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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Logapi. This utility wraps
 * {@link at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author reihsr
 * @see LogapiService
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.base.LogapiServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl
 * @generated
 */
public class LogapiServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	/**
	* @return
	*/
	public static com.liferay.portal.kernel.json.JSONObject getAPIVersion() {
		return getService().getAPIVersion();
	}

	/**
	* @return
	*/
	public static com.liferay.portal.kernel.json.JSONArray regbbs(
		java.lang.String data) {
		return getService().regbbs(data);
	}

	/**
	* @return
	*/
	public static com.liferay.portal.kernel.json.JSONArray regbbs() {
		return getService().regbbs();
	}

	public static com.liferay.portal.kernel.json.JSONArray findorganizationbyname(
		java.lang.String organizationname) {
		return getService().findorganizationbyname(organizationname);
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

	/**
	* @param organizationId
	* @return
	*/
	public static com.liferay.portal.kernel.json.JSONObject regbb(
		long organizationId) {
		return getService().regbb(organizationId);
	}

	/**
	* @param organizationId
	* @return
	*/
	public static com.liferay.portal.kernel.json.JSONObject regbb(
		long organizationId, long collectionId) {
		return getService().regbb(organizationId, collectionId);
	}

	public static com.liferay.portal.kernel.json.JSONObject regbb(
		java.lang.String id) {
		return getService().regbb(id);
	}

	public static java.lang.String getIdCard(long organizationId) {
		return getService().getIdCard(organizationId);
	}

	public static void testMethode(java.lang.String jason) {
		getService().testMethode(jason);
	}

	public static java.lang.String fdp() {
		return getService().fdp();
	}

	public static void clearService() {
		_service = null;
	}

	public static LogapiService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LogapiService.class.getName());

			if (invokableService instanceof LogapiService) {
				_service = (LogapiService)invokableService;
			}
			else {
				_service = new LogapiServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(LogapiServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LogapiService service) {
	}

	private static LogapiService _service;
}