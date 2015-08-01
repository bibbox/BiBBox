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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the puch museums objekt service. This utility wraps {@link PuchMuseumsObjektPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see PuchMuseumsObjektPersistence
 * @see PuchMuseumsObjektPersistenceImpl
 * @generated
 */
public class PuchMuseumsObjektUtil {
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
	public static void clearCache(PuchMuseumsObjekt puchMuseumsObjekt) {
		getPersistence().clearCache(puchMuseumsObjekt);
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
	public static List<PuchMuseumsObjekt> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PuchMuseumsObjekt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PuchMuseumsObjekt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PuchMuseumsObjekt update(PuchMuseumsObjekt puchMuseumsObjekt)
		throws SystemException {
		return getPersistence().update(puchMuseumsObjekt);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PuchMuseumsObjekt update(
		PuchMuseumsObjekt puchMuseumsObjekt, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(puchMuseumsObjekt, serviceContext);
	}

	/**
	* Caches the puch museums objekt in the entity cache if it is enabled.
	*
	* @param puchMuseumsObjekt the puch museums objekt
	*/
	public static void cacheResult(
		at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt puchMuseumsObjekt) {
		getPersistence().cacheResult(puchMuseumsObjekt);
	}

	/**
	* Caches the puch museums objekts in the entity cache if it is enabled.
	*
	* @param puchMuseumsObjekts the puch museums objekts
	*/
	public static void cacheResult(
		java.util.List<at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt> puchMuseumsObjekts) {
		getPersistence().cacheResult(puchMuseumsObjekts);
	}

	/**
	* Creates a new puch museums objekt with the primary key. Does not add the puch museums objekt to the database.
	*
	* @param puchmuseumsobjectId the primary key for the new puch museums objekt
	* @return the new puch museums objekt
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt create(
		long puchmuseumsobjectId) {
		return getPersistence().create(puchmuseumsobjectId);
	}

	/**
	* Removes the puch museums objekt with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param puchmuseumsobjectId the primary key of the puch museums objekt
	* @return the puch museums objekt that was removed
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException if a puch museums objekt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt remove(
		long puchmuseumsobjectId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(puchmuseumsobjectId);
	}

	public static at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt puchMuseumsObjekt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(puchMuseumsObjekt);
	}

	/**
	* Returns the puch museums objekt with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException} if it could not be found.
	*
	* @param puchmuseumsobjectId the primary key of the puch museums objekt
	* @return the puch museums objekt
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException if a puch museums objekt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt findByPrimaryKey(
		long puchmuseumsobjectId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(puchmuseumsobjectId);
	}

	/**
	* Returns the puch museums objekt with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param puchmuseumsobjectId the primary key of the puch museums objekt
	* @return the puch museums objekt, or <code>null</code> if a puch museums objekt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt fetchByPrimaryKey(
		long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(puchmuseumsobjectId);
	}

	/**
	* Returns all the puch museums objekts.
	*
	* @return the puch museums objekts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the puch museums objekts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of puch museums objekts.
	*
	* @return the number of puch museums objekts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PuchMuseumsObjektPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PuchMuseumsObjektPersistence)PortletBeanLocatorUtil.locate(at.graz.hmmc.liferay.portlet.puch.service.ClpSerializer.getServletContextName(),
					PuchMuseumsObjektPersistence.class.getName());

			ReferenceRegistry.registerReference(PuchMuseumsObjektUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PuchMuseumsObjektPersistence persistence) {
	}

	private static PuchMuseumsObjektPersistence _persistence;
}