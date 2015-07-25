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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.service.http.DiseaseMatrixServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.http.DiseaseMatrixServiceSoap
 * @generated
 */
public class DiseaseMatrixSoap implements Serializable {
	public static DiseaseMatrixSoap toSoapModel(DiseaseMatrix model) {
		DiseaseMatrixSoap soapModel = new DiseaseMatrixSoap();

		soapModel.setDiseasematrixId(model.getDiseasematrixId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setDiseasename(model.getDiseasename());
		soapModel.setPatientcount(model.getPatientcount());
		soapModel.setGene(model.getGene());
		soapModel.setOrphanumber(model.getOrphanumber());
		soapModel.setIcd10(model.getIcd10());
		soapModel.setOmim(model.getOmim());
		soapModel.setSynonym(model.getSynonym());
		soapModel.setModifieddate(model.getModifieddate());

		return soapModel;
	}

	public static DiseaseMatrixSoap[] toSoapModels(DiseaseMatrix[] models) {
		DiseaseMatrixSoap[] soapModels = new DiseaseMatrixSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DiseaseMatrixSoap[][] toSoapModels(DiseaseMatrix[][] models) {
		DiseaseMatrixSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DiseaseMatrixSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DiseaseMatrixSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DiseaseMatrixSoap[] toSoapModels(List<DiseaseMatrix> models) {
		List<DiseaseMatrixSoap> soapModels = new ArrayList<DiseaseMatrixSoap>(models.size());

		for (DiseaseMatrix model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DiseaseMatrixSoap[soapModels.size()]);
	}

	public DiseaseMatrixSoap() {
	}

	public long getPrimaryKey() {
		return _diseasematrixId;
	}

	public void setPrimaryKey(long pk) {
		setDiseasematrixId(pk);
	}

	public long getDiseasematrixId() {
		return _diseasematrixId;
	}

	public void setDiseasematrixId(long diseasematrixId) {
		_diseasematrixId = diseasematrixId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getDiseasename() {
		return _diseasename;
	}

	public void setDiseasename(String diseasename) {
		_diseasename = diseasename;
	}

	public String getPatientcount() {
		return _patientcount;
	}

	public void setPatientcount(String patientcount) {
		_patientcount = patientcount;
	}

	public String getGene() {
		return _gene;
	}

	public void setGene(String gene) {
		_gene = gene;
	}

	public String getOrphanumber() {
		return _orphanumber;
	}

	public void setOrphanumber(String orphanumber) {
		_orphanumber = orphanumber;
	}

	public String getIcd10() {
		return _icd10;
	}

	public void setIcd10(String icd10) {
		_icd10 = icd10;
	}

	public String getOmim() {
		return _omim;
	}

	public void setOmim(String omim) {
		_omim = omim;
	}

	public String getSynonym() {
		return _synonym;
	}

	public void setSynonym(String synonym) {
		_synonym = synonym;
	}

	public Date getModifieddate() {
		return _modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		_modifieddate = modifieddate;
	}

	private long _diseasematrixId;
	private long _organizationId;
	private String _diseasename;
	private String _patientcount;
	private String _gene;
	private String _orphanumber;
	private String _icd10;
	private String _omim;
	private String _synonym;
	private Date _modifieddate;
}