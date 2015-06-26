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

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing KdssmpPatient in entity cache.
 *
 * @author reihsr
 * @see KdssmpPatient
 * @generated
 */
public class KdssmpPatientCacheModel implements CacheModel<KdssmpPatient>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{patientId=");
		sb.append(patientId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", firstname=");
		sb.append(firstname);
		sb.append(", lastname=");
		sb.append(lastname);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", dateofbirth=");
		sb.append(dateofbirth);
		sb.append(", dateofdeath=");
		sb.append(dateofdeath);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public KdssmpPatient toEntityModel() {
		KdssmpPatientImpl kdssmpPatientImpl = new KdssmpPatientImpl();

		kdssmpPatientImpl.setPatientId(patientId);
		kdssmpPatientImpl.setOrganizationId(organizationId);

		if (firstname == null) {
			kdssmpPatientImpl.setFirstname(StringPool.BLANK);
		}
		else {
			kdssmpPatientImpl.setFirstname(firstname);
		}

		if (lastname == null) {
			kdssmpPatientImpl.setLastname(StringPool.BLANK);
		}
		else {
			kdssmpPatientImpl.setLastname(lastname);
		}

		if (gender == null) {
			kdssmpPatientImpl.setGender(StringPool.BLANK);
		}
		else {
			kdssmpPatientImpl.setGender(gender);
		}

		if (dateofbirth == Long.MIN_VALUE) {
			kdssmpPatientImpl.setDateofbirth(null);
		}
		else {
			kdssmpPatientImpl.setDateofbirth(new Date(dateofbirth));
		}

		if (dateofdeath == Long.MIN_VALUE) {
			kdssmpPatientImpl.setDateofdeath(null);
		}
		else {
			kdssmpPatientImpl.setDateofdeath(new Date(dateofdeath));
		}

		kdssmpPatientImpl.resetOriginalValues();

		return kdssmpPatientImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		patientId = objectInput.readLong();
		organizationId = objectInput.readLong();
		firstname = objectInput.readUTF();
		lastname = objectInput.readUTF();
		gender = objectInput.readUTF();
		dateofbirth = objectInput.readLong();
		dateofdeath = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(patientId);
		objectOutput.writeLong(organizationId);

		if (firstname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstname);
		}

		if (lastname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastname);
		}

		if (gender == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gender);
		}

		objectOutput.writeLong(dateofbirth);
		objectOutput.writeLong(dateofdeath);
	}

	public long patientId;
	public long organizationId;
	public String firstname;
	public String lastname;
	public String gender;
	public long dateofbirth;
	public long dateofdeath;
}