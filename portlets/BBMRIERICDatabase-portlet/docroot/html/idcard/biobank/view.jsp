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
String keywords = ParamUtil.getString(request, "keywords");

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

<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/html/idcard/biobank/view.jsp" />
</liferay-portlet:renderURL>
<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />
	
	<aui:layout>
		<aui:fieldset>
		 
			<aui:column columnWidth="100" first="true">
				<input style="width: 458px;" type="text" placeholder="search by: BioBank Name ..." value="<%= keywords %>" name="<portlet:namespace />keywords" size="100">
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
				</aui:button-row>
			</aui:column>
		</aui:fieldset>
		
	</aui:layout>
</aui:form>

<br />

<div id="BBMRIERICBiobankList">
<div id="ajaxloader"></div>
</div>

<br />

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
List<D2Biobank> biobanks = D2BiobankLocalServiceUtil.getD2Biobanks(keywords, country_filter, materialtype, diagnosisavailable_filter, biobanksize_filter, typeofbiobank, typeofcollection);
String textresult = "";
String textresult_splitter = "";
if(biobanks != null) {
	for(D2Biobank biobank : biobanks) {
		textresult += textresult_splitter + biobank.getBiobankJavascriptTable();
		textresult_splitter = ",";
	}
}
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="biobankId" value="xxxxbiobankIdxxxx" />
	<portlet:param name="mvcPath" value="/html/idcard/biobank/view_biobank.jsp" />
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:renderURL>

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
    

    Y.all('#ajaxloader').setStyle('display', 'none');;
    
  }
);
</aui:script>