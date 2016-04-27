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

package at.graz.meduni.liferay.model;

import at.graz.meduni.liferay.service.ClpSerializer;
import at.graz.meduni.liferay.service.ICD10LocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author reihsr
 */
public class ICD10Clp extends BaseModelImpl<ICD10> implements ICD10 {
	public ICD10Clp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ICD10.class;
	}

	@Override
	public String getModelClassName() {
		return ICD10.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("code", getCode());
		attributes.put("description", getDescription());
		attributes.put("INKLUSIVA", getINKLUSIVA());
		attributes.put("EXKLUSIVA", getEXKLUSIVA());
		attributes.put("TYPE", getTYPE());
		attributes.put("USED", getUSED());
		attributes.put("FROM_CODE", getFROM_CODE());
		attributes.put("TO_CODE", getTO_CODE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String INKLUSIVA = (String)attributes.get("INKLUSIVA");

		if (INKLUSIVA != null) {
			setINKLUSIVA(INKLUSIVA);
		}

		String EXKLUSIVA = (String)attributes.get("EXKLUSIVA");

		if (EXKLUSIVA != null) {
			setEXKLUSIVA(EXKLUSIVA);
		}

		String TYPE = (String)attributes.get("TYPE");

		if (TYPE != null) {
			setTYPE(TYPE);
		}

		Double USED = (Double)attributes.get("USED");

		if (USED != null) {
			setUSED(USED);
		}

		String FROM_CODE = (String)attributes.get("FROM_CODE");

		if (FROM_CODE != null) {
			setFROM_CODE(FROM_CODE);
		}

		String TO_CODE = (String)attributes.get("TO_CODE");

		if (TO_CODE != null) {
			setTO_CODE(TO_CODE);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_icd10RemoteModel != null) {
			try {
				Class<?> clazz = _icd10RemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_icd10RemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCode() {
		return _code;
	}

	@Override
	public void setCode(String code) {
		_code = code;

		if (_icd10RemoteModel != null) {
			try {
				Class<?> clazz = _icd10RemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_icd10RemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_icd10RemoteModel != null) {
			try {
				Class<?> clazz = _icd10RemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_icd10RemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getINKLUSIVA() {
		return _INKLUSIVA;
	}

	@Override
	public void setINKLUSIVA(String INKLUSIVA) {
		_INKLUSIVA = INKLUSIVA;

		if (_icd10RemoteModel != null) {
			try {
				Class<?> clazz = _icd10RemoteModel.getClass();

				Method method = clazz.getMethod("setINKLUSIVA", String.class);

				method.invoke(_icd10RemoteModel, INKLUSIVA);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEXKLUSIVA() {
		return _EXKLUSIVA;
	}

	@Override
	public void setEXKLUSIVA(String EXKLUSIVA) {
		_EXKLUSIVA = EXKLUSIVA;

		if (_icd10RemoteModel != null) {
			try {
				Class<?> clazz = _icd10RemoteModel.getClass();

				Method method = clazz.getMethod("setEXKLUSIVA", String.class);

				method.invoke(_icd10RemoteModel, EXKLUSIVA);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTYPE() {
		return _TYPE;
	}

	@Override
	public void setTYPE(String TYPE) {
		_TYPE = TYPE;

		if (_icd10RemoteModel != null) {
			try {
				Class<?> clazz = _icd10RemoteModel.getClass();

				Method method = clazz.getMethod("setTYPE", String.class);

				method.invoke(_icd10RemoteModel, TYPE);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getUSED() {
		return _USED;
	}

	@Override
	public void setUSED(double USED) {
		_USED = USED;

		if (_icd10RemoteModel != null) {
			try {
				Class<?> clazz = _icd10RemoteModel.getClass();

				Method method = clazz.getMethod("setUSED", double.class);

				method.invoke(_icd10RemoteModel, USED);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFROM_CODE() {
		return _FROM_CODE;
	}

	@Override
	public void setFROM_CODE(String FROM_CODE) {
		_FROM_CODE = FROM_CODE;

		if (_icd10RemoteModel != null) {
			try {
				Class<?> clazz = _icd10RemoteModel.getClass();

				Method method = clazz.getMethod("setFROM_CODE", String.class);

				method.invoke(_icd10RemoteModel, FROM_CODE);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTO_CODE() {
		return _TO_CODE;
	}

	@Override
	public void setTO_CODE(String TO_CODE) {
		_TO_CODE = TO_CODE;

		if (_icd10RemoteModel != null) {
			try {
				Class<?> clazz = _icd10RemoteModel.getClass();

				Method method = clazz.getMethod("setTO_CODE", String.class);

				method.invoke(_icd10RemoteModel, TO_CODE);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getICD10RemoteModel() {
		return _icd10RemoteModel;
	}

	public void setICD10RemoteModel(BaseModel<?> icd10RemoteModel) {
		_icd10RemoteModel = icd10RemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _icd10RemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_icd10RemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ICD10LocalServiceUtil.addICD10(this);
		}
		else {
			ICD10LocalServiceUtil.updateICD10(this);
		}
	}

	@Override
	public ICD10 toEscapedModel() {
		return (ICD10)ProxyUtil.newProxyInstance(ICD10.class.getClassLoader(),
			new Class[] { ICD10.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ICD10Clp clone = new ICD10Clp();

		clone.setId(getId());
		clone.setCode(getCode());
		clone.setDescription(getDescription());
		clone.setINKLUSIVA(getINKLUSIVA());
		clone.setEXKLUSIVA(getEXKLUSIVA());
		clone.setTYPE(getTYPE());
		clone.setUSED(getUSED());
		clone.setFROM_CODE(getFROM_CODE());
		clone.setTO_CODE(getTO_CODE());

		return clone;
	}

	@Override
	public int compareTo(ICD10 icd10) {
		int value = 0;

		if (getId() < icd10.getId()) {
			value = -1;
		}
		else if (getId() > icd10.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ICD10Clp)) {
			return false;
		}

		ICD10Clp icd10 = (ICD10Clp)obj;

		long primaryKey = icd10.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", INKLUSIVA=");
		sb.append(getINKLUSIVA());
		sb.append(", EXKLUSIVA=");
		sb.append(getEXKLUSIVA());
		sb.append(", TYPE=");
		sb.append(getTYPE());
		sb.append(", USED=");
		sb.append(getUSED());
		sb.append(", FROM_CODE=");
		sb.append(getFROM_CODE());
		sb.append(", TO_CODE=");
		sb.append(getTO_CODE());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.liferay.model.ICD10");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>INKLUSIVA</column-name><column-value><![CDATA[");
		sb.append(getINKLUSIVA());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>EXKLUSIVA</column-name><column-value><![CDATA[");
		sb.append(getEXKLUSIVA());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TYPE</column-name><column-value><![CDATA[");
		sb.append(getTYPE());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>USED</column-name><column-value><![CDATA[");
		sb.append(getUSED());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>FROM_CODE</column-name><column-value><![CDATA[");
		sb.append(getFROM_CODE());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TO_CODE</column-name><column-value><![CDATA[");
		sb.append(getTO_CODE());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _code;
	private String _description;
	private String _INKLUSIVA;
	private String _EXKLUSIVA;
	private String _TYPE;
	private double _USED;
	private String _FROM_CODE;
	private String _TO_CODE;
	private BaseModel<?> _icd10RemoteModel;
	private Class<?> _clpSerializerClass = at.graz.meduni.liferay.service.ClpSerializer.class;
}