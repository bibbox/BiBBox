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

package at.graz.meduni.liferay.portlet.bibbox.service.model;

import at.graz.meduni.liferay.portlet.bibbox.service.service.ClpSerializer;
import at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationOrganisationLocalServiceUtil;

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
public class InvitationOrganisationClp extends BaseModelImpl<InvitationOrganisation>
	implements InvitationOrganisation {
	public InvitationOrganisationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return InvitationOrganisation.class;
	}

	@Override
	public String getModelClassName() {
		return InvitationOrganisation.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _invitationOrganisationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInvitationOrganisationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _invitationOrganisationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("invitationOrganisationId", getInvitationOrganisationId());
		attributes.put("invitationId", getInvitationId());
		attributes.put("organisationId", getOrganisationId());
		attributes.put("userId", getUserId());
		attributes.put("lastchanged", getLastchanged());
		attributes.put("lastchanger", getLastchanger());
		attributes.put("reactdate", getReactdate());
		attributes.put("lastusedlink", getLastusedlink());
		attributes.put("rejectdate", getRejectdate());
		attributes.put("securitylinktoken", getSecuritylinktoken());
		attributes.put("securitytoken", getSecuritytoken());
		attributes.put("status", getStatus());
		attributes.put("statusdate", getStatusdate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long invitationOrganisationId = (Long)attributes.get(
				"invitationOrganisationId");

		if (invitationOrganisationId != null) {
			setInvitationOrganisationId(invitationOrganisationId);
		}

		Long invitationId = (Long)attributes.get("invitationId");

		if (invitationId != null) {
			setInvitationId(invitationId);
		}

		Long organisationId = (Long)attributes.get("organisationId");

		if (organisationId != null) {
			setOrganisationId(organisationId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date lastchanged = (Date)attributes.get("lastchanged");

		if (lastchanged != null) {
			setLastchanged(lastchanged);
		}

		Long lastchanger = (Long)attributes.get("lastchanger");

		if (lastchanger != null) {
			setLastchanger(lastchanger);
		}

		Date reactdate = (Date)attributes.get("reactdate");

		if (reactdate != null) {
			setReactdate(reactdate);
		}

		Date lastusedlink = (Date)attributes.get("lastusedlink");

		if (lastusedlink != null) {
			setLastusedlink(lastusedlink);
		}

		Date rejectdate = (Date)attributes.get("rejectdate");

		if (rejectdate != null) {
			setRejectdate(rejectdate);
		}

		Long securitylinktoken = (Long)attributes.get("securitylinktoken");

		if (securitylinktoken != null) {
			setSecuritylinktoken(securitylinktoken);
		}

		Long securitytoken = (Long)attributes.get("securitytoken");

		if (securitytoken != null) {
			setSecuritytoken(securitytoken);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date statusdate = (Date)attributes.get("statusdate");

		if (statusdate != null) {
			setStatusdate(statusdate);
		}
	}

	@Override
	public long getInvitationOrganisationId() {
		return _invitationOrganisationId;
	}

	@Override
	public void setInvitationOrganisationId(long invitationOrganisationId) {
		_invitationOrganisationId = invitationOrganisationId;

		if (_invitationOrganisationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationOrganisationRemoteModel.getClass();

				Method method = clazz.getMethod("setInvitationOrganisationId",
						long.class);

				method.invoke(_invitationOrganisationRemoteModel,
					invitationOrganisationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInvitationId() {
		return _invitationId;
	}

	@Override
	public void setInvitationId(long invitationId) {
		_invitationId = invitationId;

		if (_invitationOrganisationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationOrganisationRemoteModel.getClass();

				Method method = clazz.getMethod("setInvitationId", long.class);

				method.invoke(_invitationOrganisationRemoteModel, invitationId);
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

		if (_invitationOrganisationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationOrganisationRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganisationId", long.class);

				method.invoke(_invitationOrganisationRemoteModel, organisationId);
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

		if (_invitationOrganisationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationOrganisationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_invitationOrganisationRemoteModel, userId);
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
	public Date getLastchanged() {
		return _lastchanged;
	}

	@Override
	public void setLastchanged(Date lastchanged) {
		_lastchanged = lastchanged;

		if (_invitationOrganisationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationOrganisationRemoteModel.getClass();

				Method method = clazz.getMethod("setLastchanged", Date.class);

				method.invoke(_invitationOrganisationRemoteModel, lastchanged);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLastchanger() {
		return _lastchanger;
	}

	@Override
	public void setLastchanger(long lastchanger) {
		_lastchanger = lastchanger;

		if (_invitationOrganisationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationOrganisationRemoteModel.getClass();

				Method method = clazz.getMethod("setLastchanger", long.class);

				method.invoke(_invitationOrganisationRemoteModel, lastchanger);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getReactdate() {
		return _reactdate;
	}

	@Override
	public void setReactdate(Date reactdate) {
		_reactdate = reactdate;

		if (_invitationOrganisationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationOrganisationRemoteModel.getClass();

				Method method = clazz.getMethod("setReactdate", Date.class);

				method.invoke(_invitationOrganisationRemoteModel, reactdate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastusedlink() {
		return _lastusedlink;
	}

	@Override
	public void setLastusedlink(Date lastusedlink) {
		_lastusedlink = lastusedlink;

		if (_invitationOrganisationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationOrganisationRemoteModel.getClass();

				Method method = clazz.getMethod("setLastusedlink", Date.class);

				method.invoke(_invitationOrganisationRemoteModel, lastusedlink);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getRejectdate() {
		return _rejectdate;
	}

	@Override
	public void setRejectdate(Date rejectdate) {
		_rejectdate = rejectdate;

		if (_invitationOrganisationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationOrganisationRemoteModel.getClass();

				Method method = clazz.getMethod("setRejectdate", Date.class);

				method.invoke(_invitationOrganisationRemoteModel, rejectdate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSecuritylinktoken() {
		return _securitylinktoken;
	}

	@Override
	public void setSecuritylinktoken(long securitylinktoken) {
		_securitylinktoken = securitylinktoken;

		if (_invitationOrganisationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationOrganisationRemoteModel.getClass();

				Method method = clazz.getMethod("setSecuritylinktoken",
						long.class);

				method.invoke(_invitationOrganisationRemoteModel,
					securitylinktoken);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSecuritytoken() {
		return _securitytoken;
	}

	@Override
	public void setSecuritytoken(long securitytoken) {
		_securitytoken = securitytoken;

		if (_invitationOrganisationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationOrganisationRemoteModel.getClass();

				Method method = clazz.getMethod("setSecuritytoken", long.class);

				method.invoke(_invitationOrganisationRemoteModel, securitytoken);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStatus() {
		return _status;
	}

	@Override
	public void setStatus(long status) {
		_status = status;

		if (_invitationOrganisationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationOrganisationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", long.class);

				method.invoke(_invitationOrganisationRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStatusdate() {
		return _statusdate;
	}

	@Override
	public void setStatusdate(Date statusdate) {
		_statusdate = statusdate;

		if (_invitationOrganisationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationOrganisationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusdate", Date.class);

				method.invoke(_invitationOrganisationRemoteModel, statusdate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getInvitationOrganisationRemoteModel() {
		return _invitationOrganisationRemoteModel;
	}

	public void setInvitationOrganisationRemoteModel(
		BaseModel<?> invitationOrganisationRemoteModel) {
		_invitationOrganisationRemoteModel = invitationOrganisationRemoteModel;
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

		Class<?> remoteModelClass = _invitationOrganisationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_invitationOrganisationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			InvitationOrganisationLocalServiceUtil.addInvitationOrganisation(this);
		}
		else {
			InvitationOrganisationLocalServiceUtil.updateInvitationOrganisation(this);
		}
	}

	@Override
	public InvitationOrganisation toEscapedModel() {
		return (InvitationOrganisation)ProxyUtil.newProxyInstance(InvitationOrganisation.class.getClassLoader(),
			new Class[] { InvitationOrganisation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InvitationOrganisationClp clone = new InvitationOrganisationClp();

		clone.setInvitationOrganisationId(getInvitationOrganisationId());
		clone.setInvitationId(getInvitationId());
		clone.setOrganisationId(getOrganisationId());
		clone.setUserId(getUserId());
		clone.setLastchanged(getLastchanged());
		clone.setLastchanger(getLastchanger());
		clone.setReactdate(getReactdate());
		clone.setLastusedlink(getLastusedlink());
		clone.setRejectdate(getRejectdate());
		clone.setSecuritylinktoken(getSecuritylinktoken());
		clone.setSecuritytoken(getSecuritytoken());
		clone.setStatus(getStatus());
		clone.setStatusdate(getStatusdate());

		return clone;
	}

	@Override
	public int compareTo(InvitationOrganisation invitationOrganisation) {
		long primaryKey = invitationOrganisation.getPrimaryKey();

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

		if (!(obj instanceof InvitationOrganisationClp)) {
			return false;
		}

		InvitationOrganisationClp invitationOrganisation = (InvitationOrganisationClp)obj;

		long primaryKey = invitationOrganisation.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{invitationOrganisationId=");
		sb.append(getInvitationOrganisationId());
		sb.append(", invitationId=");
		sb.append(getInvitationId());
		sb.append(", organisationId=");
		sb.append(getOrganisationId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", lastchanged=");
		sb.append(getLastchanged());
		sb.append(", lastchanger=");
		sb.append(getLastchanger());
		sb.append(", reactdate=");
		sb.append(getReactdate());
		sb.append(", lastusedlink=");
		sb.append(getLastusedlink());
		sb.append(", rejectdate=");
		sb.append(getRejectdate());
		sb.append(", securitylinktoken=");
		sb.append(getSecuritylinktoken());
		sb.append(", securitytoken=");
		sb.append(getSecuritytoken());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusdate=");
		sb.append(getStatusdate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>invitationOrganisationId</column-name><column-value><![CDATA[");
		sb.append(getInvitationOrganisationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>invitationId</column-name><column-value><![CDATA[");
		sb.append(getInvitationId());
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
			"<column><column-name>lastchanged</column-name><column-value><![CDATA[");
		sb.append(getLastchanged());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastchanger</column-name><column-value><![CDATA[");
		sb.append(getLastchanger());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reactdate</column-name><column-value><![CDATA[");
		sb.append(getReactdate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastusedlink</column-name><column-value><![CDATA[");
		sb.append(getLastusedlink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rejectdate</column-name><column-value><![CDATA[");
		sb.append(getRejectdate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>securitylinktoken</column-name><column-value><![CDATA[");
		sb.append(getSecuritylinktoken());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>securitytoken</column-name><column-value><![CDATA[");
		sb.append(getSecuritytoken());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusdate</column-name><column-value><![CDATA[");
		sb.append(getStatusdate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _invitationOrganisationId;
	private long _invitationId;
	private long _organisationId;
	private long _userId;
	private String _userUuid;
	private Date _lastchanged;
	private long _lastchanger;
	private Date _reactdate;
	private Date _lastusedlink;
	private Date _rejectdate;
	private long _securitylinktoken;
	private long _securitytoken;
	private long _status;
	private Date _statusdate;
	private BaseModel<?> _invitationOrganisationRemoteModel;
	private Class<?> _clpSerializerClass = at.graz.meduni.liferay.portlet.bibbox.service.service.ClpSerializer.class;
}