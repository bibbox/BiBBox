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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class KdssmpParameterOptionsSoap implements Serializable {
	public static KdssmpParameterOptionsSoap toSoapModel(
		KdssmpParameterOptions model) {
		KdssmpParameterOptionsSoap soapModel = new KdssmpParameterOptionsSoap();

		soapModel.setParameteroptionsId(model.getParameteroptionsId());
		soapModel.setParameterconfigurationId(model.getParameterconfigurationId());
		soapModel.setOption(model.getOption());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static KdssmpParameterOptionsSoap[] toSoapModels(
		KdssmpParameterOptions[] models) {
		KdssmpParameterOptionsSoap[] soapModels = new KdssmpParameterOptionsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KdssmpParameterOptionsSoap[][] toSoapModels(
		KdssmpParameterOptions[][] models) {
		KdssmpParameterOptionsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KdssmpParameterOptionsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KdssmpParameterOptionsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KdssmpParameterOptionsSoap[] toSoapModels(
		List<KdssmpParameterOptions> models) {
		List<KdssmpParameterOptionsSoap> soapModels = new ArrayList<KdssmpParameterOptionsSoap>(models.size());

		for (KdssmpParameterOptions model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KdssmpParameterOptionsSoap[soapModels.size()]);
	}

	public KdssmpParameterOptionsSoap() {
	}

	public long getPrimaryKey() {
		return _parameteroptionsId;
	}

	public void setPrimaryKey(long pk) {
		setParameteroptionsId(pk);
	}

	public long getParameteroptionsId() {
		return _parameteroptionsId;
	}

	public void setParameteroptionsId(long parameteroptionsId) {
		_parameteroptionsId = parameteroptionsId;
	}

	public long getParameterconfigurationId() {
		return _parameterconfigurationId;
	}

	public void setParameterconfigurationId(long parameterconfigurationId) {
		_parameterconfigurationId = parameterconfigurationId;
	}

	public String getOption() {
		return _option;
	}

	public void setOption(String option) {
		_option = option;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private long _parameteroptionsId;
	private long _parameterconfigurationId;
	private String _option;
	private String _value;
}