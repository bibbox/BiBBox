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
import at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalServiceUtil;

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
public class SymbolTypeConfigurationClp extends BaseModelImpl<SymbolTypeConfiguration>
	implements SymbolTypeConfiguration {
	public SymbolTypeConfigurationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SymbolTypeConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return SymbolTypeConfiguration.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _symboltypeconfigurationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSymboltypeconfigurationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _symboltypeconfigurationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("symboltypeconfigurationId",
			getSymboltypeconfigurationId());
		attributes.put("symboltype", getSymboltype());
		attributes.put("template", getTemplate());
		attributes.put("symboliconconfiguration", getSymboliconconfiguration());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long symboltypeconfigurationId = (Long)attributes.get(
				"symboltypeconfigurationId");

		if (symboltypeconfigurationId != null) {
			setSymboltypeconfigurationId(symboltypeconfigurationId);
		}

		String symboltype = (String)attributes.get("symboltype");

		if (symboltype != null) {
			setSymboltype(symboltype);
		}

		String template = (String)attributes.get("template");

		if (template != null) {
			setTemplate(template);
		}

		String symboliconconfiguration = (String)attributes.get(
				"symboliconconfiguration");

		if (symboliconconfiguration != null) {
			setSymboliconconfiguration(symboliconconfiguration);
		}
	}

	@Override
	public long getSymboltypeconfigurationId() {
		return _symboltypeconfigurationId;
	}

	@Override
	public void setSymboltypeconfigurationId(long symboltypeconfigurationId) {
		_symboltypeconfigurationId = symboltypeconfigurationId;

		if (_symbolTypeConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _symbolTypeConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setSymboltypeconfigurationId",
						long.class);

				method.invoke(_symbolTypeConfigurationRemoteModel,
					symboltypeconfigurationId);
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

		if (_symbolTypeConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _symbolTypeConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setSymboltype", String.class);

				method.invoke(_symbolTypeConfigurationRemoteModel, symboltype);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTemplate() {
		return _template;
	}

	@Override
	public void setTemplate(String template) {
		_template = template;

		if (_symbolTypeConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _symbolTypeConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplate", String.class);

				method.invoke(_symbolTypeConfigurationRemoteModel, template);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSymboliconconfiguration() {
		return _symboliconconfiguration;
	}

	@Override
	public void setSymboliconconfiguration(String symboliconconfiguration) {
		_symboliconconfiguration = symboliconconfiguration;

		if (_symbolTypeConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _symbolTypeConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setSymboliconconfiguration",
						String.class);

				method.invoke(_symbolTypeConfigurationRemoteModel,
					symboliconconfiguration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSymbolTypeConfigurationRemoteModel() {
		return _symbolTypeConfigurationRemoteModel;
	}

	public void setSymbolTypeConfigurationRemoteModel(
		BaseModel<?> symbolTypeConfigurationRemoteModel) {
		_symbolTypeConfigurationRemoteModel = symbolTypeConfigurationRemoteModel;
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

		Class<?> remoteModelClass = _symbolTypeConfigurationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_symbolTypeConfigurationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SymbolTypeConfigurationLocalServiceUtil.addSymbolTypeConfiguration(this);
		}
		else {
			SymbolTypeConfigurationLocalServiceUtil.updateSymbolTypeConfiguration(this);
		}
	}

	@Override
	public SymbolTypeConfiguration toEscapedModel() {
		return (SymbolTypeConfiguration)ProxyUtil.newProxyInstance(SymbolTypeConfiguration.class.getClassLoader(),
			new Class[] { SymbolTypeConfiguration.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SymbolTypeConfigurationClp clone = new SymbolTypeConfigurationClp();

		clone.setSymboltypeconfigurationId(getSymboltypeconfigurationId());
		clone.setSymboltype(getSymboltype());
		clone.setTemplate(getTemplate());
		clone.setSymboliconconfiguration(getSymboliconconfiguration());

		return clone;
	}

	@Override
	public int compareTo(SymbolTypeConfiguration symbolTypeConfiguration) {
		long primaryKey = symbolTypeConfiguration.getPrimaryKey();

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

		if (!(obj instanceof SymbolTypeConfigurationClp)) {
			return false;
		}

		SymbolTypeConfigurationClp symbolTypeConfiguration = (SymbolTypeConfigurationClp)obj;

		long primaryKey = symbolTypeConfiguration.getPrimaryKey();

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

		sb.append("{symboltypeconfigurationId=");
		sb.append(getSymboltypeconfigurationId());
		sb.append(", symboltype=");
		sb.append(getSymboltype());
		sb.append(", template=");
		sb.append(getTemplate());
		sb.append(", symboliconconfiguration=");
		sb.append(getSymboliconconfiguration());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfiguration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>symboltypeconfigurationId</column-name><column-value><![CDATA[");
		sb.append(getSymboltypeconfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>symboltype</column-name><column-value><![CDATA[");
		sb.append(getSymboltype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>template</column-name><column-value><![CDATA[");
		sb.append(getTemplate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>symboliconconfiguration</column-name><column-value><![CDATA[");
		sb.append(getSymboliconconfiguration());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _symboltypeconfigurationId;
	private String _symboltype;
	private String _template;
	private String _symboliconconfiguration;
	private BaseModel<?> _symbolTypeConfigurationRemoteModel;
}