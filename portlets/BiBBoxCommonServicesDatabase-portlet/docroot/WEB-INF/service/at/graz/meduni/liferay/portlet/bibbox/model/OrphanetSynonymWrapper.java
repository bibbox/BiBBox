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
 * This class is a wrapper for {@link OrphanetSynonym}.
 * </p>
 *
 * @author reihsr
 * @see OrphanetSynonym
 * @generated
 */
public class OrphanetSynonymWrapper implements OrphanetSynonym,
	ModelWrapper<OrphanetSynonym> {
	public OrphanetSynonymWrapper(OrphanetSynonym orphanetSynonym) {
		_orphanetSynonym = orphanetSynonym;
	}

	@Override
	public Class<?> getModelClass() {
		return OrphanetSynonym.class;
	}

	@Override
	public String getModelClassName() {
		return OrphanetSynonym.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orphanetsynonymId", getOrphanetsynonymId());
		attributes.put("orphanetdisorderId", getOrphanetdisorderId());
		attributes.put("synonym", getSynonym());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long orphanetsynonymId = (Long)attributes.get("orphanetsynonymId");

		if (orphanetsynonymId != null) {
			setOrphanetsynonymId(orphanetsynonymId);
		}

		Long orphanetdisorderId = (Long)attributes.get("orphanetdisorderId");

		if (orphanetdisorderId != null) {
			setOrphanetdisorderId(orphanetdisorderId);
		}

		String synonym = (String)attributes.get("synonym");

		if (synonym != null) {
			setSynonym(synonym);
		}
	}

	/**
	* Returns the primary key of this orphanet synonym.
	*
	* @return the primary key of this orphanet synonym
	*/
	@Override
	public long getPrimaryKey() {
		return _orphanetSynonym.getPrimaryKey();
	}

	/**
	* Sets the primary key of this orphanet synonym.
	*
	* @param primaryKey the primary key of this orphanet synonym
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_orphanetSynonym.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the orphanetsynonym ID of this orphanet synonym.
	*
	* @return the orphanetsynonym ID of this orphanet synonym
	*/
	@Override
	public long getOrphanetsynonymId() {
		return _orphanetSynonym.getOrphanetsynonymId();
	}

	/**
	* Sets the orphanetsynonym ID of this orphanet synonym.
	*
	* @param orphanetsynonymId the orphanetsynonym ID of this orphanet synonym
	*/
	@Override
	public void setOrphanetsynonymId(long orphanetsynonymId) {
		_orphanetSynonym.setOrphanetsynonymId(orphanetsynonymId);
	}

	/**
	* Returns the orphanetdisorder ID of this orphanet synonym.
	*
	* @return the orphanetdisorder ID of this orphanet synonym
	*/
	@Override
	public long getOrphanetdisorderId() {
		return _orphanetSynonym.getOrphanetdisorderId();
	}

	/**
	* Sets the orphanetdisorder ID of this orphanet synonym.
	*
	* @param orphanetdisorderId the orphanetdisorder ID of this orphanet synonym
	*/
	@Override
	public void setOrphanetdisorderId(long orphanetdisorderId) {
		_orphanetSynonym.setOrphanetdisorderId(orphanetdisorderId);
	}

	/**
	* Returns the synonym of this orphanet synonym.
	*
	* @return the synonym of this orphanet synonym
	*/
	@Override
	public java.lang.String getSynonym() {
		return _orphanetSynonym.getSynonym();
	}

	/**
	* Sets the synonym of this orphanet synonym.
	*
	* @param synonym the synonym of this orphanet synonym
	*/
	@Override
	public void setSynonym(java.lang.String synonym) {
		_orphanetSynonym.setSynonym(synonym);
	}

	@Override
	public boolean isNew() {
		return _orphanetSynonym.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_orphanetSynonym.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _orphanetSynonym.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_orphanetSynonym.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _orphanetSynonym.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _orphanetSynonym.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_orphanetSynonym.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _orphanetSynonym.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_orphanetSynonym.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_orphanetSynonym.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_orphanetSynonym.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OrphanetSynonymWrapper((OrphanetSynonym)_orphanetSynonym.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym orphanetSynonym) {
		return _orphanetSynonym.compareTo(orphanetSynonym);
	}

	@Override
	public int hashCode() {
		return _orphanetSynonym.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym> toCacheModel() {
		return _orphanetSynonym.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym toEscapedModel() {
		return new OrphanetSynonymWrapper(_orphanetSynonym.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym toUnescapedModel() {
		return new OrphanetSynonymWrapper(_orphanetSynonym.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _orphanetSynonym.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _orphanetSynonym.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_orphanetSynonym.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrphanetSynonymWrapper)) {
			return false;
		}

		OrphanetSynonymWrapper orphanetSynonymWrapper = (OrphanetSynonymWrapper)obj;

		if (Validator.equals(_orphanetSynonym,
					orphanetSynonymWrapper._orphanetSynonym)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OrphanetSynonym getWrappedOrphanetSynonym() {
		return _orphanetSynonym;
	}

	@Override
	public OrphanetSynonym getWrappedModel() {
		return _orphanetSynonym;
	}

	@Override
	public void resetOriginalValues() {
		_orphanetSynonym.resetOriginalValues();
	}

	private OrphanetSynonym _orphanetSynonym;
}