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

import at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Fahrzeug in entity cache.
 *
 * @author reihsr
 * @see Fahrzeug
 * @generated
 */
public class FahrzeugCacheModel implements CacheModel<Fahrzeug>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{fahrzeugId=");
		sb.append(fahrzeugId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Fahrzeug toEntityModel() {
		FahrzeugImpl fahrzeugImpl = new FahrzeugImpl();

		fahrzeugImpl.setFahrzeugId(fahrzeugId);
		fahrzeugImpl.setCreaterUserId(createrUserId);

		if (createDate == Long.MIN_VALUE) {
			fahrzeugImpl.setCreateDate(null);
		}
		else {
			fahrzeugImpl.setCreateDate(new Date(createDate));
		}

		fahrzeugImpl.setModifiedUserId(modifiedUserId);

		if (modifiedDate == Long.MIN_VALUE) {
			fahrzeugImpl.setModifiedDate(null);
		}
		else {
			fahrzeugImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (typ == null) {
			fahrzeugImpl.setTyp(StringPool.BLANK);
		}
		else {
			fahrzeugImpl.setTyp(typ);
		}

		fahrzeugImpl.resetOriginalValues();

		return fahrzeugImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fahrzeugId = objectInput.readLong();
		createrUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		typ = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(fahrzeugId);
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
	}

	public long fahrzeugId;
	public long createrUserId;
	public long createDate;
	public long modifiedUserId;
	public long modifiedDate;
	public String typ;
}