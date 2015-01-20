<%@ include file="/html/rdconnect/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
long diseasematrixId = ParamUtil.getLong(request, "diseasematrixId");
String redirect = ParamUtil.getString(request, "redirect");
long organizationId = ParamUtil.getLong(request, "organizationId");

DiseaseMatrix diseasematrix = null;
if (diseasematrixId > 0) {
	diseasematrix = DiseaseMatrixLocalServiceUtil.getDiseaseMatrix(diseasematrixId);
}
	
String tmpTitle = "new-diseasematrix";
if (diseasematrix != null) {
	tmpTitle = diseasematrix.getDiseasename(); 
}
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%=tmpTitle %>'
/>

<aui:model-context bean="<%= diseasematrix %>" model="<%= DiseaseMatrix.class %>" />

<portlet:actionURL name='<%= diseasematrix == null ? "addDiseaseMatrix" : "updateDiseaseMatrix" %>' var="editDiseaseMatrixURL" windowState="normal" />

<aui:form action="<%= editDiseaseMatrixURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:input type="hidden" name="diseasematrixId" value='<%= diseasematrix == null ? "" : diseasematrix.getDiseasematrixId() %>'/>
		<aui:input type="hidden" name="organizationId" value='<%= organizationId %>'/>
		<aui:input name="diseasename" />
		<aui:input name="patientcount" />
		<aui:input name="gene" />
		<aui:input name="orphanumber" />
		<aui:input name="icd10" />
		<aui:input name="omim" />
		<aui:input name="synonym" />
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>