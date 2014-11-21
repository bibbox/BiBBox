<%@ include file="/html/init.jsp" %>
<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<Biobank> searchContainer = null;
%>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
	
	List<Country> countries = CountryLocalServiceUtil.getAllCountries();
	
	String code = ParamUtil.getString(request, "code");
	String acronym = ParamUtil.getString(request, "acronym");
	String name = ParamUtil.getString(request, "name");
	String countryCode =  ParamUtil.getString (request, "countryCode");
	List<Biobank> biobanks = BiobankLocalServiceUtil.findBiobanksByIdentity(code, acronym, name, countryCode, 0, 100);
	for (Biobank biobank : biobanks) {
		System.out.println(biobank.getCode());
	}
%>

<portlet:renderURL var="searchBiobankURL">
		<portlet:param name="mvcPath" value="/html/biobanksearch/view.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<aui:form action="<%= searchBiobankURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:input name="code" value="<%= code %>" />
		<aui:input name="acronym" value="<%= acronym %>" />
		<aui:input name="name" value="<%= name %>" />
		<aui:select label="Country" name="countryCode" showEmptyOption="<%= true %>">

	 		<%
				for (Country country : countries) {
			%>

			<aui:option selected="<%= country.getCode() == countryCode %>" value="<%= country.getCode() %>"><%=country.getName() %></aui:option>

			<%
				}
			%>

		</aui:select>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" name="search" value="search"/>
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>

<%if (!(code.isEmpty() && acronym.isEmpty() && name.isEmpty() && countryCode.isEmpty()))  { %>

<liferay-ui:search-container emptyResultsMessage="biobank-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= BiobankLocalServiceUtil.findBiobanksByIdentity(code, acronym, name, countryCode, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= BiobankLocalServiceUtil.findBiobanksCountByIdentity(code, acronym, name, countryCode) %>"
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
			name="code"
			value="<%= biobank.getCode() %>"
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

		<%
			String contactName = "";

			try {
				contactName = ContactLocalServiceUtil.getContact
						(biobank.getContactId()).getFirstName()+" "+ContactLocalServiceUtil.getContact
						(biobank.getContactId()).getLastName();
			} 
			catch (Exception e) {
			}
		%>

		<liferay-ui:search-container-column-text
			name="contact"
			value="<%= contactName %>"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/biobank/biobank_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<% } else  {%>
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
			name="code"
			value="<%= biobank.getCode() %>"
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

		<%
			String contactName = "";

			try {
				contactName = ContactLocalServiceUtil.getContact
						(biobank.getContactId()).getFirstName()+" "+ContactLocalServiceUtil.getContact
						(biobank.getContactId()).getLastName();
			} 
			catch (Exception e) {
			}
		%>

		<liferay-ui:search-container-column-text
			name="contact"
			value="<%= contactName %>"
		/>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/biobank/biobank_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>


<% } %>

