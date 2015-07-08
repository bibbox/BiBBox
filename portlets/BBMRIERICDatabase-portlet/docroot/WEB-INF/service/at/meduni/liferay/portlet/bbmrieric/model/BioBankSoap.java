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
public class BioBankSoap implements Serializable {
	public static BioBankSoap toSoapModel(BioBank model) {
		BioBankSoap soapModel = new BioBankSoap();

		soapModel.setBiobankId(model.getBiobankId());
		soapModel.setOrganisationid(model.getOrganisationid());
		soapModel.setLdapbiobankID(model.getLdapbiobankID());
		soapModel.setBiobankcountry(model.getBiobankcountry());
		soapModel.setBiobankname(model.getBiobankname());
		soapModel.setBiobanktype(model.getBiobanktype());
		soapModel.setBiobanksize(model.getBiobanksize());
		soapModel.setBiobankdescription(model.getBiobankdescription());
		soapModel.setBiobankjuristicperson(model.getBiobankjuristicperson());
		soapModel.setUUID(model.getUUID());

		return soapModel;
	}

	public static BioBankSoap[] toSoapModels(BioBank[] models) {
		BioBankSoap[] soapModels = new BioBankSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BioBankSoap[][] toSoapModels(BioBank[][] models) {
		BioBankSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BioBankSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BioBankSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BioBankSoap[] toSoapModels(List<BioBank> models) {
		List<BioBankSoap> soapModels = new ArrayList<BioBankSoap>(models.size());

		for (BioBank model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BioBankSoap[soapModels.size()]);
	}

	public BioBankSoap() {
	}

	public long getPrimaryKey() {
		return _biobankId;
	}

	public void setPrimaryKey(long pk) {
		setBiobankId(pk);
	}

	public long getBiobankId() {
		return _biobankId;
	}

	public void setBiobankId(long biobankId) {
		_biobankId = biobankId;
	}

	public long getOrganisationid() {
		return _organisationid;
	}

	public void setOrganisationid(long organisationid) {
		_organisationid = organisationid;
	}

	public String getLdapbiobankID() {
		return _ldapbiobankID;
	}

	public void setLdapbiobankID(String ldapbiobankID) {
		_ldapbiobankID = ldapbiobankID;
	}

	public String getBiobankcountry() {
		return _biobankcountry;
	}

	public void setBiobankcountry(String biobankcountry) {
		_biobankcountry = biobankcountry;
	}

	public String getBiobankname() {
		return _biobankname;
	}

	public void setBiobankname(String biobankname) {
		_biobankname = biobankname;
	}

	public String getBiobanktype() {
		return _biobanktype;
	}

	public void setBiobanktype(String biobanktype) {
		_biobanktype = biobanktype;
	}

	public String getBiobanksize() {
		return _biobanksize;
	}

	public void setBiobanksize(String biobanksize) {
		_biobanksize = biobanksize;
	}

	public String getBiobankdescription() {
		return _biobankdescription;
	}

	public void setBiobankdescription(String biobankdescription) {
		_biobankdescription = biobankdescription;
	}

	public String getBiobankjuristicperson() {
		return _biobankjuristicperson;
	}

	public void setBiobankjuristicperson(String biobankjuristicperson) {
		_biobankjuristicperson = biobankjuristicperson;
	}

	public String getUUID() {
		return _UUID;
	}

	public void setUUID(String UUID) {
		_UUID = UUID;
	}

	private long _biobankId;
	private long _organisationid;
	private String _ldapbiobankID;
	private String _biobankcountry;
	private String _biobankname;
	private String _biobanktype;
	private String _biobanksize;
	private String _biobankdescription;
	private String _biobankjuristicperson;
	private String _UUID;
}