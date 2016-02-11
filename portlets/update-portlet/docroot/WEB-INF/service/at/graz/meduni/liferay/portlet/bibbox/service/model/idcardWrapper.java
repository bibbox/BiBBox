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
 * This class is a wrapper for {@link idcard}.
 * </p>
 *
 * @author reihsr
 * @see idcard
 * @generated
 */
public class idcardWrapper implements idcard, ModelWrapper<idcard> {
	public idcardWrapper(idcard idcard) {
		_idcard = idcard;
	}

	@Override
	public Class<?> getModelClass() {
		return idcard.class;
	}

	@Override
	public String getModelClassName() {
		return idcard.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idcardId", getIdcardId());
		attributes.put("userId", getUserId());
		attributes.put("userip", getUserip());
		attributes.put("logmsg", getLogmsg());
		attributes.put("date", getDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idcardId = (Long)attributes.get("idcardId");

		if (idcardId != null) {
			setIdcardId(idcardId);
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
	* Returns the primary key of this idcard.
	*
	* @return the primary key of this idcard
	*/
	@Override
	public long getPrimaryKey() {
		return _idcard.getPrimaryKey();
	}

	/**
	* Sets the primary key of this idcard.
	*
	* @param primaryKey the primary key of this idcard
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_idcard.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the idcard ID of this idcard.
	*
	* @return the idcard ID of this idcard
	*/
	@Override
	public long getIdcardId() {
		return _idcard.getIdcardId();
	}

	/**
	* Sets the idcard ID of this idcard.
	*
	* @param idcardId the idcard ID of this idcard
	*/
	@Override
	public void setIdcardId(long idcardId) {
		_idcard.setIdcardId(idcardId);
	}

	/**
	* Returns the user ID of this idcard.
	*
	* @return the user ID of this idcard
	*/
	@Override
	public long getUserId() {
		return _idcard.getUserId();
	}

	/**
	* Sets the user ID of this idcard.
	*
	* @param userId the user ID of this idcard
	*/
	@Override
	public void setUserId(long userId) {
		_idcard.setUserId(userId);
	}

	/**
	* Returns the user uuid of this idcard.
	*
	* @return the user uuid of this idcard
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _idcard.getUserUuid();
	}

	/**
	* Sets the user uuid of this idcard.
	*
	* @param userUuid the user uuid of this idcard
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_idcard.setUserUuid(userUuid);
	}

	/**
	* Returns the userip of this idcard.
	*
	* @return the userip of this idcard
	*/
	@Override
	public java.lang.String getUserip() {
		return _idcard.getUserip();
	}

	/**
	* Sets the userip of this idcard.
	*
	* @param userip the userip of this idcard
	*/
	@Override
	public void setUserip(java.lang.String userip) {
		_idcard.setUserip(userip);
	}

	/**
	* Returns the logmsg of this idcard.
	*
	* @return the logmsg of this idcard
	*/
	@Override
	public java.lang.String getLogmsg() {
		return _idcard.getLogmsg();
	}

	/**
	* Sets the logmsg of this idcard.
	*
	* @param logmsg the logmsg of this idcard
	*/
	@Override
	public void setLogmsg(java.lang.String logmsg) {
		_idcard.setLogmsg(logmsg);
	}

	/**
	* Returns the date of this idcard.
	*
	* @return the date of this idcard
	*/
	@Override
	public java.util.Date getDate() {
		return _idcard.getDate();
	}

	/**
	* Sets the date of this idcard.
	*
	* @param date the date of this idcard
	*/
	@Override
	public void setDate(java.util.Date date) {
		_idcard.setDate(date);
	}

	@Override
	public boolean isNew() {
		return _idcard.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_idcard.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _idcard.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_idcard.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _idcard.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _idcard.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_idcard.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _idcard.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_idcard.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_idcard.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_idcard.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new idcardWrapper((idcard)_idcard.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.service.model.idcard idcard) {
		return _idcard.compareTo(idcard);
	}

	@Override
	public int hashCode() {
		return _idcard.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.service.model.idcard> toCacheModel() {
		return _idcard.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.idcard toEscapedModel() {
		return new idcardWrapper(_idcard.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.idcard toUnescapedModel() {
		return new idcardWrapper(_idcard.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _idcard.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _idcard.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_idcard.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof idcardWrapper)) {
			return false;
		}

		idcardWrapper idcardWrapper = (idcardWrapper)obj;

		if (Validator.equals(_idcard, idcardWrapper._idcard)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public idcard getWrappedidcard() {
		return _idcard;
	}

	@Override
	public idcard getWrappedModel() {
		return _idcard;
	}

	@Override
	public void resetOriginalValues() {
		_idcard.resetOriginalValues();
	}

	private idcard _idcard;
}