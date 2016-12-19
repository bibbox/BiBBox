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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for D2Biobank. This utility wraps
 * {@link at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author reihsr
 * @see D2BiobankService
 * @see at.meduni.liferay.portlet.bbmrieric.service.base.D2BiobankServiceBaseImpl
 * @see at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankServiceImpl
 * @generated
 */
public class D2BiobankServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.portal.kernel.json.JSONObject getBiobanks() {
		return getService().getBiobanks();
	}

	public static com.liferay.portal.kernel.json.JSONObject getNextBiobank(
		java.lang.String start) {
		return getService().getNextBiobank(start);
	}

	public static com.liferay.portal.kernel.json.JSONObject getCollections() {
		return getService().getCollections();
	}

	public static com.liferay.portal.kernel.json.JSONObject getNextCollections(
		java.lang.String start) {
		return getService().getNextCollections(start);
	}

	public static com.liferay.portal.kernel.json.JSONObject getBiobanks1234(
		java.lang.String start) {
		return getService().getBiobanks1234(start);
	}

	public static com.liferay.portal.kernel.json.JSONObject getBiobank(
		java.lang.String biobankId) {
		return getService().getBiobank(biobankId);
	}

	public static void clearService() {
		_service = null;
	}

	public static D2BiobankService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					D2BiobankService.class.getName());

			if (invokableService instanceof D2BiobankService) {
				_service = (D2BiobankService)invokableService;
			}
			else {
				_service = new D2BiobankServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(D2BiobankServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(D2BiobankService service) {
	}

	private static D2BiobankService _service;
}