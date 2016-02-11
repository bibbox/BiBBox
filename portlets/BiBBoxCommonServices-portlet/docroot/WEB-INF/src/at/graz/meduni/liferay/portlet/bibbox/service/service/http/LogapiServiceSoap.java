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

package at.graz.meduni.liferay.portlet.bibbox.service.service.http;

import at.graz.meduni.liferay.portlet.bibbox.service.service.LogapiServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link at.graz.meduni.liferay.portlet.bibbox.service.service.LogapiServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link at.graz.meduni.liferay.portlet.bibbox.service.model.LogapiSoap}.
 * If the method in the service utility returns a
 * {@link at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi}, that is translated to a
 * {@link at.graz.meduni.liferay.portlet.bibbox.service.model.LogapiSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author reihsr
 * @see LogapiServiceHttp
 * @see at.graz.meduni.liferay.portlet.bibbox.service.model.LogapiSoap
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.LogapiServiceUtil
 * @generated
 */
public class LogapiServiceSoap {
	/**
	* @return
	*/
	public static java.lang.String getAPIVersion() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = LogapiServiceUtil.getAPIVersion();

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* @return
	*/
	public static java.lang.String regbbs(java.lang.String data)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = LogapiServiceUtil.regbbs(data);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* @return
	*/
	public static java.lang.String regbbs() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = LogapiServiceUtil.regbbs();

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* @return
	*/
	public static java.lang.String regs() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = LogapiServiceUtil.regs();

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* @return
	*/
	public static java.lang.String bbs() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = LogapiServiceUtil.bbs();

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* @param organizationId
	* @return
	*/
	public static java.lang.String regbb(long organizationId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = LogapiServiceUtil.regbb(organizationId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* @param organizationId
	* @return
	*/
	public static java.lang.String regbb(long organizationId, long collectionId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = LogapiServiceUtil.regbb(organizationId,
					collectionId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String regbb(java.lang.String id)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = LogapiServiceUtil.regbb(id);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void testMethode(java.lang.String jason)
		throws RemoteException {
		try {
			LogapiServiceUtil.testMethode(jason);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void resttest01(long organizationId)
		throws RemoteException {
		try {
			LogapiServiceUtil.resttest01(organizationId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void resttest02(java.lang.String text)
		throws RemoteException {
		try {
			LogapiServiceUtil.resttest02(text);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void resttest03(long[] array) throws RemoteException {
		try {
			LogapiServiceUtil.resttest03(array);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void resttest04(java.lang.String[] array)
		throws RemoteException {
		try {
			LogapiServiceUtil.resttest04(array);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void resttest05(java.lang.String url,
		com.liferay.portal.model.UserSoap user) throws RemoteException {
		try {
			LogapiServiceUtil.resttest05(url,
				com.liferay.portal.model.impl.UserModelImpl.toModel(user));
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void resttest06(java.lang.String url,
		java.lang.String diseasname, java.lang.String patientcount,
		java.lang.String gene, java.lang.String orphanumber,
		java.lang.String icd10, java.lang.String omim, java.lang.String synonym)
		throws RemoteException {
		try {
			LogapiServiceUtil.resttest06(url, diseasname, patientcount, gene,
				orphanumber, icd10, omim, synonym);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void resttest07(java.lang.String url,
		java.lang.String diseasname, java.lang.String patientcount,
		java.lang.String gene, java.lang.String orphanumber,
		java.lang.String icd10, java.lang.String omim, java.lang.String synonym)
		throws RemoteException {
		try {
			LogapiServiceUtil.resttest07(url, diseasname, patientcount, gene,
				orphanumber, icd10, omim, synonym);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LogapiServiceSoap.class);
}