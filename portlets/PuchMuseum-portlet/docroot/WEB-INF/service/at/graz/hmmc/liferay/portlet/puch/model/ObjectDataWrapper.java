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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ObjectData}.
 * </p>
 *
 * @author reihsr
 * @see ObjectData
 * @generated
 */
public class ObjectDataWrapper implements ObjectData, ModelWrapper<ObjectData> {
	public ObjectDataWrapper(ObjectData objectData) {
		_objectData = objectData;
	}

	@Override
	public Class<?> getModelClass() {
		return ObjectData.class;
	}

	@Override
	public String getModelClassName() {
		return ObjectData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("objectdataId", getObjectdataId());
		attributes.put("puchmuseumsobjectId", getPuchmuseumsobjectId());
		attributes.put("objectkey", getObjectkey());
		attributes.put("objectvalue", getObjectvalue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long objectdataId = (Long)attributes.get("objectdataId");

		if (objectdataId != null) {
			setObjectdataId(objectdataId);
		}

		Long puchmuseumsobjectId = (Long)attributes.get("puchmuseumsobjectId");

		if (puchmuseumsobjectId != null) {
			setPuchmuseumsobjectId(puchmuseumsobjectId);
		}

		String objectkey = (String)attributes.get("objectkey");

		if (objectkey != null) {
			setObjectkey(objectkey);
		}

		String objectvalue = (String)attributes.get("objectvalue");

		if (objectvalue != null) {
			setObjectvalue(objectvalue);
		}
	}

	/**
	* Returns the primary key of this object data.
	*
	* @return the primary key of this object data
	*/
	@Override
	public long getPrimaryKey() {
		return _objectData.getPrimaryKey();
	}

	/**
	* Sets the primary key of this object data.
	*
	* @param primaryKey the primary key of this object data
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_objectData.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the objectdata ID of this object data.
	*
	* @return the objectdata ID of this object data
	*/
	@Override
	public long getObjectdataId() {
		return _objectData.getObjectdataId();
	}

	/**
	* Sets the objectdata ID of this object data.
	*
	* @param objectdataId the objectdata ID of this object data
	*/
	@Override
	public void setObjectdataId(long objectdataId) {
		_objectData.setObjectdataId(objectdataId);
	}

	/**
	* Returns the puchmuseumsobject ID of this object data.
	*
	* @return the puchmuseumsobject ID of this object data
	*/
	@Override
	public long getPuchmuseumsobjectId() {
		return _objectData.getPuchmuseumsobjectId();
	}

	/**
	* Sets the puchmuseumsobject ID of this object data.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID of this object data
	*/
	@Override
	public void setPuchmuseumsobjectId(long puchmuseumsobjectId) {
		_objectData.setPuchmuseumsobjectId(puchmuseumsobjectId);
	}

	/**
	* Returns the objectkey of this object data.
	*
	* @return the objectkey of this object data
	*/
	@Override
	public java.lang.String getObjectkey() {
		return _objectData.getObjectkey();
	}

	/**
	* Sets the objectkey of this object data.
	*
	* @param objectkey the objectkey of this object data
	*/
	@Override
	public void setObjectkey(java.lang.String objectkey) {
		_objectData.setObjectkey(objectkey);
	}

	/**
	* Returns the objectvalue of this object data.
	*
	* @return the objectvalue of this object data
	*/
	@Override
	public java.lang.String getObjectvalue() {
		return _objectData.getObjectvalue();
	}

	/**
	* Sets the objectvalue of this object data.
	*
	* @param objectvalue the objectvalue of this object data
	*/
	@Override
	public void setObjectvalue(java.lang.String objectvalue) {
		_objectData.setObjectvalue(objectvalue);
	}

	@Override
	public boolean isNew() {
		return _objectData.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_objectData.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _objectData.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_objectData.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _objectData.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _objectData.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_objectData.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _objectData.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_objectData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_objectData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_objectData.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ObjectDataWrapper((ObjectData)_objectData.clone());
	}

	@Override
	public int compareTo(
		at.graz.hmmc.liferay.portlet.puch.model.ObjectData objectData) {
		return _objectData.compareTo(objectData);
	}

	@Override
	public int hashCode() {
		return _objectData.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.hmmc.liferay.portlet.puch.model.ObjectData> toCacheModel() {
		return _objectData.toCacheModel();
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData toEscapedModel() {
		return new ObjectDataWrapper(_objectData.toEscapedModel());
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData toUnescapedModel() {
		return new ObjectDataWrapper(_objectData.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _objectData.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _objectData.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_objectData.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ObjectDataWrapper)) {
			return false;
		}

		ObjectDataWrapper objectDataWrapper = (ObjectDataWrapper)obj;

		if (Validator.equals(_objectData, objectDataWrapper._objectData)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ObjectData getWrappedObjectData() {
		return _objectData;
	}

	@Override
	public ObjectData getWrappedModel() {
		return _objectData;
	}

	@Override
	public void resetOriginalValues() {
		_objectData.resetOriginalValues();
	}

	private ObjectData _objectData;
}