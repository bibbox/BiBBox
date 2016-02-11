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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.service.http.ImporterConfigServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.http.ImporterConfigServiceSoap
 * @generated
 */
public class ImporterConfigSoap implements Serializable {
	public static ImporterConfigSoap toSoapModel(ImporterConfig model) {
		ImporterConfigSoap soapModel = new ImporterConfigSoap();

		soapModel.setImporterconfigId(model.getImporterconfigId());
		soapModel.setScope(model.getScope());
		soapModel.setElementId(model.getElementId());
		soapModel.setElementvalue(model.getElementvalue());

		return soapModel;
	}

	public static ImporterConfigSoap[] toSoapModels(ImporterConfig[] models) {
		ImporterConfigSoap[] soapModels = new ImporterConfigSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ImporterConfigSoap[][] toSoapModels(ImporterConfig[][] models) {
		ImporterConfigSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ImporterConfigSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ImporterConfigSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ImporterConfigSoap[] toSoapModels(List<ImporterConfig> models) {
		List<ImporterConfigSoap> soapModels = new ArrayList<ImporterConfigSoap>(models.size());

		for (ImporterConfig model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ImporterConfigSoap[soapModels.size()]);
	}

	public ImporterConfigSoap() {
	}

	public long getPrimaryKey() {
		return _importerconfigId;
	}

	public void setPrimaryKey(long pk) {
		setImporterconfigId(pk);
	}

	public long getImporterconfigId() {
		return _importerconfigId;
	}

	public void setImporterconfigId(long importerconfigId) {
		_importerconfigId = importerconfigId;
	}

	public String getScope() {
		return _scope;
	}

	public void setScope(String scope) {
		_scope = scope;
	}

	public String getElementId() {
		return _elementId;
	}

	public void setElementId(String elementId) {
		_elementId = elementId;
	}

	public String getElementvalue() {
		return _elementvalue;
	}

	public void setElementvalue(String elementvalue) {
		_elementvalue = elementvalue;
	}

	private long _importerconfigId;
	private String _scope;
	private String _elementId;
	private String _elementvalue;
}