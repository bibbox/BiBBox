<%@include file="/html/init.jsp" %>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);	
%>

<!-- Read the search parameters from the action urls for filtering -->
<%

String country = ParamUtil.getString(request, "country");
if(country.equalsIgnoreCase("")) {
	country = "all";
}

String candidatetype = ParamUtil.getString(request, "candidatetype");
if(candidatetype.equalsIgnoreCase("")) {
	candidatetype = "all";
}

String name = ParamUtil.getString(request, "name");
if(name.equalsIgnoreCase("")) {
	name = "";
}

String[] countrylist = CandidateLocalServiceUtil.getCountryNames();
String[] types = CandidateLocalServiceUtil.getTypesOfCandidates();
%>

<portlet:actionURL name='filterCandidates' var="filterCandidatesURL" />
<aui:form name="filterform" action="<%= filterCandidatesURL.toString() %>" method="post" >
<aui:fieldset  column="true">
<div style="float:left;">
<aui:input name="name" label="Name Search Filter:" size="90" value="<%= name %>" />
</div>
<div style="float:left;">
<aui:select name="country" label="Country Filter:">
	<% for (String string : countrylist) { %>
	<aui:option value="<%= string %>" selected="<%= country.equalsIgnoreCase(string) ? true : false %>">
		<%= string %>
	</aui:option>
	<% } %>
</aui:select>
</div>
<div style="float:left;">
<aui:select name="candidatetype" label="Type Filter:" >
	<% for (String string : types) { %>
	<aui:option value="<%= string %>" selected="<%= candidatetype.equalsIgnoreCase(string) ? true : false %>">
		<%= string %>
	</aui:option>
	<% } %>
</aui:select>
</div>
<aui:button-row>
<aui:button name="filter" type="submit" value="filter" label="Filter" />
<!--<aui:button name="clear" type="submit" value="clear" label="Clear" />-->
</aui:button-row>
</aui:fieldset>
</aui:form>

<%      
	Integer count = (Integer)request.getAttribute("#<portlet:namespace/>count");        
	Integer delta = (Integer)request.getAttribute("#<portlet:namespace/>delta");        
	Integer cur = (Integer)request.getAttribute("#<portlet:namespace/>cur");         
    if(cur == null){
        cur = 1;
    }
    if(delta == null){
        delta = 50;
    }
    if(count == null){
        count = 0;
    }
    PortletURL portletURL = renderResponse.createActionURL();
    portletURL.setParameter("country", country);    
    portletURL.setParameter("candidatetype", candidatetype);
    portletURL.setParameter("name", name);
    portletURL.setParameter("action", "search");
     
%>

<liferay-ui:search-container 
iteratorURL="<%= portletURL %>" 
emptyResultsMessage="there-are-no-candidates" 
delta="<%= delta %>">
<liferay-ui:search-container-results>
<%
List<MasterCandidate> tempResults = MasterCandidateLocalServiceUtil.getFilterdCandidates(name, country, candidatetype);
//results = CandidateLocalServiceUtil.subList(tempResults, searchContainer.getStart(), searchContainer.getEnd());
//List<Candidate> tempResults = ActionUtil.getProducts(renderRequest);
results = ListUtil.subList(tempResults, searchContainer.getStart(), searchContainer.getEnd());
total = tempResults.size();
pageContext.setAttribute("results", results);
pageContext.setAttribute("total", total);
%>

</liferay-ui:search-container-results>
<liferay-ui:search-container-row 
className="at.meduni.liferay.portlet.rdconnect.model.MasterCandidate"
keyProperty="masterCandidateId"
modelVar="MasterCandidate">
<liferay-ui:search-container-column-text
name="name"
property="name"
orderable="<%=true %>"
/>
<liferay-ui:search-container-column-text
name="country"
property="country"
/>
<liferay-ui:search-container-column-text
name="type"
property="candidatetype"
/>
<liferay-ui:search-container-column-jsp
	align="right"
	path="/html/candidate/mastertable/mastertable_actions.jsp"
/>
</liferay-ui:search-container-row>
<%        
portletURL.setParameter("cur", String.valueOf(cur)); 
//portletURL.setParameter("disease", disease);
portletURL.setParameter("country", country);
portletURL.setParameter("candidatetype", candidatetype);
portletURL.setParameter("name", name);
searchContainer.setIteratorURL(portletURL);    %>
    <liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</liferay-ui:search-container>