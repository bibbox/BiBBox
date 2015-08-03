<%@ include file="/html/init.jsp" %> 

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ParameterOptionsConfiguration parameteroptionsconfiguration = (ParameterOptionsConfiguration)row.getObject();

String name = ParameterOptionsConfiguration.class.getName();
long parameteroptionsconfigurationId = parameteroptionsconfiguration.getParameteroptionsconfigurationId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu >

	<portlet:renderURL var="viewURL">
		<portlet:param name="mvcPath" value="/html/configuration/parameteroptionconfiguration/view.jsp" />
		<portlet:param name="parameteroptionsconfigurationId" value="<%= String.valueOf(parameteroptionsconfigurationId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	<liferay-ui:icon image="view" url="<%=viewURL.toString() %>" />

	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/configuration/parameteroptionconfiguration/edit.jsp" />
		<portlet:param name="parameteroptionsconfigurationId" value="<%= String.valueOf(parameteroptionsconfigurationId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

	<portlet:actionURL name="deleteParameterOptionsConfiguration" var="deleteParameterOptionsConfigurationURL">
		<portlet:param name="parameteroptionsconfigurationId" value="<%= String.valueOf(parameteroptionsconfigurationId) %>" />
		<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>"/>
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%=deleteParameterOptionsConfigurationURL.toString() %>" />

</liferay-ui:icon-menu>