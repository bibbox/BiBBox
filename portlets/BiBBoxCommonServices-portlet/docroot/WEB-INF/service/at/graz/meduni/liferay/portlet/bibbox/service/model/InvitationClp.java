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
import at.graz.meduni.liferay.portlet.bibbox.service.service.InvitationLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author reihsr
 */
public class InvitationClp extends BaseModelImpl<Invitation>
	implements Invitation {
	public InvitationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Invitation.class;
	}

	@Override
	public String getModelClassName() {
		return Invitation.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _invitationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInvitationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _invitationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("invitationId", getInvitationId());
		attributes.put("name", getName());
		attributes.put("subject", getSubject());
		attributes.put("body", getBody());
		attributes.put("status", getStatus());
		attributes.put("lastchanged", getLastchanged());
		attributes.put("lastchanger", getLastchanger());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long invitationId = (Long)attributes.get("invitationId");

		if (invitationId != null) {
			setInvitationId(invitationId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String body = (String)attributes.get("body");

		if (body != null) {
			setBody(body);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date lastchanged = (Date)attributes.get("lastchanged");

		if (lastchanged != null) {
			setLastchanged(lastchanged);
		}

		Long lastchanger = (Long)attributes.get("lastchanger");

		if (lastchanger != null) {
			setLastchanger(lastchanger);
		}
	}

	@Override
	public long getInvitationId() {
		return _invitationId;
	}

	@Override
	public void setInvitationId(long invitationId) {
		_invitationId = invitationId;

		if (_invitationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationRemoteModel.getClass();

				Method method = clazz.getMethod("setInvitationId", long.class);

				method.invoke(_invitationRemoteModel, invitationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_invitationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_invitationRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubject() {
		return _subject;
	}

	@Override
	public void setSubject(String subject) {
		_subject = subject;

		if (_invitationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationRemoteModel.getClass();

				Method method = clazz.getMethod("setSubject", String.class);

				method.invoke(_invitationRemoteModel, subject);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBody() {
		return _body;
	}

	@Override
	public void setBody(String body) {
		_body = body;

		if (_invitationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationRemoteModel.getClass();

				Method method = clazz.getMethod("setBody", String.class);

				method.invoke(_invitationRemoteModel, body);
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

		if (_invitationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", long.class);

				method.invoke(_invitationRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastchanged() {
		return _lastchanged;
	}

	@Override
	public void setLastchanged(Date lastchanged) {
		_lastchanged = lastchanged;

		if (_invitationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationRemoteModel.getClass();

				Method method = clazz.getMethod("setLastchanged", Date.class);

				method.invoke(_invitationRemoteModel, lastchanged);
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

		if (_invitationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationRemoteModel.getClass();

				Method method = clazz.getMethod("setLastchanger", long.class);

				method.invoke(_invitationRemoteModel, lastchanger);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getInvitationRemoteModel() {
		return _invitationRemoteModel;
	}

	public void setInvitationRemoteModel(BaseModel<?> invitationRemoteModel) {
		_invitationRemoteModel = invitationRemoteModel;
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

		Class<?> remoteModelClass = _invitationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_invitationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			InvitationLocalServiceUtil.addInvitation(this);
		}
		else {
			InvitationLocalServiceUtil.updateInvitation(this);
		}
	}

	@Override
	public Invitation toEscapedModel() {
		return (Invitation)ProxyUtil.newProxyInstance(Invitation.class.getClassLoader(),
			new Class[] { Invitation.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InvitationClp clone = new InvitationClp();

		clone.setInvitationId(getInvitationId());
		clone.setName(getName());
		clone.setSubject(getSubject());
		clone.setBody(getBody());
		clone.setStatus(getStatus());
		clone.setLastchanged(getLastchanged());
		clone.setLastchanger(getLastchanger());

		return clone;
	}

	@Override
	public int compareTo(Invitation invitation) {
		int value = 0;

		value = DateUtil.compareTo(getLastchanged(), invitation.getLastchanged());

		value = value * -1;

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

		if (!(obj instanceof InvitationClp)) {
			return false;
		}

		InvitationClp invitation = (InvitationClp)obj;

		long primaryKey = invitation.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{invitationId=");
		sb.append(getInvitationId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", body=");
		sb.append(getBody());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", lastchanged=");
		sb.append(getLastchanged());
		sb.append(", lastchanger=");
		sb.append(getLastchanger());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>invitationId</column-name><column-value><![CDATA[");
		sb.append(getInvitationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>body</column-name><column-value><![CDATA[");
		sb.append(getBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastchanged</column-name><column-value><![CDATA[");
		sb.append(getLastchanged());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastchanger</column-name><column-value><![CDATA[");
		sb.append(getLastchanger());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _invitationId;
	private String _name;
	private String _subject;
	private String _body;
	private long _status;
	private Date _lastchanged;
	private long _lastchanger;
	private BaseModel<?> _invitationRemoteModel;
}