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

import at.graz.meduni.liferay.portlet.bibbox.service.service.BiobankPanelAssessmentLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author reihsr
 */
public class BiobankPanelAssessmentClp extends BaseModelImpl<BiobankPanelAssessment>
	implements BiobankPanelAssessment {
	public BiobankPanelAssessmentClp() {
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
	public long getPrimaryKey() {
		return _biobankpanelassessmentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBiobankpanelassessmentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _biobankpanelassessmentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("biobankpanelassessmentId", getBiobankpanelassessmentId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("userId", getUserId());
		attributes.put("reviewer", getReviewer());
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

		String reviewer = (String)attributes.get("reviewer");

		if (reviewer != null) {
			setReviewer(reviewer);
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

	@Override
	public long getBiobankpanelassessmentId() {
		return _biobankpanelassessmentId;
	}

	@Override
	public void setBiobankpanelassessmentId(long biobankpanelassessmentId) {
		_biobankpanelassessmentId = biobankpanelassessmentId;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setBiobankpanelassessmentId",
						long.class);

				method.invoke(_biobankPanelAssessmentRemoteModel,
					biobankpanelassessmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_biobankPanelAssessmentRemoteModel, organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_biobankPanelAssessmentRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getReviewer() {
		return _reviewer;
	}

	@Override
	public void setReviewer(String reviewer) {
		_reviewer = reviewer;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setReviewer", String.class);

				method.invoke(_biobankPanelAssessmentRemoteModel, reviewer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateofassessment() {
		return _dateofassessment;
	}

	@Override
	public void setDateofassessment(Date dateofassessment) {
		_dateofassessment = dateofassessment;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setDateofassessment",
						Date.class);

				method.invoke(_biobankPanelAssessmentRemoteModel,
					dateofassessment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBackground1_1() {
		return _background1_1;
	}

	@Override
	public void setBackground1_1(String background1_1) {
		_background1_1 = background1_1;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setBackground1_1", String.class);

				method.invoke(_biobankPanelAssessmentRemoteModel, background1_1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBackground1_1_comments() {
		return _background1_1_comments;
	}

	@Override
	public void setBackground1_1_comments(String background1_1_comments) {
		_background1_1_comments = background1_1_comments;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setBackground1_1_comments",
						String.class);

				method.invoke(_biobankPanelAssessmentRemoteModel,
					background1_1_comments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getElsi1_2() {
		return _elsi1_2;
	}

	@Override
	public void setElsi1_2(String elsi1_2) {
		_elsi1_2 = elsi1_2;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setElsi1_2", String.class);

				method.invoke(_biobankPanelAssessmentRemoteModel, elsi1_2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQuality1_3() {
		return _quality1_3;
	}

	@Override
	public void setQuality1_3(String quality1_3) {
		_quality1_3 = quality1_3;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setQuality1_3", String.class);

				method.invoke(_biobankPanelAssessmentRemoteModel, quality1_3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQuality1_3_comments() {
		return _quality1_3_comments;
	}

	@Override
	public void setQuality1_3_comments(String quality1_3_comments) {
		_quality1_3_comments = quality1_3_comments;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setQuality1_3_comments",
						String.class);

				method.invoke(_biobankPanelAssessmentRemoteModel,
					quality1_3_comments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCataloguemeetpurposes2_1() {
		return _cataloguemeetpurposes2_1;
	}

	@Override
	public void setCataloguemeetpurposes2_1(String cataloguemeetpurposes2_1) {
		_cataloguemeetpurposes2_1 = cataloguemeetpurposes2_1;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCataloguemeetpurposes2_1",
						String.class);

				method.invoke(_biobankPanelAssessmentRemoteModel,
					cataloguemeetpurposes2_1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdequateitplatform2_2() {
		return _adequateitplatform2_2;
	}

	@Override
	public void setAdequateitplatform2_2(String adequateitplatform2_2) {
		_adequateitplatform2_2 = adequateitplatform2_2;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAdequateitplatform2_2",
						String.class);

				method.invoke(_biobankPanelAssessmentRemoteModel,
					adequateitplatform2_2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddedvaluecatalogue2_3() {
		return _addedvaluecatalogue2_3;
	}

	@Override
	public void setAddedvaluecatalogue2_3(String addedvaluecatalogue2_3) {
		_addedvaluecatalogue2_3 = addedvaluecatalogue2_3;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAddedvaluecatalogue2_3",
						String.class);

				method.invoke(_biobankPanelAssessmentRemoteModel,
					addedvaluecatalogue2_3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAssociateddata2_4() {
		return _associateddata2_4;
	}

	@Override
	public void setAssociateddata2_4(String associateddata2_4) {
		_associateddata2_4 = associateddata2_4;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAssociateddata2_4",
						String.class);

				method.invoke(_biobankPanelAssessmentRemoteModel,
					associateddata2_4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAssociateddata2_4_comments() {
		return _associateddata2_4_comments;
	}

	@Override
	public void setAssociateddata2_4_comments(String associateddata2_4_comments) {
		_associateddata2_4_comments = associateddata2_4_comments;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAssociateddata2_4_comments",
						String.class);

				method.invoke(_biobankPanelAssessmentRemoteModel,
					associateddata2_4_comments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReasonstoaccept3_1() {
		return _reasonstoaccept3_1;
	}

	@Override
	public void setReasonstoaccept3_1(String reasonstoaccept3_1) {
		_reasonstoaccept3_1 = reasonstoaccept3_1;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setReasonstoaccept3_1",
						String.class);

				method.invoke(_biobankPanelAssessmentRemoteModel,
					reasonstoaccept3_1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRecommendation3_2() {
		return _recommendation3_2;
	}

	@Override
	public void setRecommendation3_2(String recommendation3_2) {
		_recommendation3_2 = recommendation3_2;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setRecommendation3_2",
						String.class);

				method.invoke(_biobankPanelAssessmentRemoteModel,
					recommendation3_2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNeedadditionalinformation3_3() {
		return _needadditionalinformation3_3;
	}

	@Override
	public void setNeedadditionalinformation3_3(
		String needadditionalinformation3_3) {
		_needadditionalinformation3_3 = needadditionalinformation3_3;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setNeedadditionalinformation3_3",
						String.class);

				method.invoke(_biobankPanelAssessmentRemoteModel,
					needadditionalinformation3_3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFinalrecommendation_4() {
		return _finalrecommendation_4;
	}

	@Override
	public void setFinalrecommendation_4(String finalrecommendation_4) {
		_finalrecommendation_4 = finalrecommendation_4;

		if (_biobankPanelAssessmentRemoteModel != null) {
			try {
				Class<?> clazz = _biobankPanelAssessmentRemoteModel.getClass();

				Method method = clazz.getMethod("setFinalrecommendation_4",
						String.class);

				method.invoke(_biobankPanelAssessmentRemoteModel,
					finalrecommendation_4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getAggregatedAnswers() {
		try {
			String methodName = "getAggregatedAnswers";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getBiobankPanelAssessmentRemoteModel() {
		return _biobankPanelAssessmentRemoteModel;
	}

	public void setBiobankPanelAssessmentRemoteModel(
		BaseModel<?> biobankPanelAssessmentRemoteModel) {
		_biobankPanelAssessmentRemoteModel = biobankPanelAssessmentRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _biobankPanelAssessmentRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_biobankPanelAssessmentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BiobankPanelAssessmentLocalServiceUtil.addBiobankPanelAssessment(this);
		}
		else {
			BiobankPanelAssessmentLocalServiceUtil.updateBiobankPanelAssessment(this);
		}
	}

	@Override
	public BiobankPanelAssessment toEscapedModel() {
		return (BiobankPanelAssessment)ProxyUtil.newProxyInstance(BiobankPanelAssessment.class.getClassLoader(),
			new Class[] { BiobankPanelAssessment.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BiobankPanelAssessmentClp clone = new BiobankPanelAssessmentClp();

		clone.setBiobankpanelassessmentId(getBiobankpanelassessmentId());
		clone.setOrganizationId(getOrganizationId());
		clone.setUserId(getUserId());
		clone.setReviewer(getReviewer());
		clone.setDateofassessment(getDateofassessment());
		clone.setBackground1_1(getBackground1_1());
		clone.setBackground1_1_comments(getBackground1_1_comments());
		clone.setElsi1_2(getElsi1_2());
		clone.setQuality1_3(getQuality1_3());
		clone.setQuality1_3_comments(getQuality1_3_comments());
		clone.setCataloguemeetpurposes2_1(getCataloguemeetpurposes2_1());
		clone.setAdequateitplatform2_2(getAdequateitplatform2_2());
		clone.setAddedvaluecatalogue2_3(getAddedvaluecatalogue2_3());
		clone.setAssociateddata2_4(getAssociateddata2_4());
		clone.setAssociateddata2_4_comments(getAssociateddata2_4_comments());
		clone.setReasonstoaccept3_1(getReasonstoaccept3_1());
		clone.setRecommendation3_2(getRecommendation3_2());
		clone.setNeedadditionalinformation3_3(getNeedadditionalinformation3_3());
		clone.setFinalrecommendation_4(getFinalrecommendation_4());

		return clone;
	}

	@Override
	public int compareTo(BiobankPanelAssessment biobankPanelAssessment) {
		long primaryKey = biobankPanelAssessment.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BiobankPanelAssessmentClp)) {
			return false;
		}

		BiobankPanelAssessmentClp biobankPanelAssessment = (BiobankPanelAssessmentClp)obj;

		long primaryKey = biobankPanelAssessment.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{biobankpanelassessmentId=");
		sb.append(getBiobankpanelassessmentId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", reviewer=");
		sb.append(getReviewer());
		sb.append(", dateofassessment=");
		sb.append(getDateofassessment());
		sb.append(", background1_1=");
		sb.append(getBackground1_1());
		sb.append(", background1_1_comments=");
		sb.append(getBackground1_1_comments());
		sb.append(", elsi1_2=");
		sb.append(getElsi1_2());
		sb.append(", quality1_3=");
		sb.append(getQuality1_3());
		sb.append(", quality1_3_comments=");
		sb.append(getQuality1_3_comments());
		sb.append(", cataloguemeetpurposes2_1=");
		sb.append(getCataloguemeetpurposes2_1());
		sb.append(", adequateitplatform2_2=");
		sb.append(getAdequateitplatform2_2());
		sb.append(", addedvaluecatalogue2_3=");
		sb.append(getAddedvaluecatalogue2_3());
		sb.append(", associateddata2_4=");
		sb.append(getAssociateddata2_4());
		sb.append(", associateddata2_4_comments=");
		sb.append(getAssociateddata2_4_comments());
		sb.append(", reasonstoaccept3_1=");
		sb.append(getReasonstoaccept3_1());
		sb.append(", recommendation3_2=");
		sb.append(getRecommendation3_2());
		sb.append(", needadditionalinformation3_3=");
		sb.append(getNeedadditionalinformation3_3());
		sb.append(", finalrecommendation_4=");
		sb.append(getFinalrecommendation_4());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>biobankpanelassessmentId</column-name><column-value><![CDATA[");
		sb.append(getBiobankpanelassessmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reviewer</column-name><column-value><![CDATA[");
		sb.append(getReviewer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateofassessment</column-name><column-value><![CDATA[");
		sb.append(getDateofassessment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>background1_1</column-name><column-value><![CDATA[");
		sb.append(getBackground1_1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>background1_1_comments</column-name><column-value><![CDATA[");
		sb.append(getBackground1_1_comments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>elsi1_2</column-name><column-value><![CDATA[");
		sb.append(getElsi1_2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quality1_3</column-name><column-value><![CDATA[");
		sb.append(getQuality1_3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quality1_3_comments</column-name><column-value><![CDATA[");
		sb.append(getQuality1_3_comments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cataloguemeetpurposes2_1</column-name><column-value><![CDATA[");
		sb.append(getCataloguemeetpurposes2_1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adequateitplatform2_2</column-name><column-value><![CDATA[");
		sb.append(getAdequateitplatform2_2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addedvaluecatalogue2_3</column-name><column-value><![CDATA[");
		sb.append(getAddedvaluecatalogue2_3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>associateddata2_4</column-name><column-value><![CDATA[");
		sb.append(getAssociateddata2_4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>associateddata2_4_comments</column-name><column-value><![CDATA[");
		sb.append(getAssociateddata2_4_comments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reasonstoaccept3_1</column-name><column-value><![CDATA[");
		sb.append(getReasonstoaccept3_1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recommendation3_2</column-name><column-value><![CDATA[");
		sb.append(getRecommendation3_2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>needadditionalinformation3_3</column-name><column-value><![CDATA[");
		sb.append(getNeedadditionalinformation3_3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finalrecommendation_4</column-name><column-value><![CDATA[");
		sb.append(getFinalrecommendation_4());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _biobankpanelassessmentId;
	private long _organizationId;
	private long _userId;
	private String _userUuid;
	private String _reviewer;
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
	private BaseModel<?> _biobankPanelAssessmentRemoteModel;
	private Class<?> _clpSerializerClass = at.graz.meduni.liferay.portlet.bibbox.service.service.ClpSerializer.class;
}