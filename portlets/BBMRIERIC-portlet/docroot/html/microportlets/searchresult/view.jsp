<%@ include file="/html/init.jsp" %>
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
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="com.liferay.portal.kernel.search.Field" %>
<%@ page import="com.liferay.portlet.asset.model.AssetRenderer" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portlet.asset.model.AssetRendererFactory" %>
<%@ page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portlet.journal.service.JournalContentSearchLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="java.util.Map" %>

<portlet:defineObjects />

<!--  -->
<% 
String portletId = themeDisplay.getPpid();
PortletURL portletURL = PortletURLFactoryUtil.create(request, portletId, plid, PortletRequest.RENDER_PHASE);
SearchContainer mainSearchSearchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, null, null);


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
		"            \"com.liferay.portlet.documentlibrary.model.DLFileEntry\","+
		"            \"com.liferay.portlet.documentlibrary.model.DLFolder\","+
		"            \"com.liferay.portlet.journal.model.JournalArticle\","+
		"            \"com.liferay.portlet.journal.model.JournalFolder\","+
		"            \"com.liferay.portlet.messageboards.model.MBMessage\","+
		"            \"com.liferay.portlet.wiki.model.WikiPage\""+
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


Map<String, Facet> facets = searchContext.getFacets();
List<Facet> facetsList = ListUtil.fromCollection(facets.values());
// Exception!!!!!
//facetsList = ListUtil.sort(facetsList, new PropertyComparator("facetConfiguration.weight", false, false));

/*for (Facet facet : facetsList) {
	if (facet.isStatic()) {
		continue;
	}

	FacetConfiguration facetConfiguration = facet.getFacetConfiguration();
	request.setAttribute("search.jsp-facet", facet);
	FacetCollector facetCollector = facet.getFacetCollector();
	List<TermCollector> termCollectors = facetCollector.getTermCollectors();


%>
	<liferay-util:include page='<%= "/html/portlet/search/facets/" + facetConfiguration.getDisplayStyle() + ".jsp" %>' />

<%
}*/	


boolean displayResultsInDocumentForm = true;
boolean displayMainQuery = false;

for(Document d : docs2) {
	String title = d.get(locale, Field.TITLE);
	Map<String, Field> fieldmap = d.getFields();
	Field f = fieldmap.get("classTypeId");
	String class_type_id = "";
	if(f != null) {
		class_type_id = f.getValue();
	}
	Field f_class = fieldmap.get("entryClassName");
	String class_type = "";
	if(f_class != null) {
		class_type = f_class.getValue();
	}
	/*if(class_type.equalsIgnoreCase("com.liferay.portlet.journal.model.JournalArticle")) {
		%>
		<%= class_type %> == com.liferay.portlet.journal.model.JournalArticle<br>
		<%
		continue;
	}*/
	String content = "";
	Field f_content = fieldmap.get("content");
	if(f_content != null) {
		content = f_content.getValue();
		content = StringUtil.shorten(HtmlUtil.stripHtml(content), 200);
	}
	String entryClassName = d.get(Field.ENTRY_CLASS_NAME);
	AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(entryClassName);
	long classPK = GetterUtil.getLong(d.get(Field.ENTRY_CLASS_PK));
	AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(classPK);
	
	String href = "";
	String image_url = "";
	int hitsize = 0;
	if(class_type_id.equalsIgnoreCase("")) {
		class_type_id = "Articel";
		String articleid = "";
		image_url = request.getContextPath() + "/images/article.png";
		Field f_articleid = fieldmap.get("articleId");
		if(f_articleid != null) {
			articleid = f_articleid.getValue();
		}
		List<Long> hitLayoutIds = JournalContentSearchLocalServiceUtil.getLayoutIds(themeDisplay.getSiteGroupId(), false, articleid); 
		hitsize = hitLayoutIds.size();
		if (hitLayoutIds.size() > 0) {
			Long hitLayoutId = hitLayoutIds.get(0);
			Layout hitLayout = LayoutLocalServiceUtil.getLayout(
			layout.getGroupId(), layout.isPrivateLayout(),
			hitLayoutId.longValue());
			href = PortalUtil.getLayoutURL(hitLayout, themeDisplay);
		}
	} else if(class_type_id.equalsIgnoreCase("10822")) {
		class_type_id = "News";
		image_url = request.getContextPath() + "/images/news.png";
		href = "http://new.bbmri-eric.eu/web/guest/news/-/asset_publisher/V6WfCYIg8I5M/content/" + assetRenderer.getUrlTitle();
	} else if(class_type_id.equalsIgnoreCase("12029")) {
		class_type_id = "Event";
		image_url = request.getContextPath() + "/images/event.png";
		href = "http://new.bbmri-eric.eu/web/guest/meetings/-/asset_publisher/5XsIcWr0VUL7/content/" + assetRenderer.getUrlTitle();
	}
%>
	<div class="bbmri-eric-search-container">
	  <div class="bbmri-eric-search-images">
	     <a href="<%= href %>"><img src="<%= image_url %>" height="30px" width="31px" /></a>
	  </div>
	  <div class="bbmri-eric-search-result">
		<a href="<%= href %>"><h3><%= title %></h3></a>
		<%= content %>
		</div>
	</div>
	<br>
<%	
	
}

%>
	
<%
/*

for(Document d : docs2) {
%>
<hr>
<div style="border-style:solid;border-width:3px;">
Documnet Name:<%= d.get(locale, Field.TITLE) %><br>
<%	
	
	Map<String, Field> fieldmap = d.getFields();
	for(String key : fieldmap.keySet()) {
		Field f = fieldmap.get(key);
		String value = f.getValue();
		if((key.contains("ddm/10822/HTML") && !key.endsWith("en_US ")) || (key.contains("ddm/12029/HTML") && !key.endsWith("en_US "))) {
			value = "yy";
		}
%>
		<%= key %> - <%= f.getName() %> - <%= value %> <br>
<%
	}
	
%>
</div>
<%
}
*/
%>



