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

import at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing D2BiobankNetwork in entity cache.
 *
 * @author reihsr
 * @see D2BiobankNetwork
 * @generated
 */
public class D2BiobankNetworkCacheModel implements CacheModel<D2BiobankNetwork>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(67);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", d2biobanknetworkId=");
		sb.append(d2biobanknetworkId);
		sb.append(", parentd2biobanknetworkId=");
		sb.append(parentd2biobanknetworkId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
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
		sb.append(", contactIDRef=");
		sb.append(contactIDRef);
		sb.append(", contactPriority=");
		sb.append(contactPriority);
		sb.append(", bbmriBiobankNetworkID=");
		sb.append(bbmriBiobankNetworkID);
		sb.append(", biobankNetworkName=");
		sb.append(biobankNetworkName);
		sb.append(", biobankNetworkCommonCollectionFocus=");
		sb.append(biobankNetworkCommonCollectionFocus);
		sb.append(", biobankNetworkCommonCharter=");
		sb.append(biobankNetworkCommonCharter);
		sb.append(", biobankNetworkCommonSOPs=");
		sb.append(biobankNetworkCommonSOPs);
		sb.append(", biobankNetworkCommonDataAccessPolicy=");
		sb.append(biobankNetworkCommonDataAccessPolicy);
		sb.append(", biobankNetworkCommonSampleAccessPolicy=");
		sb.append(biobankNetworkCommonSampleAccessPolicy);
		sb.append(", biobankNetworkCommonMTA=");
		sb.append(biobankNetworkCommonMTA);
		sb.append(", biobankNetworkCommonRepresentation=");
		sb.append(biobankNetworkCommonRepresentation);
		sb.append(", biobankNetworkCommonURL=");
		sb.append(biobankNetworkCommonURL);
		sb.append(", biobankNetworkIDRef=");
		sb.append(biobankNetworkIDRef);
		sb.append(", geoLatitude=");
		sb.append(geoLatitude);
		sb.append(", geoLongitude=");
		sb.append(geoLongitude);
		sb.append(", biobankNetworkAcronym=");
		sb.append(biobankNetworkAcronym);
		sb.append(", biobankNetworkDescription=");
		sb.append(biobankNetworkDescription);
		sb.append(", biobankNetworkURL=");
		sb.append(biobankNetworkURL);
		sb.append(", biobankNetworkJuridicalPerson=");
		sb.append(biobankNetworkJuridicalPerson);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public D2BiobankNetwork toEntityModel() {
		D2BiobankNetworkImpl d2BiobankNetworkImpl = new D2BiobankNetworkImpl();

		if (uuid == null) {
			d2BiobankNetworkImpl.setUuid(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkImpl.setUuid(uuid);
		}

		d2BiobankNetworkImpl.setD2biobanknetworkId(d2biobanknetworkId);
		d2BiobankNetworkImpl.setParentd2biobanknetworkId(parentd2biobanknetworkId);
		d2BiobankNetworkImpl.setStatus(status);
		d2BiobankNetworkImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			d2BiobankNetworkImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			d2BiobankNetworkImpl.setStatusDate(null);
		}
		else {
			d2BiobankNetworkImpl.setStatusDate(new Date(statusDate));
		}

		d2BiobankNetworkImpl.setCompanyId(companyId);
		d2BiobankNetworkImpl.setGroupId(groupId);
		d2BiobankNetworkImpl.setUserId(userId);

		if (userName == null) {
			d2BiobankNetworkImpl.setUserName(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			d2BiobankNetworkImpl.setCreateDate(null);
		}
		else {
			d2BiobankNetworkImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			d2BiobankNetworkImpl.setModifiedDate(null);
		}
		else {
			d2BiobankNetworkImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (updateuuid == null) {
			d2BiobankNetworkImpl.setUpdateuuid(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkImpl.setUpdateuuid(updateuuid);
		}

		if (contactIDRef == null) {
			d2BiobankNetworkImpl.setContactIDRef(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkImpl.setContactIDRef(contactIDRef);
		}

		d2BiobankNetworkImpl.setContactPriority(contactPriority);

		if (bbmriBiobankNetworkID == null) {
			d2BiobankNetworkImpl.setBbmriBiobankNetworkID(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkImpl.setBbmriBiobankNetworkID(bbmriBiobankNetworkID);
		}

		if (biobankNetworkName == null) {
			d2BiobankNetworkImpl.setBiobankNetworkName(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkImpl.setBiobankNetworkName(biobankNetworkName);
		}

		d2BiobankNetworkImpl.setBiobankNetworkCommonCollectionFocus(biobankNetworkCommonCollectionFocus);
		d2BiobankNetworkImpl.setBiobankNetworkCommonCharter(biobankNetworkCommonCharter);
		d2BiobankNetworkImpl.setBiobankNetworkCommonSOPs(biobankNetworkCommonSOPs);
		d2BiobankNetworkImpl.setBiobankNetworkCommonDataAccessPolicy(biobankNetworkCommonDataAccessPolicy);
		d2BiobankNetworkImpl.setBiobankNetworkCommonSampleAccessPolicy(biobankNetworkCommonSampleAccessPolicy);
		d2BiobankNetworkImpl.setBiobankNetworkCommonMTA(biobankNetworkCommonMTA);
		d2BiobankNetworkImpl.setBiobankNetworkCommonRepresentation(biobankNetworkCommonRepresentation);
		d2BiobankNetworkImpl.setBiobankNetworkCommonURL(biobankNetworkCommonURL);

		if (biobankNetworkIDRef == null) {
			d2BiobankNetworkImpl.setBiobankNetworkIDRef(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkImpl.setBiobankNetworkIDRef(biobankNetworkIDRef);
		}

		if (geoLatitude == null) {
			d2BiobankNetworkImpl.setGeoLatitude(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkImpl.setGeoLatitude(geoLatitude);
		}

		if (geoLongitude == null) {
			d2BiobankNetworkImpl.setGeoLongitude(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkImpl.setGeoLongitude(geoLongitude);
		}

		if (biobankNetworkAcronym == null) {
			d2BiobankNetworkImpl.setBiobankNetworkAcronym(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkImpl.setBiobankNetworkAcronym(biobankNetworkAcronym);
		}

		if (biobankNetworkDescription == null) {
			d2BiobankNetworkImpl.setBiobankNetworkDescription(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkImpl.setBiobankNetworkDescription(biobankNetworkDescription);
		}

		if (biobankNetworkURL == null) {
			d2BiobankNetworkImpl.setBiobankNetworkURL(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkImpl.setBiobankNetworkURL(biobankNetworkURL);
		}

		if (biobankNetworkJuridicalPerson == null) {
			d2BiobankNetworkImpl.setBiobankNetworkJuridicalPerson(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkImpl.setBiobankNetworkJuridicalPerson(biobankNetworkJuridicalPerson);
		}

		d2BiobankNetworkImpl.resetOriginalValues();

		return d2BiobankNetworkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		d2biobanknetworkId = objectInput.readLong();
		parentd2biobanknetworkId = objectInput.readLong();
		status = objectInput.readInt();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		updateuuid = objectInput.readUTF();
		contactIDRef = objectInput.readUTF();
		contactPriority = objectInput.readLong();
		bbmriBiobankNetworkID = objectInput.readUTF();
		biobankNetworkName = objectInput.readUTF();
		biobankNetworkCommonCollectionFocus = objectInput.readBoolean();
		biobankNetworkCommonCharter = objectInput.readBoolean();
		biobankNetworkCommonSOPs = objectInput.readBoolean();
		biobankNetworkCommonDataAccessPolicy = objectInput.readBoolean();
		biobankNetworkCommonSampleAccessPolicy = objectInput.readBoolean();
		biobankNetworkCommonMTA = objectInput.readBoolean();
		biobankNetworkCommonRepresentation = objectInput.readBoolean();
		biobankNetworkCommonURL = objectInput.readBoolean();
		biobankNetworkIDRef = objectInput.readUTF();
		geoLatitude = objectInput.readUTF();
		geoLongitude = objectInput.readUTF();
		biobankNetworkAcronym = objectInput.readUTF();
		biobankNetworkDescription = objectInput.readUTF();
		biobankNetworkURL = objectInput.readUTF();
		biobankNetworkJuridicalPerson = objectInput.readUTF();
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

		objectOutput.writeLong(d2biobanknetworkId);
		objectOutput.writeLong(parentd2biobanknetworkId);
		objectOutput.writeInt(status);
		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
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

		if (contactIDRef == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactIDRef);
		}

		objectOutput.writeLong(contactPriority);

		if (bbmriBiobankNetworkID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bbmriBiobankNetworkID);
		}

		if (biobankNetworkName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankNetworkName);
		}

		objectOutput.writeBoolean(biobankNetworkCommonCollectionFocus);
		objectOutput.writeBoolean(biobankNetworkCommonCharter);
		objectOutput.writeBoolean(biobankNetworkCommonSOPs);
		objectOutput.writeBoolean(biobankNetworkCommonDataAccessPolicy);
		objectOutput.writeBoolean(biobankNetworkCommonSampleAccessPolicy);
		objectOutput.writeBoolean(biobankNetworkCommonMTA);
		objectOutput.writeBoolean(biobankNetworkCommonRepresentation);
		objectOutput.writeBoolean(biobankNetworkCommonURL);

		if (biobankNetworkIDRef == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankNetworkIDRef);
		}

		if (geoLatitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(geoLatitude);
		}

		if (geoLongitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(geoLongitude);
		}

		if (biobankNetworkAcronym == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankNetworkAcronym);
		}

		if (biobankNetworkDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankNetworkDescription);
		}

		if (biobankNetworkURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankNetworkURL);
		}

		if (biobankNetworkJuridicalPerson == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankNetworkJuridicalPerson);
		}
	}

	public String uuid;
	public long d2biobanknetworkId;
	public long parentd2biobanknetworkId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String updateuuid;
	public String contactIDRef;
	public long contactPriority;
	public String bbmriBiobankNetworkID;
	public String biobankNetworkName;
	public boolean biobankNetworkCommonCollectionFocus;
	public boolean biobankNetworkCommonCharter;
	public boolean biobankNetworkCommonSOPs;
	public boolean biobankNetworkCommonDataAccessPolicy;
	public boolean biobankNetworkCommonSampleAccessPolicy;
	public boolean biobankNetworkCommonMTA;
	public boolean biobankNetworkCommonRepresentation;
	public boolean biobankNetworkCommonURL;
	public String biobankNetworkIDRef;
	public String geoLatitude;
	public String geoLongitude;
	public String biobankNetworkAcronym;
	public String biobankNetworkDescription;
	public String biobankNetworkURL;
	public String biobankNetworkJuridicalPerson;
}