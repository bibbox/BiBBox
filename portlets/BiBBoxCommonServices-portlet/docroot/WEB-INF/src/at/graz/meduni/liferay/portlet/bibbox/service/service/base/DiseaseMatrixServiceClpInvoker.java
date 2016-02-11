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

package at.graz.meduni.liferay.portlet.bibbox.service.service.base;

import at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixServiceUtil;

import java.util.Arrays;

/**
 * @author reihsr
 * @generated
 */
public class DiseaseMatrixServiceClpInvoker {
	public DiseaseMatrixServiceClpInvoker() {
		_methodName56 = "getBeanIdentifier";

		_methodParameterTypes56 = new String[] {  };

		_methodName57 = "setBeanIdentifier";

		_methodParameterTypes57 = new String[] { "java.lang.String" };

		_methodName62 = "testupdatediseasematrix";

		_methodParameterTypes62 = new String[] { "long" };

		_methodName63 = "updatediseasematrix";

		_methodParameterTypes63 = new String[] {
				"long",
				"at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix"
			};

		_methodName64 = "updatediseasematrixs";

		_methodParameterTypes64 = new String[] { "long", "java.util.List" };

		_methodName65 = "regbb";

		_methodParameterTypes65 = new String[] { "long" };

		_methodName66 = "getDiseaseMatrix";

		_methodParameterTypes66 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return DiseaseMatrixServiceUtil.getBeanIdentifier();
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			DiseaseMatrixServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return DiseaseMatrixServiceUtil.testupdatediseasematrix(((Long)arguments[0]).longValue());
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return DiseaseMatrixServiceUtil.updatediseasematrix(((Long)arguments[0]).longValue(),
				(at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix)arguments[1]);
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			DiseaseMatrixServiceUtil.updatediseasematrixs(((Long)arguments[0]).longValue(),
				(java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix>)arguments[1]);

			return null;
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return DiseaseMatrixServiceUtil.regbb(((Long)arguments[0]).longValue());
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return DiseaseMatrixServiceUtil.getDiseaseMatrix(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName66;
	private String[] _methodParameterTypes66;
}