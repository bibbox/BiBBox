<style>
<!--
.aui h3 {
    font-size: 20.5px;
}
-->
</style>
<%
long organizationId = 0;
java.util.Date modifieddate = null;
java.util.TreeMap<java.util.Date, String> sortetdata = new java.util.TreeMap<java.util.Date, String>(Collections.reverseOrder());
List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), parentid);
for(Organization organization : organizations) {
	
	// remove all from the ignore list
	if(ignore.contains(organization.getName())) {
		continue;
	}
	String country = "";
	modifieddate = organization.getModifiedDate();
	organizationId = organization.getOrganizationId();
	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+organization.getLogoId();
	String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
	// Core Functions
	String organizationtype = organization.getExpandoBridge().getAttribute("Organization Type").toString();
	if(organizationtype.equalsIgnoreCase("Biobank")) {
		if(organization.getLogoId() == 0) {
			imgPath = request.getContextPath() + "/images/Biobank.png";
		}
		orgPath = orgPath + "/bb_home";	
	} else {
		if(organization.getLogoId() == 0) {
			imgPath = request.getContextPath() + "/images/Registry.png";
		}
		orgPath = orgPath + "/reg_home";
	}
	// Modification Date
	List<DDLRecordSet> recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
	for(DDLRecordSet recordset : recordlist) {
		String recordsetname = String.valueOf(recordset.getNameCurrentValue());
		List<DDLRecord> records = recordset.getRecords();
			for(DDLRecord record : records) {
  			if (modifieddate.before(record.getModifiedDate())) {
  				modifieddate = record.getModifiedDate();
	  		}
	  	}
	}
	// Create cards
	String tableandcontent = "";
	 	
 	tableandcontent += "<table class=\"rdc_coreinformation_organisation-table-images\">";
  	tableandcontent += "<tr>";
  	tableandcontent += "<td rowspan=\"4\" width=\"80px\"><a href=\"" + orgPath + "\"><img alt=\"logo\" src=\"" + imgPath + "\" width=\"60px\" /></a></td>";
  	tableandcontent += "<td><a href=\"" + orgPath + "\">" + organization.getName() + "</a>";
  	if(permissionChecker.hasPermission(groupId, name, primKey, actionId_delete_organization)) {
  		tableandcontent += "<span style=\"float:right;\"><a id=\"deleteOrganization\" class=\"icon-remove\" style=\"color: red;\"";
  		tableandcontent += "organisationid=\"" + organization.getOrganizationId() + "\" organisationname=\"" + organization.getName() + "\"></a></span>";
  	}
  	tableandcontent += "</td>";
  	tableandcontent += "</tr>";
  	tableandcontent += "<tr><td>Contact:";
	User maincontact = null;
	List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
	for(User usertmp : userlist) {
		List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(usertmp.getUserId(), organization.getGroup().getGroupId());
		for (UserGroupRole ugr : usergrouprolles) {
			if(ugr.getRoleId() == optionsMainContactRole_option) {
				maincontact =  usertmp;
			}
		}
	}
	if(maincontact != null) {
		tableandcontent += "<a href=\"mailto:" + maincontact.getEmailAddress() + "\">" + maincontact.getFullName() + "</a>";
	}
	tableandcontent += "</td></tr>";
	tableandcontent += "<tr><td class=\"rdc_coreinformation_organisation-table-images-bottomborder\">";
	for(com.liferay.portal.model.Website website : WebsiteLocalServiceUtil.getWebsites(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId())) {
		tableandcontent += "<a href=\"" + website.getUrl() + "\">" + website.getUrl() + "</a>";
	}
	tableandcontent += "</td></tr>";
	tableandcontent += "</table><br>";
	
	// Add Organization to sorting tree
	if(sortetdata.containsKey(modifieddate)) {
		String tmp = sortetdata.get(modifieddate);
		sortetdata.put(modifieddate, tmp + tableandcontent);
	} else {
		sortetdata.put(modifieddate, tableandcontent);
	}
}

java.util.Date today = new java.util.Date();

//1 day, 1 week, 2 weeks, 1 month
boolean day = true;
boolean week1 = true;
boolean week2 = true;
boolean month1 = true;
boolean monthlonger = true;

for(java.util.Date date : sortetdata.keySet()) {
	if(monthlonger && ((today.getTime() - date.getTime()) / 86400000) > 32) {
		day = false;
		week1 = false;
		week2 = false;
		month1 = false;
		monthlonger = false;
		%><h3>Last update more than 2 months</h3><%	
	}
	if(day && ((today.getTime() - date.getTime()) / 86400000) <= 1) {
		day = false;
		%><h3>Updated Today</h3><%	
	}
	if(week1 && ((today.getTime() - date.getTime()) / 86400000) <= 7 && ((today.getTime() - date.getTime()) / 86400000) > 1) {
		day = false;
		week1 = false;
		%><h3>Updated this week</h3><%	
	}
	if(week2 && ((today.getTime() - date.getTime()) / 86400000) <= 14 && ((today.getTime() - date.getTime()) / 86400000) > 7) {
		day = false;
		week1 = false;
		week2 = false;
		%><h3>Updated last 2 weeks</h3><%	
	}
	if(month1 && ((today.getTime() - date.getTime()) / 86400000) <= 30 && ((today.getTime() - date.getTime()) / 86400000) > 14) {
		day = false;
		week1 = false;
		week2 = false;
		month1 = false;
		%><h3>Updated this month</h3><%	
	}
	
	%><%= sortetdata.get(date) %><%	
}
%>
<br />