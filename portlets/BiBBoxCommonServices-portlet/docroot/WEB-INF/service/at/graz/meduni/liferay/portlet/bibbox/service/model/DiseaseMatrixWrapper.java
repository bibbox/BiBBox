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
 * This class is a wrapper for {@link DiseaseMatrix}.
 * </p>
 *
 * @author reihsr
 * @see DiseaseMatrix
 * @generated
 */
public class DiseaseMatrixWrapper implements DiseaseMatrix,
	ModelWrapper<DiseaseMatrix> {
	public DiseaseMatrixWrapper(DiseaseMatrix diseaseMatrix) {
		_diseaseMatrix = diseaseMatrix;
	}

	@Override
	public Class<?> getModelClass() {
		return DiseaseMatrix.class;
	}

	@Override
	public String getModelClassName() {
		return DiseaseMatrix.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("diseasematrixId", getDiseasematrixId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("diseasename", getDiseasename());
		attributes.put("patientcount", getPatientcount());
		attributes.put("gene", getGene());
		attributes.put("orphanumber", getOrphanumber());
		attributes.put("icd10", getIcd10());
		attributes.put("omim", getOmim());
		attributes.put("synonym", getSynonym());
		attributes.put("modifieddate", getModifieddate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long diseasematrixId = (Long)attributes.get("diseasematrixId");

		if (diseasematrixId != null) {
			setDiseasematrixId(diseasematrixId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String diseasename = (String)attributes.get("diseasename");

		if (diseasename != null) {
			setDiseasename(diseasename);
		}

		String patientcount = (String)attributes.get("patientcount");

		if (patientcount != null) {
			setPatientcount(patientcount);
		}

		String gene = (String)attributes.get("gene");

		if (gene != null) {
			setGene(gene);
		}

		String orphanumber = (String)attributes.get("orphanumber");

		if (orphanumber != null) {
			setOrphanumber(orphanumber);
		}

		String icd10 = (String)attributes.get("icd10");

		if (icd10 != null) {
			setIcd10(icd10);
		}

		String omim = (String)attributes.get("omim");

		if (omim != null) {
			setOmim(omim);
		}

		String synonym = (String)attributes.get("synonym");

		if (synonym != null) {
			setSynonym(synonym);
		}

		Date modifieddate = (Date)attributes.get("modifieddate");

		if (modifieddate != null) {
			setModifieddate(modifieddate);
		}
	}

	/**
	* Returns the primary key of this disease matrix.
	*
	* @return the primary key of this disease matrix
	*/
	@Override
	public long getPrimaryKey() {
		return _diseaseMatrix.getPrimaryKey();
	}

	/**
	* Sets the primary key of this disease matrix.
	*
	* @param primaryKey the primary key of this disease matrix
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_diseaseMatrix.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the diseasematrix ID of this disease matrix.
	*
	* @return the diseasematrix ID of this disease matrix
	*/
	@Override
	public long getDiseasematrixId() {
		return _diseaseMatrix.getDiseasematrixId();
	}

	/**
	* Sets the diseasematrix ID of this disease matrix.
	*
	* @param diseasematrixId the diseasematrix ID of this disease matrix
	*/
	@Override
	public void setDiseasematrixId(long diseasematrixId) {
		_diseaseMatrix.setDiseasematrixId(diseasematrixId);
	}

	/**
	* Returns the organization ID of this disease matrix.
	*
	* @return the organization ID of this disease matrix
	*/
	@Override
	public long getOrganizationId() {
		return _diseaseMatrix.getOrganizationId();
	}

	/**
	* Sets the organization ID of this disease matrix.
	*
	* @param organizationId the organization ID of this disease matrix
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_diseaseMatrix.setOrganizationId(organizationId);
	}

	/**
	* Returns the diseasename of this disease matrix.
	*
	* @return the diseasename of this disease matrix
	*/
	@Override
	public java.lang.String getDiseasename() {
		return _diseaseMatrix.getDiseasename();
	}

	/**
	* Sets the diseasename of this disease matrix.
	*
	* @param diseasename the diseasename of this disease matrix
	*/
	@Override
	public void setDiseasename(java.lang.String diseasename) {
		_diseaseMatrix.setDiseasename(diseasename);
	}

	/**
	* Returns the patientcount of this disease matrix.
	*
	* @return the patientcount of this disease matrix
	*/
	@Override
	public java.lang.String getPatientcount() {
		return _diseaseMatrix.getPatientcount();
	}

	/**
	* Sets the patientcount of this disease matrix.
	*
	* @param patientcount the patientcount of this disease matrix
	*/
	@Override
	public void setPatientcount(java.lang.String patientcount) {
		_diseaseMatrix.setPatientcount(patientcount);
	}

	/**
	* Returns the gene of this disease matrix.
	*
	* @return the gene of this disease matrix
	*/
	@Override
	public java.lang.String getGene() {
		return _diseaseMatrix.getGene();
	}

	/**
	* Sets the gene of this disease matrix.
	*
	* @param gene the gene of this disease matrix
	*/
	@Override
	public void setGene(java.lang.String gene) {
		_diseaseMatrix.setGene(gene);
	}

	/**
	* Returns the orphanumber of this disease matrix.
	*
	* @return the orphanumber of this disease matrix
	*/
	@Override
	public java.lang.String getOrphanumber() {
		return _diseaseMatrix.getOrphanumber();
	}

	/**
	* Sets the orphanumber of this disease matrix.
	*
	* @param orphanumber the orphanumber of this disease matrix
	*/
	@Override
	public void setOrphanumber(java.lang.String orphanumber) {
		_diseaseMatrix.setOrphanumber(orphanumber);
	}

	/**
	* Returns the icd10 of this disease matrix.
	*
	* @return the icd10 of this disease matrix
	*/
	@Override
	public java.lang.String getIcd10() {
		return _diseaseMatrix.getIcd10();
	}

	/**
	* Sets the icd10 of this disease matrix.
	*
	* @param icd10 the icd10 of this disease matrix
	*/
	@Override
	public void setIcd10(java.lang.String icd10) {
		_diseaseMatrix.setIcd10(icd10);
	}

	/**
	* Returns the omim of this disease matrix.
	*
	* @return the omim of this disease matrix
	*/
	@Override
	public java.lang.String getOmim() {
		return _diseaseMatrix.getOmim();
	}

	/**
	* Sets the omim of this disease matrix.
	*
	* @param omim the omim of this disease matrix
	*/
	@Override
	public void setOmim(java.lang.String omim) {
		_diseaseMatrix.setOmim(omim);
	}

	/**
	* Returns the synonym of this disease matrix.
	*
	* @return the synonym of this disease matrix
	*/
	@Override
	public java.lang.String getSynonym() {
		return _diseaseMatrix.getSynonym();
	}

	/**
	* Sets the synonym of this disease matrix.
	*
	* @param synonym the synonym of this disease matrix
	*/
	@Override
	public void setSynonym(java.lang.String synonym) {
		_diseaseMatrix.setSynonym(synonym);
	}

	/**
	* Returns the modifieddate of this disease matrix.
	*
	* @return the modifieddate of this disease matrix
	*/
	@Override
	public java.util.Date getModifieddate() {
		return _diseaseMatrix.getModifieddate();
	}

	/**
	* Sets the modifieddate of this disease matrix.
	*
	* @param modifieddate the modifieddate of this disease matrix
	*/
	@Override
	public void setModifieddate(java.util.Date modifieddate) {
		_diseaseMatrix.setModifieddate(modifieddate);
	}

	@Override
	public boolean isNew() {
		return _diseaseMatrix.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_diseaseMatrix.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _diseaseMatrix.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_diseaseMatrix.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _diseaseMatrix.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _diseaseMatrix.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_diseaseMatrix.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _diseaseMatrix.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_diseaseMatrix.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_diseaseMatrix.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_diseaseMatrix.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DiseaseMatrixWrapper((DiseaseMatrix)_diseaseMatrix.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseaseMatrix) {
		return _diseaseMatrix.compareTo(diseaseMatrix);
	}

	@Override
	public int hashCode() {
		return _diseaseMatrix.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> toCacheModel() {
		return _diseaseMatrix.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix toEscapedModel() {
		return new DiseaseMatrixWrapper(_diseaseMatrix.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix toUnescapedModel() {
		return new DiseaseMatrixWrapper(_diseaseMatrix.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _diseaseMatrix.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _diseaseMatrix.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_diseaseMatrix.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DiseaseMatrixWrapper)) {
			return false;
		}

		DiseaseMatrixWrapper diseaseMatrixWrapper = (DiseaseMatrixWrapper)obj;

		if (Validator.equals(_diseaseMatrix, diseaseMatrixWrapper._diseaseMatrix)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DiseaseMatrix getWrappedDiseaseMatrix() {
		return _diseaseMatrix;
	}

	@Override
	public DiseaseMatrix getWrappedModel() {
		return _diseaseMatrix;
	}

	@Override
	public void resetOriginalValues() {
		_diseaseMatrix.resetOriginalValues();
	}

	private DiseaseMatrix _diseaseMatrix;
}