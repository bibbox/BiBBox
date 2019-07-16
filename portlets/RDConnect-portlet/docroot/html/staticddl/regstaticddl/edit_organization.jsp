<!-- 
POPUP
RDConnect-Portlet
staticddl/regstaticddl/edit_organization.jsp
 -->
 
<%@ include file="/html/init.jsp"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
long recordId = ParamUtil.getLong(request, "recordId");
%>

<h1>Organizations <%= recordId %></h1>