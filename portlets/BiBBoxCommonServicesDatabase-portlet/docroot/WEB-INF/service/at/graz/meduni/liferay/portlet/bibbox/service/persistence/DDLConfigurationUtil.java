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

import at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the d d l configuration service. This utility wraps {@link DDLConfigurationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see DDLConfigurationPersistence
 * @see DDLConfigurationPersistenceImpl
 * @generated
 */
public class DDLConfigurationUtil {
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
	public static void clearCache(DDLConfiguration ddlConfiguration) {
		getPersistence().clearCache(ddlConfiguration);
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
	public static List<DDLConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DDLConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DDLConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DDLConfiguration update(DDLConfiguration ddlConfiguration)
		throws SystemException {
		return getPersistence().update(ddlConfiguration);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DDLConfiguration update(DDLConfiguration ddlConfiguration,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ddlConfiguration, serviceContext);
	}

	/**
	* Returns the d d l configuration where ddmstructureId = &#63; and fieldname = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchDDLConfigurationException} if it could not be found.
	*
	* @param ddmstructureId the ddmstructure ID
	* @param fieldname the fieldname
	* @return the matching d d l configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchDDLConfigurationException if a matching d d l configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration findByFieldOptions(
		long ddmstructureId, java.lang.String fieldname)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchDDLConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFieldOptions(ddmstructureId, fieldname);
	}

	/**
	* Returns the d d l configuration where ddmstructureId = &#63; and fieldname = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ddmstructureId the ddmstructure ID
	* @param fieldname the fieldname
	* @return the matching d d l configuration, or <code>null</code> if a matching d d l configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration fetchByFieldOptions(
		long ddmstructureId, java.lang.String fieldname)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFieldOptions(ddmstructureId, fieldname);
	}

	/**
	* Returns the d d l configuration where ddmstructureId = &#63; and fieldname = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ddmstructureId the ddmstructure ID
	* @param fieldname the fieldname
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching d d l configuration, or <code>null</code> if a matching d d l configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration fetchByFieldOptions(
		long ddmstructureId, java.lang.String fieldname,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFieldOptions(ddmstructureId, fieldname,
			retrieveFromCache);
	}

	/**
	* Removes the d d l configuration where ddmstructureId = &#63; and fieldname = &#63; from the database.
	*
	* @param ddmstructureId the ddmstructure ID
	* @param fieldname the fieldname
	* @return the d d l configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration removeByFieldOptions(
		long ddmstructureId, java.lang.String fieldname)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchDDLConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByFieldOptions(ddmstructureId, fieldname);
	}

	/**
	* Returns the number of d d l configurations where ddmstructureId = &#63; and fieldname = &#63;.
	*
	* @param ddmstructureId the ddmstructure ID
	* @param fieldname the fieldname
	* @return the number of matching d d l configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFieldOptions(long ddmstructureId,
		java.lang.String fieldname)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFieldOptions(ddmstructureId, fieldname);
	}

	/**
	* Caches the d d l configuration in the entity cache if it is enabled.
	*
	* @param ddlConfiguration the d d l configuration
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration ddlConfiguration) {
		getPersistence().cacheResult(ddlConfiguration);
	}

	/**
	* Caches the d d l configurations in the entity cache if it is enabled.
	*
	* @param ddlConfigurations the d d l configurations
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration> ddlConfigurations) {
		getPersistence().cacheResult(ddlConfigurations);
	}

	/**
	* Creates a new d d l configuration with the primary key. Does not add the d d l configuration to the database.
	*
	* @param ddlconfigurationId the primary key for the new d d l configuration
	* @return the new d d l configuration
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration create(
		long ddlconfigurationId) {
		return getPersistence().create(ddlconfigurationId);
	}

	/**
	* Removes the d d l configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ddlconfigurationId the primary key of the d d l configuration
	* @return the d d l configuration that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchDDLConfigurationException if a d d l configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration remove(
		long ddlconfigurationId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchDDLConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(ddlconfigurationId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration ddlConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ddlConfiguration);
	}

	/**
	* Returns the d d l configuration with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchDDLConfigurationException} if it could not be found.
	*
	* @param ddlconfigurationId the primary key of the d d l configuration
	* @return the d d l configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchDDLConfigurationException if a d d l configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration findByPrimaryKey(
		long ddlconfigurationId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchDDLConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(ddlconfigurationId);
	}

	/**
	* Returns the d d l configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ddlconfigurationId the primary key of the d d l configuration
	* @return the d d l configuration, or <code>null</code> if a d d l configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration fetchByPrimaryKey(
		long ddlconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ddlconfigurationId);
	}

	/**
	* Returns all the d d l configurations.
	*
	* @return the d d l configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the d d l configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.DDLConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of d d l configurations
	* @param end the upper bound of the range of d d l configurations (not inclusive)
	* @return the range of d d l configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the d d l configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.DDLConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of d d l configurations
	* @param end the upper bound of the range of d d l configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of d d l configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the d d l configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of d d l configurations.
	*
	* @return the number of d d l configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DDLConfigurationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DDLConfigurationPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.service.ClpSerializer.getServletContextName(),
					DDLConfigurationPersistence.class.getName());

			ReferenceRegistry.registerReference(DDLConfigurationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DDLConfigurationPersistence persistence) {
	}

	private static DDLConfigurationPersistence _persistence;
}