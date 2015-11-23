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

import at.meduni.liferay.portlet.bbmrieric.service.D2CollectionLocalServiceUtil;

import java.util.Arrays;

/**
 * @author reihsr
 * @generated
 */
public class D2CollectionLocalServiceClpInvoker {
	public D2CollectionLocalServiceClpInvoker() {
		_methodName0 = "addD2Collection";

		_methodParameterTypes0 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2Collection"
			};

		_methodName1 = "createD2Collection";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteD2Collection";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteD2Collection";

		_methodParameterTypes3 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2Collection"
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

		_methodName10 = "fetchD2Collection";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchD2CollectionByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchD2CollectionByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getD2Collection";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getD2CollectionByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getD2CollectionByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getD2Collections";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getD2CollectionsCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateD2Collection";

		_methodParameterTypes19 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2Collection"
			};

		_methodName56 = "getBeanIdentifier";

		_methodParameterTypes56 = new String[] {  };

		_methodName57 = "setBeanIdentifier";

		_methodParameterTypes57 = new String[] { "java.lang.String" };

		_methodName62 = "addD2Collection";

		_methodParameterTypes62 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2Collection",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName63 = "addD2Collection";

		_methodParameterTypes63 = new String[] {
				"long", "long", "long", "long", "long", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "boolean", "boolean",
				"boolean", "boolean", "boolean", "boolean", "boolean", "boolean",
				"boolean", "boolean", "boolean", "boolean", "java.lang.String",
				"boolean", "boolean", "boolean", "boolean", "boolean", "boolean",
				"boolean", "boolean", "boolean", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"boolean", "boolean", "java.lang.String", "java.lang.String",
				"boolean", "boolean", "boolean", "boolean", "long", "long",
				"java.lang.String", "boolean", "boolean", "boolean", "boolean",
				"boolean", "boolean", "boolean", "java.lang.String", "boolean",
				"boolean", "boolean", "boolean", "boolean", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "boolean", "boolean", "java.lang.String",
				"java.lang.String", "boolean", "boolean", "java.lang.String",
				"java.lang.String", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName64 = "updateD2Collection";

		_methodParameterTypes64 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2Collection",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName65 = "updateD2Collection";

		_methodParameterTypes65 = new String[] {
				"long", "long", "long", "long", "long", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "boolean", "boolean",
				"boolean", "boolean", "boolean", "boolean", "boolean", "boolean",
				"boolean", "boolean", "boolean", "boolean", "java.lang.String",
				"boolean", "boolean", "boolean", "boolean", "boolean", "boolean",
				"boolean", "boolean", "boolean", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"boolean", "boolean", "java.lang.String", "java.lang.String",
				"boolean", "boolean", "boolean", "boolean", "long", "long",
				"java.lang.String", "boolean", "boolean", "boolean", "boolean",
				"boolean", "boolean", "boolean", "java.lang.String", "boolean",
				"boolean", "boolean", "boolean", "boolean", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "boolean", "boolean", "java.lang.String",
				"java.lang.String", "boolean", "boolean", "java.lang.String",
				"java.lang.String", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName66 = "getD2CollectionByBBMRIERICID";

		_methodParameterTypes66 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName67 = "getD2CollectionByBiobankId";

		_methodParameterTypes67 = new String[] { "long" };

		_methodName68 = "getRootD2Collection";

		_methodParameterTypes68 = new String[] { "long" };

		_methodName69 = "getChildD2Collection";

		_methodParameterTypes69 = new String[] { "long", "long" };

		_methodName70 = "getD2CollectionByBiobankIdCount";

		_methodParameterTypes70 = new String[] { "long" };

		_methodName71 = "getD2CollectionFromLDAP";

		_methodParameterTypes71 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2Collection",
				"javax.naming.directory.Attributes"
			};

		_methodName72 = "getLDAPNotUpdatedCollection";

		_methodParameterTypes72 = new String[] { "long", "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return D2CollectionLocalServiceUtil.addD2Collection((at.meduni.liferay.portlet.bbmrieric.model.D2Collection)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return D2CollectionLocalServiceUtil.createD2Collection(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return D2CollectionLocalServiceUtil.deleteD2Collection(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return D2CollectionLocalServiceUtil.deleteD2Collection((at.meduni.liferay.portlet.bbmrieric.model.D2Collection)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return D2CollectionLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return D2CollectionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return D2CollectionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return D2CollectionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return D2CollectionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return D2CollectionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return D2CollectionLocalServiceUtil.fetchD2Collection(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return D2CollectionLocalServiceUtil.fetchD2CollectionByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return D2CollectionLocalServiceUtil.fetchD2CollectionByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return D2CollectionLocalServiceUtil.getD2Collection(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return D2CollectionLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return D2CollectionLocalServiceUtil.getD2CollectionByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return D2CollectionLocalServiceUtil.getD2CollectionByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return D2CollectionLocalServiceUtil.getD2Collections(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return D2CollectionLocalServiceUtil.getD2CollectionsCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return D2CollectionLocalServiceUtil.updateD2Collection((at.meduni.liferay.portlet.bbmrieric.model.D2Collection)arguments[0]);
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return D2CollectionLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			D2CollectionLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return D2CollectionLocalServiceUtil.addD2Collection((at.meduni.liferay.portlet.bbmrieric.model.D2Collection)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return D2CollectionLocalServiceUtil.addD2Collection(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				(java.lang.String)arguments[8], (java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				((Boolean)arguments[11]).booleanValue(),
				((Boolean)arguments[12]).booleanValue(),
				((Boolean)arguments[13]).booleanValue(),
				((Boolean)arguments[14]).booleanValue(),
				((Boolean)arguments[15]).booleanValue(),
				((Boolean)arguments[16]).booleanValue(),
				((Boolean)arguments[17]).booleanValue(),
				((Boolean)arguments[18]).booleanValue(),
				((Boolean)arguments[19]).booleanValue(),
				((Boolean)arguments[20]).booleanValue(),
				((Boolean)arguments[21]).booleanValue(),
				((Boolean)arguments[22]).booleanValue(),
				(java.lang.String)arguments[23],
				((Boolean)arguments[24]).booleanValue(),
				((Boolean)arguments[25]).booleanValue(),
				((Boolean)arguments[26]).booleanValue(),
				((Boolean)arguments[27]).booleanValue(),
				((Boolean)arguments[28]).booleanValue(),
				((Boolean)arguments[29]).booleanValue(),
				((Boolean)arguments[30]).booleanValue(),
				((Boolean)arguments[31]).booleanValue(),
				((Boolean)arguments[32]).booleanValue(),
				(java.lang.String)arguments[33],
				((Long)arguments[34]).longValue(),
				(java.lang.String)arguments[35],
				(java.lang.String)arguments[36],
				((Long)arguments[37]).longValue(),
				(java.lang.String)arguments[38],
				(java.lang.String)arguments[39],
				(java.lang.String)arguments[40],
				((Boolean)arguments[41]).booleanValue(),
				((Boolean)arguments[42]).booleanValue(),
				(java.lang.String)arguments[43],
				(java.lang.String)arguments[44],
				((Boolean)arguments[45]).booleanValue(),
				((Boolean)arguments[46]).booleanValue(),
				((Boolean)arguments[47]).booleanValue(),
				((Boolean)arguments[48]).booleanValue(),
				((Long)arguments[49]).longValue(),
				((Long)arguments[50]).longValue(),
				(java.lang.String)arguments[51],
				((Boolean)arguments[52]).booleanValue(),
				((Boolean)arguments[53]).booleanValue(),
				((Boolean)arguments[54]).booleanValue(),
				((Boolean)arguments[55]).booleanValue(),
				((Boolean)arguments[56]).booleanValue(),
				((Boolean)arguments[57]).booleanValue(),
				((Boolean)arguments[58]).booleanValue(),
				(java.lang.String)arguments[59],
				((Boolean)arguments[60]).booleanValue(),
				((Boolean)arguments[61]).booleanValue(),
				((Boolean)arguments[62]).booleanValue(),
				((Boolean)arguments[63]).booleanValue(),
				((Boolean)arguments[64]).booleanValue(),
				(java.lang.String)arguments[65],
				(java.lang.String)arguments[66],
				(java.lang.String)arguments[67],
				(java.lang.String)arguments[68],
				(java.lang.String)arguments[69],
				((Boolean)arguments[70]).booleanValue(),
				((Boolean)arguments[71]).booleanValue(),
				(java.lang.String)arguments[72],
				(java.lang.String)arguments[73],
				((Boolean)arguments[74]).booleanValue(),
				((Boolean)arguments[75]).booleanValue(),
				(java.lang.String)arguments[76],
				(java.lang.String)arguments[77],
				((Long)arguments[78]).longValue(),
				((Long)arguments[79]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[80]);
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return D2CollectionLocalServiceUtil.updateD2Collection((at.meduni.liferay.portlet.bbmrieric.model.D2Collection)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return D2CollectionLocalServiceUtil.updateD2Collection(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6], (java.lang.String)arguments[7],
				(java.lang.String)arguments[8], (java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				((Boolean)arguments[11]).booleanValue(),
				((Boolean)arguments[12]).booleanValue(),
				((Boolean)arguments[13]).booleanValue(),
				((Boolean)arguments[14]).booleanValue(),
				((Boolean)arguments[15]).booleanValue(),
				((Boolean)arguments[16]).booleanValue(),
				((Boolean)arguments[17]).booleanValue(),
				((Boolean)arguments[18]).booleanValue(),
				((Boolean)arguments[19]).booleanValue(),
				((Boolean)arguments[20]).booleanValue(),
				((Boolean)arguments[21]).booleanValue(),
				((Boolean)arguments[22]).booleanValue(),
				(java.lang.String)arguments[23],
				((Boolean)arguments[24]).booleanValue(),
				((Boolean)arguments[25]).booleanValue(),
				((Boolean)arguments[26]).booleanValue(),
				((Boolean)arguments[27]).booleanValue(),
				((Boolean)arguments[28]).booleanValue(),
				((Boolean)arguments[29]).booleanValue(),
				((Boolean)arguments[30]).booleanValue(),
				((Boolean)arguments[31]).booleanValue(),
				((Boolean)arguments[32]).booleanValue(),
				(java.lang.String)arguments[33],
				((Long)arguments[34]).longValue(),
				(java.lang.String)arguments[35],
				(java.lang.String)arguments[36],
				((Long)arguments[37]).longValue(),
				(java.lang.String)arguments[38],
				(java.lang.String)arguments[39],
				(java.lang.String)arguments[40],
				((Boolean)arguments[41]).booleanValue(),
				((Boolean)arguments[42]).booleanValue(),
				(java.lang.String)arguments[43],
				(java.lang.String)arguments[44],
				((Boolean)arguments[45]).booleanValue(),
				((Boolean)arguments[46]).booleanValue(),
				((Boolean)arguments[47]).booleanValue(),
				((Boolean)arguments[48]).booleanValue(),
				((Long)arguments[49]).longValue(),
				((Long)arguments[50]).longValue(),
				(java.lang.String)arguments[51],
				((Boolean)arguments[52]).booleanValue(),
				((Boolean)arguments[53]).booleanValue(),
				((Boolean)arguments[54]).booleanValue(),
				((Boolean)arguments[55]).booleanValue(),
				((Boolean)arguments[56]).booleanValue(),
				((Boolean)arguments[57]).booleanValue(),
				((Boolean)arguments[58]).booleanValue(),
				(java.lang.String)arguments[59],
				((Boolean)arguments[60]).booleanValue(),
				((Boolean)arguments[61]).booleanValue(),
				((Boolean)arguments[62]).booleanValue(),
				((Boolean)arguments[63]).booleanValue(),
				((Boolean)arguments[64]).booleanValue(),
				(java.lang.String)arguments[65],
				(java.lang.String)arguments[66],
				(java.lang.String)arguments[67],
				(java.lang.String)arguments[68],
				(java.lang.String)arguments[69],
				((Boolean)arguments[70]).booleanValue(),
				((Boolean)arguments[71]).booleanValue(),
				(java.lang.String)arguments[72],
				(java.lang.String)arguments[73],
				((Boolean)arguments[74]).booleanValue(),
				((Boolean)arguments[75]).booleanValue(),
				(java.lang.String)arguments[76],
				(java.lang.String)arguments[77],
				((Long)arguments[78]).longValue(),
				((Long)arguments[79]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[80]);
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return D2CollectionLocalServiceUtil.getD2CollectionByBBMRIERICID(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return D2CollectionLocalServiceUtil.getD2CollectionByBiobankId(((Long)arguments[0]).longValue());
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return D2CollectionLocalServiceUtil.getRootD2Collection(((Long)arguments[0]).longValue());
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return D2CollectionLocalServiceUtil.getChildD2Collection(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return D2CollectionLocalServiceUtil.getD2CollectionByBiobankIdCount(((Long)arguments[0]).longValue());
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return D2CollectionLocalServiceUtil.getD2CollectionFromLDAP((at.meduni.liferay.portlet.bbmrieric.model.D2Collection)arguments[0],
				(javax.naming.directory.Attributes)arguments[1]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return D2CollectionLocalServiceUtil.getLDAPNotUpdatedCollection(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
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
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
}