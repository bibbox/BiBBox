<%@ include file="/html/symbol/init.jsp" %>  

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Icons icon = (Icons)row.getObject();
%>

<img src="<%= icon.getIconurl() %>" style="background-color: #b0c4de;padding: 5px;">