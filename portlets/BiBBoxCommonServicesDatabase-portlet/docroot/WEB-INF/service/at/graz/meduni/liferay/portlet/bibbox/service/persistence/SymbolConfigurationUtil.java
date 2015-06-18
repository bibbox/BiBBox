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

import at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the symbol configuration service. This utility wraps {@link SymbolConfigurationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see SymbolConfigurationPersistence
 * @see SymbolConfigurationPersistenceImpl
 * @generated
 */
public class SymbolConfigurationUtil {
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
	public static void clearCache(SymbolConfiguration symbolConfiguration) {
		getPersistence().clearCache(symbolConfiguration);
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
	public static List<SymbolConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SymbolConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SymbolConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SymbolConfiguration update(
		SymbolConfiguration symbolConfiguration) throws SystemException {
		return getPersistence().update(symbolConfiguration);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SymbolConfiguration update(
		SymbolConfiguration symbolConfiguration, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(symbolConfiguration, serviceContext);
	}

	/**
	* Returns the symbol configuration where scope = &#63; and eventtype = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException} if it could not be found.
	*
	* @param scope the scope
	* @param eventtype the eventtype
	* @return the matching symbol configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException if a matching symbol configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration findByFieldSymbol(
		java.lang.String scope, java.lang.String eventtype)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFieldSymbol(scope, eventtype);
	}

	/**
	* Returns the symbol configuration where scope = &#63; and eventtype = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param scope the scope
	* @param eventtype the eventtype
	* @return the matching symbol configuration, or <code>null</code> if a matching symbol configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration fetchByFieldSymbol(
		java.lang.String scope, java.lang.String eventtype)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFieldSymbol(scope, eventtype);
	}

	/**
	* Returns the symbol configuration where scope = &#63; and eventtype = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param scope the scope
	* @param eventtype the eventtype
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching symbol configuration, or <code>null</code> if a matching symbol configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration fetchByFieldSymbol(
		java.lang.String scope, java.lang.String eventtype,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFieldSymbol(scope, eventtype, retrieveFromCache);
	}

	/**
	* Removes the symbol configuration where scope = &#63; and eventtype = &#63; from the database.
	*
	* @param scope the scope
	* @param eventtype the eventtype
	* @return the symbol configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration removeByFieldSymbol(
		java.lang.String scope, java.lang.String eventtype)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByFieldSymbol(scope, eventtype);
	}

	/**
	* Returns the number of symbol configurations where scope = &#63; and eventtype = &#63;.
	*
	* @param scope the scope
	* @param eventtype the eventtype
	* @return the number of matching symbol configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFieldSymbol(java.lang.String scope,
		java.lang.String eventtype)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFieldSymbol(scope, eventtype);
	}

	/**
	* Caches the symbol configuration in the entity cache if it is enabled.
	*
	* @param symbolConfiguration the symbol configuration
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration symbolConfiguration) {
		getPersistence().cacheResult(symbolConfiguration);
	}

	/**
	* Caches the symbol configurations in the entity cache if it is enabled.
	*
	* @param symbolConfigurations the symbol configurations
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration> symbolConfigurations) {
		getPersistence().cacheResult(symbolConfigurations);
	}

	/**
	* Creates a new symbol configuration with the primary key. Does not add the symbol configuration to the database.
	*
	* @param symbolconfigurationId the primary key for the new symbol configuration
	* @return the new symbol configuration
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration create(
		long symbolconfigurationId) {
		return getPersistence().create(symbolconfigurationId);
	}

	/**
	* Removes the symbol configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param symbolconfigurationId the primary key of the symbol configuration
	* @return the symbol configuration that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException if a symbol configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration remove(
		long symbolconfigurationId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(symbolconfigurationId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration symbolConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(symbolConfiguration);
	}

	/**
	* Returns the symbol configuration with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException} if it could not be found.
	*
	* @param symbolconfigurationId the primary key of the symbol configuration
	* @return the symbol configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException if a symbol configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration findByPrimaryKey(
		long symbolconfigurationId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(symbolconfigurationId);
	}

	/**
	* Returns the symbol configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param symbolconfigurationId the primary key of the symbol configuration
	* @return the symbol configuration, or <code>null</code> if a symbol configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration fetchByPrimaryKey(
		long symbolconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(symbolconfigurationId);
	}

	/**
	* Returns all the symbol configurations.
	*
	* @return the symbol configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the symbol configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of symbol configurations
	* @param end the upper bound of the range of symbol configurations (not inclusive)
	* @return the range of symbol configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the symbol configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of symbol configurations
	* @param end the upper bound of the range of symbol configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of symbol configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the symbol configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of symbol configurations.
	*
	* @return the number of symbol configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SymbolConfigurationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SymbolConfigurationPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.service.ClpSerializer.getServletContextName(),
					SymbolConfigurationPersistence.class.getName());

			ReferenceRegistry.registerReference(SymbolConfigurationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SymbolConfigurationPersistence persistence) {
	}

	private static SymbolConfigurationPersistence _persistence;
}