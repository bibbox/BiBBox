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

String source = ParamUtil.getString(request, "source");
if(source.equalsIgnoreCase("")) {
	source = "all";
}

String candidatetype = ParamUtil.getString(request, "candidatetype");
if(candidatetype.equalsIgnoreCase("")) {
	candidatetype = "all";
}

String name = ParamUtil.getString(request, "name");
if(name.equalsIgnoreCase("")) {
	name = "";
}

if(renderRequest.getParameter("action-status") != null) {
	if(renderRequest.getParameter("action-status").equalsIgnoreCase("clear")) {
		country = "all";
		request.setAttribute("country", "all");
		source = "all";
		request.setAttribute("source", "all");
		candidatetype = "all";
		request.setAttribute("candidatetype", "all");
		name = "";
		request.setAttribute("name", "");
	}
}
	
/*String disease = ParamUtil.getString(request, "disease");
if(disease.equalsIgnoreCase("")) {
	disease = "";
}*/
%>

<% 
String[] countrylist = CandidateLocalServiceUtil.getCountryNames();
String[] types = CandidateLocalServiceUtil.getTypesOfCandidates();
String[] sources = CandidateLocalServiceUtil.getSource();
%>

<portlet:actionURL name='filterCandidates' var="filterCandidatesURL" />
<portlet:actionURL name='clearFilterCandidates' var="clearFilterCandidatesURL" />
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
<aui:select name="candidatetype" label="Type Filter:">
	<% for (String string : types) { %>
	<aui:option value="<%= string %>" selected="<%= candidatetype.equalsIgnoreCase(string) ? true : false %>">
		<%= string %>
	</aui:option>
	<% } %>
</aui:select>
</div>
<div style="float:left;">
<aui:select name="source" label="Source Filter:" >
	<% for (String string : sources) { %>
	<aui:option value="<%= string %>" selected="<%= source.equalsIgnoreCase(string) ? true : false %>">
		<%= string %>
	</aui:option>
	<% } %>
</aui:select>
</div>
<%--<aui:input name="disease" label="Search Disease:" size="90"  value="<%= disease %>" />--%>
<aui:button-row>
<aui:button name="filter" type="submit" value="filter" label="Filter" onClick="submitForm('filter')" />
<aui:button name="clear" type="submit" value="clear" label="Clear" onClick="submitForm('clear')" />
</aui:button-row>
</aui:fieldset>
</aui:form>

<script type="text/javascript" charset="utf-8">
var A = AUI();
function submitForm(action){
  if(action=='filter'){
     A.one('#<portlet:namespace/>filterform').set('action',"<%= filterCandidatesURL %>").submit();
  }else{
	  if(action=='clear'){
     	A.one('#<portlet:namespace/>filterform').set('action',"<%= clearFilterCandidatesURL %>").submit();
	  }
  }
}
</script>

<%      
	Integer count = (Integer)request.getAttribute("count");        
	Integer delta = (Integer)request.getAttribute("delta");        
	Integer cur = (Integer)request.getAttribute("cur");         
    if(cur == null){
        cur = 1;
    }
    if(delta == null){
        delta = 10;
    }
    if(count == null){
        count = 0;
    }
    PortletURL portletURL = renderResponse.createActionURL();
    //portletURL.setParameter("disease", disease);
    portletURL.setParameter("country", country);
    portletURL.setParameter("source", source);
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
List<Candidate> tempResults = CandidateLocalServiceUtil.getFilterdCandidates(name, country, candidatetype, source);
//results = CandidateLocalServiceUtil.subList(tempResults, searchContainer.getStart(), searchContainer.getEnd());
//List<Candidate> tempResults = ActionUtil.getProducts(renderRequest);
results = ListUtil.subList(tempResults, searchContainer.getStart(), searchContainer.getEnd());
total = tempResults.size();
pageContext.setAttribute("results", results);
pageContext.setAttribute("total", total);
%>

</liferay-ui:search-container-results>
<liferay-ui:search-container-row 
className="at.meduni.liferay.portlet.rdconnect.model.Candidate"
keyProperty="candidateId"
modelVar="candidate">
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
<liferay-ui:search-container-column-text
name="source"
property="source"
/>
</liferay-ui:search-container-row>
<%        
portletURL.setParameter("cur", String.valueOf(cur)); 
//portletURL.setParameter("disease", disease);
portletURL.setParameter("country", country);
portletURL.setParameter("source", source);
portletURL.setParameter("candidatetype", candidatetype);
portletURL.setParameter("name", name);
searchContainer.setIteratorURL(portletURL);    %>
    <liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</liferay-ui:search-container>