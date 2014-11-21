<%@ include file="/html/init.jsp" %>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	JuristicPerson juristicPerson = (JuristicPerson) row.getObject();

	String name = JuristicPerson.class.getName();
	long juristicPersonId = juristicPerson.getJuristicPersonId();

	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/juristicperson/edit_juristicperson.jsp" />
		<portlet:param name="juristicPersonId" value="<%= String.valueOf(juristicPersonId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%= editURL.toString() %>" />

	<portlet:actionURL name="deleteJuristicPerson" var="deleteURL">
		<portlet:param name="juristicPersonId" value="<%= String.valueOf(juristicPersonId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
</liferay-ui:icon-menu>