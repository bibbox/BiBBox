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
  	// Test Code
  	//organizationId = themeDisplay.getSiteGroupId();
  	
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
  	if(ddl_record != null) {
		%>
		
		<c:choose>
			<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_add_diseasematrix) %>">		
				<portlet:renderURL var="EditDDLCoreURL">
					<portlet:param name="mvcPath" value="/html/staticddl/dynamicddldisplay/dynamicddldisplay_edit.jsp" />
					<portlet:param name="recordId" value="<%= Long.toString(ddl_record.getRecordId()) %>" />
					<portlet:param name="recordSetId" value="<%= Long.toString(recordSetId) %>" />
					<portlet:param name="organizationId" value="<%= Long.toString(organizationId) %>" />
					<portlet:param name="redirect" value="<%= redirect %>" />
				</portlet:renderURL>
				<div style="position: relative;width: 100%;">
					<div style="width:30px;height: 30px;position:absolute;right:25px;top: -55px;z-index: 400;">
						<aui:a href="<%= EditDDLCoreURL.toString() %>"><img src='<%= request.getContextPath() + "/images/edit_green.png" %>' style="width:20px;height: 20px;" /></aui:a>
					</div>
				</div>
			</c:when>
		</c:choose>
		
		<table>
		<%
		DDMStructure ddmStructure = recordSet.getDDMStructure();
		Fields fields = ddl_record.getFields();//DDMUtil.getFields(recordSet.getDDMStructureId(), serviceContext);
		
		Map<String, Map<String, String>> fieldmap = ddmStructure.getFieldsMap();
		for(String fieldname : fieldmap.keySet()) {
			if(fieldname.equalsIgnoreCase("_fieldsDisplay")) {
				continue;
			}
			// Label td
			%>
			<tr><td>
			<%= fieldmap.get(fieldname).get("label") %>
			</td>
			<%
			// Add if clause here for spliting depending on Fieldtype
			String fieldvalue = "";
			if(ddl_record.getFieldValue(fieldname) != null) {
				fieldvalue = ddl_record.getFieldValue(fieldname).toString().replaceAll("\"\\]|\\[\"|\\[|\\]", "").replaceAll("\",\"", ",<br>");
			}
			%>
			<td>
			<strong><%=fieldvalue %></strong>
			</td>
			<%
			
		}
		%>
		</table>
		<%
  	}
}
	%>
	
	
	
