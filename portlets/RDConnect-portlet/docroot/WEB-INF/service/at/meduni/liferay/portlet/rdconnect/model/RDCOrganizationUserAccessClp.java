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
import at.meduni.liferay.portlet.rdconnect.service.RDCOrganizationUserAccessLocalServiceUtil;

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
 * @author Robert Reihs
 */
public class RDCOrganizationUserAccessClp extends BaseModelImpl<RDCOrganizationUserAccess>
	implements RDCOrganizationUserAccess {
	public RDCOrganizationUserAccessClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RDCOrganizationUserAccess.class;
	}

	@Override
	public String getModelClassName() {
		return RDCOrganizationUserAccess.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _rdcorganizationuseraccessId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRdcorganizationuseraccessId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rdcorganizationuseraccessId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("rdcorganizationuseraccessId",
			getRdcorganizationuseraccessId());
		attributes.put("organisationId", getOrganisationId());
		attributes.put("userId", getUserId());
		attributes.put("ipaddress", getIpaddress());
		attributes.put("lastaccess", getLastaccess());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long rdcorganizationuseraccessId = (Long)attributes.get(
				"rdcorganizationuseraccessId");

		if (rdcorganizationuseraccessId != null) {
			setRdcorganizationuseraccessId(rdcorganizationuseraccessId);
		}

		Long organisationId = (Long)attributes.get("organisationId");

		if (organisationId != null) {
			setOrganisationId(organisationId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long ipaddress = (Long)attributes.get("ipaddress");

		if (ipaddress != null) {
			setIpaddress(ipaddress);
		}

		Date lastaccess = (Date)attributes.get("lastaccess");

		if (lastaccess != null) {
			setLastaccess(lastaccess);
		}
	}

	@Override
	public long getRdcorganizationuseraccessId() {
		return _rdcorganizationuseraccessId;
	}

	@Override
	public void setRdcorganizationuseraccessId(long rdcorganizationuseraccessId) {
		_rdcorganizationuseraccessId = rdcorganizationuseraccessId;

		if (_rdcOrganizationUserAccessRemoteModel != null) {
			try {
				Class<?> clazz = _rdcOrganizationUserAccessRemoteModel.getClass();

				Method method = clazz.getMethod("setRdcorganizationuseraccessId",
						long.class);

				method.invoke(_rdcOrganizationUserAccessRemoteModel,
					rdcorganizationuseraccessId);
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

		if (_rdcOrganizationUserAccessRemoteModel != null) {
			try {
				Class<?> clazz = _rdcOrganizationUserAccessRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganisationId", long.class);

				method.invoke(_rdcOrganizationUserAccessRemoteModel,
					organisationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_rdcOrganizationUserAccessRemoteModel != null) {
			try {
				Class<?> clazz = _rdcOrganizationUserAccessRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_rdcOrganizationUserAccessRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getIpaddress() {
		return _ipaddress;
	}

	@Override
	public void setIpaddress(long ipaddress) {
		_ipaddress = ipaddress;

		if (_rdcOrganizationUserAccessRemoteModel != null) {
			try {
				Class<?> clazz = _rdcOrganizationUserAccessRemoteModel.getClass();

				Method method = clazz.getMethod("setIpaddress", long.class);

				method.invoke(_rdcOrganizationUserAccessRemoteModel, ipaddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastaccess() {
		return _lastaccess;
	}

	@Override
	public void setLastaccess(Date lastaccess) {
		_lastaccess = lastaccess;

		if (_rdcOrganizationUserAccessRemoteModel != null) {
			try {
				Class<?> clazz = _rdcOrganizationUserAccessRemoteModel.getClass();

				Method method = clazz.getMethod("setLastaccess", Date.class);

				method.invoke(_rdcOrganizationUserAccessRemoteModel, lastaccess);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRDCOrganizationUserAccessRemoteModel() {
		return _rdcOrganizationUserAccessRemoteModel;
	}

	public void setRDCOrganizationUserAccessRemoteModel(
		BaseModel<?> rdcOrganizationUserAccessRemoteModel) {
		_rdcOrganizationUserAccessRemoteModel = rdcOrganizationUserAccessRemoteModel;
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

		Class<?> remoteModelClass = _rdcOrganizationUserAccessRemoteModel.getClass();

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

		Object returnValue = method.invoke(_rdcOrganizationUserAccessRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RDCOrganizationUserAccessLocalServiceUtil.addRDCOrganizationUserAccess(this);
		}
		else {
			RDCOrganizationUserAccessLocalServiceUtil.updateRDCOrganizationUserAccess(this);
		}
	}

	@Override
	public RDCOrganizationUserAccess toEscapedModel() {
		return (RDCOrganizationUserAccess)ProxyUtil.newProxyInstance(RDCOrganizationUserAccess.class.getClassLoader(),
			new Class[] { RDCOrganizationUserAccess.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RDCOrganizationUserAccessClp clone = new RDCOrganizationUserAccessClp();

		clone.setRdcorganizationuseraccessId(getRdcorganizationuseraccessId());
		clone.setOrganisationId(getOrganisationId());
		clone.setUserId(getUserId());
		clone.setIpaddress(getIpaddress());
		clone.setLastaccess(getLastaccess());

		return clone;
	}

	@Override
	public int compareTo(RDCOrganizationUserAccess rdcOrganizationUserAccess) {
		long primaryKey = rdcOrganizationUserAccess.getPrimaryKey();

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

		if (!(obj instanceof RDCOrganizationUserAccessClp)) {
			return false;
		}

		RDCOrganizationUserAccessClp rdcOrganizationUserAccess = (RDCOrganizationUserAccessClp)obj;

		long primaryKey = rdcOrganizationUserAccess.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{rdcorganizationuseraccessId=");
		sb.append(getRdcorganizationuseraccessId());
		sb.append(", organisationId=");
		sb.append(getOrganisationId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", ipaddress=");
		sb.append(getIpaddress());
		sb.append(", lastaccess=");
		sb.append(getLastaccess());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append(
			"at.meduni.liferay.portlet.rdconnect.model.RDCOrganizationUserAccess");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>rdcorganizationuseraccessId</column-name><column-value><![CDATA[");
		sb.append(getRdcorganizationuseraccessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organisationId</column-name><column-value><![CDATA[");
		sb.append(getOrganisationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ipaddress</column-name><column-value><![CDATA[");
		sb.append(getIpaddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastaccess</column-name><column-value><![CDATA[");
		sb.append(getLastaccess());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _rdcorganizationuseraccessId;
	private long _organisationId;
	private long _userId;
	private String _userUuid;
	private long _ipaddress;
	private Date _lastaccess;
	private BaseModel<?> _rdcOrganizationUserAccessRemoteModel;
	private Class<?> _clpSerializerClass = at.meduni.liferay.portlet.rdconnect.service.ClpSerializer.class;
}