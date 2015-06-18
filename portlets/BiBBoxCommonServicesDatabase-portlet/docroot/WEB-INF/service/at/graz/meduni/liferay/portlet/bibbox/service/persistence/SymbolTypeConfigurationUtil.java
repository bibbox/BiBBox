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

import at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the symbol type configuration service. This utility wraps {@link SymbolTypeConfigurationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see SymbolTypeConfigurationPersistence
 * @see SymbolTypeConfigurationPersistenceImpl
 * @generated
 */
public class SymbolTypeConfigurationUtil {
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
		SymbolTypeConfiguration symbolTypeConfiguration) {
		getPersistence().clearCache(symbolTypeConfiguration);
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
	public static List<SymbolTypeConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SymbolTypeConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SymbolTypeConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SymbolTypeConfiguration update(
		SymbolTypeConfiguration symbolTypeConfiguration)
		throws SystemException {
		return getPersistence().update(symbolTypeConfiguration);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SymbolTypeConfiguration update(
		SymbolTypeConfiguration symbolTypeConfiguration,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(symbolTypeConfiguration, serviceContext);
	}

	/**
	* Returns the symbol type configuration where symboltype = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException} if it could not be found.
	*
	* @param symboltype the symboltype
	* @return the matching symbol type configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException if a matching symbol type configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration findByFieldSymbolType(
		java.lang.String symboltype)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFieldSymbolType(symboltype);
	}

	/**
	* Returns the symbol type configuration where symboltype = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param symboltype the symboltype
	* @return the matching symbol type configuration, or <code>null</code> if a matching symbol type configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration fetchByFieldSymbolType(
		java.lang.String symboltype)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFieldSymbolType(symboltype);
	}

	/**
	* Returns the symbol type configuration where symboltype = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param symboltype the symboltype
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching symbol type configuration, or <code>null</code> if a matching symbol type configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration fetchByFieldSymbolType(
		java.lang.String symboltype, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFieldSymbolType(symboltype, retrieveFromCache);
	}

	/**
	* Removes the symbol type configuration where symboltype = &#63; from the database.
	*
	* @param symboltype the symboltype
	* @return the symbol type configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration removeByFieldSymbolType(
		java.lang.String symboltype)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByFieldSymbolType(symboltype);
	}

	/**
	* Returns the number of symbol type configurations where symboltype = &#63;.
	*
	* @param symboltype the symboltype
	* @return the number of matching symbol type configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFieldSymbolType(java.lang.String symboltype)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFieldSymbolType(symboltype);
	}

	/**
	* Caches the symbol type configuration in the entity cache if it is enabled.
	*
	* @param symbolTypeConfiguration the symbol type configuration
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration symbolTypeConfiguration) {
		getPersistence().cacheResult(symbolTypeConfiguration);
	}

	/**
	* Caches the symbol type configurations in the entity cache if it is enabled.
	*
	* @param symbolTypeConfigurations the symbol type configurations
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration> symbolTypeConfigurations) {
		getPersistence().cacheResult(symbolTypeConfigurations);
	}

	/**
	* Creates a new symbol type configuration with the primary key. Does not add the symbol type configuration to the database.
	*
	* @param symboltypeconfigurationId the primary key for the new symbol type configuration
	* @return the new symbol type configuration
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration create(
		long symboltypeconfigurationId) {
		return getPersistence().create(symboltypeconfigurationId);
	}

	/**
	* Removes the symbol type configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param symboltypeconfigurationId the primary key of the symbol type configuration
	* @return the symbol type configuration that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException if a symbol type configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration remove(
		long symboltypeconfigurationId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(symboltypeconfigurationId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration symbolTypeConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(symbolTypeConfiguration);
	}

	/**
	* Returns the symbol type configuration with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException} if it could not be found.
	*
	* @param symboltypeconfigurationId the primary key of the symbol type configuration
	* @return the symbol type configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException if a symbol type configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration findByPrimaryKey(
		long symboltypeconfigurationId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(symboltypeconfigurationId);
	}

	/**
	* Returns the symbol type configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param symboltypeconfigurationId the primary key of the symbol type configuration
	* @return the symbol type configuration, or <code>null</code> if a symbol type configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration fetchByPrimaryKey(
		long symboltypeconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(symboltypeconfigurationId);
	}

	/**
	* Returns all the symbol type configurations.
	*
	* @return the symbol type configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the symbol type configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolTypeConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of symbol type configurations
	* @param end the upper bound of the range of symbol type configurations (not inclusive)
	* @return the range of symbol type configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the symbol type configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolTypeConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of symbol type configurations
	* @param end the upper bound of the range of symbol type configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of symbol type configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the symbol type configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of symbol type configurations.
	*
	* @return the number of symbol type configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SymbolTypeConfigurationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SymbolTypeConfigurationPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.service.ClpSerializer.getServletContextName(),
					SymbolTypeConfigurationPersistence.class.getName());

			ReferenceRegistry.registerReference(SymbolTypeConfigurationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SymbolTypeConfigurationPersistence persistence) {
	}

	private static SymbolTypeConfigurationPersistence _persistence;
}