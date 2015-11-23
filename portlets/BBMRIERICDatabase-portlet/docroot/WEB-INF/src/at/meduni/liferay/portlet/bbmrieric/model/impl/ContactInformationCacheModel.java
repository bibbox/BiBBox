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

import at.meduni.liferay.portlet.bbmrieric.model.ContactInformation;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ContactInformation in entity cache.
 *
 * @author reihsr
 * @see ContactInformation
 * @generated
 */
public class ContactInformationCacheModel implements CacheModel<ContactInformation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", contactinformationId=");
		sb.append(contactinformationId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", updateuuid=");
		sb.append(updateuuid);
		sb.append(", contactID=");
		sb.append(contactID);
		sb.append(", contactEmail=");
		sb.append(contactEmail);
		sb.append(", contactCountry=");
		sb.append(contactCountry);
		sb.append(", contactFirstName=");
		sb.append(contactFirstName);
		sb.append(", contactLastName=");
		sb.append(contactLastName);
		sb.append(", contactPhone=");
		sb.append(contactPhone);
		sb.append(", contactAddress=");
		sb.append(contactAddress);
		sb.append(", contactZIP=");
		sb.append(contactZIP);
		sb.append(", contactCity=");
		sb.append(contactCity);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContactInformation toEntityModel() {
		ContactInformationImpl contactInformationImpl = new ContactInformationImpl();

		if (uuid == null) {
			contactInformationImpl.setUuid(StringPool.BLANK);
		}
		else {
			contactInformationImpl.setUuid(uuid);
		}

		contactInformationImpl.setContactinformationId(contactinformationId);
		contactInformationImpl.setCompanyId(companyId);
		contactInformationImpl.setGroupId(groupId);
		contactInformationImpl.setUserId(userId);

		if (userName == null) {
			contactInformationImpl.setUserName(StringPool.BLANK);
		}
		else {
			contactInformationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			contactInformationImpl.setCreateDate(null);
		}
		else {
			contactInformationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			contactInformationImpl.setModifiedDate(null);
		}
		else {
			contactInformationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (updateuuid == null) {
			contactInformationImpl.setUpdateuuid(StringPool.BLANK);
		}
		else {
			contactInformationImpl.setUpdateuuid(updateuuid);
		}

		if (contactID == null) {
			contactInformationImpl.setContactID(StringPool.BLANK);
		}
		else {
			contactInformationImpl.setContactID(contactID);
		}

		if (contactEmail == null) {
			contactInformationImpl.setContactEmail(StringPool.BLANK);
		}
		else {
			contactInformationImpl.setContactEmail(contactEmail);
		}

		if (contactCountry == null) {
			contactInformationImpl.setContactCountry(StringPool.BLANK);
		}
		else {
			contactInformationImpl.setContactCountry(contactCountry);
		}

		if (contactFirstName == null) {
			contactInformationImpl.setContactFirstName(StringPool.BLANK);
		}
		else {
			contactInformationImpl.setContactFirstName(contactFirstName);
		}

		if (contactLastName == null) {
			contactInformationImpl.setContactLastName(StringPool.BLANK);
		}
		else {
			contactInformationImpl.setContactLastName(contactLastName);
		}

		if (contactPhone == null) {
			contactInformationImpl.setContactPhone(StringPool.BLANK);
		}
		else {
			contactInformationImpl.setContactPhone(contactPhone);
		}

		if (contactAddress == null) {
			contactInformationImpl.setContactAddress(StringPool.BLANK);
		}
		else {
			contactInformationImpl.setContactAddress(contactAddress);
		}

		if (contactZIP == null) {
			contactInformationImpl.setContactZIP(StringPool.BLANK);
		}
		else {
			contactInformationImpl.setContactZIP(contactZIP);
		}

		if (contactCity == null) {
			contactInformationImpl.setContactCity(StringPool.BLANK);
		}
		else {
			contactInformationImpl.setContactCity(contactCity);
		}

		contactInformationImpl.resetOriginalValues();

		return contactInformationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		contactinformationId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		updateuuid = objectInput.readUTF();
		contactID = objectInput.readUTF();
		contactEmail = objectInput.readUTF();
		contactCountry = objectInput.readUTF();
		contactFirstName = objectInput.readUTF();
		contactLastName = objectInput.readUTF();
		contactPhone = objectInput.readUTF();
		contactAddress = objectInput.readUTF();
		contactZIP = objectInput.readUTF();
		contactCity = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(contactinformationId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (updateuuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(updateuuid);
		}

		if (contactID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactID);
		}

		if (contactEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactEmail);
		}

		if (contactCountry == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactCountry);
		}

		if (contactFirstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactFirstName);
		}

		if (contactLastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactLastName);
		}

		if (contactPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactPhone);
		}

		if (contactAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactAddress);
		}

		if (contactZIP == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactZIP);
		}

		if (contactCity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactCity);
		}
	}

	public String uuid;
	public long contactinformationId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String updateuuid;
	public String contactID;
	public String contactEmail;
	public String contactCountry;
	public String contactFirstName;
	public String contactLastName;
	public String contactPhone;
	public String contactAddress;
	public String contactZIP;
	public String contactCity;
}