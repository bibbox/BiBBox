<%@ include file="/html/init.jsp" %>

<%
	Organization organization = null;
	long organizationId = 0;
	BiobankGeneralInformation biobankGeneralInformation = null;
	
	Group currentGroup = themeDisplay.getLayout().getGroup();
	if(currentGroup.isOrganization()){
		organizationId = currentGroup.getClassPK();
		organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
	}
	
	if(organization != null){
		try{
			biobankGeneralInformation = BiobankGeneralInformationLocalServiceUtil.getBiobankGeneralInformation(organizationId);	
		}
		catch(Exception e){
			biobankGeneralInformation = BiobankGeneralInformationLocalServiceUtil.createBiobankGeneralInformation(organizationId);
		}
	
	}
	
	String redirect = PortalUtil.getCurrentURL(renderRequest);
	
%>

<portlet:renderURL var="addBiobankGeneralInformationURL">
	<portlet:param name="mvcPath" value="/html/biobank/biobankgeneralinformation/edit_biobank_general_information.jsp" />
	<portlet:param name="biobankDbId" value="<%= String.valueOf(organizationId) %>" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<div class="list-group">
  <span class="list-group-item-active">
    <b><%=organization.getName() %></b>
    <a href="<%=addBiobankGeneralInformationURL.toString()%>">
    	<span style="float:right;">
    		<liferay-ui:icon image="edit" message="Edit Biobank"/>
    	</span>
    </a>
  </span>
  <span class="list-group-item">BiobankId: <b><%=biobankGeneralInformation.getBiobankId() %></b></span>
  <span class="list-group-item">Acronym: <b><%=biobankGeneralInformation.getAcronym() %></b></span>
  <span class="list-group-item">URL: <aui:a href="<%=biobankGeneralInformation.getUrl() %>"><b><%=biobankGeneralInformation.getUrl() %></b></aui:a></span>
  
	<%
		String juristicPersonName = "";
		
		try {
			juristicPersonName = JuristicPersonLocalServiceUtil.getJuristicPerson
					(biobankGeneralInformation.getJuristicPersonId()).getName();
		} 
		catch (Exception e) {
		}
	%>
  
  <span class="list-group-item">Juristic Person: <b><%=juristicPersonName %></b></span>
  
	<%
		String countryName = "";
		
		try {
			countryName = CountryLocalServiceUtil.getCountry
					(biobankGeneralInformation.getCountryCode()).getName();
		} 
		catch (Exception e) {
		}
	%>
	<span class="list-group-item">Country: <b><%=countryName %></b></span>
	
	<span class="list-group-item">Description: <b><%=biobankGeneralInformation.getDescription() %></b></span>
	<span class="list-group-item">Backup: <b><%=biobankGeneralInformation.getBackup()== true?"yes":"no" %></b></span>
	<span class="list-group-item">Training Courses: <b><%=biobankGeneralInformation.getTrainingCourses()== true?"yes":"no" %></b></span>
</div>



<%-- <aui:fieldset>
	<aui:row>
		<aui:column>Name:</aui:column><aui:column><b><%=organization.getName() %></b></aui:column>
	</aui:row>
	<aui:row>
		<aui:column>BiobankId:</aui:column><aui:column><b><%=biobank.getBiobankId() %></b></aui:column>
	</aui:row>
	<aui:row>
		<aui:column>Acronym:</aui:column><aui:column><b><%=biobank.getAcronym() %></b></aui:column>
	</aui:row>
	<aui:row>
		<aui:column>URL:</aui:column><aui:column><b><%=biobank.getUrl() %></b></aui:column>
	</aui:row>
	
	<%
		/* String juristicPersonName = "";

		try {
			juristicPersonName = JuristicPersonLocalServiceUtil.getJuristicPerson
					(biobank.getJuristicPersonId()).getName();
		} 
		catch (Exception e) {
		} */
	%>
	<aui:row>
		<aui:column>Juristic Person:</aui:column><aui:column><b><%=juristicPersonName %></b></aui:column>
	</aui:row>
	
	<%
		/* String countryName = "";
	
		try {
			countryName = CountryLocalServiceUtil.getCountry
					(biobank.getCountryCode()).getName();
		} 
		catch (Exception e) {
		} */
	%>
		
	<aui:row>
		<aui:column>Country:</aui:column><aui:column><b><%=countryName %></b></aui:column>
	</aui:row>
	<aui:row>
		<aui:column>Description:</aui:column><aui:column><b><%=biobank.getDescription() %></b></aui:column>
	</aui:row>
	<aui:row>
		<aui:column>Backup:</aui:column><aui:column><b><%= biobank.getBackup()== true?"yes":"no" %></b></aui:column>
	</aui:row>
	<aui:row>
		<aui:column>Training Courses:</aui:column><aui:column><b><%= biobank.getTrainingCourses()== true?"yes":"no" %></b></aui:column>
	</aui:row>
</aui:fieldset> --%>
