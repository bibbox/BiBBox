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

import at.graz.hmmc.liferay.portlet.puch.model.Person;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Person in entity cache.
 *
 * @author reihsr
 * @see Person
 * @generated
 */
public class PersonCacheModel implements CacheModel<Person>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{personId=");
		sb.append(personId);
		sb.append(", createrUserId=");
		sb.append(createrUserId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedUserId=");
		sb.append(modifiedUserId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", vorname=");
		sb.append(vorname);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Person toEntityModel() {
		PersonImpl personImpl = new PersonImpl();

		personImpl.setPersonId(personId);
		personImpl.setCreaterUserId(createrUserId);

		if (createDate == Long.MIN_VALUE) {
			personImpl.setCreateDate(null);
		}
		else {
			personImpl.setCreateDate(new Date(createDate));
		}

		personImpl.setModifiedUserId(modifiedUserId);

		if (modifiedDate == Long.MIN_VALUE) {
			personImpl.setModifiedDate(null);
		}
		else {
			personImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (vorname == null) {
			personImpl.setVorname(StringPool.BLANK);
		}
		else {
			personImpl.setVorname(vorname);
		}

		personImpl.resetOriginalValues();

		return personImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		personId = objectInput.readLong();
		createrUserId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedUserId = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		vorname = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(personId);
		objectOutput.writeLong(createrUserId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedUserId);
		objectOutput.writeLong(modifiedDate);

		if (vorname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(vorname);
		}
	}

	public long personId;
	public long createrUserId;
	public long createDate;
	public long modifiedUserId;
	public long modifiedDate;
	public String vorname;
}