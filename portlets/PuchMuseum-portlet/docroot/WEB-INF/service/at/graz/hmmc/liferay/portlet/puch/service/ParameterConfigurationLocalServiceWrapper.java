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

package at.graz.hmmc.liferay.portlet.puch.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ParameterConfigurationLocalService}.
 *
 * @author reihsr
 * @see ParameterConfigurationLocalService
 * @generated
 */
public class ParameterConfigurationLocalServiceWrapper
	implements ParameterConfigurationLocalService,
		ServiceWrapper<ParameterConfigurationLocalService> {
	public ParameterConfigurationLocalServiceWrapper(
		ParameterConfigurationLocalService parameterConfigurationLocalService) {
		_parameterConfigurationLocalService = parameterConfigurationLocalService;
	}

	/**
	* Adds the parameter configuration to the database. Also notifies the appropriate model listeners.
	*
	* @param parameterConfiguration the parameter configuration
	* @return the parameter configuration that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration addParameterConfiguration(
		at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration parameterConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _parameterConfigurationLocalService.addParameterConfiguration(parameterConfiguration);
	}

	/**
	* Creates a new parameter configuration with the primary key. Does not add the parameter configuration to the database.
	*
	* @param parameterconfigurationId the primary key for the new parameter configuration
	* @return the new parameter configuration
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration createParameterConfiguration(
		long parameterconfigurationId) {
		return _parameterConfigurationLocalService.createParameterConfiguration(parameterconfigurationId);
	}

	/**
	* Deletes the parameter configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param parameterconfigurationId the primary key of the parameter configuration
	* @return the parameter configuration that was removed
	* @throws PortalException if a parameter configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration deleteParameterConfiguration(
		long parameterconfigurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _parameterConfigurationLocalService.deleteParameterConfiguration(parameterconfigurationId);
	}

	/**
	* Deletes the parameter configuration from the database. Also notifies the appropriate model listeners.
	*
	* @param parameterConfiguration the parameter configuration
	* @return the parameter configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration deleteParameterConfiguration(
		at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration parameterConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _parameterConfigurationLocalService.deleteParameterConfiguration(parameterConfiguration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _parameterConfigurationLocalService.dynamicQuery();
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
		return _parameterConfigurationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _parameterConfigurationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _parameterConfigurationLocalService.dynamicQuery(dynamicQuery,
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
		return _parameterConfigurationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _parameterConfigurationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration fetchParameterConfiguration(
		long parameterconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _parameterConfigurationLocalService.fetchParameterConfiguration(parameterconfigurationId);
	}

	/**
	* Returns the parameter configuration with the primary key.
	*
	* @param parameterconfigurationId the primary key of the parameter configuration
	* @return the parameter configuration
	* @throws PortalException if a parameter configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration getParameterConfiguration(
		long parameterconfigurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _parameterConfigurationLocalService.getParameterConfiguration(parameterconfigurationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _parameterConfigurationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the parameter configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of parameter configurations
	* @param end the upper bound of the range of parameter configurations (not inclusive)
	* @return the range of parameter configurations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration> getParameterConfigurations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _parameterConfigurationLocalService.getParameterConfigurations(start,
			end);
	}

	/**
	* Returns the number of parameter configurations.
	*
	* @return the number of parameter configurations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getParameterConfigurationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _parameterConfigurationLocalService.getParameterConfigurationsCount();
	}

	/**
	* Updates the parameter configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param parameterConfiguration the parameter configuration
	* @return the parameter configuration that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration updateParameterConfiguration(
		at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration parameterConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _parameterConfigurationLocalService.updateParameterConfiguration(parameterConfiguration);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _parameterConfigurationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_parameterConfigurationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _parameterConfigurationLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* @param request
	* @return
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterConfiguration parameterConfigurationFromRequest(
		javax.portlet.ActionRequest request) {
		return _parameterConfigurationLocalService.parameterConfigurationFromRequest(request);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ParameterConfigurationLocalService getWrappedParameterConfigurationLocalService() {
		return _parameterConfigurationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedParameterConfigurationLocalService(
		ParameterConfigurationLocalService parameterConfigurationLocalService) {
		_parameterConfigurationLocalService = parameterConfigurationLocalService;
	}

	@Override
	public ParameterConfigurationLocalService getWrappedService() {
		return _parameterConfigurationLocalService;
	}

	@Override
	public void setWrappedService(
		ParameterConfigurationLocalService parameterConfigurationLocalService) {
		_parameterConfigurationLocalService = parameterConfigurationLocalService;
	}

	private ParameterConfigurationLocalService _parameterConfigurationLocalService;
}