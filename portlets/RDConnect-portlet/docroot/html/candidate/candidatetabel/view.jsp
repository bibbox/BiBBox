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

String diseases = ParamUtil.getString(request, "diseases");
if(diseases.equalsIgnoreCase("")) {
	diseases = "";
}

String state =  ParamUtil.getString(request, "state");
if(state.equalsIgnoreCase("")) {
	state = "";
}

String[] countrylist = CandidateLocalServiceUtil.getCountryNames();
String[] types = CandidateLocalServiceUtil.getTypesOfCandidates();
String[] sources = CandidateLocalServiceUtil.getSource();
String urltounfilterd = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent().split("\\?")[0]+"/";
%>

<div class="rdc-filter-form">
<portlet:actionURL name='filterCandidates' var="filterCandidatesURL" />
<aui:form name="filterform" action="<%= filterCandidatesURL.toString() %>" method="post" >
<aui:fieldset  column="true">
<div style="float:left;">
<aui:input name='name' label='Name/Disease/Subtype: <span id="rdc-filter-name-help" class="rdc-filter-name-help" title="Search for Name, Disease name and Disease Code (Example: Cell Bank or Duchenne and Becker muscular dystrophy or ORPHA269)"><b>&nbsp;?&nbsp;</b></span>' size="90" value="<%= name %>" cssClass="rdc-filter-name" />
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
<aui:select name="source" label="Source:" cssClass="rdc-filter-input" >
	<% for (String string : sources) { %>
	<aui:option value="<%= string %>" selected="<%= source.equalsIgnoreCase(string) ? true : false %>">
		<%= string %>
	</aui:option>
	<% } %>
</aui:select>
</div>
<div style="float:left;">
	<aui:select name="state" label="State:" cssClass="rdc-filter-input" >
				<aui:option value="all" selected='<%= state.equalsIgnoreCase("all") ? true : false %>' >all</aui:option>
				<aui:option value="X" selected='<%= state.equalsIgnoreCase("X") ? true : false %>' >deleted</aui:option>
				<aui:option value="0" selected='<%= state.equalsIgnoreCase("0") ? true : false %>' >not decided</aui:option>
				<aui:option value="1" selected='<%= state.equalsIgnoreCase("1") ? true : false %>' >accepted</aui:option>
				<aui:option value="P" selected='<%= state.equalsIgnoreCase("P") ? true : false %>' >published</aui:option>
	</aui:select>
</div>
<!--<aui:input name="diseases" label="Search Disease:" size="90"  value="<%= diseases %>" />-->
<div style="float:left;">
<aui:button-row>
	<aui:button name="filter" type="submit" value="filter" label="Filter" cssClass="rdc-filter-button" />
	<!--<aui:button name="clear" type="clear" value="clear" label="Clear" cssClass="clearFilterButton" />-->
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
    //portletURL.setParameter("disease", disease);
    portletURL.setParameter("country", country);
    portletURL.setParameter("source", source);
    portletURL.setParameter("diseases", diseases);    
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

/*
	AT Hook
*/
if(themeDisplay.getUserId() == 105078 || themeDisplay.getUserId() == 105092) {
	country = "Austria";
}
List<Candidate> tempResults = CandidateLocalServiceUtil.getFilterdCandidates(name, country, candidatetype, source, state);
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
name="ID"
property="candidateId"
cssClass="candidate-table-candidateId"
/>
<liferay-ui:search-container-column-jsp
align="right" 
path="/html/candidate/candidatetabel/candidatetable_name.jsp"
cssClass="candidate-table-namecontainer"
/>
<liferay-ui:search-container-column-text
name="country"
property="country"
cssClass="candidate-table-country"
/>
<liferay-ui:search-container-column-jsp
align="right" 
path="/html/candidate/candidatetabel/candidatetable_types.jsp"
cssClass="candidate-table-candidatetype"
/>
<liferay-ui:search-container-column-text
name="source"
property="source"
cssClass="candidate-table-source"
/>
<liferay-ui:search-container-column-jsp
align="right" 
path="/html/candidate/candidatetabel/editsub.jsp"
cssClass="candidate-table-editsub"
/>
</liferay-ui:search-container-row>

<%        
portletURL.setParameter("cur", String.valueOf(cur)); 
//portletURL.setParameter("disease", disease);
portletURL.setParameter("country", country);
portletURL.setParameter("source", source);
portletURL.setParameter("diseases", diseases);
portletURL.setParameter("candidatetype", candidatetype);
portletURL.setParameter("name", name);
searchContainer.setIteratorURL(portletURL);    %>
    <liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</liferay-ui:search-container>
</div>

<portlet:actionURL name='updateCandidateTableData' var="updateCandidateTableDataURL" />

<aui:script use="aui-io-request, event, node, aui-popover, valuechange, event-hover, aui-tooltip, event-valuechange, click">
	AUI().use('aui-io-request', 'event-valuechange', 'node', function(A){
		var nodeObject = A.all('#masterid');
		nodeObject.on('valuechange', function(event){
			var url = '<%= updateCandidateTableDataURL.toString() %>';
			A.io.request(url,{
				//this is the data that you are sending to the action method
				data: {
					
				   <portlet:namespace />candidateid: event.target.get('parentNode').get('parentNode').one('#candidateid').get('value'),
				   <portlet:namespace />masterid: event.target.get('parentNode').get('parentNode').one('#masterid').get('value'),
				   <portlet:namespace />state: event.target.get('parentNode').get('parentNode').one('#state').get('value'),
				},
				dataType: 'json',
				on: {
				  failure: function() { alert('failure'); },
				  success: function(event, id, obj) { "success" }
				}
			});
		});
	});
	AUI().use('aui-io-request', 'event', 'node', 'event-valuechange', 'click', function(A){
		var nodeObject = A.all('#state');
		nodeObject.on('click', function(event){
			var url = '<%= updateCandidateTableDataURL.toString() %>';
			A.io.request(url,{
				//this is the data that you are sending to the action method
				data: {
					
				   <portlet:namespace />candidateid: 	event.target.get('parentNode').get('parentNode').one('#candidateid').get('value'),
				   <portlet:namespace />masterid: 		event.target.get('parentNode').get('parentNode').one('#masterid').get('value'),
				   <portlet:namespace />state: 			event.target.get('parentNode').get('parentNode').one('#state').get('value'),
				},
				dataType: 'json',
				on: {
				  failure: function() { alert('failure'); },
				  success: function(event, id, obj) { "success" }
				}
			});
		});
	});
	AUI().use('event', 'node', function(A){
		var nodeObject = A.all('.clearFilterButton');
		nodeObject.on('click', function(event){
			var url = '<%= urltounfilterd %>';
			alert(url);
			window.location.assign(url);
		});
	});
	AUI().use('node', function(A){
		var nodeObject = A.all('#_candidatetabel_WAR_RDConnectportlet_candidatesSearchContainer_col-6');
		nodeObject.setHTML('J / A');
	});
	AUI().use('node', function(A){
		var nodeObject = A.all('#_candidatetabel_WAR_RDConnectportlet_candidatesSearchContainer_col-2');
		nodeObject.setHTML('Information');
	});
	AUI().use('node', function(A){
		var nodeObject = A.all('#_candidatetabel_WAR_RDConnectportlet_candidatesSearchContainer_col-4');
		nodeObject.setHTML('Type');
	});
	AUI().use('aui-tooltip', function(A) {
    	new A.Tooltip(
      	{
        	trigger: '#rdc-filter-name-help',
        	position: 'right',
        	cssClass: 'tooltip-help'
      	});
  	});
</aui:script>