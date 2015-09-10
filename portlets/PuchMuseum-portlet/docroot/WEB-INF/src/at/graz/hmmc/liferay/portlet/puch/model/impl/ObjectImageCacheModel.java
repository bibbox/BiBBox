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

package at.graz.hmmc.liferay.portlet.puch.model.impl;

import at.graz.hmmc.liferay.portlet.puch.model.ObjectImage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ObjectImage in entity cache.
 *
 * @author reihsr
 * @see ObjectImage
 * @generated
 */
public class ObjectImageCacheModel implements CacheModel<ObjectImage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{objectimageId=");
		sb.append(objectimageId);
		sb.append(", puchmuseumsobjectId=");
		sb.append(puchmuseumsobjectId);
		sb.append(", createrUserId=");
		sb.append(createrUserId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedUserId=");
		sb.append(modifiedUserId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", dlappimagerawId=");
		sb.append(dlappimagerawId);
		sb.append(", dlappimageprocessedId=");
		sb.append(dlappimageprocessedId);
		sb.append(", dlappimagewebId=");
		sb.append(dlappimagewebId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ObjectImage toEntityModel() {
		ObjectImageImpl objectImageImpl = new ObjectImageImpl();

		objectImageImpl.setObjectimageId(objectimageId);
		objectImageImpl.setPuchmuseumsobjectId(puchmuseumsobjectId);
		objectImageImpl.setCreaterUserId(createrUserId);

		if (createDate == Long.MIN_VALUE) {
			objectImageImpl.setCreateDate(null);
		}
		else {
			objectImageImpl.setCreateDate(new Date(createDate));
		}

		objectImageImpl.setModifiedUserId(modifiedUserId);

		if (modifiedDate == Long.MIN_VALUE) {
			objectImageImpl.setModifiedDate(null);
		}
		else {
			objectImageImpl.setModifiedDate(new Date(modifiedDate));
		}

		objectImageImpl.setDlappimagerawId(dlappimagerawId);
		objectImageImpl.setDlappimageprocessedId(dlappimageprocessedId);
		objectImageImpl.setDlappimagewebId(dlappimagewebId);

		objectImageImpl.resetOriginalValues();

		return objectImageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		objectimageId = objectInput.readLong();
		puchmuseumsobjectId = objectInput.readLong();
		createrUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dlappimagerawId = objectInput.readLong();
		dlappimageprocessedId = objectInput.readLong();
		dlappimagewebId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(objectimageId);
		objectOutput.writeLong(puchmuseumsobjectId);
		objectOutput.writeLong(createrUserId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedUserId);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(dlappimagerawId);
		objectOutput.writeLong(dlappimageprocessedId);
		objectOutput.writeLong(dlappimagewebId);
	}

	public long objectimageId;
	public long puchmuseumsobjectId;
	public long createrUserId;
	public long createDate;
	public long modifiedUserId;
	public long modifiedDate;
	public long dlappimagerawId;
	public long dlappimageprocessedId;
	public long dlappimagewebId;
}