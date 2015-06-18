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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the symbol type configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see SymbolTypeConfigurationPersistenceImpl
 * @see SymbolTypeConfigurationUtil
 * @generated
 */
public interface SymbolTypeConfigurationPersistence extends BasePersistence<SymbolTypeConfiguration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SymbolTypeConfigurationUtil} to access the symbol type configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the symbol type configuration where symboltype = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException} if it could not be found.
	*
	* @param symboltype the symboltype
	* @return the matching symbol type configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException if a matching symbol type configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration findByFieldSymbolType(
		java.lang.String symboltype)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the symbol type configuration where symboltype = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param symboltype the symboltype
	* @return the matching symbol type configuration, or <code>null</code> if a matching symbol type configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration fetchByFieldSymbolType(
		java.lang.String symboltype)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the symbol type configuration where symboltype = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param symboltype the symboltype
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching symbol type configuration, or <code>null</code> if a matching symbol type configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration fetchByFieldSymbolType(
		java.lang.String symboltype, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the symbol type configuration where symboltype = &#63; from the database.
	*
	* @param symboltype the symboltype
	* @return the symbol type configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration removeByFieldSymbolType(
		java.lang.String symboltype)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of symbol type configurations where symboltype = &#63;.
	*
	* @param symboltype the symboltype
	* @return the number of matching symbol type configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countByFieldSymbolType(java.lang.String symboltype)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the symbol type configuration in the entity cache if it is enabled.
	*
	* @param symbolTypeConfiguration the symbol type configuration
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration symbolTypeConfiguration);

	/**
	* Caches the symbol type configurations in the entity cache if it is enabled.
	*
	* @param symbolTypeConfigurations the symbol type configurations
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration> symbolTypeConfigurations);

	/**
	* Creates a new symbol type configuration with the primary key. Does not add the symbol type configuration to the database.
	*
	* @param symboltypeconfigurationId the primary key for the new symbol type configuration
	* @return the new symbol type configuration
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration create(
		long symboltypeconfigurationId);

	/**
	* Removes the symbol type configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param symboltypeconfigurationId the primary key of the symbol type configuration
	* @return the symbol type configuration that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException if a symbol type configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration remove(
		long symboltypeconfigurationId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration symbolTypeConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the symbol type configuration with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException} if it could not be found.
	*
	* @param symboltypeconfigurationId the primary key of the symbol type configuration
	* @return the symbol type configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException if a symbol type configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration findByPrimaryKey(
		long symboltypeconfigurationId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the symbol type configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param symboltypeconfigurationId the primary key of the symbol type configuration
	* @return the symbol type configuration, or <code>null</code> if a symbol type configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration fetchByPrimaryKey(
		long symboltypeconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the symbol type configurations.
	*
	* @return the symbol type configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the symbol type configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of symbol type configurations.
	*
	* @return the number of symbol type configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}