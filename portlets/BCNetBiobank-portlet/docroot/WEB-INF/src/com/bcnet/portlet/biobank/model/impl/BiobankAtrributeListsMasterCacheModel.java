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

package com.bcnet.portlet.biobank.model.impl;

import com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BiobankAtrributeListsMaster in entity cache.
 *
 * @author suyama
 * @see BiobankAtrributeListsMaster
 * @generated
 */
public class BiobankAtrributeListsMasterCacheModel implements CacheModel<BiobankAtrributeListsMaster>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{biobankAttributeListsMasterId=");
		sb.append(biobankAttributeListsMasterId);
		sb.append(", attributeListName=");
		sb.append(attributeListName);
		sb.append(", attributeListValue=");
		sb.append(attributeListValue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BiobankAtrributeListsMaster toEntityModel() {
		BiobankAtrributeListsMasterImpl biobankAtrributeListsMasterImpl = new BiobankAtrributeListsMasterImpl();

		biobankAtrributeListsMasterImpl.setBiobankAttributeListsMasterId(biobankAttributeListsMasterId);

		if (attributeListName == null) {
			biobankAtrributeListsMasterImpl.setAttributeListName(StringPool.BLANK);
		}
		else {
			biobankAtrributeListsMasterImpl.setAttributeListName(attributeListName);
		}

		if (attributeListValue == null) {
			biobankAtrributeListsMasterImpl.setAttributeListValue(StringPool.BLANK);
		}
		else {
			biobankAtrributeListsMasterImpl.setAttributeListValue(attributeListValue);
		}

		biobankAtrributeListsMasterImpl.resetOriginalValues();

		return biobankAtrributeListsMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		biobankAttributeListsMasterId = objectInput.readLong();
		attributeListName = objectInput.readUTF();
		attributeListValue = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(biobankAttributeListsMasterId);

		if (attributeListName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(attributeListName);
		}

		if (attributeListValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(attributeListValue);
		}
	}

	public long biobankAttributeListsMasterId;
	public String attributeListName;
	public String attributeListValue;
}