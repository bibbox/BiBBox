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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Candidate}.
 * </p>
 *
 * @author Robert Reihs
 * @see Candidate
 * @generated
 */
public class CandidateWrapper implements Candidate, ModelWrapper<Candidate> {
	public CandidateWrapper(Candidate candidate) {
		_candidate = candidate;
	}

	@Override
	public Class<?> getModelClass() {
		return Candidate.class;
	}

	@Override
	public String getModelClassName() {
		return Candidate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("candidateId", getCandidateId());
		attributes.put("source", getSource());
		attributes.put("name", getName());
		attributes.put("url", getUrl());
		attributes.put("contactperson", getContactperson());
		attributes.put("candidatetype", getCandidatetype());
		attributes.put("subunitof", getSubunitof());
		attributes.put("country", getCountry());
		attributes.put("diseasescodes", getDiseasescodes());
		attributes.put("diseasesfreetext", getDiseasesfreetext());
		attributes.put("comment", getComment());
		attributes.put("address", getAddress());
		attributes.put("date", getDate());
		attributes.put("searchurl", getSearchurl());
		attributes.put("sourceId", getSourceId());
		attributes.put("mail", getMail());
		attributes.put("head", getHead());
		attributes.put("submittername", getSubmittername());
		attributes.put("submitteremail", getSubmitteremail());
		attributes.put("validated", getValidated());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long candidateId = (Long)attributes.get("candidateId");

		if (candidateId != null) {
			setCandidateId(candidateId);
		}

		String source = (String)attributes.get("source");

		if (source != null) {
			setSource(source);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String contactperson = (String)attributes.get("contactperson");

		if (contactperson != null) {
			setContactperson(contactperson);
		}

		String candidatetype = (String)attributes.get("candidatetype");

		if (candidatetype != null) {
			setCandidatetype(candidatetype);
		}

		String subunitof = (String)attributes.get("subunitof");

		if (subunitof != null) {
			setSubunitof(subunitof);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String diseasescodes = (String)attributes.get("diseasescodes");

		if (diseasescodes != null) {
			setDiseasescodes(diseasescodes);
		}

		String diseasesfreetext = (String)attributes.get("diseasesfreetext");

		if (diseasesfreetext != null) {
			setDiseasesfreetext(diseasesfreetext);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		String searchurl = (String)attributes.get("searchurl");

		if (searchurl != null) {
			setSearchurl(searchurl);
		}

		String sourceId = (String)attributes.get("sourceId");

		if (sourceId != null) {
			setSourceId(sourceId);
		}

		String mail = (String)attributes.get("mail");

		if (mail != null) {
			setMail(mail);
		}

		String head = (String)attributes.get("head");

		if (head != null) {
			setHead(head);
		}

		String submittername = (String)attributes.get("submittername");

		if (submittername != null) {
			setSubmittername(submittername);
		}

		String submitteremail = (String)attributes.get("submitteremail");

		if (submitteremail != null) {
			setSubmitteremail(submitteremail);
		}

		Boolean validated = (Boolean)attributes.get("validated");

		if (validated != null) {
			setValidated(validated);
		}
	}

	/**
	* Returns the primary key of this candidate.
	*
	* @return the primary key of this candidate
	*/
	@Override
	public long getPrimaryKey() {
		return _candidate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this candidate.
	*
	* @param primaryKey the primary key of this candidate
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_candidate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the candidate ID of this candidate.
	*
	* @return the candidate ID of this candidate
	*/
	@Override
	public long getCandidateId() {
		return _candidate.getCandidateId();
	}

	/**
	* Sets the candidate ID of this candidate.
	*
	* @param candidateId the candidate ID of this candidate
	*/
	@Override
	public void setCandidateId(long candidateId) {
		_candidate.setCandidateId(candidateId);
	}

	/**
	* Returns the source of this candidate.
	*
	* @return the source of this candidate
	*/
	@Override
	public java.lang.String getSource() {
		return _candidate.getSource();
	}

	/**
	* Sets the source of this candidate.
	*
	* @param source the source of this candidate
	*/
	@Override
	public void setSource(java.lang.String source) {
		_candidate.setSource(source);
	}

	/**
	* Returns the name of this candidate.
	*
	* @return the name of this candidate
	*/
	@Override
	public java.lang.String getName() {
		return _candidate.getName();
	}

	/**
	* Sets the name of this candidate.
	*
	* @param name the name of this candidate
	*/
	@Override
	public void setName(java.lang.String name) {
		_candidate.setName(name);
	}

	/**
	* Returns the url of this candidate.
	*
	* @return the url of this candidate
	*/
	@Override
	public java.lang.String getUrl() {
		return _candidate.getUrl();
	}

	/**
	* Sets the url of this candidate.
	*
	* @param url the url of this candidate
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_candidate.setUrl(url);
	}

	/**
	* Returns the contactperson of this candidate.
	*
	* @return the contactperson of this candidate
	*/
	@Override
	public java.lang.String getContactperson() {
		return _candidate.getContactperson();
	}

	/**
	* Sets the contactperson of this candidate.
	*
	* @param contactperson the contactperson of this candidate
	*/
	@Override
	public void setContactperson(java.lang.String contactperson) {
		_candidate.setContactperson(contactperson);
	}

	/**
	* Returns the candidatetype of this candidate.
	*
	* @return the candidatetype of this candidate
	*/
	@Override
	public java.lang.String getCandidatetype() {
		return _candidate.getCandidatetype();
	}

	/**
	* Sets the candidatetype of this candidate.
	*
	* @param candidatetype the candidatetype of this candidate
	*/
	@Override
	public void setCandidatetype(java.lang.String candidatetype) {
		_candidate.setCandidatetype(candidatetype);
	}

	/**
	* Returns the subunitof of this candidate.
	*
	* @return the subunitof of this candidate
	*/
	@Override
	public java.lang.String getSubunitof() {
		return _candidate.getSubunitof();
	}

	/**
	* Sets the subunitof of this candidate.
	*
	* @param subunitof the subunitof of this candidate
	*/
	@Override
	public void setSubunitof(java.lang.String subunitof) {
		_candidate.setSubunitof(subunitof);
	}

	/**
	* Returns the country of this candidate.
	*
	* @return the country of this candidate
	*/
	@Override
	public java.lang.String getCountry() {
		return _candidate.getCountry();
	}

	/**
	* Sets the country of this candidate.
	*
	* @param country the country of this candidate
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_candidate.setCountry(country);
	}

	/**
	* Returns the diseasescodes of this candidate.
	*
	* @return the diseasescodes of this candidate
	*/
	@Override
	public java.lang.String getDiseasescodes() {
		return _candidate.getDiseasescodes();
	}

	/**
	* Sets the diseasescodes of this candidate.
	*
	* @param diseasescodes the diseasescodes of this candidate
	*/
	@Override
	public void setDiseasescodes(java.lang.String diseasescodes) {
		_candidate.setDiseasescodes(diseasescodes);
	}

	/**
	* Returns the diseasesfreetext of this candidate.
	*
	* @return the diseasesfreetext of this candidate
	*/
	@Override
	public java.lang.String getDiseasesfreetext() {
		return _candidate.getDiseasesfreetext();
	}

	/**
	* Sets the diseasesfreetext of this candidate.
	*
	* @param diseasesfreetext the diseasesfreetext of this candidate
	*/
	@Override
	public void setDiseasesfreetext(java.lang.String diseasesfreetext) {
		_candidate.setDiseasesfreetext(diseasesfreetext);
	}

	/**
	* Returns the comment of this candidate.
	*
	* @return the comment of this candidate
	*/
	@Override
	public java.lang.String getComment() {
		return _candidate.getComment();
	}

	/**
	* Sets the comment of this candidate.
	*
	* @param comment the comment of this candidate
	*/
	@Override
	public void setComment(java.lang.String comment) {
		_candidate.setComment(comment);
	}

	/**
	* Returns the address of this candidate.
	*
	* @return the address of this candidate
	*/
	@Override
	public java.lang.String getAddress() {
		return _candidate.getAddress();
	}

	/**
	* Sets the address of this candidate.
	*
	* @param address the address of this candidate
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_candidate.setAddress(address);
	}

	/**
	* Returns the date of this candidate.
	*
	* @return the date of this candidate
	*/
	@Override
	public java.util.Date getDate() {
		return _candidate.getDate();
	}

	/**
	* Sets the date of this candidate.
	*
	* @param date the date of this candidate
	*/
	@Override
	public void setDate(java.util.Date date) {
		_candidate.setDate(date);
	}

	/**
	* Returns the searchurl of this candidate.
	*
	* @return the searchurl of this candidate
	*/
	@Override
	public java.lang.String getSearchurl() {
		return _candidate.getSearchurl();
	}

	/**
	* Sets the searchurl of this candidate.
	*
	* @param searchurl the searchurl of this candidate
	*/
	@Override
	public void setSearchurl(java.lang.String searchurl) {
		_candidate.setSearchurl(searchurl);
	}

	/**
	* Returns the source ID of this candidate.
	*
	* @return the source ID of this candidate
	*/
	@Override
	public java.lang.String getSourceId() {
		return _candidate.getSourceId();
	}

	/**
	* Sets the source ID of this candidate.
	*
	* @param sourceId the source ID of this candidate
	*/
	@Override
	public void setSourceId(java.lang.String sourceId) {
		_candidate.setSourceId(sourceId);
	}

	/**
	* Returns the mail of this candidate.
	*
	* @return the mail of this candidate
	*/
	@Override
	public java.lang.String getMail() {
		return _candidate.getMail();
	}

	/**
	* Sets the mail of this candidate.
	*
	* @param mail the mail of this candidate
	*/
	@Override
	public void setMail(java.lang.String mail) {
		_candidate.setMail(mail);
	}

	/**
	* Returns the head of this candidate.
	*
	* @return the head of this candidate
	*/
	@Override
	public java.lang.String getHead() {
		return _candidate.getHead();
	}

	/**
	* Sets the head of this candidate.
	*
	* @param head the head of this candidate
	*/
	@Override
	public void setHead(java.lang.String head) {
		_candidate.setHead(head);
	}

	/**
	* Returns the submittername of this candidate.
	*
	* @return the submittername of this candidate
	*/
	@Override
	public java.lang.String getSubmittername() {
		return _candidate.getSubmittername();
	}

	/**
	* Sets the submittername of this candidate.
	*
	* @param submittername the submittername of this candidate
	*/
	@Override
	public void setSubmittername(java.lang.String submittername) {
		_candidate.setSubmittername(submittername);
	}

	/**
	* Returns the submitteremail of this candidate.
	*
	* @return the submitteremail of this candidate
	*/
	@Override
	public java.lang.String getSubmitteremail() {
		return _candidate.getSubmitteremail();
	}

	/**
	* Sets the submitteremail of this candidate.
	*
	* @param submitteremail the submitteremail of this candidate
	*/
	@Override
	public void setSubmitteremail(java.lang.String submitteremail) {
		_candidate.setSubmitteremail(submitteremail);
	}

	/**
	* Returns the validated of this candidate.
	*
	* @return the validated of this candidate
	*/
	@Override
	public boolean getValidated() {
		return _candidate.getValidated();
	}

	/**
	* Returns <code>true</code> if this candidate is validated.
	*
	* @return <code>true</code> if this candidate is validated; <code>false</code> otherwise
	*/
	@Override
	public boolean isValidated() {
		return _candidate.isValidated();
	}

	/**
	* Sets whether this candidate is validated.
	*
	* @param validated the validated of this candidate
	*/
	@Override
	public void setValidated(boolean validated) {
		_candidate.setValidated(validated);
	}

	@Override
	public boolean isNew() {
		return _candidate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_candidate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _candidate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_candidate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _candidate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _candidate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_candidate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _candidate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_candidate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_candidate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_candidate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CandidateWrapper((Candidate)_candidate.clone());
	}

	@Override
	public int compareTo(
		at.meduni.liferay.portlet.rdconnect.model.Candidate candidate) {
		return _candidate.compareTo(candidate);
	}

	@Override
	public int hashCode() {
		return _candidate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.meduni.liferay.portlet.rdconnect.model.Candidate> toCacheModel() {
		return _candidate.toCacheModel();
	}

	@Override
	public at.meduni.liferay.portlet.rdconnect.model.Candidate toEscapedModel() {
		return new CandidateWrapper(_candidate.toEscapedModel());
	}

	@Override
	public at.meduni.liferay.portlet.rdconnect.model.Candidate toUnescapedModel() {
		return new CandidateWrapper(_candidate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _candidate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _candidate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_candidate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateWrapper)) {
			return false;
		}

		CandidateWrapper candidateWrapper = (CandidateWrapper)obj;

		if (Validator.equals(_candidate, candidateWrapper._candidate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Candidate getWrappedCandidate() {
		return _candidate;
	}

	@Override
	public Candidate getWrappedModel() {
		return _candidate;
	}

	@Override
	public void resetOriginalValues() {
		_candidate.resetOriginalValues();
	}

	private Candidate _candidate;
}