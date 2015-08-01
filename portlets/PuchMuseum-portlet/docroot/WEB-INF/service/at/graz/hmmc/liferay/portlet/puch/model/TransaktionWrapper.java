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
 * This class is a wrapper for {@link Transaktion}.
 * </p>
 *
 * @author reihsr
 * @see Transaktion
 * @generated
 */
public class TransaktionWrapper implements Transaktion,
	ModelWrapper<Transaktion> {
	public TransaktionWrapper(Transaktion transaktion) {
		_transaktion = transaktion;
	}

	@Override
	public Class<?> getModelClass() {
		return Transaktion.class;
	}

	@Override
	public String getModelClassName() {
		return Transaktion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("transaktionId", getTransaktionId());
		attributes.put("createrUserId", getCreaterUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("typ", getTyp());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long transaktionId = (Long)attributes.get("transaktionId");

		if (transaktionId != null) {
			setTransaktionId(transaktionId);
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
	* Returns the primary key of this transaktion.
	*
	* @return the primary key of this transaktion
	*/
	@Override
	public long getPrimaryKey() {
		return _transaktion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this transaktion.
	*
	* @param primaryKey the primary key of this transaktion
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_transaktion.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the transaktion ID of this transaktion.
	*
	* @return the transaktion ID of this transaktion
	*/
	@Override
	public long getTransaktionId() {
		return _transaktion.getTransaktionId();
	}

	/**
	* Sets the transaktion ID of this transaktion.
	*
	* @param transaktionId the transaktion ID of this transaktion
	*/
	@Override
	public void setTransaktionId(long transaktionId) {
		_transaktion.setTransaktionId(transaktionId);
	}

	/**
	* Returns the creater user ID of this transaktion.
	*
	* @return the creater user ID of this transaktion
	*/
	@Override
	public long getCreaterUserId() {
		return _transaktion.getCreaterUserId();
	}

	/**
	* Sets the creater user ID of this transaktion.
	*
	* @param createrUserId the creater user ID of this transaktion
	*/
	@Override
	public void setCreaterUserId(long createrUserId) {
		_transaktion.setCreaterUserId(createrUserId);
	}

	/**
	* Returns the creater user uuid of this transaktion.
	*
	* @return the creater user uuid of this transaktion
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreaterUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transaktion.getCreaterUserUuid();
	}

	/**
	* Sets the creater user uuid of this transaktion.
	*
	* @param createrUserUuid the creater user uuid of this transaktion
	*/
	@Override
	public void setCreaterUserUuid(java.lang.String createrUserUuid) {
		_transaktion.setCreaterUserUuid(createrUserUuid);
	}

	/**
	* Returns the create date of this transaktion.
	*
	* @return the create date of this transaktion
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _transaktion.getCreateDate();
	}

	/**
	* Sets the create date of this transaktion.
	*
	* @param createDate the create date of this transaktion
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_transaktion.setCreateDate(createDate);
	}

	/**
	* Returns the modified user ID of this transaktion.
	*
	* @return the modified user ID of this transaktion
	*/
	@Override
	public long getModifiedUserId() {
		return _transaktion.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this transaktion.
	*
	* @param modifiedUserId the modified user ID of this transaktion
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_transaktion.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this transaktion.
	*
	* @return the modified user uuid of this transaktion
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _transaktion.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this transaktion.
	*
	* @param modifiedUserUuid the modified user uuid of this transaktion
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_transaktion.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the modified date of this transaktion.
	*
	* @return the modified date of this transaktion
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _transaktion.getModifiedDate();
	}

	/**
	* Sets the modified date of this transaktion.
	*
	* @param modifiedDate the modified date of this transaktion
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_transaktion.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the typ of this transaktion.
	*
	* @return the typ of this transaktion
	*/
	@Override
	public java.lang.String getTyp() {
		return _transaktion.getTyp();
	}

	/**
	* Sets the typ of this transaktion.
	*
	* @param typ the typ of this transaktion
	*/
	@Override
	public void setTyp(java.lang.String typ) {
		_transaktion.setTyp(typ);
	}

	@Override
	public boolean isNew() {
		return _transaktion.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_transaktion.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _transaktion.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_transaktion.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _transaktion.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _transaktion.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_transaktion.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _transaktion.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_transaktion.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_transaktion.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_transaktion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TransaktionWrapper((Transaktion)_transaktion.clone());
	}

	@Override
	public int compareTo(
		at.graz.hmmc.liferay.portlet.puch.model.Transaktion transaktion) {
		return _transaktion.compareTo(transaktion);
	}

	@Override
	public int hashCode() {
		return _transaktion.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.hmmc.liferay.portlet.puch.model.Transaktion> toCacheModel() {
		return _transaktion.toCacheModel();
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion toEscapedModel() {
		return new TransaktionWrapper(_transaktion.toEscapedModel());
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.Transaktion toUnescapedModel() {
		return new TransaktionWrapper(_transaktion.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _transaktion.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _transaktion.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_transaktion.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TransaktionWrapper)) {
			return false;
		}

		TransaktionWrapper transaktionWrapper = (TransaktionWrapper)obj;

		if (Validator.equals(_transaktion, transaktionWrapper._transaktion)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Transaktion getWrappedTransaktion() {
		return _transaktion;
	}

	@Override
	public Transaktion getWrappedModel() {
		return _transaktion;
	}

	@Override
	public void resetOriginalValues() {
		_transaktion.resetOriginalValues();
	}

	private Transaktion _transaktion;
}