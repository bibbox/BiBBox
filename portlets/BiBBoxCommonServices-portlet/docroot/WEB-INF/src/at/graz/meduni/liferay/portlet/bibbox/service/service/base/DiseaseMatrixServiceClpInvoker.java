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
		_methodName50 = "getBeanIdentifier";

		_methodParameterTypes50 = new String[] {  };

		_methodName51 = "setBeanIdentifier";

		_methodParameterTypes51 = new String[] { "java.lang.String" };

		_methodName56 = "testupdatediseasematrix";

		_methodParameterTypes56 = new String[] { "long" };

		_methodName57 = "updatediseasematrix";

		_methodParameterTypes57 = new String[] {
				"long",
				"at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix"
			};

		_methodName58 = "updatediseasematrixs";

		_methodParameterTypes58 = new String[] { "long", "java.util.List" };

		_methodName59 = "regbb";

		_methodParameterTypes59 = new String[] { "long" };

		_methodName60 = "getDiseaseMatrix";

		_methodParameterTypes60 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return DiseaseMatrixServiceUtil.getBeanIdentifier();
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			DiseaseMatrixServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return DiseaseMatrixServiceUtil.testupdatediseasematrix(((Long)arguments[0]).longValue());
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return DiseaseMatrixServiceUtil.updatediseasematrix(((Long)arguments[0]).longValue(),
				(at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix)arguments[1]);
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			DiseaseMatrixServiceUtil.updatediseasematrixs(((Long)arguments[0]).longValue(),
				(java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix>)arguments[1]);

			return null;
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return DiseaseMatrixServiceUtil.regbb(((Long)arguments[0]).longValue());
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return DiseaseMatrixServiceUtil.getDiseaseMatrix(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
}