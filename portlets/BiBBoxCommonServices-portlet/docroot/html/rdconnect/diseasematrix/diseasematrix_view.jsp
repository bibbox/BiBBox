<%@ include file="/html/rdconnect/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<liferay-ui:error key="file-upload-wrong-type" message="file-upload-wrong-type" />
<liferay-ui:error key="no-correct-sheer-found" message="no-correct-sheer-found" />
<%
if(renderRequest.getAttribute("xls-header-not-defined-column_missing") != null) {
	%>
	<div style="margin:10px; padding: 10px; background-color: #0066FF;opacity: 0.4;filter: alpha(opacity=40);color: #ffffff;" >
		<i class="fa fa-exclamation-circle"></i>&nbsp&nbsp<liferay-ui:message key='xls-header-not-defined' arguments='<%= renderRequest.getAttribute("xls-header-not-defined-column_missing") %>'/>
	</div>
	<%
}
if(renderRequest.getAttribute("xls-row-import-errors") != null) {
	%>
	<div style="margin:10px; padding: 10px; background-color: #0066FF;opacity: 0.4;filter: alpha(opacity=40);color: #ffffff;" >
		<i class="fa fa-exclamation-circle"></i>&nbsp&nbsp<liferay-ui:message key='xls-row-import-errors' arguments='<%= renderRequest.getAttribute("xls-row-import-errors") %>'/>
	</div>
	<%
}
%>

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);	
// Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_add_diseasematrix = "ADD_DISEASEMATRIX";
String actionId_view_patientcount = "VIEW_DONORS_COUNT";

long organizationId = 0;
Organization organization = null;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	organizationId = currentGroup.getClassPK();

	SimpleDateFormat simpledateformat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	%>
	<c:choose>
		<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_add_diseasematrix) %>">
			<div style="width: 100%;float:left;" class="rdcdiseases">
				<!-- Add Desease -->
				<aui:button-row cssClass="rdcbuttonrowadddiseae">
					<portlet:renderURL var="addDiseaseMatrixURL">
						<portlet:param name="mvcPath" value="/html/rdconnect/diseasematrix/diseasematrix_edit.jsp" />
						<portlet:param name="organizationId" value="<%= Long.toString(organizationId) %>" />
						<portlet:param name="redirect" value="<%= redirect %>" />
					</portlet:renderURL>
					<aui:button value="add-diseasematrix" onClick="<%= addDiseaseMatrixURL.toString() %>"/>
				</aui:button-row>
				<!-- Upload XML -->
				<portlet:actionURL name='<%="uploadFile"%>' var="uploadFileURL" windowState="normal" />
				<aui:form action="<%=uploadFileURL%>" enctype="multipart/form-data"
					method="post" name="fm" cssClass="rdcbuttonrowuploadexcel">
					<div style="width: 200px;float:left;">
						<aui:fieldset>
							<aui:input type="hidden" name="rdc_organisation" value="<%= organizationId %>" />
							<input type="file" name="fileupload" id="fileupload" size="60" />
						</aui:fieldset>
					</div>
					<div style="width: 75px;float:left;">
						<aui:button-row>
							<aui:button name="saveButton" type="submit" value="save" />
						</aui:button-row>
					</div>
				</aui:form>
				<!-- Download XLS -->
				<portlet:resourceURL var="fileDownloadXLSURL" id="fileDownload" />
				<a href="<portlet:resourceURL><portlet:param name="<%=Constants.CMD%>" value="export_xls" />
				<portlet:param name="RDCOrganisationId" value="<%= String.valueOf(organizationId) %>" />
				</portlet:resourceURL>">Download Disease Matrix as XLS File</a> <br />
				<!-- Download XLSX -->
				<portlet:resourceURL var="fileDownloadXLSXURL" id="fileDownload" />
				<a href="<portlet:resourceURL><portlet:param name="<%=Constants.CMD%>" value="export_xlsx" />
				<portlet:param name="RDCOrganisationId" value="<%= String.valueOf(organizationId) %>" />
				</portlet:resourceURL>">Download Disease Matrix as XLSX File</a>
			</div>
			<br><br>
		</c:when>
	</c:choose>
	
	<!-- -------------------------------- -->
	<!-- Load Federated DiseaseMatrixData -->
	<style>
		#ajaxloader
		{
			position: absolute;
			width: 30px;
			height: 30px;
			border: 8px solid #ed660a;
			border-right-color: transparent;
			border-radius: 50%;
			box-shadow: 0 0 25px 2px #eee;
		}
		#ajaxloader
		{
			animation: spin 1s linear infinite;
		}
		@keyframes spin
		{
			from { transform: rotate(0deg);   opacity: 0.2; }
			50%  { transform: rotate(180deg); opacity: 1.0; }
			to   { transform: rotate(360deg); opacity: 0.2; }
		}
	</style>
	<%
	//String dmdata = DiseaseMatrixLocalServiceUtil.getDiseaseMatrixFromFederation(organizationId);
	//if(!dmdata.equals("")) {
	%>
	<div id="BBMRIERICBiobankList">
		<div id="ajaxloader"></div>
	</div>
	
	<portlet:resourceURL var="resourceURL">
		<portlet:param name="<%=Constants.CMD%>" value="load_federated_data" />
		<portlet:param name="RDCOrganisationId" value="<%= String.valueOf(organizationId) %>" />
	</portlet:resourceURL>
	
	<aui:script use="aui-base,node,aui-datatable,aui-datatype,datatable-sort,aui-io-request">
		AUI().use(
		  'aui-datatable',
		  'aui-datatype',
		  'datatable-sort',
		  'aui-io-request',
		  'aui-base',
		  function(Y) {
		  	Y.io.request('<%= resourceURL %>',{
		  		dataType: 'json',
			  	on: {
	              failure: function() { 
	              	Y.all('#ajaxloader').setStyle('display', 'none');
	              	alert('Unable to Load Data'); 
	              },
	              success: function() {
	                Y.all('#ajaxloader').setStyle('display', 'none'); 
	              	var remoteData = Y.JSON.parse(Y.JSON.stringify(this.get('responseData')));
	              	if(Y.JSON.stringify(this.get('responseData')) == "[]") {
	              		Y.all('#BBMRIERICBiobankList').setStyle('display', 'none');
	              	}
				    var nestedCols = [ 
				    	{
				    		key: 'Disease Name',
				    		sortable: true
				    	},
				    	{
				    		key: 'NumberofPatientsDonors',
				    		sortable: true
				    	},
				    	{
				    		key: 'ORPHA Code',
				    		sortable: true
				    	},  	
				    	{
				    		key: 'ICD 10',
				    		sortable: true
				    	},  	
				    	{
				    		key: 'OMIM',
				    		sortable: true
				    	},  	
				    	{
				    		key: 'Synonym',
				    		label: 'Synonym(s)',
				    		sortable: true
				    	},  	
				    	{
				    		key: 'SampleCatalogue',
				    		label: 'Sample Catalogue',
				    		sortable: true,
		    				allowHTML: true,
		    				formatter: function (o) {
				    			var url = o.data.SampleCatalogue;
				    			var returnvalue = '<a href="' + url + '" target="_blank">Sample Catalogue</a>';
				    			return returnvalue;
				    		}
				    	}
				    ];
					var dataTable = new Y.DataTable(
				      {
				        columns: nestedCols,
				        data: remoteData,
				      }
				    ).render('#BBMRIERICBiobankList');
				    
				
				    
				}
		      }
		    });
		  }
		);
	</aui:script>
	<%
	//}
	%>
	
	<!-- ---------------------------- -->
	<!-- Load Local DiseaseMatrixData -->
	<liferay-ui:search-container delta='<%= GetterUtil.getInteger(prefs.getValue("rowsPerPage", "5")) %>' emptyResultsMessage="diseasematrix-empty-results-message">
		<liferay-ui:search-container-results
			results="<%= DiseaseMatrixLocalServiceUtil.getDiseaseMatrixs(organizationId, searchContainer.getStart(), searchContainer.getEnd()) %>"
			total="<%= DiseaseMatrixLocalServiceUtil.getDiseaseMatrixsCount(organizationId) %>"
		/>
	
		<liferay-ui:search-container-row
			className="at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix"
			keyProperty="diseasematrixId"
			modelVar="diseasematrix" escapedModel="<%= true %>"
		>
			<liferay-ui:search-container-column-text
				name="diseasename"
				value="<%= diseasematrix.getDiseasename() %>"
			/>
			<c:choose>
				<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_view_patientcount) %>">
					<liferay-ui:search-container-column-text
						name="patientcount"
						value="<%= diseasematrix.getPatientcount() %>"
					/>
				</c:when>
			</c:choose>
			<liferay-ui:search-container-column-text
				name="gene"
				value="<%= diseasematrix.getGene() %>"
			/>
			<liferay-ui:search-container-column-text
				name="orphanumber"
				value="<%= diseasematrix.getOrphanumber() %>"
			/>
			<liferay-ui:search-container-column-text
				name="icd10"
				value="<%= diseasematrix.getIcd10() %>"
			/>
			<liferay-ui:search-container-column-text
				name="omim"
				value="<%= diseasematrix.getOmim() %>"
			/>
			<liferay-ui:search-container-column-text
				name="synonym"
				value="<%= diseasematrix.getSynonym() %>"
			/>
			<liferay-ui:search-container-column-text
				name="modifieddate"
				value="<%= simpledateformat.format(diseasematrix.getModifieddate()) %>"
			/>
			<c:choose>
				<c:when test="<%= permissionChecker.hasPermission(groupId, name, primKey, actionId_add_diseasematrix) %>">
					<liferay-ui:search-container-column-jsp
						align="right"
						path="/html/rdconnect/diseasematrix/diseasematrix_actions.jsp"
					/>
				</c:when>
			</c:choose>
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
	
	<%
} else {
	%>
	This portlet is only available for the use in Organizations.
	
	<i id="refreschorganizationlist" class="icon-refresh"></i>
				<div id="organisationlist" >

<aui:script use="aui-base,aui-io-request,click,jsonp,jsonp-url">
AUI().ready(
	'jsonp', 
	'jsonp-url',
	'aui-base',
	'aui-io-request',
	'click',
	function(A) {
		A.all('#refreschorganizationlist').each(function() {
			this.on('click', function(event){
				/*var isDebug = true;
				var querypart = "query=" + escape('PREFIX coeus: <http://bioinformatics.ua.pt/coeus/> PREFIX diseasecard: <http://bioinformatics.ua.pt/diseasecard/resource/> SELECT ?item {?item coeus:hasConcept diseasecard:concept_OMIM }');
				var endpoint = 'http://bioinformatics.ua.pt/diseasecard/sparql';
    
				// Get our HTTP request object.
				var xmlhttp = null;
				if(window.XMLHttpRequest) {
					xmlhttp = new XMLHttpRequest();
				} else if(window.ActiveXObject) {
					// Code for older versions of IE, like IE6 and before.
					xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
				} else {
					alert('Perhaps your browser does not support XMLHttpRequests?');
				}
    
				// Set up a POST with JSON result format.
				xmlhttp.open('POST', endpoint, true); // GET can have caching probs, so POST
				xmlhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
				xmlhttp.setRequestHeader("Accept", "application/sparql-results+json");
    
				// Set up callback to get the response asynchronously.
				xmlhttp.onreadystatechange = function() {
					if(xmlhttp.readyState == 4) {
						if(xmlhttp.status == 200) {
							// Do something with the results
							if(isDebug) alert(xmlhttp.responseText);
						} else {
							// Some kind of error occurred.
							alert("Sparql query error: " + xmlhttp.status + " "
							+ xmlhttp.responseText);
						}
					}
				};
				// Send the query to the endpoint.
				xmlhttp.send(querypart);*/

				var url = 'http://bioinformatics.ua.pt/diseasecard/sparql?query=SELECT+%3Fpredicate+%3Fobject+%7B%3Chttp%3A%2F%2Fbioinformatics.ua.pt%2Fdiseasecard%2Fresource%2Fomim_114480%3E+%3Fpredicate+%3Fobject%7D&output=json&force-accept=text%2Fplain&stylesheet=.%2Fapi%2Ftranslate';
				function handleJSONP(response) {
					alert(response['results']['bindings']['0']);
				    A.one('#organisationlist').setHTML(response.get('responseData'));
				}
				
    			A.jsonp(url, handleJSONP);       
			});           
		});
	}
);
</aui:script>
	<%
}
%>

