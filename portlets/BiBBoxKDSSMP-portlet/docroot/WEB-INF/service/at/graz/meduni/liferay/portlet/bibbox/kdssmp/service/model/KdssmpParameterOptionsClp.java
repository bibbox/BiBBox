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
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpParameterOptionsLocalServiceUtil;

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
public class KdssmpParameterOptionsClp extends BaseModelImpl<KdssmpParameterOptions>
	implements KdssmpParameterOptions {
	public KdssmpParameterOptionsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return KdssmpParameterOptions.class;
	}

	@Override
	public String getModelClassName() {
		return KdssmpParameterOptions.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _parameteroptionsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setParameteroptionsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _parameteroptionsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("parameteroptionsId", getParameteroptionsId());
		attributes.put("parameterconfigurationId", getParameterconfigurationId());
		attributes.put("option", getOption());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long parameteroptionsId = (Long)attributes.get("parameteroptionsId");

		if (parameteroptionsId != null) {
			setParameteroptionsId(parameteroptionsId);
		}

		Long parameterconfigurationId = (Long)attributes.get(
				"parameterconfigurationId");

		if (parameterconfigurationId != null) {
			setParameterconfigurationId(parameterconfigurationId);
		}

		String option = (String)attributes.get("option");

		if (option != null) {
			setOption(option);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public long getParameteroptionsId() {
		return _parameteroptionsId;
	}

	@Override
	public void setParameteroptionsId(long parameteroptionsId) {
		_parameteroptionsId = parameteroptionsId;

		if (_kdssmpParameterOptionsRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpParameterOptionsRemoteModel.getClass();

				Method method = clazz.getMethod("setParameteroptionsId",
						long.class);

				method.invoke(_kdssmpParameterOptionsRemoteModel,
					parameteroptionsId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParameterconfigurationId() {
		return _parameterconfigurationId;
	}

	@Override
	public void setParameterconfigurationId(long parameterconfigurationId) {
		_parameterconfigurationId = parameterconfigurationId;

		if (_kdssmpParameterOptionsRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpParameterOptionsRemoteModel.getClass();

				Method method = clazz.getMethod("setParameterconfigurationId",
						long.class);

				method.invoke(_kdssmpParameterOptionsRemoteModel,
					parameterconfigurationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOption() {
		return _option;
	}

	@Override
	public void setOption(String option) {
		_option = option;

		if (_kdssmpParameterOptionsRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpParameterOptionsRemoteModel.getClass();

				Method method = clazz.getMethod("setOption", String.class);

				method.invoke(_kdssmpParameterOptionsRemoteModel, option);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getValue() {
		return _value;
	}

	@Override
	public void setValue(String value) {
		_value = value;

		if (_kdssmpParameterOptionsRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpParameterOptionsRemoteModel.getClass();

				Method method = clazz.getMethod("setValue", String.class);

				method.invoke(_kdssmpParameterOptionsRemoteModel, value);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getKdssmpParameterOptionsRemoteModel() {
		return _kdssmpParameterOptionsRemoteModel;
	}

	public void setKdssmpParameterOptionsRemoteModel(
		BaseModel<?> kdssmpParameterOptionsRemoteModel) {
		_kdssmpParameterOptionsRemoteModel = kdssmpParameterOptionsRemoteModel;
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

		Class<?> remoteModelClass = _kdssmpParameterOptionsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_kdssmpParameterOptionsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			KdssmpParameterOptionsLocalServiceUtil.addKdssmpParameterOptions(this);
		}
		else {
			KdssmpParameterOptionsLocalServiceUtil.updateKdssmpParameterOptions(this);
		}
	}

	@Override
	public KdssmpParameterOptions toEscapedModel() {
		return (KdssmpParameterOptions)ProxyUtil.newProxyInstance(KdssmpParameterOptions.class.getClassLoader(),
			new Class[] { KdssmpParameterOptions.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		KdssmpParameterOptionsClp clone = new KdssmpParameterOptionsClp();

		clone.setParameteroptionsId(getParameteroptionsId());
		clone.setParameterconfigurationId(getParameterconfigurationId());
		clone.setOption(getOption());
		clone.setValue(getValue());

		return clone;
	}

	@Override
	public int compareTo(KdssmpParameterOptions kdssmpParameterOptions) {
		long primaryKey = kdssmpParameterOptions.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KdssmpParameterOptionsClp)) {
			return false;
		}

		KdssmpParameterOptionsClp kdssmpParameterOptions = (KdssmpParameterOptionsClp)obj;

		long primaryKey = kdssmpParameterOptions.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{parameteroptionsId=");
		sb.append(getParameteroptionsId());
		sb.append(", parameterconfigurationId=");
		sb.append(getParameterconfigurationId());
		sb.append(", option=");
		sb.append(getOption());
		sb.append(", value=");
		sb.append(getValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>parameteroptionsId</column-name><column-value><![CDATA[");
		sb.append(getParameteroptionsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parameterconfigurationId</column-name><column-value><![CDATA[");
		sb.append(getParameterconfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>option</column-name><column-value><![CDATA[");
		sb.append(getOption());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _parameteroptionsId;
	private long _parameterconfigurationId;
	private String _option;
	private String _value;
	private BaseModel<?> _kdssmpParameterOptionsRemoteModel;
}