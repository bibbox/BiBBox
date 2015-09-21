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

package at.meduni.liferay.portlet.rdconnect.service.persistence;

import at.meduni.liferay.portlet.rdconnect.model.SearchIndex;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the search index service. This utility wraps {@link SearchIndexPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see SearchIndexPersistence
 * @see SearchIndexPersistenceImpl
 * @generated
 */
public class SearchIndexUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(SearchIndex searchIndex) {
		getPersistence().clearCache(searchIndex);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SearchIndex> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SearchIndex> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SearchIndex> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SearchIndex update(SearchIndex searchIndex)
		throws SystemException {
		return getPersistence().update(searchIndex);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SearchIndex update(SearchIndex searchIndex,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(searchIndex, serviceContext);
	}

	/**
	* Returns all the search indexs where value = &#63;.
	*
	* @param value the value
	* @return the matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.SearchIndex> findByExactSearch(
		java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByExactSearch(value);
	}

	/**
	* Returns a range of all the search indexs where value = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param value the value
	* @param start the lower bound of the range of search indexs
	* @param end the upper bound of the range of search indexs (not inclusive)
	* @return the range of matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.SearchIndex> findByExactSearch(
		java.lang.String value, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByExactSearch(value, start, end);
	}

	/**
	* Returns an ordered range of all the search indexs where value = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param value the value
	* @param start the lower bound of the range of search indexs
	* @param end the upper bound of the range of search indexs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.SearchIndex> findByExactSearch(
		java.lang.String value, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExactSearch(value, start, end, orderByComparator);
	}

	/**
	* Returns the first search index in the ordered set where value = &#63;.
	*
	* @param value the value
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search index
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex findByExactSearch_First(
		java.lang.String value,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByExactSearch_First(value, orderByComparator);
	}

	/**
	* Returns the first search index in the ordered set where value = &#63;.
	*
	* @param value the value
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search index, or <code>null</code> if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex fetchByExactSearch_First(
		java.lang.String value,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByExactSearch_First(value, orderByComparator);
	}

	/**
	* Returns the last search index in the ordered set where value = &#63;.
	*
	* @param value the value
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search index
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex findByExactSearch_Last(
		java.lang.String value,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByExactSearch_Last(value, orderByComparator);
	}

	/**
	* Returns the last search index in the ordered set where value = &#63;.
	*
	* @param value the value
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search index, or <code>null</code> if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex fetchByExactSearch_Last(
		java.lang.String value,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByExactSearch_Last(value, orderByComparator);
	}

	/**
	* Returns the search indexs before and after the current search index in the ordered set where value = &#63;.
	*
	* @param searchid the primary key of the current search index
	* @param value the value
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search index
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException if a search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex[] findByExactSearch_PrevAndNext(
		long searchid, java.lang.String value,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExactSearch_PrevAndNext(searchid, value,
			orderByComparator);
	}

	/**
	* Removes all the search indexs where value = &#63; from the database.
	*
	* @param value the value
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByExactSearch(java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByExactSearch(value);
	}

	/**
	* Returns the number of search indexs where value = &#63;.
	*
	* @param value the value
	* @return the number of matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByExactSearch(java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByExactSearch(value);
	}

	/**
	* Returns the search index where organisationid = &#63; and key = &#63; or throws a {@link at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException} if it could not be found.
	*
	* @param organisationid the organisationid
	* @param key the key
	* @return the matching search index
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex findByValueForOrganization(
		long organisationid, java.lang.String key)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByValueForOrganization(organisationid, key);
	}

	/**
	* Returns the search index where organisationid = &#63; and key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param organisationid the organisationid
	* @param key the key
	* @return the matching search index, or <code>null</code> if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex fetchByValueForOrganization(
		long organisationid, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByValueForOrganization(organisationid, key);
	}

	/**
	* Returns the search index where organisationid = &#63; and key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param organisationid the organisationid
	* @param key the key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching search index, or <code>null</code> if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex fetchByValueForOrganization(
		long organisationid, java.lang.String key, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByValueForOrganization(organisationid, key,
			retrieveFromCache);
	}

	/**
	* Removes the search index where organisationid = &#63; and key = &#63; from the database.
	*
	* @param organisationid the organisationid
	* @param key the key
	* @return the search index that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex removeByValueForOrganization(
		long organisationid, java.lang.String key)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByValueForOrganization(organisationid, key);
	}

	/**
	* Returns the number of search indexs where organisationid = &#63; and key = &#63;.
	*
	* @param organisationid the organisationid
	* @param key the key
	* @return the number of matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByValueForOrganization(long organisationid,
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByValueForOrganization(organisationid, key);
	}

	/**
	* Caches the search index in the entity cache if it is enabled.
	*
	* @param searchIndex the search index
	*/
	public static void cacheResult(
		at.meduni.liferay.portlet.rdconnect.model.SearchIndex searchIndex) {
		getPersistence().cacheResult(searchIndex);
	}

	/**
	* Caches the search indexs in the entity cache if it is enabled.
	*
	* @param searchIndexs the search indexs
	*/
	public static void cacheResult(
		java.util.List<at.meduni.liferay.portlet.rdconnect.model.SearchIndex> searchIndexs) {
		getPersistence().cacheResult(searchIndexs);
	}

	/**
	* Creates a new search index with the primary key. Does not add the search index to the database.
	*
	* @param searchid the primary key for the new search index
	* @return the new search index
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex create(
		long searchid) {
		return getPersistence().create(searchid);
	}

	/**
	* Removes the search index with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param searchid the primary key of the search index
	* @return the search index that was removed
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException if a search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex remove(
		long searchid)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(searchid);
	}

	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex updateImpl(
		at.meduni.liferay.portlet.rdconnect.model.SearchIndex searchIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(searchIndex);
	}

	/**
	* Returns the search index with the primary key or throws a {@link at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException} if it could not be found.
	*
	* @param searchid the primary key of the search index
	* @return the search index
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException if a search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex findByPrimaryKey(
		long searchid)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(searchid);
	}

	/**
	* Returns the search index with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param searchid the primary key of the search index
	* @return the search index, or <code>null</code> if a search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.SearchIndex fetchByPrimaryKey(
		long searchid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(searchid);
	}

	/**
	* Returns all the search indexs.
	*
	* @return the search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.SearchIndex> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.SearchIndex> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the search indexs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of search indexs
	* @param end the upper bound of the range of search indexs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.SearchIndex> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the search indexs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of search indexs.
	*
	* @return the number of search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SearchIndexPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SearchIndexPersistence)PortletBeanLocatorUtil.locate(at.meduni.liferay.portlet.rdconnect.service.ClpSerializer.getServletContextName(),
					SearchIndexPersistence.class.getName());

			ReferenceRegistry.registerReference(SearchIndexUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SearchIndexPersistence persistence) {
	}

	private static SearchIndexPersistence _persistence;
}