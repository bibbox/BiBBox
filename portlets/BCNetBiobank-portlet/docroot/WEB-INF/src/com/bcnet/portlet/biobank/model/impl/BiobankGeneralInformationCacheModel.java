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

import com.bcnet.portlet.biobank.model.BiobankGeneralInformation;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BiobankGeneralInformation in entity cache.
 *
 * @author suyama
 * @see BiobankGeneralInformation
 * @generated
 */
public class BiobankGeneralInformationCacheModel implements CacheModel<BiobankGeneralInformation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{biobankDbId=");
		sb.append(biobankDbId);
		sb.append(", biobankId=");
		sb.append(biobankId);
		sb.append(", acronym=");
		sb.append(acronym);
		sb.append(", url=");
		sb.append(url);
		sb.append(", juristicPersonId=");
		sb.append(juristicPersonId);
		sb.append(", countryCode=");
		sb.append(countryCode);
		sb.append(", description=");
		sb.append(description);
		sb.append(", backup=");
		sb.append(backup);
		sb.append(", trainingCourses=");
		sb.append(trainingCourses);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BiobankGeneralInformation toEntityModel() {
		BiobankGeneralInformationImpl biobankGeneralInformationImpl = new BiobankGeneralInformationImpl();

		biobankGeneralInformationImpl.setBiobankDbId(biobankDbId);

		if (biobankId == null) {
			biobankGeneralInformationImpl.setBiobankId(StringPool.BLANK);
		}
		else {
			biobankGeneralInformationImpl.setBiobankId(biobankId);
		}

		if (acronym == null) {
			biobankGeneralInformationImpl.setAcronym(StringPool.BLANK);
		}
		else {
			biobankGeneralInformationImpl.setAcronym(acronym);
		}

		if (url == null) {
			biobankGeneralInformationImpl.setUrl(StringPool.BLANK);
		}
		else {
			biobankGeneralInformationImpl.setUrl(url);
		}

		biobankGeneralInformationImpl.setJuristicPersonId(juristicPersonId);

		if (countryCode == null) {
			biobankGeneralInformationImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			biobankGeneralInformationImpl.setCountryCode(countryCode);
		}

		if (description == null) {
			biobankGeneralInformationImpl.setDescription(StringPool.BLANK);
		}
		else {
			biobankGeneralInformationImpl.setDescription(description);
		}

		biobankGeneralInformationImpl.setBackup(backup);
		biobankGeneralInformationImpl.setTrainingCourses(trainingCourses);

		biobankGeneralInformationImpl.resetOriginalValues();

		return biobankGeneralInformationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		biobankDbId = objectInput.readLong();
		biobankId = objectInput.readUTF();
		acronym = objectInput.readUTF();
		url = objectInput.readUTF();
		juristicPersonId = objectInput.readLong();
		countryCode = objectInput.readUTF();
		description = objectInput.readUTF();
		backup = objectInput.readBoolean();
		trainingCourses = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(biobankDbId);

		if (biobankId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankId);
		}

		if (acronym == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(acronym);
		}

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeLong(juristicPersonId);

		if (countryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryCode);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(backup);
		objectOutput.writeBoolean(trainingCourses);
	}

	public long biobankDbId;
	public String biobankId;
	public String acronym;
	public String url;
	public long juristicPersonId;
	public String countryCode;
	public String description;
	public boolean backup;
	public boolean trainingCourses;
}