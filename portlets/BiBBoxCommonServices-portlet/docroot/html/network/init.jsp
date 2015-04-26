<%@ include file="/html/init.jsp" %> 

<%@ page import="at.graz.meduni.liferay.portlet.bibbox.service.model.Networks"%>
<%@ page import="at.graz.meduni.liferay.portlet.bibbox.service.service.NetworksLocalServiceUtil"%>

<%@ page import="java.util.Date" %>

<!-- Roles -->
<%@ page import="com.liferay.portal.service.RoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.Role" %>
<%@ page import="com.liferay.portal.model.RoleConstants" %>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.UserGroupRole" %>

<!-- Read all DDMStructures for DDL creation -->
<%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.storage.StorageEngineUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatamapping.util.DDMUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>

<!-- Website -->
<%@ page import="com.liferay.portal.service.WebsiteLocalServiceUtil" %>

<!-- Events -->
<%@ page import="at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent"%>
<%@ page import="at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.RDConnectEventLocalServiceUtil"%>