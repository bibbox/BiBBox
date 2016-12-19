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

package at.graz.meduni.liferay.portlet.bibbox.model.impl;

import at.graz.meduni.liferay.portlet.bibbox.model.OrganizationSearchIndex;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing OrganizationSearchIndex in entity cache.
 *
 * @author reihsr
 * @see OrganizationSearchIndex
 * @generated
 */
public class OrganizationSearchIndexCacheModel implements CacheModel<OrganizationSearchIndex>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{searchid=");
		sb.append(searchid);
		sb.append(", organisationid=");
		sb.append(organisationid);
		sb.append(", locationid=");
		sb.append(locationid);
		sb.append(", location=");
		sb.append(location);
		sb.append(", key=");
		sb.append(key);
		sb.append(", searchvalue=");
		sb.append(searchvalue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OrganizationSearchIndex toEntityModel() {
		OrganizationSearchIndexImpl organizationSearchIndexImpl = new OrganizationSearchIndexImpl();

		organizationSearchIndexImpl.setSearchid(searchid);
		organizationSearchIndexImpl.setOrganisationid(organisationid);
		organizationSearchIndexImpl.setLocationid(locationid);

		if (location == null) {
			organizationSearchIndexImpl.setLocation(StringPool.BLANK);
		}
		else {
			organizationSearchIndexImpl.setLocation(location);
		}

		if (key == null) {
			organizationSearchIndexImpl.setKey(StringPool.BLANK);
		}
		else {
			organizationSearchIndexImpl.setKey(key);
		}

		if (searchvalue == null) {
			organizationSearchIndexImpl.setSearchvalue(StringPool.BLANK);
		}
		else {
			organizationSearchIndexImpl.setSearchvalue(searchvalue);
		}

		organizationSearchIndexImpl.resetOriginalValues();

		return organizationSearchIndexImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		searchid = objectInput.readLong();
		organisationid = objectInput.readLong();
		locationid = objectInput.readLong();
		location = objectInput.readUTF();
		key = objectInput.readUTF();
		searchvalue = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(searchid);
		objectOutput.writeLong(organisationid);
		objectOutput.writeLong(locationid);

		if (location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (key == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (searchvalue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(searchvalue);
		}
	}

	public long searchid;
	public long organisationid;
	public long locationid;
	public String location;
	public String key;
	public String searchvalue;
}