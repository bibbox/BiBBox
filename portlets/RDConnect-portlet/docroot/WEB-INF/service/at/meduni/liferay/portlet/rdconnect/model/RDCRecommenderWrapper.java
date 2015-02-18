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
 * This class is a wrapper for {@link RDCRecommender}.
 * </p>
 *
 * @author Robert Reihs
 * @see RDCRecommender
 * @generated
 */
public class RDCRecommenderWrapper implements RDCRecommender,
	ModelWrapper<RDCRecommender> {
	public RDCRecommenderWrapper(RDCRecommender rdcRecommender) {
		_rdcRecommender = rdcRecommender;
	}

	@Override
	public Class<?> getModelClass() {
		return RDCRecommender.class;
	}

	@Override
	public String getModelClassName() {
		return RDCRecommender.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("rdcrecommenderid", getRdcrecommenderid());
		attributes.put("organisationId", getOrganisationId());
		attributes.put("recommendedorganisationId",
			getRecommendedorganisationId());
		attributes.put("recommendervalue", getRecommendervalue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long rdcrecommenderid = (Long)attributes.get("rdcrecommenderid");

		if (rdcrecommenderid != null) {
			setRdcrecommenderid(rdcrecommenderid);
		}

		Long organisationId = (Long)attributes.get("organisationId");

		if (organisationId != null) {
			setOrganisationId(organisationId);
		}

		Long recommendedorganisationId = (Long)attributes.get(
				"recommendedorganisationId");

		if (recommendedorganisationId != null) {
			setRecommendedorganisationId(recommendedorganisationId);
		}

		Long recommendervalue = (Long)attributes.get("recommendervalue");

		if (recommendervalue != null) {
			setRecommendervalue(recommendervalue);
		}
	}

	/**
	* Returns the primary key of this r d c recommender.
	*
	* @return the primary key of this r d c recommender
	*/
	@Override
	public long getPrimaryKey() {
		return _rdcRecommender.getPrimaryKey();
	}

	/**
	* Sets the primary key of this r d c recommender.
	*
	* @param primaryKey the primary key of this r d c recommender
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rdcRecommender.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the rdcrecommenderid of this r d c recommender.
	*
	* @return the rdcrecommenderid of this r d c recommender
	*/
	@Override
	public long getRdcrecommenderid() {
		return _rdcRecommender.getRdcrecommenderid();
	}

	/**
	* Sets the rdcrecommenderid of this r d c recommender.
	*
	* @param rdcrecommenderid the rdcrecommenderid of this r d c recommender
	*/
	@Override
	public void setRdcrecommenderid(long rdcrecommenderid) {
		_rdcRecommender.setRdcrecommenderid(rdcrecommenderid);
	}

	/**
	* Returns the organisation ID of this r d c recommender.
	*
	* @return the organisation ID of this r d c recommender
	*/
	@Override
	public long getOrganisationId() {
		return _rdcRecommender.getOrganisationId();
	}

	/**
	* Sets the organisation ID of this r d c recommender.
	*
	* @param organisationId the organisation ID of this r d c recommender
	*/
	@Override
	public void setOrganisationId(long organisationId) {
		_rdcRecommender.setOrganisationId(organisationId);
	}

	/**
	* Returns the recommendedorganisation ID of this r d c recommender.
	*
	* @return the recommendedorganisation ID of this r d c recommender
	*/
	@Override
	public long getRecommendedorganisationId() {
		return _rdcRecommender.getRecommendedorganisationId();
	}

	/**
	* Sets the recommendedorganisation ID of this r d c recommender.
	*
	* @param recommendedorganisationId the recommendedorganisation ID of this r d c recommender
	*/
	@Override
	public void setRecommendedorganisationId(long recommendedorganisationId) {
		_rdcRecommender.setRecommendedorganisationId(recommendedorganisationId);
	}

	/**
	* Returns the recommendervalue of this r d c recommender.
	*
	* @return the recommendervalue of this r d c recommender
	*/
	@Override
	public long getRecommendervalue() {
		return _rdcRecommender.getRecommendervalue();
	}

	/**
	* Sets the recommendervalue of this r d c recommender.
	*
	* @param recommendervalue the recommendervalue of this r d c recommender
	*/
	@Override
	public void setRecommendervalue(long recommendervalue) {
		_rdcRecommender.setRecommendervalue(recommendervalue);
	}

	@Override
	public boolean isNew() {
		return _rdcRecommender.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rdcRecommender.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rdcRecommender.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rdcRecommender.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rdcRecommender.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rdcRecommender.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rdcRecommender.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rdcRecommender.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rdcRecommender.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rdcRecommender.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rdcRecommender.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RDCRecommenderWrapper((RDCRecommender)_rdcRecommender.clone());
	}

	@Override
	public int compareTo(
		at.meduni.liferay.portlet.rdconnect.model.RDCRecommender rdcRecommender) {
		return _rdcRecommender.compareTo(rdcRecommender);
	}

	@Override
	public int hashCode() {
		return _rdcRecommender.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.meduni.liferay.portlet.rdconnect.model.RDCRecommender> toCacheModel() {
		return _rdcRecommender.toCacheModel();
	}

	@Override
	public at.meduni.liferay.portlet.rdconnect.model.RDCRecommender toEscapedModel() {
		return new RDCRecommenderWrapper(_rdcRecommender.toEscapedModel());
	}

	@Override
	public at.meduni.liferay.portlet.rdconnect.model.RDCRecommender toUnescapedModel() {
		return new RDCRecommenderWrapper(_rdcRecommender.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rdcRecommender.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rdcRecommender.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rdcRecommender.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RDCRecommenderWrapper)) {
			return false;
		}

		RDCRecommenderWrapper rdcRecommenderWrapper = (RDCRecommenderWrapper)obj;

		if (Validator.equals(_rdcRecommender,
					rdcRecommenderWrapper._rdcRecommender)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RDCRecommender getWrappedRDCRecommender() {
		return _rdcRecommender;
	}

	@Override
	public RDCRecommender getWrappedModel() {
		return _rdcRecommender;
	}

	@Override
	public void resetOriginalValues() {
		_rdcRecommender.resetOriginalValues();
	}

	private RDCRecommender _rdcRecommender;
}