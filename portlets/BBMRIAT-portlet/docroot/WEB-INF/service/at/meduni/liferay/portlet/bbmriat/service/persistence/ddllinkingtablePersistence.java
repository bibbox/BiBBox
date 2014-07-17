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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the d d l linking table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see DDLLinkingTablePersistenceImpl
 * @see DDLLinkingTableUtil
 * @generated
 */
public interface DDLLinkingTablePersistence extends BasePersistence<DDLLinkingTable> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DDLLinkingTableUtil} to access the d d l linking table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the d d l linking tables where recordid = &#63;.
	*
	* @param recordid the recordid
	* @return the matching d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findByRecordid(
		long recordid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findByRecordid(
		long recordid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findByRecordid(
		long recordid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d d l linking table in the ordered set where recordid = &#63;.
	*
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d d l linking table
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a matching d d l linking table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable findByRecordid_First(
		long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d d l linking table in the ordered set where recordid = &#63;.
	*
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d d l linking table, or <code>null</code> if a matching d d l linking table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable fetchByRecordid_First(
		long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d d l linking table in the ordered set where recordid = &#63;.
	*
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d d l linking table
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a matching d d l linking table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable findByRecordid_Last(
		long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d d l linking table in the ordered set where recordid = &#63;.
	*
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d d l linking table, or <code>null</code> if a matching d d l linking table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable fetchByRecordid_Last(
		long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable[] findByRecordid_PrevAndNext(
		long ddllinkingtable, long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the d d l linking tables where recordid = &#63; from the database.
	*
	* @param recordid the recordid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRecordid(long recordid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d d l linking tables where recordid = &#63;.
	*
	* @param recordid the recordid
	* @return the number of matching d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public int countByRecordid(long recordid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the d d l linking tables where recordid = &#63; and recordsetid = &#63;.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @return the matching d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findByRecordsByRecordset(
		long recordid, long recordsetid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findByRecordsByRecordset(
		long recordid, long recordsetid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findByRecordsByRecordset(
		long recordid, long recordsetid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable findByRecordsByRecordset_First(
		long recordid, long recordsetid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first d d l linking table in the ordered set where recordid = &#63; and recordsetid = &#63;.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching d d l linking table, or <code>null</code> if a matching d d l linking table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable fetchByRecordsByRecordset_First(
		long recordid, long recordsetid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable findByRecordsByRecordset_Last(
		long recordid, long recordsetid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last d d l linking table in the ordered set where recordid = &#63; and recordsetid = &#63;.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching d d l linking table, or <code>null</code> if a matching d d l linking table could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable fetchByRecordsByRecordset_Last(
		long recordid, long recordsetid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable[] findByRecordsByRecordset_PrevAndNext(
		long ddllinkingtable, long recordid, long recordsetid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the d d l linking tables where recordid = &#63; and recordsetid = &#63; from the database.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRecordsByRecordset(long recordid, long recordsetid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d d l linking tables where recordid = &#63; and recordsetid = &#63;.
	*
	* @param recordid the recordid
	* @param recordsetid the recordsetid
	* @return the number of matching d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public int countByRecordsByRecordset(long recordid, long recordsetid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the d d l linking table in the entity cache if it is enabled.
	*
	* @param ddlLinkingTable the d d l linking table
	*/
	public void cacheResult(
		at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable ddlLinkingTable);

	/**
	* Caches the d d l linking tables in the entity cache if it is enabled.
	*
	* @param ddlLinkingTables the d d l linking tables
	*/
	public void cacheResult(
		java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> ddlLinkingTables);

	/**
	* Creates a new d d l linking table with the primary key. Does not add the d d l linking table to the database.
	*
	* @param ddllinkingtable the primary key for the new d d l linking table
	* @return the new d d l linking table
	*/
	public at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable create(
		long ddllinkingtable);

	/**
	* Removes the d d l linking table with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ddllinkingtable the primary key of the d d l linking table
	* @return the d d l linking table that was removed
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a d d l linking table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable remove(
		long ddllinkingtable)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable updateImpl(
		at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable ddlLinkingTable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d d l linking table with the primary key or throws a {@link at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException} if it could not be found.
	*
	* @param ddllinkingtable the primary key of the d d l linking table
	* @return the d d l linking table
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException if a d d l linking table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable findByPrimaryKey(
		long ddllinkingtable)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchDDLLinkingTableException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the d d l linking table with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ddllinkingtable the primary key of the d d l linking table
	* @return the d d l linking table, or <code>null</code> if a d d l linking table with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable fetchByPrimaryKey(
		long ddllinkingtable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the d d l linking tables.
	*
	* @return the d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.bbmriat.model.DDLLinkingTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the d d l linking tables from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of d d l linking tables.
	*
	* @return the number of d d l linking tables
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}