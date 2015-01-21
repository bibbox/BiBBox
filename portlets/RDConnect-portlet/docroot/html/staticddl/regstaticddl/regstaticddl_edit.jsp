<%@ include file="/html/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);	
// Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_add_diseasematrix = "EDIT_CORE";

if(permissionChecker.hasPermission(groupId, name, primKey, actionId_add_diseasematrix)) {
	long recordId = ParamUtil.getLong(request, "recordId");
	DDLRecord ddlrecord = DDLRecordLocalServiceUtil.getRecord(recordId);
	
	String host_institute = ddlrecord.getFieldValue("Host_institution_is_a").toString();
	String displayclass = "";
	%>
	<portlet:actionURL name="updateCoreDDL" var="updateCoreDDLURL" windowState="normal" />
	<aui:form action="<%= updateCoreDDLURL %>" method="POST" name="fm">
		<aui:fieldset>
			<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
			<aui:input type="hidden" name="recordId" value='<%=String.valueOf(recordId) %>'/>
			<aui:input type="text" name="acronym" label="Acronym" value='<%= ddlrecord.getFieldValue("acronym") %>' />
			<aui:input type="textarea" name="Description" label="Description" value='<%= ddlrecord.getFieldValue("Description") %>' />
			<aui:input type="text" name="Hoste_institute" label="Hoste institute" value='<%= ddlrecord.getFieldValue("Hoste_institute") %>' />
			<aui:select name="Host_institution_is_a" label="Type of host institution" >
				<aui:option selected='<%= host_institute.contains("Regional Authority") %>' value="Regional Authority"><liferay-ui:message key="Regional Authority" /></aui:option>
				<aui:option selected='<%= host_institute.contains("National Authority") %>' value="National Authority"><liferay-ui:message key="National Authority" /></aui:option>
				<aui:option selected='<%= host_institute.contains("University/Research Institute") %>' value="University/Research Institute"><liferay-ui:message key="University/Research Institute" /></aui:option>
				<aui:option selected='<%= host_institute.contains("Hospital") %>' value="Hospital"><liferay-ui:message key="Hospital" /></aui:option>
				<aui:option selected='<%= host_institute.contains("Patient\'s Association") %>' value="Patient's Association"><liferay-ui:message key="Patient's Association" /></aui:option>
				<aui:option selected='<%= host_institute.contains("Foundation") %>' value="Foundation"><liferay-ui:message key="Foundation" /></aui:option>
				<aui:option selected='<%= host_institute.contains("Industry/Industrial Association") %>' value="Industry/Industrial Association"><liferay-ui:message key="Industry/Industrial Association" /></aui:option>
				<aui:option selected='<%= host_institute.contains("EU Commission/EU Agency") %>' value="EU Commission/EU Agency"><liferay-ui:message key="EU Commission/EU Agency" /></aui:option>
				<aui:option selected='<%= host_institute.contains("No specific funds") %>' value="No specific funds"><liferay-ui:message key="No specific funds" /></aui:option>
				<aui:option selected='<%= host_institute.contains("Other - please specify") %>' value="Other - please specify"><liferay-ui:message key="Other - please specify" /></aui:option>
				<aui:option selected='<%= host_institute.contains("not specified") %>' value="not specified"><liferay-ui:message key="not specified" /></aui:option>
			</aui:select>
			<%
			displayclass = "notdisplayInput";
			if(host_institute.contains("Other - please specify")) {
				displayclass = "notdisplayInput";
			}
			%>
			<div id="Type_of_host_institution_display" class="<%= displayclass %>">
				<aui:input type="text" name="Type_of_host_institution" label="Other specific host institution type" value='<%= ddlrecord.getFieldValue("Type_of_host_institution") %>' />
			</div>
			<aui:input type="text" name="Text5085" label="Source of funding" value='<%= ddlrecord.getFieldValue("Text5085") %>' />
			<%
			String target_population_of_the_registry = ddlrecord.getFieldValue("Target_population_of_the_registry").toString();
			%>
			<aui:select name="Target_population_of_the_registry" label="Target population of the registry" >
				<aui:option selected='<%= target_population_of_the_registry.contains("Local") %>' value="Local"><liferay-ui:message key="Local (i.e.: Hospital, Primary healthcare centre,...)" /></aui:option>
				<aui:option selected='<%= target_population_of_the_registry.contains("Regional") %>' value="Regional"><liferay-ui:message key="Regional" /></aui:option>
				<aui:option selected='<%= target_population_of_the_registry.contains("National") %>' value="National"><liferay-ui:message key="National" /></aui:option>
				<aui:option selected='<%= target_population_of_the_registry.contains("International") %>' value="International"><liferay-ui:message key="International" /></aui:option>
				<aui:option selected='<%= target_population_of_the_registry.contains("not specified") %>' value="not specified"><liferay-ui:message key="Not specified" /></aui:option>
			</aui:select>
			<aui:input type="text" name="year_of_establishment" label="Year of establishment" value='<%= ddlrecord.getFieldValue("year_of_establishment") %>' />
			<%
			String ontologies = ddlrecord.getFieldValue("Ontologies").toString();
			%>
			<aui:select name="Ontologies" label="Ontologies" >
				<aui:option selected='<%= ontologies.contains("Human Phenotype Ontology (HPO)") %>' value="Human Phenotype Ontology (HPO)"><liferay-ui:message key="Human Phenotype Ontology (HPO)" /></aui:option>
				<aui:option selected='<%= ontologies.contains("Clinical measurement Ontology (CMO)") %>' value="Clinical measurement Ontology (CMO)"><liferay-ui:message key="Clinical measurement Ontology (CMO)" /></aui:option>
				<aui:option selected='<%= ontologies.contains("Symptoms Ontology  (SYMP)") %>' value="Symptoms Ontology  (SYMP)"><liferay-ui:message key="Symptoms Ontology (SYMP)" /></aui:option>
				<aui:option selected='<%= ontologies.contains("Clinical Traditional Medicine Signs and Symptoms Value Set (TM-SIGNS-AND-SYMPTS)") %>' value="Clinical Traditional Medicine Signs and Symptoms Value Set (TM-SIGNS-AND-SYMPTS)"><liferay-ui:message key="Clinical Traditional Medicine Signs and Symptoms Value Set (TM-SIGNS-AND-SYMPTS)" /></aui:option>
				<aui:option selected='<%= ontologies.contains("Signs and Symptoms Ontology (CSSO)") %>' value="Signs and Symptoms Ontology (CSSO)"><liferay-ui:message key="Signs and Symptoms Ontology (CSSO)" /></aui:option>
				<aui:option selected='<%= ontologies.contains("none") %>' value="noned"><liferay-ui:message key="None" /></aui:option>
				<aui:option selected='<%= ontologies.contains("not specified") %>' value="not specified"><liferay-ui:message key="Not specified" /></aui:option>
			</aui:select>
			<aui:input type="text" name="Additional_Ontologies" label="Additional Ontologies" value='<%= ddlrecord.getFieldValue("Additional_Ontologies") %>' />
			<%
			String associated_data_available = ddlrecord.getFieldValue("Associated_data_available").toString();
			%>
			<aui:select name="Associated_data_available" label="Associated data available" multiple="true">
				<aui:option selected='<%= associated_data_available.contains("Clinical") %>' value="Clinical"><liferay-ui:message key="Clinical" /></aui:option>
				<aui:option selected='<%= associated_data_available.contains("Molecular") %>' value="Molecular"><liferay-ui:message key="Molecular" /></aui:option>
				<aui:option selected='<%= associated_data_available.contains("other") %>' value="other"><liferay-ui:message key="Other (please specify)" /></aui:option>
				<aui:option selected='<%= associated_data_available.contains("None") %>' value="None"><liferay-ui:message key="None" /></aui:option>
				<aui:option selected='<%= associated_data_available.contains("Not specified") %>' value="Not specified"><liferay-ui:message key="Not specified" /></aui:option>
			</aui:select>
			<aui:input type="text" name="Additional_Associated_data_available" label="Additional Associated data available" value='<%= ddlrecord.getFieldValue("Additional_Associated_data_available") %>' />
			<%
			String imaging_available = ddlrecord.getFieldValue("Imaging_available").toString();
			%>
			<aui:select name="Imaging_available" label="Imaging available" multiple="true">
				<aui:option selected='<%= imaging_available.contains("Histopathology/digital microscopy") %>' value="Histopathology/digital microscopy"><liferay-ui:message key="Histopathology/digital microscopy" /></aui:option>
				<aui:option selected='<%= imaging_available.contains("MRI") %>' value="MRI"><liferay-ui:message key="MRI" /></aui:option>
				<aui:option selected='<%= imaging_available.contains("PET/CT") %>' value="PET/CT"><liferay-ui:message key="PET/CT" /></aui:option>
				<aui:option selected='<%= imaging_available.contains("Photo") %>' value="Photo"><liferay-ui:message key="Photo" /></aui:option>
				<aui:option selected='<%= imaging_available.contains("X-Ray") %>' value="X-Ray"><liferay-ui:message key="X-Ray" /></aui:option>
				<aui:option selected='<%= imaging_available.contains("none") %>' value="none"><liferay-ui:message key="None" /></aui:option>
				<aui:option selected='<%= imaging_available.contains("not specified") %>' value="not specified"><liferay-ui:message key="Not specified" /></aui:option>
			</aui:select>
			<aui:input type="text" name="Additional_Imaging_available" label="Additional Imaging available" value='<%= ddlrecord.getFieldValue("Additional_Imaging_available") %>' />
			<%
			String the_registry_biobanks_is_listed_in_other_inventories_networks = ddlrecord.getFieldValue("The_registry_biobanks_is_listed_in_other_inventories_networks").toString();
			%>
			<aui:select name="The_registry_biobanks_is_listed_in_other_inventories_networks" label="The registry is listed in other inventories/networks" multiple="true">
				<aui:option selected='<%= the_registry_biobanks_is_listed_in_other_inventories_networks.contains("Orphanet") %>' value="Orphanet"><liferay-ui:message key="Orphanet" /></aui:option>
				<aui:option selected='<%= the_registry_biobanks_is_listed_in_other_inventories_networks.contains("BBMRI") %>' value="BBMRI"><liferay-ui:message key="BBMRI" /></aui:option>
				<aui:option selected='<%= the_registry_biobanks_is_listed_in_other_inventories_networks.contains("RD-HUB") %>' value="RD-HUB"><liferay-ui:message key="RD-HUB" /></aui:option>
				<aui:option selected='<%= the_registry_biobanks_is_listed_in_other_inventories_networks.contains("GRDR") %>' value="GRDR"><liferay-ui:message key="GRDR" /></aui:option>
				<aui:option selected='<%= the_registry_biobanks_is_listed_in_other_inventories_networks.contains("TREAT-NMD") %>' value="TREAT-NMD"><liferay-ui:message key="TREAT-NMD" /></aui:option>
				<aui:option selected='<%= the_registry_biobanks_is_listed_in_other_inventories_networks.contains("none") %>' value="none"><liferay-ui:message key="None" /></aui:option>
				<aui:option selected='<%= the_registry_biobanks_is_listed_in_other_inventories_networks.contains("not specified") %>' value="not specified"><liferay-ui:message key="Not specified" /></aui:option>
			</aui:select>
			<aui:input type="text" name="Additional_networks_inventories" label="Additional networks/inventories" value='<%= ddlrecord.getFieldValue("Additional_networks_inventories") %>' />
		</aui:fieldset>
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel"  onClick="<%= redirect %>" />
		</aui:button-row>
	</aui:form>
	
	<%
}
%>
<aui:script use="node,change">
AUI().use('aui-base', function(A){
	A.one("#<portlet:namespace/>Host_institution_is_a").on('change',function(){
		var inputObject=A.one("#<portlet:namespace/>Host_institution_is_a");
		if(inputObject.get('value') == "Other - please specify") {
			A.one("#Additional_Associated_data_available_display").removeClass('notdisplayInput');
			//alert(inputObject.get('value'));
		} else {
			A.one("#Additional_Associated_data_available_display").addClass('notdisplayInput');
			//alert("Hide");
		}
	});
});
</aui:script>
