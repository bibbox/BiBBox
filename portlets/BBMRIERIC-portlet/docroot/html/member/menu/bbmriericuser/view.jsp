<%@ include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.model.User"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@ page import="com.liferay.portal.model.Group"%>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ page import="com.liferay.portal.model.Phone"%>

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
   <%= themeDisplay.getUser().getEmailAddress() %><span id="myuseredit" style="cursor:pointer;margin-left: 3px;"><img style="cursor:pointer;width: 10px;height: 10px;" alt="logo" src="<%= editimgpath %>" width="10px" height="10px" /></span><br>
<%
List<Phone> phones = themeDisplay.getUser().getPhones();
for(Phone phone : phones) {
	String type = phone.getType().getName();
	type = type.substring(0, 1).toUpperCase() + type.substring(1);
%>
   <%= phone.getType().getName() %>: <%= phone.getNumber() %><br>
<%
}
%>
   
   <br>
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