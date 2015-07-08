<%@ include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet"%>
<%@ page import="com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.WebsiteLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@ page import="com.liferay.portal.service.UserGroupRoleLocalServiceUtil"%>
<%@ page import="com.liferay.portal.model.UserGroupRole"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

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

	String[] types = {};
	//bbmri-eric
	String url = themeDisplay.getURLPortal()+"/web/guest/id-card-beta?biobankId=";
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
String textresult = BioBankLocalServiceUtil.getBioBankByCountryInJavaScriptArray("");
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
    		key: 'Country',
    		sortable: false,
    	},
    	{
    		key: 'BB_ID',
    		label: 'BB ID',
    		sortable: true
    	},
    	{
    		key: 'Name',
    		sortable: true,
    		allowHTML: true,
    		formatter: function (o) {
    			//encodeURIComponent
    			return '<a href="<%= url %>' + encodeURIComponent(o.data.BB_ID) + '">' + o.data.Name + '</a>';
    		}
    	},
    	{
    		key: 'Type',
    		sortable: true
    	},
    	{
    		key: 'Size',
    		sortable: true
    	},
    	{
    		key: 'Juristic Person',
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
