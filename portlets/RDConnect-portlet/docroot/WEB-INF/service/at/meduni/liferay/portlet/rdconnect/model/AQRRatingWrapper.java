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
 * This class is a wrapper for {@link AQRRating}.
 * </p>
 *
 * @author Robert Reihs
 * @see AQRRating
 * @generated
 */
public class AQRRatingWrapper implements AQRRating, ModelWrapper<AQRRating> {
	public AQRRatingWrapper(AQRRating aqrRating) {
		_aqrRating = aqrRating;
	}

	@Override
	public Class<?> getModelClass() {
		return AQRRating.class;
	}

	@Override
	public String getModelClassName() {
		return AQRRating.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("aqrId", getAqrId());
		attributes.put("accessability", getAccessability());
		attributes.put("quality", getQuality());
		attributes.put("relevance", getRelevance());
		attributes.put("masterCandidateId", getMasterCandidateId());
		attributes.put("aqrrater", getAqrrater());
		attributes.put("ratingtype", getRatingtype());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long aqrId = (Long)attributes.get("aqrId");

		if (aqrId != null) {
			setAqrId(aqrId);
		}

		Long accessability = (Long)attributes.get("accessability");

		if (accessability != null) {
			setAccessability(accessability);
		}

		Long quality = (Long)attributes.get("quality");

		if (quality != null) {
			setQuality(quality);
		}

		Long relevance = (Long)attributes.get("relevance");

		if (relevance != null) {
			setRelevance(relevance);
		}

		Long masterCandidateId = (Long)attributes.get("masterCandidateId");

		if (masterCandidateId != null) {
			setMasterCandidateId(masterCandidateId);
		}

		String aqrrater = (String)attributes.get("aqrrater");

		if (aqrrater != null) {
			setAqrrater(aqrrater);
		}

		String ratingtype = (String)attributes.get("ratingtype");

		if (ratingtype != null) {
			setRatingtype(ratingtype);
		}
	}

	/**
	* Returns the primary key of this a q r rating.
	*
	* @return the primary key of this a q r rating
	*/
	@Override
	public long getPrimaryKey() {
		return _aqrRating.getPrimaryKey();
	}

	/**
	* Sets the primary key of this a q r rating.
	*
	* @param primaryKey the primary key of this a q r rating
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_aqrRating.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the aqr ID of this a q r rating.
	*
	* @return the aqr ID of this a q r rating
	*/
	@Override
	public long getAqrId() {
		return _aqrRating.getAqrId();
	}

	/**
	* Sets the aqr ID of this a q r rating.
	*
	* @param aqrId the aqr ID of this a q r rating
	*/
	@Override
	public void setAqrId(long aqrId) {
		_aqrRating.setAqrId(aqrId);
	}

	/**
	* Returns the accessability of this a q r rating.
	*
	* @return the accessability of this a q r rating
	*/
	@Override
	public long getAccessability() {
		return _aqrRating.getAccessability();
	}

	/**
	* Sets the accessability of this a q r rating.
	*
	* @param accessability the accessability of this a q r rating
	*/
	@Override
	public void setAccessability(long accessability) {
		_aqrRating.setAccessability(accessability);
	}

	/**
	* Returns the quality of this a q r rating.
	*
	* @return the quality of this a q r rating
	*/
	@Override
	public long getQuality() {
		return _aqrRating.getQuality();
	}

	/**
	* Sets the quality of this a q r rating.
	*
	* @param quality the quality of this a q r rating
	*/
	@Override
	public void setQuality(long quality) {
		_aqrRating.setQuality(quality);
	}

	/**
	* Returns the relevance of this a q r rating.
	*
	* @return the relevance of this a q r rating
	*/
	@Override
	public long getRelevance() {
		return _aqrRating.getRelevance();
	}

	/**
	* Sets the relevance of this a q r rating.
	*
	* @param relevance the relevance of this a q r rating
	*/
	@Override
	public void setRelevance(long relevance) {
		_aqrRating.setRelevance(relevance);
	}

	/**
	* Returns the master candidate ID of this a q r rating.
	*
	* @return the master candidate ID of this a q r rating
	*/
	@Override
	public long getMasterCandidateId() {
		return _aqrRating.getMasterCandidateId();
	}

	/**
	* Sets the master candidate ID of this a q r rating.
	*
	* @param masterCandidateId the master candidate ID of this a q r rating
	*/
	@Override
	public void setMasterCandidateId(long masterCandidateId) {
		_aqrRating.setMasterCandidateId(masterCandidateId);
	}

	/**
	* Returns the aqrrater of this a q r rating.
	*
	* @return the aqrrater of this a q r rating
	*/
	@Override
	public java.lang.String getAqrrater() {
		return _aqrRating.getAqrrater();
	}

	/**
	* Sets the aqrrater of this a q r rating.
	*
	* @param aqrrater the aqrrater of this a q r rating
	*/
	@Override
	public void setAqrrater(java.lang.String aqrrater) {
		_aqrRating.setAqrrater(aqrrater);
	}

	/**
	* Returns the ratingtype of this a q r rating.
	*
	* @return the ratingtype of this a q r rating
	*/
	@Override
	public java.lang.String getRatingtype() {
		return _aqrRating.getRatingtype();
	}

	/**
	* Sets the ratingtype of this a q r rating.
	*
	* @param ratingtype the ratingtype of this a q r rating
	*/
	@Override
	public void setRatingtype(java.lang.String ratingtype) {
		_aqrRating.setRatingtype(ratingtype);
	}

	@Override
	public boolean isNew() {
		return _aqrRating.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_aqrRating.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _aqrRating.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_aqrRating.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _aqrRating.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _aqrRating.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_aqrRating.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _aqrRating.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_aqrRating.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_aqrRating.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_aqrRating.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AQRRatingWrapper((AQRRating)_aqrRating.clone());
	}

	@Override
	public int compareTo(AQRRating aqrRating) {
		return _aqrRating.compareTo(aqrRating);
	}

	@Override
	public int hashCode() {
		return _aqrRating.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<AQRRating> toCacheModel() {
		return _aqrRating.toCacheModel();
	}

	@Override
	public AQRRating toEscapedModel() {
		return new AQRRatingWrapper(_aqrRating.toEscapedModel());
	}

	@Override
	public AQRRating toUnescapedModel() {
		return new AQRRatingWrapper(_aqrRating.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _aqrRating.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _aqrRating.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_aqrRating.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AQRRatingWrapper)) {
			return false;
		}

		AQRRatingWrapper aqrRatingWrapper = (AQRRatingWrapper)obj;

		if (Validator.equals(_aqrRating, aqrRatingWrapper._aqrRating)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AQRRating getWrappedAQRRating() {
		return _aqrRating;
	}

	@Override
	public AQRRating getWrappedModel() {
		return _aqrRating;
	}

	@Override
	public void resetOriginalValues() {
		_aqrRating.resetOriginalValues();
	}

	private AQRRating _aqrRating;
}