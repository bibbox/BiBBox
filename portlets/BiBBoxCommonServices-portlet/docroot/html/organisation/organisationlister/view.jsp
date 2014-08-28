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
	String additional_information = "";
	if(!optionsTypeFilter_option.equals("")) {
		if(!organization.getExpandoBridge().getAttribute("Organization Type").equals(optionsTypeFilter_option)) {
			continue;
		}
		if(optionsTypeFilter_option.equals("Collection")) {
			String type_of_sample_collectin = "";
			String sampletype = "";
			String number_of_donors = "";
			List<DDLRecordSet> ddlrecordsets = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
			for(DDLRecordSet ddlrecordset : ddlrecordsets) {
				String recordsetname = String.valueOf(ddlrecordset.getNameCurrentValue());
				if(recordsetname.equals("Collection Core")) { 
					List<DDLRecord> records = ddlrecordset.getRecords();
					for(DDLRecord record : records) {
						if(record.getFieldValue("type_of_sample_collection") != null) {
							type_of_sample_collectin = record.getFieldValue("type_of_sample_collection").toString();
							type_of_sample_collectin = type_of_sample_collectin.replaceAll("\"", "").replaceAll("\\[", "").replaceAll("\\]", "");
						}
						if(record.getFieldValue("sample_type") != null) {
							sampletype = record.getFieldValue("sample_type").toString();
						}
						if(record.getFieldValue("number_of_donors") != null) {
							number_of_donors = record.getFieldValue("number_of_donors").toString();
						}
					}
				}
			}
			additional_information = "<table style=\"border-width: 0px;\"><tr>";
			additional_information += "<tr><td>Type:</td><td>" + type_of_sample_collectin + "</td></tr>";
			additional_information += "<tr><td>Sampletype:</td><td>" + sampletype + "</td></tr>";
			additional_information += "<tr><td>Number of Doners:</td><td>" + number_of_donors + "</td></tr>";
			
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
		<aui:a href="<%= organisationlink %>"><%= organization.getName() %></aui:a><br />
		<%= additional_information %>
	</div>
	<br />
	<%
}
%>
