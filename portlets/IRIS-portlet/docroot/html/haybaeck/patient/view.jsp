<%@ include file="/html/haybaeck/init.jsp" %>

This is the <b>Haybaeck Patient</b> portlet in View mode.

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);	
%>

<!-- Top Actions -->
<liferay-ui:icon-menu >

	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/haybaeck/tma/edit_patient.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />
</liferay-ui:icon-menu>

<!-- Top Actions -->

<liferay-ui:search-container 
emptyResultsMessage="there-are-no-candidates" 
delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "5")) %>'>
	<liferay-ui:search-container-results
		results="<%= PatientLocalServiceUtil.getPatients(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= PatientLocalServiceUtil.getPatientsCount() %>"
	/>

	<liferay-ui:search-container-row 
	className="at.meduni.graz.patho.haybaeck.model.Patient"
	keyProperty="patient_Id"
	modelVar="patient">

		<liferay-ui:search-container-column-text
		name="patient_Id"
		property="patient_Id"
		/>
		
		<liferay-ui:search-container-column-text
		name="identifier"
		property="identifier"
		/>
		
		<liferay-ui:search-container-column-text
		name="cohort"
		property="cohort"
		/>
		
		<liferay-ui:search-container-column-text
		name="first_name"
		property="first_name"
		/>
		
		<liferay-ui:search-container-column-text
		name="last_name"
		property="last_name"
		/>
		
		<liferay-ui:search-container-column-text
		name="date_of_birth"
		property="date_of_birth"
		/>
		
		<liferay-ui:search-container-column-text
		name="date_of_death"
		property="date_of_death"
		/>
		
		<liferay-ui:search-container-column-text
		name="couse_of_death"
		property="couse_of_death"
		/>
		
		<liferay-ui:search-container-column-text
		name="gender"
		property="gender"
		/>

	</liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>
