package at.meduni.liferay.portlet.rdconnect.search;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.facet.AssetEntriesFacet;
import com.liferay.portal.kernel.search.facet.Facet;
import com.liferay.portal.kernel.search.facet.ScopeFacet;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SearchField
 */
public class SearchField extends MVCPortlet {
	public void test(ActionRequest request, ActionResponse response) throws Exception {
		/*SearchContext searchContext = SearchContextFactory.getInstance(request);
		searchContext.setAttribute("paginationType", "more");
		searchContext.setEnd(mainSearchSearchContainer.getEnd());
		searchContext.setStart(mainSearchSearchContainer.getStart());
		
		Facet assetEntriesFacet = new AssetEntriesFacet(searchContext);
		assetEntriesFacet.setStatic(true);
		searchContext.addFacet(assetEntriesFacet);

		Facet scopeFacet = new ScopeFacet(searchContext);
		scopeFacet.setStatic(true);
		searchContext.addFacet(scopeFacet);
		
		Indexer indexer = IndexerRegistryUtil.getIndexer(PluginPackage.class);
		Hits hits = indexer.search(searchContext);*/
		
	}

}
