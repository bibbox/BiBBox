<%@ include file="/html/iris/init.jsp"%>

<%
Long patientid = ParamUtil.getLong(request, "patientid");

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
          <li class="active"><a href="#teb-patient">Patient: <%= patient.getField("Name").getValue() %></a></li>
          <li><a href="#tab-1">Study Information</a></li>
          <li><a href="#tab-2">Examination List</a></li>
          <li><a href="#tab-3">Info2</a></li>
        </ul>
        
     <div class="tab-content"> 
        <div id="teb-patient">
          Subject ID: <%= patient.getField("Subject_ID").getValue() %> / Anonymized Identification: <%= patient.getField("Anonymized_Identification").getValue() %><br>
          Name: <%= patient.getField("Name").getValue() %> <%= patient.getField("Surname").getValue() %><br>
          Birthdate: <%= patient.getField("Birthdate").getValue() %><br>
          Gender: <%= patient.getField("Gender").getValue().toString().replaceAll("(\\[\")", "").replaceAll("(\"\\])", "") %><br>
        </div>
        <div id="tab-1" class="tab-pane">
            Anonymized Identification: <%= patient.getField("Anonymized_Identification").getValue() %><br>
            Date of inclusion / examination: <%= patient.getField("Date_of_inclusion___examination_").getValue() %><br>
            Signed Informed consent obtained: <%= IC %><br>
            Ethnicity: <%= ethnicity_string %><br>
            Social and Educational information:<br>
            <%= patient.getField("Social_and_Educational_information").getValue() %><br>
        </div>
        <div id="tab-2" class="tab-pane">
            789
        </div>
        <div id="tab-3" class="tab-pane">
            <p>Aliquid ipsum asperiores alias temporibus autem impedit soluta ut id iure explicabo veritatis consectetur debitis eaque recusandae odit quas nobis maxime saepe. Incidunt amet obcaecati. Ducimus soluta unde repellat laboriosam fuga modi rem itaque!</p>
        </div>
    </div>
</div>
      
