<%@ include file="/html/init.jsp" %>

<portlet:defineObjects />

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.search.SearchContext"%>
<%@ page import="com.liferay.portal.kernel.search.SearchContextFactory"%>
<%@ page import="com.liferay.portal.kernel.search.facet.AssetEntriesFacet"%>
<%@ page import="com.liferay.portal.kernel.search.facet.Facet"%>
<%@ page import="com.liferay.portal.kernel.search.facet.ScopeFacet"%>
<%@ page import="com.liferay.portal.kernel.search.facet.SimpleFacet"%>
<%@ page import="com.liferay.portal.kernel.search.Indexer"%>
<%@ page import="com.liferay.portal.kernel.search.IndexerRegistryUtil"%>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecord" %>
<%@ page import="com.liferay.portal.kernel.search.FacetedSearcher" %>
<%@ page import="com.liferay.portal.kernel.search.Hits" %>
<%@ page import="com.liferay.portal.kernel.search.Document" %>
<%@ page import="com.liferay.portal.kernel.search.facet.collector.FacetCollector" %>
<%@ page import="com.liferay.portal.kernel.search.facet.collector.TermCollector" %>
<%@ page import="com.liferay.portal.kernel.search.facet.config.FacetConfiguration" %>
<%@ page import="com.liferay.util.PropertyComparator" %>
<%@ page import="com.liferay.portal.kernel.search.facet.config.FacetConfigurationUtil" %>
<%@ page import="com.liferay.portal.kernel.search.facet.util.FacetFactoryUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="java.util.Map" %>

<portlet:defineObjects />

<!--  -->
<% 
SearchContext searchContext = SearchContextFactory.getInstance(request);

searchContext.setAttribute("paginationType", "more");
searchContext.setEnd(-1);
searchContext.setStart(-1);

String[] entryCalssName = {DDLRecord.class.getName()};
searchContext.setEntryClassNames(entryCalssName);

String keywords = "";
HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
keywords = httpRequest.getParameter("SEARCH");
searchContext.setKeywords(keywords);
/*Facet assetEntriesFacet = new AssetEntriesFacet(searchContext);
assetEntriesFacet.setStatic(true);
searchContext.addFacet(assetEntriesFacet);

Facet scopeFacet = new ScopeFacet(searchContext);
scopeFacet.setStatic(true);
searchContext.addFacet(scopeFacet);*/

//Facet simpleFacet = new SimpleFacet(searchContext);
//simpleFacet.setStatic(true);
//searchContext.addFacet(simpleFacet);
String searchConfiguration = "{\"facets\": ["+
		"{"+
		"    \"displayStyle\": \"scopes\","+
		"    \"weight\": 1.6,"+
		"    \"static\": false,"+
		"    \"order\": \"OrderHitsDesc\","+
		"    \"data\": {"+
		"        \"maxTerms\": 10,"+
		"        \"frequencyThreshold\": 1,"+
		"        \"showAssetCount\": true"+
		"    },"+
		"    \"label\": \"site\","+
		"    \"className\": \"com.liferay.portal.kernel.search.facet.ScopeFacet\","+
		"   \"fieldName\": \"groupId\""+
		"},"+
		"{"+
		"   \"displayStyle\": \"asset_entries\","+
		"    \"weight\": 1.5,"+
		"    \"static\": false,"+
		"    \"order\": \"OrderHitsDesc\","+
		"    \"data\": {"+
		"        \"values\": ["+
		"            \"com.liferay.portal.model.User\","+
		"            \"com.liferay.portlet.bookmarks.model.BookmarksEntry\","+
		"            \"com.liferay.portlet.bookmarks.model.BookmarksFolder\","+
		"            \"com.liferay.portlet.blogs.model.BlogsEntry\","+
		"            \"com.liferay.portlet.documentlibrary.model.DLFileEntry\","+
		"            \"com.liferay.portlet.documentlibrary.model.DLFolder\","+
		"            \"com.liferay.portlet.journal.model.JournalArticle\","+
		"            \"com.liferay.portlet.journal.model.JournalFolder\","+
		"            \"com.liferay.portlet.messageboards.model.MBMessage\","+
		"            \"com.liferay.portlet.wiki.model.WikiPage\","+
		"            \"com.liferay.portlet.dynamicdatalists.model.DDLRecord\","+
		"            \"com.liferay.portlet.dynamicdatalists.model.DDLRecordSet\""+
		"        ],"+
		"        \"frequencyThreshold\": 1"+
		"    },"+
		"    \"label\": \"asset-type\","+
		"    \"className\": \"com.liferay.portal.kernel.search.facet.AssetEntriesFacet\","+
		"    \"fieldName\": \"entryClassName\""+
		"},"+
		"{"+
		"    \"displayStyle\": \"asset_tags\","+
		"    \"weight\": 1.4,"+
		"    \"static\": false,"+
		"    \"order\": \"OrderHitsDesc\","+
		"    \"data\": {"+
		"        \"maxTerms\": 10,"+
		"        \"displayStyle\": \"list\","+
		"        \"frequencyThreshold\": 1,"+
		"        \"showAssetCount\": true"+
		"    },"+
		"    \"label\": \"tag\","+
		"    \"className\": \"com.liferay.portal.kernel.search.facet.MultiValueFacet\","+
		"    \"fieldName\": \"assetTagNames\""+
		"},"+
		"{"+
		"    \"displayStyle\": \"folders\","+
		"    \"weight\": 1.2,"+
		"    \"static\": false,"+
		"    \"order\": \"OrderHitsDesc\","+
		"    \"data\": {"+
		"        \"maxTerms\": 10,"+
		"        \"frequencyThreshold\": 1,"+
		"        \"showAssetCount\": true"+
		"    },"+
		"    \"label\": \"folder\","+
		"    \"className\": \"com.liferay.portal.kernel.search.facet.MultiValueFacet\","+
		"    \"fieldName\": \"folderId\""+
		"},"+
		"{"+
		"    \"displayStyle\": \"users\","+
		"    \"weight\": 1.1,"+
		"    \"static\": false,"+
		"    \"order\": \"OrderHitsDesc\","+
		"    \"data\": {"+
		"        \"maxTerms\": 10,"+
		"        \"frequencyThreshold\": 1,"+
		"        \"showAssetCount\": true"+
		"    },"+
		"    \"label\": \"user\","+
		"    \"className\": \"com.liferay.portal.kernel.search.facet.MultiValueFacet\","+
		"    \"fieldName\": \"userId\""+
		"},"+
		"{"+
		"    \"displayStyle\": \"modified\","+
		"    \"weight\": 1,"+
		"    \"static\": false,"+
		"    \"order\": \"OrderHitsDesc\","+
		"    \"data\": {"+
		"        \"ranges\": ["+
		"            {"+
		"                \"range\": \"[past-hour TO *]\","+
		"                \"label\": \"past-hour\""+
		"            },"+
		"            {"+
		"                \"range\": \"[past-24-hours TO *]\","+
		"                \"label\": \"past-24-hours\""+
		"            },"+
		"            {"+
		"                \"range\": \"[past-week TO *]\","+
		"                \"label\": \"past-week\""+
		"            },"+
		"            {"+
		"                \"range\": \"[past-month TO *]\","+
		"                \"label\": \"past-month\""+
		"            },"+
		"            {"+
		"                \"range\": \"[past-year TO *]\","+
		"                \"label\": \"past-year\""+
		"            }"+
		"        ],"+
		"        \"frequencyThreshold\": 0"+
		"    },"+
		"    \"label\": \"modified\","+
		"    \"className\": \"com.liferay.portal.kernel.search.facet.ModifiedFacet\","+
		"    \"fieldName\": \"modified\""+
		"}"+
		"]}";

List<FacetConfiguration> facetConfigurations = FacetConfigurationUtil.load(searchConfiguration);

for (FacetConfiguration facetConfiguration : facetConfigurations) {
	Facet facet = FacetFactoryUtil.create(searchContext, facetConfiguration);

	searchContext.addFacet(facet);
}

//Indexer indexer = IndexerRegistryUtil.getIndexer(DDLRecord.class);
Indexer indexer = FacetedSearcher.getInstance();

Hits hits = indexer.search(searchContext);

List<Document> docs = hits.toList();

Document[] docs2 = hits.getDocs();

%>
Search for: <%= keywords %>
<br>
Number of hits: <%= hits.getLength() %>/<%= docs.size() %>/<%= docs2.length %>
<br>
SearchTime: <%= hits.getSearchTime() %>
<br>
<hr>
<!--  -->

<%
for(Document d : docs) {
	com.liferay.portal.kernel.search.Field fil = d.getField("organizationIds");
%>
	Document: <%= d.getUID() %>/<%= d.getClass().toString() %>/
	<% if(fil != null) { %>
		<%= fil.getName() %>:<%= fil.getValue() %><br>
	<% } %>
<%
	Map<String, com.liferay.portal.kernel.search.Field> fiels = d.getFields();
	for(String key : fiels.keySet()) {
		com.liferay.portal.kernel.search.Field f = fiels.get(key);
		if(f != null) {
			%>
			- Fields: <%= key %>/<%= f.getName() %>:<%= f.getValue() %><br>
			<%
		}
	}
}
%>

