<%@page import="at.graz.meduni.liferay.portlet.bibbox.service.persistence.DDLConfigurationPersistence"%>
<%@ include file="/html/ddl/init.jsp" %>  

<portlet:defineObjects />
<liferay-theme:defineObjects />


<%
List<DDMStructure> ddm_structures = DDMStructureLocalServiceUtil.getStructures(themeDisplay.getCompanyGroupId());
int ddlcount = 0;
for(DDMStructure ddm_structure : ddm_structures) { 
	if(ddm_structure.getClassName().equals("com.liferay.portlet.dynamicdatalists.model.DDLRecordSet")) {
		%>
		<hr>
		<%= ddm_structure.getStructureId() %> - <%= ddm_structure.getNameCurrentValue() %><br>
		<%
		Map<String, Map<String, String>> fieldmap = ddm_structure.getFieldsMap();
		Map<String, Map<String, String>> fieldmap_options = null;
		fieldmap_options = ddm_structure.getTransientFieldsMap(themeDisplay.getLocale().toString());
		HashMap<String, LinkedHashMap<String, String>> field_options = new HashMap<String, LinkedHashMap<String, String>>();
	  	for(String key_options : fieldmap_options.keySet()) {
	  		String ddlfield = fieldmap_options.get(key_options).get("_parentName_");
	  		if(!field_options.containsKey(ddlfield)) {
	  			field_options.put(ddlfield, new LinkedHashMap<String, String>());
	  		}
	  		field_options.get(ddlfield).put(fieldmap_options.get(key_options).get("value"), fieldmap_options.get(key_options).get("label"));
	  	}
	  	for(String key : fieldmap.keySet()) {
	  		if(key.equalsIgnoreCase("_fieldsDisplay")) {
	  			continue;
	  		}
	  		String options = "";
	  		DDLConfiguration fieldconfiguration = DDLConfigurationLocalServiceUtil.getDDLConfigurationForField(ddm_structure.getStructureId(), key);
	  		if(fieldconfiguration != null) {
	  			options = fieldconfiguration.getViewscript();
	  		}
	  		%>
			<%= key %>: <%= options %><br>
			<%
	  	}
	}
}
%>