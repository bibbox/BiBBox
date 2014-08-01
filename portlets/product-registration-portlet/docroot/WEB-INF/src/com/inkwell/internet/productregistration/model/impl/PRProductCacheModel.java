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

import com.inkwell.internet.productregistration.model.PRProduct;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PRProduct in entity cache.
 *
 * @author Rich Sezov
 * @see PRProduct
 * @generated
 */
public class PRProductCacheModel implements CacheModel<PRProduct>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{productId=");
		sb.append(productId);
		sb.append(", productName=");
		sb.append(productName);
		sb.append(", serialNumber=");
		sb.append(serialNumber);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PRProduct toEntityModel() {
		PRProductImpl prProductImpl = new PRProductImpl();

		prProductImpl.setProductId(productId);

		if (productName == null) {
			prProductImpl.setProductName(StringPool.BLANK);
		}
		else {
			prProductImpl.setProductName(productName);
		}

		if (serialNumber == null) {
			prProductImpl.setSerialNumber(StringPool.BLANK);
		}
		else {
			prProductImpl.setSerialNumber(serialNumber);
		}

		prProductImpl.setCompanyId(companyId);
		prProductImpl.setGroupId(groupId);

		prProductImpl.resetOriginalValues();

		return prProductImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		productId = objectInput.readLong();
		productName = objectInput.readUTF();
		serialNumber = objectInput.readUTF();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(productId);

		if (productName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(productName);
		}

		if (serialNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serialNumber);
		}

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
	}

	public long productId;
	public String productName;
	public String serialNumber;
	public long companyId;
	public long groupId;
}