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

import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

import at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix;
import at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.service.base.DiseaseMatrixServiceBaseImpl;

/**
 * The implementation of the disease matrix remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.base.DiseaseMatrixServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixServiceUtil
 */
public class DiseaseMatrixServiceImpl extends DiseaseMatrixServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixServiceUtil} to access the disease matrix remote service.
	 */
	@JSONWebService(value = "testupdatediseasematrix", method = "POST")
	public JSONObject testupdatediseasematrix(long organizationId) {
		System.out.println("public JSONObject testupdatediseasematrix(long organizationId) {");
		System.out.println("-testupdatediseasematrix-3-" + organizationId + "  -  ");
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("version", "0.2");
		return json;
	}
	
	@JSONWebService(value = "updatediseasematrix", method = "POST")
	public DiseaseMatrix updatediseasematrix(long organizationId, DiseaseMatrix matrix) {
		System.out.println("public DiseaseMatrix updatediseasematrix(long organizationId, DiseaseMatrix matrix) {");
		System.out.println("-updateRegbb2-3-" + organizationId + "  -  ");
		if(matrix != null) {
			System.out.println("Matrix != null:: Size ");
		} else {
			System.out.println("Matrix == null");
		}
		try {
			return DiseaseMatrixLocalServiceUtil.getDiseaseMatrix(101);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("diseasename", "0.3");
		return null;
	}
	
	@JSONWebService(value = "updatediseasematrixs", method = "POST")
	public void updatediseasematrixs(long organizationId, List<DiseaseMatrix> matrixs) {
		System.out.println("public void updatediseasematrixs(long organizationId, List<DiseaseMatrix> matrixs) {");
		System.out.println("-updateRegbb2-3-" + organizationId + "  -  ");
		if(matrixs != null) {
			System.out.println("Matrix != null:: Size " + matrixs.size());
		} else {
			System.out.println("Matrix == null");
		}
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("version", "0.1");
	}
	
	public JSONObject regbb(long organizationId) {
		System.out.println("public JSONObject regbb(long organizationId) {");
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("ID", organizationId);
		return json;
	}
	
	public DiseaseMatrix getDiseaseMatrix(long organizationId) {
		System.out.println("public DiseaseMatrix getDiseaseMatrix(long organizationId) {");
		try {
			return DiseaseMatrixLocalServiceUtil.getDiseaseMatrix(101);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}