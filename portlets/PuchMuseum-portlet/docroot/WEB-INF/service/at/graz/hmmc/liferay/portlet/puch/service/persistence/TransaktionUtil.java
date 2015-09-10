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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the transaktion service. This utility wraps {@link TransaktionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see TransaktionPersistence
 * @see TransaktionPersistenceImpl
 * @generated
 */
public class TransaktionUtil {
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
	public static void clearCache(Transaktion transaktion) {
		getPersistence().clearCache(transaktion);
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
	public static List<Transaktion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Transaktion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Transaktion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Transaktion update(Transaktion transaktion)
		throws SystemException {
		return getPersistence().update(transaktion);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Transaktion update(Transaktion transaktion,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(transaktion, serviceContext);
	}

	/**
	* Returns all the transaktions where typ = &#63;.
	*
	* @param typ the typ
	* @return the matching transaktions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> findByTyp(
		java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTyp(typ);
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> findByTyp(
		java.lang.String typ, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTyp(typ, start, end);
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> findByTyp(
		java.lang.String typ, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTyp(typ, start, end, orderByComparator);
	}

	/**
	* Returns the first transaktion in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching transaktion
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a matching transaktion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Transaktion findByTyp_First(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTyp_First(typ, orderByComparator);
	}

	/**
	* Returns the first transaktion in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching transaktion, or <code>null</code> if a matching transaktion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Transaktion fetchByTyp_First(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTyp_First(typ, orderByComparator);
	}

	/**
	* Returns the last transaktion in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching transaktion
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a matching transaktion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Transaktion findByTyp_Last(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTyp_Last(typ, orderByComparator);
	}

	/**
	* Returns the last transaktion in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching transaktion, or <code>null</code> if a matching transaktion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Transaktion fetchByTyp_Last(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTyp_Last(typ, orderByComparator);
	}

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
	public static at.graz.hmmc.liferay.portlet.puch.model.Transaktion[] findByTyp_PrevAndNext(
		long transaktionId, java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTyp_PrevAndNext(transaktionId, typ, orderByComparator);
	}

	/**
	* Removes all the transaktions where typ = &#63; from the database.
	*
	* @param typ the typ
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTyp(java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTyp(typ);
	}

	/**
	* Returns the number of transaktions where typ = &#63;.
	*
	* @param typ the typ
	* @return the number of matching transaktions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTyp(java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTyp(typ);
	}

	/**
	* Returns all the transaktions where typ = &#63; and puchmuseumsobjectId = &#63;.
	*
	* @param typ the typ
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @return the matching transaktions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> findByTypAndObject(
		java.lang.String typ, long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTypAndObject(typ, puchmuseumsobjectId);
	}

	/**
	* Returns a range of all the transaktions where typ = &#63; and puchmuseumsobjectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typ the typ
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param start the lower bound of the range of transaktions
	* @param end the upper bound of the range of transaktions (not inclusive)
	* @return the range of matching transaktions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> findByTypAndObject(
		java.lang.String typ, long puchmuseumsobjectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypAndObject(typ, puchmuseumsobjectId, start, end);
	}

	/**
	* Returns an ordered range of all the transaktions where typ = &#63; and puchmuseumsobjectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typ the typ
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param start the lower bound of the range of transaktions
	* @param end the upper bound of the range of transaktions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching transaktions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> findByTypAndObject(
		java.lang.String typ, long puchmuseumsobjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypAndObject(typ, puchmuseumsobjectId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first transaktion in the ordered set where typ = &#63; and puchmuseumsobjectId = &#63;.
	*
	* @param typ the typ
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching transaktion
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a matching transaktion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Transaktion findByTypAndObject_First(
		java.lang.String typ, long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypAndObject_First(typ, puchmuseumsobjectId,
			orderByComparator);
	}

	/**
	* Returns the first transaktion in the ordered set where typ = &#63; and puchmuseumsobjectId = &#63;.
	*
	* @param typ the typ
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching transaktion, or <code>null</code> if a matching transaktion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Transaktion fetchByTypAndObject_First(
		java.lang.String typ, long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypAndObject_First(typ, puchmuseumsobjectId,
			orderByComparator);
	}

	/**
	* Returns the last transaktion in the ordered set where typ = &#63; and puchmuseumsobjectId = &#63;.
	*
	* @param typ the typ
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching transaktion
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a matching transaktion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Transaktion findByTypAndObject_Last(
		java.lang.String typ, long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypAndObject_Last(typ, puchmuseumsobjectId,
			orderByComparator);
	}

	/**
	* Returns the last transaktion in the ordered set where typ = &#63; and puchmuseumsobjectId = &#63;.
	*
	* @param typ the typ
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching transaktion, or <code>null</code> if a matching transaktion could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Transaktion fetchByTypAndObject_Last(
		java.lang.String typ, long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypAndObject_Last(typ, puchmuseumsobjectId,
			orderByComparator);
	}

	/**
	* Returns the transaktions before and after the current transaktion in the ordered set where typ = &#63; and puchmuseumsobjectId = &#63;.
	*
	* @param transaktionId the primary key of the current transaktion
	* @param typ the typ
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next transaktion
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a transaktion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Transaktion[] findByTypAndObject_PrevAndNext(
		long transaktionId, java.lang.String typ, long puchmuseumsobjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypAndObject_PrevAndNext(transaktionId, typ,
			puchmuseumsobjectId, orderByComparator);
	}

	/**
	* Removes all the transaktions where typ = &#63; and puchmuseumsobjectId = &#63; from the database.
	*
	* @param typ the typ
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTypAndObject(java.lang.String typ,
		long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTypAndObject(typ, puchmuseumsobjectId);
	}

	/**
	* Returns the number of transaktions where typ = &#63; and puchmuseumsobjectId = &#63;.
	*
	* @param typ the typ
	* @param puchmuseumsobjectId the puchmuseumsobject ID
	* @return the number of matching transaktions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypAndObject(java.lang.String typ,
		long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTypAndObject(typ, puchmuseumsobjectId);
	}

	/**
	* Caches the transaktion in the entity cache if it is enabled.
	*
	* @param transaktion the transaktion
	*/
	public static void cacheResult(
		at.graz.hmmc.liferay.portlet.puch.model.Transaktion transaktion) {
		getPersistence().cacheResult(transaktion);
	}

	/**
	* Caches the transaktions in the entity cache if it is enabled.
	*
	* @param transaktions the transaktions
	*/
	public static void cacheResult(
		java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> transaktions) {
		getPersistence().cacheResult(transaktions);
	}

	/**
	* Creates a new transaktion with the primary key. Does not add the transaktion to the database.
	*
	* @param transaktionId the primary key for the new transaktion
	* @return the new transaktion
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Transaktion create(
		long transaktionId) {
		return getPersistence().create(transaktionId);
	}

	/**
	* Removes the transaktion with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transaktionId the primary key of the transaktion
	* @return the transaktion that was removed
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a transaktion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Transaktion remove(
		long transaktionId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(transaktionId);
	}

	public static at.graz.hmmc.liferay.portlet.puch.model.Transaktion updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.Transaktion transaktion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(transaktion);
	}

	/**
	* Returns the transaktion with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException} if it could not be found.
	*
	* @param transaktionId the primary key of the transaktion
	* @return the transaktion
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException if a transaktion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Transaktion findByPrimaryKey(
		long transaktionId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(transaktionId);
	}

	/**
	* Returns the transaktion with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param transaktionId the primary key of the transaktion
	* @return the transaktion, or <code>null</code> if a transaktion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Transaktion fetchByPrimaryKey(
		long transaktionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(transaktionId);
	}

	/**
	* Returns all the transaktions.
	*
	* @return the transaktions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the transaktions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of transaktions.
	*
	* @return the number of transaktions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TransaktionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TransaktionPersistence)PortletBeanLocatorUtil.locate(at.graz.hmmc.liferay.portlet.puch.service.ClpSerializer.getServletContextName(),
					TransaktionPersistence.class.getName());

			ReferenceRegistry.registerReference(TransaktionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TransaktionPersistence persistence) {
	}

	private static TransaktionPersistence _persistence;
}