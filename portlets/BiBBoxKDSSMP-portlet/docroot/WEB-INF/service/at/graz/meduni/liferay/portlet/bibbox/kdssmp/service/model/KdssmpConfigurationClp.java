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
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpConfigurationLocalServiceUtil;

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
public class KdssmpConfigurationClp extends BaseModelImpl<KdssmpConfiguration>
	implements KdssmpConfiguration {
	public KdssmpConfigurationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return KdssmpConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return KdssmpConfiguration.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _configurationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setConfigurationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _configurationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("configurationId", getConfigurationId());
		attributes.put("scope", getScope());
		attributes.put("optionkey", getOptionkey());
		attributes.put("optionvalue", getOptionvalue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long configurationId = (Long)attributes.get("configurationId");

		if (configurationId != null) {
			setConfigurationId(configurationId);
		}

		String scope = (String)attributes.get("scope");

		if (scope != null) {
			setScope(scope);
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
	public long getConfigurationId() {
		return _configurationId;
	}

	@Override
	public void setConfigurationId(long configurationId) {
		_configurationId = configurationId;

		if (_kdssmpConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setConfigurationId", long.class);

				method.invoke(_kdssmpConfigurationRemoteModel, configurationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getScope() {
		return _scope;
	}

	@Override
	public void setScope(String scope) {
		_scope = scope;

		if (_kdssmpConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setScope", String.class);

				method.invoke(_kdssmpConfigurationRemoteModel, scope);
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

		if (_kdssmpConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setOptionkey", String.class);

				method.invoke(_kdssmpConfigurationRemoteModel, optionkey);
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

		if (_kdssmpConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setOptionvalue", String.class);

				method.invoke(_kdssmpConfigurationRemoteModel, optionvalue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getKdssmpConfigurationRemoteModel() {
		return _kdssmpConfigurationRemoteModel;
	}

	public void setKdssmpConfigurationRemoteModel(
		BaseModel<?> kdssmpConfigurationRemoteModel) {
		_kdssmpConfigurationRemoteModel = kdssmpConfigurationRemoteModel;
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

		Class<?> remoteModelClass = _kdssmpConfigurationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_kdssmpConfigurationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			KdssmpConfigurationLocalServiceUtil.addKdssmpConfiguration(this);
		}
		else {
			KdssmpConfigurationLocalServiceUtil.updateKdssmpConfiguration(this);
		}
	}

	@Override
	public KdssmpConfiguration toEscapedModel() {
		return (KdssmpConfiguration)ProxyUtil.newProxyInstance(KdssmpConfiguration.class.getClassLoader(),
			new Class[] { KdssmpConfiguration.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		KdssmpConfigurationClp clone = new KdssmpConfigurationClp();

		clone.setConfigurationId(getConfigurationId());
		clone.setScope(getScope());
		clone.setOptionkey(getOptionkey());
		clone.setOptionvalue(getOptionvalue());

		return clone;
	}

	@Override
	public int compareTo(KdssmpConfiguration kdssmpConfiguration) {
		int value = 0;

		if (getConfigurationId() < kdssmpConfiguration.getConfigurationId()) {
			value = -1;
		}
		else if (getConfigurationId() > kdssmpConfiguration.getConfigurationId()) {
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

		if (!(obj instanceof KdssmpConfigurationClp)) {
			return false;
		}

		KdssmpConfigurationClp kdssmpConfiguration = (KdssmpConfigurationClp)obj;

		long primaryKey = kdssmpConfiguration.getPrimaryKey();

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

		sb.append("{configurationId=");
		sb.append(getConfigurationId());
		sb.append(", scope=");
		sb.append(getScope());
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
			"at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>configurationId</column-name><column-value><![CDATA[");
		sb.append(getConfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scope</column-name><column-value><![CDATA[");
		sb.append(getScope());
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

	private long _configurationId;
	private String _scope;
	private String _optionkey;
	private String _optionvalue;
	private BaseModel<?> _kdssmpConfigurationRemoteModel;
}