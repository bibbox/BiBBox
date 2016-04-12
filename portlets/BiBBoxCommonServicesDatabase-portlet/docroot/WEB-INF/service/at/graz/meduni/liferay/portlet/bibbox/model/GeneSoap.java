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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.http.GeneServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.http.GeneServiceSoap
 * @generated
 */
public class GeneSoap implements Serializable {
	public static GeneSoap toSoapModel(Gene model) {
		GeneSoap soapModel = new GeneSoap();

		soapModel.setGeneId(model.getGeneId());
		soapModel.setOrphanetdisorderId(model.getOrphanetdisorderId());
		soapModel.setSymbol(model.getSymbol());
		soapModel.setDescription(model.getDescription());
		soapModel.setGeneorphanumber(model.getGeneorphanumber());
		soapModel.setGenetype(model.getGenetype());
		soapModel.setGenetypeorphanumber(model.getGenetypeorphanumber());
		soapModel.setGenetypename(model.getGenetypename());
		soapModel.setDisordergeneassociationtype(model.getDisordergeneassociationtype());
		soapModel.setDisordergeneassociationtypename(model.getDisordergeneassociationtypename());
		soapModel.setDisordergeneassociationstatus(model.getDisordergeneassociationstatus());
		soapModel.setDisordergeneassociationstatusname(model.getDisordergeneassociationstatusname());

		return soapModel;
	}

	public static GeneSoap[] toSoapModels(Gene[] models) {
		GeneSoap[] soapModels = new GeneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GeneSoap[][] toSoapModels(Gene[][] models) {
		GeneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GeneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GeneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GeneSoap[] toSoapModels(List<Gene> models) {
		List<GeneSoap> soapModels = new ArrayList<GeneSoap>(models.size());

		for (Gene model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GeneSoap[soapModels.size()]);
	}

	public GeneSoap() {
	}

	public long getPrimaryKey() {
		return _geneId;
	}

	public void setPrimaryKey(long pk) {
		setGeneId(pk);
	}

	public long getGeneId() {
		return _geneId;
	}

	public void setGeneId(long geneId) {
		_geneId = geneId;
	}

	public long getOrphanetdisorderId() {
		return _orphanetdisorderId;
	}

	public void setOrphanetdisorderId(long orphanetdisorderId) {
		_orphanetdisorderId = orphanetdisorderId;
	}

	public String getSymbol() {
		return _symbol;
	}

	public void setSymbol(String symbol) {
		_symbol = symbol;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getGeneorphanumber() {
		return _geneorphanumber;
	}

	public void setGeneorphanumber(long geneorphanumber) {
		_geneorphanumber = geneorphanumber;
	}

	public long getGenetype() {
		return _genetype;
	}

	public void setGenetype(long genetype) {
		_genetype = genetype;
	}

	public long getGenetypeorphanumber() {
		return _genetypeorphanumber;
	}

	public void setGenetypeorphanumber(long genetypeorphanumber) {
		_genetypeorphanumber = genetypeorphanumber;
	}

	public String getGenetypename() {
		return _genetypename;
	}

	public void setGenetypename(String genetypename) {
		_genetypename = genetypename;
	}

	public long getDisordergeneassociationtype() {
		return _disordergeneassociationtype;
	}

	public void setDisordergeneassociationtype(long disordergeneassociationtype) {
		_disordergeneassociationtype = disordergeneassociationtype;
	}

	public String getDisordergeneassociationtypename() {
		return _disordergeneassociationtypename;
	}

	public void setDisordergeneassociationtypename(
		String disordergeneassociationtypename) {
		_disordergeneassociationtypename = disordergeneassociationtypename;
	}

	public long getDisordergeneassociationstatus() {
		return _disordergeneassociationstatus;
	}

	public void setDisordergeneassociationstatus(
		long disordergeneassociationstatus) {
		_disordergeneassociationstatus = disordergeneassociationstatus;
	}

	public String getDisordergeneassociationstatusname() {
		return _disordergeneassociationstatusname;
	}

	public void setDisordergeneassociationstatusname(
		String disordergeneassociationstatusname) {
		_disordergeneassociationstatusname = disordergeneassociationstatusname;
	}

	private long _geneId;
	private long _orphanetdisorderId;
	private String _symbol;
	private String _description;
	private long _geneorphanumber;
	private long _genetype;
	private long _genetypeorphanumber;
	private String _genetypename;
	private long _disordergeneassociationtype;
	private String _disordergeneassociationtypename;
	private long _disordergeneassociationstatus;
	private String _disordergeneassociationstatusname;
}