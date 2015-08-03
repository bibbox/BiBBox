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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the configuration service. This utility wraps {@link ConfigurationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ConfigurationPersistence
 * @see ConfigurationPersistenceImpl
 * @generated
 */
public class ConfigurationUtil {
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
	public static void clearCache(Configuration configuration) {
		getPersistence().clearCache(configuration);
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
	public static List<Configuration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Configuration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Configuration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Configuration update(Configuration configuration)
		throws SystemException {
		return getPersistence().update(configuration);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Configuration update(Configuration configuration,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(configuration, serviceContext);
	}

	/**
	* Returns the configuration where scope = &#63; and optionkey = &#63; or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException} if it could not be found.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the matching configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration findByoptionFinder(
		java.lang.String scope, java.lang.String optionkey)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByoptionFinder(scope, optionkey);
	}

	/**
	* Returns the configuration where scope = &#63; and optionkey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByoptionFinder(
		java.lang.String scope, java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByoptionFinder(scope, optionkey);
	}

	/**
	* Returns the configuration where scope = &#63; and optionkey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByoptionFinder(
		java.lang.String scope, java.lang.String optionkey,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByoptionFinder(scope, optionkey, retrieveFromCache);
	}

	/**
	* Removes the configuration where scope = &#63; and optionkey = &#63; from the database.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration removeByoptionFinder(
		java.lang.String scope, java.lang.String optionkey)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByoptionFinder(scope, optionkey);
	}

	/**
	* Returns the number of configurations where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the number of matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByoptionFinder(java.lang.String scope,
		java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByoptionFinder(scope, optionkey);
	}

	/**
	* Returns the configuration where scope = &#63; and optionvalue = &#63; or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException} if it could not be found.
	*
	* @param scope the scope
	* @param optionvalue the optionvalue
	* @return the matching configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration findByoptionsFinderValue(
		java.lang.String scope, java.lang.String optionvalue)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByoptionsFinderValue(scope, optionvalue);
	}

	/**
	* Returns the configuration where scope = &#63; and optionvalue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param scope the scope
	* @param optionvalue the optionvalue
	* @return the matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByoptionsFinderValue(
		java.lang.String scope, java.lang.String optionvalue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByoptionsFinderValue(scope, optionvalue);
	}

	/**
	* Returns the configuration where scope = &#63; and optionvalue = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param scope the scope
	* @param optionvalue the optionvalue
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByoptionsFinderValue(
		java.lang.String scope, java.lang.String optionvalue,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByoptionsFinderValue(scope, optionvalue,
			retrieveFromCache);
	}

	/**
	* Removes the configuration where scope = &#63; and optionvalue = &#63; from the database.
	*
	* @param scope the scope
	* @param optionvalue the optionvalue
	* @return the configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration removeByoptionsFinderValue(
		java.lang.String scope, java.lang.String optionvalue)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByoptionsFinderValue(scope, optionvalue);
	}

	/**
	* Returns the number of configurations where scope = &#63; and optionvalue = &#63;.
	*
	* @param scope the scope
	* @param optionvalue the optionvalue
	* @return the number of matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByoptionsFinderValue(java.lang.String scope,
		java.lang.String optionvalue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByoptionsFinderValue(scope, optionvalue);
	}

	/**
	* Returns all the configurations where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByoptionsFinderKey(
		java.lang.String scope, java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByoptionsFinderKey(scope, optionkey);
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByoptionsFinderKey(
		java.lang.String scope, java.lang.String optionkey, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByoptionsFinderKey(scope, optionkey, start, end);
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByoptionsFinderKey(
		java.lang.String scope, java.lang.String optionkey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByoptionsFinderKey(scope, optionkey, start, end,
			orderByComparator);
	}

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
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration findByoptionsFinderKey_First(
		java.lang.String scope, java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByoptionsFinderKey_First(scope, optionkey,
			orderByComparator);
	}

	/**
	* Returns the first configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByoptionsFinderKey_First(
		java.lang.String scope, java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByoptionsFinderKey_First(scope, optionkey,
			orderByComparator);
	}

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
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration findByoptionsFinderKey_Last(
		java.lang.String scope, java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByoptionsFinderKey_Last(scope, optionkey,
			orderByComparator);
	}

	/**
	* Returns the last configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByoptionsFinderKey_Last(
		java.lang.String scope, java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByoptionsFinderKey_Last(scope, optionkey,
			orderByComparator);
	}

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
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration[] findByoptionsFinderKey_PrevAndNext(
		long configurationId, java.lang.String scope,
		java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByoptionsFinderKey_PrevAndNext(configurationId, scope,
			optionkey, orderByComparator);
	}

	/**
	* Removes all the configurations where scope = &#63; and optionkey = &#63; from the database.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByoptionsFinderKey(java.lang.String scope,
		java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByoptionsFinderKey(scope, optionkey);
	}

	/**
	* Returns the number of configurations where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the number of matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByoptionsFinderKey(java.lang.String scope,
		java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByoptionsFinderKey(scope, optionkey);
	}

	/**
	* Returns all the configurations where scope = &#63;.
	*
	* @param scope the scope
	* @return the matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByoptionsFinder(
		java.lang.String scope)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByoptionsFinder(scope);
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByoptionsFinder(
		java.lang.String scope, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByoptionsFinder(scope, start, end);
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByoptionsFinder(
		java.lang.String scope, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByoptionsFinder(scope, start, end, orderByComparator);
	}

	/**
	* Returns the first configuration in the ordered set where scope = &#63;.
	*
	* @param scope the scope
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration findByoptionsFinder_First(
		java.lang.String scope,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByoptionsFinder_First(scope, orderByComparator);
	}

	/**
	* Returns the first configuration in the ordered set where scope = &#63;.
	*
	* @param scope the scope
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByoptionsFinder_First(
		java.lang.String scope,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByoptionsFinder_First(scope, orderByComparator);
	}

	/**
	* Returns the last configuration in the ordered set where scope = &#63;.
	*
	* @param scope the scope
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration findByoptionsFinder_Last(
		java.lang.String scope,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByoptionsFinder_Last(scope, orderByComparator);
	}

	/**
	* Returns the last configuration in the ordered set where scope = &#63;.
	*
	* @param scope the scope
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByoptionsFinder_Last(
		java.lang.String scope,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByoptionsFinder_Last(scope, orderByComparator);
	}

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
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration[] findByoptionsFinder_PrevAndNext(
		long configurationId, java.lang.String scope,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByoptionsFinder_PrevAndNext(configurationId, scope,
			orderByComparator);
	}

	/**
	* Removes all the configurations where scope = &#63; from the database.
	*
	* @param scope the scope
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByoptionsFinder(java.lang.String scope)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByoptionsFinder(scope);
	}

	/**
	* Returns the number of configurations where scope = &#63;.
	*
	* @param scope the scope
	* @return the number of matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByoptionsFinder(java.lang.String scope)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByoptionsFinder(scope);
	}

	/**
	* Returns all the configurations where optionkey = &#63;.
	*
	* @param optionkey the optionkey
	* @return the matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByOptionsFinderForKey(
		java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOptionsFinderForKey(optionkey);
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByOptionsFinderForKey(
		java.lang.String optionkey, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOptionsFinderForKey(optionkey, start, end);
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findByOptionsFinderForKey(
		java.lang.String optionkey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOptionsFinderForKey(optionkey, start, end,
			orderByComparator);
	}

	/**
	* Returns the first configuration in the ordered set where optionkey = &#63;.
	*
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration findByOptionsFinderForKey_First(
		java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOptionsFinderForKey_First(optionkey, orderByComparator);
	}

	/**
	* Returns the first configuration in the ordered set where optionkey = &#63;.
	*
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByOptionsFinderForKey_First(
		java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOptionsFinderForKey_First(optionkey,
			orderByComparator);
	}

	/**
	* Returns the last configuration in the ordered set where optionkey = &#63;.
	*
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration findByOptionsFinderForKey_Last(
		java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOptionsFinderForKey_Last(optionkey, orderByComparator);
	}

	/**
	* Returns the last configuration in the ordered set where optionkey = &#63;.
	*
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching configuration, or <code>null</code> if a matching configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByOptionsFinderForKey_Last(
		java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOptionsFinderForKey_Last(optionkey, orderByComparator);
	}

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
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration[] findByOptionsFinderForKey_PrevAndNext(
		long configurationId, java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOptionsFinderForKey_PrevAndNext(configurationId,
			optionkey, orderByComparator);
	}

	/**
	* Removes all the configurations where optionkey = &#63; from the database.
	*
	* @param optionkey the optionkey
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOptionsFinderForKey(java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOptionsFinderForKey(optionkey);
	}

	/**
	* Returns the number of configurations where optionkey = &#63;.
	*
	* @param optionkey the optionkey
	* @return the number of matching configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOptionsFinderForKey(java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOptionsFinderForKey(optionkey);
	}

	/**
	* Caches the configuration in the entity cache if it is enabled.
	*
	* @param configuration the configuration
	*/
	public static void cacheResult(
		at.graz.hmmc.liferay.portlet.puch.model.Configuration configuration) {
		getPersistence().cacheResult(configuration);
	}

	/**
	* Caches the configurations in the entity cache if it is enabled.
	*
	* @param configurations the configurations
	*/
	public static void cacheResult(
		java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> configurations) {
		getPersistence().cacheResult(configurations);
	}

	/**
	* Creates a new configuration with the primary key. Does not add the configuration to the database.
	*
	* @param configurationId the primary key for the new configuration
	* @return the new configuration
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration create(
		long configurationId) {
		return getPersistence().create(configurationId);
	}

	/**
	* Removes the configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configurationId the primary key of the configuration
	* @return the configuration that was removed
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration remove(
		long configurationId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(configurationId);
	}

	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.Configuration configuration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(configuration);
	}

	/**
	* Returns the configuration with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException} if it could not be found.
	*
	* @param configurationId the primary key of the configuration
	* @return the configuration
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException if a configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration findByPrimaryKey(
		long configurationId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(configurationId);
	}

	/**
	* Returns the configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param configurationId the primary key of the configuration
	* @return the configuration, or <code>null</code> if a configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchByPrimaryKey(
		long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(configurationId);
	}

	/**
	* Returns all the configurations.
	*
	* @return the configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of configurations.
	*
	* @return the number of configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ConfigurationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ConfigurationPersistence)PortletBeanLocatorUtil.locate(at.graz.hmmc.liferay.portlet.puch.service.ClpSerializer.getServletContextName(),
					ConfigurationPersistence.class.getName());

			ReferenceRegistry.registerReference(ConfigurationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ConfigurationPersistence persistence) {
	}

	private static ConfigurationPersistence _persistence;
}