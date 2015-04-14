<%@ page import="java.math.BigInteger" %>
<%@ include file="/html/init.jsp"%>
<%@ page import="at.meduni.liferay.portlet.bbmrieric.services.service.LDAPlogLocalServiceUtil" %>
<%@ page import="java.util.Hashtable" %>

<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.NamingEnumeration" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="javax.naming.directory.Attributes" %>
<%@ page import="javax.naming.directory.Attribute" %>
<%@ page import="java.util.Enumeration" %>
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
	
	String[] attrIDs = {
			"biobankID",
			"biobankName",
			"biobankCountry",
			"biobankDescription",
			"biobankURL",
			"biobankAcronym",
			"biobankSize",
			"dn",
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
			"diagnosisAvailable",
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
		for (NamingEnumeration<?> vals = attrs.getAll(); vals.hasMoreElements();) {
			Attribute a = (Attribute) vals.nextElement();
			for(int i = 0; i < a.size(); i++) {
				String v = a.get(i).toString();
				String vnew = v.replaceAll("'", "\\\\'");
				if (a.isOrdered()) {
					a.set(i, v);					
				}
				else {
					a.remove(v);
					a.add(vnew);
				}
			}
		}
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
		label: '<%= attrs.get("biobankID").toString().replaceAll("biobankID: ", "")%> (<%= attrs.get("biobankName").toString().replaceAll("biobankName: ", "") %>)',
		children: [
		           <%
		     for (String k : attrIDs) {
		    	 if (attrs.get(k) != null) {
		    		 if (k.equals("biobankSize")) {
		    			 try {
		    				 String bbsize = attrs.get(k).get().toString();
			    			 //BigInteger bbsizeval = BigInteger("10").pow(Integer(bbsize)); 
			    			 //bbsize = "more than " + bbsizeval + " samples";
			    			 bbsize = "more than 10^" + bbsize + " samples";
				    		 %>
				 			{label: '<%= k %>: <%= bbsize%>', leaf: true},		    		 
				    		 <%		    			 		    				 
		    			 }
		    			 catch (Exception e) {
				    		 %>
					 			{label: '<%= k %>: unknown', leaf: true},		    		 
					    	<%		    			 		    				 		    				 
		    			 }
		    		 }
		    		 else {
			    		 %>
			 			{label: '<%= attrs.get(k) %>', leaf: true},		    		 
			    		 <%
		    			 
		    		 }
	    		 }
		     }      
		           %>
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