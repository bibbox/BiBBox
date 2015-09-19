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

import at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Logapi in entity cache.
 *
 * @author reihsr
 * @see Logapi
 * @generated
 */
public class LogapiCacheModel implements CacheModel<Logapi>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{logapiId=");
		sb.append(logapiId);
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
	public Logapi toEntityModel() {
		LogapiImpl logapiImpl = new LogapiImpl();

		logapiImpl.setLogapiId(logapiId);
		logapiImpl.setUserId(userId);

		if (userip == null) {
			logapiImpl.setUserip(StringPool.BLANK);
		}
		else {
			logapiImpl.setUserip(userip);
		}

		if (logmsg == null) {
			logapiImpl.setLogmsg(StringPool.BLANK);
		}
		else {
			logapiImpl.setLogmsg(logmsg);
		}

		if (date == Long.MIN_VALUE) {
			logapiImpl.setDate(null);
		}
		else {
			logapiImpl.setDate(new Date(date));
		}

		logapiImpl.resetOriginalValues();

		return logapiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		logapiId = objectInput.readLong();
		userId = objectInput.readLong();
		userip = objectInput.readUTF();
		logmsg = objectInput.readUTF();
		date = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(logapiId);
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

	public long logapiId;
	public long userId;
	public String userip;
	public String logmsg;
	public long date;
}