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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.rdconnect.update.service.http.AddressUpdateServiceSoap}.
 *
 * @author reihsr
 * @see at.rdconnect.update.service.http.AddressUpdateServiceSoap
 * @generated
 */
public class AddressUpdateSoap implements Serializable {
	public static AddressUpdateSoap toSoapModel(AddressUpdate model) {
		AddressUpdateSoap soapModel = new AddressUpdateSoap();

		soapModel.setAddressid(model.getAddressid());
		soapModel.setStreet1(model.getStreet1());
		soapModel.setStreet2(model.getStreet2());
		soapModel.setStreet3(model.getStreet3());
		soapModel.setCity(model.getCity());
		soapModel.setZip(model.getZip());
		soapModel.setRegionid(model.getRegionid());
		soapModel.setContryid(model.getContryid());
		soapModel.setTypeid(model.getTypeid());
		soapModel.setMailing(model.getMailing());
		soapModel.setPrimary_ad(model.getPrimary_ad());
		soapModel.setOrganizationid(model.getOrganizationid());

		return soapModel;
	}

	public static AddressUpdateSoap[] toSoapModels(AddressUpdate[] models) {
		AddressUpdateSoap[] soapModels = new AddressUpdateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AddressUpdateSoap[][] toSoapModels(AddressUpdate[][] models) {
		AddressUpdateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AddressUpdateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AddressUpdateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AddressUpdateSoap[] toSoapModels(List<AddressUpdate> models) {
		List<AddressUpdateSoap> soapModels = new ArrayList<AddressUpdateSoap>(models.size());

		for (AddressUpdate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AddressUpdateSoap[soapModels.size()]);
	}

	public AddressUpdateSoap() {
	}

	public long getPrimaryKey() {
		return _addressid;
	}

	public void setPrimaryKey(long pk) {
		setAddressid(pk);
	}

	public long getAddressid() {
		return _addressid;
	}

	public void setAddressid(long addressid) {
		_addressid = addressid;
	}

	public String getStreet1() {
		return _street1;
	}

	public void setStreet1(String street1) {
		_street1 = street1;
	}

	public String getStreet2() {
		return _street2;
	}

	public void setStreet2(String street2) {
		_street2 = street2;
	}

	public String getStreet3() {
		return _street3;
	}

	public void setStreet3(String street3) {
		_street3 = street3;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getZip() {
		return _zip;
	}

	public void setZip(String zip) {
		_zip = zip;
	}

	public long getRegionid() {
		return _regionid;
	}

	public void setRegionid(long regionid) {
		_regionid = regionid;
	}

	public long getContryid() {
		return _contryid;
	}

	public void setContryid(long contryid) {
		_contryid = contryid;
	}

	public long getTypeid() {
		return _typeid;
	}

	public void setTypeid(long typeid) {
		_typeid = typeid;
	}

	public boolean getMailing() {
		return _mailing;
	}

	public boolean isMailing() {
		return _mailing;
	}

	public void setMailing(boolean mailing) {
		_mailing = mailing;
	}

	public boolean getPrimary_ad() {
		return _primary_ad;
	}

	public boolean isPrimary_ad() {
		return _primary_ad;
	}

	public void setPrimary_ad(boolean primary_ad) {
		_primary_ad = primary_ad;
	}

	public long getOrganizationid() {
		return _organizationid;
	}

	public void setOrganizationid(long organizationid) {
		_organizationid = organizationid;
	}

	private long _addressid;
	private String _street1;
	private String _street2;
	private String _street3;
	private String _city;
	private String _zip;
	private long _regionid;
	private long _contryid;
	private long _typeid;
	private boolean _mailing;
	private boolean _primary_ad;
	private long _organizationid;
}