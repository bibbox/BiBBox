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

package at.graz.meduni.liferay.portlet.bibbox.service.base;

import at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalService;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.DDLConfigurationPersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.IconConfigurationPersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.SymbolConfigurationPersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.SymbolTypeConfigurationPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the symbol type configuration local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link at.graz.meduni.liferay.portlet.bibbox.service.impl.SymbolTypeConfigurationLocalServiceImpl}.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.impl.SymbolTypeConfigurationLocalServiceImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalServiceUtil
 * @generated
 */
public abstract class SymbolTypeConfigurationLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements SymbolTypeConfigurationLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalServiceUtil} to access the symbol type configuration local service.
	 */

	/**
	 * Adds the symbol type configuration to the database. Also notifies the appropriate model listeners.
	 *
	 * @param symbolTypeConfiguration the symbol type configuration
	 * @return the symbol type configuration that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SymbolTypeConfiguration addSymbolTypeConfiguration(
		SymbolTypeConfiguration symbolTypeConfiguration)
		throws SystemException {
		symbolTypeConfiguration.setNew(true);

		return symbolTypeConfigurationPersistence.update(symbolTypeConfiguration);
	}

	/**
	 * Creates a new symbol type configuration with the primary key. Does not add the symbol type configuration to the database.
	 *
	 * @param symboltypeconfigurationId the primary key for the new symbol type configuration
	 * @return the new symbol type configuration
	 */
	@Override
	public SymbolTypeConfiguration createSymbolTypeConfiguration(
		long symboltypeconfigurationId) {
		return symbolTypeConfigurationPersistence.create(symboltypeconfigurationId);
	}

	/**
	 * Deletes the symbol type configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param symboltypeconfigurationId the primary key of the symbol type configuration
	 * @return the symbol type configuration that was removed
	 * @throws PortalException if a symbol type configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SymbolTypeConfiguration deleteSymbolTypeConfiguration(
		long symboltypeconfigurationId) throws PortalException, SystemException {
		return symbolTypeConfigurationPersistence.remove(symboltypeconfigurationId);
	}

	/**
	 * Deletes the symbol type configuration from the database. Also notifies the appropriate model listeners.
	 *
	 * @param symbolTypeConfiguration the symbol type configuration
	 * @return the symbol type configuration that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SymbolTypeConfiguration deleteSymbolTypeConfiguration(
		SymbolTypeConfiguration symbolTypeConfiguration)
		throws SystemException {
		return symbolTypeConfigurationPersistence.remove(symbolTypeConfiguration);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SymbolTypeConfiguration.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return symbolTypeConfigurationPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolTypeConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return symbolTypeConfigurationPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolTypeConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return symbolTypeConfigurationPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return symbolTypeConfigurationPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return symbolTypeConfigurationPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public SymbolTypeConfiguration fetchSymbolTypeConfiguration(
		long symboltypeconfigurationId) throws SystemException {
		return symbolTypeConfigurationPersistence.fetchByPrimaryKey(symboltypeconfigurationId);
	}

	/**
	 * Returns the symbol type configuration with the primary key.
	 *
	 * @param symboltypeconfigurationId the primary key of the symbol type configuration
	 * @return the symbol type configuration
	 * @throws PortalException if a symbol type configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SymbolTypeConfiguration getSymbolTypeConfiguration(
		long symboltypeconfigurationId) throws PortalException, SystemException {
		return symbolTypeConfigurationPersistence.findByPrimaryKey(symboltypeconfigurationId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return symbolTypeConfigurationPersistence.findByPrimaryKey(primaryKeyObj);
	}

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
	@Override
	public List<SymbolTypeConfiguration> getSymbolTypeConfigurations(
		int start, int end) throws SystemException {
		return symbolTypeConfigurationPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of symbol type configurations.
	 *
	 * @return the number of symbol type configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSymbolTypeConfigurationsCount() throws SystemException {
		return symbolTypeConfigurationPersistence.countAll();
	}

	/**
	 * Updates the symbol type configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param symbolTypeConfiguration the symbol type configuration
	 * @return the symbol type configuration that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SymbolTypeConfiguration updateSymbolTypeConfiguration(
		SymbolTypeConfiguration symbolTypeConfiguration)
		throws SystemException {
		return symbolTypeConfigurationPersistence.update(symbolTypeConfiguration);
	}

	/**
	 * Returns the d d l configuration local service.
	 *
	 * @return the d d l configuration local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationLocalService getDDLConfigurationLocalService() {
		return ddlConfigurationLocalService;
	}

	/**
	 * Sets the d d l configuration local service.
	 *
	 * @param ddlConfigurationLocalService the d d l configuration local service
	 */
	public void setDDLConfigurationLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationLocalService ddlConfigurationLocalService) {
		this.ddlConfigurationLocalService = ddlConfigurationLocalService;
	}

	/**
	 * Returns the d d l configuration remote service.
	 *
	 * @return the d d l configuration remote service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationService getDDLConfigurationService() {
		return ddlConfigurationService;
	}

	/**
	 * Sets the d d l configuration remote service.
	 *
	 * @param ddlConfigurationService the d d l configuration remote service
	 */
	public void setDDLConfigurationService(
		at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationService ddlConfigurationService) {
		this.ddlConfigurationService = ddlConfigurationService;
	}

	/**
	 * Returns the d d l configuration persistence.
	 *
	 * @return the d d l configuration persistence
	 */
	public DDLConfigurationPersistence getDDLConfigurationPersistence() {
		return ddlConfigurationPersistence;
	}

	/**
	 * Sets the d d l configuration persistence.
	 *
	 * @param ddlConfigurationPersistence the d d l configuration persistence
	 */
	public void setDDLConfigurationPersistence(
		DDLConfigurationPersistence ddlConfigurationPersistence) {
		this.ddlConfigurationPersistence = ddlConfigurationPersistence;
	}

	/**
	 * Returns the icon configuration local service.
	 *
	 * @return the icon configuration local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationLocalService getIconConfigurationLocalService() {
		return iconConfigurationLocalService;
	}

	/**
	 * Sets the icon configuration local service.
	 *
	 * @param iconConfigurationLocalService the icon configuration local service
	 */
	public void setIconConfigurationLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationLocalService iconConfigurationLocalService) {
		this.iconConfigurationLocalService = iconConfigurationLocalService;
	}

	/**
	 * Returns the icon configuration remote service.
	 *
	 * @return the icon configuration remote service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationService getIconConfigurationService() {
		return iconConfigurationService;
	}

	/**
	 * Sets the icon configuration remote service.
	 *
	 * @param iconConfigurationService the icon configuration remote service
	 */
	public void setIconConfigurationService(
		at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationService iconConfigurationService) {
		this.iconConfigurationService = iconConfigurationService;
	}

	/**
	 * Returns the icon configuration persistence.
	 *
	 * @return the icon configuration persistence
	 */
	public IconConfigurationPersistence getIconConfigurationPersistence() {
		return iconConfigurationPersistence;
	}

	/**
	 * Sets the icon configuration persistence.
	 *
	 * @param iconConfigurationPersistence the icon configuration persistence
	 */
	public void setIconConfigurationPersistence(
		IconConfigurationPersistence iconConfigurationPersistence) {
		this.iconConfigurationPersistence = iconConfigurationPersistence;
	}

	/**
	 * Returns the symbol configuration local service.
	 *
	 * @return the symbol configuration local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationLocalService getSymbolConfigurationLocalService() {
		return symbolConfigurationLocalService;
	}

	/**
	 * Sets the symbol configuration local service.
	 *
	 * @param symbolConfigurationLocalService the symbol configuration local service
	 */
	public void setSymbolConfigurationLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationLocalService symbolConfigurationLocalService) {
		this.symbolConfigurationLocalService = symbolConfigurationLocalService;
	}

	/**
	 * Returns the symbol configuration remote service.
	 *
	 * @return the symbol configuration remote service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationService getSymbolConfigurationService() {
		return symbolConfigurationService;
	}

	/**
	 * Sets the symbol configuration remote service.
	 *
	 * @param symbolConfigurationService the symbol configuration remote service
	 */
	public void setSymbolConfigurationService(
		at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationService symbolConfigurationService) {
		this.symbolConfigurationService = symbolConfigurationService;
	}

	/**
	 * Returns the symbol configuration persistence.
	 *
	 * @return the symbol configuration persistence
	 */
	public SymbolConfigurationPersistence getSymbolConfigurationPersistence() {
		return symbolConfigurationPersistence;
	}

	/**
	 * Sets the symbol configuration persistence.
	 *
	 * @param symbolConfigurationPersistence the symbol configuration persistence
	 */
	public void setSymbolConfigurationPersistence(
		SymbolConfigurationPersistence symbolConfigurationPersistence) {
		this.symbolConfigurationPersistence = symbolConfigurationPersistence;
	}

	/**
	 * Returns the symbol type configuration local service.
	 *
	 * @return the symbol type configuration local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalService getSymbolTypeConfigurationLocalService() {
		return symbolTypeConfigurationLocalService;
	}

	/**
	 * Sets the symbol type configuration local service.
	 *
	 * @param symbolTypeConfigurationLocalService the symbol type configuration local service
	 */
	public void setSymbolTypeConfigurationLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalService symbolTypeConfigurationLocalService) {
		this.symbolTypeConfigurationLocalService = symbolTypeConfigurationLocalService;
	}

	/**
	 * Returns the symbol type configuration remote service.
	 *
	 * @return the symbol type configuration remote service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationService getSymbolTypeConfigurationService() {
		return symbolTypeConfigurationService;
	}

	/**
	 * Sets the symbol type configuration remote service.
	 *
	 * @param symbolTypeConfigurationService the symbol type configuration remote service
	 */
	public void setSymbolTypeConfigurationService(
		at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationService symbolTypeConfigurationService) {
		this.symbolTypeConfigurationService = symbolTypeConfigurationService;
	}

	/**
	 * Returns the symbol type configuration persistence.
	 *
	 * @return the symbol type configuration persistence
	 */
	public SymbolTypeConfigurationPersistence getSymbolTypeConfigurationPersistence() {
		return symbolTypeConfigurationPersistence;
	}

	/**
	 * Sets the symbol type configuration persistence.
	 *
	 * @param symbolTypeConfigurationPersistence the symbol type configuration persistence
	 */
	public void setSymbolTypeConfigurationPersistence(
		SymbolTypeConfigurationPersistence symbolTypeConfigurationPersistence) {
		this.symbolTypeConfigurationPersistence = symbolTypeConfigurationPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration",
			symbolTypeConfigurationLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return SymbolTypeConfiguration.class;
	}

	protected String getModelClassName() {
		return SymbolTypeConfiguration.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = symbolTypeConfigurationPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationLocalService ddlConfigurationLocalService;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationService ddlConfigurationService;
	@BeanReference(type = DDLConfigurationPersistence.class)
	protected DDLConfigurationPersistence ddlConfigurationPersistence;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationLocalService iconConfigurationLocalService;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationService iconConfigurationService;
	@BeanReference(type = IconConfigurationPersistence.class)
	protected IconConfigurationPersistence iconConfigurationPersistence;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationLocalService symbolConfigurationLocalService;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationService symbolConfigurationService;
	@BeanReference(type = SymbolConfigurationPersistence.class)
	protected SymbolConfigurationPersistence symbolConfigurationPersistence;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalService symbolTypeConfigurationLocalService;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationService symbolTypeConfigurationService;
	@BeanReference(type = SymbolTypeConfigurationPersistence.class)
	protected SymbolTypeConfigurationPersistence symbolTypeConfigurationPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SymbolTypeConfigurationLocalServiceClpInvoker _clpInvoker = new SymbolTypeConfigurationLocalServiceClpInvoker();
}