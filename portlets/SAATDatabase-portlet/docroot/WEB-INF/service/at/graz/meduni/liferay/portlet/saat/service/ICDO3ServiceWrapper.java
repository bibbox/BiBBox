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

package at.graz.meduni.liferay.portlet.saat.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ICDO3Service}.
 *
 * @author reihsr
 * @see ICDO3Service
 * @generated
 */
public class ICDO3ServiceWrapper implements ICDO3Service,
	ServiceWrapper<ICDO3Service> {
	public ICDO3ServiceWrapper(ICDO3Service icdo3Service) {
		_icdo3Service = icdo3Service;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _icdo3Service.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_icdo3Service.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _icdo3Service.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ICDO3Service getWrappedICDO3Service() {
		return _icdo3Service;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedICDO3Service(ICDO3Service icdo3Service) {
		_icdo3Service = icdo3Service;
	}

	@Override
	public ICDO3Service getWrappedService() {
		return _icdo3Service;
	}

	@Override
	public void setWrappedService(ICDO3Service icdo3Service) {
		_icdo3Service = icdo3Service;
	}

	private ICDO3Service _icdo3Service;
}