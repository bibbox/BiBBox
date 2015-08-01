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
import at.graz.hmmc.liferay.portlet.puch.service.FahrzeugLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author reihsr
 */
public class FahrzeugClp extends BaseModelImpl<Fahrzeug> implements Fahrzeug {
	public FahrzeugClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Fahrzeug.class;
	}

	@Override
	public String getModelClassName() {
		return Fahrzeug.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _fahrzeugId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFahrzeugId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fahrzeugId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fahrzeugId", getFahrzeugId());
		attributes.put("createrUserId", getCreaterUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("typ", getTyp());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fahrzeugId = (Long)attributes.get("fahrzeugId");

		if (fahrzeugId != null) {
			setFahrzeugId(fahrzeugId);
		}

		Long createrUserId = (Long)attributes.get("createrUserId");

		if (createrUserId != null) {
			setCreaterUserId(createrUserId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedUserId = (Long)attributes.get("modifiedUserId");

		if (modifiedUserId != null) {
			setModifiedUserId(modifiedUserId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String typ = (String)attributes.get("typ");

		if (typ != null) {
			setTyp(typ);
		}
	}

	@Override
	public long getFahrzeugId() {
		return _fahrzeugId;
	}

	@Override
	public void setFahrzeugId(long fahrzeugId) {
		_fahrzeugId = fahrzeugId;

		if (_fahrzeugRemoteModel != null) {
			try {
				Class<?> clazz = _fahrzeugRemoteModel.getClass();

				Method method = clazz.getMethod("setFahrzeugId", long.class);

				method.invoke(_fahrzeugRemoteModel, fahrzeugId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreaterUserId() {
		return _createrUserId;
	}

	@Override
	public void setCreaterUserId(long createrUserId) {
		_createrUserId = createrUserId;

		if (_fahrzeugRemoteModel != null) {
			try {
				Class<?> clazz = _fahrzeugRemoteModel.getClass();

				Method method = clazz.getMethod("setCreaterUserId", long.class);

				method.invoke(_fahrzeugRemoteModel, createrUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreaterUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getCreaterUserId(), "uuid",
			_createrUserUuid);
	}

	@Override
	public void setCreaterUserUuid(String createrUserUuid) {
		_createrUserUuid = createrUserUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_fahrzeugRemoteModel != null) {
			try {
				Class<?> clazz = _fahrzeugRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_fahrzeugRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;

		if (_fahrzeugRemoteModel != null) {
			try {
				Class<?> clazz = _fahrzeugRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_fahrzeugRemoteModel, modifiedUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModifiedUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getModifiedUserId(), "uuid",
			_modifiedUserUuid);
	}

	@Override
	public void setModifiedUserUuid(String modifiedUserUuid) {
		_modifiedUserUuid = modifiedUserUuid;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_fahrzeugRemoteModel != null) {
			try {
				Class<?> clazz = _fahrzeugRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_fahrzeugRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTyp() {
		return _typ;
	}

	@Override
	public void setTyp(String typ) {
		_typ = typ;

		if (_fahrzeugRemoteModel != null) {
			try {
				Class<?> clazz = _fahrzeugRemoteModel.getClass();

				Method method = clazz.getMethod("setTyp", String.class);

				method.invoke(_fahrzeugRemoteModel, typ);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFahrzeugRemoteModel() {
		return _fahrzeugRemoteModel;
	}

	public void setFahrzeugRemoteModel(BaseModel<?> fahrzeugRemoteModel) {
		_fahrzeugRemoteModel = fahrzeugRemoteModel;
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

		Class<?> remoteModelClass = _fahrzeugRemoteModel.getClass();

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

		Object returnValue = method.invoke(_fahrzeugRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FahrzeugLocalServiceUtil.addFahrzeug(this);
		}
		else {
			FahrzeugLocalServiceUtil.updateFahrzeug(this);
		}
	}

	@Override
	public Fahrzeug toEscapedModel() {
		return (Fahrzeug)ProxyUtil.newProxyInstance(Fahrzeug.class.getClassLoader(),
			new Class[] { Fahrzeug.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FahrzeugClp clone = new FahrzeugClp();

		clone.setFahrzeugId(getFahrzeugId());
		clone.setCreaterUserId(getCreaterUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setModifiedDate(getModifiedDate());
		clone.setTyp(getTyp());

		return clone;
	}

	@Override
	public int compareTo(Fahrzeug fahrzeug) {
		int value = 0;

		value = getTyp().compareTo(fahrzeug.getTyp());

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

		if (!(obj instanceof FahrzeugClp)) {
			return false;
		}

		FahrzeugClp fahrzeug = (FahrzeugClp)obj;

		long primaryKey = fahrzeug.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{fahrzeugId=");
		sb.append(getFahrzeugId());
		sb.append(", createrUserId=");
		sb.append(getCreaterUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedUserId=");
		sb.append(getModifiedUserId());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", typ=");
		sb.append(getTyp());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>fahrzeugId</column-name><column-value><![CDATA[");
		sb.append(getFahrzeugId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createrUserId</column-name><column-value><![CDATA[");
		sb.append(getCreaterUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedUserId</column-name><column-value><![CDATA[");
		sb.append(getModifiedUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typ</column-name><column-value><![CDATA[");
		sb.append(getTyp());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _fahrzeugId;
	private long _createrUserId;
	private String _createrUserUuid;
	private Date _createDate;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private Date _modifiedDate;
	private String _typ;
	private BaseModel<?> _fahrzeugRemoteModel;
}