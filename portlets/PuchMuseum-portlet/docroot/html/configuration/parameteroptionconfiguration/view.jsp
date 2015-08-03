<%@ include file="/html/init.jsp"%>

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
%>
	<aui:button-row>
		<portlet:renderURL var="addParameterConfigurationURL">
			<portlet:param name="mvcPath" value="/html/configuration/parameteroptionconfiguration/edit.jsp" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:renderURL>
		<aui:button value="add-parameter-configuration" onClick="<%= addParameterConfigurationURL.toString() %>"/>
	</aui:button-row>
	
<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "10")) %>' emptyResultsMessage="empty-results-message">
	<liferay-ui:search-container-results
		results="<%= ParameterOptionsConfigurationLocalServiceUtil.getParameterOptionsConfigurations(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ParameterOptionsConfigurationLocalServiceUtil.getParameterOptionsConfigurationsCount() %>"
	/>
	
	<liferay-ui:search-container-row
		className="at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration"
		keyProperty="parameteroptionsconfigurationId"
		modelVar="parameteroptionsconfiguration" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="ID"
			property="parameteroptionsconfigurationId"
		/>
	
		<liferay-ui:search-container-column-text
			name="parameterconfigurationId"
			property="parameterconfigurationId"
		/>
	
		<liferay-ui:search-container-column-text
			name="optionkey"
			property="optionkey"
		/>
	
		<liferay-ui:search-container-column-text
			name="optionvalue"
			property="optionvalue"
		/>
	
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/configuration/parameteroptionconfiguration/parameteroptionsconfiguration_actions.jsp"
		/>
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
