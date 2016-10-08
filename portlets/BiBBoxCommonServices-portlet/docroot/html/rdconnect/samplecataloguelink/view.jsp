<%@ include file="/html/rdconnect/init.jsp" %> 

<%
String optionsLinkTitle_cfg = GetterUtil.getString(portletPreferences.getValue("optionsLinkTitle", "Sample Catalogue"));
%>

<style>
.rdconnect-sample-catalogue-link {
	background-image: url("/RDConnect-theme/images/leiste_neu.png");
    color: #ffffff;
    font-size: 16px;
    margin: 3px 30px 0;
    padding: 10px 32px;
    text-align: center;
    border-radius: 2px;
    font-weight: bold;
}   
</style>

<%
String link = "https://molgenis21.gcc.rug.nl/menu/main/dataexplorer?entity=rdconnect_Sample&q=OrganizationID==12345";

%>

<a target="_blank" href="https://molgenis21.gcc.rug.nl/menu/main/dataexplorer?entity=rdconnect_Sample&hideselect=true">
	<div class="rdconnect-sample-catalogue-link"><%= optionsLinkTitle_cfg %></div>
</a>
