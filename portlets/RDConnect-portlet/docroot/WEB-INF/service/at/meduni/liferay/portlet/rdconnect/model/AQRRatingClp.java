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

package at.meduni.liferay.portlet.rdconnect.model;

import at.meduni.liferay.portlet.rdconnect.service.AQRRatingLocalServiceUtil;
import at.meduni.liferay.portlet.rdconnect.service.ClpSerializer;

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
 * @author Robert Reihs
 */
public class AQRRatingClp extends BaseModelImpl<AQRRating> implements AQRRating {
	public AQRRatingClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AQRRating.class;
	}

	@Override
	public String getModelClassName() {
		return AQRRating.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _aqrId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAqrId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _aqrId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("aqrId", getAqrId());
		attributes.put("accessability", getAccessability());
		attributes.put("quality", getQuality());
		attributes.put("relevance", getRelevance());
		attributes.put("masterCandidateId", getMasterCandidateId());
		attributes.put("aqrrater", getAqrrater());
		attributes.put("ratingtype", getRatingtype());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long aqrId = (Long)attributes.get("aqrId");

		if (aqrId != null) {
			setAqrId(aqrId);
		}

		Long accessability = (Long)attributes.get("accessability");

		if (accessability != null) {
			setAccessability(accessability);
		}

		Long quality = (Long)attributes.get("quality");

		if (quality != null) {
			setQuality(quality);
		}

		Long relevance = (Long)attributes.get("relevance");

		if (relevance != null) {
			setRelevance(relevance);
		}

		Long masterCandidateId = (Long)attributes.get("masterCandidateId");

		if (masterCandidateId != null) {
			setMasterCandidateId(masterCandidateId);
		}

		String aqrrater = (String)attributes.get("aqrrater");

		if (aqrrater != null) {
			setAqrrater(aqrrater);
		}

		String ratingtype = (String)attributes.get("ratingtype");

		if (ratingtype != null) {
			setRatingtype(ratingtype);
		}
	}

	@Override
	public long getAqrId() {
		return _aqrId;
	}

	@Override
	public void setAqrId(long aqrId) {
		_aqrId = aqrId;

		if (_aqrRatingRemoteModel != null) {
			try {
				Class<?> clazz = _aqrRatingRemoteModel.getClass();

				Method method = clazz.getMethod("setAqrId", long.class);

				method.invoke(_aqrRatingRemoteModel, aqrId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAccessability() {
		return _accessability;
	}

	@Override
	public void setAccessability(long accessability) {
		_accessability = accessability;

		if (_aqrRatingRemoteModel != null) {
			try {
				Class<?> clazz = _aqrRatingRemoteModel.getClass();

				Method method = clazz.getMethod("setAccessability", long.class);

				method.invoke(_aqrRatingRemoteModel, accessability);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getQuality() {
		return _quality;
	}

	@Override
	public void setQuality(long quality) {
		_quality = quality;

		if (_aqrRatingRemoteModel != null) {
			try {
				Class<?> clazz = _aqrRatingRemoteModel.getClass();

				Method method = clazz.getMethod("setQuality", long.class);

				method.invoke(_aqrRatingRemoteModel, quality);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRelevance() {
		return _relevance;
	}

	@Override
	public void setRelevance(long relevance) {
		_relevance = relevance;

		if (_aqrRatingRemoteModel != null) {
			try {
				Class<?> clazz = _aqrRatingRemoteModel.getClass();

				Method method = clazz.getMethod("setRelevance", long.class);

				method.invoke(_aqrRatingRemoteModel, relevance);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMasterCandidateId() {
		return _masterCandidateId;
	}

	@Override
	public void setMasterCandidateId(long masterCandidateId) {
		_masterCandidateId = masterCandidateId;

		if (_aqrRatingRemoteModel != null) {
			try {
				Class<?> clazz = _aqrRatingRemoteModel.getClass();

				Method method = clazz.getMethod("setMasterCandidateId",
						long.class);

				method.invoke(_aqrRatingRemoteModel, masterCandidateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAqrrater() {
		return _aqrrater;
	}

	@Override
	public void setAqrrater(String aqrrater) {
		_aqrrater = aqrrater;

		if (_aqrRatingRemoteModel != null) {
			try {
				Class<?> clazz = _aqrRatingRemoteModel.getClass();

				Method method = clazz.getMethod("setAqrrater", String.class);

				method.invoke(_aqrRatingRemoteModel, aqrrater);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRatingtype() {
		return _ratingtype;
	}

	@Override
	public void setRatingtype(String ratingtype) {
		_ratingtype = ratingtype;

		if (_aqrRatingRemoteModel != null) {
			try {
				Class<?> clazz = _aqrRatingRemoteModel.getClass();

				Method method = clazz.getMethod("setRatingtype", String.class);

				method.invoke(_aqrRatingRemoteModel, ratingtype);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAQRRatingRemoteModel() {
		return _aqrRatingRemoteModel;
	}

	public void setAQRRatingRemoteModel(BaseModel<?> aqrRatingRemoteModel) {
		_aqrRatingRemoteModel = aqrRatingRemoteModel;
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

		Class<?> remoteModelClass = _aqrRatingRemoteModel.getClass();

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

		Object returnValue = method.invoke(_aqrRatingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AQRRatingLocalServiceUtil.addAQRRating(this);
		}
		else {
			AQRRatingLocalServiceUtil.updateAQRRating(this);
		}
	}

	@Override
	public AQRRating toEscapedModel() {
		return (AQRRating)ProxyUtil.newProxyInstance(AQRRating.class.getClassLoader(),
			new Class[] { AQRRating.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AQRRatingClp clone = new AQRRatingClp();

		clone.setAqrId(getAqrId());
		clone.setAccessability(getAccessability());
		clone.setQuality(getQuality());
		clone.setRelevance(getRelevance());
		clone.setMasterCandidateId(getMasterCandidateId());
		clone.setAqrrater(getAqrrater());
		clone.setRatingtype(getRatingtype());

		return clone;
	}

	@Override
	public int compareTo(AQRRating aqrRating) {
		long primaryKey = aqrRating.getPrimaryKey();

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

		if (!(obj instanceof AQRRatingClp)) {
			return false;
		}

		AQRRatingClp aqrRating = (AQRRatingClp)obj;

		long primaryKey = aqrRating.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{aqrId=");
		sb.append(getAqrId());
		sb.append(", accessability=");
		sb.append(getAccessability());
		sb.append(", quality=");
		sb.append(getQuality());
		sb.append(", relevance=");
		sb.append(getRelevance());
		sb.append(", masterCandidateId=");
		sb.append(getMasterCandidateId());
		sb.append(", aqrrater=");
		sb.append(getAqrrater());
		sb.append(", ratingtype=");
		sb.append(getRatingtype());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("at.meduni.liferay.portlet.rdconnect.model.AQRRating");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>aqrId</column-name><column-value><![CDATA[");
		sb.append(getAqrId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessability</column-name><column-value><![CDATA[");
		sb.append(getAccessability());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quality</column-name><column-value><![CDATA[");
		sb.append(getQuality());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>relevance</column-name><column-value><![CDATA[");
		sb.append(getRelevance());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>masterCandidateId</column-name><column-value><![CDATA[");
		sb.append(getMasterCandidateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aqrrater</column-name><column-value><![CDATA[");
		sb.append(getAqrrater());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingtype</column-name><column-value><![CDATA[");
		sb.append(getRatingtype());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _aqrId;
	private long _accessability;
	private long _quality;
	private long _relevance;
	private long _masterCandidateId;
	private String _aqrrater;
	private String _ratingtype;
	private BaseModel<?> _aqrRatingRemoteModel;
	private Class<?> _clpSerializerClass = at.meduni.liferay.portlet.rdconnect.service.ClpSerializer.class;
}