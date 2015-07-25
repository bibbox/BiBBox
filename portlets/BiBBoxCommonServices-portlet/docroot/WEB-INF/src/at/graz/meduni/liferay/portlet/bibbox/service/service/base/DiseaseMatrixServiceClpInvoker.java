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
		_methodName44 = "getBeanIdentifier";

		_methodParameterTypes44 = new String[] {  };

		_methodName45 = "setBeanIdentifier";

		_methodParameterTypes45 = new String[] { "java.lang.String" };

		_methodName50 = "updatediseasematrix";

		_methodParameterTypes50 = new String[] {
				"long",
				"at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix"
			};

		_methodName51 = "updatediseasematrixs";

		_methodParameterTypes51 = new String[] { "long", "java.util.List" };

		_methodName52 = "regbb";

		_methodParameterTypes52 = new String[] { "long" };

		_methodName53 = "getDiseaseMatrix";

		_methodParameterTypes53 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return DiseaseMatrixServiceUtil.getBeanIdentifier();
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			DiseaseMatrixServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			DiseaseMatrixServiceUtil.updatediseasematrix(((Long)arguments[0]).longValue(),
				(at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix)arguments[1]);

			return null;
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			DiseaseMatrixServiceUtil.updatediseasematrixs(((Long)arguments[0]).longValue(),
				(java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix>)arguments[1]);

			return null;
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return DiseaseMatrixServiceUtil.regbb(((Long)arguments[0]).longValue());
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return DiseaseMatrixServiceUtil.getDiseaseMatrix(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
}