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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the symbol configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see SymbolConfigurationPersistenceImpl
 * @see SymbolConfigurationUtil
 * @generated
 */
public interface SymbolConfigurationPersistence extends BasePersistence<SymbolConfiguration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SymbolConfigurationUtil} to access the symbol configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the symbol configuration where scope = &#63; and eventtype = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException} if it could not be found.
	*
	* @param scope the scope
	* @param eventtype the eventtype
	* @return the matching symbol configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException if a matching symbol configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration findByFieldSymbol(
		java.lang.String scope, java.lang.String eventtype)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the symbol configuration where scope = &#63; and eventtype = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param scope the scope
	* @param eventtype the eventtype
	* @return the matching symbol configuration, or <code>null</code> if a matching symbol configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration fetchByFieldSymbol(
		java.lang.String scope, java.lang.String eventtype)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the symbol configuration where scope = &#63; and eventtype = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param scope the scope
	* @param eventtype the eventtype
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching symbol configuration, or <code>null</code> if a matching symbol configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration fetchByFieldSymbol(
		java.lang.String scope, java.lang.String eventtype,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the symbol configuration where scope = &#63; and eventtype = &#63; from the database.
	*
	* @param scope the scope
	* @param eventtype the eventtype
	* @return the symbol configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration removeByFieldSymbol(
		java.lang.String scope, java.lang.String eventtype)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of symbol configurations where scope = &#63; and eventtype = &#63;.
	*
	* @param scope the scope
	* @param eventtype the eventtype
	* @return the number of matching symbol configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countByFieldSymbol(java.lang.String scope,
		java.lang.String eventtype)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the symbol configuration in the entity cache if it is enabled.
	*
	* @param symbolConfiguration the symbol configuration
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration symbolConfiguration);

	/**
	* Caches the symbol configurations in the entity cache if it is enabled.
	*
	* @param symbolConfigurations the symbol configurations
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration> symbolConfigurations);

	/**
	* Creates a new symbol configuration with the primary key. Does not add the symbol configuration to the database.
	*
	* @param symbolconfigurationId the primary key for the new symbol configuration
	* @return the new symbol configuration
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration create(
		long symbolconfigurationId);

	/**
	* Removes the symbol configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param symbolconfigurationId the primary key of the symbol configuration
	* @return the symbol configuration that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException if a symbol configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration remove(
		long symbolconfigurationId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration symbolConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the symbol configuration with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException} if it could not be found.
	*
	* @param symbolconfigurationId the primary key of the symbol configuration
	* @return the symbol configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException if a symbol configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration findByPrimaryKey(
		long symbolconfigurationId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the symbol configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param symbolconfigurationId the primary key of the symbol configuration
	* @return the symbol configuration, or <code>null</code> if a symbol configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration fetchByPrimaryKey(
		long symbolconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the symbol configurations.
	*
	* @return the symbol configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the symbol configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of symbol configurations.
	*
	* @return the number of symbol configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}