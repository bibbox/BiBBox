<%@ include file="/html/init.jsp" %>
<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<Contact> searchContainer = null;
%>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<aui:button-row>
	<portlet:renderURL var="addContactURL">
		<portlet:param name="mvcPath" value="/html/contact/edit_contact.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button onClick="<%= addContactURL.toString() %>" value="add-contact" />
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="contact-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= ContactLocalServiceUtil.getAllContacts(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= ContactLocalServiceUtil.getContactsCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.bcnet.portlet.biobank.model.Contact"
		keyProperty="contactId"
		modelVar="biobankContact" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="name"
			value="<%= biobankContact.getFirstName()+\" \"+biobankContact.getLastName() %>"
		/>

		<liferay-ui:search-container-column-text
			name="phone"
			property="phone"
		/>

		<liferay-ui:search-container-column-text
			name="email"
			property="email"
		/>

		<liferay-ui:search-container-column-text
			name="address"
			property="address"
		/>

		<liferay-ui:search-container-column-text
			name="zip"
			property="zip"
		/>
		
		<liferay-ui:search-container-column-text
			name="city"
			property="city"
		/>
		
		<%
			String countryName = "";

			try {
				countryName = CountryLocalServiceUtil.getCountry(biobankContact.getCountryCode()).getName();
			} catch (Exception e) {
			}
		%>

		<liferay-ui:search-container-column-text
			name="country"
			value="<%= countryName %>"
		/>
		
		<%
			String juristicPersonName = "";

			try {
				juristicPersonName = JuristicPersonLocalServiceUtil.getJuristicPerson
						(biobankContact.getJuristicPersonId()).getName();
			} 
			catch (Exception e) {
			}
		%>

		<liferay-ui:search-container-column-text
			name="juristicPersonName"
			value="<%= juristicPersonName %>"
		/>
		
		<liferay-ui:search-container-column-text
			name="department"
			property="department"
		/>
		
		<liferay-ui:search-container-column-text
			name="orcId"
			property="orcId"
		/>
		
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/contact/contact_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>