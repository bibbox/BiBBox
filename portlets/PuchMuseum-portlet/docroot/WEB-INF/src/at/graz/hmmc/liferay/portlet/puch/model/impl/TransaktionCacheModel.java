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

import at.graz.hmmc.liferay.portlet.puch.model.Transaktion;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Transaktion in entity cache.
 *
 * @author reihsr
 * @see Transaktion
 * @generated
 */
public class TransaktionCacheModel implements CacheModel<Transaktion>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{transaktionId=");
		sb.append(transaktionId);
		sb.append(", createrUserId=");
		sb.append(createrUserId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedUserId=");
		sb.append(modifiedUserId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", typ=");
		sb.append(typ);
		sb.append(", puchmuseumsobjectId=");
		sb.append(puchmuseumsobjectId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Transaktion toEntityModel() {
		TransaktionImpl transaktionImpl = new TransaktionImpl();

		transaktionImpl.setTransaktionId(transaktionId);
		transaktionImpl.setCreaterUserId(createrUserId);

		if (createDate == Long.MIN_VALUE) {
			transaktionImpl.setCreateDate(null);
		}
		else {
			transaktionImpl.setCreateDate(new Date(createDate));
		}

		transaktionImpl.setModifiedUserId(modifiedUserId);

		if (modifiedDate == Long.MIN_VALUE) {
			transaktionImpl.setModifiedDate(null);
		}
		else {
			transaktionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (typ == null) {
			transaktionImpl.setTyp(StringPool.BLANK);
		}
		else {
			transaktionImpl.setTyp(typ);
		}

		transaktionImpl.setPuchmuseumsobjectId(puchmuseumsobjectId);

		if (startDate == Long.MIN_VALUE) {
			transaktionImpl.setStartDate(null);
		}
		else {
			transaktionImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			transaktionImpl.setEndDate(null);
		}
		else {
			transaktionImpl.setEndDate(new Date(endDate));
		}

		transaktionImpl.resetOriginalValues();

		return transaktionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		transaktionId = objectInput.readLong();
		createrUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		typ = objectInput.readUTF();
		puchmuseumsobjectId = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(transaktionId);
		objectOutput.writeLong(createrUserId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedUserId);
		objectOutput.writeLong(modifiedDate);

		if (typ == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typ);
		}

		objectOutput.writeLong(puchmuseumsobjectId);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
	}

	public long transaktionId;
	public long createrUserId;
	public long createDate;
	public long modifiedUserId;
	public long modifiedDate;
	public String typ;
	public long puchmuseumsobjectId;
	public long startDate;
	public long endDate;
}