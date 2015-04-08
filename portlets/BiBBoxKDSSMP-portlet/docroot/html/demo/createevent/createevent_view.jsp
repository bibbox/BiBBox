<%@ include file="/html/demo/init.jsp" %> 
<%@ page import="com.liferay.portal.model.LayoutTypePortlet" %>

<portlet:defineObjects />
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<style>
	<%
	List<KdssmpConfiguration> options = KdssmpConfigurationLocalServiceUtil.getConfigurationOptions("CSSConfig");
	for(KdssmpConfiguration option : options) {
		%>
		<%= "." + option.getOptionkey().toLowerCase().replaceAll(" ", "") + "{" %> 
		<%= option.getOptionvalue() %>
		<%= "}" %>
		<%
	}
	%>
</style>

<%
String portletResource = ParamUtil.getString(request, "portletResource");
long organizationId = 0;
Organization organization = null;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
	organizationId = currentGroup.getClassPK();
  	organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
}

HashMap<String, String> eventcreation = new HashMap<String, String>();
List<KdssmpConfiguration> event_options = KdssmpConfigurationLocalServiceUtil.getConfigurationOptions("EventGroup");
for(KdssmpConfiguration event_option : event_options) {
	if(eventcreation.containsKey(event_option.getOptionvalue())) {
		eventcreation.put(event_option.getOptionvalue(), eventcreation.get(event_option.getOptionvalue()) + "<br>" + "&nbsp<i id=\"kdssmpcreateevent\" tag=\"" + event_option.getOptionkey().toLowerCase().replaceAll(" ", "").replaceAll("ä", "a") + "\" style=\"cursor: pointer;\" class=\"fa fa-plus\">&nbsp" + event_option.getOptionkey() + "</i>");
	} else {
		eventcreation.put(event_option.getOptionvalue(), "&nbsp<i id=\"kdssmpcreateevent\" tag=\"" + event_option.getOptionkey().toLowerCase().replaceAll(" ", "").replaceAll("ä", "a") + "\" style=\"cursor: pointer;\" class=\"fa fa-plus\">&nbsp" + event_option.getOptionkey() + "</i>");
	}
}
for(String key : eventcreation.keySet()) {
	%>
	<div style="border-style: solid;border-width: 1px; margin-bottom: 5px;border-radius: 5px;">
	<div style="background-color: blue; color: #FFFFFF;">
	<%= key %> :
	</div>
	<%= eventcreation.get(key) %><br>
	</div>
	<%
}
%>
<% 
String addOrganizationURL = themeDisplay.getURLCurrent().split("[?]")[0];
if(addOrganizationURL.matches("/web/" + organizationId)) {
	addOrganizationURL += "/patient";
}
if(addOrganizationURL.matches("/web/" + organizationId + "/")) {
	addOrganizationURL += "patient";
}
addOrganizationURL = addOrganizationURL + "/-/event/createevent/" + organizationId;
%>
<!-- Popup for adding Organiaztions to the list -->
<aui:script use="aui-base">
            A.all('#kdssmpcreateevent').on(
               'click',
               function(event) {
               	  var tag = event.target.getAttribute('tag');
               	  
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
                        id: '_<%=HtmlUtil.escapeJS(portletResource)%>_addorganisation' + text + tag,
                        title: '<%= "Create " %> ' + tag + ' <%= " for Patient " + organization.getName() %>',
                        uri: '<%= addOrganizationURL %>' + '/' + tag
                     }
                  );
               }
            );
</aui:script>