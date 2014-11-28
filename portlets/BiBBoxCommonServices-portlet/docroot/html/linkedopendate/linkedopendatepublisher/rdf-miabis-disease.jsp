<%@ include file="/html/linkedopendate/linkedopendatepublisher/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.storage.Field" %>

<portlet:defineObjects />

<%

Long diseasematrixid = ParamUtil.getLong(request, "diseasematrixid");
Long organisationid = ParamUtil.getLong(request, "organisationid");

String rdf_header = "";
rdf_header += "@prefix rdf: &#60;http://www.w3.org/1999/02/22-rdf-syntax-ns#&#62;<br>";
rdf_header += "@prefix dc: &#60;http://purl.org/dc/elements/1.1/&#62;<br>";
rdf_header += "@prefix ex: &#60;http://example.org/stuff/1.0/&#62;<br>";
rdf_header += "@prefix miabis: &#60;http://...&#62;<br>";

String rdf_uri = "http://rd-connect.bibbox.org/wobr/-/web-of-rdconnect/" + organisationid + "/diseasesMatrix/" + diseasematrixid;
String rdf_codes = "";
String rdf_diseases = "";

Organization organization = OrganizationLocalServiceUtil.getOrganization(organisationid);

List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
for(DDLRecordSet rdc_rs : rdc_recordlist) {
	String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
	if(rdc_rsname.equals("Disease Matrix")) {
	  //List<DDLRecord> records = rdc_rs.get;
	  DDLRecord record = DDLRecordLocalServiceUtil.getRecord(diseasematrixid);
	  //for(DDLRecord record : records) {
		  Field f_number_of_doners = record.getField("Number_of_Donors");
		  if(f_number_of_doners != null) {
			  rdf_diseases += "miabis:storedsampleamount " + f_number_of_doners.getValue() + "<br>";
		  }
		  Field f_gene = record.getField("Gene");
		  if(f_gene != null) {
	           rdf_diseases += "gene:gene " + f_gene.getValue() + "<br>";
		  }
		  Field f_orphanet_number = record.getField("Orphanet_Number");
		  if(f_orphanet_number != null) {
	           rdf_diseases += "orphanet:number " + f_orphanet_number.getValue() + "<br>";
		  }
		  Field f_icd10 = record.getField("ICD10");
		  if(f_icd10 != null) {
	           rdf_diseases += "who:icd10 " + f_icd10.getValue() + "<br>";
		  }
		  Field f_omim = record.getField("OMIM");
		  if(f_omim != null) {
	           rdf_diseases += "omim:omim " + f_omim.getValue() + "<br>";
		  }
		  Field f_synonyms = record.getField("Synonym_s_");
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
