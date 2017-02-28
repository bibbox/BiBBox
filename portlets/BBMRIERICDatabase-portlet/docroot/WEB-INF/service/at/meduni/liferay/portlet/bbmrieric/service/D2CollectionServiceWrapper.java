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

package at.meduni.liferay.portlet.bbmrieric.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link D2CollectionService}.
 *
 * @author reihsr
 * @see D2CollectionService
 * @generated
 */
public class D2CollectionServiceWrapper implements D2CollectionService,
	ServiceWrapper<D2CollectionService> {
	public D2CollectionServiceWrapper(D2CollectionService d2CollectionService) {
		_d2CollectionService = d2CollectionService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _d2CollectionService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_d2CollectionService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _d2CollectionService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getBiobanks() {
		return _d2CollectionService.getBiobanks();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getNextBiobank(
		java.lang.String start) {
		return _d2CollectionService.getNextBiobank(start);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getCollections() {
		return _d2CollectionService.getCollections();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getNextCollections(
		java.lang.String start) {
		return _d2CollectionService.getNextCollections(start);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getBiobanks1234(
		java.lang.String start) {
		return _d2CollectionService.getBiobanks1234(start);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getBiobank(
		java.lang.String biobankId) {
		return _d2CollectionService.getBiobank(biobankId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public D2CollectionService getWrappedD2CollectionService() {
		return _d2CollectionService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedD2CollectionService(
		D2CollectionService d2CollectionService) {
		_d2CollectionService = d2CollectionService;
	}

	@Override
	public D2CollectionService getWrappedService() {
		return _d2CollectionService;
	}

	@Override
	public void setWrappedService(D2CollectionService d2CollectionService) {
		_d2CollectionService = d2CollectionService;
	}

	private D2CollectionService _d2CollectionService;
}