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

import at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the puch museums objekt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see PuchMuseumsObjektPersistenceImpl
 * @see PuchMuseumsObjektUtil
 * @generated
 */
public interface PuchMuseumsObjektPersistence extends BasePersistence<PuchMuseumsObjekt> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PuchMuseumsObjektUtil} to access the puch museums objekt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the puch museums objekt in the entity cache if it is enabled.
	*
	* @param puchMuseumsObjekt the puch museums objekt
	*/
	public void cacheResult(
		at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt puchMuseumsObjekt);

	/**
	* Caches the puch museums objekts in the entity cache if it is enabled.
	*
	* @param puchMuseumsObjekts the puch museums objekts
	*/
	public void cacheResult(
		java.util.List<at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt> puchMuseumsObjekts);

	/**
	* Creates a new puch museums objekt with the primary key. Does not add the puch museums objekt to the database.
	*
	* @param puchmuseumsobjectId the primary key for the new puch museums objekt
	* @return the new puch museums objekt
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt create(
		long puchmuseumsobjectId);

	/**
	* Removes the puch museums objekt with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param puchmuseumsobjectId the primary key of the puch museums objekt
	* @return the puch museums objekt that was removed
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException if a puch museums objekt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt remove(
		long puchmuseumsobjectId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt puchMuseumsObjekt)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the puch museums objekt with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException} if it could not be found.
	*
	* @param puchmuseumsobjectId the primary key of the puch museums objekt
	* @return the puch museums objekt
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException if a puch museums objekt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt findByPrimaryKey(
		long puchmuseumsobjectId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the puch museums objekt with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param puchmuseumsobjectId the primary key of the puch museums objekt
	* @return the puch museums objekt, or <code>null</code> if a puch museums objekt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt fetchByPrimaryKey(
		long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the puch museums objekts.
	*
	* @return the puch museums objekts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the puch museums objekts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.PuchMuseumsObjektModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of puch museums objekts
	* @param end the upper bound of the range of puch museums objekts (not inclusive)
	* @return the range of puch museums objekts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the puch museums objekts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.PuchMuseumsObjektModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of puch museums objekts
	* @param end the upper bound of the range of puch museums objekts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of puch museums objekts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the puch museums objekts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of puch museums objekts.
	*
	* @return the number of puch museums objekts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}