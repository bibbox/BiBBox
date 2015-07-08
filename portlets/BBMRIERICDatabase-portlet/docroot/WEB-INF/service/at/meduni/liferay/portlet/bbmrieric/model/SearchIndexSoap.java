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

package at.meduni.liferay.portlet.bbmrieric.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author reihsr
 * @generated
 */
public class SearchIndexSoap implements Serializable {
	public static SearchIndexSoap toSoapModel(SearchIndex model) {
		SearchIndexSoap soapModel = new SearchIndexSoap();

		soapModel.setSearchid(model.getSearchid());
		soapModel.setOrganisationid(model.getOrganisationid());
		soapModel.setLocationid(model.getLocationid());
		soapModel.setLocation(model.getLocation());
		soapModel.setSearchindexkey(model.getSearchindexkey());
		soapModel.setSearchindexvalue(model.getSearchindexvalue());
		soapModel.setUUID(model.getUUID());

		return soapModel;
	}

	public static SearchIndexSoap[] toSoapModels(SearchIndex[] models) {
		SearchIndexSoap[] soapModels = new SearchIndexSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SearchIndexSoap[][] toSoapModels(SearchIndex[][] models) {
		SearchIndexSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SearchIndexSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SearchIndexSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SearchIndexSoap[] toSoapModels(List<SearchIndex> models) {
		List<SearchIndexSoap> soapModels = new ArrayList<SearchIndexSoap>(models.size());

		for (SearchIndex model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SearchIndexSoap[soapModels.size()]);
	}

	public SearchIndexSoap() {
	}

	public long getPrimaryKey() {
		return _searchid;
	}

	public void setPrimaryKey(long pk) {
		setSearchid(pk);
	}

	public long getSearchid() {
		return _searchid;
	}

	public void setSearchid(long searchid) {
		_searchid = searchid;
	}

	public long getOrganisationid() {
		return _organisationid;
	}

	public void setOrganisationid(long organisationid) {
		_organisationid = organisationid;
	}

	public long getLocationid() {
		return _locationid;
	}

	public void setLocationid(long locationid) {
		_locationid = locationid;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public String getSearchindexkey() {
		return _searchindexkey;
	}

	public void setSearchindexkey(String searchindexkey) {
		_searchindexkey = searchindexkey;
	}

	public String getSearchindexvalue() {
		return _searchindexvalue;
	}

	public void setSearchindexvalue(String searchindexvalue) {
		_searchindexvalue = searchindexvalue;
	}

	public String getUUID() {
		return _UUID;
	}

	public void setUUID(String UUID) {
		_UUID = UUID;
	}

	private long _searchid;
	private long _organisationid;
	private long _locationid;
	private String _location;
	private String _searchindexkey;
	private String _searchindexvalue;
	private String _UUID;
}