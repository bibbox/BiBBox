<%@ include file="/html/init.jsp" %> 

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
String articalTemplate_cfg = GetterUtil.getString(portletPreferences.getValue("articalTemplate", ""));
String inventarNumberPattern_cfg = GetterUtil.getString(portletPreferences.getValue("inventarNumberPattern", "#"));
%>

<portlet:actionURL name='addObject' var="addObjectURL" windowState="normal" />

<aui:form action="<%= addObjectURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:input type="hidden" name="articaltemplate" value="<%= articalTemplate_cfg %>" />
		<aui:input type="hidden" name="inventarNumberpattern" value="<%= inventarNumberPattern_cfg %>" />
		<aui:input name="title" />
		<aui:select label="Type" name="structureId">
			<%
			List<DDMStructure> ddm_structures = DDMStructureLocalServiceUtil.getStructures(themeDisplay.getScopeGroupId());
			for(DDMStructure ddm_structure : ddm_structures) {
				if(ddm_structure.getClassName().equals("com.liferay.portlet.journal.model.JournalArticle")) {
					%>
					<aui:option value="<%= ddm_structure.getStructureKey() %>"><%= ddm_structure.getName(themeDisplay.getLocale()) %></aui:option>
					<%
				}
			}
			%>
		</aui:select>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>