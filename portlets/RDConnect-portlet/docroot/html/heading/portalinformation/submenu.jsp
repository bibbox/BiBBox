
<%--<%@include file="/html/init.jsp" %>
/*
 * The Submenu of the heading Portlet Information
 */
 --%>
<%

List<Layout> pagelayouts = themeDisplay.getLayouts();

for(Layout l :pagelayouts) {
	String pagesurl = themeDisplay.getURLPortal() + "/web" + themeDisplay.getSiteGroup().getFriendlyURL() + l.getFriendlyURL();
	
	%>	
	<aui:a href="<%= pagesurl %>"><%= l.getName() %></aui:a>
	<%
}
%>