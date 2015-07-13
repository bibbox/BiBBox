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

import at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DiseaseDiscription in entity cache.
 *
 * @author reihsr
 * @see DiseaseDiscription
 * @generated
 */
public class DiseaseDiscriptionCacheModel implements CacheModel<DiseaseDiscription>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{diseasediscriptionId=");
		sb.append(diseasediscriptionId);
		sb.append(", diseasecode=");
		sb.append(diseasecode);
		sb.append(", diseasegroup=");
		sb.append(diseasegroup);
		sb.append(", diseasediscription=");
		sb.append(diseasediscription);
		sb.append(", root=");
		sb.append(root);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DiseaseDiscription toEntityModel() {
		DiseaseDiscriptionImpl diseaseDiscriptionImpl = new DiseaseDiscriptionImpl();

		diseaseDiscriptionImpl.setDiseasediscriptionId(diseasediscriptionId);

		if (diseasecode == null) {
			diseaseDiscriptionImpl.setDiseasecode(StringPool.BLANK);
		}
		else {
			diseaseDiscriptionImpl.setDiseasecode(diseasecode);
		}

		if (diseasegroup == null) {
			diseaseDiscriptionImpl.setDiseasegroup(StringPool.BLANK);
		}
		else {
			diseaseDiscriptionImpl.setDiseasegroup(diseasegroup);
		}

		if (diseasediscription == null) {
			diseaseDiscriptionImpl.setDiseasediscription(StringPool.BLANK);
		}
		else {
			diseaseDiscriptionImpl.setDiseasediscription(diseasediscription);
		}

		diseaseDiscriptionImpl.setRoot(root);

		diseaseDiscriptionImpl.resetOriginalValues();

		return diseaseDiscriptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		diseasediscriptionId = objectInput.readLong();
		diseasecode = objectInput.readUTF();
		diseasegroup = objectInput.readUTF();
		diseasediscription = objectInput.readUTF();
		root = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(diseasediscriptionId);

		if (diseasecode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diseasecode);
		}

		if (diseasegroup == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diseasegroup);
		}

		if (diseasediscription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diseasediscription);
		}

		objectOutput.writeBoolean(root);
	}

	public long diseasediscriptionId;
	public String diseasecode;
	public String diseasegroup;
	public String diseasediscription;
	public boolean root;
}