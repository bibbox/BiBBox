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
 * Provides a wrapper for {@link ParameterOptionsConfigurationLocalService}.
 *
 * @author reihsr
 * @see ParameterOptionsConfigurationLocalService
 * @generated
 */
public class ParameterOptionsConfigurationLocalServiceWrapper
	implements ParameterOptionsConfigurationLocalService,
		ServiceWrapper<ParameterOptionsConfigurationLocalService> {
	public ParameterOptionsConfigurationLocalServiceWrapper(
		ParameterOptionsConfigurationLocalService parameterOptionsConfigurationLocalService) {
		_parameterOptionsConfigurationLocalService = parameterOptionsConfigurationLocalService;
	}

	/**
	* Adds the parameter options configuration to the database. Also notifies the appropriate model listeners.
	*
	* @param parameterOptionsConfiguration the parameter options configuration
	* @return the parameter options configuration that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration addParameterOptionsConfiguration(
		at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration parameterOptionsConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _parameterOptionsConfigurationLocalService.addParameterOptionsConfiguration(parameterOptionsConfiguration);
	}

	/**
	* Creates a new parameter options configuration with the primary key. Does not add the parameter options configuration to the database.
	*
	* @param parameteroptionsconfigurationId the primary key for the new parameter options configuration
	* @return the new parameter options configuration
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration createParameterOptionsConfiguration(
		long parameteroptionsconfigurationId) {
		return _parameterOptionsConfigurationLocalService.createParameterOptionsConfiguration(parameteroptionsconfigurationId);
	}

	/**
	* Deletes the parameter options configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param parameteroptionsconfigurationId the primary key of the parameter options configuration
	* @return the parameter options configuration that was removed
	* @throws PortalException if a parameter options configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration deleteParameterOptionsConfiguration(
		long parameteroptionsconfigurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _parameterOptionsConfigurationLocalService.deleteParameterOptionsConfiguration(parameteroptionsconfigurationId);
	}

	/**
	* Deletes the parameter options configuration from the database. Also notifies the appropriate model listeners.
	*
	* @param parameterOptionsConfiguration the parameter options configuration
	* @return the parameter options configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration deleteParameterOptionsConfiguration(
		at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration parameterOptionsConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _parameterOptionsConfigurationLocalService.deleteParameterOptionsConfiguration(parameterOptionsConfiguration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _parameterOptionsConfigurationLocalService.dynamicQuery();
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
		return _parameterOptionsConfigurationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterOptionsConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _parameterOptionsConfigurationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterOptionsConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _parameterOptionsConfigurationLocalService.dynamicQuery(dynamicQuery,
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
		return _parameterOptionsConfigurationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _parameterOptionsConfigurationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration fetchParameterOptionsConfiguration(
		long parameteroptionsconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _parameterOptionsConfigurationLocalService.fetchParameterOptionsConfiguration(parameteroptionsconfigurationId);
	}

	/**
	* Returns the parameter options configuration with the primary key.
	*
	* @param parameteroptionsconfigurationId the primary key of the parameter options configuration
	* @return the parameter options configuration
	* @throws PortalException if a parameter options configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration getParameterOptionsConfiguration(
		long parameteroptionsconfigurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _parameterOptionsConfigurationLocalService.getParameterOptionsConfiguration(parameteroptionsconfigurationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _parameterOptionsConfigurationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the parameter options configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterOptionsConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of parameter options configurations
	* @param end the upper bound of the range of parameter options configurations (not inclusive)
	* @return the range of parameter options configurations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration> getParameterOptionsConfigurations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _parameterOptionsConfigurationLocalService.getParameterOptionsConfigurations(start,
			end);
	}

	/**
	* Returns the number of parameter options configurations.
	*
	* @return the number of parameter options configurations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getParameterOptionsConfigurationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _parameterOptionsConfigurationLocalService.getParameterOptionsConfigurationsCount();
	}

	/**
	* Updates the parameter options configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param parameterOptionsConfiguration the parameter options configuration
	* @return the parameter options configuration that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration updateParameterOptionsConfiguration(
		at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration parameterOptionsConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _parameterOptionsConfigurationLocalService.updateParameterOptionsConfiguration(parameterOptionsConfiguration);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _parameterOptionsConfigurationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_parameterOptionsConfigurationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _parameterOptionsConfigurationLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* @param request
	* @return
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration parameterOptionsConfigurationFromRequest(
		javax.portlet.ActionRequest request) {
		return _parameterOptionsConfigurationLocalService.parameterOptionsConfigurationFromRequest(request);
	}

	@Override
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration> getParameterOptionsConfigurationForParameterConfiguration(
		long parameterconfigurationId) {
		return _parameterOptionsConfigurationLocalService.getParameterOptionsConfigurationForParameterConfiguration(parameterconfigurationId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ParameterOptionsConfigurationLocalService getWrappedParameterOptionsConfigurationLocalService() {
		return _parameterOptionsConfigurationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedParameterOptionsConfigurationLocalService(
		ParameterOptionsConfigurationLocalService parameterOptionsConfigurationLocalService) {
		_parameterOptionsConfigurationLocalService = parameterOptionsConfigurationLocalService;
	}

	@Override
	public ParameterOptionsConfigurationLocalService getWrappedService() {
		return _parameterOptionsConfigurationLocalService;
	}

	@Override
	public void setWrappedService(
		ParameterOptionsConfigurationLocalService parameterOptionsConfigurationLocalService) {
		_parameterOptionsConfigurationLocalService = parameterOptionsConfigurationLocalService;
	}

	private ParameterOptionsConfigurationLocalService _parameterOptionsConfigurationLocalService;
}