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

package at.bibbox.reactjsservice.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.bibbox.reactjsservice.service.http.ToolInformationServiceSoap}.
 *
 * @author reihsr
 * @see at.bibbox.reactjsservice.service.http.ToolInformationServiceSoap
 * @generated
 */
public class ToolInformationSoap implements Serializable {
	public static ToolInformationSoap toSoapModel(ToolInformation model) {
		ToolInformationSoap soapModel = new ToolInformationSoap();

		soapModel.setToolInformationId(model.getToolInformationId());
		soapModel.setGitUUID(model.getGitUUID());
		soapModel.setLogourl(model.getLogourl());
		soapModel.setName(model.getName());
		soapModel.setCategory(model.getCategory());
		soapModel.setCompany(model.getCompany());
		soapModel.setDemourl(model.getDemourl());
		soapModel.setDownloadurl(model.getDownloadurl());
		soapModel.setToolId(model.getToolId());
		soapModel.setPlatform(model.getPlatform());
		soapModel.setLicense(model.getLicense());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ToolInformationSoap[] toSoapModels(ToolInformation[] models) {
		ToolInformationSoap[] soapModels = new ToolInformationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ToolInformationSoap[][] toSoapModels(
		ToolInformation[][] models) {
		ToolInformationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ToolInformationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ToolInformationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ToolInformationSoap[] toSoapModels(
		List<ToolInformation> models) {
		List<ToolInformationSoap> soapModels = new ArrayList<ToolInformationSoap>(models.size());

		for (ToolInformation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ToolInformationSoap[soapModels.size()]);
	}

	public ToolInformationSoap() {
	}

	public long getPrimaryKey() {
		return _toolInformationId;
	}

	public void setPrimaryKey(long pk) {
		setToolInformationId(pk);
	}

	public long getToolInformationId() {
		return _toolInformationId;
	}

	public void setToolInformationId(long toolInformationId) {
		_toolInformationId = toolInformationId;
	}

	public String getGitUUID() {
		return _gitUUID;
	}

	public void setGitUUID(String gitUUID) {
		_gitUUID = gitUUID;
	}

	public String getLogourl() {
		return _logourl;
	}

	public void setLogourl(String logourl) {
		_logourl = logourl;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getCompany() {
		return _company;
	}

	public void setCompany(String company) {
		_company = company;
	}

	public String getDemourl() {
		return _demourl;
	}

	public void setDemourl(String demourl) {
		_demourl = demourl;
	}

	public String getDownloadurl() {
		return _downloadurl;
	}

	public void setDownloadurl(String downloadurl) {
		_downloadurl = downloadurl;
	}

	public String getToolId() {
		return _toolId;
	}

	public void setToolId(String toolId) {
		_toolId = toolId;
	}

	public String getPlatform() {
		return _platform;
	}

	public void setPlatform(String platform) {
		_platform = platform;
	}

	public String getLicense() {
		return _license;
	}

	public void setLicense(String license) {
		_license = license;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _toolInformationId;
	private String _gitUUID;
	private String _logourl;
	private String _name;
	private String _category;
	private String _company;
	private String _demourl;
	private String _downloadurl;
	private String _toolId;
	private String _platform;
	private String _license;
	private String _description;
}