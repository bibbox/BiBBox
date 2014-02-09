<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.service.permission.UserPermissionUtil" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>




<portlet:defineObjects />

<% 
String currentURL = PortalUtil.getCurrentURL(request);

	long organizationId = 0;
	com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
    if (currentGroup.isOrganization()) {
        // the group is an Organization
    	organizationId = currentGroup.getClassPK();
        //Get Users From Organisations
        List<User> users = UserLocalServiceUtil.getOrganizationUsers(organizationId);
        for(User u : users) {
        	String imgPath = themeDisplay.getPathImage()+"/user_portrait?screenName="+u.getScreenName()+"&amp;companyId="+u.getCompanyId();
%>
			<div class="rdc-people-dispaly"><img style="float:left;" alt="" class="avatar" src="<%= imgPath %>" width="35" /> 
			<%= u.getFullName() %> <br>
			<%= u.getJobTitle() %> <br>
			</div>

<%
        }
	}
    
    Group controlPanelGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "Control Panel");
    long controlPanelPlid = LayoutLocalServiceUtil.getDefaultPlid(controlPanelGroup.getGroupId(), true);
    LiferayPortletURL editorganizationURL = PortletURLFactoryUtil.create(request, "125", controlPanelPlid, "RENDER_PHASE");
    editorganizationURL.setParameter("struts_action", "/users_admin/edit_user");
    editorganizationURL.setParameter("redirect", currentURL);
    editorganizationURL.setParameter("p_p_state", "maximized");
    
    %>
	    <portlet:renderURL var="addUserURL">
			<portlet:param name="struts_action" value="/users_admin/edit_user" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</portlet:renderURL>

		<aui:nav-item href="<%= editorganizationURL.toString() %>" iconCssClass="icon-user" label="Add User" />
	<%  %>


