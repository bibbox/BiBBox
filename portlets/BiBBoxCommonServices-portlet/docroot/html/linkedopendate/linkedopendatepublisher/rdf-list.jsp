<%@ include file="/html/linkedopendate/linkedopendatepublisher/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<portlet:defineObjects />

<%

Integer success = ParamUtil.getInteger(request, "resourcePrimKey");

%>
<br>

<%
List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), 0);
for(Organization organization : organizations) {
	String rdf_header = "";
	
	List<DDLRecord> records_diseasematrix = null;

	rdf_header += "@prefix rdf: &#60;http://www.w3.org/1999/02/22-rdf-syntax-ns#&#62;<br>";
	rdf_header += "@prefix dc: &#60;http://purl.org/dc/elements/1.1/&#62;<br>";
	rdf_header += "@prefix ex: &#60;http://example.org/stuff/1.0/&#62;<br>";
	rdf_header += "@prefix miabis: &#60;http://...&#62;<br>";

	String rdf_type = "";
	String rdf_web = "";
	String rdf_uri = "http://rd-connect.bibbox.org/wobr/-/web-of-rdconnect/" + organization.getOrganizationId();
	String disease_matrix = "";

	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
	for(DDLRecordSet rdc_rs : rdc_recordlist) {
	   String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
	   if(rdc_rsname.equals("core")) { 
	      List<DDLRecord> records_type = rdc_rs.getRecords();
	      for(DDLRecord record : records_type) {
	         if(record.getFieldValue("Radio2493") != null) {
	            String type = record.getFieldValue("Radio2493").toString();
	            if(type.equalsIgnoreCase("[bb]") || type.equalsIgnoreCase("[\"bb\"]")) {
	               rdf_type += "rdf:type: miabis:biobank;<br>";
	            } else if(type.equalsIgnoreCase("[reg]") || type.equalsIgnoreCase("[\"reg\"]")) {
	               rdf_type += "rdf:type: miabis:registry;<br>";
	            } else {
	               rdf_type += "rdf:type: miabis:biobank;<br>";
	               rdf_type += "rdf:type: miabis:registry;<br>";
	            }
	         }
	      }
	   }
	   if(rdc_rsname.equals("Disease Matrix")) {
		   disease_matrix = "miabis:disease (<br>";
		   records_diseasematrix = rdc_rs.getRecords();
		   for(DDLRecord record : records_diseasematrix) {
			   String tmpuri = rdf_uri + "/diseasesMatrix/" + record.getRecordId();
			   disease_matrix += "&#60;<a href=\"" + tmpuri + "\">" + tmpuri + "</a>&#62;<br>";
		   }
		   disease_matrix += ").<br>";
	   }
	}

	for(com.liferay.portal.model.Website website : WebsiteLocalServiceUtil.getWebsites(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId())) {
	   rdf_web += "miabis:web " + website.getUrl() + ";<br>";
	}

	long personid = 0;

	String rdf_persons = "foaf:Person (<br>";
	User maincontact = null;
	List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
	for(User usertmp : userlist) {
		String tmpuri = rdf_uri + "/person/" + usertmp.getUserId();
	   rdf_persons += "&#60;<a href=\"" + tmpuri + "\">" + tmpuri + "</a>&#62;<br>";
	   List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(usertmp.getUserId(), organization.getGroup().getGroupId());
	   for (UserGroupRole ugr : usergrouprolles) {
	      if(ugr.getRole().getName().equalsIgnoreCase("BiobanK-REG-MAINCONTACT")
	            || ugr.getRole().getName().equalsIgnoreCase("Biobank, Registry Main Contact")
	            || ugr.getRole().getName().equalsIgnoreCase("BiobanK-REG-MAINCONTACT")) {
	         maincontact =  usertmp;
	         personid = maincontact.getUserId();
	      }
	   }
	}
	rdf_persons += ").<br>";

	String contact_uri = "";
	if(maincontact != null) {
	  //String tmpuri = rdf_uri + "/person/" + maincontact.getFullName().replaceAll(" ", "");
	  String tmpuri = rdf_uri + "/person/" + maincontact.getUserId();
	  contact_uri = "miabis:contact &#60;<a href=\"" + tmpuri + "\">" + tmpuri + "</a>&#62;.<br>"; 
	   
	}



	%>

	<%= rdf_header %>
	<br>
	&#60;<a href="<%= rdf_uri %>"><%= rdf_uri %></a>&#62;<br>
	<%= rdf_type %>
	miabis:name "<%= organization.getName() %>";<br>
	<%= rdf_web %>
	<%= contact_uri %>
	<br>
	<%= rdf_persons %>
	<br>
	<%= disease_matrix %>
   
   <br>
   
<%
long organisationid = organization.getOrganizationId();

// ------------
// Person
if(personid != 0) {


rdf_header = "";
rdf_header += "@prefix rdf: &#60;http://www.w3.org/1999/02/22-rdf-syntax-ns#&#62;<br>";
rdf_header += "@prefix dc: &#60;http://purl.org/dc/elements/1.1/&#62;<br>";
rdf_header += "@prefix ex: &#60;http://example.org/stuff/1.0/&#62;<br>";
rdf_header += "@prefix miabis: &#60;http://...&#62;<br>";

User person = UserLocalServiceUtil.getUser(personid);

rdf_uri = "http://rd-connect.bibbox.org/wobr/-/web-of-rdconnect/" + organisationid + "/person/" + personid;
rdf_type = "rdf:type: foaf:Person<br>";
String rdf_name =  "foaf:name \"" + person.getFullName() + "\"<br>";
String rdf_mail =  "foaf:mbox \"" + person.getEmailAddress() + "\"<br>";

String rdf_organisation = "miabis:organisation (<br>";
List<Organization> organisations = OrganizationLocalServiceUtil.getUserOrganizations(personid);
for(Organization organization_tmp : organisations) {
	String tmp_uri = "http://rd-connect.bibbox.org/wobr/-/web-of-rdconnect/" + organization_tmp.getOrganizationId();
	rdf_organisation += "&#60;<a href=\"" + tmp_uri + "\">" + tmp_uri + "</a>&#62;<br>";
}
rdf_organisation += ").<br>";

%>
<%= rdf_header %>
<br>
&#60;<a href="<%= rdf_uri %>"><%= rdf_uri %></a>&#62;<br>
<%= rdf_type %>
<%= rdf_name %>
<%= rdf_mail %>

<%= rdf_organisation %>
	
	<%
}
%>
<!-- disease -->
<%
if(records_diseasematrix != null) {
for(DDLRecord record : records_diseasematrix) {
	   long diseasematrixid = record.getRecordId();
	rdf_header = "";
	rdf_header += "@prefix rdf: &#60;http://www.w3.org/1999/02/22-rdf-syntax-ns#&#62;<br>";
	rdf_header += "@prefix dc: &#60;http://purl.org/dc/elements/1.1/&#62;<br>";
	rdf_header += "@prefix ex: &#60;http://example.org/stuff/1.0/&#62;<br>";
	rdf_header += "@prefix miabis: &#60;http://...&#62;<br>";
	
	rdf_uri = "http://rd-connect.bibbox.org/wobr/-/web-of-rdconnect/" + organisationid + "/diseasesMatrix/" + diseasematrixid;
	String rdf_codes = "";
	String rdf_diseases = "";
	
	List<DDLRecordSet> rdc_recordlist2 = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
	for(DDLRecordSet rdc_rs2 : rdc_recordlist2) {
		String rdc_rsname = String.valueOf(rdc_rs2.getNameCurrentValue());
		if(rdc_rsname.equals("Disease Matrix")) {
		  //List<DDLRecord> records = rdc_rs.get;
		  DDLRecord record2 = DDLRecordLocalServiceUtil.getRecord(diseasematrixid);
		  //for(DDLRecord record : records) {
			  Field f_number_of_doners = record2.getField("Number_of_Donors");
			  if(f_number_of_doners != null) {
				  rdf_diseases += "miabis:storedsampleamount " + f_number_of_doners.getValue() + "<br>";
			  }
			  Field f_gene = record2.getField("Gene");
			  if(f_gene != null) {
		           rdf_diseases += "gene:gene " + f_gene.getValue() + "<br>";
			  }
			  Field f_orphanet_number = record2.getField("Orphanet_Number");
			  if(f_orphanet_number != null) {
		           rdf_diseases += "orphanet:number &#60;http://www.orphanet/ORDO/Orphanet_" + f_orphanet_number.getValue() + "&#62;<br>";
			  }
			  Field f_icd10 = record2.getField("ICD10");
			  if(f_icd10 != null) {
		           rdf_diseases += "who:icd10 " + f_icd10.getValue() + "<br>";
			  }
			  Field f_omim = record2.getField("OMIM");
			  if(f_omim != null) {
		           rdf_diseases += "omim:omim " + f_omim.getValue() + "<br>";
			  }
			  Field f_synonyms = record2.getField("Synonym_s_");
			  if(f_synonyms != null) {
		           rdf_diseases += "text:synonym " + f_synonyms.getValue() + "<br>";
			  }
		  //}
		}
	}
	
	%>
	<%= rdf_header %>
	<br>
	&#60;<a href="<%= rdf_uri %>"><%= rdf_uri %></a>&#62;<br>
	<%= rdf_diseases %>
<%
}
}
}
%>