<%@ include file="/html/demo2/init.jsp" %> 

<portlet:defineObjects />

<%
long optionsCouncelingGroupLeaderRoleId_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsCouncelingGroupLeaderRoleId", "0"));
long optionsPathologistRoleId_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsPathologistRoleId", "0"));
long optionsOnkologistRoleId_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsOnkologistRoleId", "0"));
long optionsPatientRoleId_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsPatientRoleId", "0"));

String portletResource = ParamUtil.getString(request, "portletResource");
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
long organizationId = 0;
Organization organization = null;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
	organizationId = currentGroup.getClassPK();
  	organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
}

if(organization != null) {
	String template = "<h4>Counceling Group Leader:</h4>§COUNCELINGGROUPLEADER§<h5>Pathologist</h5>§PATHOLOGIST§<h5>Onkologist</h5>§ONKOLOGIST§<h4>Patient</h4>§PATIENT§";
	List<User> users = UserLocalServiceUtil.getOrganizationUsers(organizationId);
	for(User user_om : users) {
		String userimgPath = themeDisplay.getPathImage()+"/user_portrait?screenName="+user_om.getScreenName()+"&amp;companyId="+user_om.getCompanyId();
		List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user_om.getUserId(), organization.getGroup().getGroupId());
		String user_container = "<table><tr><td>";
		user_container += "<img src=\"" + userimgPath + "\" height=\"50\" style=\"height:50px;\">";
		user_container += "</td><td>";
		user_container += user_om.getFullName() + "<br>" + user_om.getEmailAddress();
		user_container += "</td></tr></table>";
		
		for (UserGroupRole ugr : usergrouprolles) {
			if(ugr.getRoleId() == optionsCouncelingGroupLeaderRoleId_cfg) {
				template = template.replaceAll("§COUNCELINGGROUPLEADER§", user_container + "<br>§COUNCELINGGROUPLEADER§");
			}
			if(ugr.getRoleId() == optionsPathologistRoleId_cfg) {
				template = template.replaceAll("§PATHOLOGIST§", user_container + "<br>§PATHOLOGIST§");
			}
			if(ugr.getRoleId() == optionsOnkologistRoleId_cfg) {
				template = template.replaceAll("§ONKOLOGIST§", user_container + "<br>§ONKOLOGIST§");
			}
			if(ugr.getRoleId() == optionsPatientRoleId_cfg) {
				template = template.replaceAll("§PATIENT§", user_container + "<br>§PATIENT§");
			}
		}
	}
	template = template.replaceAll("§COUNCELINGGROUPLEADER§", "");
	template = template.replaceAll("§PATHOLOGIST§", "");
	template = template.replaceAll("§ONKOLOGIST§", "");
	template = template.replaceAll("§PATIENT§", "");
	%>
	<%= template %>
	<%
} else {
%>
	<h3>Portlet can not worke here.</h3>
<%
}
%>
