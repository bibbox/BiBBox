<!-- 
BiBBoxCommonServices
user/invitation

 -->
<%@ include file="/html/user/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<style tyle="text/css">
<!--
@media screen
{
	p.bodyText {font-family:verdana, arial, sans-serif;}
}
@media print
{
	p.bodyText {font-family:georgia, times, serif;}
	body { background: white; }
}
@media screen, print
{
	p.bodyText {font-size:10pt}
}
-->
</style>

<%
	long biobankId = ParamUtil.getLong(request, "biobankId");
	long optionsMainContactRole_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", ""));
	
	String headerimage = request.getContextPath() + "/images/BiobankPrintImage.png";
	Organization organization = OrganizationLocalServiceUtil.getOrganization(biobankId);
	
	User maincontact = null;
	List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(biobankId);
	for(User user_mc : userlist) {
		List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user_mc.getUserId(), organization.getGroup().getGroupId());
		for (UserGroupRole ugr : usergrouprolles) {
			if(ugr.getRoleId() == optionsMainContactRole_cfg) {
				maincontact =  user_mc;
			}
		}
	}
	
	// set Variables
	String acronym = "";
	String year_of_esteblishment = "";
	String source_of_funding = "";
	String hoste_institute = "";
	String type_of_host_institution = "";
	String target_population = "";
	String listed_networks = "";
	String listed_networks2 = "";
	// retreve Variables
	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
  		
  		if(rdc_rsname.equals("bb_core")) {
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				if(record.getFieldValue("acronym") != null) {
  					acronym = record.getFieldValue("acronym").toString();
  				}
  				if(record.getFieldValue("year_of_establishment") != null) {
  					year_of_esteblishment = record.getFieldValue("year_of_establishment").toString();
  				}
  				if(record.getFieldValue("Text5085") != null) {
  					source_of_funding = record.getFieldValue("Text5085").toString();
  				}
  				if(record.getFieldValue("Hoste_institute") != null) {
  					hoste_institute = record.getFieldValue("Hoste_institute").toString();
  				}
  				if(record.getFieldValue("Host_institution_is_a") != null) {
  					type_of_host_institution = record.getFieldValue("Host_institution_is_a").toString();
  				}
  				if(record.getFieldValue("countryCode") != null) {
  					target_population = record.getFieldValue("countryCode").toString();
  				}
  				if(record.getFieldValue("The_registry_biobanks_is_listed_in_other_inventories_networks") != null) {
  					listed_networks = record.getFieldValue("The_registry_biobanks_is_listed_in_other_inventories_networks").toString();
  				}
  				if(record.getFieldValue("Additional_networks_inventories") != null) {
  					listed_networks2 = record.getFieldValue("Additional_networks_inventories").toString();
  				}
  			}
  		}
  	}
  	if(!listed_networks2.equalsIgnoreCase("")) {
  		listed_networks += "<br>" + listed_networks2;
  	}

%>
<!-- Header -->
<div>
<h4>Rare Disease Biobank Application Form</h2>
<img style="position: absolute;right: 10px;top: 10px;width:266px;height=42px;" alt="logo" src="<%= headerimage %>" width="266px" height="42px" />
</div>
<!-- 1 OVERVIEW -->
<div>
	<h5>1 OVERVIEW</h3>
	<hr>
	<h6>1.1 General information</h6>
	<table>
		<tr><td>Biobank Name</td><td><%= organization.getName() %></td></tr>
		<tr><td>Street address</td><td><%= organization.getAddress().getStreet1() %><br><%= organization.getAddress().getStreet2() %><br><%= organization.getAddress().getStreet3() %></td></tr>
		<tr><td>Zip code, City</td><td><%= organization.getAddress().getZip() %>, <%= organization.getAddress().getCity() %></td></tr>
		<tr><td>Country</td><td><%= organization.getAddress().getCountry().getNameCurrentValue() %></td></tr>
		<tr><td>Acronym</td><td><%= acronym %></td></tr>
		<tr><td>Year of establishment</td><td><%= year_of_esteblishment %></td></tr>
		<tr><td>Website</td><td>
		<% 
			List<Website> websites = WebsiteLocalServiceUtil.getWebsites(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId());
			boolean first = true; 
			for(Website website : websites) {
				if(!first) {
					%><br /><%
				}
				%><aui:a href='<%= website.getUrl() %>' target="blank"><%= website.getUrl() %></aui:a><%
				first = false;
			}
			%>
		</td></tr>
	</table>
	<h6>1.2 Main Contact (Head of Biobank)</h6>
	<table border="1">
		<tr><td>First Name</td><td><%= maincontact.getFirstName() %></td><td>Middle Name</td><td><%= maincontact.getMiddleName() %></td></tr>
		<tr><td>Last Name</td><td><%= maincontact.getLastName() %></td><td>Title</td><td><%= "" %></td></tr>
		<tr><td>E-Mail</td><td colspan="3"><%= maincontact.getEmailAddress() %></td></tr>
		<%
		String gender = "";
		if(maincontact.getFemale()) {
			gender = "Female";
		}
		if(maincontact.getMale()) {
			gender = "Male";
		}
		%>
		<tr><td>Gender</td><td colspan="3"><%= gender %></td></tr>
		<%
		String role = "";
		if(maincontact.getExpandoBridge() != null) {
			if(maincontact.getExpandoBridge().getAttribute("Role within the organisation") != null) {
				String user_roles_string = maincontact.getExpandoBridge().getAttribute("Role within the organisation").toString();
				String[] user_roles = user_roles_string.split(";");
				for(String user_role : user_roles) {
					String[] our = user_role.split("_");
					if(our.length == 0 || our[0].length() == 0) {
						continue;
					}
					long orgid = Long.parseLong(our[0]);
					if(orgid == biobankId) {
						if(our.length == 1) {
							role = "";
						} else {
							role = our[1];
						}
					}
				}
			}
		}
		%>
		<tr><td>Position</td><td colspan="3"><%= role %></td></tr>
		<tr><td colspan="4"></td></tr>
		<tr><td>Source of funding</td><%= source_of_funding %><td colspan="3"></td></tr>
		<tr><td>Host institute</td><%= hoste_institute %><td colspan="3"></td></tr>
		<tr><td>Type of host institute</td><%= type_of_host_institution %><td colspan="3"></td></tr>
		<tr><td>How many rare diseases are in your biobank?</td><td colspan="3"></td></tr>
		<tr><td>Target population</td><%= target_population %><td colspan="3"></td></tr>
		<tr><td>Your biobank is listed in other inventories/networks (please select all that apply):</td><%= listed_networks %><td colspan="3"></td></tr>
	</table>
	<h5>2 COLLECTIONS OF DISEASES</h3>
	<hr>
</div>