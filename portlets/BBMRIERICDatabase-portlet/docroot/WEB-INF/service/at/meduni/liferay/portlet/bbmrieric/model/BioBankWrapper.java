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

package at.meduni.liferay.portlet.bbmrieric.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BioBank}.
 * </p>
 *
 * @author reihsr
 * @see BioBank
 * @generated
 */
public class BioBankWrapper implements BioBank, ModelWrapper<BioBank> {
	public BioBankWrapper(BioBank bioBank) {
		_bioBank = bioBank;
	}

	@Override
	public Class<?> getModelClass() {
		return BioBank.class;
	}

	@Override
	public String getModelClassName() {
		return BioBank.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("biobankId", getBiobankId());
		attributes.put("organisationid", getOrganisationid());
		attributes.put("ldapbiobankID", getLdapbiobankID());
		attributes.put("biobankcountry", getBiobankcountry());
		attributes.put("biobankname", getBiobankname());
		attributes.put("biobanktype", getBiobanktype());
		attributes.put("biobanksize", getBiobanksize());
		attributes.put("biobankdescription", getBiobankdescription());
		attributes.put("biobankjuristicperson", getBiobankjuristicperson());
		attributes.put("UUID", getUUID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long biobankId = (Long)attributes.get("biobankId");

		if (biobankId != null) {
			setBiobankId(biobankId);
		}

		Long organisationid = (Long)attributes.get("organisationid");

		if (organisationid != null) {
			setOrganisationid(organisationid);
		}

		String ldapbiobankID = (String)attributes.get("ldapbiobankID");

		if (ldapbiobankID != null) {
			setLdapbiobankID(ldapbiobankID);
		}

		String biobankcountry = (String)attributes.get("biobankcountry");

		if (biobankcountry != null) {
			setBiobankcountry(biobankcountry);
		}

		String biobankname = (String)attributes.get("biobankname");

		if (biobankname != null) {
			setBiobankname(biobankname);
		}

		String biobanktype = (String)attributes.get("biobanktype");

		if (biobanktype != null) {
			setBiobanktype(biobanktype);
		}

		String biobanksize = (String)attributes.get("biobanksize");

		if (biobanksize != null) {
			setBiobanksize(biobanksize);
		}

		String biobankdescription = (String)attributes.get("biobankdescription");

		if (biobankdescription != null) {
			setBiobankdescription(biobankdescription);
		}

		String biobankjuristicperson = (String)attributes.get(
				"biobankjuristicperson");

		if (biobankjuristicperson != null) {
			setBiobankjuristicperson(biobankjuristicperson);
		}

		String UUID = (String)attributes.get("UUID");

		if (UUID != null) {
			setUUID(UUID);
		}
	}

	/**
	* Returns the primary key of this bio bank.
	*
	* @return the primary key of this bio bank
	*/
	@Override
	public long getPrimaryKey() {
		return _bioBank.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bio bank.
	*
	* @param primaryKey the primary key of this bio bank
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bioBank.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the biobank ID of this bio bank.
	*
	* @return the biobank ID of this bio bank
	*/
	@Override
	public long getBiobankId() {
		return _bioBank.getBiobankId();
	}

	/**
	* Sets the biobank ID of this bio bank.
	*
	* @param biobankId the biobank ID of this bio bank
	*/
	@Override
	public void setBiobankId(long biobankId) {
		_bioBank.setBiobankId(biobankId);
	}

	/**
	* Returns the organisationid of this bio bank.
	*
	* @return the organisationid of this bio bank
	*/
	@Override
	public long getOrganisationid() {
		return _bioBank.getOrganisationid();
	}

	/**
	* Sets the organisationid of this bio bank.
	*
	* @param organisationid the organisationid of this bio bank
	*/
	@Override
	public void setOrganisationid(long organisationid) {
		_bioBank.setOrganisationid(organisationid);
	}

	/**
	* Returns the ldapbiobank i d of this bio bank.
	*
	* @return the ldapbiobank i d of this bio bank
	*/
	@Override
	public java.lang.String getLdapbiobankID() {
		return _bioBank.getLdapbiobankID();
	}

	/**
	* Sets the ldapbiobank i d of this bio bank.
	*
	* @param ldapbiobankID the ldapbiobank i d of this bio bank
	*/
	@Override
	public void setLdapbiobankID(java.lang.String ldapbiobankID) {
		_bioBank.setLdapbiobankID(ldapbiobankID);
	}

	/**
	* Returns the biobankcountry of this bio bank.
	*
	* @return the biobankcountry of this bio bank
	*/
	@Override
	public java.lang.String getBiobankcountry() {
		return _bioBank.getBiobankcountry();
	}

	/**
	* Sets the biobankcountry of this bio bank.
	*
	* @param biobankcountry the biobankcountry of this bio bank
	*/
	@Override
	public void setBiobankcountry(java.lang.String biobankcountry) {
		_bioBank.setBiobankcountry(biobankcountry);
	}

	/**
	* Returns the biobankname of this bio bank.
	*
	* @return the biobankname of this bio bank
	*/
	@Override
	public java.lang.String getBiobankname() {
		return _bioBank.getBiobankname();
	}

	/**
	* Sets the biobankname of this bio bank.
	*
	* @param biobankname the biobankname of this bio bank
	*/
	@Override
	public void setBiobankname(java.lang.String biobankname) {
		_bioBank.setBiobankname(biobankname);
	}

	/**
	* Returns the biobanktype of this bio bank.
	*
	* @return the biobanktype of this bio bank
	*/
	@Override
	public java.lang.String getBiobanktype() {
		return _bioBank.getBiobanktype();
	}

	/**
	* Sets the biobanktype of this bio bank.
	*
	* @param biobanktype the biobanktype of this bio bank
	*/
	@Override
	public void setBiobanktype(java.lang.String biobanktype) {
		_bioBank.setBiobanktype(biobanktype);
	}

	/**
	* Returns the biobanksize of this bio bank.
	*
	* @return the biobanksize of this bio bank
	*/
	@Override
	public java.lang.String getBiobanksize() {
		return _bioBank.getBiobanksize();
	}

	/**
	* Sets the biobanksize of this bio bank.
	*
	* @param biobanksize the biobanksize of this bio bank
	*/
	@Override
	public void setBiobanksize(java.lang.String biobanksize) {
		_bioBank.setBiobanksize(biobanksize);
	}

	/**
	* Returns the biobankdescription of this bio bank.
	*
	* @return the biobankdescription of this bio bank
	*/
	@Override
	public java.lang.String getBiobankdescription() {
		return _bioBank.getBiobankdescription();
	}

	/**
	* Sets the biobankdescription of this bio bank.
	*
	* @param biobankdescription the biobankdescription of this bio bank
	*/
	@Override
	public void setBiobankdescription(java.lang.String biobankdescription) {
		_bioBank.setBiobankdescription(biobankdescription);
	}

	/**
	* Returns the biobankjuristicperson of this bio bank.
	*
	* @return the biobankjuristicperson of this bio bank
	*/
	@Override
	public java.lang.String getBiobankjuristicperson() {
		return _bioBank.getBiobankjuristicperson();
	}

	/**
	* Sets the biobankjuristicperson of this bio bank.
	*
	* @param biobankjuristicperson the biobankjuristicperson of this bio bank
	*/
	@Override
	public void setBiobankjuristicperson(java.lang.String biobankjuristicperson) {
		_bioBank.setBiobankjuristicperson(biobankjuristicperson);
	}

	/**
	* Returns the u u i d of this bio bank.
	*
	* @return the u u i d of this bio bank
	*/
	@Override
	public java.lang.String getUUID() {
		return _bioBank.getUUID();
	}

	/**
	* Sets the u u i d of this bio bank.
	*
	* @param UUID the u u i d of this bio bank
	*/
	@Override
	public void setUUID(java.lang.String UUID) {
		_bioBank.setUUID(UUID);
	}

	@Override
	public boolean isNew() {
		return _bioBank.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_bioBank.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _bioBank.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bioBank.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _bioBank.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _bioBank.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bioBank.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bioBank.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_bioBank.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_bioBank.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bioBank.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BioBankWrapper((BioBank)_bioBank.clone());
	}

	@Override
	public int compareTo(
		at.meduni.liferay.portlet.bbmrieric.model.BioBank bioBank) {
		return _bioBank.compareTo(bioBank);
	}

	@Override
	public int hashCode() {
		return _bioBank.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.meduni.liferay.portlet.bbmrieric.model.BioBank> toCacheModel() {
		return _bioBank.toCacheModel();
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank toEscapedModel() {
		return new BioBankWrapper(_bioBank.toEscapedModel());
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank toUnescapedModel() {
		return new BioBankWrapper(_bioBank.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bioBank.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bioBank.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bioBank.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BioBankWrapper)) {
			return false;
		}

		BioBankWrapper bioBankWrapper = (BioBankWrapper)obj;

		if (Validator.equals(_bioBank, bioBankWrapper._bioBank)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BioBank getWrappedBioBank() {
		return _bioBank;
	}

	@Override
	public BioBank getWrappedModel() {
		return _bioBank;
	}

	@Override
	public void resetOriginalValues() {
		_bioBank.resetOriginalValues();
	}

	private BioBank _bioBank;
}