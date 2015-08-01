<%@ include file="/html/init.jsp" %> 

<%@ page import="com.liferay.portal.kernel.util.KeyValuePair" %>
<%@ page import="com.liferay.portal.kernel.util.KeyValuePairComparator" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

<!-- Roles -->
<%@ page import="com.liferay.portal.service.RoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.Role" %>
<%@ page import="com.liferay.portal.model.RoleConstants" %>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.UserGroupRole" %>

<!-- User -->
<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="com.liferay.portlet.usersadmin.util.UsersAdminUtil" %>
<%@ page import="com.liferay.portal.model.UserConstants" %>

<!-- Organization -->
<%@ page import="com.liferay.portal.service.OrganizationLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.Organization" %>

<!-- Service Project Imports -->
<%@ page import="at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration" %>
<%@ page import="at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationLocalServiceUtil" %>

<!-- URL -->
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>

<!-- Counter from insert -->
<%@ page import="com.liferay.counter.service.CounterLocalServiceUtil" %>

<!-- DDLs -->
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil" %>

<!-- Website -->
<%@ page import="com.liferay.portal.service.WebsiteLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.Website" %>

<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.LinkedHashMap" %>

<!-- Symbol -->
<%@ page import="at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration"%>
<%@ page import="at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationLocalServiceUtil"%>
<%@ page import="at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration"%>
<%@ page import="at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration"%>
<%@ page import="at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalServiceUtil"%>
<%@ page import="at.graz.meduni.liferay.portlet.bibbox.model.Icons"%>
<%@ page import="at.graz.meduni.liferay.portlet.bibbox.service.IconsLocalServiceUtil"%>
