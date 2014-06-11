<%@ include file="/html/iris/irislinkedopendata/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<portlet:defineObjects />

<%

Integer success = ParamUtil.getInteger(request, "resourcePrimKey");

String rdf_header = "";

rdf_header += "@prefix rdf: &#60;http://www.w3.org/1999/02/22-rdf-syntax-ns#&#62;<br>";
rdf_header += "@prefix dc: &#60;http://purl.org/dc/elements/1.1/&#62;<br>";
rdf_header += "@prefix ex: &#60;http://example.org/stuff/1.0/&#62;<br>";
rdf_header += "@prefix miabis: &#60;http://...&#62;<br>";

%>

<%= rdf_header %>
<br>

<%
List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(themeDisplay.getCompanyId(), 0);
for(Organization organization : organizations) {
	if(organization.getName().equalsIgnoreCase("National Biobank of Test")) {
		continue;
	}
	if(organization.getName().equalsIgnoreCase("BBMUSK")) {
		continue;
	}
	if(organization.getName().equalsIgnoreCase("Medical Univeristy of Shi'Kahr")) {
		continue;
	}
	String linkname = organization.getName().toLowerCase().replaceAll(" ", "_");
	String rdf_type = "";
	String rdf_web = "";
	String rdf_uri = "http://rd-connect.bibbox.org/wobr/-/web-of-rdconnect/" + organization.getOrganizationId();
	
	List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
	for(DDLRecordSet rdc_rs : rdc_recordlist) {
		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
		if(rdc_rsname.equals("core")) { 
			List<DDLRecord> records = rdc_rs.getRecords();
         for(DDLRecord record : records) {
        	   if(record.getFieldValue("Radio2493") != null) {
        		   String type = record.getFieldValue("Radio2493").toString();
        		   if(type.equalsIgnoreCase("[bb]") || type.equalsIgnoreCase("[\"bb\"]")) {
        			   rdf_type += "rdf:type: miabis:biobank;<br>";
               } else if(type.equalsIgnoreCase("[reg]") || type.equalsIgnoreCase("[\"reg\"]")) {
            	   rdf_type += "rdf:type: miabis:registry;<br>";
               } else {
            	   rdf_type += "rdf:type: miabis:biobank;<br>";
            	   rdf_type += "rdf:type: miabis:registry;<br>";
               }
        	   }
         }
		}
	}
	
	for(com.liferay.portal.model.Website website : WebsiteLocalServiceUtil.getWebsites(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId())) {
		rdf_web += "miabis:web " + website.getUrl() + ";<br>";
   }
	
	User maincontact = null;
    List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
    for(User usertmp : userlist) {
       List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(usertmp.getUserId(), organization.getGroup().getGroupId());
       for (UserGroupRole ugr : usergrouprolles) {
          if(ugr.getRole().getName().equalsIgnoreCase("BiobanK-REG-MAINCONTACT")
                || ugr.getRole().getName().equalsIgnoreCase("Biobank, Registry Main Contact")
                || ugr.getRole().getName().equalsIgnoreCase("BiobanK-REG-MAINCONTACT")) {
             maincontact =  usertmp;
          }
       }
    }
    String contact_uri = "";
    if(maincontact != null) {
    	String tmpuri = rdf_uri + "/person/" + maincontact.getUserId();
    	contact_uri = "miabis:contact &#60;<a href=\"" + tmpuri + "\">" + tmpuri + "</a>&#62;;<br>"; 
    	 
    }
%>
   &#60;<a href="<%= rdf_uri %>"><%= rdf_uri %></a>&#62;<br>
   <%= rdf_type %>
   miabis:name "<%= organization.getName() %>";<br>
   <%= rdf_web %>
   <%= contact_uri %>
   
   <br>
<%
}
%>