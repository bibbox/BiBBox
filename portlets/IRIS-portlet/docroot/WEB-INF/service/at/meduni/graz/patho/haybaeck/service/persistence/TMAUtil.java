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

package at.meduni.graz.patho.haybaeck.service.persistence;

import at.meduni.graz.patho.haybaeck.model.TMA;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the t m a service. This utility wraps {@link TMAPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see TMAPersistence
 * @see TMAPersistenceImpl
 * @generated
 */
public class TMAUtil {
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
	public static void clearCache(TMA tma) {
		getPersistence().clearCache(tma);
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
	public static List<TMA> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TMA> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TMA> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TMA update(TMA tma) throws SystemException {
		return getPersistence().update(tma);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TMA update(TMA tma, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(tma, serviceContext);
	}

	/**
	* Caches the t m a in the entity cache if it is enabled.
	*
	* @param tma the t m a
	*/
	public static void cacheResult(at.meduni.graz.patho.haybaeck.model.TMA tma) {
		getPersistence().cacheResult(tma);
	}

	/**
	* Caches the t m as in the entity cache if it is enabled.
	*
	* @param tmas the t m as
	*/
	public static void cacheResult(
		java.util.List<at.meduni.graz.patho.haybaeck.model.TMA> tmas) {
		getPersistence().cacheResult(tmas);
	}

	/**
	* Creates a new t m a with the primary key. Does not add the t m a to the database.
	*
	* @param tma_Id the primary key for the new t m a
	* @return the new t m a
	*/
	public static at.meduni.graz.patho.haybaeck.model.TMA create(long tma_Id) {
		return getPersistence().create(tma_Id);
	}

	/**
	* Removes the t m a with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tma_Id the primary key of the t m a
	* @return the t m a that was removed
	* @throws at.meduni.graz.patho.haybaeck.NoSuchTMAException if a t m a with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.graz.patho.haybaeck.model.TMA remove(long tma_Id)
		throws at.meduni.graz.patho.haybaeck.NoSuchTMAException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(tma_Id);
	}

	public static at.meduni.graz.patho.haybaeck.model.TMA updateImpl(
		at.meduni.graz.patho.haybaeck.model.TMA tma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tma);
	}

	/**
	* Returns the t m a with the primary key or throws a {@link at.meduni.graz.patho.haybaeck.NoSuchTMAException} if it could not be found.
	*
	* @param tma_Id the primary key of the t m a
	* @return the t m a
	* @throws at.meduni.graz.patho.haybaeck.NoSuchTMAException if a t m a with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.graz.patho.haybaeck.model.TMA findByPrimaryKey(
		long tma_Id)
		throws at.meduni.graz.patho.haybaeck.NoSuchTMAException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(tma_Id);
	}

	/**
	* Returns the t m a with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tma_Id the primary key of the t m a
	* @return the t m a, or <code>null</code> if a t m a with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.graz.patho.haybaeck.model.TMA fetchByPrimaryKey(
		long tma_Id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tma_Id);
	}

	/**
	* Returns all the t m as.
	*
	* @return the t m as
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.graz.patho.haybaeck.model.TMA> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the t m as.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.graz.patho.haybaeck.model.impl.TMAModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of t m as
	* @param end the upper bound of the range of t m as (not inclusive)
	* @return the range of t m as
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.graz.patho.haybaeck.model.TMA> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the t m as.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.graz.patho.haybaeck.model.impl.TMAModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of t m as
	* @param end the upper bound of the range of t m as (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of t m as
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.graz.patho.haybaeck.model.TMA> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the t m as from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of t m as.
	*
	* @return the number of t m as
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TMAPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TMAPersistence)PortletBeanLocatorUtil.locate(at.meduni.graz.patho.haybaeck.service.ClpSerializer.getServletContextName(),
					TMAPersistence.class.getName());

			ReferenceRegistry.registerReference(TMAUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TMAPersistence persistence) {
	}

	private static TMAPersistence _persistence;
}