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
 * Provides a wrapper for {@link DDLConfigurationService}.
 *
 * @author reihsr
 * @see DDLConfigurationService
 * @generated
 */
public class DDLConfigurationServiceWrapper implements DDLConfigurationService,
	ServiceWrapper<DDLConfigurationService> {
	public DDLConfigurationServiceWrapper(
		DDLConfigurationService ddlConfigurationService) {
		_ddlConfigurationService = ddlConfigurationService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _ddlConfigurationService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ddlConfigurationService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ddlConfigurationService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DDLConfigurationService getWrappedDDLConfigurationService() {
		return _ddlConfigurationService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDDLConfigurationService(
		DDLConfigurationService ddlConfigurationService) {
		_ddlConfigurationService = ddlConfigurationService;
	}

	@Override
	public DDLConfigurationService getWrappedService() {
		return _ddlConfigurationService;
	}

	@Override
	public void setWrappedService(
		DDLConfigurationService ddlConfigurationService) {
		_ddlConfigurationService = ddlConfigurationService;
	}

	private DDLConfigurationService _ddlConfigurationService;
}