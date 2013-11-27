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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MasterCandidateLinkCandidate}.
 * </p>
 *
 * @author Robert Reihs
 * @see MasterCandidateLinkCandidate
 * @generated
 */
public class MasterCandidateLinkCandidateWrapper
	implements MasterCandidateLinkCandidate,
		ModelWrapper<MasterCandidateLinkCandidate> {
	public MasterCandidateLinkCandidateWrapper(
		MasterCandidateLinkCandidate masterCandidateLinkCandidate) {
		_masterCandidateLinkCandidate = masterCandidateLinkCandidate;
	}

	@Override
	public Class<?> getModelClass() {
		return MasterCandidateLinkCandidate.class;
	}

	@Override
	public String getModelClassName() {
		return MasterCandidateLinkCandidate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("linkId", getLinkId());
		attributes.put("candidateId", getCandidateId());
		attributes.put("masterCandidateId", getMasterCandidateId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long linkId = (Long)attributes.get("linkId");

		if (linkId != null) {
			setLinkId(linkId);
		}

		Long candidateId = (Long)attributes.get("candidateId");

		if (candidateId != null) {
			setCandidateId(candidateId);
		}

		Long masterCandidateId = (Long)attributes.get("masterCandidateId");

		if (masterCandidateId != null) {
			setMasterCandidateId(masterCandidateId);
		}
	}

	/**
	* Returns the primary key of this master candidate link candidate.
	*
	* @return the primary key of this master candidate link candidate
	*/
	@Override
	public long getPrimaryKey() {
		return _masterCandidateLinkCandidate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this master candidate link candidate.
	*
	* @param primaryKey the primary key of this master candidate link candidate
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_masterCandidateLinkCandidate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the link ID of this master candidate link candidate.
	*
	* @return the link ID of this master candidate link candidate
	*/
	@Override
	public long getLinkId() {
		return _masterCandidateLinkCandidate.getLinkId();
	}

	/**
	* Sets the link ID of this master candidate link candidate.
	*
	* @param linkId the link ID of this master candidate link candidate
	*/
	@Override
	public void setLinkId(long linkId) {
		_masterCandidateLinkCandidate.setLinkId(linkId);
	}

	/**
	* Returns the candidate ID of this master candidate link candidate.
	*
	* @return the candidate ID of this master candidate link candidate
	*/
	@Override
	public long getCandidateId() {
		return _masterCandidateLinkCandidate.getCandidateId();
	}

	/**
	* Sets the candidate ID of this master candidate link candidate.
	*
	* @param candidateId the candidate ID of this master candidate link candidate
	*/
	@Override
	public void setCandidateId(long candidateId) {
		_masterCandidateLinkCandidate.setCandidateId(candidateId);
	}

	/**
	* Returns the master candidate ID of this master candidate link candidate.
	*
	* @return the master candidate ID of this master candidate link candidate
	*/
	@Override
	public long getMasterCandidateId() {
		return _masterCandidateLinkCandidate.getMasterCandidateId();
	}

	/**
	* Sets the master candidate ID of this master candidate link candidate.
	*
	* @param masterCandidateId the master candidate ID of this master candidate link candidate
	*/
	@Override
	public void setMasterCandidateId(long masterCandidateId) {
		_masterCandidateLinkCandidate.setMasterCandidateId(masterCandidateId);
	}

	@Override
	public boolean isNew() {
		return _masterCandidateLinkCandidate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_masterCandidateLinkCandidate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _masterCandidateLinkCandidate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_masterCandidateLinkCandidate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _masterCandidateLinkCandidate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _masterCandidateLinkCandidate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_masterCandidateLinkCandidate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _masterCandidateLinkCandidate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_masterCandidateLinkCandidate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_masterCandidateLinkCandidate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_masterCandidateLinkCandidate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MasterCandidateLinkCandidateWrapper((MasterCandidateLinkCandidate)_masterCandidateLinkCandidate.clone());
	}

	@Override
	public int compareTo(
		MasterCandidateLinkCandidate masterCandidateLinkCandidate) {
		return _masterCandidateLinkCandidate.compareTo(masterCandidateLinkCandidate);
	}

	@Override
	public int hashCode() {
		return _masterCandidateLinkCandidate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<MasterCandidateLinkCandidate> toCacheModel() {
		return _masterCandidateLinkCandidate.toCacheModel();
	}

	@Override
	public MasterCandidateLinkCandidate toEscapedModel() {
		return new MasterCandidateLinkCandidateWrapper(_masterCandidateLinkCandidate.toEscapedModel());
	}

	@Override
	public MasterCandidateLinkCandidate toUnescapedModel() {
		return new MasterCandidateLinkCandidateWrapper(_masterCandidateLinkCandidate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _masterCandidateLinkCandidate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _masterCandidateLinkCandidate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_masterCandidateLinkCandidate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MasterCandidateLinkCandidateWrapper)) {
			return false;
		}

		MasterCandidateLinkCandidateWrapper masterCandidateLinkCandidateWrapper = (MasterCandidateLinkCandidateWrapper)obj;

		if (Validator.equals(_masterCandidateLinkCandidate,
					masterCandidateLinkCandidateWrapper._masterCandidateLinkCandidate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MasterCandidateLinkCandidate getWrappedMasterCandidateLinkCandidate() {
		return _masterCandidateLinkCandidate;
	}

	@Override
	public MasterCandidateLinkCandidate getWrappedModel() {
		return _masterCandidateLinkCandidate;
	}

	@Override
	public void resetOriginalValues() {
		_masterCandidateLinkCandidate.resetOriginalValues();
	}

	private MasterCandidateLinkCandidate _masterCandidateLinkCandidate;
}