<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

This is the <b>Rdcddl Display</b> portlet in Config mode.

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

<form action="<liferay-portlet:actionURL portletConfiguration="true" />"
method="post" name="<portlet:namespace />fm">
 
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
 
<table class="lfr-table">
<tr>
    <td>Email</td>
        <td><input type="text" name="<portlet:namespace />email"  value="<%=email %>"/>
    </td>
 
    <td>Subject</td>
        <td><input type="text" name="<portlet:namespace />subject"  value="<%=subject %>" />
    </td>
</tr>
<tr>
       <td colspan="2">
            <input type="button" value="<liferay-ui:message key="save" />"
onClick="submitForm(document.<portlet:namespace />fm);" />
       </td>
</tr>
</table>
</form>
