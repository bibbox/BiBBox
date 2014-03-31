<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<form action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post" name="<portlet:namespace />fm"> 
	<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" /> 
	
	Type: <select name="<portlet:namespace />type"> 
		<option value="casual">Casual</option>
		<option value="formal">Formal</option> 
	</select> <br/>
	
	<input type="button" value="Save" onClick="submitForm(document.<portlet:namespace />fm);" /> 
</form>
