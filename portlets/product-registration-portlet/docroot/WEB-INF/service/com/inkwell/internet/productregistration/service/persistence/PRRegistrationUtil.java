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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the p r registration service. This utility wraps {@link PRRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rich Sezov
 * @see PRRegistrationPersistence
 * @see PRRegistrationPersistenceImpl
 * @generated
 */
public class PRRegistrationUtil {
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
	public static void clearCache(PRRegistration prRegistration) {
		getPersistence().clearCache(prRegistration);
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
	public static List<PRRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PRRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PRRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PRRegistration update(PRRegistration prRegistration)
		throws SystemException {
		return getPersistence().update(prRegistration);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PRRegistration update(PRRegistration prRegistration,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(prRegistration, serviceContext);
	}

	/**
	* Returns all the p r registrations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first p r registration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first p r registration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r registration, or <code>null</code> if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last p r registration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last p r registration in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r registration, or <code>null</code> if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRRegistration[] findByGroupId_PrevAndNext(
		long registrationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(registrationId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the p r registrations that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRRegistration[] filterFindByGroupId_PrevAndNext(
		long registrationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(registrationId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the p r registrations where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of p r registrations where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of p r registrations that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns all the p r registrations where groupId = &#63; and prUserId = &#63;.
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @return the matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_RU(
		long groupId, long prUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_RU(groupId, prUserId);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_RU(
		long groupId, long prUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_RU(groupId, prUserId, start, end);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_RU(
		long groupId, long prUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_RU(groupId, prUserId, start, end, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRRegistration findByG_RU_First(
		long groupId, long prUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_RU_First(groupId, prUserId, orderByComparator);
	}

	/**
	* Returns the first p r registration in the ordered set where groupId = &#63; and prUserId = &#63;.
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r registration, or <code>null</code> if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration fetchByG_RU_First(
		long groupId, long prUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_RU_First(groupId, prUserId, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRRegistration findByG_RU_Last(
		long groupId, long prUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_RU_Last(groupId, prUserId, orderByComparator);
	}

	/**
	* Returns the last p r registration in the ordered set where groupId = &#63; and prUserId = &#63;.
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r registration, or <code>null</code> if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration fetchByG_RU_Last(
		long groupId, long prUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_RU_Last(groupId, prUserId, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRRegistration[] findByG_RU_PrevAndNext(
		long registrationId, long groupId, long prUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_RU_PrevAndNext(registrationId, groupId, prUserId,
			orderByComparator);
	}

	/**
	* Returns all the p r registrations that the user has permission to view where groupId = &#63; and prUserId = &#63;.
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @return the matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_RU(
		long groupId, long prUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_RU(groupId, prUserId);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_RU(
		long groupId, long prUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_RU(groupId, prUserId, start, end);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_RU(
		long groupId, long prUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_RU(groupId, prUserId, start, end,
			orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRRegistration[] filterFindByG_RU_PrevAndNext(
		long registrationId, long groupId, long prUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_RU_PrevAndNext(registrationId, groupId,
			prUserId, orderByComparator);
	}

	/**
	* Removes all the p r registrations where groupId = &#63; and prUserId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_RU(long groupId, long prUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_RU(groupId, prUserId);
	}

	/**
	* Returns the number of p r registrations where groupId = &#63; and prUserId = &#63;.
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @return the number of matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_RU(long groupId, long prUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_RU(groupId, prUserId);
	}

	/**
	* Returns the number of p r registrations that the user has permission to view where groupId = &#63; and prUserId = &#63;.
	*
	* @param groupId the group ID
	* @param prUserId the pr user ID
	* @return the number of matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_RU(long groupId, long prUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_RU(groupId, prUserId);
	}

	/**
	* Returns all the p r registrations where groupId = &#63; and datePurchased = &#63;.
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @return the matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_DP(
		long groupId, java.util.Date datePurchased)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_DP(groupId, datePurchased);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_DP(
		long groupId, java.util.Date datePurchased, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_DP(groupId, datePurchased, start, end);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_DP(
		long groupId, java.util.Date datePurchased, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_DP(groupId, datePurchased, start, end,
			orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRRegistration findByG_DP_First(
		long groupId, java.util.Date datePurchased,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_DP_First(groupId, datePurchased, orderByComparator);
	}

	/**
	* Returns the first p r registration in the ordered set where groupId = &#63; and datePurchased = &#63;.
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r registration, or <code>null</code> if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration fetchByG_DP_First(
		long groupId, java.util.Date datePurchased,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_DP_First(groupId, datePurchased, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRRegistration findByG_DP_Last(
		long groupId, java.util.Date datePurchased,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_DP_Last(groupId, datePurchased, orderByComparator);
	}

	/**
	* Returns the last p r registration in the ordered set where groupId = &#63; and datePurchased = &#63;.
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r registration, or <code>null</code> if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration fetchByG_DP_Last(
		long groupId, java.util.Date datePurchased,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_DP_Last(groupId, datePurchased, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRRegistration[] findByG_DP_PrevAndNext(
		long registrationId, long groupId, java.util.Date datePurchased,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_DP_PrevAndNext(registrationId, groupId,
			datePurchased, orderByComparator);
	}

	/**
	* Returns all the p r registrations that the user has permission to view where groupId = &#63; and datePurchased = &#63;.
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @return the matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_DP(
		long groupId, java.util.Date datePurchased)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_DP(groupId, datePurchased);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_DP(
		long groupId, java.util.Date datePurchased, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_DP(groupId, datePurchased, start, end);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_DP(
		long groupId, java.util.Date datePurchased, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_DP(groupId, datePurchased, start, end,
			orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRRegistration[] filterFindByG_DP_PrevAndNext(
		long registrationId, long groupId, java.util.Date datePurchased,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_DP_PrevAndNext(registrationId, groupId,
			datePurchased, orderByComparator);
	}

	/**
	* Removes all the p r registrations where groupId = &#63; and datePurchased = &#63; from the database.
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_DP(long groupId, java.util.Date datePurchased)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_DP(groupId, datePurchased);
	}

	/**
	* Returns the number of p r registrations where groupId = &#63; and datePurchased = &#63;.
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @return the number of matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_DP(long groupId, java.util.Date datePurchased)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_DP(groupId, datePurchased);
	}

	/**
	* Returns the number of p r registrations that the user has permission to view where groupId = &#63; and datePurchased = &#63;.
	*
	* @param groupId the group ID
	* @param datePurchased the date purchased
	* @return the number of matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_DP(long groupId,
		java.util.Date datePurchased)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_DP(groupId, datePurchased);
	}

	/**
	* Returns all the p r registrations where groupId = &#63; and serialNumber = &#63;.
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @return the matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_SN(
		long groupId, java.lang.String serialNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_SN(groupId, serialNumber);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_SN(
		long groupId, java.lang.String serialNumber, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_SN(groupId, serialNumber, start, end);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findByG_SN(
		long groupId, java.lang.String serialNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_SN(groupId, serialNumber, start, end,
			orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRRegistration findByG_SN_First(
		long groupId, java.lang.String serialNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_SN_First(groupId, serialNumber, orderByComparator);
	}

	/**
	* Returns the first p r registration in the ordered set where groupId = &#63; and serialNumber = &#63;.
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p r registration, or <code>null</code> if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration fetchByG_SN_First(
		long groupId, java.lang.String serialNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_SN_First(groupId, serialNumber, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRRegistration findByG_SN_Last(
		long groupId, java.lang.String serialNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_SN_Last(groupId, serialNumber, orderByComparator);
	}

	/**
	* Returns the last p r registration in the ordered set where groupId = &#63; and serialNumber = &#63;.
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p r registration, or <code>null</code> if a matching p r registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration fetchByG_SN_Last(
		long groupId, java.lang.String serialNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_SN_Last(groupId, serialNumber, orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRRegistration[] findByG_SN_PrevAndNext(
		long registrationId, long groupId, java.lang.String serialNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_SN_PrevAndNext(registrationId, groupId,
			serialNumber, orderByComparator);
	}

	/**
	* Returns all the p r registrations that the user has permission to view where groupId = &#63; and serialNumber = &#63;.
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @return the matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_SN(
		long groupId, java.lang.String serialNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_SN(groupId, serialNumber);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_SN(
		long groupId, java.lang.String serialNumber, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_SN(groupId, serialNumber, start, end);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> filterFindByG_SN(
		long groupId, java.lang.String serialNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_SN(groupId, serialNumber, start, end,
			orderByComparator);
	}

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
	public static com.inkwell.internet.productregistration.model.PRRegistration[] filterFindByG_SN_PrevAndNext(
		long registrationId, long groupId, java.lang.String serialNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_SN_PrevAndNext(registrationId, groupId,
			serialNumber, orderByComparator);
	}

	/**
	* Removes all the p r registrations where groupId = &#63; and serialNumber = &#63; from the database.
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_SN(long groupId, java.lang.String serialNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_SN(groupId, serialNumber);
	}

	/**
	* Returns the number of p r registrations where groupId = &#63; and serialNumber = &#63;.
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @return the number of matching p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_SN(long groupId, java.lang.String serialNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_SN(groupId, serialNumber);
	}

	/**
	* Returns the number of p r registrations that the user has permission to view where groupId = &#63; and serialNumber = &#63;.
	*
	* @param groupId the group ID
	* @param serialNumber the serial number
	* @return the number of matching p r registrations that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_SN(long groupId,
		java.lang.String serialNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_SN(groupId, serialNumber);
	}

	/**
	* Caches the p r registration in the entity cache if it is enabled.
	*
	* @param prRegistration the p r registration
	*/
	public static void cacheResult(
		com.inkwell.internet.productregistration.model.PRRegistration prRegistration) {
		getPersistence().cacheResult(prRegistration);
	}

	/**
	* Caches the p r registrations in the entity cache if it is enabled.
	*
	* @param prRegistrations the p r registrations
	*/
	public static void cacheResult(
		java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> prRegistrations) {
		getPersistence().cacheResult(prRegistrations);
	}

	/**
	* Creates a new p r registration with the primary key. Does not add the p r registration to the database.
	*
	* @param registrationId the primary key for the new p r registration
	* @return the new p r registration
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration create(
		long registrationId) {
		return getPersistence().create(registrationId);
	}

	/**
	* Removes the p r registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param registrationId the primary key of the p r registration
	* @return the p r registration that was removed
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration remove(
		long registrationId)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(registrationId);
	}

	public static com.inkwell.internet.productregistration.model.PRRegistration updateImpl(
		com.inkwell.internet.productregistration.model.PRRegistration prRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(prRegistration);
	}

	/**
	* Returns the p r registration with the primary key or throws a {@link com.inkwell.internet.productregistration.NoSuchRegistrationException} if it could not be found.
	*
	* @param registrationId the primary key of the p r registration
	* @return the p r registration
	* @throws com.inkwell.internet.productregistration.NoSuchRegistrationException if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration findByPrimaryKey(
		long registrationId)
		throws com.inkwell.internet.productregistration.NoSuchRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(registrationId);
	}

	/**
	* Returns the p r registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param registrationId the primary key of the p r registration
	* @return the p r registration, or <code>null</code> if a p r registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRRegistration fetchByPrimaryKey(
		long registrationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(registrationId);
	}

	/**
	* Returns all the p r registrations.
	*
	* @return the p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.inkwell.internet.productregistration.model.PRRegistration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the p r registrations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of p r registrations.
	*
	* @return the number of p r registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PRRegistrationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PRRegistrationPersistence)PortletBeanLocatorUtil.locate(com.inkwell.internet.productregistration.service.ClpSerializer.getServletContextName(),
					PRRegistrationPersistence.class.getName());

			ReferenceRegistry.registerReference(PRRegistrationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PRRegistrationPersistence persistence) {
	}

	private static PRRegistrationPersistence _persistence;
}