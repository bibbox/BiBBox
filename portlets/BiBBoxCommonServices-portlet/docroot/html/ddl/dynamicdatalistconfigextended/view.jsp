<%@page import="at.graz.meduni.liferay.portlet.bibbox.service.persistence.DDLConfigurationPersistence"%>
<%@ include file="/html/ddl/init.jsp" %>  

<portlet:defineObjects />
<liferay-theme:defineObjects />

<div id="myToggler">
<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
List<DDMStructure> ddm_structures = DDMStructureLocalServiceUtil.getStructures(themeDisplay.getCompanyGroupId());
int ddlcount = 0;
for(DDMStructure ddm_structure : ddm_structures) { 
	if(ddm_structure.getClassName().equals("com.liferay.portlet.dynamicdatalists.model.DDLRecordSet")) {
		%>
		<h4 class="header toggler-header-collapsed"><span><%= ddm_structure.getStructureId() %></span> - <%= ddm_structure.getNameCurrentValue() %></h4>
			<portlet:actionURL name="updateDDLConfig" var="updateDDLConfigURL" windowState="normal" />
			<aui:form action="<%= updateDDLConfigURL %>" method="POST" name="fm" cssClass="content toggler-content-collapsed">
				<aui:fieldset>
					<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
					<aui:input type="hidden" name="ddmstructureid" value="<%= ddm_structure.getStructureId() %>" />
					<aui:input type="hidden" name="ddmstructurename" value="<%= ddm_structure.getNameCurrentValue() %>" />
					<aui:layout cssClass="proposelayout">
			
					<%
					Map<String, Map<String, String>> fieldmap = ddm_structure.getFieldsMap();
					Map<String, Map<String, String>> fieldmap_options = null;
					fieldmap_options = ddm_structure.getTransientFieldsMap(themeDisplay.getLocale().toString());
					HashMap<String, LinkedHashMap<String, String>> field_options = new HashMap<String, LinkedHashMap<String, String>>();
				  	for(String key_options : fieldmap_options.keySet()) {
				  		String ddlfield = fieldmap_options.get(key_options).get("_parentName_");
				  		if(!field_options.containsKey(ddlfield)) {
				  			field_options.put(ddlfield, new LinkedHashMap<String, String>());
				  		}
				  		field_options.get(ddlfield).put(fieldmap_options.get(key_options).get("value"), fieldmap_options.get(key_options).get("label"));
				  	}
				  	for(String key : fieldmap.keySet()) {
				  		if(key.equalsIgnoreCase("_fieldsDisplay")) {
				  			continue;
				  		}
				  		String options = "";
				  		String viewtitlecss  = "";
				  		String viewvaluecss  = "";
				  		long columwidth = 50;
				  		String edittip = "";
				  		String displaytip = "";
				  		String fieldconfigurationid = "";
				  		String group = "";
				  		String viewscript = "";
				  		String editscript = "";
				  		boolean display = false;
				  		DDLConfiguration fieldconfiguration = DDLConfigurationLocalServiceUtil.getDDLConfigurationForField(ddm_structure.getStructureId(), key);
				  		if(fieldconfiguration != null) {
				  			options = fieldconfiguration.getViewscript();
				  			viewtitlecss = fieldconfiguration.getViewtitlecss();
				  			viewvaluecss = fieldconfiguration.getViewvaluecss();
				  			columwidth = fieldconfiguration.getColumwidth();
				  			edittip = fieldconfiguration.getEdittip();
				  			displaytip = fieldconfiguration.getDisplaytip();
				  			group = fieldconfiguration.getGroup();
				  			display = fieldconfiguration.getDisplay();
				  			fieldconfigurationid = String.valueOf(fieldconfiguration.getDdlconfigurationId());
				  			viewscript = fieldconfiguration.getViewscript();
				  			editscript = fieldconfiguration.getEditscript();
				  		}
				  		%>
				  		<aui:column columnWidth='100' first="true">
							<b><%= fieldmap.get(key).get("label") %>:</b> <%= options %><br>
							<aui:input type="hidden" name="fieldconfigurationid" value="<%= fieldconfigurationid %>" />
						</aui:column>
						<aui:column columnWidth='25' first="true">
							<aui:input name='<%= fieldmap.get(key).get("label") + "_viewtitlecss" %>' label="Title CSS" value="<%=viewtitlecss%>" />
						</aui:column>
						<aui:column columnWidth='25'>
							<aui:input name='<%= fieldmap.get(key).get("label") + "_viewvaluecss" %>' label="Value CSS" value="<%=viewvaluecss%>" />
						</aui:column>
						<aui:column columnWidth='50' last="true">
							<aui:input name='<%= fieldmap.get(key).get("label") + "_displaytip" %>' label="Tips for view" value="<%=displaytip%>" type="textarea" />
						</aui:column>
						<aui:column columnWidth='25' first="true">
							<aui:select label="Column Width" name='<%= fieldmap.get(key).get("label") + "_columwidth" %>' >
								<aui:option value="0" selected='<%= columwidth == 10 ? true : false %>' >10%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 15 ? true : false %>' >15%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 20 ? true : false %>' >20%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 25 ? true : false %>' >25%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 28 ? true : false %>' >28%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 30 ? true : false %>' >30%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 33 ? true : false %>' >33%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 35 ? true : false %>' >35%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 40 ? true : false %>' >40%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 45 ? true : false %>' >45%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 50 ? true : false %>' >50%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 55 ? true : false %>' >55%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 60 ? true : false %>' >60%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 62 ? true : false %>' >62%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 65 ? true : false %>' >65%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 66 ? true : false %>' >66%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 70 ? true : false %>' >70%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 75 ? true : false %>' >75%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 80 ? true : false %>' >80%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 85 ? true : false %>' >85%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 90 ? true : false %>' >90%</aui:option>
								<aui:option value="0" selected='<%= columwidth == 95 ? true : false %>' >95%</aui:option>
							</aui:select>
						</aui:column>
						<aui:column columnWidth='75' last="true">
							<aui:input name='<%= fieldmap.get(key).get("label") + "_edittip" %>' label="Tips for edit" value="<%=edittip%>" type="textarea" />
						</aui:column>
						<aui:column columnWidth='50' first="true">
							<aui:input name='<%= fieldmap.get(key).get("label") + "_group" %>' label="Group" value="<%=group%>" />
						</aui:column>
						<aui:column columnWidth='50' last="true">
							<aui:input name='<%= fieldmap.get(key).get("label") + "_display" %>' label="Display" type="checkbox" value="<%=display%>" />
						</aui:column>
						<aui:column columnWidth='50' first="true">
							<aui:input name='<%= fieldmap.get(key).get("label") + "_viewscript" %>' label="Viewscript" value="<%=viewscript%>" type="textarea" />
						</aui:column>
						<aui:column columnWidth='50' last="true">
							<aui:input name='<%= fieldmap.get(key).get("label") + "_editscript" %>' label="Editscript" value="<%=editscript%>" type="textarea" />
						</aui:column>
						
						<%
				  	}
				  	%>
				  	</aui:layout>
			  	</aui:fieldset>
			  	<aui:button-row>
					<aui:button type="submit" />
				</aui:button-row>
		  	</aui:form>
		  	
		<%
	}
}
%>
</div>
<script>
YUI().use(
		  'aui-toggler',
		  function(Y) {
		    new Y.TogglerDelegate(
		      {
		        animated: true,
		        closeAllOnExpand: true,
		        container: '#myToggler',
		        content: '.content',
		        expanded: false,
		        header: '.header',
		        transition: {
		          duration: 0.2,
		          easing: 'cubic-bezier(0, 0.1, 0, 1)'
		        }
		      }
		    );
		  }
		);
</script>