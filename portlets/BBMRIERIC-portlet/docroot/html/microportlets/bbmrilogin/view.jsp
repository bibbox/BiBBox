<%@ include file="/html/init.jsp" %>

<portlet:defineObjects />

<div class="bbmrieric-logincontainer">
	<div class="bbmrieric-logincontainer-webinarlogin">
		Webinar <span class="bbmrieric-bold">LOGIN</span>
		<div class="bbmrieric-logincontainer-square-webinarlogin"></div>
	</div>
	<div class="bbmrieric-logincontainer-login">
		<% if(themeDisplay.isSignedIn()) { %>
			<aui:a href="<%= themeDisplay.getURLSignOut() %>">Intranet <span class="bbmrieric-bold">LOGOUT</span></aui:a>
		<% } else { %>
			<aui:a href="<%= themeDisplay.getURLSignIn() %>">Intranet <span class="bbmrieric-bold">LOGIN</span></aui:a>
		<% } %>
		<div class="bbmrieric-logincontainer-square-login"></div>
	</div>
</div>
