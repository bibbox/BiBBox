<%@ include file="/html/init.jsp" %>
<%!
   com.liferay.portal.kernel.dao.search.SearchContainer<Biobank> searchContainer = null;
%>
<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
	List<Country> countries = CountryLocalServiceUtil.getAllCountries();
	
	String countryCode =  ParamUtil.getString (request, "countryCode");
	String keywords = ParamUtil.getString(request, "keywords");
	
	List<BiobankGeneralInformation> results = BiobankGeneralInformationLocalServiceUtil.findBiobanksByKeywordsCountry(keywords, countryCode, 0, 100);
	BiobankGeneralInformation biobankGeneralInformation = null;
	BiobankAttributeLists attributelist= null;
	/* for(Object object:results){
		Object[] arrayobject=(Object[])object;
		biobankGeneralInformation =(BiobankGeneralInformation)arrayobject[0];
		attributelist=(BiobankAttributeLists)arrayobject[1];
		out.println(biobankGeneralInformation.getAcronym());
		out.println(attributelist.getAttributeListValue());
		} */
		System.out.println(results.toString());
		if(results!=null){System.out.println("not null");}
		if(results==null){System.out.println("null");}
	//System.out.println(results.get(0).getBiobankName());
	System.out.println(results.get(1).getBiobankAttributeLists());
	
%>

<portlet:renderURL var="searchBiobankURL">
		<portlet:param name="mvcPath" value="/html/biobank/biobanksearch/biobanksearch.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<aui:form action="<%= searchBiobankURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:row>
			<aui:column>
				<aui:input name="keywords" label='Keywords <i class="icon-question-sign" title="Search by Keywords (Example: Name, Id, Acronym of the biobank;
				 Different Services and Facilities keywords like: Genomics, DNA/RNA Extraction, Cell Biology, MySQL, etc)"></i>' type="text" value="" style="width:500px"
					/>
			</aui:column>
			<aui:column>
				<aui:select name="countryCode" label='Country' >
					<aui:option>Select</aui:option>
					<%
						for (Country country : countries) {
					%>
					
							<aui:option selected="<%= country.getCountryCode() == countryCode %>" value="<%= country.getCountryCode() %>"><%=country.getName() %></aui:option>
					
					<%
						}
					%>
				</aui:select>
			</aui:column>
			<aui:column>
				<aui:button type="submit" value="Search" cssClass="biobank-search-button"/>
			</aui:column>
		</aui:row>
		
	
	</aui:fieldset>
</aui:form>
		