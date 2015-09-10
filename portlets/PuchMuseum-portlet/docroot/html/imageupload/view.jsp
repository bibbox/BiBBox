<%@include file="/html/init.jsp"%>
<%@ page import="com.liferay.util.PwdGenerator"%>

<%
//https://github.com/blueimp/JavaScript-Load-Image
%>
<script src="/PuchMuseum-portlet/js/loadimage/load-image.js"></script>
<script src="/PuchMuseum-portlet/js/loadimage/load-image-ios.js"></script>
<script src="/PuchMuseum-portlet/js/loadimage/load-image-orientation.js"></script>
<script src="/PuchMuseum-portlet/js/loadimage/load-image-meta.js"></script>
<script src="/PuchMuseum-portlet/js/loadimage/load-image-exif.js"></script>
<script src="/PuchMuseum-portlet/js/loadimage/load-image-exif-map.js"></script>

<portlet:defineObjects />
<%
String uploadProgressId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);

%>



<portlet:actionURL var="editCaseURL" name="uploadCase">
<portlet:param name="jspPage" value="/edit.jsp" />
</portlet:actionURL>
<liferay-ui:success key="success" message=" YEAH. Case uploaded successfully!" />
<liferay-ui:error key="error"
message="Sorry, an error prevented the upload. Please try again." />
<liferay-ui:upload-progress
id="<%= uploadProgressId %>"
message="uploading"
redirect="<%= editCaseURL %>"
/>

<aui:form action="<%= editCaseURL %>" enctype="multipart/form-data" method="post" >
<aui:input type="file" name="fileName" size="75"/>
<aui:input type="file" name="fileName1" size="75"/>
<input type="submit" value="<liferay-ui:message key="upload" />" onClick="<%= uploadProgressId %>.startProgress(); return true;"/>
<!--  aui:button type="submit" value="Save" /-->
</aui:form>

<script>

</script>