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
 * Provides a wrapper for {@link DictionaryDictionaryLinkService}.
 *
 * @author reihsr
 * @see DictionaryDictionaryLinkService
 * @generated
 */
public class DictionaryDictionaryLinkServiceWrapper
	implements DictionaryDictionaryLinkService,
		ServiceWrapper<DictionaryDictionaryLinkService> {
	public DictionaryDictionaryLinkServiceWrapper(
		DictionaryDictionaryLinkService dictionaryDictionaryLinkService) {
		_dictionaryDictionaryLinkService = dictionaryDictionaryLinkService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _dictionaryDictionaryLinkService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dictionaryDictionaryLinkService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dictionaryDictionaryLinkService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DictionaryDictionaryLinkService getWrappedDictionaryDictionaryLinkService() {
		return _dictionaryDictionaryLinkService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDictionaryDictionaryLinkService(
		DictionaryDictionaryLinkService dictionaryDictionaryLinkService) {
		_dictionaryDictionaryLinkService = dictionaryDictionaryLinkService;
	}

	@Override
	public DictionaryDictionaryLinkService getWrappedService() {
		return _dictionaryDictionaryLinkService;
	}

	@Override
	public void setWrappedService(
		DictionaryDictionaryLinkService dictionaryDictionaryLinkService) {
		_dictionaryDictionaryLinkService = dictionaryDictionaryLinkService;
	}

	private DictionaryDictionaryLinkService _dictionaryDictionaryLinkService;
}