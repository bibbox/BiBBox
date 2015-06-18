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
 * Provides a wrapper for {@link IconConfigurationService}.
 *
 * @author reihsr
 * @see IconConfigurationService
 * @generated
 */
public class IconConfigurationServiceWrapper implements IconConfigurationService,
	ServiceWrapper<IconConfigurationService> {
	public IconConfigurationServiceWrapper(
		IconConfigurationService iconConfigurationService) {
		_iconConfigurationService = iconConfigurationService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _iconConfigurationService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_iconConfigurationService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _iconConfigurationService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public IconConfigurationService getWrappedIconConfigurationService() {
		return _iconConfigurationService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedIconConfigurationService(
		IconConfigurationService iconConfigurationService) {
		_iconConfigurationService = iconConfigurationService;
	}

	@Override
	public IconConfigurationService getWrappedService() {
		return _iconConfigurationService;
	}

	@Override
	public void setWrappedService(
		IconConfigurationService iconConfigurationService) {
		_iconConfigurationService = iconConfigurationService;
	}

	private IconConfigurationService _iconConfigurationService;
}