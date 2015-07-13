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
.idcard_idcardbodybottom-shortdescription {
	width: 436px;
	height:60px;
	padding-top: 30px;
	margin-left: 54px;
	margin-right: 54px;
	margin-bottom: 20px;
	overflow: hidden;
  	text-overflow: ellipsis;
}
.idcard_idcardbodybottom-menue {
	width: 494px;
	height:40px;
	margin-left: 25px;
	margin-right: 25px;
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
	%>
	<div><aui:a href="/services">Services</aui:a> / <aui:a href="/bbmri-eric-catalouge-beta2">Catalogue</aui:a> / <aui:a href="bbmri-eric-catalouge-beta2"><%= biobank.getBiobankname() %></aui:a></div>
	<br>
	<!-- ID Card -->
	<div class="idcard_idcardbody">
		<!-- top -->
		<div class="idcard_idcardbodytop">
			<span class="idcard_idcardbodytop-id">ID # <%= biobankId %></span>
			<span class="idcard_idcardbodytop-type"></span>
		</div>
		<!-- middle -->
		<div class="idcard_idcardbodymiddle">
			<aui:a href="<%= orgPath %>"><img alt="logo" class="idcard_idcardbodymiddle-logo" src="<%= imgPath %>" /></aui:a>
			<div class="idcard_idcardbodymiddle-organizationname"><%= biobank.getBiobankname() %></div>
		</div>
		<!-- bottom -->
		<div class="idcard_idcardbodybottom">
			<div class="idcard_idcardbodybottom-shortdescription"><%= biobank.getBiobankdescription() %>
			</div>
			<div class="idcard_idcardbodybottom-menue">
				<%= biobank.getBiobankjuristicperson() %>
			</div>
		</div>
	</div>
	<br><br>
	<div>
	<br>
		<h3>Main Contact</h3>
		<%
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
		if(!name.equalsIgnoreCase("")) {
			%>
			Name: <%= name %><br>
			<%
		}
		String email = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankContactEmail").getSearchindexvalue();
		%>
		E-Mail: <a href='<%= "mailto:" + email %>'><%= email %></a><br>
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
			Address: <%= address %><br>
			<%
		}
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankContactPhone");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			%>
			Phone: <%= searchindex.getSearchindexvalue() %><br>
			<%
		}
		%>
		<br>
		<h3>Overview</h3>
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
			Biobank Size: <%= bbsize %><br>
			<%
		}
		%>
		Biobank Type: <%= biobank.getBiobanktype().replaceAll(", biobankContact", "").replaceAll("biobankContact", "") %><br>
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
		BBMRI-ERIC Partner Charter Signed: <%= biobankPartnerCharterSigned %><br>
		
		<br>
		<h3>Material Type</h3>
		<%
		String[] biobankmaterialstoredarray = {"biobankMaterialStoredDNA","biobankMaterialStoredcDNAmRNA","biobankMaterialStoredmicroRNA",
				"biobankMaterialStoredWholeBlood","biobankMaterialStoredPBC","biobankMaterialStoredPlasma","biobankMaterialStoredSerum",
				"biobankMaterialStoredTissueCryo","biobankMaterialStoredTissueParaffin","biobankMaterialStoredCellLines","biobankMaterialStoredUrine",
				"biobankMaterialStoredSaliva","biobankMaterialStoredFaeces","biobankMaterialStoredPathogen","biobankMaterialStoredRNA",
				"biobankMaterialStoredOther"};
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
		
		<br>
		<h3>Available Data</h3>
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
		
		<br>
		<h3>Available Diagnosis</h3>
		<%
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "diagnosisAvailable");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			%>
			Available diagnosis: <%= searchindex.getSearchindexvalue() %><br>
			<%
		}
		%>
		
		<br>
		<h3>Access Condition</h3>
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
			Sample Access Fee: <%= display %><br>
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
			Sample Access on Joint Projects: <%= display %><br>
			<%
		}
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankSampleAccessDescription");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			if(searchindex.getSearchindexvalue().equalsIgnoreCase("true")) {
				display = "yes";
			} else {
				display = "no";
			}
			%>
			Sample Access Rules: <%= display %><br>
			<%
		}
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankSampleAccessURI");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			%>
			URL for access policy for the samples: <aui:a href="<%= searchindex.getSearchindexvalue() %>">here</aui:a><br>
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
			Data Access Fee: <%= display %><br>
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
			Data Access on Joint Projects: <%= display %><br>
			<%
		}
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankDataAccessDescription");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			if(searchindex.getSearchindexvalue().equalsIgnoreCase("true")) {
				display = "yes";
			} else {
				display = "no";
			}
			%>
			Data Access Rules: <%= display %><br>
			<%
		}
		searchindex = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankDataAccessURI");
		if(searchindex != null && !searchindex.getSearchindexvalue().equalsIgnoreCase("")) {
			%>
			URL for access policy for the data: <aui:a href="<%= searchindex.getSearchindexvalue() %>">here</aui:a><br>
			<%
		}
		%>
	</div>
	
	<%
}
%>