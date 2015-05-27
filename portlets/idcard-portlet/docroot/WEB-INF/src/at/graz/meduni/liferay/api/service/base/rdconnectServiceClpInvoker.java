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

package at.graz.meduni.liferay.api.service.base;

import at.graz.meduni.liferay.api.service.rdconnectServiceUtil;

import java.util.Arrays;

/**
 * @author reihsr
 * @generated
 */
public class rdconnectServiceClpInvoker {
	public rdconnectServiceClpInvoker() {
		_methodName18 = "getBeanIdentifier";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "setBeanIdentifier";

		_methodParameterTypes19 = new String[] { "java.lang.String" };

		_methodName24 = "getRdconnect";

		_methodParameterTypes24 = new String[] {  };

		_methodName25 = "updateregbb";

		_methodParameterTypes25 = new String[] {
				"long", "com.liferay.portal.kernel.json.JSONObject"
			};

		_methodName26 = "updateregbb2";

		_methodParameterTypes26 = new String[] { "long" };

		_methodName27 = "updatedisease";

		_methodParameterTypes27 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName28 = "updatedisease";

		_methodParameterTypes28 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName29 = "regbb";

		_methodParameterTypes29 = new String[] { "long" };

		_methodName30 = "regbbs";

		_methodParameterTypes30 = new String[] {  };

		_methodName31 = "regs";

		_methodParameterTypes31 = new String[] {  };

		_methodName32 = "bbs";

		_methodParameterTypes32 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return rdconnectServiceUtil.getBeanIdentifier();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			rdconnectServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return rdconnectServiceUtil.getRdconnect();
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			rdconnectServiceUtil.updateregbb(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.json.JSONObject)arguments[1]);

			return null;
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			rdconnectServiceUtil.updateregbb2(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			rdconnectServiceUtil.updatedisease(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);

			return null;
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			rdconnectServiceUtil.updatedisease(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);

			return null;
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return rdconnectServiceUtil.regbb(((Long)arguments[0]).longValue());
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return rdconnectServiceUtil.regbbs();
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			return rdconnectServiceUtil.regs();
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return rdconnectServiceUtil.bbs();
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
}