<%@ include file="/html/init.jsp"%>
<%@ page import="at.meduni.liferay.portlet.bbmrieric.services.service.LDAPlogLocalServiceUtil" %>
<%@ page import="java.util.Hashtable" %>

<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.NamingEnumeration" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="javax.naming.directory.Attributes" %>
<%@ page import="javax.naming.directory.BasicAttribute" %>
<%@ page import="javax.naming.directory.BasicAttributes" %>
<%@ page import="javax.naming.directory.DirContext" %>
<%@ page import="javax.naming.directory.InitialDirContext" %>
<%@ page import="javax.naming.directory.SearchControls" %>
<%@ page import="javax.naming.directory.SearchResult" %>
<%@ page import="javax.naming.ldap.LdapContext" %>

<portlet:defineObjects />

<div id="myTreeView"></div>

<aui:script>
YUI().use(
  'aui-tree-view',
  function(Y) {
    new Y.TreeViewDD(
      {
      	boundingBox: '#myTreeView',
      	children: [
<%
Hashtable<String, String> environment = new Hashtable<String, String>();
environment.put(LdapContext.CONTROL_FACTORIES, "com.sun.jndi.ldap.ControlFactory");
environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
environment.put(Context.PROVIDER_URL, "ldap://directory.bbmri-eric.eu:389");
environment.put(Context.SECURITY_AUTHENTICATION, "simple");
environment.put(Context.REFERRAL, "follow");

// connect to LDAP
try {
	DirContext ctx = new InitialDirContext(environment);
	
	/*Attributes matchAttrs = new BasicAttributes(true); // ignore attribute name case
	matchAttrs.put(new BasicAttribute("biobankID"));
	matchAttrs.   SearchControls.SUBTREE_SCOPE*/
	
	String[] attrIDs = { "biobankID", "biobankName", "biobankCountry", "dn",
			"diagnosisAvailable",
			"biobankID",
			"biobankName",
			"biobankJuridicalPerson",
			"biobankCountry",
			"biobankContactFirstName",
			"biobankContactLastName",
			"biobankContactPhone",
			"biobankContactEmail",
			"biobankContactAddress",
			"biobankContactZIP",
			"biobankContactCity",
			"biobankContactCountry",
			"biobankMaterialStoredDNA",
			"biobankMaterialStoredcDNAmRNA",
			"biobankMaterialStoredmicroRNA",
			"biobankMaterialStoredWholeBlood",
			"biobankMaterialStoredPBC",
			"biobankMaterialStoredPlasma",
			"biobankMaterialStoredSerum",
			"biobankMaterialStoredTissueCryo",
			"biobankMaterialStoredTissueParaffin",
			"biobankMaterialStoredCellLines",
			"biobankMaterialStoredUrine",
			"biobankMaterialStoredSaliva",
			"biobankMaterialStoredFaeces",
			"biobankMaterialStoredPathogen",
			"biobankMaterialStoredOther",
			"biobankSize",
			"biobankSampleAccessFee",
			"biobankSampleAccessJointProjects",
			"biobankSampleAccessDescription",
			"biobankDataAccessFee",
			"biobankDataAccessJointProjects",
			"biobankDataAccessDescription",
			"biobankAvailableMaleSamplesData",
			"biobankAvailableFemaleSamplesData",
			"biobankAvailableBiologicalSamples",
			"biobankAvailableSurveyData",
			"biobankAvailableImagingData",
			"biobankAvailableMedicalRecords",
			"biobankAvailableNationalRegistries",
			"biobankAvailableGenealogicalRecords",
			"biobankAvailablePhysioBiochemMeasurements",
			"biobankAvailableOther",
			"biobankITSupportAvailable",
			"biobankITStaffSize" };

	SearchControls ctls = new SearchControls();
	ctls.setReturningAttributes(attrIDs);
	ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
	
	// Search for objects using filter and controls
	NamingEnumeration answer = ctx.search("dc=directory,dc=bbmri-eric,dc=eu", "(objectclass=*)", ctls);
	//NamingEnumeration answer = ctx.search("dc=directory,dc=bbmri-eric,dc=eu", matchAttrs);
	String country = "";
	String bracket = "";
	while (answer.hasMore()) {
		SearchResult sr = (SearchResult) answer.next();
		Attributes attrs = sr.getAttributes();
		if(attrs.get("biobankCountry") == null) {
			continue;
		}
		if(!country.equalsIgnoreCase(attrs.get("biobankCountry").toString())) {
			country = attrs.get("biobankCountry").toString();
			%>
			<%= bracket %>
			{
			expanded: true,
			label: '<%= attrs.get("biobankCountry").toString().replaceAll("biobankCountry: ", "") %>',
			children: [
			<%
			bracket = "]},";
		}
		
		%>
		{
		leaf: true,
		label: '<%= attrs.get("biobankName").toString().replaceAll("biobankName: ", "") %>',
		children: [
			{label: '<%= attrs.get("biobankID") %>', leaf: true},
			{label: '<%= attrs.get("diagnosisAvailable") %>', leaf: true},
			{label: '<%= attrs.get("biobankName") %>', leaf: true},
			{label: '<%= attrs.get("biobankJuridicalPerson") %>', leaf: true},
			{label: '<%= attrs.get("biobankCountry") %>', leaf: true},
			{label: '<%= attrs.get("biobankContactFirstName") %>', leaf: true},
			{label: '<%= attrs.get("biobankContactLastName") %>', leaf: true},
			{label: '<%= attrs.get("biobankContactPhone") %>', leaf: true},
			{label: '<%= attrs.get("biobankContactEmail") %>', leaf: true},
			{label: '<%= attrs.get("biobankContactAddress") %>', leaf: true},
			{label: '<%= attrs.get("biobankContactZIP") %>', leaf: true},
			{label: '<%= attrs.get("biobankContactCity") %>', leaf: true},
			{label: '<%= attrs.get("biobankContactCountry") %>', leaf: true},
			{label: '<%= attrs.get("biobankMaterialStoredDNA") %>', leaf: true},
			{label: '<%= attrs.get("biobankMaterialStoredcDNAmRNA") %>', leaf: true},
			{label: '<%= attrs.get("biobankMaterialStoredmicroRNA") %>', leaf: true},
			{label: '<%= attrs.get("biobankMaterialStoredWholeBlood") %>', leaf: true},
			{label: '<%= attrs.get("biobankMaterialStoredPBC") %>', leaf: true},
			{label: '<%= attrs.get("biobankMaterialStoredPlasma") %>', leaf: true},
			{label: '<%= attrs.get("biobankMaterialStoredSerum") %>', leaf: true},
			{label: '<%= attrs.get("biobankMaterialStoredTissueCryo") %>', leaf: true},
			{label: '<%= attrs.get("biobankMaterialStoredTissueParaffin") %>', leaf: true},
			{label: '<%= attrs.get("biobankMaterialStoredCellLines") %>', leaf: true},
			{label: '<%= attrs.get("biobankMaterialStoredUrine") %>', leaf: true},
			{label: '<%= attrs.get("biobankMaterialStoredSaliva") %>', leaf: true},
			{label: '<%= attrs.get("biobankMaterialStoredFaeces") %>', leaf: true},
			{label: '<%= attrs.get("biobankMaterialStoredPathogen") %>', leaf: true},
			{label: '<%= attrs.get("biobankMaterialStoredOther") %>', leaf: true},
			{label: '<%= attrs.get("biobankSize") %>', leaf: true},
			{label: '<%= attrs.get("biobankSampleAccessFee") %>', leaf: true},
			{label: '<%= attrs.get("biobankSampleAccessJointProjects") %>', leaf: true},
			{label: '<%= attrs.get("biobankSampleAccessDescription") %>', leaf: true},
			{label: '<%= attrs.get("biobankDataAccessFee") %>', leaf: true},
			{label: '<%= attrs.get("biobankDataAccessJointProjects") %>', leaf: true},
			{label: '<%= attrs.get("biobankDataAccessDescription") %>', leaf: true},
			{label: '<%= attrs.get("biobankAvailableMaleSamplesData") %>', leaf: true},
			{label: '<%= attrs.get("biobankAvailableFemaleSamplesData") %>', leaf: true},
			{label: '<%= attrs.get("biobankAvailableBiologicalSamples") %>', leaf: true},
			{label: '<%= attrs.get("biobankAvailableSurveyData") %>', leaf: true},
			{label: '<%= attrs.get("biobankAvailableImagingData") %>', leaf: true},
			{label: '<%= attrs.get("biobankAvailableMedicalRecords") %>', leaf: true},
			{label: '<%= attrs.get("biobankAvailableNationalRegistries") %>', leaf: true},
			{label: '<%= attrs.get("biobankAvailableGenealogicalRecords") %>', leaf: true},
			{label: '<%= attrs.get("biobankAvailablePhysioBiochemMeasurements") %>', leaf: true},
			{label: '<%= attrs.get("biobankAvailableOther") %>', leaf: true},
			{label: '<%= attrs.get("biobankITSupportAvailable") %>', leaf: true},
			{label: '<%= attrs.get("biobankITStaffSize") %>', leaf: true},
		]
		},
		<%
	}
	%>
	]}
	<%
} catch (NamingException e) {
	System.err.println("ERROR: LDAPlogLocalServiceImpl::getCountrylist()");
	e.printStackTrace();
}
%>
		]
      }
    ).render();
  }
);
</aui:script>