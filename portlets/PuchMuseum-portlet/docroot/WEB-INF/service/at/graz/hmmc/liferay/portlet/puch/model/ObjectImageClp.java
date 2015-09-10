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
import at.graz.hmmc.liferay.portlet.puch.service.ObjectImageLocalServiceUtil;

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
public class ObjectImageClp extends BaseModelImpl<ObjectImage>
	implements ObjectImage {
	public ObjectImageClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ObjectImage.class;
	}

	@Override
	public String getModelClassName() {
		return ObjectImage.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _objectimageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setObjectimageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _objectimageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("objectimageId", getObjectimageId());
		attributes.put("puchmuseumsobjectId", getPuchmuseumsobjectId());
		attributes.put("createrUserId", getCreaterUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dlappimagerawId", getDlappimagerawId());
		attributes.put("dlappimageprocessedId", getDlappimageprocessedId());
		attributes.put("dlappimagewebId", getDlappimagewebId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long objectimageId = (Long)attributes.get("objectimageId");

		if (objectimageId != null) {
			setObjectimageId(objectimageId);
		}

		Long puchmuseumsobjectId = (Long)attributes.get("puchmuseumsobjectId");

		if (puchmuseumsobjectId != null) {
			setPuchmuseumsobjectId(puchmuseumsobjectId);
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

		Long dlappimagerawId = (Long)attributes.get("dlappimagerawId");

		if (dlappimagerawId != null) {
			setDlappimagerawId(dlappimagerawId);
		}

		Long dlappimageprocessedId = (Long)attributes.get(
				"dlappimageprocessedId");

		if (dlappimageprocessedId != null) {
			setDlappimageprocessedId(dlappimageprocessedId);
		}

		Long dlappimagewebId = (Long)attributes.get("dlappimagewebId");

		if (dlappimagewebId != null) {
			setDlappimagewebId(dlappimagewebId);
		}
	}

	@Override
	public long getObjectimageId() {
		return _objectimageId;
	}

	@Override
	public void setObjectimageId(long objectimageId) {
		_objectimageId = objectimageId;

		if (_objectImageRemoteModel != null) {
			try {
				Class<?> clazz = _objectImageRemoteModel.getClass();

				Method method = clazz.getMethod("setObjectimageId", long.class);

				method.invoke(_objectImageRemoteModel, objectimageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPuchmuseumsobjectId() {
		return _puchmuseumsobjectId;
	}

	@Override
	public void setPuchmuseumsobjectId(long puchmuseumsobjectId) {
		_puchmuseumsobjectId = puchmuseumsobjectId;

		if (_objectImageRemoteModel != null) {
			try {
				Class<?> clazz = _objectImageRemoteModel.getClass();

				Method method = clazz.getMethod("setPuchmuseumsobjectId",
						long.class);

				method.invoke(_objectImageRemoteModel, puchmuseumsobjectId);
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

		if (_objectImageRemoteModel != null) {
			try {
				Class<?> clazz = _objectImageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreaterUserId", long.class);

				method.invoke(_objectImageRemoteModel, createrUserId);
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

		if (_objectImageRemoteModel != null) {
			try {
				Class<?> clazz = _objectImageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_objectImageRemoteModel, createDate);
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

		if (_objectImageRemoteModel != null) {
			try {
				Class<?> clazz = _objectImageRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_objectImageRemoteModel, modifiedUserId);
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

		if (_objectImageRemoteModel != null) {
			try {
				Class<?> clazz = _objectImageRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_objectImageRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDlappimagerawId() {
		return _dlappimagerawId;
	}

	@Override
	public void setDlappimagerawId(long dlappimagerawId) {
		_dlappimagerawId = dlappimagerawId;

		if (_objectImageRemoteModel != null) {
			try {
				Class<?> clazz = _objectImageRemoteModel.getClass();

				Method method = clazz.getMethod("setDlappimagerawId", long.class);

				method.invoke(_objectImageRemoteModel, dlappimagerawId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDlappimageprocessedId() {
		return _dlappimageprocessedId;
	}

	@Override
	public void setDlappimageprocessedId(long dlappimageprocessedId) {
		_dlappimageprocessedId = dlappimageprocessedId;

		if (_objectImageRemoteModel != null) {
			try {
				Class<?> clazz = _objectImageRemoteModel.getClass();

				Method method = clazz.getMethod("setDlappimageprocessedId",
						long.class);

				method.invoke(_objectImageRemoteModel, dlappimageprocessedId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDlappimagewebId() {
		return _dlappimagewebId;
	}

	@Override
	public void setDlappimagewebId(long dlappimagewebId) {
		_dlappimagewebId = dlappimagewebId;

		if (_objectImageRemoteModel != null) {
			try {
				Class<?> clazz = _objectImageRemoteModel.getClass();

				Method method = clazz.getMethod("setDlappimagewebId", long.class);

				method.invoke(_objectImageRemoteModel, dlappimagewebId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getObjectImageRemoteModel() {
		return _objectImageRemoteModel;
	}

	public void setObjectImageRemoteModel(BaseModel<?> objectImageRemoteModel) {
		_objectImageRemoteModel = objectImageRemoteModel;
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

		Class<?> remoteModelClass = _objectImageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_objectImageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ObjectImageLocalServiceUtil.addObjectImage(this);
		}
		else {
			ObjectImageLocalServiceUtil.updateObjectImage(this);
		}
	}

	@Override
	public ObjectImage toEscapedModel() {
		return (ObjectImage)ProxyUtil.newProxyInstance(ObjectImage.class.getClassLoader(),
			new Class[] { ObjectImage.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ObjectImageClp clone = new ObjectImageClp();

		clone.setObjectimageId(getObjectimageId());
		clone.setPuchmuseumsobjectId(getPuchmuseumsobjectId());
		clone.setCreaterUserId(getCreaterUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setModifiedDate(getModifiedDate());
		clone.setDlappimagerawId(getDlappimagerawId());
		clone.setDlappimageprocessedId(getDlappimageprocessedId());
		clone.setDlappimagewebId(getDlappimagewebId());

		return clone;
	}

	@Override
	public int compareTo(ObjectImage objectImage) {
		long primaryKey = objectImage.getPrimaryKey();

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

		if (!(obj instanceof ObjectImageClp)) {
			return false;
		}

		ObjectImageClp objectImage = (ObjectImageClp)obj;

		long primaryKey = objectImage.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{objectimageId=");
		sb.append(getObjectimageId());
		sb.append(", puchmuseumsobjectId=");
		sb.append(getPuchmuseumsobjectId());
		sb.append(", createrUserId=");
		sb.append(getCreaterUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedUserId=");
		sb.append(getModifiedUserId());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", dlappimagerawId=");
		sb.append(getDlappimagerawId());
		sb.append(", dlappimageprocessedId=");
		sb.append(getDlappimageprocessedId());
		sb.append(", dlappimagewebId=");
		sb.append(getDlappimagewebId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("at.graz.hmmc.liferay.portlet.puch.model.ObjectImage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>objectimageId</column-name><column-value><![CDATA[");
		sb.append(getObjectimageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>puchmuseumsobjectId</column-name><column-value><![CDATA[");
		sb.append(getPuchmuseumsobjectId());
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
			"<column><column-name>dlappimagerawId</column-name><column-value><![CDATA[");
		sb.append(getDlappimagerawId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dlappimageprocessedId</column-name><column-value><![CDATA[");
		sb.append(getDlappimageprocessedId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dlappimagewebId</column-name><column-value><![CDATA[");
		sb.append(getDlappimagewebId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _objectimageId;
	private long _puchmuseumsobjectId;
	private long _createrUserId;
	private String _createrUserUuid;
	private Date _createDate;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private Date _modifiedDate;
	private long _dlappimagerawId;
	private long _dlappimageprocessedId;
	private long _dlappimagewebId;
	private BaseModel<?> _objectImageRemoteModel;
}