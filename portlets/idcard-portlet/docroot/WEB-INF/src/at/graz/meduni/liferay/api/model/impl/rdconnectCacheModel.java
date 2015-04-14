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

package at.graz.meduni.liferay.api.model.impl;

import at.graz.meduni.liferay.api.model.rdconnect;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing rdconnect in entity cache.
 *
 * @author reihsr
 * @see rdconnect
 * @generated
 */
public class rdconnectCacheModel implements CacheModel<rdconnect>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{idcardapilogId=");
		sb.append(idcardapilogId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", ipaddress=");
		sb.append(ipaddress);
		sb.append(", accessDate=");
		sb.append(accessDate);
		sb.append(", requestparameter=");
		sb.append(requestparameter);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public rdconnect toEntityModel() {
		rdconnectImpl rdconnectImpl = new rdconnectImpl();

		rdconnectImpl.setIdcardapilogId(idcardapilogId);
		rdconnectImpl.setUserId(userId);

		if (ipaddress == null) {
			rdconnectImpl.setIpaddress(StringPool.BLANK);
		}
		else {
			rdconnectImpl.setIpaddress(ipaddress);
		}

		if (accessDate == Long.MIN_VALUE) {
			rdconnectImpl.setAccessDate(null);
		}
		else {
			rdconnectImpl.setAccessDate(new Date(accessDate));
		}

		if (requestparameter == null) {
			rdconnectImpl.setRequestparameter(StringPool.BLANK);
		}
		else {
			rdconnectImpl.setRequestparameter(requestparameter);
		}

		rdconnectImpl.resetOriginalValues();

		return rdconnectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idcardapilogId = objectInput.readLong();
		userId = objectInput.readLong();
		ipaddress = objectInput.readUTF();
		accessDate = objectInput.readLong();
		requestparameter = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(idcardapilogId);
		objectOutput.writeLong(userId);

		if (ipaddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ipaddress);
		}

		objectOutput.writeLong(accessDate);

		if (requestparameter == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(requestparameter);
		}
	}

	public long idcardapilogId;
	public long userId;
	public String ipaddress;
	public long accessDate;
	public String requestparameter;
}