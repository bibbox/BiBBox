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

package at.graz.meduni.liferay.portlet.bibbox.service.base;

import at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalServiceUtil;

import java.util.Arrays;

/**
 * @author reihsr
 * @generated
 */
public class SymbolTypeConfigurationLocalServiceClpInvoker {
	public SymbolTypeConfigurationLocalServiceClpInvoker() {
		_methodName0 = "addSymbolTypeConfiguration";

		_methodParameterTypes0 = new String[] {
				"at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration"
			};

		_methodName1 = "createSymbolTypeConfiguration";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSymbolTypeConfiguration";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSymbolTypeConfiguration";

		_methodParameterTypes3 = new String[] {
				"at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchSymbolTypeConfiguration";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getSymbolTypeConfiguration";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getSymbolTypeConfigurations";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSymbolTypeConfigurationsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSymbolTypeConfiguration";

		_methodParameterTypes15 = new String[] {
				"at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration"
			};

		_methodName58 = "getBeanIdentifier";

		_methodParameterTypes58 = new String[] {  };

		_methodName59 = "setBeanIdentifier";

		_methodParameterTypes59 = new String[] { "java.lang.String" };

		_methodName64 = "getSymbolTypeConfigurationBySymbolType";

		_methodParameterTypes64 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.addSymbolTypeConfiguration((at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.createSymbolTypeConfiguration(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.deleteSymbolTypeConfiguration(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.deleteSymbolTypeConfiguration((at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.fetchSymbolTypeConfiguration(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.getSymbolTypeConfiguration(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.getSymbolTypeConfigurations(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.getSymbolTypeConfigurationsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.updateSymbolTypeConfiguration((at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration)arguments[0]);
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			SymbolTypeConfigurationLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return SymbolTypeConfigurationLocalServiceUtil.getSymbolTypeConfigurationBySymbolType((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName64;
	private String[] _methodParameterTypes64;
}