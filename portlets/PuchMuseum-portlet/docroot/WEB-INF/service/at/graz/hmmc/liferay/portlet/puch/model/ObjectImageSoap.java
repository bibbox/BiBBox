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
public class ObjectImageSoap implements Serializable {
	public static ObjectImageSoap toSoapModel(ObjectImage model) {
		ObjectImageSoap soapModel = new ObjectImageSoap();

		soapModel.setObjectimageId(model.getObjectimageId());
		soapModel.setPuchmuseumsobjectId(model.getPuchmuseumsobjectId());
		soapModel.setCreaterUserId(model.getCreaterUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedUserId(model.getModifiedUserId());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDlappimagerawId(model.getDlappimagerawId());
		soapModel.setDlappimageprocessedId(model.getDlappimageprocessedId());
		soapModel.setDlappimagewebId(model.getDlappimagewebId());

		return soapModel;
	}

	public static ObjectImageSoap[] toSoapModels(ObjectImage[] models) {
		ObjectImageSoap[] soapModels = new ObjectImageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ObjectImageSoap[][] toSoapModels(ObjectImage[][] models) {
		ObjectImageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ObjectImageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ObjectImageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ObjectImageSoap[] toSoapModels(List<ObjectImage> models) {
		List<ObjectImageSoap> soapModels = new ArrayList<ObjectImageSoap>(models.size());

		for (ObjectImage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ObjectImageSoap[soapModels.size()]);
	}

	public ObjectImageSoap() {
	}

	public long getPrimaryKey() {
		return _objectimageId;
	}

	public void setPrimaryKey(long pk) {
		setObjectimageId(pk);
	}

	public long getObjectimageId() {
		return _objectimageId;
	}

	public void setObjectimageId(long objectimageId) {
		_objectimageId = objectimageId;
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

	public long getDlappimagerawId() {
		return _dlappimagerawId;
	}

	public void setDlappimagerawId(long dlappimagerawId) {
		_dlappimagerawId = dlappimagerawId;
	}

	public long getDlappimageprocessedId() {
		return _dlappimageprocessedId;
	}

	public void setDlappimageprocessedId(long dlappimageprocessedId) {
		_dlappimageprocessedId = dlappimageprocessedId;
	}

	public long getDlappimagewebId() {
		return _dlappimagewebId;
	}

	public void setDlappimagewebId(long dlappimagewebId) {
		_dlappimagewebId = dlappimagewebId;
	}

	private long _objectimageId;
	private long _puchmuseumsobjectId;
	private long _createrUserId;
	private Date _createDate;
	private long _modifiedUserId;
	private Date _modifiedDate;
	private long _dlappimagerawId;
	private long _dlappimageprocessedId;
	private long _dlappimagewebId;
}