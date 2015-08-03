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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class ParameterConfigurationSoap implements Serializable {
	public static ParameterConfigurationSoap toSoapModel(
		ParameterConfiguration model) {
		ParameterConfigurationSoap soapModel = new ParameterConfigurationSoap();

		soapModel.setParameterconfigurationId(model.getParameterconfigurationId());
		soapModel.setDisplaynameshort(model.getDisplaynameshort());
		soapModel.setDisplaynamelong(model.getDisplaynamelong());
		soapModel.setDatatype(model.getDatatype());
		soapModel.setGroup(model.getGroup());
		soapModel.setTab(model.getTab());
		soapModel.setViewscript(model.getViewscript());
		soapModel.setViewvisible(model.getViewvisible());
		soapModel.setViewtip(model.getViewtip());
		soapModel.setViewtitlecss(model.getViewtitlecss());
		soapModel.setViewvaluecss(model.getViewvaluecss());
		soapModel.setViewcss(model.getViewcss());
		soapModel.setEditscript(model.getEditscript());
		soapModel.setEditvisible(model.getEditvisible());
		soapModel.setEdittip(model.getEdittip());
		soapModel.setEdittitlecss(model.getEdittitlecss());
		soapModel.setEditvaluecss(model.getEditvaluecss());
		soapModel.setEditcss(model.getEditcss());
		soapModel.setEditcolumnwidth(model.getEditcolumnwidth());

		return soapModel;
	}

	public static ParameterConfigurationSoap[] toSoapModels(
		ParameterConfiguration[] models) {
		ParameterConfigurationSoap[] soapModels = new ParameterConfigurationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ParameterConfigurationSoap[][] toSoapModels(
		ParameterConfiguration[][] models) {
		ParameterConfigurationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ParameterConfigurationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ParameterConfigurationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ParameterConfigurationSoap[] toSoapModels(
		List<ParameterConfiguration> models) {
		List<ParameterConfigurationSoap> soapModels = new ArrayList<ParameterConfigurationSoap>(models.size());

		for (ParameterConfiguration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ParameterConfigurationSoap[soapModels.size()]);
	}

	public ParameterConfigurationSoap() {
	}

	public long getPrimaryKey() {
		return _parameterconfigurationId;
	}

	public void setPrimaryKey(long pk) {
		setParameterconfigurationId(pk);
	}

	public long getParameterconfigurationId() {
		return _parameterconfigurationId;
	}

	public void setParameterconfigurationId(long parameterconfigurationId) {
		_parameterconfigurationId = parameterconfigurationId;
	}

	public String getDisplaynameshort() {
		return _displaynameshort;
	}

	public void setDisplaynameshort(String displaynameshort) {
		_displaynameshort = displaynameshort;
	}

	public String getDisplaynamelong() {
		return _displaynamelong;
	}

	public void setDisplaynamelong(String displaynamelong) {
		_displaynamelong = displaynamelong;
	}

	public String getDatatype() {
		return _datatype;
	}

	public void setDatatype(String datatype) {
		_datatype = datatype;
	}

	public String getGroup() {
		return _group;
	}

	public void setGroup(String group) {
		_group = group;
	}

	public String getTab() {
		return _tab;
	}

	public void setTab(String tab) {
		_tab = tab;
	}

	public String getViewscript() {
		return _viewscript;
	}

	public void setViewscript(String viewscript) {
		_viewscript = viewscript;
	}

	public boolean getViewvisible() {
		return _viewvisible;
	}

	public boolean isViewvisible() {
		return _viewvisible;
	}

	public void setViewvisible(boolean viewvisible) {
		_viewvisible = viewvisible;
	}

	public String getViewtip() {
		return _viewtip;
	}

	public void setViewtip(String viewtip) {
		_viewtip = viewtip;
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

	public String getViewcss() {
		return _viewcss;
	}

	public void setViewcss(String viewcss) {
		_viewcss = viewcss;
	}

	public String getEditscript() {
		return _editscript;
	}

	public void setEditscript(String editscript) {
		_editscript = editscript;
	}

	public boolean getEditvisible() {
		return _editvisible;
	}

	public boolean isEditvisible() {
		return _editvisible;
	}

	public void setEditvisible(boolean editvisible) {
		_editvisible = editvisible;
	}

	public String getEdittip() {
		return _edittip;
	}

	public void setEdittip(String edittip) {
		_edittip = edittip;
	}

	public String getEdittitlecss() {
		return _edittitlecss;
	}

	public void setEdittitlecss(String edittitlecss) {
		_edittitlecss = edittitlecss;
	}

	public String getEditvaluecss() {
		return _editvaluecss;
	}

	public void setEditvaluecss(String editvaluecss) {
		_editvaluecss = editvaluecss;
	}

	public String getEditcss() {
		return _editcss;
	}

	public void setEditcss(String editcss) {
		_editcss = editcss;
	}

	public long getEditcolumnwidth() {
		return _editcolumnwidth;
	}

	public void setEditcolumnwidth(long editcolumnwidth) {
		_editcolumnwidth = editcolumnwidth;
	}

	private long _parameterconfigurationId;
	private String _displaynameshort;
	private String _displaynamelong;
	private String _datatype;
	private String _group;
	private String _tab;
	private String _viewscript;
	private boolean _viewvisible;
	private String _viewtip;
	private String _viewtitlecss;
	private String _viewvaluecss;
	private String _viewcss;
	private String _editscript;
	private boolean _editvisible;
	private String _edittip;
	private String _edittitlecss;
	private String _editvaluecss;
	private String _editcss;
	private long _editcolumnwidth;
}