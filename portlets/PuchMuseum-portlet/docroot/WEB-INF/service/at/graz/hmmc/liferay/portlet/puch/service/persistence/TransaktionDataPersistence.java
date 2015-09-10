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

package at.graz.hmmc.liferay.portlet.puch.service.persistence;

import at.graz.hmmc.liferay.portlet.puch.model.TransaktionData;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the transaktion data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see TransaktionDataPersistenceImpl
 * @see TransaktionDataUtil
 * @generated
 */
public interface TransaktionDataPersistence extends BasePersistence<TransaktionData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TransaktionDataUtil} to access the transaktion data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the transaktion datas where transaktionId = &#63;.
	*
	* @param transaktionId the transaktion ID
	* @return the matching transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.TransaktionData> findByTransaction(
		long transaktionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the transaktion datas where transaktionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param transaktionId the transaktion ID
	* @param start the lower bound of the range of transaktion datas
	* @param end the upper bound of the range of transaktion datas (not inclusive)
	* @return the range of matching transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.TransaktionData> findByTransaction(
		long transaktionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the transaktion datas where transaktionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param transaktionId the transaktion ID
	* @param start the lower bound of the range of transaktion datas
	* @param end the upper bound of the range of transaktion datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.TransaktionData> findByTransaction(
		long transaktionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first transaktion data in the ordered set where transaktionId = &#63;.
	*
	* @param transaktionId the transaktion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching transaktion data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a matching transaktion data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData findByTransaction_First(
		long transaktionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first transaktion data in the ordered set where transaktionId = &#63;.
	*
	* @param transaktionId the transaktion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching transaktion data, or <code>null</code> if a matching transaktion data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData fetchByTransaction_First(
		long transaktionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last transaktion data in the ordered set where transaktionId = &#63;.
	*
	* @param transaktionId the transaktion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching transaktion data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a matching transaktion data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData findByTransaction_Last(
		long transaktionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last transaktion data in the ordered set where transaktionId = &#63;.
	*
	* @param transaktionId the transaktion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching transaktion data, or <code>null</code> if a matching transaktion data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData fetchByTransaction_Last(
		long transaktionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the transaktion datas before and after the current transaktion data in the ordered set where transaktionId = &#63;.
	*
	* @param transaktiondataId the primary key of the current transaktion data
	* @param transaktionId the transaktion ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next transaktion data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a transaktion data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData[] findByTransaction_PrevAndNext(
		long transaktiondataId, long transaktionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the transaktion datas where transaktionId = &#63; from the database.
	*
	* @param transaktionId the transaktion ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTransaction(long transaktionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of transaktion datas where transaktionId = &#63;.
	*
	* @param transaktionId the transaktion ID
	* @return the number of matching transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByTransaction(long transaktionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the transaktion data where transaktionId = &#63; and objectkey = &#63; or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException} if it could not be found.
	*
	* @param transaktionId the transaktion ID
	* @param objectkey the objectkey
	* @return the matching transaktion data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a matching transaktion data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData findByDataByOntology(
		long transaktionId, java.lang.String objectkey)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the transaktion data where transaktionId = &#63; and objectkey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param transaktionId the transaktion ID
	* @param objectkey the objectkey
	* @return the matching transaktion data, or <code>null</code> if a matching transaktion data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData fetchByDataByOntology(
		long transaktionId, java.lang.String objectkey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the transaktion data where transaktionId = &#63; and objectkey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param transaktionId the transaktion ID
	* @param objectkey the objectkey
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching transaktion data, or <code>null</code> if a matching transaktion data could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData fetchByDataByOntology(
		long transaktionId, java.lang.String objectkey,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the transaktion data where transaktionId = &#63; and objectkey = &#63; from the database.
	*
	* @param transaktionId the transaktion ID
	* @param objectkey the objectkey
	* @return the transaktion data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData removeByDataByOntology(
		long transaktionId, java.lang.String objectkey)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of transaktion datas where transaktionId = &#63; and objectkey = &#63;.
	*
	* @param transaktionId the transaktion ID
	* @param objectkey the objectkey
	* @return the number of matching transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public int countByDataByOntology(long transaktionId,
		java.lang.String objectkey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the transaktion data in the entity cache if it is enabled.
	*
	* @param transaktionData the transaktion data
	*/
	public void cacheResult(
		at.graz.hmmc.liferay.portlet.puch.model.TransaktionData transaktionData);

	/**
	* Caches the transaktion datas in the entity cache if it is enabled.
	*
	* @param transaktionDatas the transaktion datas
	*/
	public void cacheResult(
		java.util.List<at.graz.hmmc.liferay.portlet.puch.model.TransaktionData> transaktionDatas);

	/**
	* Creates a new transaktion data with the primary key. Does not add the transaktion data to the database.
	*
	* @param transaktiondataId the primary key for the new transaktion data
	* @return the new transaktion data
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData create(
		long transaktiondataId);

	/**
	* Removes the transaktion data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transaktiondataId the primary key of the transaktion data
	* @return the transaktion data that was removed
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a transaktion data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData remove(
		long transaktiondataId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.TransaktionData transaktionData)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the transaktion data with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException} if it could not be found.
	*
	* @param transaktiondataId the primary key of the transaktion data
	* @return the transaktion data
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException if a transaktion data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData findByPrimaryKey(
		long transaktiondataId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionDataException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the transaktion data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param transaktiondataId the primary key of the transaktion data
	* @return the transaktion data, or <code>null</code> if a transaktion data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData fetchByPrimaryKey(
		long transaktiondataId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the transaktion datas.
	*
	* @return the transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.TransaktionData> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the transaktion datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of transaktion datas
	* @param end the upper bound of the range of transaktion datas (not inclusive)
	* @return the range of transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.TransaktionData> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the transaktion datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of transaktion datas
	* @param end the upper bound of the range of transaktion datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.TransaktionData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the transaktion datas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of transaktion datas.
	*
	* @return the number of transaktion datas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}