<%@ include file="/html/init.jsp" %> 

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ParameterConfiguration parameterconfiguration = (ParameterConfiguration)row.getObject();

String name = ParameterConfiguration.class.getName();
long parameterconfigurationId = parameterconfiguration.getParameterconfigurationId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu >

	<portlet:renderURL var="viewURL">
		<portlet:param name="mvcPath" value="/html/configuration/parameterconfiguration/view.jsp" />
		<portlet:param name="parameterconfigurationId" value="<%= String.valueOf(parameterconfigurationId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	<liferay-ui:icon image="view" url="<%=viewURL.toString() %>" />

	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/configuration/parameterconfiguration/edit.jsp" />
		<portlet:param name="parameterconfigurationId" value="<%= String.valueOf(parameterconfigurationId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

	<portlet:actionURL name="deleteParameterConfiguration" var="deleteParameterConfigurationURL">
		<portlet:param name="parameterconfigurationId" value="<%= String.valueOf(parameterconfigurationId) %>" />
		<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>"/>
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%=deleteParameterConfigurationURL.toString() %>" />

</liferay-ui:icon-menu>