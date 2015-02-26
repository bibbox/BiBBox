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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing patientnamegenerator in entity cache.
 *
 * @author reihsr
 * @see patientnamegenerator
 * @generated
 */
public class patientnamegeneratorCacheModel implements CacheModel<patientnamegenerator>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{patientnamegeneratorId=");
		sb.append(patientnamegeneratorId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public patientnamegenerator toEntityModel() {
		patientnamegeneratorImpl patientnamegeneratorImpl = new patientnamegeneratorImpl();

		patientnamegeneratorImpl.setPatientnamegeneratorId(patientnamegeneratorId);

		if (name == null) {
			patientnamegeneratorImpl.setName(StringPool.BLANK);
		}
		else {
			patientnamegeneratorImpl.setName(name);
		}

		if (type == null) {
			patientnamegeneratorImpl.setType(StringPool.BLANK);
		}
		else {
			patientnamegeneratorImpl.setType(type);
		}

		patientnamegeneratorImpl.resetOriginalValues();

		return patientnamegeneratorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		patientnamegeneratorId = objectInput.readLong();
		name = objectInput.readUTF();
		type = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(patientnamegeneratorId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}
	}

	public long patientnamegeneratorId;
	public String name;
	public String type;
}