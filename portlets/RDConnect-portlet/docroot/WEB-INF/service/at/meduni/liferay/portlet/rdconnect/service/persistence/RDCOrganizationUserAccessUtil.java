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

import at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the r d c organization user access service. This utility wraps {@link RDCOrganizationUserAccessPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see RDCOrganizationUserAccessPersistence
 * @see RDCOrganizationUserAccessPersistenceImpl
 * @generated
 */
public class RDCOrganizationUserAccessUtil {
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
		RDCOrganizationUserAccess rdcOrganizationUserAccess) {
		getPersistence().clearCache(rdcOrganizationUserAccess);
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
	public static List<RDCOrganizationUserAccess> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RDCOrganizationUserAccess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RDCOrganizationUserAccess> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static RDCOrganizationUserAccess update(
		RDCOrganizationUserAccess rdcOrganizationUserAccess)
		throws SystemException {
		return getPersistence().update(rdcOrganizationUserAccess);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static RDCOrganizationUserAccess update(
		RDCOrganizationUserAccess rdcOrganizationUserAccess,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(rdcOrganizationUserAccess, serviceContext);
	}

	/**
	* Returns all the r d c organization user accesses where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @return the matching r d c organization user accesses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess> findByOrganizationId(
		long organisationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganizationId(organisationId);
	}

	/**
	* Returns a range of all the r d c organization user accesses where organisationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.RDCOrganizationUserAccessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organisationId the organisation ID
	* @param start the lower bound of the range of r d c organization user accesses
	* @param end the upper bound of the range of r d c organization user accesses (not inclusive)
	* @return the range of matching r d c organization user accesses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess> findByOrganizationId(
		long organisationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrganizationId(organisationId, start, end);
	}

	/**
	* Returns an ordered range of all the r d c organization user accesses where organisationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.RDCOrganizationUserAccessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organisationId the organisation ID
	* @param start the lower bound of the range of r d c organization user accesses
	* @param end the upper bound of the range of r d c organization user accesses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching r d c organization user accesses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess> findByOrganizationId(
		long organisationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId(organisationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first r d c organization user access in the ordered set where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d c organization user access
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException if a matching r d c organization user access could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess findByOrganizationId_First(
		long organisationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId_First(organisationId, orderByComparator);
	}

	/**
	* Returns the first r d c organization user access in the ordered set where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d c organization user access, or <code>null</code> if a matching r d c organization user access could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess fetchByOrganizationId_First(
		long organisationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationId_First(organisationId,
			orderByComparator);
	}

	/**
	* Returns the last r d c organization user access in the ordered set where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d c organization user access
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException if a matching r d c organization user access could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess findByOrganizationId_Last(
		long organisationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId_Last(organisationId, orderByComparator);
	}

	/**
	* Returns the last r d c organization user access in the ordered set where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d c organization user access, or <code>null</code> if a matching r d c organization user access could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess fetchByOrganizationId_Last(
		long organisationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrganizationId_Last(organisationId, orderByComparator);
	}

	/**
	* Returns the r d c organization user accesses before and after the current r d c organization user access in the ordered set where organisationId = &#63;.
	*
	* @param rdcorganizationuseraccessId the primary key of the current r d c organization user access
	* @param organisationId the organisation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next r d c organization user access
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException if a r d c organization user access with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess[] findByOrganizationId_PrevAndNext(
		long rdcorganizationuseraccessId, long organisationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrganizationId_PrevAndNext(rdcorganizationuseraccessId,
			organisationId, orderByComparator);
	}

	/**
	* Removes all the r d c organization user accesses where organisationId = &#63; from the database.
	*
	* @param organisationId the organisation ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrganizationId(long organisationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrganizationId(organisationId);
	}

	/**
	* Returns the number of r d c organization user accesses where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @return the number of matching r d c organization user accesses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrganizationId(long organisationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrganizationId(organisationId);
	}

	/**
	* Caches the r d c organization user access in the entity cache if it is enabled.
	*
	* @param rdcOrganizationUserAccess the r d c organization user access
	*/
	public static void cacheResult(
		at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess rdcOrganizationUserAccess) {
		getPersistence().cacheResult(rdcOrganizationUserAccess);
	}

	/**
	* Caches the r d c organization user accesses in the entity cache if it is enabled.
	*
	* @param rdcOrganizationUserAccesses the r d c organization user accesses
	*/
	public static void cacheResult(
		java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess> rdcOrganizationUserAccesses) {
		getPersistence().cacheResult(rdcOrganizationUserAccesses);
	}

	/**
	* Creates a new r d c organization user access with the primary key. Does not add the r d c organization user access to the database.
	*
	* @param rdcorganizationuseraccessId the primary key for the new r d c organization user access
	* @return the new r d c organization user access
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess create(
		long rdcorganizationuseraccessId) {
		return getPersistence().create(rdcorganizationuseraccessId);
	}

	/**
	* Removes the r d c organization user access with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rdcorganizationuseraccessId the primary key of the r d c organization user access
	* @return the r d c organization user access that was removed
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException if a r d c organization user access with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess remove(
		long rdcorganizationuseraccessId)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(rdcorganizationuseraccessId);
	}

	public static at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess updateImpl(
		at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess rdcOrganizationUserAccess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(rdcOrganizationUserAccess);
	}

	/**
	* Returns the r d c organization user access with the primary key or throws a {@link at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException} if it could not be found.
	*
	* @param rdcorganizationuseraccessId the primary key of the r d c organization user access
	* @return the r d c organization user access
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException if a r d c organization user access with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess findByPrimaryKey(
		long rdcorganizationuseraccessId)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(rdcorganizationuseraccessId);
	}

	/**
	* Returns the r d c organization user access with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rdcorganizationuseraccessId the primary key of the r d c organization user access
	* @return the r d c organization user access, or <code>null</code> if a r d c organization user access with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess fetchByPrimaryKey(
		long rdcorganizationuseraccessId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(rdcorganizationuseraccessId);
	}

	/**
	* Returns all the r d c organization user accesses.
	*
	* @return the r d c organization user accesses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the r d c organization user accesses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.RDCOrganizationUserAccessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of r d c organization user accesses
	* @param end the upper bound of the range of r d c organization user accesses (not inclusive)
	* @return the range of r d c organization user accesses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the r d c organization user accesses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.RDCOrganizationUserAccessModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of r d c organization user accesses
	* @param end the upper bound of the range of r d c organization user accesses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of r d c organization user accesses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the r d c organization user accesses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of r d c organization user accesses.
	*
	* @return the number of r d c organization user accesses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RDCOrganizationUserAccessPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RDCOrganizationUserAccessPersistence)PortletBeanLocatorUtil.locate(at.meduni.liferay.portlet.rdconnect.service.ClpSerializer.getServletContextName(),
					RDCOrganizationUserAccessPersistence.class.getName());

			ReferenceRegistry.registerReference(RDCOrganizationUserAccessUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RDCOrganizationUserAccessPersistence persistence) {
	}

	private static RDCOrganizationUserAccessPersistence _persistence;
}