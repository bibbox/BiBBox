<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>

<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.ActionRequest" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="java.util.List" %>

<%@ page import="at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt"%>
<%@ page import="at.graz.hmmc.liferay.portlet.puch.service.PuchMuseumsObjektLocalServiceUtil"%>
<%@ page import="at.graz.hmmc.liferay.portlet.puch.model.Configuration"%>
<%@ page import="at.graz.hmmc.liferay.portlet.puch.service.ConfigurationLocalServiceUtil"%>
<%@ page import="at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration"%>
<%@ page import="at.graz.hmmc.liferay.portlet.puch.service.ParameterConfigurationLocalServiceUtil"%>
<%@ page import="at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration"%>
<%@ page import="at.graz.hmmc.liferay.portlet.puch.service.ParameterOptionsConfigurationLocalServiceUtil"%>
<%@ page import="at.graz.hmmc.liferay.portlet.puch.model.ObjectData"%>
<%@ page import="at.graz.hmmc.liferay.portlet.puch.service.ObjectDataLocalServiceUtil"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
PortletPreferences prefs = renderRequest.getPreferences();
%>