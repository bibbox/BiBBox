<%@include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet"%>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.WebsiteLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil"%>
<%@ page import="com.liferay.portal.model.UserGroupRole"%>
<%@ page import="java.util.ArrayList"%>

<portlet:defineObjects />

<%
long optionsMainContactRole_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", "13320"));

	String keywords = "";
	HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
	keywords = httpRequest.getParameter("SEARCH");
	if (keywords == null) {
		keywords = "";
	}

	String candidatetype = ParamUtil.getString(request, "candidatetype");
	if(candidatetype.equalsIgnoreCase("")) {
		candidatetype = "all";
	}

	String[] types = CandidateLocalServiceUtil.getTypesOfCandidates();
%>

<portlet:actionURL name='filterList' var="filterListURL" />
<aui:form action="<%= filterListURL.toString() %>" method="POST" name="fm">
	<aui:layout>
		<aui:fieldset>
		 
			<aui:column columnWidth="50" first="true">
				<input style="width: 420px;" type="text" placeholder="search by: Disease Name, Gene, ORPHACODE,  ICD10, OMIM ..." value="<%= keywords %>" name="SEARCH" size="60">
			</aui:column>
			<aui:column columnWidth="35">
				<aui:select inlineLabel="left" name="candidatetype" label="Type:" cssClass="rdc-filter-input"  >
					<% for (String string : types) { %>
					<aui:option value="<%= string %>" selected="<%= candidatetype.equalsIgnoreCase(string) ? true : false %>">
						<%= string %>
					</aui:option>
					<% } %>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="15" last="true">
				<aui:button-row cssClass="searchFiledFloat">
					<aui:button type="submit" value="Filter" />
				</aui:button-row>
			</aui:column>
		</aui:fieldset>
		
	</aui:layout>
</aui:form>

<%
	String textresult = SearchIndexLocalServiceUtil.getSearchIndexByKeyword(keywords, candidatetype, themeDisplay, request.getContextPath(), optionsMainContactRole_cfg);
//textresult = "{Name: 'Test', OrganizationLink: '/home', Type: 'Biobank', 'Number of Cases': 5, 'Data Access Committe': 'no', 'Request data':  'http://rd-connect.eu', 'Nuber of access': 0}";
%>

<div id="myDataTable"></div>

<br />
<% if(textresult.equalsIgnoreCase("No Results for the query.")) { %>
<h4><%= textresult %></h4>
<% } else { %>
<aui:script use="node,aui-datatable,aui-datatype,datatable-sort">
AUI().use(
  'aui-datatable',
  'aui-datatype',
  'datatable-sort',
  function(Y) {
    var remoteData = [<%= textresult %>];
    var nestedCols = [ 
    	{
    		key: 'Logo',
    		sortable: false,
    		allowHTML: true,
    		formatter: function (o) {
    			return '<img width="60px" src="' + o.data.OrganizationImageLink + '" alt="logo">';
    		}
    	},
    	{
    		key: 'Name',
    		sortable: true,
    		allowHTML: true,
    		formatter: function (o) {
    			return '<a href="' + o.data.OrganizationLink + '">' + o.data.Name + '</a>';
    		}
    	},
    	{
    		key: 'Type',
    		sortable: true
    	},
    	{
    		key: 'Number of Cases',
    		sortable: true
    	},
    	{
    		key: 'Data Access Committe',
    		sortable: true
    	},
    	{
    		key: 'Request data',
    		sortable: true,
    		allowHTML: true,
    		formatter: '<a href="mailto:{value}">{value}</a>'
    	},
    	{
    		key: 'Number of access',
    		sortable: true
    	}
    ];
	var dataTable = new Y.DataTable(
      {
        columns: nestedCols,
        data: remoteData,
      }
    ).render('#myDataTable');

    dataTable.get('boundingBox').unselectable();
  }
);
</aui:script>
<% } %>
