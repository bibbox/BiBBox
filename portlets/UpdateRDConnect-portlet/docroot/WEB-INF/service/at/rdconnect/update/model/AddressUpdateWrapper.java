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

package at.rdconnect.update.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AddressUpdate}.
 * </p>
 *
 * @author reihsr
 * @see AddressUpdate
 * @generated
 */
public class AddressUpdateWrapper implements AddressUpdate,
	ModelWrapper<AddressUpdate> {
	public AddressUpdateWrapper(AddressUpdate addressUpdate) {
		_addressUpdate = addressUpdate;
	}

	@Override
	public Class<?> getModelClass() {
		return AddressUpdate.class;
	}

	@Override
	public String getModelClassName() {
		return AddressUpdate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressid", getAddressid());
		attributes.put("street1", getStreet1());
		attributes.put("street2", getStreet2());
		attributes.put("street3", getStreet3());
		attributes.put("city", getCity());
		attributes.put("zip", getZip());
		attributes.put("regionid", getRegionid());
		attributes.put("contryid", getContryid());
		attributes.put("typeid", getTypeid());
		attributes.put("mailing", getMailing());
		attributes.put("primary_ad", getPrimary_ad());
		attributes.put("organizationid", getOrganizationid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressid = (Long)attributes.get("addressid");

		if (addressid != null) {
			setAddressid(addressid);
		}

		String street1 = (String)attributes.get("street1");

		if (street1 != null) {
			setStreet1(street1);
		}

		String street2 = (String)attributes.get("street2");

		if (street2 != null) {
			setStreet2(street2);
		}

		String street3 = (String)attributes.get("street3");

		if (street3 != null) {
			setStreet3(street3);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String zip = (String)attributes.get("zip");

		if (zip != null) {
			setZip(zip);
		}

		Long regionid = (Long)attributes.get("regionid");

		if (regionid != null) {
			setRegionid(regionid);
		}

		Long contryid = (Long)attributes.get("contryid");

		if (contryid != null) {
			setContryid(contryid);
		}

		Long typeid = (Long)attributes.get("typeid");

		if (typeid != null) {
			setTypeid(typeid);
		}

		Boolean mailing = (Boolean)attributes.get("mailing");

		if (mailing != null) {
			setMailing(mailing);
		}

		Boolean primary_ad = (Boolean)attributes.get("primary_ad");

		if (primary_ad != null) {
			setPrimary_ad(primary_ad);
		}

		Long organizationid = (Long)attributes.get("organizationid");

		if (organizationid != null) {
			setOrganizationid(organizationid);
		}
	}

	/**
	* Returns the primary key of this address update.
	*
	* @return the primary key of this address update
	*/
	@Override
	public long getPrimaryKey() {
		return _addressUpdate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this address update.
	*
	* @param primaryKey the primary key of this address update
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_addressUpdate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the addressid of this address update.
	*
	* @return the addressid of this address update
	*/
	@Override
	public long getAddressid() {
		return _addressUpdate.getAddressid();
	}

	/**
	* Sets the addressid of this address update.
	*
	* @param addressid the addressid of this address update
	*/
	@Override
	public void setAddressid(long addressid) {
		_addressUpdate.setAddressid(addressid);
	}

	/**
	* Returns the street1 of this address update.
	*
	* @return the street1 of this address update
	*/
	@Override
	public java.lang.String getStreet1() {
		return _addressUpdate.getStreet1();
	}

	/**
	* Sets the street1 of this address update.
	*
	* @param street1 the street1 of this address update
	*/
	@Override
	public void setStreet1(java.lang.String street1) {
		_addressUpdate.setStreet1(street1);
	}

	/**
	* Returns the street2 of this address update.
	*
	* @return the street2 of this address update
	*/
	@Override
	public java.lang.String getStreet2() {
		return _addressUpdate.getStreet2();
	}

	/**
	* Sets the street2 of this address update.
	*
	* @param street2 the street2 of this address update
	*/
	@Override
	public void setStreet2(java.lang.String street2) {
		_addressUpdate.setStreet2(street2);
	}

	/**
	* Returns the street3 of this address update.
	*
	* @return the street3 of this address update
	*/
	@Override
	public java.lang.String getStreet3() {
		return _addressUpdate.getStreet3();
	}

	/**
	* Sets the street3 of this address update.
	*
	* @param street3 the street3 of this address update
	*/
	@Override
	public void setStreet3(java.lang.String street3) {
		_addressUpdate.setStreet3(street3);
	}

	/**
	* Returns the city of this address update.
	*
	* @return the city of this address update
	*/
	@Override
	public java.lang.String getCity() {
		return _addressUpdate.getCity();
	}

	/**
	* Sets the city of this address update.
	*
	* @param city the city of this address update
	*/
	@Override
	public void setCity(java.lang.String city) {
		_addressUpdate.setCity(city);
	}

	/**
	* Returns the zip of this address update.
	*
	* @return the zip of this address update
	*/
	@Override
	public java.lang.String getZip() {
		return _addressUpdate.getZip();
	}

	/**
	* Sets the zip of this address update.
	*
	* @param zip the zip of this address update
	*/
	@Override
	public void setZip(java.lang.String zip) {
		_addressUpdate.setZip(zip);
	}

	/**
	* Returns the regionid of this address update.
	*
	* @return the regionid of this address update
	*/
	@Override
	public long getRegionid() {
		return _addressUpdate.getRegionid();
	}

	/**
	* Sets the regionid of this address update.
	*
	* @param regionid the regionid of this address update
	*/
	@Override
	public void setRegionid(long regionid) {
		_addressUpdate.setRegionid(regionid);
	}

	/**
	* Returns the contryid of this address update.
	*
	* @return the contryid of this address update
	*/
	@Override
	public long getContryid() {
		return _addressUpdate.getContryid();
	}

	/**
	* Sets the contryid of this address update.
	*
	* @param contryid the contryid of this address update
	*/
	@Override
	public void setContryid(long contryid) {
		_addressUpdate.setContryid(contryid);
	}

	/**
	* Returns the typeid of this address update.
	*
	* @return the typeid of this address update
	*/
	@Override
	public long getTypeid() {
		return _addressUpdate.getTypeid();
	}

	/**
	* Sets the typeid of this address update.
	*
	* @param typeid the typeid of this address update
	*/
	@Override
	public void setTypeid(long typeid) {
		_addressUpdate.setTypeid(typeid);
	}

	/**
	* Returns the mailing of this address update.
	*
	* @return the mailing of this address update
	*/
	@Override
	public boolean getMailing() {
		return _addressUpdate.getMailing();
	}

	/**
	* Returns <code>true</code> if this address update is mailing.
	*
	* @return <code>true</code> if this address update is mailing; <code>false</code> otherwise
	*/
	@Override
	public boolean isMailing() {
		return _addressUpdate.isMailing();
	}

	/**
	* Sets whether this address update is mailing.
	*
	* @param mailing the mailing of this address update
	*/
	@Override
	public void setMailing(boolean mailing) {
		_addressUpdate.setMailing(mailing);
	}

	/**
	* Returns the primary_ad of this address update.
	*
	* @return the primary_ad of this address update
	*/
	@Override
	public boolean getPrimary_ad() {
		return _addressUpdate.getPrimary_ad();
	}

	/**
	* Returns <code>true</code> if this address update is primary_ad.
	*
	* @return <code>true</code> if this address update is primary_ad; <code>false</code> otherwise
	*/
	@Override
	public boolean isPrimary_ad() {
		return _addressUpdate.isPrimary_ad();
	}

	/**
	* Sets whether this address update is primary_ad.
	*
	* @param primary_ad the primary_ad of this address update
	*/
	@Override
	public void setPrimary_ad(boolean primary_ad) {
		_addressUpdate.setPrimary_ad(primary_ad);
	}

	/**
	* Returns the organizationid of this address update.
	*
	* @return the organizationid of this address update
	*/
	@Override
	public long getOrganizationid() {
		return _addressUpdate.getOrganizationid();
	}

	/**
	* Sets the organizationid of this address update.
	*
	* @param organizationid the organizationid of this address update
	*/
	@Override
	public void setOrganizationid(long organizationid) {
		_addressUpdate.setOrganizationid(organizationid);
	}

	@Override
	public boolean isNew() {
		return _addressUpdate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_addressUpdate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _addressUpdate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_addressUpdate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _addressUpdate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _addressUpdate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_addressUpdate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _addressUpdate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_addressUpdate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_addressUpdate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_addressUpdate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AddressUpdateWrapper((AddressUpdate)_addressUpdate.clone());
	}

	@Override
	public int compareTo(at.rdconnect.update.model.AddressUpdate addressUpdate) {
		return _addressUpdate.compareTo(addressUpdate);
	}

	@Override
	public int hashCode() {
		return _addressUpdate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.rdconnect.update.model.AddressUpdate> toCacheModel() {
		return _addressUpdate.toCacheModel();
	}

	@Override
	public at.rdconnect.update.model.AddressUpdate toEscapedModel() {
		return new AddressUpdateWrapper(_addressUpdate.toEscapedModel());
	}

	@Override
	public at.rdconnect.update.model.AddressUpdate toUnescapedModel() {
		return new AddressUpdateWrapper(_addressUpdate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _addressUpdate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _addressUpdate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_addressUpdate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressUpdateWrapper)) {
			return false;
		}

		AddressUpdateWrapper addressUpdateWrapper = (AddressUpdateWrapper)obj;

		if (Validator.equals(_addressUpdate, addressUpdateWrapper._addressUpdate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AddressUpdate getWrappedAddressUpdate() {
		return _addressUpdate;
	}

	@Override
	public AddressUpdate getWrappedModel() {
		return _addressUpdate;
	}

	@Override
	public void resetOriginalValues() {
		_addressUpdate.resetOriginalValues();
	}

	private AddressUpdate _addressUpdate;
}