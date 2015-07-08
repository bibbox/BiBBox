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
		String email = SearchIndexLocalServiceUtil.getSearchIndex(biobank.getOrganisationid(), "biobankContactLastName").getSearchindexvalue();
		%>
		E-Mail: <aui:a href="<%= email %>"><%= email %></aui:a><br>
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
				address = searchindex.getSearchindexvalue();
			} else {
				address += ", " + searchindex.getSearchindexvalue();
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
		<h3>Overview</h3>
		<h3>Material Type</h3>
		<h3>Available Data</h3>
		<h3>Available Diagnosis</h3>
		<h3>Access Condition</h3>
	</div>
	
	<%
}
%>