<%@ include file="/html/rdconnect/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
long generalinformationId = ParamUtil.getLong(request, "generalinformationId");
String redirect = ParamUtil.getString(request, "redirect");
long organizationId = ParamUtil.getLong(request, "organizationId");

GeneralInformation generalinformation = null;
if (generalinformationId > 0) {
	generalinformation = GeneralInformationLocalServiceUtil.getGeneralInformation(generalinformationId);
}

Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
	
String tmpTitle = "General Information " + organization.getName();
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%=tmpTitle %>'
/>

<aui:model-context bean="<%= generalinformation %>" model="<%= GeneralInformation.class %>" />

<portlet:actionURL name='<%= generalinformation == null ? "addGeneralInformation" : "updateGeneralInformation" %>' var="editGeneralInformationURL" windowState="normal" />

<aui:form action="<%= editGeneralInformationURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:layout>
			<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
			<aui:input type="hidden" name="generalinformationId" value='<%= generalinformation == null ? "" : generalinformation.getGeneralinformationId() %>'/>
			<aui:input type="hidden" name="organizationId" value='<%= organizationId %>'/>
			<aui:column columnWidth="100" first="true">
				<aui:input name="acronym" />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="description" />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="hosteinstitue" />
			</aui:column>
			<aui:column columnWidth="50" first="true">
				<aui:select name="typeofhosteinstitue" showEmptyOption="<%= true %>" label="typeofhosteinstitue" cssClass="typeofhosteinstitue">
					<aui:option value="Regional Authority" selected="<%=\"Regional Authority\".equals(generalinformation.getTypeofhosteinstitue()) %>">Regional Authority</aui:option>
					<aui:option value="National Authority" selected="<%=\"National Authority\".equals(generalinformation.getTypeofhosteinstitue()) %>">National Authority</aui:option>
					<aui:option value="Hospital" selected="<%=\"Hospital\".equals(generalinformation.getTypeofhosteinstitue()) %>">Hospital</aui:option>	
					<aui:option value="Patient's Association" selected="<%=\"Patient's Association\".equals(generalinformation.getTypeofhosteinstitue()) %>">Patient's Association</aui:option>
					<aui:option value="Foundation" selected="<%=\"Foundation\".equals(generalinformation.getTypeofhosteinstitue()) %>">Foundation</aui:option>
					<aui:option value="EU Commission/EU Agency" selected="<%=\"EU Commission/EU Agency\".equals(generalinformation.getTypeofhosteinstitue()) %>">EU Commission/EU Agency</aui:option>
					<aui:option value="No specific funds" selected="<%=\"No specific funds\".equals(generalinformation.getTypeofhosteinstitue()) %>">No specific funds</aui:option>
					<aui:option value="Other - please specify" selected="<%=generalinformation.getTypeofhosteinstitue().contains(\"Other - please specify\") %>">Other - please specify</aui:option>
					<aui:option value="not specified" selected="<%=generalinformation.getTypeofhosteinstitue().equals(\"not specified\") %>">not specified</aui:option>		
				</aui:select>
			</aui:column>
			<aui:column columnWidth="50" last="true">
				<%
				String othertypeofhosteinstitue = "";
				if(generalinformation.getTypeofhosteinstitue().contains("Other - please specify")) {
					othertypeofhosteinstitue = generalinformation.getTypeofhosteinstitue().replaceAll("Other - please specify", "");
				}
				%>
				<aui:input name="othertypeofhosteinstitue" label="othertypeofhosteinstitue" type="text" value='<%= othertypeofhosteinstitue %>' />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="sourceoffunding" />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="country" />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:select name="targetpopulation" showEmptyOption="<%= true %>" label="targetpopulation" cssClass="targetpopulation">
					<aui:option value="Local (i.e.: Hospital, Primary healthcare centre,...)" selected="<%=\"Local (i.e.: Hospital, Primary healthcare centre,...)\".equals(generalinformation.getTargetpopulation()) %>">Local (i.e.: Hospital, Primary healthcare centre,...)</aui:option>
					<aui:option value="Regional" selected="<%=\"Regional\".equals(generalinformation.getTargetpopulation()) %>">Regional</aui:option>
					<aui:option value="National" selected="<%=\"National\".equals(generalinformation.getTargetpopulation()) %>">National</aui:option>	
					<aui:option value="International" selected="<%=\"International\".equals(generalinformation.getTargetpopulation()) %>">International</aui:option>
					<aui:option value="not specified" selected="<%=\"not specified\".equals(generalinformation.getTargetpopulation()) %>">not specified</aui:option>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="yearofestablishment" />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:select name="howmanyrdsareintheregistrybiobank" showEmptyOption="<%= true %>" label="howmanyrdsareintheregistrybiobank" cssClass="howmanyrdsareintheregistrybiobank">
					<aui:option value="Just one RD" selected="<%=\"Just one RD\".equals(generalinformation.getHowmanyrdsareintheregistrybiobank()) %>">Just one RD</aui:option>
					<aui:option value="A group of related RDs" selected="<%=\"A group of related RDs\".equals(generalinformation.getHowmanyrdsareintheregistrybiobank()) %>">A group of related RDs</aui:option>
					<aui:option value="A group of unrelated RDs" selected="<%=\"A group of unrelated RDs\".equals(generalinformation.getHowmanyrdsareintheregistrybiobank()) %>">A group of unrelated RDs</aui:option>	
					<aui:option value="Several diseases among which some are RD" selected="<%=\"Several diseases among which some are RD\".equals(generalinformation.getHowmanyrdsareintheregistrybiobank()) %>">Several diseases among which some are RD</aui:option>
					<aui:option value="not specified" selected="<%=\"not specified\".equals(generalinformation.getHowmanyrdsareintheregistrybiobank()) %>">not specified</aui:option>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="percentageofrarediseasesinyourregistrybiobank" />
			</aui:column>
			<aui:column columnWidth="50" first="true">
				<aui:select name="ontologies" showEmptyOption="<%= true %>" label="ontologies" cssClass="ontologies">
					<aui:option value="Human Phenotype Ontology (HPO)" selected="<%=\"Human Phenotype Ontology (HPO)\".equals(generalinformation.getOntologies()) %>">Human Phenotype Ontology (HPO)</aui:option>
					<aui:option value="Clinical measurement Ontology (CMO)" selected="<%=\"Clinical measurement Ontology (CMO)\".equals(generalinformation.getOntologies()) %>">Clinical measurement Ontology (CMO)</aui:option>
					<aui:option value="Symptoms Ontology (SYMP)" selected="<%=\"Symptoms Ontology (SYMP)\".equals(generalinformation.getOntologies()) %>">Symptoms Ontology (SYMP)</aui:option>	
					<aui:option value="Clinical Traditional Medicine Signs and Symptoms Value Set (TM-SIGNS-AND-SYMPTS)" selected="<%=\"Clinical Traditional Medicine Signs and Symptoms Value Set (TM-SIGNS-AND-SYMPTS)\".equals(generalinformation.getOntologies()) %>">Clinical Traditional Medicine Signs and Symptoms Value Set (TM-SIGNS-AND-SYMPTS)</aui:option>
					<aui:option value="Signs and Symptoms Ontology (CSSO)" selected="<%=\"Signs and Symptoms Ontology (CSSO)\".equals(generalinformation.getOntologies()) %>">Signs and Symptoms Ontology (CSSO)</aui:option>
					<aui:option value="None" selected="<%=\"None\".equals(generalinformation.getOntologies()) %>">None</aui:option>
					<aui:option value="not specified" selected="<%=\"not specified\".equals(generalinformation.getOntologies()) %>">not specified</aui:option>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="50" last="true">
				<%
				String otherontologies = "";
				if(generalinformation.getOntologies().contains("Other - please specify")) {
					otherontologies = generalinformation.getOntologies().replaceAll("Other - please specify", "");
				}
				%>
				<aui:input name="otherontologies" label="otherontologies" type="text" value='<%= otherontologies %>' />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:select name="biomaterialcollected" showEmptyOption="<%= true %>" label="biomaterialcollected" cssClass="biomaterialcollected" multiple="true">
					<aui:option value="Local (i.e.: Hospital, Primary healthcare centre,...)" selected="<%=\"Local (i.e.: Hospital, Primary healthcare centre,...)\".equals(generalinformation.getTargetpopulation()) %>">Local (i.e.: Hospital, Primary healthcare centre,...)</aui:option>
					<aui:option value="Regional" selected="<%=\"Regional\".equals(generalinformation.getTargetpopulation()) %>">Regional</aui:option>
					<aui:option value="National" selected="<%=\"National\".equals(generalinformation.getTargetpopulation()) %>">National</aui:option>	
					<aui:option value="International" selected="<%=\"International\".equals(generalinformation.getTargetpopulation()) %>">International</aui:option>
					<aui:option value="not specified" selected="<%=\"not specified\".equals(generalinformation.getTargetpopulation()) %>">not specified</aui:option>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="biomaterialprepared" />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="origionofcollection" />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="useofcollection" />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="associateddataavailable" />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="imagingavailable" />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="theregistrybiobanksislistedinotherinventoriesnetworks" />
			</aui:column>
		</aui:layout>
		<liferay-ui:input-editor />
		<input name="<portlet:namespace />htmlCodeFromEditorPlacedHere" type="hidden" value="" />
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>

<aui:script use="event, node, event-valuechange, click">
	AUI().use('aui-io-request', 'event-valuechange', 'node', function(A){
		var nodeObject = A.all('.typeofhosteinstitue');
		nodeObject.on('valuechange', function(event){
			alert("1234 " + nodeObject.get('value'));
		});
	});
</aui:script>

<script type="text/javascript">
            function <portlet:namespace />initEditor() {
                        return '<font style="font-weight: bold">' + <%= generalinformation.getDescription() %> + '</font>';
            }

            function <portlet:namespace />extractCodeFromEditor() {
                        var x = document.<portlet:namespace />fm.<portlet:namespace />htmlCodeFromEditorPlacedHere.value = window.<portlet:namespace />editor.getHTML();
 
                        alert(x);
            }
</script>
