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
		return _invitationID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInvitationID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _invitationID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("invitationID", getInvitationID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long invitationID = (Long)attributes.get("invitationID");

		if (invitationID != null) {
			setInvitationID(invitationID);
		}
	}

	@Override
	public long getInvitationID() {
		return _invitationID;
	}

	@Override
	public void setInvitationID(long invitationID) {
		_invitationID = invitationID;

		if (_invitationRemoteModel != null) {
			try {
				Class<?> clazz = _invitationRemoteModel.getClass();

				Method method = clazz.getMethod("setInvitationID", long.class);

				method.invoke(_invitationRemoteModel, invitationID);
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

		clone.setInvitationID(getInvitationID());

		return clone;
	}

	@Override
	public int compareTo(Invitation invitation) {
		long primaryKey = invitation.getPrimaryKey();

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
		StringBundler sb = new StringBundler(3);

		sb.append("{invitationID=");
		sb.append(getInvitationID());

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(7);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>invitationID</column-name><column-value><![CDATA[");
		sb.append(getInvitationID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _invitationID;
	private BaseModel<?> _invitationRemoteModel;
}