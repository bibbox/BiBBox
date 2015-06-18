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

package at.graz.meduni.liferay.portlet.bibbox.model;

import at.graz.meduni.liferay.portlet.bibbox.service.ClpSerializer;
import at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationLocalServiceUtil;

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
public class SymbolConfigurationClp extends BaseModelImpl<SymbolConfiguration>
	implements SymbolConfiguration {
	public SymbolConfigurationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SymbolConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return SymbolConfiguration.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _symbolconfigurationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSymbolconfigurationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _symbolconfigurationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("symbolconfigurationId", getSymbolconfigurationId());
		attributes.put("scope", getScope());
		attributes.put("eventtype", getEventtype());
		attributes.put("basecolor", getBasecolor());
		attributes.put("symboltype", getSymboltype());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long symbolconfigurationId = (Long)attributes.get(
				"symbolconfigurationId");

		if (symbolconfigurationId != null) {
			setSymbolconfigurationId(symbolconfigurationId);
		}

		String scope = (String)attributes.get("scope");

		if (scope != null) {
			setScope(scope);
		}

		String eventtype = (String)attributes.get("eventtype");

		if (eventtype != null) {
			setEventtype(eventtype);
		}

		String basecolor = (String)attributes.get("basecolor");

		if (basecolor != null) {
			setBasecolor(basecolor);
		}

		String symboltype = (String)attributes.get("symboltype");

		if (symboltype != null) {
			setSymboltype(symboltype);
		}
	}

	@Override
	public long getSymbolconfigurationId() {
		return _symbolconfigurationId;
	}

	@Override
	public void setSymbolconfigurationId(long symbolconfigurationId) {
		_symbolconfigurationId = symbolconfigurationId;

		if (_symbolConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _symbolConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setSymbolconfigurationId",
						long.class);

				method.invoke(_symbolConfigurationRemoteModel,
					symbolconfigurationId);
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

		if (_symbolConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _symbolConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setScope", String.class);

				method.invoke(_symbolConfigurationRemoteModel, scope);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventtype() {
		return _eventtype;
	}

	@Override
	public void setEventtype(String eventtype) {
		_eventtype = eventtype;

		if (_symbolConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _symbolConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setEventtype", String.class);

				method.invoke(_symbolConfigurationRemoteModel, eventtype);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBasecolor() {
		return _basecolor;
	}

	@Override
	public void setBasecolor(String basecolor) {
		_basecolor = basecolor;

		if (_symbolConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _symbolConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setBasecolor", String.class);

				method.invoke(_symbolConfigurationRemoteModel, basecolor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSymboltype() {
		return _symboltype;
	}

	@Override
	public void setSymboltype(String symboltype) {
		_symboltype = symboltype;

		if (_symbolConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _symbolConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setSymboltype", String.class);

				method.invoke(_symbolConfigurationRemoteModel, symboltype);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getTemplate() {
		try {
			String methodName = "getTemplate";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getSymbolConfigurationRemoteModel() {
		return _symbolConfigurationRemoteModel;
	}

	public void setSymbolConfigurationRemoteModel(
		BaseModel<?> symbolConfigurationRemoteModel) {
		_symbolConfigurationRemoteModel = symbolConfigurationRemoteModel;
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

		Class<?> remoteModelClass = _symbolConfigurationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_symbolConfigurationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SymbolConfigurationLocalServiceUtil.addSymbolConfiguration(this);
		}
		else {
			SymbolConfigurationLocalServiceUtil.updateSymbolConfiguration(this);
		}
	}

	@Override
	public SymbolConfiguration toEscapedModel() {
		return (SymbolConfiguration)ProxyUtil.newProxyInstance(SymbolConfiguration.class.getClassLoader(),
			new Class[] { SymbolConfiguration.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SymbolConfigurationClp clone = new SymbolConfigurationClp();

		clone.setSymbolconfigurationId(getSymbolconfigurationId());
		clone.setScope(getScope());
		clone.setEventtype(getEventtype());
		clone.setBasecolor(getBasecolor());
		clone.setSymboltype(getSymboltype());

		return clone;
	}

	@Override
	public int compareTo(SymbolConfiguration symbolConfiguration) {
		long primaryKey = symbolConfiguration.getPrimaryKey();

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

		if (!(obj instanceof SymbolConfigurationClp)) {
			return false;
		}

		SymbolConfigurationClp symbolConfiguration = (SymbolConfigurationClp)obj;

		long primaryKey = symbolConfiguration.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{symbolconfigurationId=");
		sb.append(getSymbolconfigurationId());
		sb.append(", scope=");
		sb.append(getScope());
		sb.append(", eventtype=");
		sb.append(getEventtype());
		sb.append(", basecolor=");
		sb.append(getBasecolor());
		sb.append(", symboltype=");
		sb.append(getSymboltype());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfiguration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>symbolconfigurationId</column-name><column-value><![CDATA[");
		sb.append(getSymbolconfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scope</column-name><column-value><![CDATA[");
		sb.append(getScope());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventtype</column-name><column-value><![CDATA[");
		sb.append(getEventtype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>basecolor</column-name><column-value><![CDATA[");
		sb.append(getBasecolor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>symboltype</column-name><column-value><![CDATA[");
		sb.append(getSymboltype());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _symbolconfigurationId;
	private String _scope;
	private String _eventtype;
	private String _basecolor;
	private String _symboltype;
	private BaseModel<?> _symbolConfigurationRemoteModel;
}