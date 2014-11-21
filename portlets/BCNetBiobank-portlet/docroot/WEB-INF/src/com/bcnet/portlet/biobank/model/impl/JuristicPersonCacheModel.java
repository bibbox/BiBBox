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

package com.bcnet.portlet.biobank.model.impl;

import com.bcnet.portlet.biobank.model.JuristicPerson;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing JuristicPerson in entity cache.
 *
 * @author suyama
 * @see JuristicPerson
 * @generated
 */
public class JuristicPersonCacheModel implements CacheModel<JuristicPerson>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{juristicPersonId=");
		sb.append(juristicPersonId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", url=");
		sb.append(url);
		sb.append(", address=");
		sb.append(address);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JuristicPerson toEntityModel() {
		JuristicPersonImpl juristicPersonImpl = new JuristicPersonImpl();

		juristicPersonImpl.setJuristicPersonId(juristicPersonId);

		if (name == null) {
			juristicPersonImpl.setName(StringPool.BLANK);
		}
		else {
			juristicPersonImpl.setName(name);
		}

		if (url == null) {
			juristicPersonImpl.setUrl(StringPool.BLANK);
		}
		else {
			juristicPersonImpl.setUrl(url);
		}

		if (address == null) {
			juristicPersonImpl.setAddress(StringPool.BLANK);
		}
		else {
			juristicPersonImpl.setAddress(address);
		}

		juristicPersonImpl.resetOriginalValues();

		return juristicPersonImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		juristicPersonId = objectInput.readLong();
		name = objectInput.readUTF();
		url = objectInput.readUTF();
		address = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(juristicPersonId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}
	}

	public long juristicPersonId;
	public String name;
	public String url;
	public String address;
}