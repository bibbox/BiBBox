
<%--<%@include file="/html/init.jsp" %>
/*
 * The Submenu of the heading Portlet Information
 */
 --%>

<div id='cssmenu'>
<ul>
<%

List<Layout> pagelayouts = themeDisplay.getLayouts();

for(Layout l : pagelayouts) {
	String pagesurl = themeDisplay.getURLPortal() + "/web" + themeDisplay.getSiteGroup().getFriendlyURL() + l.getFriendlyURL();
	
	String aktiveli = "<li>";
	if(themeDisplay.getURLCurrent().equalsIgnoreCase("/web" + themeDisplay.getSiteGroup().getFriendlyURL() + l.getFriendlyURL())
			|| themeDisplay.getURLCurrent().equalsIgnoreCase(l.getFriendlyURL())) {
		aktiveli = "<li class='active' >";
	} else {
		aktiveli = "<li>";
	}
	
	%>	
	<%= aktiveli %><aui:a href="<%= pagesurl %>"><%= l.getName() %></aui:a></li>
	<%
}
%>
</ul>
</div>