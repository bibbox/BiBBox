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
 * This class is a wrapper for {@link GeneReference}.
 * </p>
 *
 * @author reihsr
 * @see GeneReference
 * @generated
 */
public class GeneReferenceWrapper implements GeneReference,
	ModelWrapper<GeneReference> {
	public GeneReferenceWrapper(GeneReference geneReference) {
		_geneReference = geneReference;
	}

	@Override
	public Class<?> getModelClass() {
		return GeneReference.class;
	}

	@Override
	public String getModelClassName() {
		return GeneReference.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("genereferenceId", getGenereferenceId());
		attributes.put("geneId", getGeneId());
		attributes.put("source", getSource());
		attributes.put("reference", getReference());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long genereferenceId = (Long)attributes.get("genereferenceId");

		if (genereferenceId != null) {
			setGenereferenceId(genereferenceId);
		}

		Long geneId = (Long)attributes.get("geneId");

		if (geneId != null) {
			setGeneId(geneId);
		}

		String source = (String)attributes.get("source");

		if (source != null) {
			setSource(source);
		}

		String reference = (String)attributes.get("reference");

		if (reference != null) {
			setReference(reference);
		}
	}

	/**
	* Returns the primary key of this gene reference.
	*
	* @return the primary key of this gene reference
	*/
	@Override
	public long getPrimaryKey() {
		return _geneReference.getPrimaryKey();
	}

	/**
	* Sets the primary key of this gene reference.
	*
	* @param primaryKey the primary key of this gene reference
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_geneReference.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the genereference ID of this gene reference.
	*
	* @return the genereference ID of this gene reference
	*/
	@Override
	public long getGenereferenceId() {
		return _geneReference.getGenereferenceId();
	}

	/**
	* Sets the genereference ID of this gene reference.
	*
	* @param genereferenceId the genereference ID of this gene reference
	*/
	@Override
	public void setGenereferenceId(long genereferenceId) {
		_geneReference.setGenereferenceId(genereferenceId);
	}

	/**
	* Returns the gene ID of this gene reference.
	*
	* @return the gene ID of this gene reference
	*/
	@Override
	public long getGeneId() {
		return _geneReference.getGeneId();
	}

	/**
	* Sets the gene ID of this gene reference.
	*
	* @param geneId the gene ID of this gene reference
	*/
	@Override
	public void setGeneId(long geneId) {
		_geneReference.setGeneId(geneId);
	}

	/**
	* Returns the source of this gene reference.
	*
	* @return the source of this gene reference
	*/
	@Override
	public java.lang.String getSource() {
		return _geneReference.getSource();
	}

	/**
	* Sets the source of this gene reference.
	*
	* @param source the source of this gene reference
	*/
	@Override
	public void setSource(java.lang.String source) {
		_geneReference.setSource(source);
	}

	/**
	* Returns the reference of this gene reference.
	*
	* @return the reference of this gene reference
	*/
	@Override
	public java.lang.String getReference() {
		return _geneReference.getReference();
	}

	/**
	* Sets the reference of this gene reference.
	*
	* @param reference the reference of this gene reference
	*/
	@Override
	public void setReference(java.lang.String reference) {
		_geneReference.setReference(reference);
	}

	@Override
	public boolean isNew() {
		return _geneReference.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_geneReference.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _geneReference.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_geneReference.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _geneReference.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _geneReference.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_geneReference.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _geneReference.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_geneReference.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_geneReference.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_geneReference.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GeneReferenceWrapper((GeneReference)_geneReference.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneReference geneReference) {
		return _geneReference.compareTo(geneReference);
	}

	@Override
	public int hashCode() {
		return _geneReference.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.model.GeneReference> toCacheModel() {
		return _geneReference.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneReference toEscapedModel() {
		return new GeneReferenceWrapper(_geneReference.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneReference toUnescapedModel() {
		return new GeneReferenceWrapper(_geneReference.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _geneReference.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _geneReference.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_geneReference.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeneReferenceWrapper)) {
			return false;
		}

		GeneReferenceWrapper geneReferenceWrapper = (GeneReferenceWrapper)obj;

		if (Validator.equals(_geneReference, geneReferenceWrapper._geneReference)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GeneReference getWrappedGeneReference() {
		return _geneReference;
	}

	@Override
	public GeneReference getWrappedModel() {
		return _geneReference;
	}

	@Override
	public void resetOriginalValues() {
		_geneReference.resetOriginalValues();
	}

	private GeneReference _geneReference;
}