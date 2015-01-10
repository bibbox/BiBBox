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

import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;

import at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.service.base.DiseaseMatrixLocalServiceBaseImpl;

/**
 * The implementation of the disease matrix local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.base.DiseaseMatrixLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalServiceUtil
 */
public class DiseaseMatrixLocalServiceImpl
	extends DiseaseMatrixLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalServiceUtil} to access the disease matrix local service.
	 */
	public List<DiseaseMatrix> getDiseaseMatrixs(long organizationID, int begin, int end) throws SystemException {
		return diseaseMatrixPersistence.findByOrganizationFinder(organizationID, begin, end);
	}
	
	public int getDiseaseMatrixsCount(long organizationID) throws SystemException {
		return diseaseMatrixPersistence.countByOrganizationFinder(organizationID);
	}
	
	/**
	 * Convenience method to create a DiseaseMatrix object out of the request. Used
	 * by the Add / Edit methods.
	 *
	 */
	public DiseaseMatrix diseaseMatrixFromRequest(PortletRequest request) {
		DiseaseMatrixImpl diseasematrix = new DiseaseMatrixImpl();
		diseasematrix.setDiseasematrixId(ParamUtil.getLong(request, "diseasematrixId"));
		diseasematrix.setOrganizationId(ParamUtil.getLong(request, "organizationId"));
		diseasematrix.setDiseasename(ParamUtil.getString(request, "diseasename"));
		diseasematrix.setPatientcount(ParamUtil.getString(request, "patientcount"));
		diseasematrix.setGene(ParamUtil.getString(request, "gene"));
		diseasematrix.setOrphanumber(ParamUtil.getString(request, "orphanumber"));
		diseasematrix.setIcd10(ParamUtil.getString(request, "icd10"));
		diseasematrix.setOmim(ParamUtil.getString(request, "omim"));
		diseasematrix.setSynonym(ParamUtil.getString(request, "synonym"));
		diseasematrix.setModifieddate(new Date());
		return diseasematrix;
	}
	
	/**
	 * Adds the DiseaseMatrix to the database incrementing the primary key
	 *
	 */
	public DiseaseMatrix addDiseaseMatrix(DiseaseMatrix diseasematrix) throws SystemException {
		long diseasematrixId = CounterLocalServiceUtil.increment(DiseaseMatrix.class.getName());

		diseasematrix.setDiseasematrixId(diseasematrixId);

		return super.addDiseaseMatrix(diseasematrix);
	}
}
