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

package at.graz.meduni.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ICD10}.
 * </p>
 *
 * @author reihsr
 * @see ICD10
 * @generated
 */
public class ICD10Wrapper implements ICD10, ModelWrapper<ICD10> {
	public ICD10Wrapper(ICD10 icd10) {
		_icd10 = icd10;
	}

	@Override
	public Class<?> getModelClass() {
		return ICD10.class;
	}

	@Override
	public String getModelClassName() {
		return ICD10.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("code", getCode());
		attributes.put("description", getDescription());
		attributes.put("INKLUSIVA", getINKLUSIVA());
		attributes.put("EXKLUSIVA", getEXKLUSIVA());
		attributes.put("TYPE", getTYPE());
		attributes.put("USED", getUSED());
		attributes.put("FROM_CODE", getFROM_CODE());
		attributes.put("TO_CODE", getTO_CODE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String INKLUSIVA = (String)attributes.get("INKLUSIVA");

		if (INKLUSIVA != null) {
			setINKLUSIVA(INKLUSIVA);
		}

		String EXKLUSIVA = (String)attributes.get("EXKLUSIVA");

		if (EXKLUSIVA != null) {
			setEXKLUSIVA(EXKLUSIVA);
		}

		String TYPE = (String)attributes.get("TYPE");

		if (TYPE != null) {
			setTYPE(TYPE);
		}

		Double USED = (Double)attributes.get("USED");

		if (USED != null) {
			setUSED(USED);
		}

		String FROM_CODE = (String)attributes.get("FROM_CODE");

		if (FROM_CODE != null) {
			setFROM_CODE(FROM_CODE);
		}

		String TO_CODE = (String)attributes.get("TO_CODE");

		if (TO_CODE != null) {
			setTO_CODE(TO_CODE);
		}
	}

	/**
	* Returns the primary key of this i c d10.
	*
	* @return the primary key of this i c d10
	*/
	@Override
	public long getPrimaryKey() {
		return _icd10.getPrimaryKey();
	}

	/**
	* Sets the primary key of this i c d10.
	*
	* @param primaryKey the primary key of this i c d10
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_icd10.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this i c d10.
	*
	* @return the ID of this i c d10
	*/
	@Override
	public long getId() {
		return _icd10.getId();
	}

	/**
	* Sets the ID of this i c d10.
	*
	* @param id the ID of this i c d10
	*/
	@Override
	public void setId(long id) {
		_icd10.setId(id);
	}

	/**
	* Returns the code of this i c d10.
	*
	* @return the code of this i c d10
	*/
	@Override
	public java.lang.String getCode() {
		return _icd10.getCode();
	}

	/**
	* Sets the code of this i c d10.
	*
	* @param code the code of this i c d10
	*/
	@Override
	public void setCode(java.lang.String code) {
		_icd10.setCode(code);
	}

	/**
	* Returns the description of this i c d10.
	*
	* @return the description of this i c d10
	*/
	@Override
	public java.lang.String getDescription() {
		return _icd10.getDescription();
	}

	/**
	* Sets the description of this i c d10.
	*
	* @param description the description of this i c d10
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_icd10.setDescription(description);
	}

	/**
	* Returns the i n k l u s i v a of this i c d10.
	*
	* @return the i n k l u s i v a of this i c d10
	*/
	@Override
	public java.lang.String getINKLUSIVA() {
		return _icd10.getINKLUSIVA();
	}

	/**
	* Sets the i n k l u s i v a of this i c d10.
	*
	* @param INKLUSIVA the i n k l u s i v a of this i c d10
	*/
	@Override
	public void setINKLUSIVA(java.lang.String INKLUSIVA) {
		_icd10.setINKLUSIVA(INKLUSIVA);
	}

	/**
	* Returns the e x k l u s i v a of this i c d10.
	*
	* @return the e x k l u s i v a of this i c d10
	*/
	@Override
	public java.lang.String getEXKLUSIVA() {
		return _icd10.getEXKLUSIVA();
	}

	/**
	* Sets the e x k l u s i v a of this i c d10.
	*
	* @param EXKLUSIVA the e x k l u s i v a of this i c d10
	*/
	@Override
	public void setEXKLUSIVA(java.lang.String EXKLUSIVA) {
		_icd10.setEXKLUSIVA(EXKLUSIVA);
	}

	/**
	* Returns the t y p e of this i c d10.
	*
	* @return the t y p e of this i c d10
	*/
	@Override
	public java.lang.String getTYPE() {
		return _icd10.getTYPE();
	}

	/**
	* Sets the t y p e of this i c d10.
	*
	* @param TYPE the t y p e of this i c d10
	*/
	@Override
	public void setTYPE(java.lang.String TYPE) {
		_icd10.setTYPE(TYPE);
	}

	/**
	* Returns the u s e d of this i c d10.
	*
	* @return the u s e d of this i c d10
	*/
	@Override
	public double getUSED() {
		return _icd10.getUSED();
	}

	/**
	* Sets the u s e d of this i c d10.
	*
	* @param USED the u s e d of this i c d10
	*/
	@Override
	public void setUSED(double USED) {
		_icd10.setUSED(USED);
	}

	/**
	* Returns the f r o m_ c o d e of this i c d10.
	*
	* @return the f r o m_ c o d e of this i c d10
	*/
	@Override
	public java.lang.String getFROM_CODE() {
		return _icd10.getFROM_CODE();
	}

	/**
	* Sets the f r o m_ c o d e of this i c d10.
	*
	* @param FROM_CODE the f r o m_ c o d e of this i c d10
	*/
	@Override
	public void setFROM_CODE(java.lang.String FROM_CODE) {
		_icd10.setFROM_CODE(FROM_CODE);
	}

	/**
	* Returns the t o_ c o d e of this i c d10.
	*
	* @return the t o_ c o d e of this i c d10
	*/
	@Override
	public java.lang.String getTO_CODE() {
		return _icd10.getTO_CODE();
	}

	/**
	* Sets the t o_ c o d e of this i c d10.
	*
	* @param TO_CODE the t o_ c o d e of this i c d10
	*/
	@Override
	public void setTO_CODE(java.lang.String TO_CODE) {
		_icd10.setTO_CODE(TO_CODE);
	}

	@Override
	public boolean isNew() {
		return _icd10.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_icd10.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _icd10.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_icd10.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _icd10.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _icd10.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_icd10.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _icd10.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_icd10.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_icd10.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_icd10.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ICD10Wrapper((ICD10)_icd10.clone());
	}

	@Override
	public int compareTo(at.graz.meduni.liferay.model.ICD10 icd10) {
		return _icd10.compareTo(icd10);
	}

	@Override
	public int hashCode() {
		return _icd10.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.model.ICD10> toCacheModel() {
		return _icd10.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.model.ICD10 toEscapedModel() {
		return new ICD10Wrapper(_icd10.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.model.ICD10 toUnescapedModel() {
		return new ICD10Wrapper(_icd10.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _icd10.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _icd10.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_icd10.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ICD10Wrapper)) {
			return false;
		}

		ICD10Wrapper icd10Wrapper = (ICD10Wrapper)obj;

		if (Validator.equals(_icd10, icd10Wrapper._icd10)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ICD10 getWrappedICD10() {
		return _icd10;
	}

	@Override
	public ICD10 getWrappedModel() {
		return _icd10;
	}

	@Override
	public void resetOriginalValues() {
		_icd10.resetOriginalValues();
	}

	private ICD10 _icd10;
}