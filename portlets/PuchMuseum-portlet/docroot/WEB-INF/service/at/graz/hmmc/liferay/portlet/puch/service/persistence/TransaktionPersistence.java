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

import at.graz.hmmc.liferay.portlet.puch.model.Transaktion;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the transaktion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see TransaktionPersistenceImpl
 * @see TransaktionUtil
 * @generated
 */
public interface TransaktionPersistence extends BasePersistence<Transaktion> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TransaktionUtil} to access the transaktion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the transaktions where typ = &#63;.
	*
	* @param typ the typ
	* @return the matching transaktions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> findByTyp(
		java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the transaktions where typ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typ the typ
	* @param start the lower bound of the range of transaktions
	* @param end the upper bound of the range of transaktions (not inclusive)
	* @return the range of matching transaktions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> findByTyp(
		java.lang.String typ, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the transaktions where typ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typ the typ
	* @param start the lower bound of the range of transaktions
	* @param end the upper bound of the range of transaktions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching transaktions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> findByTyp(
		java.lang.String typ, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first transaktion in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching transaktion
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a matching transaktion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion findByTyp_First(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first transaktion in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching transaktion, or <code>null</code> if a matching transaktion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion fetchByTyp_First(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last transaktion in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching transaktion
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a matching transaktion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion findByTyp_Last(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last transaktion in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching transaktion, or <code>null</code> if a matching transaktion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion fetchByTyp_Last(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the transaktions before and after the current transaktion in the ordered set where typ = &#63;.
	*
	* @param transaktionId the primary key of the current transaktion
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next transaktion
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a transaktion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion[] findByTyp_PrevAndNext(
		long transaktionId, java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the transaktions where typ = &#63; from the database.
	*
	* @param typ the typ
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTyp(java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of transaktions where typ = &#63;.
	*
	* @param typ the typ
	* @return the number of matching transaktions
	* @throws SystemException if a system exception occurred
	*/
	public int countByTyp(java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the transaktion in the entity cache if it is enabled.
	*
	* @param transaktion the transaktion
	*/
	public void cacheResult(
		at.graz.hmmc.liferay.portlet.puch.model.Transaktion transaktion);

	/**
	* Caches the transaktions in the entity cache if it is enabled.
	*
	* @param transaktions the transaktions
	*/
	public void cacheResult(
		java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> transaktions);

	/**
	* Creates a new transaktion with the primary key. Does not add the transaktion to the database.
	*
	* @param transaktionId the primary key for the new transaktion
	* @return the new transaktion
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion create(
		long transaktionId);

	/**
	* Removes the transaktion with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transaktionId the primary key of the transaktion
	* @return the transaktion that was removed
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a transaktion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion remove(
		long transaktionId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.Transaktion transaktion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the transaktion with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException} if it could not be found.
	*
	* @param transaktionId the primary key of the transaktion
	* @return the transaktion
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a transaktion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion findByPrimaryKey(
		long transaktionId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the transaktion with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param transaktionId the primary key of the transaktion
	* @return the transaktion, or <code>null</code> if a transaktion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion fetchByPrimaryKey(
		long transaktionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the transaktions.
	*
	* @return the transaktions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the transaktions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of transaktions
	* @param end the upper bound of the range of transaktions (not inclusive)
	* @return the range of transaktions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the transaktions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of transaktions
	* @param end the upper bound of the range of transaktions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of transaktions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the transaktions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of transaktions.
	*
	* @return the number of transaktions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}