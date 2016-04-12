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

package at.graz.meduni.liferay.portlet.bibbox.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.http.GeneSynonymServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.http.GeneSynonymServiceSoap
 * @generated
 */
public class GeneSynonymSoap implements Serializable {
	public static GeneSynonymSoap toSoapModel(GeneSynonym model) {
		GeneSynonymSoap soapModel = new GeneSynonymSoap();

		soapModel.setGenesynonymId(model.getGenesynonymId());
		soapModel.setGeneId(model.getGeneId());
		soapModel.setSynonym(model.getSynonym());

		return soapModel;
	}

	public static GeneSynonymSoap[] toSoapModels(GeneSynonym[] models) {
		GeneSynonymSoap[] soapModels = new GeneSynonymSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GeneSynonymSoap[][] toSoapModels(GeneSynonym[][] models) {
		GeneSynonymSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GeneSynonymSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GeneSynonymSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GeneSynonymSoap[] toSoapModels(List<GeneSynonym> models) {
		List<GeneSynonymSoap> soapModels = new ArrayList<GeneSynonymSoap>(models.size());

		for (GeneSynonym model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GeneSynonymSoap[soapModels.size()]);
	}

	public GeneSynonymSoap() {
	}

	public long getPrimaryKey() {
		return _genesynonymId;
	}

	public void setPrimaryKey(long pk) {
		setGenesynonymId(pk);
	}

	public long getGenesynonymId() {
		return _genesynonymId;
	}

	public void setGenesynonymId(long genesynonymId) {
		_genesynonymId = genesynonymId;
	}

	public long getGeneId() {
		return _geneId;
	}

	public void setGeneId(long geneId) {
		_geneId = geneId;
	}

	public String getSynonym() {
		return _synonym;
	}

	public void setSynonym(String synonym) {
		_synonym = synonym;
	}

	private long _genesynonymId;
	private long _geneId;
	private String _synonym;
}