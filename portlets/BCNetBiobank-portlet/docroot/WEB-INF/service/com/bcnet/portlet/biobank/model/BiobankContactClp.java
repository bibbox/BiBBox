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

package com.bcnet.portlet.biobank.model;

import com.bcnet.portlet.biobank.service.BiobankContactLocalServiceUtil;
import com.bcnet.portlet.biobank.service.ClpSerializer;
import com.bcnet.portlet.biobank.service.persistence.BiobankContactPK;

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
 * @author suyama
 */
public class BiobankContactClp extends BaseModelImpl<BiobankContact>
	implements BiobankContact {
	public BiobankContactClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BiobankContact.class;
	}

	@Override
	public String getModelClassName() {
		return BiobankContact.class.getName();
	}

	@Override
	public BiobankContactPK getPrimaryKey() {
		return new BiobankContactPK(_biobankDbId, _contactId);
	}

	@Override
	public void setPrimaryKey(BiobankContactPK primaryKey) {
		setBiobankDbId(primaryKey.biobankDbId);
		setContactId(primaryKey.contactId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new BiobankContactPK(_biobankDbId, _contactId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((BiobankContactPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("biobankDbId", getBiobankDbId());
		attributes.put("contactId", getContactId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long biobankDbId = (Long)attributes.get("biobankDbId");

		if (biobankDbId != null) {
			setBiobankDbId(biobankDbId);
		}

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}
	}

	@Override
	public long getBiobankDbId() {
		return _biobankDbId;
	}

	@Override
	public void setBiobankDbId(long biobankDbId) {
		_biobankDbId = biobankDbId;

		if (_biobankContactRemoteModel != null) {
			try {
				Class<?> clazz = _biobankContactRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankDbId", long.class);

				method.invoke(_biobankContactRemoteModel, biobankDbId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContactId() {
		return _contactId;
	}

	@Override
	public void setContactId(long contactId) {
		_contactId = contactId;

		if (_biobankContactRemoteModel != null) {
			try {
				Class<?> clazz = _biobankContactRemoteModel.getClass();

				Method method = clazz.getMethod("setContactId", long.class);

				method.invoke(_biobankContactRemoteModel, contactId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBiobankContactRemoteModel() {
		return _biobankContactRemoteModel;
	}

	public void setBiobankContactRemoteModel(
		BaseModel<?> biobankContactRemoteModel) {
		_biobankContactRemoteModel = biobankContactRemoteModel;
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

		Class<?> remoteModelClass = _biobankContactRemoteModel.getClass();

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

		Object returnValue = method.invoke(_biobankContactRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BiobankContactLocalServiceUtil.addBiobankContact(this);
		}
		else {
			BiobankContactLocalServiceUtil.updateBiobankContact(this);
		}
	}

	@Override
	public BiobankContact toEscapedModel() {
		return (BiobankContact)ProxyUtil.newProxyInstance(BiobankContact.class.getClassLoader(),
			new Class[] { BiobankContact.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BiobankContactClp clone = new BiobankContactClp();

		clone.setBiobankDbId(getBiobankDbId());
		clone.setContactId(getContactId());

		return clone;
	}

	@Override
	public int compareTo(BiobankContact biobankContact) {
		BiobankContactPK primaryKey = biobankContact.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BiobankContactClp)) {
			return false;
		}

		BiobankContactClp biobankContact = (BiobankContactClp)obj;

		BiobankContactPK primaryKey = biobankContact.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{biobankDbId=");
		sb.append(getBiobankDbId());
		sb.append(", contactId=");
		sb.append(getContactId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.bcnet.portlet.biobank.model.BiobankContact");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>biobankDbId</column-name><column-value><![CDATA[");
		sb.append(getBiobankDbId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _biobankDbId;
	private long _contactId;
	private BaseModel<?> _biobankContactRemoteModel;
}