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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link KdssmpConfigurationLocalService}.
 *
 * @author reihsr
 * @see KdssmpConfigurationLocalService
 * @generated
 */
public class KdssmpConfigurationLocalServiceWrapper
	implements KdssmpConfigurationLocalService,
		ServiceWrapper<KdssmpConfigurationLocalService> {
	public KdssmpConfigurationLocalServiceWrapper(
		KdssmpConfigurationLocalService kdssmpConfigurationLocalService) {
		_kdssmpConfigurationLocalService = kdssmpConfigurationLocalService;
	}

	/**
	* Adds the kdssmp configuration to the database. Also notifies the appropriate model listeners.
	*
	* @param kdssmpConfiguration the kdssmp configuration
	* @return the kdssmp configuration that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration addKdssmpConfiguration(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration kdssmpConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpConfigurationLocalService.addKdssmpConfiguration(kdssmpConfiguration);
	}

	/**
	* Creates a new kdssmp configuration with the primary key. Does not add the kdssmp configuration to the database.
	*
	* @param configurationId the primary key for the new kdssmp configuration
	* @return the new kdssmp configuration
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration createKdssmpConfiguration(
		long configurationId) {
		return _kdssmpConfigurationLocalService.createKdssmpConfiguration(configurationId);
	}

	/**
	* Deletes the kdssmp configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configurationId the primary key of the kdssmp configuration
	* @return the kdssmp configuration that was removed
	* @throws PortalException if a kdssmp configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration deleteKdssmpConfiguration(
		long configurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpConfigurationLocalService.deleteKdssmpConfiguration(configurationId);
	}

	/**
	* Deletes the kdssmp configuration from the database. Also notifies the appropriate model listeners.
	*
	* @param kdssmpConfiguration the kdssmp configuration
	* @return the kdssmp configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration deleteKdssmpConfiguration(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration kdssmpConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpConfigurationLocalService.deleteKdssmpConfiguration(kdssmpConfiguration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _kdssmpConfigurationLocalService.dynamicQuery();
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
		return _kdssmpConfigurationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _kdssmpConfigurationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _kdssmpConfigurationLocalService.dynamicQuery(dynamicQuery,
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
		return _kdssmpConfigurationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _kdssmpConfigurationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration fetchKdssmpConfiguration(
		long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpConfigurationLocalService.fetchKdssmpConfiguration(configurationId);
	}

	/**
	* Returns the kdssmp configuration with the primary key.
	*
	* @param configurationId the primary key of the kdssmp configuration
	* @return the kdssmp configuration
	* @throws PortalException if a kdssmp configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration getKdssmpConfiguration(
		long configurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpConfigurationLocalService.getKdssmpConfiguration(configurationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpConfigurationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the kdssmp configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kdssmp configurations
	* @param end the upper bound of the range of kdssmp configurations (not inclusive)
	* @return the range of kdssmp configurations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration> getKdssmpConfigurations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpConfigurationLocalService.getKdssmpConfigurations(start,
			end);
	}

	/**
	* Returns the number of kdssmp configurations.
	*
	* @return the number of kdssmp configurations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getKdssmpConfigurationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpConfigurationLocalService.getKdssmpConfigurationsCount();
	}

	/**
	* Updates the kdssmp configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param kdssmpConfiguration the kdssmp configuration
	* @return the kdssmp configuration that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration updateKdssmpConfiguration(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration kdssmpConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpConfigurationLocalService.updateKdssmpConfiguration(kdssmpConfiguration);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _kdssmpConfigurationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_kdssmpConfigurationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _kdssmpConfigurationLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* @param scope
	* @param key
	* @return
	* @throws NoSuchKdssmpConfigurationException
	* @throws SystemException
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration getConfigurationOption(
		java.lang.String scope, java.lang.String key)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpConfigurationLocalService.getConfigurationOption(scope,
			key);
	}

	/**
	* @param request
	* @return
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration symbolKdssmpConfigurationFromRequest(
		javax.portlet.ActionRequest request) {
		return _kdssmpConfigurationLocalService.symbolKdssmpConfigurationFromRequest(request);
	}

	/**
	* @param scope
	* @param value
	* @return
	* @throws NoSuchKdssmpConfigurationException
	* @throws SystemException
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration getConfigurationOptionValue(
		java.lang.String scope, java.lang.String value)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpConfigurationLocalService.getConfigurationOptionValue(scope,
			value);
	}

	/**
	* @param scope
	* @param key
	* @return
	* @throws NoSuchKdssmpConfigurationException
	* @throws SystemException
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration> getConfigurationOptions(
		java.lang.String scope, java.lang.String key)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpConfigurationLocalService.getConfigurationOptions(scope,
			key);
	}

	/**
	* @param scope
	* @return
	* @throws NoSuchKdssmpConfigurationException
	* @throws SystemException
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration> getConfigurationOptions(
		java.lang.String scope)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpConfigurationLocalService.getConfigurationOptions(scope);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public KdssmpConfigurationLocalService getWrappedKdssmpConfigurationLocalService() {
		return _kdssmpConfigurationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedKdssmpConfigurationLocalService(
		KdssmpConfigurationLocalService kdssmpConfigurationLocalService) {
		_kdssmpConfigurationLocalService = kdssmpConfigurationLocalService;
	}

	@Override
	public KdssmpConfigurationLocalService getWrappedService() {
		return _kdssmpConfigurationLocalService;
	}

	@Override
	public void setWrappedService(
		KdssmpConfigurationLocalService kdssmpConfigurationLocalService) {
		_kdssmpConfigurationLocalService = kdssmpConfigurationLocalService;
	}

	private KdssmpConfigurationLocalService _kdssmpConfigurationLocalService;
}