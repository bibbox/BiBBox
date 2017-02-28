<%@ include file="/html/idcard/init.jsp" %>

<style>
<!--
.optionitelic {
	font-style: italic;
}
.optionbold {
	font-weight: bold;
}
-->
</style>

<style>
a.tooltip_size {outline:none; }
a.tooltip_size strong {line-height:30px;}
a.tooltip_size:hover {text-decoration:none;} 
a.tooltip_size span {
    z-index:10;
    display:none; 
    padding:14px 20px;
    margin-top:25px; 
    margin-left:-160px;
    width:250px; 
    line-height:16px;
}
a.tooltip_size:hover span{
    display:inline; 
    position:absolute; 
    border:2px solid #FFF;  
    color:#EEE;
    background:#184b8a;
    opacity: 0.8;
    filter: alpha(opacity=80);
}
    
/*CSS3 extras*/
a.tooltip_size span
{
    border-radius:2px;        
    box-shadow: 0px 0px 8px 4px #666;
    /*opacity: 0.8;*/
}
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
#negotiatorloader
{
	position: absolute;
	width: 15px;
	height: 15px;
	border: 6px solid #ed660a;
	border-right-color: transparent;
	border-radius: 50%;
	box-shadow: 0 0 25px 2px #eee;
}
#negotiatorloader
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

<!-- 
<c:if test='<%= D2BiobankModelPermission.contains(permissionChecker, scopeGroupId, "ADD_BIOBANK") %>'>
	<aui:button-row cssClass="d2biobank-button">
		<portlet:renderURL var="addEntryURL">
			<portlet:param name="mvcPath" value="/html/idcard/biobank/edit_biobank.jsp"></portlet:param>
		</portlet:renderURL>
		<aui:button onClick="<%= addEntryURL.toString() %>" value="Add Biobank"></aui:button>
	</aui:button-row>
</c:if>

 -->

<%
String mode = "";
HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
mode = httpRequest.getParameter("mode");
if (mode == null) {
	mode = "production";
}

String nTocken = httpRequest.getParameter("nToken");
if (nTocken == null) {
	nTocken = "false";
}

System.out.println("=>nTocken: " + nTocken);

String keywords = ParamUtil.getString(request, "keywords");

String nTockenLiferay = ParamUtil.getString(request, "nTockenLiferay");
if (nTockenLiferay == null || nTockenLiferay.equalsIgnoreCase("")) {
	if(nTocken.equalsIgnoreCase("false")) {
		nTockenLiferay = "false";
	} else {
		nTockenLiferay = nTocken;
	}
}
System.out.println("=>nTockenLiferay: " + nTockenLiferay);

String country_filter = ParamUtil.getString(request, "country");
if (country_filter == null) {
	country_filter = "";
}

String materialtype = ParamUtil.getString(request, "materialtype");
if (materialtype == null) {
	materialtype = "";
}

String diagnosisavailable_filter = ParamUtil.getString(request, "diagnosisavailable");
if (diagnosisavailable_filter == null) {
	diagnosisavailable_filter = "";
}
String biobanksize_filter = ParamUtil.getString(request, "biobanksize");
if (biobanksize_filter == null) {
	biobanksize_filter = "";
}
String typeofbiobank = ParamUtil.getString(request, "typeofbiobank");
if (typeofbiobank == null) {
	typeofbiobank = "";
}
String typeofcollection = ParamUtil.getString(request, "typeofcollection");
if (typeofcollection == null) {
	typeofcollection = "";
}

String[] materialtypes = D2BiobankKeys.getMaterialTypes();
String[] diagnosisavailable = D2BiobankKeys.getDiagnosisAvailable();
String[] country = D2BiobankKeys.getCountries();
String[] biobanksize = D2BiobankKeys.getBiobankSize();
String[] typeofbiobanks = D2BiobankKeys.getTypeOfBiobank();
String[] typeofcollections = D2BiobankKeys.getTypeOfCollection();
%>

<div id="myTab">
<ul class="nav nav-tabs">
    <li class="active"><a href="#tab-biobank">Biobanks</a></li>
    <li><a href="#tab-network">Biobank Networks</a></li>
  </ul>
  <div class="tab-content">
    <div id="tab-biobank" class="tab-pane">
    
    
<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/html/idcard/biobank/view.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />
	
	<aui:layout>
		<aui:fieldset>
		 	<input type="hidden" name="mode" value="<%= mode %>" />
		 	<aui:input type="hidden" name="nTockenLiferay" value="<%= nTockenLiferay %>" />
		 	
			<aui:column columnWidth="100" first="true">
				<input style="width: 458px;" type="text" placeholder="search by: BioBank Name ..." value="<%= keywords %>" name="<portlet:namespace />keywords" size="100" id="<portlet:namespace />keywords">
			</aui:column>
			<aui:column columnWidth="25" first="true">
				<aui:select inlineLabel="left" name="materialtype" label="Material Types:" cssClass="rdc-filter-input"  >
					<aui:option value="" selected='<%= materialtype.equalsIgnoreCase("") ? true : false %>'></aui:option>
					<% for (String string : materialtypes) { %>
					<aui:option value="<%= string %>" selected="<%= materialtype.equalsIgnoreCase(string) ? true : false %>">
						<%= string.replaceAll("biobankMaterialStored", "") %>
					</aui:option>
					<% } %>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="25" >
				<aui:select inlineLabel="left" name="diagnosisavailable" label="Diagnosis Available:" cssClass="rdc-filter-input"  >
					<aui:option value="" selected='<%= diagnosisavailable_filter.equalsIgnoreCase("") ? true : false %>'></aui:option>
					<% for (String string : diagnosisavailable) { 
						String cssclass = "";
						if(string.startsWith("--")) {
							cssclass = "optionitelic";
						}
						if(!string.startsWith("-")) {
							cssclass = "optionbold";
						}
						%>
					<aui:option cssClass="<%= cssclass %>" value="<%= string %>" selected="<%= diagnosisavailable_filter.equalsIgnoreCase(string) ? true : false %>">
						<%= string.replaceAll("urn:miriam:", "") %>
					</aui:option>
					<% } %>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="25" >
				<aui:select inlineLabel="left" name="country" label="Country:" cssClass="rdc-filter-input"  >
					<aui:option value="" selected='<%= country_filter.equalsIgnoreCase("") ? true : false %>'></aui:option>
					<% for (String string : country) { %>
					<aui:option value="<%= string %>" selected="<%= country_filter.equalsIgnoreCase(string) ? true : false %>">
						<%= com.liferay.portal.service.CountryServiceUtil.getCountryByA2(string).getNameCurrentValue() %>
					</aui:option>
					<% } %>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="25" last="true" >
				<aui:select inlineLabel="left" name="biobanksize" label="Biobank Size:" cssClass="rdc-filter-input"  >
					<aui:option value="" selected='<%= biobanksize_filter.equalsIgnoreCase("") ? true : false %>'></aui:option>
					<% for (String string : biobanksize) { %>
					<aui:option value="<%= string %>" selected="<%= biobanksize_filter.equalsIgnoreCase(string) ? true : false %>">
						<%= string %>
					</aui:option>
					<% } %>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="25" first="true" >
				<aui:select inlineLabel="left" name="typeofbiobank" label="Type of Biobank:" cssClass="rdc-filter-input"  >
					<aui:option value="" selected='<%= typeofbiobank.equalsIgnoreCase("") ? true : false %>'></aui:option>
					<% for (String string : typeofbiobanks) { %>
					<aui:option value="<%= string %>" selected="<%= typeofbiobank.equalsIgnoreCase(string) ? true : false %>">
						<%= string %>
					</aui:option>
					<% } %>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="25" >
				<aui:select inlineLabel="left" name="typeofcollection" label="Type of Collection:" cssClass="rdc-filter-input"  >
					<aui:option value="" selected='<%= typeofcollection.equalsIgnoreCase("") ? true : false %>'></aui:option>
					<% for (String string : typeofcollections) { %>
					<aui:option value="<%= string %>" selected="<%= typeofcollection.equalsIgnoreCase(string) ? true : false %>">
						<%= string %>
					</aui:option>
					<% } %>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="15" last="true">
				<aui:button-row cssClass="searchFiledFloat">
					<aui:button type="submit" value="search" />
					<% 
					String negotiationButtonName = "";
					if(nTockenLiferay.equalsIgnoreCase("false") || nTockenLiferay.equalsIgnoreCase("")) {
						negotiationButtonName = "Start Negotiation";
					} else {
						negotiationButtonName = "Edit Negotiation";
					}
					if(mode.equalsIgnoreCase("debug")) { %>
						<aui:button style="margin-top: 10px;" value="<%= negotiationButtonName %>" onClick="startNegotiation()" />
					<% } %>
 				</aui:button-row>
			</aui:column>
		</aui:fieldset>
		
	</aui:layout>
</aui:form>

<portlet:resourceURL var="startNegotiationURL"></portlet:resourceURL>

<aui:script use="aui-base">
	Liferay.provide(window, 'startNegotiation', function() {
		var humanReadable = "";
		var s_url = "http://old.bbmri-eric.eu/bbmri-eric-directory-2.0?p_p_id=biobank_WAR_BBMRIERICDatabaseportlet";
		var url_spliter = "&";
		var spliter = "";
		
		var s_keywords = A.one('#<portlet:namespace/>keywords').get('value');
		if(s_keywords != "") {
			s_url += url_spliter + '<portlet:namespace/>keywords=' + s_keywords;
			humanReadable += spliter + "search for " + s_keywords;
			spliter = "-";
		}
		
		var s_materialtype = A.one('#<portlet:namespace/>materialtype').get('value');
		if(s_materialtype != "") {
			s_url += url_spliter + '<portlet:namespace/>materialtype=' + s_materialtype;
			humanReadable += spliter + "materials is " + s_materialtype;
			spliter = "-";
		}
		
		var s_diagnosisavailable = A.one('#<portlet:namespace/>diagnosisavailable').get('value');
		if(s_diagnosisavailable != "") {
			s_url += url_spliter + '<portlet:namespace/>diagnosisavailable=' + s_diagnosisavailable;
			humanReadable += spliter + "diagnosis is " + s_diagnosisavailable;
			spliter = "-";
		}
		
		var s_country = A.one('#<portlet:namespace/>country').get('value');
		if(s_country != "") {
			s_url += url_spliter + '<portlet:namespace/>country=' + s_country;
			humanReadable += spliter + "country is " + s_country;
			spliter = "-";
		}
		
		var s_biobanksize = A.one('#<portlet:namespace/>biobanksize').get('value');
		if(s_biobanksize != "") {
			s_url += url_spliter + '<portlet:namespace/>biobanksize=' + s_biobanksize;
			humanReadable += spliter + "biobanksize is " + s_biobanksize;
			spliter = "-";
		}
		
		var s_typeofbiobank = A.one('#<portlet:namespace/>typeofbiobank').get('value');
		if(s_typeofbiobank != "") {
			s_url += url_spliter + '<portlet:namespace/>typeofbiobank=' + s_typeofbiobank;
			humanReadable += spliter + "biobanktype is " + s_typeofbiobank;
			spliter = "-";
		}
		
		var s_typeofcollection = A.one('#<portlet:namespace/>typeofcollection').get('value');
		if(s_typeofcollection != "") {
			s_url += url_spliter + '<portlet:namespace/>typeofcollection=' + s_typeofcollection;
			humanReadable += spliter + "collectiontype is " + s_typeofcollection;
			spliter = "-";
		}
		
		var collections = A.one('#collectionarray').getHTML();
		
		console.log(humanReadable);
		console.log(s_url);
		console.log(collections);
		
		A.all('#negotiator').setStyle('display', 'inline');
		
		var url = '<%= startNegotiationURL.toString() %>';
		A.io.request(url,{
			dataType: 'json',
			method: 'post',
			data: {
				<portlet:namespace />searchurl: s_url,
				<portlet:namespace />humanReadable: humanReadable,
				<portlet:namespace />collections: collections
			},
			on: {
				failure: function() { 
					A.all('#negotiatorloader').setStyle('display', 'none');
					A.one('#negotiatordata').setHTML('There is a problem with the server connection.');
				},
				success: function(data) { 
				  	var response = this.get('responseData');
				  	A.all('#negotiatorloader').setStyle('display', 'none');
				  	var redirect_uri = response['redirect_uri'];
				  	window.location = redirect_uri;
				  	A.one('#negotiatordata').setHTML('Negotiation process started:<br><a target="_blank" href="' + redirect_uri + '">' + redirect_uri + '</a>');
				  }
				}
		});
	});
</aui:script>

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
List<D2Biobank> biobanks = D2BiobankLocalServiceUtil.getD2Biobanks(keywords, country_filter, materialtype, diagnosisavailable_filter, biobanksize_filter, typeofbiobank, typeofcollection);
String textresult = "";
String textresult_splitter = "";

JSONArray collectionarray = JSONFactoryUtil.createJSONArray();

if(biobanks != null) {
	for(D2Biobank biobank : biobanks) {
		textresult += textresult_splitter + biobank.getBiobankJavascriptTable();
		textresult_splitter = ",";
		for(D2Collection collection : biobank.getCollections()) {
			JSONObject json = JSONFactoryUtil.createJSONObject();
			json.put("biobankID", biobank.getBbmribiobankID());
			json.put("collectionID", collection.getBbmricollectionID());
			collectionarray.put(json);
		}
	}
}

String textresult_networks = "";
textresult_splitter = "";
List<D2BiobankNetwork> networks = D2BiobankNetworkLocalServiceUtil.getD2BiobankNetworks(-1, -1);
if(networks != null) {
	for(D2BiobankNetwork network : networks) {
		textresult_networks += textresult_splitter + network.getBiobankNetworkJavascriptTable();
		textresult_splitter = ",";
	}
}

%>

<div id="negotiator" style="display: none;width: 100%;">
	<div id="negotiatorloader"></div>
	<div id="negotiatordata" style="float: left;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Start Negotiation ...</div>
	<br>
</div>
<div id="collectionarray" style="display: none;"><%= collectionarray.toString() %></div>

<br />
<span style="font-size: 80%;">Number of Biobanks: <%= biobanks.size() %></span><br>
<div id="BBMRIERICBiobankList">
<div id="ajaxloader"></div>
</div>

<br />

	</div>
    <div id="tab-network">
    
    	<div id="BBMRIERICBiobankNetworkList">
		<div id="ajaxloader-network"></div>
    
    </div>
</div>



<portlet:renderURL var="viewURL">
	<portlet:param name="biobankId" value="xxxxbiobankIdxxxx" />
	<portlet:param name="mvcPath" value="/html/idcard/biobank/view_biobank.jsp" />
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:renderURL>

<portlet:renderURL var="viewNetworkURL">
	<portlet:param name="biobanknetworkId" value="xxxxbiobanknetworkIdxxxx" />
	<portlet:param name="mvcPath" value="/html/idcard/biobank/view_network.jsp" />
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:renderURL>

<aui:script use="node">
	YUI().use(
  'aui-tabview',
  function(Y) {
    new Y.TabView(
      {
        srcNode: '#myTab'
      }
    ).render();
  }
);
</aui:script>

<aui:script use="node,aui-datatable,aui-datatype,datatable-sort">
AUI().use(
  'aui-datatable',
  'aui-datatype',
  'datatable-sort',
  function(Y) {
    var remoteData = [<%= textresult_networks %>];
    var nestedCols = [ 
    	{
    		key: 'Name',
    		sortable: true,
    		allowHTML: true,
    		formatter: function (o) {
    			//encodeURIComponent
    			var url = '<a href="<%= viewNetworkURL %>">' + o.data.Name + '</a>';
    			url = url.replace('xxxxbiobanknetworkIdxxxx', o.data.BB_ID);
    			return url;
    		}
    	},
    	{
    		key: 'Juristic Person',
    		sortable: true
    	},
    	{
    		key: 'Assosiations',
    		sortable: true,
    		allowHTML: true, 
    		formatter: function (o) {
    			//encodeURIComponent
    			var Numberofnetworks = o.data.Numberofnetworks;
    			var Numberofbiobanks = o.data.Numberofbiobanks;
    			var Numberofcollections = o.data.Numberofcollections;
    			var returnvalue = '<a href="#" class="tooltip_size">N' + Numberofnetworks + '/B' + Numberofbiobanks + '/C' + Numberofcollections;
    			returnvalue += '<span>Networks: ' + Numberofnetworks + '<br>Biobanks: ' + Numberofbiobanks + '<br>Collections: ' + Numberofcollections + '</span></a>';
    			return returnvalue;
    		}
    	},
    	{
    		key: 'Collection Focus',
    		sortable: true
    	},
    	{
    		key: 'Charter',
    		sortable: true
    	},
    	{
    		key: 'SOP',
    		sortable: true
    	},
    	{
    		key: 'Data Access Policy',
    		label: 'Data A.P.',
    		sortable: true
    	},
    	{
    		key: 'Sample Access Policy',
    		label: 'Sample A.P.',
    		sortable: true
    	},
    	{
    		key: 'MTA',
    		sortable: true
    	}
    ];
	var dataTable = new Y.DataTable(
      {
        columns: nestedCols,
        data: remoteData,
      }
    ).render('#BBMRIERICBiobankNetworkList');
    

    Y.all('#ajaxloader-network').setStyle('display', 'none');
    
  }
);
</aui:script>
    	

<aui:script use="node,aui-datatable,aui-datatype,datatable-sort">
AUI().use(
  'aui-datatable',
  'aui-datatype',
  'datatable-sort',
  function(Y) {
    var remoteData = [<%= textresult %>];
    var nestedCols = [ 
    	{
    		key: 'Country',
    		sortable: true,
    	},
    	{
    		key: 'Name',
    		sortable: true,
    		allowHTML: true,
    		formatter: function (o) {
    			//encodeURIComponent
    			var url = '<a href="<%= viewURL %>">' + o.data.Name + '</a>';
    			url = url.replace('xxxxbiobankIdxxxx', o.data.BB_ID);
    			return url;
    		}
    	},
    	{
    		key: 'Type',
    		sortable: true
    	},
    	{
    		key: 'Diagnosis',
    		sortable: true
    	},
    	{
    		key: 'CollectionsCount',
    		label: 'Number of Collections',
    		sortable: true,
    		allowHTML: true,
    		formatter: function (o) {
    			//encodeURIComponent
    			var sizeexpond = o.data.Size.toExponential().split('e');
    			var returnvalue = '<a href="#" class="tooltip_size">' + o.data.CollectionsCount;
    			returnvalue += '<span>' + o.data.CollectionList + '</span></a>';
    			return returnvalue;
    		}
    	},
    	{
    		key: 'Size',
    		sortable: true,
    		allowHTML: true, 
    		formatter: function (o) {
    			//encodeURIComponent
    			var sizeexpond = o.data.Size.toExponential().split('e');
    			var returnvalue = '<a href="#" class="tooltip_size">' + sizeexpond[0] + 'x10<sup>' + sizeexpond[1].replace('+', '') + '</sup>';
    			returnvalue += '<span>' + o.data.CollectionList + '</span></a>';
    			return returnvalue;
    		}
    	},
    	{
    		key: 'Juristic Person',
    		sortable: true
    	}
    ];
	var dataTable = new Y.DataTable(
      {
        columns: nestedCols,
        data: remoteData,
      }
    ).render('#BBMRIERICBiobankList');
    dataTable.sort('Country');
    
    Y.all('#ajaxloader').setStyle('display', 'none');;
    
  }
);
</aui:script>