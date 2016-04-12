<%@ include file="/html/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<%
String articalTemplate_cfg = GetterUtil.getString(portletPreferences.getValue("articalTemplate", ""));
String inventarNumberPattern_cfg = GetterUtil.getString(portletPreferences.getValue("inventarNumberPattern", "#"));
HashMap<String, String> artical_template = new HashMap<String, String>();
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout cssClass="proposelayout">
   			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
   			<%
   			int counter = 0;
			List<DDMStructure> ddm_structures = DDMStructureLocalServiceUtil.getStructures(themeDisplay.getScopeGroupId());
			for(DDMStructure ddm_structure : ddm_structures) {
				if(ddm_structure.getClassName().equals("com.liferay.portlet.journal.model.JournalArticle")) {
					%>
					<aui:select label="<%= ddm_structure.getName(themeDisplay.getLocale()) %>" name='<%= "structuretemplateId_" + counter %>'>
						<%
						List<DDMTemplate> templates = ddm_structure.getTemplates();
						for(DDMTemplate template : templates) {
							%>
							<aui:option value='<%= ddm_structure.getStructureKey() + "_" + template.getTemplateKey() %>'><%= template.getName(themeDisplay.getLocale()) %></aui:option>
							<%
						}
						%>
					</aui:select>
					<%
					counter++;
				}
			}
			%>
			<aui:input name="numberofstructures" type="hidden" value="<%= counter %>" />
			<aui:input name="preferences--inventarNumberPattern--" value="<%= inventarNumberPattern_cfg %>" />
   		</aui:layout>
   	</aui:fieldset>
   	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>