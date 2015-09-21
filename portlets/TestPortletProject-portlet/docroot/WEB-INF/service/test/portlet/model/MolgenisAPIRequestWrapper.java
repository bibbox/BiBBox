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

package test.portlet.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MolgenisAPIRequest}.
 * </p>
 *
 * @author reihsr
 * @see MolgenisAPIRequest
 * @generated
 */
public class MolgenisAPIRequestWrapper implements MolgenisAPIRequest,
	ModelWrapper<MolgenisAPIRequest> {
	public MolgenisAPIRequestWrapper(MolgenisAPIRequest molgenisAPIRequest) {
		_molgenisAPIRequest = molgenisAPIRequest;
	}

	@Override
	public Class<?> getModelClass() {
		return MolgenisAPIRequest.class;
	}

	@Override
	public String getModelClassName() {
		return MolgenisAPIRequest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("molgenisapirequestId", getMolgenisapirequestId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long molgenisapirequestId = (Long)attributes.get("molgenisapirequestId");

		if (molgenisapirequestId != null) {
			setMolgenisapirequestId(molgenisapirequestId);
		}
	}

	/**
	* Returns the primary key of this molgenis a p i request.
	*
	* @return the primary key of this molgenis a p i request
	*/
	@Override
	public long getPrimaryKey() {
		return _molgenisAPIRequest.getPrimaryKey();
	}

	/**
	* Sets the primary key of this molgenis a p i request.
	*
	* @param primaryKey the primary key of this molgenis a p i request
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_molgenisAPIRequest.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the molgenisapirequest ID of this molgenis a p i request.
	*
	* @return the molgenisapirequest ID of this molgenis a p i request
	*/
	@Override
	public long getMolgenisapirequestId() {
		return _molgenisAPIRequest.getMolgenisapirequestId();
	}

	/**
	* Sets the molgenisapirequest ID of this molgenis a p i request.
	*
	* @param molgenisapirequestId the molgenisapirequest ID of this molgenis a p i request
	*/
	@Override
	public void setMolgenisapirequestId(long molgenisapirequestId) {
		_molgenisAPIRequest.setMolgenisapirequestId(molgenisapirequestId);
	}

	@Override
	public boolean isNew() {
		return _molgenisAPIRequest.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_molgenisAPIRequest.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _molgenisAPIRequest.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_molgenisAPIRequest.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _molgenisAPIRequest.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _molgenisAPIRequest.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_molgenisAPIRequest.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _molgenisAPIRequest.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_molgenisAPIRequest.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_molgenisAPIRequest.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_molgenisAPIRequest.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MolgenisAPIRequestWrapper((MolgenisAPIRequest)_molgenisAPIRequest.clone());
	}

	@Override
	public int compareTo(
		test.portlet.model.MolgenisAPIRequest molgenisAPIRequest) {
		return _molgenisAPIRequest.compareTo(molgenisAPIRequest);
	}

	@Override
	public int hashCode() {
		return _molgenisAPIRequest.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<test.portlet.model.MolgenisAPIRequest> toCacheModel() {
		return _molgenisAPIRequest.toCacheModel();
	}

	@Override
	public test.portlet.model.MolgenisAPIRequest toEscapedModel() {
		return new MolgenisAPIRequestWrapper(_molgenisAPIRequest.toEscapedModel());
	}

	@Override
	public test.portlet.model.MolgenisAPIRequest toUnescapedModel() {
		return new MolgenisAPIRequestWrapper(_molgenisAPIRequest.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _molgenisAPIRequest.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _molgenisAPIRequest.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_molgenisAPIRequest.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MolgenisAPIRequestWrapper)) {
			return false;
		}

		MolgenisAPIRequestWrapper molgenisAPIRequestWrapper = (MolgenisAPIRequestWrapper)obj;

		if (Validator.equals(_molgenisAPIRequest,
					molgenisAPIRequestWrapper._molgenisAPIRequest)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MolgenisAPIRequest getWrappedMolgenisAPIRequest() {
		return _molgenisAPIRequest;
	}

	@Override
	public MolgenisAPIRequest getWrappedModel() {
		return _molgenisAPIRequest;
	}

	@Override
	public void resetOriginalValues() {
		_molgenisAPIRequest.resetOriginalValues();
	}

	private MolgenisAPIRequest _molgenisAPIRequest;
}