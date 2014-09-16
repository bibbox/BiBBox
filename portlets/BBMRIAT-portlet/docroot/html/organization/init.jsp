<%@ include file="/html/init.jsp" %> 

<%@ page import="com.liferay.portal.kernel.util.KeyValuePair" %>
<%@ page import="com.liferay.portal.kernel.util.KeyValuePairComparator" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>

<!-- Includes for searching the Site Templates -->
<%@ page import="com.liferay.portal.service.LayoutSetPrototypeServiceUtil" %>
<%@ page import="com.liferay.portal.model.LayoutSetPrototype" %>

<!-- Read all DDMStructures for DDL creation -->
<%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.storage.StorageEngineUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.util.DDMUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>

<!-- Includes for regex -->
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.regex.Matcher" %>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.liferay.portal.kernel.util.ArrayUtil" %>

<%@ page import="com.liferay.portal.service.ServiceContext" %>

<!-- Roles -->
<%@ page import="com.liferay.portal.service.RoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.Role" %>
<%@ page import="com.liferay.portal.model.RoleConstants" %>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.UserGroupRole" %>

<!-- Service Imports -->
<%@ page import="at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink" %>
<%@ page import="at.graz.meduni.liferay.portlet.bbmriat.service.service.OrganizationlinkLocalServiceUtil" %>