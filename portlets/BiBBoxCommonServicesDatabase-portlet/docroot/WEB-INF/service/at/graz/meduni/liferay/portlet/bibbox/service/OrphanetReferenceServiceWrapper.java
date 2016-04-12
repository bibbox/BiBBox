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

package at.graz.meduni.liferay.portlet.bibbox.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OrphanetReferenceService}.
 *
 * @author reihsr
 * @see OrphanetReferenceService
 * @generated
 */
public class OrphanetReferenceServiceWrapper implements OrphanetReferenceService,
	ServiceWrapper<OrphanetReferenceService> {
	public OrphanetReferenceServiceWrapper(
		OrphanetReferenceService orphanetReferenceService) {
		_orphanetReferenceService = orphanetReferenceService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _orphanetReferenceService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_orphanetReferenceService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _orphanetReferenceService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OrphanetReferenceService getWrappedOrphanetReferenceService() {
		return _orphanetReferenceService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOrphanetReferenceService(
		OrphanetReferenceService orphanetReferenceService) {
		_orphanetReferenceService = orphanetReferenceService;
	}

	@Override
	public OrphanetReferenceService getWrappedService() {
		return _orphanetReferenceService;
	}

	@Override
	public void setWrappedService(
		OrphanetReferenceService orphanetReferenceService) {
		_orphanetReferenceService = orphanetReferenceService;
	}

	private OrphanetReferenceService _orphanetReferenceService;
}