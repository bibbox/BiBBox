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
 * This class is a wrapper for {@link Biobank}.
 * </p>
 *
 * @author suyama
 * @see Biobank
 * @generated
 */
public class BiobankWrapper implements Biobank, ModelWrapper<Biobank> {
	public BiobankWrapper(Biobank biobank) {
		_biobank = biobank;
	}

	@Override
	public Class<?> getModelClass() {
		return Biobank.class;
	}

	@Override
	public String getModelClassName() {
		return Biobank.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("biobankDbId", getBiobankDbId());
		attributes.put("biobankId", getBiobankId());
		attributes.put("acronym", getAcronym());
		attributes.put("name", getName());
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
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
	* Returns the primary key of this biobank.
	*
	* @return the primary key of this biobank
	*/
	@Override
	public long getPrimaryKey() {
		return _biobank.getPrimaryKey();
	}

	/**
	* Sets the primary key of this biobank.
	*
	* @param primaryKey the primary key of this biobank
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_biobank.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the biobank db ID of this biobank.
	*
	* @return the biobank db ID of this biobank
	*/
	@Override
	public long getBiobankDbId() {
		return _biobank.getBiobankDbId();
	}

	/**
	* Sets the biobank db ID of this biobank.
	*
	* @param biobankDbId the biobank db ID of this biobank
	*/
	@Override
	public void setBiobankDbId(long biobankDbId) {
		_biobank.setBiobankDbId(biobankDbId);
	}

	/**
	* Returns the biobank ID of this biobank.
	*
	* @return the biobank ID of this biobank
	*/
	@Override
	public java.lang.String getBiobankId() {
		return _biobank.getBiobankId();
	}

	/**
	* Sets the biobank ID of this biobank.
	*
	* @param biobankId the biobank ID of this biobank
	*/
	@Override
	public void setBiobankId(java.lang.String biobankId) {
		_biobank.setBiobankId(biobankId);
	}

	/**
	* Returns the acronym of this biobank.
	*
	* @return the acronym of this biobank
	*/
	@Override
	public java.lang.String getAcronym() {
		return _biobank.getAcronym();
	}

	/**
	* Sets the acronym of this biobank.
	*
	* @param acronym the acronym of this biobank
	*/
	@Override
	public void setAcronym(java.lang.String acronym) {
		_biobank.setAcronym(acronym);
	}

	/**
	* Returns the name of this biobank.
	*
	* @return the name of this biobank
	*/
	@Override
	public java.lang.String getName() {
		return _biobank.getName();
	}

	/**
	* Sets the name of this biobank.
	*
	* @param name the name of this biobank
	*/
	@Override
	public void setName(java.lang.String name) {
		_biobank.setName(name);
	}

	/**
	* Returns the url of this biobank.
	*
	* @return the url of this biobank
	*/
	@Override
	public java.lang.String getUrl() {
		return _biobank.getUrl();
	}

	/**
	* Sets the url of this biobank.
	*
	* @param url the url of this biobank
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_biobank.setUrl(url);
	}

	/**
	* Returns the juristic person ID of this biobank.
	*
	* @return the juristic person ID of this biobank
	*/
	@Override
	public long getJuristicPersonId() {
		return _biobank.getJuristicPersonId();
	}

	/**
	* Sets the juristic person ID of this biobank.
	*
	* @param juristicPersonId the juristic person ID of this biobank
	*/
	@Override
	public void setJuristicPersonId(long juristicPersonId) {
		_biobank.setJuristicPersonId(juristicPersonId);
	}

	/**
	* Returns the country code of this biobank.
	*
	* @return the country code of this biobank
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _biobank.getCountryCode();
	}

	/**
	* Sets the country code of this biobank.
	*
	* @param countryCode the country code of this biobank
	*/
	@Override
	public void setCountryCode(java.lang.String countryCode) {
		_biobank.setCountryCode(countryCode);
	}

	/**
	* Returns the description of this biobank.
	*
	* @return the description of this biobank
	*/
	@Override
	public java.lang.String getDescription() {
		return _biobank.getDescription();
	}

	/**
	* Sets the description of this biobank.
	*
	* @param description the description of this biobank
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_biobank.setDescription(description);
	}

	/**
	* Returns the backup of this biobank.
	*
	* @return the backup of this biobank
	*/
	@Override
	public boolean getBackup() {
		return _biobank.getBackup();
	}

	/**
	* Returns <code>true</code> if this biobank is backup.
	*
	* @return <code>true</code> if this biobank is backup; <code>false</code> otherwise
	*/
	@Override
	public boolean isBackup() {
		return _biobank.isBackup();
	}

	/**
	* Sets whether this biobank is backup.
	*
	* @param backup the backup of this biobank
	*/
	@Override
	public void setBackup(boolean backup) {
		_biobank.setBackup(backup);
	}

	/**
	* Returns the training courses of this biobank.
	*
	* @return the training courses of this biobank
	*/
	@Override
	public boolean getTrainingCourses() {
		return _biobank.getTrainingCourses();
	}

	/**
	* Returns <code>true</code> if this biobank is training courses.
	*
	* @return <code>true</code> if this biobank is training courses; <code>false</code> otherwise
	*/
	@Override
	public boolean isTrainingCourses() {
		return _biobank.isTrainingCourses();
	}

	/**
	* Sets whether this biobank is training courses.
	*
	* @param trainingCourses the training courses of this biobank
	*/
	@Override
	public void setTrainingCourses(boolean trainingCourses) {
		_biobank.setTrainingCourses(trainingCourses);
	}

	@Override
	public boolean isNew() {
		return _biobank.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_biobank.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _biobank.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_biobank.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _biobank.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _biobank.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_biobank.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _biobank.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_biobank.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_biobank.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_biobank.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BiobankWrapper((Biobank)_biobank.clone());
	}

	@Override
	public int compareTo(com.bcnet.portlet.biobank.model.Biobank biobank) {
		return _biobank.compareTo(biobank);
	}

	@Override
	public int hashCode() {
		return _biobank.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.bcnet.portlet.biobank.model.Biobank> toCacheModel() {
		return _biobank.toCacheModel();
	}

	@Override
	public com.bcnet.portlet.biobank.model.Biobank toEscapedModel() {
		return new BiobankWrapper(_biobank.toEscapedModel());
	}

	@Override
	public com.bcnet.portlet.biobank.model.Biobank toUnescapedModel() {
		return new BiobankWrapper(_biobank.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _biobank.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _biobank.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_biobank.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BiobankWrapper)) {
			return false;
		}

		BiobankWrapper biobankWrapper = (BiobankWrapper)obj;

		if (Validator.equals(_biobank, biobankWrapper._biobank)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Biobank getWrappedBiobank() {
		return _biobank;
	}

	@Override
	public Biobank getWrappedModel() {
		return _biobank;
	}

	@Override
	public void resetOriginalValues() {
		_biobank.resetOriginalValues();
	}

	private Biobank _biobank;
}