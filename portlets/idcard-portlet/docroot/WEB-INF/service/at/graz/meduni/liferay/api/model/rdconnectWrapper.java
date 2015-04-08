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

package at.graz.meduni.liferay.api.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link rdconnect}.
 * </p>
 *
 * @author reihsr
 * @see rdconnect
 * @generated
 */
public class rdconnectWrapper implements rdconnect, ModelWrapper<rdconnect> {
	public rdconnectWrapper(rdconnect rdconnect) {
		_rdconnect = rdconnect;
	}

	@Override
	public Class<?> getModelClass() {
		return rdconnect.class;
	}

	@Override
	public String getModelClassName() {
		return rdconnect.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idcardapilogId", getIdcardapilogId());
		attributes.put("userId", getUserId());
		attributes.put("ipaddress", getIpaddress());
		attributes.put("accessDate", getAccessDate());
		attributes.put("requestparameter", getRequestparameter());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idcardapilogId = (Long)attributes.get("idcardapilogId");

		if (idcardapilogId != null) {
			setIdcardapilogId(idcardapilogId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String ipaddress = (String)attributes.get("ipaddress");

		if (ipaddress != null) {
			setIpaddress(ipaddress);
		}

		Date accessDate = (Date)attributes.get("accessDate");

		if (accessDate != null) {
			setAccessDate(accessDate);
		}

		String requestparameter = (String)attributes.get("requestparameter");

		if (requestparameter != null) {
			setRequestparameter(requestparameter);
		}
	}

	/**
	* Returns the primary key of this rdconnect.
	*
	* @return the primary key of this rdconnect
	*/
	@Override
	public long getPrimaryKey() {
		return _rdconnect.getPrimaryKey();
	}

	/**
	* Sets the primary key of this rdconnect.
	*
	* @param primaryKey the primary key of this rdconnect
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rdconnect.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the idcardapilog ID of this rdconnect.
	*
	* @return the idcardapilog ID of this rdconnect
	*/
	@Override
	public long getIdcardapilogId() {
		return _rdconnect.getIdcardapilogId();
	}

	/**
	* Sets the idcardapilog ID of this rdconnect.
	*
	* @param idcardapilogId the idcardapilog ID of this rdconnect
	*/
	@Override
	public void setIdcardapilogId(long idcardapilogId) {
		_rdconnect.setIdcardapilogId(idcardapilogId);
	}

	/**
	* Returns the user ID of this rdconnect.
	*
	* @return the user ID of this rdconnect
	*/
	@Override
	public long getUserId() {
		return _rdconnect.getUserId();
	}

	/**
	* Sets the user ID of this rdconnect.
	*
	* @param userId the user ID of this rdconnect
	*/
	@Override
	public void setUserId(long userId) {
		_rdconnect.setUserId(userId);
	}

	/**
	* Returns the user uuid of this rdconnect.
	*
	* @return the user uuid of this rdconnect
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rdconnect.getUserUuid();
	}

	/**
	* Sets the user uuid of this rdconnect.
	*
	* @param userUuid the user uuid of this rdconnect
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_rdconnect.setUserUuid(userUuid);
	}

	/**
	* Returns the ipaddress of this rdconnect.
	*
	* @return the ipaddress of this rdconnect
	*/
	@Override
	public java.lang.String getIpaddress() {
		return _rdconnect.getIpaddress();
	}

	/**
	* Sets the ipaddress of this rdconnect.
	*
	* @param ipaddress the ipaddress of this rdconnect
	*/
	@Override
	public void setIpaddress(java.lang.String ipaddress) {
		_rdconnect.setIpaddress(ipaddress);
	}

	/**
	* Returns the access date of this rdconnect.
	*
	* @return the access date of this rdconnect
	*/
	@Override
	public java.util.Date getAccessDate() {
		return _rdconnect.getAccessDate();
	}

	/**
	* Sets the access date of this rdconnect.
	*
	* @param accessDate the access date of this rdconnect
	*/
	@Override
	public void setAccessDate(java.util.Date accessDate) {
		_rdconnect.setAccessDate(accessDate);
	}

	/**
	* Returns the requestparameter of this rdconnect.
	*
	* @return the requestparameter of this rdconnect
	*/
	@Override
	public java.lang.String getRequestparameter() {
		return _rdconnect.getRequestparameter();
	}

	/**
	* Sets the requestparameter of this rdconnect.
	*
	* @param requestparameter the requestparameter of this rdconnect
	*/
	@Override
	public void setRequestparameter(java.lang.String requestparameter) {
		_rdconnect.setRequestparameter(requestparameter);
	}

	@Override
	public boolean isNew() {
		return _rdconnect.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rdconnect.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rdconnect.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rdconnect.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rdconnect.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rdconnect.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rdconnect.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rdconnect.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rdconnect.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rdconnect.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rdconnect.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new rdconnectWrapper((rdconnect)_rdconnect.clone());
	}

	@Override
	public int compareTo(at.graz.meduni.liferay.api.model.rdconnect rdconnect) {
		return _rdconnect.compareTo(rdconnect);
	}

	@Override
	public int hashCode() {
		return _rdconnect.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.api.model.rdconnect> toCacheModel() {
		return _rdconnect.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.api.model.rdconnect toEscapedModel() {
		return new rdconnectWrapper(_rdconnect.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.api.model.rdconnect toUnescapedModel() {
		return new rdconnectWrapper(_rdconnect.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rdconnect.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rdconnect.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rdconnect.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof rdconnectWrapper)) {
			return false;
		}

		rdconnectWrapper rdconnectWrapper = (rdconnectWrapper)obj;

		if (Validator.equals(_rdconnect, rdconnectWrapper._rdconnect)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public rdconnect getWrappedrdconnect() {
		return _rdconnect;
	}

	@Override
	public rdconnect getWrappedModel() {
		return _rdconnect;
	}

	@Override
	public void resetOriginalValues() {
		_rdconnect.resetOriginalValues();
	}

	private rdconnect _rdconnect;
}