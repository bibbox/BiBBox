<%@ include file="/html/rdconnect/init.jsp" %> 

Test <b>Scaleus Import</b><br><br>

<%
String redirect = ParamUtil.getString(request, "redirect");
%>

<portlet:actionURL name='testImport' var="testImportURL" windowState="normal" />

<aui:form action="<%= testImportURL %>" method="POST" name="fm">
	<aui:fieldset title="Biobank">
		<aui:layout>
			<h3>Biobank</h3>
			<aui:column columnWidth="50" first="true">
				<aui:input prefix="http://catalogue.rd-connect.eu/" label="BiobankID (http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/10779)" name="BiobankID" suffix="/1234" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "BiobankID") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="CollectionID predicate" name="CollectionIDPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "CollectionIDPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="MaincontactID predicate" name="MaincontactIDPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "MaincontactIDPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="Name predicate" name="NamePredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "NamePredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="OrganizationID predicate" name="OrganizationIDPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "OrganizationIDPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Acronym predicate" name="AcronymPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "AcronymPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="Type predicate" name="TypePredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "TypePredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="URL predicate" name="URLPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "URLPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="IDCardURL predicate" name="IDCardURLPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "IDCardURLPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Also Listed in predicate" name="AlsoListedInPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "AlsoListedInPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="Last Activities predicate" name="LastActivitiesPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "LastActivitiesPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="Date of Inclusio predicate" name="DateOfInclusioPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "DateOfInclusioPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Type of host Institution predicate" name="TypeOfHostInstitutionPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "TypeOfHostInstitutionPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Target population predicate" name="TargetPopulationPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "TargetPopulationPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="Address predicate" name="AddressPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "AddressPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="Name of host Institution predicate (Address)" name="NameOfHostInstitutionPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "NameOfHostInstitutionPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Street1 predicate (Address)" name="Street1Predicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "Street1Predicate") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="street2 predicate (Address)" name="Street2Predicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "Street2Predicate") %>' />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="ZIP predicate (Address)" name="ZIPPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "ZIPPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="City predicate (Address)" name="CityPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "CityPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Country predicate (Address)" name="CountryPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "CountryPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Description predicate" name="DescriptionPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "DescriptionPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="Source of Funding predicate" name="SourceOfFundingPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "SourceOfFundingPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="Target Country predicate" name="TargetCountryPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "TargetCountryPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Year of establishment predicate" name="YearOfEstablishmentPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "YearOfEstablishmentPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Ontologies predicate" name="OntologiesPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "OntologiesPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="Associated data available predicate" name="AssociatedDataAvailablePredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "AssociatedDataAvailablePredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="Imaging available predicate" name="ImagingAvailablePredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "ImagingAvailablePredicate") %>' />
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:fieldset title="Collection">
		<aui:layout>
			<h3>Collection</h3>
			<aui:column columnWidth="75" first="true">
				<aui:input prefix="http://catalogue.rd-connect.eu/" label="CollectionID (http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/10779/collection-id/1)" name="CollectionID" suffix="/1" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "CollectionID") %>' />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="DiseasMatrixID predicate" name="DiseasMatrixIDPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "DiseasMatrixIDPredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="Name predicate" name="CollectionNamePredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "CollectionNamePredicate") %>' />
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:fieldset title="Diseasmatrix">
		<aui:layout>
			<h3>DiseasMatrix</h3>
			<aui:column columnWidth="100" first="true">
				<aui:input prefix="http://catalogue.rd-connect.eu/" label="DiseasMatrixID (http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/10779)" name="DiseaseMatrixID" suffix="/123" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "DiseaseMatrixID") %>' />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="Disease Name predicate" name="DiseaseName" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "DiseaseName") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Number Of Patients/Donors predicate" name="NumberOfPatients" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "NumberOfPatients") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Gene predicate" name="Gene" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "Gene") %>' />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="ORPHA Code predicate" name="ORPHACode" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "ORPHACode") %>' />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="ICD10 predicate" name="ICD10" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "ICD10") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="OMIM predicate" name="OMIM" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "OMIM") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Synonym predicate" name="Synonym" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "Synonym") %>' />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="ModifiedDate predicate" name="ModifiedDate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "ModifiedDate") %>' />
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:fieldset title="User">
		<aui:layout>
			<h3>User</h3>
			<aui:column columnWidth="100" first="true">
				<aui:input prefix="http://catalogue.rd-connect.eu/" label="UserID (http://catalogue.rd-connect.eu/apiv1/regbb/person-id/10779)" name="UserID" suffix="/1" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "UserID") %>' />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="Firstname predicate" name="FirstnamePredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "FirstnamePredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Lastname predicate" name="LastnamePredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "LastnamePredicate") %>' />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="E-Mail predicate" name="EMailPredicate" value='<%= ImporterConfigLocalServiceUtil.getPredicate("scaleus", "EMailPredicate") %>' />
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>

<aui:script>
AUI().use('aui-base', function(A){
	A.all("#<portlet:namespace />BiobankID").on('change',function(event){
		var valuetarget = event.target.get('value');
		//alert(valuetarget);
		A.one("#<portlet:namespace />CollectionID").get('parentNode').one(".add-on").setHTML("http://catalogue.rd-connect.eu/" + valuetarget + "/1234/");
		A.one("#<portlet:namespace />DiseaseMatrixID").get('parentNode').one(".add-on").setHTML("http://catalogue.rd-connect.eu/" + valuetarget + "/1234/");
	});
});
AUI().use('aui-base', function(A){
	A.all("#<portlet:namespace />CollectionID").on('change',function(event){
		var valuetarget = event.target.get('value');
		var additionalvalue = event.target.get('parentNode').one(".add-on").getHTML();
		//alert(valuetarget);
		A.one("#<portlet:namespace />DiseaseMatrixID").get('parentNode').one(".add-on").setHTML(additionalvalue + valuetarget + "/1234/");
	});
});
</aui:script>