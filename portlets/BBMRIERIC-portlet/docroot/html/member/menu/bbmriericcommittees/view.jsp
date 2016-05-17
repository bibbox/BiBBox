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
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>

<portlet:defineObjects />
<div class="bbmri-eric-member-area-top-menue-container-menu-home">
   <aui:a href="/web/home"><img src="<%=request.getContextPath()%>/images/home_1.png" height="16px" width="19px" /></aui:a>
</div>
<div class="bbmri-eric-member-area-top-menue-container-menu-current-site">
<%
String currentURL = PortalUtil.getCurrentURL(request);
String url_home = themeDisplay.getURLPortal() + themeDisplay.getSiteGroup().getPathFriendlyURL(false, themeDisplay) + themeDisplay.getSiteGroup().getFriendlyURL();

List<Group> groups = themeDisplay.getUser().getMySiteGroups();
boolean adhoc = false;
boolean committees = false;
boolean wg = false;
boolean wp = false;
boolean project = false;
List<String> groupsfornavigation = new ArrayList<String>();
groupsfornavigation.add("PROJECTS");
groupsfornavigation.add("GROUPS");
groupsfornavigation.add("WG");
groupsfornavigation.add("GOVERNANCE");

HashMap<String, String> groupsfornavigationnaming = new HashMap<String, String>();
groupsfornavigationnaming.put("GOVERNANCE", "committee");
groupsfornavigationnaming.put("WG", "working group");
groupsfornavigationnaming.put("GROUPS", "ad-hoc working group");
groupsfornavigationnaming.put("PROJECTS", "projects");

for(Group group : groups) {
	List<AssetTag> tags = AssetTagServiceUtil.getTags(Group.class.getName(), group.getPrimaryKey());
   for(AssetTag tag : tags) {
	   if(tag.getName().equalsIgnoreCase("ad-hoc working group")) {
		   adhoc = true; 
      }
	   if(tag.getName().equalsIgnoreCase("committee") || tag.getName().equalsIgnoreCase("governance")) {
		   committees = true;
	   }
	   if(tag.getName().equalsIgnoreCase("working group")) {
		   wg = true;
	   }
	   if(tag.getName().equalsIgnoreCase("projects")) {
		   project = true;
	   }
   }
}
if(!adhoc) {
	groupsfornavigation.remove(groupsfornavigation.indexOf("GROUPS"));
}
if(!committees) {
	groupsfornavigation.remove(groupsfornavigation.indexOf("GOVERNANCE"));
}
if(!wg) {
	groupsfornavigation.remove(groupsfornavigation.indexOf("WG"));
}
if(!project) {
	groupsfornavigation.remove(groupsfornavigation.indexOf("PROJECTS"));
}

String g1 = "";
String g2 = "";
String g3 = "";
String g4 = "";
String g5 = "";
String tg1 = "";
String tg2 = "";
String tg3 = "";
String tg4 = "";
String tg5 = "";
for(String groupsfornavigation_key : groupsfornavigation) {
	if(g5.equalsIgnoreCase("")) {
		g5 = groupsfornavigationnaming.get(groupsfornavigation_key);
		tg5 = groupsfornavigation_key;
		continue;
	}
	if(g4.equalsIgnoreCase("")) {
		g4 = groupsfornavigationnaming.get(groupsfornavigation_key);
		tg4 = groupsfornavigation_key;
		continue;
	}
	if(g3.equalsIgnoreCase("")) {
		g3 = groupsfornavigationnaming.get(groupsfornavigation_key);
		tg3 = groupsfornavigation_key;
		continue;
	}
	if(g2.equalsIgnoreCase("")) {
		g2 = groupsfornavigationnaming.get(groupsfornavigation_key);
		tg2 = groupsfornavigation_key;
		continue;
	}
	if(g1.equalsIgnoreCase("")) {
		g1 = groupsfornavigationnaming.get(groupsfornavigation_key);
		tg1 = groupsfornavigation_key;
		continue;
	}	
}

%>
   <aui:a href="<%= url_home %>"><ul><li><%= themeDisplay.getSiteGroupName() %></li></ul></aui:a>
</div>
<!-- Group Container -->
<!-- Group 1 
<div class="bbmri-eric-member-area-top-menue-container-group1">
   <ul>
      <% if(!g1.equalsIgnoreCase("")) { %>
	      <li class="bbmri-eric-member-area-top-menue-container-group1-ul-li"><%= tg1 %><img style="margin-left: 1px;" src="<%=request.getContextPath()%>/images/arrow.png" height="5px" width="7px" />
	         <ul>
	            <%    
	            for(Group group : groups) {
	               List<AssetTag> tags = AssetTagServiceUtil.getTags(Group.class.getName(), group.getPrimaryKey());
	               for(AssetTag tag : tags) {               
		               if(tag.getName().equalsIgnoreCase(g1)) {	               
		                  String url = themeDisplay.getURLPortal() + group.getPathFriendlyURL(false, themeDisplay) + group.getFriendlyURL();
		                  String grouptitle = group.getDescriptiveName().replaceAll("^WG ", "Working Group ").replaceAll("^WP ", "Working Party ");
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
      <% } %>
   </ul>
</div>-->
<!-- Group 2 -->
<div class="bbmri-eric-member-area-top-menue-container-group2">
	<ul>
	  <% if(!g2.equalsIgnoreCase("")) { %>
		<li class="bbmri-eric-member-area-top-menue-container-group2-ul-li"><%= tg2 %><img style="margin-left: 1px;" src="<%=request.getContextPath()%>/images/arrow.png" height="5px" width="7px" />
			<ul>
				<% 
					for(Group group : groups) {
						List<AssetTag> tags = AssetTagServiceUtil.getTags(Group.class.getName(), group.getPrimaryKey());
						for(AssetTag tag : tags) {
							if(tag.getName().equalsIgnoreCase(g2)) {
							
								String url = themeDisplay.getURLPortal() + group.getPathFriendlyURL(false, themeDisplay) + group.getFriendlyURL();
			                     //String state = JSONFactoryUtil.looseDeserialize(group.getExpandoBridge().getAttribute("state").toString(), Company.class);
			                     //String state = JSONFactoryUtil.deserialize(group.getExpandoBridge().getAttribute("state").toString()).toString();
			                     
			                     
			                     String grouptitle = group.getDescriptiveName().replaceAll("^WG ", "Working Group ").replaceAll("^WP ", "Working Party ");
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
	   <% } %>
	</ul>
</div>
<!-- Group 3 -->
<div class="bbmri-eric-member-area-top-menue-container-group3">
   <ul>
      <% if(!g3.equalsIgnoreCase("")) { %>
	      <li class="bbmri-eric-member-area-top-menue-container-group3-ul-li"><%= tg3 %><img style="margin-left: 1px;" src="<%=request.getContextPath()%>/images/arrow.png" height="5px" width="7px" />
	         <ul>
	            <% 
            
	            for(Group group : groups) {
	            	List<AssetTag> tags = AssetTagServiceUtil.getTags(Group.class.getName(), group.getPrimaryKey());
	                for(AssetTag tag : tags) {
	                
		                if(tag.getName().equalsIgnoreCase(g3)) {
		                	String url = themeDisplay.getURLPortal() + group.getPathFriendlyURL(false, themeDisplay) + group.getFriendlyURL();
		                     //String state = JSONFactoryUtil.looseDeserialize(group.getExpandoBridge().getAttribute("state").toString(), Company.class);
		                     //String state = JSONFactoryUtil.deserialize(group.getExpandoBridge().getAttribute("state").toString()).toString();
		                     
		                     
		                     String grouptitle = group.getDescriptiveName().replaceAll("^WG ", "Working Group ").replaceAll("^WP ", "Working Party ");
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
	   <% } %>
   </ul>
</div>
<!-- Group 4 -->
<div class="bbmri-eric-member-area-top-menue-container-group4">
   <ul>
      <% if(!g4.equalsIgnoreCase("")) { %>
	      <li class="bbmri-eric-member-area-top-menue-container-group4-ul-li"><%= tg4 %><img style="margin-left: 1px;" src="<%=request.getContextPath()%>/images/arrow.png" height="5px" width="7px" />
	         <ul>
	            <% 
            
	            for(Group group : groups) {
	            	List<AssetTag> tags = AssetTagServiceUtil.getTags(Group.class.getName(), group.getPrimaryKey());
	                for(AssetTag tag : tags) {
		                if(tag.getName().equalsIgnoreCase(g4)) {
		                	String url = themeDisplay.getURLPortal() + group.getPathFriendlyURL(false, themeDisplay) + group.getFriendlyURL();
		                     //String state = JSONFactoryUtil.looseDeserialize(group.getExpandoBridge().getAttribute("state").toString(), Company.class);
		                     //String state = JSONFactoryUtil.deserialize(group.getExpandoBridge().getAttribute("state").toString()).toString();
		                     
		                     
		                     String grouptitle = group.getDescriptiveName().replaceAll("^WG ", "Working Group ").replaceAll("^WP ", "Working Party ");
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
	   <% } %>
   </ul>
</div>
<!-- Group 5 -->
<div class="bbmri-eric-member-area-top-menue-container-group5">
   <ul>
      <% if(!g5.equalsIgnoreCase("")) { %>
	      <li class="bbmri-eric-member-area-top-menue-container-group5-ul-li"><%= tg5 %><img style="margin-left: 1px;" src="<%=request.getContextPath()%>/images/arrow.png" height="5px" width="7px" />
	         <ul>
	            <% 
            
	            for(Group group : groups) {
	            	List<AssetTag> tags = AssetTagServiceUtil.getTags(Group.class.getName(), group.getPrimaryKey());
	                for(AssetTag tag : tags) {
		                if(tag.getName().equalsIgnoreCase(g5)) {
		                	String url = themeDisplay.getURLPortal() + group.getPathFriendlyURL(false, themeDisplay) + group.getFriendlyURL();
		                     //String state = JSONFactoryUtil.looseDeserialize(group.getExpandoBridge().getAttribute("state").toString(), Company.class);
		                     //String state = JSONFactoryUtil.deserialize(group.getExpandoBridge().getAttribute("state").toString()).toString();
		                     
		                     
		                     String grouptitle = group.getDescriptiveName().replaceAll("^WG ", "Working Group ").replaceAll("^WP ", "Working Party ");
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
	   <% } %>
   </ul>
</div>
<!-- Group Container END -->
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
		<img alt="myaccount" height="18px" width="10px" src="<%= request.getContextPath() %>/images/profile.png" />
		<ul>
		<!-- User -->
		<%
      String imgPath = themeDisplay.getPathImage()+"/user_portrait?screenName="+themeDisplay.getUser().getScreenName()+"&amp;companyId="+themeDisplay.getUser().getCompanyId();
      %>
		<li id="portalmyuseredit" style="cursor:pointer;">
		<img style="opacity:0.5;filter:alpha(opacity=50); alt="myaccount" height="20px" width="20px" src="<%= imgPath %>" />
		<%= themeDisplay.getUser().getFullName() %></li>
		<!-- Organisation Owner For membership Requests -->
      <%
      List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(themeDisplay.getUserId(), themeDisplay.getSiteGroupId());
      for (UserGroupRole ugr : usergrouprolles) {
         if(ugr.getRole().getName().equalsIgnoreCase("BBMRI ERIC Site Owner")) {
            %>
            <li id="sitemembership" style="cursor:pointer;">
            <img alt="sitemembership" height="16px" width="16px" src="<%= request.getContextPath() %>/images/icon_membership.png" />
            Membership Management</li>
            <%
         }
      }
      %>
		<!-- Sign out -->
		<li class="sign-out"><aui:a href="<%= themeDisplay.getURLSignOut() %>">
		<img style="opacity:0.3;filter:alpha(opacity=30);" alt="myaccount" height="18px" width="10px" src="<%= request.getContextPath() %>/images/icon_sign_out.png" />
		Sign Out</aui:a></li>
		
		</ul>
	<% } else { %>
		<img alt="myaccount" height="18px" width="18px" src="<%= request.getContextPath() %>/images/signinkey.png" />
		<ul>
		<!-- Sign in -->
		<li class="sign-in"><aui:a href="<%= themeDisplay.getURLSignIn() %>">
		<img style="opacity:0.3;filter:alpha(opacity=30);" alt="myaccount" height="18px" width="10px" src="<%= request.getContextPath() %>/images/signinkey.png" />
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