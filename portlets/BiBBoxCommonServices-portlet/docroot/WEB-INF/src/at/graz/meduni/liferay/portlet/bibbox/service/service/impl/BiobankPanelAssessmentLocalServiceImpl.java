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

package at.graz.meduni.liferay.portlet.bibbox.service.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.portlet.PortletRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;

import at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.BiobankPanelAssessmentImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.service.base.BiobankPanelAssessmentLocalServiceBaseImpl;

/**
 * The implementation of the biobank panel assessment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.service.BiobankPanelAssessmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.base.BiobankPanelAssessmentLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.BiobankPanelAssessmentLocalServiceUtil
 */
public class BiobankPanelAssessmentLocalServiceImpl
	extends BiobankPanelAssessmentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.service.BiobankPanelAssessmentLocalServiceUtil} to access the biobank panel assessment local service.
	 */
	/**
	 * Convenience method to create a Invitation object out of the request.
	 * @throws SystemException 
	 */
	public BiobankPanelAssessment biobankPanelAssessmentFromRequest(PortletRequest request) throws SystemException {
		BiobankPanelAssessmentImpl biobankpanelassessment = new BiobankPanelAssessmentImpl();
		biobankpanelassessment.setBiobankpanelassessmentId(CounterLocalServiceUtil.increment(BiobankPanelAssessment.class.getName()));
		biobankpanelassessment.setOrganizationId(ParamUtil.getLong(request, "organizationId"));
		biobankpanelassessment.setUserId(ParamUtil.getLong(request, "userId"));
		// DateFormat
		DateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");
		biobankpanelassessment.setDateofassessment(ParamUtil.getDate(request, "dateofassessment", dateformat));
		biobankpanelassessment.setBackground1_1(ParamUtil.getString(request, "background1_1"));
		biobankpanelassessment.setBackground1_1_comments(ParamUtil.getString(request, "background1_1_comments"));
		biobankpanelassessment.setElsi1_2(ParamUtil.getString(request, "elsi1_2"));
		biobankpanelassessment.setQuality1_3(ParamUtil.getString(request, "quality1_3"));
		biobankpanelassessment.setQuality1_3_comments(ParamUtil.getString(request, "quality1_3_comments"));
		biobankpanelassessment.setCataloguemeetpurposes2_1(ParamUtil.getString(request, "cataloguemeetpurposes2_1"));
		biobankpanelassessment.setAdequateitplatform2_2(ParamUtil.getString(request, "adequateitplatform2_2"));
		biobankpanelassessment.setAddedvaluecatalogue2_3(ParamUtil.getString(request, "addedvaluecatalogue2_3"));
		biobankpanelassessment.setAssociateddata2_4(ParamUtil.getString(request, "associateddata2_4"));
		biobankpanelassessment.setAssociateddata2_4_comments(ParamUtil.getString(request, "associateddata2_4_comments"));
		biobankpanelassessment.setReasonstoaccept3_1(ParamUtil.getString(request, "reasonstoaccept3_1"));
		biobankpanelassessment.setRecommendation3_2(ParamUtil.getString(request, "recommendation3_2"));
		biobankpanelassessment.setNeedadditionalinformation3_3(ParamUtil.getString(request, "needadditionalinformation3_3"));
		biobankpanelassessment.setFinalrecommendation_4(ParamUtil.getString(request, "finalrecommendation_4"));
		return biobankpanelassessment;
	}
}