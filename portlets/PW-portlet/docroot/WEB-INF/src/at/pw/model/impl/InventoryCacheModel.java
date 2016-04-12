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

package at.pw.model.impl;

import at.pw.model.Inventory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Inventory in entity cache.
 *
 * @author reihsr
 * @see Inventory
 * @generated
 */
public class InventoryCacheModel implements CacheModel<Inventory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{inventoryId=");
		sb.append(inventoryId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", inventarnummer=");
		sb.append(inventarnummer);
		sb.append(", webcontentId=");
		sb.append(webcontentId);
		sb.append(", folderId=");
		sb.append(folderId);
		sb.append(", structureId=");
		sb.append(structureId);
		sb.append(", structuretemplateId=");
		sb.append(structuretemplateId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Inventory toEntityModel() {
		InventoryImpl inventoryImpl = new InventoryImpl();

		inventoryImpl.setInventoryId(inventoryId);

		if (createDate == Long.MIN_VALUE) {
			inventoryImpl.setCreateDate(null);
		}
		else {
			inventoryImpl.setCreateDate(new Date(createDate));
		}

		inventoryImpl.setInventarnummer(inventarnummer);
		inventoryImpl.setWebcontentId(webcontentId);
		inventoryImpl.setFolderId(folderId);

		if (structureId == null) {
			inventoryImpl.setStructureId(StringPool.BLANK);
		}
		else {
			inventoryImpl.setStructureId(structureId);
		}

		if (structuretemplateId == null) {
			inventoryImpl.setStructuretemplateId(StringPool.BLANK);
		}
		else {
			inventoryImpl.setStructuretemplateId(structuretemplateId);
		}

		inventoryImpl.resetOriginalValues();

		return inventoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		inventoryId = objectInput.readLong();
		createDate = objectInput.readLong();
		inventarnummer = objectInput.readLong();
		webcontentId = objectInput.readLong();
		folderId = objectInput.readLong();
		structureId = objectInput.readUTF();
		structuretemplateId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(inventoryId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(inventarnummer);
		objectOutput.writeLong(webcontentId);
		objectOutput.writeLong(folderId);

		if (structureId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(structureId);
		}

		if (structuretemplateId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(structuretemplateId);
		}
	}

	public long inventoryId;
	public long createDate;
	public long inventarnummer;
	public long webcontentId;
	public long folderId;
	public String structureId;
	public String structuretemplateId;
}