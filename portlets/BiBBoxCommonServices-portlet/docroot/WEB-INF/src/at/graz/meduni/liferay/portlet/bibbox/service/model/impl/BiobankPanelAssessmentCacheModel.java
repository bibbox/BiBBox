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

package at.graz.meduni.liferay.portlet.bibbox.service.model.impl;

import at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BiobankPanelAssessment in entity cache.
 *
 * @author reihsr
 * @see BiobankPanelAssessment
 * @generated
 */
public class BiobankPanelAssessmentCacheModel implements CacheModel<BiobankPanelAssessment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{biobankpanelassessmentId=");
		sb.append(biobankpanelassessmentId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", reviewer=");
		sb.append(reviewer);
		sb.append(", dateofassessment=");
		sb.append(dateofassessment);
		sb.append(", background1_1=");
		sb.append(background1_1);
		sb.append(", background1_1_comments=");
		sb.append(background1_1_comments);
		sb.append(", elsi1_2=");
		sb.append(elsi1_2);
		sb.append(", quality1_3=");
		sb.append(quality1_3);
		sb.append(", quality1_3_comments=");
		sb.append(quality1_3_comments);
		sb.append(", cataloguemeetpurposes2_1=");
		sb.append(cataloguemeetpurposes2_1);
		sb.append(", adequateitplatform2_2=");
		sb.append(adequateitplatform2_2);
		sb.append(", addedvaluecatalogue2_3=");
		sb.append(addedvaluecatalogue2_3);
		sb.append(", associateddata2_4=");
		sb.append(associateddata2_4);
		sb.append(", associateddata2_4_comments=");
		sb.append(associateddata2_4_comments);
		sb.append(", reasonstoaccept3_1=");
		sb.append(reasonstoaccept3_1);
		sb.append(", recommendation3_2=");
		sb.append(recommendation3_2);
		sb.append(", needadditionalinformation3_3=");
		sb.append(needadditionalinformation3_3);
		sb.append(", finalrecommendation_4=");
		sb.append(finalrecommendation_4);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BiobankPanelAssessment toEntityModel() {
		BiobankPanelAssessmentImpl biobankPanelAssessmentImpl = new BiobankPanelAssessmentImpl();

		biobankPanelAssessmentImpl.setBiobankpanelassessmentId(biobankpanelassessmentId);
		biobankPanelAssessmentImpl.setOrganizationId(organizationId);
		biobankPanelAssessmentImpl.setUserId(userId);

		if (reviewer == null) {
			biobankPanelAssessmentImpl.setReviewer(StringPool.BLANK);
		}
		else {
			biobankPanelAssessmentImpl.setReviewer(reviewer);
		}

		if (dateofassessment == Long.MIN_VALUE) {
			biobankPanelAssessmentImpl.setDateofassessment(null);
		}
		else {
			biobankPanelAssessmentImpl.setDateofassessment(new Date(
					dateofassessment));
		}

		if (background1_1 == null) {
			biobankPanelAssessmentImpl.setBackground1_1(StringPool.BLANK);
		}
		else {
			biobankPanelAssessmentImpl.setBackground1_1(background1_1);
		}

		if (background1_1_comments == null) {
			biobankPanelAssessmentImpl.setBackground1_1_comments(StringPool.BLANK);
		}
		else {
			biobankPanelAssessmentImpl.setBackground1_1_comments(background1_1_comments);
		}

		if (elsi1_2 == null) {
			biobankPanelAssessmentImpl.setElsi1_2(StringPool.BLANK);
		}
		else {
			biobankPanelAssessmentImpl.setElsi1_2(elsi1_2);
		}

		if (quality1_3 == null) {
			biobankPanelAssessmentImpl.setQuality1_3(StringPool.BLANK);
		}
		else {
			biobankPanelAssessmentImpl.setQuality1_3(quality1_3);
		}

		if (quality1_3_comments == null) {
			biobankPanelAssessmentImpl.setQuality1_3_comments(StringPool.BLANK);
		}
		else {
			biobankPanelAssessmentImpl.setQuality1_3_comments(quality1_3_comments);
		}

		if (cataloguemeetpurposes2_1 == null) {
			biobankPanelAssessmentImpl.setCataloguemeetpurposes2_1(StringPool.BLANK);
		}
		else {
			biobankPanelAssessmentImpl.setCataloguemeetpurposes2_1(cataloguemeetpurposes2_1);
		}

		if (adequateitplatform2_2 == null) {
			biobankPanelAssessmentImpl.setAdequateitplatform2_2(StringPool.BLANK);
		}
		else {
			biobankPanelAssessmentImpl.setAdequateitplatform2_2(adequateitplatform2_2);
		}

		if (addedvaluecatalogue2_3 == null) {
			biobankPanelAssessmentImpl.setAddedvaluecatalogue2_3(StringPool.BLANK);
		}
		else {
			biobankPanelAssessmentImpl.setAddedvaluecatalogue2_3(addedvaluecatalogue2_3);
		}

		if (associateddata2_4 == null) {
			biobankPanelAssessmentImpl.setAssociateddata2_4(StringPool.BLANK);
		}
		else {
			biobankPanelAssessmentImpl.setAssociateddata2_4(associateddata2_4);
		}

		if (associateddata2_4_comments == null) {
			biobankPanelAssessmentImpl.setAssociateddata2_4_comments(StringPool.BLANK);
		}
		else {
			biobankPanelAssessmentImpl.setAssociateddata2_4_comments(associateddata2_4_comments);
		}

		if (reasonstoaccept3_1 == null) {
			biobankPanelAssessmentImpl.setReasonstoaccept3_1(StringPool.BLANK);
		}
		else {
			biobankPanelAssessmentImpl.setReasonstoaccept3_1(reasonstoaccept3_1);
		}

		if (recommendation3_2 == null) {
			biobankPanelAssessmentImpl.setRecommendation3_2(StringPool.BLANK);
		}
		else {
			biobankPanelAssessmentImpl.setRecommendation3_2(recommendation3_2);
		}

		if (needadditionalinformation3_3 == null) {
			biobankPanelAssessmentImpl.setNeedadditionalinformation3_3(StringPool.BLANK);
		}
		else {
			biobankPanelAssessmentImpl.setNeedadditionalinformation3_3(needadditionalinformation3_3);
		}

		if (finalrecommendation_4 == null) {
			biobankPanelAssessmentImpl.setFinalrecommendation_4(StringPool.BLANK);
		}
		else {
			biobankPanelAssessmentImpl.setFinalrecommendation_4(finalrecommendation_4);
		}

		biobankPanelAssessmentImpl.resetOriginalValues();

		return biobankPanelAssessmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		biobankpanelassessmentId = objectInput.readLong();
		organizationId = objectInput.readLong();
		userId = objectInput.readLong();
		reviewer = objectInput.readUTF();
		dateofassessment = objectInput.readLong();
		background1_1 = objectInput.readUTF();
		background1_1_comments = objectInput.readUTF();
		elsi1_2 = objectInput.readUTF();
		quality1_3 = objectInput.readUTF();
		quality1_3_comments = objectInput.readUTF();
		cataloguemeetpurposes2_1 = objectInput.readUTF();
		adequateitplatform2_2 = objectInput.readUTF();
		addedvaluecatalogue2_3 = objectInput.readUTF();
		associateddata2_4 = objectInput.readUTF();
		associateddata2_4_comments = objectInput.readUTF();
		reasonstoaccept3_1 = objectInput.readUTF();
		recommendation3_2 = objectInput.readUTF();
		needadditionalinformation3_3 = objectInput.readUTF();
		finalrecommendation_4 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(biobankpanelassessmentId);
		objectOutput.writeLong(organizationId);
		objectOutput.writeLong(userId);

		if (reviewer == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reviewer);
		}

		objectOutput.writeLong(dateofassessment);

		if (background1_1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(background1_1);
		}

		if (background1_1_comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(background1_1_comments);
		}

		if (elsi1_2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(elsi1_2);
		}

		if (quality1_3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(quality1_3);
		}

		if (quality1_3_comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(quality1_3_comments);
		}

		if (cataloguemeetpurposes2_1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cataloguemeetpurposes2_1);
		}

		if (adequateitplatform2_2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(adequateitplatform2_2);
		}

		if (addedvaluecatalogue2_3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(addedvaluecatalogue2_3);
		}

		if (associateddata2_4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associateddata2_4);
		}

		if (associateddata2_4_comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(associateddata2_4_comments);
		}

		if (reasonstoaccept3_1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reasonstoaccept3_1);
		}

		if (recommendation3_2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(recommendation3_2);
		}

		if (needadditionalinformation3_3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(needadditionalinformation3_3);
		}

		if (finalrecommendation_4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(finalrecommendation_4);
		}
	}

	public long biobankpanelassessmentId;
	public long organizationId;
	public long userId;
	public String reviewer;
	public long dateofassessment;
	public String background1_1;
	public String background1_1_comments;
	public String elsi1_2;
	public String quality1_3;
	public String quality1_3_comments;
	public String cataloguemeetpurposes2_1;
	public String adequateitplatform2_2;
	public String addedvaluecatalogue2_3;
	public String associateddata2_4;
	public String associateddata2_4_comments;
	public String reasonstoaccept3_1;
	public String recommendation3_2;
	public String needadditionalinformation3_3;
	public String finalrecommendation_4;
}