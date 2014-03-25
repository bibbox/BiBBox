<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.model.Role" %>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);	
%>

<!-- Read the search parameters from the action urls for filtering -->
<%
String name2 = "";
HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
name2 = httpRequest.getParameter("_portalmenu_WAR_RDConnectportlet_name");
if(name2 == null) {
	name2 = "";
}

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
	if(name2.equalsIgnoreCase("")) {
		name = "";
	} else {
		name = name2;
	}
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
<aui:input name="name" label="Name/Disease/Subtype:" size="90" value="<%= name %>" />
</div>
<div style="float:left;">
<aui:select name="country" label="Country:" cssClass="rdc-filter-input" >
	<% for (String string : countrylist) { %>
	<aui:option value="<%= string %>" selected="<%= country.equalsIgnoreCase(string) ? true : false %>">
		<%= string %>
	</aui:option>
	<% } %>
</aui:select>
</div>
<div style="float:left;">
<aui:select name="candidatetype" label="Type:" cssClass="rdc-filter-input" >
	<% for (String string : types) { %>
	<aui:option value="<%= string %>" selected="<%= candidatetype.equalsIgnoreCase(string) ? true : false %>">
		<%= string %>
	</aui:option>
	<% } %>
</aui:select>
</div>
<div style="float:left;">
	<aui:select name="state" label="State:" cssClass="rdc-filter-input" >
				<aui:option value="all" selected='<%= state.equalsIgnoreCase("all") ? true : false %>' >all</aui:option>
				<aui:option value="1" selected='<%= state.equalsIgnoreCase("1") ? true : false %>' >not published</aui:option>
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
 
    
    request.setAttribute("proveofconcept", portletURL.toString());
%>



<liferay-ui:search-container 
iteratorURL="<%= portletURL %>" 
emptyResultsMessage="there-are-no-candidates" 
delta="<%= delta %>">
<liferay-ui:search-container-results>
<%
/*
AT Hook
*/
if(themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
	country = "Austria";
}
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
<%
boolean portaleditorrole = false;
for(Role role : themeDisplay.getUser().getRoles()) {
	if(role.getName().equalsIgnoreCase("PORTAL-EDITOR"))
		portaleditorrole = true;
	if(role.getName().equalsIgnoreCase("Administrator"))
		portaleditorrole = true;
}

%>
<liferay-ui:search-container-column-jsp
	align="right" 
	path="/html/candidate/mastertable/candidatemastertable_idcard.jsp"
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
	path="/html/candidate/mastertable/candidatemaster_state.jsp"
	cssClass="candidate-table-state"
/>
<%
if(portaleditorrole) {
%>
<liferay-ui:search-container-column-jsp
	align="right"
	path="/html/candidate/mastertable/mastertable_actions.jsp"
/>
<% } %>
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
	AUI().use('node', function(A){
		var nodeObject = A.all('#_mastertable_WAR_RDConnectportlet_masterCandidatesSearchContainer_col-5');
		nodeObject.setHTML('State');
	});
</aui:script>