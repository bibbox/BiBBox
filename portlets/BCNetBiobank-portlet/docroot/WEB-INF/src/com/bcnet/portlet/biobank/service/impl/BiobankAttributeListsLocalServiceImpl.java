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

import com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException;
import com.bcnet.portlet.biobank.model.BiobankAttributeLists;
import com.bcnet.portlet.biobank.service.base.BiobankAttributeListsLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the biobank attribute lists local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.base.BiobankAttributeListsLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalServiceUtil
 */
public class BiobankAttributeListsLocalServiceImpl
	extends BiobankAttributeListsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalServiceUtil} to access the biobank attribute lists local service.
	 */
	
	public BiobankAttributeLists addBiobankAttributeLists(long biobankDbId, String attributeListName,
			String attributeListValue) throws SystemException{
		
		long biobankAttributeListsId = 
				counterLocalService.increment(BiobankAttributeLists.class.getName());
		
		BiobankAttributeLists biobankAttributeLists = 
				biobankAttributeListsPersistence.create(biobankAttributeListsId);
		
		biobankAttributeLists.setBiobankDbId(biobankDbId);
		biobankAttributeLists.setAttributeListName(attributeListName);
		biobankAttributeLists.setAttributeListValue(attributeListValue);
		
		super.addBiobankAttributeLists(biobankAttributeLists);
		
		return biobankAttributeLists;
	}
	
	
	public List<BiobankAttributeLists> getBiobankAtrributeListsByBiobankDbId(long biobankDbId)
		throws SystemException{
	
		return biobankAttributeListsPersistence.findBybiobankDbId(biobankDbId);
	}
	
	
	public List<BiobankAttributeLists> getBiobankAtrributeListsByBiobankDbId_AttributeListName
		(long biobankDbId, String attributeListName)
			throws SystemException{
		
		return biobankAttributeListsPersistence.findBybiobankDbId_attributeListName(biobankDbId, attributeListName);
	}
	
	
	public BiobankAttributeLists getBiobankAtrributeListsByBiobankDbId_AttributeListName_AttributeListValue
		(long biobankDbId, String attributeListName, String attributeListValue) throws SystemException{

		try {
			return biobankAttributeListsPersistence.
					findBybiobankDbId_attributeListName_attributeListValue(biobankDbId, attributeListName, attributeListValue);
		} catch (NoSuchBiobankAttributeListsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public BiobankAttributeLists deleteBiobankAttributeLists(long biobankDbId, String attributeListName, String attributeListValue) throws SystemException{
		
		BiobankAttributeLists biobankAttributeLists = 
				getBiobankAtrributeListsByBiobankDbId_AttributeListName_AttributeListValue(biobankDbId, attributeListName, attributeListValue);
		
		return biobankAttributeListsPersistence.remove(biobankAttributeLists);
	}
}