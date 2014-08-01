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

import com.inkwell.internet.productregistration.model.PRUser;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the p r user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see PRUserPersistenceImpl
 * @see PRUserUtil
 * @generated
 */
public interface PRUserPersistence extends BasePersistence<PRUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PRUserUtil} to access the p r user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the p r users where groupId = &#63; and lastName = &#63;.
	*
	* @param groupId the group ID
	* @param lastName the last name
	* @return the matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_LN(
		long groupId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r users where groupId = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param lastName the last name
	* @param start the lower bound of the range of p r users
	* @param end the upper bound of the range of p r users (not inclusive)
	* @return the range of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_LN(
		long groupId, java.lang.String lastName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r users where groupId = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param lastName the last name
	* @param start the lower bound of the range of p r users
	* @param end the upper bound of the range of p r users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_LN(
		long groupId, java.lang.String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r user in the ordered set where groupId = &#63; and lastName = &#63;.
	*
	* @param groupId the group ID
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser findByG_LN_First(
		long groupId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r user in the ordered set where groupId = &#63; and lastName = &#63;.
	*
	* @param groupId the group ID
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r user, or <code>null</code> if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser fetchByG_LN_First(
		long groupId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r user in the ordered set where groupId = &#63; and lastName = &#63;.
	*
	* @param groupId the group ID
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser findByG_LN_Last(
		long groupId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r user in the ordered set where groupId = &#63; and lastName = &#63;.
	*
	* @param groupId the group ID
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r user, or <code>null</code> if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser fetchByG_LN_Last(
		long groupId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r users before and after the current p r user in the ordered set where groupId = &#63; and lastName = &#63;.
	*
	* @param prUserId the primary key of the current p r user
	* @param groupId the group ID
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser[] findByG_LN_PrevAndNext(
		long prUserId, long groupId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r users that the user has permission to view where groupId = &#63; and lastName = &#63;.
	*
	* @param groupId the group ID
	* @param lastName the last name
	* @return the matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_LN(
		long groupId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r users that the user has permission to view where groupId = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param lastName the last name
	* @param start the lower bound of the range of p r users
	* @param end the upper bound of the range of p r users (not inclusive)
	* @return the range of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_LN(
		long groupId, java.lang.String lastName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r users that the user has permissions to view where groupId = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param lastName the last name
	* @param start the lower bound of the range of p r users
	* @param end the upper bound of the range of p r users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_LN(
		long groupId, java.lang.String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r users before and after the current p r user in the ordered set of p r users that the user has permission to view where groupId = &#63; and lastName = &#63;.
	*
	* @param prUserId the primary key of the current p r user
	* @param groupId the group ID
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser[] filterFindByG_LN_PrevAndNext(
		long prUserId, long groupId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p r users where groupId = &#63; and lastName = &#63; from the database.
	*
	* @param groupId the group ID
	* @param lastName the last name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_LN(long groupId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r users where groupId = &#63; and lastName = &#63;.
	*
	* @param groupId the group ID
	* @param lastName the last name
	* @return the number of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_LN(long groupId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r users that the user has permission to view where groupId = &#63; and lastName = &#63;.
	*
	* @param groupId the group ID
	* @param lastName the last name
	* @return the number of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_LN(long groupId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r users where groupId = &#63; and email = &#63;.
	*
	* @param groupId the group ID
	* @param email the email
	* @return the matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_E(
		long groupId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r users where groupId = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param email the email
	* @param start the lower bound of the range of p r users
	* @param end the upper bound of the range of p r users (not inclusive)
	* @return the range of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_E(
		long groupId, java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r users where groupId = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param email the email
	* @param start the lower bound of the range of p r users
	* @param end the upper bound of the range of p r users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_E(
		long groupId, java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r user in the ordered set where groupId = &#63; and email = &#63;.
	*
	* @param groupId the group ID
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser findByG_E_First(
		long groupId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r user in the ordered set where groupId = &#63; and email = &#63;.
	*
	* @param groupId the group ID
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r user, or <code>null</code> if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser fetchByG_E_First(
		long groupId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r user in the ordered set where groupId = &#63; and email = &#63;.
	*
	* @param groupId the group ID
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser findByG_E_Last(
		long groupId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r user in the ordered set where groupId = &#63; and email = &#63;.
	*
	* @param groupId the group ID
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r user, or <code>null</code> if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser fetchByG_E_Last(
		long groupId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r users before and after the current p r user in the ordered set where groupId = &#63; and email = &#63;.
	*
	* @param prUserId the primary key of the current p r user
	* @param groupId the group ID
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser[] findByG_E_PrevAndNext(
		long prUserId, long groupId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r users that the user has permission to view where groupId = &#63; and email = &#63;.
	*
	* @param groupId the group ID
	* @param email the email
	* @return the matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_E(
		long groupId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r users that the user has permission to view where groupId = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param email the email
	* @param start the lower bound of the range of p r users
	* @param end the upper bound of the range of p r users (not inclusive)
	* @return the range of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_E(
		long groupId, java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r users that the user has permissions to view where groupId = &#63; and email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param email the email
	* @param start the lower bound of the range of p r users
	* @param end the upper bound of the range of p r users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_E(
		long groupId, java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r users before and after the current p r user in the ordered set of p r users that the user has permission to view where groupId = &#63; and email = &#63;.
	*
	* @param prUserId the primary key of the current p r user
	* @param groupId the group ID
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser[] filterFindByG_E_PrevAndNext(
		long prUserId, long groupId, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p r users where groupId = &#63; and email = &#63; from the database.
	*
	* @param groupId the group ID
	* @param email the email
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_E(long groupId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r users where groupId = &#63; and email = &#63;.
	*
	* @param groupId the group ID
	* @param email the email
	* @return the number of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_E(long groupId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r users that the user has permission to view where groupId = &#63; and email = &#63;.
	*
	* @param groupId the group ID
	* @param email the email
	* @return the number of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_E(long groupId, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r users where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_U(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r users where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of p r users
	* @param end the upper bound of the range of p r users (not inclusive)
	* @return the range of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_U(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r users where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of p r users
	* @param end the upper bound of the range of p r users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r user in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser findByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p r user in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r user, or <code>null</code> if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser fetchByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r user in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser findByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p r user in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r user, or <code>null</code> if a matching p r user could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser fetchByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r users before and after the current p r user in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param prUserId the primary key of the current p r user
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser[] findByG_U_PrevAndNext(
		long prUserId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r users that the user has permission to view where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_U(
		long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r users that the user has permission to view where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of p r users
	* @param end the upper bound of the range of p r users (not inclusive)
	* @return the range of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_U(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r users that the user has permissions to view where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of p r users
	* @param end the upper bound of the range of p r users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> filterFindByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r users before and after the current p r user in the ordered set of p r users that the user has permission to view where groupId = &#63; and userId = &#63;.
	*
	* @param prUserId the primary key of the current p r user
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser[] filterFindByG_U_PrevAndNext(
		long prUserId, long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p r users where groupId = &#63; and userId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r users where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching p r users
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r users that the user has permission to view where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching p r users that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_U(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the p r user in the entity cache if it is enabled.
	*
	* @param prUser the p r user
	*/
	public void cacheResult(
		com.inkwell.internet.productregistration.model.PRUser prUser);

	/**
	* Caches the p r users in the entity cache if it is enabled.
	*
	* @param prUsers the p r users
	*/
	public void cacheResult(
		java.util.List<com.inkwell.internet.productregistration.model.PRUser> prUsers);

	/**
	* Creates a new p r user with the primary key. Does not add the p r user to the database.
	*
	* @param prUserId the primary key for the new p r user
	* @return the new p r user
	*/
	public com.inkwell.internet.productregistration.model.PRUser create(
		long prUserId);

	/**
	* Removes the p r user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param prUserId the primary key of the p r user
	* @return the p r user that was removed
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser remove(
		long prUserId)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.inkwell.internet.productregistration.model.PRUser updateImpl(
		com.inkwell.internet.productregistration.model.PRUser prUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r user with the primary key or throws a {@link com.inkwell.internet.productregistration.NoSuchUserException} if it could not be found.
	*
	* @param prUserId the primary key of the p r user
	* @return the p r user
	* @throws com.inkwell.internet.productregistration.NoSuchUserException if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser findByPrimaryKey(
		long prUserId)
		throws com.inkwell.internet.productregistration.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p r user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param prUserId the primary key of the p r user
	* @return the p r user, or <code>null</code> if a p r user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.inkwell.internet.productregistration.model.PRUser fetchByPrimaryKey(
		long prUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p r users.
	*
	* @return the p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p r users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p r users
	* @param end the upper bound of the range of p r users (not inclusive)
	* @return the range of p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p r users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p r users
	* @param end the upper bound of the range of p r users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p r users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.inkwell.internet.productregistration.model.PRUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p r users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p r users.
	*
	* @return the number of p r users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}