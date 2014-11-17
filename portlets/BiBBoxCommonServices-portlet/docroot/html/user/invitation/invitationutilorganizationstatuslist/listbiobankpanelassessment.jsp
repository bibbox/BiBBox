<!-- 
BiBBoxCommonServices
user/invitation

 -->
<%@ include file="/html/user/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
long organizationId = ParamUtil.getLong(request, "organizationId");
String redirect = ParamUtil.getString(request, "redirect");
%>