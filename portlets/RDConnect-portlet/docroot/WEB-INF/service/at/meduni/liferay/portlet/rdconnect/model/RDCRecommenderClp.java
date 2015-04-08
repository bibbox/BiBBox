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

import at.meduni.liferay.portlet.rdconnect.service.ClpSerializer;
import at.meduni.liferay.portlet.rdconnect.service.RDCRecommenderLocalServiceUtil;

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
public class RDCRecommenderClp extends BaseModelImpl<RDCRecommender>
	implements RDCRecommender {
	public RDCRecommenderClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RDCRecommender.class;
	}

	@Override
	public String getModelClassName() {
		return RDCRecommender.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _rdcrecommenderid;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRdcrecommenderid(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rdcrecommenderid;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("rdcrecommenderid", getRdcrecommenderid());
		attributes.put("organisationId", getOrganisationId());
		attributes.put("recommendedorganisationId",
			getRecommendedorganisationId());
		attributes.put("recommendervalue", getRecommendervalue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long rdcrecommenderid = (Long)attributes.get("rdcrecommenderid");

		if (rdcrecommenderid != null) {
			setRdcrecommenderid(rdcrecommenderid);
		}

		Long organisationId = (Long)attributes.get("organisationId");

		if (organisationId != null) {
			setOrganisationId(organisationId);
		}

		Long recommendedorganisationId = (Long)attributes.get(
				"recommendedorganisationId");

		if (recommendedorganisationId != null) {
			setRecommendedorganisationId(recommendedorganisationId);
		}

		Double recommendervalue = (Double)attributes.get("recommendervalue");

		if (recommendervalue != null) {
			setRecommendervalue(recommendervalue);
		}
	}

	@Override
	public long getRdcrecommenderid() {
		return _rdcrecommenderid;
	}

	@Override
	public void setRdcrecommenderid(long rdcrecommenderid) {
		_rdcrecommenderid = rdcrecommenderid;

		if (_rdcRecommenderRemoteModel != null) {
			try {
				Class<?> clazz = _rdcRecommenderRemoteModel.getClass();

				Method method = clazz.getMethod("setRdcrecommenderid",
						long.class);

				method.invoke(_rdcRecommenderRemoteModel, rdcrecommenderid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganisationId() {
		return _organisationId;
	}

	@Override
	public void setOrganisationId(long organisationId) {
		_organisationId = organisationId;

		if (_rdcRecommenderRemoteModel != null) {
			try {
				Class<?> clazz = _rdcRecommenderRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganisationId", long.class);

				method.invoke(_rdcRecommenderRemoteModel, organisationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRecommendedorganisationId() {
		return _recommendedorganisationId;
	}

	@Override
	public void setRecommendedorganisationId(long recommendedorganisationId) {
		_recommendedorganisationId = recommendedorganisationId;

		if (_rdcRecommenderRemoteModel != null) {
			try {
				Class<?> clazz = _rdcRecommenderRemoteModel.getClass();

				Method method = clazz.getMethod("setRecommendedorganisationId",
						long.class);

				method.invoke(_rdcRecommenderRemoteModel,
					recommendedorganisationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getRecommendervalue() {
		return _recommendervalue;
	}

	@Override
	public void setRecommendervalue(double recommendervalue) {
		_recommendervalue = recommendervalue;

		if (_rdcRecommenderRemoteModel != null) {
			try {
				Class<?> clazz = _rdcRecommenderRemoteModel.getClass();

				Method method = clazz.getMethod("setRecommendervalue",
						double.class);

				method.invoke(_rdcRecommenderRemoteModel, recommendervalue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRDCRecommenderRemoteModel() {
		return _rdcRecommenderRemoteModel;
	}

	public void setRDCRecommenderRemoteModel(
		BaseModel<?> rdcRecommenderRemoteModel) {
		_rdcRecommenderRemoteModel = rdcRecommenderRemoteModel;
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

		Class<?> remoteModelClass = _rdcRecommenderRemoteModel.getClass();

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

		Object returnValue = method.invoke(_rdcRecommenderRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RDCRecommenderLocalServiceUtil.addRDCRecommender(this);
		}
		else {
			RDCRecommenderLocalServiceUtil.updateRDCRecommender(this);
		}
	}

	@Override
	public RDCRecommender toEscapedModel() {
		return (RDCRecommender)ProxyUtil.newProxyInstance(RDCRecommender.class.getClassLoader(),
			new Class[] { RDCRecommender.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RDCRecommenderClp clone = new RDCRecommenderClp();

		clone.setRdcrecommenderid(getRdcrecommenderid());
		clone.setOrganisationId(getOrganisationId());
		clone.setRecommendedorganisationId(getRecommendedorganisationId());
		clone.setRecommendervalue(getRecommendervalue());

		return clone;
	}

	@Override
	public int compareTo(RDCRecommender rdcRecommender) {
		long primaryKey = rdcRecommender.getPrimaryKey();

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

		if (!(obj instanceof RDCRecommenderClp)) {
			return false;
		}

		RDCRecommenderClp rdcRecommender = (RDCRecommenderClp)obj;

		long primaryKey = rdcRecommender.getPrimaryKey();

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

		sb.append("{rdcrecommenderid=");
		sb.append(getRdcrecommenderid());
		sb.append(", organisationId=");
		sb.append(getOrganisationId());
		sb.append(", recommendedorganisationId=");
		sb.append(getRecommendedorganisationId());
		sb.append(", recommendervalue=");
		sb.append(getRecommendervalue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("at.meduni.liferay.portlet.rdconnect.model.RDCRecommender");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>rdcrecommenderid</column-name><column-value><![CDATA[");
		sb.append(getRdcrecommenderid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organisationId</column-name><column-value><![CDATA[");
		sb.append(getOrganisationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recommendedorganisationId</column-name><column-value><![CDATA[");
		sb.append(getRecommendedorganisationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recommendervalue</column-name><column-value><![CDATA[");
		sb.append(getRecommendervalue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _rdcrecommenderid;
	private long _organisationId;
	private long _recommendedorganisationId;
	private double _recommendervalue;
	private BaseModel<?> _rdcRecommenderRemoteModel;
}