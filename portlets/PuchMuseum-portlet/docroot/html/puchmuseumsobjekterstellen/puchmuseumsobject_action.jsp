<%@ include file="/html/init.jsp" %> 

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
PuchMuseumsObjekt puchmuseumsobjekt = (PuchMuseumsObjekt)row.getObject();

String name = PuchMuseumsObjekt.class.getName();
long puchmuseumsobjectId = puchmuseumsobjekt.getPuchmuseumsobjectId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu >

	<portlet:renderURL var="viewURL">
		<portlet:param name="mvcPath" value="/html/puchmuseumsobjekterstellen/view.jsp" />
		<portlet:param name="puchmuseumsobjectId" value="<%= String.valueOf(puchmuseumsobjectId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%=viewURL.toString() %>" />

	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/puchmuseumsobjekterstellen/edit.jsp" />
		<portlet:param name="puchmuseumsobjectId" value="<%= String.valueOf(puchmuseumsobjectId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

	<portlet:actionURL name="deleteKdssmpConfiguration" var="deleteKdssmpConfigurationURL">
		<portlet:param name="puchmuseumsobjectId" value="<%= String.valueOf(puchmuseumsobjectId) %>" />
		<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>"/>
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%=deleteKdssmpConfigurationURL.toString() %>" />

</liferay-ui:icon-menu>