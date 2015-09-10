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
import at.graz.hmmc.liferay.portlet.puch.service.TransaktionDataLocalServiceUtil;

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
public class TransaktionDataClp extends BaseModelImpl<TransaktionData>
	implements TransaktionData {
	public TransaktionDataClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TransaktionData.class;
	}

	@Override
	public String getModelClassName() {
		return TransaktionData.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _transaktiondataId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTransaktiondataId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _transaktiondataId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("transaktiondataId", getTransaktiondataId());
		attributes.put("puchmuseumsobjectId", getPuchmuseumsobjectId());
		attributes.put("transaktionId", getTransaktionId());
		attributes.put("objectkey", getObjectkey());
		attributes.put("objectvalue", getObjectvalue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long transaktiondataId = (Long)attributes.get("transaktiondataId");

		if (transaktiondataId != null) {
			setTransaktiondataId(transaktiondataId);
		}

		Long puchmuseumsobjectId = (Long)attributes.get("puchmuseumsobjectId");

		if (puchmuseumsobjectId != null) {
			setPuchmuseumsobjectId(puchmuseumsobjectId);
		}

		Long transaktionId = (Long)attributes.get("transaktionId");

		if (transaktionId != null) {
			setTransaktionId(transaktionId);
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
	public long getTransaktiondataId() {
		return _transaktiondataId;
	}

	@Override
	public void setTransaktiondataId(long transaktiondataId) {
		_transaktiondataId = transaktiondataId;

		if (_transaktionDataRemoteModel != null) {
			try {
				Class<?> clazz = _transaktionDataRemoteModel.getClass();

				Method method = clazz.getMethod("setTransaktiondataId",
						long.class);

				method.invoke(_transaktionDataRemoteModel, transaktiondataId);
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

		if (_transaktionDataRemoteModel != null) {
			try {
				Class<?> clazz = _transaktionDataRemoteModel.getClass();

				Method method = clazz.getMethod("setPuchmuseumsobjectId",
						long.class);

				method.invoke(_transaktionDataRemoteModel, puchmuseumsobjectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTransaktionId() {
		return _transaktionId;
	}

	@Override
	public void setTransaktionId(long transaktionId) {
		_transaktionId = transaktionId;

		if (_transaktionDataRemoteModel != null) {
			try {
				Class<?> clazz = _transaktionDataRemoteModel.getClass();

				Method method = clazz.getMethod("setTransaktionId", long.class);

				method.invoke(_transaktionDataRemoteModel, transaktionId);
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

		if (_transaktionDataRemoteModel != null) {
			try {
				Class<?> clazz = _transaktionDataRemoteModel.getClass();

				Method method = clazz.getMethod("setObjectkey", String.class);

				method.invoke(_transaktionDataRemoteModel, objectkey);
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

		if (_transaktionDataRemoteModel != null) {
			try {
				Class<?> clazz = _transaktionDataRemoteModel.getClass();

				Method method = clazz.getMethod("setObjectvalue", String.class);

				method.invoke(_transaktionDataRemoteModel, objectvalue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String formatValueHTML() {
		try {
			String methodName = "formatValueHTML";

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

	public BaseModel<?> getTransaktionDataRemoteModel() {
		return _transaktionDataRemoteModel;
	}

	public void setTransaktionDataRemoteModel(
		BaseModel<?> transaktionDataRemoteModel) {
		_transaktionDataRemoteModel = transaktionDataRemoteModel;
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

		Class<?> remoteModelClass = _transaktionDataRemoteModel.getClass();

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

		Object returnValue = method.invoke(_transaktionDataRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TransaktionDataLocalServiceUtil.addTransaktionData(this);
		}
		else {
			TransaktionDataLocalServiceUtil.updateTransaktionData(this);
		}
	}

	@Override
	public TransaktionData toEscapedModel() {
		return (TransaktionData)ProxyUtil.newProxyInstance(TransaktionData.class.getClassLoader(),
			new Class[] { TransaktionData.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TransaktionDataClp clone = new TransaktionDataClp();

		clone.setTransaktiondataId(getTransaktiondataId());
		clone.setPuchmuseumsobjectId(getPuchmuseumsobjectId());
		clone.setTransaktionId(getTransaktionId());
		clone.setObjectkey(getObjectkey());
		clone.setObjectvalue(getObjectvalue());

		return clone;
	}

	@Override
	public int compareTo(TransaktionData transaktionData) {
		int value = 0;

		if (getTransaktionId() < transaktionData.getTransaktionId()) {
			value = -1;
		}
		else if (getTransaktionId() > transaktionData.getTransaktionId()) {
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

		if (!(obj instanceof TransaktionDataClp)) {
			return false;
		}

		TransaktionDataClp transaktionData = (TransaktionDataClp)obj;

		long primaryKey = transaktionData.getPrimaryKey();

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

		sb.append("{transaktiondataId=");
		sb.append(getTransaktiondataId());
		sb.append(", puchmuseumsobjectId=");
		sb.append(getPuchmuseumsobjectId());
		sb.append(", transaktionId=");
		sb.append(getTransaktionId());
		sb.append(", objectkey=");
		sb.append(getObjectkey());
		sb.append(", objectvalue=");
		sb.append(getObjectvalue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("at.graz.hmmc.liferay.portlet.puch.model.TransaktionData");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>transaktiondataId</column-name><column-value><![CDATA[");
		sb.append(getTransaktiondataId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>puchmuseumsobjectId</column-name><column-value><![CDATA[");
		sb.append(getPuchmuseumsobjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>transaktionId</column-name><column-value><![CDATA[");
		sb.append(getTransaktionId());
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

	private long _transaktiondataId;
	private long _puchmuseumsobjectId;
	private long _transaktionId;
	private String _objectkey;
	private String _objectvalue;
	private BaseModel<?> _transaktionDataRemoteModel;
}