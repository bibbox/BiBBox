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
 * This class is a wrapper for {@link PuchMuseumsObjekt}.
 * </p>
 *
 * @author reihsr
 * @see PuchMuseumsObjekt
 * @generated
 */
public class PuchMuseumsObjektWrapper implements PuchMuseumsObjekt,
	ModelWrapper<PuchMuseumsObjekt> {
	public PuchMuseumsObjektWrapper(PuchMuseumsObjekt puchMuseumsObjekt) {
		_puchMuseumsObjekt = puchMuseumsObjekt;
	}

	@Override
	public Class<?> getModelClass() {
		return PuchMuseumsObjekt.class;
	}

	@Override
	public String getModelClassName() {
		return PuchMuseumsObjekt.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("puchmuseumsobjectId", getPuchmuseumsobjectId());
		attributes.put("createrUserId", getCreaterUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("objekttyp", getObjekttyp());
		attributes.put("objektid", getObjektid());
		attributes.put("folder", getFolder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long puchmuseumsobjectId = (Long)attributes.get("puchmuseumsobjectId");

		if (puchmuseumsobjectId != null) {
			setPuchmuseumsobjectId(puchmuseumsobjectId);
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

		String objekttyp = (String)attributes.get("objekttyp");

		if (objekttyp != null) {
			setObjekttyp(objekttyp);
		}

		Long objektid = (Long)attributes.get("objektid");

		if (objektid != null) {
			setObjektid(objektid);
		}

		String folder = (String)attributes.get("folder");

		if (folder != null) {
			setFolder(folder);
		}
	}

	/**
	* Returns the primary key of this puch museums objekt.
	*
	* @return the primary key of this puch museums objekt
	*/
	@Override
	public long getPrimaryKey() {
		return _puchMuseumsObjekt.getPrimaryKey();
	}

	/**
	* Sets the primary key of this puch museums objekt.
	*
	* @param primaryKey the primary key of this puch museums objekt
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_puchMuseumsObjekt.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the puchmuseumsobject ID of this puch museums objekt.
	*
	* @return the puchmuseumsobject ID of this puch museums objekt
	*/
	@Override
	public long getPuchmuseumsobjectId() {
		return _puchMuseumsObjekt.getPuchmuseumsobjectId();
	}

	/**
	* Sets the puchmuseumsobject ID of this puch museums objekt.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID of this puch museums objekt
	*/
	@Override
	public void setPuchmuseumsobjectId(long puchmuseumsobjectId) {
		_puchMuseumsObjekt.setPuchmuseumsobjectId(puchmuseumsobjectId);
	}

	/**
	* Returns the creater user ID of this puch museums objekt.
	*
	* @return the creater user ID of this puch museums objekt
	*/
	@Override
	public long getCreaterUserId() {
		return _puchMuseumsObjekt.getCreaterUserId();
	}

	/**
	* Sets the creater user ID of this puch museums objekt.
	*
	* @param createrUserId the creater user ID of this puch museums objekt
	*/
	@Override
	public void setCreaterUserId(long createrUserId) {
		_puchMuseumsObjekt.setCreaterUserId(createrUserId);
	}

	/**
	* Returns the creater user uuid of this puch museums objekt.
	*
	* @return the creater user uuid of this puch museums objekt
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreaterUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _puchMuseumsObjekt.getCreaterUserUuid();
	}

	/**
	* Sets the creater user uuid of this puch museums objekt.
	*
	* @param createrUserUuid the creater user uuid of this puch museums objekt
	*/
	@Override
	public void setCreaterUserUuid(java.lang.String createrUserUuid) {
		_puchMuseumsObjekt.setCreaterUserUuid(createrUserUuid);
	}

	/**
	* Returns the create date of this puch museums objekt.
	*
	* @return the create date of this puch museums objekt
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _puchMuseumsObjekt.getCreateDate();
	}

	/**
	* Sets the create date of this puch museums objekt.
	*
	* @param createDate the create date of this puch museums objekt
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_puchMuseumsObjekt.setCreateDate(createDate);
	}

	/**
	* Returns the modified user ID of this puch museums objekt.
	*
	* @return the modified user ID of this puch museums objekt
	*/
	@Override
	public long getModifiedUserId() {
		return _puchMuseumsObjekt.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this puch museums objekt.
	*
	* @param modifiedUserId the modified user ID of this puch museums objekt
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_puchMuseumsObjekt.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this puch museums objekt.
	*
	* @return the modified user uuid of this puch museums objekt
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _puchMuseumsObjekt.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this puch museums objekt.
	*
	* @param modifiedUserUuid the modified user uuid of this puch museums objekt
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_puchMuseumsObjekt.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the modified date of this puch museums objekt.
	*
	* @return the modified date of this puch museums objekt
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _puchMuseumsObjekt.getModifiedDate();
	}

	/**
	* Sets the modified date of this puch museums objekt.
	*
	* @param modifiedDate the modified date of this puch museums objekt
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_puchMuseumsObjekt.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the objekttyp of this puch museums objekt.
	*
	* @return the objekttyp of this puch museums objekt
	*/
	@Override
	public java.lang.String getObjekttyp() {
		return _puchMuseumsObjekt.getObjekttyp();
	}

	/**
	* Sets the objekttyp of this puch museums objekt.
	*
	* @param objekttyp the objekttyp of this puch museums objekt
	*/
	@Override
	public void setObjekttyp(java.lang.String objekttyp) {
		_puchMuseumsObjekt.setObjekttyp(objekttyp);
	}

	/**
	* Returns the objektid of this puch museums objekt.
	*
	* @return the objektid of this puch museums objekt
	*/
	@Override
	public long getObjektid() {
		return _puchMuseumsObjekt.getObjektid();
	}

	/**
	* Sets the objektid of this puch museums objekt.
	*
	* @param objektid the objektid of this puch museums objekt
	*/
	@Override
	public void setObjektid(long objektid) {
		_puchMuseumsObjekt.setObjektid(objektid);
	}

	/**
	* Returns the folder of this puch museums objekt.
	*
	* @return the folder of this puch museums objekt
	*/
	@Override
	public java.lang.String getFolder() {
		return _puchMuseumsObjekt.getFolder();
	}

	/**
	* Sets the folder of this puch museums objekt.
	*
	* @param folder the folder of this puch museums objekt
	*/
	@Override
	public void setFolder(java.lang.String folder) {
		_puchMuseumsObjekt.setFolder(folder);
	}

	@Override
	public boolean isNew() {
		return _puchMuseumsObjekt.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_puchMuseumsObjekt.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _puchMuseumsObjekt.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_puchMuseumsObjekt.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _puchMuseumsObjekt.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _puchMuseumsObjekt.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_puchMuseumsObjekt.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _puchMuseumsObjekt.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_puchMuseumsObjekt.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_puchMuseumsObjekt.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_puchMuseumsObjekt.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PuchMuseumsObjektWrapper((PuchMuseumsObjekt)_puchMuseumsObjekt.clone());
	}

	@Override
	public int compareTo(PuchMuseumsObjekt puchMuseumsObjekt) {
		return _puchMuseumsObjekt.compareTo(puchMuseumsObjekt);
	}

	@Override
	public int hashCode() {
		return _puchMuseumsObjekt.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<PuchMuseumsObjekt> toCacheModel() {
		return _puchMuseumsObjekt.toCacheModel();
	}

	@Override
	public PuchMuseumsObjekt toEscapedModel() {
		return new PuchMuseumsObjektWrapper(_puchMuseumsObjekt.toEscapedModel());
	}

	@Override
	public PuchMuseumsObjekt toUnescapedModel() {
		return new PuchMuseumsObjektWrapper(_puchMuseumsObjekt.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _puchMuseumsObjekt.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _puchMuseumsObjekt.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_puchMuseumsObjekt.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PuchMuseumsObjektWrapper)) {
			return false;
		}

		PuchMuseumsObjektWrapper puchMuseumsObjektWrapper = (PuchMuseumsObjektWrapper)obj;

		if (Validator.equals(_puchMuseumsObjekt,
					puchMuseumsObjektWrapper._puchMuseumsObjekt)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PuchMuseumsObjekt getWrappedPuchMuseumsObjekt() {
		return _puchMuseumsObjekt;
	}

	@Override
	public PuchMuseumsObjekt getWrappedModel() {
		return _puchMuseumsObjekt;
	}

	@Override
	public void resetOriginalValues() {
		_puchMuseumsObjekt.resetOriginalValues();
	}

	private PuchMuseumsObjekt _puchMuseumsObjekt;
}