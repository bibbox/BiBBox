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
 * The extended model implementation for the D2Collection service. Represents a row in the &quot;bbmrieric.d2collection&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.bbmrieric.model.D2Collection} interface.
 * </p>
 *
 * @author reihsr
 */
public class D2CollectionImpl extends D2CollectionBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a d2 collection model instance should use the {@link at.meduni.liferay.portlet.bbmrieric.model.D2Collection} interface instead.
	 */
	public D2CollectionImpl() {
	}
	
	public ContactInformation getContactInformation() {
		return ContactInformationLocalServiceUtil.getContactInformationWithLdapUpdate(this.getContactIDRef());
	}
	
	public List<D2Collection> getChildD2Collection() {
		return D2CollectionLocalServiceUtil.getChildD2Collection(this.getBiobankId(), this.getD2collectionId());
	}
	
	public String getChildD2CollectionAuiTreeStructure() {
		String returnvalue = "";
		List<D2Collection> childes = getChildD2Collection();
		for(D2Collection child : childes) {
			if(returnvalue.equals("")) {
				returnvalue = "children: [{";
			} else {
				returnvalue += "},{";
			}
			returnvalue += child.getChildD2CollectionAuiTreeStructure() + "label: '<span id=\"" + child.getBbmricollectionID() + "\">" + child.getCollectionName() + "</span>'";
		}
		if(!returnvalue.equals("")) {
			returnvalue += "}],";
		}
		return returnvalue;
	}
	
	public String getCollectionTypeHTML() {
		String returnstring = "";
		String splitter = "";
		if(this.getCollectionTypeCaseControl()) {
			returnstring += splitter + "Case Control";
			splitter = ", ";
		}
		if(this.getCollectionTypeCohort()) {
			returnstring += splitter + "Cohort";
			splitter = ", ";
		}
		if(this.getCollectionTypeCrossSectional()) {
			returnstring += splitter + "Cross Sectional";
			splitter = ", ";
		}
		if(this.getCollectionTypeLongitudinal()) {
			returnstring += splitter + "Longitudinal";
			splitter = ", ";
		}
		if(this.getCollectionTypeTwinStudy()) {
			returnstring += splitter + "Twin Study";
			splitter = ", ";
		}
		if(this.getCollectionTypeQualityControl()) {
			returnstring += splitter + "Quality Control";
			splitter = ", ";
		}
		if(this.getCollectionTypePopulationBased()) {
			returnstring += splitter + "Population Based";
			splitter = ", ";
		}
		if(this.getCollectionTypeDiseaseSpecific()) {
			returnstring += splitter + "Disease Specific";
			splitter = ", ";
		}
		if(this.getCollectionTypeBirthCohort()) {
			returnstring += splitter + "Birth Cohort";
			splitter = ", ";
		}
		
		if(!this.getCollectionTypeOther().equals("")) {
			returnstring += splitter + this.getCollectionTypeOther().replaceAll("FALSE", "").replaceAll("TRUE", "");
		}
		return returnstring;
	}
	
	public String getCollectionTemeratureHTML() {
		String returnstring = "";
		String splitter = "";
		if(this.getTemperatureRoom()) {
			returnstring += splitter + "Room Temperature";
			splitter = ", ";
		}
		if(this.getTemperature2to10()) {
			returnstring += splitter + "-2 to -10";
			splitter = ", ";
		}
		if(this.getTemperature18to35()) {
			returnstring += splitter + "-18 to -35";
			splitter = ", ";
		}
		if(this.getTemperature60to85()) {
			returnstring += splitter + "-60 to -85";
			splitter = ", ";
		}
		if(this.getTemperatureLN()) {
			returnstring += splitter + "Liquid Nitrogen";
			splitter = ", ";
		}
		if(this.getTemperatureOther().equals("")) {
			returnstring += splitter + this.getTemperatureOther().replaceAll("FALSE", "").replaceAll("TRUE", "");
		}
		return returnstring;
	}
	
	public String getCollectionDataAvailableHTML() {
		String returnstring = "";
		String splitter = "";
		if(this.getCollectionAvailableBiologicalSamples()) {
			returnstring += splitter + "Biological Samples";
			splitter = ", ";
		}
		if(this.getCollectionAvailableSurveyData()) {
			returnstring += splitter + "Survey Data";
			splitter = ", ";
		}
		if(this.getCollectionAvailableImagingData()) {
			returnstring += splitter + "Imaging Data";
			splitter = ", ";
		}
		if(this.getCollectionAvailableMedicalRecords()) {
			returnstring += splitter + "Medical Records";
			splitter = ", ";
		}
		if(this.getCollectionAvailableNationalRegistries()) {
			returnstring += splitter + "National Registries";
			splitter = ", ";
		}
		if(this.getCollectionAvailableGenealogicalRecords()) {
			returnstring += splitter + "Genealogical Records";
			splitter = ", ";
		}
		if(this.getCollectionAvailablePhysioBiochemMeasurements()) {
			returnstring += splitter + "Physio Biochem Measurements";
			splitter = ", ";
		}
		if(this.getCollectionAvailableOther().equals("")) {
			returnstring += splitter + this.getCollectionAvailableOther().replaceAll("FALSE", "").replaceAll("TRUE", "");
		}
		return returnstring;
	}
	
	public String getCollectionMaterialTypeHTML() {
		String returnstring = "";
		String splitter = "";
		if(this.getMaterialStoredDNA()) {
			returnstring += splitter + "DNA";
			splitter = ", ";
		}
		if(this.getMaterialStoredPlasma()) {
			returnstring += splitter + "Plasma";
			splitter = ", ";
		}
		if(this.getMaterialStoredSerum()) {
			returnstring += splitter + "Serum";
			splitter = ", ";
		}
		if(this.getMaterialStoredUrine()) {
			returnstring += splitter + "Urine";
			splitter = ", ";
		}
		if(this.getMaterialStoredSaliva()) {
			returnstring += splitter + "Saliva";
			splitter = ", ";
		}
		if(this.getMaterialStoredFaeces()) {
			returnstring += splitter + "Faeces";
			splitter = ", ";
		}
		if(this.getMaterialStoredRNA()) {
			returnstring += splitter + "RNA";
			splitter = ", ";
		}
		if(this.getMaterialStoredBlood()) {
			returnstring += splitter + "Blood";
			splitter = ", ";
		}
		if(this.getMaterialStoredTissueFrozen()) {
			returnstring += splitter + "Tissue Frozen";
			splitter = ", ";
		}
		if(this.getMaterialStoredTissueFFPE()) {
			returnstring += splitter + "Tissue FFPE";
			splitter = ", ";
		}
		if(this.getMaterialStoredImmortalizedCellLines()) {
			returnstring += splitter + "Immortalized Cell Lines";
			splitter = ", ";
		}
		if(this.getMaterialStoredIsolatedPathogen()) {
			returnstring += splitter + "Isolated Pathogen";
			splitter = ", ";
		}
				
		if(this.getMaterialStoredOther().equals("")) {
			returnstring += splitter + this.getMaterialStoredOther().replaceAll("FALSE", "").replaceAll("TRUE", "");
		}
		return returnstring;
	}
}