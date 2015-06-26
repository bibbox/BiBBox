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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the icon configuration service. This utility wraps {@link IconConfigurationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see IconConfigurationPersistence
 * @see IconConfigurationPersistenceImpl
 * @generated
 */
public class IconConfigurationUtil {
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
	public static void clearCache(IconConfiguration iconConfiguration) {
		getPersistence().clearCache(iconConfiguration);
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
	public static List<IconConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<IconConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<IconConfiguration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static IconConfiguration update(IconConfiguration iconConfiguration)
		throws SystemException {
		return getPersistence().update(iconConfiguration);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static IconConfiguration update(
		IconConfiguration iconConfiguration, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(iconConfiguration, serviceContext);
	}

	/**
	* Returns all the icon configurations where symbolconfigurationId = &#63; and position = &#63;.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param position the position
	* @return the matching icon configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration> findByIconsPosition(
		long symbolconfigurationId, java.lang.String position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIconsPosition(symbolconfigurationId, position);
	}

	/**
	* Returns a range of all the icon configurations where symbolconfigurationId = &#63; and position = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param position the position
	* @param start the lower bound of the range of icon configurations
	* @param end the upper bound of the range of icon configurations (not inclusive)
	* @return the range of matching icon configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration> findByIconsPosition(
		long symbolconfigurationId, java.lang.String position, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIconsPosition(symbolconfigurationId, position, start,
			end);
	}

	/**
	* Returns an ordered range of all the icon configurations where symbolconfigurationId = &#63; and position = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param position the position
	* @param start the lower bound of the range of icon configurations
	* @param end the upper bound of the range of icon configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching icon configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration> findByIconsPosition(
		long symbolconfigurationId, java.lang.String position, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIconsPosition(symbolconfigurationId, position, start,
			end, orderByComparator);
	}

	/**
	* Returns the first icon configuration in the ordered set where symbolconfigurationId = &#63; and position = &#63;.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param position the position
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching icon configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a matching icon configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration findByIconsPosition_First(
		long symbolconfigurationId, java.lang.String position,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIconsPosition_First(symbolconfigurationId, position,
			orderByComparator);
	}

	/**
	* Returns the first icon configuration in the ordered set where symbolconfigurationId = &#63; and position = &#63;.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param position the position
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching icon configuration, or <code>null</code> if a matching icon configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration fetchByIconsPosition_First(
		long symbolconfigurationId, java.lang.String position,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIconsPosition_First(symbolconfigurationId, position,
			orderByComparator);
	}

	/**
	* Returns the last icon configuration in the ordered set where symbolconfigurationId = &#63; and position = &#63;.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param position the position
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching icon configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a matching icon configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration findByIconsPosition_Last(
		long symbolconfigurationId, java.lang.String position,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIconsPosition_Last(symbolconfigurationId, position,
			orderByComparator);
	}

	/**
	* Returns the last icon configuration in the ordered set where symbolconfigurationId = &#63; and position = &#63;.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param position the position
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching icon configuration, or <code>null</code> if a matching icon configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration fetchByIconsPosition_Last(
		long symbolconfigurationId, java.lang.String position,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIconsPosition_Last(symbolconfigurationId, position,
			orderByComparator);
	}

	/**
	* Returns the icon configurations before and after the current icon configuration in the ordered set where symbolconfigurationId = &#63; and position = &#63;.
	*
	* @param iconconfigurationId the primary key of the current icon configuration
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param position the position
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next icon configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a icon configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration[] findByIconsPosition_PrevAndNext(
		long iconconfigurationId, long symbolconfigurationId,
		java.lang.String position,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIconsPosition_PrevAndNext(iconconfigurationId,
			symbolconfigurationId, position, orderByComparator);
	}

	/**
	* Removes all the icon configurations where symbolconfigurationId = &#63; and position = &#63; from the database.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param position the position
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIconsPosition(long symbolconfigurationId,
		java.lang.String position)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIconsPosition(symbolconfigurationId, position);
	}

	/**
	* Returns the number of icon configurations where symbolconfigurationId = &#63; and position = &#63;.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param position the position
	* @return the number of matching icon configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIconsPosition(long symbolconfigurationId,
		java.lang.String position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByIconsPosition(symbolconfigurationId, position);
	}

	/**
	* Returns all the icon configurations where symbolconfigurationId = &#63; and key = &#63;.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param key the key
	* @return the matching icon configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration> findByIconsKey(
		long symbolconfigurationId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIconsKey(symbolconfigurationId, key);
	}

	/**
	* Returns a range of all the icon configurations where symbolconfigurationId = &#63; and key = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param key the key
	* @param start the lower bound of the range of icon configurations
	* @param end the upper bound of the range of icon configurations (not inclusive)
	* @return the range of matching icon configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration> findByIconsKey(
		long symbolconfigurationId, java.lang.String key, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIconsKey(symbolconfigurationId, key, start, end);
	}

	/**
	* Returns an ordered range of all the icon configurations where symbolconfigurationId = &#63; and key = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param key the key
	* @param start the lower bound of the range of icon configurations
	* @param end the upper bound of the range of icon configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching icon configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration> findByIconsKey(
		long symbolconfigurationId, java.lang.String key, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIconsKey(symbolconfigurationId, key, start, end,
			orderByComparator);
	}

	/**
	* Returns the first icon configuration in the ordered set where symbolconfigurationId = &#63; and key = &#63;.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching icon configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a matching icon configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration findByIconsKey_First(
		long symbolconfigurationId, java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIconsKey_First(symbolconfigurationId, key,
			orderByComparator);
	}

	/**
	* Returns the first icon configuration in the ordered set where symbolconfigurationId = &#63; and key = &#63;.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching icon configuration, or <code>null</code> if a matching icon configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration fetchByIconsKey_First(
		long symbolconfigurationId, java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIconsKey_First(symbolconfigurationId, key,
			orderByComparator);
	}

	/**
	* Returns the last icon configuration in the ordered set where symbolconfigurationId = &#63; and key = &#63;.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching icon configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a matching icon configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration findByIconsKey_Last(
		long symbolconfigurationId, java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIconsKey_Last(symbolconfigurationId, key,
			orderByComparator);
	}

	/**
	* Returns the last icon configuration in the ordered set where symbolconfigurationId = &#63; and key = &#63;.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching icon configuration, or <code>null</code> if a matching icon configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration fetchByIconsKey_Last(
		long symbolconfigurationId, java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIconsKey_Last(symbolconfigurationId, key,
			orderByComparator);
	}

	/**
	* Returns the icon configurations before and after the current icon configuration in the ordered set where symbolconfigurationId = &#63; and key = &#63;.
	*
	* @param iconconfigurationId the primary key of the current icon configuration
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next icon configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a icon configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration[] findByIconsKey_PrevAndNext(
		long iconconfigurationId, long symbolconfigurationId,
		java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIconsKey_PrevAndNext(iconconfigurationId,
			symbolconfigurationId, key, orderByComparator);
	}

	/**
	* Removes all the icon configurations where symbolconfigurationId = &#63; and key = &#63; from the database.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param key the key
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIconsKey(long symbolconfigurationId,
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIconsKey(symbolconfigurationId, key);
	}

	/**
	* Returns the number of icon configurations where symbolconfigurationId = &#63; and key = &#63;.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param key the key
	* @return the number of matching icon configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIconsKey(long symbolconfigurationId,
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIconsKey(symbolconfigurationId, key);
	}

	/**
	* Returns the icon configuration where symbolconfigurationId = &#63; and key = &#63; and position = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException} if it could not be found.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param key the key
	* @param position the position
	* @return the matching icon configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a matching icon configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration findByIconsKeyPosition(
		long symbolconfigurationId, java.lang.String key,
		java.lang.String position)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIconsKeyPosition(symbolconfigurationId, key, position);
	}

	/**
	* Returns the icon configuration where symbolconfigurationId = &#63; and key = &#63; and position = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param key the key
	* @param position the position
	* @return the matching icon configuration, or <code>null</code> if a matching icon configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration fetchByIconsKeyPosition(
		long symbolconfigurationId, java.lang.String key,
		java.lang.String position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIconsKeyPosition(symbolconfigurationId, key, position);
	}

	/**
	* Returns the icon configuration where symbolconfigurationId = &#63; and key = &#63; and position = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param key the key
	* @param position the position
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching icon configuration, or <code>null</code> if a matching icon configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration fetchByIconsKeyPosition(
		long symbolconfigurationId, java.lang.String key,
		java.lang.String position, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIconsKeyPosition(symbolconfigurationId, key,
			position, retrieveFromCache);
	}

	/**
	* Removes the icon configuration where symbolconfigurationId = &#63; and key = &#63; and position = &#63; from the database.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param key the key
	* @param position the position
	* @return the icon configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration removeByIconsKeyPosition(
		long symbolconfigurationId, java.lang.String key,
		java.lang.String position)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByIconsKeyPosition(symbolconfigurationId, key,
			position);
	}

	/**
	* Returns the number of icon configurations where symbolconfigurationId = &#63; and key = &#63; and position = &#63;.
	*
	* @param symbolconfigurationId the symbolconfiguration ID
	* @param key the key
	* @param position the position
	* @return the number of matching icon configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIconsKeyPosition(long symbolconfigurationId,
		java.lang.String key, java.lang.String position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByIconsKeyPosition(symbolconfigurationId, key, position);
	}

	/**
	* Caches the icon configuration in the entity cache if it is enabled.
	*
	* @param iconConfiguration the icon configuration
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration iconConfiguration) {
		getPersistence().cacheResult(iconConfiguration);
	}

	/**
	* Caches the icon configurations in the entity cache if it is enabled.
	*
	* @param iconConfigurations the icon configurations
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration> iconConfigurations) {
		getPersistence().cacheResult(iconConfigurations);
	}

	/**
	* Creates a new icon configuration with the primary key. Does not add the icon configuration to the database.
	*
	* @param iconconfigurationId the primary key for the new icon configuration
	* @return the new icon configuration
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration create(
		long iconconfigurationId) {
		return getPersistence().create(iconconfigurationId);
	}

	/**
	* Removes the icon configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param iconconfigurationId the primary key of the icon configuration
	* @return the icon configuration that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a icon configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration remove(
		long iconconfigurationId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(iconconfigurationId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration iconConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(iconConfiguration);
	}

	/**
	* Returns the icon configuration with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException} if it could not be found.
	*
	* @param iconconfigurationId the primary key of the icon configuration
	* @return the icon configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a icon configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration findByPrimaryKey(
		long iconconfigurationId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(iconconfigurationId);
	}

	/**
	* Returns the icon configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param iconconfigurationId the primary key of the icon configuration
	* @return the icon configuration, or <code>null</code> if a icon configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration fetchByPrimaryKey(
		long iconconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(iconconfigurationId);
	}

	/**
	* Returns all the icon configurations.
	*
	* @return the icon configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the icon configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of icon configurations.
	*
	* @return the number of icon configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static IconConfigurationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (IconConfigurationPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.service.ClpSerializer.getServletContextName(),
					IconConfigurationPersistence.class.getName());

			ReferenceRegistry.registerReference(IconConfigurationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(IconConfigurationPersistence persistence) {
	}

	private static IconConfigurationPersistence _persistence;
}