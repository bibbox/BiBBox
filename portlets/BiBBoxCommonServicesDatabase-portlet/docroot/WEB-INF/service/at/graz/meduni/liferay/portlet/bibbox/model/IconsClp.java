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
import at.graz.meduni.liferay.portlet.bibbox.service.IconsLocalServiceUtil;

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
public class IconsClp extends BaseModelImpl<Icons> implements Icons {
	public IconsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Icons.class;
	}

	@Override
	public String getModelClassName() {
		return Icons.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _iconsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIconsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _iconsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("iconsId", getIconsId());
		attributes.put("iconurl", getIconurl());
		attributes.put("group", getGroup());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long iconsId = (Long)attributes.get("iconsId");

		if (iconsId != null) {
			setIconsId(iconsId);
		}

		String iconurl = (String)attributes.get("iconurl");

		if (iconurl != null) {
			setIconurl(iconurl);
		}

		String group = (String)attributes.get("group");

		if (group != null) {
			setGroup(group);
		}
	}

	@Override
	public long getIconsId() {
		return _iconsId;
	}

	@Override
	public void setIconsId(long iconsId) {
		_iconsId = iconsId;

		if (_iconsRemoteModel != null) {
			try {
				Class<?> clazz = _iconsRemoteModel.getClass();

				Method method = clazz.getMethod("setIconsId", long.class);

				method.invoke(_iconsRemoteModel, iconsId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIconurl() {
		return _iconurl;
	}

	@Override
	public void setIconurl(String iconurl) {
		_iconurl = iconurl;

		if (_iconsRemoteModel != null) {
			try {
				Class<?> clazz = _iconsRemoteModel.getClass();

				Method method = clazz.getMethod("setIconurl", String.class);

				method.invoke(_iconsRemoteModel, iconurl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGroup() {
		return _group;
	}

	@Override
	public void setGroup(String group) {
		_group = group;

		if (_iconsRemoteModel != null) {
			try {
				Class<?> clazz = _iconsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroup", String.class);

				method.invoke(_iconsRemoteModel, group);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getIconsRemoteModel() {
		return _iconsRemoteModel;
	}

	public void setIconsRemoteModel(BaseModel<?> iconsRemoteModel) {
		_iconsRemoteModel = iconsRemoteModel;
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

		Class<?> remoteModelClass = _iconsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_iconsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			IconsLocalServiceUtil.addIcons(this);
		}
		else {
			IconsLocalServiceUtil.updateIcons(this);
		}
	}

	@Override
	public Icons toEscapedModel() {
		return (Icons)ProxyUtil.newProxyInstance(Icons.class.getClassLoader(),
			new Class[] { Icons.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		IconsClp clone = new IconsClp();

		clone.setIconsId(getIconsId());
		clone.setIconurl(getIconurl());
		clone.setGroup(getGroup());

		return clone;
	}

	@Override
	public int compareTo(Icons icons) {
		long primaryKey = icons.getPrimaryKey();

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

		if (!(obj instanceof IconsClp)) {
			return false;
		}

		IconsClp icons = (IconsClp)obj;

		long primaryKey = icons.getPrimaryKey();

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

		sb.append("{iconsId=");
		sb.append(getIconsId());
		sb.append(", iconurl=");
		sb.append(getIconurl());
		sb.append(", group=");
		sb.append(getGroup());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.liferay.portlet.bibbox.model.Icons");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>iconsId</column-name><column-value><![CDATA[");
		sb.append(getIconsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>iconurl</column-name><column-value><![CDATA[");
		sb.append(getIconurl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>group</column-name><column-value><![CDATA[");
		sb.append(getGroup());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _iconsId;
	private String _iconurl;
	private String _group;
	private BaseModel<?> _iconsRemoteModel;
}