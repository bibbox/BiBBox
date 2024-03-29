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
 * Provides a wrapper for {@link SymbolTypeConfigurationLocalService}.
 *
 * @author reihsr
 * @see SymbolTypeConfigurationLocalService
 * @generated
 */
public class SymbolTypeConfigurationLocalServiceWrapper
	implements SymbolTypeConfigurationLocalService,
		ServiceWrapper<SymbolTypeConfigurationLocalService> {
	public SymbolTypeConfigurationLocalServiceWrapper(
		SymbolTypeConfigurationLocalService symbolTypeConfigurationLocalService) {
		_symbolTypeConfigurationLocalService = symbolTypeConfigurationLocalService;
	}

	/**
	* Adds the symbol type configuration to the database. Also notifies the appropriate model listeners.
	*
	* @param symbolTypeConfiguration the symbol type configuration
	* @return the symbol type configuration that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration addSymbolTypeConfiguration(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration symbolTypeConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolTypeConfigurationLocalService.addSymbolTypeConfiguration(symbolTypeConfiguration);
	}

	/**
	* Creates a new symbol type configuration with the primary key. Does not add the symbol type configuration to the database.
	*
	* @param symboltypeconfigurationId the primary key for the new symbol type configuration
	* @return the new symbol type configuration
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration createSymbolTypeConfiguration(
		long symboltypeconfigurationId) {
		return _symbolTypeConfigurationLocalService.createSymbolTypeConfiguration(symboltypeconfigurationId);
	}

	/**
	* Deletes the symbol type configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param symboltypeconfigurationId the primary key of the symbol type configuration
	* @return the symbol type configuration that was removed
	* @throws PortalException if a symbol type configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration deleteSymbolTypeConfiguration(
		long symboltypeconfigurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _symbolTypeConfigurationLocalService.deleteSymbolTypeConfiguration(symboltypeconfigurationId);
	}

	/**
	* Deletes the symbol type configuration from the database. Also notifies the appropriate model listeners.
	*
	* @param symbolTypeConfiguration the symbol type configuration
	* @return the symbol type configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration deleteSymbolTypeConfiguration(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration symbolTypeConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolTypeConfigurationLocalService.deleteSymbolTypeConfiguration(symbolTypeConfiguration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _symbolTypeConfigurationLocalService.dynamicQuery();
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
		return _symbolTypeConfigurationLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolTypeConfigurationLocalService.dynamicQuery(dynamicQuery,
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolTypeConfigurationLocalService.dynamicQuery(dynamicQuery,
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
		return _symbolTypeConfigurationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _symbolTypeConfigurationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration fetchSymbolTypeConfiguration(
		long symboltypeconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolTypeConfigurationLocalService.fetchSymbolTypeConfiguration(symboltypeconfigurationId);
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
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration getSymbolTypeConfiguration(
		long symboltypeconfigurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _symbolTypeConfigurationLocalService.getSymbolTypeConfiguration(symboltypeconfigurationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _symbolTypeConfigurationLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration> getSymbolTypeConfigurations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolTypeConfigurationLocalService.getSymbolTypeConfigurations(start,
			end);
	}

	/**
	* Returns the number of symbol type configurations.
	*
	* @return the number of symbol type configurations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSymbolTypeConfigurationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolTypeConfigurationLocalService.getSymbolTypeConfigurationsCount();
	}

	/**
	* Updates the symbol type configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param symbolTypeConfiguration the symbol type configuration
	* @return the symbol type configuration that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration updateSymbolTypeConfiguration(
		at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration symbolTypeConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _symbolTypeConfigurationLocalService.updateSymbolTypeConfiguration(symbolTypeConfiguration);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _symbolTypeConfigurationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_symbolTypeConfigurationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _symbolTypeConfigurationLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration getSymbolTypeConfigurationBySymbolType(
		java.lang.String symboltype) {
		return _symbolTypeConfigurationLocalService.getSymbolTypeConfigurationBySymbolType(symboltype);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration symbolTypeConfigurationFromRequest(
		javax.portlet.ActionRequest request) {
		return _symbolTypeConfigurationLocalService.symbolTypeConfigurationFromRequest(request);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SymbolTypeConfigurationLocalService getWrappedSymbolTypeConfigurationLocalService() {
		return _symbolTypeConfigurationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSymbolTypeConfigurationLocalService(
		SymbolTypeConfigurationLocalService symbolTypeConfigurationLocalService) {
		_symbolTypeConfigurationLocalService = symbolTypeConfigurationLocalService;
	}

	@Override
	public SymbolTypeConfigurationLocalService getWrappedService() {
		return _symbolTypeConfigurationLocalService;
	}

	@Override
	public void setWrappedService(
		SymbolTypeConfigurationLocalService symbolTypeConfigurationLocalService) {
		_symbolTypeConfigurationLocalService = symbolTypeConfigurationLocalService;
	}

	private SymbolTypeConfigurationLocalService _symbolTypeConfigurationLocalService;
}