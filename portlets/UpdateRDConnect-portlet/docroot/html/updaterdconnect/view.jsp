<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
 

<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.ActionRequest" %>
<%@ page import="javax.portlet.PortletPreferences" %>
 
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys"%>

<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.lang.Math" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortalPermissionUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortletPermissionUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.PortletURL" %>

<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.model.Group"%>
<%@ page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="com.liferay.portlet.dynamicdatamapping.storage.Fields" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.storage.Field" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecord" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalServiceUtil" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="com.liferay.portal.service.CountryServiceUtil" %>

<%@ page import="com.liferay.portal.service.OrganizationLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="com.liferay.portal.model.Organization" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
PortletPreferences prefs = renderRequest.getPreferences();
%>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String redirect = ParamUtil.getString(request, "redirect");
%>

<%= themeDisplay.getCompanyId() %>

This is the <b>Update Rd Connect</b> portlet in View mode.

<!-- <div style="border-style: solid;border-width: 3px;border-color: #3300FF;background-color: #CCFFCC;"> 

	Update Address:

	<portlet:actionURL name="updateRDCAddress" var="updateRDCAddressURL" windowState="normal" />

	<aui:form action="<%= updateRDCAddressURL %>" method="POST" name="fm">
		<aui:fieldset>
			<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		</aui:fieldset>
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel"  onClick="<%= redirect %>" />
		</aui:button-row>
	</aui:form>
</div>

<div style="border-style: solid;border-width: 3px;border-color: #3300FF;background-color: #CCFFCC;"> 

	Update Core:

	<portlet:actionURL name="updateRDCCore" var="updateRDCCoreURL" windowState="normal" />

	<aui:form action="<%= updateRDCCoreURL %>" method="POST" name="fm">
		<aui:fieldset>
			<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		</aui:fieldset>
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel"  onClick="<%= redirect %>" />
		</aui:button-row>
	</aui:form>
</div>

<div style="border-style: solid;border-width: 3px;border-color: #3300FF;background-color: #CCFFCC;"> 

	Update Accessibility:

	<portlet:actionURL name="updateRDCAccessibility" var="updateRDCAccessibilityURL" windowState="normal" />

	<aui:form action="<%= updateRDCAccessibilityURL %>" method="POST" name="fm">
		<aui:fieldset>
			<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		</aui:fieldset>
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel"  onClick="<%= redirect %>" />
		</aui:button-row>
	</aui:form>
</div>

<div style="border-style: solid;border-width: 3px;border-color: #3300FF;background-color: #CCFFCC;"> 

	Update Quality:

	<portlet:actionURL name="updateRDCQuality" var="updateRDCQualityURL" windowState="normal" />

	<aui:form action="<%= updateRDCQualityURL %>" method="POST" name="fm">
		<aui:fieldset>
			<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		</aui:fieldset>
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel"  onClick="<%= redirect %>" />
		</aui:button-row>
	</aui:form>
</div> -->

<div style="border-style: solid;border-width: 3px;border-color: #3300FF;background-color: #CCFFCC;"> 

	Update Phone:

	<portlet:actionURL name="updateRDCPhone" var="updateRDCPhoneURL" windowState="normal" />

	<aui:form action="<%= updateRDCPhoneURL %>" method="POST" name="fm">
		<aui:fieldset>
			<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		</aui:fieldset>
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel"  onClick="<%= redirect %>" />
		</aui:button-row>
	</aui:form>
</div>
