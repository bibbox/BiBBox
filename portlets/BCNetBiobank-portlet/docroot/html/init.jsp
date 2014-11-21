<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.KeyValuePair" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>


<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="com.liferay.portal.model.Organization" %>
<%@page import="com.liferay.portal.model.Group"%>

<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>

<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>




<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>


<%@ page import="com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster" %>
<%@ page import="com.bcnet.portlet.biobank.model.BiobankAttributeLists" %>
<%@ page import="com.bcnet.portlet.biobank.model.JuristicPerson" %>
<%@ page import="com.bcnet.portlet.biobank.model.Contact" %>
<%@ page import="com.bcnet.portlet.biobank.model.Country" %>
<%@ page import="com.bcnet.portlet.biobank.model.Biobank" %>
<%@ page import="com.bcnet.portlet.biobank.model.BiobankGeneralInformation" %>
<%@ page import="com.bcnet.portlet.biobank.service.BiobankAtrributeListsMasterLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.JuristicPersonLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.ContactLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.CountryLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.BiobankLocalServiceUtil"%>
<%@ page import="com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalServiceUtil"%>



<liferay-theme:defineObjects />

<portlet:defineObjects />