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

package at.rdconnect.update.model.impl;

import at.rdconnect.update.model.CoreUpdate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CoreUpdate in entity cache.
 *
 * @author reihsr
 * @see CoreUpdate
 * @generated
 */
public class CoreUpdateCacheModel implements CacheModel<CoreUpdate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{coreid=");
		sb.append(coreid);
		sb.append(", organizationid=");
		sb.append(organizationid);
		sb.append(", fieldname=");
		sb.append(fieldname);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CoreUpdate toEntityModel() {
		CoreUpdateImpl coreUpdateImpl = new CoreUpdateImpl();

		coreUpdateImpl.setCoreid(coreid);
		coreUpdateImpl.setOrganizationid(organizationid);

		if (fieldname == null) {
			coreUpdateImpl.setFieldname(StringPool.BLANK);
		}
		else {
			coreUpdateImpl.setFieldname(fieldname);
		}

		if (value == null) {
			coreUpdateImpl.setValue(StringPool.BLANK);
		}
		else {
			coreUpdateImpl.setValue(value);
		}

		coreUpdateImpl.resetOriginalValues();

		return coreUpdateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		coreid = objectInput.readLong();
		organizationid = objectInput.readLong();
		fieldname = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(coreid);
		objectOutput.writeLong(organizationid);

		if (fieldname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fieldname);
		}

		if (value == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public long coreid;
	public long organizationid;
	public String fieldname;
	public String value;
}