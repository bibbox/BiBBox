<%@include file="/html/init.jsp" %>

<portlet:defineObjects />


<div class="rdchubportalinfo">
	<div class="rdchubportalinfologo">
		<img alt="logo" src="<%= request.getContextPath() %>/images/RDLogoglobe.png" width="180px" height="180px" />
	</div>
	<div class="rdchubportalinfoheader">
		<h3>Curator Portal - RD-Connect</h3>
	</div>
	<div class="rdchubportalinfosubmenu">
	<div id='cssmenu'>
	<ul>
		<%
		List<Layout> pagelayouts = themeDisplay.getLayouts();

		int width_all = 906 - pagelayouts.size() +1;
		int width = (int)Math.floor(width_all/pagelayouts.size());
		int offset = width_all - (width*pagelayouts.size());
		
		for(Layout l : pagelayouts) {
			String pagesurl = themeDisplay.getURLPortal() + "/web" + themeDisplay.getSiteGroup().getFriendlyURL() + l.getFriendlyURL();
			
			String aktiveli = "<li class='rdconnect-heading-submenue-border' style='width:" + width + "px;'>";
			if(themeDisplay.getURLCurrent().equalsIgnoreCase("/web" + themeDisplay.getSiteGroup().getFriendlyURL() + l.getFriendlyURL())
					|| themeDisplay.getURLCurrent().equalsIgnoreCase(l.getFriendlyURL())) {
				aktiveli = "<li class='active rdconnect-heading-submenue-border' style='width:" + (width+offset) + "px;'>";
			} else {
				aktiveli = "<li class='rdconnect-heading-submenue-border' style='width:" + width + "px;'>";
			}
			
			%>	
			<%= aktiveli %><aui:a href="<%= pagesurl %>"><%= l.getName() %></aui:a></li>
			<%
		}
		%>
	</ul>
	</div>
	</div>
</div>