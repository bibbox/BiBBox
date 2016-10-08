<%@ include file="/html/rdconnect/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
//<link rel="stylesheet" type="text/css" href="DataTables/datatables.min.css"/>
//<script type="text/javascript" src="DataTables/datatables.min.js"></script> 
%>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs-3.3.6/jq-2.2.3/jszip-2.5.0/pdfmake-0.1.18/dt-1.10.12/af-2.1.2/b-1.2.1/b-colvis-1.2.1/b-flash-1.2.1/b-html5-1.2.1/b-print-1.2.1/cr-1.3.2/fc-3.2.2/fh-3.1.2/kt-2.1.2/r-2.1.0/rr-1.1.2/sc-1.4.2/se-1.2.0/datatables.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs-3.3.6/jq-2.2.3/jszip-2.5.0/pdfmake-0.1.18/dt-1.10.12/af-2.1.2/b-1.2.1/b-colvis-1.2.1/b-flash-1.2.1/b-html5-1.2.1/b-print-1.2.1/cr-1.3.2/fc-3.2.2/fh-3.1.2/kt-2.1.2/r-2.1.0/rr-1.1.2/sc-1.4.2/se-1.2.0/datatables.min.js"></script>



<table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Age</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>Name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Age</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
        </tfoot>
        <tbody>
            <tr>
                <td>Tiger Nixon</td>
                <td>System Architect</td>
                <td>Edinburgh</td>
                <td>61</td>
                <td>2011/04/25</td>
                <td>$320,800</td>
            </tr>
            <tr>
                <td>Garrett Winters</td>
                <td>Accountant</td>
                <td>Tokyo</td>
                <td>63</td>
                <td>2011/07/25</td>
                <td>$170,750</td>
            </tr>
            <tr>
                <td>Ashton Cox</td>
                <td>Junior Technical Author</td>
                <td>San Francisco</td>
                <td>66</td>
                <td>2009/01/12</td>
                <td>$86,000</td>
            </tr>
            <tr>
                <td>Cedric Kelly</td>
                <td>Senior Javascript Developer</td>
                <td>Edinburgh</td>
                <td>22</td>
                <td>2012/03/29</td>
                <td>$433,060</td>
            </tr>
            <tr>
                <td>Airi Satou</td>
                <td>Accountant</td>
                <td>Tokyo</td>
                <td>33</td>
                <td>2008/11/28</td>
                <td>$162,700</td>
            </tr>
            <tr>
                <td>Brielle Williamson</td>
                <td>Integration Specialist</td>
                <td>New York</td>
                <td>61</td>
                <td>2012/12/02</td>
                <td>$372,000</td>
            </tr>
            <tr>
                <td>Herrod Chandler</td>
                <td>Sales Assistant</td>
                <td>San Francisco</td>
                <td>59</td>
                <td>2012/08/06</td>
                <td>$137,500</td>
            </tr>
            <tr>
                <td>Rhona Davidson</td>
                <td>Integration Specialist</td>
                <td>Tokyo</td>
                <td>55</td>
                <td>2010/10/14</td>
                <td>$327,900</td>
            </tr>
            <tr>
                <td>Colleen Hurst</td>
                <td>Javascript Developer</td>
                <td>San Francisco</td>
                <td>39</td>
                <td>2009/09/15</td>
                <td>$205,500</td>
            </tr>
            <tr>
                <td>Sonya Frost</td>
                <td>Software Engineer</td>
                <td>Edinburgh</td>
                <td>23</td>
                <td>2008/12/13</td>
                <td>$103,600</td>
            </tr>
            <tr>
                <td>Jena Gaines</td>
                <td>Office Manager</td>
                <td>London</td>
                <td>30</td>
                <td>2008/12/19</td>
                <td>$90,560</td>
            </tr>
            <tr>
                <td>Quinn Flynn</td>
                <td>Support Lead</td>
                <td>Edinburgh</td>
                <td>22</td>
                <td>2013/03/03</td>
                <td>$342,000</td>
            </tr>
            <tr>
                <td>Charde Marshall</td>
                <td>Regional Director</td>
                <td>San Francisco</td>
                <td>36</td>
                <td>2008/10/16</td>
                <td>$470,600</td>
            </tr>
            <tr>
                <td>Haley Kennedy</td>
                <td>Senior Marketing Designer</td>
                <td>London</td>
                <td>43</td>
                <td>2012/12/18</td>
                <td>$313,500</td>
            </tr>
            <tr>
                <td>Tatyana Fitzpatrick</td>
                <td>Regional Director</td>
                <td>London</td>
                <td>19</td>
                <td>2010/03/17</td>
                <td>$385,750</td>
            </tr>
            <tr>
                <td>Michael Silva</td>
                <td>Marketing Designer</td>
                <td>London</td>
                <td>66</td>
                <td>2012/11/27</td>
                <td>$198,500</td>
            </tr>
            <tr>
                <td>Paul Byrd</td>
                <td>Chief Financial Officer (CFO)</td>
                <td>New York</td>
                <td>64</td>
                <td>2010/06/09</td>
                <td>$725,000</td>
            </tr>
            <tr>
                <td>Gloria Little</td>
                <td>Systems Administrator</td>
                <td>New York</td>
                <td>59</td>
                <td>2009/04/10</td>
                <td>$237,500</td>
            </tr>
            <tr>
                <td>Bradley Greer</td>
                <td>Software Engineer</td>
                <td>London</td>
                <td>41</td>
                <td>2012/10/13</td>
                <td>$132,000</td>
            </tr>
            <tr>
                <td>Dai Rios</td>
                <td>Personnel Lead</td>
                <td>Edinburgh</td>
                <td>35</td>
                <td>2012/09/26</td>
                <td>$217,500</td>
            </tr>
            <tr>
                <td>Jenette Caldwell</td>
                <td>Development Lead</td>
                <td>New York</td>
                <td>30</td>
                <td>2011/09/03</td>
                <td>$345,000</td>
            </tr>
            <tr>
                <td>Yuri Berry</td>
                <td>Chief Marketing Officer (CMO)</td>
                <td>New York</td>
                <td>40</td>
                <td>2009/06/25</td>
                <td>$675,000</td>
            </tr>
            <tr>
                <td>Caesar Vance</td>
                <td>Pre-Sales Support</td>
                <td>New York</td>
                <td>21</td>
                <td>2011/12/12</td>
                <td>$106,450</td>
            </tr>
            <tr>
                <td>Doris Wilder</td>
                <td>Sales Assistant</td>
                <td>Sidney</td>
                <td>23</td>
                <td>2010/09/20</td>
                <td>$85,600</td>
            </tr>
            <tr>
                <td>Angelica Ramos</td>
                <td>Chief Executive Officer (CEO)</td>
                <td>London</td>
                <td>47</td>
                <td>2009/10/09</td>
                <td>$1,200,000</td>
            </tr>
            <tr>
                <td>Gavin Joyce</td>
                <td>Developer</td>
                <td>Edinburgh</td>
                <td>42</td>
                <td>2010/12/22</td>
                <td>$92,575</td>
            </tr>
            <tr>
                <td>Jennifer Chang</td>
                <td>Regional Director</td>
                <td>Singapore</td>
                <td>28</td>
                <td>2010/11/14</td>
                <td>$357,650</td>
            </tr>
            <tr>
                <td>Brenden Wagner</td>
                <td>Software Engineer</td>
                <td>San Francisco</td>
                <td>28</td>
                <td>2011/06/07</td>
                <td>$206,850</td>
            </tr>
            <tr>
                <td>Fiona Green</td>
                <td>Chief Operating Officer (COO)</td>
                <td>San Francisco</td>
                <td>48</td>
                <td>2010/03/11</td>
                <td>$850,000</td>
            </tr>
            <tr>
                <td>Shou Itou</td>
                <td>Regional Marketing</td>
                <td>Tokyo</td>
                <td>20</td>
                <td>2011/08/14</td>
                <td>$163,000</td>
            </tr>
            <tr>
                <td>Michelle House</td>
                <td>Integration Specialist</td>
                <td>Sidney</td>
                <td>37</td>
                <td>2011/06/02</td>
                <td>$95,400</td>
            </tr>
            <tr>
                <td>Suki Burks</td>
                <td>Developer</td>
                <td>London</td>
                <td>53</td>
                <td>2009/10/22</td>
                <td>$114,500</td>
            </tr>
            <tr>
                <td>Prescott Bartlett</td>
                <td>Technical Author</td>
                <td>London</td>
                <td>27</td>
                <td>2011/05/07</td>
                <td>$145,000</td>
            </tr>
            <tr>
                <td>Gavin Cortez</td>
                <td>Team Leader</td>
                <td>San Francisco</td>
                <td>22</td>
                <td>2008/10/26</td>
                <td>$235,500</td>
            </tr>
            <tr>
                <td>Martena Mccray</td>
                <td>Post-Sales support</td>
                <td>Edinburgh</td>
                <td>46</td>
                <td>2011/03/09</td>
                <td>$324,050</td>
            </tr>
            <tr>
                <td>Unity Butler</td>
                <td>Marketing Designer</td>
                <td>San Francisco</td>
                <td>47</td>
                <td>2009/12/09</td>
                <td>$85,675</td>
            </tr>
            <tr>
                <td>Howard Hatfield</td>
                <td>Office Manager</td>
                <td>San Francisco</td>
                <td>51</td>
                <td>2008/12/16</td>
                <td>$164,500</td>
            </tr>
            <tr>
                <td>Hope Fuentes</td>
                <td>Secretary</td>
                <td>San Francisco</td>
                <td>41</td>
                <td>2010/02/12</td>
                <td>$109,850</td>
            </tr>
            <tr>
                <td>Vivian Harrell</td>
                <td>Financial Controller</td>
                <td>San Francisco</td>
                <td>62</td>
                <td>2009/02/14</td>
                <td>$452,500</td>
            </tr>
            <tr>
                <td>Timothy Mooney</td>
                <td>Office Manager</td>
                <td>London</td>
                <td>37</td>
                <td>2008/12/11</td>
                <td>$136,200</td>
            </tr>
            <tr>
                <td>Jackson Bradshaw</td>
                <td>Director</td>
                <td>New York</td>
                <td>65</td>
                <td>2008/09/26</td>
                <td>$645,750</td>
            </tr>
            <tr>
                <td>Olivia Liang</td>
                <td>Support Engineer</td>
                <td>Singapore</td>
                <td>64</td>
                <td>2011/02/03</td>
                <td>$234,500</td>
            </tr>
            <tr>
                <td>Bruno Nash</td>
                <td>Software Engineer</td>
                <td>London</td>
                <td>38</td>
                <td>2011/05/03</td>
                <td>$163,500</td>
            </tr>
            <tr>
                <td>Sakura Yamamoto</td>
                <td>Support Engineer</td>
                <td>Tokyo</td>
                <td>37</td>
                <td>2009/08/19</td>
                <td>$139,575</td>
            </tr>
            <tr>
                <td>Thor Walton</td>
                <td>Developer</td>
                <td>New York</td>
                <td>61</td>
                <td>2013/08/11</td>
                <td>$98,540</td>
            </tr>
            <tr>
                <td>Finn Camacho</td>
                <td>Support Engineer</td>
                <td>San Francisco</td>
                <td>47</td>
                <td>2009/07/07</td>
                <td>$87,500</td>
            </tr>
            <tr>
                <td>Serge Baldwin</td>
                <td>Data Coordinator</td>
                <td>Singapore</td>
                <td>64</td>
                <td>2012/04/09</td>
                <td>$138,575</td>
            </tr>
            <tr>
                <td>Zenaida Frank</td>
                <td>Software Engineer</td>
                <td>New York</td>
                <td>63</td>
                <td>2010/01/04</td>
                <td>$125,250</td>
            </tr>
            <tr>
                <td>Zorita Serrano</td>
                <td>Software Engineer</td>
                <td>San Francisco</td>
                <td>56</td>
                <td>2012/06/01</td>
                <td>$115,000</td>
            </tr>
            <tr>
                <td>Jennifer Acosta</td>
                <td>Junior Javascript Developer</td>
                <td>Edinburgh</td>
                <td>43</td>
                <td>2013/02/01</td>
                <td>$75,650</td>
            </tr>
            <tr>
                <td>Cara Stevens</td>
                <td>Sales Assistant</td>
                <td>New York</td>
                <td>46</td>
                <td>2011/12/06</td>
                <td>$145,600</td>
            </tr>
            <tr>
                <td>Hermione Butler</td>
                <td>Regional Director</td>
                <td>London</td>
                <td>47</td>
                <td>2011/03/21</td>
                <td>$356,250</td>
            </tr>
            <tr>
                <td>Lael Greer</td>
                <td>Systems Administrator</td>
                <td>London</td>
                <td>21</td>
                <td>2009/02/27</td>
                <td>$103,500</td>
            </tr>
            <tr>
                <td>Jonas Alexander</td>
                <td>Developer</td>
                <td>San Francisco</td>
                <td>30</td>
                <td>2010/07/14</td>
                <td>$86,500</td>
            </tr>
            <tr>
                <td>Shad Decker</td>
                <td>Regional Director</td>
                <td>Edinburgh</td>
                <td>51</td>
                <td>2008/11/13</td>
                <td>$183,000</td>
            </tr>
            <tr>
                <td>Michael Bruce</td>
                <td>Javascript Developer</td>
                <td>Singapore</td>
                <td>29</td>
                <td>2011/06/27</td>
                <td>$183,000</td>
            </tr>
            <tr>
                <td>Donna Snider</td>
                <td>Customer Support</td>
                <td>New York</td>
                <td>27</td>
                <td>2011/01/25</td>
                <td>$112,000</td>
            </tr>
        </tbody>
    </table>



<script>
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>



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

	SimpleDateFormat simpledateformat = new SimpleDateFormat("dd.MM.yyyy");
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
				    		label: 'Number of Patients, Donors',
				    		sortable: true
				    	},
				    	{
				    		key: 'Gene',
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
	<%
	int optionsRDCRowsPerPage_cfg = GetterUtil.getInteger(portletPreferences.getValue("optionsRDCRowsPerPage", "5"));
	%>
	
	<liferay-ui:search-container delta='<%= optionsRDCRowsPerPage_cfg %>' emptyResultsMessage="diseasematrix-empty-results-message">
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

