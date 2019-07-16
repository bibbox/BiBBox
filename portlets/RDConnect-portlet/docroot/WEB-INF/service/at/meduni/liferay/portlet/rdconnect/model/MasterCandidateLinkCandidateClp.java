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
import at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLinkCandidateLocalServiceUtil;

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
public class MasterCandidateLinkCandidateClp extends BaseModelImpl<MasterCandidateLinkCandidate>
	implements MasterCandidateLinkCandidate {
	public MasterCandidateLinkCandidateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MasterCandidateLinkCandidate.class;
	}

	@Override
	public String getModelClassName() {
		return MasterCandidateLinkCandidate.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _linkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _linkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("linkId", getLinkId());
		attributes.put("candidateId", getCandidateId());
		attributes.put("masterCandidateId", getMasterCandidateId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long linkId = (Long)attributes.get("linkId");

		if (linkId != null) {
			setLinkId(linkId);
		}

		Long candidateId = (Long)attributes.get("candidateId");

		if (candidateId != null) {
			setCandidateId(candidateId);
		}

		Long masterCandidateId = (Long)attributes.get("masterCandidateId");

		if (masterCandidateId != null) {
			setMasterCandidateId(masterCandidateId);
		}
	}

	@Override
	public long getLinkId() {
		return _linkId;
	}

	@Override
	public void setLinkId(long linkId) {
		_linkId = linkId;

		if (_masterCandidateLinkCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateLinkCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkId", long.class);

				method.invoke(_masterCandidateLinkCandidateRemoteModel, linkId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCandidateId() {
		return _candidateId;
	}

	@Override
	public void setCandidateId(long candidateId) {
		_candidateId = candidateId;

		if (_masterCandidateLinkCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateLinkCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setCandidateId", long.class);

				method.invoke(_masterCandidateLinkCandidateRemoteModel,
					candidateId);
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

		if (_masterCandidateLinkCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _masterCandidateLinkCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setMasterCandidateId",
						long.class);

				method.invoke(_masterCandidateLinkCandidateRemoteModel,
					masterCandidateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMasterCandidateLinkCandidateRemoteModel() {
		return _masterCandidateLinkCandidateRemoteModel;
	}

	public void setMasterCandidateLinkCandidateRemoteModel(
		BaseModel<?> masterCandidateLinkCandidateRemoteModel) {
		_masterCandidateLinkCandidateRemoteModel = masterCandidateLinkCandidateRemoteModel;
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

		Class<?> remoteModelClass = _masterCandidateLinkCandidateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_masterCandidateLinkCandidateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MasterCandidateLinkCandidateLocalServiceUtil.addMasterCandidateLinkCandidate(this);
		}
		else {
			MasterCandidateLinkCandidateLocalServiceUtil.updateMasterCandidateLinkCandidate(this);
		}
	}

	@Override
	public MasterCandidateLinkCandidate toEscapedModel() {
		return (MasterCandidateLinkCandidate)ProxyUtil.newProxyInstance(MasterCandidateLinkCandidate.class.getClassLoader(),
			new Class[] { MasterCandidateLinkCandidate.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MasterCandidateLinkCandidateClp clone = new MasterCandidateLinkCandidateClp();

		clone.setLinkId(getLinkId());
		clone.setCandidateId(getCandidateId());
		clone.setMasterCandidateId(getMasterCandidateId());

		return clone;
	}

	@Override
	public int compareTo(
		MasterCandidateLinkCandidate masterCandidateLinkCandidate) {
		long primaryKey = masterCandidateLinkCandidate.getPrimaryKey();

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

		if (!(obj instanceof MasterCandidateLinkCandidateClp)) {
			return false;
		}

		MasterCandidateLinkCandidateClp masterCandidateLinkCandidate = (MasterCandidateLinkCandidateClp)obj;

		long primaryKey = masterCandidateLinkCandidate.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{linkId=");
		sb.append(getLinkId());
		sb.append(", candidateId=");
		sb.append(getCandidateId());
		sb.append(", masterCandidateId=");
		sb.append(getMasterCandidateId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append(
			"at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>linkId</column-name><column-value><![CDATA[");
		sb.append(getLinkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidateId</column-name><column-value><![CDATA[");
		sb.append(getCandidateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>masterCandidateId</column-name><column-value><![CDATA[");
		sb.append(getMasterCandidateId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _linkId;
	private long _candidateId;
	private long _masterCandidateId;
	private BaseModel<?> _masterCandidateLinkCandidateRemoteModel;
	private Class<?> _clpSerializerClass = at.meduni.liferay.portlet.rdconnect.service.ClpSerializer.class;
}