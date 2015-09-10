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

package at.graz.hmmc.liferay.portlet.puch.model.impl;

import at.graz.hmmc.liferay.portlet.puch.model.TransaktionData;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TransaktionData in entity cache.
 *
 * @author reihsr
 * @see TransaktionData
 * @generated
 */
public class TransaktionDataCacheModel implements CacheModel<TransaktionData>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{transaktiondataId=");
		sb.append(transaktiondataId);
		sb.append(", puchmuseumsobjectId=");
		sb.append(puchmuseumsobjectId);
		sb.append(", transaktionId=");
		sb.append(transaktionId);
		sb.append(", objectkey=");
		sb.append(objectkey);
		sb.append(", objectvalue=");
		sb.append(objectvalue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TransaktionData toEntityModel() {
		TransaktionDataImpl transaktionDataImpl = new TransaktionDataImpl();

		transaktionDataImpl.setTransaktiondataId(transaktiondataId);
		transaktionDataImpl.setPuchmuseumsobjectId(puchmuseumsobjectId);
		transaktionDataImpl.setTransaktionId(transaktionId);

		if (objectkey == null) {
			transaktionDataImpl.setObjectkey(StringPool.BLANK);
		}
		else {
			transaktionDataImpl.setObjectkey(objectkey);
		}

		if (objectvalue == null) {
			transaktionDataImpl.setObjectvalue(StringPool.BLANK);
		}
		else {
			transaktionDataImpl.setObjectvalue(objectvalue);
		}

		transaktionDataImpl.resetOriginalValues();

		return transaktionDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		transaktiondataId = objectInput.readLong();
		puchmuseumsobjectId = objectInput.readLong();
		transaktionId = objectInput.readLong();
		objectkey = objectInput.readUTF();
		objectvalue = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(transaktiondataId);
		objectOutput.writeLong(puchmuseumsobjectId);
		objectOutput.writeLong(transaktionId);

		if (objectkey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(objectkey);
		}

		if (objectvalue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(objectvalue);
		}
	}

	public long transaktiondataId;
	public long puchmuseumsobjectId;
	public long transaktionId;
	public String objectkey;
	public String objectvalue;
}