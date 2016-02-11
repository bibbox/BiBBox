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
 * Provides a wrapper for {@link LogapiService}.
 *
 * @author reihsr
 * @see LogapiService
 * @generated
 */
public class LogapiServiceWrapper implements LogapiService,
	ServiceWrapper<LogapiService> {
	public LogapiServiceWrapper(LogapiService logapiService) {
		_logapiService = logapiService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _logapiService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_logapiService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _logapiService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* @return
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONObject getAPIVersion() {
		return _logapiService.getAPIVersion();
	}

	/**
	* @return
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONArray regbbs(
		java.lang.String data) {
		return _logapiService.regbbs(data);
	}

	/**
	* @return
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONArray regbbs() {
		return _logapiService.regbbs();
	}

	/**
	* @return
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONArray regs() {
		return _logapiService.regs();
	}

	/**
	* @return
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONArray bbs() {
		return _logapiService.bbs();
	}

	/**
	* @param organizationId
	* @return
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONObject regbb(long organizationId) {
		return _logapiService.regbb(organizationId);
	}

	/**
	* @param organizationId
	* @return
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONObject regbb(
		long organizationId, long collectionId) {
		return _logapiService.regbb(organizationId, collectionId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject regbb(java.lang.String id) {
		return _logapiService.regbb(id);
	}

	@Override
	public void testMethode(java.lang.String jason) {
		_logapiService.testMethode(jason);
	}

	@Override
	public void resttest01(long organizationId) {
		_logapiService.resttest01(organizationId);
	}

	@Override
	public void resttest02(java.lang.String text) {
		_logapiService.resttest02(text);
	}

	@Override
	public void resttest03(long[] array) {
		_logapiService.resttest03(array);
	}

	@Override
	public void resttest04(java.lang.String[] array) {
		_logapiService.resttest04(array);
	}

	@Override
	public void resttest05(java.lang.String url,
		com.liferay.portal.model.User user) {
		_logapiService.resttest05(url, user);
	}

	@Override
	public void resttest06(java.lang.String url, java.lang.String diseasname,
		java.lang.String patientcount, java.lang.String gene,
		java.lang.String orphanumber, java.lang.String icd10,
		java.lang.String omim, java.lang.String synonym) {
		_logapiService.resttest06(url, diseasname, patientcount, gene,
			orphanumber, icd10, omim, synonym);
	}

	@Override
	public void resttest07(java.lang.String url, java.lang.String diseasname,
		java.lang.String patientcount, java.lang.String gene,
		java.lang.String orphanumber, java.lang.String icd10,
		java.lang.String omim, java.lang.String synonym) {
		_logapiService.resttest07(url, diseasname, patientcount, gene,
			orphanumber, icd10, omim, synonym);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LogapiService getWrappedLogapiService() {
		return _logapiService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLogapiService(LogapiService logapiService) {
		_logapiService = logapiService;
	}

	@Override
	public LogapiService getWrappedService() {
		return _logapiService;
	}

	@Override
	public void setWrappedService(LogapiService logapiService) {
		_logapiService = logapiService;
	}

	private LogapiService _logapiService;
}