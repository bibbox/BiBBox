<%
List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), parentid);
for(Organization organization : organizations) {
	if(ignore.contains(organization.getName())) {
		continue;
	}
	String additional_information = "";
	if(!optionsTypeFilter_option.equals("")) {
		if(!organization.getExpandoBridge().getAttribute("Organization Type").equals(optionsTypeFilter_option)) {
			continue;
		}
		if(optionsTypeFilter_option.equals("Collection")) {
			additional_information = "<table style=\"border-width: 0px;\"><tr>";
			
			List<Organization> suborganizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), organization.getOrganizationId());
			for(Organization suborganization : suborganizations) {
				String organisationlink = themeDisplay.getURLPortal() + "/web" + suborganization.getGroup().getFriendlyURL();
				additional_information += "<tr><td colspan=\"2\"><a href=\"" + organisationlink + "\">&nbsp&nbsp&nbsp-&nbsp&nbsp" + suborganization.getName() + "</a></td></tr>";
			}
			additional_information += "</table>";
			
		}
	}
	String organisationlink = themeDisplay.getURLPortal() + "/web" + organization.getGroup().getFriendlyURL();
	%>
	<div style="border-width: 1px;border-style: solid;border-color: #8bbf39;border-radius: 5px;padding:5px;margin:px;">
		<aui:a href="<%= organisationlink %>"><%= organization.getName() %></aui:a>
		<br />
		<%= additional_information %>
	</div>
	<br />
	<%
}
%>
