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

import at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the icon configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see IconConfigurationPersistenceImpl
 * @see IconConfigurationUtil
 * @generated
 */
public interface IconConfigurationPersistence extends BasePersistence<IconConfiguration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IconConfigurationUtil} to access the icon configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the icon configuration in the entity cache if it is enabled.
	*
	* @param iconConfiguration the icon configuration
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration iconConfiguration);

	/**
	* Caches the icon configurations in the entity cache if it is enabled.
	*
	* @param iconConfigurations the icon configurations
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration> iconConfigurations);

	/**
	* Creates a new icon configuration with the primary key. Does not add the icon configuration to the database.
	*
	* @param iconconfigurationId the primary key for the new icon configuration
	* @return the new icon configuration
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration create(
		long iconconfigurationId);

	/**
	* Removes the icon configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param iconconfigurationId the primary key of the icon configuration
	* @return the icon configuration that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a icon configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration remove(
		long iconconfigurationId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration iconConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the icon configuration with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException} if it could not be found.
	*
	* @param iconconfigurationId the primary key of the icon configuration
	* @return the icon configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a icon configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration findByPrimaryKey(
		long iconconfigurationId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the icon configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param iconconfigurationId the primary key of the icon configuration
	* @return the icon configuration, or <code>null</code> if a icon configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration fetchByPrimaryKey(
		long iconconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the icon configurations.
	*
	* @return the icon configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the icon configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of icon configurations
	* @param end the upper bound of the range of icon configurations (not inclusive)
	* @return the range of icon configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the icon configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of icon configurations
	* @param end the upper bound of the range of icon configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of icon configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the icon configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of icon configurations.
	*
	* @return the number of icon configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}