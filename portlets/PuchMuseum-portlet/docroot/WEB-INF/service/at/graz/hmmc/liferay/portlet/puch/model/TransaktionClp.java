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
import at.graz.hmmc.liferay.portlet.puch.service.TransaktionLocalServiceUtil;

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
public class TransaktionClp extends BaseModelImpl<Transaktion>
	implements Transaktion {
	public TransaktionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Transaktion.class;
	}

	@Override
	public String getModelClassName() {
		return Transaktion.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _transaktionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTransaktionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _transaktionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("transaktionId", getTransaktionId());
		attributes.put("createrUserId", getCreaterUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("typ", getTyp());
		attributes.put("puchmuseumsobjectId", getPuchmuseumsobjectId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long transaktionId = (Long)attributes.get("transaktionId");

		if (transaktionId != null) {
			setTransaktionId(transaktionId);
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

		Long puchmuseumsobjectId = (Long)attributes.get("puchmuseumsobjectId");

		if (puchmuseumsobjectId != null) {
			setPuchmuseumsobjectId(puchmuseumsobjectId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	@Override
	public long getTransaktionId() {
		return _transaktionId;
	}

	@Override
	public void setTransaktionId(long transaktionId) {
		_transaktionId = transaktionId;

		if (_transaktionRemoteModel != null) {
			try {
				Class<?> clazz = _transaktionRemoteModel.getClass();

				Method method = clazz.getMethod("setTransaktionId", long.class);

				method.invoke(_transaktionRemoteModel, transaktionId);
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

		if (_transaktionRemoteModel != null) {
			try {
				Class<?> clazz = _transaktionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreaterUserId", long.class);

				method.invoke(_transaktionRemoteModel, createrUserId);
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

		if (_transaktionRemoteModel != null) {
			try {
				Class<?> clazz = _transaktionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_transaktionRemoteModel, createDate);
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

		if (_transaktionRemoteModel != null) {
			try {
				Class<?> clazz = _transaktionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_transaktionRemoteModel, modifiedUserId);
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

		if (_transaktionRemoteModel != null) {
			try {
				Class<?> clazz = _transaktionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_transaktionRemoteModel, modifiedDate);
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

		if (_transaktionRemoteModel != null) {
			try {
				Class<?> clazz = _transaktionRemoteModel.getClass();

				Method method = clazz.getMethod("setTyp", String.class);

				method.invoke(_transaktionRemoteModel, typ);
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

		if (_transaktionRemoteModel != null) {
			try {
				Class<?> clazz = _transaktionRemoteModel.getClass();

				Method method = clazz.getMethod("setPuchmuseumsobjectId",
						long.class);

				method.invoke(_transaktionRemoteModel, puchmuseumsobjectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_transaktionRemoteModel != null) {
			try {
				Class<?> clazz = _transaktionRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_transaktionRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_transaktionRemoteModel != null) {
			try {
				Class<?> clazz = _transaktionRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_transaktionRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTransaktionRemoteModel() {
		return _transaktionRemoteModel;
	}

	public void setTransaktionRemoteModel(BaseModel<?> transaktionRemoteModel) {
		_transaktionRemoteModel = transaktionRemoteModel;
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

		Class<?> remoteModelClass = _transaktionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_transaktionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TransaktionLocalServiceUtil.addTransaktion(this);
		}
		else {
			TransaktionLocalServiceUtil.updateTransaktion(this);
		}
	}

	@Override
	public Transaktion toEscapedModel() {
		return (Transaktion)ProxyUtil.newProxyInstance(Transaktion.class.getClassLoader(),
			new Class[] { Transaktion.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TransaktionClp clone = new TransaktionClp();

		clone.setTransaktionId(getTransaktionId());
		clone.setCreaterUserId(getCreaterUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setModifiedDate(getModifiedDate());
		clone.setTyp(getTyp());
		clone.setPuchmuseumsobjectId(getPuchmuseumsobjectId());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());

		return clone;
	}

	@Override
	public int compareTo(Transaktion transaktion) {
		int value = 0;

		value = getTyp().compareTo(transaktion.getTyp());

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

		if (!(obj instanceof TransaktionClp)) {
			return false;
		}

		TransaktionClp transaktion = (TransaktionClp)obj;

		long primaryKey = transaktion.getPrimaryKey();

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

		sb.append("{transaktionId=");
		sb.append(getTransaktionId());
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
		sb.append(", puchmuseumsobjectId=");
		sb.append(getPuchmuseumsobjectId());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("at.graz.hmmc.liferay.portlet.puch.model.Transaktion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>transaktionId</column-name><column-value><![CDATA[");
		sb.append(getTransaktionId());
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
		sb.append(
			"<column><column-name>puchmuseumsobjectId</column-name><column-value><![CDATA[");
		sb.append(getPuchmuseumsobjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _transaktionId;
	private long _createrUserId;
	private String _createrUserUuid;
	private Date _createDate;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private Date _modifiedDate;
	private String _typ;
	private long _puchmuseumsobjectId;
	private Date _startDate;
	private Date _endDate;
	private BaseModel<?> _transaktionRemoteModel;
}