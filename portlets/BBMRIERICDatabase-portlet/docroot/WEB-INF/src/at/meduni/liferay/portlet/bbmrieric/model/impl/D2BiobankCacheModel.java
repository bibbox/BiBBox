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

import at.meduni.liferay.portlet.bbmrieric.model.D2Biobank;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing D2Biobank in entity cache.
 *
 * @author reihsr
 * @see D2Biobank
 * @generated
 */
public class D2BiobankCacheModel implements CacheModel<D2Biobank>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(85);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", biobankId=");
		sb.append(biobankId);
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
		sb.append(", bbmribiobankID=");
		sb.append(bbmribiobankID);
		sb.append(", biobankName=");
		sb.append(biobankName);
		sb.append(", biobankJurisdicalPerson=");
		sb.append(biobankJurisdicalPerson);
		sb.append(", biobankCountry=");
		sb.append(biobankCountry);
		sb.append(", biobankPartnerCharterSigned=");
		sb.append(biobankPartnerCharterSigned);
		sb.append(", bioresourceReference=");
		sb.append(bioresourceReference);
		sb.append(", biobankNetworkIDRef=");
		sb.append(biobankNetworkIDRef);
		sb.append(", geoLatitude=");
		sb.append(geoLatitude);
		sb.append(", geoLongitude=");
		sb.append(geoLongitude);
		sb.append(", collaborationPartnersCommercial=");
		sb.append(collaborationPartnersCommercial);
		sb.append(", collaborationPartnersNonforprofit=");
		sb.append(collaborationPartnersNonforprofit);
		sb.append(", biobankITSupportAvailable=");
		sb.append(biobankITSupportAvailable);
		sb.append(", biobankITStaffSize=");
		sb.append(biobankITStaffSize);
		sb.append(", biobankISAvailable=");
		sb.append(biobankISAvailable);
		sb.append(", biobankHISAvailable=");
		sb.append(biobankHISAvailable);
		sb.append(", biobankAcronym=");
		sb.append(biobankAcronym);
		sb.append(", biobankDescription=");
		sb.append(biobankDescription);
		sb.append(", biobankURL=");
		sb.append(biobankURL);
		sb.append(", biobankHeadFirstName=");
		sb.append(biobankHeadFirstName);
		sb.append(", biobankHeadLastName=");
		sb.append(biobankHeadLastName);
		sb.append(", biobankHeadRole=");
		sb.append(biobankHeadRole);
		sb.append(", biobankClinical=");
		sb.append(biobankClinical);
		sb.append(", biobankPopulation=");
		sb.append(biobankPopulation);
		sb.append(", biobankResearchStudy=");
		sb.append(biobankResearchStudy);
		sb.append(", biobankNonHuman=");
		sb.append(biobankNonHuman);
		sb.append(", biobankCollection=");
		sb.append(biobankCollection);
		sb.append(", biobankType=");
		sb.append(biobankType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public D2Biobank toEntityModel() {
		D2BiobankImpl d2BiobankImpl = new D2BiobankImpl();

		if (uuid == null) {
			d2BiobankImpl.setUuid(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setUuid(uuid);
		}

		d2BiobankImpl.setBiobankId(biobankId);
		d2BiobankImpl.setStatus(status);
		d2BiobankImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			d2BiobankImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			d2BiobankImpl.setStatusDate(null);
		}
		else {
			d2BiobankImpl.setStatusDate(new Date(statusDate));
		}

		d2BiobankImpl.setCompanyId(companyId);
		d2BiobankImpl.setGroupId(groupId);
		d2BiobankImpl.setUserId(userId);

		if (userName == null) {
			d2BiobankImpl.setUserName(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			d2BiobankImpl.setCreateDate(null);
		}
		else {
			d2BiobankImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			d2BiobankImpl.setModifiedDate(null);
		}
		else {
			d2BiobankImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (updateuuid == null) {
			d2BiobankImpl.setUpdateuuid(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setUpdateuuid(updateuuid);
		}

		if (contactIDRef == null) {
			d2BiobankImpl.setContactIDRef(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setContactIDRef(contactIDRef);
		}

		d2BiobankImpl.setContactPriority(contactPriority);

		if (bbmribiobankID == null) {
			d2BiobankImpl.setBbmribiobankID(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setBbmribiobankID(bbmribiobankID);
		}

		if (biobankName == null) {
			d2BiobankImpl.setBiobankName(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setBiobankName(biobankName);
		}

		if (biobankJurisdicalPerson == null) {
			d2BiobankImpl.setBiobankJurisdicalPerson(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setBiobankJurisdicalPerson(biobankJurisdicalPerson);
		}

		if (biobankCountry == null) {
			d2BiobankImpl.setBiobankCountry(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setBiobankCountry(biobankCountry);
		}

		d2BiobankImpl.setBiobankPartnerCharterSigned(biobankPartnerCharterSigned);

		if (bioresourceReference == null) {
			d2BiobankImpl.setBioresourceReference(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setBioresourceReference(bioresourceReference);
		}

		if (biobankNetworkIDRef == null) {
			d2BiobankImpl.setBiobankNetworkIDRef(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setBiobankNetworkIDRef(biobankNetworkIDRef);
		}

		if (geoLatitude == null) {
			d2BiobankImpl.setGeoLatitude(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setGeoLatitude(geoLatitude);
		}

		if (geoLongitude == null) {
			d2BiobankImpl.setGeoLongitude(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setGeoLongitude(geoLongitude);
		}

		d2BiobankImpl.setCollaborationPartnersCommercial(collaborationPartnersCommercial);
		d2BiobankImpl.setCollaborationPartnersNonforprofit(collaborationPartnersNonforprofit);
		d2BiobankImpl.setBiobankITSupportAvailable(biobankITSupportAvailable);
		d2BiobankImpl.setBiobankITStaffSize(biobankITStaffSize);
		d2BiobankImpl.setBiobankISAvailable(biobankISAvailable);
		d2BiobankImpl.setBiobankHISAvailable(biobankHISAvailable);

		if (biobankAcronym == null) {
			d2BiobankImpl.setBiobankAcronym(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setBiobankAcronym(biobankAcronym);
		}

		if (biobankDescription == null) {
			d2BiobankImpl.setBiobankDescription(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setBiobankDescription(biobankDescription);
		}

		if (biobankURL == null) {
			d2BiobankImpl.setBiobankURL(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setBiobankURL(biobankURL);
		}

		if (biobankHeadFirstName == null) {
			d2BiobankImpl.setBiobankHeadFirstName(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setBiobankHeadFirstName(biobankHeadFirstName);
		}

		if (biobankHeadLastName == null) {
			d2BiobankImpl.setBiobankHeadLastName(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setBiobankHeadLastName(biobankHeadLastName);
		}

		if (biobankHeadRole == null) {
			d2BiobankImpl.setBiobankHeadRole(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setBiobankHeadRole(biobankHeadRole);
		}

		d2BiobankImpl.setBiobankClinical(biobankClinical);
		d2BiobankImpl.setBiobankPopulation(biobankPopulation);
		d2BiobankImpl.setBiobankResearchStudy(biobankResearchStudy);
		d2BiobankImpl.setBiobankNonHuman(biobankNonHuman);
		d2BiobankImpl.setBiobankCollection(biobankCollection);

		if (biobankType == null) {
			d2BiobankImpl.setBiobankType(StringPool.BLANK);
		}
		else {
			d2BiobankImpl.setBiobankType(biobankType);
		}

		d2BiobankImpl.resetOriginalValues();

		return d2BiobankImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		biobankId = objectInput.readLong();
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
		bbmribiobankID = objectInput.readUTF();
		biobankName = objectInput.readUTF();
		biobankJurisdicalPerson = objectInput.readUTF();
		biobankCountry = objectInput.readUTF();
		biobankPartnerCharterSigned = objectInput.readBoolean();
		bioresourceReference = objectInput.readUTF();
		biobankNetworkIDRef = objectInput.readUTF();
		geoLatitude = objectInput.readUTF();
		geoLongitude = objectInput.readUTF();
		collaborationPartnersCommercial = objectInput.readBoolean();
		collaborationPartnersNonforprofit = objectInput.readBoolean();
		biobankITSupportAvailable = objectInput.readBoolean();
		biobankITStaffSize = objectInput.readLong();
		biobankISAvailable = objectInput.readBoolean();
		biobankHISAvailable = objectInput.readBoolean();
		biobankAcronym = objectInput.readUTF();
		biobankDescription = objectInput.readUTF();
		biobankURL = objectInput.readUTF();
		biobankHeadFirstName = objectInput.readUTF();
		biobankHeadLastName = objectInput.readUTF();
		biobankHeadRole = objectInput.readUTF();
		biobankClinical = objectInput.readBoolean();
		biobankPopulation = objectInput.readBoolean();
		biobankResearchStudy = objectInput.readBoolean();
		biobankNonHuman = objectInput.readBoolean();
		biobankCollection = objectInput.readBoolean();
		biobankType = objectInput.readUTF();
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

		objectOutput.writeLong(biobankId);
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

		if (bbmribiobankID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bbmribiobankID);
		}

		if (biobankName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankName);
		}

		if (biobankJurisdicalPerson == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankJurisdicalPerson);
		}

		if (biobankCountry == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankCountry);
		}

		objectOutput.writeBoolean(biobankPartnerCharterSigned);

		if (bioresourceReference == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bioresourceReference);
		}

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

		objectOutput.writeBoolean(collaborationPartnersCommercial);
		objectOutput.writeBoolean(collaborationPartnersNonforprofit);
		objectOutput.writeBoolean(biobankITSupportAvailable);
		objectOutput.writeLong(biobankITStaffSize);
		objectOutput.writeBoolean(biobankISAvailable);
		objectOutput.writeBoolean(biobankHISAvailable);

		if (biobankAcronym == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankAcronym);
		}

		if (biobankDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankDescription);
		}

		if (biobankURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankURL);
		}

		if (biobankHeadFirstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankHeadFirstName);
		}

		if (biobankHeadLastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankHeadLastName);
		}

		if (biobankHeadRole == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankHeadRole);
		}

		objectOutput.writeBoolean(biobankClinical);
		objectOutput.writeBoolean(biobankPopulation);
		objectOutput.writeBoolean(biobankResearchStudy);
		objectOutput.writeBoolean(biobankNonHuman);
		objectOutput.writeBoolean(biobankCollection);

		if (biobankType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankType);
		}
	}

	public String uuid;
	public long biobankId;
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
	public String bbmribiobankID;
	public String biobankName;
	public String biobankJurisdicalPerson;
	public String biobankCountry;
	public boolean biobankPartnerCharterSigned;
	public String bioresourceReference;
	public String biobankNetworkIDRef;
	public String geoLatitude;
	public String geoLongitude;
	public boolean collaborationPartnersCommercial;
	public boolean collaborationPartnersNonforprofit;
	public boolean biobankITSupportAvailable;
	public long biobankITStaffSize;
	public boolean biobankISAvailable;
	public boolean biobankHISAvailable;
	public String biobankAcronym;
	public String biobankDescription;
	public String biobankURL;
	public String biobankHeadFirstName;
	public String biobankHeadLastName;
	public String biobankHeadRole;
	public boolean biobankClinical;
	public boolean biobankPopulation;
	public boolean biobankResearchStudy;
	public boolean biobankNonHuman;
	public boolean biobankCollection;
	public String biobankType;
}