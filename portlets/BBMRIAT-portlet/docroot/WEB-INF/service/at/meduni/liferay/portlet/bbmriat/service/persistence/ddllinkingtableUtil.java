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

package at.meduni.liferay.portlet.bbmriat.service.persistence;

import at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the ddllinkingtable service. This utility wraps {@link ddllinkingtablePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see ddllinkingtablePersistence
 * @see ddllinkingtablePersistenceImpl
 * @generated
 */
public class ddllinkingtableUtil {
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
	public static void clearCache(ddllinkingtable ddllinkingtable) {
		getPersistence().clearCache(ddllinkingtable);
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
	public static List<ddllinkingtable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ddllinkingtable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ddllinkingtable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ddllinkingtable update(ddllinkingtable ddllinkingtable)
		throws SystemException {
		return getPersistence().update(ddllinkingtable);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ddllinkingtable update(ddllinkingtable ddllinkingtable,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ddllinkingtable, serviceContext);
	}

	/**
	* Returns all the ddllinkingtables where recordid = &#63;.
	*
	* @param recordid the recordid
	* @return the matching ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> findByRecordid(
		long recordid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRecordid(recordid);
	}

	/**
	* Returns a range of all the ddllinkingtables where recordid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.ddllinkingtableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recordid the recordid
	* @param start the lower bound of the range of ddllinkingtables
	* @param end the upper bound of the range of ddllinkingtables (not inclusive)
	* @return the range of matching ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> findByRecordid(
		long recordid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRecordid(recordid, start, end);
	}

	/**
	* Returns an ordered range of all the ddllinkingtables where recordid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.ddllinkingtableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recordid the recordid
	* @param start the lower bound of the range of ddllinkingtables
	* @param end the upper bound of the range of ddllinkingtables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> findByRecordid(
		long recordid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRecordid(recordid, start, end, orderByComparator);
	}

	/**
	* Returns the first ddllinkingtable in the ordered set where recordid = &#63;.
	*
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ddllinkingtable
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a matching ddllinkingtable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable findByRecordid_First(
		long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRecordid_First(recordid, orderByComparator);
	}

	/**
	* Returns the first ddllinkingtable in the ordered set where recordid = &#63;.
	*
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ddllinkingtable, or <code>null</code> if a matching ddllinkingtable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable fetchByRecordid_First(
		long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRecordid_First(recordid, orderByComparator);
	}

	/**
	* Returns the last ddllinkingtable in the ordered set where recordid = &#63;.
	*
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ddllinkingtable
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a matching ddllinkingtable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable findByRecordid_Last(
		long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRecordid_Last(recordid, orderByComparator);
	}

	/**
	* Returns the last ddllinkingtable in the ordered set where recordid = &#63;.
	*
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ddllinkingtable, or <code>null</code> if a matching ddllinkingtable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable fetchByRecordid_Last(
		long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRecordid_Last(recordid, orderByComparator);
	}

	/**
	* Returns the ddllinkingtables before and after the current ddllinkingtable in the ordered set where recordid = &#63;.
	*
	* @param ddllinkingtable the primary key of the current ddllinkingtable
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ddllinkingtable
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a ddllinkingtable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable[] findByRecordid_PrevAndNext(
		long ddllinkingtable, long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRecordid_PrevAndNext(ddllinkingtable, recordid,
			orderByComparator);
	}

	/**
	* Removes all the ddllinkingtables where recordid = &#63; from the database.
	*
	* @param recordid the recordid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRecordid(long recordid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRecordid(recordid);
	}

	/**
	* Returns the number of ddllinkingtables where recordid = &#63;.
	*
	* @param recordid the recordid
	* @return the number of matching ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRecordid(long recordid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRecordid(recordid);
	}

	/**
	* Returns all the ddllinkingtables where recordid = &#63; and recordsetid = &#63;.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @return the matching ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> findByRecordsByRecordset(
		long recordid, long recordsetid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRecordsByRecordset(recordid, recordsetid);
	}

	/**
	* Returns a range of all the ddllinkingtables where recordid = &#63; and recordsetid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.ddllinkingtableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @param start the lower bound of the range of ddllinkingtables
	* @param end the upper bound of the range of ddllinkingtables (not inclusive)
	* @return the range of matching ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> findByRecordsByRecordset(
		long recordid, long recordsetid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRecordsByRecordset(recordid, recordsetid, start, end);
	}

	/**
	* Returns an ordered range of all the ddllinkingtables where recordid = &#63; and recordsetid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.ddllinkingtableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @param start the lower bound of the range of ddllinkingtables
	* @param end the upper bound of the range of ddllinkingtables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> findByRecordsByRecordset(
		long recordid, long recordsetid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRecordsByRecordset(recordid, recordsetid, start, end,
			orderByComparator);
	}

	/**
	* Returns the first ddllinkingtable in the ordered set where recordid = &#63; and recordsetid = &#63;.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ddllinkingtable
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a matching ddllinkingtable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable findByRecordsByRecordset_First(
		long recordid, long recordsetid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRecordsByRecordset_First(recordid, recordsetid,
			orderByComparator);
	}

	/**
	* Returns the first ddllinkingtable in the ordered set where recordid = &#63; and recordsetid = &#63;.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ddllinkingtable, or <code>null</code> if a matching ddllinkingtable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable fetchByRecordsByRecordset_First(
		long recordid, long recordsetid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRecordsByRecordset_First(recordid, recordsetid,
			orderByComparator);
	}

	/**
	* Returns the last ddllinkingtable in the ordered set where recordid = &#63; and recordsetid = &#63;.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ddllinkingtable
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a matching ddllinkingtable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable findByRecordsByRecordset_Last(
		long recordid, long recordsetid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRecordsByRecordset_Last(recordid, recordsetid,
			orderByComparator);
	}

	/**
	* Returns the last ddllinkingtable in the ordered set where recordid = &#63; and recordsetid = &#63;.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ddllinkingtable, or <code>null</code> if a matching ddllinkingtable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable fetchByRecordsByRecordset_Last(
		long recordid, long recordsetid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRecordsByRecordset_Last(recordid, recordsetid,
			orderByComparator);
	}

	/**
	* Returns the ddllinkingtables before and after the current ddllinkingtable in the ordered set where recordid = &#63; and recordsetid = &#63;.
	*
	* @param ddllinkingtable the primary key of the current ddllinkingtable
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ddllinkingtable
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a ddllinkingtable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable[] findByRecordsByRecordset_PrevAndNext(
		long ddllinkingtable, long recordid, long recordsetid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRecordsByRecordset_PrevAndNext(ddllinkingtable,
			recordid, recordsetid, orderByComparator);
	}

	/**
	* Removes all the ddllinkingtables where recordid = &#63; and recordsetid = &#63; from the database.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRecordsByRecordset(long recordid,
		long recordsetid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRecordsByRecordset(recordid, recordsetid);
	}

	/**
	* Returns the number of ddllinkingtables where recordid = &#63; and recordsetid = &#63;.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @return the number of matching ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRecordsByRecordset(long recordid, long recordsetid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRecordsByRecordset(recordid, recordsetid);
	}

	/**
	* Caches the ddllinkingtable in the entity cache if it is enabled.
	*
	* @param ddllinkingtable the ddllinkingtable
	*/
	public static void cacheResult(
		at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable ddllinkingtable) {
		getPersistence().cacheResult(ddllinkingtable);
	}

	/**
	* Caches the ddllinkingtables in the entity cache if it is enabled.
	*
	* @param ddllinkingtables the ddllinkingtables
	*/
	public static void cacheResult(
		java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> ddllinkingtables) {
		getPersistence().cacheResult(ddllinkingtables);
	}

	/**
	* Creates a new ddllinkingtable with the primary key. Does not add the ddllinkingtable to the database.
	*
	* @param ddllinkingtable the primary key for the new ddllinkingtable
	* @return the new ddllinkingtable
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable create(
		long ddllinkingtable) {
		return getPersistence().create(ddllinkingtable);
	}

	/**
	* Removes the ddllinkingtable with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ddllinkingtable the primary key of the ddllinkingtable
	* @return the ddllinkingtable that was removed
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a ddllinkingtable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable remove(
		long ddllinkingtable)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(ddllinkingtable);
	}

	public static at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable updateImpl(
		at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable ddllinkingtable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ddllinkingtable);
	}

	/**
	* Returns the ddllinkingtable with the primary key or throws a {@link at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException} if it could not be found.
	*
	* @param ddllinkingtable the primary key of the ddllinkingtable
	* @return the ddllinkingtable
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a ddllinkingtable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable findByPrimaryKey(
		long ddllinkingtable)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(ddllinkingtable);
	}

	/**
	* Returns the ddllinkingtable with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ddllinkingtable the primary key of the ddllinkingtable
	* @return the ddllinkingtable, or <code>null</code> if a ddllinkingtable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable fetchByPrimaryKey(
		long ddllinkingtable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ddllinkingtable);
	}

	/**
	* Returns all the ddllinkingtables.
	*
	* @return the ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ddllinkingtables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.ddllinkingtableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ddllinkingtables
	* @param end the upper bound of the range of ddllinkingtables (not inclusive)
	* @return the range of ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ddllinkingtables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.ddllinkingtableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ddllinkingtables
	* @param end the upper bound of the range of ddllinkingtables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ddllinkingtables from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ddllinkingtables.
	*
	* @return the number of ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ddllinkingtablePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ddllinkingtablePersistence)PortletBeanLocatorUtil.locate(at.meduni.liferay.portlet.bbmriat.service.ClpSerializer.getServletContextName(),
					ddllinkingtablePersistence.class.getName());

			ReferenceRegistry.registerReference(ddllinkingtableUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ddllinkingtablePersistence persistence) {
	}

	private static ddllinkingtablePersistence _persistence;
}