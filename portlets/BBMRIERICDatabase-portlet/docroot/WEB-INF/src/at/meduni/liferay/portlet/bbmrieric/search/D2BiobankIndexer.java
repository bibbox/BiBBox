package at.meduni.liferay.portlet.bbmrieric.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.PortletURL;

import at.meduni.liferay.portlet.bbmrieric.model.D2Biobank;
import at.meduni.liferay.portlet.bbmrieric.permission.D2BiobankPermission;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.persistence.D2BiobankActionableDynamicQuery;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;

public class D2BiobankIndexer extends BaseIndexer {
	
	public static final String[] CLASS_NAMES = { D2Biobank.class.getName() };

    public static final String PORTLET_ID = "BBMRIERICDatabase-portlet";
    
    public D2BiobankIndexer() {
    	setPermissionAware(true);
    }

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}
	
	@Override
    public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, long entryClassPK, String actionId) throws Exception {

            return D2BiobankPermission.contains(permissionChecker, entryClassPK, ActionKeys.VIEW);
    }

	@Override
	protected void doDelete(Object obj) throws Exception {
		D2Biobank biobank = (D2Biobank)obj;
		deleteDocument(biobank.getCompanyId(), biobank.getBiobankId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		D2Biobank biobank = (D2Biobank)obj;
		Document document = getBaseModelDocument(PORTLET_ID, biobank);

        document.addDate(Field.MODIFIED_DATE, biobank.getModifiedDate());
        document.addText(Field.CONTENT, biobank.getBiobankDescription());
        document.addText(Field.TITLE, biobank.getBiobankName());
        document.addText("country", biobank.getBiobankCountry());
        document.addKeyword(Field.GROUP_ID, getSiteGroupId(biobank.getGroupId()));
        document.addKeyword(Field.SCOPE_GROUP_ID, biobank.getGroupId());
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception {
		Summary summary = createSummary(document);
        summary.setMaxContentLength(200);
        return summary;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		D2Biobank biobank = (D2Biobank)obj;
		Document document = getDocument(biobank);
		SearchEngineUtil.updateDocument(getSearchEngineId(), biobank.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		D2Biobank biobank = D2BiobankLocalServiceUtil.getD2Biobank(classPK);
		doReindex(biobank);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexBiobanks(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}
	
	protected void reindexBiobanks(long companyId) throws PortalException, SystemException {
		final Collection<Document> documents = new ArrayList<Document>();

        ActionableDynamicQuery actionableDynamicQuery = new D2BiobankActionableDynamicQuery() {
        	@Override
        	protected void addCriteria(DynamicQuery dynamicQuery) {
        	}

        	@Override
        	protected void performAction(Object object) throws PortalException {
        		D2Biobank biobank = (D2Biobank) object;
        		Document document = getDocument(biobank);
        		documents.add(document);
        	}
        };
        actionableDynamicQuery.setCompanyId(companyId);
        actionableDynamicQuery.performActions();
        SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents);
	}
}
