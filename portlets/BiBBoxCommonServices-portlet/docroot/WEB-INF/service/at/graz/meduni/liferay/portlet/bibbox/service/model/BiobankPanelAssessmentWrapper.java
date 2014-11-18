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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BiobankPanelAssessment}.
 * </p>
 *
 * @author reihsr
 * @see BiobankPanelAssessment
 * @generated
 */
public class BiobankPanelAssessmentWrapper implements BiobankPanelAssessment,
	ModelWrapper<BiobankPanelAssessment> {
	public BiobankPanelAssessmentWrapper(
		BiobankPanelAssessment biobankPanelAssessment) {
		_biobankPanelAssessment = biobankPanelAssessment;
	}

	@Override
	public Class<?> getModelClass() {
		return BiobankPanelAssessment.class;
	}

	@Override
	public String getModelClassName() {
		return BiobankPanelAssessment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("biobankpanelassessmentId", getBiobankpanelassessmentId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("userId", getUserId());
		attributes.put("dateofassessment", getDateofassessment());
		attributes.put("background1_1", getBackground1_1());
		attributes.put("background1_1_comments", getBackground1_1_comments());
		attributes.put("elsi1_2", getElsi1_2());
		attributes.put("quality1_3", getQuality1_3());
		attributes.put("quality1_3_comments", getQuality1_3_comments());
		attributes.put("cataloguemeetpurposes2_1", getCataloguemeetpurposes2_1());
		attributes.put("adequateitplatform2_2", getAdequateitplatform2_2());
		attributes.put("addedvaluecatalogue2_3", getAddedvaluecatalogue2_3());
		attributes.put("associateddata2_4", getAssociateddata2_4());
		attributes.put("associateddata2_4_comments",
			getAssociateddata2_4_comments());
		attributes.put("reasonstoaccept3_1", getReasonstoaccept3_1());
		attributes.put("recommendation3_2", getRecommendation3_2());
		attributes.put("needadditionalinformation3_3",
			getNeedadditionalinformation3_3());
		attributes.put("finalrecommendation_4", getFinalrecommendation_4());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long biobankpanelassessmentId = (Long)attributes.get(
				"biobankpanelassessmentId");

		if (biobankpanelassessmentId != null) {
			setBiobankpanelassessmentId(biobankpanelassessmentId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date dateofassessment = (Date)attributes.get("dateofassessment");

		if (dateofassessment != null) {
			setDateofassessment(dateofassessment);
		}

		String background1_1 = (String)attributes.get("background1_1");

		if (background1_1 != null) {
			setBackground1_1(background1_1);
		}

		String background1_1_comments = (String)attributes.get(
				"background1_1_comments");

		if (background1_1_comments != null) {
			setBackground1_1_comments(background1_1_comments);
		}

		String elsi1_2 = (String)attributes.get("elsi1_2");

		if (elsi1_2 != null) {
			setElsi1_2(elsi1_2);
		}

		String quality1_3 = (String)attributes.get("quality1_3");

		if (quality1_3 != null) {
			setQuality1_3(quality1_3);
		}

		String quality1_3_comments = (String)attributes.get(
				"quality1_3_comments");

		if (quality1_3_comments != null) {
			setQuality1_3_comments(quality1_3_comments);
		}

		String cataloguemeetpurposes2_1 = (String)attributes.get(
				"cataloguemeetpurposes2_1");

		if (cataloguemeetpurposes2_1 != null) {
			setCataloguemeetpurposes2_1(cataloguemeetpurposes2_1);
		}

		String adequateitplatform2_2 = (String)attributes.get(
				"adequateitplatform2_2");

		if (adequateitplatform2_2 != null) {
			setAdequateitplatform2_2(adequateitplatform2_2);
		}

		String addedvaluecatalogue2_3 = (String)attributes.get(
				"addedvaluecatalogue2_3");

		if (addedvaluecatalogue2_3 != null) {
			setAddedvaluecatalogue2_3(addedvaluecatalogue2_3);
		}

		String associateddata2_4 = (String)attributes.get("associateddata2_4");

		if (associateddata2_4 != null) {
			setAssociateddata2_4(associateddata2_4);
		}

		String associateddata2_4_comments = (String)attributes.get(
				"associateddata2_4_comments");

		if (associateddata2_4_comments != null) {
			setAssociateddata2_4_comments(associateddata2_4_comments);
		}

		String reasonstoaccept3_1 = (String)attributes.get("reasonstoaccept3_1");

		if (reasonstoaccept3_1 != null) {
			setReasonstoaccept3_1(reasonstoaccept3_1);
		}

		String recommendation3_2 = (String)attributes.get("recommendation3_2");

		if (recommendation3_2 != null) {
			setRecommendation3_2(recommendation3_2);
		}

		String needadditionalinformation3_3 = (String)attributes.get(
				"needadditionalinformation3_3");

		if (needadditionalinformation3_3 != null) {
			setNeedadditionalinformation3_3(needadditionalinformation3_3);
		}

		String finalrecommendation_4 = (String)attributes.get(
				"finalrecommendation_4");

		if (finalrecommendation_4 != null) {
			setFinalrecommendation_4(finalrecommendation_4);
		}
	}

	/**
	* Returns the primary key of this biobank panel assessment.
	*
	* @return the primary key of this biobank panel assessment
	*/
	@Override
	public long getPrimaryKey() {
		return _biobankPanelAssessment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this biobank panel assessment.
	*
	* @param primaryKey the primary key of this biobank panel assessment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_biobankPanelAssessment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the biobankpanelassessment ID of this biobank panel assessment.
	*
	* @return the biobankpanelassessment ID of this biobank panel assessment
	*/
	@Override
	public long getBiobankpanelassessmentId() {
		return _biobankPanelAssessment.getBiobankpanelassessmentId();
	}

	/**
	* Sets the biobankpanelassessment ID of this biobank panel assessment.
	*
	* @param biobankpanelassessmentId the biobankpanelassessment ID of this biobank panel assessment
	*/
	@Override
	public void setBiobankpanelassessmentId(long biobankpanelassessmentId) {
		_biobankPanelAssessment.setBiobankpanelassessmentId(biobankpanelassessmentId);
	}

	/**
	* Returns the organization ID of this biobank panel assessment.
	*
	* @return the organization ID of this biobank panel assessment
	*/
	@Override
	public long getOrganizationId() {
		return _biobankPanelAssessment.getOrganizationId();
	}

	/**
	* Sets the organization ID of this biobank panel assessment.
	*
	* @param organizationId the organization ID of this biobank panel assessment
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_biobankPanelAssessment.setOrganizationId(organizationId);
	}

	/**
	* Returns the user ID of this biobank panel assessment.
	*
	* @return the user ID of this biobank panel assessment
	*/
	@Override
	public long getUserId() {
		return _biobankPanelAssessment.getUserId();
	}

	/**
	* Sets the user ID of this biobank panel assessment.
	*
	* @param userId the user ID of this biobank panel assessment
	*/
	@Override
	public void setUserId(long userId) {
		_biobankPanelAssessment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this biobank panel assessment.
	*
	* @return the user uuid of this biobank panel assessment
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biobankPanelAssessment.getUserUuid();
	}

	/**
	* Sets the user uuid of this biobank panel assessment.
	*
	* @param userUuid the user uuid of this biobank panel assessment
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_biobankPanelAssessment.setUserUuid(userUuid);
	}

	/**
	* Returns the dateofassessment of this biobank panel assessment.
	*
	* @return the dateofassessment of this biobank panel assessment
	*/
	@Override
	public java.util.Date getDateofassessment() {
		return _biobankPanelAssessment.getDateofassessment();
	}

	/**
	* Sets the dateofassessment of this biobank panel assessment.
	*
	* @param dateofassessment the dateofassessment of this biobank panel assessment
	*/
	@Override
	public void setDateofassessment(java.util.Date dateofassessment) {
		_biobankPanelAssessment.setDateofassessment(dateofassessment);
	}

	/**
	* Returns the background1_1 of this biobank panel assessment.
	*
	* @return the background1_1 of this biobank panel assessment
	*/
	@Override
	public java.lang.String getBackground1_1() {
		return _biobankPanelAssessment.getBackground1_1();
	}

	/**
	* Sets the background1_1 of this biobank panel assessment.
	*
	* @param background1_1 the background1_1 of this biobank panel assessment
	*/
	@Override
	public void setBackground1_1(java.lang.String background1_1) {
		_biobankPanelAssessment.setBackground1_1(background1_1);
	}

	/**
	* Returns the background1_1_comments of this biobank panel assessment.
	*
	* @return the background1_1_comments of this biobank panel assessment
	*/
	@Override
	public java.lang.String getBackground1_1_comments() {
		return _biobankPanelAssessment.getBackground1_1_comments();
	}

	/**
	* Sets the background1_1_comments of this biobank panel assessment.
	*
	* @param background1_1_comments the background1_1_comments of this biobank panel assessment
	*/
	@Override
	public void setBackground1_1_comments(
		java.lang.String background1_1_comments) {
		_biobankPanelAssessment.setBackground1_1_comments(background1_1_comments);
	}

	/**
	* Returns the elsi1_2 of this biobank panel assessment.
	*
	* @return the elsi1_2 of this biobank panel assessment
	*/
	@Override
	public java.lang.String getElsi1_2() {
		return _biobankPanelAssessment.getElsi1_2();
	}

	/**
	* Sets the elsi1_2 of this biobank panel assessment.
	*
	* @param elsi1_2 the elsi1_2 of this biobank panel assessment
	*/
	@Override
	public void setElsi1_2(java.lang.String elsi1_2) {
		_biobankPanelAssessment.setElsi1_2(elsi1_2);
	}

	/**
	* Returns the quality1_3 of this biobank panel assessment.
	*
	* @return the quality1_3 of this biobank panel assessment
	*/
	@Override
	public java.lang.String getQuality1_3() {
		return _biobankPanelAssessment.getQuality1_3();
	}

	/**
	* Sets the quality1_3 of this biobank panel assessment.
	*
	* @param quality1_3 the quality1_3 of this biobank panel assessment
	*/
	@Override
	public void setQuality1_3(java.lang.String quality1_3) {
		_biobankPanelAssessment.setQuality1_3(quality1_3);
	}

	/**
	* Returns the quality1_3_comments of this biobank panel assessment.
	*
	* @return the quality1_3_comments of this biobank panel assessment
	*/
	@Override
	public java.lang.String getQuality1_3_comments() {
		return _biobankPanelAssessment.getQuality1_3_comments();
	}

	/**
	* Sets the quality1_3_comments of this biobank panel assessment.
	*
	* @param quality1_3_comments the quality1_3_comments of this biobank panel assessment
	*/
	@Override
	public void setQuality1_3_comments(java.lang.String quality1_3_comments) {
		_biobankPanelAssessment.setQuality1_3_comments(quality1_3_comments);
	}

	/**
	* Returns the cataloguemeetpurposes2_1 of this biobank panel assessment.
	*
	* @return the cataloguemeetpurposes2_1 of this biobank panel assessment
	*/
	@Override
	public java.lang.String getCataloguemeetpurposes2_1() {
		return _biobankPanelAssessment.getCataloguemeetpurposes2_1();
	}

	/**
	* Sets the cataloguemeetpurposes2_1 of this biobank panel assessment.
	*
	* @param cataloguemeetpurposes2_1 the cataloguemeetpurposes2_1 of this biobank panel assessment
	*/
	@Override
	public void setCataloguemeetpurposes2_1(
		java.lang.String cataloguemeetpurposes2_1) {
		_biobankPanelAssessment.setCataloguemeetpurposes2_1(cataloguemeetpurposes2_1);
	}

	/**
	* Returns the adequateitplatform2_2 of this biobank panel assessment.
	*
	* @return the adequateitplatform2_2 of this biobank panel assessment
	*/
	@Override
	public java.lang.String getAdequateitplatform2_2() {
		return _biobankPanelAssessment.getAdequateitplatform2_2();
	}

	/**
	* Sets the adequateitplatform2_2 of this biobank panel assessment.
	*
	* @param adequateitplatform2_2 the adequateitplatform2_2 of this biobank panel assessment
	*/
	@Override
	public void setAdequateitplatform2_2(java.lang.String adequateitplatform2_2) {
		_biobankPanelAssessment.setAdequateitplatform2_2(adequateitplatform2_2);
	}

	/**
	* Returns the addedvaluecatalogue2_3 of this biobank panel assessment.
	*
	* @return the addedvaluecatalogue2_3 of this biobank panel assessment
	*/
	@Override
	public java.lang.String getAddedvaluecatalogue2_3() {
		return _biobankPanelAssessment.getAddedvaluecatalogue2_3();
	}

	/**
	* Sets the addedvaluecatalogue2_3 of this biobank panel assessment.
	*
	* @param addedvaluecatalogue2_3 the addedvaluecatalogue2_3 of this biobank panel assessment
	*/
	@Override
	public void setAddedvaluecatalogue2_3(
		java.lang.String addedvaluecatalogue2_3) {
		_biobankPanelAssessment.setAddedvaluecatalogue2_3(addedvaluecatalogue2_3);
	}

	/**
	* Returns the associateddata2_4 of this biobank panel assessment.
	*
	* @return the associateddata2_4 of this biobank panel assessment
	*/
	@Override
	public java.lang.String getAssociateddata2_4() {
		return _biobankPanelAssessment.getAssociateddata2_4();
	}

	/**
	* Sets the associateddata2_4 of this biobank panel assessment.
	*
	* @param associateddata2_4 the associateddata2_4 of this biobank panel assessment
	*/
	@Override
	public void setAssociateddata2_4(java.lang.String associateddata2_4) {
		_biobankPanelAssessment.setAssociateddata2_4(associateddata2_4);
	}

	/**
	* Returns the associateddata2_4_comments of this biobank panel assessment.
	*
	* @return the associateddata2_4_comments of this biobank panel assessment
	*/
	@Override
	public java.lang.String getAssociateddata2_4_comments() {
		return _biobankPanelAssessment.getAssociateddata2_4_comments();
	}

	/**
	* Sets the associateddata2_4_comments of this biobank panel assessment.
	*
	* @param associateddata2_4_comments the associateddata2_4_comments of this biobank panel assessment
	*/
	@Override
	public void setAssociateddata2_4_comments(
		java.lang.String associateddata2_4_comments) {
		_biobankPanelAssessment.setAssociateddata2_4_comments(associateddata2_4_comments);
	}

	/**
	* Returns the reasonstoaccept3_1 of this biobank panel assessment.
	*
	* @return the reasonstoaccept3_1 of this biobank panel assessment
	*/
	@Override
	public java.lang.String getReasonstoaccept3_1() {
		return _biobankPanelAssessment.getReasonstoaccept3_1();
	}

	/**
	* Sets the reasonstoaccept3_1 of this biobank panel assessment.
	*
	* @param reasonstoaccept3_1 the reasonstoaccept3_1 of this biobank panel assessment
	*/
	@Override
	public void setReasonstoaccept3_1(java.lang.String reasonstoaccept3_1) {
		_biobankPanelAssessment.setReasonstoaccept3_1(reasonstoaccept3_1);
	}

	/**
	* Returns the recommendation3_2 of this biobank panel assessment.
	*
	* @return the recommendation3_2 of this biobank panel assessment
	*/
	@Override
	public java.lang.String getRecommendation3_2() {
		return _biobankPanelAssessment.getRecommendation3_2();
	}

	/**
	* Sets the recommendation3_2 of this biobank panel assessment.
	*
	* @param recommendation3_2 the recommendation3_2 of this biobank panel assessment
	*/
	@Override
	public void setRecommendation3_2(java.lang.String recommendation3_2) {
		_biobankPanelAssessment.setRecommendation3_2(recommendation3_2);
	}

	/**
	* Returns the needadditionalinformation3_3 of this biobank panel assessment.
	*
	* @return the needadditionalinformation3_3 of this biobank panel assessment
	*/
	@Override
	public java.lang.String getNeedadditionalinformation3_3() {
		return _biobankPanelAssessment.getNeedadditionalinformation3_3();
	}

	/**
	* Sets the needadditionalinformation3_3 of this biobank panel assessment.
	*
	* @param needadditionalinformation3_3 the needadditionalinformation3_3 of this biobank panel assessment
	*/
	@Override
	public void setNeedadditionalinformation3_3(
		java.lang.String needadditionalinformation3_3) {
		_biobankPanelAssessment.setNeedadditionalinformation3_3(needadditionalinformation3_3);
	}

	/**
	* Returns the finalrecommendation_4 of this biobank panel assessment.
	*
	* @return the finalrecommendation_4 of this biobank panel assessment
	*/
	@Override
	public java.lang.String getFinalrecommendation_4() {
		return _biobankPanelAssessment.getFinalrecommendation_4();
	}

	/**
	* Sets the finalrecommendation_4 of this biobank panel assessment.
	*
	* @param finalrecommendation_4 the finalrecommendation_4 of this biobank panel assessment
	*/
	@Override
	public void setFinalrecommendation_4(java.lang.String finalrecommendation_4) {
		_biobankPanelAssessment.setFinalrecommendation_4(finalrecommendation_4);
	}

	@Override
	public boolean isNew() {
		return _biobankPanelAssessment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_biobankPanelAssessment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _biobankPanelAssessment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_biobankPanelAssessment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _biobankPanelAssessment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _biobankPanelAssessment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_biobankPanelAssessment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _biobankPanelAssessment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_biobankPanelAssessment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_biobankPanelAssessment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_biobankPanelAssessment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BiobankPanelAssessmentWrapper((BiobankPanelAssessment)_biobankPanelAssessment.clone());
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment biobankPanelAssessment) {
		return _biobankPanelAssessment.compareTo(biobankPanelAssessment);
	}

	@Override
	public int hashCode() {
		return _biobankPanelAssessment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment> toCacheModel() {
		return _biobankPanelAssessment.toCacheModel();
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment toEscapedModel() {
		return new BiobankPanelAssessmentWrapper(_biobankPanelAssessment.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment toUnescapedModel() {
		return new BiobankPanelAssessmentWrapper(_biobankPanelAssessment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _biobankPanelAssessment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _biobankPanelAssessment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_biobankPanelAssessment.persist();
	}

	@Override
	public java.lang.String getAggregatedAnswers() {
		return _biobankPanelAssessment.getAggregatedAnswers();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BiobankPanelAssessmentWrapper)) {
			return false;
		}

		BiobankPanelAssessmentWrapper biobankPanelAssessmentWrapper = (BiobankPanelAssessmentWrapper)obj;

		if (Validator.equals(_biobankPanelAssessment,
					biobankPanelAssessmentWrapper._biobankPanelAssessment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BiobankPanelAssessment getWrappedBiobankPanelAssessment() {
		return _biobankPanelAssessment;
	}

	@Override
	public BiobankPanelAssessment getWrappedModel() {
		return _biobankPanelAssessment;
	}

	@Override
	public void resetOriginalValues() {
		_biobankPanelAssessment.resetOriginalValues();
	}

	private BiobankPanelAssessment _biobankPanelAssessment;
}