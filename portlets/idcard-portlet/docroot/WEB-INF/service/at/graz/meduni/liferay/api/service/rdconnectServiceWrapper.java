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

package at.graz.meduni.liferay.api.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link rdconnectService}.
 *
 * @author reihsr
 * @see rdconnectService
 * @generated
 */
public class rdconnectServiceWrapper implements rdconnectService,
	ServiceWrapper<rdconnectService> {
	public rdconnectServiceWrapper(rdconnectService rdconnectService) {
		_rdconnectService = rdconnectService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _rdconnectService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_rdconnectService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _rdconnectService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public at.graz.meduni.liferay.api.model.rdconnect getRdconnect()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rdconnectService.getRdconnect();
	}

	@Override
	public void updateregbb(long organizationId,
		com.liferay.portal.kernel.json.JSONObject json) {
		_rdconnectService.updateregbb(organizationId, json);
	}

	@Override
	public void updateregbb2(long organizationId, java.util.Map jsondata) {
		_rdconnectService.updateregbb2(organizationId, jsondata);
	}

	@Override
	public void updatedisease(long organizationId,
		java.lang.String diseasename, java.lang.String count) {
		_rdconnectService.updatedisease(organizationId, diseasename, count);
	}

	@Override
	public void updatedisease(long organizationId, long diseasematrixId,
		java.lang.String count) {
		_rdconnectService.updatedisease(organizationId, diseasematrixId, count);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject regbb(long organizationId) {
		return _rdconnectService.regbb(organizationId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray regbbs() {
		return _rdconnectService.regbbs();
	}

	/**
	* @return
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONArray regs() {
		return _rdconnectService.regs();
	}

	/**
	* @return
	*/
	@Override
	public com.liferay.portal.kernel.json.JSONArray bbs() {
		return _rdconnectService.bbs();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public rdconnectService getWrappedrdconnectService() {
		return _rdconnectService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedrdconnectService(rdconnectService rdconnectService) {
		_rdconnectService = rdconnectService;
	}

	@Override
	public rdconnectService getWrappedService() {
		return _rdconnectService;
	}

	@Override
	public void setWrappedService(rdconnectService rdconnectService) {
		_rdconnectService = rdconnectService;
	}

	private rdconnectService _rdconnectService;
}