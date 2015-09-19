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

package at.graz.meduni.liferay.portlet.bibbox.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Logapi}.
 * </p>
 *
 * @author reihsr
 * @see Logapi
 * @generated
 */
public class LogapiWrapper implements Logapi, ModelWrapper<Logapi> {
	public LogapiWrapper(Logapi logapi) {
		_logapi = logapi;
	}

	@Override
	public Class<?> getModelClass() {
		return Logapi.class;
	}

	@Override
	public String getModelClassName() {
		return Logapi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("logapiId", getLogapiId());
		attributes.put("userId", getUserId());
		attributes.put("userip", getUserip());
		attributes.put("logmsg", getLogmsg());
		attributes.put("date", getDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long logapiId = (Long)attributes.get("logapiId");

		if (logapiId != null) {
			setLogapiId(logapiId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userip = (String)attributes.get("userip");

		if (userip != null) {
			setUserip(userip);
		}

		String logmsg = (String)attributes.get("logmsg");

		if (logmsg != null) {
			setLogmsg(logmsg);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}
	}

	/**
	* Returns the primary key of this logapi.
	*
	* @return the primary key of this logapi
	*/
	@Override
	public long getPrimaryKey() {
		return _logapi.getPrimaryKey();
	}

	/**
	* Sets the primary key of this logapi.
	*
	* @param primaryKey the primary key of this logapi
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_logapi.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the logapi ID of this logapi.
	*
	* @return the logapi ID of this logapi
	*/
	@Override
	public long getLogapiId() {
		return _logapi.getLogapiId();
	}

	/**
	* Sets the logapi ID of this logapi.
	*
	* @param logapiId the logapi ID of this logapi
	*/
	@Override
	public void setLogapiId(long logapiId) {
		_logapi.setLogapiId(logapiId);
	}

	/**
	* Returns the user ID of this logapi.
	*
	* @return the user ID of this logapi
	*/
	@Override
	public long getUserId() {
		return _logapi.getUserId();
	}

	/**
	* Sets the user ID of this logapi.
	*
	* @param userId the user ID of this logapi
	*/
	@Override
	public void setUserId(long userId) {
		_logapi.setUserId(userId);
	}

	/**
	* Returns the user uuid of this logapi.
	*
	* @return the user uuid of this logapi
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logapi.getUserUuid();
	}

	/**
	* Sets the user uuid of this logapi.
	*
	* @param userUuid the user uuid of this logapi
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_logapi.setUserUuid(userUuid);
	}

	/**
	* Returns the userip of this logapi.
	*
	* @return the userip of this logapi
	*/
	@Override
	public java.lang.String getUserip() {
		return _logapi.getUserip();
	}

	/**
	* Sets the userip of this logapi.
	*
	* @param userip the userip of this logapi
	*/
	@Override
	public void setUserip(java.lang.String userip) {
		_logapi.setUserip(userip);
	}

	/**
	* Returns the logmsg of this logapi.
	*
	* @return the logmsg of this logapi
	*/
	@Override
	public java.lang.String getLogmsg() {
		return _logapi.getLogmsg();
	}

	/**
	* Sets the logmsg of this logapi.
	*
	* @param logmsg the logmsg of this logapi
	*/
	@Override
	public void setLogmsg(java.lang.String logmsg) {
		_logapi.setLogmsg(logmsg);
	}

	/**
	* Returns the date of this logapi.
	*
	* @return the date of this logapi
	*/
	@Override
	public java.util.Date getDate() {
		return _logapi.getDate();
	}

	/**
	* Sets the date of this logapi.
	*
	* @param date the date of this logapi
	*/
	@Override
	public void setDate(java.util.Date date) {
		_logapi.setDate(date);
	}

	@Override
	public boolean isNew() {
		return _logapi.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_logapi.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _logapi.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_logapi.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _logapi.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _logapi.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_logapi.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _logapi.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_logapi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_logapi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_logapi.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LogapiWrapper((Logapi)_logapi.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi logapi) {
		return _logapi.compareTo(logapi);
	}

	@Override
	public int hashCode() {
		return _logapi.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi> toCacheModel() {
		return _logapi.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi toEscapedModel() {
		return new LogapiWrapper(_logapi.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Logapi toUnescapedModel() {
		return new LogapiWrapper(_logapi.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _logapi.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _logapi.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_logapi.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LogapiWrapper)) {
			return false;
		}

		LogapiWrapper logapiWrapper = (LogapiWrapper)obj;

		if (Validator.equals(_logapi, logapiWrapper._logapi)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Logapi getWrappedLogapi() {
		return _logapi;
	}

	@Override
	public Logapi getWrappedModel() {
		return _logapi;
	}

	@Override
	public void resetOriginalValues() {
		_logapi.resetOriginalValues();
	}

	private Logapi _logapi;
}