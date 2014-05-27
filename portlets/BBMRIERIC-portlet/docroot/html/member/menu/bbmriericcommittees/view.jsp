<%@ include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.model.Group" %>
<%@ page import="com.liferay.portal.kernel.util.PrefsPropsUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>

<portlet:defineObjects />
<div class="bbmri-eric-member-area-top-menue-container-menu-home">
   <aui:a href="/web/home"><img src="<%=request.getContextPath()%>/images/home_1.png" height="16px" width="19px" /></aui:a>
</div>
<div class="bbmri-eric-member-area-top-menue-container-menu-current-site">
   <ul><li><%= themeDisplay.getSiteGroupName() %></li></ul>
</div>
<div class="bbmri-eric-member-area-top-menue-container-committees">
	<ul>
		<li class="bbmri-eric-member-area-top-menue-container-committees-ul-li">COMMITTEES<img src="<%=request.getContextPath()%>/images/arrow.png" height="9px" width="13px" />
			<ul>
				<% 
				List<Group> groups = themeDisplay.getUser().getMySiteGroups();
				
				for(Group group : groups) {
					if(group.getDescriptiveName().startsWith("WG")) {
						continue;
					}
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
<div class="bbmri-eric-member-area-top-menue-container-menu-workinggroups">
   <ul>
      <li class="bbmri-eric-member-area-top-menue-container-menu-workinggroups-ul-li">WORKINGGROUPS<img src="<%=request.getContextPath()%>/images/arrow.png" height="9px" width="13px" />
         <ul>
            <% 
            
            for(Group group : groups) {
               if(!group.getDescriptiveName().startsWith("WG")) {
                  continue;
               }
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
<div class="bbmri-eric-member-area-top-menue-container-menu-user">
<%
Group controlPanelGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "Control Panel");
long controlPanelPlid = LayoutLocalServiceUtil.getDefaultPlid(controlPanelGroup.getGroupId(), true);
LiferayPortletURL editmyusersURL = PortletURLFactoryUtil.create(request, "2", controlPanelPlid, "RENDER_PHASE");
editmyusersURL.setParameter("p_p_state", "maximized");
editmyusersURL.setParameter("controlPanelCategory", "my");
String portletResource = ParamUtil.getString(request, "portletResource");

/*editmyusersURL = PortletURLFactoryUtil.create(request, "125", controlPanelPlid, "RENDER_PHASE");
editmyusersURL.setParameter("struts_action", "/users_admin/edit_user");
editmyusersURL.setParameter("p_p_state", "maximized");
editmyusersURL.setParameter("p_u_i_d", String.valueOf(themeDisplay.getUserId()));*/
%>
   <ul><li>
	<% if(themeDisplay.isSignedIn()) { %>
	<img style="opacity:0.5;filter:alpha(opacity=50);" alt="myaccount" height="18px" width="10px" src="<%= request.getContextPath() %>/images/profile.png" />
	<ul>
	<li id="portalmyuseredit" style="cursor:pointer;"><%= themeDisplay.getUser().getFullName() %></li>
	<li class="sign-out"><aui:a href="<%= themeDisplay.getURLSignOut() %>">Sign Out</aui:a></li>
	</ul>
	<% } else { %>
	<img alt="myaccount" height="18px" width="18px" src="<%= request.getContextPath() %>/images/signinkey.png" />
	<ul>
	<li class="sign-in"><aui:a href="<%= themeDisplay.getURLSignIn() %>">Sign In</aui:a></li>
	<li style="visibility:hidden;" id="portalmyuseredit" style="cursor:pointer;"><%= themeDisplay.getUser().getFullName() %></li>
	</ul>
	<% } %>
	</li></ul>
</div>
<aui:script use="aui-base">
            A.all('#portalmyuseredit').on(
               'click',
               function(event) {
                  Liferay.Util.selectEntity(
                     {
                        dialog: {
                           constrain: true,
                           modal: true,
                           width: 1000
                        },
                        id: '_<%=HtmlUtil.escapeJS(portletResource)%>_selectFolder',
                        title: 'Edit my account.',
                        uri: '<%=editmyusersURL.toString()%>'
                     }
                  );
               }
            );
</aui:script>