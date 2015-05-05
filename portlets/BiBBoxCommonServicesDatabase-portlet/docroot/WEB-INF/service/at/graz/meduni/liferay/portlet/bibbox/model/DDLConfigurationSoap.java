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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.http.DDLConfigurationServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.http.DDLConfigurationServiceSoap
 * @generated
 */
public class DDLConfigurationSoap implements Serializable {
	public static DDLConfigurationSoap toSoapModel(DDLConfiguration model) {
		DDLConfigurationSoap soapModel = new DDLConfigurationSoap();

		soapModel.setDdlconfigurationId(model.getDdlconfigurationId());
		soapModel.setDdmstructureId(model.getDdmstructureId());
		soapModel.setFieldname(model.getFieldname());
		soapModel.setGroup(model.getGroup());
		soapModel.setDisplay(model.getDisplay());
		soapModel.setViewscript(model.getViewscript());
		soapModel.setDisplaytip(model.getDisplaytip());
		soapModel.setViewtitlecss(model.getViewtitlecss());
		soapModel.setViewvaluecss(model.getViewvaluecss());
		soapModel.setColumwidth(model.getColumwidth());
		soapModel.setEditscript(model.getEditscript());
		soapModel.setEdittip(model.getEdittip());

		return soapModel;
	}

	public static DDLConfigurationSoap[] toSoapModels(DDLConfiguration[] models) {
		DDLConfigurationSoap[] soapModels = new DDLConfigurationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DDLConfigurationSoap[][] toSoapModels(
		DDLConfiguration[][] models) {
		DDLConfigurationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DDLConfigurationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DDLConfigurationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DDLConfigurationSoap[] toSoapModels(
		List<DDLConfiguration> models) {
		List<DDLConfigurationSoap> soapModels = new ArrayList<DDLConfigurationSoap>(models.size());

		for (DDLConfiguration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DDLConfigurationSoap[soapModels.size()]);
	}

	public DDLConfigurationSoap() {
	}

	public long getPrimaryKey() {
		return _ddlconfigurationId;
	}

	public void setPrimaryKey(long pk) {
		setDdlconfigurationId(pk);
	}

	public long getDdlconfigurationId() {
		return _ddlconfigurationId;
	}

	public void setDdlconfigurationId(long ddlconfigurationId) {
		_ddlconfigurationId = ddlconfigurationId;
	}

	public long getDdmstructureId() {
		return _ddmstructureId;
	}

	public void setDdmstructureId(long ddmstructureId) {
		_ddmstructureId = ddmstructureId;
	}

	public String getFieldname() {
		return _fieldname;
	}

	public void setFieldname(String fieldname) {
		_fieldname = fieldname;
	}

	public String getGroup() {
		return _group;
	}

	public void setGroup(String group) {
		_group = group;
	}

	public boolean getDisplay() {
		return _display;
	}

	public boolean isDisplay() {
		return _display;
	}

	public void setDisplay(boolean display) {
		_display = display;
	}

	public String getViewscript() {
		return _viewscript;
	}

	public void setViewscript(String viewscript) {
		_viewscript = viewscript;
	}

	public String getDisplaytip() {
		return _displaytip;
	}

	public void setDisplaytip(String displaytip) {
		_displaytip = displaytip;
	}

	public String getViewtitlecss() {
		return _viewtitlecss;
	}

	public void setViewtitlecss(String viewtitlecss) {
		_viewtitlecss = viewtitlecss;
	}

	public String getViewvaluecss() {
		return _viewvaluecss;
	}

	public void setViewvaluecss(String viewvaluecss) {
		_viewvaluecss = viewvaluecss;
	}

	public long getColumwidth() {
		return _columwidth;
	}

	public void setColumwidth(long columwidth) {
		_columwidth = columwidth;
	}

	public String getEditscript() {
		return _editscript;
	}

	public void setEditscript(String editscript) {
		_editscript = editscript;
	}

	public String getEdittip() {
		return _edittip;
	}

	public void setEdittip(String edittip) {
		_edittip = edittip;
	}

	private long _ddlconfigurationId;
	private long _ddmstructureId;
	private String _fieldname;
	private String _group;
	private boolean _display;
	private String _viewscript;
	private String _displaytip;
	private String _viewtitlecss;
	private String _viewvaluecss;
	private long _columwidth;
	private String _editscript;
	private String _edittip;
}