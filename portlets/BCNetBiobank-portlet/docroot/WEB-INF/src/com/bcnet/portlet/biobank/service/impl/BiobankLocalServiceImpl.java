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

package com.bcnet.portlet.biobank.service.impl;

import java.util.List;

import com.bcnet.portlet.biobank.model.Biobank;
import com.bcnet.portlet.biobank.service.base.BiobankLocalServiceBaseImpl;
import com.bcnet.portlet.biobank.service.persistence.BiobankFinderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the biobank local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bcnet.portlet.biobank.service.BiobankLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.base.BiobankLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.BiobankLocalServiceUtil
 */
public class BiobankLocalServiceImpl extends BiobankLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bcnet.portlet.biobank.service.BiobankLocalServiceUtil} to access the biobank local service.
	 */
	
	public Biobank addBiobank(
			String biobankId, String acronym, String name, String url, long juristicPersonId,
			String countryCode, String description,	boolean backup, boolean trainingCourses) 
					throws SystemException, PortalException{
		
		long biobankDbId = counterLocalService.increment(Biobank.class.getName());
		
		Biobank biobank = biobankPersistence.create(biobankDbId);
		
		biobank.setBiobankId(biobankId);
		biobank.setAcronym(acronym);
		biobank.setName(name);
		biobank.setUrl(url);
		biobank.setJuristicPersonId(juristicPersonId);
		biobank.setCountryCode(countryCode);
		biobank.setDescription(description);
		biobank.setBackup(backup);
		biobank.setTrainingCourses(trainingCourses);
		
		super.addBiobank(biobank);
		
		return biobank;
		
	}
	
	public Biobank deleteBiobank(Biobank biobank) throws SystemException{

		return biobankPersistence.remove(biobank);
	}

	public Biobank deleteBiobank(long biobankDbId) throws PortalException, SystemException{
		
		Biobank biobank = biobankPersistence.findByPrimaryKey(biobankDbId);
		return deleteBiobank(biobank);
	}
	
	public Biobank getBiobank(long biobankDbId) throws PortalException, SystemException{

		return biobankPersistence.findByPrimaryKey(biobankDbId);
	}
	
	public List<Biobank> getAllBiobanks() throws SystemException{

		return biobankPersistence.findAll();
	}
	
	public List<Biobank> getAllBiobanks(int start, int end) throws SystemException{

		return biobankPersistence.findAll(start, end);
	}
	
	public Biobank updateBiobank(long biobankDbId, String biobankId, String acronym, String name,
			String url, long juristicPersonId, String countryCode,
			String description,	boolean backup, boolean trainingCourses)
			throws PortalException, SystemException{
				
		Biobank biobank = biobankPersistence.findByPrimaryKey(biobankDbId);
		
		biobank.setBiobankId(biobankId);
		biobank.setAcronym(acronym);
		biobank.setName(name);
		biobank.setUrl(url);
		biobank.setJuristicPersonId(juristicPersonId);
		biobank.setCountryCode(countryCode);
		biobank.setDescription(description);
		biobank.setBackup(backup);
		biobank.setTrainingCourses(trainingCourses);
		
		super.updateBiobank(biobank);
		
		return biobank;
		
	}
	
	public List<Biobank> findBiobanksByIdentity(String biobankId, String acronym, String name, String countryCode, int begin, int end){
		
		return BiobankFinderUtil.findByCodeAcronymNameCountry(biobankId, acronym, name, countryCode, begin, end);
	}
	
	public int findBiobanksCountByIdentity(String biobankId, String acronym, String name, String countryCode){
		
		return BiobankFinderUtil.countByCodeAcronymNameCountry(biobankId, acronym, name, countryCode);
	}
}