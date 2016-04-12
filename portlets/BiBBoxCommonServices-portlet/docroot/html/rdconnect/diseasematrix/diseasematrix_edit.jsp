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

<style>
.aui .diseasematrixinput {
	width: 450px;
	max-width: 500px;
}
.aui .diseasematrixinputlong {
	width: 900px;
	max-width: 1000px;
}
</style>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%=tmpTitle %>'
/>

<aui:model-context bean="<%= diseasematrix %>" model="<%= DiseaseMatrix.class %>" />

<portlet:actionURL name='<%= diseasematrix == null ? "addDiseaseMatrix" : "updateDiseaseMatrix" %>' var="editDiseaseMatrixURL" windowState="normal" />

<aui:form action="<%= editDiseaseMatrixURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:layout cssClass="proposelayout">
			<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
			<aui:input type="hidden" name="diseasematrixId" value='<%= diseasematrix == null ? "" : diseasematrix.getDiseasematrixId() %>'/>
			<aui:input type="hidden" name="organizationId" value='<%= organizationId %>'/>
			<aui:column columnWidth="100" first="true">
					<aui:input id="InputDiseasename" name="diseasename" first="true" cssClass="diseasematrixinputlong" />
				</aui:column>
				<aui:column columnWidth="100" first="true">
					<aui:input name="patientcount" />
				</aui:column>
				<aui:column columnWidth="50" first="true" >
					<aui:input name="gene" cssClass="diseasematrixinput" />
				</aui:column>
				<aui:column columnWidth="50" last="true">
					<aui:input id="InputOrphanumber" name="orphanumber"  helpMessage="Type Orhanumber Input Box" first="true" cssClass="diseasematrixinput" />
				</aui:column>
				<aui:column columnWidth="50" first="true">
					<aui:input name="icd10"  cssClass="diseasematrixinput"/>
				</aui:column>
				<aui:column columnWidth="50" last="true">
					<aui:input name="omim"  cssClass="diseasematrixinput"/>
				</aui:column>
				<aui:column columnWidth="100" first="true">
					<aui:input name="synonym" cssClass="diseasematrixinputlong" />
				</aui:column>
			</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>

<portlet:resourceURL var="getOrphanumbers">
	<portlet:param name="<%=Constants.CMD%>" value="load_diseasname" />
	<portlet:param name="RDCOrganisationId" value="<%= String.valueOf(organizationId) %>" />
</portlet:resourceURL>
<aui:script>
	AUI().use('autocomplete-list','aui-base','aui-io-request','autocomplete-filters','autocomplete-highlighters',function (A) {
		function orhanumberFormatter(query, results) {
  			// Iterate over the array of tweet result objects and return an
  			// array of HTML strings.
  			return A.Array.map(results, function (result) {
    			var jsonarrayresult = result.raw;
    			// Use string substitution to fill out the tweet template and
    			// return an HTML string for this result.
    			return jsonarrayresult.orphanumber + " (" +  jsonarrayresult.diseasename + ")";
  			});
		}

		A.io.request('<%= getOrphanumbers %>',{
			dataType: 'json',
			method: 'GET',
			on: {
				success: function() {
					new A.AutoCompleteList(
					{
						allowBrowserAutocomplete: 'false',
						activateFirstItem: 'true',
						inputNode: '#<portlet:namespace/>InputOrphanumber',
						resultTextLocator: 'orphanumber',
						resultFormatter: orhanumberFormatter,
						resultHighlighter:['phraseMatch'],
						resultFilters:['phraseMatch'],
						render: 'true',
						source:this.get('responseData'),
					});
				}
			}
		}); 
		
		A.io.request('<%= getOrphanumbers %>',{
			dataType: 'json',
			method: 'GET',
			on: {
				success: function() {
					new A.AutoCompleteList(
					{
						allowBrowserAutocomplete: 'false',
						activateFirstItem: 'true',
						inputNode: '#<portlet:namespace/>InputDiseasename',
						resultTextLocator: 'diseasename',
						resultHighlighter:['phraseMatch'],
						resultFilters:['phraseMatch'],
						render: 'true',
						source:this.get('responseData'),
					});
				}
			}
		}); 
		
		var diseaseNameNode = mynode = A.all('#<portlet:namespace/>InputDiseasename');
		
		diseaseNameNode.ac.after('select', function (e) {
		    alert("Selected");
		});                
	});
</aui:script>