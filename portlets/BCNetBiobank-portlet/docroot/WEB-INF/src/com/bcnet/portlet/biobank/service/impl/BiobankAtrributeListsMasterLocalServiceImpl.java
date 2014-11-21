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

import com.bcnet.portlet.biobank.model.BiobankAtrributeListsMaster;
import com.bcnet.portlet.biobank.service.BiobankAtrributeListsMasterLocalServiceUtil;
import com.bcnet.portlet.biobank.service.base.BiobankAtrributeListsMasterLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the biobank atrribute lists master local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bcnet.portlet.biobank.service.BiobankAtrributeListsMasterLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.base.BiobankAtrributeListsMasterLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.BiobankAtrributeListsMasterLocalServiceUtil
 */
public class BiobankAtrributeListsMasterLocalServiceImpl
	extends BiobankAtrributeListsMasterLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bcnet.portlet.biobank.service.BiobankAtrributeListsMasterLocalServiceUtil} to access the biobank atrribute lists master local service.
	 */
	
	public BiobankAtrributeListsMaster addBiobankAttributeListsMaster(String attributeListName,
			String attributeListValue) throws SystemException{
		
		long biobankAttributeListsMasterId = 
				counterLocalService.increment(BiobankAtrributeListsMaster.class.getName());
		
		BiobankAtrributeListsMaster biobankAttributeListsMaster = 
				biobankAtrributeListsMasterPersistence.create(biobankAttributeListsMasterId);
		
		biobankAttributeListsMaster.setAttributeListName(attributeListName);
		biobankAttributeListsMaster.setAttributeListValue(attributeListValue);
		
		super.addBiobankAtrributeListsMaster(biobankAttributeListsMaster);
		
		return biobankAttributeListsMaster;
	
	}
	
	public BiobankAtrributeListsMaster deleteBiobankAttributeListsMaster(BiobankAtrributeListsMaster
			biobankAtrributeListsMaster) throws SystemException{
		
		return biobankAtrributeListsMasterPersistence.remove(biobankAtrributeListsMaster);
	}
	
	public BiobankAtrributeListsMaster deleteBiobankAttributeListsMaster(long
			biobankAtrributeListsMasterId) throws PortalException, SystemException{
		
		BiobankAtrributeListsMaster biobankAtrributeListsMaster = biobankAtrributeListsMasterPersistence.
				findByPrimaryKey(biobankAtrributeListsMasterId);
		
		return deleteBiobankAtrributeListsMaster(biobankAtrributeListsMaster);
	}
	
	public BiobankAtrributeListsMaster getBiobankAttributeListsMaster(long
			biobankAtrributeListsMasterId) throws PortalException, SystemException{
		
		return biobankAtrributeListsMasterPersistence.findByPrimaryKey(biobankAtrributeListsMasterId);
	}
	
	public List<BiobankAtrributeListsMaster> getAllBiobankAtrributeListsMasters() throws SystemException{
		
		return biobankAtrributeListsMasterPersistence.findAll();
	}
	
	public List<BiobankAtrributeListsMaster> getAllBiobankAtrributeListsMasters(int start, int end)
			throws SystemException{
		
		return biobankAtrributeListsMasterPersistence.findAll(start, end);
	}
	
	public List<BiobankAtrributeListsMaster> getBiobankAtrributeListsMasterByAttributeListName(String attributeListName)
			throws SystemException{
		
		return biobankAtrributeListsMasterPersistence.findByattribute(attributeListName);
	}
	
	public BiobankAtrributeListsMaster updateBiobankAttributeListsMaster(long biobankAttributeListsMasterId, 
			String attributeListName, String attributeListValue) throws SystemException{
	
		BiobankAtrributeListsMaster biobankAttributeListsMaster = BiobankAtrributeListsMasterLocalServiceUtil.
				fetchBiobankAtrributeListsMaster(biobankAttributeListsMasterId);
		
		biobankAttributeListsMaster.setAttributeListName(attributeListName);
		biobankAttributeListsMaster.setAttributeListValue(attributeListValue);
		
		super.updateBiobankAtrributeListsMaster(biobankAttributeListsMaster);
		
		return biobankAttributeListsMaster;
	}
}