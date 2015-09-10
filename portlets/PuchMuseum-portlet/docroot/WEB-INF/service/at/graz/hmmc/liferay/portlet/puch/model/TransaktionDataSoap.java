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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class TransaktionDataSoap implements Serializable {
	public static TransaktionDataSoap toSoapModel(TransaktionData model) {
		TransaktionDataSoap soapModel = new TransaktionDataSoap();

		soapModel.setTransaktiondataId(model.getTransaktiondataId());
		soapModel.setPuchmuseumsobjectId(model.getPuchmuseumsobjectId());
		soapModel.setTransaktionId(model.getTransaktionId());
		soapModel.setObjectkey(model.getObjectkey());
		soapModel.setObjectvalue(model.getObjectvalue());

		return soapModel;
	}

	public static TransaktionDataSoap[] toSoapModels(TransaktionData[] models) {
		TransaktionDataSoap[] soapModels = new TransaktionDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TransaktionDataSoap[][] toSoapModels(
		TransaktionData[][] models) {
		TransaktionDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TransaktionDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TransaktionDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TransaktionDataSoap[] toSoapModels(
		List<TransaktionData> models) {
		List<TransaktionDataSoap> soapModels = new ArrayList<TransaktionDataSoap>(models.size());

		for (TransaktionData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TransaktionDataSoap[soapModels.size()]);
	}

	public TransaktionDataSoap() {
	}

	public long getPrimaryKey() {
		return _transaktiondataId;
	}

	public void setPrimaryKey(long pk) {
		setTransaktiondataId(pk);
	}

	public long getTransaktiondataId() {
		return _transaktiondataId;
	}

	public void setTransaktiondataId(long transaktiondataId) {
		_transaktiondataId = transaktiondataId;
	}

	public long getPuchmuseumsobjectId() {
		return _puchmuseumsobjectId;
	}

	public void setPuchmuseumsobjectId(long puchmuseumsobjectId) {
		_puchmuseumsobjectId = puchmuseumsobjectId;
	}

	public long getTransaktionId() {
		return _transaktionId;
	}

	public void setTransaktionId(long transaktionId) {
		_transaktionId = transaktionId;
	}

	public String getObjectkey() {
		return _objectkey;
	}

	public void setObjectkey(String objectkey) {
		_objectkey = objectkey;
	}

	public String getObjectvalue() {
		return _objectvalue;
	}

	public void setObjectvalue(String objectvalue) {
		_objectvalue = objectvalue;
	}

	private long _transaktiondataId;
	private long _puchmuseumsobjectId;
	private long _transaktionId;
	private String _objectkey;
	private String _objectvalue;
}