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

String ddlname = "core";

long organizationId = 0;
Organization organization = null;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	organizationId = currentGroup.getClassPK();
  	organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
  	// Test Code
  	//organizationId = themeDisplay.getSiteGroupId();
  	
  	DDLRecord core_record = null;
  	long recordSetId = 0;
  	
  	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
  		if(rdc_rsname.equalsIgnoreCase(ddlname)) {
  			recordSetId = rdc_rs.getRecordSetId();
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				core_record = record;
  			}
  		}
  	}
  	
  	if(false) {
	  	Map<String, Map<String, String>> fieldmap = null;
		fieldmap = DDLRecordSetLocalServiceUtil.getDDLRecordSet(recordSetId).getDDMStructure().getFieldsMap();
	  	
	  	HashMap<String, LinkedHashMap<String, String>> field_options = new HashMap<String, LinkedHashMap<String, String>>();
	  	for(String key_options : fieldmap.keySet()) {
	  		%>
	  		<%= key_options %><br />
	  		<%
	  		for(String key_options2 : fieldmap.get(key_options).keySet()) {
	  			%>
	  	  		&nbsp;&nbsp;&nbsp;-&nbsp;<%= key_options2 %> - <%= fieldmap.get(key_options).get(key_options2) %><br />
	  	  		<%
	  		}
	  	}
  	}
  	
  	if(core_record != null) {
		%>
		
		<c:choose>
			<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_add_diseasematrix) %>">		
				<portlet:renderURL var="EditDDLCoreURL">
					<portlet:param name="mvcPath" value="/html/staticddl/regstaticddl/regstaticddl_edit.jsp" />
					<portlet:param name="recordId" value="<%= Long.toString(core_record.getRecordId()) %>" />
					<portlet:param name="recordSetId" value="<%= Long.toString(recordSetId) %>" />
					<portlet:param name="organizationId" value="<%= Long.toString(organizationId) %>" />
					<portlet:param name="redirect" value="<%= redirect %>" />
				</portlet:renderURL>
				<div style="position: relative;width: 100%;">
					<div style="width:30px;height: 30px;position:absolute;right:25px;top: -55px;z-index: 400;">
						<aui:a href="<%= EditDDLCoreURL.toString() %>"><img src='<%= request.getContextPath() + "/images/editorange.png" %>' style="width:15px;height: 15px;" /></aui:a>
					</div>
				</div>
			</c:when>
		</c:choose>
		
		<%
		String ontologies = "";
		if(core_record.getFieldValue("Ontologies") != null) {
			if(!core_record.getFieldValue("Ontologies").toString().contains("not specified")) {
				ontologies = core_record.getFieldValue("Ontologies").toString().replaceAll("\"\\]|\\[\"", "").replaceAll("\",\"", ",<br>");
				if(core_record.getFieldValue("Additional_Ontologies") != null) {
					if(!core_record.getFieldValue("Additional_Ontologies").toString().equalsIgnoreCase("")) {
						ontologies += "<br />  Additional Ontologies: " + core_record.getFieldValue("Additional_Ontologies");
					}
				}
			}
		}
		
		String images_available = "";
		if(core_record.getFieldValue("Imaging_available") != null) {
			if(!core_record.getFieldValue("Imaging_available").toString().contains("not specified")) {
				images_available = core_record.getFieldValue("Imaging_available").toString().replaceAll("\"\\]|\\[\"|\\[|\\]", "").replaceAll("\",\"", ",<br>");
				if(core_record.getFieldValue("Additional_Imaging_available") != null) {
					if(!core_record.getFieldValue("Additional_Imaging_available").toString().equalsIgnoreCase("")) {
						images_available += "<br />  Additional Imaging Data available: " + core_record.getFieldValue("Additional_Imaging_available");
					}
				}
			}
		}
		
		String year_of_establishment = "";
		if(core_record.getFieldValue("year_of_establishment") != null) {
			year_of_establishment = core_record.getFieldValue("year_of_establishment").toString();
		}
		
		String host_institution_is_a = "";
		if(core_record.getFieldValue("Host_institution_is_a") != null) {
			host_institution_is_a = core_record.getFieldValue("Host_institution_is_a").toString().replaceAll("\"\\]|\\[\"", "").replaceAll("\",\"", ",<br>");
			if(host_institution_is_a.contains("not specified")) {
				host_institution_is_a  = "";
			}
			if(host_institution_is_a.contains("Other - please specify")) {
				if(core_record.getFieldValue("Type_of_host_institution") != null) {
					host_institution_is_a  = core_record.getFieldValue("Type_of_host_institution").toString();
				}
			}
		}
		
		String source_of_funding = "";
		if(core_record.getFieldValue("Source_of_funding") != null) {
			source_of_funding = core_record.getFieldValue("Source_of_funding").toString().replaceAll("\"\\]|\\[\"", "").replaceAll("\",\"", ",<br>");
			if(source_of_funding.contains("not specified")) {
				source_of_funding  = "";
			}
			if(source_of_funding.contains("Other - please specify")) {
				if(core_record.getFieldValue("Text5085") != null) {
					source_of_funding  = core_record.getFieldValue("Text5085").toString();
				}
			}
		}
		
		String  acronym = "";
		if(core_record.getFieldValue("acronym") != null) {
			acronym = core_record.getFieldValue("acronym").toString();
			if(!acronym.equalsIgnoreCase("")) {
				acronym = " - (" + acronym + ")";
			}
		}
		
		String target_population = "";
		if(core_record.getFieldValue("Target_population_of_the_registry") != null) {
			target_population = core_record.getFieldValue("Target_population_of_the_registry").toString().replaceAll("\"\\]|\\[\"", "").replaceAll("\",\"", ", ");
		}
		
		String listedin = "";
		if(core_record.getFieldValue("The_registry_biobanks_is_listed_in_other_inventories_networks") != null) {
			listedin = core_record.getFieldValue("The_registry_biobanks_is_listed_in_other_inventories_networks").toString().replaceAll("\"\\]|\\[\"", "").replaceAll("\",\"", ",<br>").replaceAll("\\]|\\[", "");
			if(core_record.getFieldValue("Additional_networks_inventories") != null) {
				if(!core_record.getFieldValue("Additional_networks_inventories").toString().equalsIgnoreCase("")) {
					listedin.replaceAll("none", "").replaceAll("not specified", "");
				}
				listedin += "<br>" + core_record.getFieldValue("Additional_networks_inventories");
			}
		}
		
		String discription = "";
		if(core_record.getFieldValue("Description") != null) {
			discription = core_record.getFieldValue("Description").toString().replaceAll("\"\\]|\\[\"", "");
		}
		%>
		
		<h4><%= organization.getName() %><%= acronym %></h4>
		
		<table>
		<tr><td style="vertical-align: top;">Type of Host Institution: </td><td><strong><%= host_institution_is_a %> </strong></td></tr>
		<tr><td style="vertical-align: top;">Source of funding: </td><td><strong><%= source_of_funding %></strong></td></tr>
		<tr><td style="vertical-align: top;">Target population: </td><td><strong><%= target_population %> </strong></td></tr>
		<tr><td style="vertical-align: top;">Year of establishment: </td><td><strong><%= year_of_establishment %> </strong></td></tr>
		<tr><td style="vertical-align: top;">Ontologies used: </td><td><strong><%= ontologies %> </strong></td></tr>
		<tr><td style="vertical-align: top;">Imaging available: </td><td><strong><%= images_available %> </strong></td></tr>
		<tr><td style="vertical-align: top;">Also listed in: </td><td><strong><%= listedin %> </strong></td></tr>
		</table>
		<%= discription %> <br />
		
		<%
  	}
}
%>
	
