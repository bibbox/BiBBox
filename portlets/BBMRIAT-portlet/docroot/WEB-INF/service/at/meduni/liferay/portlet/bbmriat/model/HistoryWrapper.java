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

package at.meduni.liferay.portlet.bbmriat.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link History}.
 * </p>
 *
 * @author Robert Reihs
 * @see History
 * @generated
 */
public class HistoryWrapper implements History, ModelWrapper<History> {
	public HistoryWrapper(History history) {
		_history = history;
	}

	@Override
	public Class<?> getModelClass() {
		return History.class;
	}

	@Override
	public String getModelClassName() {
		return History.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("historyId", getHistoryId());
		attributes.put("action", getAction());
		attributes.put("time", getTime());
		attributes.put("histo_id", getHisto_id());
		attributes.put("workplace_id", getWorkplace_id());
		attributes.put("order_id", getOrder_id());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long historyId = (Long)attributes.get("historyId");

		if (historyId != null) {
			setHistoryId(historyId);
		}

		Long action = (Long)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		Date time = (Date)attributes.get("time");

		if (time != null) {
			setTime(time);
		}

		Long histo_id = (Long)attributes.get("histo_id");

		if (histo_id != null) {
			setHisto_id(histo_id);
		}

		Long workplace_id = (Long)attributes.get("workplace_id");

		if (workplace_id != null) {
			setWorkplace_id(workplace_id);
		}

		Long order_id = (Long)attributes.get("order_id");

		if (order_id != null) {
			setOrder_id(order_id);
		}
	}

	/**
	* Returns the primary key of this history.
	*
	* @return the primary key of this history
	*/
	@Override
	public long getPrimaryKey() {
		return _history.getPrimaryKey();
	}

	/**
	* Sets the primary key of this history.
	*
	* @param primaryKey the primary key of this history
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_history.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the history ID of this history.
	*
	* @return the history ID of this history
	*/
	@Override
	public long getHistoryId() {
		return _history.getHistoryId();
	}

	/**
	* Sets the history ID of this history.
	*
	* @param historyId the history ID of this history
	*/
	@Override
	public void setHistoryId(long historyId) {
		_history.setHistoryId(historyId);
	}

	/**
	* Returns the action of this history.
	*
	* @return the action of this history
	*/
	@Override
	public long getAction() {
		return _history.getAction();
	}

	/**
	* Sets the action of this history.
	*
	* @param action the action of this history
	*/
	@Override
	public void setAction(long action) {
		_history.setAction(action);
	}

	/**
	* Returns the time of this history.
	*
	* @return the time of this history
	*/
	@Override
	public java.util.Date getTime() {
		return _history.getTime();
	}

	/**
	* Sets the time of this history.
	*
	* @param time the time of this history
	*/
	@Override
	public void setTime(java.util.Date time) {
		_history.setTime(time);
	}

	/**
	* Returns the histo_id of this history.
	*
	* @return the histo_id of this history
	*/
	@Override
	public long getHisto_id() {
		return _history.getHisto_id();
	}

	/**
	* Sets the histo_id of this history.
	*
	* @param histo_id the histo_id of this history
	*/
	@Override
	public void setHisto_id(long histo_id) {
		_history.setHisto_id(histo_id);
	}

	/**
	* Returns the workplace_id of this history.
	*
	* @return the workplace_id of this history
	*/
	@Override
	public long getWorkplace_id() {
		return _history.getWorkplace_id();
	}

	/**
	* Sets the workplace_id of this history.
	*
	* @param workplace_id the workplace_id of this history
	*/
	@Override
	public void setWorkplace_id(long workplace_id) {
		_history.setWorkplace_id(workplace_id);
	}

	/**
	* Returns the order_id of this history.
	*
	* @return the order_id of this history
	*/
	@Override
	public long getOrder_id() {
		return _history.getOrder_id();
	}

	/**
	* Sets the order_id of this history.
	*
	* @param order_id the order_id of this history
	*/
	@Override
	public void setOrder_id(long order_id) {
		_history.setOrder_id(order_id);
	}

	@Override
	public boolean isNew() {
		return _history.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_history.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _history.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_history.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _history.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _history.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_history.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _history.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_history.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_history.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_history.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HistoryWrapper((History)_history.clone());
	}

	@Override
	public int compareTo(
		at.meduni.liferay.portlet.bbmriat.model.History history) {
		return _history.compareTo(history);
	}

	@Override
	public int hashCode() {
		return _history.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.meduni.liferay.portlet.bbmriat.model.History> toCacheModel() {
		return _history.toCacheModel();
	}

	@Override
	public at.meduni.liferay.portlet.bbmriat.model.History toEscapedModel() {
		return new HistoryWrapper(_history.toEscapedModel());
	}

	@Override
	public at.meduni.liferay.portlet.bbmriat.model.History toUnescapedModel() {
		return new HistoryWrapper(_history.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _history.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _history.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_history.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HistoryWrapper)) {
			return false;
		}

		HistoryWrapper historyWrapper = (HistoryWrapper)obj;

		if (Validator.equals(_history, historyWrapper._history)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public History getWrappedHistory() {
		return _history;
	}

	@Override
	public History getWrappedModel() {
		return _history;
	}

	@Override
	public void resetOriginalValues() {
		_history.resetOriginalValues();
	}

	private History _history;
}