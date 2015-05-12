<%@ include file="/html/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String redirect = ParamUtil.getString(request, "redirect");	
// Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_add_diseasematrix = "EDIT_CORE";

if(permissionChecker.hasPermission(groupId, name, primKey, actionId_add_diseasematrix)) {
	long recordId = ParamUtil.getLong(request, "recordId");
	long recordSetId = ParamUtil.getLong(request, "recordSetId");
	long organizationId = ParamUtil.getLong(request, "organizationId");
	DDLRecord ddlrecord = DDLRecordLocalServiceUtil.getRecord(recordId);
	
	// Get all options for fields
	Map<String, Map<String, String>> fieldmap = null;
	fieldmap = DDLRecordSetLocalServiceUtil.getDDLRecordSet(recordSetId).getDDMStructure().getTransientFieldsMap(themeDisplay.getLocale().toString());
	
	HashMap<String, LinkedHashMap<String, String>> field_options = new HashMap<String, LinkedHashMap<String, String>>();
  	for(String key_options : fieldmap.keySet()) {
  		String ddlfield = fieldmap.get(key_options).get("_parentName_");
  		if(!field_options.containsKey(ddlfield)) {
  			field_options.put(ddlfield, new LinkedHashMap<String, String>());
  		}
  		field_options.get(ddlfield).put(fieldmap.get(key_options).get("value"), fieldmap.get(key_options).get("label"));
  	}
	
  	String host_institute = "";
  	if(ddlrecord.getFieldValue("Host_institution_is_a") != null) {
		host_institute = ddlrecord.getFieldValue("Host_institution_is_a").toString();
  	}
	String displayclass = "";
	%>
	<portlet:actionURL name="updateCoreDDL" var="updateCoreDDLURL" windowState="normal" />
	<aui:form action="<%= updateCoreDDLURL %>" method="POST" name="fm">
		<aui:fieldset>
			<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
			<aui:input type="hidden" name="recordId" value='<%=String.valueOf(recordId) %>'/>
			<aui:input type="hidden" name="recordSetId" value='<%=String.valueOf(recordSetId) %>'/>
			<aui:input type="hidden" name="organizationId" value='<%=String.valueOf(organizationId) %>'/>
			<aui:input type="text" name="acronym" label="Acronym" value='<%= ddlrecord.getFieldValue("acronym") %>' />
			<aui:field-wrapper label="Description">
			    <liferay-ui:input-editor name="Description" toolbarSet="liferay-article" initMethod="initEditor" width="200" />
			    <script type="text/javascript">
			        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(ddlrecord.getFieldValue("Description").toString().replaceAll("\"\\]|\\[\"", "")) %>"; }
			    </script>
			</aui:field-wrapper>
			<!-- Host Institute -->
			<aui:select name="Host_institution_is_a" label="Type of host institution" >
				<% 
				for(String option : field_options.get("Host_institution_is_a").keySet()) {
					%>
					<aui:option selected='<%= host_institute.contains(option) %>' value="<%= option %>"><liferay-ui:message key='<%= field_options.get("Host_institution_is_a").get(option) %>' /></aui:option>
					<%
				}
				%>
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
			<!-- Source of Funding -->
			<%
			String source_of_funding = "";
			if(ddlrecord.getFieldValue("Source_of_funding") != null) {
				source_of_funding = ddlrecord.getFieldValue("Source_of_funding").toString();
		  	}
			%>
			<aui:select name="Source_of_funding" label='Source of funding' >
				<% 
				for(String option : field_options.get("Source_of_funding").keySet()) {
					%>
					<aui:option selected='<%= source_of_funding.contains(option) %>' value="<%= option %>"><liferay-ui:message key='<%= field_options.get("Source_of_funding").get(option) %>' /></aui:option>
					<%
				}
				%>
			</aui:select>
			<%
			displayclass = "notdisplayInput";
			if(source_of_funding.contains("Other - please specify")) {
				displayclass = "notdisplayInput";
			}
			%>
			<div id="Source_of_funding_display" class="<%= displayclass %>">
				<aui:input type="text" name="Text5085" label='Other specific source of funding' value='<%= ddlrecord.getFieldValue("Text5085") %>' />
			</div>
			<!-- Target Country -->
			<%
			String[] countrylist = CandidateLocalServiceUtil.getCountryNames();
			String targetcountry = "";
			if(ddlrecord.getFieldValue("countryCode") != null) {
				targetcountry = ddlrecord.getFieldValue("countryCode").toString();
			}
			%>
			<aui:select name="countryCode" label="Target Country" >
				<% 
				for(String option : countrylist) {
					if(option.equalsIgnoreCase("all")) {
						option = "International";
					}
					%>
					<aui:option selected='<%= targetcountry.contains(option) %>' value="<%= option %>"><liferay-ui:message key='<%= option %>' /></aui:option>
					<%
				}
				%>
			</aui:select>
			<!-- Target Population -->
			<%
			String target_population_of_the_registry = "";
			if(ddlrecord.getFieldValue("Target_population_of_the_registry") != null) {
				target_population_of_the_registry = ddlrecord.getFieldValue("Target_population_of_the_registry").toString();
			}
			%>
			<aui:select name="Target_population_of_the_registry" label="Target population of the registry" >
				<% 
				for(String option : field_options.get("Target_population_of_the_registry").keySet()) {
					%>
					<aui:option selected='<%= target_population_of_the_registry.contains(option) %>' value="<%= option %>"><liferay-ui:message key='<%= field_options.get("Target_population_of_the_registry").get(option) %>' /></aui:option>
					<%
				}
				%>
			</aui:select>
			<aui:input type="text" name="year_of_establishment" label="Year of establishment" value='<%= ddlrecord.getFieldValue("year_of_establishment") %>' />
			<%
			String ontologies = "";
			if(ddlrecord.getFieldValue("Ontologies") != null) {
				ontologies = ddlrecord.getFieldValue("Ontologies").toString();
			}
			%>
			<aui:select name="Ontologies" label="Ontologies" >
				<% 
				for(String option : field_options.get("Ontologies").keySet()) {
					%>
					<aui:option selected='<%= ontologies.contains(option) %>' value="<%= option %>"><liferay-ui:message key='<%= field_options.get("Ontologies").get(option) %>' /></aui:option>
					<%
				}
				%>
			</aui:select>
			<aui:input type="text" name="Additional_Ontologies" label="Additional Ontologies" value='<%= ddlrecord.getFieldValue("Additional_Ontologies") %>' />
			<%
			String associated_data_available = "";
			if(ddlrecord.getFieldValue("Associated_data_available") != null) {
				associated_data_available = ddlrecord.getFieldValue("Associated_data_available").toString();
			}
			%>
			<aui:select name="Associated_data_available" label="Associated data available" multiple="true" >
				<% 
				for(String option : field_options.get("Associated_data_available").keySet()) {
					%>
					<aui:option selected='<%= associated_data_available.contains(option) %>' value="<%= option %>"><liferay-ui:message key='<%= field_options.get("Associated_data_available").get(option) %>' /></aui:option>
					<%
				}
				%>
			</aui:select>
			<aui:input type="text" name="Additional_Associated_data_available" label="Additional Associated data available" value='<%= ddlrecord.getFieldValue("Additional_Associated_data_available") %>' />
			<%
			String imaging_available = "";
			if(ddlrecord.getFieldValue("Imaging_available") != null) {
				imaging_available = ddlrecord.getFieldValue("Imaging_available").toString();
			}
			%>
			<aui:select name="Imaging_available" label="Imaging available" multiple="true" >
				<% 
				for(String option : field_options.get("Imaging_available").keySet()) {
					%>
					<aui:option selected='<%= imaging_available.contains(option) %>' value="<%= option %>"><liferay-ui:message key='<%= field_options.get("Imaging_available").get(option) %>' /></aui:option>
					<%
				}
				%>
			</aui:select>
			<aui:input type="text" name="Additional_Imaging_available" label="Additional Imaging available" value='<%= ddlrecord.getFieldValue("Additional_Imaging_available") %>' />
			<%
			String the_registry_biobanks_is_listed_in_other_inventories_networks = "";
			if(ddlrecord.getFieldValue("The_registry_biobanks_is_listed_in_other_inventories_networks") != null) {
				the_registry_biobanks_is_listed_in_other_inventories_networks = ddlrecord.getFieldValue("The_registry_biobanks_is_listed_in_other_inventories_networks").toString();
			}
			%>
			<aui:select name="The_registry_biobanks_is_listed_in_other_inventories_networks" label="The registry is listed in other inventories/networks" multiple="true"  >
				<% 
				for(String option : field_options.get("The_registry_biobanks_is_listed_in_other_inventories_networks").keySet()) {
					%>
					<aui:option selected='<%= the_registry_biobanks_is_listed_in_other_inventories_networks.contains(option) %>' value="<%= option %>"><liferay-ui:message key='<%= field_options.get("The_registry_biobanks_is_listed_in_other_inventories_networks").get(option) %>' /></aui:option>
					<%
				}
				%>
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
			A.one("#Type_of_host_institution_display").removeClass('notdisplayInput');
			//alert(inputObject.get('value'));
		} else {
			//alert("Hide");
			A.one("#Type_of_host_institution_display").addClass('notdisplayInput');
			
		}
	});
});
</aui:script>
<aui:script use="node,change">
AUI().use('aui-base', function(A){
	A.one("#<portlet:namespace/>Source_of_funding").on('change',function(){
		var inputObject=A.one("#<portlet:namespace/>Source_of_funding");
		if(inputObject.get('value') == "Other - please specify") {
			A.one("#Source_of_funding_display").removeClass('notdisplayInput');
			//alert(inputObject.get('value'));
		} else {
			//alert("Hide");
			A.one("#Source_of_funding_display").addClass('notdisplayInput');
			
		}
	});
});
</aui:script>
