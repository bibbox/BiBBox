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

package at.meduni.liferay.portlet.bbmrieric.services.model;

import at.meduni.liferay.portlet.bbmrieric.services.service.ClpSerializer;
import at.meduni.liferay.portlet.bbmrieric.services.service.LDAPlogLocalServiceUtil;

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
public class LDAPlogClp extends BaseModelImpl<LDAPlog> implements LDAPlog {
	public LDAPlogClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LDAPlog.class;
	}

	@Override
	public String getModelClassName() {
		return LDAPlog.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _ldaplogId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLdaplogId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ldaplogId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ldaplogId", getLdaplogId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ldaplogId = (Long)attributes.get("ldaplogId");

		if (ldaplogId != null) {
			setLdaplogId(ldaplogId);
		}
	}

	@Override
	public long getLdaplogId() {
		return _ldaplogId;
	}

	@Override
	public void setLdaplogId(long ldaplogId) {
		_ldaplogId = ldaplogId;

		if (_ldaPlogRemoteModel != null) {
			try {
				Class<?> clazz = _ldaPlogRemoteModel.getClass();

				Method method = clazz.getMethod("setLdaplogId", long.class);

				method.invoke(_ldaPlogRemoteModel, ldaplogId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLDAPlogRemoteModel() {
		return _ldaPlogRemoteModel;
	}

	public void setLDAPlogRemoteModel(BaseModel<?> ldaPlogRemoteModel) {
		_ldaPlogRemoteModel = ldaPlogRemoteModel;
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

		Class<?> remoteModelClass = _ldaPlogRemoteModel.getClass();

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

		Object returnValue = method.invoke(_ldaPlogRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LDAPlogLocalServiceUtil.addLDAPlog(this);
		}
		else {
			LDAPlogLocalServiceUtil.updateLDAPlog(this);
		}
	}

	@Override
	public LDAPlog toEscapedModel() {
		return (LDAPlog)ProxyUtil.newProxyInstance(LDAPlog.class.getClassLoader(),
			new Class[] { LDAPlog.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LDAPlogClp clone = new LDAPlogClp();

		clone.setLdaplogId(getLdaplogId());

		return clone;
	}

	@Override
	public int compareTo(LDAPlog ldaPlog) {
		long primaryKey = ldaPlog.getPrimaryKey();

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

		if (!(obj instanceof LDAPlogClp)) {
			return false;
		}

		LDAPlogClp ldaPlog = (LDAPlogClp)obj;

		long primaryKey = ldaPlog.getPrimaryKey();

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

		sb.append("{ldaplogId=");
		sb.append(getLdaplogId());

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(7);

		sb.append("<model><model-name>");
		sb.append("at.meduni.liferay.portlet.bbmrieric.services.model.LDAPlog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ldaplogId</column-name><column-value><![CDATA[");
		sb.append(getLdaplogId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ldaplogId;
	private BaseModel<?> _ldaPlogRemoteModel;
}