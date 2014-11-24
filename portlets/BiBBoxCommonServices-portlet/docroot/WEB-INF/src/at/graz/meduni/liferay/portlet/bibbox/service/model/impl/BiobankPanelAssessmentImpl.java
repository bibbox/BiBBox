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

import at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment;

/**
 * The extended model implementation for the BiobankPanelAssessment service. Represents a row in the &quot;bibboxcs.invitation_organisation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment} interface.
 * </p>
 *
 * @author reihsr
 */
public class BiobankPanelAssessmentImpl extends BiobankPanelAssessmentBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a biobank panel assessment model instance should use the {@link at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment} interface instead.
	 */
	public BiobankPanelAssessmentImpl() {
	}
	
	public String getAggregatedAnswers() {
		String return_value = "";
		// 1.1
		if(this.getBackground1_1().equalsIgnoreCase("Appropriate")) {
			return_value += "<font style=\"color: green;\">" + this.getBackground1_1().substring(0, 1) + "</font>";
		} else if(this.getBackground1_1().equalsIgnoreCase("Inadequate")) {
			return_value += "<font style=\"color: red;font-weight: bold;\">" + this.getBackground1_1().substring(0, 1) + "</font>";
		} else {
			return_value += "-";
		}
		// 1.2
		if(this.getElsi1_2().equalsIgnoreCase("Yes")) {
			return_value += "<font style=\"color: green;\">" + this.getElsi1_2().substring(0, 1) + "</font>";
		} else if(this.getElsi1_2().equalsIgnoreCase("No")) {
			return_value += "<font style=\"color: red;font-weight: bold;\">" + this.getElsi1_2().substring(0, 1) + "</font>";
		} else if(this.getElsi1_2().equalsIgnoreCase("Unclear")) {
			return_value += "<font style=\"color: red;font-weight: bold;\">" + this.getElsi1_2().substring(0, 1) + "</font>";
		} else {
			return_value += "-";
		}
		// 1.3
		if(this.getQuality1_3().equalsIgnoreCase("Yes")) {
			return_value += "<font style=\"color: green;\">" + this.getQuality1_3().substring(0, 1) + "</font>";
		} else if(this.getQuality1_3().equalsIgnoreCase("No")) {
			return_value += "<font style=\"color: red;font-weight: bold;\">" + this.getQuality1_3().substring(0, 1) + "</font>";
		} else if(this.getQuality1_3().equalsIgnoreCase("Unclear")) {
			return_value += "<font style=\"color: red;font-weight: bold;\">" + this.getQuality1_3().substring(0, 1) + "</font>";
		} else {
			return_value += "-";
		}
		// 2.1
		if(this.getCataloguemeetpurposes2_1().equalsIgnoreCase("Yes")) {
			return_value += "<font style=\"color: green;\">" + this.getCataloguemeetpurposes2_1().substring(0, 1) + "</font>";
		} else if(this.getCataloguemeetpurposes2_1().equalsIgnoreCase("No")) {
			return_value += "<font style=\"color: red;font-weight: bold;\">" + this.getCataloguemeetpurposes2_1().substring(0, 1) + "</font>";
		} else if(this.getCataloguemeetpurposes2_1().equalsIgnoreCase("Unclear")) {
			return_value += "<font style=\"color: red;font-weight: bold;\">" + this.getCataloguemeetpurposes2_1().substring(0, 1) + "</font>";
		} else {
			return_value += "-";
		}
		// 2.2
		if(this.getAdequateitplatform2_2().equalsIgnoreCase("Yes")) {
			return_value += "<font style=\"color: green;\">" + this.getAdequateitplatform2_2().substring(0, 1) + "</font>";
		} else if(this.getAdequateitplatform2_2().equalsIgnoreCase("No")) {
			return_value += "<font style=\"color: red;font-weight: bold;\">" + this.getAdequateitplatform2_2().substring(0, 1) + "</font>";
		} else if(this.getAdequateitplatform2_2().equalsIgnoreCase("Unclear")) {
			return_value += "<font style=\"color: red;font-weight: bold;\">" + this.getAdequateitplatform2_2().substring(0, 1) + "</font>";
		} else {
			return_value += "-";
		}
		// 2.3
		if(this.getAddedvaluecatalogue2_3().equalsIgnoreCase("Yes")) {
			return_value += "<font style=\"color: green;\">" + this.getAddedvaluecatalogue2_3().substring(0, 1) + "</font>";
		} else if(this.getAddedvaluecatalogue2_3().equalsIgnoreCase("No")) {
			return_value += "<font style=\"color: red;font-weight: bold;\">" + this.getAddedvaluecatalogue2_3().substring(0, 1) + "</font>";
		} else if(this.getAddedvaluecatalogue2_3().equalsIgnoreCase("Unclear")) {
			return_value += "<font style=\"color: red;font-weight: bold;\">" + this.getAddedvaluecatalogue2_3().substring(0, 1) + "</font>";
		} else {
			return_value += "-";
		}
		// 2.4
		if(this.getAssociateddata2_4().equalsIgnoreCase("Yes")) {
			return_value += "<font style=\"color: green;\">" + this.getAssociateddata2_4().substring(0, 1) + "</font>";
		} else if(this.getAssociateddata2_4().equalsIgnoreCase("No")) {
			return_value += "<font style=\"color: red;font-weight: bold;\">" + this.getAssociateddata2_4().substring(0, 1) + "</font>";
		} else if(this.getAssociateddata2_4().equalsIgnoreCase("Unclear")) {
			return_value += "<font style=\"color: red;font-weight: bold;\">" + this.getAssociateddata2_4().substring(0, 1) + "</font>";
		} else {
			return_value += "-";
		}
		return return_value;
	}
}