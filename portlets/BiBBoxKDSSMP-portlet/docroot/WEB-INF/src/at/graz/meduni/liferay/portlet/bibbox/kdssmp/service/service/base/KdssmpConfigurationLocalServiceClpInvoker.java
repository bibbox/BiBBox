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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.base;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpConfigurationLocalServiceUtil;

import java.util.Arrays;

/**
 * @author reihsr
 * @generated
 */
public class KdssmpConfigurationLocalServiceClpInvoker {
	public KdssmpConfigurationLocalServiceClpInvoker() {
		_methodName0 = "addKdssmpConfiguration";

		_methodParameterTypes0 = new String[] {
				"at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration"
			};

		_methodName1 = "createKdssmpConfiguration";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteKdssmpConfiguration";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteKdssmpConfiguration";

		_methodParameterTypes3 = new String[] {
				"at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration"
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

		_methodName10 = "fetchKdssmpConfiguration";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getKdssmpConfiguration";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getKdssmpConfigurations";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getKdssmpConfigurationsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateKdssmpConfiguration";

		_methodParameterTypes15 = new String[] {
				"at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration"
			};

		_methodName60 = "getBeanIdentifier";

		_methodParameterTypes60 = new String[] {  };

		_methodName61 = "setBeanIdentifier";

		_methodParameterTypes61 = new String[] { "java.lang.String" };

		_methodName66 = "getConfigurationOption";

		_methodParameterTypes66 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName67 = "symbolKdssmpConfigurationFromRequest";

		_methodParameterTypes67 = new String[] { "javax.portlet.ActionRequest" };

		_methodName68 = "getConfigurationOptionValue";

		_methodParameterTypes68 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName69 = "getConfigurationOptions";

		_methodParameterTypes69 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName70 = "getConfigurationOptions";

		_methodParameterTypes70 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.addKdssmpConfiguration((at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.createKdssmpConfiguration(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.deleteKdssmpConfiguration(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.deleteKdssmpConfiguration((at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.fetchKdssmpConfiguration(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.getKdssmpConfiguration(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.getKdssmpConfigurations(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.getKdssmpConfigurationsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.updateKdssmpConfiguration((at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration)arguments[0]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			KdssmpConfigurationLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.getConfigurationOption((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.symbolKdssmpConfigurationFromRequest((javax.portlet.ActionRequest)arguments[0]);
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.getConfigurationOptionValue((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.getConfigurationOptions((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return KdssmpConfigurationLocalServiceUtil.getConfigurationOptions((java.lang.String)arguments[0]);
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
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
}