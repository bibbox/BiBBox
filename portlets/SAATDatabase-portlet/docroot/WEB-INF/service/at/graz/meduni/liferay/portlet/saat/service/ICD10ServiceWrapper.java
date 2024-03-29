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
 * Provides a wrapper for {@link ICD10Service}.
 *
 * @author reihsr
 * @see ICD10Service
 * @generated
 */
public class ICD10ServiceWrapper implements ICD10Service,
	ServiceWrapper<ICD10Service> {
	public ICD10ServiceWrapper(ICD10Service icd10Service) {
		_icd10Service = icd10Service;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _icd10Service.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_icd10Service.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _icd10Service.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ICD10Service getWrappedICD10Service() {
		return _icd10Service;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedICD10Service(ICD10Service icd10Service) {
		_icd10Service = icd10Service;
	}

	@Override
	public ICD10Service getWrappedService() {
		return _icd10Service;
	}

	@Override
	public void setWrappedService(ICD10Service icd10Service) {
		_icd10Service = icd10Service;
	}

	private ICD10Service _icd10Service;
}