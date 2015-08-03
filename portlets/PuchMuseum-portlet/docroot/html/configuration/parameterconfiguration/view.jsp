<%@ include file="/html/init.jsp"%>

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
%>
	<aui:button-row>
		<portlet:renderURL var="addParameterConfigurationURL">
			<portlet:param name="mvcPath" value="/html/configuration/parameterconfiguration/edit.jsp" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:renderURL>
		<aui:button value="add-parameter-configuration" onClick="<%= addParameterConfigurationURL.toString() %>"/>
	</aui:button-row>
	
<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "10")) %>' emptyResultsMessage="empty-results-message">
	<liferay-ui:search-container-results
		results="<%= ParameterConfigurationLocalServiceUtil.getParameterConfigurations(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ParameterConfigurationLocalServiceUtil.getParameterConfigurationsCount() %>"
	/>
	
	<liferay-ui:search-container-row
		className="at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration"
		keyProperty="parameterconfigurationId"
		modelVar="parameterconfiguration" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="ID"
			property="parameterconfigurationId"
		/>
	
		<liferay-ui:search-container-column-text
			name="displaynameshort"
			property="displaynameshort"
		/>
	
		<liferay-ui:search-container-column-text
			name="displaynamelong"
			property="displaynamelong"
		/>
	
		<liferay-ui:search-container-column-text
			name="datatype"
			property="datatype"
		/>

		<liferay-ui:search-container-column-text
			name="group"
			property="group"
		/>
	
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/configuration/parameterconfiguration/parameterconfiguration_actions.jsp"
		/>
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
