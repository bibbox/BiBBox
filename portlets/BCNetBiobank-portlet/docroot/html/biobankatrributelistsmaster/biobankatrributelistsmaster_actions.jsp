<%@ include file="/html/init.jsp" %>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	BiobankAtrributeListsMaster biobankAtrributeListsMaster = (BiobankAtrributeListsMaster) row.getObject();

	String name = BiobankAtrributeListsMaster.class.getName();
	long biobankAtrributeListsMasterId = biobankAtrributeListsMaster.getBiobankAttributeListsMasterId();

	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/biobankatrributelistsmaster/edit_biobankatrributelistsmaster.jsp" />
		<portlet:param name="biobankAtrributeListsMasterId" value="<%= String.valueOf(biobankAtrributeListsMasterId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%= editURL.toString() %>" />

	<portlet:actionURL name="deleteBiobankAtrributeListsMaster" var="deleteURL">
		<portlet:param name="biobankAtrributeListsMasterId" value="<%= String.valueOf(biobankAtrributeListsMasterId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
</liferay-ui:icon-menu>