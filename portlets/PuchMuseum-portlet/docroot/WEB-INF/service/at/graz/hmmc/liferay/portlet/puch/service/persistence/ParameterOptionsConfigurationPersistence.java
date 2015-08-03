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

import at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the parameter options configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ParameterOptionsConfigurationPersistenceImpl
 * @see ParameterOptionsConfigurationUtil
 * @generated
 */
public interface ParameterOptionsConfigurationPersistence
	extends BasePersistence<ParameterOptionsConfiguration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ParameterOptionsConfigurationUtil} to access the parameter options configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the parameter options configurations where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @return the matching parameter options configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration> findByOptionsForParameter(
		long parameterconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the parameter options configurations where parameterconfigurationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterOptionsConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param start the lower bound of the range of parameter options configurations
	* @param end the upper bound of the range of parameter options configurations (not inclusive)
	* @return the range of matching parameter options configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration> findByOptionsForParameter(
		long parameterconfigurationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the parameter options configurations where parameterconfigurationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterOptionsConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param start the lower bound of the range of parameter options configurations
	* @param end the upper bound of the range of parameter options configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching parameter options configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration> findByOptionsForParameter(
		long parameterconfigurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first parameter options configuration in the ordered set where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching parameter options configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException if a matching parameter options configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration findByOptionsForParameter_First(
		long parameterconfigurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first parameter options configuration in the ordered set where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching parameter options configuration, or <code>null</code> if a matching parameter options configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration fetchByOptionsForParameter_First(
		long parameterconfigurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last parameter options configuration in the ordered set where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching parameter options configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException if a matching parameter options configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration findByOptionsForParameter_Last(
		long parameterconfigurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last parameter options configuration in the ordered set where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching parameter options configuration, or <code>null</code> if a matching parameter options configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration fetchByOptionsForParameter_Last(
		long parameterconfigurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the parameter options configurations before and after the current parameter options configuration in the ordered set where parameterconfigurationId = &#63;.
	*
	* @param parameteroptionsconfigurationId the primary key of the current parameter options configuration
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next parameter options configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException if a parameter options configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration[] findByOptionsForParameter_PrevAndNext(
		long parameteroptionsconfigurationId, long parameterconfigurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the parameter options configurations where parameterconfigurationId = &#63; from the database.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOptionsForParameter(long parameterconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of parameter options configurations where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @return the number of matching parameter options configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countByOptionsForParameter(long parameterconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the parameter options configuration in the entity cache if it is enabled.
	*
	* @param parameterOptionsConfiguration the parameter options configuration
	*/
	public void cacheResult(
		at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration parameterOptionsConfiguration);

	/**
	* Caches the parameter options configurations in the entity cache if it is enabled.
	*
	* @param parameterOptionsConfigurations the parameter options configurations
	*/
	public void cacheResult(
		java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration> parameterOptionsConfigurations);

	/**
	* Creates a new parameter options configuration with the primary key. Does not add the parameter options configuration to the database.
	*
	* @param parameteroptionsconfigurationId the primary key for the new parameter options configuration
	* @return the new parameter options configuration
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration create(
		long parameteroptionsconfigurationId);

	/**
	* Removes the parameter options configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param parameteroptionsconfigurationId the primary key of the parameter options configuration
	* @return the parameter options configuration that was removed
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException if a parameter options configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration remove(
		long parameteroptionsconfigurationId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration parameterOptionsConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the parameter options configuration with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException} if it could not be found.
	*
	* @param parameteroptionsconfigurationId the primary key of the parameter options configuration
	* @return the parameter options configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException if a parameter options configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration findByPrimaryKey(
		long parameteroptionsconfigurationId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the parameter options configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param parameteroptionsconfigurationId the primary key of the parameter options configuration
	* @return the parameter options configuration, or <code>null</code> if a parameter options configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration fetchByPrimaryKey(
		long parameteroptionsconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the parameter options configurations.
	*
	* @return the parameter options configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the parameter options configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterOptionsConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of parameter options configurations
	* @param end the upper bound of the range of parameter options configurations (not inclusive)
	* @return the range of parameter options configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the parameter options configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterOptionsConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of parameter options configurations
	* @param end the upper bound of the range of parameter options configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of parameter options configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the parameter options configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of parameter options configurations.
	*
	* @return the number of parameter options configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}