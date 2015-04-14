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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl;

/**
 * The extended model implementation for the KdssmpParameterConfiguration service. Represents a row in the &quot;kdssmp.arameterconfiguration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterConfiguration} interface.
 * </p>
 *
 * @author reihsr
 */
public class KdssmpParameterConfigurationImpl
	extends KdssmpParameterConfigurationBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a kdssmp parameter configuration model instance should use the {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterConfiguration} interface instead.
	 */
	public KdssmpParameterConfigurationImpl() {
	}
	
	public String getInputParameter() {
		System.out.println(htmlInput());
		System.out.println(this.getDatatype());
		if(this.getDatatype().equalsIgnoreCase("String")) {
			if(this.getDisplayoptions().equalsIgnoreCase("html")) {
				return htmlInput();
			}
		}
		return "";
	}
	
	/*
	 * <aui:field-wrapper label="Description">
			    <liferay-ui:input-editor name="Description" toolbarSet="liferay-article" initMethod="initEditor" width="200" />
			    <script type="text/javascript">
			        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(ddlrecord.getFieldValue("Description").toString().replaceAll("\"\\]|\\[\"", "")) %>"; }
			    </script>
			</aui:field-wrapper>
	 */
	private String htmlInput() {
		String labelname = this.getDatatype() + this.getParameterconfigurationId();
		String html = "<label for=\"" + labelname + "\">" + this.getDisplayname() + "</label>";
		html += "<liferay-ui:input-editor name=\"" + labelname + "\" toolbarSet=\"liferay-article\" initMethod=\"initEditor\" width=\"100%\" />";
		html += "<script type=\"text/javascript\">function <portlet:namespace />initEditor() { return \"test\"; }</script>";
		return html;
	}
}