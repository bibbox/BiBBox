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
	String howmanyrarediseases = "";
	// 2
	String percentagerdsamples = "";
	// 3
	String biobankcollects = "";
	String biobankcollectsadditional = "";
	String biobankprepares = "";
	String biobankpreparesadditional = "";
	// 4
	String collectionsorigin = "";
	String collectionsoriginaddition = "";
	String collectionsuse = "";
	String collectionsuseaddition = "";
	String associateddata = "";
	String associateddataaddition = "";
	String associateddataimg = "";
	String associateddataimgaddition = "";
	String scientificpublications = "";
	// 5
	String qualityassurancesystem = "";
	String qualityassurancesystemspecify = "";
	String standardsforsampleacquisition = "";
	String ensuresampleintegrity = "";
	String dedicatedsop = "";
	// 6
	String biobankcataloguecollection = "";
	String publishedonwebsite = "";
	String biobankmaintainanupdateddatabase = "";
	String samplemanagementsystemcontain = "";
	String softwarebiobank = "";
	String databaseexportable = "";
	// 7
	String restrictionaccesssamples = "";
	String restrictionaccesssamplesspecify = "";
	String samplesdistributeyear = "";
	String materialtransferagreement = "";
	String costrecoverysystem = "";
	String returnoftheresults = "";
	// 8
	String ethicalcommitteeapproval = "";
	String startingdateoftheethicalcommitteeapproval = "";
	String presumeddateforobtainingtheapproval = "";
	String samplescollectedwithaninformedconsent = "";
	String informedconsentoptionforwithdraw = "";
	String typeofinformedconsent = "";
	String internationalexchangeofsamplesconsidered = "";
	String somelimitationsregardingyourlocalregulation = "";
	// 9
	String entiresamplecollectionavailable = "";
	String entiresamplecollectionavailablenotspecify = "";
	String linesexplainingwhyjoin = "";
	String otherremarks = "";
	// 10
	String willingtoaccepttheterms = "";
	String agreetopublishyouravailablecollections = "";
	String agreetodistributesamples = "";
	String biobankwillretainownership = "";
	String remainconfidentialduringtheentireassessment = "";
	
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
  					type_of_host_institution = record.getFieldValue("Host_institution_is_a").toString().replaceAll("\"\\]|\\[\"", "").replaceAll("\",\"", ",<br>");
  				}
  				if(record.getFieldValue("countryCode") != null) {
  					target_population = record.getFieldValue("countryCode").toString();
  				}
  				if(record.getFieldValue("The_registry_biobanks_is_listed_in_other_inventories_networks") != null) {
  					listed_networks = record.getFieldValue("The_registry_biobanks_is_listed_in_other_inventories_networks").toString().replaceAll("\"\\]|\\[\"", "").replaceAll("\",\"", ",<br>");
  				}
  				if(record.getFieldValue("Additional_networks_inventories") != null) {
  					listed_networks2 = record.getFieldValue("Additional_networks_inventories").toString();
  				}
  				if(record.getFieldValue("How_many_RD_are_in_the_registry_biobank") != null) {
  					howmanyrarediseases = record.getFieldValue("How_many_RD_are_in_the_registry_biobank").toString().replaceAll("\"\\]|\\[\"", "").replaceAll("\",\"", ",<br>");
  				}
  				if(record.getFieldValue("Percentage_of_rare_diseases_in_your_registry_biobank") != null) {
  					percentagerdsamples = record.getFieldValue("Percentage_of_rare_diseases_in_your_registry_biobank").toString();
  				}
  				if(record.getFieldValue("Biomaterial_Available") != null) {
  					biobankcollects = record.getFieldValue("Biomaterial_Available").toString().replaceAll("\"\\]|\\[\"", "").replaceAll("\",\"", ",<br>");
  				}
  				if(record.getFieldValue("Additional_Biomaterial_available") != null) {
  					biobankcollectsadditional = record.getFieldValue("Additional_Biomaterial_available").toString();
  				}
  				if(record.getFieldValue("Biomaterial_prepared") != null) {
  					biobankprepares = record.getFieldValue("Biomaterial_prepared").toString().replaceAll("\"\\]|\\[\"", "").replaceAll("\",\"", ",<br>");
  				}
  				if(record.getFieldValue("Additional_Biomaterial_prepared") != null) {
  					biobankpreparesadditional = record.getFieldValue("Additional_Biomaterial_prepared").toString();
  				}
  				if(record.getFieldValue("Origin_of_collection") != null) {
  					collectionsorigin = record.getFieldValue("Origin_of_collection").toString().replaceAll("\"\\]|\\[\"", "").replaceAll("\",\"", ",<br>");
  				}
  				if(record.getFieldValue("Additional_Origin_of_collection") != null) {
  					collectionsoriginaddition = record.getFieldValue("Additional_Origin_of_collection").toString();
  				}
  				if(record.getFieldValue("Use_of_collection") != null) {
  					collectionsuse = record.getFieldValue("Use_of_collection").toString().replaceAll("\"\\]|\\[\"", "").replaceAll("\",\"", ",<br>");
  				}
  				if(record.getFieldValue("Additional_Use_of_collection") != null) {
  					collectionsuseaddition = record.getFieldValue("Additional_Use_of_collection").toString();
  				}
  				if(record.getFieldValue("Associated_data_available") != null) {
  					associateddata = record.getFieldValue("Associated_data_available").toString().replaceAll("\"\\]|\\[\"", "").replaceAll("\",\"", ",<br>");
  				}
  				if(record.getFieldValue("Additional_Associated_data_available") != null) {
  					associateddataaddition = record.getFieldValue("Additional_Associated_data_available").toString();
  				}
  				if(record.getFieldValue("Imaging_available") != null) {
  					associateddataimg = record.getFieldValue("Imaging_available").toString().replaceAll("\"\\]|\\[\"", "").replaceAll("\",\"", ",<br>&nbsp;&nbsp;&nbsp;");
  				}
  				if(record.getFieldValue("Additional_Imaging_available") != null) {
  					associateddataimgaddition = record.getFieldValue("Additional_Imaging_available").toString();
  				}
  			}
  		}
  		if(rdc_rsname.equals("Scientific publications")) {
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				if(record.getFieldValue("Author") != null) {
  					scientificpublications += record.getFieldValue("Author").toString() + ": ";
  				}
  				if(record.getFieldValue("Title") != null) {
  					scientificpublications += "<b>" + record.getFieldValue("Title").toString() + ".</b>";
  				}
  				if(record.getFieldValue("Journal") != null) {
  					scientificpublications += "In: " + record.getFieldValue("Journal").toString() + "";
  				}
  				if(record.getFieldValue("Year") != null) {
  					scientificpublications += " (" + record.getFieldValue("Year").toString() + ");";
  				}
  				scientificpublications += "<br>";
  			}
  		}
  		if(rdc_rsname.equals("q_biobank_quality")) {
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				if(record.getFieldValue("Accreditation_certification_program") != null) {
  					qualityassurancesystem += record.getFieldValue("Accreditation_certification_program").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("If_yes__specify__ISO_standards___") != null) {
  					qualityassurancesystemspecify += record.getFieldValue("If_yes__specify__ISO_standards___").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("Standardized_case-inclusion_and-exclusion_criteria") != null) {
  					standardsforsampleacquisition += record.getFieldValue("Standardized_case-inclusion_and-exclusion_criteria").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("Molecular_test_performed_to_ensure_sample_integrity") != null) {
  					ensuresampleintegrity += record.getFieldValue("Molecular_test_performed_to_ensure_sample_integrity").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("Standardized_Operating_Procedures__SOPs__available_for_data_management") != null) {
  					dedicatedsop += record.getFieldValue("Standardized_Operating_Procedures__SOPs__available_for_data_management").toString().replaceAll("\"\\]|\\[\"", "").replaceAll("\",\"", ",<br>");
  				}
  				if(record.getFieldValue("Catalogue_of_collections") != null) {
  					biobankcataloguecollection += record.getFieldValue("Catalogue_of_collections").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("If_yes__online_available_please_specify_URL_") != null) {
  					publishedonwebsite += record.getFieldValue("If_yes__online_available_please_specify_URL_").toString();
  				}
  				if(record.getFieldValue("Maintain_of_an_updated_database") != null) {
  					biobankmaintainanupdateddatabase += record.getFieldValue("Maintain_of_an_updated_database").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("Does_sample_management_system_contain_a_data_identification_system") != null) {
  					samplemanagementsystemcontain += record.getFieldValue("Does_sample_management_system_contain_a_data_identification_system").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("Software") != null) {
  					softwarebiobank += record.getFieldValue("Software").toString();
  				}
  				if(record.getFieldValue("Is_the_collection_database_exportable") != null) {
  					startingdateoftheethicalcommitteeapproval += record.getFieldValue("Is_the_collection_database_exportable").toString();
  				}
  				if(record.getFieldValue("If_no__please_specify_the_presumed_date_for_obtaining_the_approval") != null) {
  					startingdateoftheethicalcommitteeapproval += record.getFieldValue("If_no__please_specify_the_presumed_date_for_obtaining_the_approval").toString();
  				}
  			}
  		}
  		if(rdc_rsname.equals("q_biobank_quality")) {
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				if(record.getFieldValue("Restriction_for_use") != null) {
  					restrictionaccesssamples += record.getFieldValue("Restriction_for_use").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("Please_specify_restriction") != null) {
  					restrictionaccesssamplesspecify += record.getFieldValue("Please_specify_restriction").toString();
  				}
  				if(record.getFieldValue("How_many_samples_are_distributed_per_year") != null) {
  					samplesdistributeyear += record.getFieldValue("How_many_samples_are_distributed_per_year").toString();
  				}
  				if(record.getFieldValue("Requirement_to_sign_a_material_transfer_agreement") != null) {
  					materialtransferagreement += record.getFieldValue("Requirement_to_sign_a_material_transfer_agreement").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("Cost_recovery_system_in_place") != null) {
  					costrecoverysystem += record.getFieldValue("Cost_recovery_system_in_place").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("Dedicated_policy_for_return_of_results") != null) {
  					returnoftheresults += record.getFieldValue("Dedicated_policy_for_return_of_results").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("Ethical_Committee_approval_for_biobanking_activity") != null) {
  					ethicalcommitteeapproval += record.getFieldValue("Ethical_Committee_approval_for_biobanking_activity").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("If_yes__please_specify_the_starting_date_of_the_approval") != null) {
  					presumeddateforobtainingtheapproval += record.getFieldValue("If_yes__please_specify_the_starting_date_of_the_approval").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("Are_the_biological_samples_collected_with_an_informed_consent_from_the_patient") != null) {
  					samplescollectedwithaninformedconsent += record.getFieldValue("Are_the_biological_samples_collected_with_an_informed_consent_from_the_patient").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("Does_the_informed_consent_include_the_option_for_patients_to_withdraw_sample_at_any_time") != null) {
  					informedconsentoptionforwithdraw += record.getFieldValue("Does_the_informed_consent_include_the_option_for_patients_to_withdraw_sample_at_any_time").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("Type_of_consent_is_obtained_from_the_patients") != null) {
  					typeofinformedconsent += record.getFieldValue("Type_of_consent_is_obtained_from_the_patients").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("Is_international_exchange_of_samples_considered_in_the_informed_consent") != null) {
  					internationalexchangeofsamplesconsidered += record.getFieldValue("Is_international_exchange_of_samples_considered_in_the_informed_consent").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("Please_specify_if_you_have_some_limitations_regarding_your_local_regulation") != null) {
  					somelimitationsregardingyourlocalregulation += record.getFieldValue("Please_specify_if_you_have_some_limitations_regarding_your_local_regulation").toString();
  				}
  			}
  		}
  		if(rdc_rsname.equals("q_biobank_contribution")) {
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				if(record.getFieldValue("Is_your_entire_sample_collection_available_for_the_RD-Connect_Catalogue") != null) {
  					entiresamplecollectionavailable += record.getFieldValue("Is_your_entire_sample_collection_available_for_the_RD-Connect_Catalogue").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("If_not__please_specify_what_type_of_collections_can_be_publicly_available") != null) {
  					entiresamplecollectionavailablenotspecify += record.getFieldValue("If_not__please_specify_what_type_of_collections_can_be_publicly_available").toString();
  				}
  				if(record.getFieldValue("Please_write_a_few_lines_explaining_why_you_would_like_your_biobank_to_join_RD-Connect") != null) {
  					linesexplainingwhyjoin += record.getFieldValue("Please_write_a_few_lines_explaining_why_you_would_like_your_biobank_to_join_RD-Connect").toString();
  				}
  				if(record.getFieldValue("Other_remarks_or_questions") != null) {
  					otherremarks += record.getFieldValue("Other_remarks_or_questions").toString();
  				}
  				if(record.getFieldValue("You_are_willing_to_accept_the_terms_of_the_RD-Connect_general_charter") != null) {
  					willingtoaccepttheterms += record.getFieldValue("You_are_willing_to_accept_the_terms_of_the_RD-Connect_general_charter").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("You_agree_to_publish_your_available_collections_on_the_RD-Connect_platform") != null) {
  					agreetopublishyouravailablecollections += record.getFieldValue("You_agree_to_publish_your_available_collections_on_the_RD-Connect_platform").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("You_agree_to_distribute_samples_to_investigators_involved_in_rare_disease_research") != null) {
  					agreetodistributesamples += record.getFieldValue("You_agree_to_distribute_samples_to_investigators_involved_in_rare_disease_research").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("Your_biobank_will_retain_ownership__control_and_legal_liability_of_the_biological_samples__RD-Connect_does_not_take_responsibility_for_the_handling_to_the_samples_") != null) {
  					biobankwillretainownership += record.getFieldValue("Your_biobank_will_retain_ownership__control_and_legal_liability_of_the_biological_samples__RD-Connect_does_not_take_responsibility_for_the_handling_to_the_samples_").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  				if(record.getFieldValue("Select8778") != null) {
  					remainconfidentialduringtheentireassessment += record.getFieldValue("Select8778").toString().replaceAll("\"\\]|\\[\"", "");
  				}
  			}
  		}
  	}
  	// Additional
  	if(!associateddataaddition.equalsIgnoreCase("")) {
  		associateddata += "<br />" + associateddataaddition;
  	}
  	if(!associateddataimgaddition.equalsIgnoreCase("")) {
  		associateddataimg += "<br />" + associateddataimgaddition;
  	}
  	if(!associateddataimg.equalsIgnoreCase("")) {
  		associateddataimg += "<br />Imaging available:<br />&nbsp;&nbsp;&nbsp;" + associateddataimg;
  	}
  	if(!collectionsuseaddition.equalsIgnoreCase("")) {
  		collectionsuse += "<br />" + collectionsuseaddition;
  	}
  	if(!collectionsoriginaddition.equalsIgnoreCase("")) {
  		collectionsorigin += "<br />" + collectionsoriginaddition;
  	}
  	if(!biobankpreparesadditional.equalsIgnoreCase("")) {
  		biobankprepares += "<br />" + biobankpreparesadditional;
  	}
  	if(!biobankcollectsadditional.equalsIgnoreCase("")) {
  		biobankcollects += "<br />" + biobankcollectsadditional;
  	}
  	if(!listed_networks2.equalsIgnoreCase("")) {
  		listed_networks += "<br>" + listed_networks2;
  	}
  	// Create Gender
  	String gender = "";
	if(maincontact.getFemale()) {
		gender = "Female";
	}
	if(maincontact.getMale()) {
		gender = "Male";
	}
  	// Create Position
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
  	// Create Disease Matrix
  	String diseasematrixtable = "<table border=\"1\" style=\"width:100%\">";
  	diseasematrixtable += "<tr><th>Disease Name</th><th>Number of Patients, Donors</th><th>Gene</th><th>ORPHA Code</th><th>ICD 10</th><th>OMIM</th><th>Synonym(s)</th></tr>";
  	List<DiseaseMatrix> diseasematrixs = DiseaseMatrixLocalServiceUtil.getDiseaseMatrixs(biobankId, -1, -1);
  	String style = "style=\"background-color: #E8E8E8;\"";
  	boolean evenrow = false;
  	for(DiseaseMatrix diseasematrix : diseasematrixs) {
  		if(evenrow) {
  			diseasematrixtable += "<tr" + style + "><td>";
  			evenrow = false;
  		} else {
  			diseasematrixtable += "<tr><td>";
  			evenrow = true;
  		}
  		diseasematrixtable += diseasematrix.getDiseasename() + 
  				"</td><td>" + diseasematrix.getPatientcount() + "</td><td>" + diseasematrix.getGene() + 
  				"</td><td>" + diseasematrix.getOrphanumber() + "</td><td>" + diseasematrix.getIcd10() + 
  				"</td><td>" + diseasematrix.getOmim() + "</td><td>" + diseasematrix.getSynonym() + "</td></tr>";
  	}
  	diseasematrixtable += "</table>";
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
	<table style="width:100%">
		<tr><td style="width:25%">Biobank Name</td><td style="width:75%"><%= organization.getName() %></td></tr>
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
	<table border="1" style="width:100%">
		<tr><td style="width:25%">First Name</td><td style="width:25%"><%= maincontact.getFirstName() %></td><td style="width:25%">Middle Name</td><td style="width:25%"><%= maincontact.getMiddleName() %></td></tr>
		<tr><td>Last Name</td><td><%= maincontact.getLastName() %></td><td>Title</td><td><%= "" %></td></tr>
		<tr><td>E-Mail</td><td colspan="3"><%= maincontact.getEmailAddress() %></td></tr
		<tr><td>Gender</td><td colspan="3"><%= gender %></td></tr>
		<tr><td>Position</td><td colspan="3"><%= role %></td></tr>
		<tr><td colspan="4"></td></tr>
		<tr><td>1.3 Source of funding</td><td colspan="3"><%= source_of_funding %></td></tr>
		<tr><td>1.4 Host institute</td><td colspan="3"><%= hoste_institute %></td></tr>
		<tr><td>1.5 Type of host institute</td><td colspan="3"><%= type_of_host_institution %></td></tr>
		<tr><td>1.6 How many rare diseases are in your biobank?</td><td colspan="3"><%= howmanyrarediseases %></td></tr>
		<tr><td>1.7 Target population</td><td colspan="3"><%= target_population %></td></tr>
		<tr><td>1.8 Your biobank is listed in other inventories/networks (please select all that apply):</td><td colspan="3"><%= listed_networks %></td></tr>
	</table>
	<h5>2 COLLECTIONS OF DISEASES</h3>
	<hr>
	<table border="0" style="width:100%">
		<tr><td>2.1 What percentage of your biological sample are from rare diseases? (%):</td><td><%= percentagerdsamples %></td></tr>
		<tr><td>2.2 DiseaseMatrix</td><td></td></tr>
	</table>
	<%= diseasematrixtable %>
	<h5>3 TYPE OF BIOLOGICAL RESOURCES</h3>
	<hr>
	<table border="1" style="width:100%">
		<tr><td style="width:50%">3.1 The biobank collects</td><td style="width:50%"><%= biobankcollects %></td></tr>
		<tr><td style="width:50%">3.2 The biobank prepares</td><td style="width:50%"><%= biobankprepares %></td></tr>
	</table>
	<h5>4 USE AND ORIGIN OF THE BIOLOGICAL SAMPLES</h3>
	<hr>
	<table border="1" style="width:100%">
		<tr><td colspan="2">4.1 In what context were your collections sampled/used?</td></tr>
		<tr><td style="width:50%">Origin</td><td style="width:50%"><%= collectionsorigin %></td></tr>
		<tr><td>Use</td><td><%= collectionsuse %></td></tr>
		<tr><td colspan="2">4.2 What type of associated data could you provide with the samples?</td></tr>
		<tr><td colspan="2"><%= associateddata %></td></tr>
		<tr><td colspan="2">4.3 List of recent scientific publications based on samples from your biobank:</td></tr>
		<tr><tdcolspan="2"><%= scientificpublications %></td></tr>
	</table>
	<h5>5 QUALITY ASSURANCE</h3>
	<hr>
	<table border="1" style="width:100%">
		<tr><td style="width:50%">5.1 Does your biobank have a Quality Assurance system?</td><td style="width:50%"><%= qualityassurancesystem %></td></tr>
		<tr><td>If yes, please specify which</td><td><%= qualityassurancesystemspecify %></td></tr>
		<tr><td>5.2 Does your biobank adopt a dedicated standards for sample acquisition?</td><td><%= standardsforsampleacquisition %></td></tr>
		<tr><td>5.3 Does your biobank perform molecular tests to ensure sample integrity?</td><td><%= ensuresampleintegrity %></td></tr>
		<tr><td>5.4 Does your biobank adopt a dedicated SOP for sample processing/storage?</td><td><%= dedicatedsop %></td></tr>
	</table>
	<h5>6 DATA MANAGEMENT</h3>
	<hr>
	<table border="1" style="width:100%">
		<tr><td style="width:50%">6.1 Does your biobank have a catalogue of collection?</td><td style="width:50%"><%= biobankcataloguecollection %></td></tr>
		<tr><td>If yes, is it published on a website?</td><td><%= publishedonwebsite %></td></tr>
		<tr><td>6.2 Does your biobank maintain an updated database?</td><td><%= biobankmaintainanupdateddatabase %></td></tr>
		<tr><td>6.3 Does your sample management system contain a data identification system?</td><td><%= samplemanagementsystemcontain %></td></tr>
		<tr><td>6.4 Which software does your biobank use?</td><td><%= softwarebiobank %></td></tr>
		<tr><td>6.5 Is the collection database exportable?</td><td><%= databaseexportable %></td></tr>
	</table>
	<h5>7 ACCESS TO SAMPLE COLLECTIONS</h3>
	<hr>
	<table border="1" style="width:100%">
		<tr><td style="width:50%">7.1 Is there a restriction on which user may access samples held in your biobank?</td><td style="width:50%"><%= restrictionaccesssamples %></td></tr>
		<tr><td colspan="2"><%= restrictionaccesssamplesspecify %></td></tr>
		<tr><td>7.2 How many samples do you distribute per year?</td><td><%= samplesdistributeyear %></td></tr>
		<tr><td>7.3 Does your biobank require the users to sign a Material Transfer Agreement?</td><td><%= materialtransferagreement %></td></tr>
		<tr><td>7.4 Is there a cost recovery system in place?</td><td><%= costrecoverysystem %></td></tr>
		<tr><td>7.5 Is there a dedicated policy for the return of the results from users?</td><td><%= returnoftheresults %></td></tr>
	</table>
	<h5>8 ETHICAL, LEGAL AND SOCIAL IMPLICATIONS (ELSI)</h3>
	<hr>
	<table border="1" style="width:100%">
		<tr><td style="width:50%">8.1 Do you have an Ethical Committee approval for your biobanking activity?</td><td style="width:50%"><%= ethicalcommitteeapproval %></td></tr>
		<tr><td>If yes, please specify the starting date of the Ethical Committee approval:</td><td><%= startingdateoftheethicalcommitteeapproval %></td></tr>
		<tr><td>If no, please specify the presumed date for obtaining the approval:</td><td><%= presumeddateforobtainingtheapproval %></td></tr>
		<tr><td>8.2 Are the biological samples collected with an informed consent from the patients?</td><td><%= samplescollectedwithaninformedconsent %></td></tr>
		<tr><td>8.3 Does the informed consent include the option for patients to withdraw sample at any time?</td><td><%= informedconsentoptionforwithdraw %></td></tr>
		<tr><td>8.4 Type of informed consent signed by the donors:</td><td><%= typeofinformedconsent %></td></tr>
		<tr><td>8.5 Is international exchange of samples considered in the informed consent?</td><td><%= internationalexchangeofsamplesconsidered %></td></tr>
		<tr><td colspan="2">Please specify if you have some limitations regarding your local regulation:</td></tr>
		<tr><td colspan="2"><%= somelimitationsregardingyourlocalregulation %></td></tr>
	</table>
	<h5>9 CONTRIBUTION TO THE RD-CONNECT PLATFORM</h3>
	<hr>
	<table border="1" style="width:100%">
		<tr><td style="width:50%">9.1 Is your entire sample collection available for the RD-Connect Catalogue?</td><td style="width:50%"><%= entiresamplecollectionavailable %></td></tr>
		<tr><td colspan="2">If not, please specify what type of collections can be publicly available.</td></tr>
		<tr><td colspan="2"><%= entiresamplecollectionavailablenotspecify %></td></tr>
		<tr><td colspan="2">9.2 Please write a few lines explaining why you would like your biobank to join RD-Connect:</td></tr>
		<tr><td colspan="2"><%= linesexplainingwhyjoin %></td></tr>
		<tr><td colspan="2">9.3 Other remarks or questions:</td></tr>
		<tr><td colspan="2"><%= otherremarks %></td></tr>
	</table>
	<h5>10 DECLARATION & DISCLAIMER</h3>
	<hr>
	<table border="1" style="width:100%">
		<tr><td style="width:5%">10.1</td><td style="width:50%">You are willing to accept the terms of the RD-Connect general charter.</td><td style="width:45%"><%= willingtoaccepttheterms %></td></tr>
		<tr><td></td><td>You agree to publish your available collections on the RD-Connect platform.</td><td><%= agreetopublishyouravailablecollections %></td></tr>
		<tr><td></td><td>You agree to distribute samples to investigators involved in rare disease research.</td><td><%= agreetodistributesamples %></td></tr>
		<tr><td>10.2</td><td>Your biobank will retain ownership, control and legal liability of the biological samples. RD-Connect does not take responsibility for the handling to the samples.</td><td><%= biobankwillretainownership %></td></tr>
		<tr><td>10.3</td><td>You agree that your answers in this survey can be processed and stored by RD-Connect. Your data will remain confidential during the entire assessment process.</td><td><%= remainconfidentialduringtheentireassessment %></td></tr>
	</table>
</div>