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

package com.inkwell.internet.productregistration.model.impl;

import com.inkwell.internet.productregistration.model.PRRegistration;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PRRegistration in entity cache.
 *
 * @author Rich Sezov
 * @see PRRegistration
 * @generated
 */
public class PRRegistrationCacheModel implements CacheModel<PRRegistration>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{registrationId=");
		sb.append(registrationId);
		sb.append(", prUserId=");
		sb.append(prUserId);
		sb.append(", datePurchased=");
		sb.append(datePurchased);
		sb.append(", howHear=");
		sb.append(howHear);
		sb.append(", wherePurchased=");
		sb.append(wherePurchased);
		sb.append(", serialNumber=");
		sb.append(serialNumber);
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PRRegistration toEntityModel() {
		PRRegistrationImpl prRegistrationImpl = new PRRegistrationImpl();

		prRegistrationImpl.setRegistrationId(registrationId);
		prRegistrationImpl.setPrUserId(prUserId);

		if (datePurchased == Long.MIN_VALUE) {
			prRegistrationImpl.setDatePurchased(null);
		}
		else {
			prRegistrationImpl.setDatePurchased(new Date(datePurchased));
		}

		if (howHear == null) {
			prRegistrationImpl.setHowHear(StringPool.BLANK);
		}
		else {
			prRegistrationImpl.setHowHear(howHear);
		}

		if (wherePurchased == null) {
			prRegistrationImpl.setWherePurchased(StringPool.BLANK);
		}
		else {
			prRegistrationImpl.setWherePurchased(wherePurchased);
		}

		if (serialNumber == null) {
			prRegistrationImpl.setSerialNumber(StringPool.BLANK);
		}
		else {
			prRegistrationImpl.setSerialNumber(serialNumber);
		}

		prRegistrationImpl.setProductId(productId);
		prRegistrationImpl.setCompanyId(companyId);
		prRegistrationImpl.setGroupId(groupId);

		prRegistrationImpl.resetOriginalValues();

		return prRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		registrationId = objectInput.readLong();
		prUserId = objectInput.readLong();
		datePurchased = objectInput.readLong();
		howHear = objectInput.readUTF();
		wherePurchased = objectInput.readUTF();
		serialNumber = objectInput.readUTF();
		productId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(registrationId);
		objectOutput.writeLong(prUserId);
		objectOutput.writeLong(datePurchased);

		if (howHear == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(howHear);
		}

		if (wherePurchased == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(wherePurchased);
		}

		if (serialNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serialNumber);
		}

		objectOutput.writeLong(productId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
	}

	public long registrationId;
	public long prUserId;
	public long datePurchased;
	public String howHear;
	public String wherePurchased;
	public String serialNumber;
	public long productId;
	public long companyId;
	public long groupId;
}