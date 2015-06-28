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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.http.GeneReferenceServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.http.GeneReferenceServiceSoap
 * @generated
 */
public class GeneReferenceSoap implements Serializable {
	public static GeneReferenceSoap toSoapModel(GeneReference model) {
		GeneReferenceSoap soapModel = new GeneReferenceSoap();

		soapModel.setGenereferenceId(model.getGenereferenceId());
		soapModel.setGeneId(model.getGeneId());
		soapModel.setSource(model.getSource());
		soapModel.setReference(model.getReference());

		return soapModel;
	}

	public static GeneReferenceSoap[] toSoapModels(GeneReference[] models) {
		GeneReferenceSoap[] soapModels = new GeneReferenceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GeneReferenceSoap[][] toSoapModels(GeneReference[][] models) {
		GeneReferenceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GeneReferenceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GeneReferenceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GeneReferenceSoap[] toSoapModels(List<GeneReference> models) {
		List<GeneReferenceSoap> soapModels = new ArrayList<GeneReferenceSoap>(models.size());

		for (GeneReference model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GeneReferenceSoap[soapModels.size()]);
	}

	public GeneReferenceSoap() {
	}

	public long getPrimaryKey() {
		return _genereferenceId;
	}

	public void setPrimaryKey(long pk) {
		setGenereferenceId(pk);
	}

	public long getGenereferenceId() {
		return _genereferenceId;
	}

	public void setGenereferenceId(long genereferenceId) {
		_genereferenceId = genereferenceId;
	}

	public long getGeneId() {
		return _geneId;
	}

	public void setGeneId(long geneId) {
		_geneId = geneId;
	}

	public String getSource() {
		return _source;
	}

	public void setSource(String source) {
		_source = source;
	}

	public String getReference() {
		return _reference;
	}

	public void setReference(String reference) {
		_reference = reference;
	}

	private long _genereferenceId;
	private long _geneId;
	private String _source;
	private String _reference;
}