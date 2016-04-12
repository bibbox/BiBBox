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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.pw.service.http.InventoryServiceSoap}.
 *
 * @author reihsr
 * @see at.pw.service.http.InventoryServiceSoap
 * @generated
 */
public class InventorySoap implements Serializable {
	public static InventorySoap toSoapModel(Inventory model) {
		InventorySoap soapModel = new InventorySoap();

		soapModel.setInventoryId(model.getInventoryId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setInventarnummer(model.getInventarnummer());
		soapModel.setWebcontentId(model.getWebcontentId());
		soapModel.setFolderId(model.getFolderId());
		soapModel.setStructureId(model.getStructureId());
		soapModel.setStructuretemplateId(model.getStructuretemplateId());

		return soapModel;
	}

	public static InventorySoap[] toSoapModels(Inventory[] models) {
		InventorySoap[] soapModels = new InventorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InventorySoap[][] toSoapModels(Inventory[][] models) {
		InventorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InventorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new InventorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InventorySoap[] toSoapModels(List<Inventory> models) {
		List<InventorySoap> soapModels = new ArrayList<InventorySoap>(models.size());

		for (Inventory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InventorySoap[soapModels.size()]);
	}

	public InventorySoap() {
	}

	public long getPrimaryKey() {
		return _inventoryId;
	}

	public void setPrimaryKey(long pk) {
		setInventoryId(pk);
	}

	public long getInventoryId() {
		return _inventoryId;
	}

	public void setInventoryId(long inventoryId) {
		_inventoryId = inventoryId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getInventarnummer() {
		return _inventarnummer;
	}

	public void setInventarnummer(long inventarnummer) {
		_inventarnummer = inventarnummer;
	}

	public long getWebcontentId() {
		return _webcontentId;
	}

	public void setWebcontentId(long webcontentId) {
		_webcontentId = webcontentId;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public String getStructureId() {
		return _structureId;
	}

	public void setStructureId(String structureId) {
		_structureId = structureId;
	}

	public String getStructuretemplateId() {
		return _structuretemplateId;
	}

	public void setStructuretemplateId(String structuretemplateId) {
		_structuretemplateId = structuretemplateId;
	}

	private long _inventoryId;
	private Date _createDate;
	private long _inventarnummer;
	private long _webcontentId;
	private long _folderId;
	private String _structureId;
	private String _structuretemplateId;
}