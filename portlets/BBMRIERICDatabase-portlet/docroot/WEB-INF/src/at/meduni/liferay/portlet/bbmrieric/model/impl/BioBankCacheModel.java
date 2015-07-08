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

import at.meduni.liferay.portlet.bbmrieric.model.BioBank;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BioBank in entity cache.
 *
 * @author reihsr
 * @see BioBank
 * @generated
 */
public class BioBankCacheModel implements CacheModel<BioBank>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{biobankId=");
		sb.append(biobankId);
		sb.append(", organisationid=");
		sb.append(organisationid);
		sb.append(", ldapbiobankID=");
		sb.append(ldapbiobankID);
		sb.append(", biobankcountry=");
		sb.append(biobankcountry);
		sb.append(", biobankname=");
		sb.append(biobankname);
		sb.append(", biobanktype=");
		sb.append(biobanktype);
		sb.append(", biobanksize=");
		sb.append(biobanksize);
		sb.append(", biobankdescription=");
		sb.append(biobankdescription);
		sb.append(", biobankjuristicperson=");
		sb.append(biobankjuristicperson);
		sb.append(", UUID=");
		sb.append(UUID);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BioBank toEntityModel() {
		BioBankImpl bioBankImpl = new BioBankImpl();

		bioBankImpl.setBiobankId(biobankId);
		bioBankImpl.setOrganisationid(organisationid);

		if (ldapbiobankID == null) {
			bioBankImpl.setLdapbiobankID(StringPool.BLANK);
		}
		else {
			bioBankImpl.setLdapbiobankID(ldapbiobankID);
		}

		if (biobankcountry == null) {
			bioBankImpl.setBiobankcountry(StringPool.BLANK);
		}
		else {
			bioBankImpl.setBiobankcountry(biobankcountry);
		}

		if (biobankname == null) {
			bioBankImpl.setBiobankname(StringPool.BLANK);
		}
		else {
			bioBankImpl.setBiobankname(biobankname);
		}

		if (biobanktype == null) {
			bioBankImpl.setBiobanktype(StringPool.BLANK);
		}
		else {
			bioBankImpl.setBiobanktype(biobanktype);
		}

		if (biobanksize == null) {
			bioBankImpl.setBiobanksize(StringPool.BLANK);
		}
		else {
			bioBankImpl.setBiobanksize(biobanksize);
		}

		if (biobankdescription == null) {
			bioBankImpl.setBiobankdescription(StringPool.BLANK);
		}
		else {
			bioBankImpl.setBiobankdescription(biobankdescription);
		}

		if (biobankjuristicperson == null) {
			bioBankImpl.setBiobankjuristicperson(StringPool.BLANK);
		}
		else {
			bioBankImpl.setBiobankjuristicperson(biobankjuristicperson);
		}

		if (UUID == null) {
			bioBankImpl.setUUID(StringPool.BLANK);
		}
		else {
			bioBankImpl.setUUID(UUID);
		}

		bioBankImpl.resetOriginalValues();

		return bioBankImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		biobankId = objectInput.readLong();
		organisationid = objectInput.readLong();
		ldapbiobankID = objectInput.readUTF();
		biobankcountry = objectInput.readUTF();
		biobankname = objectInput.readUTF();
		biobanktype = objectInput.readUTF();
		biobanksize = objectInput.readUTF();
		biobankdescription = objectInput.readUTF();
		biobankjuristicperson = objectInput.readUTF();
		UUID = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(biobankId);
		objectOutput.writeLong(organisationid);

		if (ldapbiobankID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ldapbiobankID);
		}

		if (biobankcountry == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankcountry);
		}

		if (biobankname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankname);
		}

		if (biobanktype == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobanktype);
		}

		if (biobanksize == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobanksize);
		}

		if (biobankdescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankdescription);
		}

		if (biobankjuristicperson == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biobankjuristicperson);
		}

		if (UUID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(UUID);
		}
	}

	public long biobankId;
	public long organisationid;
	public String ldapbiobankID;
	public String biobankcountry;
	public String biobankname;
	public String biobanktype;
	public String biobanksize;
	public String biobankdescription;
	public String biobankjuristicperson;
	public String UUID;
}