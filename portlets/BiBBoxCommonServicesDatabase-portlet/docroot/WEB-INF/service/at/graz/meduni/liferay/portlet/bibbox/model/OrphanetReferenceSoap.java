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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.http.OrphanetReferenceServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.http.OrphanetReferenceServiceSoap
 * @generated
 */
public class OrphanetReferenceSoap implements Serializable {
	public static OrphanetReferenceSoap toSoapModel(OrphanetReference model) {
		OrphanetReferenceSoap soapModel = new OrphanetReferenceSoap();

		soapModel.setOrphanetreferenceId(model.getOrphanetreferenceId());
		soapModel.setOrphanetdisorderId(model.getOrphanetdisorderId());
		soapModel.setSource(model.getSource());
		soapModel.setReference(model.getReference());
		soapModel.setDisordermappingrelation(model.getDisordermappingrelation());
		soapModel.setDisordermappingrelationorphanumber(model.getDisordermappingrelationorphanumber());
		soapModel.setDisordermappingrelationname(model.getDisordermappingrelationname());
		soapModel.setDisordermappingicdrelation(model.getDisordermappingicdrelation());
		soapModel.setDisordermappingicdrelationorphanumber(model.getDisordermappingicdrelationorphanumber());
		soapModel.setDisordermappingicdrelationname(model.getDisordermappingicdrelationname());
		soapModel.setDisordermappingvalidationstatus(model.getDisordermappingvalidationstatus());
		soapModel.setDisordermappingvalidationstatusorphanumber(model.getDisordermappingvalidationstatusorphanumber());
		soapModel.setDisordermappingvalidationstatusname(model.getDisordermappingvalidationstatusname());

		return soapModel;
	}

	public static OrphanetReferenceSoap[] toSoapModels(
		OrphanetReference[] models) {
		OrphanetReferenceSoap[] soapModels = new OrphanetReferenceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrphanetReferenceSoap[][] toSoapModels(
		OrphanetReference[][] models) {
		OrphanetReferenceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrphanetReferenceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrphanetReferenceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrphanetReferenceSoap[] toSoapModels(
		List<OrphanetReference> models) {
		List<OrphanetReferenceSoap> soapModels = new ArrayList<OrphanetReferenceSoap>(models.size());

		for (OrphanetReference model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrphanetReferenceSoap[soapModels.size()]);
	}

	public OrphanetReferenceSoap() {
	}

	public long getPrimaryKey() {
		return _orphanetreferenceId;
	}

	public void setPrimaryKey(long pk) {
		setOrphanetreferenceId(pk);
	}

	public long getOrphanetreferenceId() {
		return _orphanetreferenceId;
	}

	public void setOrphanetreferenceId(long orphanetreferenceId) {
		_orphanetreferenceId = orphanetreferenceId;
	}

	public long getOrphanetdisorderId() {
		return _orphanetdisorderId;
	}

	public void setOrphanetdisorderId(long orphanetdisorderId) {
		_orphanetdisorderId = orphanetdisorderId;
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

	public long getDisordermappingrelation() {
		return _disordermappingrelation;
	}

	public void setDisordermappingrelation(long disordermappingrelation) {
		_disordermappingrelation = disordermappingrelation;
	}

	public long getDisordermappingrelationorphanumber() {
		return _disordermappingrelationorphanumber;
	}

	public void setDisordermappingrelationorphanumber(
		long disordermappingrelationorphanumber) {
		_disordermappingrelationorphanumber = disordermappingrelationorphanumber;
	}

	public String getDisordermappingrelationname() {
		return _disordermappingrelationname;
	}

	public void setDisordermappingrelationname(
		String disordermappingrelationname) {
		_disordermappingrelationname = disordermappingrelationname;
	}

	public long getDisordermappingicdrelation() {
		return _disordermappingicdrelation;
	}

	public void setDisordermappingicdrelation(long disordermappingicdrelation) {
		_disordermappingicdrelation = disordermappingicdrelation;
	}

	public long getDisordermappingicdrelationorphanumber() {
		return _disordermappingicdrelationorphanumber;
	}

	public void setDisordermappingicdrelationorphanumber(
		long disordermappingicdrelationorphanumber) {
		_disordermappingicdrelationorphanumber = disordermappingicdrelationorphanumber;
	}

	public String getDisordermappingicdrelationname() {
		return _disordermappingicdrelationname;
	}

	public void setDisordermappingicdrelationname(
		String disordermappingicdrelationname) {
		_disordermappingicdrelationname = disordermappingicdrelationname;
	}

	public long getDisordermappingvalidationstatus() {
		return _disordermappingvalidationstatus;
	}

	public void setDisordermappingvalidationstatus(
		long disordermappingvalidationstatus) {
		_disordermappingvalidationstatus = disordermappingvalidationstatus;
	}

	public long getDisordermappingvalidationstatusorphanumber() {
		return _disordermappingvalidationstatusorphanumber;
	}

	public void setDisordermappingvalidationstatusorphanumber(
		long disordermappingvalidationstatusorphanumber) {
		_disordermappingvalidationstatusorphanumber = disordermappingvalidationstatusorphanumber;
	}

	public String getDisordermappingvalidationstatusname() {
		return _disordermappingvalidationstatusname;
	}

	public void setDisordermappingvalidationstatusname(
		String disordermappingvalidationstatusname) {
		_disordermappingvalidationstatusname = disordermappingvalidationstatusname;
	}

	private long _orphanetreferenceId;
	private long _orphanetdisorderId;
	private String _source;
	private String _reference;
	private long _disordermappingrelation;
	private long _disordermappingrelationorphanumber;
	private String _disordermappingrelationname;
	private long _disordermappingicdrelation;
	private long _disordermappingicdrelationorphanumber;
	private String _disordermappingicdrelationname;
	private long _disordermappingvalidationstatus;
	private long _disordermappingvalidationstatusorphanumber;
	private String _disordermappingvalidationstatusname;
}