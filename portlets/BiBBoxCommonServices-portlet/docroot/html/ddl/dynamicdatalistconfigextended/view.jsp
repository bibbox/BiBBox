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
			<portlet:actionURL name="updateDDL" var="updateDDLURL" windowState="normal" />
			<aui:form action="<%=updateDDLURL%>" method="POST" name="fm" cssClass="content toggler-content-collapsed">
				<aui:fieldset>
					<aui:input type="hidden" name="redirect" value="<%=redirect%>" />
			
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
				  		String columwidth = "";
				  		String edittip = "";
				  		String displaytip = "";
				  		DDLConfiguration fieldconfiguration = DDLConfigurationLocalServiceUtil.getDDLConfigurationForField(ddm_structure.getStructureId(), key);
				  		if(fieldconfiguration != null) {
				  			options = fieldconfiguration.getViewscript();
				  			viewtitlecss = fieldconfiguration.getViewtitlecss();
				  			viewvaluecss = fieldconfiguration.getViewvaluecss();
				  			columwidth = fieldconfiguration.getViewvaluecss();
				  			edittip = fieldconfiguration.getEdittip();
				  			displaytip = fieldconfiguration.getDisplaytip();
				  		}
				  		%>
						<b><%= fieldmap.get(key).get("label") %>:</b> <%= options %><br>
						<aui:column columnWidth='25'>
							<aui:input name="viewtitlecss" label="Title CSS" value="<%=viewtitlecss%>" />
						</aui:column>
						<aui:column columnWidth='25'>
							<aui:input name="viewvaluecss" label="Value CSS" value="<%=viewvaluecss%>" />
						</aui:column>
						<aui:column columnWidth='50'>
							<aui:input name="displaytip" label="Tips for view" value="<%=displaytip%>" type="textarea" />
						</aui:column>
						<aui:column columnWidth='25'>
							<aui:input name="columwidth" label="Column Width" value="<%=columwidth%>" />
						</aui:column>
						<aui:column columnWidth='75'>
							<aui:input name="edittip" label="Tips for edit" value="<%=edittip%>" type="textarea" />
						</aui:column>
						
						<%
				  	}
				  	%>
			  	</aui:fieldset>
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