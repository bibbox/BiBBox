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

package at.graz.meduni.liferay.portlet.bibbox.service.model;

import at.graz.meduni.liferay.portlet.bibbox.service.service.ClpSerializer;
import at.graz.meduni.liferay.portlet.bibbox.service.service.ImporterConfigLocalServiceUtil;

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
public class ImporterConfigClp extends BaseModelImpl<ImporterConfig>
	implements ImporterConfig {
	public ImporterConfigClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ImporterConfig.class;
	}

	@Override
	public String getModelClassName() {
		return ImporterConfig.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _importerconfigId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setImporterconfigId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _importerconfigId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("importerconfigId", getImporterconfigId());
		attributes.put("scope", getScope());
		attributes.put("elementId", getElementId());
		attributes.put("elementvalue", getElementvalue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long importerconfigId = (Long)attributes.get("importerconfigId");

		if (importerconfigId != null) {
			setImporterconfigId(importerconfigId);
		}

		String scope = (String)attributes.get("scope");

		if (scope != null) {
			setScope(scope);
		}

		String elementId = (String)attributes.get("elementId");

		if (elementId != null) {
			setElementId(elementId);
		}

		String elementvalue = (String)attributes.get("elementvalue");

		if (elementvalue != null) {
			setElementvalue(elementvalue);
		}
	}

	@Override
	public long getImporterconfigId() {
		return _importerconfigId;
	}

	@Override
	public void setImporterconfigId(long importerconfigId) {
		_importerconfigId = importerconfigId;

		if (_importerConfigRemoteModel != null) {
			try {
				Class<?> clazz = _importerConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setImporterconfigId",
						long.class);

				method.invoke(_importerConfigRemoteModel, importerconfigId);
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

		if (_importerConfigRemoteModel != null) {
			try {
				Class<?> clazz = _importerConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setScope", String.class);

				method.invoke(_importerConfigRemoteModel, scope);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getElementId() {
		return _elementId;
	}

	@Override
	public void setElementId(String elementId) {
		_elementId = elementId;

		if (_importerConfigRemoteModel != null) {
			try {
				Class<?> clazz = _importerConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setElementId", String.class);

				method.invoke(_importerConfigRemoteModel, elementId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getElementvalue() {
		return _elementvalue;
	}

	@Override
	public void setElementvalue(String elementvalue) {
		_elementvalue = elementvalue;

		if (_importerConfigRemoteModel != null) {
			try {
				Class<?> clazz = _importerConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setElementvalue", String.class);

				method.invoke(_importerConfigRemoteModel, elementvalue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getImporterConfigRemoteModel() {
		return _importerConfigRemoteModel;
	}

	public void setImporterConfigRemoteModel(
		BaseModel<?> importerConfigRemoteModel) {
		_importerConfigRemoteModel = importerConfigRemoteModel;
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

		Class<?> remoteModelClass = _importerConfigRemoteModel.getClass();

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

		Object returnValue = method.invoke(_importerConfigRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ImporterConfigLocalServiceUtil.addImporterConfig(this);
		}
		else {
			ImporterConfigLocalServiceUtil.updateImporterConfig(this);
		}
	}

	@Override
	public ImporterConfig toEscapedModel() {
		return (ImporterConfig)ProxyUtil.newProxyInstance(ImporterConfig.class.getClassLoader(),
			new Class[] { ImporterConfig.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ImporterConfigClp clone = new ImporterConfigClp();

		clone.setImporterconfigId(getImporterconfigId());
		clone.setScope(getScope());
		clone.setElementId(getElementId());
		clone.setElementvalue(getElementvalue());

		return clone;
	}

	@Override
	public int compareTo(ImporterConfig importerConfig) {
		long primaryKey = importerConfig.getPrimaryKey();

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

		if (!(obj instanceof ImporterConfigClp)) {
			return false;
		}

		ImporterConfigClp importerConfig = (ImporterConfigClp)obj;

		long primaryKey = importerConfig.getPrimaryKey();

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

		sb.append("{importerconfigId=");
		sb.append(getImporterconfigId());
		sb.append(", scope=");
		sb.append(getScope());
		sb.append(", elementId=");
		sb.append(getElementId());
		sb.append(", elementvalue=");
		sb.append(getElementvalue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>importerconfigId</column-name><column-value><![CDATA[");
		sb.append(getImporterconfigId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scope</column-name><column-value><![CDATA[");
		sb.append(getScope());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>elementId</column-name><column-value><![CDATA[");
		sb.append(getElementId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>elementvalue</column-name><column-value><![CDATA[");
		sb.append(getElementvalue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _importerconfigId;
	private String _scope;
	private String _elementId;
	private String _elementvalue;
	private BaseModel<?> _importerConfigRemoteModel;
}