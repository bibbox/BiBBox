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

String ddlname = "reg_core";

long organizationId = 0;
/*Organization organization = null;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	organizationId = currentGroup.getClassPK();*/
  	// Test Code
  	organizationId = themeDisplay.getSiteGroupId();
  	
  	DDLRecord core_record = null;
  	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organizationId);
  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
  		
  		
  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
  		if(rdc_rsname.equalsIgnoreCase(ddlname)) {
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				core_record = record;
  			}
  		}
  	}
	%>
	
	<c:choose>
		<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_add_diseasematrix) %>">
			<aui:button-row>
			<portlet:renderURL var="addDiseaseMatrixURL">
				<portlet:param name="mvcPath" value="/html/staticddl/regstaticddl/regstaticddl_edit.jsp" />
				<portlet:param name="recordId" value="<%= Long.toString(core_record.getRecordId()) %>" />
				<portlet:param name="redirect" value="<%= redirect %>" />
			</portlet:renderURL>
				<aui:button value="add-diseasematrix" onClick="<%= addDiseaseMatrixURL.toString() %>"/>
		</aui:button-row>
		</c:when>
	</c:choose>
	
	<%
	String ontologies = "";
	if(!core_record.getFieldValue("Ontologies").toString().contains("not specified")) {
		ontologies = core_record.getFieldValue("Ontologies").toString();
		if(!core_record.getFieldValue("Additional_Ontologies").toString().equalsIgnoreCase("")) {
			ontologies += "<br />  Additional Ontologies: " + core_record.getFieldValue("Additional_Ontologies");
		}
	}
	
	String images_available = "";
	if(!core_record.getFieldValue("Imaging_available").toString().contains("not specified")) {
		images_available = core_record.getFieldValue("Imaging_available").toString();
		if(!core_record.getFieldValue("Additional_Imaging_available").toString().equalsIgnoreCase("")) {
			images_available += "<br />  Additional Imaging Data available: " + core_record.getFieldValue("Additional_Imaging_available");
		}
	}
	
	String year_of_establishment = "";
	if(core_record.getFieldValue("year_of_establishment") != null) {
		year_of_establishment = core_record.getFieldValue("year_of_establishment").toString();
	}
	
	String host_institution_is_a = core_record.getFieldValue("Host_institution_is_a").toString();
	if(host_institution_is_a.contains("not specified")) {
		host_institution_is_a  = "";
	}
	%>
	
	<h4>organization.getName() - (<%= core_record.getFieldValue("acronym") %>)</h4>
	
	Type of Host Institution: <%= host_institution_is_a %> <br />
	Source of funding: <%= core_record.getFieldValue("Text5085") %> <br />
	Target population: <%= core_record.getFieldValue("Target_population_of_the_registry") %> <br />
	Year of establishment: <%= year_of_establishment %> <br />
	Ontologies used: <%= ontologies %> <br />
	Imaging available: <%= images_available %> <br />
	Also listed in: <%= core_record.getFieldValue("Additional_networks_inventories") %> <br />
	<%= core_record.getFieldValue("Description") %> <br />
	
	<%
//}
%>
	
