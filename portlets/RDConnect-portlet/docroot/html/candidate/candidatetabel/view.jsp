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

String[] countrylist = CandidateLocalServiceUtil.getCountryNames();
String[] types = CandidateLocalServiceUtil.getTypesOfCandidates();
String[] sources = CandidateLocalServiceUtil.getSource();
String urltounfilterd = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent().split("\\?")[0]+"/";
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
	<aui:button name="filter" type="submit" value="filter" label="Filter" onClick="submitFormRDConnectCandidatePropose('filter')" />
	<aui:button name="clear" type="submit" value="clear" label="Clear" onClick="<%= urltounfilterd %>" />
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
<div class="rdc-candidate-table">



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

<p><b>Number of Candidates: <%= total %></b></p>

</liferay-ui:search-container-results>

<liferay-ui:search-container-row 
className="at.meduni.liferay.portlet.rdconnect.model.Candidate"
keyProperty="candidateId"
modelVar="candidate">
<liferay-ui:search-container-column-text
name="Candidate Id"
property="candidateId"
/>
<liferay-ui:search-container-column-text
name="name"
property="name"
href="<%=candidate.getUrl()%>"
target="_blank"
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
<liferay-ui:search-container-column-jsp
align="right" 
path="/html/candidate/candidatetabel/editsub.jsp"
/>
<liferay-ui:search-container-column-button
name="Save"
href="#"
cssClass="search-container-column-button-save-table"
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
</div>

<portlet:actionURL name='updateCandidateTableData' var="updateCandidateTableDataURL" />

<aui:script use="aui-io-request, event, node">
	AUI().use('aui-io-request', 'event', 'node', function(A){
		var nodeObject = A.all('.search-container-column-button-save-table');
		nodeObject.on('click', function(event){
			var url = '<%= updateCandidateTableDataURL.toString() %>';
			A.io.request(url,{
				//this is the data that you are sending to the action method
				data: {
					
				   <portlet:namespace />candidateid: event.target.get('parentNode').get('parentNode').one('#candidateid').get('value'),
				   <portlet:namespace />masterid: event.target.get('parentNode').get('parentNode').one('#masterid').get('value'),
				   <portlet:namespace />accepted: event.target.get('parentNode').get('parentNode').one('#accepted').get('checked'),
				},
				dataType: 'json',
				on: {
				  failure: function() { alert('failure'); },
				  success: function(event, id, obj) { "success" }
				}
			});
		});
	});
</aui:script>