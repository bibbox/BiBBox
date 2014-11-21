<%@ include file="/html/init.jsp" %>
<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<Biobank> searchContainer = null;
%>
This is the <b>Biobank</b> portlet in View mode.

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>
<%=scopeGroupId %>
<aui:button-row>
	<portlet:renderURL var="addBiobankURL">
		<portlet:param name="mvcPath" value="/html/biobank/biobank_tabs.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button onClick="<%= addBiobankURL.toString() %>" value="add-biobank" />
	
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="biobank-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= BiobankLocalServiceUtil.getAllBiobanks(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= BiobankLocalServiceUtil.getBiobanksCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.bcnet.portlet.biobank.model.Biobank"
		keyProperty="biobankId"
		modelVar="biobank" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="name"
			value="<%= biobank.getName() %>"
		/>

		<liferay-ui:search-container-column-text
			name="description"
			property="description"
		/>

		<liferay-ui:search-container-column-text
			name="biobankId"
			value="<%= biobank.getBiobankId() %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="acronym"
			value="<%= biobank.getAcronym() %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="url"
			value="<%= biobank.getUrl() %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="Backup"
			value="<%= biobank.getBackup()== true?\"yes\":\"no\" %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="trainingCourses"
			value="<%= biobank.getTrainingCourses()== true?\"yes\":\"no\" %>"
		/>
		<%
			String juristicPersonName = "";

			try {
				juristicPersonName = JuristicPersonLocalServiceUtil.getJuristicPerson
						(biobank.getJuristicPersonId()).getName();
			} 
			catch (Exception e) {
			}
		%>

		<liferay-ui:search-container-column-text
			name="juristicPerson"
			value="<%= juristicPersonName %>"
		/>

		
		<%
			String countryName = "";

			try {
				countryName = CountryLocalServiceUtil.getCountry
						(biobank.getCountryCode()).getName();
			} 
			catch (Exception e) {
			}
		%>

		<liferay-ui:search-container-column-text
			name="country"
			value="<%= countryName %>"
		/>

		

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/biobank/biobank_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>