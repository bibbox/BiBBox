<!-- 
BiBBoxCommonServices
user/invitation

 -->
<%@ include file="/html/user/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
long organizationId = ParamUtil.getLong(request, "organizationId");
String redirect = ParamUtil.getString(request, "redirect");
%>

<% 
String tmpTitle = "new-assessment";

String background1_1 = "Not Specified";


%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%=tmpTitle %>'
/>

<portlet:actionURL name='addAssessment' var="addAssessmentURL" windowState="normal" />
<aui:form action="<%= addAssessmentURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:input type="hidden" name="organizationId" value="<%= String.valueOf(organizationId) %>" />
		<aui:layout>
			<h1>1 GENERAL INFORMATION ON THE BIOBANK</h1>
			<aui:column columnWidth="100" first="true">
				<aui:select name="background1_1" showEmptyOption="<%= true %>" label="1.1 Biobank background (year of experience, Director's CV, etc)">
					<aui:option value="Not Specified" selected="<%=\"Not Specified\".equals(background1_1) %>">Not Specified</aui:option>
					<aui:option value="Appropriate" selected="<%=\"Appropriate\".equals(background1_1) %>">Appropriate</aui:option>
					<aui:option value="Inadequate" selected="<%=\"Inadequate\".equals(background1_1) %>">Inadequate</aui:option>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input type="textarea" name="background1_1_comments" lable="Comments, if any:" />
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>