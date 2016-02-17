<%@ include file="/html/idcard/init.jsp" %>

<%
D2BiobankNetwork network = null;
if(network == null) {
	long biobanknetworkId = ParamUtil.getLong(request, "biobanknetworkId");
	network = D2BiobankNetworkLocalServiceUtil.getD2BiobankNetwork(biobanknetworkId);
}
String redirect = ParamUtil.getString(request, "redirect");
String redirect_this = PortalUtil.getCurrentURL(renderRequest);

String imgPath = request.getContextPath() + "/image/network.png";
String imgPath_bg = request.getContextPath() + "/image/network_bg.png";

ContactInformation contactinformation = network.getContactInformation();
String contact_name = "";
if(contactinformation != null) {
	contact_name = contactinformation.getContactFirstName() + " " + contactinformation.getContactLastName();
}

%>

<style>
.email_float_left {
    float: left;
}
.email_float {
    float: right;
}
.point_class:before {
	content: ".";
}
.aui #portlet_biobank_WAR_BBMRIERICDatabaseportlet .taglib-header {
	display: inline;
	border-bottom: 1px solid #184b8a;
}
.aui #portlet_biobank_WAR_BBMRIERICDatabaseportlet .taglib-header .header-back-to a {
    padding: 0 0.5em 0.5em 0;
}
.idcard_idcardbody {
	background-color: #6D8EC9;
	background-image: url("<%= imgPath_bg %>");
	color: #FFFFFF;
	background-position: center;
	background-size:contain;
	background-repeat:no-repeat;
}
.idcard_idcardbodymiddle {
    background-color: rgba(255,255,255,0.7);
    height: 116px;
    width: 100%;
}
.idcard_idcardbodymiddle-organizationname {
    color: #184b8a;
}
.aui .fieldname-long {
	float: left;
    font-weight: bold;
    margin-right: 5px;
    width: 470px;
}
</style>
<liferay-ui:header
	backURL="<%= redirect %>"
	title='Back'
/>
	<br>
	<!-- ID Card -->
	<div class="idcard_idcardbody">
		<!-- top -->
		<div class="idcard_idcardbodytop">
			<span class="idcard_idcardbodytop-id"><b>ID:</b> <%= network.getBbmriBiobankNetworkID() %></span>
			<span class="idcard_idcardbodytop-type"></span>
		</div>
		<!-- middle -->
		<div class="idcard_idcardbodymiddle">
			<img alt="logo" class="idcard_idcardbodymiddle-logo" src="<%= imgPath %>" />
			<div class="idcard_idcardbodymiddle-organizationname"><%= network.getBiobankNetworkName() %></div>
		</div>
		<!-- bottom -->
		<div class="idcard_idcardbodybottom">
			<div class="idcard_idcardbodybottom-shortdescription">
				<%
				if(network.getBiobankNetworkDescription().length() == 0) {
					%>
					A short discription of the <%= network.getBiobankNetworkName() %> Biobank will follow soon.
					<%
				} else {
					if(network.getBiobankNetworkDescription().length() > 300) {
						%>
						<%= network.getBiobankNetworkDescription().subSequence(0, 300) %>...
						<%
					} else {
						%>
						<%= network.getBiobankNetworkDescription() %>
						<%
					}			
				}
				%>
			</div>
			<div class="idcard_idcardbodybottom-menue">
				<div style="width: 110px;font-weight:bold;float:left;">Contact:</div><div style="float:left;"><%= HtmlUtil.unescape(contact_name) %></div> <br>
				<div style="width: 110px;font-weight:bold;float:left;">Institution:</div><div style="float:left;"><%= network.getBiobankNetworkJuridicalPerson() %></div>
			</div>
		</div>
	</div>
	<br><br>
	
<div style="width: 100%;">
	<div class="textsizeidcard" style="width: 100%;">
		<br>
		<!-- Main Contact -->
		<h1 class="bbmriericrecentnews">Main Contact</h1>
	  	<%
		if(contactinformation != null) {
			%>
			<div>
				<div class="fieldname">Name:</div>
				<div class="fieldvalue"><%= contactinformation.getContactFirstName() + " " + contactinformation.getContactLastName() %></div>
				<div style='content: "";clear: both;display: table;'></div> 
			</div>
			<div>
				<div class="fieldname">E-Mail:</div>
				<div class="fieldvalue"><%= contactinformation.getContactEmailMunged() %></div>
				<div style='content: "";clear: both;display: table;'></div> 
			</div>
			<%
			if(!contactinformation.getHtmlAddress().equalsIgnoreCase("")) {
				%>
				<div>
					<div class="fieldname">Address:</div>
					<div class="fieldvalue"><%= contactinformation.getHtmlAddress() %></div>
					<div style='content: "";clear: both;display: table;'></div> 
				</div>
				<%
			}
			%>
			<%
			if(!contactinformation.getContactPhone().equalsIgnoreCase("")) {
				%>
				<div>
					<div class="fieldname">Phone:</div>
					<div class="fieldvalue"><%= contactinformation.getContactPhone() %></div>
					<div style='content: "";clear: both;display: table;'></div> 
				</div>
				<%
			}
			%>
			<%
		}
		%>
		<br>
		<div style='content: "";clear: both;display: table;'></div>
		<br>
		<!-- Overview -->
		<h1 class="bbmriericrecentnews">Overview</h1>	
		<div>
			<div class="fieldname-long">All the biobanks/collections in the network share the same focus with which the samples are collected (e.g., disease specific):
			</div>
			<div class="fieldvalue"><%= network.getBiobankNetworkCommonCollectionFocus() == true ? "Yes" : "No" %>
			</div>
			<div style='content: "";clear: both;display: table;'></div> 
		</div>
		<div>
			<div class="fieldname-long">All the biobanks/collections in the network have to have a network charter signed:
			</div>
			<div class="fieldvalue"><%= network.getBiobankNetworkCommonCharter() == true ? "Yes" : "No" %>
			</div>
			<div style='content: "";clear: both;display: table;'></div> 
		</div>
		<div>
			<div class="fieldname-long">All the biobanks/collections in the network share the same SOPs:
			</div>
			<div class="fieldvalue"><%= network.getBiobankNetworkCommonSOPs() == true ? "Yes" : "No" %>
			</div>
			<div style='content: "";clear: both;display: table;'></div> 
		</div>
		<div>
			<div class="fieldname-long">All the biobanks/collections in the network share the same data access policy:
			</div>
			<div class="fieldvalue"><%= network.getBiobankNetworkCommonDataAccessPolicy() == true ? "Yes" : "No" %>
			</div>
			<div style='content: "";clear: both;display: table;'></div> 
		</div>
		<div>
			<div class="fieldname-long">All the biobanks/collections in the network share the same sample access policy:
			</div>
			<div class="fieldvalue"><%= network.getBiobankNetworkCommonSampleAccessPolicy() == true ? "Yes" : "No" %>
			</div>
			<div style='content: "";clear: both;display: table;'></div> 
		</div>
		<div>
			<div class="fieldname-long">All the biobanks/collections in the network share the same MTA:
			</div>
			<div class="fieldvalue"><%= network.getBiobankNetworkCommonMTA() == true ? "Yes" : "No" %>
			</div>
			<div style='content: "";clear: both;display: table;'></div> 
		</div>
		<div>
			<div class="fieldname-long">All the biobanks/collections in the network are represented using the network only:
			</div>
			<div class="fieldvalue"><%= network.getBiobankNetworkCommonRepresentation() == true ? "Yes" : "No" %>
			</div>
			<div style='content: "";clear: both;display: table;'></div> 
		</div>
		<div>
			<div class="fieldname-long">All the biobanks/collections in the network share the same web presentation on the common URL:
			</div>
			<div class="fieldvalue"><%= network.getBiobankNetworkCommonURL() == true ? "Yes" : "No" %>
			</div>
			<div style='content: "";clear: both;display: table;'></div> 
		</div>
		<%
		List<D2BiobankNetwork> networks = network.getAssosiatedNetworks();
		if(networks.size() != 0) {
			%>
			<div><div class="fieldname">Associated Networks for the Network:</div>
			<div class="fieldvalue">
				<%
				String networksplitter = "";
				for(D2BiobankNetwork network_assosiated : networks) {
					%>
					<portlet:renderURL var="viewNetworkURL">
						<portlet:param name="biobanknetworkId" value="xxxxbiobankIdxxxx" />
						<portlet:param name="mvcPath" value="/html/idcard/biobank/view_network.jsp" />
						<portlet:param name="redirect" value="<%= redirect_this %>"/>
					</portlet:renderURL>
					<aui:a href='<%= viewNetworkURL.toString().replaceAll("xxxxbiobankIdxxxx", String.valueOf(network_assosiated.getD2biobanknetworkId())) %>'><%= networksplitter + network_assosiated.getBiobankNetworkName() %></aui:a>
					<%
					networksplitter = "<br>";
				}
				%>
			</div>
			<div style='content: "";clear: both;display: table;'></div>
			<%
		}
		%>
		
		<%
		List<D2Biobank> biobanks = network.getAssosiatedBiobanks();
		if(biobanks.size() != 0) {
			%>
			<div><div class="fieldname">Associated Biobanks for the Network:</div>
			<div class="fieldvalue">
				<%
				String networksplitter = "";
				for(D2Biobank biobank_assosiated : biobanks) {
					%>
					<portlet:renderURL var="viewBiobankURL">
						<portlet:param name="biobankId" value="xxxxbiobankIdxxxx" />
						<portlet:param name="mvcPath" value="/html/idcard/biobank/view_biobank.jsp" />
						<portlet:param name="redirect" value="<%= redirect_this %>"/>
					</portlet:renderURL>
					<aui:a href='<%= viewBiobankURL.toString().replaceAll("xxxxbiobankIdxxxx", String.valueOf(biobank_assosiated.getBiobankId())) %>'><%= networksplitter + biobank_assosiated.getBiobankName() %></aui:a>
					<%
					networksplitter = "<br>";
				}
				%>
			</div>
			<div style='content: "";clear: both;display: table;'></div>
			<%
		}
		%>
		
		<%
		List<D2Collection> collections = network.getAssosiatedCollections();
		if(collections.size() != 0) {
			%>
			<div><div class="fieldname">Associated Collections for the Network:</div>
			<div class="fieldvalue">
				<%
				String networksplitter = "";
				for(D2Collection collection_assosiated : collections) {
					%>
					<portlet:renderURL var="viewCollectionURL">
						<portlet:param name="biobankId" value="xxxxbiobankIdxxxx" />
						<portlet:param name="mvcPath" value="/html/idcard/biobank/view_biobank.jsp" />
						<portlet:param name="redirect" value="<%= redirect_this %>"/>
					</portlet:renderURL>
					<aui:a href='<%= viewCollectionURL.toString().replaceAll("xxxxbiobankIdxxxx", String.valueOf(collection_assosiated.getBiobankId())) %>'><%= networksplitter + collection_assosiated.getCollectionName() %></aui:a>
					<%
					networksplitter = "<br>";
				}
				%>
			</div>
			<div style='content: "";clear: both;display: table;'></div>
			<%
		}
		%>
		
		
		
		<%
		if(network.getBiobankNetworkDescription().length() != 0) {
			%>
			<div>
				<div class="fieldname">Biobank network description:</div>
				<div class="fieldvalue"><%= network.getBiobankNetworkDescription() %></div>
				<div style='content: "";clear: both;display: table;'></div> 
			</div>
			
			<%			
		}
		%>
		<br>
		<div style='content: "";clear: both;display: table;'></div>
		<br>
	
	</div>
</div>
