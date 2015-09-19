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

package at.graz.meduni.liferay.portlet.bibbox.service.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the logapi service. This utility wraps {@link LogapiPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see LogapiPersistence
 * @see LogapiPersistenceImpl
 * @generated
 */
public class LogapiUtil {
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
	public static void clearCache(Logapi logapi) {
		getPersistence().clearCache(logapi);
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
	public static List<Logapi> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Logapi> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Logapi> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Logapi update(Logapi logapi) throws SystemException {
		return getPersistence().update(logapi);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Logapi update(Logapi logapi, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(logapi, serviceContext);
	}

	/**
	* Caches the logapi in the entity cache if it is enabled.
	*
	* @param logapi the logapi
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi logapi) {
		getPersistence().cacheResult(logapi);
	}

	/**
	* Caches the logapis in the entity cache if it is enabled.
	*
	* @param logapis the logapis
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi> logapis) {
		getPersistence().cacheResult(logapis);
	}

	/**
	* Creates a new logapi with the primary key. Does not add the logapi to the database.
	*
	* @param logapiId the primary key for the new logapi
	* @return the new logapi
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi create(
		long logapiId) {
		return getPersistence().create(logapiId);
	}

	/**
	* Removes the logapi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param logapiId the primary key of the logapi
	* @return the logapi that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchLogapiException if a logapi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi remove(
		long logapiId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchLogapiException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(logapiId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi logapi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(logapi);
	}

	/**
	* Returns the logapi with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchLogapiException} if it could not be found.
	*
	* @param logapiId the primary key of the logapi
	* @return the logapi
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchLogapiException if a logapi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi findByPrimaryKey(
		long logapiId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchLogapiException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(logapiId);
	}

	/**
	* Returns the logapi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param logapiId the primary key of the logapi
	* @return the logapi, or <code>null</code> if a logapi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi fetchByPrimaryKey(
		long logapiId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(logapiId);
	}

	/**
	* Returns all the logapis.
	*
	* @return the logapis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the logapis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.LogapiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logapis
	* @param end the upper bound of the range of logapis (not inclusive)
	* @return the range of logapis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the logapis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.LogapiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of logapis
	* @param end the upper bound of the range of logapis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of logapis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the logapis from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of logapis.
	*
	* @return the number of logapis
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LogapiPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LogapiPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.service.service.ClpSerializer.getServletContextName(),
					LogapiPersistence.class.getName());

			ReferenceRegistry.registerReference(LogapiUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LogapiPersistence persistence) {
	}

	private static LogapiPersistence _persistence;
}