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
 * This class is a wrapper for {@link ICDO3}.
 * </p>
 *
 * @author reihsr
 * @see ICDO3
 * @generated
 */
public class ICDO3Wrapper implements ICDO3, ModelWrapper<ICDO3> {
	public ICDO3Wrapper(ICDO3 icdo3) {
		_icdo3 = icdo3;
	}

	@Override
	public Class<?> getModelClass() {
		return ICDO3.class;
	}

	@Override
	public String getModelClassName() {
		return ICDO3.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("code", getCode());
		attributes.put("term", getTerm());
		attributes.put("sui", getSui());
		attributes.put("typ", getTyp());
		attributes.put("use", getUse());
		attributes.put("description", getDescription());
		attributes.put("localisation", getLocalisation());
		attributes.put("link", getLink());
		attributes.put("exklusiva", getExklusiva());
		attributes.put("hint", getHint());

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

		Integer term = (Integer)attributes.get("term");

		if (term != null) {
			setTerm(term);
		}

		Integer sui = (Integer)attributes.get("sui");

		if (sui != null) {
			setSui(sui);
		}

		String typ = (String)attributes.get("typ");

		if (typ != null) {
			setTyp(typ);
		}

		String use = (String)attributes.get("use");

		if (use != null) {
			setUse(use);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String localisation = (String)attributes.get("localisation");

		if (localisation != null) {
			setLocalisation(localisation);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		String exklusiva = (String)attributes.get("exklusiva");

		if (exklusiva != null) {
			setExklusiva(exklusiva);
		}

		String hint = (String)attributes.get("hint");

		if (hint != null) {
			setHint(hint);
		}
	}

	/**
	* Returns the primary key of this i c d o3.
	*
	* @return the primary key of this i c d o3
	*/
	@Override
	public long getPrimaryKey() {
		return _icdo3.getPrimaryKey();
	}

	/**
	* Sets the primary key of this i c d o3.
	*
	* @param primaryKey the primary key of this i c d o3
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_icdo3.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this i c d o3.
	*
	* @return the ID of this i c d o3
	*/
	@Override
	public long getId() {
		return _icdo3.getId();
	}

	/**
	* Sets the ID of this i c d o3.
	*
	* @param id the ID of this i c d o3
	*/
	@Override
	public void setId(long id) {
		_icdo3.setId(id);
	}

	/**
	* Returns the code of this i c d o3.
	*
	* @return the code of this i c d o3
	*/
	@Override
	public java.lang.String getCode() {
		return _icdo3.getCode();
	}

	/**
	* Sets the code of this i c d o3.
	*
	* @param code the code of this i c d o3
	*/
	@Override
	public void setCode(java.lang.String code) {
		_icdo3.setCode(code);
	}

	/**
	* Returns the term of this i c d o3.
	*
	* @return the term of this i c d o3
	*/
	@Override
	public int getTerm() {
		return _icdo3.getTerm();
	}

	/**
	* Sets the term of this i c d o3.
	*
	* @param term the term of this i c d o3
	*/
	@Override
	public void setTerm(int term) {
		_icdo3.setTerm(term);
	}

	/**
	* Returns the sui of this i c d o3.
	*
	* @return the sui of this i c d o3
	*/
	@Override
	public int getSui() {
		return _icdo3.getSui();
	}

	/**
	* Sets the sui of this i c d o3.
	*
	* @param sui the sui of this i c d o3
	*/
	@Override
	public void setSui(int sui) {
		_icdo3.setSui(sui);
	}

	/**
	* Returns the typ of this i c d o3.
	*
	* @return the typ of this i c d o3
	*/
	@Override
	public java.lang.String getTyp() {
		return _icdo3.getTyp();
	}

	/**
	* Sets the typ of this i c d o3.
	*
	* @param typ the typ of this i c d o3
	*/
	@Override
	public void setTyp(java.lang.String typ) {
		_icdo3.setTyp(typ);
	}

	/**
	* Returns the use of this i c d o3.
	*
	* @return the use of this i c d o3
	*/
	@Override
	public java.lang.String getUse() {
		return _icdo3.getUse();
	}

	/**
	* Sets the use of this i c d o3.
	*
	* @param use the use of this i c d o3
	*/
	@Override
	public void setUse(java.lang.String use) {
		_icdo3.setUse(use);
	}

	/**
	* Returns the description of this i c d o3.
	*
	* @return the description of this i c d o3
	*/
	@Override
	public java.lang.String getDescription() {
		return _icdo3.getDescription();
	}

	/**
	* Sets the description of this i c d o3.
	*
	* @param description the description of this i c d o3
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_icdo3.setDescription(description);
	}

	/**
	* Returns the localisation of this i c d o3.
	*
	* @return the localisation of this i c d o3
	*/
	@Override
	public java.lang.String getLocalisation() {
		return _icdo3.getLocalisation();
	}

	/**
	* Sets the localisation of this i c d o3.
	*
	* @param localisation the localisation of this i c d o3
	*/
	@Override
	public void setLocalisation(java.lang.String localisation) {
		_icdo3.setLocalisation(localisation);
	}

	/**
	* Returns the link of this i c d o3.
	*
	* @return the link of this i c d o3
	*/
	@Override
	public java.lang.String getLink() {
		return _icdo3.getLink();
	}

	/**
	* Sets the link of this i c d o3.
	*
	* @param link the link of this i c d o3
	*/
	@Override
	public void setLink(java.lang.String link) {
		_icdo3.setLink(link);
	}

	/**
	* Returns the exklusiva of this i c d o3.
	*
	* @return the exklusiva of this i c d o3
	*/
	@Override
	public java.lang.String getExklusiva() {
		return _icdo3.getExklusiva();
	}

	/**
	* Sets the exklusiva of this i c d o3.
	*
	* @param exklusiva the exklusiva of this i c d o3
	*/
	@Override
	public void setExklusiva(java.lang.String exklusiva) {
		_icdo3.setExklusiva(exklusiva);
	}

	/**
	* Returns the hint of this i c d o3.
	*
	* @return the hint of this i c d o3
	*/
	@Override
	public java.lang.String getHint() {
		return _icdo3.getHint();
	}

	/**
	* Sets the hint of this i c d o3.
	*
	* @param hint the hint of this i c d o3
	*/
	@Override
	public void setHint(java.lang.String hint) {
		_icdo3.setHint(hint);
	}

	@Override
	public boolean isNew() {
		return _icdo3.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_icdo3.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _icdo3.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_icdo3.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _icdo3.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _icdo3.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_icdo3.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _icdo3.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_icdo3.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_icdo3.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_icdo3.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ICDO3Wrapper((ICDO3)_icdo3.clone());
	}

	@Override
	public int compareTo(at.graz.meduni.liferay.model.ICDO3 icdo3) {
		return _icdo3.compareTo(icdo3);
	}

	@Override
	public int hashCode() {
		return _icdo3.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.model.ICDO3> toCacheModel() {
		return _icdo3.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.model.ICDO3 toEscapedModel() {
		return new ICDO3Wrapper(_icdo3.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.model.ICDO3 toUnescapedModel() {
		return new ICDO3Wrapper(_icdo3.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _icdo3.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _icdo3.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_icdo3.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ICDO3Wrapper)) {
			return false;
		}

		ICDO3Wrapper icdo3Wrapper = (ICDO3Wrapper)obj;

		if (Validator.equals(_icdo3, icdo3Wrapper._icdo3)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ICDO3 getWrappedICDO3() {
		return _icdo3;
	}

	@Override
	public ICDO3 getWrappedModel() {
		return _icdo3;
	}

	@Override
	public void resetOriginalValues() {
		_icdo3.resetOriginalValues();
	}

	private ICDO3 _icdo3;
}