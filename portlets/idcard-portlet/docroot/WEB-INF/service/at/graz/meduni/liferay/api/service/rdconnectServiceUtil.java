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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for rdconnect. This utility wraps
 * {@link at.graz.meduni.liferay.api.service.impl.rdconnectServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author reihsr
 * @see rdconnectService
 * @see at.graz.meduni.liferay.api.service.base.rdconnectServiceBaseImpl
 * @see at.graz.meduni.liferay.api.service.impl.rdconnectServiceImpl
 * @generated
 */
public class rdconnectServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.meduni.liferay.api.service.impl.rdconnectServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static at.graz.meduni.liferay.api.model.rdconnect getRdconnect()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRdconnect();
	}

	public static void updateregbb(long organizationId,
		com.liferay.portal.kernel.json.JSONObject json) {
		getService().updateregbb(organizationId, json);
	}

	public static void updateregbb2(long organizationId) {
		getService().updateregbb2(organizationId);
	}

	public static void updatedisease(long organizationId,
		java.lang.String diseasename, java.lang.String count) {
		getService().updatedisease(organizationId, diseasename, count);
	}

	public static void updatedisease(long organizationId, long diseasematrixId,
		java.lang.String count) {
		getService().updatedisease(organizationId, diseasematrixId, count);
	}

	public static com.liferay.portal.kernel.json.JSONObject regbb(
		long organizationId) {
		return getService().regbb(organizationId);
	}

	public static com.liferay.portal.kernel.json.JSONArray regbbs() {
		return getService().regbbs();
	}

	/**
	* @return
	*/
	public static com.liferay.portal.kernel.json.JSONArray regs() {
		return getService().regs();
	}

	/**
	* @return
	*/
	public static com.liferay.portal.kernel.json.JSONArray bbs() {
		return getService().bbs();
	}

	public static void clearService() {
		_service = null;
	}

	public static rdconnectService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					rdconnectService.class.getName());

			if (invokableService instanceof rdconnectService) {
				_service = (rdconnectService)invokableService;
			}
			else {
				_service = new rdconnectServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(rdconnectServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(rdconnectService service) {
	}

	private static rdconnectService _service;
}