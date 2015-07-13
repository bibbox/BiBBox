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
<style>
<!--
.optionitelic {
	font-style: italic;
}
.optionbold {
	font-weight: bold;
}
-->
</style>
<%
long optionsMainContactRole_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsMainContactRole", "13320"));

	String keywords = "";
	HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
	httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
	keywords = httpRequest.getParameter("SEARCH");
	if (keywords == null) {
		keywords = "";
	}

	String candidatetype = httpRequest.getParameter(renderResponse.getNamespace() + "candidatetype");
	if(candidatetype == null) {
		candidatetype = "";
	}
	
	String country_filter = httpRequest.getParameter(renderResponse.getNamespace() + "country");
	if (country_filter == null) {
		country_filter = "";
	}
	
	String materialtype = httpRequest.getParameter(renderResponse.getNamespace() + "materialtype");
	if (materialtype == null) {
		materialtype = "";
	}
	
	String diagnosisavailable_filter = httpRequest.getParameter(renderResponse.getNamespace() + "diagnosisavailable");
	if (diagnosisavailable_filter == null) {
		diagnosisavailable_filter = "";
	}
	String biobanksize_filter = httpRequest.getParameter(renderResponse.getNamespace() + "biobanksize");
	if (biobanksize_filter == null) {
		biobanksize_filter = "";
	}
	String typeofbiobank = httpRequest.getParameter(renderResponse.getNamespace() + "typeofbiobank");
	if (typeofbiobank == null) {
		typeofbiobank = "";
	}

	String[] materialtypes = SearchIndexLocalServiceUtil.getMaterialTypes();
	String[] diagnosisavailable = SearchIndexLocalServiceUtil.getDiagnosisAvailable();
	String[] country = SearchIndexLocalServiceUtil.getCountry();
	String[] biobanksize = SearchIndexLocalServiceUtil.getBiobankSize();
	String[] typeofbiobanks = SearchIndexLocalServiceUtil.getTypeOfBiobank();
 
	String url = themeDisplay.getURLPortal()+"/web/guest/id-card-beta?biobankId=";
	//String url = themeDisplay.getURLPortal()+"/web/guest/bbmri-eric?biobankId=";
	
	String searchurl = themeDisplay.getURLPortal() + layout.getFriendlyURL(); //"/web/guest/bbmri-eric";//
%>

<aui:form action="<%= searchurl.toString() %>" method="GET" name="fm">
	<aui:layout>
		<aui:fieldset>
		 
			<aui:column columnWidth="100" first="true">
				<input style="width: 420px;" type="text" placeholder="search by: Disease Name, Gene, ORPHACODE,  ICD10, OMIM ..." value="<%= keywords %>" name="SEARCH" size="60">
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:select inlineLabel="left" name="materialtype" label="Material Types:" cssClass="rdc-filter-input"  >
					<aui:option value="" selected='<%= materialtype.equalsIgnoreCase("") ? true : false %>'></aui:option>
					<% for (String string : materialtypes) { %>
					<aui:option value="<%= string %>" selected="<%= materialtype.equalsIgnoreCase(string) ? true : false %>">
						<%= string.replaceAll("biobankMaterialStored", "") %>
					</aui:option>
					<% } %>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="25" >
				<aui:select inlineLabel="left" name="diagnosisavailable" label="Diagnosis Available:" cssClass="rdc-filter-input"  >
					<aui:option value="" selected='<%= diagnosisavailable_filter.equalsIgnoreCase("") ? true : false %>'></aui:option>
					<% for (String string : diagnosisavailable) { 
						String cssclass = "";
						if(string.startsWith("--")) {
							cssclass = "optionitelic";
						}
						if(!string.startsWith("-")) {
							cssclass = "optionbold";
						}
						%>
					<aui:option cssClass="<%= cssclass %>" value="<%= string %>" selected="<%= diagnosisavailable_filter.equalsIgnoreCase(string) ? true : false %>">
						<%= string.replaceAll("urn:miriam:", "") %>
					</aui:option>
					<% } %>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="25" >
				<aui:select inlineLabel="left" name="country" label="Country:" cssClass="rdc-filter-input"  >
					<aui:option value="" selected='<%= country_filter.equalsIgnoreCase("") ? true : false %>'></aui:option>
					<% for (String string : country) { %>
					<aui:option value="<%= string %>" selected="<%= country_filter.equalsIgnoreCase(string) ? true : false %>">
						<%= com.liferay.portal.service.CountryServiceUtil.getCountryByA2(string).getNameCurrentValue() %>
					</aui:option>
					<% } %>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="25" last="true" >
				<aui:select inlineLabel="left" name="biobanksize" label="Biobank Size:" cssClass="rdc-filter-input"  >
					<aui:option value="" selected='<%= biobanksize_filter.equalsIgnoreCase("") ? true : false %>'></aui:option>
					<% for (String string : biobanksize) { %>
					<aui:option value="<%= string %>" selected="<%= biobanksize_filter.equalsIgnoreCase(string) ? true : false %>">
						<%= string %>
					</aui:option>
					<% } %>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="25" first="true" >
				<aui:select inlineLabel="left" name="typeofbiobank" label="Type of Biobank:" cssClass="rdc-filter-input"  >
					<aui:option value="" selected='<%= typeofbiobank.equalsIgnoreCase("") ? true : false %>'></aui:option>
					<% for (String string : typeofbiobanks) { %>
					<aui:option value="<%= string %>" selected="<%= typeofbiobank.equalsIgnoreCase(string) ? true : false %>">
						<%= string %>
					</aui:option>
					<% } %>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="15" >
				<aui:button-row cssClass="searchFiledFloat">
					<aui:button type="submit" value="Filter" />
				</aui:button-row>
			</aui:column>
		</aui:fieldset>
		
	</aui:layout>
</aui:form>

<%
String textresult = BioBankLocalServiceUtil.getBioBankFiltered(keywords, country_filter, materialtype, diagnosisavailable_filter, biobanksize_filter, typeofbiobank);
//String textresult = BioBankLocalServiceUtil.getBioBankByCountryInJavaScriptArray("");
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
    		sortable: true,
    	},
    	{
    		key: 'BB_ID',
    		label: 'BB ID',
    		sortable: true,
    		allowHTML: true,
    		formatter: function (o) {
    			//encodeURIComponent
    			return '<a href="<%= url %>' + encodeURIComponent(o.data.BB_ID) + '">' + o.data.BB_ID.replace('bbmri-eric:', '') + '</a>';
    		}
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
