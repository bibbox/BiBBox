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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.ClpSerializer;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.patientnamegeneratorLocalServiceUtil;

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
public class patientnamegeneratorClp extends BaseModelImpl<patientnamegenerator>
	implements patientnamegenerator {
	public patientnamegeneratorClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return patientnamegenerator.class;
	}

	@Override
	public String getModelClassName() {
		return patientnamegenerator.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _patientnamegeneratorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPatientnamegeneratorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _patientnamegeneratorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("patientnamegeneratorId", getPatientnamegeneratorId());
		attributes.put("name", getName());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long patientnamegeneratorId = (Long)attributes.get(
				"patientnamegeneratorId");

		if (patientnamegeneratorId != null) {
			setPatientnamegeneratorId(patientnamegeneratorId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	@Override
	public long getPatientnamegeneratorId() {
		return _patientnamegeneratorId;
	}

	@Override
	public void setPatientnamegeneratorId(long patientnamegeneratorId) {
		_patientnamegeneratorId = patientnamegeneratorId;

		if (_patientnamegeneratorRemoteModel != null) {
			try {
				Class<?> clazz = _patientnamegeneratorRemoteModel.getClass();

				Method method = clazz.getMethod("setPatientnamegeneratorId",
						long.class);

				method.invoke(_patientnamegeneratorRemoteModel,
					patientnamegeneratorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_patientnamegeneratorRemoteModel != null) {
			try {
				Class<?> clazz = _patientnamegeneratorRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_patientnamegeneratorRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_patientnamegeneratorRemoteModel != null) {
			try {
				Class<?> clazz = _patientnamegeneratorRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_patientnamegeneratorRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getpatientnamegeneratorRemoteModel() {
		return _patientnamegeneratorRemoteModel;
	}

	public void setpatientnamegeneratorRemoteModel(
		BaseModel<?> patientnamegeneratorRemoteModel) {
		_patientnamegeneratorRemoteModel = patientnamegeneratorRemoteModel;
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

		Class<?> remoteModelClass = _patientnamegeneratorRemoteModel.getClass();

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

		Object returnValue = method.invoke(_patientnamegeneratorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			patientnamegeneratorLocalServiceUtil.addpatientnamegenerator(this);
		}
		else {
			patientnamegeneratorLocalServiceUtil.updatepatientnamegenerator(this);
		}
	}

	@Override
	public patientnamegenerator toEscapedModel() {
		return (patientnamegenerator)ProxyUtil.newProxyInstance(patientnamegenerator.class.getClassLoader(),
			new Class[] { patientnamegenerator.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		patientnamegeneratorClp clone = new patientnamegeneratorClp();

		clone.setPatientnamegeneratorId(getPatientnamegeneratorId());
		clone.setName(getName());
		clone.setType(getType());

		return clone;
	}

	@Override
	public int compareTo(patientnamegenerator patientnamegenerator) {
		int value = 0;

		value = getName().compareTo(patientnamegenerator.getName());

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

		if (!(obj instanceof patientnamegeneratorClp)) {
			return false;
		}

		patientnamegeneratorClp patientnamegenerator = (patientnamegeneratorClp)obj;

		long primaryKey = patientnamegenerator.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{patientnamegeneratorId=");
		sb.append(getPatientnamegeneratorId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", type=");
		sb.append(getType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>patientnamegeneratorId</column-name><column-value><![CDATA[");
		sb.append(getPatientnamegeneratorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _patientnamegeneratorId;
	private String _name;
	private String _type;
	private BaseModel<?> _patientnamegeneratorRemoteModel;
}