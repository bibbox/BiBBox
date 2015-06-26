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

import at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationService;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.DDLConfigurationPersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.IconConfigurationPersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.IconsPersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.SymbolConfigurationPersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.SymbolTypeConfigurationPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the d d l configuration remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link at.graz.meduni.liferay.portlet.bibbox.service.impl.DDLConfigurationServiceImpl}.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.impl.DDLConfigurationServiceImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationServiceUtil
 * @generated
 */
public abstract class DDLConfigurationServiceBaseImpl extends BaseServiceImpl
	implements DDLConfigurationService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationServiceUtil} to access the d d l configuration remote service.
	 */

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
	 * Returns the icons local service.
	 *
	 * @return the icons local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.IconsLocalService getIconsLocalService() {
		return iconsLocalService;
	}

	/**
	 * Sets the icons local service.
	 *
	 * @param iconsLocalService the icons local service
	 */
	public void setIconsLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.IconsLocalService iconsLocalService) {
		this.iconsLocalService = iconsLocalService;
	}

	/**
	 * Returns the icons remote service.
	 *
	 * @return the icons remote service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.IconsService getIconsService() {
		return iconsService;
	}

	/**
	 * Sets the icons remote service.
	 *
	 * @param iconsService the icons remote service
	 */
	public void setIconsService(
		at.graz.meduni.liferay.portlet.bibbox.service.IconsService iconsService) {
		this.iconsService = iconsService;
	}

	/**
	 * Returns the icons persistence.
	 *
	 * @return the icons persistence
	 */
	public IconsPersistence getIconsPersistence() {
		return iconsPersistence;
	}

	/**
	 * Sets the icons persistence.
	 *
	 * @param iconsPersistence the icons persistence
	 */
	public void setIconsPersistence(IconsPersistence iconsPersistence) {
		this.iconsPersistence = iconsPersistence;
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
	}

	public void destroy() {
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
		return DDLConfiguration.class;
	}

	protected String getModelClassName() {
		return DDLConfiguration.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = ddlConfigurationPersistence.getDataSource();

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
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.IconsLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.IconsLocalService iconsLocalService;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.IconsService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.IconsService iconsService;
	@BeanReference(type = IconsPersistence.class)
	protected IconsPersistence iconsPersistence;
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
	private DDLConfigurationServiceClpInvoker _clpInvoker = new DDLConfigurationServiceClpInvoker();
}