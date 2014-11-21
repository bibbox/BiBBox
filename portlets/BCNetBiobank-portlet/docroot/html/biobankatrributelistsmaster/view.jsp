<%@ include file="/html/init.jsp" %>
<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<BiobankAtrributeListsMaster> searchContainer = null;
%>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>
<%= scopeGroupId %>
<aui:button-row>
	<portlet:renderURL var="addBiobankAtrributeListsMasterURL">
		<portlet:param name="mvcPath" value="/html/biobankatrributelistsmaster/edit_biobankatrributelistsmaster.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button onClick="<%= addBiobankAtrributeListsMasterURL.toString() %>" value="add-biobankAtrributeListsMaster" />
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="biobankAtrributeListsMaster-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= BiobankAtrributeListsMasterLocalServiceUtil.getAllBiobankAtrributeListsMasters(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= BiobankAtrributeListsMasterLocalServiceUtil.getBiobankAtrributeListsMastersCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster"
		keyProperty="biobankAtrributeListsMasterId"
		modelVar="biobankAtrributeListsMaster" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="attributeListName"
			value="<%= biobankAtrributeListsMaster.getAttributeListName() %>"
		/>

		<liferay-ui:search-container-column-text
			name="attributeListValue"
			property="attributeListValue"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/biobankatrributelistsmaster/biobankatrributelistsmaster_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>