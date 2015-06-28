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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.http.OrphanetDisorderServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.http.OrphanetDisorderServiceSoap
 * @generated
 */
public class OrphanetDisorderSoap implements Serializable {
	public static OrphanetDisorderSoap toSoapModel(OrphanetDisorder model) {
		OrphanetDisorderSoap soapModel = new OrphanetDisorderSoap();

		soapModel.setOrphanetdisorderId(model.getOrphanetdisorderId());
		soapModel.setOrphanumber(model.getOrphanumber());
		soapModel.setOrpahnetlink(model.getOrpahnetlink());
		soapModel.setDiseasename(model.getDiseasename());

		return soapModel;
	}

	public static OrphanetDisorderSoap[] toSoapModels(OrphanetDisorder[] models) {
		OrphanetDisorderSoap[] soapModels = new OrphanetDisorderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrphanetDisorderSoap[][] toSoapModels(
		OrphanetDisorder[][] models) {
		OrphanetDisorderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrphanetDisorderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrphanetDisorderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrphanetDisorderSoap[] toSoapModels(
		List<OrphanetDisorder> models) {
		List<OrphanetDisorderSoap> soapModels = new ArrayList<OrphanetDisorderSoap>(models.size());

		for (OrphanetDisorder model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrphanetDisorderSoap[soapModels.size()]);
	}

	public OrphanetDisorderSoap() {
	}

	public long getPrimaryKey() {
		return _orphanetdisorderId;
	}

	public void setPrimaryKey(long pk) {
		setOrphanetdisorderId(pk);
	}

	public long getOrphanetdisorderId() {
		return _orphanetdisorderId;
	}

	public void setOrphanetdisorderId(long orphanetdisorderId) {
		_orphanetdisorderId = orphanetdisorderId;
	}

	public long getOrphanumber() {
		return _orphanumber;
	}

	public void setOrphanumber(long orphanumber) {
		_orphanumber = orphanumber;
	}

	public String getOrpahnetlink() {
		return _orpahnetlink;
	}

	public void setOrpahnetlink(String orpahnetlink) {
		_orpahnetlink = orpahnetlink;
	}

	public String getDiseasename() {
		return _diseasename;
	}

	public void setDiseasename(String diseasename) {
		_diseasename = diseasename;
	}

	private long _orphanetdisorderId;
	private long _orphanumber;
	private String _orpahnetlink;
	private String _diseasename;
}