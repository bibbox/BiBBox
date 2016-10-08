<%@ include file="/html/rdconnect/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<%
int optionsRDCRowsPerPage_cfg = GetterUtil.getInteger(portletPreferences.getValue("optionsRDCRowsPerPage", "5"));
%>


<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout>
			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<aui:column columnWidth="25" first="true">
				<aui:input name="preferences--optionsRDCRowsPerPage--" value="<%= optionsRDCRowsPerPage_cfg %>" label="Rows per Page" />
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>