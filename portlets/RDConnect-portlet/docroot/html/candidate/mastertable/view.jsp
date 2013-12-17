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

String state =  ParamUtil.getString(request, "state");
if(state.equalsIgnoreCase("")) {
	state = "";
}

String[] countrylist = CandidateLocalServiceUtil.getCountryNames();
String[] types = CandidateLocalServiceUtil.getTypesOfCandidates();
%>
<div class="rdc-filter-form">
<portlet:actionURL name='filterCandidates' var="filterCandidatesURL" />
<aui:form name="filterform" action="<%= filterCandidatesURL.toString() %>" method="post" >
<aui:fieldset  column="true">
<div style="float:left;">
<aui:input name="name" label="Name Search Filter:" size="90" value="<%= name %>" />
</div>
<div style="float:left;">
<aui:select name="country" label="Country Filter:" cssClass="rdc-filter-input" >
	<% for (String string : countrylist) { %>
	<aui:option value="<%= string %>" selected="<%= country.equalsIgnoreCase(string) ? true : false %>">
		<%= string %>
	</aui:option>
	<% } %>
</aui:select>
</div>
<div style="float:left;">
<aui:select name="candidatetype" label="Type Filter:" cssClass="rdc-filter-input" >
	<% for (String string : types) { %>
	<aui:option value="<%= string %>" selected="<%= candidatetype.equalsIgnoreCase(string) ? true : false %>">
		<%= string %>
	</aui:option>
	<% } %>
</aui:select>
</div>
<div style="float:left;">
	<aui:select name="state" label="state Filter:" cssClass="rdc-filter-input" >
				<aui:option value="all" selected='<%= state.equalsIgnoreCase("all") ? true : false %>' >all</aui:option>
				<aui:option value="0" selected='<%= state.equalsIgnoreCase("0") ? true : false %>' >not decided</aui:option>
				<aui:option value="1" selected='<%= state.equalsIgnoreCase("1") ? true : false %>' >data checked 1</aui:option>
				<aui:option value="2" selected='<%= state.equalsIgnoreCase("2") ? true : false %>' >data checked 2</aui:option>
				<aui:option value="3" selected='<%= state.equalsIgnoreCase("3") ? true : false %>' >data checked 3</aui:option>
				<aui:option value="4" selected='<%= state.equalsIgnoreCase("4") ? true : false %>' >data checked 4</aui:option>
				<aui:option value="5" selected='<%= state.equalsIgnoreCase("5") ? true : false %>' >data checked 5</aui:option>
				<aui:option value="P" selected='<%= state.equalsIgnoreCase("P") ? true : false %>' >published</aui:option>
	</aui:select>
</div>
<div style="float:left;">
<aui:button-row>
<aui:button name="filter" type="submit" value="filter" label="Filter"  cssClass="rdc-filter-button" />
<!--<aui:button name="clear" type="submit" value="clear" label="Clear" />-->
</aui:button-row>
</div>
</aui:fieldset>
</aui:form>
</div>
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
List<MasterCandidate> tempResults = MasterCandidateLocalServiceUtil.getFilterdCandidates(name, country, candidatetype, state);
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
	name="ID"
	property="masterCandidateId"
	cssClass="candidate-table-candidateId"
/>
<liferay-ui:search-container-column-jsp
	align="right" 
	path="/html/candidate/mastertable/candidatemastertable_name.jsp"
	cssClass="candidate-table-namecontainer"
/>
<liferay-ui:search-container-column-text
	name="country"
	property="country"
/>
<liferay-ui:search-container-column-jsp
	align="right" 
	path="/html/candidate/mastertable/candidatemastertable_types.jsp"
	cssClass="candidate-table-namecontainer"
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

<aui:script use="node">
	AUI().use('node', function(A){
		var nodeObject = A.all('#_mastertable_WAR_RDConnectportlet_masterCandidatesSearchContainer_col-2');
		nodeObject.setHTML('Information');
	});
	AUI().use('node', function(A){
		var nodeObject = A.all('#_mastertable_WAR_RDConnectportlet_masterCandidatesSearchContainer_col-4');
		nodeObject.setHTML('Type');
	});
</aui:script>