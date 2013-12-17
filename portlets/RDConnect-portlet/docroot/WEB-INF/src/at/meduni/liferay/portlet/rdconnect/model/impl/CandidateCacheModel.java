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

import at.meduni.liferay.portlet.rdconnect.model.Candidate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Candidate in entity cache.
 *
 * @author Robert Reihs
 * @see Candidate
 * @generated
 */
public class CandidateCacheModel implements CacheModel<Candidate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{candidateId=");
		sb.append(candidateId);
		sb.append(", source=");
		sb.append(source);
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
		sb.append(", subunitof=");
		sb.append(subunitof);
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
		sb.append(", searchurl=");
		sb.append(searchurl);
		sb.append(", sourceId=");
		sb.append(sourceId);
		sb.append(", mail=");
		sb.append(mail);
		sb.append(", head=");
		sb.append(head);
		sb.append(", coverage=");
		sb.append(coverage);
		sb.append(", network=");
		sb.append(network);
		sb.append(", submittername=");
		sb.append(submittername);
		sb.append(", submitteremail=");
		sb.append(submitteremail);
		sb.append(", validated=");
		sb.append(validated);
		sb.append(", accepted=");
		sb.append(accepted);
		sb.append(", masterId=");
		sb.append(masterId);
		sb.append(", state=");
		sb.append(state);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Candidate toEntityModel() {
		CandidateImpl candidateImpl = new CandidateImpl();

		candidateImpl.setCandidateId(candidateId);

		if (source == null) {
			candidateImpl.setSource(StringPool.BLANK);
		}
		else {
			candidateImpl.setSource(source);
		}

		if (name == null) {
			candidateImpl.setName(StringPool.BLANK);
		}
		else {
			candidateImpl.setName(name);
		}

		if (url == null) {
			candidateImpl.setUrl(StringPool.BLANK);
		}
		else {
			candidateImpl.setUrl(url);
		}

		if (contactperson == null) {
			candidateImpl.setContactperson(StringPool.BLANK);
		}
		else {
			candidateImpl.setContactperson(contactperson);
		}

		if (candidatetype == null) {
			candidateImpl.setCandidatetype(StringPool.BLANK);
		}
		else {
			candidateImpl.setCandidatetype(candidatetype);
		}

		if (candidatesubtype == null) {
			candidateImpl.setCandidatesubtype(StringPool.BLANK);
		}
		else {
			candidateImpl.setCandidatesubtype(candidatesubtype);
		}

		if (subunitof == null) {
			candidateImpl.setSubunitof(StringPool.BLANK);
		}
		else {
			candidateImpl.setSubunitof(subunitof);
		}

		if (country == null) {
			candidateImpl.setCountry(StringPool.BLANK);
		}
		else {
			candidateImpl.setCountry(country);
		}

		if (diseasescodes == null) {
			candidateImpl.setDiseasescodes(StringPool.BLANK);
		}
		else {
			candidateImpl.setDiseasescodes(diseasescodes);
		}

		if (diseasesfreetext == null) {
			candidateImpl.setDiseasesfreetext(StringPool.BLANK);
		}
		else {
			candidateImpl.setDiseasesfreetext(diseasesfreetext);
		}

		if (comment == null) {
			candidateImpl.setComment(StringPool.BLANK);
		}
		else {
			candidateImpl.setComment(comment);
		}

		if (address == null) {
			candidateImpl.setAddress(StringPool.BLANK);
		}
		else {
			candidateImpl.setAddress(address);
		}

		if (date == Long.MIN_VALUE) {
			candidateImpl.setDate(null);
		}
		else {
			candidateImpl.setDate(new Date(date));
		}

		if (searchurl == null) {
			candidateImpl.setSearchurl(StringPool.BLANK);
		}
		else {
			candidateImpl.setSearchurl(searchurl);
		}

		if (sourceId == null) {
			candidateImpl.setSourceId(StringPool.BLANK);
		}
		else {
			candidateImpl.setSourceId(sourceId);
		}

		if (mail == null) {
			candidateImpl.setMail(StringPool.BLANK);
		}
		else {
			candidateImpl.setMail(mail);
		}

		if (head == null) {
			candidateImpl.setHead(StringPool.BLANK);
		}
		else {
			candidateImpl.setHead(head);
		}

		if (coverage == null) {
			candidateImpl.setCoverage(StringPool.BLANK);
		}
		else {
			candidateImpl.setCoverage(coverage);
		}

		if (network == null) {
			candidateImpl.setNetwork(StringPool.BLANK);
		}
		else {
			candidateImpl.setNetwork(network);
		}

		if (submittername == null) {
			candidateImpl.setSubmittername(StringPool.BLANK);
		}
		else {
			candidateImpl.setSubmittername(submittername);
		}

		if (submitteremail == null) {
			candidateImpl.setSubmitteremail(StringPool.BLANK);
		}
		else {
			candidateImpl.setSubmitteremail(submitteremail);
		}

		candidateImpl.setValidated(validated);
		candidateImpl.setAccepted(accepted);
		candidateImpl.setMasterId(masterId);

		if (state == null) {
			candidateImpl.setState(StringPool.BLANK);
		}
		else {
			candidateImpl.setState(state);
		}

		candidateImpl.resetOriginalValues();

		return candidateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		candidateId = objectInput.readLong();
		source = objectInput.readUTF();
		name = objectInput.readUTF();
		url = objectInput.readUTF();
		contactperson = objectInput.readUTF();
		candidatetype = objectInput.readUTF();
		candidatesubtype = objectInput.readUTF();
		subunitof = objectInput.readUTF();
		country = objectInput.readUTF();
		diseasescodes = objectInput.readUTF();
		diseasesfreetext = objectInput.readUTF();
		comment = objectInput.readUTF();
		address = objectInput.readUTF();
		date = objectInput.readLong();
		searchurl = objectInput.readUTF();
		sourceId = objectInput.readUTF();
		mail = objectInput.readUTF();
		head = objectInput.readUTF();
		coverage = objectInput.readUTF();
		network = objectInput.readUTF();
		submittername = objectInput.readUTF();
		submitteremail = objectInput.readUTF();
		validated = objectInput.readBoolean();
		accepted = objectInput.readBoolean();
		masterId = objectInput.readLong();
		state = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(candidateId);

		if (source == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(source);
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

		if (subunitof == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subunitof);
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

		if (searchurl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(searchurl);
		}

		if (sourceId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sourceId);
		}

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

		if (coverage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(coverage);
		}

		if (network == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(network);
		}

		if (submittername == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(submittername);
		}

		if (submitteremail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(submitteremail);
		}

		objectOutput.writeBoolean(validated);
		objectOutput.writeBoolean(accepted);
		objectOutput.writeLong(masterId);

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}
	}

	public long candidateId;
	public String source;
	public String name;
	public String url;
	public String contactperson;
	public String candidatetype;
	public String candidatesubtype;
	public String subunitof;
	public String country;
	public String diseasescodes;
	public String diseasesfreetext;
	public String comment;
	public String address;
	public long date;
	public String searchurl;
	public String sourceId;
	public String mail;
	public String head;
	public String coverage;
	public String network;
	public String submittername;
	public String submitteremail;
	public boolean validated;
	public boolean accepted;
	public long masterId;
	public String state;
}