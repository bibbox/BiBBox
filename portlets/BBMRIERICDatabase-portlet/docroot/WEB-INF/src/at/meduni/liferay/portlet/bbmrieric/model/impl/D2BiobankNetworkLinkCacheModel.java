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

import at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing D2BiobankNetworkLink in entity cache.
 *
 * @author reihsr
 * @see D2BiobankNetworkLink
 * @generated
 */
public class D2BiobankNetworkLinkCacheModel implements CacheModel<D2BiobankNetworkLink>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", d2biobanknetworklinkId=");
		sb.append(d2biobanknetworklinkId);
		sb.append(", d2biobanknetworkId=");
		sb.append(d2biobanknetworkId);
		sb.append(", d2linkId=");
		sb.append(d2linkId);
		sb.append(", d2linktype=");
		sb.append(d2linktype);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public D2BiobankNetworkLink toEntityModel() {
		D2BiobankNetworkLinkImpl d2BiobankNetworkLinkImpl = new D2BiobankNetworkLinkImpl();

		if (uuid == null) {
			d2BiobankNetworkLinkImpl.setUuid(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkLinkImpl.setUuid(uuid);
		}

		d2BiobankNetworkLinkImpl.setD2biobanknetworklinkId(d2biobanknetworklinkId);
		d2BiobankNetworkLinkImpl.setD2biobanknetworkId(d2biobanknetworkId);
		d2BiobankNetworkLinkImpl.setD2linkId(d2linkId);

		if (d2linktype == null) {
			d2BiobankNetworkLinkImpl.setD2linktype(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkLinkImpl.setD2linktype(d2linktype);
		}

		d2BiobankNetworkLinkImpl.setStatus(status);
		d2BiobankNetworkLinkImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			d2BiobankNetworkLinkImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkLinkImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			d2BiobankNetworkLinkImpl.setStatusDate(null);
		}
		else {
			d2BiobankNetworkLinkImpl.setStatusDate(new Date(statusDate));
		}

		d2BiobankNetworkLinkImpl.setCompanyId(companyId);
		d2BiobankNetworkLinkImpl.setGroupId(groupId);
		d2BiobankNetworkLinkImpl.setUserId(userId);

		if (userName == null) {
			d2BiobankNetworkLinkImpl.setUserName(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkLinkImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			d2BiobankNetworkLinkImpl.setCreateDate(null);
		}
		else {
			d2BiobankNetworkLinkImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			d2BiobankNetworkLinkImpl.setModifiedDate(null);
		}
		else {
			d2BiobankNetworkLinkImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (updateuuid == null) {
			d2BiobankNetworkLinkImpl.setUpdateuuid(StringPool.BLANK);
		}
		else {
			d2BiobankNetworkLinkImpl.setUpdateuuid(updateuuid);
		}

		d2BiobankNetworkLinkImpl.resetOriginalValues();

		return d2BiobankNetworkLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		d2biobanknetworklinkId = objectInput.readLong();
		d2biobanknetworkId = objectInput.readLong();
		d2linkId = objectInput.readLong();
		d2linktype = objectInput.readUTF();
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

		objectOutput.writeLong(d2biobanknetworklinkId);
		objectOutput.writeLong(d2biobanknetworkId);
		objectOutput.writeLong(d2linkId);

		if (d2linktype == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(d2linktype);
		}

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
	}

	public String uuid;
	public long d2biobanknetworklinkId;
	public long d2biobanknetworkId;
	public long d2linkId;
	public String d2linktype;
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
}