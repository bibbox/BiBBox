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
				<aui:input prefix="http://catalogue.rd-connect.eu/" label="BiobankID (http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/10779)" name="BiobankID" suffix="/1234" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="CollectionID predicate" name="CollectionIDPredicate" />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="MaincontactID predicate" name="MaincontactIDPredicate" />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="Name predicate" name="NamePredicate" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="OrganizationID predicate" name="OrganizationIDPredicate" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Acronym predicate" name="AcronymPredicate" />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="Type predicate" name="TypePredicate" />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="URL predicate" name="URLPredicate" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="IDCardURL predicate" name="IDCardURLPredicate" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Also Listed in predicate" name="AlsoListedInPredicate" />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="Last Activities predicate" name="LastActivitiesPredicate" />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="Date of Inclusio predicate" name="DateOfInclusioPredicate" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Type of host Institution predicate" name="TypeOfHostInstitutionPredicate" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Target population predicate" name="TargetPopulationPredicate" />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="Address predicate" name="AddressPredicate" />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="Name of host Institution predicate (Address)" name="NameOfHostInstitutionPredicate" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Street1 predicate (Address)" name="Street1Predicate" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="street2 predicate (Address)" name="Street2Predicate" />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="ZIP predicate (Address)" name="ZIPPredicate" />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="City predicate (Address)" name="CityPredicate" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Country predicate (Address)" name="CountryPredicate" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Description predicate" name="DescriptionPredicate" />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="Source of Funding predicate" name="SourceOfFundingPredicate" />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="Target Country predicate" name="TargetCountryPredicate" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Year of establishment predicate" name="YearOfEstablishmentPredicate" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Ontologies predicate" name="OntologiesPredicate" />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="Associated data available predicate" name="AssociatedDataAvailablePredicate" />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="Imaging available predicate" name="ImagingAvailablePredicate" />
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:fieldset title="Collection">
		<aui:layout>
			<h3>Collection</h3>
			<aui:column columnWidth="75" first="true">
				<aui:input prefix="http://catalogue.rd-connect.eu/" label="CollectionID (http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/10779/collection-id/1)" name="CollectionID" suffix="/1" />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="DiseasMatrixID predicate" name="DiseasMatrixIDPredicate" />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="Name predicate" name="CollectionNamePredicate" />
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:fieldset title="Diseasmatrix">
		<aui:layout>
			<h3>DiseasMatrix</h3>
			<aui:column columnWidth="100" first="true">
				<aui:input prefix="http://catalogue.rd-connect.eu/" label="DiseasMatrixID (http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/10779)" name="DiseaseMatrixID" suffix="/123" />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="Disease Name predicate" name="DiseaseName" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Number Of Patients/Donors predicate" name="NumberOfPatients" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Gene predicate" name="Gene" />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="ORPHA Code predicate" name="ORPHACode" />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="ICD10 predicate" name="ICD10" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="OMIM predicate" name="OMIM" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Synonym predicate" name="Synonym" />
			</aui:column>
			<aui:column columnWidth="25" last="true">
				<aui:input label="ModifiedDate predicate" name="ModifiedDate" />
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:fieldset title="User">
		<aui:layout>
			<h3>User</h3>
			<aui:column columnWidth="100" first="true">
				<aui:input prefix="http://catalogue.rd-connect.eu/" label="UserID (http://catalogue.rd-connect.eu/apiv1/regbb/person-id/10779)" name="UserID" suffix="/1" />
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:input label="Firstname predicate" name="FirstnamePredicate" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="Lastname predicate" name="LastnamePredicate" />
			</aui:column>
			<aui:column columnWidth="25">
				<aui:input label="E-Mail predicate" name="EMailPredicate" />
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