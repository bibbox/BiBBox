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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Candidate service. Represents a row in the &quot;rdconnect.candidate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link at.meduni.liferay.portlet.rdconnect.model.impl.CandidateModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link at.meduni.liferay.portlet.rdconnect.model.impl.CandidateImpl}.
 * </p>
 *
 * @author Robert Reihs
 * @see Candidate
 * @see at.meduni.liferay.portlet.rdconnect.model.impl.CandidateImpl
 * @see at.meduni.liferay.portlet.rdconnect.model.impl.CandidateModelImpl
 * @generated
 */
public interface CandidateModel extends BaseModel<Candidate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a candidate model instance should use the {@link Candidate} interface instead.
	 */

	/**
	 * Returns the primary key of this candidate.
	 *
	 * @return the primary key of this candidate
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this candidate.
	 *
	 * @param primaryKey the primary key of this candidate
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the candidate ID of this candidate.
	 *
	 * @return the candidate ID of this candidate
	 */
	public long getCandidateId();

	/**
	 * Sets the candidate ID of this candidate.
	 *
	 * @param candidateId the candidate ID of this candidate
	 */
	public void setCandidateId(long candidateId);

	/**
	 * Returns the source of this candidate.
	 *
	 * @return the source of this candidate
	 */
	@AutoEscape
	public String getSource();

	/**
	 * Sets the source of this candidate.
	 *
	 * @param source the source of this candidate
	 */
	public void setSource(String source);

	/**
	 * Returns the name of this candidate.
	 *
	 * @return the name of this candidate
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this candidate.
	 *
	 * @param name the name of this candidate
	 */
	public void setName(String name);

	/**
	 * Returns the url of this candidate.
	 *
	 * @return the url of this candidate
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this candidate.
	 *
	 * @param url the url of this candidate
	 */
	public void setUrl(String url);

	/**
	 * Returns the contactperson of this candidate.
	 *
	 * @return the contactperson of this candidate
	 */
	@AutoEscape
	public String getContactperson();

	/**
	 * Sets the contactperson of this candidate.
	 *
	 * @param contactperson the contactperson of this candidate
	 */
	public void setContactperson(String contactperson);

	/**
	 * Returns the candidatetype of this candidate.
	 *
	 * @return the candidatetype of this candidate
	 */
	@AutoEscape
	public String getCandidatetype();

	/**
	 * Sets the candidatetype of this candidate.
	 *
	 * @param candidatetype the candidatetype of this candidate
	 */
	public void setCandidatetype(String candidatetype);

	/**
	 * Returns the candidatesubtype of this candidate.
	 *
	 * @return the candidatesubtype of this candidate
	 */
	@AutoEscape
	public String getCandidatesubtype();

	/**
	 * Sets the candidatesubtype of this candidate.
	 *
	 * @param candidatesubtype the candidatesubtype of this candidate
	 */
	public void setCandidatesubtype(String candidatesubtype);

	/**
	 * Returns the subunitof of this candidate.
	 *
	 * @return the subunitof of this candidate
	 */
	@AutoEscape
	public String getSubunitof();

	/**
	 * Sets the subunitof of this candidate.
	 *
	 * @param subunitof the subunitof of this candidate
	 */
	public void setSubunitof(String subunitof);

	/**
	 * Returns the country of this candidate.
	 *
	 * @return the country of this candidate
	 */
	@AutoEscape
	public String getCountry();

	/**
	 * Sets the country of this candidate.
	 *
	 * @param country the country of this candidate
	 */
	public void setCountry(String country);

	/**
	 * Returns the diseasescodes of this candidate.
	 *
	 * @return the diseasescodes of this candidate
	 */
	@AutoEscape
	public String getDiseasescodes();

	/**
	 * Sets the diseasescodes of this candidate.
	 *
	 * @param diseasescodes the diseasescodes of this candidate
	 */
	public void setDiseasescodes(String diseasescodes);

	/**
	 * Returns the diseasesfreetext of this candidate.
	 *
	 * @return the diseasesfreetext of this candidate
	 */
	@AutoEscape
	public String getDiseasesfreetext();

	/**
	 * Sets the diseasesfreetext of this candidate.
	 *
	 * @param diseasesfreetext the diseasesfreetext of this candidate
	 */
	public void setDiseasesfreetext(String diseasesfreetext);

	/**
	 * Returns the comment of this candidate.
	 *
	 * @return the comment of this candidate
	 */
	@AutoEscape
	public String getComment();

	/**
	 * Sets the comment of this candidate.
	 *
	 * @param comment the comment of this candidate
	 */
	public void setComment(String comment);

	/**
	 * Returns the address of this candidate.
	 *
	 * @return the address of this candidate
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this candidate.
	 *
	 * @param address the address of this candidate
	 */
	public void setAddress(String address);

	/**
	 * Returns the date of this candidate.
	 *
	 * @return the date of this candidate
	 */
	public Date getDate();

	/**
	 * Sets the date of this candidate.
	 *
	 * @param date the date of this candidate
	 */
	public void setDate(Date date);

	/**
	 * Returns the searchurl of this candidate.
	 *
	 * @return the searchurl of this candidate
	 */
	@AutoEscape
	public String getSearchurl();

	/**
	 * Sets the searchurl of this candidate.
	 *
	 * @param searchurl the searchurl of this candidate
	 */
	public void setSearchurl(String searchurl);

	/**
	 * Returns the source ID of this candidate.
	 *
	 * @return the source ID of this candidate
	 */
	@AutoEscape
	public String getSourceId();

	/**
	 * Sets the source ID of this candidate.
	 *
	 * @param sourceId the source ID of this candidate
	 */
	public void setSourceId(String sourceId);

	/**
	 * Returns the mail of this candidate.
	 *
	 * @return the mail of this candidate
	 */
	@AutoEscape
	public String getMail();

	/**
	 * Sets the mail of this candidate.
	 *
	 * @param mail the mail of this candidate
	 */
	public void setMail(String mail);

	/**
	 * Returns the head of this candidate.
	 *
	 * @return the head of this candidate
	 */
	@AutoEscape
	public String getHead();

	/**
	 * Sets the head of this candidate.
	 *
	 * @param head the head of this candidate
	 */
	public void setHead(String head);

	/**
	 * Returns the coverage of this candidate.
	 *
	 * @return the coverage of this candidate
	 */
	@AutoEscape
	public String getCoverage();

	/**
	 * Sets the coverage of this candidate.
	 *
	 * @param coverage the coverage of this candidate
	 */
	public void setCoverage(String coverage);

	/**
	 * Returns the network of this candidate.
	 *
	 * @return the network of this candidate
	 */
	@AutoEscape
	public String getNetwork();

	/**
	 * Sets the network of this candidate.
	 *
	 * @param network the network of this candidate
	 */
	public void setNetwork(String network);

	/**
	 * Returns the submittername of this candidate.
	 *
	 * @return the submittername of this candidate
	 */
	@AutoEscape
	public String getSubmittername();

	/**
	 * Sets the submittername of this candidate.
	 *
	 * @param submittername the submittername of this candidate
	 */
	public void setSubmittername(String submittername);

	/**
	 * Returns the submitteremail of this candidate.
	 *
	 * @return the submitteremail of this candidate
	 */
	@AutoEscape
	public String getSubmitteremail();

	/**
	 * Sets the submitteremail of this candidate.
	 *
	 * @param submitteremail the submitteremail of this candidate
	 */
	public void setSubmitteremail(String submitteremail);

	/**
	 * Returns the validated of this candidate.
	 *
	 * @return the validated of this candidate
	 */
	public boolean getValidated();

	/**
	 * Returns <code>true</code> if this candidate is validated.
	 *
	 * @return <code>true</code> if this candidate is validated; <code>false</code> otherwise
	 */
	public boolean isValidated();

	/**
	 * Sets whether this candidate is validated.
	 *
	 * @param validated the validated of this candidate
	 */
	public void setValidated(boolean validated);

	/**
	 * Returns the accepted of this candidate.
	 *
	 * @return the accepted of this candidate
	 */
	public boolean getAccepted();

	/**
	 * Returns <code>true</code> if this candidate is accepted.
	 *
	 * @return <code>true</code> if this candidate is accepted; <code>false</code> otherwise
	 */
	public boolean isAccepted();

	/**
	 * Sets whether this candidate is accepted.
	 *
	 * @param accepted the accepted of this candidate
	 */
	public void setAccepted(boolean accepted);

	/**
	 * Returns the master ID of this candidate.
	 *
	 * @return the master ID of this candidate
	 */
	public long getMasterId();

	/**
	 * Sets the master ID of this candidate.
	 *
	 * @param masterId the master ID of this candidate
	 */
	public void setMasterId(long masterId);

	/**
	 * Returns the state of this candidate.
	 *
	 * @return the state of this candidate
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this candidate.
	 *
	 * @param state the state of this candidate
	 */
	public void setState(String state);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Candidate candidate);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Candidate> toCacheModel();

	@Override
	public Candidate toEscapedModel();

	@Override
	public Candidate toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}