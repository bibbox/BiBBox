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

package com.bcnet.portlet.biobank.service.persistence;

import com.bcnet.portlet.biobank.model.BiobankContact;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the biobank contact service. This utility wraps {@link BiobankContactPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see BiobankContactPersistence
 * @see BiobankContactPersistenceImpl
 * @generated
 */
public class BiobankContactUtil {
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
	public static void clearCache(BiobankContact biobankContact) {
		getPersistence().clearCache(biobankContact);
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
	public static List<BiobankContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BiobankContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BiobankContact> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BiobankContact update(BiobankContact biobankContact)
		throws SystemException {
		return getPersistence().update(biobankContact);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BiobankContact update(BiobankContact biobankContact,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(biobankContact, serviceContext);
	}

	/**
	* Caches the biobank contact in the entity cache if it is enabled.
	*
	* @param biobankContact the biobank contact
	*/
	public static void cacheResult(
		com.bcnet.portlet.biobank.model.BiobankContact biobankContact) {
		getPersistence().cacheResult(biobankContact);
	}

	/**
	* Caches the biobank contacts in the entity cache if it is enabled.
	*
	* @param biobankContacts the biobank contacts
	*/
	public static void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.BiobankContact> biobankContacts) {
		getPersistence().cacheResult(biobankContacts);
	}

	/**
	* Creates a new biobank contact with the primary key. Does not add the biobank contact to the database.
	*
	* @param biobankContactPK the primary key for the new biobank contact
	* @return the new biobank contact
	*/
	public static com.bcnet.portlet.biobank.model.BiobankContact create(
		com.bcnet.portlet.biobank.service.persistence.BiobankContactPK biobankContactPK) {
		return getPersistence().create(biobankContactPK);
	}

	/**
	* Removes the biobank contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankContactPK the primary key of the biobank contact
	* @return the biobank contact that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankContactException if a biobank contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankContact remove(
		com.bcnet.portlet.biobank.service.persistence.BiobankContactPK biobankContactPK)
		throws com.bcnet.portlet.biobank.NoSuchBiobankContactException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(biobankContactPK);
	}

	public static com.bcnet.portlet.biobank.model.BiobankContact updateImpl(
		com.bcnet.portlet.biobank.model.BiobankContact biobankContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(biobankContact);
	}

	/**
	* Returns the biobank contact with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchBiobankContactException} if it could not be found.
	*
	* @param biobankContactPK the primary key of the biobank contact
	* @return the biobank contact
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankContactException if a biobank contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankContact findByPrimaryKey(
		com.bcnet.portlet.biobank.service.persistence.BiobankContactPK biobankContactPK)
		throws com.bcnet.portlet.biobank.NoSuchBiobankContactException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(biobankContactPK);
	}

	/**
	* Returns the biobank contact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param biobankContactPK the primary key of the biobank contact
	* @return the biobank contact, or <code>null</code> if a biobank contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankContact fetchByPrimaryKey(
		com.bcnet.portlet.biobank.service.persistence.BiobankContactPK biobankContactPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(biobankContactPK);
	}

	/**
	* Returns all the biobank contacts.
	*
	* @return the biobank contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankContact> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the biobank contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank contacts
	* @param end the upper bound of the range of biobank contacts (not inclusive)
	* @return the range of biobank contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankContact> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the biobank contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank contacts
	* @param end the upper bound of the range of biobank contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of biobank contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the biobank contacts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of biobank contacts.
	*
	* @return the number of biobank contacts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BiobankContactPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BiobankContactPersistence)PortletBeanLocatorUtil.locate(com.bcnet.portlet.biobank.service.ClpSerializer.getServletContextName(),
					BiobankContactPersistence.class.getName());

			ReferenceRegistry.registerReference(BiobankContactUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BiobankContactPersistence persistence) {
	}

	private static BiobankContactPersistence _persistence;
}