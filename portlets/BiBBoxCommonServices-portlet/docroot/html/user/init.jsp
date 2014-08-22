<%@ include file="/html/init.jsp" %> 

<%@ page import="com.liferay.portal.kernel.util.KeyValuePair" %>
<%@ page import="com.liferay.portal.kernel.util.KeyValuePairComparator" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>

<!-- Roles -->
<%@ page import="com.liferay.portal.service.RoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.Role" %>
<%@ page import="com.liferay.portal.model.RoleConstants" %>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.UserGroupRole" %>

<!-- User -->
<%@ page import="com.liferay.portal.model.User" %>

<!-- Organization -->
<%@ page import="com.liferay.portal.service.OrganizationLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.Organization" %>

<!-- Invitation -->
<%@ page import="at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation" %>
<%@ page import="at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationLocalServiceUtil" %>
<%@ page import="at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation" %>
<%@ page import="at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationOrganisationLocalServiceUtil" %>

<!-- URL -->
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>

<!-- Counter from insert -->
<%@ page import="com.liferay.counter.service.CounterLocalServiceUtil" %>