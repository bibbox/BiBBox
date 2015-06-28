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

package at.graz.meduni.liferay.portlet.bibbox.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the orphanet disorder service. This utility wraps {@link OrphanetDisorderPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see OrphanetDisorderPersistence
 * @see OrphanetDisorderPersistenceImpl
 * @generated
 */
public class OrphanetDisorderUtil {
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
	public static void clearCache(OrphanetDisorder orphanetDisorder) {
		getPersistence().clearCache(orphanetDisorder);
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
	public static List<OrphanetDisorder> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrphanetDisorder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrphanetDisorder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static OrphanetDisorder update(OrphanetDisorder orphanetDisorder)
		throws SystemException {
		return getPersistence().update(orphanetDisorder);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static OrphanetDisorder update(OrphanetDisorder orphanetDisorder,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(orphanetDisorder, serviceContext);
	}

	/**
	* Caches the orphanet disorder in the entity cache if it is enabled.
	*
	* @param orphanetDisorder the orphanet disorder
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder orphanetDisorder) {
		getPersistence().cacheResult(orphanetDisorder);
	}

	/**
	* Caches the orphanet disorders in the entity cache if it is enabled.
	*
	* @param orphanetDisorders the orphanet disorders
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder> orphanetDisorders) {
		getPersistence().cacheResult(orphanetDisorders);
	}

	/**
	* Creates a new orphanet disorder with the primary key. Does not add the orphanet disorder to the database.
	*
	* @param orphanetdisorderId the primary key for the new orphanet disorder
	* @return the new orphanet disorder
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder create(
		long orphanetdisorderId) {
		return getPersistence().create(orphanetdisorderId);
	}

	/**
	* Removes the orphanet disorder with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orphanetdisorderId the primary key of the orphanet disorder
	* @return the orphanet disorder that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException if a orphanet disorder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder remove(
		long orphanetdisorderId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(orphanetdisorderId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder orphanetDisorder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(orphanetDisorder);
	}

	/**
	* Returns the orphanet disorder with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException} if it could not be found.
	*
	* @param orphanetdisorderId the primary key of the orphanet disorder
	* @return the orphanet disorder
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException if a orphanet disorder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder findByPrimaryKey(
		long orphanetdisorderId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(orphanetdisorderId);
	}

	/**
	* Returns the orphanet disorder with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orphanetdisorderId the primary key of the orphanet disorder
	* @return the orphanet disorder, or <code>null</code> if a orphanet disorder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder fetchByPrimaryKey(
		long orphanetdisorderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(orphanetdisorderId);
	}

	/**
	* Returns all the orphanet disorders.
	*
	* @return the orphanet disorders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the orphanet disorders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetDisorderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orphanet disorders
	* @param end the upper bound of the range of orphanet disorders (not inclusive)
	* @return the range of orphanet disorders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the orphanet disorders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetDisorderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orphanet disorders
	* @param end the upper bound of the range of orphanet disorders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of orphanet disorders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the orphanet disorders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of orphanet disorders.
	*
	* @return the number of orphanet disorders
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OrphanetDisorderPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OrphanetDisorderPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.service.ClpSerializer.getServletContextName(),
					OrphanetDisorderPersistence.class.getName());

			ReferenceRegistry.registerReference(OrphanetDisorderUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(OrphanetDisorderPersistence persistence) {
	}

	private static OrphanetDisorderPersistence _persistence;
}