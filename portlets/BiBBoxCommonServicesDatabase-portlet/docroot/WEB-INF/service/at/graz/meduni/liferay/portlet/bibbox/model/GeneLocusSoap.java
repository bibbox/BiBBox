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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.http.GeneLocusServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.http.GeneLocusServiceSoap
 * @generated
 */
public class GeneLocusSoap implements Serializable {
	public static GeneLocusSoap toSoapModel(GeneLocus model) {
		GeneLocusSoap soapModel = new GeneLocusSoap();

		soapModel.setGenelocusId(model.getGenelocusId());
		soapModel.setGeneId(model.getGeneId());
		soapModel.setGenelocus(model.getGenelocus());
		soapModel.setGenelocuskey(model.getGenelocuskey());

		return soapModel;
	}

	public static GeneLocusSoap[] toSoapModels(GeneLocus[] models) {
		GeneLocusSoap[] soapModels = new GeneLocusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GeneLocusSoap[][] toSoapModels(GeneLocus[][] models) {
		GeneLocusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GeneLocusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GeneLocusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GeneLocusSoap[] toSoapModels(List<GeneLocus> models) {
		List<GeneLocusSoap> soapModels = new ArrayList<GeneLocusSoap>(models.size());

		for (GeneLocus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GeneLocusSoap[soapModels.size()]);
	}

	public GeneLocusSoap() {
	}

	public long getPrimaryKey() {
		return _genelocusId;
	}

	public void setPrimaryKey(long pk) {
		setGenelocusId(pk);
	}

	public long getGenelocusId() {
		return _genelocusId;
	}

	public void setGenelocusId(long genelocusId) {
		_genelocusId = genelocusId;
	}

	public long getGeneId() {
		return _geneId;
	}

	public void setGeneId(long geneId) {
		_geneId = geneId;
	}

	public String getGenelocus() {
		return _genelocus;
	}

	public void setGenelocus(String genelocus) {
		_genelocus = genelocus;
	}

	public String getGenelocuskey() {
		return _genelocuskey;
	}

	public void setGenelocuskey(String genelocuskey) {
		_genelocuskey = genelocuskey;
	}

	private long _genelocusId;
	private long _geneId;
	private String _genelocus;
	private String _genelocuskey;
}