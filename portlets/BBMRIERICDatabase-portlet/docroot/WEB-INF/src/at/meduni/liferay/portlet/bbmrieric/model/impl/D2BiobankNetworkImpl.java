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

import java.util.ArrayList;
import java.util.List;

import at.meduni.liferay.portlet.bbmrieric.model.ContactInformation;
import at.meduni.liferay.portlet.bbmrieric.model.D2Biobank;
import at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork;
import at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetworkLink;
import at.meduni.liferay.portlet.bbmrieric.model.D2Collection;
import at.meduni.liferay.portlet.bbmrieric.service.ContactInformationLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLinkLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2CollectionLocalServiceUtil;

/**
 * The extended model implementation for the D2BiobankNetwork service. Represents a row in the &quot;bbmrieric.d2biobanknetwork&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork} interface.
 * </p>
 *
 * @author reihsr
 */
public class D2BiobankNetworkImpl extends D2BiobankNetworkBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a d2 biobank network model instance should use the {@link at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork} interface instead.
	 */
	public D2BiobankNetworkImpl() {
	}
	
	public ContactInformation getContactInformation() {
		return ContactInformationLocalServiceUtil.getContactInformationWithLdapUpdate(this.getContactIDRef());
	}
	
	public List<D2BiobankNetwork> getAssosiatedNetworks() {
		List<D2BiobankNetwork> networks = new ArrayList<D2BiobankNetwork>();
		List<D2BiobankNetworkLink> networklinks = D2BiobankNetworkLinkLocalServiceUtil.getChildForNetworkLinks(this.getD2biobanknetworkId(), "D2BiobankNetwork");
		for(D2BiobankNetworkLink networklink : networklinks) {
			try {
				networks.add(D2BiobankNetworkLocalServiceUtil.getD2BiobankNetwork(networklink.getD2linkId()));
			} catch(Exception ex) {
				
			}
		}
		return networks;
	}
	
	public List<D2Biobank> getAssosiatedBiobanks() {
		List<D2Biobank> networks = new ArrayList<D2Biobank>();
		List<D2BiobankNetworkLink> networklinks = D2BiobankNetworkLinkLocalServiceUtil.getChildForNetworkLinks(this.getD2biobanknetworkId(), "D2Biobank");
		for(D2BiobankNetworkLink networklink : networklinks) {
			try {
				networks.add(D2BiobankLocalServiceUtil.getD2Biobank(networklink.getD2linkId()));
			} catch(Exception ex) {
				
			}
		}
		return networks;
	}
	
	public List<D2Collection> getAssosiatedCollections() {
		List<D2Collection> networks = new ArrayList<D2Collection>();
		List<D2BiobankNetworkLink> networklinks = D2BiobankNetworkLinkLocalServiceUtil.getChildForNetworkLinks(this.getD2biobanknetworkId(), "D2Collection");
		for(D2BiobankNetworkLink networklink : networklinks) {
			try {
				networks.add(D2CollectionLocalServiceUtil.getD2Collection(networklink.getD2linkId()));
			} catch(Exception ex) {
				
			}
		}
		return networks;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getBiobankNetworkJavascriptTable() {
		String return_value = "{";
		//BB ID
		return_value += "'BB_ID': '" + this.getD2biobanknetworkId() + "',";
		//Name
		return_value += "Name: '" + this.getBiobankNetworkName().replaceAll("'", "\\\\'") + "',";
		//Juristic Person
		return_value += "'Juristic Person': '" + this.getBiobankNetworkJuridicalPerson().replaceAll("'", "\\\\'") + "',";
		// Number of Networks
		return_value += "'Numberofnetworks': '" + this.getAssosiatedNetworks().size() + "',";
		// Number of Biobanks
		return_value += "'Numberofbiobanks': '" + this.getAssosiatedBiobanks().size() + "',";
		// Number of Collections
		return_value += "'Numberofcollections': '" + this.getAssosiatedCollections().size() + "',";
		// Collection Focus
		return_value += "'Collection Focus': '" + String.valueOf(this.getBiobankNetworkCommonCollectionFocus()).replaceAll("true", "yes").replaceAll("false", "no") + "',";
		// Charter
		return_value += "'Charter': '" + String.valueOf(this.getBiobankNetworkCommonCharter()).replaceAll("true", "yes").replaceAll("false", "no") + "',";
		// SOP
		return_value += "'SOP': '" + String.valueOf(this.getBiobankNetworkCommonSOPs()).replaceAll("true", "yes").replaceAll("false", "no") + "',";
		// DataAccessPolicy
		return_value += "'Data Access Policy': '" + String.valueOf(this.getBiobankNetworkCommonDataAccessPolicy()).replaceAll("true", "yes").replaceAll("false", "no") + "',";
		// DataAccessPolicy
		return_value += "'Sample Access Policy': '" + String.valueOf(this.getBiobankNetworkCommonSampleAccessPolicy()).replaceAll("true", "yes").replaceAll("false", "no") + "',";
		// DataAccessPolicy
		return_value += "'MTA': '" + String.valueOf(this.getBiobankNetworkCommonMTA()).replaceAll("true", "yes").replaceAll("false", "no") + "'";
		return return_value + "}";
	}
}