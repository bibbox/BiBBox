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

package at.meduni.liferay.portlet.bbmrieric.service.persistence;

import at.meduni.liferay.portlet.bbmrieric.model.SearchIndex;

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
 * @author reihsr
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
	* Returns all the search indexs where searchindexvalue = &#63;.
	*
	* @param searchindexvalue the searchindexvalue
	* @return the matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.SearchIndex> findByExactSearch(
		java.lang.String searchindexvalue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByExactSearch(searchindexvalue);
	}

	/**
	* Returns a range of all the search indexs where searchindexvalue = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param searchindexvalue the searchindexvalue
	* @param start the lower bound of the range of search indexs
	* @param end the upper bound of the range of search indexs (not inclusive)
	* @return the range of matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.SearchIndex> findByExactSearch(
		java.lang.String searchindexvalue, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByExactSearch(searchindexvalue, start, end);
	}

	/**
	* Returns an ordered range of all the search indexs where searchindexvalue = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param searchindexvalue the searchindexvalue
	* @param start the lower bound of the range of search indexs
	* @param end the upper bound of the range of search indexs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.SearchIndex> findByExactSearch(
		java.lang.String searchindexvalue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExactSearch(searchindexvalue, start, end,
			orderByComparator);
	}

	/**
	* Returns the first search index in the ordered set where searchindexvalue = &#63;.
	*
	* @param searchindexvalue the searchindexvalue
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search index
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex findByExactSearch_First(
		java.lang.String searchindexvalue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExactSearch_First(searchindexvalue, orderByComparator);
	}

	/**
	* Returns the first search index in the ordered set where searchindexvalue = &#63;.
	*
	* @param searchindexvalue the searchindexvalue
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search index, or <code>null</code> if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex fetchByExactSearch_First(
		java.lang.String searchindexvalue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByExactSearch_First(searchindexvalue, orderByComparator);
	}

	/**
	* Returns the last search index in the ordered set where searchindexvalue = &#63;.
	*
	* @param searchindexvalue the searchindexvalue
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search index
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex findByExactSearch_Last(
		java.lang.String searchindexvalue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExactSearch_Last(searchindexvalue, orderByComparator);
	}

	/**
	* Returns the last search index in the ordered set where searchindexvalue = &#63;.
	*
	* @param searchindexvalue the searchindexvalue
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search index, or <code>null</code> if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex fetchByExactSearch_Last(
		java.lang.String searchindexvalue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByExactSearch_Last(searchindexvalue, orderByComparator);
	}

	/**
	* Returns the search indexs before and after the current search index in the ordered set where searchindexvalue = &#63;.
	*
	* @param searchid the primary key of the current search index
	* @param searchindexvalue the searchindexvalue
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search index
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex[] findByExactSearch_PrevAndNext(
		long searchid, java.lang.String searchindexvalue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExactSearch_PrevAndNext(searchid, searchindexvalue,
			orderByComparator);
	}

	/**
	* Removes all the search indexs where searchindexvalue = &#63; from the database.
	*
	* @param searchindexvalue the searchindexvalue
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByExactSearch(java.lang.String searchindexvalue)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByExactSearch(searchindexvalue);
	}

	/**
	* Returns the number of search indexs where searchindexvalue = &#63;.
	*
	* @param searchindexvalue the searchindexvalue
	* @return the number of matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByExactSearch(java.lang.String searchindexvalue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByExactSearch(searchindexvalue);
	}

	/**
	* Returns all the search indexs where organisationid = &#63;.
	*
	* @param organisationid the organisationid
	* @return the matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.SearchIndex> findBySearchIndexByOrganization(
		long organisationid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySearchIndexByOrganization(organisationid);
	}

	/**
	* Returns a range of all the search indexs where organisationid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organisationid the organisationid
	* @param start the lower bound of the range of search indexs
	* @param end the upper bound of the range of search indexs (not inclusive)
	* @return the range of matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.SearchIndex> findBySearchIndexByOrganization(
		long organisationid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySearchIndexByOrganization(organisationid, start, end);
	}

	/**
	* Returns an ordered range of all the search indexs where organisationid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organisationid the organisationid
	* @param start the lower bound of the range of search indexs
	* @param end the upper bound of the range of search indexs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.SearchIndex> findBySearchIndexByOrganization(
		long organisationid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySearchIndexByOrganization(organisationid, start, end,
			orderByComparator);
	}

	/**
	* Returns the first search index in the ordered set where organisationid = &#63;.
	*
	* @param organisationid the organisationid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search index
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex findBySearchIndexByOrganization_First(
		long organisationid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySearchIndexByOrganization_First(organisationid,
			orderByComparator);
	}

	/**
	* Returns the first search index in the ordered set where organisationid = &#63;.
	*
	* @param organisationid the organisationid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search index, or <code>null</code> if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex fetchBySearchIndexByOrganization_First(
		long organisationid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySearchIndexByOrganization_First(organisationid,
			orderByComparator);
	}

	/**
	* Returns the last search index in the ordered set where organisationid = &#63;.
	*
	* @param organisationid the organisationid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search index
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex findBySearchIndexByOrganization_Last(
		long organisationid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySearchIndexByOrganization_Last(organisationid,
			orderByComparator);
	}

	/**
	* Returns the last search index in the ordered set where organisationid = &#63;.
	*
	* @param organisationid the organisationid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search index, or <code>null</code> if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex fetchBySearchIndexByOrganization_Last(
		long organisationid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySearchIndexByOrganization_Last(organisationid,
			orderByComparator);
	}

	/**
	* Returns the search indexs before and after the current search index in the ordered set where organisationid = &#63;.
	*
	* @param searchid the primary key of the current search index
	* @param organisationid the organisationid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search index
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex[] findBySearchIndexByOrganization_PrevAndNext(
		long searchid, long organisationid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySearchIndexByOrganization_PrevAndNext(searchid,
			organisationid, orderByComparator);
	}

	/**
	* Removes all the search indexs where organisationid = &#63; from the database.
	*
	* @param organisationid the organisationid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySearchIndexByOrganization(long organisationid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySearchIndexByOrganization(organisationid);
	}

	/**
	* Returns the number of search indexs where organisationid = &#63;.
	*
	* @param organisationid the organisationid
	* @return the number of matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySearchIndexByOrganization(long organisationid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySearchIndexByOrganization(organisationid);
	}

	/**
	* Returns the search index where organisationid = &#63; and searchindexkey = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException} if it could not be found.
	*
	* @param organisationid the organisationid
	* @param searchindexkey the searchindexkey
	* @return the matching search index
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex findBySearchIndex(
		long organisationid, java.lang.String searchindexkey)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySearchIndex(organisationid, searchindexkey);
	}

	/**
	* Returns the search index where organisationid = &#63; and searchindexkey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param organisationid the organisationid
	* @param searchindexkey the searchindexkey
	* @return the matching search index, or <code>null</code> if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex fetchBySearchIndex(
		long organisationid, java.lang.String searchindexkey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySearchIndex(organisationid, searchindexkey);
	}

	/**
	* Returns the search index where organisationid = &#63; and searchindexkey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param organisationid the organisationid
	* @param searchindexkey the searchindexkey
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching search index, or <code>null</code> if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex fetchBySearchIndex(
		long organisationid, java.lang.String searchindexkey,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySearchIndex(organisationid, searchindexkey,
			retrieveFromCache);
	}

	/**
	* Removes the search index where organisationid = &#63; and searchindexkey = &#63; from the database.
	*
	* @param organisationid the organisationid
	* @param searchindexkey the searchindexkey
	* @return the search index that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex removeBySearchIndex(
		long organisationid, java.lang.String searchindexkey)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeBySearchIndex(organisationid, searchindexkey);
	}

	/**
	* Returns the number of search indexs where organisationid = &#63; and searchindexkey = &#63;.
	*
	* @param organisationid the organisationid
	* @param searchindexkey the searchindexkey
	* @return the number of matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySearchIndex(long organisationid,
		java.lang.String searchindexkey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBySearchIndex(organisationid, searchindexkey);
	}

	/**
	* Returns all the search indexs where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @return the matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.SearchIndex> findByNotUUID(
		java.lang.String UUID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNotUUID(UUID);
	}

	/**
	* Returns a range of all the search indexs where UUID &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param UUID the u u i d
	* @param start the lower bound of the range of search indexs
	* @param end the upper bound of the range of search indexs (not inclusive)
	* @return the range of matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.SearchIndex> findByNotUUID(
		java.lang.String UUID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNotUUID(UUID, start, end);
	}

	/**
	* Returns an ordered range of all the search indexs where UUID &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param UUID the u u i d
	* @param start the lower bound of the range of search indexs
	* @param end the upper bound of the range of search indexs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.SearchIndex> findByNotUUID(
		java.lang.String UUID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNotUUID(UUID, start, end, orderByComparator);
	}

	/**
	* Returns the first search index in the ordered set where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search index
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex findByNotUUID_First(
		java.lang.String UUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNotUUID_First(UUID, orderByComparator);
	}

	/**
	* Returns the first search index in the ordered set where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching search index, or <code>null</code> if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex fetchByNotUUID_First(
		java.lang.String UUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNotUUID_First(UUID, orderByComparator);
	}

	/**
	* Returns the last search index in the ordered set where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search index
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex findByNotUUID_Last(
		java.lang.String UUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNotUUID_Last(UUID, orderByComparator);
	}

	/**
	* Returns the last search index in the ordered set where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching search index, or <code>null</code> if a matching search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex fetchByNotUUID_Last(
		java.lang.String UUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNotUUID_Last(UUID, orderByComparator);
	}

	/**
	* Returns the search indexs before and after the current search index in the ordered set where UUID &ne; &#63;.
	*
	* @param searchid the primary key of the current search index
	* @param UUID the u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next search index
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex[] findByNotUUID_PrevAndNext(
		long searchid, java.lang.String UUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNotUUID_PrevAndNext(searchid, UUID, orderByComparator);
	}

	/**
	* Removes all the search indexs where UUID &ne; &#63; from the database.
	*
	* @param UUID the u u i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNotUUID(java.lang.String UUID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNotUUID(UUID);
	}

	/**
	* Returns the number of search indexs where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @return the number of matching search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNotUUID(java.lang.String UUID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNotUUID(UUID);
	}

	/**
	* Caches the search index in the entity cache if it is enabled.
	*
	* @param searchIndex the search index
	*/
	public static void cacheResult(
		at.meduni.liferay.portlet.bbmrieric.model.SearchIndex searchIndex) {
		getPersistence().cacheResult(searchIndex);
	}

	/**
	* Caches the search indexs in the entity cache if it is enabled.
	*
	* @param searchIndexs the search indexs
	*/
	public static void cacheResult(
		java.util.List<at.meduni.liferay.portlet.bbmrieric.model.SearchIndex> searchIndexs) {
		getPersistence().cacheResult(searchIndexs);
	}

	/**
	* Creates a new search index with the primary key. Does not add the search index to the database.
	*
	* @param searchid the primary key for the new search index
	* @return the new search index
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex create(
		long searchid) {
		return getPersistence().create(searchid);
	}

	/**
	* Removes the search index with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param searchid the primary key of the search index
	* @return the search index that was removed
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex remove(
		long searchid)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(searchid);
	}

	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex updateImpl(
		at.meduni.liferay.portlet.bbmrieric.model.SearchIndex searchIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(searchIndex);
	}

	/**
	* Returns the search index with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException} if it could not be found.
	*
	* @param searchid the primary key of the search index
	* @return the search index
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException if a search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex findByPrimaryKey(
		long searchid)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchSearchIndexException,
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
	public static at.meduni.liferay.portlet.bbmrieric.model.SearchIndex fetchByPrimaryKey(
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
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.SearchIndex> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the search indexs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of search indexs
	* @param end the upper bound of the range of search indexs (not inclusive)
	* @return the range of search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.SearchIndex> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the search indexs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of search indexs
	* @param end the upper bound of the range of search indexs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.SearchIndex> findAll(
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
			_persistence = (SearchIndexPersistence)PortletBeanLocatorUtil.locate(at.meduni.liferay.portlet.bbmrieric.service.ClpSerializer.getServletContextName(),
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