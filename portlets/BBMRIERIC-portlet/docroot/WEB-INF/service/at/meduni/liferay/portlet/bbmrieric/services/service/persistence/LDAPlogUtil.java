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

package at.meduni.liferay.portlet.bbmrieric.services.service.persistence;

import at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l d a plog service. This utility wraps {@link LDAPlogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see LDAPlogPersistence
 * @see LDAPlogPersistenceImpl
 * @generated
 */
public class LDAPlogUtil {
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
	public static void clearCache(LDAPlog ldaPlog) {
		getPersistence().clearCache(ldaPlog);
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
	public static List<LDAPlog> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LDAPlog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LDAPlog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LDAPlog update(LDAPlog ldaPlog) throws SystemException {
		return getPersistence().update(ldaPlog);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LDAPlog update(LDAPlog ldaPlog, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(ldaPlog, serviceContext);
	}

	/**
	* Caches the l d a plog in the entity cache if it is enabled.
	*
	* @param ldaPlog the l d a plog
	*/
	public static void cacheResult(
		at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog ldaPlog) {
		getPersistence().cacheResult(ldaPlog);
	}

	/**
	* Caches the l d a plogs in the entity cache if it is enabled.
	*
	* @param ldaPlogs the l d a plogs
	*/
	public static void cacheResult(
		java.util.List<at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog> ldaPlogs) {
		getPersistence().cacheResult(ldaPlogs);
	}

	/**
	* Creates a new l d a plog with the primary key. Does not add the l d a plog to the database.
	*
	* @param ldaplogId the primary key for the new l d a plog
	* @return the new l d a plog
	*/
	public static at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog create(
		long ldaplogId) {
		return getPersistence().create(ldaplogId);
	}

	/**
	* Removes the l d a plog with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ldaplogId the primary key of the l d a plog
	* @return the l d a plog that was removed
	* @throws at.meduni.liferay.portlet.bbmrieric.services.NoSuchlogException if a l d a plog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog remove(
		long ldaplogId)
		throws at.meduni.liferay.portlet.bbmrieric.services.NoSuchlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(ldaplogId);
	}

	public static at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog updateImpl(
		at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog ldaPlog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ldaPlog);
	}

	/**
	* Returns the l d a plog with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.services.NoSuchlogException} if it could not be found.
	*
	* @param ldaplogId the primary key of the l d a plog
	* @return the l d a plog
	* @throws at.meduni.liferay.portlet.bbmrieric.services.NoSuchlogException if a l d a plog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog findByPrimaryKey(
		long ldaplogId)
		throws at.meduni.liferay.portlet.bbmrieric.services.NoSuchlogException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(ldaplogId);
	}

	/**
	* Returns the l d a plog with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ldaplogId the primary key of the l d a plog
	* @return the l d a plog, or <code>null</code> if a l d a plog with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog fetchByPrimaryKey(
		long ldaplogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ldaplogId);
	}

	/**
	* Returns all the l d a plogs.
	*
	* @return the l d a plogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the l d a plogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.services.model.impl.LDAPlogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l d a plogs
	* @param end the upper bound of the range of l d a plogs (not inclusive)
	* @return the range of l d a plogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the l d a plogs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.services.model.impl.LDAPlogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l d a plogs
	* @param end the upper bound of the range of l d a plogs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of l d a plogs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the l d a plogs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of l d a plogs.
	*
	* @return the number of l d a plogs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LDAPlogPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LDAPlogPersistence)PortletBeanLocatorUtil.locate(at.meduni.liferay.portlet.bbmrieric.services.service.ClpSerializer.getServletContextName(),
					LDAPlogPersistence.class.getName());

			ReferenceRegistry.registerReference(LDAPlogUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LDAPlogPersistence persistence) {
	}

	private static LDAPlogPersistence _persistence;
}