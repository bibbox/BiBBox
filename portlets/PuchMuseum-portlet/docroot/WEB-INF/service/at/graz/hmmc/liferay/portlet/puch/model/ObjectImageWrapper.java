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
 * This class is a wrapper for {@link ObjectImage}.
 * </p>
 *
 * @author reihsr
 * @see ObjectImage
 * @generated
 */
public class ObjectImageWrapper implements ObjectImage,
	ModelWrapper<ObjectImage> {
	public ObjectImageWrapper(ObjectImage objectImage) {
		_objectImage = objectImage;
	}

	@Override
	public Class<?> getModelClass() {
		return ObjectImage.class;
	}

	@Override
	public String getModelClassName() {
		return ObjectImage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("objectimageId", getObjectimageId());
		attributes.put("puchmuseumsobjectId", getPuchmuseumsobjectId());
		attributes.put("createrUserId", getCreaterUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedUserId", getModifiedUserId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dlappimagerawId", getDlappimagerawId());
		attributes.put("dlappimageprocessedId", getDlappimageprocessedId());
		attributes.put("dlappimagewebId", getDlappimagewebId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long objectimageId = (Long)attributes.get("objectimageId");

		if (objectimageId != null) {
			setObjectimageId(objectimageId);
		}

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

		Long dlappimagerawId = (Long)attributes.get("dlappimagerawId");

		if (dlappimagerawId != null) {
			setDlappimagerawId(dlappimagerawId);
		}

		Long dlappimageprocessedId = (Long)attributes.get(
				"dlappimageprocessedId");

		if (dlappimageprocessedId != null) {
			setDlappimageprocessedId(dlappimageprocessedId);
		}

		Long dlappimagewebId = (Long)attributes.get("dlappimagewebId");

		if (dlappimagewebId != null) {
			setDlappimagewebId(dlappimagewebId);
		}
	}

	/**
	* Returns the primary key of this object image.
	*
	* @return the primary key of this object image
	*/
	@Override
	public long getPrimaryKey() {
		return _objectImage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this object image.
	*
	* @param primaryKey the primary key of this object image
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_objectImage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the objectimage ID of this object image.
	*
	* @return the objectimage ID of this object image
	*/
	@Override
	public long getObjectimageId() {
		return _objectImage.getObjectimageId();
	}

	/**
	* Sets the objectimage ID of this object image.
	*
	* @param objectimageId the objectimage ID of this object image
	*/
	@Override
	public void setObjectimageId(long objectimageId) {
		_objectImage.setObjectimageId(objectimageId);
	}

	/**
	* Returns the puchmuseumsobject ID of this object image.
	*
	* @return the puchmuseumsobject ID of this object image
	*/
	@Override
	public long getPuchmuseumsobjectId() {
		return _objectImage.getPuchmuseumsobjectId();
	}

	/**
	* Sets the puchmuseumsobject ID of this object image.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID of this object image
	*/
	@Override
	public void setPuchmuseumsobjectId(long puchmuseumsobjectId) {
		_objectImage.setPuchmuseumsobjectId(puchmuseumsobjectId);
	}

	/**
	* Returns the creater user ID of this object image.
	*
	* @return the creater user ID of this object image
	*/
	@Override
	public long getCreaterUserId() {
		return _objectImage.getCreaterUserId();
	}

	/**
	* Sets the creater user ID of this object image.
	*
	* @param createrUserId the creater user ID of this object image
	*/
	@Override
	public void setCreaterUserId(long createrUserId) {
		_objectImage.setCreaterUserId(createrUserId);
	}

	/**
	* Returns the creater user uuid of this object image.
	*
	* @return the creater user uuid of this object image
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCreaterUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectImage.getCreaterUserUuid();
	}

	/**
	* Sets the creater user uuid of this object image.
	*
	* @param createrUserUuid the creater user uuid of this object image
	*/
	@Override
	public void setCreaterUserUuid(java.lang.String createrUserUuid) {
		_objectImage.setCreaterUserUuid(createrUserUuid);
	}

	/**
	* Returns the create date of this object image.
	*
	* @return the create date of this object image
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _objectImage.getCreateDate();
	}

	/**
	* Sets the create date of this object image.
	*
	* @param createDate the create date of this object image
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_objectImage.setCreateDate(createDate);
	}

	/**
	* Returns the modified user ID of this object image.
	*
	* @return the modified user ID of this object image
	*/
	@Override
	public long getModifiedUserId() {
		return _objectImage.getModifiedUserId();
	}

	/**
	* Sets the modified user ID of this object image.
	*
	* @param modifiedUserId the modified user ID of this object image
	*/
	@Override
	public void setModifiedUserId(long modifiedUserId) {
		_objectImage.setModifiedUserId(modifiedUserId);
	}

	/**
	* Returns the modified user uuid of this object image.
	*
	* @return the modified user uuid of this object image
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getModifiedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectImage.getModifiedUserUuid();
	}

	/**
	* Sets the modified user uuid of this object image.
	*
	* @param modifiedUserUuid the modified user uuid of this object image
	*/
	@Override
	public void setModifiedUserUuid(java.lang.String modifiedUserUuid) {
		_objectImage.setModifiedUserUuid(modifiedUserUuid);
	}

	/**
	* Returns the modified date of this object image.
	*
	* @return the modified date of this object image
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _objectImage.getModifiedDate();
	}

	/**
	* Sets the modified date of this object image.
	*
	* @param modifiedDate the modified date of this object image
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_objectImage.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the dlappimageraw ID of this object image.
	*
	* @return the dlappimageraw ID of this object image
	*/
	@Override
	public long getDlappimagerawId() {
		return _objectImage.getDlappimagerawId();
	}

	/**
	* Sets the dlappimageraw ID of this object image.
	*
	* @param dlappimagerawId the dlappimageraw ID of this object image
	*/
	@Override
	public void setDlappimagerawId(long dlappimagerawId) {
		_objectImage.setDlappimagerawId(dlappimagerawId);
	}

	/**
	* Returns the dlappimageprocessed ID of this object image.
	*
	* @return the dlappimageprocessed ID of this object image
	*/
	@Override
	public long getDlappimageprocessedId() {
		return _objectImage.getDlappimageprocessedId();
	}

	/**
	* Sets the dlappimageprocessed ID of this object image.
	*
	* @param dlappimageprocessedId the dlappimageprocessed ID of this object image
	*/
	@Override
	public void setDlappimageprocessedId(long dlappimageprocessedId) {
		_objectImage.setDlappimageprocessedId(dlappimageprocessedId);
	}

	/**
	* Returns the dlappimageweb ID of this object image.
	*
	* @return the dlappimageweb ID of this object image
	*/
	@Override
	public long getDlappimagewebId() {
		return _objectImage.getDlappimagewebId();
	}

	/**
	* Sets the dlappimageweb ID of this object image.
	*
	* @param dlappimagewebId the dlappimageweb ID of this object image
	*/
	@Override
	public void setDlappimagewebId(long dlappimagewebId) {
		_objectImage.setDlappimagewebId(dlappimagewebId);
	}

	@Override
	public boolean isNew() {
		return _objectImage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_objectImage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _objectImage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_objectImage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _objectImage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _objectImage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_objectImage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _objectImage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_objectImage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_objectImage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_objectImage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ObjectImageWrapper((ObjectImage)_objectImage.clone());
	}

	@Override
	public int compareTo(
		at.graz.hmmc.liferay.portlet.puch.model.ObjectImage objectImage) {
		return _objectImage.compareTo(objectImage);
	}

	@Override
	public int hashCode() {
		return _objectImage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.hmmc.liferay.portlet.puch.model.ObjectImage> toCacheModel() {
		return _objectImage.toCacheModel();
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectImage toEscapedModel() {
		return new ObjectImageWrapper(_objectImage.toEscapedModel());
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectImage toUnescapedModel() {
		return new ObjectImageWrapper(_objectImage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _objectImage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _objectImage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_objectImage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ObjectImageWrapper)) {
			return false;
		}

		ObjectImageWrapper objectImageWrapper = (ObjectImageWrapper)obj;

		if (Validator.equals(_objectImage, objectImageWrapper._objectImage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ObjectImage getWrappedObjectImage() {
		return _objectImage;
	}

	@Override
	public ObjectImage getWrappedModel() {
		return _objectImage;
	}

	@Override
	public void resetOriginalValues() {
		_objectImage.resetOriginalValues();
	}

	private ObjectImage _objectImage;
}