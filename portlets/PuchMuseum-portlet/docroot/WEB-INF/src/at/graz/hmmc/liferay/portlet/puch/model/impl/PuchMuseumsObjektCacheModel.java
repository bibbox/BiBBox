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

import at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PuchMuseumsObjekt in entity cache.
 *
 * @author reihsr
 * @see PuchMuseumsObjekt
 * @generated
 */
public class PuchMuseumsObjektCacheModel implements CacheModel<PuchMuseumsObjekt>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{puchmuseumsobjectId=");
		sb.append(puchmuseumsobjectId);
		sb.append(", createrUserId=");
		sb.append(createrUserId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedUserId=");
		sb.append(modifiedUserId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", objekttyp=");
		sb.append(objekttyp);
		sb.append(", objektid=");
		sb.append(objektid);
		sb.append(", folder=");
		sb.append(folder);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PuchMuseumsObjekt toEntityModel() {
		PuchMuseumsObjektImpl puchMuseumsObjektImpl = new PuchMuseumsObjektImpl();

		puchMuseumsObjektImpl.setPuchmuseumsobjectId(puchmuseumsobjectId);
		puchMuseumsObjektImpl.setCreaterUserId(createrUserId);

		if (createDate == Long.MIN_VALUE) {
			puchMuseumsObjektImpl.setCreateDate(null);
		}
		else {
			puchMuseumsObjektImpl.setCreateDate(new Date(createDate));
		}

		puchMuseumsObjektImpl.setModifiedUserId(modifiedUserId);

		if (modifiedDate == Long.MIN_VALUE) {
			puchMuseumsObjektImpl.setModifiedDate(null);
		}
		else {
			puchMuseumsObjektImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (objekttyp == null) {
			puchMuseumsObjektImpl.setObjekttyp(StringPool.BLANK);
		}
		else {
			puchMuseumsObjektImpl.setObjekttyp(objekttyp);
		}

		puchMuseumsObjektImpl.setObjektid(objektid);
		puchMuseumsObjektImpl.setFolder(folder);

		puchMuseumsObjektImpl.resetOriginalValues();

		return puchMuseumsObjektImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		puchmuseumsobjectId = objectInput.readLong();
		createrUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		objekttyp = objectInput.readUTF();
		objektid = objectInput.readLong();
		folder = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(puchmuseumsobjectId);
		objectOutput.writeLong(createrUserId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedUserId);
		objectOutput.writeLong(modifiedDate);

		if (objekttyp == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(objekttyp);
		}

		objectOutput.writeLong(objektid);
		objectOutput.writeLong(folder);
	}

	public long puchmuseumsobjectId;
	public long createrUserId;
	public long createDate;
	public long modifiedUserId;
	public long modifiedDate;
	public String objekttyp;
	public long objektid;
	public long folder;
}