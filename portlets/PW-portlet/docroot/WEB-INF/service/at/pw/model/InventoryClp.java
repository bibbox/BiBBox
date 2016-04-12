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

package at.pw.model;

import at.pw.service.ClpSerializer;
import at.pw.service.InventoryLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
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
public class InventoryClp extends BaseModelImpl<Inventory> implements Inventory {
	public InventoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Inventory.class;
	}

	@Override
	public String getModelClassName() {
		return Inventory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _inventoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInventoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _inventoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("inventoryId", getInventoryId());
		attributes.put("createDate", getCreateDate());
		attributes.put("inventarnummer", getInventarnummer());
		attributes.put("webcontentId", getWebcontentId());
		attributes.put("folderId", getFolderId());
		attributes.put("structureId", getStructureId());
		attributes.put("structuretemplateId", getStructuretemplateId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long inventoryId = (Long)attributes.get("inventoryId");

		if (inventoryId != null) {
			setInventoryId(inventoryId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long inventarnummer = (Long)attributes.get("inventarnummer");

		if (inventarnummer != null) {
			setInventarnummer(inventarnummer);
		}

		Long webcontentId = (Long)attributes.get("webcontentId");

		if (webcontentId != null) {
			setWebcontentId(webcontentId);
		}

		Long folderId = (Long)attributes.get("folderId");

		if (folderId != null) {
			setFolderId(folderId);
		}

		String structureId = (String)attributes.get("structureId");

		if (structureId != null) {
			setStructureId(structureId);
		}

		String structuretemplateId = (String)attributes.get(
				"structuretemplateId");

		if (structuretemplateId != null) {
			setStructuretemplateId(structuretemplateId);
		}
	}

	@Override
	public long getInventoryId() {
		return _inventoryId;
	}

	@Override
	public void setInventoryId(long inventoryId) {
		_inventoryId = inventoryId;

		if (_inventoryRemoteModel != null) {
			try {
				Class<?> clazz = _inventoryRemoteModel.getClass();

				Method method = clazz.getMethod("setInventoryId", long.class);

				method.invoke(_inventoryRemoteModel, inventoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_inventoryRemoteModel != null) {
			try {
				Class<?> clazz = _inventoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_inventoryRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInventarnummer() {
		return _inventarnummer;
	}

	@Override
	public void setInventarnummer(long inventarnummer) {
		_inventarnummer = inventarnummer;

		if (_inventoryRemoteModel != null) {
			try {
				Class<?> clazz = _inventoryRemoteModel.getClass();

				Method method = clazz.getMethod("setInventarnummer", long.class);

				method.invoke(_inventoryRemoteModel, inventarnummer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getWebcontentId() {
		return _webcontentId;
	}

	@Override
	public void setWebcontentId(long webcontentId) {
		_webcontentId = webcontentId;

		if (_inventoryRemoteModel != null) {
			try {
				Class<?> clazz = _inventoryRemoteModel.getClass();

				Method method = clazz.getMethod("setWebcontentId", long.class);

				method.invoke(_inventoryRemoteModel, webcontentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFolderId() {
		return _folderId;
	}

	@Override
	public void setFolderId(long folderId) {
		_folderId = folderId;

		if (_inventoryRemoteModel != null) {
			try {
				Class<?> clazz = _inventoryRemoteModel.getClass();

				Method method = clazz.getMethod("setFolderId", long.class);

				method.invoke(_inventoryRemoteModel, folderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStructureId() {
		return _structureId;
	}

	@Override
	public void setStructureId(String structureId) {
		_structureId = structureId;

		if (_inventoryRemoteModel != null) {
			try {
				Class<?> clazz = _inventoryRemoteModel.getClass();

				Method method = clazz.getMethod("setStructureId", String.class);

				method.invoke(_inventoryRemoteModel, structureId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStructuretemplateId() {
		return _structuretemplateId;
	}

	@Override
	public void setStructuretemplateId(String structuretemplateId) {
		_structuretemplateId = structuretemplateId;

		if (_inventoryRemoteModel != null) {
			try {
				Class<?> clazz = _inventoryRemoteModel.getClass();

				Method method = clazz.getMethod("setStructuretemplateId",
						String.class);

				method.invoke(_inventoryRemoteModel, structuretemplateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getInventoryRemoteModel() {
		return _inventoryRemoteModel;
	}

	public void setInventoryRemoteModel(BaseModel<?> inventoryRemoteModel) {
		_inventoryRemoteModel = inventoryRemoteModel;
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

		Class<?> remoteModelClass = _inventoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_inventoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			InventoryLocalServiceUtil.addInventory(this);
		}
		else {
			InventoryLocalServiceUtil.updateInventory(this);
		}
	}

	@Override
	public Inventory toEscapedModel() {
		return (Inventory)ProxyUtil.newProxyInstance(Inventory.class.getClassLoader(),
			new Class[] { Inventory.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InventoryClp clone = new InventoryClp();

		clone.setInventoryId(getInventoryId());
		clone.setCreateDate(getCreateDate());
		clone.setInventarnummer(getInventarnummer());
		clone.setWebcontentId(getWebcontentId());
		clone.setFolderId(getFolderId());
		clone.setStructureId(getStructureId());
		clone.setStructuretemplateId(getStructuretemplateId());

		return clone;
	}

	@Override
	public int compareTo(Inventory inventory) {
		int value = 0;

		if (getInventoryId() < inventory.getInventoryId()) {
			value = -1;
		}
		else if (getInventoryId() > inventory.getInventoryId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof InventoryClp)) {
			return false;
		}

		InventoryClp inventory = (InventoryClp)obj;

		long primaryKey = inventory.getPrimaryKey();

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

		sb.append("{inventoryId=");
		sb.append(getInventoryId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", inventarnummer=");
		sb.append(getInventarnummer());
		sb.append(", webcontentId=");
		sb.append(getWebcontentId());
		sb.append(", folderId=");
		sb.append(getFolderId());
		sb.append(", structureId=");
		sb.append(getStructureId());
		sb.append(", structuretemplateId=");
		sb.append(getStructuretemplateId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("at.pw.model.Inventory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>inventoryId</column-name><column-value><![CDATA[");
		sb.append(getInventoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inventarnummer</column-name><column-value><![CDATA[");
		sb.append(getInventarnummer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>webcontentId</column-name><column-value><![CDATA[");
		sb.append(getWebcontentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderId</column-name><column-value><![CDATA[");
		sb.append(getFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>structureId</column-name><column-value><![CDATA[");
		sb.append(getStructureId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>structuretemplateId</column-name><column-value><![CDATA[");
		sb.append(getStructuretemplateId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _inventoryId;
	private Date _createDate;
	private long _inventarnummer;
	private long _webcontentId;
	private long _folderId;
	private String _structureId;
	private String _structuretemplateId;
	private BaseModel<?> _inventoryRemoteModel;
}