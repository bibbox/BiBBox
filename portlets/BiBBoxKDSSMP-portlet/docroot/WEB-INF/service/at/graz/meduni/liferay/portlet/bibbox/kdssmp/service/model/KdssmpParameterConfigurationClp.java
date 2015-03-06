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
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.KdssmpParameterConfigurationLocalServiceUtil;

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
public class KdssmpParameterConfigurationClp extends BaseModelImpl<KdssmpParameterConfiguration>
	implements KdssmpParameterConfiguration {
	public KdssmpParameterConfigurationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return KdssmpParameterConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return KdssmpParameterConfiguration.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _parameterconfigurationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setParameterconfigurationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _parameterconfigurationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("parameterconfigurationId", getParameterconfigurationId());
		attributes.put("displayname", getDisplayname());
		attributes.put("datatype", getDatatype());
		attributes.put("valuerange", getValuerange());
		attributes.put("displayoptions", getDisplayoptions());
		attributes.put("visible", getVisible());
		attributes.put("computed", getComputed());
		attributes.put("confirmationscript", getConfirmationscript());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long parameterconfigurationId = (Long)attributes.get(
				"parameterconfigurationId");

		if (parameterconfigurationId != null) {
			setParameterconfigurationId(parameterconfigurationId);
		}

		String displayname = (String)attributes.get("displayname");

		if (displayname != null) {
			setDisplayname(displayname);
		}

		String datatype = (String)attributes.get("datatype");

		if (datatype != null) {
			setDatatype(datatype);
		}

		String valuerange = (String)attributes.get("valuerange");

		if (valuerange != null) {
			setValuerange(valuerange);
		}

		String displayoptions = (String)attributes.get("displayoptions");

		if (displayoptions != null) {
			setDisplayoptions(displayoptions);
		}

		String visible = (String)attributes.get("visible");

		if (visible != null) {
			setVisible(visible);
		}

		String computed = (String)attributes.get("computed");

		if (computed != null) {
			setComputed(computed);
		}

		String confirmationscript = (String)attributes.get("confirmationscript");

		if (confirmationscript != null) {
			setConfirmationscript(confirmationscript);
		}
	}

	@Override
	public long getParameterconfigurationId() {
		return _parameterconfigurationId;
	}

	@Override
	public void setParameterconfigurationId(long parameterconfigurationId) {
		_parameterconfigurationId = parameterconfigurationId;

		if (_kdssmpParameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpParameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setParameterconfigurationId",
						long.class);

				method.invoke(_kdssmpParameterConfigurationRemoteModel,
					parameterconfigurationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisplayname() {
		return _displayname;
	}

	@Override
	public void setDisplayname(String displayname) {
		_displayname = displayname;

		if (_kdssmpParameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpParameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayname", String.class);

				method.invoke(_kdssmpParameterConfigurationRemoteModel,
					displayname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDatatype() {
		return _datatype;
	}

	@Override
	public void setDatatype(String datatype) {
		_datatype = datatype;

		if (_kdssmpParameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpParameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setDatatype", String.class);

				method.invoke(_kdssmpParameterConfigurationRemoteModel, datatype);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getValuerange() {
		return _valuerange;
	}

	@Override
	public void setValuerange(String valuerange) {
		_valuerange = valuerange;

		if (_kdssmpParameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpParameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setValuerange", String.class);

				method.invoke(_kdssmpParameterConfigurationRemoteModel,
					valuerange);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisplayoptions() {
		return _displayoptions;
	}

	@Override
	public void setDisplayoptions(String displayoptions) {
		_displayoptions = displayoptions;

		if (_kdssmpParameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpParameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayoptions",
						String.class);

				method.invoke(_kdssmpParameterConfigurationRemoteModel,
					displayoptions);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVisible() {
		return _visible;
	}

	@Override
	public void setVisible(String visible) {
		_visible = visible;

		if (_kdssmpParameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpParameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setVisible", String.class);

				method.invoke(_kdssmpParameterConfigurationRemoteModel, visible);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComputed() {
		return _computed;
	}

	@Override
	public void setComputed(String computed) {
		_computed = computed;

		if (_kdssmpParameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpParameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setComputed", String.class);

				method.invoke(_kdssmpParameterConfigurationRemoteModel, computed);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getConfirmationscript() {
		return _confirmationscript;
	}

	@Override
	public void setConfirmationscript(String confirmationscript) {
		_confirmationscript = confirmationscript;

		if (_kdssmpParameterConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _kdssmpParameterConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setConfirmationscript",
						String.class);

				method.invoke(_kdssmpParameterConfigurationRemoteModel,
					confirmationscript);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getInputParameter() {
		try {
			String methodName = "getInputParameter";

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

	public BaseModel<?> getKdssmpParameterConfigurationRemoteModel() {
		return _kdssmpParameterConfigurationRemoteModel;
	}

	public void setKdssmpParameterConfigurationRemoteModel(
		BaseModel<?> kdssmpParameterConfigurationRemoteModel) {
		_kdssmpParameterConfigurationRemoteModel = kdssmpParameterConfigurationRemoteModel;
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

		Class<?> remoteModelClass = _kdssmpParameterConfigurationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_kdssmpParameterConfigurationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			KdssmpParameterConfigurationLocalServiceUtil.addKdssmpParameterConfiguration(this);
		}
		else {
			KdssmpParameterConfigurationLocalServiceUtil.updateKdssmpParameterConfiguration(this);
		}
	}

	@Override
	public KdssmpParameterConfiguration toEscapedModel() {
		return (KdssmpParameterConfiguration)ProxyUtil.newProxyInstance(KdssmpParameterConfiguration.class.getClassLoader(),
			new Class[] { KdssmpParameterConfiguration.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		KdssmpParameterConfigurationClp clone = new KdssmpParameterConfigurationClp();

		clone.setParameterconfigurationId(getParameterconfigurationId());
		clone.setDisplayname(getDisplayname());
		clone.setDatatype(getDatatype());
		clone.setValuerange(getValuerange());
		clone.setDisplayoptions(getDisplayoptions());
		clone.setVisible(getVisible());
		clone.setComputed(getComputed());
		clone.setConfirmationscript(getConfirmationscript());

		return clone;
	}

	@Override
	public int compareTo(
		KdssmpParameterConfiguration kdssmpParameterConfiguration) {
		long primaryKey = kdssmpParameterConfiguration.getPrimaryKey();

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

		if (!(obj instanceof KdssmpParameterConfigurationClp)) {
			return false;
		}

		KdssmpParameterConfigurationClp kdssmpParameterConfiguration = (KdssmpParameterConfigurationClp)obj;

		long primaryKey = kdssmpParameterConfiguration.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{parameterconfigurationId=");
		sb.append(getParameterconfigurationId());
		sb.append(", displayname=");
		sb.append(getDisplayname());
		sb.append(", datatype=");
		sb.append(getDatatype());
		sb.append(", valuerange=");
		sb.append(getValuerange());
		sb.append(", displayoptions=");
		sb.append(getDisplayoptions());
		sb.append(", visible=");
		sb.append(getVisible());
		sb.append(", computed=");
		sb.append(getComputed());
		sb.append(", confirmationscript=");
		sb.append(getConfirmationscript());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterConfiguration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>parameterconfigurationId</column-name><column-value><![CDATA[");
		sb.append(getParameterconfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayname</column-name><column-value><![CDATA[");
		sb.append(getDisplayname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>datatype</column-name><column-value><![CDATA[");
		sb.append(getDatatype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valuerange</column-name><column-value><![CDATA[");
		sb.append(getValuerange());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayoptions</column-name><column-value><![CDATA[");
		sb.append(getDisplayoptions());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>visible</column-name><column-value><![CDATA[");
		sb.append(getVisible());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>computed</column-name><column-value><![CDATA[");
		sb.append(getComputed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>confirmationscript</column-name><column-value><![CDATA[");
		sb.append(getConfirmationscript());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _parameterconfigurationId;
	private String _displayname;
	private String _datatype;
	private String _valuerange;
	private String _displayoptions;
	private String _visible;
	private String _computed;
	private String _confirmationscript;
	private BaseModel<?> _kdssmpParameterConfigurationRemoteModel;
}