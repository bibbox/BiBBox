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

import com.bcnet.portlet.biobank.model.BiobankAttributeLists;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BiobankAttributeLists in entity cache.
 *
 * @author suyama
 * @see BiobankAttributeLists
 * @generated
 */
public class BiobankAttributeListsCacheModel implements CacheModel<BiobankAttributeLists>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{biobankAttributeListsId=");
		sb.append(biobankAttributeListsId);
		sb.append(", biobankDbId=");
		sb.append(biobankDbId);
		sb.append(", attributeListName=");
		sb.append(attributeListName);
		sb.append(", attributeListValue=");
		sb.append(attributeListValue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BiobankAttributeLists toEntityModel() {
		BiobankAttributeListsImpl biobankAttributeListsImpl = new BiobankAttributeListsImpl();

		biobankAttributeListsImpl.setBiobankAttributeListsId(biobankAttributeListsId);
		biobankAttributeListsImpl.setBiobankDbId(biobankDbId);

		if (attributeListName == null) {
			biobankAttributeListsImpl.setAttributeListName(StringPool.BLANK);
		}
		else {
			biobankAttributeListsImpl.setAttributeListName(attributeListName);
		}

		if (attributeListValue == null) {
			biobankAttributeListsImpl.setAttributeListValue(StringPool.BLANK);
		}
		else {
			biobankAttributeListsImpl.setAttributeListValue(attributeListValue);
		}

		biobankAttributeListsImpl.resetOriginalValues();

		return biobankAttributeListsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		biobankAttributeListsId = objectInput.readLong();
		biobankDbId = objectInput.readLong();
		attributeListName = objectInput.readUTF();
		attributeListValue = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(biobankAttributeListsId);
		objectOutput.writeLong(biobankDbId);

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

	public long biobankAttributeListsId;
	public long biobankDbId;
	public String attributeListName;
	public String attributeListValue;
}