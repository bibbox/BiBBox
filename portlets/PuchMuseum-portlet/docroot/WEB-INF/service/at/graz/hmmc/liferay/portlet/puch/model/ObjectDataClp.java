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
import at.graz.hmmc.liferay.portlet.puch.service.ObjectDataLocalServiceUtil;

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
public class ObjectDataClp extends BaseModelImpl<ObjectData>
	implements ObjectData {
	public ObjectDataClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ObjectData.class;
	}

	@Override
	public String getModelClassName() {
		return ObjectData.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _objectdataId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setObjectdataId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _objectdataId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("objectdataId", getObjectdataId());
		attributes.put("puchmuseumsobjectId", getPuchmuseumsobjectId());
		attributes.put("objectkey", getObjectkey());
		attributes.put("objectvalue", getObjectvalue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long objectdataId = (Long)attributes.get("objectdataId");

		if (objectdataId != null) {
			setObjectdataId(objectdataId);
		}

		Long puchmuseumsobjectId = (Long)attributes.get("puchmuseumsobjectId");

		if (puchmuseumsobjectId != null) {
			setPuchmuseumsobjectId(puchmuseumsobjectId);
		}

		String objectkey = (String)attributes.get("objectkey");

		if (objectkey != null) {
			setObjectkey(objectkey);
		}

		String objectvalue = (String)attributes.get("objectvalue");

		if (objectvalue != null) {
			setObjectvalue(objectvalue);
		}
	}

	@Override
	public long getObjectdataId() {
		return _objectdataId;
	}

	@Override
	public void setObjectdataId(long objectdataId) {
		_objectdataId = objectdataId;

		if (_objectDataRemoteModel != null) {
			try {
				Class<?> clazz = _objectDataRemoteModel.getClass();

				Method method = clazz.getMethod("setObjectdataId", long.class);

				method.invoke(_objectDataRemoteModel, objectdataId);
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

		if (_objectDataRemoteModel != null) {
			try {
				Class<?> clazz = _objectDataRemoteModel.getClass();

				Method method = clazz.getMethod("setPuchmuseumsobjectId",
						long.class);

				method.invoke(_objectDataRemoteModel, puchmuseumsobjectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getObjectkey() {
		return _objectkey;
	}

	@Override
	public void setObjectkey(String objectkey) {
		_objectkey = objectkey;

		if (_objectDataRemoteModel != null) {
			try {
				Class<?> clazz = _objectDataRemoteModel.getClass();

				Method method = clazz.getMethod("setObjectkey", String.class);

				method.invoke(_objectDataRemoteModel, objectkey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getObjectvalue() {
		return _objectvalue;
	}

	@Override
	public void setObjectvalue(String objectvalue) {
		_objectvalue = objectvalue;

		if (_objectDataRemoteModel != null) {
			try {
				Class<?> clazz = _objectDataRemoteModel.getClass();

				Method method = clazz.getMethod("setObjectvalue", String.class);

				method.invoke(_objectDataRemoteModel, objectvalue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getObjectDataRemoteModel() {
		return _objectDataRemoteModel;
	}

	public void setObjectDataRemoteModel(BaseModel<?> objectDataRemoteModel) {
		_objectDataRemoteModel = objectDataRemoteModel;
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

		Class<?> remoteModelClass = _objectDataRemoteModel.getClass();

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

		Object returnValue = method.invoke(_objectDataRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ObjectDataLocalServiceUtil.addObjectData(this);
		}
		else {
			ObjectDataLocalServiceUtil.updateObjectData(this);
		}
	}

	@Override
	public ObjectData toEscapedModel() {
		return (ObjectData)ProxyUtil.newProxyInstance(ObjectData.class.getClassLoader(),
			new Class[] { ObjectData.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ObjectDataClp clone = new ObjectDataClp();

		clone.setObjectdataId(getObjectdataId());
		clone.setPuchmuseumsobjectId(getPuchmuseumsobjectId());
		clone.setObjectkey(getObjectkey());
		clone.setObjectvalue(getObjectvalue());

		return clone;
	}

	@Override
	public int compareTo(ObjectData objectData) {
		int value = 0;

		if (getPuchmuseumsobjectId() < objectData.getPuchmuseumsobjectId()) {
			value = -1;
		}
		else if (getPuchmuseumsobjectId() > objectData.getPuchmuseumsobjectId()) {
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

		if (!(obj instanceof ObjectDataClp)) {
			return false;
		}

		ObjectDataClp objectData = (ObjectDataClp)obj;

		long primaryKey = objectData.getPrimaryKey();

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

		sb.append("{objectdataId=");
		sb.append(getObjectdataId());
		sb.append(", puchmuseumsobjectId=");
		sb.append(getPuchmuseumsobjectId());
		sb.append(", objectkey=");
		sb.append(getObjectkey());
		sb.append(", objectvalue=");
		sb.append(getObjectvalue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("at.graz.hmmc.liferay.portlet.puch.model.ObjectData");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>objectdataId</column-name><column-value><![CDATA[");
		sb.append(getObjectdataId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>puchmuseumsobjectId</column-name><column-value><![CDATA[");
		sb.append(getPuchmuseumsobjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>objectkey</column-name><column-value><![CDATA[");
		sb.append(getObjectkey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>objectvalue</column-name><column-value><![CDATA[");
		sb.append(getObjectvalue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _objectdataId;
	private long _puchmuseumsobjectId;
	private String _objectkey;
	private String _objectvalue;
	private BaseModel<?> _objectDataRemoteModel;
}