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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Rich Sezov
 * @generated
 */
public class PRProductSoap implements Serializable {
	public static PRProductSoap toSoapModel(PRProduct model) {
		PRProductSoap soapModel = new PRProductSoap();

		soapModel.setProductId(model.getProductId());
		soapModel.setProductName(model.getProductName());
		soapModel.setSerialNumber(model.getSerialNumber());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static PRProductSoap[] toSoapModels(PRProduct[] models) {
		PRProductSoap[] soapModels = new PRProductSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PRProductSoap[][] toSoapModels(PRProduct[][] models) {
		PRProductSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PRProductSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PRProductSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PRProductSoap[] toSoapModels(List<PRProduct> models) {
		List<PRProductSoap> soapModels = new ArrayList<PRProductSoap>(models.size());

		for (PRProduct model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PRProductSoap[soapModels.size()]);
	}

	public PRProductSoap() {
	}

	public long getPrimaryKey() {
		return _productId;
	}

	public void setPrimaryKey(long pk) {
		setProductId(pk);
	}

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public String getProductName() {
		return _productName;
	}

	public void setProductName(String productName) {
		_productName = productName;
	}

	public String getSerialNumber() {
		return _serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		_serialNumber = serialNumber;
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

	private long _productId;
	private String _productName;
	private String _serialNumber;
	private long _companyId;
	private long _groupId;
}