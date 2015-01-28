<%@ include file="/html/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);	
// Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_add_diseasematrix = "EDIT_DDL";

String ddlname = GetterUtil.getString(portletPreferences.getValue("optionsDDLName", ""));

long organizationId = 0;
Organization organization = null;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	organizationId = currentGroup.getClassPK();
  	organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
  	
  	DDLRecord ddl_record = null;
  	DDLRecordSet recordSet = null;
  	long recordSetId = 0;
  	
  	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
  		if(rdc_rsname.equalsIgnoreCase(ddlname)) {
  			recordSetId = rdc_rs.getRecordSetId();
  			recordSet = rdc_rs;
  			List<DDLRecord> records = rdc_rs.getRecords();
  			for(DDLRecord record : records) {
  				ddl_record = record;
  			}
  		}
  	}
  	if(ddl_record != null && permissionChecker.hasPermission(groupId, name, primKey, actionId_add_diseasematrix)) {
  		
  		// Get all options for fields
  		Map<String, Map<String, String>> fieldmap_options = null;
  		fieldmap_options = DDLRecordSetLocalServiceUtil.getDDLRecordSet(recordSetId).getDDMStructure().getTransientFieldsMap(themeDisplay.getLocale().toString());
  		
  		HashMap<String, LinkedHashMap<String, String>> field_options = new HashMap<String, LinkedHashMap<String, String>>();
  	  	for(String key_options : fieldmap_options.keySet()) {
  	  		String ddlfield = fieldmap_options.get(key_options).get("_parentName_");
  	  		if(!field_options.containsKey(ddlfield)) {
  	  			field_options.put(ddlfield, new LinkedHashMap<String, String>());
  	  		}
  	  		field_options.get(ddlfield).put(fieldmap_options.get(key_options).get("value"), fieldmap_options.get(key_options).get("label"));
  	  	}
  		
		DDMStructure ddmStructure = recordSet.getDDMStructure();
		Fields fields = ddl_record.getFields();
		%>
		<portlet:actionURL name="updateDDLValues" var="updateDDLValuesURL" windowState="normal" />
		<aui:form action="<%= updateDDLValuesURL %>" method="POST" name="fm">
			<aui:fieldset>
				<%
				Map<String, Map<String, String>> fieldmap = ddmStructure.getFieldsMap();
				for(String fieldname : fieldmap.keySet()) {
					if(fieldname.equalsIgnoreCase("_fieldsDisplay")) {
						continue;
					}
					if(fieldmap.get(fieldname).get("type").equalsIgnoreCase("select") && fieldmap.get(fieldname).get("multiple").equalsIgnoreCase("true")) {
						String fieldvalue = "";
						if(ddl_record.getFieldValue(fieldname) != null) {
							fieldvalue = ddl_record.getFieldValue(fieldname).toString();
						}
						%>
						<aui:select name="Imaging_available" label="Imaging available" multiple="true"  showEmptyOption="true">
							<% 
							for(String option : field_options.get("Imaging_available").keySet()) {
								%>
								<aui:option selected='<%= fieldvalue.contains(option) %>' value="<%= option %>"><liferay-ui:message key='<%= field_options.get("Imaging_available").get(option) %>' /></aui:option>
								<%
							}
							%>
						</aui:select>
						<%
					}
					//ADD IF WITH FIELDS
		
				}
				%>
			</aui:fieldset>
			<aui:button-row>
				<aui:button type="submit" />
				<aui:button type="cancel"  onClick="<%= redirect %>" />
			</aui:button-row>
		</aui:form>
		<%
  	}
}
%>