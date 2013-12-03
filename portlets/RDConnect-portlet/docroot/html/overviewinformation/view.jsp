<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

<% 
long organizationId = 0;
			com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
            if (currentGroup.isUser()) {
             // the group is a private user community
             // getting the userId of the group's owner is
              long userId = currentGroup.getClassPK();
              System.out.println("user group - user id :" +  userId );
            }
            else if (currentGroup.isOrganization()) {
              // the group is an Organization
              organizationId = currentGroup.getClassPK();
              System.out.println("Organization group - organizationId  :" +  organizationId );
            }
            else {
             // its a normal community
                System.out.println("its a normal community");
           }

/*
Define label Values
*/
HashMap<String, String> qq1 = new HashMap<String, String>();
qq1.put("[\"1\"]", "Yes");
qq1.put("[\"0\"]", "No");
qq1.put("[\"-1\"]", "Unknown");
/*
ENDE Define label Values
*/

//DDLs nach usern
boolean filled = false;
long userId2 = themeDisplay.getUserId();
List<Organization> organisations = OrganizationLocalServiceUtil.getUserOrganizations(userId2);
for(Organization o : organisations) {
organizationId = o.getOrganizationId();

long coreinformationId = 0;
long biobankdetailID = 0;
long biobankqualitydataandsamples = 0;
long accessibility = 0;
long collections = 0;

/*
16527 | Medical Univeristy of Shi'Kahr
16520 | BBMUSK
26585 | NATIONAL BIOBANK OF CRIED TEARS
30064 | Centre Saxony-Anhalt registry of congenital anomalies
30110 | Antwerpen registry of congenital anomalies
30120 | Centro Regionale Veneto per la Fibrosi Cistica
*/

if(organizationId == 30064) {
	coreinformationId = 0;
	biobankdetailID = 0;
	biobankqualitydataandsamples = 0;
	accessibility = 0;
}
if(organizationId == 30110) {
	coreinformationId = 30274; //core
	biobankdetailID = 0;
	biobankqualitydataandsamples = 30782; //quality
	accessibility = 30286; //accessibility
	collections = 30797; //collections
}
if(organizationId == 30120) {
	coreinformationId = 30813;
	biobankdetailID = 0;
	biobankqualitydataandsamples = 30836;
	accessibility = 30829;
	collections = 30850; //collections
}

// Core Information
if(coreinformationId != 0){
	List<DDLRecord> rec = DDLRecordLocalServiceUtil.getRecords(coreinformationId);
	for(DDLRecord r : rec) {
		Field f_name = r.getField("name");
		Field f_acronym = r.getField("acronym");
		Field f_type = r.getField("type");
		Field f_subtype = r.getField("subtype");
		Field f_description = r.getField("description");
		Field f_organisation = r.getField("organisation");
		Field f_legalentity = r.getField("legalEntity");
		Field f_maincontact = r.getField("mainContact");
		Field f_role = r.getField("role");
		Field f_diseasescovered = r.getField("diseasesCovered");
		Field f_countrycode = r.getField("countryCode");
		Field f_geographicareacovered = r.getField("geographicAreaCovered");
%>
<h3><%if(f_acronym != null) { %>
<%= f_acronym.getValue() %>
<%}%> - <%if(f_name != null) { %><%= f_name.getValue() %><%}%></h3>
<table border="0">
<tr>
<td>Main Contact</td>
<td><%if(f_maincontact != null) { %><%= f_maincontact.getValue() %><%}%></td>
</tr>
<td>Country</td>
<td><%if(f_countrycode != null) { %><%= f_countrycode.getValue() %><%}%></td>
</tr>
</table>

<%
	}
} // ENDE Core Information
%>

<%
// Qualaty
if(biobankqualitydataandsamples != 0){
	List<DDLRecord> rec = DDLRecordLocalServiceUtil.getRecords(biobankqualitydataandsamples);
	for(DDLRecord r : rec) {
		Field f_qq1 = r.getField("Is_the_biobank_part_of_an_accreditation_certification_program");
		Field f_qq2 = r.getField("Accreditation__Certification_Organsiation_");
		
%>
<h5>Quality</h5>
<table border="0">
<tr>
<td>Is the biobank part of an accreditation/certification program:</td>
<td><%if(f_qq1 != null) { %><%= qq1.get(f_qq1.getValue()).toString() %><%}%></td>
</tr>
<tr>
<td>Accreditation, Certification Organsiation:</td>
<td><%if(f_qq2 != null) { %><%= f_qq2.getValue() %><%}%></td>
</tr>
</table>

<%
	}
} // ENDE Quality
%>
<%
} // ENDE Organisationrun
%>
