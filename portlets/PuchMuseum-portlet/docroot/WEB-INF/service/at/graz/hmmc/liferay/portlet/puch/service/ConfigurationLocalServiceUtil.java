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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Configuration. This utility wraps
 * {@link at.graz.hmmc.liferay.portlet.puch.service.impl.ConfigurationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author reihsr
 * @see ConfigurationLocalService
 * @see at.graz.hmmc.liferay.portlet.puch.service.base.ConfigurationLocalServiceBaseImpl
 * @see at.graz.hmmc.liferay.portlet.puch.service.impl.ConfigurationLocalServiceImpl
 * @generated
 */
public class ConfigurationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.hmmc.liferay.portlet.puch.service.impl.ConfigurationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the configuration to the database. Also notifies the appropriate model listeners.
	*
	* @param configuration the configuration
	* @return the configuration that was added
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration addConfiguration(
		at.graz.hmmc.liferay.portlet.puch.model.Configuration configuration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addConfiguration(configuration);
	}

	/**
	* Creates a new configuration with the primary key. Does not add the configuration to the database.
	*
	* @param configurationId the primary key for the new configuration
	* @return the new configuration
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration createConfiguration(
		long configurationId) {
		return getService().createConfiguration(configurationId);
	}

	/**
	* Deletes the configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configurationId the primary key of the configuration
	* @return the configuration that was removed
	* @throws PortalException if a configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration deleteConfiguration(
		long configurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteConfiguration(configurationId);
	}

	/**
	* Deletes the configuration from the database. Also notifies the appropriate model listeners.
	*
	* @param configuration the configuration
	* @return the configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration deleteConfiguration(
		at.graz.hmmc.liferay.portlet.puch.model.Configuration configuration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteConfiguration(configuration);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration fetchConfiguration(
		long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchConfiguration(configurationId);
	}

	/**
	* Returns the configuration with the primary key.
	*
	* @param configurationId the primary key of the configuration
	* @return the configuration
	* @throws PortalException if a configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration getConfiguration(
		long configurationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getConfiguration(configurationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of configurations
	* @param end the upper bound of the range of configurations (not inclusive)
	* @return the range of configurations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> getConfigurations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getConfigurations(start, end);
	}

	/**
	* Returns the number of configurations.
	*
	* @return the number of configurations
	* @throws SystemException if a system exception occurred
	*/
	public static int getConfigurationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getConfigurationsCount();
	}

	/**
	* Updates the configuration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param configuration the configuration
	* @return the configuration that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration updateConfiguration(
		at.graz.hmmc.liferay.portlet.puch.model.Configuration configuration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateConfiguration(configuration);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* @param request
	* @return
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration configurationFromRequest(
		javax.portlet.ActionRequest request) {
		return getService().configurationFromRequest(request);
	}

	/**
	* @param scope
	* @param value
	* @return
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration getConfigurationOptionValue(
		java.lang.String scope, java.lang.String value) {
		return getService().getConfigurationOptionValue(scope, value);
	}

	/**
	* @param scope
	* @param key
	* @return
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Configuration getConfigurationOption(
		java.lang.String scope, java.lang.String key) {
		return getService().getConfigurationOption(scope, key);
	}

	/**
	* @param scope
	* @param key
	* @return
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> getConfigurationOptions(
		java.lang.String scope, java.lang.String key) {
		return getService().getConfigurationOptions(scope, key);
	}

	/**
	* @param scope
	* @return
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> getConfigurationOptions(
		java.lang.String scope) {
		return getService().getConfigurationOptions(scope);
	}

	/**
	* @param scope
	* @param start
	* @param end
	* @return
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> getConfigurationOptions(
		java.lang.String scope, int start, int end) {
		return getService().getConfigurationOptions(scope, start, end);
	}

	/**
	* @param scope
	* @return
	*/
	public static int getConfigurationOptionsCount(java.lang.String scope) {
		return getService().getConfigurationOptionsCount(scope);
	}

	/**
	* @param key
	* @return
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> getConfigurationOptionsForKey(
		java.lang.String key) {
		return getService().getConfigurationOptionsForKey(key);
	}

	/**
	* @param scope
	* @param start
	* @param end
	* @return
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Configuration> getConfigurationOptionsForKey(
		java.lang.String key, int start, int end) {
		return getService().getConfigurationOptionsForKey(key, start, end);
	}

	/**
	* @param scope
	* @return
	*/
	public static int getConfigurationOptionsForKeyCount(java.lang.String key) {
		return getService().getConfigurationOptionsForKeyCount(key);
	}

	public static void clearService() {
		_service = null;
	}

	public static ConfigurationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ConfigurationLocalService.class.getName());

			if (invokableLocalService instanceof ConfigurationLocalService) {
				_service = (ConfigurationLocalService)invokableLocalService;
			}
			else {
				_service = new ConfigurationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ConfigurationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ConfigurationLocalService service) {
	}

	private static ConfigurationLocalService _service;
}