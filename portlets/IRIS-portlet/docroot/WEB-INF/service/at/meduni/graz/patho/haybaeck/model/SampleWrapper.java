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
 * This class is a wrapper for {@link Sample}.
 * </p>
 *
 * @author reihsr
 * @see Sample
 * @generated
 */
public class SampleWrapper implements Sample, ModelWrapper<Sample> {
	public SampleWrapper(Sample sample) {
		_sample = sample;
	}

	@Override
	public Class<?> getModelClass() {
		return Sample.class;
	}

	@Override
	public String getModelClassName() {
		return Sample.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sample_Id", getSample_Id());
		attributes.put("patient_id", getPatient_id());
		attributes.put("t", getT());
		attributes.put("n", getN());
		attributes.put("m", getM());
		attributes.put("g", getG());
		attributes.put("r", getR());
		attributes.put("p", getP());
		attributes.put("l", getL());
		attributes.put("v", getV());
		attributes.put("stage", getStage());
		attributes.put("operation", getOperation());
		attributes.put("post_op_treatment", getPost_op_treatment());
		attributes.put("recurrence", getRecurrence());
		attributes.put("recurrence_date", getRecurrence_date());
		attributes.put("dead_live", getDead_live());
		attributes.put("last_follow_up_date", getLast_follow_up_date());
		attributes.put("hospital", getHospital());
		attributes.put("tnm_staging", getTnm_staging());
		attributes.put("diagnosis", getDiagnosis());
		attributes.put("operation_date", getOperation_date());
		attributes.put("tmp_identifier", getTmp_identifier());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sample_Id = (Long)attributes.get("sample_Id");

		if (sample_Id != null) {
			setSample_Id(sample_Id);
		}

		Long patient_id = (Long)attributes.get("patient_id");

		if (patient_id != null) {
			setPatient_id(patient_id);
		}

		String t = (String)attributes.get("t");

		if (t != null) {
			setT(t);
		}

		String n = (String)attributes.get("n");

		if (n != null) {
			setN(n);
		}

		String m = (String)attributes.get("m");

		if (m != null) {
			setM(m);
		}

		String g = (String)attributes.get("g");

		if (g != null) {
			setG(g);
		}

		String r = (String)attributes.get("r");

		if (r != null) {
			setR(r);
		}

		String p = (String)attributes.get("p");

		if (p != null) {
			setP(p);
		}

		String l = (String)attributes.get("l");

		if (l != null) {
			setL(l);
		}

		String v = (String)attributes.get("v");

		if (v != null) {
			setV(v);
		}

		String stage = (String)attributes.get("stage");

		if (stage != null) {
			setStage(stage);
		}

		String operation = (String)attributes.get("operation");

		if (operation != null) {
			setOperation(operation);
		}

		String post_op_treatment = (String)attributes.get("post_op_treatment");

		if (post_op_treatment != null) {
			setPost_op_treatment(post_op_treatment);
		}

		Boolean recurrence = (Boolean)attributes.get("recurrence");

		if (recurrence != null) {
			setRecurrence(recurrence);
		}

		Date recurrence_date = (Date)attributes.get("recurrence_date");

		if (recurrence_date != null) {
			setRecurrence_date(recurrence_date);
		}

		String dead_live = (String)attributes.get("dead_live");

		if (dead_live != null) {
			setDead_live(dead_live);
		}

		Date last_follow_up_date = (Date)attributes.get("last_follow_up_date");

		if (last_follow_up_date != null) {
			setLast_follow_up_date(last_follow_up_date);
		}

		String hospital = (String)attributes.get("hospital");

		if (hospital != null) {
			setHospital(hospital);
		}

		String tnm_staging = (String)attributes.get("tnm_staging");

		if (tnm_staging != null) {
			setTnm_staging(tnm_staging);
		}

		String diagnosis = (String)attributes.get("diagnosis");

		if (diagnosis != null) {
			setDiagnosis(diagnosis);
		}

		Date operation_date = (Date)attributes.get("operation_date");

		if (operation_date != null) {
			setOperation_date(operation_date);
		}

		String tmp_identifier = (String)attributes.get("tmp_identifier");

		if (tmp_identifier != null) {
			setTmp_identifier(tmp_identifier);
		}
	}

	/**
	* Returns the primary key of this sample.
	*
	* @return the primary key of this sample
	*/
	@Override
	public long getPrimaryKey() {
		return _sample.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sample.
	*
	* @param primaryKey the primary key of this sample
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sample.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sample_ ID of this sample.
	*
	* @return the sample_ ID of this sample
	*/
	@Override
	public long getSample_Id() {
		return _sample.getSample_Id();
	}

	/**
	* Sets the sample_ ID of this sample.
	*
	* @param sample_Id the sample_ ID of this sample
	*/
	@Override
	public void setSample_Id(long sample_Id) {
		_sample.setSample_Id(sample_Id);
	}

	/**
	* Returns the patient_id of this sample.
	*
	* @return the patient_id of this sample
	*/
	@Override
	public long getPatient_id() {
		return _sample.getPatient_id();
	}

	/**
	* Sets the patient_id of this sample.
	*
	* @param patient_id the patient_id of this sample
	*/
	@Override
	public void setPatient_id(long patient_id) {
		_sample.setPatient_id(patient_id);
	}

	/**
	* Returns the t of this sample.
	*
	* @return the t of this sample
	*/
	@Override
	public java.lang.String getT() {
		return _sample.getT();
	}

	/**
	* Sets the t of this sample.
	*
	* @param t the t of this sample
	*/
	@Override
	public void setT(java.lang.String t) {
		_sample.setT(t);
	}

	/**
	* Returns the n of this sample.
	*
	* @return the n of this sample
	*/
	@Override
	public java.lang.String getN() {
		return _sample.getN();
	}

	/**
	* Sets the n of this sample.
	*
	* @param n the n of this sample
	*/
	@Override
	public void setN(java.lang.String n) {
		_sample.setN(n);
	}

	/**
	* Returns the m of this sample.
	*
	* @return the m of this sample
	*/
	@Override
	public java.lang.String getM() {
		return _sample.getM();
	}

	/**
	* Sets the m of this sample.
	*
	* @param m the m of this sample
	*/
	@Override
	public void setM(java.lang.String m) {
		_sample.setM(m);
	}

	/**
	* Returns the g of this sample.
	*
	* @return the g of this sample
	*/
	@Override
	public java.lang.String getG() {
		return _sample.getG();
	}

	/**
	* Sets the g of this sample.
	*
	* @param g the g of this sample
	*/
	@Override
	public void setG(java.lang.String g) {
		_sample.setG(g);
	}

	/**
	* Returns the r of this sample.
	*
	* @return the r of this sample
	*/
	@Override
	public java.lang.String getR() {
		return _sample.getR();
	}

	/**
	* Sets the r of this sample.
	*
	* @param r the r of this sample
	*/
	@Override
	public void setR(java.lang.String r) {
		_sample.setR(r);
	}

	/**
	* Returns the p of this sample.
	*
	* @return the p of this sample
	*/
	@Override
	public java.lang.String getP() {
		return _sample.getP();
	}

	/**
	* Sets the p of this sample.
	*
	* @param p the p of this sample
	*/
	@Override
	public void setP(java.lang.String p) {
		_sample.setP(p);
	}

	/**
	* Returns the l of this sample.
	*
	* @return the l of this sample
	*/
	@Override
	public java.lang.String getL() {
		return _sample.getL();
	}

	/**
	* Sets the l of this sample.
	*
	* @param l the l of this sample
	*/
	@Override
	public void setL(java.lang.String l) {
		_sample.setL(l);
	}

	/**
	* Returns the v of this sample.
	*
	* @return the v of this sample
	*/
	@Override
	public java.lang.String getV() {
		return _sample.getV();
	}

	/**
	* Sets the v of this sample.
	*
	* @param v the v of this sample
	*/
	@Override
	public void setV(java.lang.String v) {
		_sample.setV(v);
	}

	/**
	* Returns the stage of this sample.
	*
	* @return the stage of this sample
	*/
	@Override
	public java.lang.String getStage() {
		return _sample.getStage();
	}

	/**
	* Sets the stage of this sample.
	*
	* @param stage the stage of this sample
	*/
	@Override
	public void setStage(java.lang.String stage) {
		_sample.setStage(stage);
	}

	/**
	* Returns the operation of this sample.
	*
	* @return the operation of this sample
	*/
	@Override
	public java.lang.String getOperation() {
		return _sample.getOperation();
	}

	/**
	* Sets the operation of this sample.
	*
	* @param operation the operation of this sample
	*/
	@Override
	public void setOperation(java.lang.String operation) {
		_sample.setOperation(operation);
	}

	/**
	* Returns the post_op_treatment of this sample.
	*
	* @return the post_op_treatment of this sample
	*/
	@Override
	public java.lang.String getPost_op_treatment() {
		return _sample.getPost_op_treatment();
	}

	/**
	* Sets the post_op_treatment of this sample.
	*
	* @param post_op_treatment the post_op_treatment of this sample
	*/
	@Override
	public void setPost_op_treatment(java.lang.String post_op_treatment) {
		_sample.setPost_op_treatment(post_op_treatment);
	}

	/**
	* Returns the recurrence of this sample.
	*
	* @return the recurrence of this sample
	*/
	@Override
	public boolean getRecurrence() {
		return _sample.getRecurrence();
	}

	/**
	* Returns <code>true</code> if this sample is recurrence.
	*
	* @return <code>true</code> if this sample is recurrence; <code>false</code> otherwise
	*/
	@Override
	public boolean isRecurrence() {
		return _sample.isRecurrence();
	}

	/**
	* Sets whether this sample is recurrence.
	*
	* @param recurrence the recurrence of this sample
	*/
	@Override
	public void setRecurrence(boolean recurrence) {
		_sample.setRecurrence(recurrence);
	}

	/**
	* Returns the recurrence_date of this sample.
	*
	* @return the recurrence_date of this sample
	*/
	@Override
	public java.util.Date getRecurrence_date() {
		return _sample.getRecurrence_date();
	}

	/**
	* Sets the recurrence_date of this sample.
	*
	* @param recurrence_date the recurrence_date of this sample
	*/
	@Override
	public void setRecurrence_date(java.util.Date recurrence_date) {
		_sample.setRecurrence_date(recurrence_date);
	}

	/**
	* Returns the dead_live of this sample.
	*
	* @return the dead_live of this sample
	*/
	@Override
	public java.lang.String getDead_live() {
		return _sample.getDead_live();
	}

	/**
	* Sets the dead_live of this sample.
	*
	* @param dead_live the dead_live of this sample
	*/
	@Override
	public void setDead_live(java.lang.String dead_live) {
		_sample.setDead_live(dead_live);
	}

	/**
	* Returns the last_follow_up_date of this sample.
	*
	* @return the last_follow_up_date of this sample
	*/
	@Override
	public java.util.Date getLast_follow_up_date() {
		return _sample.getLast_follow_up_date();
	}

	/**
	* Sets the last_follow_up_date of this sample.
	*
	* @param last_follow_up_date the last_follow_up_date of this sample
	*/
	@Override
	public void setLast_follow_up_date(java.util.Date last_follow_up_date) {
		_sample.setLast_follow_up_date(last_follow_up_date);
	}

	/**
	* Returns the hospital of this sample.
	*
	* @return the hospital of this sample
	*/
	@Override
	public java.lang.String getHospital() {
		return _sample.getHospital();
	}

	/**
	* Sets the hospital of this sample.
	*
	* @param hospital the hospital of this sample
	*/
	@Override
	public void setHospital(java.lang.String hospital) {
		_sample.setHospital(hospital);
	}

	/**
	* Returns the tnm_staging of this sample.
	*
	* @return the tnm_staging of this sample
	*/
	@Override
	public java.lang.String getTnm_staging() {
		return _sample.getTnm_staging();
	}

	/**
	* Sets the tnm_staging of this sample.
	*
	* @param tnm_staging the tnm_staging of this sample
	*/
	@Override
	public void setTnm_staging(java.lang.String tnm_staging) {
		_sample.setTnm_staging(tnm_staging);
	}

	/**
	* Returns the diagnosis of this sample.
	*
	* @return the diagnosis of this sample
	*/
	@Override
	public java.lang.String getDiagnosis() {
		return _sample.getDiagnosis();
	}

	/**
	* Sets the diagnosis of this sample.
	*
	* @param diagnosis the diagnosis of this sample
	*/
	@Override
	public void setDiagnosis(java.lang.String diagnosis) {
		_sample.setDiagnosis(diagnosis);
	}

	/**
	* Returns the operation_date of this sample.
	*
	* @return the operation_date of this sample
	*/
	@Override
	public java.util.Date getOperation_date() {
		return _sample.getOperation_date();
	}

	/**
	* Sets the operation_date of this sample.
	*
	* @param operation_date the operation_date of this sample
	*/
	@Override
	public void setOperation_date(java.util.Date operation_date) {
		_sample.setOperation_date(operation_date);
	}

	/**
	* Returns the tmp_identifier of this sample.
	*
	* @return the tmp_identifier of this sample
	*/
	@Override
	public java.lang.String getTmp_identifier() {
		return _sample.getTmp_identifier();
	}

	/**
	* Sets the tmp_identifier of this sample.
	*
	* @param tmp_identifier the tmp_identifier of this sample
	*/
	@Override
	public void setTmp_identifier(java.lang.String tmp_identifier) {
		_sample.setTmp_identifier(tmp_identifier);
	}

	@Override
	public boolean isNew() {
		return _sample.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_sample.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _sample.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sample.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _sample.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _sample.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sample.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sample.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_sample.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_sample.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sample.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SampleWrapper((Sample)_sample.clone());
	}

	@Override
	public int compareTo(at.meduni.graz.patho.haybaeck.model.Sample sample) {
		return _sample.compareTo(sample);
	}

	@Override
	public int hashCode() {
		return _sample.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.meduni.graz.patho.haybaeck.model.Sample> toCacheModel() {
		return _sample.toCacheModel();
	}

	@Override
	public at.meduni.graz.patho.haybaeck.model.Sample toEscapedModel() {
		return new SampleWrapper(_sample.toEscapedModel());
	}

	@Override
	public at.meduni.graz.patho.haybaeck.model.Sample toUnescapedModel() {
		return new SampleWrapper(_sample.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sample.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sample.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sample.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SampleWrapper)) {
			return false;
		}

		SampleWrapper sampleWrapper = (SampleWrapper)obj;

		if (Validator.equals(_sample, sampleWrapper._sample)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Sample getWrappedSample() {
		return _sample;
	}

	@Override
	public Sample getWrappedModel() {
		return _sample;
	}

	@Override
	public void resetOriginalValues() {
		_sample.resetOriginalValues();
	}

	private Sample _sample;
}