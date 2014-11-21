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

package com.bcnet.portlet.biobank.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BiobankAttributeListsService}.
 *
 * @author suyama
 * @see BiobankAttributeListsService
 * @generated
 */
public class BiobankAttributeListsServiceWrapper
	implements BiobankAttributeListsService,
		ServiceWrapper<BiobankAttributeListsService> {
	public BiobankAttributeListsServiceWrapper(
		BiobankAttributeListsService biobankAttributeListsService) {
		_biobankAttributeListsService = biobankAttributeListsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _biobankAttributeListsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_biobankAttributeListsService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _biobankAttributeListsService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BiobankAttributeListsService getWrappedBiobankAttributeListsService() {
		return _biobankAttributeListsService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBiobankAttributeListsService(
		BiobankAttributeListsService biobankAttributeListsService) {
		_biobankAttributeListsService = biobankAttributeListsService;
	}

	@Override
	public BiobankAttributeListsService getWrappedService() {
		return _biobankAttributeListsService;
	}

	@Override
	public void setWrappedService(
		BiobankAttributeListsService biobankAttributeListsService) {
		_biobankAttributeListsService = biobankAttributeListsService;
	}

	private BiobankAttributeListsService _biobankAttributeListsService;
}