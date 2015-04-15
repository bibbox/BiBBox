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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Networks}.
 * </p>
 *
 * @author reihsr
 * @see Networks
 * @generated
 */
public class NetworksWrapper implements Networks, ModelWrapper<Networks> {
	public NetworksWrapper(Networks networks) {
		_networks = networks;
	}

	@Override
	public Class<?> getModelClass() {
		return Networks.class;
	}

	@Override
	public String getModelClassName() {
		return Networks.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("networkId", getNetworkId());
		attributes.put("organizationnetworkId", getOrganizationnetworkId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("relation", getRelation());
		attributes.put("yearofestablishment", getYearofestablishment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long networkId = (Long)attributes.get("networkId");

		if (networkId != null) {
			setNetworkId(networkId);
		}

		Long organizationnetworkId = (Long)attributes.get(
				"organizationnetworkId");

		if (organizationnetworkId != null) {
			setOrganizationnetworkId(organizationnetworkId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String relation = (String)attributes.get("relation");

		if (relation != null) {
			setRelation(relation);
		}

		String yearofestablishment = (String)attributes.get(
				"yearofestablishment");

		if (yearofestablishment != null) {
			setYearofestablishment(yearofestablishment);
		}
	}

	/**
	* Returns the primary key of this networks.
	*
	* @return the primary key of this networks
	*/
	@Override
	public long getPrimaryKey() {
		return _networks.getPrimaryKey();
	}

	/**
	* Sets the primary key of this networks.
	*
	* @param primaryKey the primary key of this networks
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_networks.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the network ID of this networks.
	*
	* @return the network ID of this networks
	*/
	@Override
	public long getNetworkId() {
		return _networks.getNetworkId();
	}

	/**
	* Sets the network ID of this networks.
	*
	* @param networkId the network ID of this networks
	*/
	@Override
	public void setNetworkId(long networkId) {
		_networks.setNetworkId(networkId);
	}

	/**
	* Returns the organizationnetwork ID of this networks.
	*
	* @return the organizationnetwork ID of this networks
	*/
	@Override
	public long getOrganizationnetworkId() {
		return _networks.getOrganizationnetworkId();
	}

	/**
	* Sets the organizationnetwork ID of this networks.
	*
	* @param organizationnetworkId the organizationnetwork ID of this networks
	*/
	@Override
	public void setOrganizationnetworkId(long organizationnetworkId) {
		_networks.setOrganizationnetworkId(organizationnetworkId);
	}

	/**
	* Returns the organization ID of this networks.
	*
	* @return the organization ID of this networks
	*/
	@Override
	public long getOrganizationId() {
		return _networks.getOrganizationId();
	}

	/**
	* Sets the organization ID of this networks.
	*
	* @param organizationId the organization ID of this networks
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_networks.setOrganizationId(organizationId);
	}

	/**
	* Returns the relation of this networks.
	*
	* @return the relation of this networks
	*/
	@Override
	public java.lang.String getRelation() {
		return _networks.getRelation();
	}

	/**
	* Sets the relation of this networks.
	*
	* @param relation the relation of this networks
	*/
	@Override
	public void setRelation(java.lang.String relation) {
		_networks.setRelation(relation);
	}

	/**
	* Returns the yearofestablishment of this networks.
	*
	* @return the yearofestablishment of this networks
	*/
	@Override
	public java.lang.String getYearofestablishment() {
		return _networks.getYearofestablishment();
	}

	/**
	* Sets the yearofestablishment of this networks.
	*
	* @param yearofestablishment the yearofestablishment of this networks
	*/
	@Override
	public void setYearofestablishment(java.lang.String yearofestablishment) {
		_networks.setYearofestablishment(yearofestablishment);
	}

	@Override
	public boolean isNew() {
		return _networks.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_networks.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _networks.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_networks.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _networks.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _networks.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_networks.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _networks.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_networks.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_networks.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_networks.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NetworksWrapper((Networks)_networks.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Networks networks) {
		return _networks.compareTo(networks);
	}

	@Override
	public int hashCode() {
		return _networks.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.service.model.Networks> toCacheModel() {
		return _networks.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Networks toEscapedModel() {
		return new NetworksWrapper(_networks.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.Networks toUnescapedModel() {
		return new NetworksWrapper(_networks.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _networks.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _networks.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_networks.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NetworksWrapper)) {
			return false;
		}

		NetworksWrapper networksWrapper = (NetworksWrapper)obj;

		if (Validator.equals(_networks, networksWrapper._networks)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Networks getWrappedNetworks() {
		return _networks;
	}

	@Override
	public Networks getWrappedModel() {
		return _networks;
	}

	@Override
	public void resetOriginalValues() {
		_networks.resetOriginalValues();
	}

	private Networks _networks;
}