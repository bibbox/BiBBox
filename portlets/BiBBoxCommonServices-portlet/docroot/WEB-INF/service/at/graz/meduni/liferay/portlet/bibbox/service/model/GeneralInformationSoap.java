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

package at.graz.meduni.liferay.portlet.bibbox.service.model;

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
public class GeneralInformationSoap implements Serializable {
	public static GeneralInformationSoap toSoapModel(GeneralInformation model) {
		GeneralInformationSoap soapModel = new GeneralInformationSoap();

		soapModel.setGeneralinformationId(model.getGeneralinformationId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setAcronym(model.getAcronym());
		soapModel.setDescription(model.getDescription());
		soapModel.setHosteinstitue(model.getHosteinstitue());
		soapModel.setTypeofhosteinstitue(model.getTypeofhosteinstitue());
		soapModel.setSourceoffunding(model.getSourceoffunding());
		soapModel.setCountry(model.getCountry());
		soapModel.setTargetpopulation(model.getTargetpopulation());
		soapModel.setYearofestablishment(model.getYearofestablishment());
		soapModel.setHowmanyrdsareintheregistrybiobank(model.getHowmanyrdsareintheregistrybiobank());
		soapModel.setPercentageofrarediseasesinyourregistrybiobank(model.getPercentageofrarediseasesinyourregistrybiobank());
		soapModel.setOntologies(model.getOntologies());
		soapModel.setBiomaterialcollected(model.getBiomaterialcollected());
		soapModel.setBiomaterialcollectedinbiobank(model.getBiomaterialcollectedinbiobank());
		soapModel.setBiomaterialprepared(model.getBiomaterialprepared());
		soapModel.setOrigionofcollection(model.getOrigionofcollection());
		soapModel.setUseofcollection(model.getUseofcollection());
		soapModel.setAssociateddataavailable(model.getAssociateddataavailable());
		soapModel.setImagingavailable(model.getImagingavailable());
		soapModel.setTheregistrybiobanksislistedinotherinventoriesnetworks(model.getTheregistrybiobanksislistedinotherinventoriesnetworks());
		soapModel.setModifieddate(model.getModifieddate());

		return soapModel;
	}

	public static GeneralInformationSoap[] toSoapModels(
		GeneralInformation[] models) {
		GeneralInformationSoap[] soapModels = new GeneralInformationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GeneralInformationSoap[][] toSoapModels(
		GeneralInformation[][] models) {
		GeneralInformationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GeneralInformationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GeneralInformationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GeneralInformationSoap[] toSoapModels(
		List<GeneralInformation> models) {
		List<GeneralInformationSoap> soapModels = new ArrayList<GeneralInformationSoap>(models.size());

		for (GeneralInformation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GeneralInformationSoap[soapModels.size()]);
	}

	public GeneralInformationSoap() {
	}

	public long getPrimaryKey() {
		return _generalinformationId;
	}

	public void setPrimaryKey(long pk) {
		setGeneralinformationId(pk);
	}

	public long getGeneralinformationId() {
		return _generalinformationId;
	}

	public void setGeneralinformationId(long generalinformationId) {
		_generalinformationId = generalinformationId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getAcronym() {
		return _acronym;
	}

	public void setAcronym(String acronym) {
		_acronym = acronym;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getHosteinstitue() {
		return _hosteinstitue;
	}

	public void setHosteinstitue(String hosteinstitue) {
		_hosteinstitue = hosteinstitue;
	}

	public String getTypeofhosteinstitue() {
		return _typeofhosteinstitue;
	}

	public void setTypeofhosteinstitue(String typeofhosteinstitue) {
		_typeofhosteinstitue = typeofhosteinstitue;
	}

	public String getSourceoffunding() {
		return _sourceoffunding;
	}

	public void setSourceoffunding(String sourceoffunding) {
		_sourceoffunding = sourceoffunding;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getTargetpopulation() {
		return _targetpopulation;
	}

	public void setTargetpopulation(String targetpopulation) {
		_targetpopulation = targetpopulation;
	}

	public String getYearofestablishment() {
		return _yearofestablishment;
	}

	public void setYearofestablishment(String yearofestablishment) {
		_yearofestablishment = yearofestablishment;
	}

	public String getHowmanyrdsareintheregistrybiobank() {
		return _howmanyrdsareintheregistrybiobank;
	}

	public void setHowmanyrdsareintheregistrybiobank(
		String howmanyrdsareintheregistrybiobank) {
		_howmanyrdsareintheregistrybiobank = howmanyrdsareintheregistrybiobank;
	}

	public String getPercentageofrarediseasesinyourregistrybiobank() {
		return _percentageofrarediseasesinyourregistrybiobank;
	}

	public void setPercentageofrarediseasesinyourregistrybiobank(
		String percentageofrarediseasesinyourregistrybiobank) {
		_percentageofrarediseasesinyourregistrybiobank = percentageofrarediseasesinyourregistrybiobank;
	}

	public String getOntologies() {
		return _ontologies;
	}

	public void setOntologies(String ontologies) {
		_ontologies = ontologies;
	}

	public String getBiomaterialcollected() {
		return _biomaterialcollected;
	}

	public void setBiomaterialcollected(String biomaterialcollected) {
		_biomaterialcollected = biomaterialcollected;
	}

	public String getBiomaterialcollectedinbiobank() {
		return _biomaterialcollectedinbiobank;
	}

	public void setBiomaterialcollectedinbiobank(
		String biomaterialcollectedinbiobank) {
		_biomaterialcollectedinbiobank = biomaterialcollectedinbiobank;
	}

	public String getBiomaterialprepared() {
		return _biomaterialprepared;
	}

	public void setBiomaterialprepared(String biomaterialprepared) {
		_biomaterialprepared = biomaterialprepared;
	}

	public String getOrigionofcollection() {
		return _origionofcollection;
	}

	public void setOrigionofcollection(String origionofcollection) {
		_origionofcollection = origionofcollection;
	}

	public String getUseofcollection() {
		return _useofcollection;
	}

	public void setUseofcollection(String useofcollection) {
		_useofcollection = useofcollection;
	}

	public String getAssociateddataavailable() {
		return _associateddataavailable;
	}

	public void setAssociateddataavailable(String associateddataavailable) {
		_associateddataavailable = associateddataavailable;
	}

	public String getImagingavailable() {
		return _imagingavailable;
	}

	public void setImagingavailable(String imagingavailable) {
		_imagingavailable = imagingavailable;
	}

	public String getTheregistrybiobanksislistedinotherinventoriesnetworks() {
		return _theregistrybiobanksislistedinotherinventoriesnetworks;
	}

	public void setTheregistrybiobanksislistedinotherinventoriesnetworks(
		String theregistrybiobanksislistedinotherinventoriesnetworks) {
		_theregistrybiobanksislistedinotherinventoriesnetworks = theregistrybiobanksislistedinotherinventoriesnetworks;
	}

	public Date getModifieddate() {
		return _modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		_modifieddate = modifieddate;
	}

	private long _generalinformationId;
	private long _organizationId;
	private String _acronym;
	private String _description;
	private String _hosteinstitue;
	private String _typeofhosteinstitue;
	private String _sourceoffunding;
	private String _country;
	private String _targetpopulation;
	private String _yearofestablishment;
	private String _howmanyrdsareintheregistrybiobank;
	private String _percentageofrarediseasesinyourregistrybiobank;
	private String _ontologies;
	private String _biomaterialcollected;
	private String _biomaterialcollectedinbiobank;
	private String _biomaterialprepared;
	private String _origionofcollection;
	private String _useofcollection;
	private String _associateddataavailable;
	private String _imagingavailable;
	private String _theregistrybiobanksislistedinotherinventoriesnetworks;
	private Date _modifieddate;
}