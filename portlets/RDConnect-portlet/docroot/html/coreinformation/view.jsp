<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.WebsiteLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.UserGroupRole" %>

<portlet:defineObjects />

<%
long organizationId = 0;
long userId2 = themeDisplay.getUserId();
java.util.Date modifieddate = null;
java.util.TreeMap<java.util.Date, String> sortetdata = new java.util.TreeMap<java.util.Date, String>(Collections.reverseOrder());
List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), 0);
for(Organization organization : organizations) {
	String country = "";
	modifieddate = organization.getModifiedDate();
	organizationId = organization.getOrganizationId();
	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+organization.getLogoId();
	String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
	if(organization.getName().equalsIgnoreCase("National Biobank of Test")) {
		continue;
	}
	if(organization.getName().equalsIgnoreCase("BBMUSK")) {
		continue;
	}
	if(organization.getName().equalsIgnoreCase("BBMRI.at")) {
		continue;
	}
	if(organization.getName().equalsIgnoreCase("BBMRI.at Intranet")) {
		continue;
	}
	if(organization.getName().equalsIgnoreCase("Medical Univeristy of Shi'Kahr")) {
		continue;
	}
	if(organization.getName().equalsIgnoreCase("National Biobank of Vulcan") && !permissionChecker.isOmniadmin()) {
		continue;
	}
	
	
	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
	
	
		
	  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
	  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
	  		
	  		if(rdc_rsname.equals("core")) {  		
	  			List<DDLRecord> records = rdc_rs.getRecords();
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
			  				if(themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
			  					orgPath = orgPath + "/at_home";
			  				} else {
			  					orgPath = orgPath + "/bb_home";
			  				}
			  			} else if(type.equalsIgnoreCase("[reg]") || type.equalsIgnoreCase("[\"reg\"]")) {
			  				if(organization.getLogoId() == 0) {
			  					imgPath = request.getContextPath() + "/images/Registry.png";
			  				}
			  				if(themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
			  					orgPath = orgPath + "/at_home";
			  				} else {
			  					orgPath = orgPath + "/home";
			  				}
			  			} else {
			  				if(organization.getLogoId() == 0) {
			  					imgPath = request.getContextPath() + "/images/RegistryBiobank.png";
			  				}
			  				if(themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
			  					orgPath = orgPath + "/at_home";
			  				} else {
			  					orgPath = orgPath + "/regbb_home";
			  				}
			  			}
		  			}
	  			}
	  		} else {
	  			List<DDLRecord> records = rdc_rs.getRecords();
	  			for(DDLRecord record : records) {
	  				if (modifieddate.before(record.getModifiedDate())) {
	  					modifieddate = record.getModifiedDate();
	  				}
	  			}
	  		}
		}
	  	String tableandcontent = "";
	  	
	  	tableandcontent += "<table class=\"rdc_coreinformation_organisation-table-images\">";
	  	tableandcontent += "<tr>";
	  	tableandcontent += "<td rowspan=\"4\" width=\"80px\"><a href=\"" + orgPath + "\"><img alt=\"logo\" src=\"" + imgPath + "\" width=\"60px\" /></a></td>";
	  	tableandcontent += "<td><a href=\"" + orgPath + "\">" + organization.getName() + "</a></td>";
	  	tableandcontent += "</tr>";
	  	// Deseases -------------------------------------------------------------
	  	/*tableandcontent += "<tr>";
	  	tableandcontent += "<div id=\"myToggler\">";
	  	
	  	tableandcontent += "<td class=\"header toggler-header-collapsed\">Diseases</td>";
	  	tableandcontent += "<div class=\"content toggler-content-collapsed\">";

		for(DDLRecordSet rdc_rs : rdc_recordlist) {
			String rdc_rsname = rdc_rs.getNameCurrentValue();
			if(rdc_rsname.equals("Disease Matrix")) { 
				List<DDLRecord> records = rdc_rs.getRecords();
				for(DDLRecord record : records) {
					if(record.getFieldValue("Name") != null) {
						String diseasname = record.getFieldValue("Name").toString();
						if(diseasname.length() != 0) {
							tableandcontent += "diseasname, ";
						}
					}
				}
			}
		}
		tableandcontent += "</div></div></tr>";
		*/
		// Deseases -------------------------------------------------------------
		tableandcontent += "<tr><td>Contact:";
		User maincontact = null;
		List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
		for(User usertmp : userlist) {
			List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(usertmp.getUserId(), organization.getGroup().getGroupId());
			for (UserGroupRole ugr : usergrouprolles) {
				if(ugr.getRole().getName().equalsIgnoreCase("BiobanK-REG-MAINCONTACT")
						|| ugr.getRole().getName().equalsIgnoreCase("Biobank, Registry Main Contact")
						|| ugr.getRole().getName().equalsIgnoreCase("BiobanK-REG-MAINCONTACT")) {
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
		
		if(themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
			if(country.equalsIgnoreCase("Austria")) {
				if(sortetdata.containsKey(modifieddate)) {
					String tmp = sortetdata.get(modifieddate);
					sortetdata.put(modifieddate, tmp + tableandcontent);
				} else {
					sortetdata.put(modifieddate, tableandcontent);
				}
			}
		} else {
			if(sortetdata.containsKey(modifieddate)) {
				String tmp = sortetdata.get(modifieddate);
				sortetdata.put(modifieddate, tmp + tableandcontent);
			} else {
				sortetdata.put(modifieddate, tableandcontent);
			}
		}
	}

for(java.util.Date date : sortetdata.keySet()) {
	%><%= sortetdata.get(date) %><%	
}
%>
<br />