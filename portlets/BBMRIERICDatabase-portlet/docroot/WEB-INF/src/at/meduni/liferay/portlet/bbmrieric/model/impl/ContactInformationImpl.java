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

package at.meduni.liferay.portlet.bbmrieric.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.CountryServiceUtil;

/**
 * The extended model implementation for the ContactInformation service. Represents a row in the &quot;bbmrieric.contactinformation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.bbmrieric.model.ContactInformation} interface.
 * </p>
 *
 * @author reihsr
 */
public class ContactInformationImpl extends ContactInformationBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a contact information model instance should use the {@link at.meduni.liferay.portlet.bbmrieric.model.ContactInformation} interface instead.
	 */
	public ContactInformationImpl() {
	}
	
	public String getHtmlAddress() {
		String return_value = "";
		if(!this.getContactAddress().equals("")) {
			return_value = this.getContactAddress();
		}
		if(!this.getContactZIP().equals("")) {
			if(!return_value.equals("")) {
				return_value += "<br>" + this.getContactZIP();
			} else {
				return_value += this.getContactZIP();
			}
			if(!this.getContactCity().equals("")) {
				return_value += "&nbsp;" + this.getContactCity();
			}
		} else {
			if(!this.getContactCity().equals("")) {
				return_value += "<br>" + this.getContactCity();
			}
		}
		if(!this.getContactCountry().equals("")) {
			String country = "";
			try {
				country = CountryServiceUtil.getCountryByA2(this.getContactCountry()).getName();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!return_value.equals("")) {
				return_value += "<br>" + country;
			} else {
				return_value = country;
			}
			
		}
		return return_value;
	}
}