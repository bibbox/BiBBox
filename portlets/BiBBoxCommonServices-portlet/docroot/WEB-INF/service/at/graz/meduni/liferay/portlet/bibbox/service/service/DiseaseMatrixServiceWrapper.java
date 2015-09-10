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

package at.graz.meduni.liferay.portlet.bibbox.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DiseaseMatrixService}.
 *
 * @author reihsr
 * @see DiseaseMatrixService
 * @generated
 */
public class DiseaseMatrixServiceWrapper implements DiseaseMatrixService,
	ServiceWrapper<DiseaseMatrixService> {
	public DiseaseMatrixServiceWrapper(
		DiseaseMatrixService diseaseMatrixService) {
		_diseaseMatrixService = diseaseMatrixService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _diseaseMatrixService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_diseaseMatrixService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _diseaseMatrixService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject testupdatediseasematrix(
		long organizationId) {
		return _diseaseMatrixService.testupdatediseasematrix(organizationId);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix updatediseasematrix(
		long organizationId,
		at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix matrix) {
		return _diseaseMatrixService.updatediseasematrix(organizationId, matrix);
	}

	@Override
	public void updatediseasematrixs(long organizationId,
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> matrixs) {
		_diseaseMatrixService.updatediseasematrixs(organizationId, matrixs);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject regbb(long organizationId) {
		return _diseaseMatrixService.regbb(organizationId);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix getDiseaseMatrix(
		long organizationId) {
		return _diseaseMatrixService.getDiseaseMatrix(organizationId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DiseaseMatrixService getWrappedDiseaseMatrixService() {
		return _diseaseMatrixService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDiseaseMatrixService(
		DiseaseMatrixService diseaseMatrixService) {
		_diseaseMatrixService = diseaseMatrixService;
	}

	@Override
	public DiseaseMatrixService getWrappedService() {
		return _diseaseMatrixService;
	}

	@Override
	public void setWrappedService(DiseaseMatrixService diseaseMatrixService) {
		_diseaseMatrixService = diseaseMatrixService;
	}

	private DiseaseMatrixService _diseaseMatrixService;
}