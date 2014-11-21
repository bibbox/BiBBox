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

package com.bcnet.portlet.biobank.model.impl;

import java.util.List;

import com.bcnet.portlet.biobank.model.BiobankAttributeLists;
import com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

/**
 * The extended model implementation for the BiobankGeneralInformation service. Represents a row in the &quot;biobank&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bcnet.portlet.biobank.model.BiobankGeneralInformation} interface.
 * </p>
 *
 * @author suyama
 */
public class BiobankGeneralInformationImpl
	extends BiobankGeneralInformationBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a biobank general information model instance should use the {@link com.bcnet.portlet.biobank.model.BiobankGeneralInformation} interface instead.
	 */
	public BiobankGeneralInformationImpl() {
	}
	
	
	
	public String getBiobankName(){
		try {
			return OrganizationLocalServiceUtil.getOrganization(this.getBiobankDbId()).getName();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<BiobankAttributeLists> getBiobankAttributeLists(){
		
		try {
			return BiobankAttributeListsLocalServiceUtil.getBiobankAtrributeListsByBiobankDbId(this.getBiobankDbId());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}