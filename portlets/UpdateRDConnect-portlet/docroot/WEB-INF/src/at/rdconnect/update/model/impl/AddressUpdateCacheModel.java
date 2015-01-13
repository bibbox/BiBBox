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

import at.rdconnect.update.model.AddressUpdate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AddressUpdate in entity cache.
 *
 * @author reihsr
 * @see AddressUpdate
 * @generated
 */
public class AddressUpdateCacheModel implements CacheModel<AddressUpdate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{addressid=");
		sb.append(addressid);
		sb.append(", street1=");
		sb.append(street1);
		sb.append(", street2=");
		sb.append(street2);
		sb.append(", street3=");
		sb.append(street3);
		sb.append(", city=");
		sb.append(city);
		sb.append(", zip=");
		sb.append(zip);
		sb.append(", regionid=");
		sb.append(regionid);
		sb.append(", contryid=");
		sb.append(contryid);
		sb.append(", typeid=");
		sb.append(typeid);
		sb.append(", mailing=");
		sb.append(mailing);
		sb.append(", primary_ad=");
		sb.append(primary_ad);
		sb.append(", organizationid=");
		sb.append(organizationid);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AddressUpdate toEntityModel() {
		AddressUpdateImpl addressUpdateImpl = new AddressUpdateImpl();

		addressUpdateImpl.setAddressid(addressid);

		if (street1 == null) {
			addressUpdateImpl.setStreet1(StringPool.BLANK);
		}
		else {
			addressUpdateImpl.setStreet1(street1);
		}

		if (street2 == null) {
			addressUpdateImpl.setStreet2(StringPool.BLANK);
		}
		else {
			addressUpdateImpl.setStreet2(street2);
		}

		if (street3 == null) {
			addressUpdateImpl.setStreet3(StringPool.BLANK);
		}
		else {
			addressUpdateImpl.setStreet3(street3);
		}

		if (city == null) {
			addressUpdateImpl.setCity(StringPool.BLANK);
		}
		else {
			addressUpdateImpl.setCity(city);
		}

		if (zip == null) {
			addressUpdateImpl.setZip(StringPool.BLANK);
		}
		else {
			addressUpdateImpl.setZip(zip);
		}

		addressUpdateImpl.setRegionid(regionid);
		addressUpdateImpl.setContryid(contryid);
		addressUpdateImpl.setTypeid(typeid);
		addressUpdateImpl.setMailing(mailing);
		addressUpdateImpl.setPrimary_ad(primary_ad);
		addressUpdateImpl.setOrganizationid(organizationid);

		addressUpdateImpl.resetOriginalValues();

		return addressUpdateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addressid = objectInput.readLong();
		street1 = objectInput.readUTF();
		street2 = objectInput.readUTF();
		street3 = objectInput.readUTF();
		city = objectInput.readUTF();
		zip = objectInput.readUTF();
		regionid = objectInput.readLong();
		contryid = objectInput.readLong();
		typeid = objectInput.readLong();
		mailing = objectInput.readBoolean();
		primary_ad = objectInput.readBoolean();
		organizationid = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(addressid);

		if (street1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(street1);
		}

		if (street2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(street2);
		}

		if (street3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(street3);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (zip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zip);
		}

		objectOutput.writeLong(regionid);
		objectOutput.writeLong(contryid);
		objectOutput.writeLong(typeid);
		objectOutput.writeBoolean(mailing);
		objectOutput.writeBoolean(primary_ad);
		objectOutput.writeLong(organizationid);
	}

	public long addressid;
	public String street1;
	public String street2;
	public String street3;
	public String city;
	public String zip;
	public long regionid;
	public long contryid;
	public long typeid;
	public boolean mailing;
	public boolean primary_ad;
	public long organizationid;
}