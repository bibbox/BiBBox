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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class PuchMuseumsObjektSoap implements Serializable {
	public static PuchMuseumsObjektSoap toSoapModel(PuchMuseumsObjekt model) {
		PuchMuseumsObjektSoap soapModel = new PuchMuseumsObjektSoap();

		soapModel.setPuchmuseumsobjectId(model.getPuchmuseumsobjectId());
		soapModel.setCreaterUserId(model.getCreaterUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setObjekttyp(model.getObjekttyp());
		soapModel.setObjektid(model.getObjektid());
		soapModel.setFolder(model.getFolder());

		return soapModel;
	}

	public static PuchMuseumsObjektSoap[] toSoapModels(
		PuchMuseumsObjekt[] models) {
		PuchMuseumsObjektSoap[] soapModels = new PuchMuseumsObjektSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PuchMuseumsObjektSoap[][] toSoapModels(
		PuchMuseumsObjekt[][] models) {
		PuchMuseumsObjektSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PuchMuseumsObjektSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PuchMuseumsObjektSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PuchMuseumsObjektSoap[] toSoapModels(
		List<PuchMuseumsObjekt> models) {
		List<PuchMuseumsObjektSoap> soapModels = new ArrayList<PuchMuseumsObjektSoap>(models.size());

		for (PuchMuseumsObjekt model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PuchMuseumsObjektSoap[soapModels.size()]);
	}

	public PuchMuseumsObjektSoap() {
	}

	public long getPrimaryKey() {
		return _puchmuseumsobjectId;
	}

	public void setPrimaryKey(long pk) {
		setPuchmuseumsobjectId(pk);
	}

	public long getPuchmuseumsobjectId() {
		return _puchmuseumsobjectId;
	}

	public void setPuchmuseumsobjectId(long puchmuseumsobjectId) {
		_puchmuseumsobjectId = puchmuseumsobjectId;
	}

	public long getCreaterUserId() {
		return _createrUserId;
	}

	public void setCreaterUserId(long createrUserId) {
		_createrUserId = createrUserId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getModifiedUserId() {
		return _modifiedUserId;
	}

	public void setModifiedUserId(long modifiedUserId) {
		_modifiedUserId = modifiedUserId;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getObjekttyp() {
		return _objekttyp;
	}

	public void setObjekttyp(String objekttyp) {
		_objekttyp = objekttyp;
	}

	public long getObjektid() {
		return _objektid;
	}

	public void setObjektid(long objektid) {
		_objektid = objektid;
	}

	public String getFolder() {
		return _folder;
	}

	public void setFolder(String folder) {
		_folder = folder;
	}

	private long _puchmuseumsobjectId;
	private long _createrUserId;
	private Date _createDate;
	private long _modifiedUserId;
	private Date _modifiedDate;
	private String _objekttyp;
	private long _objektid;
	private String _folder;
}