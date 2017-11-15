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

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;

/**
 * The extended model implementation for the GeneralInformation service. Represents a row in the &quot;rdconnect.generalgnformation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation} interface.
 * </p>
 *
 * @author reihsr
 */
public class GeneralInformationImpl extends GeneralInformationBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a general information model instance should use the {@link at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation} interface instead.
	 */
	public GeneralInformationImpl() {
	}
	
	public String getBiomaterialcollectedinbiobankFormated() {
		if(this.getBiomaterialcollectedinbiobank() != null) {
			if(this.getBiomaterialcollectedinbiobank().equals("")) {
				return "";
			} else {
				return formatBiomaterialCollectedInBiobank();
			}
		} else {
			return "";
		}
	}
	
	private String formatBiomaterialCollectedInBiobank() {
		String return_string = "Biomaterial available in this Biobanks: <br>";
		List<Organization> organizations = getOrganizationList(this.getBiomaterialcollectedinbiobank());
		for(Organization organization : organizations) {
			return_string += createOrganizationIcon(organization);
		}
		return return_string;
	}
	
	private List<Organization> getOrganizationList(String organizationIds) {
		List<Organization> organizations = new ArrayList<Organization>();
		for(String id : organizationIds.split(";")) {
			try {
				long organizationId = Long.valueOf(id);
				organizations.add(OrganizationLocalServiceUtil.getOrganization(organizationId));
			} catch(Exception ex) {
				System.err.println("Error reading Organization with id: " + id);
				ex.printStackTrace();
			}
		}
		return organizations;
	}
	
	private String createOrganizationIcon(Organization organization) {
		
		String imgPath = "/image/layout_set_logo?img_id="+organization.getLogoId();
		String orgPath = "/web"+organization.getGroup().getFriendlyURL();
		String organizationtype = organization.getExpandoBridge().getAttribute("Organization Type").toString();
		if(organizationtype.equalsIgnoreCase("Biobank")) {
			if(organization.getLogoId() == 0) {
				imgPath = "/BiBBoxCommonServices-portlet/images/Biobank.png";
			}
			orgPath = orgPath + "/bb_home";	
		} else {
			if(organization.getLogoId() == 0) {
				imgPath = "/BiBBoxCommonServices-portlet/images/Registry.png";
			}
			orgPath = orgPath + "/reg_home";
		}
		// Table 590 breite
		String table = "<table style=\"width:590px\"><tr><td>";
		table += "<td width=\"80px\"><a href=\"" + orgPath + "\"><img alt=\"logo\" src=\"" + imgPath + "\" width=\"60px\" /></a></td>";
		table += "<td width=\"500px\"><a href=\"" + orgPath + "\">" + organization.getName() + "</a></td></tr></table>";
		return table;
	}
}