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

package at.graz.hmmc.liferay.portlet.puch.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Fahrzeug}.
 * </p>
 *
 * @author reihsr
 * @see Fahrzeug
 * @generated
 */
public class FahrzeugWrapper implements Fahrzeug, ModelWrapper<Fahrzeug> {
	public FahrzeugWrapper(Fahrzeug fahrzeug) {
		_fahrzeug = fahrzeug;
	}

	@Override
	public Class<?> getModelClass() {
		return Fahrzeug.class;
	}

	@Override
	public String getModelClassName() {
		return Fahrzeug.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fahrzeugId", getFahrzeugId());
		attributes.put("createrUserId", getCreaterUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("typ", getTyp());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fahrzeugId = (Long)attributes.get("fahrzeugId");

		if (fahrzeugId != null) {
			setFahrzeugId(fahrzeugId);
		}

		Long createrUserId = (Long)attributes.get("createrUserId");

		if (createrUserId != null) {
			setCreaterUserId(createrUserId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedUserId = (Long)attributes.get("modifiedUserId");

		if (modifiedUserId != null) {
			setModifiedUserId(modifiedUserId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String typ = (String)attributes.get("typ");

		if (typ != null) {
			setTyp(typ);
		}
	}

	/**
	* Returns the primary key of this fahrzeug.
	*
	* @return the primary key of this fahrzeug
	*/
	@Override
	public long getPrimaryKey() {
		return _fahrzeug.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fahrzeug.
	*
	* @param primaryKey the primary key of this fahrzeug
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_fahrzeug.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the fahrzeug ID of this fahrzeug.
	*
	* @return the fahrzeug ID of this fahrzeug
	*/
	@Override
	public long getFahrzeugId() {
		return _fahrzeug.getFahrzeugId();
	}

	/**
	* Sets the fahrzeug ID of this fahrzeug.
	*
	* @param fahrzeugId the fahrzeug ID of this fahrzeug
	*/
	@Override
	public void setFahrzeugId(long fahrzeugId) {
		_fahrzeug.setFahrzeugId(fahrzeugId);
	}

	/**
	* Returns the creater user ID of this fahrzeug.
	*
	* @return the creater user ID of this fahrzeug
	*/
	@Override
	public long getCreaterUserId() {
		return _fahrzeug.getCreaterUserId();
	}

	/**
	* Sets the creater user ID of this fahrzeug.
	*
	* @param createrUserId the creater user ID of this fahrzeug
	*/
	@Override
	public void setCreaterUserId(long createrUserId) {
		_fahrzeug.setCreaterUserId(createrUserId);
	}

	/**
	* Returns the creater user uuid of this fahrzeug.
	*
	* @return the creater user uuid of this fahrzeug
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreaterUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fahrzeug.getCreaterUserUuid();
	}

	/**
	* Sets the creater user uuid of this fahrzeug.
	*
	* @param createrUserUuid the creater user uuid of this fahrzeug
	*/
	@Override
	public void setCreaterUserUuid(java.lang.String createrUserUuid) {
		_fahrzeug.setCreaterUserUuid(createrUserUuid);
	}

	/**
	* Returns the create date of this fahrzeug.
	*
	* @return the create date of this fahrzeug
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _fahrzeug.getCreateDate();
	}

	/**
	* Sets the create date of this fahrzeug.
	*
	* @param createDate the create date of this fahrzeug
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_fahrzeug.setCreateDate(createDate);
	}

	/**
	* Returns the modified user ID of this fahrzeug.
	*
	* @return the modified user ID of this fahrzeug
	*/
	@Override
	public long getModifiedUserId() {
		return _fahrzeug.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this fahrzeug.
	*
	* @param modifiedUserId the modified user ID of this fahrzeug
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_fahrzeug.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this fahrzeug.
	*
	* @return the modified user uuid of this fahrzeug
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fahrzeug.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this fahrzeug.
	*
	* @param modifiedUserUuid the modified user uuid of this fahrzeug
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_fahrzeug.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the modified date of this fahrzeug.
	*
	* @return the modified date of this fahrzeug
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _fahrzeug.getModifiedDate();
	}

	/**
	* Sets the modified date of this fahrzeug.
	*
	* @param modifiedDate the modified date of this fahrzeug
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_fahrzeug.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the typ of this fahrzeug.
	*
	* @return the typ of this fahrzeug
	*/
	@Override
	public java.lang.String getTyp() {
		return _fahrzeug.getTyp();
	}

	/**
	* Sets the typ of this fahrzeug.
	*
	* @param typ the typ of this fahrzeug
	*/
	@Override
	public void setTyp(java.lang.String typ) {
		_fahrzeug.setTyp(typ);
	}

	@Override
	public boolean isNew() {
		return _fahrzeug.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_fahrzeug.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _fahrzeug.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_fahrzeug.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _fahrzeug.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _fahrzeug.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_fahrzeug.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _fahrzeug.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_fahrzeug.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_fahrzeug.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_fahrzeug.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FahrzeugWrapper((Fahrzeug)_fahrzeug.clone());
	}

	@Override
	public int compareTo(
		at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug fahrzeug) {
		return _fahrzeug.compareTo(fahrzeug);
	}

	@Override
	public int hashCode() {
		return _fahrzeug.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug> toCacheModel() {
		return _fahrzeug.toCacheModel();
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug toEscapedModel() {
		return new FahrzeugWrapper(_fahrzeug.toEscapedModel());
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.Fahrzeug toUnescapedModel() {
		return new FahrzeugWrapper(_fahrzeug.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _fahrzeug.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _fahrzeug.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_fahrzeug.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FahrzeugWrapper)) {
			return false;
		}

		FahrzeugWrapper fahrzeugWrapper = (FahrzeugWrapper)obj;

		if (Validator.equals(_fahrzeug, fahrzeugWrapper._fahrzeug)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Fahrzeug getWrappedFahrzeug() {
		return _fahrzeug;
	}

	@Override
	public Fahrzeug getWrappedModel() {
		return _fahrzeug;
	}

	@Override
	public void resetOriginalValues() {
		_fahrzeug.resetOriginalValues();
	}

	private Fahrzeug _fahrzeug;
}