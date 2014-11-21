<%@ include file="/html/init.jsp" %>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Biobank biobank = (Biobank) row.getObject();

	String name = Biobank.class.getName();
	long biobankDbId = biobank.getBiobankDbId();

	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/biobank/biobank_tabs.jsp" />
		<portlet:param name="biobankDbId" value="<%= String.valueOf(biobankDbId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%= editURL.toString() %>" />
	
	<portlet:renderURL var="editBiobankAttributesURL">
		<portlet:param name="mvcPath" value="/html/biobankattributelists/edit_biobankattributes.jsp" />
		<portlet:param name="biobankDbId" value="<%= String.valueOf(biobankDbId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%= editBiobankAttributesURL.toString() %>" message="Edit Attributes"/>

	<portlet:actionURL name="deleteBiobank" var="deleteURL">
		<portlet:param name="biobankDbId" value="<%= String.valueOf(biobankDbId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
	
</liferay-ui:icon-menu>