<%@ include file="/html/organisation/init.jsp" %> 

<portlet:defineObjects />

<%
long optionsListOrganizationFromMainOrganization_option = GetterUtil.getLong(portletPreferences.getValue("optionsListOrganizationFromMainOrganization", "0"));
String optionsTypeFilter_option = GetterUtil.getString(portletPreferences.getValue("optionsTypeFilter", ""));
String optionsIgnoreOrganisations_option = GetterUtil.getString(portletPreferences.getValue("optionsIgnoreOrganisations", ""));
List<String> ignore = new ArrayList<String>();
for(String ignorenames : optionsIgnoreOrganisations_option.split(";")) {
	ignore.add(ignorenames);
}
long parentid = optionsListOrganizationFromMainOrganization_option;
if(optionsListOrganizationFromMainOrganization_option == 1) {
	com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
	if (currentGroup.isOrganization()) {
		parentid = currentGroup.getClassPK();
	}
}


List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), parentid);
for(Organization organization : organizations) {
	if(ignore.contains(organization.getName())) {
		continue;
	}
	if(!optionsTypeFilter_option.equals("")) {
		if(!organization.getExpandoBridge().getAttribute("Organization Type").equals(optionsTypeFilter_option)) {
			continue;
		}
	}
	%>
	<%= organization.getName() %><br />
	<%
}
%>
