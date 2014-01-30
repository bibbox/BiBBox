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

package at.meduni.liferay.portlet.rdconnect.model.impl;

import at.meduni.liferay.portlet.rdconnect.model.MasterCandidate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MasterCandidate in entity cache.
 *
 * @author Robert Reihs
 * @see MasterCandidate
 * @generated
 */
public class MasterCandidateCacheModel implements CacheModel<MasterCandidate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{masterCandidateId=");
		sb.append(masterCandidateId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", url=");
		sb.append(url);
		sb.append(", contactperson=");
		sb.append(contactperson);
		sb.append(", candidatetype=");
		sb.append(candidatetype);
		sb.append(", candidatesubtype=");
		sb.append(candidatesubtype);
		sb.append(", country=");
		sb.append(country);
		sb.append(", diseasescodes=");
		sb.append(diseasescodes);
		sb.append(", diseasesfreetext=");
		sb.append(diseasesfreetext);
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", address=");
		sb.append(address);
		sb.append(", date=");
		sb.append(date);
		sb.append(", mail=");
		sb.append(mail);
		sb.append(", head=");
		sb.append(head);
		sb.append(", groupid=");
		sb.append(groupid);
		sb.append(", companyid=");
		sb.append(companyid);
		sb.append(", organisationid=");
		sb.append(organisationid);
		sb.append(", joinId=");
		sb.append(joinId);
		sb.append(", accepted=");
		sb.append(accepted);
		sb.append(", state=");
		sb.append(state);
		sb.append(", diseasescodesauto=");
		sb.append(diseasescodesauto);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MasterCandidate toEntityModel() {
		MasterCandidateImpl masterCandidateImpl = new MasterCandidateImpl();

		masterCandidateImpl.setMasterCandidateId(masterCandidateId);

		if (name == null) {
			masterCandidateImpl.setName(StringPool.BLANK);
		}
		else {
			masterCandidateImpl.setName(name);
		}

		if (url == null) {
			masterCandidateImpl.setUrl(StringPool.BLANK);
		}
		else {
			masterCandidateImpl.setUrl(url);
		}

		if (contactperson == null) {
			masterCandidateImpl.setContactperson(StringPool.BLANK);
		}
		else {
			masterCandidateImpl.setContactperson(contactperson);
		}

		if (candidatetype == null) {
			masterCandidateImpl.setCandidatetype(StringPool.BLANK);
		}
		else {
			masterCandidateImpl.setCandidatetype(candidatetype);
		}

		if (candidatesubtype == null) {
			masterCandidateImpl.setCandidatesubtype(StringPool.BLANK);
		}
		else {
			masterCandidateImpl.setCandidatesubtype(candidatesubtype);
		}

		if (country == null) {
			masterCandidateImpl.setCountry(StringPool.BLANK);
		}
		else {
			masterCandidateImpl.setCountry(country);
		}

		if (diseasescodes == null) {
			masterCandidateImpl.setDiseasescodes(StringPool.BLANK);
		}
		else {
			masterCandidateImpl.setDiseasescodes(diseasescodes);
		}

		if (diseasesfreetext == null) {
			masterCandidateImpl.setDiseasesfreetext(StringPool.BLANK);
		}
		else {
			masterCandidateImpl.setDiseasesfreetext(diseasesfreetext);
		}

		if (comment == null) {
			masterCandidateImpl.setComment(StringPool.BLANK);
		}
		else {
			masterCandidateImpl.setComment(comment);
		}

		if (address == null) {
			masterCandidateImpl.setAddress(StringPool.BLANK);
		}
		else {
			masterCandidateImpl.setAddress(address);
		}

		if (date == Long.MIN_VALUE) {
			masterCandidateImpl.setDate(null);
		}
		else {
			masterCandidateImpl.setDate(new Date(date));
		}

		if (mail == null) {
			masterCandidateImpl.setMail(StringPool.BLANK);
		}
		else {
			masterCandidateImpl.setMail(mail);
		}

		if (head == null) {
			masterCandidateImpl.setHead(StringPool.BLANK);
		}
		else {
			masterCandidateImpl.setHead(head);
		}

		masterCandidateImpl.setGroupid(groupid);
		masterCandidateImpl.setCompanyid(companyid);
		masterCandidateImpl.setOrganisationid(organisationid);
		masterCandidateImpl.setJoinId(joinId);
		masterCandidateImpl.setAccepted(accepted);

		if (state == null) {
			masterCandidateImpl.setState(StringPool.BLANK);
		}
		else {
			masterCandidateImpl.setState(state);
		}

		if (diseasescodesauto == null) {
			masterCandidateImpl.setDiseasescodesauto(StringPool.BLANK);
		}
		else {
			masterCandidateImpl.setDiseasescodesauto(diseasescodesauto);
		}

		masterCandidateImpl.resetOriginalValues();

		return masterCandidateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		masterCandidateId = objectInput.readLong();
		name = objectInput.readUTF();
		url = objectInput.readUTF();
		contactperson = objectInput.readUTF();
		candidatetype = objectInput.readUTF();
		candidatesubtype = objectInput.readUTF();
		country = objectInput.readUTF();
		diseasescodes = objectInput.readUTF();
		diseasesfreetext = objectInput.readUTF();
		comment = objectInput.readUTF();
		address = objectInput.readUTF();
		date = objectInput.readLong();
		mail = objectInput.readUTF();
		head = objectInput.readUTF();
		groupid = objectInput.readLong();
		companyid = objectInput.readLong();
		organisationid = objectInput.readLong();
		joinId = objectInput.readLong();
		accepted = objectInput.readBoolean();
		state = objectInput.readUTF();
		diseasescodesauto = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(masterCandidateId);

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

		if (contactperson == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactperson);
		}

		if (candidatetype == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(candidatetype);
		}

		if (candidatesubtype == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(candidatesubtype);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (diseasescodes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diseasescodes);
		}

		if (diseasesfreetext == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diseasesfreetext);
		}

		if (comment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comment);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		objectOutput.writeLong(date);

		if (mail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mail);
		}

		if (head == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(head);
		}

		objectOutput.writeLong(groupid);
		objectOutput.writeLong(companyid);
		objectOutput.writeLong(organisationid);
		objectOutput.writeLong(joinId);
		objectOutput.writeBoolean(accepted);

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (diseasescodesauto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(diseasescodesauto);
		}
	}

	public long masterCandidateId;
	public String name;
	public String url;
	public String contactperson;
	public String candidatetype;
	public String candidatesubtype;
	public String country;
	public String diseasescodes;
	public String diseasesfreetext;
	public String comment;
	public String address;
	public long date;
	public String mail;
	public String head;
	public long groupid;
	public long companyid;
	public long organisationid;
	public long joinId;
	public boolean accepted;
	public String state;
	public String diseasescodesauto;
}