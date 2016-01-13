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

package at.meduni.liferay.portlet.bbmrieric.service.base;

import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLocalServiceUtil;

import java.util.Arrays;

/**
 * @author reihsr
 * @generated
 */
public class D2BiobankNetworkLocalServiceClpInvoker {
	public D2BiobankNetworkLocalServiceClpInvoker() {
		_methodName0 = "addD2BiobankNetwork";

		_methodParameterTypes0 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork"
			};

		_methodName1 = "createD2BiobankNetwork";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteD2BiobankNetwork";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteD2BiobankNetwork";

		_methodParameterTypes3 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork"
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

		_methodName10 = "fetchD2BiobankNetwork";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchD2BiobankNetworkByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchD2BiobankNetworkByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getD2BiobankNetwork";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getD2BiobankNetworkByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getD2BiobankNetworkByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getD2BiobankNetworks";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getD2BiobankNetworksCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateD2BiobankNetwork";

		_methodParameterTypes19 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork"
			};

		_methodName64 = "getBeanIdentifier";

		_methodParameterTypes64 = new String[] {  };

		_methodName65 = "setBeanIdentifier";

		_methodParameterTypes65 = new String[] { "java.lang.String" };

		_methodName70 = "addD2BiobankNetwork";

		_methodParameterTypes70 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName71 = "addD2BiobankNetwork";

		_methodParameterTypes71 = new String[] {
				"long", "long", "long", "long", "java.lang.String",
				"java.lang.String", "long", "java.lang.String",
				"java.lang.String", "boolean", "boolean", "boolean", "boolean",
				"boolean", "boolean", "boolean", "boolean", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName72 = "getLDAPNotUpdatedNetworks";

		_methodParameterTypes72 = new String[] { "long", "java.lang.String" };

		_methodName73 = "getD2BiobankNetworkByBBMRIERICID";

		_methodParameterTypes73 = new String[] { "long", "java.lang.String" };

		_methodName74 = "getD2BiobankNetworkFromLDAP";

		_methodParameterTypes74 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork",
				"javax.naming.directory.Attributes"
			};

		_methodName75 = "updateD2BiobankNetwork";

		_methodParameterTypes75 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName76 = "updateD2BiobankNetwork";

		_methodParameterTypes76 = new String[] {
				"long", "long", "long", "long", "java.lang.String",
				"java.lang.String", "long", "java.lang.String",
				"java.lang.String", "boolean", "boolean", "boolean", "boolean",
				"boolean", "boolean", "boolean", "boolean", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.addD2BiobankNetwork((at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.createD2BiobankNetwork(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.deleteD2BiobankNetwork(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.deleteD2BiobankNetwork((at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.fetchD2BiobankNetwork(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.fetchD2BiobankNetworkByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.fetchD2BiobankNetworkByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.getD2BiobankNetwork(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.getD2BiobankNetworkByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.getD2BiobankNetworkByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.getD2BiobankNetworks(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.getD2BiobankNetworksCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.updateD2BiobankNetwork((at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork)arguments[0]);
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			D2BiobankNetworkLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.addD2BiobankNetwork((at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.addD2BiobankNetwork(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				((Long)arguments[6]).longValue(),
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				((Boolean)arguments[9]).booleanValue(),
				((Boolean)arguments[10]).booleanValue(),
				((Boolean)arguments[11]).booleanValue(),
				((Boolean)arguments[12]).booleanValue(),
				((Boolean)arguments[13]).booleanValue(),
				((Boolean)arguments[14]).booleanValue(),
				((Boolean)arguments[15]).booleanValue(),
				((Boolean)arguments[16]).booleanValue(),
				(java.lang.String)arguments[17],
				(java.lang.String)arguments[18],
				(java.lang.String)arguments[19],
				(java.lang.String)arguments[20],
				(java.lang.String)arguments[21],
				(java.lang.String)arguments[22],
				(java.lang.String)arguments[23],
				(com.liferay.portal.service.ServiceContext)arguments[24]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.getLDAPNotUpdatedNetworks(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.getD2BiobankNetworkByBBMRIERICID(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.getD2BiobankNetworkFromLDAP((at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork)arguments[0],
				(javax.naming.directory.Attributes)arguments[1]);
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.updateD2BiobankNetwork((at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return D2BiobankNetworkLocalServiceUtil.updateD2BiobankNetwork(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				((Long)arguments[6]).longValue(),
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				((Boolean)arguments[9]).booleanValue(),
				((Boolean)arguments[10]).booleanValue(),
				((Boolean)arguments[11]).booleanValue(),
				((Boolean)arguments[12]).booleanValue(),
				((Boolean)arguments[13]).booleanValue(),
				((Boolean)arguments[14]).booleanValue(),
				((Boolean)arguments[15]).booleanValue(),
				((Boolean)arguments[16]).booleanValue(),
				(java.lang.String)arguments[17],
				(java.lang.String)arguments[18],
				(java.lang.String)arguments[19],
				(java.lang.String)arguments[20],
				(java.lang.String)arguments[21],
				(java.lang.String)arguments[22],
				(java.lang.String)arguments[23],
				(com.liferay.portal.service.ServiceContext)arguments[24]);
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
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
}