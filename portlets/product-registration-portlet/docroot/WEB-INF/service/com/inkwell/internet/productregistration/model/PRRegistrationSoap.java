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

package com.inkwell.internet.productregistration.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Rich Sezov
 * @generated
 */
public class PRRegistrationSoap implements Serializable {
	public static PRRegistrationSoap toSoapModel(PRRegistration model) {
		PRRegistrationSoap soapModel = new PRRegistrationSoap();

		soapModel.setRegistrationId(model.getRegistrationId());
		soapModel.setPrUserId(model.getPrUserId());
		soapModel.setDatePurchased(model.getDatePurchased());
		soapModel.setHowHear(model.getHowHear());
		soapModel.setWherePurchased(model.getWherePurchased());
		soapModel.setSerialNumber(model.getSerialNumber());
		soapModel.setProductId(model.getProductId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static PRRegistrationSoap[] toSoapModels(PRRegistration[] models) {
		PRRegistrationSoap[] soapModels = new PRRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PRRegistrationSoap[][] toSoapModels(PRRegistration[][] models) {
		PRRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PRRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PRRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PRRegistrationSoap[] toSoapModels(List<PRRegistration> models) {
		List<PRRegistrationSoap> soapModels = new ArrayList<PRRegistrationSoap>(models.size());

		for (PRRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PRRegistrationSoap[soapModels.size()]);
	}

	public PRRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _registrationId;
	}

	public void setPrimaryKey(long pk) {
		setRegistrationId(pk);
	}

	public long getRegistrationId() {
		return _registrationId;
	}

	public void setRegistrationId(long registrationId) {
		_registrationId = registrationId;
	}

	public long getPrUserId() {
		return _prUserId;
	}

	public void setPrUserId(long prUserId) {
		_prUserId = prUserId;
	}

	public Date getDatePurchased() {
		return _datePurchased;
	}

	public void setDatePurchased(Date datePurchased) {
		_datePurchased = datePurchased;
	}

	public String getHowHear() {
		return _howHear;
	}

	public void setHowHear(String howHear) {
		_howHear = howHear;
	}

	public String getWherePurchased() {
		return _wherePurchased;
	}

	public void setWherePurchased(String wherePurchased) {
		_wherePurchased = wherePurchased;
	}

	public String getSerialNumber() {
		return _serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		_serialNumber = serialNumber;
	}

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private long _registrationId;
	private long _prUserId;
	private Date _datePurchased;
	private String _howHear;
	private String _wherePurchased;
	private String _serialNumber;
	private long _productId;
	private long _companyId;
	private long _groupId;
}