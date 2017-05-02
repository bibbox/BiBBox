<%@page import="at.graz.meduni.liferay.portlet.bibbox.service.persistence.DDLConfigurationPersistence"%>
<%@ include file="/html/ddl/init.jsp" %>  

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%@ include file="/html/ddl/dynamicdatalistconfigextended/inlinestyle.jspf" %>

<!-- ------------------------------- -->
<!-- INIT Parameters for the Portlet -->
<!-- ------------------------------- -->
<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<!-- ------------------------------- -->
<!-- Main Ccntent area               -->
<!-- ------------------------------- -->
<div id="ddmStructureToggler">
	<%
	List<DDMStructure> ddm_structures = DDMStructureLocalServiceUtil.getStructures(themeDisplay.getCompanyGroupId());
	// Iterate throu all the ddl Record sets
	for(DDMStructure ddm_structure : ddm_structures) { 
		if(ddm_structure.getClassName().equals("com.liferay.portlet.dynamicdatalists.model.DDLRecordSet")) {
		  	
		  	Map<String, Map<String, String>> fieldsmap = ddm_structure.getFieldsMap();
			
			%>
			<%@ include file="/html/ddl/dynamicdatalistconfigextended/ddm_structures.jspf" %>
			<%
		}
	}
	%>
</div> <!-- <div id="ddmStructureToggler"> -->



<%@ include file="/html/ddl/dynamicdatalistconfigextended/inlinejs.jspf" %>
