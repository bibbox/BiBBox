<%@ include file="/html/init.jsp" %>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Contact biobankContact = (Contact) row.getObject();

	long contactId = biobankContact.getContactId();

	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/contact/edit_contact.jsp" />
		<portlet:param name="contactId" value="<%= String.valueOf(contactId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%= editURL.toString() %>" />

	<portlet:actionURL name="deleteContact" var="deleteURL">
		<portlet:param name="contactId" value="<%= String.valueOf(contactId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
</liferay-ui:icon-menu>