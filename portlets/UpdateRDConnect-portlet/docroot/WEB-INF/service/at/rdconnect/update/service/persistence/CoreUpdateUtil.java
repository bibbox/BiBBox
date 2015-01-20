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

package at.rdconnect.update.service.persistence;

import at.rdconnect.update.model.CoreUpdate;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the core update service. This utility wraps {@link CoreUpdatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see CoreUpdatePersistence
 * @see CoreUpdatePersistenceImpl
 * @generated
 */
public class CoreUpdateUtil {
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
	public static void clearCache(CoreUpdate coreUpdate) {
		getPersistence().clearCache(coreUpdate);
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
	public static List<CoreUpdate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CoreUpdate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CoreUpdate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CoreUpdate update(CoreUpdate coreUpdate)
		throws SystemException {
		return getPersistence().update(coreUpdate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CoreUpdate update(CoreUpdate coreUpdate,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(coreUpdate, serviceContext);
	}

	/**
	* Returns all the core updates where organizationid = &#63;.
	*
	* @param organizationid the organizationid
	* @return the matching core updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.rdconnect.update.model.CoreUpdate> findByOrganizationId(
		long organizationid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganizationId(organizationid);
	}

	/**
	* Returns a range of all the core updates where organizationid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.CoreUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationid the organizationid
	* @param start the lower bound of the range of core updates
	* @param end the upper bound of the range of core updates (not inclusive)
	* @return the range of matching core updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.rdconnect.update.model.CoreUpdate> findByOrganizationId(
		long organizationid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganizationId(organizationid, start, end);
	}

	/**
	* Returns an ordered range of all the core updates where organizationid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.CoreUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationid the organizationid
	* @param start the lower bound of the range of core updates
	* @param end the upper bound of the range of core updates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching core updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.rdconnect.update.model.CoreUpdate> findByOrganizationId(
		long organizationid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId(organizationid, start, end,
			orderByComparator);
	}

	/**
	* Returns the first core update in the ordered set where organizationid = &#63;.
	*
	* @param organizationid the organizationid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching core update
	* @throws at.rdconnect.update.NoSuchCoreUpdateException if a matching core update could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.rdconnect.update.model.CoreUpdate findByOrganizationId_First(
		long organizationid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.rdconnect.update.NoSuchCoreUpdateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId_First(organizationid, orderByComparator);
	}

	/**
	* Returns the first core update in the ordered set where organizationid = &#63;.
	*
	* @param organizationid the organizationid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching core update, or <code>null</code> if a matching core update could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.rdconnect.update.model.CoreUpdate fetchByOrganizationId_First(
		long organizationid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationId_First(organizationid,
			orderByComparator);
	}

	/**
	* Returns the last core update in the ordered set where organizationid = &#63;.
	*
	* @param organizationid the organizationid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching core update
	* @throws at.rdconnect.update.NoSuchCoreUpdateException if a matching core update could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.rdconnect.update.model.CoreUpdate findByOrganizationId_Last(
		long organizationid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.rdconnect.update.NoSuchCoreUpdateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId_Last(organizationid, orderByComparator);
	}

	/**
	* Returns the last core update in the ordered set where organizationid = &#63;.
	*
	* @param organizationid the organizationid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching core update, or <code>null</code> if a matching core update could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.rdconnect.update.model.CoreUpdate fetchByOrganizationId_Last(
		long organizationid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationId_Last(organizationid, orderByComparator);
	}

	/**
	* Returns the core updates before and after the current core update in the ordered set where organizationid = &#63;.
	*
	* @param coreid the primary key of the current core update
	* @param organizationid the organizationid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next core update
	* @throws at.rdconnect.update.NoSuchCoreUpdateException if a core update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.rdconnect.update.model.CoreUpdate[] findByOrganizationId_PrevAndNext(
		long coreid, long organizationid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.rdconnect.update.NoSuchCoreUpdateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId_PrevAndNext(coreid, organizationid,
			orderByComparator);
	}

	/**
	* Removes all the core updates where organizationid = &#63; from the database.
	*
	* @param organizationid the organizationid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrganizationId(long organizationid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrganizationId(organizationid);
	}

	/**
	* Returns the number of core updates where organizationid = &#63;.
	*
	* @param organizationid the organizationid
	* @return the number of matching core updates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrganizationId(long organizationid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrganizationId(organizationid);
	}

	/**
	* Caches the core update in the entity cache if it is enabled.
	*
	* @param coreUpdate the core update
	*/
	public static void cacheResult(
		at.rdconnect.update.model.CoreUpdate coreUpdate) {
		getPersistence().cacheResult(coreUpdate);
	}

	/**
	* Caches the core updates in the entity cache if it is enabled.
	*
	* @param coreUpdates the core updates
	*/
	public static void cacheResult(
		java.util.List<at.rdconnect.update.model.CoreUpdate> coreUpdates) {
		getPersistence().cacheResult(coreUpdates);
	}

	/**
	* Creates a new core update with the primary key. Does not add the core update to the database.
	*
	* @param coreid the primary key for the new core update
	* @return the new core update
	*/
	public static at.rdconnect.update.model.CoreUpdate create(long coreid) {
		return getPersistence().create(coreid);
	}

	/**
	* Removes the core update with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param coreid the primary key of the core update
	* @return the core update that was removed
	* @throws at.rdconnect.update.NoSuchCoreUpdateException if a core update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.rdconnect.update.model.CoreUpdate remove(long coreid)
		throws at.rdconnect.update.NoSuchCoreUpdateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(coreid);
	}

	public static at.rdconnect.update.model.CoreUpdate updateImpl(
		at.rdconnect.update.model.CoreUpdate coreUpdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(coreUpdate);
	}

	/**
	* Returns the core update with the primary key or throws a {@link at.rdconnect.update.NoSuchCoreUpdateException} if it could not be found.
	*
	* @param coreid the primary key of the core update
	* @return the core update
	* @throws at.rdconnect.update.NoSuchCoreUpdateException if a core update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.rdconnect.update.model.CoreUpdate findByPrimaryKey(
		long coreid)
		throws at.rdconnect.update.NoSuchCoreUpdateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(coreid);
	}

	/**
	* Returns the core update with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param coreid the primary key of the core update
	* @return the core update, or <code>null</code> if a core update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.rdconnect.update.model.CoreUpdate fetchByPrimaryKey(
		long coreid) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(coreid);
	}

	/**
	* Returns all the core updates.
	*
	* @return the core updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.rdconnect.update.model.CoreUpdate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the core updates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.CoreUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of core updates
	* @param end the upper bound of the range of core updates (not inclusive)
	* @return the range of core updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.rdconnect.update.model.CoreUpdate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the core updates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.CoreUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of core updates
	* @param end the upper bound of the range of core updates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of core updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.rdconnect.update.model.CoreUpdate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the core updates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of core updates.
	*
	* @return the number of core updates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CoreUpdatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CoreUpdatePersistence)PortletBeanLocatorUtil.locate(at.rdconnect.update.service.ClpSerializer.getServletContextName(),
					CoreUpdatePersistence.class.getName());

			ReferenceRegistry.registerReference(CoreUpdateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CoreUpdatePersistence persistence) {
	}

	private static CoreUpdatePersistence _persistence;
}