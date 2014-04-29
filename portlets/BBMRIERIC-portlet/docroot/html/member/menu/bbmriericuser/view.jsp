<%@ include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.model.User"%>

<portlet:defineObjects />

<div class="bbmri-eric-member-area-top-area-expand-container-user-portlet-user-image">
   <%     
   String imgPath = themeDisplay.getPathImage()+"/user_portrait?screenName="+ user.getScreenName()+"&amp;companyId="+user.getCompanyId();
   %>
   <img style="float:left;" alt="" class="avatar" src="<%= imgPath %>" width="180" /> 
</div>
<div class="bbmri-eric-member-area-top-area-expand-container-user-portlet-user-edit">
   PhD<br>
   Add Position<br>
   Configure Member Area
</div>
