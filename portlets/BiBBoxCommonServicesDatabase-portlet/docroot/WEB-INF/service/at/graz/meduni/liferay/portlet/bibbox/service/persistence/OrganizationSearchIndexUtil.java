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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the organization search index service. This utility wraps {@link OrganizationSearchIndexPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see OrganizationSearchIndexPersistence
 * @see OrganizationSearchIndexPersistenceImpl
 * @generated
 */
public class OrganizationSearchIndexUtil {
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
	public static void clearCache(
		OrganizationSearchIndex organizationSearchIndex) {
		getPersistence().clearCache(organizationSearchIndex);
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
	public static List<OrganizationSearchIndex> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrganizationSearchIndex> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrganizationSearchIndex> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static OrganizationSearchIndex update(
		OrganizationSearchIndex organizationSearchIndex)
		throws SystemException {
		return getPersistence().update(organizationSearchIndex);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static OrganizationSearchIndex update(
		OrganizationSearchIndex organizationSearchIndex,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(organizationSearchIndex, serviceContext);
	}

	/**
	* Returns all the organization search indexs where value = &#63;.
	*
	* @param value the value
	* @return the matching organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex> findByExactSearch(
		java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByExactSearch(value);
	}

	/**
	* Returns a range of all the organization search indexs where value = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrganizationSearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param value the value
	* @param start the lower bound of the range of organization search indexs
	* @param end the upper bound of the range of organization search indexs (not inclusive)
	* @return the range of matching organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex> findByExactSearch(
		java.lang.String value, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByExactSearch(value, start, end);
	}

	/**
	* Returns an ordered range of all the organization search indexs where value = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrganizationSearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param value the value
	* @param start the lower bound of the range of organization search indexs
	* @param end the upper bound of the range of organization search indexs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex> findByExactSearch(
		java.lang.String value, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExactSearch(value, start, end, orderByComparator);
	}

	/**
	* Returns the first organization search index in the ordered set where value = &#63;.
	*
	* @param value the value
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organization search index
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a matching organization search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex findByExactSearch_First(
		java.lang.String value,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByExactSearch_First(value, orderByComparator);
	}

	/**
	* Returns the first organization search index in the ordered set where value = &#63;.
	*
	* @param value the value
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching organization search index, or <code>null</code> if a matching organization search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex fetchByExactSearch_First(
		java.lang.String value,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByExactSearch_First(value, orderByComparator);
	}

	/**
	* Returns the last organization search index in the ordered set where value = &#63;.
	*
	* @param value the value
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organization search index
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a matching organization search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex findByExactSearch_Last(
		java.lang.String value,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByExactSearch_Last(value, orderByComparator);
	}

	/**
	* Returns the last organization search index in the ordered set where value = &#63;.
	*
	* @param value the value
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching organization search index, or <code>null</code> if a matching organization search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex fetchByExactSearch_Last(
		java.lang.String value,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByExactSearch_Last(value, orderByComparator);
	}

	/**
	* Returns the organization search indexs before and after the current organization search index in the ordered set where value = &#63;.
	*
	* @param searchid the primary key of the current organization search index
	* @param value the value
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next organization search index
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a organization search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex[] findByExactSearch_PrevAndNext(
		long searchid, java.lang.String value,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByExactSearch_PrevAndNext(searchid, value,
			orderByComparator);
	}

	/**
	* Removes all the organization search indexs where value = &#63; from the database.
	*
	* @param value the value
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByExactSearch(java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByExactSearch(value);
	}

	/**
	* Returns the number of organization search indexs where value = &#63;.
	*
	* @param value the value
	* @return the number of matching organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByExactSearch(java.lang.String value)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByExactSearch(value);
	}

	/**
	* Returns the organization search index where organisationid = &#63; and key = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException} if it could not be found.
	*
	* @param organisationid the organisationid
	* @param key the key
	* @return the matching organization search index
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a matching organization search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex findByKeyAndOrganization(
		long organisationid, java.lang.String key)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByKeyAndOrganization(organisationid, key);
	}

	/**
	* Returns the organization search index where organisationid = &#63; and key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param organisationid the organisationid
	* @param key the key
	* @return the matching organization search index, or <code>null</code> if a matching organization search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex fetchByKeyAndOrganization(
		long organisationid, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByKeyAndOrganization(organisationid, key);
	}

	/**
	* Returns the organization search index where organisationid = &#63; and key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param organisationid the organisationid
	* @param key the key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching organization search index, or <code>null</code> if a matching organization search index could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex fetchByKeyAndOrganization(
		long organisationid, java.lang.String key, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByKeyAndOrganization(organisationid, key,
			retrieveFromCache);
	}

	/**
	* Removes the organization search index where organisationid = &#63; and key = &#63; from the database.
	*
	* @param organisationid the organisationid
	* @param key the key
	* @return the organization search index that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex removeByKeyAndOrganization(
		long organisationid, java.lang.String key)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByKeyAndOrganization(organisationid, key);
	}

	/**
	* Returns the number of organization search indexs where organisationid = &#63; and key = &#63;.
	*
	* @param organisationid the organisationid
	* @param key the key
	* @return the number of matching organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByKeyAndOrganization(long organisationid,
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByKeyAndOrganization(organisationid, key);
	}

	/**
	* Caches the organization search index in the entity cache if it is enabled.
	*
	* @param organizationSearchIndex the organization search index
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex organizationSearchIndex) {
		getPersistence().cacheResult(organizationSearchIndex);
	}

	/**
	* Caches the organization search indexs in the entity cache if it is enabled.
	*
	* @param organizationSearchIndexs the organization search indexs
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex> organizationSearchIndexs) {
		getPersistence().cacheResult(organizationSearchIndexs);
	}

	/**
	* Creates a new organization search index with the primary key. Does not add the organization search index to the database.
	*
	* @param searchid the primary key for the new organization search index
	* @return the new organization search index
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex create(
		long searchid) {
		return getPersistence().create(searchid);
	}

	/**
	* Removes the organization search index with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param searchid the primary key of the organization search index
	* @return the organization search index that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a organization search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex remove(
		long searchid)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(searchid);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex organizationSearchIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(organizationSearchIndex);
	}

	/**
	* Returns the organization search index with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException} if it could not be found.
	*
	* @param searchid the primary key of the organization search index
	* @return the organization search index
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException if a organization search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex findByPrimaryKey(
		long searchid)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrganizationSearchIndexException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(searchid);
	}

	/**
	* Returns the organization search index with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param searchid the primary key of the organization search index
	* @return the organization search index, or <code>null</code> if a organization search index with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex fetchByPrimaryKey(
		long searchid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(searchid);
	}

	/**
	* Returns all the organization search indexs.
	*
	* @return the organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the organization search indexs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of organization search indexs.
	*
	* @return the number of organization search indexs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OrganizationSearchIndexPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OrganizationSearchIndexPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.service.ClpSerializer.getServletContextName(),
					OrganizationSearchIndexPersistence.class.getName());

			ReferenceRegistry.registerReference(OrganizationSearchIndexUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(OrganizationSearchIndexPersistence persistence) {
	}

	private static OrganizationSearchIndexPersistence _persistence;
}