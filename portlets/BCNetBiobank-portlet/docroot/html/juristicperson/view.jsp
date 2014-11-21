<%@ include file="/html/init.jsp" %>
<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<JuristicPerson> searchContainer = null;
%>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<aui:button-row>
	<portlet:renderURL var="addJuristicPersonURL">
		<portlet:param name="mvcPath" value="/html/juristicperson/edit_juristicperson.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button onClick="<%= addJuristicPersonURL.toString() %>" value="add-juristicPerson" />
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="juristicPerson-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= JuristicPersonLocalServiceUtil.getAllJuristicPersons(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= JuristicPersonLocalServiceUtil.getJuristicPersonsCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.bcnet.portlet.biobank.model.JuristicPerson"
		keyProperty="juristicPersonId"
		modelVar="juristicPerson" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="name"
			value="<%= juristicPerson.getName() %>"
		/>

		<liferay-ui:search-container-column-text
			name="url"
			property="url"
		/>

		<liferay-ui:search-container-column-text
			name="address"
			property="address"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/juristicperson/juristicperson_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>