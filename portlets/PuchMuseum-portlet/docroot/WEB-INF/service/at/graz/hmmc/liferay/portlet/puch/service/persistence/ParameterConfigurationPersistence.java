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

package at.graz.hmmc.liferay.portlet.puch.service.persistence;

import at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the parameter configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ParameterConfigurationPersistenceImpl
 * @see ParameterConfigurationUtil
 * @generated
 */
public interface ParameterConfigurationPersistence extends BasePersistence<ParameterConfiguration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ParameterConfigurationUtil} to access the parameter configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the parameter configuration in the entity cache if it is enabled.
	*
	* @param parameterConfiguration the parameter configuration
	*/
	public void cacheResult(
		at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration parameterConfiguration);

	/**
	* Caches the parameter configurations in the entity cache if it is enabled.
	*
	* @param parameterConfigurations the parameter configurations
	*/
	public void cacheResult(
		java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration> parameterConfigurations);

	/**
	* Creates a new parameter configuration with the primary key. Does not add the parameter configuration to the database.
	*
	* @param parameterconfigurationId the primary key for the new parameter configuration
	* @return the new parameter configuration
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration create(
		long parameterconfigurationId);

	/**
	* Removes the parameter configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param parameterconfigurationId the primary key of the parameter configuration
	* @return the parameter configuration that was removed
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterConfigurationException if a parameter configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration remove(
		long parameterconfigurationId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration parameterConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the parameter configuration with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchParameterConfigurationException} if it could not be found.
	*
	* @param parameterconfigurationId the primary key of the parameter configuration
	* @return the parameter configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterConfigurationException if a parameter configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration findByPrimaryKey(
		long parameterconfigurationId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the parameter configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param parameterconfigurationId the primary key of the parameter configuration
	* @return the parameter configuration, or <code>null</code> if a parameter configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration fetchByPrimaryKey(
		long parameterconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the parameter configurations.
	*
	* @return the parameter configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the parameter configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of parameter configurations
	* @param end the upper bound of the range of parameter configurations (not inclusive)
	* @return the range of parameter configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the parameter configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of parameter configurations
	* @param end the upper bound of the range of parameter configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of parameter configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the parameter configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of parameter configurations.
	*
	* @return the number of parameter configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}