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

package at.graz.meduni.liferay.portlet.bibbox.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GeneralInformation}.
 * </p>
 *
 * @author reihsr
 * @see GeneralInformation
 * @generated
 */
public class GeneralInformationWrapper implements GeneralInformation,
	ModelWrapper<GeneralInformation> {
	public GeneralInformationWrapper(GeneralInformation generalInformation) {
		_generalInformation = generalInformation;
	}

	@Override
	public Class<?> getModelClass() {
		return GeneralInformation.class;
	}

	@Override
	public String getModelClassName() {
		return GeneralInformation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("generalinformationId", getGeneralinformationId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("acronym", getAcronym());
		attributes.put("description", getDescription());
		attributes.put("hosteinstitue", getHosteinstitue());
		attributes.put("typeofhosteinstitue", getTypeofhosteinstitue());
		attributes.put("sourceoffunding", getSourceoffunding());
		attributes.put("country", getCountry());
		attributes.put("targetpopulation", getTargetpopulation());
		attributes.put("yearofestablishment", getYearofestablishment());
		attributes.put("howmanyrdsareintheregistrybiobank",
			getHowmanyrdsareintheregistrybiobank());
		attributes.put("percentageofrarediseasesinyourregistrybiobank",
			getPercentageofrarediseasesinyourregistrybiobank());
		attributes.put("ontologies", getOntologies());
		attributes.put("biomaterialcollected", getBiomaterialcollected());
		attributes.put("biomaterialprepared", getBiomaterialprepared());
		attributes.put("origionofcollection", getOrigionofcollection());
		attributes.put("useofcollection", getUseofcollection());
		attributes.put("associateddataavailable", getAssociateddataavailable());
		attributes.put("imagingavailable", getImagingavailable());
		attributes.put("theregistrybiobanksislistedinotherinventoriesnetworks",
			getTheregistrybiobanksislistedinotherinventoriesnetworks());
		attributes.put("modifieddate", getModifieddate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long generalinformationId = (Long)attributes.get("generalinformationId");

		if (generalinformationId != null) {
			setGeneralinformationId(generalinformationId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String acronym = (String)attributes.get("acronym");

		if (acronym != null) {
			setAcronym(acronym);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String hosteinstitue = (String)attributes.get("hosteinstitue");

		if (hosteinstitue != null) {
			setHosteinstitue(hosteinstitue);
		}

		String typeofhosteinstitue = (String)attributes.get(
				"typeofhosteinstitue");

		if (typeofhosteinstitue != null) {
			setTypeofhosteinstitue(typeofhosteinstitue);
		}

		String sourceoffunding = (String)attributes.get("sourceoffunding");

		if (sourceoffunding != null) {
			setSourceoffunding(sourceoffunding);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String targetpopulation = (String)attributes.get("targetpopulation");

		if (targetpopulation != null) {
			setTargetpopulation(targetpopulation);
		}

		String yearofestablishment = (String)attributes.get(
				"yearofestablishment");

		if (yearofestablishment != null) {
			setYearofestablishment(yearofestablishment);
		}

		String howmanyrdsareintheregistrybiobank = (String)attributes.get(
				"howmanyrdsareintheregistrybiobank");

		if (howmanyrdsareintheregistrybiobank != null) {
			setHowmanyrdsareintheregistrybiobank(howmanyrdsareintheregistrybiobank);
		}

		String percentageofrarediseasesinyourregistrybiobank = (String)attributes.get(
				"percentageofrarediseasesinyourregistrybiobank");

		if (percentageofrarediseasesinyourregistrybiobank != null) {
			setPercentageofrarediseasesinyourregistrybiobank(percentageofrarediseasesinyourregistrybiobank);
		}

		String ontologies = (String)attributes.get("ontologies");

		if (ontologies != null) {
			setOntologies(ontologies);
		}

		String biomaterialcollected = (String)attributes.get(
				"biomaterialcollected");

		if (biomaterialcollected != null) {
			setBiomaterialcollected(biomaterialcollected);
		}

		String biomaterialprepared = (String)attributes.get(
				"biomaterialprepared");

		if (biomaterialprepared != null) {
			setBiomaterialprepared(biomaterialprepared);
		}

		String origionofcollection = (String)attributes.get(
				"origionofcollection");

		if (origionofcollection != null) {
			setOrigionofcollection(origionofcollection);
		}

		String useofcollection = (String)attributes.get("useofcollection");

		if (useofcollection != null) {
			setUseofcollection(useofcollection);
		}

		String associateddataavailable = (String)attributes.get(
				"associateddataavailable");

		if (associateddataavailable != null) {
			setAssociateddataavailable(associateddataavailable);
		}

		String imagingavailable = (String)attributes.get("imagingavailable");

		if (imagingavailable != null) {
			setImagingavailable(imagingavailable);
		}

		String theregistrybiobanksislistedinotherinventoriesnetworks = (String)attributes.get(
				"theregistrybiobanksislistedinotherinventoriesnetworks");

		if (theregistrybiobanksislistedinotherinventoriesnetworks != null) {
			setTheregistrybiobanksislistedinotherinventoriesnetworks(theregistrybiobanksislistedinotherinventoriesnetworks);
		}

		Date modifieddate = (Date)attributes.get("modifieddate");

		if (modifieddate != null) {
			setModifieddate(modifieddate);
		}
	}

	/**
	* Returns the primary key of this general information.
	*
	* @return the primary key of this general information
	*/
	@Override
	public long getPrimaryKey() {
		return _generalInformation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this general information.
	*
	* @param primaryKey the primary key of this general information
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_generalInformation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the generalinformation ID of this general information.
	*
	* @return the generalinformation ID of this general information
	*/
	@Override
	public long getGeneralinformationId() {
		return _generalInformation.getGeneralinformationId();
	}

	/**
	* Sets the generalinformation ID of this general information.
	*
	* @param generalinformationId the generalinformation ID of this general information
	*/
	@Override
	public void setGeneralinformationId(long generalinformationId) {
		_generalInformation.setGeneralinformationId(generalinformationId);
	}

	/**
	* Returns the organization ID of this general information.
	*
	* @return the organization ID of this general information
	*/
	@Override
	public long getOrganizationId() {
		return _generalInformation.getOrganizationId();
	}

	/**
	* Sets the organization ID of this general information.
	*
	* @param organizationId the organization ID of this general information
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_generalInformation.setOrganizationId(organizationId);
	}

	/**
	* Returns the acronym of this general information.
	*
	* @return the acronym of this general information
	*/
	@Override
	public java.lang.String getAcronym() {
		return _generalInformation.getAcronym();
	}

	/**
	* Sets the acronym of this general information.
	*
	* @param acronym the acronym of this general information
	*/
	@Override
	public void setAcronym(java.lang.String acronym) {
		_generalInformation.setAcronym(acronym);
	}

	/**
	* Returns the description of this general information.
	*
	* @return the description of this general information
	*/
	@Override
	public java.lang.String getDescription() {
		return _generalInformation.getDescription();
	}

	/**
	* Sets the description of this general information.
	*
	* @param description the description of this general information
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_generalInformation.setDescription(description);
	}

	/**
	* Returns the hosteinstitue of this general information.
	*
	* @return the hosteinstitue of this general information
	*/
	@Override
	public java.lang.String getHosteinstitue() {
		return _generalInformation.getHosteinstitue();
	}

	/**
	* Sets the hosteinstitue of this general information.
	*
	* @param hosteinstitue the hosteinstitue of this general information
	*/
	@Override
	public void setHosteinstitue(java.lang.String hosteinstitue) {
		_generalInformation.setHosteinstitue(hosteinstitue);
	}

	/**
	* Returns the typeofhosteinstitue of this general information.
	*
	* @return the typeofhosteinstitue of this general information
	*/
	@Override
	public java.lang.String getTypeofhosteinstitue() {
		return _generalInformation.getTypeofhosteinstitue();
	}

	/**
	* Sets the typeofhosteinstitue of this general information.
	*
	* @param typeofhosteinstitue the typeofhosteinstitue of this general information
	*/
	@Override
	public void setTypeofhosteinstitue(java.lang.String typeofhosteinstitue) {
		_generalInformation.setTypeofhosteinstitue(typeofhosteinstitue);
	}

	/**
	* Returns the sourceoffunding of this general information.
	*
	* @return the sourceoffunding of this general information
	*/
	@Override
	public java.lang.String getSourceoffunding() {
		return _generalInformation.getSourceoffunding();
	}

	/**
	* Sets the sourceoffunding of this general information.
	*
	* @param sourceoffunding the sourceoffunding of this general information
	*/
	@Override
	public void setSourceoffunding(java.lang.String sourceoffunding) {
		_generalInformation.setSourceoffunding(sourceoffunding);
	}

	/**
	* Returns the country of this general information.
	*
	* @return the country of this general information
	*/
	@Override
	public java.lang.String getCountry() {
		return _generalInformation.getCountry();
	}

	/**
	* Sets the country of this general information.
	*
	* @param country the country of this general information
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_generalInformation.setCountry(country);
	}

	/**
	* Returns the targetpopulation of this general information.
	*
	* @return the targetpopulation of this general information
	*/
	@Override
	public java.lang.String getTargetpopulation() {
		return _generalInformation.getTargetpopulation();
	}

	/**
	* Sets the targetpopulation of this general information.
	*
	* @param targetpopulation the targetpopulation of this general information
	*/
	@Override
	public void setTargetpopulation(java.lang.String targetpopulation) {
		_generalInformation.setTargetpopulation(targetpopulation);
	}

	/**
	* Returns the yearofestablishment of this general information.
	*
	* @return the yearofestablishment of this general information
	*/
	@Override
	public java.lang.String getYearofestablishment() {
		return _generalInformation.getYearofestablishment();
	}

	/**
	* Sets the yearofestablishment of this general information.
	*
	* @param yearofestablishment the yearofestablishment of this general information
	*/
	@Override
	public void setYearofestablishment(java.lang.String yearofestablishment) {
		_generalInformation.setYearofestablishment(yearofestablishment);
	}

	/**
	* Returns the howmanyrdsareintheregistrybiobank of this general information.
	*
	* @return the howmanyrdsareintheregistrybiobank of this general information
	*/
	@Override
	public java.lang.String getHowmanyrdsareintheregistrybiobank() {
		return _generalInformation.getHowmanyrdsareintheregistrybiobank();
	}

	/**
	* Sets the howmanyrdsareintheregistrybiobank of this general information.
	*
	* @param howmanyrdsareintheregistrybiobank the howmanyrdsareintheregistrybiobank of this general information
	*/
	@Override
	public void setHowmanyrdsareintheregistrybiobank(
		java.lang.String howmanyrdsareintheregistrybiobank) {
		_generalInformation.setHowmanyrdsareintheregistrybiobank(howmanyrdsareintheregistrybiobank);
	}

	/**
	* Returns the percentageofrarediseasesinyourregistrybiobank of this general information.
	*
	* @return the percentageofrarediseasesinyourregistrybiobank of this general information
	*/
	@Override
	public java.lang.String getPercentageofrarediseasesinyourregistrybiobank() {
		return _generalInformation.getPercentageofrarediseasesinyourregistrybiobank();
	}

	/**
	* Sets the percentageofrarediseasesinyourregistrybiobank of this general information.
	*
	* @param percentageofrarediseasesinyourregistrybiobank the percentageofrarediseasesinyourregistrybiobank of this general information
	*/
	@Override
	public void setPercentageofrarediseasesinyourregistrybiobank(
		java.lang.String percentageofrarediseasesinyourregistrybiobank) {
		_generalInformation.setPercentageofrarediseasesinyourregistrybiobank(percentageofrarediseasesinyourregistrybiobank);
	}

	/**
	* Returns the ontologies of this general information.
	*
	* @return the ontologies of this general information
	*/
	@Override
	public java.lang.String getOntologies() {
		return _generalInformation.getOntologies();
	}

	/**
	* Sets the ontologies of this general information.
	*
	* @param ontologies the ontologies of this general information
	*/
	@Override
	public void setOntologies(java.lang.String ontologies) {
		_generalInformation.setOntologies(ontologies);
	}

	/**
	* Returns the biomaterialcollected of this general information.
	*
	* @return the biomaterialcollected of this general information
	*/
	@Override
	public java.lang.String getBiomaterialcollected() {
		return _generalInformation.getBiomaterialcollected();
	}

	/**
	* Sets the biomaterialcollected of this general information.
	*
	* @param biomaterialcollected the biomaterialcollected of this general information
	*/
	@Override
	public void setBiomaterialcollected(java.lang.String biomaterialcollected) {
		_generalInformation.setBiomaterialcollected(biomaterialcollected);
	}

	/**
	* Returns the biomaterialprepared of this general information.
	*
	* @return the biomaterialprepared of this general information
	*/
	@Override
	public java.lang.String getBiomaterialprepared() {
		return _generalInformation.getBiomaterialprepared();
	}

	/**
	* Sets the biomaterialprepared of this general information.
	*
	* @param biomaterialprepared the biomaterialprepared of this general information
	*/
	@Override
	public void setBiomaterialprepared(java.lang.String biomaterialprepared) {
		_generalInformation.setBiomaterialprepared(biomaterialprepared);
	}

	/**
	* Returns the origionofcollection of this general information.
	*
	* @return the origionofcollection of this general information
	*/
	@Override
	public java.lang.String getOrigionofcollection() {
		return _generalInformation.getOrigionofcollection();
	}

	/**
	* Sets the origionofcollection of this general information.
	*
	* @param origionofcollection the origionofcollection of this general information
	*/
	@Override
	public void setOrigionofcollection(java.lang.String origionofcollection) {
		_generalInformation.setOrigionofcollection(origionofcollection);
	}

	/**
	* Returns the useofcollection of this general information.
	*
	* @return the useofcollection of this general information
	*/
	@Override
	public java.lang.String getUseofcollection() {
		return _generalInformation.getUseofcollection();
	}

	/**
	* Sets the useofcollection of this general information.
	*
	* @param useofcollection the useofcollection of this general information
	*/
	@Override
	public void setUseofcollection(java.lang.String useofcollection) {
		_generalInformation.setUseofcollection(useofcollection);
	}

	/**
	* Returns the associateddataavailable of this general information.
	*
	* @return the associateddataavailable of this general information
	*/
	@Override
	public java.lang.String getAssociateddataavailable() {
		return _generalInformation.getAssociateddataavailable();
	}

	/**
	* Sets the associateddataavailable of this general information.
	*
	* @param associateddataavailable the associateddataavailable of this general information
	*/
	@Override
	public void setAssociateddataavailable(
		java.lang.String associateddataavailable) {
		_generalInformation.setAssociateddataavailable(associateddataavailable);
	}

	/**
	* Returns the imagingavailable of this general information.
	*
	* @return the imagingavailable of this general information
	*/
	@Override
	public java.lang.String getImagingavailable() {
		return _generalInformation.getImagingavailable();
	}

	/**
	* Sets the imagingavailable of this general information.
	*
	* @param imagingavailable the imagingavailable of this general information
	*/
	@Override
	public void setImagingavailable(java.lang.String imagingavailable) {
		_generalInformation.setImagingavailable(imagingavailable);
	}

	/**
	* Returns the theregistrybiobanksislistedinotherinventoriesnetworks of this general information.
	*
	* @return the theregistrybiobanksislistedinotherinventoriesnetworks of this general information
	*/
	@Override
	public java.lang.String getTheregistrybiobanksislistedinotherinventoriesnetworks() {
		return _generalInformation.getTheregistrybiobanksislistedinotherinventoriesnetworks();
	}

	/**
	* Sets the theregistrybiobanksislistedinotherinventoriesnetworks of this general information.
	*
	* @param theregistrybiobanksislistedinotherinventoriesnetworks the theregistrybiobanksislistedinotherinventoriesnetworks of this general information
	*/
	@Override
	public void setTheregistrybiobanksislistedinotherinventoriesnetworks(
		java.lang.String theregistrybiobanksislistedinotherinventoriesnetworks) {
		_generalInformation.setTheregistrybiobanksislistedinotherinventoriesnetworks(theregistrybiobanksislistedinotherinventoriesnetworks);
	}

	/**
	* Returns the modifieddate of this general information.
	*
	* @return the modifieddate of this general information
	*/
	@Override
	public java.util.Date getModifieddate() {
		return _generalInformation.getModifieddate();
	}

	/**
	* Sets the modifieddate of this general information.
	*
	* @param modifieddate the modifieddate of this general information
	*/
	@Override
	public void setModifieddate(java.util.Date modifieddate) {
		_generalInformation.setModifieddate(modifieddate);
	}

	@Override
	public boolean isNew() {
		return _generalInformation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_generalInformation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _generalInformation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_generalInformation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _generalInformation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _generalInformation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_generalInformation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _generalInformation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_generalInformation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_generalInformation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_generalInformation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GeneralInformationWrapper((GeneralInformation)_generalInformation.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation generalInformation) {
		return _generalInformation.compareTo(generalInformation);
	}

	@Override
	public int hashCode() {
		return _generalInformation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation> toCacheModel() {
		return _generalInformation.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation toEscapedModel() {
		return new GeneralInformationWrapper(_generalInformation.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation toUnescapedModel() {
		return new GeneralInformationWrapper(_generalInformation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _generalInformation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _generalInformation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_generalInformation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeneralInformationWrapper)) {
			return false;
		}

		GeneralInformationWrapper generalInformationWrapper = (GeneralInformationWrapper)obj;

		if (Validator.equals(_generalInformation,
					generalInformationWrapper._generalInformation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GeneralInformation getWrappedGeneralInformation() {
		return _generalInformation;
	}

	@Override
	public GeneralInformation getWrappedModel() {
		return _generalInformation;
	}

	@Override
	public void resetOriginalValues() {
		_generalInformation.resetOriginalValues();
	}

	private GeneralInformation _generalInformation;
}