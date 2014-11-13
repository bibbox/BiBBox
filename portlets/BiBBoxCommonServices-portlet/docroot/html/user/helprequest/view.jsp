<!-- 
BiBBoxCommonServices
user/helprequest

 -->
<%@ include file="/html/user/init.jsp" %> 

<portlet:defineObjects />
<%
String redirect = ParamUtil.getString(request, "redirect");	
%>

If you have any problems pleas let us know.

<portlet:actionURL name='sendHelpRequest' var="sendHelpRequestURL" windowState="normal" />

<aui:form action="<%= sendHelpRequestURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:layout>
			<aui:column columnWidth="100" first="true">
				<aui:input name="subject" />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input name="body" type="textarea" cssClass="bibbox_cs_width_100 bibbox_cs_height_bigger" />
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"/>
	</aui:button-row>
</aui:form>
