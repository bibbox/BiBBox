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

package at.graz.meduni.liferay.portlet.bibbox.model;

import at.graz.meduni.liferay.portlet.bibbox.service.ClpSerializer;
import at.graz.meduni.liferay.portlet.bibbox.service.OrphanetSynonymLocalServiceUtil;

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
public class OrphanetSynonymClp extends BaseModelImpl<OrphanetSynonym>
	implements OrphanetSynonym {
	public OrphanetSynonymClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return OrphanetSynonym.class;
	}

	@Override
	public String getModelClassName() {
		return OrphanetSynonym.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _orphanetsynonymId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOrphanetsynonymId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _orphanetsynonymId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orphanetsynonymId", getOrphanetsynonymId());
		attributes.put("orphanetdisorderId", getOrphanetdisorderId());
		attributes.put("synonym", getSynonym());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long orphanetsynonymId = (Long)attributes.get("orphanetsynonymId");

		if (orphanetsynonymId != null) {
			setOrphanetsynonymId(orphanetsynonymId);
		}

		Long orphanetdisorderId = (Long)attributes.get("orphanetdisorderId");

		if (orphanetdisorderId != null) {
			setOrphanetdisorderId(orphanetdisorderId);
		}

		String synonym = (String)attributes.get("synonym");

		if (synonym != null) {
			setSynonym(synonym);
		}
	}

	@Override
	public long getOrphanetsynonymId() {
		return _orphanetsynonymId;
	}

	@Override
	public void setOrphanetsynonymId(long orphanetsynonymId) {
		_orphanetsynonymId = orphanetsynonymId;

		if (_orphanetSynonymRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetSynonymRemoteModel.getClass();

				Method method = clazz.getMethod("setOrphanetsynonymId",
						long.class);

				method.invoke(_orphanetSynonymRemoteModel, orphanetsynonymId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrphanetdisorderId() {
		return _orphanetdisorderId;
	}

	@Override
	public void setOrphanetdisorderId(long orphanetdisorderId) {
		_orphanetdisorderId = orphanetdisorderId;

		if (_orphanetSynonymRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetSynonymRemoteModel.getClass();

				Method method = clazz.getMethod("setOrphanetdisorderId",
						long.class);

				method.invoke(_orphanetSynonymRemoteModel, orphanetdisorderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSynonym() {
		return _synonym;
	}

	@Override
	public void setSynonym(String synonym) {
		_synonym = synonym;

		if (_orphanetSynonymRemoteModel != null) {
			try {
				Class<?> clazz = _orphanetSynonymRemoteModel.getClass();

				Method method = clazz.getMethod("setSynonym", String.class);

				method.invoke(_orphanetSynonymRemoteModel, synonym);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOrphanetSynonymRemoteModel() {
		return _orphanetSynonymRemoteModel;
	}

	public void setOrphanetSynonymRemoteModel(
		BaseModel<?> orphanetSynonymRemoteModel) {
		_orphanetSynonymRemoteModel = orphanetSynonymRemoteModel;
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

		Class<?> remoteModelClass = _orphanetSynonymRemoteModel.getClass();

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

		Object returnValue = method.invoke(_orphanetSynonymRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OrphanetSynonymLocalServiceUtil.addOrphanetSynonym(this);
		}
		else {
			OrphanetSynonymLocalServiceUtil.updateOrphanetSynonym(this);
		}
	}

	@Override
	public OrphanetSynonym toEscapedModel() {
		return (OrphanetSynonym)ProxyUtil.newProxyInstance(OrphanetSynonym.class.getClassLoader(),
			new Class[] { OrphanetSynonym.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OrphanetSynonymClp clone = new OrphanetSynonymClp();

		clone.setOrphanetsynonymId(getOrphanetsynonymId());
		clone.setOrphanetdisorderId(getOrphanetdisorderId());
		clone.setSynonym(getSynonym());

		return clone;
	}

	@Override
	public int compareTo(OrphanetSynonym orphanetSynonym) {
		long primaryKey = orphanetSynonym.getPrimaryKey();

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

		if (!(obj instanceof OrphanetSynonymClp)) {
			return false;
		}

		OrphanetSynonymClp orphanetSynonym = (OrphanetSynonymClp)obj;

		long primaryKey = orphanetSynonym.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{orphanetsynonymId=");
		sb.append(getOrphanetsynonymId());
		sb.append(", orphanetdisorderId=");
		sb.append(getOrphanetdisorderId());
		sb.append(", synonym=");
		sb.append(getSynonym());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orphanetsynonymId</column-name><column-value><![CDATA[");
		sb.append(getOrphanetsynonymId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orphanetdisorderId</column-name><column-value><![CDATA[");
		sb.append(getOrphanetdisorderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>synonym</column-name><column-value><![CDATA[");
		sb.append(getSynonym());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _orphanetsynonymId;
	private long _orphanetdisorderId;
	private String _synonym;
	private BaseModel<?> _orphanetSynonymRemoteModel;
}