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

package at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the r d connect event notification service. This utility wraps {@link RDConnectEventNotificationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see RDConnectEventNotificationPersistence
 * @see RDConnectEventNotificationPersistenceImpl
 * @generated
 */
public class RDConnectEventNotificationUtil {
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
		RDConnectEventNotification rdConnectEventNotification) {
		getPersistence().clearCache(rdConnectEventNotification);
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
	public static List<RDConnectEventNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RDConnectEventNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RDConnectEventNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static RDConnectEventNotification update(
		RDConnectEventNotification rdConnectEventNotification)
		throws SystemException {
		return getPersistence().update(rdConnectEventNotification);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static RDConnectEventNotification update(
		RDConnectEventNotification rdConnectEventNotification,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(rdConnectEventNotification, serviceContext);
	}

	/**
	* Returns the r d connect event notification where notificationtype = &#63; and userId = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException} if it could not be found.
	*
	* @param notificationtype the notificationtype
	* @param userId the user ID
	* @return the matching r d connect event notification
	* @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException if a matching r d connect event notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification findByEventNotificationForUser(
		java.lang.String notificationtype, long userId)
		throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventNotificationForUser(notificationtype, userId);
	}

	/**
	* Returns the r d connect event notification where notificationtype = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param notificationtype the notificationtype
	* @param userId the user ID
	* @return the matching r d connect event notification, or <code>null</code> if a matching r d connect event notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification fetchByEventNotificationForUser(
		java.lang.String notificationtype, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEventNotificationForUser(notificationtype, userId);
	}

	/**
	* Returns the r d connect event notification where notificationtype = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param notificationtype the notificationtype
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching r d connect event notification, or <code>null</code> if a matching r d connect event notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification fetchByEventNotificationForUser(
		java.lang.String notificationtype, long userId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEventNotificationForUser(notificationtype, userId,
			retrieveFromCache);
	}

	/**
	* Removes the r d connect event notification where notificationtype = &#63; and userId = &#63; from the database.
	*
	* @param notificationtype the notificationtype
	* @param userId the user ID
	* @return the r d connect event notification that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification removeByEventNotificationForUser(
		java.lang.String notificationtype, long userId)
		throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByEventNotificationForUser(notificationtype, userId);
	}

	/**
	* Returns the number of r d connect event notifications where notificationtype = &#63; and userId = &#63;.
	*
	* @param notificationtype the notificationtype
	* @param userId the user ID
	* @return the number of matching r d connect event notifications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEventNotificationForUser(
		java.lang.String notificationtype, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByEventNotificationForUser(notificationtype, userId);
	}

	/**
	* Returns all the r d connect event notifications where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching r d connect event notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification> findByEventNotificationsForUser(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEventNotificationsForUser(userId);
	}

	/**
	* Returns a range of all the r d connect event notifications where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of r d connect event notifications
	* @param end the upper bound of the range of r d connect event notifications (not inclusive)
	* @return the range of matching r d connect event notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification> findByEventNotificationsForUser(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventNotificationsForUser(userId, start, end);
	}

	/**
	* Returns an ordered range of all the r d connect event notifications where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of r d connect event notifications
	* @param end the upper bound of the range of r d connect event notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching r d connect event notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification> findByEventNotificationsForUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventNotificationsForUser(userId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first r d connect event notification in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d connect event notification
	* @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException if a matching r d connect event notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification findByEventNotificationsForUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventNotificationsForUser_First(userId,
			orderByComparator);
	}

	/**
	* Returns the first r d connect event notification in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d connect event notification, or <code>null</code> if a matching r d connect event notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification fetchByEventNotificationsForUser_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEventNotificationsForUser_First(userId,
			orderByComparator);
	}

	/**
	* Returns the last r d connect event notification in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d connect event notification
	* @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException if a matching r d connect event notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification findByEventNotificationsForUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventNotificationsForUser_Last(userId,
			orderByComparator);
	}

	/**
	* Returns the last r d connect event notification in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d connect event notification, or <code>null</code> if a matching r d connect event notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification fetchByEventNotificationsForUser_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEventNotificationsForUser_Last(userId,
			orderByComparator);
	}

	/**
	* Returns the r d connect event notifications before and after the current r d connect event notification in the ordered set where userId = &#63;.
	*
	* @param eventnotificationId the primary key of the current r d connect event notification
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next r d connect event notification
	* @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException if a r d connect event notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification[] findByEventNotificationsForUser_PrevAndNext(
		long eventnotificationId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventNotificationsForUser_PrevAndNext(eventnotificationId,
			userId, orderByComparator);
	}

	/**
	* Removes all the r d connect event notifications where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEventNotificationsForUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEventNotificationsForUser(userId);
	}

	/**
	* Returns the number of r d connect event notifications where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching r d connect event notifications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEventNotificationsForUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEventNotificationsForUser(userId);
	}

	/**
	* Caches the r d connect event notification in the entity cache if it is enabled.
	*
	* @param rdConnectEventNotification the r d connect event notification
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification rdConnectEventNotification) {
		getPersistence().cacheResult(rdConnectEventNotification);
	}

	/**
	* Caches the r d connect event notifications in the entity cache if it is enabled.
	*
	* @param rdConnectEventNotifications the r d connect event notifications
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification> rdConnectEventNotifications) {
		getPersistence().cacheResult(rdConnectEventNotifications);
	}

	/**
	* Creates a new r d connect event notification with the primary key. Does not add the r d connect event notification to the database.
	*
	* @param eventnotificationId the primary key for the new r d connect event notification
	* @return the new r d connect event notification
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification create(
		long eventnotificationId) {
		return getPersistence().create(eventnotificationId);
	}

	/**
	* Removes the r d connect event notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventnotificationId the primary key of the r d connect event notification
	* @return the r d connect event notification that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException if a r d connect event notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification remove(
		long eventnotificationId)
		throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(eventnotificationId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification rdConnectEventNotification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(rdConnectEventNotification);
	}

	/**
	* Returns the r d connect event notification with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException} if it could not be found.
	*
	* @param eventnotificationId the primary key of the r d connect event notification
	* @return the r d connect event notification
	* @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException if a r d connect event notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification findByPrimaryKey(
		long eventnotificationId)
		throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(eventnotificationId);
	}

	/**
	* Returns the r d connect event notification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventnotificationId the primary key of the r d connect event notification
	* @return the r d connect event notification, or <code>null</code> if a r d connect event notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification fetchByPrimaryKey(
		long eventnotificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eventnotificationId);
	}

	/**
	* Returns all the r d connect event notifications.
	*
	* @return the r d connect event notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the r d connect event notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of r d connect event notifications
	* @param end the upper bound of the range of r d connect event notifications (not inclusive)
	* @return the range of r d connect event notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the r d connect event notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of r d connect event notifications
	* @param end the upper bound of the range of r d connect event notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of r d connect event notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEventNotification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the r d connect event notifications from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of r d connect event notifications.
	*
	* @return the number of r d connect event notifications
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RDConnectEventNotificationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RDConnectEventNotificationPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.ClpSerializer.getServletContextName(),
					RDConnectEventNotificationPersistence.class.getName());

			ReferenceRegistry.registerReference(RDConnectEventNotificationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		RDConnectEventNotificationPersistence persistence) {
	}

	private static RDConnectEventNotificationPersistence _persistence;
}