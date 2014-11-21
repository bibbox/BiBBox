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

import com.bcnet.portlet.biobank.model.BiobankGeneralInformation;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the biobank general information service. This utility wraps {@link BiobankGeneralInformationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see BiobankGeneralInformationPersistence
 * @see BiobankGeneralInformationPersistenceImpl
 * @generated
 */
public class BiobankGeneralInformationUtil {
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
	public static void clearCache(
		BiobankGeneralInformation biobankGeneralInformation) {
		getPersistence().clearCache(biobankGeneralInformation);
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
	public static List<BiobankGeneralInformation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BiobankGeneralInformation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BiobankGeneralInformation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BiobankGeneralInformation update(
		BiobankGeneralInformation biobankGeneralInformation)
		throws SystemException {
		return getPersistence().update(biobankGeneralInformation);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BiobankGeneralInformation update(
		BiobankGeneralInformation biobankGeneralInformation,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(biobankGeneralInformation, serviceContext);
	}

	/**
	* Caches the biobank general information in the entity cache if it is enabled.
	*
	* @param biobankGeneralInformation the biobank general information
	*/
	public static void cacheResult(
		com.bcnet.portlet.biobank.model.BiobankGeneralInformation biobankGeneralInformation) {
		getPersistence().cacheResult(biobankGeneralInformation);
	}

	/**
	* Caches the biobank general informations in the entity cache if it is enabled.
	*
	* @param biobankGeneralInformations the biobank general informations
	*/
	public static void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.BiobankGeneralInformation> biobankGeneralInformations) {
		getPersistence().cacheResult(biobankGeneralInformations);
	}

	/**
	* Creates a new biobank general information with the primary key. Does not add the biobank general information to the database.
	*
	* @param biobankDbId the primary key for the new biobank general information
	* @return the new biobank general information
	*/
	public static com.bcnet.portlet.biobank.model.BiobankGeneralInformation create(
		long biobankDbId) {
		return getPersistence().create(biobankDbId);
	}

	/**
	* Removes the biobank general information with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankDbId the primary key of the biobank general information
	* @return the biobank general information that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException if a biobank general information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankGeneralInformation remove(
		long biobankDbId)
		throws com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(biobankDbId);
	}

	public static com.bcnet.portlet.biobank.model.BiobankGeneralInformation updateImpl(
		com.bcnet.portlet.biobank.model.BiobankGeneralInformation biobankGeneralInformation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(biobankGeneralInformation);
	}

	/**
	* Returns the biobank general information with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException} if it could not be found.
	*
	* @param biobankDbId the primary key of the biobank general information
	* @return the biobank general information
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException if a biobank general information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankGeneralInformation findByPrimaryKey(
		long biobankDbId)
		throws com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(biobankDbId);
	}

	/**
	* Returns the biobank general information with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param biobankDbId the primary key of the biobank general information
	* @return the biobank general information, or <code>null</code> if a biobank general information with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.BiobankGeneralInformation fetchByPrimaryKey(
		long biobankDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(biobankDbId);
	}

	/**
	* Returns all the biobank general informations.
	*
	* @return the biobank general informations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankGeneralInformation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the biobank general informations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank general informations
	* @param end the upper bound of the range of biobank general informations (not inclusive)
	* @return the range of biobank general informations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankGeneralInformation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the biobank general informations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank general informations
	* @param end the upper bound of the range of biobank general informations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of biobank general informations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.BiobankGeneralInformation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the biobank general informations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of biobank general informations.
	*
	* @return the number of biobank general informations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BiobankGeneralInformationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BiobankGeneralInformationPersistence)PortletBeanLocatorUtil.locate(com.bcnet.portlet.biobank.service.ClpSerializer.getServletContextName(),
					BiobankGeneralInformationPersistence.class.getName());

			ReferenceRegistry.registerReference(BiobankGeneralInformationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BiobankGeneralInformationPersistence persistence) {
	}

	private static BiobankGeneralInformationPersistence _persistence;
}