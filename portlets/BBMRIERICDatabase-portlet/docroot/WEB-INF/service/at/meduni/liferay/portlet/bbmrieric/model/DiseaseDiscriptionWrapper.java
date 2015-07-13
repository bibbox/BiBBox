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
 * This class is a wrapper for {@link DiseaseDiscription}.
 * </p>
 *
 * @author reihsr
 * @see DiseaseDiscription
 * @generated
 */
public class DiseaseDiscriptionWrapper implements DiseaseDiscription,
	ModelWrapper<DiseaseDiscription> {
	public DiseaseDiscriptionWrapper(DiseaseDiscription diseaseDiscription) {
		_diseaseDiscription = diseaseDiscription;
	}

	@Override
	public Class<?> getModelClass() {
		return DiseaseDiscription.class;
	}

	@Override
	public String getModelClassName() {
		return DiseaseDiscription.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("diseasediscriptionId", getDiseasediscriptionId());
		attributes.put("diseasecode", getDiseasecode());
		attributes.put("diseasegroup", getDiseasegroup());
		attributes.put("diseasediscription", getDiseasediscription());
		attributes.put("root", getRoot());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long diseasediscriptionId = (Long)attributes.get("diseasediscriptionId");

		if (diseasediscriptionId != null) {
			setDiseasediscriptionId(diseasediscriptionId);
		}

		String diseasecode = (String)attributes.get("diseasecode");

		if (diseasecode != null) {
			setDiseasecode(diseasecode);
		}

		String diseasegroup = (String)attributes.get("diseasegroup");

		if (diseasegroup != null) {
			setDiseasegroup(diseasegroup);
		}

		String diseasediscription = (String)attributes.get("diseasediscription");

		if (diseasediscription != null) {
			setDiseasediscription(diseasediscription);
		}

		Boolean root = (Boolean)attributes.get("root");

		if (root != null) {
			setRoot(root);
		}
	}

	/**
	* Returns the primary key of this disease discription.
	*
	* @return the primary key of this disease discription
	*/
	@Override
	public long getPrimaryKey() {
		return _diseaseDiscription.getPrimaryKey();
	}

	/**
	* Sets the primary key of this disease discription.
	*
	* @param primaryKey the primary key of this disease discription
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_diseaseDiscription.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the diseasediscription ID of this disease discription.
	*
	* @return the diseasediscription ID of this disease discription
	*/
	@Override
	public long getDiseasediscriptionId() {
		return _diseaseDiscription.getDiseasediscriptionId();
	}

	/**
	* Sets the diseasediscription ID of this disease discription.
	*
	* @param diseasediscriptionId the diseasediscription ID of this disease discription
	*/
	@Override
	public void setDiseasediscriptionId(long diseasediscriptionId) {
		_diseaseDiscription.setDiseasediscriptionId(diseasediscriptionId);
	}

	/**
	* Returns the diseasecode of this disease discription.
	*
	* @return the diseasecode of this disease discription
	*/
	@Override
	public java.lang.String getDiseasecode() {
		return _diseaseDiscription.getDiseasecode();
	}

	/**
	* Sets the diseasecode of this disease discription.
	*
	* @param diseasecode the diseasecode of this disease discription
	*/
	@Override
	public void setDiseasecode(java.lang.String diseasecode) {
		_diseaseDiscription.setDiseasecode(diseasecode);
	}

	/**
	* Returns the diseasegroup of this disease discription.
	*
	* @return the diseasegroup of this disease discription
	*/
	@Override
	public java.lang.String getDiseasegroup() {
		return _diseaseDiscription.getDiseasegroup();
	}

	/**
	* Sets the diseasegroup of this disease discription.
	*
	* @param diseasegroup the diseasegroup of this disease discription
	*/
	@Override
	public void setDiseasegroup(java.lang.String diseasegroup) {
		_diseaseDiscription.setDiseasegroup(diseasegroup);
	}

	/**
	* Returns the diseasediscription of this disease discription.
	*
	* @return the diseasediscription of this disease discription
	*/
	@Override
	public java.lang.String getDiseasediscription() {
		return _diseaseDiscription.getDiseasediscription();
	}

	/**
	* Sets the diseasediscription of this disease discription.
	*
	* @param diseasediscription the diseasediscription of this disease discription
	*/
	@Override
	public void setDiseasediscription(java.lang.String diseasediscription) {
		_diseaseDiscription.setDiseasediscription(diseasediscription);
	}

	/**
	* Returns the root of this disease discription.
	*
	* @return the root of this disease discription
	*/
	@Override
	public boolean getRoot() {
		return _diseaseDiscription.getRoot();
	}

	/**
	* Returns <code>true</code> if this disease discription is root.
	*
	* @return <code>true</code> if this disease discription is root; <code>false</code> otherwise
	*/
	@Override
	public boolean isRoot() {
		return _diseaseDiscription.isRoot();
	}

	/**
	* Sets whether this disease discription is root.
	*
	* @param root the root of this disease discription
	*/
	@Override
	public void setRoot(boolean root) {
		_diseaseDiscription.setRoot(root);
	}

	@Override
	public boolean isNew() {
		return _diseaseDiscription.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_diseaseDiscription.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _diseaseDiscription.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_diseaseDiscription.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _diseaseDiscription.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _diseaseDiscription.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_diseaseDiscription.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _diseaseDiscription.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_diseaseDiscription.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_diseaseDiscription.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_diseaseDiscription.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DiseaseDiscriptionWrapper((DiseaseDiscription)_diseaseDiscription.clone());
	}

	@Override
	public int compareTo(
		at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription diseaseDiscription) {
		return _diseaseDiscription.compareTo(diseaseDiscription);
	}

	@Override
	public int hashCode() {
		return _diseaseDiscription.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription> toCacheModel() {
		return _diseaseDiscription.toCacheModel();
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription toEscapedModel() {
		return new DiseaseDiscriptionWrapper(_diseaseDiscription.toEscapedModel());
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription toUnescapedModel() {
		return new DiseaseDiscriptionWrapper(_diseaseDiscription.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _diseaseDiscription.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _diseaseDiscription.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_diseaseDiscription.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DiseaseDiscriptionWrapper)) {
			return false;
		}

		DiseaseDiscriptionWrapper diseaseDiscriptionWrapper = (DiseaseDiscriptionWrapper)obj;

		if (Validator.equals(_diseaseDiscription,
					diseaseDiscriptionWrapper._diseaseDiscription)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DiseaseDiscription getWrappedDiseaseDiscription() {
		return _diseaseDiscription;
	}

	@Override
	public DiseaseDiscription getWrappedModel() {
		return _diseaseDiscription;
	}

	@Override
	public void resetOriginalValues() {
		_diseaseDiscription.resetOriginalValues();
	}

	private DiseaseDiscription _diseaseDiscription;
}