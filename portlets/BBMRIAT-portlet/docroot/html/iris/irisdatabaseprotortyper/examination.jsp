<%@ include file="/html/iris/init.jsp"%>

<%
Long patientid = ParamUtil.getLong(request, "patientid");
Long examinationid = ParamUtil.getLong(request, "examinationid");

DDLRecord patient = DDLRecordLocalServiceUtil.getDDLRecord(patientid);

Field ethnicity = patient.getField("Ethnicity");
String ethnicity_string = "";
if(ethnicity != null) {
   ethnicity_string = ethnicity.getValue().toString().replaceAll("(\\[\")", "").replaceAll("(\"\\])", "");
   if(ethnicity_string.equalsIgnoreCase("other")) {
        ethnicity_string = "Other: " + patient.getField("Other").getValue().toString();
   }
} 
String IC = "Yes";
if(patient.getField("Signed_Informed_consent_obtained__").getValue().toString().equalsIgnoreCase("false")) {
   IC = "No";
}

%>

<!-- Pannel 2 -->
<div id="bbmritab">
      
        <ul class="nav nav-tabs">
          <li><a href="#teb-patient">Patient: <%= patient.getField("Name").getValue() %></a></li>
          <li class="active"><a href="#teb-examination">Examination: <%= examinationid %></a></li>
        </ul>
        
     <div class="tab-content"> 
        <div id="teb-patient">
				Subject ID: <%= patient.getField("Subject_ID").getValue() %> / Anonymized Identification: <%= patient.getField("Anonymized_Identification").getValue() %><br>
          Name: <%= patient.getField("Name").getValue() %> <%= patient.getField("Surname").getValue() %><br>
          Birthdate: <%= patient.getField("Birthdate").getValue() %><br>
          Gender: <%= patient.getField("Gender").getValue().toString().replaceAll("(\\[\")", "").replaceAll("(\"\\])", "") %><br>
			</div>
			<div id="teb-examination">
			   Examination: <%= examinationid %>
			</div>
		</div>
</div>