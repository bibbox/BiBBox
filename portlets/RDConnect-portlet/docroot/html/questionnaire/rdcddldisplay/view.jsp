<%@include file="/html/init.jsp" %>
<%@ page import="java.util.UUID;" %>

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