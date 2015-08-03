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

package at.graz.hmmc.liferay.portlet.puch.model;

import at.graz.hmmc.liferay.portlet.puch.service.ClpSerializer;
import at.graz.hmmc.liferay.portlet.puch.service.ParameterOptionsConfigurationLocalServiceUtil;

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
public class ParameterOptionsConfigurationClp extends BaseModelImpl<ParameterOptionsConfiguration>
	implements ParameterOptionsConfiguration {
	public ParameterOptionsConfigurationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ParameterOptionsConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return ParameterOptionsConfiguration.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _parameteroptionsconfigurationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setParameteroptionsconfigurationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _parameteroptionsconfigurationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("parameteroptionsconfigurationId",
			getParameteroptionsconfigurationId());
		attributes.put("parameterconfigurationId", getParameterconfigurationId());
		attributes.put("optionkey", getOptionkey());
		attributes.put("optionvalue", getOptionvalue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long parameteroptionsconfigurationId = (Long)attributes.get(
				"parameteroptionsconfigurationId");

		if (parameteroptionsconfigurationId != null) {
			setParameteroptionsconfigurationId(parameteroptionsconfigurationId);
		}

		Long parameterconfigurationId = (Long)attributes.get(
				"parameterconfigurationId");

		if (parameterconfigurationId != null) {
			setParameterconfigurationId(parameterconfigurationId);
		}

		String optionkey = (String)attributes.get("optionkey");

		if (optionkey != null) {
			setOptionkey(optionkey);
		}

		String optionvalue = (String)attributes.get("optionvalue");

		if (optionvalue != null) {
			setOptionvalue(optionvalue);
		}
	}

	@Override
	public long getParameteroptionsconfigurationId() {
		return _parameteroptionsconfigurationId;
	}

	@Override
	public void setParameteroptionsconfigurationId(
		long parameteroptionsconfigurationId) {
		_parameteroptionsconfigurationId = parameteroptionsconfigurationId;

		if (_parameterOptionsConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterOptionsConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setParameteroptionsconfigurationId",
						long.class);

				method.invoke(_parameterOptionsConfigurationRemoteModel,
					parameteroptionsconfigurationId);
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

		if (_parameterOptionsConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterOptionsConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setParameterconfigurationId",
						long.class);

				method.invoke(_parameterOptionsConfigurationRemoteModel,
					parameterconfigurationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOptionkey() {
		return _optionkey;
	}

	@Override
	public void setOptionkey(String optionkey) {
		_optionkey = optionkey;

		if (_parameterOptionsConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterOptionsConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setOptionkey", String.class);

				method.invoke(_parameterOptionsConfigurationRemoteModel,
					optionkey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOptionvalue() {
		return _optionvalue;
	}

	@Override
	public void setOptionvalue(String optionvalue) {
		_optionvalue = optionvalue;

		if (_parameterOptionsConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _parameterOptionsConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setOptionvalue", String.class);

				method.invoke(_parameterOptionsConfigurationRemoteModel,
					optionvalue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getParameterOptionsConfigurationRemoteModel() {
		return _parameterOptionsConfigurationRemoteModel;
	}

	public void setParameterOptionsConfigurationRemoteModel(
		BaseModel<?> parameterOptionsConfigurationRemoteModel) {
		_parameterOptionsConfigurationRemoteModel = parameterOptionsConfigurationRemoteModel;
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

		Class<?> remoteModelClass = _parameterOptionsConfigurationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_parameterOptionsConfigurationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ParameterOptionsConfigurationLocalServiceUtil.addParameterOptionsConfiguration(this);
		}
		else {
			ParameterOptionsConfigurationLocalServiceUtil.updateParameterOptionsConfiguration(this);
		}
	}

	@Override
	public ParameterOptionsConfiguration toEscapedModel() {
		return (ParameterOptionsConfiguration)ProxyUtil.newProxyInstance(ParameterOptionsConfiguration.class.getClassLoader(),
			new Class[] { ParameterOptionsConfiguration.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ParameterOptionsConfigurationClp clone = new ParameterOptionsConfigurationClp();

		clone.setParameteroptionsconfigurationId(getParameteroptionsconfigurationId());
		clone.setParameterconfigurationId(getParameterconfigurationId());
		clone.setOptionkey(getOptionkey());
		clone.setOptionvalue(getOptionvalue());

		return clone;
	}

	@Override
	public int compareTo(
		ParameterOptionsConfiguration parameterOptionsConfiguration) {
		long primaryKey = parameterOptionsConfiguration.getPrimaryKey();

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

		if (!(obj instanceof ParameterOptionsConfigurationClp)) {
			return false;
		}

		ParameterOptionsConfigurationClp parameterOptionsConfiguration = (ParameterOptionsConfigurationClp)obj;

		long primaryKey = parameterOptionsConfiguration.getPrimaryKey();

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

		sb.append("{parameteroptionsconfigurationId=");
		sb.append(getParameteroptionsconfigurationId());
		sb.append(", parameterconfigurationId=");
		sb.append(getParameterconfigurationId());
		sb.append(", optionkey=");
		sb.append(getOptionkey());
		sb.append(", optionvalue=");
		sb.append(getOptionvalue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>parameteroptionsconfigurationId</column-name><column-value><![CDATA[");
		sb.append(getParameteroptionsconfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parameterconfigurationId</column-name><column-value><![CDATA[");
		sb.append(getParameterconfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>optionkey</column-name><column-value><![CDATA[");
		sb.append(getOptionkey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>optionvalue</column-name><column-value><![CDATA[");
		sb.append(getOptionvalue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _parameteroptionsconfigurationId;
	private long _parameterconfigurationId;
	private String _optionkey;
	private String _optionvalue;
	private BaseModel<?> _parameterOptionsConfigurationRemoteModel;
}