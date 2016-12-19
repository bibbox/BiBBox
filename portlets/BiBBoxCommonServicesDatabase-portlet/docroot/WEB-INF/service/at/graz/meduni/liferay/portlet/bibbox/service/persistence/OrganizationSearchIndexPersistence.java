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

package at.graz.meduni.liferay.portlet.bibbox.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the organization search index service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see OrganizationSearchIndexPersistenceImpl
 * @see OrganizationSearchIndexUtil
 * @generated
 */
public interface OrganizationSearchIndexPersistence extends BasePersistence<OrganizationSearchIndex> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrganizationSearchIndexUtil} to access the organization search index persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the organization search indexs where searchvalue = &#63;.
	*
	* @param searchvalue the searchvalue
	* @return the matching organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex> findByExactSearch(
		java.lang.String searchvalue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the organization search indexs where searchvalue = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrganizationSearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param searchvalue the searchvalue
	* @param start the lower bound of the range of organization search indexs
	* @param end the upper bound of the range of organization search indexs (not inclusive)
	* @return the range of matching organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex> findByExactSearch(
		java.lang.String searchvalue, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the organization search indexs where searchvalue = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrganizationSearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param searchvalue the searchvalue
	* @param start the lower bound of the range of organization search indexs
	* @param end the upper bound of the range of organization search indexs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex> findByExactSearch(
		java.lang.String searchvalue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first organization search index in the ordered set where searchvalue = &#63;.
	*
	* @param searchvalue the searchvalue
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organization search index
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a matching organization search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex findByExactSearch_First(
		java.lang.String searchvalue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first organization search index in the ordered set where searchvalue = &#63;.
	*
	* @param searchvalue the searchvalue
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organization search index, or <code>null</code> if a matching organization search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex fetchByExactSearch_First(
		java.lang.String searchvalue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last organization search index in the ordered set where searchvalue = &#63;.
	*
	* @param searchvalue the searchvalue
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organization search index
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a matching organization search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex findByExactSearch_Last(
		java.lang.String searchvalue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last organization search index in the ordered set where searchvalue = &#63;.
	*
	* @param searchvalue the searchvalue
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organization search index, or <code>null</code> if a matching organization search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex fetchByExactSearch_Last(
		java.lang.String searchvalue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organization search indexs before and after the current organization search index in the ordered set where searchvalue = &#63;.
	*
	* @param searchid the primary key of the current organization search index
	* @param searchvalue the searchvalue
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next organization search index
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a organization search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex[] findByExactSearch_PrevAndNext(
		long searchid, java.lang.String searchvalue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the organization search indexs where searchvalue = &#63; from the database.
	*
	* @param searchvalue the searchvalue
	* @throws SystemException if a system exception occurred
	*/
	public void removeByExactSearch(java.lang.String searchvalue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of organization search indexs where searchvalue = &#63;.
	*
	* @param searchvalue the searchvalue
	* @return the number of matching organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	public int countByExactSearch(java.lang.String searchvalue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organization search index where organisationid = &#63; and key = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException} if it could not be found.
	*
	* @param organisationid the organisationid
	* @param key the key
	* @return the matching organization search index
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a matching organization search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex findByKeyAndOrganization(
		long organisationid, java.lang.String key)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organization search index where organisationid = &#63; and key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param organisationid the organisationid
	* @param key the key
	* @return the matching organization search index, or <code>null</code> if a matching organization search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex fetchByKeyAndOrganization(
		long organisationid, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organization search index where organisationid = &#63; and key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param organisationid the organisationid
	* @param key the key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching organization search index, or <code>null</code> if a matching organization search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex fetchByKeyAndOrganization(
		long organisationid, java.lang.String key, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the organization search index where organisationid = &#63; and key = &#63; from the database.
	*
	* @param organisationid the organisationid
	* @param key the key
	* @return the organization search index that was removed
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex removeByKeyAndOrganization(
		long organisationid, java.lang.String key)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of organization search indexs where organisationid = &#63; and key = &#63;.
	*
	* @param organisationid the organisationid
	* @param key the key
	* @return the number of matching organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	public int countByKeyAndOrganization(long organisationid,
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the organization search index in the entity cache if it is enabled.
	*
	* @param organizationSearchIndex the organization search index
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex organizationSearchIndex);

	/**
	* Caches the organization search indexs in the entity cache if it is enabled.
	*
	* @param organizationSearchIndexs the organization search indexs
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex> organizationSearchIndexs);

	/**
	* Creates a new organization search index with the primary key. Does not add the organization search index to the database.
	*
	* @param searchid the primary key for the new organization search index
	* @return the new organization search index
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex create(
		long searchid);

	/**
	* Removes the organization search index with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param searchid the primary key of the organization search index
	* @return the organization search index that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a organization search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex remove(
		long searchid)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex organizationSearchIndex)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organization search index with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException} if it could not be found.
	*
	* @param searchid the primary key of the organization search index
	* @return the organization search index
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a organization search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex findByPrimaryKey(
		long searchid)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the organization search index with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param searchid the primary key of the organization search index
	* @return the organization search index, or <code>null</code> if a organization search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex fetchByPrimaryKey(
		long searchid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the organization search indexs.
	*
	* @return the organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the organization search indexs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrganizationSearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of organization search indexs
	* @param end the upper bound of the range of organization search indexs (not inclusive)
	* @return the range of organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the organization search indexs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrganizationSearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of organization search indexs
	* @param end the upper bound of the range of organization search indexs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the organization search indexs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of organization search indexs.
	*
	* @return the number of organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}