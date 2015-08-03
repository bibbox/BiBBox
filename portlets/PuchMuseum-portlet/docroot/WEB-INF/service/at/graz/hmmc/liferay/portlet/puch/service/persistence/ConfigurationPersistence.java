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

import at.graz.hmmc.liferay.portlet.puch.model.Configuration;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ConfigurationPersistenceImpl
 * @see ConfigurationUtil
 * @generated
 */
public interface ConfigurationPersistence extends BasePersistence<Configuration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConfigurationUtil} to access the configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the configuration where scope = &#63; and optionkey = &#63; or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException} if it could not be found.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the matching configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration findByoptionFinder(
		java.lang.String scope, java.lang.String optionkey)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuration where scope = &#63; and optionkey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByoptionFinder(
		java.lang.String scope, java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuration where scope = &#63; and optionkey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByoptionFinder(
		java.lang.String scope, java.lang.String optionkey,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the configuration where scope = &#63; and optionkey = &#63; from the database.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration removeByoptionFinder(
		java.lang.String scope, java.lang.String optionkey)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of configurations where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the number of matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countByoptionFinder(java.lang.String scope,
		java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuration where scope = &#63; and optionvalue = &#63; or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException} if it could not be found.
	*
	* @param scope the scope
	* @param optionvalue the optionvalue
	* @return the matching configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration findByoptionsFinderValue(
		java.lang.String scope, java.lang.String optionvalue)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuration where scope = &#63; and optionvalue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param scope the scope
	* @param optionvalue the optionvalue
	* @return the matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByoptionsFinderValue(
		java.lang.String scope, java.lang.String optionvalue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuration where scope = &#63; and optionvalue = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param scope the scope
	* @param optionvalue the optionvalue
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByoptionsFinderValue(
		java.lang.String scope, java.lang.String optionvalue,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the configuration where scope = &#63; and optionvalue = &#63; from the database.
	*
	* @param scope the scope
	* @param optionvalue the optionvalue
	* @return the configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration removeByoptionsFinderValue(
		java.lang.String scope, java.lang.String optionvalue)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of configurations where scope = &#63; and optionvalue = &#63;.
	*
	* @param scope the scope
	* @param optionvalue the optionvalue
	* @return the number of matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countByoptionsFinderValue(java.lang.String scope,
		java.lang.String optionvalue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the configurations where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByoptionsFinderKey(
		java.lang.String scope, java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the configurations where scope = &#63; and optionkey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @param start the lower bound of the range of configurations
	* @param end the upper bound of the range of configurations (not inclusive)
	* @return the range of matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByoptionsFinderKey(
		java.lang.String scope, java.lang.String optionkey, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the configurations where scope = &#63; and optionkey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @param start the lower bound of the range of configurations
	* @param end the upper bound of the range of configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByoptionsFinderKey(
		java.lang.String scope, java.lang.String optionkey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration findByoptionsFinderKey_First(
		java.lang.String scope, java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByoptionsFinderKey_First(
		java.lang.String scope, java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration findByoptionsFinderKey_Last(
		java.lang.String scope, java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByoptionsFinderKey_Last(
		java.lang.String scope, java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configurations before and after the current configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	*
	* @param configurationId the primary key of the current configuration
	* @param scope the scope
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration[] findByoptionsFinderKey_PrevAndNext(
		long configurationId, java.lang.String scope,
		java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the configurations where scope = &#63; and optionkey = &#63; from the database.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @throws SystemException if a system exception occurred
	*/
	public void removeByoptionsFinderKey(java.lang.String scope,
		java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of configurations where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the number of matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countByoptionsFinderKey(java.lang.String scope,
		java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the configurations where scope = &#63;.
	*
	* @param scope the scope
	* @return the matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByoptionsFinder(
		java.lang.String scope)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the configurations where scope = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scope the scope
	* @param start the lower bound of the range of configurations
	* @param end the upper bound of the range of configurations (not inclusive)
	* @return the range of matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByoptionsFinder(
		java.lang.String scope, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the configurations where scope = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scope the scope
	* @param start the lower bound of the range of configurations
	* @param end the upper bound of the range of configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByoptionsFinder(
		java.lang.String scope, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first configuration in the ordered set where scope = &#63;.
	*
	* @param scope the scope
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration findByoptionsFinder_First(
		java.lang.String scope,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first configuration in the ordered set where scope = &#63;.
	*
	* @param scope the scope
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByoptionsFinder_First(
		java.lang.String scope,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last configuration in the ordered set where scope = &#63;.
	*
	* @param scope the scope
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration findByoptionsFinder_Last(
		java.lang.String scope,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last configuration in the ordered set where scope = &#63;.
	*
	* @param scope the scope
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByoptionsFinder_Last(
		java.lang.String scope,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configurations before and after the current configuration in the ordered set where scope = &#63;.
	*
	* @param configurationId the primary key of the current configuration
	* @param scope the scope
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration[] findByoptionsFinder_PrevAndNext(
		long configurationId, java.lang.String scope,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the configurations where scope = &#63; from the database.
	*
	* @param scope the scope
	* @throws SystemException if a system exception occurred
	*/
	public void removeByoptionsFinder(java.lang.String scope)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of configurations where scope = &#63;.
	*
	* @param scope the scope
	* @return the number of matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countByoptionsFinder(java.lang.String scope)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the configurations where optionkey = &#63;.
	*
	* @param optionkey the optionkey
	* @return the matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByOptionsFinderForKey(
		java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the configurations where optionkey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param optionkey the optionkey
	* @param start the lower bound of the range of configurations
	* @param end the upper bound of the range of configurations (not inclusive)
	* @return the range of matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByOptionsFinderForKey(
		java.lang.String optionkey, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the configurations where optionkey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param optionkey the optionkey
	* @param start the lower bound of the range of configurations
	* @param end the upper bound of the range of configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByOptionsFinderForKey(
		java.lang.String optionkey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first configuration in the ordered set where optionkey = &#63;.
	*
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration findByOptionsFinderForKey_First(
		java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first configuration in the ordered set where optionkey = &#63;.
	*
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByOptionsFinderForKey_First(
		java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last configuration in the ordered set where optionkey = &#63;.
	*
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration findByOptionsFinderForKey_Last(
		java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last configuration in the ordered set where optionkey = &#63;.
	*
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByOptionsFinderForKey_Last(
		java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configurations before and after the current configuration in the ordered set where optionkey = &#63;.
	*
	* @param configurationId the primary key of the current configuration
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration[] findByOptionsFinderForKey_PrevAndNext(
		long configurationId, java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the configurations where optionkey = &#63; from the database.
	*
	* @param optionkey the optionkey
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOptionsFinderForKey(java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of configurations where optionkey = &#63;.
	*
	* @param optionkey the optionkey
	* @return the number of matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countByOptionsFinderForKey(java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the configuration in the entity cache if it is enabled.
	*
	* @param configuration the configuration
	*/
	public void cacheResult(
		at.graz.hmmc.liferay.portlet.puch.model.Configuration configuration);

	/**
	* Caches the configurations in the entity cache if it is enabled.
	*
	* @param configurations the configurations
	*/
	public void cacheResult(
		java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> configurations);

	/**
	* Creates a new configuration with the primary key. Does not add the configuration to the database.
	*
	* @param configurationId the primary key for the new configuration
	* @return the new configuration
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration create(
		long configurationId);

	/**
	* Removes the configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configurationId the primary key of the configuration
	* @return the configuration that was removed
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration remove(
		long configurationId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.hmmc.liferay.portlet.puch.model.Configuration updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.Configuration configuration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuration with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException} if it could not be found.
	*
	* @param configurationId the primary key of the configuration
	* @return the configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration findByPrimaryKey(
		long configurationId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param configurationId the primary key of the configuration
	* @return the configuration, or <code>null</code> if a configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByPrimaryKey(
		long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the configurations.
	*
	* @return the configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of configurations
	* @param end the upper bound of the range of configurations (not inclusive)
	* @return the range of configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of configurations
	* @param end the upper bound of the range of configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of configurations.
	*
	* @return the number of configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}