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

package at.graz.meduni.liferay.portlet.bibbox.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link OrphanetReference}.
 * </p>
 *
 * @author reihsr
 * @see OrphanetReference
 * @generated
 */
public class OrphanetReferenceWrapper implements OrphanetReference,
	ModelWrapper<OrphanetReference> {
	public OrphanetReferenceWrapper(OrphanetReference orphanetReference) {
		_orphanetReference = orphanetReference;
	}

	@Override
	public Class<?> getModelClass() {
		return OrphanetReference.class;
	}

	@Override
	public String getModelClassName() {
		return OrphanetReference.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orphanetreferenceId", getOrphanetreferenceId());
		attributes.put("orphanetdisorderId", getOrphanetdisorderId());
		attributes.put("source", getSource());
		attributes.put("reference", getReference());
		attributes.put("disordermappingrelation", getDisordermappingrelation());
		attributes.put("disordermappingrelationorphanumber",
			getDisordermappingrelationorphanumber());
		attributes.put("disordermappingrelationname",
			getDisordermappingrelationname());
		attributes.put("disordermappingicdrelation",
			getDisordermappingicdrelation());
		attributes.put("disordermappingicdrelationorphanumber",
			getDisordermappingicdrelationorphanumber());
		attributes.put("disordermappingicdrelationname",
			getDisordermappingicdrelationname());
		attributes.put("disordermappingvalidationstatus",
			getDisordermappingvalidationstatus());
		attributes.put("disordermappingvalidationstatusorphanumber",
			getDisordermappingvalidationstatusorphanumber());
		attributes.put("disordermappingvalidationstatusname",
			getDisordermappingvalidationstatusname());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long orphanetreferenceId = (Long)attributes.get("orphanetreferenceId");

		if (orphanetreferenceId != null) {
			setOrphanetreferenceId(orphanetreferenceId);
		}

		Long orphanetdisorderId = (Long)attributes.get("orphanetdisorderId");

		if (orphanetdisorderId != null) {
			setOrphanetdisorderId(orphanetdisorderId);
		}

		String source = (String)attributes.get("source");

		if (source != null) {
			setSource(source);
		}

		String reference = (String)attributes.get("reference");

		if (reference != null) {
			setReference(reference);
		}

		Long disordermappingrelation = (Long)attributes.get(
				"disordermappingrelation");

		if (disordermappingrelation != null) {
			setDisordermappingrelation(disordermappingrelation);
		}

		Long disordermappingrelationorphanumber = (Long)attributes.get(
				"disordermappingrelationorphanumber");

		if (disordermappingrelationorphanumber != null) {
			setDisordermappingrelationorphanumber(disordermappingrelationorphanumber);
		}

		String disordermappingrelationname = (String)attributes.get(
				"disordermappingrelationname");

		if (disordermappingrelationname != null) {
			setDisordermappingrelationname(disordermappingrelationname);
		}

		Long disordermappingicdrelation = (Long)attributes.get(
				"disordermappingicdrelation");

		if (disordermappingicdrelation != null) {
			setDisordermappingicdrelation(disordermappingicdrelation);
		}

		Long disordermappingicdrelationorphanumber = (Long)attributes.get(
				"disordermappingicdrelationorphanumber");

		if (disordermappingicdrelationorphanumber != null) {
			setDisordermappingicdrelationorphanumber(disordermappingicdrelationorphanumber);
		}

		String disordermappingicdrelationname = (String)attributes.get(
				"disordermappingicdrelationname");

		if (disordermappingicdrelationname != null) {
			setDisordermappingicdrelationname(disordermappingicdrelationname);
		}

		Long disordermappingvalidationstatus = (Long)attributes.get(
				"disordermappingvalidationstatus");

		if (disordermappingvalidationstatus != null) {
			setDisordermappingvalidationstatus(disordermappingvalidationstatus);
		}

		Long disordermappingvalidationstatusorphanumber = (Long)attributes.get(
				"disordermappingvalidationstatusorphanumber");

		if (disordermappingvalidationstatusorphanumber != null) {
			setDisordermappingvalidationstatusorphanumber(disordermappingvalidationstatusorphanumber);
		}

		String disordermappingvalidationstatusname = (String)attributes.get(
				"disordermappingvalidationstatusname");

		if (disordermappingvalidationstatusname != null) {
			setDisordermappingvalidationstatusname(disordermappingvalidationstatusname);
		}
	}

	/**
	* Returns the primary key of this orphanet reference.
	*
	* @return the primary key of this orphanet reference
	*/
	@Override
	public long getPrimaryKey() {
		return _orphanetReference.getPrimaryKey();
	}

	/**
	* Sets the primary key of this orphanet reference.
	*
	* @param primaryKey the primary key of this orphanet reference
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_orphanetReference.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the orphanetreference ID of this orphanet reference.
	*
	* @return the orphanetreference ID of this orphanet reference
	*/
	@Override
	public long getOrphanetreferenceId() {
		return _orphanetReference.getOrphanetreferenceId();
	}

	/**
	* Sets the orphanetreference ID of this orphanet reference.
	*
	* @param orphanetreferenceId the orphanetreference ID of this orphanet reference
	*/
	@Override
	public void setOrphanetreferenceId(long orphanetreferenceId) {
		_orphanetReference.setOrphanetreferenceId(orphanetreferenceId);
	}

	/**
	* Returns the orphanetdisorder ID of this orphanet reference.
	*
	* @return the orphanetdisorder ID of this orphanet reference
	*/
	@Override
	public long getOrphanetdisorderId() {
		return _orphanetReference.getOrphanetdisorderId();
	}

	/**
	* Sets the orphanetdisorder ID of this orphanet reference.
	*
	* @param orphanetdisorderId the orphanetdisorder ID of this orphanet reference
	*/
	@Override
	public void setOrphanetdisorderId(long orphanetdisorderId) {
		_orphanetReference.setOrphanetdisorderId(orphanetdisorderId);
	}

	/**
	* Returns the source of this orphanet reference.
	*
	* @return the source of this orphanet reference
	*/
	@Override
	public java.lang.String getSource() {
		return _orphanetReference.getSource();
	}

	/**
	* Sets the source of this orphanet reference.
	*
	* @param source the source of this orphanet reference
	*/
	@Override
	public void setSource(java.lang.String source) {
		_orphanetReference.setSource(source);
	}

	/**
	* Returns the reference of this orphanet reference.
	*
	* @return the reference of this orphanet reference
	*/
	@Override
	public java.lang.String getReference() {
		return _orphanetReference.getReference();
	}

	/**
	* Sets the reference of this orphanet reference.
	*
	* @param reference the reference of this orphanet reference
	*/
	@Override
	public void setReference(java.lang.String reference) {
		_orphanetReference.setReference(reference);
	}

	/**
	* Returns the disordermappingrelation of this orphanet reference.
	*
	* @return the disordermappingrelation of this orphanet reference
	*/
	@Override
	public long getDisordermappingrelation() {
		return _orphanetReference.getDisordermappingrelation();
	}

	/**
	* Sets the disordermappingrelation of this orphanet reference.
	*
	* @param disordermappingrelation the disordermappingrelation of this orphanet reference
	*/
	@Override
	public void setDisordermappingrelation(long disordermappingrelation) {
		_orphanetReference.setDisordermappingrelation(disordermappingrelation);
	}

	/**
	* Returns the disordermappingrelationorphanumber of this orphanet reference.
	*
	* @return the disordermappingrelationorphanumber of this orphanet reference
	*/
	@Override
	public long getDisordermappingrelationorphanumber() {
		return _orphanetReference.getDisordermappingrelationorphanumber();
	}

	/**
	* Sets the disordermappingrelationorphanumber of this orphanet reference.
	*
	* @param disordermappingrelationorphanumber the disordermappingrelationorphanumber of this orphanet reference
	*/
	@Override
	public void setDisordermappingrelationorphanumber(
		long disordermappingrelationorphanumber) {
		_orphanetReference.setDisordermappingrelationorphanumber(disordermappingrelationorphanumber);
	}

	/**
	* Returns the disordermappingrelationname of this orphanet reference.
	*
	* @return the disordermappingrelationname of this orphanet reference
	*/
	@Override
	public java.lang.String getDisordermappingrelationname() {
		return _orphanetReference.getDisordermappingrelationname();
	}

	/**
	* Sets the disordermappingrelationname of this orphanet reference.
	*
	* @param disordermappingrelationname the disordermappingrelationname of this orphanet reference
	*/
	@Override
	public void setDisordermappingrelationname(
		java.lang.String disordermappingrelationname) {
		_orphanetReference.setDisordermappingrelationname(disordermappingrelationname);
	}

	/**
	* Returns the disordermappingicdrelation of this orphanet reference.
	*
	* @return the disordermappingicdrelation of this orphanet reference
	*/
	@Override
	public long getDisordermappingicdrelation() {
		return _orphanetReference.getDisordermappingicdrelation();
	}

	/**
	* Sets the disordermappingicdrelation of this orphanet reference.
	*
	* @param disordermappingicdrelation the disordermappingicdrelation of this orphanet reference
	*/
	@Override
	public void setDisordermappingicdrelation(long disordermappingicdrelation) {
		_orphanetReference.setDisordermappingicdrelation(disordermappingicdrelation);
	}

	/**
	* Returns the disordermappingicdrelationorphanumber of this orphanet reference.
	*
	* @return the disordermappingicdrelationorphanumber of this orphanet reference
	*/
	@Override
	public long getDisordermappingicdrelationorphanumber() {
		return _orphanetReference.getDisordermappingicdrelationorphanumber();
	}

	/**
	* Sets the disordermappingicdrelationorphanumber of this orphanet reference.
	*
	* @param disordermappingicdrelationorphanumber the disordermappingicdrelationorphanumber of this orphanet reference
	*/
	@Override
	public void setDisordermappingicdrelationorphanumber(
		long disordermappingicdrelationorphanumber) {
		_orphanetReference.setDisordermappingicdrelationorphanumber(disordermappingicdrelationorphanumber);
	}

	/**
	* Returns the disordermappingicdrelationname of this orphanet reference.
	*
	* @return the disordermappingicdrelationname of this orphanet reference
	*/
	@Override
	public java.lang.String getDisordermappingicdrelationname() {
		return _orphanetReference.getDisordermappingicdrelationname();
	}

	/**
	* Sets the disordermappingicdrelationname of this orphanet reference.
	*
	* @param disordermappingicdrelationname the disordermappingicdrelationname of this orphanet reference
	*/
	@Override
	public void setDisordermappingicdrelationname(
		java.lang.String disordermappingicdrelationname) {
		_orphanetReference.setDisordermappingicdrelationname(disordermappingicdrelationname);
	}

	/**
	* Returns the disordermappingvalidationstatus of this orphanet reference.
	*
	* @return the disordermappingvalidationstatus of this orphanet reference
	*/
	@Override
	public long getDisordermappingvalidationstatus() {
		return _orphanetReference.getDisordermappingvalidationstatus();
	}

	/**
	* Sets the disordermappingvalidationstatus of this orphanet reference.
	*
	* @param disordermappingvalidationstatus the disordermappingvalidationstatus of this orphanet reference
	*/
	@Override
	public void setDisordermappingvalidationstatus(
		long disordermappingvalidationstatus) {
		_orphanetReference.setDisordermappingvalidationstatus(disordermappingvalidationstatus);
	}

	/**
	* Returns the disordermappingvalidationstatusorphanumber of this orphanet reference.
	*
	* @return the disordermappingvalidationstatusorphanumber of this orphanet reference
	*/
	@Override
	public long getDisordermappingvalidationstatusorphanumber() {
		return _orphanetReference.getDisordermappingvalidationstatusorphanumber();
	}

	/**
	* Sets the disordermappingvalidationstatusorphanumber of this orphanet reference.
	*
	* @param disordermappingvalidationstatusorphanumber the disordermappingvalidationstatusorphanumber of this orphanet reference
	*/
	@Override
	public void setDisordermappingvalidationstatusorphanumber(
		long disordermappingvalidationstatusorphanumber) {
		_orphanetReference.setDisordermappingvalidationstatusorphanumber(disordermappingvalidationstatusorphanumber);
	}

	/**
	* Returns the disordermappingvalidationstatusname of this orphanet reference.
	*
	* @return the disordermappingvalidationstatusname of this orphanet reference
	*/
	@Override
	public java.lang.String getDisordermappingvalidationstatusname() {
		return _orphanetReference.getDisordermappingvalidationstatusname();
	}

	/**
	* Sets the disordermappingvalidationstatusname of this orphanet reference.
	*
	* @param disordermappingvalidationstatusname the disordermappingvalidationstatusname of this orphanet reference
	*/
	@Override
	public void setDisordermappingvalidationstatusname(
		java.lang.String disordermappingvalidationstatusname) {
		_orphanetReference.setDisordermappingvalidationstatusname(disordermappingvalidationstatusname);
	}

	@Override
	public boolean isNew() {
		return _orphanetReference.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_orphanetReference.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _orphanetReference.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_orphanetReference.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _orphanetReference.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _orphanetReference.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_orphanetReference.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _orphanetReference.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_orphanetReference.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_orphanetReference.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_orphanetReference.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OrphanetReferenceWrapper((OrphanetReference)_orphanetReference.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference orphanetReference) {
		return _orphanetReference.compareTo(orphanetReference);
	}

	@Override
	public int hashCode() {
		return _orphanetReference.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference> toCacheModel() {
		return _orphanetReference.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference toEscapedModel() {
		return new OrphanetReferenceWrapper(_orphanetReference.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference toUnescapedModel() {
		return new OrphanetReferenceWrapper(_orphanetReference.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _orphanetReference.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _orphanetReference.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_orphanetReference.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrphanetReferenceWrapper)) {
			return false;
		}

		OrphanetReferenceWrapper orphanetReferenceWrapper = (OrphanetReferenceWrapper)obj;

		if (Validator.equals(_orphanetReference,
					orphanetReferenceWrapper._orphanetReference)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OrphanetReference getWrappedOrphanetReference() {
		return _orphanetReference;
	}

	@Override
	public OrphanetReference getWrappedModel() {
		return _orphanetReference;
	}

	@Override
	public void resetOriginalValues() {
		_orphanetReference.resetOriginalValues();
	}

	private OrphanetReference _orphanetReference;
}