<%@ include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.model.Group" %>
<%@ page import="com.liferay.portal.kernel.util.PrefsPropsUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys" %>

<portlet:defineObjects />
<div class="bbmri-eric-member-area-top-menue-container-committees-dropdown">
	<ul>
		<li class="bbmri-eric-member-area-top-menue-container-committees-dropdown-ul-li">COMMITTEES<img src="<%=request.getContextPath()%>/images/arrow.png" height="9px" width="13px" />
			<ul>
				<% 
				List<Group> groups = themeDisplay.getUser().getMySiteGroups();
				
				for(Group group : groups) {
				   String url = themeDisplay.getURLPortal() + group.getPathFriendlyURL(false, themeDisplay) + group.getFriendlyURL();
				%>
				<li>
				  <aui:a href="<%= url %>"><%= group.getDescriptiveName() %></aui:a>
				</li>
				<%
				}
				%>
		   </ul>
	   </li>
	</ul>
</div>