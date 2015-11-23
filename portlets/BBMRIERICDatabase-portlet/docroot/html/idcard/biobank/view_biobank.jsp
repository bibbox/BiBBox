<%@ include file="/html/idcard/init.jsp" %>

<%
D2Biobank biobank = null;
if(biobank == null) {
	long biobankId = ParamUtil.getLong(request, "biobankId");
	biobank = D2BiobankLocalServiceUtil.getD2Biobank(biobankId);
}
String redirect = ParamUtil.getString(request, "redirect");

AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(D2Biobank.class.getName(), biobank.getBiobankId());

String currentURL = PortalUtil.getCurrentURL(request);

List<AssetTag> assetTags = AssetTagLocalServiceUtil.getTags(D2Biobank.class.getName(), biobank.getBiobankId());
PortalUtil.setPageKeywords(ListUtil.toString(assetTags, "name"), request);

biobank = D2BiobankLocalServiceUtil.getBiobankWithLdapUpdate(biobank.getBiobankId());

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	String imgPath = "http://www.geonames.org/flags/x/" + biobank.getBiobankCountry().toLowerCase() + ".gif";
	%>

<style>
.aui #portlet_biobank_WAR_BBMRIERICDatabaseportlet .taglib-header {
	display: inline;
	border-bottom: 1px solid #184b8a;
}
.aui #portlet_biobank_WAR_BBMRIERICDatabaseportlet .taglib-header .header-back-to a {
    padding: 0 0.5em 0.5em 0;
}
</style>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='Back to Directory'
/>

	<br>
	<!-- ID Card -->
	<div class="idcard_idcardbody">
		<!-- top -->
		<div class="idcard_idcardbodytop">
			<span class="idcard_idcardbodytop-id"><b>ID:</b> <%= biobank.getBbmribiobankID() %></span>
			<span class="idcard_idcardbodytop-type"></span>
		</div>
		<!-- middle -->
		<div class="idcard_idcardbodymiddle">
			<img alt="logo" class="idcard_idcardbodymiddle-logo" src="<%= imgPath %>" />
			<div class="idcard_idcardbodymiddle-organizationname"><%= biobank.getBiobankName() %></div>
		</div>
		<!-- bottom -->
		<div class="idcard_idcardbodybottom">
			<div class="idcard_idcardbodybottom-shortdescription">
				<%
				if(biobank.getBiobankDescription().length() == 0) {
					%>
					A short discription of the <%= biobank.getBiobankName() %> Biobank will follow soon.
					<%
				} else {
					if(biobank.getBiobankDescription().length() > 300) {
						%>
						<%= biobank.getBiobankDescription().subSequence(0, 300) %>...
						<%
					} else {
						%>
						<%= biobank.getBiobankDescription() %>
						<%
					}			
				}
				%>
			</div>
			<div class="idcard_idcardbodybottom-menue">
				<div style="width: 110px;font-weight:bold;float:left;">Head:</div><div style="float:left;"><%= HtmlUtil.unescape(biobank.getBiobankHeadFirstName() + " " + biobank.getBiobankHeadLastName()) %></div> <br>
				<div style="width: 110px;font-weight:bold;float:left;">Institution:</div><div style="float:left;"><%= biobank.getBiobankJurisdicalPerson() %></div>
			</div>
		</div>
	</div>
	<br><br>

	<div style="width: 100%;">
	<div class="textsizeidcard" style="width: 100%;">
	<br>
		<h1 class="bbmriericrecentnews">Main Contact</h1>
		<%
		ContactInformation contactinformation = biobank.getContactInformation();
		if(contactinformation != null) {
			%>
			<div><div class="fieldname">Name:</div><div class="fieldvalue"><%= contactinformation.getContactFirstName() + " " + contactinformation.getContactLastName() %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			<%
		
		
		%>
		<div><div class="fieldname">E-Mail:</div><div class="fieldvalue"><a href='<%= "mailto:" + contactinformation.getContactEmail() %>'><%= contactinformation.getContactEmail() %></a></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
		<%
		if(!contactinformation.getHtmlAddress().equalsIgnoreCase("")) {
			%>
			<div><div class="fieldname">Address:</div><div class="fieldvalue"><%= contactinformation.getHtmlAddress() %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			<%
		}
			%>
			<div><div class="fieldname">Phone:</div><div class="fieldvalue"><%= contactinformation.getContactPhone() %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			<%
		}
		%>
		<div style='content: "";clear: both;display: table;'></div>
		<br>
		<h1 class="bbmriericrecentnews">Overview</h1>
		
		<div><div class="fieldname">Biobank Type:</div><div class="fieldvalue"><%= biobank.getBiobankType().replaceAll(", biobankContact", "").replaceAll("biobankContact", "") %></div>
		<div style='content: "";clear: both;display: table;'></div> 
	</div>
		<%
		String biobankPartnerCharterSigned = "not specified";
		if(biobank.getBiobankPartnerCharterSigned()) {
			biobankPartnerCharterSigned = "yes";
		} else {
			biobankPartnerCharterSigned = "no";
		}
		%>
		<div><div class="fieldname">BBMRI-ERIC Partner Charter Signed:</div><div class="fieldvalue"><%= biobankPartnerCharterSigned %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
	
		<%
		if(biobank.getBiobankDescription().length() != 0) {
			%>
			<div><div class="fieldname">Biobank Description:</div><div class="fieldvalue"><%= biobank.getBiobankDescription() %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			
			<%			
		}
		%>
		<br>
		<div style='content: "";clear: both;display: table;'></div>
		<br>
		
		<h1 class="bbmriericrecentnews">Access Condition</h1>
		<%
		String display = "";
		if(biobank.getCollaborationPartnersNonforprofit()) {
			display = "yes";
		} else {
			display = "no";
		}
			%>
			<div><div class="fieldname">Biobank can collaborate with non-for-profit partners:</div><div class="fieldvalue"><%= display %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			<%
		if(biobank.getCollaborationPartnersCommercial()) {
			display = "yes";
		} else {
			display = "no";
		}
			%>
			<div><div class="fieldname">Biobank can collaborate with commercial partners:</div><div class="fieldvalue"><%= display %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			
		<div style='content: "";clear: both;display: table;'></div> 
	</div>
	<br>&nbsp;
	</div>
	<hr>
	<%
	List<D2Collection> collections = biobank.getCollections();
	%>

<div id="collectionTreeView" style="margin-top: 20px;margin-bottom: 15px;"></div>

<style>
.collection-view-hidden {
	display: none;
}
.collection-tree-selected { 
	background: rgba(237, 102, 10,0.4);
	padding-left: 5px;
	padding-right: 5px;
	border-radius: 5px;
}
</style>

	<div class="collections-view">
	<% 
			String cssdisplayclass = "collection-view";
		    for(D2Collection collection : collections) {
			    %>
			    <div id="collection-<%= collection.getD2collectionId() %>" class="<%= cssdisplayclass %>">
			    	<!-- Name & Collection Type -->
			    	<%
			    	String acronym = "";
			    	if(!collection.getCollectionAcronym().equals("")) {
			    		acronym = "(" + collection.getCollectionAcronym() + ")";
			    	}
			    	%>
			    	<h1 style="color: #8bbf39;"><%= collection.getCollectionName() %> <%= acronym %></h1>
			    	<!-- Main Contact -->
			    	<h1 class="bbmriericrecentnews">Main Contact</h1>
			    	<%
					ContactInformation contactinformation_collection = collection.getContactInformation();
					if(contactinformation != null) {
						%>
						<div>
							<div class="fieldname">Name:</div>
							<div class="fieldvalue"><%= contactinformation_collection.getContactFirstName() + " " + contactinformation_collection.getContactLastName() %></div>
							<div style='content: "";clear: both;display: table;'></div> 
						</div>
						<div>
							<div class="fieldname">E-Mail:</div>
							<div class="fieldvalue"><a href='<%= "mailto:" + contactinformation_collection.getContactEmail() %>'><%= contactinformation_collection.getContactEmail() %></a></div>
							<div style='content: "";clear: both;display: table;'></div> 
						</div>
						<%
						if(!contactinformation_collection.getHtmlAddress().equalsIgnoreCase("")) {
							%>
							<div>
								<div class="fieldname">Address:</div>
								<div class="fieldvalue"><%= contactinformation_collection.getHtmlAddress() %></div>
								<div style='content: "";clear: both;display: table;'></div> 
							</div>
							<%
						}
						%>
						<%
						if(!contactinformation_collection.getContactPhone().equalsIgnoreCase("")) {
							%>
							<div>
								<div class="fieldname">Phone:</div>
								<div class="fieldvalue"><%= contactinformation_collection.getContactPhone() %></div>
								<div style='content: "";clear: both;display: table;'></div> 
							</div>
							<%
						}
						%>
						<%
					}
					%>
			    	<div style='content: "";clear: both;display: table;'></div>
					<br>
			    	<!-- Overview -->
			    	<h1 class="bbmriericrecentnews">Overview</h1>
			    	<div>
						<div class="fieldname">Head:</div>
						<div class="fieldvalue"><%= collection.getCollectionHeadFirstName() + " " + collection.getCollectionHeadLastName() %></div>
						<div style='content: "";clear: both;display: table;'></div> 
					</div>
					<div>
						<div class="fieldname">Collection Type:</div>
						<div class="fieldvalue"><%= collection.getCollectionTypeHTML() %></div>
						<div style='content: "";clear: both;display: table;'></div> 
					</div>
					<div>
						<div class="fieldname">Collection Size:</div>
						<%
						String size = "";
						if(collection.getCollectionSize() != 0) {
							size += collection.getCollectionSize() + " Samples";
		    			} else {
		    				if(collection.getCollectionOrderOfMagnitude() ==  0) {
		    					size = "< 10 Samples";
		    				} else if(collection.getCollectionOrderOfMagnitude() ==  1) {
		    					size = "10 - 100 Samples";
		    				} else if(collection.getCollectionOrderOfMagnitude() ==  2) {
		    					size = "100 - 1.000 Samples";
		    				} else if(collection.getCollectionOrderOfMagnitude() ==  3) {
		    					size = "1.000 - 10.000 Samples";
		    				} else if(collection.getCollectionOrderOfMagnitude() ==  4) {
		    					size = "10.000 - 100.000 Samples";
		    				} else if(collection.getCollectionOrderOfMagnitude() ==  5) {
		    					size = "100.000 - 1.000.000 Samples";
		    				} else if(collection.getCollectionOrderOfMagnitude() ==  6) {
		    					size = "1.000.000 - 10.000.000 Samples";
		    				} else if(collection.getCollectionOrderOfMagnitude() ==  7) {
		    					size = "10.000.000 - 100.000.000 Samples";
		    				} else if(collection.getCollectionOrderOfMagnitude() ==  8) {
		    					size = "100.000.000 - 1.000.000.000 Samples";
		    				} else  {
		    					size = "Sample size not specified";
		    				}
		    			}
						%>
						<div class="fieldvalue"><%= size %></div>
						<div style='content: "";clear: both;display: table;'></div> 
					</div>
					<%
					if(collection.getCollectionAgeLow() != 0 || collection.getCollectionAgeHigh() != 0) {
						%>
						<div>
							<div class="fieldname">Collection age distribution:</div>
							<div class="fieldvalue"><%= collection.getCollectionAgeLow() + " - " + collection.getCollectionAgeHigh() + collection.getCollectionAgeUnit() %></div>
							<div style='content: "";clear: both;display: table;'></div> 
						</div>
						<%
		    		}
					%>
					<%
					if(collection.getCollectionSexFemale() || collection.getCollectionSexMale() || collection.getCollectionSexUndiferrentiated() || collection.getCollectionSexUnknown()) {
						String splitter = "";
						%>
						<div>
							<div class="fieldname">Gender:</div>
							<div class="fieldvalue">
								<%
								if(collection.getCollectionSexFemale()) {
									%>
									<%= splitter %>Female
									<%
									splitter = ", ";
								}
								if(collection.getCollectionSexMale()) {
									%>
									<%= splitter %>Male
									<%
									splitter = ", ";
								}
								if(collection.getCollectionSexUndiferrentiated()) {
									%>
									<%= splitter %>Undiferrentiated
									<%
									splitter = ", ";
								}
								if(collection.getCollectionSexUnknown()) {
									%>
									<%= splitter %>Unknown
									<%
									splitter = ", ";
								}
								%>
							</div>
							<div style='content: "";clear: both;display: table;'></div> 
						</div>
						<%
		    		}
					%>
					<div>
						<div class="fieldname">Collection storage temperature:</div>
						<div class="fieldvalue"><%= collection.getCollectionTemeratureHTML() %></div>
						<div style='content: "";clear: both;display: table;'></div> 
					</div>
					<div>
						<div class="fieldname">Collection Description:</div>
						<div class="fieldvalue"><%= collection.getCollectionDescription() %></div>
						<div style='content: "";clear: both;display: table;'></div> 
					</div>
			    	<!-- Material Type -->
			    	<h1 class="bbmriericrecentnews">Material Type</h1>
			    	<div class="fieldvalue" style="width: 545px;"><%= collection.getCollectionMaterialTypeHTML() %></div>
					<div style='content: "";clear: both;display: table;'></div> 
			    	<!-- Available Data -->
			    	<h1 class="bbmriericrecentnews">Available Data</h1>
			    	<div class="fieldvalue" style="width: 545px;"><%= collection.getCollectionDataAvailableHTML() %></div>
					<div style='content: "";clear: both;display: table;'></div> 
			    	<!-- Available Diagnosis -->
			    	<h1 class="bbmriericrecentnews">Available Diagnosis</h1>
			    	<div class="fieldvalue" style="width: 545px;"><%= collection.getDiagnosisAvailable().replaceAll("urn:miriam:", "") %></div>
					<div style='content: "";clear: both;display: table;'></div> 
					<!-- Access Condition -->
					<h1 class="bbmriericrecentnews">Access Condition</h1>
					<div>
						<%
						String display_access = "";
						if(collection.getCollectionSampleAccessFee()) {
							display_access = "yes";
						} else {
							display_access = "no";
						}
						%>
						<div class="fieldname">Sample Access Fee:</div>
						<div class="fieldvalue"><%= display_access %></div>
						<div style='content: "";clear: both;display: table;'></div> 
					</div>
					<div>
						<%
						display_access = "";
						if(collection.getCollectionSampleAccessJointProjects()) {
							display_access = "yes";
						} else {
							display_access = "no";
						}
						%>
						<div class="fieldname">Sample Access on Joint Projects:</div>
						<div class="fieldvalue"><%= display_access %></div>
						<div style='content: "";clear: both;display: table;'></div> 
					</div>
					<%
					if(!collection.getCollectionSampleAccessDescription().equals("")) {
						%>
						<div>
							<div class="fieldname">Sample Access Rules:</div>
							<div class="fieldvalue"><%= collection.getCollectionSampleAccessDescription() %></div>
							<div style='content: "";clear: both;display: table;'></div> 
						</div>
						<%
					}
					%>
					<%
					if(!collection.getCollectionSampleAccessURI().equals("")) {
						%>
						<div>
							<div class="fieldname">URL for access policy for the samples:</div>
							<div class="fieldvalue"><%= collection.getCollectionSampleAccessURI() %></div>
							<div style='content: "";clear: both;display: table;'></div> 
						</div>
						<%
					}
					%>
					<div>
						<%
						display_access = "";
						if(collection.getCollectionDataAccessFee()) {
							display_access = "yes";
						} else {
							display_access = "no";
						}
						%>
						<div class="fieldname">Data Access Fee:</div>
						<div class="fieldvalue"><%= display_access %></div>
						<div style='content: "";clear: both;display: table;'></div> 
					</div>
					<div>
						<%
						display_access = "";
						if(collection.getCollectionDataAccessJointProjects()) {
							display_access = "yes";
						} else {
							display_access = "no";
						}
						%>
						<div class="fieldname">Data Access on Joint Projects:</div>
						<div class="fieldvalue"><%= display_access %></div>
						<div style='content: "";clear: both;display: table;'></div> 
					</div>
					<%
					if(!collection.getCollectionDataAccessDescription().equals("")) {
						%>
						<div>
							<div class="fieldname">Access Rules:</div>
							<div class="fieldvalue"><%= collection.getCollectionDataAccessDescription() %></div>
							<div style='content: "";clear: both;display: table;'></div> 
						</div>
						<%
					}
					%>
					<%
					if(!collection.getCollectionDataAccessURI().equals("")) {
						%>
						<div>
							<div class="fieldname">URL for access policy for the data:</div>
							<div class="fieldvalue"><%= collection.getCollectionDataAccessURI() %></div>
							<div style='content: "";clear: both;display: table;'></div> 
						</div>
						<%
					}
					%>
			    </div>
			    <%
			    cssdisplayclass = "collection-view collection-view-hidden";
		    }
		    %>
		</div>

<liferay-ui:asset-links
        assetEntryId="<%= (assetEntry != null) ? assetEntry.getEntryId() : 0 %>"
        className="<%= D2Biobank.class.getName() %>"
        classPK="<%= biobank.getBiobankId() %>" />
        
<%
List<D2Collection> rootcollections = biobank.getRootCollections();
String collectiontree = "";
String select_css = "collection-tree-selected";
for(D2Collection rootcollection : rootcollections) {
	collectiontree += "{" + rootcollection.getChildD2CollectionAuiTreeStructure() + "expanded: true,label: '<span id=\"treecollection-" + rootcollection.getD2collectionId() + "\" class=\"" + select_css + "\">" + rootcollection.getCollectionName() + "</span>'},";
	select_css = "";
}
%>

<!-- Create Collection Tree -->
<aui:script>
YUI().use(
  'aui-tree-view',
  function(Y) {
  	var collectiontree = [<%= collectiontree %>];
    new Y.TreeViewDD(
      {
        boundingBox: '#collectionTreeView',
        children: collectiontree
      }
    ).render();
  }
);
</aui:script>  
<!-- Display the selected Collection -->
<aui:script>
YUI().use('aui-node',function(Y) {
	var nodes = Y.all('.tree-node');
	nodes.on(
      'click',
      function(event) {
      	var id = event.target.get("id");
      	var node = event.target;
      	if(id.startsWith('yui_')) {
      		id = node.get('parentNode').one('span').one('span').get("id");
      	}
      	id = id.replace("treecollection-", "");
      	Y.all('.collection-view').addClass('collection-view-hidden');
      	Y.one('#collection-' + id).removeClass('collection-view-hidden');
      	Y.all('.collection-tree-selected').removeClass('collection-tree-selected');
      	Y.one('#treecollection-' + id).addClass('collection-tree-selected');
      }
    );
});
</aui:script>    