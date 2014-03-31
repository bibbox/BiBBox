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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the ddllinkingtable service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see ddllinkingtablePersistenceImpl
 * @see ddllinkingtableUtil
 * @generated
 */
public interface ddllinkingtablePersistence extends BasePersistence<ddllinkingtable> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ddllinkingtableUtil} to access the ddllinkingtable persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the ddllinkingtables where recordid = &#63;.
	*
	* @param recordid the recordid
	* @return the matching ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> findByRecordid(
		long recordid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> findByRecordid(
		long recordid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> findByRecordid(
		long recordid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ddllinkingtable in the ordered set where recordid = &#63;.
	*
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ddllinkingtable
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a matching ddllinkingtable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable findByRecordid_First(
		long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ddllinkingtable in the ordered set where recordid = &#63;.
	*
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ddllinkingtable, or <code>null</code> if a matching ddllinkingtable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable fetchByRecordid_First(
		long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ddllinkingtable in the ordered set where recordid = &#63;.
	*
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ddllinkingtable
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a matching ddllinkingtable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable findByRecordid_Last(
		long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ddllinkingtable in the ordered set where recordid = &#63;.
	*
	* @param recordid the recordid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ddllinkingtable, or <code>null</code> if a matching ddllinkingtable could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable fetchByRecordid_Last(
		long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable[] findByRecordid_PrevAndNext(
		long ddllinkingtable, long recordid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ddllinkingtables where recordid = &#63; from the database.
	*
	* @param recordid the recordid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRecordid(long recordid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ddllinkingtables where recordid = &#63;.
	*
	* @param recordid the recordid
	* @return the number of matching ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	public int countByRecordid(long recordid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the ddllinkingtable in the entity cache if it is enabled.
	*
	* @param ddllinkingtable the ddllinkingtable
	*/
	public void cacheResult(
		at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable ddllinkingtable);

	/**
	* Caches the ddllinkingtables in the entity cache if it is enabled.
	*
	* @param ddllinkingtables the ddllinkingtables
	*/
	public void cacheResult(
		java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> ddllinkingtables);

	/**
	* Creates a new ddllinkingtable with the primary key. Does not add the ddllinkingtable to the database.
	*
	* @param ddllinkingtable the primary key for the new ddllinkingtable
	* @return the new ddllinkingtable
	*/
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable create(
		long ddllinkingtable);

	/**
	* Removes the ddllinkingtable with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ddllinkingtable the primary key of the ddllinkingtable
	* @return the ddllinkingtable that was removed
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a ddllinkingtable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable remove(
		long ddllinkingtable)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable updateImpl(
		at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable ddllinkingtable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ddllinkingtable with the primary key or throws a {@link at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException} if it could not be found.
	*
	* @param ddllinkingtable the primary key of the ddllinkingtable
	* @return the ddllinkingtable
	* @throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException if a ddllinkingtable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable findByPrimaryKey(
		long ddllinkingtable)
		throws at.meduni.liferay.portlet.bbmriat.NoSuchddllinkingtableException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ddllinkingtable with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ddllinkingtable the primary key of the ddllinkingtable
	* @return the ddllinkingtable, or <code>null</code> if a ddllinkingtable with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable fetchByPrimaryKey(
		long ddllinkingtable)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ddllinkingtables.
	*
	* @return the ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.bbmriat.model.ddllinkingtable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ddllinkingtables from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ddllinkingtables.
	*
	* @return the number of ddllinkingtables
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}