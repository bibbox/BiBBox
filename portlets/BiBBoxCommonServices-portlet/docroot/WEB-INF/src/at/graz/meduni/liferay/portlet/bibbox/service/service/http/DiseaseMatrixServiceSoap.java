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

import at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrixSoap}.
 * If the method in the service utility returns a
 * {@link at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix}, that is translated to a
 * {@link at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrixSoap}. Methods that SOAP cannot
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
 * @see DiseaseMatrixServiceHttp
 * @see at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrixSoap
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixServiceUtil
 * @generated
 */
public class DiseaseMatrixServiceSoap {
	public static java.lang.String testupdatediseasematrix(long organizationId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = DiseaseMatrixServiceUtil.testupdatediseasematrix(organizationId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrixSoap updatediseasematrix(
		long organizationId,
		at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrixSoap matrix)
		throws RemoteException {
		try {
			at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix returnValue =
				DiseaseMatrixServiceUtil.updatediseasematrix(organizationId,
					at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixModelImpl.toModel(
						matrix));

			return at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrixSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void updatediseasematrixs(long organizationId,
		at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrixSoap[] matrixs)
		throws RemoteException {
		try {
			DiseaseMatrixServiceUtil.updatediseasematrixs(organizationId,
				at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixModelImpl.toModels(
					matrixs));
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String regbb(long organizationId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = DiseaseMatrixServiceUtil.regbb(organizationId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrixSoap getDiseaseMatrix(
		long organizationId) throws RemoteException {
		try {
			at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix returnValue =
				DiseaseMatrixServiceUtil.getDiseaseMatrix(organizationId);

			return at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrixSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DiseaseMatrixServiceSoap.class);
}