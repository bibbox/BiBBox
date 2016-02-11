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

import at.graz.meduni.liferay.portlet.bibbox.service.model.idcard;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the idcard service. This utility wraps {@link idcardPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see idcardPersistence
 * @see idcardPersistenceImpl
 * @generated
 */
public class idcardUtil {
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
	public static void clearCache(idcard idcard) {
		getPersistence().clearCache(idcard);
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
	public static List<idcard> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<idcard> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<idcard> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static idcard update(idcard idcard) throws SystemException {
		return getPersistence().update(idcard);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static idcard update(idcard idcard, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(idcard, serviceContext);
	}

	/**
	* Caches the idcard in the entity cache if it is enabled.
	*
	* @param idcard the idcard
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.service.model.idcard idcard) {
		getPersistence().cacheResult(idcard);
	}

	/**
	* Caches the idcards in the entity cache if it is enabled.
	*
	* @param idcards the idcards
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.idcard> idcards) {
		getPersistence().cacheResult(idcards);
	}

	/**
	* Creates a new idcard with the primary key. Does not add the idcard to the database.
	*
	* @param idcardId the primary key for the new idcard
	* @return the new idcard
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.idcard create(
		long idcardId) {
		return getPersistence().create(idcardId);
	}

	/**
	* Removes the idcard with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idcardId the primary key of the idcard
	* @return the idcard that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchidcardException if a idcard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.idcard remove(
		long idcardId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchidcardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(idcardId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.service.model.idcard updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.idcard idcard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(idcard);
	}

	/**
	* Returns the idcard with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchidcardException} if it could not be found.
	*
	* @param idcardId the primary key of the idcard
	* @return the idcard
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchidcardException if a idcard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.idcard findByPrimaryKey(
		long idcardId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchidcardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(idcardId);
	}

	/**
	* Returns the idcard with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idcardId the primary key of the idcard
	* @return the idcard, or <code>null</code> if a idcard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.idcard fetchByPrimaryKey(
		long idcardId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idcardId);
	}

	/**
	* Returns all the idcards.
	*
	* @return the idcards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.idcard> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the idcards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.idcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of idcards
	* @param end the upper bound of the range of idcards (not inclusive)
	* @return the range of idcards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.idcard> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the idcards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.idcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of idcards
	* @param end the upper bound of the range of idcards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of idcards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.idcard> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the idcards from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of idcards.
	*
	* @return the number of idcards
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static idcardPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (idcardPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.service.service.ClpSerializer.getServletContextName(),
					idcardPersistence.class.getName());

			ReferenceRegistry.registerReference(idcardUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(idcardPersistence persistence) {
	}

	private static idcardPersistence _persistence;
}