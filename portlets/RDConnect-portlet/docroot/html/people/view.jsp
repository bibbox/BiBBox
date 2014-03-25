<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.service.permission.UserPermissionUtil" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portal.model.Role" %>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.UserGroupRole" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>



<portlet:defineObjects />

<% 
String currentURL = PortalUtil.getCurrentURL(request);
boolean portaleditorrole = false;
boolean biobankregistryownerrole = false;

Group controlPanelGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "Control Panel");
long controlPanelPlid = LayoutLocalServiceUtil.getDefaultPlid(controlPanelGroup.getGroupId(), true);
LiferayPortletURL adduserURL = PortletURLFactoryUtil.create(request, "125", controlPanelPlid, "RENDER_PHASE");
adduserURL.setParameter("struts_action", "/users_admin/edit_user");
adduserURL.setParameter("redirect", currentURL);
adduserURL.setParameter("p_p_state", "maximized");

	long organizationId = 0;
	com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
	String editimgpath = request.getContextPath() + "/images/edit.png";
	String editroleimgpath = request.getContextPath() + "/images/person-icon.png";
    if (currentGroup.isOrganization()) {
        // the group is an Organization
    	organizationId = currentGroup.getClassPK();
        //Get Users From Organisations
        List<User> users = UserLocalServiceUtil.getOrganizationUsers(organizationId);
        
        for(Role role : themeDisplay.getUser().getRoles()) {
        	if(role.getName().equalsIgnoreCase("PORTAL-EDITOR"))
        		portaleditorrole = true;
        	if(role.getName().equalsIgnoreCase("Administrator"))
        		portaleditorrole = true;
        }
        //Biobank, Registry Owner
        Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
        for (UserGroupRole ugr : UserGroupRoleLocalServiceUtil.getUserGroupRoles(themeDisplay.getUserId(), organization.getGroupId())) {
        	if(ugr.getRole().getName().equalsIgnoreCase("BIOBANK-REG-OWNER"))
        		biobankregistryownerrole = true;  			
        }
        
        for(User u : users) {
        	LiferayPortletURL editusersURL = null;
        	if(u.getUserId() == themeDisplay.getUserId()) {
        		editusersURL = PortletURLFactoryUtil.create(request, "2", controlPanelPlid, "RENDER_PHASE");
        		editusersURL.setParameter("redirect", currentURL);
	        	editusersURL.setParameter("p_p_state", "maximized");
	        	editusersURL.setParameter("controlPanelCategory", "my");
	        	editusersURL.setParameter("doAsGroupId", String.valueOf(themeDisplay.getUser().getGroupId()));
        	} else {
	        	editusersURL = PortletURLFactoryUtil.create(request, "125", controlPanelPlid, "RENDER_PHASE");
	        	editusersURL.setParameter("struts_action", "/users_admin/edit_user");
	        	editusersURL.setParameter("redirect", currentURL);
	        	editusersURL.setParameter("p_p_state", "maximized");
	        	editusersURL.setParameter("p_u_i_d", String.valueOf(u.getUserId()));
        	}
        	
        	%>
        	<portlet:renderURL var="edituserrollURL">
    			<portlet:param name="mvcPath" value="/html/people/edituserrolle.jsp" />
    			<portlet:param name="redirect" value="<%= currentURL %>"/>
    			<portlet:param name="rdcuserid" value="<%= String.valueOf(u.getUserId()) %>"/>
    		</portlet:renderURL>
    		
    		<%
        	
        	String imgPath = themeDisplay.getPathImage()+"/user_portrait?screenName="+u.getScreenName()+"&amp;companyId="+u.getCompanyId();
%>
			<div class="rdc-people-dispaly"><img style="float:left;" alt="" class="avatar" src="<%= imgPath %>" width="35" /> 
			<%= u.getFullName() %> 
			<% 
			if(biobankregistryownerrole || portaleditorrole) { 
				if(u.getUserId() == themeDisplay.getUserId()) { %>
					<img id="myuseredit" style="cursor:pointer;width: 10px;height: 10px;" alt="logo" src="<%= editimgpath %>" width="10px" height="10px" />
					<a href="<%= edituserrollURL.toString() %>"><img style="width: 10px;height: 10px;" alt="logo" src="<%= editroleimgpath %>" width="10px" height="10px" /></a>
					<!-- <a href="<%= themeDisplay.getURLMyAccount() %>"><img style="width: 10px;height: 10px;" alt="logo" src="<%= editimgpath %>" width="10px" height="10px" /></a> -->
			<% } else { %>
				<a href="<%= editusersURL.toString() %>"><img style="width: 10px;height: 10px;" alt="logo" src="<%= editimgpath %>" width="10px" height="10px" /></a>
				<a href="<%= edituserrollURL.toString() %>"><img style="width: 10px;height: 10px;" alt="logo" src="<%= editroleimgpath %>" width="10px" height="10px" /></a>
			<% 
				}
			} %>
			<br>
			<%= u.getJobTitle() %> <br>
			</div>

<%
        }
	}  
    
    
    if(biobankregistryownerrole || portaleditorrole) {
    %>
    	<portlet:renderURL var="adduser2URL">
			<portlet:param name="mvcPath" value="/html/people/adduser.jsp" />
			<portlet:param name="redirect" value="<%= currentURL %>"/>
		</portlet:renderURL>
		<div><a href="<%= adduser2URL %>" class="icon-user">Add User</a></div>
		
	<% } %>

<% 
LiferayPortletURL editmyusersURL = PortletURLFactoryUtil.create(request, "2", controlPanelPlid, "RENDER_PHASE");
editmyusersURL.setParameter("p_p_state", "maximized");
editmyusersURL.setParameter("controlPanelCategory", "my");
//editmyusersURL.setParameter("doAsGroupId", String.valueOf(themeDisplay.getUser().getGroupId())); 
String portletResource = ParamUtil.getString(request, "portletResource");
//String editurlaccount = themeDisplay.getURLMyAccount().toString();
%>


<aui:script use="aui-base,event,aui-dialog,aui-dialog-iframe">
		A.all('#myuseredit').on(
			'click',
			function(event) {
				Liferay.Util.selectEntity({
					dialog: {
						constrain: true,
						modal: true,
						width: 1000
					},
					id: '_<%=HtmlUtil.escapeJS(portletResource)%>_selectFolder',
					title: 'Edit my account.',
					uri: '<%= editmyusersURL.toString() %>'
				});
			}
		);
</aui:script>