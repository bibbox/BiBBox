<%@ include file="/html/iris/irislinkedopendata/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<portlet:defineObjects />

<%

Long personid = ParamUtil.getLong(request, "personid");
Long organisationid = ParamUtil.getLong(request, "organisationid");

String rdf_header = "";
rdf_header += "@prefix rdf: &#60;http://www.w3.org/1999/02/22-rdf-syntax-ns#&#62;<br>";
rdf_header += "@prefix dc: &#60;http://purl.org/dc/elements/1.1/&#62;<br>";
rdf_header += "@prefix ex: &#60;http://example.org/stuff/1.0/&#62;<br>";
rdf_header += "@prefix miabis: &#60;http://...&#62;<br>";

User person = UserLocalServiceUtil.getUser(personid);

String rdf_uri = "http://rd-connect.bibbox.org/wobr/-/web-of-rdconnect/" + organisationid + "/person/" + personid;
String rdf_type = "rdf:type: foaf:Person<br>";
String rdf_name =  "foaf:name \"" + person.getFullName() + "\"<br>";
String rdf_mail =  "foaf:mbox \"" + person.getEmailAddress() + "\"<br>";

String rdf_organisation = "miabis:organisation (<br>";
List<Organization> organisations = OrganizationLocalServiceUtil.getUserOrganizations(personid);
for(Organization organization : organisations) {
	String tmp_uri = "http://rd-connect.bibbox.org/wobr/-/web-of-rdconnect/" + organization.getOrganizationId();
	rdf_organisation += "&#60;<a href=\"" + tmp_uri + "\">" + tmp_uri + "</a>&#62;<br>";
}
rdf_organisation += ").<br>";

%>
<%= rdf_header %>
<br>
&#60;<a href="<%= rdf_uri %>"><%= rdf_uri %></a>&#62;<br>
<%= rdf_type %>
<%= rdf_name %>
<%= rdf_mail %>

<%= rdf_organisation %>