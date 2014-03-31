<%@ include file="/html/init.jsp" %>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil"%>
<%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalService" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.storage.Fields" %>


<portlet:defineObjects />

This is the <b>Ddl Record Hierarchy</b> portlet in View mode.

<%
PortletPreferences preferences = renderRequest.getPreferences();

String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
 preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}
%>
You have selected <%= preferences.getValue("company",null) %>

<!-- Config Patient Table -->
<% 

long patientstructurerecord_id = 12230;
DDLRecordSet patient_recordset = DDLRecordSetLocalServiceUtil.getRecordSet(patientstructurerecord_id);

%>
<!-- Start Patient Table -->
<br>Patient Tables<br>
<%= patient_recordset %>

<table>
<tr>
<%
Set<String> fields = patient_recordset.getDDMStructure().getFieldNames();
for(String s : fields) {
	if(s.equalsIgnoreCase("_fieldsDisplay")) {
		continue;
	}
	%>
	<td><%= patient_recordset.getDDMStructure().getFieldLabel(s, locale) %></td>
<%	
}
%>
</tr>
<%
patient_recordset.getRecords();
%>
</table>

<!-- End Patient Table -->