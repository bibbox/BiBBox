
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
	List<DDLRecordSet> recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
	for(DDLRecordSet recordset : recordlist) {
		String recordsetname = String.valueOf(recordset.getNameCurrentValue());
		// Core
		if(recordsetname.equals("core")) {
			List<DDLRecord> records = recordset.getRecords();
  			for(DDLRecord record : records) {
  				if (modifieddate.before(record.getModifiedDate())) {
  					modifieddate = record.getModifiedDate();
  				}
  				if(record.getFieldValue("countryCode") != null) {
  					country = record.getFieldValue("countryCode").toString();
  				}
	  			if(record.getFieldValue("Radio2493") != null) {
		  			String type = record.getFieldValue("Radio2493").toString();
		  			if(type.equalsIgnoreCase("[bb]") || type.equalsIgnoreCase("[\"bb\"]")) {
		  				if(organization.getLogoId() == 0) {
		  					imgPath = request.getContextPath() + "/images/Biobank.png";
		  				}
		  				orgPath = orgPath + "/bb_home";	
		  			} else if(type.equalsIgnoreCase("[reg]") || type.equalsIgnoreCase("[\"reg\"]")) {
		  				if(organization.getLogoId() == 0) {
		  					imgPath = request.getContextPath() + "/images/Registry.png";
		  				}
		  				orgPath = orgPath + "/home";
		  			} else {
		  				if(organization.getLogoId() == 0) {
		  					imgPath = request.getContextPath() + "/images/Registry.png";
		  				}
		  				orgPath = orgPath + "/home";
		  			}
	  			}
  			}
		} else {
	  		List<DDLRecord> records = recordset.getRecords();
				for(DDLRecord record : records) {
  				if (modifieddate.before(record.getModifiedDate())) {
  					modifieddate = record.getModifiedDate();
	  			}
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

for(java.util.Date date : sortetdata.keySet()) {
	%><%= sortetdata.get(date) %><%	
}
%>
<br />