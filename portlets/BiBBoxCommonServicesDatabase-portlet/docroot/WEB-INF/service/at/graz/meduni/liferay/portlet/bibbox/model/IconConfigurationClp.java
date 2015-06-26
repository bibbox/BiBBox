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
import at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationLocalServiceUtil;

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
public class IconConfigurationClp extends BaseModelImpl<IconConfiguration>
	implements IconConfiguration {
	public IconConfigurationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return IconConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return IconConfiguration.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _iconconfigurationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIconconfigurationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _iconconfigurationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("iconconfigurationId", getIconconfigurationId());
		attributes.put("symbolconfigurationId", getSymbolconfigurationId());
		attributes.put("position", getPosition());
		attributes.put("key", getKey());
		attributes.put("iconsId", getIconsId());
		attributes.put("elementcolor", getElementcolor());
		attributes.put("width", getWidth());
		attributes.put("height", getHeight());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long iconconfigurationId = (Long)attributes.get("iconconfigurationId");

		if (iconconfigurationId != null) {
			setIconconfigurationId(iconconfigurationId);
		}

		Long symbolconfigurationId = (Long)attributes.get(
				"symbolconfigurationId");

		if (symbolconfigurationId != null) {
			setSymbolconfigurationId(symbolconfigurationId);
		}

		String position = (String)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		Long iconsId = (Long)attributes.get("iconsId");

		if (iconsId != null) {
			setIconsId(iconsId);
		}

		String elementcolor = (String)attributes.get("elementcolor");

		if (elementcolor != null) {
			setElementcolor(elementcolor);
		}

		String width = (String)attributes.get("width");

		if (width != null) {
			setWidth(width);
		}

		String height = (String)attributes.get("height");

		if (height != null) {
			setHeight(height);
		}
	}

	@Override
	public long getIconconfigurationId() {
		return _iconconfigurationId;
	}

	@Override
	public void setIconconfigurationId(long iconconfigurationId) {
		_iconconfigurationId = iconconfigurationId;

		if (_iconConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _iconConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setIconconfigurationId",
						long.class);

				method.invoke(_iconConfigurationRemoteModel, iconconfigurationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSymbolconfigurationId() {
		return _symbolconfigurationId;
	}

	@Override
	public void setSymbolconfigurationId(long symbolconfigurationId) {
		_symbolconfigurationId = symbolconfigurationId;

		if (_iconConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _iconConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setSymbolconfigurationId",
						long.class);

				method.invoke(_iconConfigurationRemoteModel,
					symbolconfigurationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPosition() {
		return _position;
	}

	@Override
	public void setPosition(String position) {
		_position = position;

		if (_iconConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _iconConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setPosition", String.class);

				method.invoke(_iconConfigurationRemoteModel, position);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKey() {
		return _key;
	}

	@Override
	public void setKey(String key) {
		_key = key;

		if (_iconConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _iconConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setKey", String.class);

				method.invoke(_iconConfigurationRemoteModel, key);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIconsId() {
		return _iconsId;
	}

	@Override
	public void setIconsId(long iconsId) {
		_iconsId = iconsId;

		if (_iconConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _iconConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setIconsId", long.class);

				method.invoke(_iconConfigurationRemoteModel, iconsId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getElementcolor() {
		return _elementcolor;
	}

	@Override
	public void setElementcolor(String elementcolor) {
		_elementcolor = elementcolor;

		if (_iconConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _iconConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setElementcolor", String.class);

				method.invoke(_iconConfigurationRemoteModel, elementcolor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWidth() {
		return _width;
	}

	@Override
	public void setWidth(String width) {
		_width = width;

		if (_iconConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _iconConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setWidth", String.class);

				method.invoke(_iconConfigurationRemoteModel, width);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHeight() {
		return _height;
	}

	@Override
	public void setHeight(String height) {
		_height = height;

		if (_iconConfigurationRemoteModel != null) {
			try {
				Class<?> clazz = _iconConfigurationRemoteModel.getClass();

				Method method = clazz.getMethod("setHeight", String.class);

				method.invoke(_iconConfigurationRemoteModel, height);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getHTMLIcon() {
		try {
			String methodName = "getHTMLIcon";

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

	@Override
	public java.lang.String getIconUrl() {
		try {
			String methodName = "getIconUrl";

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

	public BaseModel<?> getIconConfigurationRemoteModel() {
		return _iconConfigurationRemoteModel;
	}

	public void setIconConfigurationRemoteModel(
		BaseModel<?> iconConfigurationRemoteModel) {
		_iconConfigurationRemoteModel = iconConfigurationRemoteModel;
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

		Class<?> remoteModelClass = _iconConfigurationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_iconConfigurationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			IconConfigurationLocalServiceUtil.addIconConfiguration(this);
		}
		else {
			IconConfigurationLocalServiceUtil.updateIconConfiguration(this);
		}
	}

	@Override
	public IconConfiguration toEscapedModel() {
		return (IconConfiguration)ProxyUtil.newProxyInstance(IconConfiguration.class.getClassLoader(),
			new Class[] { IconConfiguration.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		IconConfigurationClp clone = new IconConfigurationClp();

		clone.setIconconfigurationId(getIconconfigurationId());
		clone.setSymbolconfigurationId(getSymbolconfigurationId());
		clone.setPosition(getPosition());
		clone.setKey(getKey());
		clone.setIconsId(getIconsId());
		clone.setElementcolor(getElementcolor());
		clone.setWidth(getWidth());
		clone.setHeight(getHeight());

		return clone;
	}

	@Override
	public int compareTo(IconConfiguration iconConfiguration) {
		long primaryKey = iconConfiguration.getPrimaryKey();

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

		if (!(obj instanceof IconConfigurationClp)) {
			return false;
		}

		IconConfigurationClp iconConfiguration = (IconConfigurationClp)obj;

		long primaryKey = iconConfiguration.getPrimaryKey();

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

		sb.append("{iconconfigurationId=");
		sb.append(getIconconfigurationId());
		sb.append(", symbolconfigurationId=");
		sb.append(getSymbolconfigurationId());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append(", key=");
		sb.append(getKey());
		sb.append(", iconsId=");
		sb.append(getIconsId());
		sb.append(", elementcolor=");
		sb.append(getElementcolor());
		sb.append(", width=");
		sb.append(getWidth());
		sb.append(", height=");
		sb.append(getHeight());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>iconconfigurationId</column-name><column-value><![CDATA[");
		sb.append(getIconconfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>symbolconfigurationId</column-name><column-value><![CDATA[");
		sb.append(getSymbolconfigurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>key</column-name><column-value><![CDATA[");
		sb.append(getKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>iconsId</column-name><column-value><![CDATA[");
		sb.append(getIconsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>elementcolor</column-name><column-value><![CDATA[");
		sb.append(getElementcolor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>width</column-name><column-value><![CDATA[");
		sb.append(getWidth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>height</column-name><column-value><![CDATA[");
		sb.append(getHeight());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _iconconfigurationId;
	private long _symbolconfigurationId;
	private String _position;
	private String _key;
	private long _iconsId;
	private String _elementcolor;
	private String _width;
	private String _height;
	private BaseModel<?> _iconConfigurationRemoteModel;
}