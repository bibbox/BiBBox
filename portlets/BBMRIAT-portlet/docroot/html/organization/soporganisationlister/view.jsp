<%@ include file="/html/organization/init.jsp" %> 

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
long organizationId = 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	long recordid = 0;
  	organizationId = currentGroup.getClassPK();
  	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
	Organization parent_organization = organization;
	boolean parentfound = false;
	if(optionsListOrganizationFromMainOrganization_option == 2) {
	  	while(!parentfound) {
	  		if(parent_organization.getParentOrganizationId() == 0) {
	  			parentfound = true;
	  		} else {
	  			parent_organization = parent_organization.getParentOrganization();
	  		}
	  	}
	}
}
%>