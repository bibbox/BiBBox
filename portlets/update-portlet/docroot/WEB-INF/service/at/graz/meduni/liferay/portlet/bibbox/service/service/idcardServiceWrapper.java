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
 * Provides a wrapper for {@link idcardService}.
 *
 * @author reihsr
 * @see idcardService
 * @generated
 */
public class idcardServiceWrapper implements idcardService,
	ServiceWrapper<idcardService> {
	public idcardServiceWrapper(idcardService idcardService) {
		_idcardService = idcardService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _idcardService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_idcardService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _idcardService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject DiseaseMatrix(
		long idcardid, long diseaseid, java.lang.String diseasname,
		java.lang.String patientcount, java.lang.String gene,
		java.lang.String orphanumber, java.lang.String icd10,
		java.lang.String omim, java.lang.String synonym) {
		return _idcardService.DiseaseMatrix(idcardid, diseaseid, diseasname,
			patientcount, gene, orphanumber, icd10, omim, synonym);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject DiseaseMatrix(
		java.lang.String url, long diseaseid, java.lang.String diseasname,
		java.lang.String patientcount, java.lang.String gene,
		java.lang.String orphanumber, java.lang.String icd10,
		java.lang.String omim, java.lang.String synonym) {
		return _idcardService.DiseaseMatrix(url, diseaseid, diseasname,
			patientcount, gene, orphanumber, icd10, omim, synonym);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject DiseaseMatrix(
		long idcardid, java.lang.String diseasname,
		java.lang.String patientcount, java.lang.String gene,
		java.lang.String orphanumber, java.lang.String icd10,
		java.lang.String omim, java.lang.String synonym) {
		return _idcardService.DiseaseMatrix(idcardid, diseasname, patientcount,
			gene, orphanumber, icd10, omim, synonym);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject DiseaseMatrix(
		java.lang.String url, java.lang.String diseasname,
		java.lang.String patientcount, java.lang.String gene,
		java.lang.String orphanumber, java.lang.String icd10,
		java.lang.String omim, java.lang.String synonym) {
		return _idcardService.DiseaseMatrix(url, diseasname, patientcount,
			gene, orphanumber, icd10, omim, synonym);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public idcardService getWrappedidcardService() {
		return _idcardService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedidcardService(idcardService idcardService) {
		_idcardService = idcardService;
	}

	@Override
	public idcardService getWrappedService() {
		return _idcardService;
	}

	@Override
	public void setWrappedService(idcardService idcardService) {
		_idcardService = idcardService;
	}

	private idcardService _idcardService;
}