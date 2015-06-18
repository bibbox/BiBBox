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

package at.graz.meduni.liferay.portlet.bibbox.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SymbolConfigurationLocalService}.
 *
 * @author reihsr
 * @see SymbolConfigurationLocalService
 * @generated
 */
public class SymbolConfigurationLocalServiceWrapper
	implements SymbolConfigurationLocalService,
		ServiceWrapper<SymbolConfigurationLocalService> {
	public SymbolConfigurationLocalServiceWrapper(
		SymbolConfigurationLocalService symbolConfigurationLocalService) {
		_symbolConfigurationLocalService = symbolConfigurationLocalService;
	}

	/**
	* Adds the symbol configuration to the database. Also notifies the appropriate model listeners.
	*
	* @param symbolConfiguration the symbol configuration
	* @return the symbol configuration that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration addSymbolConfiguration(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration symbolConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolConfigurationLocalService.addSymbolConfiguration(symbolConfiguration);
	}

	/**
	* Creates a new symbol configuration with the primary key. Does not add the symbol configuration to the database.
	*
	* @param symbolconfigurationId the primary key for the new symbol configuration
	* @return the new symbol configuration
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration createSymbolConfiguration(
		long symbolconfigurationId) {
		return _symbolConfigurationLocalService.createSymbolConfiguration(symbolconfigurationId);
	}

	/**
	* Deletes the symbol configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param symbolconfigurationId the primary key of the symbol configuration
	* @return the symbol configuration that was removed
	* @throws PortalException if a symbol configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration deleteSymbolConfiguration(
		long symbolconfigurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _symbolConfigurationLocalService.deleteSymbolConfiguration(symbolconfigurationId);
	}

	/**
	* Deletes the symbol configuration from the database. Also notifies the appropriate model listeners.
	*
	* @param symbolConfiguration the symbol configuration
	* @return the symbol configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration deleteSymbolConfiguration(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration symbolConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolConfigurationLocalService.deleteSymbolConfiguration(symbolConfiguration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _symbolConfigurationLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolConfigurationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolConfigurationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolConfigurationLocalService.dynamicQuery(dynamicQuery,
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolConfigurationLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolConfigurationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration fetchSymbolConfiguration(
		long symbolconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolConfigurationLocalService.fetchSymbolConfiguration(symbolconfigurationId);
	}

	/**
	* Returns the symbol configuration with the primary key.
	*
	* @param symbolconfigurationId the primary key of the symbol configuration
	* @return the symbol configuration
	* @throws PortalException if a symbol configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration getSymbolConfiguration(
		long symbolconfigurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _symbolConfigurationLocalService.getSymbolConfiguration(symbolconfigurationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _symbolConfigurationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the symbol configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of symbol configurations
	* @param end the upper bound of the range of symbol configurations (not inclusive)
	* @return the range of symbol configurations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration> getSymbolConfigurations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolConfigurationLocalService.getSymbolConfigurations(start,
			end);
	}

	/**
	* Returns the number of symbol configurations.
	*
	* @return the number of symbol configurations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSymbolConfigurationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolConfigurationLocalService.getSymbolConfigurationsCount();
	}

	/**
	* Updates the symbol configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param symbolConfiguration the symbol configuration
	* @return the symbol configuration that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration updateSymbolConfiguration(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration symbolConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolConfigurationLocalService.updateSymbolConfiguration(symbolConfiguration);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _symbolConfigurationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_symbolConfigurationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _symbolConfigurationLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.lang.String getSymbol(java.lang.String scope,
		java.lang.String eventtype,
		java.util.LinkedHashMap<java.lang.String, java.lang.String> icons) {
		return _symbolConfigurationLocalService.getSymbol(scope, eventtype,
			icons);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SymbolConfigurationLocalService getWrappedSymbolConfigurationLocalService() {
		return _symbolConfigurationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSymbolConfigurationLocalService(
		SymbolConfigurationLocalService symbolConfigurationLocalService) {
		_symbolConfigurationLocalService = symbolConfigurationLocalService;
	}

	@Override
	public SymbolConfigurationLocalService getWrappedService() {
		return _symbolConfigurationLocalService;
	}

	@Override
	public void setWrappedService(
		SymbolConfigurationLocalService symbolConfigurationLocalService) {
		_symbolConfigurationLocalService = symbolConfigurationLocalService;
	}

	private SymbolConfigurationLocalService _symbolConfigurationLocalService;
}