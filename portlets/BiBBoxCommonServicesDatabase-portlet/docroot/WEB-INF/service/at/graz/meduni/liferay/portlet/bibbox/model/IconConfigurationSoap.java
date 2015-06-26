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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.http.IconConfigurationServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.http.IconConfigurationServiceSoap
 * @generated
 */
public class IconConfigurationSoap implements Serializable {
	public static IconConfigurationSoap toSoapModel(IconConfiguration model) {
		IconConfigurationSoap soapModel = new IconConfigurationSoap();

		soapModel.setIconconfigurationId(model.getIconconfigurationId());
		soapModel.setSymbolconfigurationId(model.getSymbolconfigurationId());
		soapModel.setPosition(model.getPosition());
		soapModel.setKey(model.getKey());
		soapModel.setIconsId(model.getIconsId());
		soapModel.setElementcolor(model.getElementcolor());
		soapModel.setWidth(model.getWidth());
		soapModel.setHeight(model.getHeight());

		return soapModel;
	}

	public static IconConfigurationSoap[] toSoapModels(
		IconConfiguration[] models) {
		IconConfigurationSoap[] soapModels = new IconConfigurationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IconConfigurationSoap[][] toSoapModels(
		IconConfiguration[][] models) {
		IconConfigurationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new IconConfigurationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new IconConfigurationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IconConfigurationSoap[] toSoapModels(
		List<IconConfiguration> models) {
		List<IconConfigurationSoap> soapModels = new ArrayList<IconConfigurationSoap>(models.size());

		for (IconConfiguration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IconConfigurationSoap[soapModels.size()]);
	}

	public IconConfigurationSoap() {
	}

	public long getPrimaryKey() {
		return _iconconfigurationId;
	}

	public void setPrimaryKey(long pk) {
		setIconconfigurationId(pk);
	}

	public long getIconconfigurationId() {
		return _iconconfigurationId;
	}

	public void setIconconfigurationId(long iconconfigurationId) {
		_iconconfigurationId = iconconfigurationId;
	}

	public long getSymbolconfigurationId() {
		return _symbolconfigurationId;
	}

	public void setSymbolconfigurationId(long symbolconfigurationId) {
		_symbolconfigurationId = symbolconfigurationId;
	}

	public String getPosition() {
		return _position;
	}

	public void setPosition(String position) {
		_position = position;
	}

	public String getKey() {
		return _key;
	}

	public void setKey(String key) {
		_key = key;
	}

	public long getIconsId() {
		return _iconsId;
	}

	public void setIconsId(long iconsId) {
		_iconsId = iconsId;
	}

	public String getElementcolor() {
		return _elementcolor;
	}

	public void setElementcolor(String elementcolor) {
		_elementcolor = elementcolor;
	}

	public String getWidth() {
		return _width;
	}

	public void setWidth(String width) {
		_width = width;
	}

	public String getHeight() {
		return _height;
	}

	public void setHeight(String height) {
		_height = height;
	}

	private long _iconconfigurationId;
	private long _symbolconfigurationId;
	private String _position;
	private String _key;
	private long _iconsId;
	private String _elementcolor;
	private String _width;
	private String _height;
}