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

package at.graz.meduni.liferay.portlet.bibbox.service.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the importer config service. This utility wraps {@link ImporterConfigPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ImporterConfigPersistence
 * @see ImporterConfigPersistenceImpl
 * @generated
 */
public class ImporterConfigUtil {
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
	public static void clearCache(ImporterConfig importerConfig) {
		getPersistence().clearCache(importerConfig);
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
	public static List<ImporterConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ImporterConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ImporterConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ImporterConfig update(ImporterConfig importerConfig)
		throws SystemException {
		return getPersistence().update(importerConfig);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ImporterConfig update(ImporterConfig importerConfig,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(importerConfig, serviceContext);
	}

	/**
	* Returns all the importer configs where scope = &#63; and elementId = &#63;.
	*
	* @param scope the scope
	* @param elementId the element ID
	* @return the matching importer configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig> findByImporterConfig(
		java.lang.String scope, java.lang.String elementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByImporterConfig(scope, elementId);
	}

	/**
	* Returns a range of all the importer configs where scope = &#63; and elementId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.ImporterConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scope the scope
	* @param elementId the element ID
	* @param start the lower bound of the range of importer configs
	* @param end the upper bound of the range of importer configs (not inclusive)
	* @return the range of matching importer configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig> findByImporterConfig(
		java.lang.String scope, java.lang.String elementId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByImporterConfig(scope, elementId, start, end);
	}

	/**
	* Returns an ordered range of all the importer configs where scope = &#63; and elementId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.ImporterConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scope the scope
	* @param elementId the element ID
	* @param start the lower bound of the range of importer configs
	* @param end the upper bound of the range of importer configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching importer configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig> findByImporterConfig(
		java.lang.String scope, java.lang.String elementId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByImporterConfig(scope, elementId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first importer config in the ordered set where scope = &#63; and elementId = &#63;.
	*
	* @param scope the scope
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching importer config
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a matching importer config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig findByImporterConfig_First(
		java.lang.String scope, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByImporterConfig_First(scope, elementId,
			orderByComparator);
	}

	/**
	* Returns the first importer config in the ordered set where scope = &#63; and elementId = &#63;.
	*
	* @param scope the scope
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching importer config, or <code>null</code> if a matching importer config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig fetchByImporterConfig_First(
		java.lang.String scope, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByImporterConfig_First(scope, elementId,
			orderByComparator);
	}

	/**
	* Returns the last importer config in the ordered set where scope = &#63; and elementId = &#63;.
	*
	* @param scope the scope
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching importer config
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a matching importer config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig findByImporterConfig_Last(
		java.lang.String scope, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByImporterConfig_Last(scope, elementId,
			orderByComparator);
	}

	/**
	* Returns the last importer config in the ordered set where scope = &#63; and elementId = &#63;.
	*
	* @param scope the scope
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching importer config, or <code>null</code> if a matching importer config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig fetchByImporterConfig_Last(
		java.lang.String scope, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByImporterConfig_Last(scope, elementId,
			orderByComparator);
	}

	/**
	* Returns the importer configs before and after the current importer config in the ordered set where scope = &#63; and elementId = &#63;.
	*
	* @param importerconfigId the primary key of the current importer config
	* @param scope the scope
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next importer config
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a importer config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig[] findByImporterConfig_PrevAndNext(
		long importerconfigId, java.lang.String scope,
		java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByImporterConfig_PrevAndNext(importerconfigId, scope,
			elementId, orderByComparator);
	}

	/**
	* Removes all the importer configs where scope = &#63; and elementId = &#63; from the database.
	*
	* @param scope the scope
	* @param elementId the element ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByImporterConfig(java.lang.String scope,
		java.lang.String elementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByImporterConfig(scope, elementId);
	}

	/**
	* Returns the number of importer configs where scope = &#63; and elementId = &#63;.
	*
	* @param scope the scope
	* @param elementId the element ID
	* @return the number of matching importer configs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByImporterConfig(java.lang.String scope,
		java.lang.String elementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByImporterConfig(scope, elementId);
	}

	/**
	* Caches the importer config in the entity cache if it is enabled.
	*
	* @param importerConfig the importer config
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig importerConfig) {
		getPersistence().cacheResult(importerConfig);
	}

	/**
	* Caches the importer configs in the entity cache if it is enabled.
	*
	* @param importerConfigs the importer configs
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig> importerConfigs) {
		getPersistence().cacheResult(importerConfigs);
	}

	/**
	* Creates a new importer config with the primary key. Does not add the importer config to the database.
	*
	* @param importerconfigId the primary key for the new importer config
	* @return the new importer config
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig create(
		long importerconfigId) {
		return getPersistence().create(importerconfigId);
	}

	/**
	* Removes the importer config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param importerconfigId the primary key of the importer config
	* @return the importer config that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a importer config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig remove(
		long importerconfigId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(importerconfigId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig importerConfig)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(importerConfig);
	}

	/**
	* Returns the importer config with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException} if it could not be found.
	*
	* @param importerconfigId the primary key of the importer config
	* @return the importer config
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a importer config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig findByPrimaryKey(
		long importerconfigId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(importerconfigId);
	}

	/**
	* Returns the importer config with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param importerconfigId the primary key of the importer config
	* @return the importer config, or <code>null</code> if a importer config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig fetchByPrimaryKey(
		long importerconfigId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(importerconfigId);
	}

	/**
	* Returns all the importer configs.
	*
	* @return the importer configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the importer configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.ImporterConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of importer configs
	* @param end the upper bound of the range of importer configs (not inclusive)
	* @return the range of importer configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the importer configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.ImporterConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of importer configs
	* @param end the upper bound of the range of importer configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of importer configs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the importer configs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of importer configs.
	*
	* @return the number of importer configs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ImporterConfigPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ImporterConfigPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.service.service.ClpSerializer.getServletContextName(),
					ImporterConfigPersistence.class.getName());

			ReferenceRegistry.registerReference(ImporterConfigUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ImporterConfigPersistence persistence) {
	}

	private static ImporterConfigPersistence _persistence;
}