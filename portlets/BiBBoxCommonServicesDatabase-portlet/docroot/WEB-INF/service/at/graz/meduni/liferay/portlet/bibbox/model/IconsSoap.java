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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.http.IconsServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.http.IconsServiceSoap
 * @generated
 */
public class IconsSoap implements Serializable {
	public static IconsSoap toSoapModel(Icons model) {
		IconsSoap soapModel = new IconsSoap();

		soapModel.setIconsId(model.getIconsId());
		soapModel.setIconurl(model.getIconurl());
		soapModel.setGroup(model.getGroup());

		return soapModel;
	}

	public static IconsSoap[] toSoapModels(Icons[] models) {
		IconsSoap[] soapModels = new IconsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IconsSoap[][] toSoapModels(Icons[][] models) {
		IconsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new IconsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new IconsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IconsSoap[] toSoapModels(List<Icons> models) {
		List<IconsSoap> soapModels = new ArrayList<IconsSoap>(models.size());

		for (Icons model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IconsSoap[soapModels.size()]);
	}

	public IconsSoap() {
	}

	public long getPrimaryKey() {
		return _iconsId;
	}

	public void setPrimaryKey(long pk) {
		setIconsId(pk);
	}

	public long getIconsId() {
		return _iconsId;
	}

	public void setIconsId(long iconsId) {
		_iconsId = iconsId;
	}

	public String getIconurl() {
		return _iconurl;
	}

	public void setIconurl(String iconurl) {
		_iconurl = iconurl;
	}

	public String getGroup() {
		return _group;
	}

	public void setGroup(String group) {
		_group = group;
	}

	private long _iconsId;
	private String _iconurl;
	private String _group;
}