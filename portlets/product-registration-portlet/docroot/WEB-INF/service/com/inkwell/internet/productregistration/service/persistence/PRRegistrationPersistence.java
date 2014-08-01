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

package com.inkwell.internet.productregistration.service.persistence;

import com.inkwell.internet.productregistration.model.PRRegistration;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the p r registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see PRRegistrationPersistenceImpl
 * @see PRRegistrationUtil
 * @generated
 */
public interface PRRegistrationPersistence extends BasePersistence<PRRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PRRegistrationUtil} to access the p r registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the p r registrations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r registrations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @return the range of matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r registrations where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r registration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r registration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r registration, or <code>null</code> if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r registration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r registration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r registration, or <code>null</code> if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r registrations before and after the current p r registration in the ordered set where groupId = &#63;.
	*
	* @param registrationId the primary key of the current p r registration
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration[] findByGroupId_PrevAndNext(
		long registrationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r registrations that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r registrations that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @return the range of matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r registrations that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r registrations before and after the current p r registration in the ordered set of p r registrations that the user has permission to view where groupId = &#63;.
	*
	* @param registrationId the primary key of the current p r registration
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration[] filterFindByGroupId_PrevAndNext(
		long registrationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p r registrations where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r registrations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r registrations that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r registrations where groupId = &#63; and prUserId = &#63;.
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @return the matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_RU(
		long groupId, long prUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r registrations where groupId = &#63; and prUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @return the range of matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_RU(
		long groupId, long prUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r registrations where groupId = &#63; and prUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_RU(
		long groupId, long prUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r registration in the ordered set where groupId = &#63; and prUserId = &#63;.
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration findByG_RU_First(
		long groupId, long prUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r registration in the ordered set where groupId = &#63; and prUserId = &#63;.
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r registration, or <code>null</code> if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration fetchByG_RU_First(
		long groupId, long prUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r registration in the ordered set where groupId = &#63; and prUserId = &#63;.
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration findByG_RU_Last(
		long groupId, long prUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r registration in the ordered set where groupId = &#63; and prUserId = &#63;.
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r registration, or <code>null</code> if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration fetchByG_RU_Last(
		long groupId, long prUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r registrations before and after the current p r registration in the ordered set where groupId = &#63; and prUserId = &#63;.
	*
	* @param registrationId the primary key of the current p r registration
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration[] findByG_RU_PrevAndNext(
		long registrationId, long groupId, long prUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r registrations that the user has permission to view where groupId = &#63; and prUserId = &#63;.
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @return the matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_RU(
		long groupId, long prUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r registrations that the user has permission to view where groupId = &#63; and prUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @return the range of matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_RU(
		long groupId, long prUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r registrations that the user has permissions to view where groupId = &#63; and prUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_RU(
		long groupId, long prUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r registrations before and after the current p r registration in the ordered set of p r registrations that the user has permission to view where groupId = &#63; and prUserId = &#63;.
	*
	* @param registrationId the primary key of the current p r registration
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration[] filterFindByG_RU_PrevAndNext(
		long registrationId, long groupId, long prUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p r registrations where groupId = &#63; and prUserId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_RU(long groupId, long prUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r registrations where groupId = &#63; and prUserId = &#63;.
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @return the number of matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_RU(long groupId, long prUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r registrations that the user has permission to view where groupId = &#63; and prUserId = &#63;.
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @return the number of matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_RU(long groupId, long prUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r registrations where groupId = &#63; and datePurchased = &#63;.
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @return the matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_DP(
		long groupId, java.util.Date datePurchased)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r registrations where groupId = &#63; and datePurchased = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @return the range of matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_DP(
		long groupId, java.util.Date datePurchased, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r registrations where groupId = &#63; and datePurchased = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_DP(
		long groupId, java.util.Date datePurchased, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r registration in the ordered set where groupId = &#63; and datePurchased = &#63;.
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration findByG_DP_First(
		long groupId, java.util.Date datePurchased,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r registration in the ordered set where groupId = &#63; and datePurchased = &#63;.
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r registration, or <code>null</code> if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration fetchByG_DP_First(
		long groupId, java.util.Date datePurchased,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r registration in the ordered set where groupId = &#63; and datePurchased = &#63;.
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration findByG_DP_Last(
		long groupId, java.util.Date datePurchased,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r registration in the ordered set where groupId = &#63; and datePurchased = &#63;.
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r registration, or <code>null</code> if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration fetchByG_DP_Last(
		long groupId, java.util.Date datePurchased,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r registrations before and after the current p r registration in the ordered set where groupId = &#63; and datePurchased = &#63;.
	*
	* @param registrationId the primary key of the current p r registration
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration[] findByG_DP_PrevAndNext(
		long registrationId, long groupId, java.util.Date datePurchased,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r registrations that the user has permission to view where groupId = &#63; and datePurchased = &#63;.
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @return the matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_DP(
		long groupId, java.util.Date datePurchased)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r registrations that the user has permission to view where groupId = &#63; and datePurchased = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @return the range of matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_DP(
		long groupId, java.util.Date datePurchased, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r registrations that the user has permissions to view where groupId = &#63; and datePurchased = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_DP(
		long groupId, java.util.Date datePurchased, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r registrations before and after the current p r registration in the ordered set of p r registrations that the user has permission to view where groupId = &#63; and datePurchased = &#63;.
	*
	* @param registrationId the primary key of the current p r registration
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration[] filterFindByG_DP_PrevAndNext(
		long registrationId, long groupId, java.util.Date datePurchased,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p r registrations where groupId = &#63; and datePurchased = &#63; from the database.
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_DP(long groupId, java.util.Date datePurchased)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r registrations where groupId = &#63; and datePurchased = &#63;.
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @return the number of matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_DP(long groupId, java.util.Date datePurchased)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r registrations that the user has permission to view where groupId = &#63; and datePurchased = &#63;.
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @return the number of matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_DP(long groupId, java.util.Date datePurchased)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r registrations where groupId = &#63; and serialNumber = &#63;.
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @return the matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_SN(
		long groupId, java.lang.String serialNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r registrations where groupId = &#63; and serialNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @return the range of matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_SN(
		long groupId, java.lang.String serialNumber, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r registrations where groupId = &#63; and serialNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_SN(
		long groupId, java.lang.String serialNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r registration in the ordered set where groupId = &#63; and serialNumber = &#63;.
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration findByG_SN_First(
		long groupId, java.lang.String serialNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r registration in the ordered set where groupId = &#63; and serialNumber = &#63;.
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r registration, or <code>null</code> if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration fetchByG_SN_First(
		long groupId, java.lang.String serialNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r registration in the ordered set where groupId = &#63; and serialNumber = &#63;.
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration findByG_SN_Last(
		long groupId, java.lang.String serialNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r registration in the ordered set where groupId = &#63; and serialNumber = &#63;.
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r registration, or <code>null</code> if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration fetchByG_SN_Last(
		long groupId, java.lang.String serialNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r registrations before and after the current p r registration in the ordered set where groupId = &#63; and serialNumber = &#63;.
	*
	* @param registrationId the primary key of the current p r registration
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration[] findByG_SN_PrevAndNext(
		long registrationId, long groupId, java.lang.String serialNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r registrations that the user has permission to view where groupId = &#63; and serialNumber = &#63;.
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @return the matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_SN(
		long groupId, java.lang.String serialNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r registrations that the user has permission to view where groupId = &#63; and serialNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @return the range of matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_SN(
		long groupId, java.lang.String serialNumber, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r registrations that the user has permissions to view where groupId = &#63; and serialNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_SN(
		long groupId, java.lang.String serialNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r registrations before and after the current p r registration in the ordered set of p r registrations that the user has permission to view where groupId = &#63; and serialNumber = &#63;.
	*
	* @param registrationId the primary key of the current p r registration
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration[] filterFindByG_SN_PrevAndNext(
		long registrationId, long groupId, java.lang.String serialNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p r registrations where groupId = &#63; and serialNumber = &#63; from the database.
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_SN(long groupId, java.lang.String serialNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r registrations where groupId = &#63; and serialNumber = &#63;.
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @return the number of matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_SN(long groupId, java.lang.String serialNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r registrations that the user has permission to view where groupId = &#63; and serialNumber = &#63;.
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @return the number of matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_SN(long groupId, java.lang.String serialNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the p r registration in the entity cache if it is enabled.
	*
	* @param prRegistration the p r registration
	*/
	public void cacheResult(
		com.inkwell.internet.productregistration.model.PRRegistration prRegistration);

	/**
	* Caches the p r registrations in the entity cache if it is enabled.
	*
	* @param prRegistrations the p r registrations
	*/
	public void cacheResult(
		java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> prRegistrations);

	/**
	* Creates a new p r registration with the primary key. Does not add the p r registration to the database.
	*
	* @param registrationId the primary key for the new p r registration
	* @return the new p r registration
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration create(
		long registrationId);

	/**
	* Removes the p r registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param registrationId the primary key of the p r registration
	* @return the p r registration that was removed
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration remove(
		long registrationId)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.inkwell.internet.productregistration.model.PRRegistration updateImpl(
		com.inkwell.internet.productregistration.model.PRRegistration prRegistration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r registration with the primary key or throws a {@link com.inkwell.internet.productregistration.NoSuchRegistrationException} if it could not be found.
	*
	* @param registrationId the primary key of the p r registration
	* @return the p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration findByPrimaryKey(
		long registrationId)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param registrationId the primary key of the p r registration
	* @return the p r registration, or <code>null</code> if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRRegistration fetchByPrimaryKey(
		long registrationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r registrations.
	*
	* @return the p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @return the range of p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p r registrations
	* @param end the upper bound of the range of p r registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p r registrations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r registrations.
	*
	* @return the number of p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}