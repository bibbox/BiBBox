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

import com.bcnet.portlet.biobank.model.Biobank;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Biobank in entity cache.
 *
 * @author suyama
 * @see Biobank
 * @generated
 */
public class BiobankCacheModel implements CacheModel<Biobank>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{biobankDbId=");
		sb.append(biobankDbId);
		sb.append(", biobankId=");
		sb.append(biobankId);
		sb.append(", acronym=");
		sb.append(acronym);
		sb.append(", name=");
		sb.append(name);
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
	public Biobank toEntityModel() {
		BiobankImpl biobankImpl = new BiobankImpl();

		biobankImpl.setBiobankDbId(biobankDbId);

		if (biobankId == null) {
			biobankImpl.setBiobankId(StringPool.BLANK);
		}
		else {
			biobankImpl.setBiobankId(biobankId);
		}

		if (acronym == null) {
			biobankImpl.setAcronym(StringPool.BLANK);
		}
		else {
			biobankImpl.setAcronym(acronym);
		}

		if (name == null) {
			biobankImpl.setName(StringPool.BLANK);
		}
		else {
			biobankImpl.setName(name);
		}

		if (url == null) {
			biobankImpl.setUrl(StringPool.BLANK);
		}
		else {
			biobankImpl.setUrl(url);
		}

		biobankImpl.setJuristicPersonId(juristicPersonId);

		if (countryCode == null) {
			biobankImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			biobankImpl.setCountryCode(countryCode);
		}

		if (description == null) {
			biobankImpl.setDescription(StringPool.BLANK);
		}
		else {
			biobankImpl.setDescription(description);
		}

		biobankImpl.setBackup(backup);
		biobankImpl.setTrainingCourses(trainingCourses);

		biobankImpl.resetOriginalValues();

		return biobankImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		biobankDbId = objectInput.readLong();
		biobankId = objectInput.readUTF();
		acronym = objectInput.readUTF();
		name = objectInput.readUTF();
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

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
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
	public String name;
	public String url;
	public long juristicPersonId;
	public String countryCode;
	public String description;
	public boolean backup;
	public boolean trainingCourses;
}