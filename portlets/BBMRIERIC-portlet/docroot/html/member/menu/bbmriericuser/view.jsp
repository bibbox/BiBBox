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
   
   LiferayPortletURL editmyusersURL = PortletURLFactoryUtil.create(request, "2", controlPanelPlid, "RENDER_PHASE");
   editmyusersURL.setParameter("p_p_state", "maximized");
   editmyusersURL.setParameter("controlPanelCategory", "my");
   String portletResource = com.liferay.portal.kernel.util.ParamUtil.getString(request, "portletResource");

   %>
   <img style="float:left;" alt="" class="avatar" src="<%= imgPath %>" width="180" /> 
</div>
<div class="bbmri-eric-member-area-top-area-expand-container-user-portlet-user-edit">
   <%= themeDisplay.getUser().getJobTitle() %><br>
   <span id="myuseredit" style="cursor:pointer;">Add Position <img style="cursor:pointer;width: 10px;height: 10px;" alt="logo" src="<%= editimgpath %>" width="10px" height="10px" /></span><br>
   <aui:a href="/web/home">Configure Member Area</aui:a><br>
   <aui:a href="<%= themeDisplay.getURLSignOut() %>">Sign Out</aui:a>
</div>

<aui:script use="aui-base,event,aui-dialog,aui-dialog-iframe">
      A.all('#myuseredit').on(
         'click',
         function(event) {
            Liferay.Util.selectEntity({
               dialog: {
                  constrain: true,
                  modal: true,
                  width: 1000
               },
               id: '_<%=HtmlUtil.escapeJS(portletResource)%>_selectFolder',
               title: 'Edit my account.',
               uri: '<%= editmyusersURL.toString() %>'
            });
         }
      );
</aui:script>