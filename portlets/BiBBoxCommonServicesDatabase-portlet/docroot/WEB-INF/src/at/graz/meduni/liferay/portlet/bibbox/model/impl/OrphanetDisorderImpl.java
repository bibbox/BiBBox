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

package at.graz.meduni.liferay.portlet.bibbox.model.impl;

import java.util.List;

import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference;
import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym;
import at.graz.meduni.liferay.portlet.bibbox.service.OrphanetReferenceLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.OrphanetSynonymLocalServiceUtil;

/**
 * The extended model implementation for the OrphanetDisorder service. Represents a row in the &quot;ontologies.orphanetdisorder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder} interface.
 * </p>
 *
 * @author reihsr
 */
public class OrphanetDisorderImpl extends OrphanetDisorderBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a orphanet disorder model instance should use the {@link at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder} interface instead.
	 */
	public OrphanetDisorderImpl() {
	}
	
	public String getICD10() {
		String returnvalue = "";
		List<OrphanetReference> references = OrphanetReferenceLocalServiceUtil.getOrphanetReferenceByOrpahnetDisorderIdAndSource(this.getOrphanetdisorderId(), "ICD-10");
		if(references != null) {
			String splitter = "";
			for(OrphanetReference reference : references) {
				returnvalue += splitter + reference.getReference();
				splitter = ", ";
			}
		}
		return returnvalue;
	}
	
	public String getOMIM() {
		String returnvalue = "";
		List<OrphanetReference> references = OrphanetReferenceLocalServiceUtil.getOrphanetReferenceByOrpahnetDisorderIdAndSource(this.getOrphanetdisorderId(), "OMIM");
		if(references != null) {
			String splitter = "";
			for(OrphanetReference reference : references) {
				returnvalue += splitter + "#" + reference.getReference();
				splitter = ", ";
			}
		}
		return returnvalue;
	}
	
	public String getSynonym() {
		String returnvalue = "";
		List<OrphanetSynonym> synonyms = OrphanetSynonymLocalServiceUtil.getOrphanetSynonymByOrpahnetDisorderId(this.getOrphanetdisorderId());
		if(synonyms != null) {
			String splitter = "";
			for(OrphanetSynonym synonym : synonyms) {
				returnvalue += splitter + synonym.getSynonym();
				splitter = ", ";
			}
		}
		return returnvalue;
	}
}