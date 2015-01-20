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

import at.rdconnect.update.model.QualityUpdate;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the quality update service. This utility wraps {@link QualityUpdatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see QualityUpdatePersistence
 * @see QualityUpdatePersistenceImpl
 * @generated
 */
public class QualityUpdateUtil {
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
	public static void clearCache(QualityUpdate qualityUpdate) {
		getPersistence().clearCache(qualityUpdate);
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
	public static List<QualityUpdate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QualityUpdate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QualityUpdate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static QualityUpdate update(QualityUpdate qualityUpdate)
		throws SystemException {
		return getPersistence().update(qualityUpdate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static QualityUpdate update(QualityUpdate qualityUpdate,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(qualityUpdate, serviceContext);
	}

	/**
	* Returns all the quality updates where organizationid = &#63;.
	*
	* @param organizationid the organizationid
	* @return the matching quality updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.rdconnect.update.model.QualityUpdate> findByOrganizationId(
		long organizationid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganizationId(organizationid);
	}

	/**
	* Returns a range of all the quality updates where organizationid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.QualityUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationid the organizationid
	* @param start the lower bound of the range of quality updates
	* @param end the upper bound of the range of quality updates (not inclusive)
	* @return the range of matching quality updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.rdconnect.update.model.QualityUpdate> findByOrganizationId(
		long organizationid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganizationId(organizationid, start, end);
	}

	/**
	* Returns an ordered range of all the quality updates where organizationid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.QualityUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationid the organizationid
	* @param start the lower bound of the range of quality updates
	* @param end the upper bound of the range of quality updates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching quality updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.rdconnect.update.model.QualityUpdate> findByOrganizationId(
		long organizationid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId(organizationid, start, end,
			orderByComparator);
	}

	/**
	* Returns the first quality update in the ordered set where organizationid = &#63;.
	*
	* @param organizationid the organizationid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching quality update
	* @throws at.rdconnect.update.NoSuchQualityUpdateException if a matching quality update could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.rdconnect.update.model.QualityUpdate findByOrganizationId_First(
		long organizationid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.rdconnect.update.NoSuchQualityUpdateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId_First(organizationid, orderByComparator);
	}

	/**
	* Returns the first quality update in the ordered set where organizationid = &#63;.
	*
	* @param organizationid the organizationid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching quality update, or <code>null</code> if a matching quality update could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.rdconnect.update.model.QualityUpdate fetchByOrganizationId_First(
		long organizationid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationId_First(organizationid,
			orderByComparator);
	}

	/**
	* Returns the last quality update in the ordered set where organizationid = &#63;.
	*
	* @param organizationid the organizationid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching quality update
	* @throws at.rdconnect.update.NoSuchQualityUpdateException if a matching quality update could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.rdconnect.update.model.QualityUpdate findByOrganizationId_Last(
		long organizationid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.rdconnect.update.NoSuchQualityUpdateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId_Last(organizationid, orderByComparator);
	}

	/**
	* Returns the last quality update in the ordered set where organizationid = &#63;.
	*
	* @param organizationid the organizationid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching quality update, or <code>null</code> if a matching quality update could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.rdconnect.update.model.QualityUpdate fetchByOrganizationId_Last(
		long organizationid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationId_Last(organizationid, orderByComparator);
	}

	/**
	* Returns the quality updates before and after the current quality update in the ordered set where organizationid = &#63;.
	*
	* @param coreid the primary key of the current quality update
	* @param organizationid the organizationid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next quality update
	* @throws at.rdconnect.update.NoSuchQualityUpdateException if a quality update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.rdconnect.update.model.QualityUpdate[] findByOrganizationId_PrevAndNext(
		long coreid, long organizationid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.rdconnect.update.NoSuchQualityUpdateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId_PrevAndNext(coreid, organizationid,
			orderByComparator);
	}

	/**
	* Removes all the quality updates where organizationid = &#63; from the database.
	*
	* @param organizationid the organizationid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrganizationId(long organizationid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrganizationId(organizationid);
	}

	/**
	* Returns the number of quality updates where organizationid = &#63;.
	*
	* @param organizationid the organizationid
	* @return the number of matching quality updates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrganizationId(long organizationid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrganizationId(organizationid);
	}

	/**
	* Caches the quality update in the entity cache if it is enabled.
	*
	* @param qualityUpdate the quality update
	*/
	public static void cacheResult(
		at.rdconnect.update.model.QualityUpdate qualityUpdate) {
		getPersistence().cacheResult(qualityUpdate);
	}

	/**
	* Caches the quality updates in the entity cache if it is enabled.
	*
	* @param qualityUpdates the quality updates
	*/
	public static void cacheResult(
		java.util.List<at.rdconnect.update.model.QualityUpdate> qualityUpdates) {
		getPersistence().cacheResult(qualityUpdates);
	}

	/**
	* Creates a new quality update with the primary key. Does not add the quality update to the database.
	*
	* @param coreid the primary key for the new quality update
	* @return the new quality update
	*/
	public static at.rdconnect.update.model.QualityUpdate create(long coreid) {
		return getPersistence().create(coreid);
	}

	/**
	* Removes the quality update with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param coreid the primary key of the quality update
	* @return the quality update that was removed
	* @throws at.rdconnect.update.NoSuchQualityUpdateException if a quality update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.rdconnect.update.model.QualityUpdate remove(long coreid)
		throws at.rdconnect.update.NoSuchQualityUpdateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(coreid);
	}

	public static at.rdconnect.update.model.QualityUpdate updateImpl(
		at.rdconnect.update.model.QualityUpdate qualityUpdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(qualityUpdate);
	}

	/**
	* Returns the quality update with the primary key or throws a {@link at.rdconnect.update.NoSuchQualityUpdateException} if it could not be found.
	*
	* @param coreid the primary key of the quality update
	* @return the quality update
	* @throws at.rdconnect.update.NoSuchQualityUpdateException if a quality update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.rdconnect.update.model.QualityUpdate findByPrimaryKey(
		long coreid)
		throws at.rdconnect.update.NoSuchQualityUpdateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(coreid);
	}

	/**
	* Returns the quality update with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param coreid the primary key of the quality update
	* @return the quality update, or <code>null</code> if a quality update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.rdconnect.update.model.QualityUpdate fetchByPrimaryKey(
		long coreid) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(coreid);
	}

	/**
	* Returns all the quality updates.
	*
	* @return the quality updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.rdconnect.update.model.QualityUpdate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the quality updates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.QualityUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of quality updates
	* @param end the upper bound of the range of quality updates (not inclusive)
	* @return the range of quality updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.rdconnect.update.model.QualityUpdate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the quality updates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.rdconnect.update.model.impl.QualityUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of quality updates
	* @param end the upper bound of the range of quality updates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of quality updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.rdconnect.update.model.QualityUpdate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the quality updates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of quality updates.
	*
	* @return the number of quality updates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static QualityUpdatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (QualityUpdatePersistence)PortletBeanLocatorUtil.locate(at.rdconnect.update.service.ClpSerializer.getServletContextName(),
					QualityUpdatePersistence.class.getName());

			ReferenceRegistry.registerReference(QualityUpdateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(QualityUpdatePersistence persistence) {
	}

	private static QualityUpdatePersistence _persistence;
}