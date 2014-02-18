<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.service.permission.UserPermissionUtil" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portal.model.Role" %>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.UserGroupRole" %>




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

// Link to all users
/*editusersURL.setParameter("struts_action", "/users_admin/view");
editusersURL.setParameter("usersListView", "flat-users");
editusersURL.setParameter("toolbarItem", "view-all-users");
editusersURL.setParameter("controlPanelCategory", "users");
editusersURL.setParameter("saveUsersListView", "true");
editusersURL.setParameter("redirect", currentURL);
editusersURL.setParameter("p_p_state", "maximized");
editusersURL.setParameter("struts_action", "/users_admin/view");
editusersURL.setParameter("organizationId", String.valueOf(organizationId));
editusersURL.setParameter("usersListView", "tree");
editusersURL.setParameter("redirect", currentURL);
editusersURL.setParameter("p_p_state", "maximized");*/

	long organizationId = 0;
	com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
	String editimgpath = request.getContextPath() + "/images/edit.png";
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
        	
        	LiferayPortletURL editusersURL = PortletURLFactoryUtil.create(request, "125", controlPanelPlid, "RENDER_PHASE");
        	editusersURL.setParameter("struts_action", "/users_admin/edit_user");
        	editusersURL.setParameter("redirect", currentURL);
        	editusersURL.setParameter("p_p_state", "maximized");
        	editusersURL.setParameter("p_u_i_d", String.valueOf(u.getUserId()));
        	
        	String imgPath = themeDisplay.getPathImage()+"/user_portrait?screenName="+u.getScreenName()+"&amp;companyId="+u.getCompanyId();
%>
			<div class="rdc-people-dispaly"><img style="float:left;" alt="" class="avatar" src="<%= imgPath %>" width="35" /> 
			<%= u.getFullName() %> 
			<% if(biobankregistryownerrole || portaleditorrole) { %>
			<a href="<%= editusersURL.toString() %>"><img style="width: 10px;height: 10px;" alt="logo" src="<%= editimgpath %>" width="10px" height="10px" /></a>
			<% } %>
			<br>
			<%= u.getJobTitle() %> <br>
			</div>

<%
        }
	}   
    
    if(biobankregistryownerrole || portaleditorrole) {
    %>
		<div><a href="<%= adduserURL.toString() %>" class="icon-user">Add User</a></div>
		
	<% } %>


