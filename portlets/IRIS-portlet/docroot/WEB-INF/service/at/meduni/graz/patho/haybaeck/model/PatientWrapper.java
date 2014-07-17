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

package at.meduni.graz.patho.haybaeck.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Patient}.
 * </p>
 *
 * @author reihsr
 * @see Patient
 * @generated
 */
public class PatientWrapper implements Patient, ModelWrapper<Patient> {
	public PatientWrapper(Patient patient) {
		_patient = patient;
	}

	@Override
	public Class<?> getModelClass() {
		return Patient.class;
	}

	@Override
	public String getModelClassName() {
		return Patient.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("patient_Id", getPatient_Id());
		attributes.put("identifier", getIdentifier());
		attributes.put("cohort", getCohort());
		attributes.put("first_name", getFirst_name());
		attributes.put("last_name", getLast_name());
		attributes.put("date_of_birth", getDate_of_birth());
		attributes.put("date_of_death", getDate_of_death());
		attributes.put("couse_of_death", getCouse_of_death());
		attributes.put("gender", getGender());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long patient_Id = (Long)attributes.get("patient_Id");

		if (patient_Id != null) {
			setPatient_Id(patient_Id);
		}

		String identifier = (String)attributes.get("identifier");

		if (identifier != null) {
			setIdentifier(identifier);
		}

		String cohort = (String)attributes.get("cohort");

		if (cohort != null) {
			setCohort(cohort);
		}

		String first_name = (String)attributes.get("first_name");

		if (first_name != null) {
			setFirst_name(first_name);
		}

		String last_name = (String)attributes.get("last_name");

		if (last_name != null) {
			setLast_name(last_name);
		}

		Date date_of_birth = (Date)attributes.get("date_of_birth");

		if (date_of_birth != null) {
			setDate_of_birth(date_of_birth);
		}

		Date date_of_death = (Date)attributes.get("date_of_death");

		if (date_of_death != null) {
			setDate_of_death(date_of_death);
		}

		String couse_of_death = (String)attributes.get("couse_of_death");

		if (couse_of_death != null) {
			setCouse_of_death(couse_of_death);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}
	}

	/**
	* Returns the primary key of this patient.
	*
	* @return the primary key of this patient
	*/
	@Override
	public long getPrimaryKey() {
		return _patient.getPrimaryKey();
	}

	/**
	* Sets the primary key of this patient.
	*
	* @param primaryKey the primary key of this patient
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_patient.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the patient_ ID of this patient.
	*
	* @return the patient_ ID of this patient
	*/
	@Override
	public long getPatient_Id() {
		return _patient.getPatient_Id();
	}

	/**
	* Sets the patient_ ID of this patient.
	*
	* @param patient_Id the patient_ ID of this patient
	*/
	@Override
	public void setPatient_Id(long patient_Id) {
		_patient.setPatient_Id(patient_Id);
	}

	/**
	* Returns the identifier of this patient.
	*
	* @return the identifier of this patient
	*/
	@Override
	public java.lang.String getIdentifier() {
		return _patient.getIdentifier();
	}

	/**
	* Sets the identifier of this patient.
	*
	* @param identifier the identifier of this patient
	*/
	@Override
	public void setIdentifier(java.lang.String identifier) {
		_patient.setIdentifier(identifier);
	}

	/**
	* Returns the cohort of this patient.
	*
	* @return the cohort of this patient
	*/
	@Override
	public java.lang.String getCohort() {
		return _patient.getCohort();
	}

	/**
	* Sets the cohort of this patient.
	*
	* @param cohort the cohort of this patient
	*/
	@Override
	public void setCohort(java.lang.String cohort) {
		_patient.setCohort(cohort);
	}

	/**
	* Returns the first_name of this patient.
	*
	* @return the first_name of this patient
	*/
	@Override
	public java.lang.String getFirst_name() {
		return _patient.getFirst_name();
	}

	/**
	* Sets the first_name of this patient.
	*
	* @param first_name the first_name of this patient
	*/
	@Override
	public void setFirst_name(java.lang.String first_name) {
		_patient.setFirst_name(first_name);
	}

	/**
	* Returns the last_name of this patient.
	*
	* @return the last_name of this patient
	*/
	@Override
	public java.lang.String getLast_name() {
		return _patient.getLast_name();
	}

	/**
	* Sets the last_name of this patient.
	*
	* @param last_name the last_name of this patient
	*/
	@Override
	public void setLast_name(java.lang.String last_name) {
		_patient.setLast_name(last_name);
	}

	/**
	* Returns the date_of_birth of this patient.
	*
	* @return the date_of_birth of this patient
	*/
	@Override
	public java.util.Date getDate_of_birth() {
		return _patient.getDate_of_birth();
	}

	/**
	* Sets the date_of_birth of this patient.
	*
	* @param date_of_birth the date_of_birth of this patient
	*/
	@Override
	public void setDate_of_birth(java.util.Date date_of_birth) {
		_patient.setDate_of_birth(date_of_birth);
	}

	/**
	* Returns the date_of_death of this patient.
	*
	* @return the date_of_death of this patient
	*/
	@Override
	public java.util.Date getDate_of_death() {
		return _patient.getDate_of_death();
	}

	/**
	* Sets the date_of_death of this patient.
	*
	* @param date_of_death the date_of_death of this patient
	*/
	@Override
	public void setDate_of_death(java.util.Date date_of_death) {
		_patient.setDate_of_death(date_of_death);
	}

	/**
	* Returns the couse_of_death of this patient.
	*
	* @return the couse_of_death of this patient
	*/
	@Override
	public java.lang.String getCouse_of_death() {
		return _patient.getCouse_of_death();
	}

	/**
	* Sets the couse_of_death of this patient.
	*
	* @param couse_of_death the couse_of_death of this patient
	*/
	@Override
	public void setCouse_of_death(java.lang.String couse_of_death) {
		_patient.setCouse_of_death(couse_of_death);
	}

	/**
	* Returns the gender of this patient.
	*
	* @return the gender of this patient
	*/
	@Override
	public java.lang.String getGender() {
		return _patient.getGender();
	}

	/**
	* Sets the gender of this patient.
	*
	* @param gender the gender of this patient
	*/
	@Override
	public void setGender(java.lang.String gender) {
		_patient.setGender(gender);
	}

	@Override
	public boolean isNew() {
		return _patient.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_patient.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _patient.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_patient.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _patient.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _patient.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_patient.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _patient.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_patient.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_patient.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_patient.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PatientWrapper((Patient)_patient.clone());
	}

	@Override
	public int compareTo(at.meduni.graz.patho.haybaeck.model.Patient patient) {
		return _patient.compareTo(patient);
	}

	@Override
	public int hashCode() {
		return _patient.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.meduni.graz.patho.haybaeck.model.Patient> toCacheModel() {
		return _patient.toCacheModel();
	}

	@Override
	public at.meduni.graz.patho.haybaeck.model.Patient toEscapedModel() {
		return new PatientWrapper(_patient.toEscapedModel());
	}

	@Override
	public at.meduni.graz.patho.haybaeck.model.Patient toUnescapedModel() {
		return new PatientWrapper(_patient.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _patient.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _patient.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_patient.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PatientWrapper)) {
			return false;
		}

		PatientWrapper patientWrapper = (PatientWrapper)obj;

		if (Validator.equals(_patient, patientWrapper._patient)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Patient getWrappedPatient() {
		return _patient;
	}

	@Override
	public Patient getWrappedModel() {
		return _patient;
	}

	@Override
	public void resetOriginalValues() {
		_patient.resetOriginalValues();
	}

	private Patient _patient;
}