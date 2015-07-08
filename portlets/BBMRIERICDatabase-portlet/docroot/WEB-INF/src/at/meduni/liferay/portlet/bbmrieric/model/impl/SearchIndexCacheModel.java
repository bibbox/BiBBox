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

package at.meduni.liferay.portlet.bbmrieric.model.impl;

import at.meduni.liferay.portlet.bbmrieric.model.SearchIndex;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SearchIndex in entity cache.
 *
 * @author reihsr
 * @see SearchIndex
 * @generated
 */
public class SearchIndexCacheModel implements CacheModel<SearchIndex>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{searchid=");
		sb.append(searchid);
		sb.append(", organisationid=");
		sb.append(organisationid);
		sb.append(", locationid=");
		sb.append(locationid);
		sb.append(", location=");
		sb.append(location);
		sb.append(", searchindexkey=");
		sb.append(searchindexkey);
		sb.append(", searchindexvalue=");
		sb.append(searchindexvalue);
		sb.append(", UUID=");
		sb.append(UUID);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SearchIndex toEntityModel() {
		SearchIndexImpl searchIndexImpl = new SearchIndexImpl();

		searchIndexImpl.setSearchid(searchid);
		searchIndexImpl.setOrganisationid(organisationid);
		searchIndexImpl.setLocationid(locationid);

		if (location == null) {
			searchIndexImpl.setLocation(StringPool.BLANK);
		}
		else {
			searchIndexImpl.setLocation(location);
		}

		if (searchindexkey == null) {
			searchIndexImpl.setSearchindexkey(StringPool.BLANK);
		}
		else {
			searchIndexImpl.setSearchindexkey(searchindexkey);
		}

		if (searchindexvalue == null) {
			searchIndexImpl.setSearchindexvalue(StringPool.BLANK);
		}
		else {
			searchIndexImpl.setSearchindexvalue(searchindexvalue);
		}

		if (UUID == null) {
			searchIndexImpl.setUUID(StringPool.BLANK);
		}
		else {
			searchIndexImpl.setUUID(UUID);
		}

		searchIndexImpl.resetOriginalValues();

		return searchIndexImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		searchid = objectInput.readLong();
		organisationid = objectInput.readLong();
		locationid = objectInput.readLong();
		location = objectInput.readUTF();
		searchindexkey = objectInput.readUTF();
		searchindexvalue = objectInput.readUTF();
		UUID = objectInput.readUTF();
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

		if (searchindexkey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(searchindexkey);
		}

		if (searchindexvalue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(searchindexvalue);
		}

		if (UUID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(UUID);
		}
	}

	public long searchid;
	public long organisationid;
	public long locationid;
	public String location;
	public String searchindexkey;
	public String searchindexvalue;
	public String UUID;
}