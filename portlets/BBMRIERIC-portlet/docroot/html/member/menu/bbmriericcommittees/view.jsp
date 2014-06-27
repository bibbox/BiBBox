<%@ include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.model.Group" %>
<%@ page import="com.liferay.portal.kernel.util.PrefsPropsUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="java.io.Serializable" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.liferay.portlet.asset.service.AssetTagServiceUtil" %>
<%@ page import="com.liferay.portlet.asset.model.AssetTag" %>
<%@ page import="com.liferay.portal.model.UserGroupRole" %>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.io.ObjectOutputStream" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>

<portlet:defineObjects />
<div class="bbmri-eric-member-area-top-menue-container-menu-home">
   <aui:a href="/web/home"><img src="<%=request.getContextPath()%>/images/home_1.png" height="16px" width="19px" /></aui:a>
</div>
<div class="bbmri-eric-member-area-top-menue-container-menu-current-site">
<%
String currentURL = PortalUtil.getCurrentURL(request);
String url_home = themeDisplay.getURLPortal() + themeDisplay.getSiteGroup().getPathFriendlyURL(false, themeDisplay) + themeDisplay.getSiteGroup().getFriendlyURL();

%>
   <aui:a href="<%= url_home %>"><ul><li><%= themeDisplay.getSiteGroupName() %></li></ul></aui:a>
</div>
<div class="bbmri-eric-member-area-top-menue-container-adhoc">
   <ul>
      <li class="bbmri-eric-member-area-top-menue-container-adhoc-ul-li">AD-HOC<img src="<%=request.getContextPath()%>/images/arrow.png" height="13px" width="19px" />
         <ul>
            <% 
            List<Group> groups = themeDisplay.getUser().getMySiteGroups();
            
            for(Group group : groups) {
               List<AssetTag> tags = AssetTagServiceUtil.getTags(Group.class.getName(), group.getPrimaryKey());
               for(AssetTag tag : tags) {
               
	               if(tag.getName().equalsIgnoreCase("ad-hoc working group")) {
	               
	                  String url = themeDisplay.getURLPortal() + group.getPathFriendlyURL(false, themeDisplay) + group.getFriendlyURL();
	                  //String state = JSONFactoryUtil.looseDeserialize(group.getExpandoBridge().getAttribute("state").toString(), Company.class);
	                	//String state = JSONFactoryUtil.deserialize(group.getExpandoBridge().getAttribute("state").toString()).toString();
	                  
	                  
	                  String grouptitle = group.getDescriptiveName();
	                  /*if(state.equalsIgnoreCase("closed")) {
	                	  grouptitle = state + group.getDescriptiveName();
	                  } else {
	                	  grouptitle = state + group.getDescriptiveName();
	                  }*/
	                  %>
	                  <li>
	                    <aui:a href="<%= url %>"><%= grouptitle %></aui:a>
	                  </li>
	                  <%
	               }
               }
            }
            %>
         </ul>
      </li>
   </ul>
</div>
<div class="bbmri-eric-member-area-top-menue-container-committees">
	<ul>
		<li class="bbmri-eric-member-area-top-menue-container-committees-ul-li">COMMITTEES<img src="<%=request.getContextPath()%>/images/arrow.png" height="13px" width="19px" />
			<ul>
				<% 
				groups = themeDisplay.getUser().getMySiteGroups();
				
				for(Group group : groups) {
					List<AssetTag> tags = AssetTagServiceUtil.getTags(Group.class.getName(), group.getPrimaryKey());
					for(AssetTag tag : tags) {
						if(tag.getName().equalsIgnoreCase("committee")) {
						
							String url = themeDisplay.getURLPortal() + group.getPathFriendlyURL(false, themeDisplay) + group.getFriendlyURL();
		                     //String state = JSONFactoryUtil.looseDeserialize(group.getExpandoBridge().getAttribute("state").toString(), Company.class);
		                     //String state = JSONFactoryUtil.deserialize(group.getExpandoBridge().getAttribute("state").toString()).toString();
		                     
		                     
		                     String grouptitle = group.getDescriptiveName();
		                     /*if(state.equalsIgnoreCase("closed")) {
		                       grouptitle = state + group.getDescriptiveName();
		                     } else {
		                       grouptitle = state + group.getDescriptiveName();
		                     }*/
		                     %>
		                     <li>
		                       <aui:a href="<%= url %>"><%= grouptitle %></aui:a>
		                     </li>
		                     <%
						}
					}
				}
				%>
		   </ul>
	   </li>
	</ul>
</div>
<div class="bbmri-eric-member-area-top-menue-container-menu-workinggroups">
   <ul>
      <li class="bbmri-eric-member-area-top-menue-container-menu-workinggroups-ul-li">WORKINGGROUPS<img src="<%=request.getContextPath()%>/images/arrow.png" height="13px" width="19px" />
         <ul>
            <% 
            
            for(Group group : groups) {
            	List<AssetTag> tags = AssetTagServiceUtil.getTags(Group.class.getName(), group.getPrimaryKey());
                for(AssetTag tag : tags) {
                
	                if(tag.getName().equalsIgnoreCase("working group")) {
	                	String url = themeDisplay.getURLPortal() + group.getPathFriendlyURL(false, themeDisplay) + group.getFriendlyURL();
	                     //String state = JSONFactoryUtil.looseDeserialize(group.getExpandoBridge().getAttribute("state").toString(), Company.class);
	                     //String state = JSONFactoryUtil.deserialize(group.getExpandoBridge().getAttribute("state").toString()).toString();
	                     
	                     
	                     String grouptitle = group.getDescriptiveName();
	                     /*if(state.equalsIgnoreCase("closed")) {
	                       grouptitle = state + group.getDescriptiveName();
	                     } else {
	                       grouptitle = state + group.getDescriptiveName();
	                     }*/
	                     %>
	                     <li>
	                       <aui:a href="<%= url %>"><%= grouptitle %></aui:a>
	                     </li>
	                     <%
	                }
                }
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

LiferayPortletURL editsitemembershipURL = PortletURLFactoryUtil.create(request, "174", controlPanelPlid, "RENDER_PHASE");
editsitemembershipURL.setDoAsGroupId(themeDisplay.getSiteGroupId());
editsitemembershipURL.setControlPanelCategory("current_site.users");
editsitemembershipURL.setParameter("redirect", currentURL);
editsitemembershipURL.setWindowState(WindowState.MAXIMIZED);
/*editmyusersURL = PortletURLFactoryUtil.create(request, "125", controlPanelPlid, "RENDER_PHASE");
editmyusersURL.setParameter("struts_action", "/users_admin/edit_user");
editmyusersURL.setParameter("p_p_state", "maximized");
editmyusersURL.setParameter("p_u_i_d", String.valueOf(themeDisplay.getUserId()));*/
%>
   <ul><li>
	<% if(themeDisplay.isSignedIn()) { %>
		<img style="opacity:0.5;filter:alpha(opacity=50);" alt="myaccount" height="18px" width="10px" src="<%= request.getContextPath() %>/images/profile.png" />
		<ul>
		<!-- User -->
		<%
      String imgPath = themeDisplay.getPathImage()+"/user_portrait?screenName="+themeDisplay.getUser().getScreenName()+"&amp;companyId="+themeDisplay.getUser().getCompanyId();
      %>
		<li id="portalmyuseredit" style="cursor:pointer;">
		<img style="opacity:0.5;filter:alpha(opacity=50);" alt="myaccount" height="20px" width="20px" src="<%= imgPath %>" />
		<%= themeDisplay.getUser().getFullName() %></li>
		<!-- Organisation Owner For membership Requests -->
      <%
      List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(themeDisplay.getUserId(), themeDisplay.getSiteGroupId());
      for (UserGroupRole ugr : usergrouprolles) {
         if(ugr.getRole().getName().equalsIgnoreCase("BBMRI ERIC Site Owner")) {
            %>
            <li id="sitemembership" style="cursor:pointer;">
            Site Membership Management</li>
            <%
         }
      }
      %>
		<!-- Sign out -->
		<li class="sign-out"><aui:a href="<%= themeDisplay.getURLSignOut() %>">
		<img style="opacity:0.5;filter:alpha(opacity=50);" alt="myaccount" height="18px" width="10px" src="<%= request.getContextPath() %>/images/signinkey.png" />
		Sign Out</aui:a></li>
		
		</ul>
	<% } else { %>
		<img alt="myaccount" height="18px" width="18px" src="<%= request.getContextPath() %>/images/signinkey.png" />
		<ul>
		<!-- Sign in -->
		<li class="sign-in"><aui:a href="<%= themeDisplay.getURLSignIn() %>">
		<img style="opacity:0.5;filter:alpha(opacity=50);" alt="myaccount" height="18px" width="10px" src="<%= request.getContextPath() %>/images/signinkey.png" />
		Sign In</aui:a></li>
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
<aui:script use="aui-base">
            A.all('#sitemembership').on(
               'click',
               function(event) {
                  Liferay.Util.selectEntity(
                     {
                        dialog: {
                           constrain: true,
                           modal: true,
                           width: 1000
                        },
                        id: '_<%=HtmlUtil.escapeJS(portletResource)%>_sitemembership',
                        title: 'Edit Site Membership.',
                        uri: '<%=editsitemembershipURL.toString()%>'
                     }
                  );
               }
            );
</aui:script>