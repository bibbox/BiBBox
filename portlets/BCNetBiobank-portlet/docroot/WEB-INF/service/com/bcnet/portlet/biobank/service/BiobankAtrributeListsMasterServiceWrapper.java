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
 * Provides a wrapper for {@link BiobankAtrributeListsMasterService}.
 *
 * @author suyama
 * @see BiobankAtrributeListsMasterService
 * @generated
 */
public class BiobankAtrributeListsMasterServiceWrapper
	implements BiobankAtrributeListsMasterService,
		ServiceWrapper<BiobankAtrributeListsMasterService> {
	public BiobankAtrributeListsMasterServiceWrapper(
		BiobankAtrributeListsMasterService biobankAtrributeListsMasterService) {
		_biobankAtrributeListsMasterService = biobankAtrributeListsMasterService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _biobankAtrributeListsMasterService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_biobankAtrributeListsMasterService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _biobankAtrributeListsMasterService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BiobankAtrributeListsMasterService getWrappedBiobankAtrributeListsMasterService() {
		return _biobankAtrributeListsMasterService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBiobankAtrributeListsMasterService(
		BiobankAtrributeListsMasterService biobankAtrributeListsMasterService) {
		_biobankAtrributeListsMasterService = biobankAtrributeListsMasterService;
	}

	@Override
	public BiobankAtrributeListsMasterService getWrappedService() {
		return _biobankAtrributeListsMasterService;
	}

	@Override
	public void setWrappedService(
		BiobankAtrributeListsMasterService biobankAtrributeListsMasterService) {
		_biobankAtrributeListsMasterService = biobankAtrributeListsMasterService;
	}

	private BiobankAtrributeListsMasterService _biobankAtrributeListsMasterService;
}