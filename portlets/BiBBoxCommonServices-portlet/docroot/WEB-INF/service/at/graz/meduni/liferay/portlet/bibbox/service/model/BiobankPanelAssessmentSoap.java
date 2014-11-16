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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.bibbox.service.service.http.BiobankPanelAssessmentServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.http.BiobankPanelAssessmentServiceSoap
 * @generated
 */
public class BiobankPanelAssessmentSoap implements Serializable {
	public static BiobankPanelAssessmentSoap toSoapModel(
		BiobankPanelAssessment model) {
		BiobankPanelAssessmentSoap soapModel = new BiobankPanelAssessmentSoap();

		soapModel.setBiobankpanelassessmentId(model.getBiobankpanelassessmentId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setUserId(model.getUserId());
		soapModel.setDateofassessment(model.getDateofassessment());
		soapModel.setBackground1_1(model.getBackground1_1());
		soapModel.setBackground1_1_comments(model.getBackground1_1_comments());
		soapModel.setElsi1_2(model.getElsi1_2());
		soapModel.setQuality1_3(model.getQuality1_3());
		soapModel.setQuality1_3_comments(model.getQuality1_3_comments());
		soapModel.setCataloguemeetpurposes2_1(model.getCataloguemeetpurposes2_1());
		soapModel.setAdequateitplatform2_2(model.getAdequateitplatform2_2());
		soapModel.setAddedvaluecatalogue2_3(model.getAddedvaluecatalogue2_3());
		soapModel.setAssociateddata2_4(model.getAssociateddata2_4());
		soapModel.setAssociateddata2_4_comments(model.getAssociateddata2_4_comments());
		soapModel.setReasonstoaccept3_1(model.getReasonstoaccept3_1());
		soapModel.setRecommendation3_2(model.getRecommendation3_2());
		soapModel.setNeedadditionalinformation3_3(model.getNeedadditionalinformation3_3());
		soapModel.setFinalrecommendation_4(model.getFinalrecommendation_4());

		return soapModel;
	}

	public static BiobankPanelAssessmentSoap[] toSoapModels(
		BiobankPanelAssessment[] models) {
		BiobankPanelAssessmentSoap[] soapModels = new BiobankPanelAssessmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BiobankPanelAssessmentSoap[][] toSoapModels(
		BiobankPanelAssessment[][] models) {
		BiobankPanelAssessmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BiobankPanelAssessmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BiobankPanelAssessmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BiobankPanelAssessmentSoap[] toSoapModels(
		List<BiobankPanelAssessment> models) {
		List<BiobankPanelAssessmentSoap> soapModels = new ArrayList<BiobankPanelAssessmentSoap>(models.size());

		for (BiobankPanelAssessment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BiobankPanelAssessmentSoap[soapModels.size()]);
	}

	public BiobankPanelAssessmentSoap() {
	}

	public long getPrimaryKey() {
		return _biobankpanelassessmentId;
	}

	public void setPrimaryKey(long pk) {
		setBiobankpanelassessmentId(pk);
	}

	public long getBiobankpanelassessmentId() {
		return _biobankpanelassessmentId;
	}

	public void setBiobankpanelassessmentId(long biobankpanelassessmentId) {
		_biobankpanelassessmentId = biobankpanelassessmentId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getDateofassessment() {
		return _dateofassessment;
	}

	public void setDateofassessment(Date dateofassessment) {
		_dateofassessment = dateofassessment;
	}

	public String getBackground1_1() {
		return _background1_1;
	}

	public void setBackground1_1(String background1_1) {
		_background1_1 = background1_1;
	}

	public String getBackground1_1_comments() {
		return _background1_1_comments;
	}

	public void setBackground1_1_comments(String background1_1_comments) {
		_background1_1_comments = background1_1_comments;
	}

	public String getElsi1_2() {
		return _elsi1_2;
	}

	public void setElsi1_2(String elsi1_2) {
		_elsi1_2 = elsi1_2;
	}

	public String getQuality1_3() {
		return _quality1_3;
	}

	public void setQuality1_3(String quality1_3) {
		_quality1_3 = quality1_3;
	}

	public String getQuality1_3_comments() {
		return _quality1_3_comments;
	}

	public void setQuality1_3_comments(String quality1_3_comments) {
		_quality1_3_comments = quality1_3_comments;
	}

	public String getCataloguemeetpurposes2_1() {
		return _cataloguemeetpurposes2_1;
	}

	public void setCataloguemeetpurposes2_1(String cataloguemeetpurposes2_1) {
		_cataloguemeetpurposes2_1 = cataloguemeetpurposes2_1;
	}

	public String getAdequateitplatform2_2() {
		return _adequateitplatform2_2;
	}

	public void setAdequateitplatform2_2(String adequateitplatform2_2) {
		_adequateitplatform2_2 = adequateitplatform2_2;
	}

	public String getAddedvaluecatalogue2_3() {
		return _addedvaluecatalogue2_3;
	}

	public void setAddedvaluecatalogue2_3(String addedvaluecatalogue2_3) {
		_addedvaluecatalogue2_3 = addedvaluecatalogue2_3;
	}

	public String getAssociateddata2_4() {
		return _associateddata2_4;
	}

	public void setAssociateddata2_4(String associateddata2_4) {
		_associateddata2_4 = associateddata2_4;
	}

	public String getAssociateddata2_4_comments() {
		return _associateddata2_4_comments;
	}

	public void setAssociateddata2_4_comments(String associateddata2_4_comments) {
		_associateddata2_4_comments = associateddata2_4_comments;
	}

	public String getReasonstoaccept3_1() {
		return _reasonstoaccept3_1;
	}

	public void setReasonstoaccept3_1(String reasonstoaccept3_1) {
		_reasonstoaccept3_1 = reasonstoaccept3_1;
	}

	public String getRecommendation3_2() {
		return _recommendation3_2;
	}

	public void setRecommendation3_2(String recommendation3_2) {
		_recommendation3_2 = recommendation3_2;
	}

	public String getNeedadditionalinformation3_3() {
		return _needadditionalinformation3_3;
	}

	public void setNeedadditionalinformation3_3(
		String needadditionalinformation3_3) {
		_needadditionalinformation3_3 = needadditionalinformation3_3;
	}

	public String getFinalrecommendation_4() {
		return _finalrecommendation_4;
	}

	public void setFinalrecommendation_4(String finalrecommendation_4) {
		_finalrecommendation_4 = finalrecommendation_4;
	}

	private long _biobankpanelassessmentId;
	private long _organizationId;
	private long _userId;
	private Date _dateofassessment;
	private String _background1_1;
	private String _background1_1_comments;
	private String _elsi1_2;
	private String _quality1_3;
	private String _quality1_3_comments;
	private String _cataloguemeetpurposes2_1;
	private String _adequateitplatform2_2;
	private String _addedvaluecatalogue2_3;
	private String _associateddata2_4;
	private String _associateddata2_4_comments;
	private String _reasonstoaccept3_1;
	private String _recommendation3_2;
	private String _needadditionalinformation3_3;
	private String _finalrecommendation_4;
}