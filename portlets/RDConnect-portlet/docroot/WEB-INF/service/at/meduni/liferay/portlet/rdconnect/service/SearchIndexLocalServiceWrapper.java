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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SearchIndexLocalService}.
 *
 * @author Robert Reihs
 * @see SearchIndexLocalService
 * @generated
 */
public class SearchIndexLocalServiceWrapper implements SearchIndexLocalService,
	ServiceWrapper<SearchIndexLocalService> {
	public SearchIndexLocalServiceWrapper(
		SearchIndexLocalService searchIndexLocalService) {
		_searchIndexLocalService = searchIndexLocalService;
	}

	/**
	* Adds the search index to the database. Also notifies the appropriate model listeners.
	*
	* @param searchIndex the search index
	* @return the search index that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.SearchIndex addSearchIndex(
		at.meduni.liferay.portlet.rdconnect.model.SearchIndex searchIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchIndexLocalService.addSearchIndex(searchIndex);
	}

	/**
	* Creates a new search index with the primary key. Does not add the search index to the database.
	*
	* @param searchid the primary key for the new search index
	* @return the new search index
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.SearchIndex createSearchIndex(
		long searchid) {
		return _searchIndexLocalService.createSearchIndex(searchid);
	}

	/**
	* Deletes the search index with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param searchid the primary key of the search index
	* @return the search index that was removed
	* @throws PortalException if a search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.SearchIndex deleteSearchIndex(
		long searchid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _searchIndexLocalService.deleteSearchIndex(searchid);
	}

	/**
	* Deletes the search index from the database. Also notifies the appropriate model listeners.
	*
	* @param searchIndex the search index
	* @return the search index that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.SearchIndex deleteSearchIndex(
		at.meduni.liferay.portlet.rdconnect.model.SearchIndex searchIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchIndexLocalService.deleteSearchIndex(searchIndex);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _searchIndexLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchIndexLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _searchIndexLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchIndexLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchIndexLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchIndexLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.meduni.liferay.portlet.rdconnect.model.SearchIndex fetchSearchIndex(
		long searchid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchIndexLocalService.fetchSearchIndex(searchid);
	}

	/**
	* Returns the search index with the primary key.
	*
	* @param searchid the primary key of the search index
	* @return the search index
	* @throws PortalException if a search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.SearchIndex getSearchIndex(
		long searchid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _searchIndexLocalService.getSearchIndex(searchid);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _searchIndexLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<at.meduni.liferay.portlet.rdconnect.model.SearchIndex> getSearchIndexs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchIndexLocalService.getSearchIndexs(start, end);
	}

	/**
	* Returns the number of search indexs.
	*
	* @return the number of search indexs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSearchIndexsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchIndexLocalService.getSearchIndexsCount();
	}

	/**
	* Updates the search index in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param searchIndex the search index
	* @return the search index that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.SearchIndex updateSearchIndex(
		at.meduni.liferay.portlet.rdconnect.model.SearchIndex searchIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _searchIndexLocalService.updateSearchIndex(searchIndex);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _searchIndexLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_searchIndexLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _searchIndexLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Search index for normal Search
	*/
	@Override
	public java.lang.String getSearchIndexByKeyword(java.lang.String keyword,
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.lang.String contextpath) {
		return _searchIndexLocalService.getSearchIndexByKeyword(keyword,
			themeDisplay, contextpath);
	}

	/**
	* Search for Reporting system for general user
	*
	* @param keyword
	* @param type
	* @return
	*/
	@Override
	public java.lang.String getSearchIndexByKeyword(java.lang.String keyword,
		java.lang.String type,
		com.liferay.portal.theme.ThemeDisplay themeDisplay,
		java.lang.String contextpath) {
		return _searchIndexLocalService.getSearchIndexByKeyword(keyword, type,
			themeDisplay, contextpath);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SearchIndexLocalService getWrappedSearchIndexLocalService() {
		return _searchIndexLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSearchIndexLocalService(
		SearchIndexLocalService searchIndexLocalService) {
		_searchIndexLocalService = searchIndexLocalService;
	}

	@Override
	public SearchIndexLocalService getWrappedService() {
		return _searchIndexLocalService;
	}

	@Override
	public void setWrappedService(
		SearchIndexLocalService searchIndexLocalService) {
		_searchIndexLocalService = searchIndexLocalService;
	}

	private SearchIndexLocalService _searchIndexLocalService;
}