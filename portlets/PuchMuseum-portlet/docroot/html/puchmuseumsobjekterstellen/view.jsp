<%@ include file="/html/init.jsp"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

<style>
<!--
.aui table {
    width: 100%;
}
-->
</style>

<%
PuchMuseumsObjekt puchmuseumsobjekt = null;
long puchmuseumsobjektId = ParamUtil.getLong(request, "puchmuseumsobjectId");
puchmuseumsobjekt = PuchMuseumsObjektLocalServiceUtil.getPuchMuseumsObjekt(puchmuseumsobjektId);
String objekttyp = puchmuseumsobjekt.getObjekttyp();
String redirect = ParamUtil.getString(request, "redirect");
String portletResource = ParamUtil.getString(request, "portletResource");

Configuration icon_configuration = ConfigurationLocalServiceUtil.getConfigurationOption("Icon", objekttyp);
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='back-to-list-objects'
/>

<%= icon_configuration.getOptionvalue() %><br>

<%
	List<Configuration> configurations = ConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", objekttyp);
	for (Configuration configuration : configurations) {
		ParameterConfiguration parameterconfig = ParameterConfigurationLocalServiceUtil.getParameterConfiguration(Long.parseLong(configuration.getOptionvalue()));
		if(!parameterconfig.getViewvisible()) {
			continue;
		}
		
		String id = parameterconfig.getParameterconfigurationId() + "";

		ObjectData objectdata = ObjectDataLocalServiceUtil.getObjectDataForObject(puchmuseumsobjektId, id);
		String data = "";
		%>
		<div style='<%= parameterconfig.getViewcss() %>'>
		<%
		if (objectdata != null) {
			if (parameterconfig.getDatatype().equalsIgnoreCase("html")) {
				%>
				<div style="<%= parameterconfig.getViewtitlecss() %>"><%= parameterconfig.getDisplaynameshort() %>: </div><div style="<%= parameterconfig.getViewvaluecss() %>"><%= objectdata.formatValueHTML() %></div>
				<%
			} else if (parameterconfig.getDatatype().equalsIgnoreCase("text")) {
				%>
				<div style="<%= parameterconfig.getViewtitlecss() %>"><%= parameterconfig.getDisplaynameshort() %>: </div><div style="<%= parameterconfig.getViewvaluecss() %>"><%= objectdata.formatValueHTML() %></div>
				<%
			} else if (parameterconfig.getDatatype().equalsIgnoreCase("textbox")) {
				%>
				<div style="<%= parameterconfig.getViewtitlecss() %>"><%= parameterconfig.getDisplaynameshort() %>: </div><div style="<%= parameterconfig.getViewvaluecss() %>"><%= objectdata.formatValueHTML() %></div>
				<%
			} else if (parameterconfig.getDatatype().equalsIgnoreCase("Select")) {
				%>
				<div style="<%= parameterconfig.getViewtitlecss() %>"><%= parameterconfig.getDisplaynameshort() %>: </div><div style="<%= parameterconfig.getViewvaluecss() %>"><%= objectdata.formatValueHTML() %></div>
				<%
			} else if (parameterconfig.getDatatype().equalsIgnoreCase("Multiselect")) {
				%>
				<div style="<%= parameterconfig.getViewtitlecss() %>"><%= parameterconfig.getDisplaynameshort() %>: </div><div style="<%= parameterconfig.getViewvaluecss() %>"><%= objectdata.formatValueHTML() %></div>
				<%
			} else if (parameterconfig.getDatatype().equalsIgnoreCase("image")) {
				try {
					long imageid = Long.parseLong(objectdata.getObjectvalue());
					if(imageid != 0) {
						FileEntry imagefile = DLAppServiceUtil.getFileEntry(imageid);
						String thumbnailrawSrc = DLUtil.getThumbnailSrc(imagefile, null, themeDisplay);
						%>
						<div style="<%= parameterconfig.getViewtitlecss() %>"><%= parameterconfig.getDisplaynameshort() %>: </div>
						<div style="<%= parameterconfig.getViewvaluecss() %>">
							 <img src="<%= thumbnailrawSrc %>" alt="<%= parameterconfig.getDisplaynameshort() %>"> 
						</div>
						<%
					}
				} catch(Exception ex) {
					System.out.println("Error loading file");
				}
			}
		} else {
			%>
			<%= parameterconfig.getDisplaynameshort() %><br>
			<%
		}
		%>
		<div style='content: "";clear: both;display: table;'></div>
		</div>
		<%
	}
%>
<%
List<Configuration> configurations_sub = null;
Transaktion transaction = null;

%>
<%
String transactiontype = "standortprotokoll";
%>
<%@include file="/html/transactions/view_transactions_for_object.jspf" %>
<%
transactiontype = "besitzerprotokoll";
%>
<%@include file="/html/transactions/view_transactions_for_object.jspf" %>
<%
transactiontype = "leihprotokolle";
%>
<%@include file="/html/transactions/view_transactions_for_object.jspf" %>
<%
transactiontype = "zustandsprotokoll";
%>
<%@include file="/html/transactions/view_transactions_for_object.jspf" %>

<%@include file="/html/imageupload/view_images_for_object.jspf" %>

<!-- Popup for adding Organiaztions to the list -->
			<aui:script use="aui-base">
	            A.all('#createtransaction').on(
	               'click',
	               function(event) {
	               	  var tag = event.target.getAttribute('tag');
	               	  var tagurl = event.target.getAttribute('tagurl');
	               	  var titleheadline = event.target.getHTML();
	               	  var text = "";
					  var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
					
					  for( var i=0; i < 5; i++ ) {
					  	text += possible.charAt(Math.floor(Math.random() * possible.length));
					  }
	               	  
	                  Liferay.Util.selectEntity(
	                     {
	                        dialog: {
	                           cache: false,
	                           constrain: true,
	                           modal: true,
	                           width: 1000
	                        },
	                        id: '_<%=HtmlUtil.escapeJS(portletResource)%>_createtransaction' + text + tag,
	                        title: 'Create ' + titleheadline,
	                        uri: tagurl + '/' + tag
	                     }
	                  );
	               }
	            );
			</aui:script>