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

import at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the fahrzeug service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see FahrzeugPersistenceImpl
 * @see FahrzeugUtil
 * @generated
 */
public interface FahrzeugPersistence extends BasePersistence<Fahrzeug> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FahrzeugUtil} to access the fahrzeug persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the fahrzeugs where typ = &#63;.
	*
	* @param typ the typ
	* @return the matching fahrzeugs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug> findByTyp(
		java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fahrzeugs where typ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.FahrzeugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typ the typ
	* @param start the lower bound of the range of fahrzeugs
	* @param end the upper bound of the range of fahrzeugs (not inclusive)
	* @return the range of matching fahrzeugs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug> findByTyp(
		java.lang.String typ, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fahrzeugs where typ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.FahrzeugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typ the typ
	* @param start the lower bound of the range of fahrzeugs
	* @param end the upper bound of the range of fahrzeugs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fahrzeugs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug> findByTyp(
		java.lang.String typ, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fahrzeug in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fahrzeug
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException if a matching fahrzeug could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug findByTyp_First(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first fahrzeug in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fahrzeug, or <code>null</code> if a matching fahrzeug could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug fetchByTyp_First(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fahrzeug in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fahrzeug
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException if a matching fahrzeug could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug findByTyp_Last(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last fahrzeug in the ordered set where typ = &#63;.
	*
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fahrzeug, or <code>null</code> if a matching fahrzeug could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug fetchByTyp_Last(
		java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fahrzeugs before and after the current fahrzeug in the ordered set where typ = &#63;.
	*
	* @param fahrzeugId the primary key of the current fahrzeug
	* @param typ the typ
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fahrzeug
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException if a fahrzeug with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug[] findByTyp_PrevAndNext(
		long fahrzeugId, java.lang.String typ,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fahrzeugs where typ = &#63; from the database.
	*
	* @param typ the typ
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTyp(java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fahrzeugs where typ = &#63;.
	*
	* @param typ the typ
	* @return the number of matching fahrzeugs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTyp(java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the fahrzeug in the entity cache if it is enabled.
	*
	* @param fahrzeug the fahrzeug
	*/
	public void cacheResult(
		at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug fahrzeug);

	/**
	* Caches the fahrzeugs in the entity cache if it is enabled.
	*
	* @param fahrzeugs the fahrzeugs
	*/
	public void cacheResult(
		java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug> fahrzeugs);

	/**
	* Creates a new fahrzeug with the primary key. Does not add the fahrzeug to the database.
	*
	* @param fahrzeugId the primary key for the new fahrzeug
	* @return the new fahrzeug
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug create(
		long fahrzeugId);

	/**
	* Removes the fahrzeug with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fahrzeugId the primary key of the fahrzeug
	* @return the fahrzeug that was removed
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException if a fahrzeug with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug remove(
		long fahrzeugId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug fahrzeug)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fahrzeug with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException} if it could not be found.
	*
	* @param fahrzeugId the primary key of the fahrzeug
	* @return the fahrzeug
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException if a fahrzeug with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug findByPrimaryKey(
		long fahrzeugId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchFahrzeugException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fahrzeug with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fahrzeugId the primary key of the fahrzeug
	* @return the fahrzeug, or <code>null</code> if a fahrzeug with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug fetchByPrimaryKey(
		long fahrzeugId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fahrzeugs.
	*
	* @return the fahrzeugs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fahrzeugs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.FahrzeugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fahrzeugs
	* @param end the upper bound of the range of fahrzeugs (not inclusive)
	* @return the range of fahrzeugs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fahrzeugs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.FahrzeugModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fahrzeugs
	* @param end the upper bound of the range of fahrzeugs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fahrzeugs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fahrzeugs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fahrzeugs.
	*
	* @return the number of fahrzeugs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}