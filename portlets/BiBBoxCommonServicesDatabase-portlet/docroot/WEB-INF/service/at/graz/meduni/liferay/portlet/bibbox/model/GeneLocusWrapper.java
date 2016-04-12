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
 * This class is a wrapper for {@link GeneLocus}.
 * </p>
 *
 * @author reihsr
 * @see GeneLocus
 * @generated
 */
public class GeneLocusWrapper implements GeneLocus, ModelWrapper<GeneLocus> {
	public GeneLocusWrapper(GeneLocus geneLocus) {
		_geneLocus = geneLocus;
	}

	@Override
	public Class<?> getModelClass() {
		return GeneLocus.class;
	}

	@Override
	public String getModelClassName() {
		return GeneLocus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("genelocusId", getGenelocusId());
		attributes.put("geneId", getGeneId());
		attributes.put("genelocus", getGenelocus());
		attributes.put("genelocuskey", getGenelocuskey());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long genelocusId = (Long)attributes.get("genelocusId");

		if (genelocusId != null) {
			setGenelocusId(genelocusId);
		}

		Long geneId = (Long)attributes.get("geneId");

		if (geneId != null) {
			setGeneId(geneId);
		}

		String genelocus = (String)attributes.get("genelocus");

		if (genelocus != null) {
			setGenelocus(genelocus);
		}

		String genelocuskey = (String)attributes.get("genelocuskey");

		if (genelocuskey != null) {
			setGenelocuskey(genelocuskey);
		}
	}

	/**
	* Returns the primary key of this gene locus.
	*
	* @return the primary key of this gene locus
	*/
	@Override
	public long getPrimaryKey() {
		return _geneLocus.getPrimaryKey();
	}

	/**
	* Sets the primary key of this gene locus.
	*
	* @param primaryKey the primary key of this gene locus
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_geneLocus.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the genelocus ID of this gene locus.
	*
	* @return the genelocus ID of this gene locus
	*/
	@Override
	public long getGenelocusId() {
		return _geneLocus.getGenelocusId();
	}

	/**
	* Sets the genelocus ID of this gene locus.
	*
	* @param genelocusId the genelocus ID of this gene locus
	*/
	@Override
	public void setGenelocusId(long genelocusId) {
		_geneLocus.setGenelocusId(genelocusId);
	}

	/**
	* Returns the gene ID of this gene locus.
	*
	* @return the gene ID of this gene locus
	*/
	@Override
	public long getGeneId() {
		return _geneLocus.getGeneId();
	}

	/**
	* Sets the gene ID of this gene locus.
	*
	* @param geneId the gene ID of this gene locus
	*/
	@Override
	public void setGeneId(long geneId) {
		_geneLocus.setGeneId(geneId);
	}

	/**
	* Returns the genelocus of this gene locus.
	*
	* @return the genelocus of this gene locus
	*/
	@Override
	public java.lang.String getGenelocus() {
		return _geneLocus.getGenelocus();
	}

	/**
	* Sets the genelocus of this gene locus.
	*
	* @param genelocus the genelocus of this gene locus
	*/
	@Override
	public void setGenelocus(java.lang.String genelocus) {
		_geneLocus.setGenelocus(genelocus);
	}

	/**
	* Returns the genelocuskey of this gene locus.
	*
	* @return the genelocuskey of this gene locus
	*/
	@Override
	public java.lang.String getGenelocuskey() {
		return _geneLocus.getGenelocuskey();
	}

	/**
	* Sets the genelocuskey of this gene locus.
	*
	* @param genelocuskey the genelocuskey of this gene locus
	*/
	@Override
	public void setGenelocuskey(java.lang.String genelocuskey) {
		_geneLocus.setGenelocuskey(genelocuskey);
	}

	@Override
	public boolean isNew() {
		return _geneLocus.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_geneLocus.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _geneLocus.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_geneLocus.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _geneLocus.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _geneLocus.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_geneLocus.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _geneLocus.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_geneLocus.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_geneLocus.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_geneLocus.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GeneLocusWrapper((GeneLocus)_geneLocus.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus geneLocus) {
		return _geneLocus.compareTo(geneLocus);
	}

	@Override
	public int hashCode() {
		return _geneLocus.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus> toCacheModel() {
		return _geneLocus.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus toEscapedModel() {
		return new GeneLocusWrapper(_geneLocus.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus toUnescapedModel() {
		return new GeneLocusWrapper(_geneLocus.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _geneLocus.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _geneLocus.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_geneLocus.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeneLocusWrapper)) {
			return false;
		}

		GeneLocusWrapper geneLocusWrapper = (GeneLocusWrapper)obj;

		if (Validator.equals(_geneLocus, geneLocusWrapper._geneLocus)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GeneLocus getWrappedGeneLocus() {
		return _geneLocus;
	}

	@Override
	public GeneLocus getWrappedModel() {
		return _geneLocus;
	}

	@Override
	public void resetOriginalValues() {
		_geneLocus.resetOriginalValues();
	}

	private GeneLocus _geneLocus;
}