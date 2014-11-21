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

package com.bcnet.portlet.biobank.service.base;

import com.bcnet.portlet.biobank.service.BiobankAtrributeListsMasterLocalServiceUtil;

import java.util.Arrays;

/**
 * @author suyama
 * @generated
 */
public class BiobankAtrributeListsMasterLocalServiceClpInvoker {
	public BiobankAtrributeListsMasterLocalServiceClpInvoker() {
		_methodName0 = "addBiobankAtrributeListsMaster";

		_methodParameterTypes0 = new String[] {
				"com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster"
			};

		_methodName1 = "createBiobankAtrributeListsMaster";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteBiobankAtrributeListsMaster";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteBiobankAtrributeListsMaster";

		_methodParameterTypes3 = new String[] {
				"com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster"
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

		_methodName10 = "fetchBiobankAtrributeListsMaster";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getBiobankAtrributeListsMaster";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getBiobankAtrributeListsMasters";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getBiobankAtrributeListsMastersCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateBiobankAtrributeListsMaster";

		_methodParameterTypes15 = new String[] {
				"com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster"
			};

		_methodName72 = "getBeanIdentifier";

		_methodParameterTypes72 = new String[] {  };

		_methodName73 = "setBeanIdentifier";

		_methodParameterTypes73 = new String[] { "java.lang.String" };

		_methodName78 = "addBiobankAttributeListsMaster";

		_methodParameterTypes78 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName79 = "deleteBiobankAttributeListsMaster";

		_methodParameterTypes79 = new String[] {
				"com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster"
			};

		_methodName80 = "deleteBiobankAttributeListsMaster";

		_methodParameterTypes80 = new String[] { "long" };

		_methodName81 = "getBiobankAttributeListsMaster";

		_methodParameterTypes81 = new String[] { "long" };

		_methodName82 = "getAllBiobankAtrributeListsMasters";

		_methodParameterTypes82 = new String[] {  };

		_methodName83 = "getAllBiobankAtrributeListsMasters";

		_methodParameterTypes83 = new String[] { "int", "int" };

		_methodName84 = "getBiobankAtrributeListsMasterByAttributeListName";

		_methodParameterTypes84 = new String[] { "java.lang.String" };

		_methodName85 = "updateBiobankAttributeListsMaster";

		_methodParameterTypes85 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.addBiobankAtrributeListsMaster((com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.createBiobankAtrributeListsMaster(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.deleteBiobankAtrributeListsMaster(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.deleteBiobankAtrributeListsMaster((com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.fetchBiobankAtrributeListsMaster(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.getBiobankAtrributeListsMaster(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.getBiobankAtrributeListsMasters(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.getBiobankAtrributeListsMastersCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.updateBiobankAtrributeListsMaster((com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster)arguments[0]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			BiobankAtrributeListsMasterLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.addBiobankAttributeListsMaster((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.deleteBiobankAttributeListsMaster((com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster)arguments[0]);
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.deleteBiobankAttributeListsMaster(((Long)arguments[0]).longValue());
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.getBiobankAttributeListsMaster(((Long)arguments[0]).longValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.getAllBiobankAtrributeListsMasters();
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.getAllBiobankAtrributeListsMasters(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.getBiobankAtrributeListsMasterByAttributeListName((java.lang.String)arguments[0]);
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return BiobankAtrributeListsMasterLocalServiceUtil.updateBiobankAttributeListsMaster(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
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
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName84;
	private String[] _methodParameterTypes84;
	private String _methodName85;
	private String[] _methodParameterTypes85;
}