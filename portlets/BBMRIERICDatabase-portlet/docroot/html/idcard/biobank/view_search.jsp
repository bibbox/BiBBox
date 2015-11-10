<%@ include file="/html/idcard/init.jsp" %>

<%
    String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/html/idcard/biobank/view_search.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
        <portlet:param name="mvcPath" value="/html/idcard/biobank/view.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />

    <liferay-ui:header
        backURL="<%= viewURL.toString() %>"
        title="search"
    />

    <div class="search-form">
        <span class="aui-search-bar">
            <aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" />

            <aui:button type="submit" value="search" />
        </span>
    </div>
</aui:form>

<%
        SearchContext searchContext = SearchContextFactory.getInstance(request);

        searchContext.setKeywords(keywords);
        searchContext.setAttribute("paginationType", "more");
        searchContext.setStart(0);
        searchContext.setEnd(10);

        Indexer indexer = IndexerRegistryUtil.getIndexer(D2Biobank.class);

        Hits hits = indexer.search(searchContext);

        List<D2Biobank> biobanks = new ArrayList<D2Biobank>();

        for (int i = 0; i < hits.getDocs().length; i++) {
                Document doc = hits.doc(i);

                long biobankId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));

                D2Biobank biobank = null;

                try {
                	biobank = D2BiobankLocalServiceUtil.getD2Biobank(biobankId);
                } catch (PortalException pe) {
                        _log.error(pe.getLocalizedMessage());
                } catch (SystemException se) {
                        _log.error(se.getLocalizedMessage());
                }

                biobanks.add(biobank);
        }
%>

<liferay-ui:search-container delta="10" emptyResultsMessage="no-entries-were-found">
        <liferay-ui:search-container-results
                results="<%= biobanks %>"
                total="<%= biobanks.size() %>"
        />

        <liferay-ui:search-container-row
                className="at.meduni.liferay.portlet.bbmrieric.model.D2Biobank"
                keyProperty="biobankId" modelVar="biobank" escapedModel="<%=true%>">

                <liferay-ui:search-container-column-text property="biobankId" />

                <liferay-ui:search-container-column-text property="biobankName" />

                <liferay-ui:search-container-column-jsp
            path="/html/idcard/biobank/biobank_actions.jsp"
            align="right" />
        </liferay-ui:search-container-row>

        <liferay-ui:search-iterator />
</liferay-ui:search-container>

<%
        if (Validator.isNotNull(keywords)) {
                String currentURL = PortalUtil.getCurrentURL(request);
                PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "search") + ": " + keywords, currentURL);
        }
%>

<%!
        private static Log _log = LogFactoryUtil.getLog("docroot.html.idcard.biobank.view_search_jsp");
%>