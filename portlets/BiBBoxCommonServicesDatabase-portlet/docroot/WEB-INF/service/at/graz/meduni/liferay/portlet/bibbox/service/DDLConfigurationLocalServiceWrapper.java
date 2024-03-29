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
 * Provides a wrapper for {@link DDLConfigurationLocalService}.
 *
 * @author reihsr
 * @see DDLConfigurationLocalService
 * @generated
 */
public class DDLConfigurationLocalServiceWrapper
	implements DDLConfigurationLocalService,
		ServiceWrapper<DDLConfigurationLocalService> {
	public DDLConfigurationLocalServiceWrapper(
		DDLConfigurationLocalService ddlConfigurationLocalService) {
		_ddlConfigurationLocalService = ddlConfigurationLocalService;
	}

	/**
	* Adds the d d l configuration to the database. Also notifies the appropriate model listeners.
	*
	* @param ddlConfiguration the d d l configuration
	* @return the d d l configuration that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration addDDLConfiguration(
		at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration ddlConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddlConfigurationLocalService.addDDLConfiguration(ddlConfiguration);
	}

	/**
	* Creates a new d d l configuration with the primary key. Does not add the d d l configuration to the database.
	*
	* @param ddlconfigurationId the primary key for the new d d l configuration
	* @return the new d d l configuration
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration createDDLConfiguration(
		long ddlconfigurationId) {
		return _ddlConfigurationLocalService.createDDLConfiguration(ddlconfigurationId);
	}

	/**
	* Deletes the d d l configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ddlconfigurationId the primary key of the d d l configuration
	* @return the d d l configuration that was removed
	* @throws PortalException if a d d l configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration deleteDDLConfiguration(
		long ddlconfigurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ddlConfigurationLocalService.deleteDDLConfiguration(ddlconfigurationId);
	}

	/**
	* Deletes the d d l configuration from the database. Also notifies the appropriate model listeners.
	*
	* @param ddlConfiguration the d d l configuration
	* @return the d d l configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration deleteDDLConfiguration(
		at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration ddlConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddlConfigurationLocalService.deleteDDLConfiguration(ddlConfiguration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ddlConfigurationLocalService.dynamicQuery();
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
		return _ddlConfigurationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.DDLConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ddlConfigurationLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.DDLConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _ddlConfigurationLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _ddlConfigurationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _ddlConfigurationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration fetchDDLConfiguration(
		long ddlconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddlConfigurationLocalService.fetchDDLConfiguration(ddlconfigurationId);
	}

	/**
	* Returns the d d l configuration with the primary key.
	*
	* @param ddlconfigurationId the primary key of the d d l configuration
	* @return the d d l configuration
	* @throws PortalException if a d d l configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration getDDLConfiguration(
		long ddlconfigurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ddlConfigurationLocalService.getDDLConfiguration(ddlconfigurationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ddlConfigurationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the d d l configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.DDLConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of d d l configurations
	* @param end the upper bound of the range of d d l configurations (not inclusive)
	* @return the range of d d l configurations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration> getDDLConfigurations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddlConfigurationLocalService.getDDLConfigurations(start, end);
	}

	/**
	* Returns the number of d d l configurations.
	*
	* @return the number of d d l configurations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDDLConfigurationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddlConfigurationLocalService.getDDLConfigurationsCount();
	}

	/**
	* Updates the d d l configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ddlConfiguration the d d l configuration
	* @return the d d l configuration that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration updateDDLConfiguration(
		at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration ddlConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ddlConfigurationLocalService.updateDDLConfiguration(ddlConfiguration);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _ddlConfigurationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ddlConfigurationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ddlConfigurationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration getDDLConfigurationForField(
		long ddmstructureId, java.lang.String fieldname) {
		return _ddlConfigurationLocalService.getDDLConfigurationForField(ddmstructureId,
			fieldname);
	}

	/**
	* @return
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.DDLConfiguration createDDLConfiguration() {
		return _ddlConfigurationLocalService.createDDLConfiguration();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DDLConfigurationLocalService getWrappedDDLConfigurationLocalService() {
		return _ddlConfigurationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDDLConfigurationLocalService(
		DDLConfigurationLocalService ddlConfigurationLocalService) {
		_ddlConfigurationLocalService = ddlConfigurationLocalService;
	}

	@Override
	public DDLConfigurationLocalService getWrappedService() {
		return _ddlConfigurationLocalService;
	}

	@Override
	public void setWrappedService(
		DDLConfigurationLocalService ddlConfigurationLocalService) {
		_ddlConfigurationLocalService = ddlConfigurationLocalService;
	}

	private DDLConfigurationLocalService _ddlConfigurationLocalService;
}