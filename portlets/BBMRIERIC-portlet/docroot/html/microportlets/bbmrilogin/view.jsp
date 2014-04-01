<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.PrefsPropsUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys" %>

<portlet:defineObjects />

<div class="bbmrieric-logincontainer">
	<!-- <div class="bbmrieric-logincontainer-webinarlogin">
		Webinar <span class="bbmrieric-bold">LOGIN</span>
		<div class="bbmrieric-logincontainer-square-webinarlogin"></div>
	</div> -->
	<div class="bbmrieric-logincontainer-login">
		<% if(themeDisplay.isSignedIn()) { %>
			<aui:a href="<%= PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.DEFAULT_LANDING_PAGE_PATH) %>">Member <span class="bbmrieric-bold">AREA</span></aui:a>
		<% } else { %>
			<aui:a href="<%= themeDisplay.getURLSignIn() %>">Member <span class="bbmrieric-bold">LOGIN</span></aui:a>
		<% } %>
		<div class="bbmrieric-logincontainer-square-login"></div>
	</div>
</div>
<hr style="background-color:#FFFFFF; border-width:0; color:#FFFFFF; height:1px; lineheight:0; display: inline-block; text-align: left; width:100%;margin-bottom: 5px;margin-top: 10px;">
