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
 * This class is a wrapper for {@link GeneSynonym}.
 * </p>
 *
 * @author reihsr
 * @see GeneSynonym
 * @generated
 */
public class GeneSynonymWrapper implements GeneSynonym,
	ModelWrapper<GeneSynonym> {
	public GeneSynonymWrapper(GeneSynonym geneSynonym) {
		_geneSynonym = geneSynonym;
	}

	@Override
	public Class<?> getModelClass() {
		return GeneSynonym.class;
	}

	@Override
	public String getModelClassName() {
		return GeneSynonym.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("genesynonymId", getGenesynonymId());
		attributes.put("geneId", getGeneId());
		attributes.put("synonym", getSynonym());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long genesynonymId = (Long)attributes.get("genesynonymId");

		if (genesynonymId != null) {
			setGenesynonymId(genesynonymId);
		}

		Long geneId = (Long)attributes.get("geneId");

		if (geneId != null) {
			setGeneId(geneId);
		}

		String synonym = (String)attributes.get("synonym");

		if (synonym != null) {
			setSynonym(synonym);
		}
	}

	/**
	* Returns the primary key of this gene synonym.
	*
	* @return the primary key of this gene synonym
	*/
	@Override
	public long getPrimaryKey() {
		return _geneSynonym.getPrimaryKey();
	}

	/**
	* Sets the primary key of this gene synonym.
	*
	* @param primaryKey the primary key of this gene synonym
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_geneSynonym.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the genesynonym ID of this gene synonym.
	*
	* @return the genesynonym ID of this gene synonym
	*/
	@Override
	public long getGenesynonymId() {
		return _geneSynonym.getGenesynonymId();
	}

	/**
	* Sets the genesynonym ID of this gene synonym.
	*
	* @param genesynonymId the genesynonym ID of this gene synonym
	*/
	@Override
	public void setGenesynonymId(long genesynonymId) {
		_geneSynonym.setGenesynonymId(genesynonymId);
	}

	/**
	* Returns the gene ID of this gene synonym.
	*
	* @return the gene ID of this gene synonym
	*/
	@Override
	public long getGeneId() {
		return _geneSynonym.getGeneId();
	}

	/**
	* Sets the gene ID of this gene synonym.
	*
	* @param geneId the gene ID of this gene synonym
	*/
	@Override
	public void setGeneId(long geneId) {
		_geneSynonym.setGeneId(geneId);
	}

	/**
	* Returns the synonym of this gene synonym.
	*
	* @return the synonym of this gene synonym
	*/
	@Override
	public java.lang.String getSynonym() {
		return _geneSynonym.getSynonym();
	}

	/**
	* Sets the synonym of this gene synonym.
	*
	* @param synonym the synonym of this gene synonym
	*/
	@Override
	public void setSynonym(java.lang.String synonym) {
		_geneSynonym.setSynonym(synonym);
	}

	@Override
	public boolean isNew() {
		return _geneSynonym.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_geneSynonym.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _geneSynonym.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_geneSynonym.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _geneSynonym.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _geneSynonym.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_geneSynonym.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _geneSynonym.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_geneSynonym.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_geneSynonym.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_geneSynonym.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GeneSynonymWrapper((GeneSynonym)_geneSynonym.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym geneSynonym) {
		return _geneSynonym.compareTo(geneSynonym);
	}

	@Override
	public int hashCode() {
		return _geneSynonym.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym> toCacheModel() {
		return _geneSynonym.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym toEscapedModel() {
		return new GeneSynonymWrapper(_geneSynonym.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym toUnescapedModel() {
		return new GeneSynonymWrapper(_geneSynonym.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _geneSynonym.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _geneSynonym.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_geneSynonym.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeneSynonymWrapper)) {
			return false;
		}

		GeneSynonymWrapper geneSynonymWrapper = (GeneSynonymWrapper)obj;

		if (Validator.equals(_geneSynonym, geneSynonymWrapper._geneSynonym)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GeneSynonym getWrappedGeneSynonym() {
		return _geneSynonym;
	}

	@Override
	public GeneSynonym getWrappedModel() {
		return _geneSynonym;
	}

	@Override
	public void resetOriginalValues() {
		_geneSynonym.resetOriginalValues();
	}

	private GeneSynonym _geneSynonym;
}