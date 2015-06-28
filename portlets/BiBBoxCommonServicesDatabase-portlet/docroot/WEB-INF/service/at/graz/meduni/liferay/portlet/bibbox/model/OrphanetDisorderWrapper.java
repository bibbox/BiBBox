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
 * This class is a wrapper for {@link OrphanetDisorder}.
 * </p>
 *
 * @author reihsr
 * @see OrphanetDisorder
 * @generated
 */
public class OrphanetDisorderWrapper implements OrphanetDisorder,
	ModelWrapper<OrphanetDisorder> {
	public OrphanetDisorderWrapper(OrphanetDisorder orphanetDisorder) {
		_orphanetDisorder = orphanetDisorder;
	}

	@Override
	public Class<?> getModelClass() {
		return OrphanetDisorder.class;
	}

	@Override
	public String getModelClassName() {
		return OrphanetDisorder.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orphanetdisorderId", getOrphanetdisorderId());
		attributes.put("orphanumber", getOrphanumber());
		attributes.put("orpahnetlink", getOrpahnetlink());
		attributes.put("diseasename", getDiseasename());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long orphanetdisorderId = (Long)attributes.get("orphanetdisorderId");

		if (orphanetdisorderId != null) {
			setOrphanetdisorderId(orphanetdisorderId);
		}

		Long orphanumber = (Long)attributes.get("orphanumber");

		if (orphanumber != null) {
			setOrphanumber(orphanumber);
		}

		String orpahnetlink = (String)attributes.get("orpahnetlink");

		if (orpahnetlink != null) {
			setOrpahnetlink(orpahnetlink);
		}

		String diseasename = (String)attributes.get("diseasename");

		if (diseasename != null) {
			setDiseasename(diseasename);
		}
	}

	/**
	* Returns the primary key of this orphanet disorder.
	*
	* @return the primary key of this orphanet disorder
	*/
	@Override
	public long getPrimaryKey() {
		return _orphanetDisorder.getPrimaryKey();
	}

	/**
	* Sets the primary key of this orphanet disorder.
	*
	* @param primaryKey the primary key of this orphanet disorder
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_orphanetDisorder.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the orphanetdisorder ID of this orphanet disorder.
	*
	* @return the orphanetdisorder ID of this orphanet disorder
	*/
	@Override
	public long getOrphanetdisorderId() {
		return _orphanetDisorder.getOrphanetdisorderId();
	}

	/**
	* Sets the orphanetdisorder ID of this orphanet disorder.
	*
	* @param orphanetdisorderId the orphanetdisorder ID of this orphanet disorder
	*/
	@Override
	public void setOrphanetdisorderId(long orphanetdisorderId) {
		_orphanetDisorder.setOrphanetdisorderId(orphanetdisorderId);
	}

	/**
	* Returns the orphanumber of this orphanet disorder.
	*
	* @return the orphanumber of this orphanet disorder
	*/
	@Override
	public long getOrphanumber() {
		return _orphanetDisorder.getOrphanumber();
	}

	/**
	* Sets the orphanumber of this orphanet disorder.
	*
	* @param orphanumber the orphanumber of this orphanet disorder
	*/
	@Override
	public void setOrphanumber(long orphanumber) {
		_orphanetDisorder.setOrphanumber(orphanumber);
	}

	/**
	* Returns the orpahnetlink of this orphanet disorder.
	*
	* @return the orpahnetlink of this orphanet disorder
	*/
	@Override
	public java.lang.String getOrpahnetlink() {
		return _orphanetDisorder.getOrpahnetlink();
	}

	/**
	* Sets the orpahnetlink of this orphanet disorder.
	*
	* @param orpahnetlink the orpahnetlink of this orphanet disorder
	*/
	@Override
	public void setOrpahnetlink(java.lang.String orpahnetlink) {
		_orphanetDisorder.setOrpahnetlink(orpahnetlink);
	}

	/**
	* Returns the diseasename of this orphanet disorder.
	*
	* @return the diseasename of this orphanet disorder
	*/
	@Override
	public java.lang.String getDiseasename() {
		return _orphanetDisorder.getDiseasename();
	}

	/**
	* Sets the diseasename of this orphanet disorder.
	*
	* @param diseasename the diseasename of this orphanet disorder
	*/
	@Override
	public void setDiseasename(java.lang.String diseasename) {
		_orphanetDisorder.setDiseasename(diseasename);
	}

	@Override
	public boolean isNew() {
		return _orphanetDisorder.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_orphanetDisorder.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _orphanetDisorder.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_orphanetDisorder.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _orphanetDisorder.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _orphanetDisorder.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_orphanetDisorder.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _orphanetDisorder.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_orphanetDisorder.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_orphanetDisorder.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_orphanetDisorder.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OrphanetDisorderWrapper((OrphanetDisorder)_orphanetDisorder.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder orphanetDisorder) {
		return _orphanetDisorder.compareTo(orphanetDisorder);
	}

	@Override
	public int hashCode() {
		return _orphanetDisorder.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder> toCacheModel() {
		return _orphanetDisorder.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder toEscapedModel() {
		return new OrphanetDisorderWrapper(_orphanetDisorder.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder toUnescapedModel() {
		return new OrphanetDisorderWrapper(_orphanetDisorder.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _orphanetDisorder.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _orphanetDisorder.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_orphanetDisorder.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrphanetDisorderWrapper)) {
			return false;
		}

		OrphanetDisorderWrapper orphanetDisorderWrapper = (OrphanetDisorderWrapper)obj;

		if (Validator.equals(_orphanetDisorder,
					orphanetDisorderWrapper._orphanetDisorder)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OrphanetDisorder getWrappedOrphanetDisorder() {
		return _orphanetDisorder;
	}

	@Override
	public OrphanetDisorder getWrappedModel() {
		return _orphanetDisorder;
	}

	@Override
	public void resetOriginalValues() {
		_orphanetDisorder.resetOriginalValues();
	}

	private OrphanetDisorder _orphanetDisorder;
}