<%@include file="/html/init.jsp" %>

<%
	MasterCandidate master = null;

	long masterId = ParamUtil.getLong(request, "masterId");

	if (masterId > 0) {
		master = MasterCandidateLocalServiceUtil.getMasterCandidate(masterId);
	}
	
	String[] countrylist = CandidateLocalServiceUtil.getCountryNames();
	
	String redirect = ParamUtil.getString(request, "redirect");	
	
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%=master.getName() %>'
/>

<aui:model-context bean="<%= master %>" model="<%= MasterCandidate.class %>" />
<portlet:actionURL name='updateMasterCandidate' var="updateMasterCandidateURL" windowState="normal" />
<aui:form action="<%= updateMasterCandidateURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="masterCandidateId" value='<%= master.getMasterCandidateId() %>'/>

		<aui:input name="name" />
				
		<aui:input name="url" />
		
		<aui:input name="contactperson" />

		<aui:input name="candidatetype" />

		<aui:input name="diseasescodes" />

		<aui:input name="diseasesfreetext" />
		
		<aui:input name="comment" />
		
		<aui:select name="country" showEmptyOption="<%= true %>" label="country">
			<% for (String string : countrylist) { %>
				<aui:option value="<%= string %>" selected="<%= master.getCountry().equalsIgnoreCase(string) ? true : false %>"><%= string %></aui:option>
			<% } %>
		</aui:select>
		
		<aui:input name="address" />

		<aui:input name="mail" />

		<aui:input name="head" />

		<aui:input name="joinId" />
		
		<aui:input name="accepted" />
		
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>