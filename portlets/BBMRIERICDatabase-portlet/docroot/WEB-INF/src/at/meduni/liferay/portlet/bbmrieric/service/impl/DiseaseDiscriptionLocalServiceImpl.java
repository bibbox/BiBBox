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

package at.meduni.liferay.portlet.bbmrieric.service.impl;

import java.util.List;

import at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription;
import at.meduni.liferay.portlet.bbmrieric.service.base.DiseaseDiscriptionLocalServiceBaseImpl;

/**
 * The implementation of the disease discription local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.bbmrieric.service.DiseaseDiscriptionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.meduni.liferay.portlet.bbmrieric.service.base.DiseaseDiscriptionLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.bbmrieric.service.DiseaseDiscriptionLocalServiceUtil
 */
public class DiseaseDiscriptionLocalServiceImpl
	extends DiseaseDiscriptionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.meduni.liferay.portlet.bbmrieric.service.DiseaseDiscriptionLocalServiceUtil} to access the disease discription local service.
	 */
	public List<DiseaseDiscription> getRootEntrys() {
		try {
			return diseaseDiscriptionPersistence.findByRoot(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public List<DiseaseDiscription> getDiseaseDiscriptionByGroup(String diseasegroup) {
		try {
			return diseaseDiscriptionPersistence.findByDiseaseGroup(diseasegroup);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}