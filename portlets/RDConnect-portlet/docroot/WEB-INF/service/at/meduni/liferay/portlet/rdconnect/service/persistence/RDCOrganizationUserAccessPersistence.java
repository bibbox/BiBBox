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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the r d c organization user access service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see RDCOrganizationUserAccessPersistenceImpl
 * @see RDCOrganizationUserAccessUtil
 * @generated
 */
public interface RDCOrganizationUserAccessPersistence extends BasePersistence<RDCOrganizationUserAccess> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RDCOrganizationUserAccessUtil} to access the r d c organization user access persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the r d c organization user accesses where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @return the matching r d c organization user accesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess> findByOrganizationId(
		long organisationId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess> findByOrganizationId(
		long organisationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess> findByOrganizationId(
		long organisationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first r d c organization user access in the ordered set where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d c organization user access
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException if a matching r d c organization user access could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess findByOrganizationId_First(
		long organisationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first r d c organization user access in the ordered set where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d c organization user access, or <code>null</code> if a matching r d c organization user access could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess fetchByOrganizationId_First(
		long organisationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last r d c organization user access in the ordered set where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d c organization user access
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException if a matching r d c organization user access could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess findByOrganizationId_Last(
		long organisationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last r d c organization user access in the ordered set where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d c organization user access, or <code>null</code> if a matching r d c organization user access could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess fetchByOrganizationId_Last(
		long organisationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess[] findByOrganizationId_PrevAndNext(
		long rdcorganizationuseraccessId, long organisationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the r d c organization user accesses where organisationId = &#63; from the database.
	*
	* @param organisationId the organisation ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrganizationId(long organisationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of r d c organization user accesses where organisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @return the number of matching r d c organization user accesses
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrganizationId(long organisationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the r d c organization user access in the entity cache if it is enabled.
	*
	* @param rdcOrganizationUserAccess the r d c organization user access
	*/
	public void cacheResult(
		at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess rdcOrganizationUserAccess);

	/**
	* Caches the r d c organization user accesses in the entity cache if it is enabled.
	*
	* @param rdcOrganizationUserAccesses the r d c organization user accesses
	*/
	public void cacheResult(
		java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess> rdcOrganizationUserAccesses);

	/**
	* Creates a new r d c organization user access with the primary key. Does not add the r d c organization user access to the database.
	*
	* @param rdcorganizationuseraccessId the primary key for the new r d c organization user access
	* @return the new r d c organization user access
	*/
	public at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess create(
		long rdcorganizationuseraccessId);

	/**
	* Removes the r d c organization user access with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rdcorganizationuseraccessId the primary key of the r d c organization user access
	* @return the r d c organization user access that was removed
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException if a r d c organization user access with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess remove(
		long rdcorganizationuseraccessId)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess updateImpl(
		at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess rdcOrganizationUserAccess)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the r d c organization user access with the primary key or throws a {@link at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException} if it could not be found.
	*
	* @param rdcorganizationuseraccessId the primary key of the r d c organization user access
	* @return the r d c organization user access
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException if a r d c organization user access with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess findByPrimaryKey(
		long rdcorganizationuseraccessId)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCOrganizationUserAccessException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the r d c organization user access with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rdcorganizationuseraccessId the primary key of the r d c organization user access
	* @return the r d c organization user access, or <code>null</code> if a r d c organization user access with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess fetchByPrimaryKey(
		long rdcorganizationuseraccessId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the r d c organization user accesses.
	*
	* @return the r d c organization user accesses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the r d c organization user accesses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of r d c organization user accesses.
	*
	* @return the number of r d c organization user accesses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}