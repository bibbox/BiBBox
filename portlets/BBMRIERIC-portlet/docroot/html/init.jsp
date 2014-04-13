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

<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<%@ page import="java.util.List" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
PortletPreferences prefs = renderRequest.getPreferences();
%>