<%@ include file="/html/demo2/init.jsp" %> 

<portlet:defineObjects />

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

if(organization != null) {
	HashMap<String, String> eventcreation = new HashMap<String, String>();
	List<KdssmpConfiguration> event_options = KdssmpConfigurationLocalServiceUtil.getConfigurationOptions("EventGroup");
	for(KdssmpConfiguration event_option : event_options) {
		String tag = event_option.getOptionkey();
		String text = KdssmpConfigurationLocalServiceUtil.getConfigurationOption("Display", event_option.getOptionkey()).getOptionvalue();
		KdssmpPatient patient = KdssmpPatientLocalServiceUtil.getPatientForOrganization(organizationId);
		List<Event> events = EventLocalServiceUtil.getEventsForPatient(patient.getPatientId());
		if(events.size() == 0 && event_option.getOptionvalue().equalsIgnoreCase("Erstdiagnose")) {
			if(eventcreation.containsKey(event_option.getOptionvalue())) {
				eventcreation.put(event_option.getOptionvalue(), eventcreation.get(event_option.getOptionvalue()) + "<br>" + "&nbsp<i id=\"kdssmpcreateevent\" tag=\"" + tag + "\" style=\"cursor: pointer;\" class=\"fa fa-plus\">&nbsp" + text + "</i>");
			} else {
				eventcreation.put(event_option.getOptionvalue(), "&nbsp<i id=\"kdssmpcreateevent\" tag=\"" + tag + "\" style=\"cursor: pointer;\" class=\"fa fa-plus\">&nbsp" + text + "</i>");
			}
		} else if(events.size() != 0 && !event_option.getOptionvalue().equalsIgnoreCase("Erstdiagnose")) {
			if(eventcreation.containsKey(event_option.getOptionvalue())) {
				eventcreation.put(event_option.getOptionvalue(), eventcreation.get(event_option.getOptionvalue()) + "<br>" + "&nbsp<i id=\"kdssmpcreateevent\" tag=\"" + tag + "\" style=\"cursor: pointer;\" class=\"fa fa-plus\">&nbsp" + text + "</i>");
			} else {
				eventcreation.put(event_option.getOptionvalue(), "&nbsp<i id=\"kdssmpcreateevent\" tag=\"" + tag + "\" style=\"cursor: pointer;\" class=\"fa fa-plus\">&nbsp" + text + "</i>");
			}
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
		addOrganizationURL += "/patient-overview";
	}
	if(addOrganizationURL.matches("/web/" + organizationId + "/")) {
		addOrganizationURL += "patient-overview";
	}
	addOrganizationURL = addOrganizationURL + "/-/event2/createevent2/" + organizationId;
	%>
	<!-- Popup for adding Organiaztions to the list -->
	<aui:script use="aui-base">
	            A.all('#kdssmpcreateevent').on(
	               'click',
	               function(event) {
	               	  var tag = event.target.getAttribute('tag');
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
	                        id: '_<%=HtmlUtil.escapeJS(portletResource)%>_addorganisation' + text + tag,
	                        title: 'Create ' + titleheadline + ' <%= " for Patient " + organization.getName() %>',
	                        uri: '<%= addOrganizationURL %>' + '/' + tag
	                     }
	                  );
	               }
	            );
	</aui:script>
	<%
}
%>