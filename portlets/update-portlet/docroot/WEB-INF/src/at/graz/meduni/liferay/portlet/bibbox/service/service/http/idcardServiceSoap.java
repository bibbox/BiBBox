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

import at.graz.meduni.liferay.portlet.bibbox.service.service.idcardServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link at.graz.meduni.liferay.portlet.bibbox.service.service.idcardServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link at.graz.meduni.liferay.portlet.bibbox.service.model.idcardSoap}.
 * If the method in the service utility returns a
 * {@link at.graz.meduni.liferay.portlet.bibbox.service.model.idcard}, that is translated to a
 * {@link at.graz.meduni.liferay.portlet.bibbox.service.model.idcardSoap}. Methods that SOAP cannot
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
 * @see idcardServiceHttp
 * @see at.graz.meduni.liferay.portlet.bibbox.service.model.idcardSoap
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.idcardServiceUtil
 * @generated
 */
public class idcardServiceSoap {
	public static java.lang.String TestVariables(long idcardid)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = idcardServiceUtil.TestVariables(idcardid);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String DiseaseMatrix(long idcardid, long diseaseid,
		java.lang.String diseasname, java.lang.String patientcount,
		java.lang.String gene, java.lang.String orphanumber,
		java.lang.String icd10, java.lang.String omim, java.lang.String synonym)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = idcardServiceUtil.DiseaseMatrix(idcardid,
					diseaseid, diseasname, patientcount, gene, orphanumber,
					icd10, omim, synonym);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String DiseaseMatrix(java.lang.String url,
		long diseaseid, java.lang.String diseasname,
		java.lang.String patientcount, java.lang.String gene,
		java.lang.String orphanumber, java.lang.String icd10,
		java.lang.String omim, java.lang.String synonym)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = idcardServiceUtil.DiseaseMatrix(url,
					diseaseid, diseasname, patientcount, gene, orphanumber,
					icd10, omim, synonym);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String DiseaseMatrix(long idcardid,
		java.lang.String diseasname, java.lang.String patientcount,
		java.lang.String gene, java.lang.String orphanumber,
		java.lang.String icd10, java.lang.String omim, java.lang.String synonym)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = idcardServiceUtil.DiseaseMatrix(idcardid,
					diseasname, patientcount, gene, orphanumber, icd10, omim,
					synonym);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String DiseaseMatrix(java.lang.String url,
		java.lang.String diseasname, java.lang.String patientcount,
		java.lang.String gene, java.lang.String orphanumber,
		java.lang.String icd10, java.lang.String omim, java.lang.String synonym)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = idcardServiceUtil.DiseaseMatrix(url,
					diseasname, patientcount, gene, orphanumber, icd10, omim,
					synonym);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(idcardServiceSoap.class);
}