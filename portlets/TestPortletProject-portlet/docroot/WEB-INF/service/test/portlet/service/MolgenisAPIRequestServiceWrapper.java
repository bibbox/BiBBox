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

package test.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MolgenisAPIRequestService}.
 *
 * @author reihsr
 * @see MolgenisAPIRequestService
 * @generated
 */
public class MolgenisAPIRequestServiceWrapper
	implements MolgenisAPIRequestService,
		ServiceWrapper<MolgenisAPIRequestService> {
	public MolgenisAPIRequestServiceWrapper(
		MolgenisAPIRequestService molgenisAPIRequestService) {
		_molgenisAPIRequestService = molgenisAPIRequestService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _molgenisAPIRequestService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_molgenisAPIRequestService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _molgenisAPIRequestService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MolgenisAPIRequestService getWrappedMolgenisAPIRequestService() {
		return _molgenisAPIRequestService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMolgenisAPIRequestService(
		MolgenisAPIRequestService molgenisAPIRequestService) {
		_molgenisAPIRequestService = molgenisAPIRequestService;
	}

	@Override
	public MolgenisAPIRequestService getWrappedService() {
		return _molgenisAPIRequestService;
	}

	@Override
	public void setWrappedService(
		MolgenisAPIRequestService molgenisAPIRequestService) {
		_molgenisAPIRequestService = molgenisAPIRequestService;
	}

	private MolgenisAPIRequestService _molgenisAPIRequestService;
}