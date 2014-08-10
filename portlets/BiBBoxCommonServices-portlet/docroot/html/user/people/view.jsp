<!-- 
BiBBoxCommonServices
user/people

 -->
<%@ include file="/html/user/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
// Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_manage_maincontact = "MANAGE_MAINCONTACT";
String actionId_add_user = "ADD_USER";
String actionId_edit_user = "EDIT_USER";
%>

<!-- Main Contact  -->
<%
long optionsMainContactRole_option = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", "0"));
boolean optionsDisplayMaincontact_option = GetterUtil.getBoolean(portletPreferences.getValue("optionsDisplayMaincontact", "false"));
String redirect = ParamUtil.getString(request, "redirect");

String currentURL = PortalUtil.getCurrentURL(request);
String editimgpath = request.getContextPath() + "/images/edit.png";
	
long organizationId = 0;
Organization organization = null;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	organizationId = currentGroup.getClassPK();
  	organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
}

if(optionsDisplayMaincontact_option) {
	User maincontact = null;
	long maincontactid = 0;
	List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organizationId);
	for(User user_mc : userlist) {
		List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user_mc.getUserId(), organization.getGroup().getGroupId());
		for (UserGroupRole ugr : usergrouprolles) {
			if(ugr.getRoleId() == optionsMainContactRole_option) {
				maincontact =  user_mc;
				maincontactid = user_mc.getUserId();
			}
		}
	}
	%>
	
	<portlet:renderURL var="editmaincontactURL">
		<portlet:param name="mvcPath" value="/html/user/people/maincontact.jsp" />
		<portlet:param name="redirect" value="<%= currentURL %>"/>
		<portlet:param name="maincontactid" value="<%= String.valueOf(maincontactid) %>"/>
	</portlet:renderURL>
	
	
	<div style="height:100%;width:100%;">
		<span class="rdc_idcard_idcaibody-headlines"  style="height:100%;width:100%;">Main contact
			<c:choose>
				<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_manage_maincontact) %>">
					&nbsp;&nbsp;<aui:a href="<%= editmaincontactURL.toString() %>"><img alt="logo" src="<%= editimgpath %>" width="10px" height="10px" /></aui:a>
				</c:when>
			</c:choose>
		</span>
		<% 
		if(maincontact != null) {
			String imgPath = themeDisplay.getPathImage()+"/user_portrait?screenName="+maincontact.getScreenName()+"&amp;companyId="+maincontact.getCompanyId();
			%>
			<br>
			<div class="rdc_idcard_idcaibody-avatar"><img alt="" src="<%= imgPath %>" /></div>
			<span class="rdc_idcard_idcaibody-contactname"><%= maincontact.getFullName() %></span><br>
			<span class="rdc_idcard_idcaibody-contactemail"><aui:a href='<%= "mailto:" + maincontact.getEmailAddress() %>'><%= maincontact.getEmailAddress() %></aui:a></span>
			<%
		}
		%>
	</div>
	<br />
	<hr />
	<%
}
%>
<!-- Personal List -->
<div style="height:100%;width:100%;">
	<span class="rdc_idcard_idcaibody-headlines"  style="height:100%;width:100%;">Personal
	</span>
</div>
<% 
//Get Users From Organisations
List<User> users = UserLocalServiceUtil.getOrganizationUsers(organizationId);
for(User user_om : users) {
	String role = "";
	String imgPath = themeDisplay.getPathImage()+"/user_portrait?screenName="+user_om.getScreenName()+"&amp;companyId="+user_om.getCompanyId();
	String[] user_roles = user_om.getExpandoBridge().getAttribute("Role within the organisation").toString().split(";");
	for(String user_role : user_roles) {
		String[] our = user_role.split("_");
		if(our.length == 0 || our[0].length() == 0) {
			continue;
		}
		long orgid = Long.parseLong(our[0]);
		if(orgid == organizationId) {
			role = our[1];
		}
	}
	%>
	<div class="rdc-people-dispaly"  style="height:100%;width:100%;">
		<img style="float:left;" alt="" class="avatar" src="<%= imgPath %>" width="35" /> 
		<%= user_om.getFullName() %>
		<br>
		<%= role %> 
		<br>
	</div>
	<%
}
%>


