<%@ include file="/html/init.jsp" %>

<%
	Contact biobankContact = null;

	long contactId = ParamUtil.getLong(request, "contactId");

	if (contactId > 0) {
		biobankContact = ContactLocalServiceUtil.getContact(contactId);
	}

	List<Contact> contacts = ContactLocalServiceUtil.getAllContacts();
	List<JuristicPerson> juristicPersons = JuristicPersonLocalServiceUtil.getAllJuristicPersons();
	List<Country> countries = CountryLocalServiceUtil.getAllCountries();

	String redirect = ParamUtil.getString(request, "redirect");
%>

<aui:model-context bean="<%= biobankContact %>" model="<%= Contact.class %>" />
<portlet:renderURL var="viewContactURL" />
<portlet:actionURL name='<%= biobankContact == null ? "addContact" : "updateContact" %>' var="editContactURL" windowState="normal" />

<liferay-ui:header
	backURL="<%= viewContactURL %>"
	title='<%= (biobankContact != null) ? biobankContact.getFirstName()+" "+biobankContact.getLastName() : "new-contact" %>'
/>

<aui:form action="<%= editContactURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

		<aui:input name="contactId" type="hidden" value='<%= biobankContact == null ? "" : biobankContact.getContactId() %>'/>

		<aui:input name="firstName" />
		
		<aui:input name="lastName" />

		<aui:input name="phone" />
		
		<aui:input name="email" />
		
		<aui:input name="address" />
		
		<aui:input name="zip" />
		
		<aui:input name="city" />

		<aui:select label="Country" name="countryCode" showEmptyOption="<%= true %>">

	 		<%
				for (Country country : countries) {
			%>

			<aui:option selected="<%= biobankContact != null && country.getCode() == biobankContact.getCountryCode() %>" value="<%= country.getCode() %>"><%=country.getName() %></aui:option>

			<%
				}
			%>

		</aui:select>

		<aui:select label="Juristic Person" name="juristicPersonId" showEmptyOption="<%= true %>">

	 		<%
				for (JuristicPerson juristicPerson : juristicPersons) {
			%>

			<aui:option selected="<%= biobankContact != null && juristicPerson.getJuristicPersonId() == biobankContact.getJuristicPersonId() %>" value="<%= juristicPerson.getJuristicPersonId() %>"><%=juristicPerson.getName() %></aui:option>

			<%
				}
			%>

		</aui:select>

		<aui:input name="department" />
		
		<aui:input name="orcId" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button onClick="<%= viewContactURL %>"  type="cancel" />
	</aui:button-row>
</aui:form>