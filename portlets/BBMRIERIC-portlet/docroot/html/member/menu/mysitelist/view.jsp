<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.model.Group" %>
<%@ page import="com.liferay.portal.kernel.util.PrefsPropsUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys" %>

<portlet:defineObjects />

<ul style="float: right;">
<li style="list-style-type: none;">
		<div style="float: left;">
			<div class="<%= themeDisplay.getURLCurrent().contains(PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.DEFAULT_LANDING_PAGE_PATH)) ? "bbmri-eric-square-orange" : "bbmri-eric-square-blue" %>"></div>
			<div style="float: left;color: #184B8A;">
				<aui:a href="<%= PrefsPropsUtil.getString(themeDisplay.getCompanyId(), PropsKeys.DEFAULT_LANDING_PAGE_PATH) %>">Overview</aui:a>
			</div>
		</div>
	<br>
	</li>
<% 
List<Group> groups = themeDisplay.getUser().getMySiteGroups();

for(Group group : groups) {
	String url = themeDisplay.getURLPortal() + group.getPathFriendlyURL(false, themeDisplay) + group.getFriendlyURL();
%>
	<li style="list-style-type: none;">
		<div style="float: left;">
			<div class="<%= themeDisplay.getSiteGroupId() == group.getGroupId() ? "bbmri-eric-square-orange" : "bbmri-eric-square-blue" %>"></div>
			<div style="float: left;color: #184B8A;">
				<aui:a href="<%= url %>"><%= group.getDescriptiveName() %></aui:a>
			</div>
		</div>
	<br>
	</li>
<%
}
%>
</ul>