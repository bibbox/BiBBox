<%@ include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.model.User"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@ page import="com.liferay.portal.model.Group"%>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>

<portlet:defineObjects />

<div class="bbmri-eric-member-area-top-area-expand-container-user-portlet-user-image">
   <%     
   String currentURL = PortalUtil.getCurrentURL(request);
   
   String imgPath = themeDisplay.getPathImage()+"/user_portrait?screenName="+ user.getScreenName()+"&amp;companyId="+user.getCompanyId();
   
   String editimgpath = request.getContextPath() + "/images/edit.png";
   
   Group controlPanelGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), "Control Panel");
   long controlPanelPlid = LayoutLocalServiceUtil.getDefaultPlid(controlPanelGroup.getGroupId(), true);
   
   LiferayPortletURL editusersURL = null;
   editusersURL = PortletURLFactoryUtil.create(request, "2", controlPanelPlid, "RENDER_PHASE");
   editusersURL.setParameter("redirect", currentURL);
   editusersURL.setParameter("p_p_state", "maximized");
   editusersURL.setParameter("controlPanelCategory", "my");
   editusersURL.setParameter("doAsGroupId", String.valueOf(themeDisplay.getUser().getGroupId()));

   %>
   <img style="float:left;" alt="" class="avatar" src="<%= imgPath %>" width="180" /> 
</div>
<div class="bbmri-eric-member-area-top-area-expand-container-user-portlet-user-edit">
   <%= themeDisplay.getUser().getJobTitle() %><br>
   <aui:a href="<%= editusersURL.toString() %>">Add Position <img id="myuseredit" style="cursor:pointer;width: 10px;height: 10px;" alt="logo" src="<%= editimgpath %>" width="10px" height="10px" /></aui:a><br>
   <aui:a href="/web/home">Configure Member Area</aui:a><br>
   <aui:a href="<%= themeDisplay.getURLSignOut() %>">Sign Out</aui:a>
</div>
