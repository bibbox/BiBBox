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

package com.bcnet.portlet.biobank.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BiobankGeneralInformation}.
 * </p>
 *
 * @author suyama
 * @see BiobankGeneralInformation
 * @generated
 */
public class BiobankGeneralInformationWrapper
	implements BiobankGeneralInformation,
		ModelWrapper<BiobankGeneralInformation> {
	public BiobankGeneralInformationWrapper(
		BiobankGeneralInformation biobankGeneralInformation) {
		_biobankGeneralInformation = biobankGeneralInformation;
	}

	@Override
	public Class<?> getModelClass() {
		return BiobankGeneralInformation.class;
	}

	@Override
	public String getModelClassName() {
		return BiobankGeneralInformation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("biobankDbId", getBiobankDbId());
		attributes.put("biobankId", getBiobankId());
		attributes.put("acronym", getAcronym());
		attributes.put("url", getUrl());
		attributes.put("juristicPersonId", getJuristicPersonId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("description", getDescription());
		attributes.put("backup", getBackup());
		attributes.put("trainingCourses", getTrainingCourses());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long biobankDbId = (Long)attributes.get("biobankDbId");

		if (biobankDbId != null) {
			setBiobankDbId(biobankDbId);
		}

		String biobankId = (String)attributes.get("biobankId");

		if (biobankId != null) {
			setBiobankId(biobankId);
		}

		String acronym = (String)attributes.get("acronym");

		if (acronym != null) {
			setAcronym(acronym);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Long juristicPersonId = (Long)attributes.get("juristicPersonId");

		if (juristicPersonId != null) {
			setJuristicPersonId(juristicPersonId);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean backup = (Boolean)attributes.get("backup");

		if (backup != null) {
			setBackup(backup);
		}

		Boolean trainingCourses = (Boolean)attributes.get("trainingCourses");

		if (trainingCourses != null) {
			setTrainingCourses(trainingCourses);
		}
	}

	/**
	* Returns the primary key of this biobank general information.
	*
	* @return the primary key of this biobank general information
	*/
	@Override
	public long getPrimaryKey() {
		return _biobankGeneralInformation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this biobank general information.
	*
	* @param primaryKey the primary key of this biobank general information
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_biobankGeneralInformation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the biobank db ID of this biobank general information.
	*
	* @return the biobank db ID of this biobank general information
	*/
	@Override
	public long getBiobankDbId() {
		return _biobankGeneralInformation.getBiobankDbId();
	}

	/**
	* Sets the biobank db ID of this biobank general information.
	*
	* @param biobankDbId the biobank db ID of this biobank general information
	*/
	@Override
	public void setBiobankDbId(long biobankDbId) {
		_biobankGeneralInformation.setBiobankDbId(biobankDbId);
	}

	/**
	* Returns the biobank ID of this biobank general information.
	*
	* @return the biobank ID of this biobank general information
	*/
	@Override
	public java.lang.String getBiobankId() {
		return _biobankGeneralInformation.getBiobankId();
	}

	/**
	* Sets the biobank ID of this biobank general information.
	*
	* @param biobankId the biobank ID of this biobank general information
	*/
	@Override
	public void setBiobankId(java.lang.String biobankId) {
		_biobankGeneralInformation.setBiobankId(biobankId);
	}

	/**
	* Returns the acronym of this biobank general information.
	*
	* @return the acronym of this biobank general information
	*/
	@Override
	public java.lang.String getAcronym() {
		return _biobankGeneralInformation.getAcronym();
	}

	/**
	* Sets the acronym of this biobank general information.
	*
	* @param acronym the acronym of this biobank general information
	*/
	@Override
	public void setAcronym(java.lang.String acronym) {
		_biobankGeneralInformation.setAcronym(acronym);
	}

	/**
	* Returns the url of this biobank general information.
	*
	* @return the url of this biobank general information
	*/
	@Override
	public java.lang.String getUrl() {
		return _biobankGeneralInformation.getUrl();
	}

	/**
	* Sets the url of this biobank general information.
	*
	* @param url the url of this biobank general information
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_biobankGeneralInformation.setUrl(url);
	}

	/**
	* Returns the juristic person ID of this biobank general information.
	*
	* @return the juristic person ID of this biobank general information
	*/
	@Override
	public long getJuristicPersonId() {
		return _biobankGeneralInformation.getJuristicPersonId();
	}

	/**
	* Sets the juristic person ID of this biobank general information.
	*
	* @param juristicPersonId the juristic person ID of this biobank general information
	*/
	@Override
	public void setJuristicPersonId(long juristicPersonId) {
		_biobankGeneralInformation.setJuristicPersonId(juristicPersonId);
	}

	/**
	* Returns the country code of this biobank general information.
	*
	* @return the country code of this biobank general information
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _biobankGeneralInformation.getCountryCode();
	}

	/**
	* Sets the country code of this biobank general information.
	*
	* @param countryCode the country code of this biobank general information
	*/
	@Override
	public void setCountryCode(java.lang.String countryCode) {
		_biobankGeneralInformation.setCountryCode(countryCode);
	}

	/**
	* Returns the description of this biobank general information.
	*
	* @return the description of this biobank general information
	*/
	@Override
	public java.lang.String getDescription() {
		return _biobankGeneralInformation.getDescription();
	}

	/**
	* Sets the description of this biobank general information.
	*
	* @param description the description of this biobank general information
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_biobankGeneralInformation.setDescription(description);
	}

	/**
	* Returns the backup of this biobank general information.
	*
	* @return the backup of this biobank general information
	*/
	@Override
	public boolean getBackup() {
		return _biobankGeneralInformation.getBackup();
	}

	/**
	* Returns <code>true</code> if this biobank general information is backup.
	*
	* @return <code>true</code> if this biobank general information is backup; <code>false</code> otherwise
	*/
	@Override
	public boolean isBackup() {
		return _biobankGeneralInformation.isBackup();
	}

	/**
	* Sets whether this biobank general information is backup.
	*
	* @param backup the backup of this biobank general information
	*/
	@Override
	public void setBackup(boolean backup) {
		_biobankGeneralInformation.setBackup(backup);
	}

	/**
	* Returns the training courses of this biobank general information.
	*
	* @return the training courses of this biobank general information
	*/
	@Override
	public boolean getTrainingCourses() {
		return _biobankGeneralInformation.getTrainingCourses();
	}

	/**
	* Returns <code>true</code> if this biobank general information is training courses.
	*
	* @return <code>true</code> if this biobank general information is training courses; <code>false</code> otherwise
	*/
	@Override
	public boolean isTrainingCourses() {
		return _biobankGeneralInformation.isTrainingCourses();
	}

	/**
	* Sets whether this biobank general information is training courses.
	*
	* @param trainingCourses the training courses of this biobank general information
	*/
	@Override
	public void setTrainingCourses(boolean trainingCourses) {
		_biobankGeneralInformation.setTrainingCourses(trainingCourses);
	}

	@Override
	public boolean isNew() {
		return _biobankGeneralInformation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_biobankGeneralInformation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _biobankGeneralInformation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_biobankGeneralInformation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _biobankGeneralInformation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _biobankGeneralInformation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_biobankGeneralInformation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _biobankGeneralInformation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_biobankGeneralInformation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_biobankGeneralInformation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_biobankGeneralInformation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BiobankGeneralInformationWrapper((BiobankGeneralInformation)_biobankGeneralInformation.clone());
	}

	@Override
	public int compareTo(
		com.bcnet.portlet.biobank.model.BiobankGeneralInformation biobankGeneralInformation) {
		return _biobankGeneralInformation.compareTo(biobankGeneralInformation);
	}

	@Override
	public int hashCode() {
		return _biobankGeneralInformation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.bcnet.portlet.biobank.model.BiobankGeneralInformation> toCacheModel() {
		return _biobankGeneralInformation.toCacheModel();
	}

	@Override
	public com.bcnet.portlet.biobank.model.BiobankGeneralInformation toEscapedModel() {
		return new BiobankGeneralInformationWrapper(_biobankGeneralInformation.toEscapedModel());
	}

	@Override
	public com.bcnet.portlet.biobank.model.BiobankGeneralInformation toUnescapedModel() {
		return new BiobankGeneralInformationWrapper(_biobankGeneralInformation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _biobankGeneralInformation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _biobankGeneralInformation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_biobankGeneralInformation.persist();
	}

	@Override
	public java.lang.String getBiobankName() {
		return _biobankGeneralInformation.getBiobankName();
	}

	@Override
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankAttributeLists> getBiobankAttributeLists() {
		return _biobankGeneralInformation.getBiobankAttributeLists();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BiobankGeneralInformationWrapper)) {
			return false;
		}

		BiobankGeneralInformationWrapper biobankGeneralInformationWrapper = (BiobankGeneralInformationWrapper)obj;

		if (Validator.equals(_biobankGeneralInformation,
					biobankGeneralInformationWrapper._biobankGeneralInformation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BiobankGeneralInformation getWrappedBiobankGeneralInformation() {
		return _biobankGeneralInformation;
	}

	@Override
	public BiobankGeneralInformation getWrappedModel() {
		return _biobankGeneralInformation;
	}

	@Override
	public void resetOriginalValues() {
		_biobankGeneralInformation.resetOriginalValues();
	}

	private BiobankGeneralInformation _biobankGeneralInformation;
}