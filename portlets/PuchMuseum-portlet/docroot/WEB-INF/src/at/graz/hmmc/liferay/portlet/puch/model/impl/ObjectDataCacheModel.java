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

import at.graz.hmmc.liferay.portlet.puch.model.ObjectData;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ObjectData in entity cache.
 *
 * @author reihsr
 * @see ObjectData
 * @generated
 */
public class ObjectDataCacheModel implements CacheModel<ObjectData>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{objectdataId=");
		sb.append(objectdataId);
		sb.append(", puchmuseumsobjectId=");
		sb.append(puchmuseumsobjectId);
		sb.append(", objectkey=");
		sb.append(objectkey);
		sb.append(", objectvalue=");
		sb.append(objectvalue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ObjectData toEntityModel() {
		ObjectDataImpl objectDataImpl = new ObjectDataImpl();

		objectDataImpl.setObjectdataId(objectdataId);
		objectDataImpl.setPuchmuseumsobjectId(puchmuseumsobjectId);

		if (objectkey == null) {
			objectDataImpl.setObjectkey(StringPool.BLANK);
		}
		else {
			objectDataImpl.setObjectkey(objectkey);
		}

		if (objectvalue == null) {
			objectDataImpl.setObjectvalue(StringPool.BLANK);
		}
		else {
			objectDataImpl.setObjectvalue(objectvalue);
		}

		objectDataImpl.resetOriginalValues();

		return objectDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		objectdataId = objectInput.readLong();
		puchmuseumsobjectId = objectInput.readLong();
		objectkey = objectInput.readUTF();
		objectvalue = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(objectdataId);
		objectOutput.writeLong(puchmuseumsobjectId);

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

	public long objectdataId;
	public long puchmuseumsobjectId;
	public String objectkey;
	public String objectvalue;
}