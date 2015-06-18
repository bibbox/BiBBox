/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package at.meduni.liferay.portlet.rdconnect.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SearchIndex. This utility wraps
 * {@link at.meduni.liferay.portlet.rdconnect.service.impl.SearchIndexLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Robert Reihs
 * @see SearchIndexLocalService
 * @see at.meduni.liferay.portlet.rdconnect.service.base.SearchIndexLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.rdconnect.service.impl.SearchIndexLocalServiceImpl
 * @generated
 */
public class SearchIndexLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.meduni.liferay.portlet.rdconnect.service.impl.SearchIndexLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the search index to the database. Also notifies the appropriate model listeners.
	*
	* @param searchIndex the search index
	* @return the search index that was added
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex addSearchIndex(
		at.meduni.liferay.portlet.rdconnect.model.SearchIndex searchIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSearchIndex(searchIndex);
	}

	/**
	* Creates a new search index with the primary key. Does not add the search index to the database.
	*
	* @param searchid the primary key for the new search index
	* @return the new search index
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex createSearchIndex(
		long searchid) {
		return getService().createSearchIndex(searchid);
	}

	/**
	* Deletes the search index with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param searchid the primary key of the search index
	* @return the search index that was removed
	* @throws PortalException if a search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex deleteSearchIndex(
		long searchid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSearchIndex(searchid);
	}

	/**
	* Deletes the search index from the database. Also notifies the appropriate model listeners.
	*
	* @param searchIndex the search index
	* @return the search index that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex deleteSearchIndex(
		at.meduni.liferay.portlet.rdconnect.model.SearchIndex searchIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSearchIndex(searchIndex);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex fetchSearchIndex(
		long searchid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSearchIndex(searchid);
	}

	/**
	* Returns the search index with the primary key.
	*
	* @param searchid the primary key of the search index
	* @return the search index
	* @throws PortalException if a search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex getSearchIndex(
		long searchid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSearchIndex(searchid);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the search indexs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of search indexs
	* @param end the upper bound of the range of search indexs (not inclusive)
	* @return the range of search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.SearchIndex> getSearchIndexs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSearchIndexs(start, end);
	}

	/**
	* Returns the number of search indexs.
	*
	* @return the number of search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static int getSearchIndexsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSearchIndexsCount();
	}

	/**
	* Updates the search index in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param searchIndex the search index
	* @return the search index that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex updateSearchIndex(
		at.meduni.liferay.portlet.rdconnect.model.SearchIndex searchIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSearchIndex(searchIndex);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Search index for normal Search
	*/
	public static java.lang.String getSearchIndexByKeyword(
		java.lang.String keyword,
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.lang.String contextpath) {
		return getService()
				   .getSearchIndexByKeyword(keyword, themeDisplay, contextpath);
	}

	/**
	* Search for Reporting system for general user
	*
	* @param keyword
	* @param type
	* @return
	*/
	public static java.lang.String getSearchIndexByKeyword(
		java.lang.String keyword, java.lang.String type,
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.lang.String contextpath, long maincontactrole) {
		return getService()
				   .getSearchIndexByKeyword(keyword, type, themeDisplay,
			contextpath, maincontactrole);
	}

	/**
	* Create User Statistics
	*
	* @return
	*/
	public static java.lang.String getUserStatistiks() {
		return getService().getUserStatistiks();
	}

	public static void clearService() {
		_service = null;
	}

	public static SearchIndexLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SearchIndexLocalService.class.getName());

			if (invokableLocalService instanceof SearchIndexLocalService) {
				_service = (SearchIndexLocalService)invokableLocalService;
			}
			else {
				_service = new SearchIndexLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SearchIndexLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SearchIndexLocalService service) {
	}

	private static SearchIndexLocalService _service;
}