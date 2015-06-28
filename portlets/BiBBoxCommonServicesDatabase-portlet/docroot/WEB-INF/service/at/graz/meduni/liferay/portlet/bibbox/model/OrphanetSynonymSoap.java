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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.http.OrphanetSynonymServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.http.OrphanetSynonymServiceSoap
 * @generated
 */
public class OrphanetSynonymSoap implements Serializable {
	public static OrphanetSynonymSoap toSoapModel(OrphanetSynonym model) {
		OrphanetSynonymSoap soapModel = new OrphanetSynonymSoap();

		soapModel.setOrphanetsynonymId(model.getOrphanetsynonymId());
		soapModel.setOrphanetdisorderId(model.getOrphanetdisorderId());
		soapModel.setSynonym(model.getSynonym());

		return soapModel;
	}

	public static OrphanetSynonymSoap[] toSoapModels(OrphanetSynonym[] models) {
		OrphanetSynonymSoap[] soapModels = new OrphanetSynonymSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrphanetSynonymSoap[][] toSoapModels(
		OrphanetSynonym[][] models) {
		OrphanetSynonymSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrphanetSynonymSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrphanetSynonymSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrphanetSynonymSoap[] toSoapModels(
		List<OrphanetSynonym> models) {
		List<OrphanetSynonymSoap> soapModels = new ArrayList<OrphanetSynonymSoap>(models.size());

		for (OrphanetSynonym model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrphanetSynonymSoap[soapModels.size()]);
	}

	public OrphanetSynonymSoap() {
	}

	public long getPrimaryKey() {
		return _orphanetsynonymId;
	}

	public void setPrimaryKey(long pk) {
		setOrphanetsynonymId(pk);
	}

	public long getOrphanetsynonymId() {
		return _orphanetsynonymId;
	}

	public void setOrphanetsynonymId(long orphanetsynonymId) {
		_orphanetsynonymId = orphanetsynonymId;
	}

	public long getOrphanetdisorderId() {
		return _orphanetdisorderId;
	}

	public void setOrphanetdisorderId(long orphanetdisorderId) {
		_orphanetdisorderId = orphanetdisorderId;
	}

	public String getSynonym() {
		return _synonym;
	}

	public void setSynonym(String synonym) {
		_synonym = synonym;
	}

	private long _orphanetsynonymId;
	private long _orphanetdisorderId;
	private String _synonym;
}