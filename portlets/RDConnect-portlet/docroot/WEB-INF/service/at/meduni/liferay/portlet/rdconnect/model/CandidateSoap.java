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

package at.meduni.liferay.portlet.rdconnect.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Robert Reihs
 * @generated
 */
public class CandidateSoap implements Serializable {
	public static CandidateSoap toSoapModel(Candidate model) {
		CandidateSoap soapModel = new CandidateSoap();

		soapModel.setCandidateId(model.getCandidateId());
		soapModel.setSource(model.getSource());
		soapModel.setName(model.getName());
		soapModel.setUrl(model.getUrl());
		soapModel.setContactperson(model.getContactperson());
		soapModel.setCandidatetype(model.getCandidatetype());
		soapModel.setSubunitof(model.getSubunitof());
		soapModel.setCountry(model.getCountry());
		soapModel.setDiseasescodes(model.getDiseasescodes());
		soapModel.setDiseasesfreetext(model.getDiseasesfreetext());
		soapModel.setComment(model.getComment());
		soapModel.setAddress(model.getAddress());
		soapModel.setDate(model.getDate());
		soapModel.setSearchurl(model.getSearchurl());
		soapModel.setSourceId(model.getSourceId());
		soapModel.setMail(model.getMail());
		soapModel.setHead(model.getHead());
		soapModel.setCoverage(model.getCoverage());
		soapModel.setNetwork(model.getNetwork());
		soapModel.setSubmittername(model.getSubmittername());
		soapModel.setSubmitteremail(model.getSubmitteremail());
		soapModel.setValidated(model.getValidated());
		soapModel.setAccepted(model.getAccepted());
		soapModel.setMasterId(model.getMasterId());

		return soapModel;
	}

	public static CandidateSoap[] toSoapModels(Candidate[] models) {
		CandidateSoap[] soapModels = new CandidateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CandidateSoap[][] toSoapModels(Candidate[][] models) {
		CandidateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CandidateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CandidateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CandidateSoap[] toSoapModels(List<Candidate> models) {
		List<CandidateSoap> soapModels = new ArrayList<CandidateSoap>(models.size());

		for (Candidate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CandidateSoap[soapModels.size()]);
	}

	public CandidateSoap() {
	}

	public long getPrimaryKey() {
		return _candidateId;
	}

	public void setPrimaryKey(long pk) {
		setCandidateId(pk);
	}

	public long getCandidateId() {
		return _candidateId;
	}

	public void setCandidateId(long candidateId) {
		_candidateId = candidateId;
	}

	public String getSource() {
		return _source;
	}

	public void setSource(String source) {
		_source = source;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getContactperson() {
		return _contactperson;
	}

	public void setContactperson(String contactperson) {
		_contactperson = contactperson;
	}

	public String getCandidatetype() {
		return _candidatetype;
	}

	public void setCandidatetype(String candidatetype) {
		_candidatetype = candidatetype;
	}

	public String getSubunitof() {
		return _subunitof;
	}

	public void setSubunitof(String subunitof) {
		_subunitof = subunitof;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getDiseasescodes() {
		return _diseasescodes;
	}

	public void setDiseasescodes(String diseasescodes) {
		_diseasescodes = diseasescodes;
	}

	public String getDiseasesfreetext() {
		return _diseasesfreetext;
	}

	public void setDiseasesfreetext(String diseasesfreetext) {
		_diseasesfreetext = diseasesfreetext;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public String getSearchurl() {
		return _searchurl;
	}

	public void setSearchurl(String searchurl) {
		_searchurl = searchurl;
	}

	public String getSourceId() {
		return _sourceId;
	}

	public void setSourceId(String sourceId) {
		_sourceId = sourceId;
	}

	public String getMail() {
		return _mail;
	}

	public void setMail(String mail) {
		_mail = mail;
	}

	public String getHead() {
		return _head;
	}

	public void setHead(String head) {
		_head = head;
	}

	public String getCoverage() {
		return _coverage;
	}

	public void setCoverage(String coverage) {
		_coverage = coverage;
	}

	public String getNetwork() {
		return _network;
	}

	public void setNetwork(String network) {
		_network = network;
	}

	public String getSubmittername() {
		return _submittername;
	}

	public void setSubmittername(String submittername) {
		_submittername = submittername;
	}

	public String getSubmitteremail() {
		return _submitteremail;
	}

	public void setSubmitteremail(String submitteremail) {
		_submitteremail = submitteremail;
	}

	public boolean getValidated() {
		return _validated;
	}

	public boolean isValidated() {
		return _validated;
	}

	public void setValidated(boolean validated) {
		_validated = validated;
	}

	public boolean getAccepted() {
		return _accepted;
	}

	public boolean isAccepted() {
		return _accepted;
	}

	public void setAccepted(boolean accepted) {
		_accepted = accepted;
	}

	public long getMasterId() {
		return _masterId;
	}

	public void setMasterId(long masterId) {
		_masterId = masterId;
	}

	private long _candidateId;
	private String _source;
	private String _name;
	private String _url;
	private String _contactperson;
	private String _candidatetype;
	private String _subunitof;
	private String _country;
	private String _diseasescodes;
	private String _diseasesfreetext;
	private String _comment;
	private String _address;
	private Date _date;
	private String _searchurl;
	private String _sourceId;
	private String _mail;
	private String _head;
	private String _coverage;
	private String _network;
	private String _submittername;
	private String _submitteremail;
	private boolean _validated;
	private boolean _accepted;
	private long _masterId;
}