<%@include file="/html/init.jsp"%>
<%@ page import="com.liferay.util.PwdGenerator"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
String uploadProgressId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
long puchmuseumsobjektId = ParamUtil.getLong(request, "puchmuseumsobjectId");
long imageId = ParamUtil.getLong(request, "imageId");
String redirect = ParamUtil.getString(request, "redirect");
%>

<%= puchmuseumsobjektId %>

<portlet:actionURL var="uploadImageURL" name="uploadImage">

</portlet:actionURL>
<liferay-ui:success key="success" message=" Image uploaded successfully!" />
<liferay-ui:error key="error"
message="Sorry, an error prevented the upload. Please try again." />
<liferay-ui:upload-progress
id="<%= uploadProgressId %>"
message="uploading"
redirect="<%= uploadImageURL %>"
/>

<aui:form action="<%= uploadImageURL %>" enctype="multipart/form-data" method="post" >
<aui:input type="hidden" name="puchmuseumsobjektId" value="<%= puchmuseumsobjektId %>"/>
<aui:input type="hidden" name="ojid" value="<%= puchmuseumsobjektId %>"/>
<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
<aui:input type="file" name="imageRaw" size="75"/>
<aui:input type="file" name="imageProcessed" size="75"/>
<input type="submit" value="<liferay-ui:message key="upload" />" onClick="<%= uploadProgressId %>.startProgress(); return true;"/>
<!--  aui:button type="submit" value="Save" /-->
</aui:form>