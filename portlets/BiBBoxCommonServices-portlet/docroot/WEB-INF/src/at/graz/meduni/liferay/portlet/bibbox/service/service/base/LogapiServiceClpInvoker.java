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

import at.graz.meduni.liferay.portlet.bibbox.service.service.LogapiServiceUtil;

import java.util.Arrays;

/**
 * @author reihsr
 * @generated
 */
public class LogapiServiceClpInvoker {
	public LogapiServiceClpInvoker() {
		_methodName56 = "getBeanIdentifier";

		_methodParameterTypes56 = new String[] {  };

		_methodName57 = "setBeanIdentifier";

		_methodParameterTypes57 = new String[] { "java.lang.String" };

		_methodName62 = "getAPIVersion";

		_methodParameterTypes62 = new String[] {  };

		_methodName63 = "regbbs";

		_methodParameterTypes63 = new String[] { "java.lang.String" };

		_methodName64 = "getRDConnectBiobanks";

		_methodParameterTypes64 = new String[] {  };

		_methodName65 = "getRDConnectBiobanks";

		_methodParameterTypes65 = new String[] { "java.lang.Integer" };

		_methodName66 = "getRDConnectCollections";

		_methodParameterTypes66 = new String[] {  };

		_methodName67 = "getRDConnectCollections";

		_methodParameterTypes67 = new String[] { "java.lang.Integer" };

		_methodName73 = "regbbs";

		_methodParameterTypes73 = new String[] {  };

		_methodName74 = "findorganizationbyname";

		_methodParameterTypes74 = new String[] { "java.lang.String" };

		_methodName75 = "regs";

		_methodParameterTypes75 = new String[] {  };

		_methodName76 = "bbs";

		_methodParameterTypes76 = new String[] {  };

		_methodName77 = "regbb";

		_methodParameterTypes77 = new String[] { "long" };

		_methodName78 = "regbb";

		_methodParameterTypes78 = new String[] { "long", "long" };

		_methodName79 = "regbb";

		_methodParameterTypes79 = new String[] { "java.lang.String" };

		_methodName80 = "getIdCard";

		_methodParameterTypes80 = new String[] { "long" };

		_methodName81 = "testMethode";

		_methodParameterTypes81 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return LogapiServiceUtil.getBeanIdentifier();
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			LogapiServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return LogapiServiceUtil.getAPIVersion();
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return LogapiServiceUtil.regbbs((java.lang.String)arguments[0]);
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return LogapiServiceUtil.getRDConnectBiobanks();
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return LogapiServiceUtil.getRDConnectBiobanks((java.lang.Integer)arguments[0]);
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return LogapiServiceUtil.getRDConnectCollections();
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return LogapiServiceUtil.getRDConnectCollections((java.lang.Integer)arguments[0]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return LogapiServiceUtil.regbbs();
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return LogapiServiceUtil.findorganizationbyname((java.lang.String)arguments[0]);
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return LogapiServiceUtil.regs();
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return LogapiServiceUtil.bbs();
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return LogapiServiceUtil.regbb(((Long)arguments[0]).longValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return LogapiServiceUtil.regbb(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return LogapiServiceUtil.regbb((java.lang.String)arguments[0]);
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return LogapiServiceUtil.getIdCard(((Long)arguments[0]).longValue());
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			LogapiServiceUtil.testMethode((java.lang.String)arguments[0]);

			return null;
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
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
}