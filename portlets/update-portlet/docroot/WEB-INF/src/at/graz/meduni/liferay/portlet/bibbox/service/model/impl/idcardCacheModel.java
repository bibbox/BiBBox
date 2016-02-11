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

package at.graz.meduni.liferay.portlet.bibbox.service.model.impl;

import at.graz.meduni.liferay.portlet.bibbox.service.model.idcard;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing idcard in entity cache.
 *
 * @author reihsr
 * @see idcard
 * @generated
 */
public class idcardCacheModel implements CacheModel<idcard>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{idcardId=");
		sb.append(idcardId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userip=");
		sb.append(userip);
		sb.append(", logmsg=");
		sb.append(logmsg);
		sb.append(", date=");
		sb.append(date);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public idcard toEntityModel() {
		idcardImpl idcardImpl = new idcardImpl();

		idcardImpl.setIdcardId(idcardId);
		idcardImpl.setUserId(userId);

		if (userip == null) {
			idcardImpl.setUserip(StringPool.BLANK);
		}
		else {
			idcardImpl.setUserip(userip);
		}

		if (logmsg == null) {
			idcardImpl.setLogmsg(StringPool.BLANK);
		}
		else {
			idcardImpl.setLogmsg(logmsg);
		}

		if (date == Long.MIN_VALUE) {
			idcardImpl.setDate(null);
		}
		else {
			idcardImpl.setDate(new Date(date));
		}

		idcardImpl.resetOriginalValues();

		return idcardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idcardId = objectInput.readLong();
		userId = objectInput.readLong();
		userip = objectInput.readUTF();
		logmsg = objectInput.readUTF();
		date = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(idcardId);
		objectOutput.writeLong(userId);

		if (userip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userip);
		}

		if (logmsg == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(logmsg);
		}

		objectOutput.writeLong(date);
	}

	public long idcardId;
	public long userId;
	public String userip;
	public String logmsg;
	public long date;
}