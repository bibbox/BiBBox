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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link KdssmpPatient}.
 * </p>
 *
 * @author reihsr
 * @see KdssmpPatient
 * @generated
 */
public class KdssmpPatientWrapper implements KdssmpPatient,
	ModelWrapper<KdssmpPatient> {
	public KdssmpPatientWrapper(KdssmpPatient kdssmpPatient) {
		_kdssmpPatient = kdssmpPatient;
	}

	@Override
	public Class<?> getModelClass() {
		return KdssmpPatient.class;
	}

	@Override
	public String getModelClassName() {
		return KdssmpPatient.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("patientId", getPatientId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("firstname", getFirstname());
		attributes.put("lastname", getLastname());
		attributes.put("gender", getGender());
		attributes.put("dateofbirth", getDateofbirth());
		attributes.put("dateofdeath", getDateofdeath());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long patientId = (Long)attributes.get("patientId");

		if (patientId != null) {
			setPatientId(patientId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String firstname = (String)attributes.get("firstname");

		if (firstname != null) {
			setFirstname(firstname);
		}

		String lastname = (String)attributes.get("lastname");

		if (lastname != null) {
			setLastname(lastname);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Date dateofbirth = (Date)attributes.get("dateofbirth");

		if (dateofbirth != null) {
			setDateofbirth(dateofbirth);
		}

		Date dateofdeath = (Date)attributes.get("dateofdeath");

		if (dateofdeath != null) {
			setDateofdeath(dateofdeath);
		}
	}

	/**
	* Returns the primary key of this kdssmp patient.
	*
	* @return the primary key of this kdssmp patient
	*/
	@Override
	public long getPrimaryKey() {
		return _kdssmpPatient.getPrimaryKey();
	}

	/**
	* Sets the primary key of this kdssmp patient.
	*
	* @param primaryKey the primary key of this kdssmp patient
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_kdssmpPatient.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the patient ID of this kdssmp patient.
	*
	* @return the patient ID of this kdssmp patient
	*/
	@Override
	public long getPatientId() {
		return _kdssmpPatient.getPatientId();
	}

	/**
	* Sets the patient ID of this kdssmp patient.
	*
	* @param patientId the patient ID of this kdssmp patient
	*/
	@Override
	public void setPatientId(long patientId) {
		_kdssmpPatient.setPatientId(patientId);
	}

	/**
	* Returns the organization ID of this kdssmp patient.
	*
	* @return the organization ID of this kdssmp patient
	*/
	@Override
	public long getOrganizationId() {
		return _kdssmpPatient.getOrganizationId();
	}

	/**
	* Sets the organization ID of this kdssmp patient.
	*
	* @param organizationId the organization ID of this kdssmp patient
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_kdssmpPatient.setOrganizationId(organizationId);
	}

	/**
	* Returns the firstname of this kdssmp patient.
	*
	* @return the firstname of this kdssmp patient
	*/
	@Override
	public java.lang.String getFirstname() {
		return _kdssmpPatient.getFirstname();
	}

	/**
	* Sets the firstname of this kdssmp patient.
	*
	* @param firstname the firstname of this kdssmp patient
	*/
	@Override
	public void setFirstname(java.lang.String firstname) {
		_kdssmpPatient.setFirstname(firstname);
	}

	/**
	* Returns the lastname of this kdssmp patient.
	*
	* @return the lastname of this kdssmp patient
	*/
	@Override
	public java.lang.String getLastname() {
		return _kdssmpPatient.getLastname();
	}

	/**
	* Sets the lastname of this kdssmp patient.
	*
	* @param lastname the lastname of this kdssmp patient
	*/
	@Override
	public void setLastname(java.lang.String lastname) {
		_kdssmpPatient.setLastname(lastname);
	}

	/**
	* Returns the gender of this kdssmp patient.
	*
	* @return the gender of this kdssmp patient
	*/
	@Override
	public java.lang.String getGender() {
		return _kdssmpPatient.getGender();
	}

	/**
	* Sets the gender of this kdssmp patient.
	*
	* @param gender the gender of this kdssmp patient
	*/
	@Override
	public void setGender(java.lang.String gender) {
		_kdssmpPatient.setGender(gender);
	}

	/**
	* Returns the dateofbirth of this kdssmp patient.
	*
	* @return the dateofbirth of this kdssmp patient
	*/
	@Override
	public java.util.Date getDateofbirth() {
		return _kdssmpPatient.getDateofbirth();
	}

	/**
	* Sets the dateofbirth of this kdssmp patient.
	*
	* @param dateofbirth the dateofbirth of this kdssmp patient
	*/
	@Override
	public void setDateofbirth(java.util.Date dateofbirth) {
		_kdssmpPatient.setDateofbirth(dateofbirth);
	}

	/**
	* Returns the dateofdeath of this kdssmp patient.
	*
	* @return the dateofdeath of this kdssmp patient
	*/
	@Override
	public java.util.Date getDateofdeath() {
		return _kdssmpPatient.getDateofdeath();
	}

	/**
	* Sets the dateofdeath of this kdssmp patient.
	*
	* @param dateofdeath the dateofdeath of this kdssmp patient
	*/
	@Override
	public void setDateofdeath(java.util.Date dateofdeath) {
		_kdssmpPatient.setDateofdeath(dateofdeath);
	}

	@Override
	public boolean isNew() {
		return _kdssmpPatient.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_kdssmpPatient.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _kdssmpPatient.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_kdssmpPatient.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _kdssmpPatient.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _kdssmpPatient.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_kdssmpPatient.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _kdssmpPatient.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_kdssmpPatient.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_kdssmpPatient.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_kdssmpPatient.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new KdssmpPatientWrapper((KdssmpPatient)_kdssmpPatient.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient kdssmpPatient) {
		return _kdssmpPatient.compareTo(kdssmpPatient);
	}

	@Override
	public int hashCode() {
		return _kdssmpPatient.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient> toCacheModel() {
		return _kdssmpPatient.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient toEscapedModel() {
		return new KdssmpPatientWrapper(_kdssmpPatient.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient toUnescapedModel() {
		return new KdssmpPatientWrapper(_kdssmpPatient.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _kdssmpPatient.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _kdssmpPatient.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_kdssmpPatient.persist();
	}

	@Override
	public int getNumberOfEvents() {
		return _kdssmpPatient.getNumberOfEvents();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KdssmpPatientWrapper)) {
			return false;
		}

		KdssmpPatientWrapper kdssmpPatientWrapper = (KdssmpPatientWrapper)obj;

		if (Validator.equals(_kdssmpPatient, kdssmpPatientWrapper._kdssmpPatient)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public KdssmpPatient getWrappedKdssmpPatient() {
		return _kdssmpPatient;
	}

	@Override
	public KdssmpPatient getWrappedModel() {
		return _kdssmpPatient;
	}

	@Override
	public void resetOriginalValues() {
		_kdssmpPatient.resetOriginalValues();
	}

	private KdssmpPatient _kdssmpPatient;
}