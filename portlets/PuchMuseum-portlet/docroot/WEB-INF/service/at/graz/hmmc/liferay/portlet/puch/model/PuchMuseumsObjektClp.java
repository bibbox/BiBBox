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

package at.graz.hmmc.liferay.portlet.puch.model;

import at.graz.hmmc.liferay.portlet.puch.service.ClpSerializer;
import at.graz.hmmc.liferay.portlet.puch.service.PuchMuseumsObjektLocalServiceUtil;

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
public class PuchMuseumsObjektClp extends BaseModelImpl<PuchMuseumsObjekt>
	implements PuchMuseumsObjekt {
	public PuchMuseumsObjektClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PuchMuseumsObjekt.class;
	}

	@Override
	public String getModelClassName() {
		return PuchMuseumsObjekt.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _puchmuseumsobjectId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPuchmuseumsobjectId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _puchmuseumsobjectId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("puchmuseumsobjectId", getPuchmuseumsobjectId());
		attributes.put("createrUserId", getCreaterUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("objekttyp", getObjekttyp());
		attributes.put("objektid", getObjektid());
		attributes.put("folder", getFolder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long puchmuseumsobjectId = (Long)attributes.get("puchmuseumsobjectId");

		if (puchmuseumsobjectId != null) {
			setPuchmuseumsobjectId(puchmuseumsobjectId);
		}

		Long createrUserId = (Long)attributes.get("createrUserId");

		if (createrUserId != null) {
			setCreaterUserId(createrUserId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedUserId = (Long)attributes.get("modifiedUserId");

		if (modifiedUserId != null) {
			setModifiedUserId(modifiedUserId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String objekttyp = (String)attributes.get("objekttyp");

		if (objekttyp != null) {
			setObjekttyp(objekttyp);
		}

		Long objektid = (Long)attributes.get("objektid");

		if (objektid != null) {
			setObjektid(objektid);
		}

		String folder = (String)attributes.get("folder");

		if (folder != null) {
			setFolder(folder);
		}
	}

	@Override
	public long getPuchmuseumsobjectId() {
		return _puchmuseumsobjectId;
	}

	@Override
	public void setPuchmuseumsobjectId(long puchmuseumsobjectId) {
		_puchmuseumsobjectId = puchmuseumsobjectId;

		if (_puchMuseumsObjektRemoteModel != null) {
			try {
				Class<?> clazz = _puchMuseumsObjektRemoteModel.getClass();

				Method method = clazz.getMethod("setPuchmuseumsobjectId",
						long.class);

				method.invoke(_puchMuseumsObjektRemoteModel, puchmuseumsobjectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreaterUserId() {
		return _createrUserId;
	}

	@Override
	public void setCreaterUserId(long createrUserId) {
		_createrUserId = createrUserId;

		if (_puchMuseumsObjektRemoteModel != null) {
			try {
				Class<?> clazz = _puchMuseumsObjektRemoteModel.getClass();

				Method method = clazz.getMethod("setCreaterUserId", long.class);

				method.invoke(_puchMuseumsObjektRemoteModel, createrUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreaterUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getCreaterUserId(), "uuid",
			_createrUserUuid);
	}

	@Override
	public void setCreaterUserUuid(String createrUserUuid) {
		_createrUserUuid = createrUserUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_puchMuseumsObjektRemoteModel != null) {
			try {
				Class<?> clazz = _puchMuseumsObjektRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_puchMuseumsObjektRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;

		if (_puchMuseumsObjektRemoteModel != null) {
			try {
				Class<?> clazz = _puchMuseumsObjektRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedUserId", long.class);

				method.invoke(_puchMuseumsObjektRemoteModel, modifiedUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModifiedUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getModifiedUserId(), "uuid",
			_modifiedUserUuid);
	}

	@Override
	public void setModifiedUserUuid(String modifiedUserUuid) {
		_modifiedUserUuid = modifiedUserUuid;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_puchMuseumsObjektRemoteModel != null) {
			try {
				Class<?> clazz = _puchMuseumsObjektRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_puchMuseumsObjektRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getObjekttyp() {
		return _objekttyp;
	}

	@Override
	public void setObjekttyp(String objekttyp) {
		_objekttyp = objekttyp;

		if (_puchMuseumsObjektRemoteModel != null) {
			try {
				Class<?> clazz = _puchMuseumsObjektRemoteModel.getClass();

				Method method = clazz.getMethod("setObjekttyp", String.class);

				method.invoke(_puchMuseumsObjektRemoteModel, objekttyp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getObjektid() {
		return _objektid;
	}

	@Override
	public void setObjektid(long objektid) {
		_objektid = objektid;

		if (_puchMuseumsObjektRemoteModel != null) {
			try {
				Class<?> clazz = _puchMuseumsObjektRemoteModel.getClass();

				Method method = clazz.getMethod("setObjektid", long.class);

				method.invoke(_puchMuseumsObjektRemoteModel, objektid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFolder() {
		return _folder;
	}

	@Override
	public void setFolder(String folder) {
		_folder = folder;

		if (_puchMuseumsObjektRemoteModel != null) {
			try {
				Class<?> clazz = _puchMuseumsObjektRemoteModel.getClass();

				Method method = clazz.getMethod("setFolder", String.class);

				method.invoke(_puchMuseumsObjektRemoteModel, folder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getHTMLSummery() {
		try {
			String methodName = "getHTMLSummery";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getPuchMuseumsObjektRemoteModel() {
		return _puchMuseumsObjektRemoteModel;
	}

	public void setPuchMuseumsObjektRemoteModel(
		BaseModel<?> puchMuseumsObjektRemoteModel) {
		_puchMuseumsObjektRemoteModel = puchMuseumsObjektRemoteModel;
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

		Class<?> remoteModelClass = _puchMuseumsObjektRemoteModel.getClass();

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

		Object returnValue = method.invoke(_puchMuseumsObjektRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PuchMuseumsObjektLocalServiceUtil.addPuchMuseumsObjekt(this);
		}
		else {
			PuchMuseumsObjektLocalServiceUtil.updatePuchMuseumsObjekt(this);
		}
	}

	@Override
	public PuchMuseumsObjekt toEscapedModel() {
		return (PuchMuseumsObjekt)ProxyUtil.newProxyInstance(PuchMuseumsObjekt.class.getClassLoader(),
			new Class[] { PuchMuseumsObjekt.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PuchMuseumsObjektClp clone = new PuchMuseumsObjektClp();

		clone.setPuchmuseumsobjectId(getPuchmuseumsobjectId());
		clone.setCreaterUserId(getCreaterUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedUserId(getModifiedUserId());
		clone.setModifiedDate(getModifiedDate());
		clone.setObjekttyp(getObjekttyp());
		clone.setObjektid(getObjektid());
		clone.setFolder(getFolder());

		return clone;
	}

	@Override
	public int compareTo(PuchMuseumsObjekt puchMuseumsObjekt) {
		long primaryKey = puchMuseumsObjekt.getPrimaryKey();

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

		if (!(obj instanceof PuchMuseumsObjektClp)) {
			return false;
		}

		PuchMuseumsObjektClp puchMuseumsObjekt = (PuchMuseumsObjektClp)obj;

		long primaryKey = puchMuseumsObjekt.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{puchmuseumsobjectId=");
		sb.append(getPuchmuseumsobjectId());
		sb.append(", createrUserId=");
		sb.append(getCreaterUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedUserId=");
		sb.append(getModifiedUserId());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", objekttyp=");
		sb.append(getObjekttyp());
		sb.append(", objektid=");
		sb.append(getObjektid());
		sb.append(", folder=");
		sb.append(getFolder());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>puchmuseumsobjectId</column-name><column-value><![CDATA[");
		sb.append(getPuchmuseumsobjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createrUserId</column-name><column-value><![CDATA[");
		sb.append(getCreaterUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedUserId</column-name><column-value><![CDATA[");
		sb.append(getModifiedUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>objekttyp</column-name><column-value><![CDATA[");
		sb.append(getObjekttyp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>objektid</column-name><column-value><![CDATA[");
		sb.append(getObjektid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folder</column-name><column-value><![CDATA[");
		sb.append(getFolder());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _puchmuseumsobjectId;
	private long _createrUserId;
	private String _createrUserUuid;
	private Date _createDate;
	private long _modifiedUserId;
	private String _modifiedUserUuid;
	private Date _modifiedDate;
	private String _objekttyp;
	private long _objektid;
	private String _folder;
	private BaseModel<?> _puchMuseumsObjektRemoteModel;
}