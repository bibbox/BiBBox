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

import at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the d d l linking table service. This utility wraps {@link DDLLinkingTablePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see DDLLinkingTablePersistence
 * @see DDLLinkingTablePersistenceImpl
 * @generated
 */
public class DDLLinkingTableUtil {
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
	public static void clearCache(DDLLinkingTable ddlLinkingTable) {
		getPersistence().clearCache(ddlLinkingTable);
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
	public static List<DDLLinkingTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DDLLinkingTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DDLLinkingTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DDLLinkingTable update(DDLLinkingTable ddlLinkingTable)
		throws SystemException {
		return getPersistence().update(ddlLinkingTable);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DDLLinkingTable update(DDLLinkingTable ddlLinkingTable,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ddlLinkingTable, serviceContext);
	}

	/**
	* Returns all the d d l linking tables where recordid = &#63;.
	*
	* @param recordid the recordid
	* @return the matching d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findByRecordid(
		long recordid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRecordid(recordid);
	}

	/**
	* Returns a range of all the d d l linking tables where recordid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.DDLLinkingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recordid the recordid
	* @param start the lower bound of the range of d d l linking tables
	* @param end the upper bound of the range of d d l linking tables (not inclusive)
	* @return the range of matching d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findByRecordid(
		long recordid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRecordid(recordid, start, end);
	}

	/**
	* Returns an ordered range of all the d d l linking tables where recordid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.DDLLinkingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recordid the recordid
	* @param start the lower bound of the range of d d l linking tables
	* @param end the upper bound of the range of d d l linking tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findByRecordid(
		long recordid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRecordid(recordid, start, end, orderByComparator);
	}

	/**
	* Returns the first d d l linking table in the ordered set where recordid = &#63;.
	*
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d d l linking table
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a matching d d l linking table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable findByRecordid_First(
		long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRecordid_First(recordid, orderByComparator);
	}

	/**
	* Returns the first d d l linking table in the ordered set where recordid = &#63;.
	*
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d d l linking table, or <code>null</code> if a matching d d l linking table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable fetchByRecordid_First(
		long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRecordid_First(recordid, orderByComparator);
	}

	/**
	* Returns the last d d l linking table in the ordered set where recordid = &#63;.
	*
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d d l linking table
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a matching d d l linking table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable findByRecordid_Last(
		long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRecordid_Last(recordid, orderByComparator);
	}

	/**
	* Returns the last d d l linking table in the ordered set where recordid = &#63;.
	*
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d d l linking table, or <code>null</code> if a matching d d l linking table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable fetchByRecordid_Last(
		long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRecordid_Last(recordid, orderByComparator);
	}

	/**
	* Returns the d d l linking tables before and after the current d d l linking table in the ordered set where recordid = &#63;.
	*
	* @param ddllinkingtable the primary key of the current d d l linking table
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next d d l linking table
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a d d l linking table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable[] findByRecordid_PrevAndNext(
		long ddllinkingtable, long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRecordid_PrevAndNext(ddllinkingtable, recordid,
			orderByComparator);
	}

	/**
	* Removes all the d d l linking tables where recordid = &#63; from the database.
	*
	* @param recordid the recordid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRecordid(long recordid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRecordid(recordid);
	}

	/**
	* Returns the number of d d l linking tables where recordid = &#63;.
	*
	* @param recordid the recordid
	* @return the number of matching d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRecordid(long recordid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRecordid(recordid);
	}

	/**
	* Returns all the d d l linking tables where recordid = &#63; and recordsetid = &#63;.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @return the matching d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findByRecordsByRecordset(
		long recordid, long recordsetid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRecordsByRecordset(recordid, recordsetid);
	}

	/**
	* Returns a range of all the d d l linking tables where recordid = &#63; and recordsetid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.DDLLinkingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @param start the lower bound of the range of d d l linking tables
	* @param end the upper bound of the range of d d l linking tables (not inclusive)
	* @return the range of matching d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findByRecordsByRecordset(
		long recordid, long recordsetid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRecordsByRecordset(recordid, recordsetid, start, end);
	}

	/**
	* Returns an ordered range of all the d d l linking tables where recordid = &#63; and recordsetid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.DDLLinkingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @param start the lower bound of the range of d d l linking tables
	* @param end the upper bound of the range of d d l linking tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findByRecordsByRecordset(
		long recordid, long recordsetid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRecordsByRecordset(recordid, recordsetid, start, end,
			orderByComparator);
	}

	/**
	* Returns the first d d l linking table in the ordered set where recordid = &#63; and recordsetid = &#63;.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d d l linking table
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a matching d d l linking table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable findByRecordsByRecordset_First(
		long recordid, long recordsetid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRecordsByRecordset_First(recordid, recordsetid,
			orderByComparator);
	}

	/**
	* Returns the first d d l linking table in the ordered set where recordid = &#63; and recordsetid = &#63;.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d d l linking table, or <code>null</code> if a matching d d l linking table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable fetchByRecordsByRecordset_First(
		long recordid, long recordsetid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRecordsByRecordset_First(recordid, recordsetid,
			orderByComparator);
	}

	/**
	* Returns the last d d l linking table in the ordered set where recordid = &#63; and recordsetid = &#63;.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d d l linking table
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a matching d d l linking table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable findByRecordsByRecordset_Last(
		long recordid, long recordsetid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRecordsByRecordset_Last(recordid, recordsetid,
			orderByComparator);
	}

	/**
	* Returns the last d d l linking table in the ordered set where recordid = &#63; and recordsetid = &#63;.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d d l linking table, or <code>null</code> if a matching d d l linking table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable fetchByRecordsByRecordset_Last(
		long recordid, long recordsetid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRecordsByRecordset_Last(recordid, recordsetid,
			orderByComparator);
	}

	/**
	* Returns the d d l linking tables before and after the current d d l linking table in the ordered set where recordid = &#63; and recordsetid = &#63;.
	*
	* @param ddllinkingtable the primary key of the current d d l linking table
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next d d l linking table
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a d d l linking table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable[] findByRecordsByRecordset_PrevAndNext(
		long ddllinkingtable, long recordid, long recordsetid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRecordsByRecordset_PrevAndNext(ddllinkingtable,
			recordid, recordsetid, orderByComparator);
	}

	/**
	* Removes all the d d l linking tables where recordid = &#63; and recordsetid = &#63; from the database.
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
	* Returns the number of d d l linking tables where recordid = &#63; and recordsetid = &#63;.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @return the number of matching d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRecordsByRecordset(long recordid, long recordsetid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRecordsByRecordset(recordid, recordsetid);
	}

	/**
	* Caches the d d l linking table in the entity cache if it is enabled.
	*
	* @param ddlLinkingTable the d d l linking table
	*/
	public static void cacheResult(
		at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable ddlLinkingTable) {
		getPersistence().cacheResult(ddlLinkingTable);
	}

	/**
	* Caches the d d l linking tables in the entity cache if it is enabled.
	*
	* @param ddlLinkingTables the d d l linking tables
	*/
	public static void cacheResult(
		java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> ddlLinkingTables) {
		getPersistence().cacheResult(ddlLinkingTables);
	}

	/**
	* Creates a new d d l linking table with the primary key. Does not add the d d l linking table to the database.
	*
	* @param ddllinkingtable the primary key for the new d d l linking table
	* @return the new d d l linking table
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable create(
		long ddllinkingtable) {
		return getPersistence().create(ddllinkingtable);
	}

	/**
	* Removes the d d l linking table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ddllinkingtable the primary key of the d d l linking table
	* @return the d d l linking table that was removed
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a d d l linking table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable remove(
		long ddllinkingtable)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(ddllinkingtable);
	}

	public static at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable updateImpl(
		at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable ddlLinkingTable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ddlLinkingTable);
	}

	/**
	* Returns the d d l linking table with the primary key or throws a {@link at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException} if it could not be found.
	*
	* @param ddllinkingtable the primary key of the d d l linking table
	* @return the d d l linking table
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a d d l linking table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable findByPrimaryKey(
		long ddllinkingtable)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(ddllinkingtable);
	}

	/**
	* Returns the d d l linking table with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ddllinkingtable the primary key of the d d l linking table
	* @return the d d l linking table, or <code>null</code> if a d d l linking table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable fetchByPrimaryKey(
		long ddllinkingtable)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ddllinkingtable);
	}

	/**
	* Returns all the d d l linking tables.
	*
	* @return the d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the d d l linking tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.DDLLinkingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of d d l linking tables
	* @param end the upper bound of the range of d d l linking tables (not inclusive)
	* @return the range of d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the d d l linking tables.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmriat.model.impl.DDLLinkingTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of d d l linking tables
	* @param end the upper bound of the range of d d l linking tables (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the d d l linking tables from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of d d l linking tables.
	*
	* @return the number of d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DDLLinkingTablePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DDLLinkingTablePersistence)PortletBeanLocatorUtil.locate(at.meduni.liferay.portlet.bbmriat.service.ClpSerializer.getServletContextName(),
					DDLLinkingTablePersistence.class.getName());

			ReferenceRegistry.registerReference(DDLLinkingTableUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DDLLinkingTablePersistence persistence) {
	}

	private static DDLLinkingTablePersistence _persistence;
}