<%@include file="/html/init.jsp" %>

<%
	MasterCandidate master = null;

	long masterId = ParamUtil.getLong(request, "masterId");

	if (masterId > 0) {
		master = MasterCandidateLocalServiceUtil.getMasterCandidate(masterId);
	}
	
	String[] countrylist = CandidateLocalServiceUtil.getCountryNames();
	String[] types = CandidateLocalServiceUtil.getTypesOfCandidatesNewEntry();
	
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
	<aui:layout cssClass="proposelayout"> 
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="masterCandidateId" value='<%= master.getMasterCandidateId() %>' cssClass="propose"/>
	<aui:column columnWidth="100" first="true">
		<aui:input name="name" value='<%= master.getName() %>' cssClass="propose"/>
	</aui:column>
	<aui:column columnWidth="50" first="true">	
		<% if(master.getCountry().contains(";")) { %>
			<aui:input name="country" value='<%= master.getCountry() %>' />
		<% } else { %>
		<aui:select name="country" label="country" cssClass="propose">
			<% for (String string : countrylist) { %>
				<aui:option value="<%= string %>" selected="<%= master.getCountry().equalsIgnoreCase(string) %>"><%= string %></aui:option>
			<% } %>
		</aui:select>
		<% } %>
	</aui:column>
	<aui:column columnWidth="25">	
		<aui:select name="candidatetype" showEmptyOption="<%= true %>" label="Type" cssClass="propose">
			<% for (String string : types) { %>
				<aui:option value="<%= string %>" selected="<%= master.getCandidatetype().equalsIgnoreCase(string) ? true : false %>"><%= string %></aui:option>
			<% } %>
		</aui:select>
	</aui:column>
	<aui:column columnWidth="25" last="true">	
		<aui:input name="candidatesubtype" cssClass="propose" label="Subtype" />
	</aui:column>
	<aui:column columnWidth="100" first="true">			
		<aui:input name="url" cssClass="propose" />
	</aui:column>
	<aui:column columnWidth="50" first="true">	
		<aui:input name="contactperson" cssClass="propose" />
	</aui:column>
	<aui:column columnWidth="50" last="true">	
		<aui:input name="mail" cssClass="propose" />
	</aui:column>
	<aui:column columnWidth="100" first="true" >	
		<aui:input name="address" cssClass="propose"/>
	</aui:column>
	<aui:column columnWidth="50" first="true">
		<aui:input name="diseasescodes" cssClass="propose" />
	</aui:column>
	<aui:column columnWidth="50" last="true">
		<aui:input name="diseasesfreetext" cssClass="propose" />
	</aui:column>
	<aui:column columnWidth="100" first="true">
		<aui:input name="comment"  cssClass="propose" />	
	</aui:column>
	<aui:column columnWidth="50" first="true">
		<aui:input name="head" cssClass="propose"  />
	</aui:column>
	<aui:column columnWidth="25">
		<aui:input name="joinId" cssClass="propose"  />
	</aui:column>
	<aui:column columnWidth="25" last="true" >
		<% if(master.getState().equalsIgnoreCase("P")) { %>
			<aui:input name="statepublished" label="Data checked: published" value="published" disabled="true" cssClass="propose" />
			<aui:input type="hidden" name="state" value="P" />
		<% } else { %>
			<aui:select name="state" cssClass="propose" label="Data checked">
				<aui:option value="X" selected='<%= master.getState().equalsIgnoreCase("X") ? true : false %>' >rejected</aui:option>
				<aui:option value="0" selected='<%= master.getState().equalsIgnoreCase("0") ? true : false %>' >not decided</aui:option>
				<aui:option value="1" selected='<%= master.getState().equalsIgnoreCase("1") ? true : false %>' >data checked 1</aui:option>
				<aui:option value="2" selected='<%= master.getState().equalsIgnoreCase("2") ? true : false %>' >data checked 2</aui:option>
				<aui:option value="3" selected='<%= master.getState().equalsIgnoreCase("3") ? true : false %>' >data checked 3</aui:option>
				<aui:option value="4" selected='<%= master.getState().equalsIgnoreCase("4") ? true : false %>' >data checked 4</aui:option>
				<aui:option value="5" selected='<%= master.getState().equalsIgnoreCase("5") ? true : false %>' >data checked 5</aui:option>
			</aui:select>
		<% } %>
	</aui:column>
	</aui:layout>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>