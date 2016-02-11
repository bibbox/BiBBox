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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the importer config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ImporterConfigPersistenceImpl
 * @see ImporterConfigUtil
 * @generated
 */
public interface ImporterConfigPersistence extends BasePersistence<ImporterConfig> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImporterConfigUtil} to access the importer config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the importer configs where scope = &#63; and elementId = &#63;.
	*
	* @param scope the scope
	* @param elementId the element ID
	* @return the matching importer configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig> findByImporterConfig(
		java.lang.String scope, java.lang.String elementId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig> findByImporterConfig(
		java.lang.String scope, java.lang.String elementId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig> findByImporterConfig(
		java.lang.String scope, java.lang.String elementId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig findByImporterConfig_First(
		java.lang.String scope, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first importer config in the ordered set where scope = &#63; and elementId = &#63;.
	*
	* @param scope the scope
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching importer config, or <code>null</code> if a matching importer config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig fetchByImporterConfig_First(
		java.lang.String scope, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig findByImporterConfig_Last(
		java.lang.String scope, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last importer config in the ordered set where scope = &#63; and elementId = &#63;.
	*
	* @param scope the scope
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching importer config, or <code>null</code> if a matching importer config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig fetchByImporterConfig_Last(
		java.lang.String scope, java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig[] findByImporterConfig_PrevAndNext(
		long importerconfigId, java.lang.String scope,
		java.lang.String elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the importer configs where scope = &#63; and elementId = &#63; from the database.
	*
	* @param scope the scope
	* @param elementId the element ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByImporterConfig(java.lang.String scope,
		java.lang.String elementId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of importer configs where scope = &#63; and elementId = &#63;.
	*
	* @param scope the scope
	* @param elementId the element ID
	* @return the number of matching importer configs
	* @throws SystemException if a system exception occurred
	*/
	public int countByImporterConfig(java.lang.String scope,
		java.lang.String elementId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the importer config in the entity cache if it is enabled.
	*
	* @param importerConfig the importer config
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig importerConfig);

	/**
	* Caches the importer configs in the entity cache if it is enabled.
	*
	* @param importerConfigs the importer configs
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig> importerConfigs);

	/**
	* Creates a new importer config with the primary key. Does not add the importer config to the database.
	*
	* @param importerconfigId the primary key for the new importer config
	* @return the new importer config
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig create(
		long importerconfigId);

	/**
	* Removes the importer config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param importerconfigId the primary key of the importer config
	* @return the importer config that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a importer config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig remove(
		long importerconfigId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig importerConfig)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the importer config with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException} if it could not be found.
	*
	* @param importerconfigId the primary key of the importer config
	* @return the importer config
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a importer config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig findByPrimaryKey(
		long importerconfigId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the importer config with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param importerconfigId the primary key of the importer config
	* @return the importer config, or <code>null</code> if a importer config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig fetchByPrimaryKey(
		long importerconfigId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the importer configs.
	*
	* @return the importer configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the importer configs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of importer configs.
	*
	* @return the number of importer configs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}