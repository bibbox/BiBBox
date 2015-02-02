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

import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the r d connect event service. This utility wraps {@link RDConnectEventPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see RDConnectEventPersistence
 * @see RDConnectEventPersistenceImpl
 * @generated
 */
public class RDConnectEventUtil {
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
	public static void clearCache(RDConnectEvent rdConnectEvent) {
		getPersistence().clearCache(rdConnectEvent);
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
	public static List<RDConnectEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RDConnectEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RDConnectEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static RDConnectEvent update(RDConnectEvent rdConnectEvent)
		throws SystemException {
		return getPersistence().update(rdConnectEvent);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static RDConnectEvent update(RDConnectEvent rdConnectEvent,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(rdConnectEvent, serviceContext);
	}

	/**
	* Returns all the r d connect events where restricted = &#63;.
	*
	* @param restricted the restricted
	* @return the matching r d connect events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent> findByRestricted(
		java.lang.String restricted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRestricted(restricted);
	}

	/**
	* Returns a range of all the r d connect events where restricted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param restricted the restricted
	* @param start the lower bound of the range of r d connect events
	* @param end the upper bound of the range of r d connect events (not inclusive)
	* @return the range of matching r d connect events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent> findByRestricted(
		java.lang.String restricted, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRestricted(restricted, start, end);
	}

	/**
	* Returns an ordered range of all the r d connect events where restricted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param restricted the restricted
	* @param start the lower bound of the range of r d connect events
	* @param end the upper bound of the range of r d connect events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching r d connect events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent> findByRestricted(
		java.lang.String restricted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRestricted(restricted, start, end, orderByComparator);
	}

	/**
	* Returns the first r d connect event in the ordered set where restricted = &#63;.
	*
	* @param restricted the restricted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d connect event
	* @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a matching r d connect event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent findByRestricted_First(
		java.lang.String restricted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRestricted_First(restricted, orderByComparator);
	}

	/**
	* Returns the first r d connect event in the ordered set where restricted = &#63;.
	*
	* @param restricted the restricted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d connect event, or <code>null</code> if a matching r d connect event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent fetchByRestricted_First(
		java.lang.String restricted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRestricted_First(restricted, orderByComparator);
	}

	/**
	* Returns the last r d connect event in the ordered set where restricted = &#63;.
	*
	* @param restricted the restricted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d connect event
	* @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a matching r d connect event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent findByRestricted_Last(
		java.lang.String restricted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRestricted_Last(restricted, orderByComparator);
	}

	/**
	* Returns the last r d connect event in the ordered set where restricted = &#63;.
	*
	* @param restricted the restricted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d connect event, or <code>null</code> if a matching r d connect event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent fetchByRestricted_Last(
		java.lang.String restricted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRestricted_Last(restricted, orderByComparator);
	}

	/**
	* Returns the r d connect events before and after the current r d connect event in the ordered set where restricted = &#63;.
	*
	* @param eventId the primary key of the current r d connect event
	* @param restricted the restricted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next r d connect event
	* @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a r d connect event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent[] findByRestricted_PrevAndNext(
		long eventId, java.lang.String restricted,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRestricted_PrevAndNext(eventId, restricted,
			orderByComparator);
	}

	/**
	* Removes all the r d connect events where restricted = &#63; from the database.
	*
	* @param restricted the restricted
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRestricted(java.lang.String restricted)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRestricted(restricted);
	}

	/**
	* Returns the number of r d connect events where restricted = &#63;.
	*
	* @param restricted the restricted
	* @return the number of matching r d connect events
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRestricted(java.lang.String restricted)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRestricted(restricted);
	}

	/**
	* Returns all the r d connect events where eventdate = &#63;.
	*
	* @param eventdate the eventdate
	* @return the matching r d connect events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent> findByEventdate(
		java.util.Date eventdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEventdate(eventdate);
	}

	/**
	* Returns a range of all the r d connect events where eventdate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventdate the eventdate
	* @param start the lower bound of the range of r d connect events
	* @param end the upper bound of the range of r d connect events (not inclusive)
	* @return the range of matching r d connect events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent> findByEventdate(
		java.util.Date eventdate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEventdate(eventdate, start, end);
	}

	/**
	* Returns an ordered range of all the r d connect events where eventdate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventdate the eventdate
	* @param start the lower bound of the range of r d connect events
	* @param end the upper bound of the range of r d connect events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching r d connect events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent> findByEventdate(
		java.util.Date eventdate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventdate(eventdate, start, end, orderByComparator);
	}

	/**
	* Returns the first r d connect event in the ordered set where eventdate = &#63;.
	*
	* @param eventdate the eventdate
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d connect event
	* @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a matching r d connect event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent findByEventdate_First(
		java.util.Date eventdate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventdate_First(eventdate, orderByComparator);
	}

	/**
	* Returns the first r d connect event in the ordered set where eventdate = &#63;.
	*
	* @param eventdate the eventdate
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching r d connect event, or <code>null</code> if a matching r d connect event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent fetchByEventdate_First(
		java.util.Date eventdate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEventdate_First(eventdate, orderByComparator);
	}

	/**
	* Returns the last r d connect event in the ordered set where eventdate = &#63;.
	*
	* @param eventdate the eventdate
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d connect event
	* @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a matching r d connect event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent findByEventdate_Last(
		java.util.Date eventdate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventdate_Last(eventdate, orderByComparator);
	}

	/**
	* Returns the last r d connect event in the ordered set where eventdate = &#63;.
	*
	* @param eventdate the eventdate
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching r d connect event, or <code>null</code> if a matching r d connect event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent fetchByEventdate_Last(
		java.util.Date eventdate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEventdate_Last(eventdate, orderByComparator);
	}

	/**
	* Returns the r d connect events before and after the current r d connect event in the ordered set where eventdate = &#63;.
	*
	* @param eventId the primary key of the current r d connect event
	* @param eventdate the eventdate
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next r d connect event
	* @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a r d connect event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent[] findByEventdate_PrevAndNext(
		long eventId, java.util.Date eventdate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventdate_PrevAndNext(eventId, eventdate,
			orderByComparator);
	}

	/**
	* Removes all the r d connect events where eventdate = &#63; from the database.
	*
	* @param eventdate the eventdate
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEventdate(java.util.Date eventdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEventdate(eventdate);
	}

	/**
	* Returns the number of r d connect events where eventdate = &#63;.
	*
	* @param eventdate the eventdate
	* @return the number of matching r d connect events
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEventdate(java.util.Date eventdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEventdate(eventdate);
	}

	/**
	* Caches the r d connect event in the entity cache if it is enabled.
	*
	* @param rdConnectEvent the r d connect event
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent rdConnectEvent) {
		getPersistence().cacheResult(rdConnectEvent);
	}

	/**
	* Caches the r d connect events in the entity cache if it is enabled.
	*
	* @param rdConnectEvents the r d connect events
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent> rdConnectEvents) {
		getPersistence().cacheResult(rdConnectEvents);
	}

	/**
	* Creates a new r d connect event with the primary key. Does not add the r d connect event to the database.
	*
	* @param eventId the primary key for the new r d connect event
	* @return the new r d connect event
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent create(
		long eventId) {
		return getPersistence().create(eventId);
	}

	/**
	* Removes the r d connect event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventId the primary key of the r d connect event
	* @return the r d connect event that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a r d connect event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent remove(
		long eventId)
		throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(eventId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent rdConnectEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(rdConnectEvent);
	}

	/**
	* Returns the r d connect event with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException} if it could not be found.
	*
	* @param eventId the primary key of the r d connect event
	* @return the r d connect event
	* @throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException if a r d connect event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent findByPrimaryKey(
		long eventId)
		throws at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.NoSuchRDConnectEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(eventId);
	}

	/**
	* Returns the r d connect event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventId the primary key of the r d connect event
	* @return the r d connect event, or <code>null</code> if a r d connect event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent fetchByPrimaryKey(
		long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eventId);
	}

	/**
	* Returns all the r d connect events.
	*
	* @return the r d connect events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the r d connect events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of r d connect events
	* @param end the upper bound of the range of r d connect events (not inclusive)
	* @return the range of r d connect events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the r d connect events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.impl.RDConnectEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of r d connect events
	* @param end the upper bound of the range of r d connect events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of r d connect events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.model.RDConnectEvent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the r d connect events from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of r d connect events.
	*
	* @return the number of r d connect events
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RDConnectEventPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RDConnectEventPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.ClpSerializer.getServletContextName(),
					RDConnectEventPersistence.class.getName());

			ReferenceRegistry.registerReference(RDConnectEventUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RDConnectEventPersistence persistence) {
	}

	private static RDConnectEventPersistence _persistence;
}