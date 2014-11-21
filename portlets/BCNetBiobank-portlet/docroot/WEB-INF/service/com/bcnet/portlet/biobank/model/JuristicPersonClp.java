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

package com.bcnet.portlet.biobank.model;

import com.bcnet.portlet.biobank.service.ClpSerializer;
import com.bcnet.portlet.biobank.service.JuristicPersonLocalServiceUtil;

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
 * @author suyama
 */
public class JuristicPersonClp extends BaseModelImpl<JuristicPerson>
	implements JuristicPerson {
	public JuristicPersonClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return JuristicPerson.class;
	}

	@Override
	public String getModelClassName() {
		return JuristicPerson.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _juristicPersonId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJuristicPersonId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _juristicPersonId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("juristicPersonId", getJuristicPersonId());
		attributes.put("name", getName());
		attributes.put("url", getUrl());
		attributes.put("address", getAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long juristicPersonId = (Long)attributes.get("juristicPersonId");

		if (juristicPersonId != null) {
			setJuristicPersonId(juristicPersonId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}
	}

	@Override
	public long getJuristicPersonId() {
		return _juristicPersonId;
	}

	@Override
	public void setJuristicPersonId(long juristicPersonId) {
		_juristicPersonId = juristicPersonId;

		if (_juristicPersonRemoteModel != null) {
			try {
				Class<?> clazz = _juristicPersonRemoteModel.getClass();

				Method method = clazz.getMethod("setJuristicPersonId",
						long.class);

				method.invoke(_juristicPersonRemoteModel, juristicPersonId);
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

		if (_juristicPersonRemoteModel != null) {
			try {
				Class<?> clazz = _juristicPersonRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_juristicPersonRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrl() {
		return _url;
	}

	@Override
	public void setUrl(String url) {
		_url = url;

		if (_juristicPersonRemoteModel != null) {
			try {
				Class<?> clazz = _juristicPersonRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_juristicPersonRemoteModel, url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress() {
		return _address;
	}

	@Override
	public void setAddress(String address) {
		_address = address;

		if (_juristicPersonRemoteModel != null) {
			try {
				Class<?> clazz = _juristicPersonRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_juristicPersonRemoteModel, address);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getJuristicPersonRemoteModel() {
		return _juristicPersonRemoteModel;
	}

	public void setJuristicPersonRemoteModel(
		BaseModel<?> juristicPersonRemoteModel) {
		_juristicPersonRemoteModel = juristicPersonRemoteModel;
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

		Class<?> remoteModelClass = _juristicPersonRemoteModel.getClass();

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

		Object returnValue = method.invoke(_juristicPersonRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			JuristicPersonLocalServiceUtil.addJuristicPerson(this);
		}
		else {
			JuristicPersonLocalServiceUtil.updateJuristicPerson(this);
		}
	}

	@Override
	public JuristicPerson toEscapedModel() {
		return (JuristicPerson)ProxyUtil.newProxyInstance(JuristicPerson.class.getClassLoader(),
			new Class[] { JuristicPerson.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		JuristicPersonClp clone = new JuristicPersonClp();

		clone.setJuristicPersonId(getJuristicPersonId());
		clone.setName(getName());
		clone.setUrl(getUrl());
		clone.setAddress(getAddress());

		return clone;
	}

	@Override
	public int compareTo(JuristicPerson juristicPerson) {
		long primaryKey = juristicPerson.getPrimaryKey();

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

		if (!(obj instanceof JuristicPersonClp)) {
			return false;
		}

		JuristicPersonClp juristicPerson = (JuristicPersonClp)obj;

		long primaryKey = juristicPerson.getPrimaryKey();

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

		sb.append("{juristicPersonId=");
		sb.append(getJuristicPersonId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.bcnet.portlet.biobank.model.JuristicPerson");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>juristicPersonId</column-name><column-value><![CDATA[");
		sb.append(getJuristicPersonId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _juristicPersonId;
	private String _name;
	private String _url;
	private String _address;
	private BaseModel<?> _juristicPersonRemoteModel;
}