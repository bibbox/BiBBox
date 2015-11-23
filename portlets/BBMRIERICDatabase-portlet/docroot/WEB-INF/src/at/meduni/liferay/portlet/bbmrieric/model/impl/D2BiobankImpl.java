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

import java.util.List;

import at.meduni.liferay.portlet.bbmrieric.model.ContactInformation;
import at.meduni.liferay.portlet.bbmrieric.model.D2Collection;
import at.meduni.liferay.portlet.bbmrieric.service.ContactInformationLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2CollectionLocalServiceUtil;

/**
 * The extended model implementation for the D2Biobank service. Represents a row in the &quot;bbmrieric.d2biobank&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.bbmrieric.model.D2Biobank} interface.
 * </p>
 *
 * @author reihsr
 */
public class D2BiobankImpl extends D2BiobankBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a d2 biobank model instance should use the {@link at.meduni.liferay.portlet.bbmrieric.model.D2Biobank} interface instead.
	 */
	public D2BiobankImpl() {
	}
	
	/**
	 * 
	 */
	public ContactInformation getContactInformation() {
		return ContactInformationLocalServiceUtil.getContactInformationWithLdapUpdate(this.getContactIDRef());
	}
	
	/**
	 * 
	 */
	public List<D2Collection> getCollections() {
		return D2CollectionLocalServiceUtil.getD2CollectionByBiobankId(this.getBiobankId());
	}
	
	public List<D2Collection> getRootCollections() {
		return D2CollectionLocalServiceUtil.getRootD2Collection(this.getBiobankId());
	}
	
	/**
	 * 
	 */
	public int getCollectionsCount() {
		return D2CollectionLocalServiceUtil.getD2CollectionByBiobankIdCount(this.getBiobankId());
	}
	
	/**
	 * 
	 * @return
	 */
	public String getBiobankJavascriptTable() {
		String return_value = "{";
		
		return_value += "Country: '" + this.getBiobankCountry().replaceAll("'", "\\\\'") + "',";
		//BB ID
		return_value += "'BB_ID': " + this.getBiobankId() + ",";
		//Name
		return_value += "Name: '" + this.getBiobankName().replaceAll("'", "\\\\'") + "',";
		//Type
		return_value += "Type: '" + this.getBiobankType().replaceAll("'", "\\\\'").replaceAll(", biobankContact", "").replaceAll("biobankContact", "") + "',";
		//Number of Collections
		return_value += "CollectionsCount: '" + this.getCollectionsCount() + "',";
		//Size & Collection List
		long size = 0;
		String collectionlist = "";
		String collectionlistsplitter = "";
		String diagnosis = "";
		String diagnosis_splitter = "";
		List<D2Collection> collections = this.getCollections();
		for(D2Collection collection : collections) {
			size += Math.pow(10, collection.getCollectionOrderOfMagnitude());
			collectionlist += collectionlistsplitter + "<b>" + collection.getCollectionName() + ":<br>";
			collectionlist += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; >10<sup>" + collection.getCollectionOrderOfMagnitude() + "</sup></b>&nbsp;&nbsp;#&nbsp;&nbsp;";
			if(collection.getCollectionSize() != 0) {
				collectionlist += collection.getCollectionSize();
			} else {
				collectionlist += collectionSizeFromOrderOfMagnitude(collection.getCollectionOrderOfMagnitude());
			}
			collection.getCollectionOrderOfMagnitude();
			String[] temps = collection.getDiagnosisAvailable().replaceAll("urn:miriam:", "").replaceAll(" ,", ",").split(",");
			for(String temp : temps) {
				if(!diagnosis.contains(temp)) {
					diagnosis += diagnosis_splitter + temp;
					diagnosis_splitter = ", ";
				}
				
			}
			collectionlistsplitter = "<br><hr><br>";
		}
		return_value += "Size: " + size + ",";
		return_value += "CollectionList: '" + collectionlist.replaceAll("'", "\\\\'") + "',";
		//BB Diagnosis
		return_value += "'Diagnosis': '" + diagnosis.replaceAll("'", "\\\\'") + "',";
		//Juristic Person
		return_value += "'Juristic Person': '" + this.getBiobankJurisdicalPerson().replaceAll("'", "\\\\'") + "'";
		
		return return_value + "}";
	}
	
	/**
	 * 
	 * @param orderofmagnitude
	 * @return
	 */
	private String collectionSizeFromOrderOfMagnitude(long orderofmagnitude) {
		String returnvalue = "";
		switch((int)orderofmagnitude) {
			case 0:
				returnvalue += "< 10";
				break;
			case 1:
				returnvalue += "10 - 100";
				break;
			case 2:
				returnvalue += "100 - 1.000";
				break;
			case 3:
				returnvalue += "1.000 - 10.000";
				break;
			case 4:
				returnvalue += "10.000 - 100.000";
				break;
			case 5:
				returnvalue += "100.000 - 1.000.000";
				break;
			case 6:
				returnvalue += "1.000.000 - 10.000.000";
				break;
			case 7:
				returnvalue += "10.000.000 - 100.000.000";
				break;
			case 8:
				returnvalue += "100.000.000 - 1.000.000.000";
				break;
			default:
				returnvalue += "NA";
				break;
		}
		return returnvalue;
	}
}