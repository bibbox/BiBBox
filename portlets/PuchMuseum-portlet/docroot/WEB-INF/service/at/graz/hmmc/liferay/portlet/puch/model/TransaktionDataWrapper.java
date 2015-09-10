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

package at.graz.hmmc.liferay.portlet.puch.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TransaktionData}.
 * </p>
 *
 * @author reihsr
 * @see TransaktionData
 * @generated
 */
public class TransaktionDataWrapper implements TransaktionData,
	ModelWrapper<TransaktionData> {
	public TransaktionDataWrapper(TransaktionData transaktionData) {
		_transaktionData = transaktionData;
	}

	@Override
	public Class<?> getModelClass() {
		return TransaktionData.class;
	}

	@Override
	public String getModelClassName() {
		return TransaktionData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("transaktiondataId", getTransaktiondataId());
		attributes.put("puchmuseumsobjectId", getPuchmuseumsobjectId());
		attributes.put("transaktionId", getTransaktionId());
		attributes.put("objectkey", getObjectkey());
		attributes.put("objectvalue", getObjectvalue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long transaktiondataId = (Long)attributes.get("transaktiondataId");

		if (transaktiondataId != null) {
			setTransaktiondataId(transaktiondataId);
		}

		Long puchmuseumsobjectId = (Long)attributes.get("puchmuseumsobjectId");

		if (puchmuseumsobjectId != null) {
			setPuchmuseumsobjectId(puchmuseumsobjectId);
		}

		Long transaktionId = (Long)attributes.get("transaktionId");

		if (transaktionId != null) {
			setTransaktionId(transaktionId);
		}

		String objectkey = (String)attributes.get("objectkey");

		if (objectkey != null) {
			setObjectkey(objectkey);
		}

		String objectvalue = (String)attributes.get("objectvalue");

		if (objectvalue != null) {
			setObjectvalue(objectvalue);
		}
	}

	/**
	* Returns the primary key of this transaktion data.
	*
	* @return the primary key of this transaktion data
	*/
	@Override
	public long getPrimaryKey() {
		return _transaktionData.getPrimaryKey();
	}

	/**
	* Sets the primary key of this transaktion data.
	*
	* @param primaryKey the primary key of this transaktion data
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_transaktionData.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the transaktiondata ID of this transaktion data.
	*
	* @return the transaktiondata ID of this transaktion data
	*/
	@Override
	public long getTransaktiondataId() {
		return _transaktionData.getTransaktiondataId();
	}

	/**
	* Sets the transaktiondata ID of this transaktion data.
	*
	* @param transaktiondataId the transaktiondata ID of this transaktion data
	*/
	@Override
	public void setTransaktiondataId(long transaktiondataId) {
		_transaktionData.setTransaktiondataId(transaktiondataId);
	}

	/**
	* Returns the puchmuseumsobject ID of this transaktion data.
	*
	* @return the puchmuseumsobject ID of this transaktion data
	*/
	@Override
	public long getPuchmuseumsobjectId() {
		return _transaktionData.getPuchmuseumsobjectId();
	}

	/**
	* Sets the puchmuseumsobject ID of this transaktion data.
	*
	* @param puchmuseumsobjectId the puchmuseumsobject ID of this transaktion data
	*/
	@Override
	public void setPuchmuseumsobjectId(long puchmuseumsobjectId) {
		_transaktionData.setPuchmuseumsobjectId(puchmuseumsobjectId);
	}

	/**
	* Returns the transaktion ID of this transaktion data.
	*
	* @return the transaktion ID of this transaktion data
	*/
	@Override
	public long getTransaktionId() {
		return _transaktionData.getTransaktionId();
	}

	/**
	* Sets the transaktion ID of this transaktion data.
	*
	* @param transaktionId the transaktion ID of this transaktion data
	*/
	@Override
	public void setTransaktionId(long transaktionId) {
		_transaktionData.setTransaktionId(transaktionId);
	}

	/**
	* Returns the objectkey of this transaktion data.
	*
	* @return the objectkey of this transaktion data
	*/
	@Override
	public java.lang.String getObjectkey() {
		return _transaktionData.getObjectkey();
	}

	/**
	* Sets the objectkey of this transaktion data.
	*
	* @param objectkey the objectkey of this transaktion data
	*/
	@Override
	public void setObjectkey(java.lang.String objectkey) {
		_transaktionData.setObjectkey(objectkey);
	}

	/**
	* Returns the objectvalue of this transaktion data.
	*
	* @return the objectvalue of this transaktion data
	*/
	@Override
	public java.lang.String getObjectvalue() {
		return _transaktionData.getObjectvalue();
	}

	/**
	* Sets the objectvalue of this transaktion data.
	*
	* @param objectvalue the objectvalue of this transaktion data
	*/
	@Override
	public void setObjectvalue(java.lang.String objectvalue) {
		_transaktionData.setObjectvalue(objectvalue);
	}

	@Override
	public boolean isNew() {
		return _transaktionData.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_transaktionData.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _transaktionData.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_transaktionData.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _transaktionData.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _transaktionData.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_transaktionData.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _transaktionData.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_transaktionData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_transaktionData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_transaktionData.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TransaktionDataWrapper((TransaktionData)_transaktionData.clone());
	}

	@Override
	public int compareTo(
		at.graz.hmmc.liferay.portlet.puch.model.TransaktionData transaktionData) {
		return _transaktionData.compareTo(transaktionData);
	}

	@Override
	public int hashCode() {
		return _transaktionData.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.hmmc.liferay.portlet.puch.model.TransaktionData> toCacheModel() {
		return _transaktionData.toCacheModel();
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData toEscapedModel() {
		return new TransaktionDataWrapper(_transaktionData.toEscapedModel());
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.TransaktionData toUnescapedModel() {
		return new TransaktionDataWrapper(_transaktionData.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _transaktionData.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _transaktionData.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_transaktionData.persist();
	}

	@Override
	public java.lang.String formatValueHTML() {
		return _transaktionData.formatValueHTML();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TransaktionDataWrapper)) {
			return false;
		}

		TransaktionDataWrapper transaktionDataWrapper = (TransaktionDataWrapper)obj;

		if (Validator.equals(_transaktionData,
					transaktionDataWrapper._transaktionData)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TransaktionData getWrappedTransaktionData() {
		return _transaktionData;
	}

	@Override
	public TransaktionData getWrappedModel() {
		return _transaktionData;
	}

	@Override
	public void resetOriginalValues() {
		_transaktionData.resetOriginalValues();
	}

	private TransaktionData _transaktionData;
}