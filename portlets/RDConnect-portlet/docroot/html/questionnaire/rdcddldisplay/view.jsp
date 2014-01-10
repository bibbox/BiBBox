<%@include file="/html/init.jsp" %>
<%@ page import="java.util.UUID" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>

<portlet:defineObjects />

<%
String currentURL = PortalUtil.getCurrentURL(request);
 
PortletPreferences preferences = renderRequest.getPreferences();
 
String portletResource = ParamUtil.getString(request, "portletResource");
 
/*if (Validator.isNotNull(portletResource)) {
preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}*/
if(portletResource == null) {
preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}
 
String  email = preferences.getValue("email", StringPool.BLANK);
String  subject = preferences.getValue("subject", StringPool.BLANK);

%>

<% 

com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
long organizationId = 0;
// Überprüfung ob das Portlet auf einer Organistions Seite ist
if (currentGroup.isOrganization()) {
  	organizationId = currentGroup.getClassPK();
}
Organization organisations = OrganizationLocalServiceUtil.getOrganization(organizationId);
%>
<br>OrganizationId: <%= organizationId %> <br>
<%
List<DDLRecordSet> l = DDLRecordSetLocalServiceUtil.getRecordSets(organisations.getGroupId());
for(DDLRecordSet rs : l) {
	
%>
<%= rs.getName() %>
<% } %>
<br>
<hr>
This is the <b>Rdcddl Display</b> portlet in View mode.


<%=email %>
<%=subject %>

<%
	/*VelocityPortletPreferences vprefs = new VelocityPortletPreferences();
   	vprefs.setValue("portlet-setup-show-borders", "false");
   	vprefs.setValue("contentURL", "http://site.local/guest/guest-site-navigation.html");
   	
   	defaultPreferences=" vprefs.toString()"*/
   	String instanceid = themeDisplay.getPortletDisplay().getInstanceId();
   	//String instanceid = UUID.randomUUID().toString().replaceAll("-", "");
   	String portalid = "169_INSTANCE_I" + instanceid;

%>

<liferay-portlet:runtime portletName="<%= portalid %>" />