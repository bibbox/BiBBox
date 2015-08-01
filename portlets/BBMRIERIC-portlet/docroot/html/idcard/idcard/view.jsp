<%@ include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<style>
.balbalbal {
	left:16px;
	top:-32px;
	padding-top: 24px;
}
.idcard_idcardbody {
	background-color:#E2E3CE;
	border-radius:25px;
	box-shadow: 5px 7px 20px rgba(0,0,0,0.2);
	height:322px;
	width:544px;
}

.idcard_idcardbodytop {
	height:32px;
	width:100%;
	font-size:12px;
	padding-top: 7px;
}
.idcard_idcardbodytop-id {
	margin-left: 40px;
	float: left;
	width:322px;
}
.idcard_idcardbodytop-type {
	float: left;
	width: 158px;
}

.idcard_idcardbodymiddle {
	height:116px;
	width:100%;
	background-color:#FFFFFF;
}
.idcard_idcardbodymiddle-logo {
	margin-left: 26px;
	margin-top: 20px;
	float: left;
	margin-right: 20px;
}
.aui .idcard_idcardbodymiddle img {
	height:85px;
}
.idcard_idcardbodymiddle-organizationname {
	font-size: 18px;
	font-weight:bold;
	color: #8BBF39;
	width: 100%;
	height:116px;
	display: table-cell;
	vertical-align: middle;
}

.idcard_idcardbodybottom {
	height:150px;
	width:100%;
}
.idcard_idcardbodybottom-shortdescription:before, .idcard_idcardbodybottom-shortdescription:after, .idcard_idcardbodybottom-shortdescription > * {
	opacity: 1; 
}

.idcard_idcardbodybottom-shortdescription {
	width: 436px;
	height:60px;
	padding-top: 30px;
	margin-left: 40px;
	margin-right: 54px;
	margin-bottom: 20px;
	overflow: hidden;
  	text-overflow: ellipsis;
  	font-size: 16px;
}

.idcard_idcardbodybottom-shortdescription:before {
	content: "";
	float: left;
	width: 5px; 
	height: 60px; 
}

.idcard_idcardbodybottom-shortdescription > *:first-child {
	float: right;
	width: 100%; 
	margin-left: -5px;
}
.idcard_idcardbodybottom-shortdescription:after {
	content: "...";
	float: right; 
	position: relative;
	top: -20px;	
	left: 100%;
	width: 25px; 
	margin-left: -25px;
	padding-right: 5px;
	background: red; 
	font-size: 14px; 
	opacity: 0.95;
}
.idcard_idcardbodybottom-menue {
	width: 494px;
	height:40px;
	margin-left: 40px;
	margin-right: 10px;
}
</style>


<%
String biobankId = "";
HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
biobankId = httpRequest.getParameter("biobankId");
if (biobankId == null) {
	biobankId = "";
}

if(!biobankId.equalsIgnoreCase("")) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	BioBank biobank = BioBankLocalServiceUtil.getBioBank(biobankId);
	List<SearchIndex> searchindexs = SearchIndexLocalServiceUtil.getSearchIndexForOrganization(biobank.getOrganisationid());
	String orgPath = "#";
	String imgPath = "http://www.geonames.org/flags/x/" + biobank.getBiobankcountry().toLowerCase() + ".gif";
	String name = "";
	SearchIndex searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankContactFirstName");
	if(searchindex != null) {
		name = searchindex.getSearchindexvalue();
	}
	searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankContactLastName");
	if(searchindex != null) {
		if(name.equalsIgnoreCase("")) {
			name = searchindex.getSearchindexvalue();
		} else {
			name += " " + searchindex.getSearchindexvalue();
		}
	}
	String biobankDescription = "";
	searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankDescription");
	if(searchindex != null) {
		biobankDescription = searchindex.getSearchindexvalue();
	}
	%>
	<div><aui:a href="/services">Services</aui:a> / <aui:a href="/bbmri-eric-directory-1.0">Directory 1.0</aui:a> / <aui:a href='<%= "id-card-beta?biobankId=" + biobank.getLdapbiobankID() %>'><%= biobank.getBiobankname() %></aui:a></div>
	<br>
	<!-- ID Card -->
	<div class="idcard_idcardbody">
		<!-- top -->
		<div class="idcard_idcardbodytop">
			<span class="idcard_idcardbodytop-id"><b>ID:</b> <%= biobankId %></span>
			<span class="idcard_idcardbodytop-type"></span>
		</div>
		<!-- middle -->
		<div class="idcard_idcardbodymiddle">
			<aui:a href="<%= orgPath %>"><img alt="logo" class="idcard_idcardbodymiddle-logo" src="<%= imgPath %>" /></aui:a>
			<div class="idcard_idcardbodymiddle-organizationname"><%= biobank.getBiobankname() %></div>
		</div>
		<!-- bottom -->
		<div class="idcard_idcardbodybottom">
			<div class="idcard_idcardbodybottom-shortdescription">
				<%
				if(biobankDescription.length() == 0) {
					%>
					A short discription of the <%= biobank.getBiobankname() %> Biobank will follow soon.
					<%
				} else {
					%>
					<%= biobankDescription %>
					<%			
				}
				%>
			</div>
			<div class="idcard_idcardbodybottom-menue">
				<div style="width: 90px;font-weight:bold;float:left;">PI:</div><div style="float:left;"><%= name %></div> <br>
				<div style="width: 90px;font-weight:bold;float:left;">Hosted by:</div><div style="float:left;"><%= biobank.getBiobankjuristicperson() %></div>
			</div>
		</div>
	</div>
	<br><br>
	<style>
	.aui .textsizeidcard {
		font-size: 16px;
		float: left;
	}
	.aui .fieldname {
		font-weight: bold;
		width: 170px;
		float: left;
		margin-right: 5px;
	}
	.aui .fieldvalue {
		width: 370px;
		float: left;
	}
	</style>
	<div style="width: 100%;">
	<div class="textsizeidcard" style="width: 100%;">
	<br>
		<h1 class="bbmriericrecentnews">Main Contact</h1>
		<%
		
		if(!name.equalsIgnoreCase("")) {
			%>
			<div><div class="fieldname">Name:</div><div class="fieldvalue"><%= name %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			<%
		}
		String email = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankContactEmail").getSearchindexvalue();
		%>
		<div><div class="fieldname">E-Mail:</div><div class="fieldvalue"><a href='<%= "mailto:" + email %>'><%= email %></a></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
		<%
		String address = "";
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankContactAddress");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			address = searchindex.getSearchindexvalue();
		}
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankContactZIP");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			if(address.equalsIgnoreCase("")) {
				address = searchindex.getSearchindexvalue();
			} else {
				address += ", " + searchindex.getSearchindexvalue();
			}
		}
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankContactCity");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			if(address.equalsIgnoreCase("")) {
				address = searchindex.getSearchindexvalue();
			} else {
				address += " " + searchindex.getSearchindexvalue();
			}
		}
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankContactCountry");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			if(address.equalsIgnoreCase("")) {
				address = com.liferay.portal.service.CountryServiceUtil.getCountryByA2(searchindex.getSearchindexvalue()).getNameCurrentValue();
			} else {
				address += ", " + com.liferay.portal.service.CountryServiceUtil.getCountryByA2(searchindex.getSearchindexvalue()).getNameCurrentValue();
			}
		}
		if(!address.equalsIgnoreCase("")) {
			%>
			<div><div class="fieldname">Address:</div><div class="fieldvalue"><%= address %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			<%
		}
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankContactPhone");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			%>
			<div><div class="fieldname">Phone:</div><div class="fieldvalue"><%= searchindex.getSearchindexvalue() %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			<%
		}
		%>
		<div style='content: "";clear: both;display: table;'></div>
		<br>
		<h1 class="bbmriericrecentnews">Overview</h1>
		<%
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankSize");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			String bbsize = "";
			if(searchindex.getSearchindexvalue().equalsIgnoreCase("0")) {
	        	 bbsize = "< 10 Samples";
			} else if(searchindex.getSearchindexvalue().equalsIgnoreCase("1")) {
	        	 bbsize = "10 - 100 Samples";
			} else if(searchindex.getSearchindexvalue().equalsIgnoreCase("2")) {
	        	 bbsize = "100 - 1.000 Samples";
			} else if(searchindex.getSearchindexvalue().equalsIgnoreCase("3")) {
	        	 bbsize = "1.000 - 10.000 Samples";
			} else if(searchindex.getSearchindexvalue().equalsIgnoreCase("4")) {
	        	 bbsize = "10.000 - 100.000 Samples";
			} else if(searchindex.getSearchindexvalue().equalsIgnoreCase("5")) {
	        	 bbsize = "100.000 - 1.000.000 Samples";
			} else if(searchindex.getSearchindexvalue().equalsIgnoreCase("6")) {
	        	 bbsize = "1.000.000 - 10.000.000 Samples";
			} else if(searchindex.getSearchindexvalue().equalsIgnoreCase("7")) {
	        	 bbsize = "10.000.000 - 100.000.000 Samples";
			} else if(searchindex.getSearchindexvalue().equalsIgnoreCase("8")) {
	        	 bbsize = "100.000.000 - 1.000.000.000 Samples";
			} else  {
	        	 bbsize = "Samples not specified";
			}
			%>
			<div><div class="fieldname">Biobank Size:</div><div class="fieldvalue"><%= bbsize %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			<%
		}
		%>
		<div><div class="fieldname">Biobank Type:</div><div class="fieldvalue"><%= biobank.getBiobanktype().replaceAll(", biobankContact", "").replaceAll("biobankContact", "") %></div>
		<div style='content: "";clear: both;display: table;'></div> 
	</div>
		<%
		String biobankPartnerCharterSigned = "not specified";
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankPartnerCharterSigned");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			if(searchindex.getSearchindexvalue().equalsIgnoreCase("true")) {
				biobankPartnerCharterSigned = "yes";
			} else {
				biobankPartnerCharterSigned = "no";
			}
		}
		%>
		<div><div class="fieldname">BBMRI-ERIC Partner Charter Signed:</div><div class="fieldvalue"><%= biobankPartnerCharterSigned %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
	
		<%
		if(biobankDescription.length() != 0) {
			%>
			<div><div class="fieldname">Biobank Description:</div><div class="fieldvalue"><%= biobankDescription %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			
			<%			
		}
		%>
		<br>
		<div style='content: "";clear: both;display: table;'></div>
		<br>
		<h1 class="bbmriericrecentnews">Material Type</h1>
		<%
		/*String[] biobankmaterialstoredarray = {"biobankMaterialStoredDNA","biobankMaterialStoredcDNAmRNA","biobankMaterialStoredmicroRNA",
				"biobankMaterialStoredWholeBlood","biobankMaterialStoredPBC","biobankMaterialStoredPlasma","biobankMaterialStoredSerum",
				"biobankMaterialStoredTissueCryo","biobankMaterialStoredTissueFFPE","biobankMaterialStoredCellLines","biobankMaterialStoredUrine",
				"biobankMaterialStoredSaliva","biobankMaterialStoredFaeces","biobankMaterialStoredPathogen","biobankMaterialStoredRNA",
				"biobankMaterialStoredOther"};*/
		
		String[] biobankmaterialstoredarray = {"biobankMaterialStoredDNA",
		 "biobankMaterialStoredPlasma",
		 "biobankMaterialStoredSerum",
		 "biobankMaterialStoredUrine",
		 "biobankMaterialStoredSaliva",
		 "biobankMaterialStoredFaeces",
		 "biobankMaterialStoredOther",
		 "biobankMaterialStoredRNA",
		 "biobankMaterialStoredBlood",
		 "biobankMaterialStoredTissueFrozen",
		 "biobankMaterialStoredTissueFFPE",
		 "biobankMaterialStoredImmortalizedCellLines",
		 "biobankMaterialStoredIsolatedPathogen"};
		
		String biobankmaterialstored_display = "";
		String splitter = "";
		for(String biobankmaterialstored : biobankmaterialstoredarray) {
			searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), biobankmaterialstored);
			if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("") && searchindex.getSearchindexvalue().equalsIgnoreCase("true")) {
				biobankmaterialstored_display += splitter + searchindex.getSearchindexkey().replaceAll("biobankMaterialStored", "");
				splitter = ", ";
			}
		}
		%>
		<%= biobankmaterialstored_display %><br>
		
		<div style='content: "";clear: both;display: table;'></div>
		<br>
		<h1 class="bbmriericrecentnews">Available Data</h1>
		<%
		String[] biobankdataarray = {"biobankAvailableMaleSamplesData","biobankAvailableFemaleSamplesData","biobankAvailableBiologicalSamples",
				"biobankAvailableSurveyData","biobankAvailableImagingData","biobankAvailableMedicalRecords","biobankAvailableNationalRegistries",
				"biobankAvailableGenealogicalRecords","biobankAvailablePhysioBiochemMeasurements","biobankAvailableOther"};
		String biobankdata_display = "";
		splitter = "";
		for(String biobankdata : biobankdataarray) {
			searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), biobankdata);
			if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("") && searchindex.getSearchindexvalue().equalsIgnoreCase("true")) {
				biobankdata_display += splitter + searchindex.getSearchindexkey().replaceAll("biobankAvailable", "");
				splitter = ", ";
			}
		}
		%>
		<%= biobankdata_display %><br>
		
		<div style='content: "";clear: both;display: table;'></div>
		<br>
		<h1 class="bbmriericrecentnews">Available Diagnosis</h1>
		<%
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "diagnosisAvailable");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			%>
			<div><div class="fieldname">Available diagnosis:</div><div class="fieldvalue"><%= searchindex.getSearchindexvalue().replaceAll("urn:miriam:", "") %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			<%
		}
		%>
		
		<div style='content: "";clear: both;display: table;'></div>
		<br>
		<h1 class="bbmriericrecentnews">Access Condition</h1>
		<%
		String display = "";
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankSampleAccessFee");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			if(searchindex.getSearchindexvalue().equalsIgnoreCase("true")) {
				display = "yes";
			} else {
				display = "no";
			}
			%>
			<div><div class="fieldname">Sample Access Fee:</div><div class="fieldvalue"><%= display %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			<%
		}
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankSampleAccessJointProjects");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			if(searchindex.getSearchindexvalue().equalsIgnoreCase("true")) {
				display = "yes";
			} else {
				display = "no";
			}
			%>
			<div><div class="fieldname">Sample Access on Joint Projects:</div><div class="fieldvalue"><%= display %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			<%
		}
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankSampleAccessDescription");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			display = searchindex.getSearchindexvalue();
			%>
			<div><div class="fieldname">Sample Access Rules:</div><div class="fieldvalue"><%= display %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			<%
		}
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankSampleAccessURI");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			%>
			<div><div class="fieldname">URL for access policy for the samples:</div><div class="fieldvalue"><aui:a href="<%= searchindex.getSearchindexvalue() %>">here</aui:a></div>
			<div style='content: "";clear: both;display: table;'></div> 
	</div>
			<%
		}
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankDataAccessFee");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			if(searchindex.getSearchindexvalue().equalsIgnoreCase("true")) {
				display = "yes";
			} else {
				display = "no";
			}
			%>
			<div><div class="fieldname">Data Access Fee:</div><div class="fieldvalue"><%= display %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			<%
		}
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankDataAccessJointProjects");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			if(searchindex.getSearchindexvalue().equalsIgnoreCase("true")) {
				display = "yes";
			} else {
				display = "no";
			}
			%>
			<div><div class="fieldname">Data Access on Joint Projects:</div><div class="fieldvalue"><%= display %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			<%
		}
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankDataAccessDescription");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			display = searchindex.getSearchindexvalue();
			%>
			<div><div class="fieldname">Data Access Rules:</div><div class="fieldvalue"><%= display %></div><div style='content: "";clear: both;display: table;'></div> 
	</div>
			<%
		}
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankDataAccessURI");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			%>
			<div><div class="fieldname">URL for access policy for the data:</div><div class="fieldvalue"><aui:a href="<%= searchindex.getSearchindexvalue() %>">here</aui:a></div>
			<div style='content: "";clear: both;display: table;'></div> 
	</div>
			<%
		}
		%>
		<div style='content: "";clear: both;display: table;'></div> 
	</div>
	<br>&nbsp;
	</div>
	<br><br>
	<%
}
%>