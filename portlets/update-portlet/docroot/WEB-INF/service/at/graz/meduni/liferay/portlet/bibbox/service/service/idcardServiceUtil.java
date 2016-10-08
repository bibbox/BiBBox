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
 * Provides the remote service utility for idcard. This utility wraps
 * {@link at.graz.meduni.liferay.portlet.bibbox.service.service.impl.idcardServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author reihsr
 * @see idcardService
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.base.idcardServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.impl.idcardServiceImpl
 * @generated
 */
public class idcardServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.meduni.liferay.portlet.bibbox.service.service.impl.idcardServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.portal.kernel.json.JSONObject TestVariables(
		long idcardid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().TestVariables(idcardid);
	}

	public static com.liferay.portal.kernel.json.JSONObject DiseaseMatrix(
		long idcardid, long diseaseid, java.lang.String diseasname,
		java.lang.String patientcount, java.lang.String gene,
		java.lang.String orphanumber, java.lang.String icd10,
		java.lang.String omim, java.lang.String synonym) {
		return getService()
				   .DiseaseMatrix(idcardid, diseaseid, diseasname,
			patientcount, gene, orphanumber, icd10, omim, synonym);
	}

	public static com.liferay.portal.kernel.json.JSONObject DiseaseMatrix(
		java.lang.String url, long diseaseid, java.lang.String diseasname,
		java.lang.String patientcount, java.lang.String gene,
		java.lang.String orphanumber, java.lang.String icd10,
		java.lang.String omim, java.lang.String synonym) {
		return getService()
				   .DiseaseMatrix(url, diseaseid, diseasname, patientcount,
			gene, orphanumber, icd10, omim, synonym);
	}

	public static com.liferay.portal.kernel.json.JSONObject DiseaseMatrix(
		long idcardid, java.lang.String diseasname,
		java.lang.String patientcount, java.lang.String gene,
		java.lang.String orphanumber, java.lang.String icd10,
		java.lang.String omim, java.lang.String synonym) {
		return getService()
				   .DiseaseMatrix(idcardid, diseasname, patientcount, gene,
			orphanumber, icd10, omim, synonym);
	}

	public static com.liferay.portal.kernel.json.JSONObject DiseaseMatrix(
		java.lang.String url, java.lang.String diseasname,
		java.lang.String patientcount, java.lang.String gene,
		java.lang.String orphanumber, java.lang.String icd10,
		java.lang.String omim, java.lang.String synonym) {
		return getService()
				   .DiseaseMatrix(url, diseasname, patientcount, gene,
			orphanumber, icd10, omim, synonym);
	}

	public static void clearService() {
		_service = null;
	}

	public static idcardService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					idcardService.class.getName());

			if (invokableService instanceof idcardService) {
				_service = (idcardService)invokableService;
			}
			else {
				_service = new idcardServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(idcardServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(idcardService service) {
	}

	private static idcardService _service;
}