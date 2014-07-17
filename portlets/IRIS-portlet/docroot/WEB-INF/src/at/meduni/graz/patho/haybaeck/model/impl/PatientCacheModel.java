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

package at.meduni.graz.patho.haybaeck.model.impl;

import at.meduni.graz.patho.haybaeck.model.Patient;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Patient in entity cache.
 *
 * @author reihsr
 * @see Patient
 * @generated
 */
public class PatientCacheModel implements CacheModel<Patient>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{patient_Id=");
		sb.append(patient_Id);
		sb.append(", identifier=");
		sb.append(identifier);
		sb.append(", cohort=");
		sb.append(cohort);
		sb.append(", first_name=");
		sb.append(first_name);
		sb.append(", last_name=");
		sb.append(last_name);
		sb.append(", date_of_birth=");
		sb.append(date_of_birth);
		sb.append(", date_of_death=");
		sb.append(date_of_death);
		sb.append(", couse_of_death=");
		sb.append(couse_of_death);
		sb.append(", gender=");
		sb.append(gender);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Patient toEntityModel() {
		PatientImpl patientImpl = new PatientImpl();

		patientImpl.setPatient_Id(patient_Id);

		if (identifier == null) {
			patientImpl.setIdentifier(StringPool.BLANK);
		}
		else {
			patientImpl.setIdentifier(identifier);
		}

		if (cohort == null) {
			patientImpl.setCohort(StringPool.BLANK);
		}
		else {
			patientImpl.setCohort(cohort);
		}

		if (first_name == null) {
			patientImpl.setFirst_name(StringPool.BLANK);
		}
		else {
			patientImpl.setFirst_name(first_name);
		}

		if (last_name == null) {
			patientImpl.setLast_name(StringPool.BLANK);
		}
		else {
			patientImpl.setLast_name(last_name);
		}

		if (date_of_birth == Long.MIN_VALUE) {
			patientImpl.setDate_of_birth(null);
		}
		else {
			patientImpl.setDate_of_birth(new Date(date_of_birth));
		}

		if (date_of_death == Long.MIN_VALUE) {
			patientImpl.setDate_of_death(null);
		}
		else {
			patientImpl.setDate_of_death(new Date(date_of_death));
		}

		if (couse_of_death == null) {
			patientImpl.setCouse_of_death(StringPool.BLANK);
		}
		else {
			patientImpl.setCouse_of_death(couse_of_death);
		}

		if (gender == null) {
			patientImpl.setGender(StringPool.BLANK);
		}
		else {
			patientImpl.setGender(gender);
		}

		patientImpl.resetOriginalValues();

		return patientImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		patient_Id = objectInput.readLong();
		identifier = objectInput.readUTF();
		cohort = objectInput.readUTF();
		first_name = objectInput.readUTF();
		last_name = objectInput.readUTF();
		date_of_birth = objectInput.readLong();
		date_of_death = objectInput.readLong();
		couse_of_death = objectInput.readUTF();
		gender = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(patient_Id);

		if (identifier == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(identifier);
		}

		if (cohort == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cohort);
		}

		if (first_name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(first_name);
		}

		if (last_name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(last_name);
		}

		objectOutput.writeLong(date_of_birth);
		objectOutput.writeLong(date_of_death);

		if (couse_of_death == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(couse_of_death);
		}

		if (gender == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gender);
		}
	}

	public long patient_Id;
	public String identifier;
	public String cohort;
	public String first_name;
	public String last_name;
	public long date_of_birth;
	public long date_of_death;
	public String couse_of_death;
	public String gender;
}