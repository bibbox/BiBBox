<%@include file="/html/init.jsp" %>

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<portlet:defineObjects />

	<style>
		.rdc-event-container {
			position: absolute;
	   		overflow: hidden;
	    	width: 85px;
	    	height: 35px; 
	    	border: 0px solid black;
	    	right: -85px;
	    	top: 8px;
		}

		#rdc-event-slide {
	    	position: absolute;
	    	left: -85px;
	    	width: 85px;
	    	height: 35px;
	    	background-color: #3A5894;
	    	transition: 1s;
			color: #FFFFFF;
			padding: 8px 0 0 7px;
		}

		.rdc-event-container:hover #rdc-event-slide {
	    	transition: 1s;
	    	left: 0;
		}
	</style>
	
	
	

<%
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

String template = "<div style=\"margin: 5px 20px 10px 10px; width: 95%; background-color: #E2E3CE; border-radius: 3px;-webkit-box-shadow: 2px 2px 2px 1px rgba(0,0,0,0.50);-moz-box-shadow: 2px 2px 2px 1px rgba(0,0,0,0.50);box-shadow: 2px 2px 2px 1px rgba(0,0,0,0.50);position: relative;\"><div class=\"rdc-event-container\"><div id=\"rdc-event-slide\">[$slidertext$]</div></div><table style=\"margin: 8px 0 5px 0; background-color: #FFFFFF; float:left; width:100%;height: 35px;\"><tr><td style=\"width:160px;\">[$logoleft$]</td><td style=\"\">[$title$]</td><td style=\"width:60px;\">[$logoright$]</td></tr></table><div style=\"margin: 10px;\">[$shorttext$]<br></div></div>";

List<RDConnectEvent> rdconnectevents = RDConnectEventLocalServiceUtil.getEvents();
for(RDConnectEvent rdconnectevent : rdconnectevents) {
	String event = template.replaceAll("\\[\\$slidertext\\$\\]", dateFormat.format(rdconnectevent.getEventdate()));
	event = event.replaceAll("\\[\\$title\\$\\]", rdconnectevent.getEventtype());
	event = event.replaceAll("\\[\\$shorttext\\$\\]", rdconnectevent.getShorttext());
	if(rdconnectevent.getEventtype().equalsIgnoreCase("Candidate Propose")) {
		event = event.replaceAll("\\[\\$logoleft\\$\\]", "&nbsp&nbsp<i class=\"fa fa-bullhorn fa-2x\"></i>");
		event = event.replaceAll("\\[\\$logoright\\$\\]", "&nbsp&nbsp<i class=\"fa fa-hand-o-up fa-2x\"></i>");
	}
	%>
	<%= event %>
	<%
}
%>