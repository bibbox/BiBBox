<%@ include file="/html/symbol/init.jsp" %>  

<portlet:defineObjects />
<liferay-theme:defineObjects />

<style>
	.event-container-text-right {
		width: 353px;
		height: 100px;
		border: 1px solid black;
		margin: 20px 0 0 0;
	   	border-radius: 15px;
	}
	.event-container-icon {
		width: 110px;
		height: 100px;
		border: 1px solid black;
		margin: 20px 0 0 0;
	   	border-radius: 15px;
	}
	.event-container-text-bottom {
		width: 110px;
		height: 150px;
		border: 1px solid black;
		margin: 20px 0 0 0;
	   	border-radius: 15px;
	}
	.event {
	   	width: 110px;
	   	height: 100px; 
	   	border: 1px solid black;
	   	border-radius: 15px;
	   	text-align: center;
	   	float: left;
	   	margin: -1px 0 0 -1px;	
	   	position: relative;
	   	top: -42px;
	   	color: #FFFFFF;
	}
	.event-text {
	   	width: 240px;
	   	height: 100px; 
	   	text-align: center;
	   	float: left;
	   	position: relative;
	   	top: -42px;
		overflow:hidden;
	}
	.event-text-bottom {
	   	width: 110px;
	   	height: 50px; 
	   	text-align: center;
	   	float: left;
	   	position: relative;
	   	top: -42px;
	}
	.event-date {
		position: relative;
		width: 70px;
	   	height: 40px;
	   	border: 1px solid black;
	   	background-color: #A8A8A8;
		color: #FFFFFF;
		top: -14px;
		right: -39px;
		font-size: 10px;
		line-height: 12px;
		text-align: center;
		border-radius: 5px;
	}
	.changecolor {
		background-color: green;
	}
	.configurationeventtype {
		width: 150px;
	   	height: 20px;
	   	border: 1px solid black;
	   	border-bottom: 0px solid black;
	   	background-color: #A8A8A8;
		color: #FFFFFF;
		font-size: 14px;
		line-height: 20px;
		text-align: left;
		border-top-left-radius: 5px;
		border-top-right-radius: 5px;
	}
	.symbolconfigurationoverview {
		width: 450px;
		border: 1px solid black;
		background-color: #DBDBDB;
		padding: 10px;
	}
</style>

<% 
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


String headerlogo = request.getContextPath() + "/images/logo_mib.gif";
String headerimage = request.getContextPath() + "/images/header.gif";

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<div style="background-image: url('<%= headerimage %>');background-repeat: repeat-x;"><img alt="logo" src="<%= headerlogo %>" width="252px" /></div>

<aui:button-row>
	<portlet:renderURL var="listTemplatesURL">
		<portlet:param name="mvcPath" value="/html/symbol/symbolconfiguration/listtemplates.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<aui:button value="list-templates" onClick="<%= listTemplatesURL.toString() %>"/>
</aui:button-row>

<div class="event-container-text-right" style="background-color: #DBDBDB; ">
	<div class="event-date">12/05/2014</div>
	<div class="event changecolor">
		<div style="background-color: red;width: 75px;height: 74px;clear: both;float: right;overflow:hidden;border-top-right-radius: 15px;">A3
		</div>
		<div style="width: 35px;height: 25px;overflow:hidden;">
			A1
		</div>
	
		<div style="background-color: blue;width: 35px;height: 14px;float: left;text-align: center;font: 12px arial, sans-serif;overflow:hidden;">
			Code<br>
		</div>
		<div style="background-color: orange;width: 35px;height: 35px;float: left;overflow:hidden;">A2
		</div>
		
		<div style="background-color: blue;width: 110px;height: 25px;position: absolute;bottom: 0px;border-top: 1px solid #ffffff;border-bottom-left-radius: 15px;border-bottom-right-radius: 15px;overflow:hidden;">
			A4
		</div>
	</div>
	<div class="event-text">Event Text</div>
</div><br>

<!-- <img alt="logo" src="/BiBBoxCommonServicesDatabase-portlet/images/icons/basic/zeit.png" width="252px" style="background-color: blue;" /> -->

<%
List<SymbolConfiguration> symbolconfigurations = SymbolConfigurationLocalServiceUtil.getSymbolConfigurations(-1, -1);
for(SymbolConfiguration symbolconfiguration : symbolconfigurations) {
	%>
	<div style="width: 100%;margin-top: 5px;">
		<div style="width: 75%;">
			<div class="configurationeventtype"><%= symbolconfiguration.getEventtype() %></div>
			<div class="symbolconfigurationoverview">
				<div><div style="float: left;margin-right:5px;">Color: </div><div style="float: left;margin-right:5px;">#<%= symbolconfiguration.getBasecolor() %></div><div style="background-color: #<%= symbolconfiguration.getBasecolor() %>;float: left;width: 20px;height: 20px;margin-right:5px;"></div></div>
				<br>
				<div>Icon Config:<br> 
					<%
					String symboliconconfiguration = symbolconfiguration.getSymbolIconConfiguration();
					String[] extractedsymboliconconfiguration = symboliconconfiguration.split("-");
					int position = 1;
					for(String iconcount : extractedsymboliconconfiguration) {
						%>
						Icon area A<%= position %>: <%= iconcount %><br>
						<% 
						for(IconConfiguration iconconfiguration : symbolconfiguration.getIconsForPosition(String.valueOf(position))) {
							%>
							<img title="<%= iconconfiguration.getKey() %>" alt="<%= iconconfiguration.getKey() %>" src="<%= iconconfiguration.getIconUrl() %>" style="background-color: #<%= iconconfiguration.getElementcolor() %>;height: 35px;"/>
							<%
						}
						%>
						<br>
						<%
						position ++;
					} 
					%>
				</div>
			</div>
		</div>
		<div style="float: right;width: 20%;">
			<input class="basecolor" type="color" label="Basecolor" name="basecolor" value='<%= "#" + symbolconfiguration.getBasecolor() %>'><br>
			<%= symbolconfiguration.getTemplate().replaceAll("§basecoler§", symbolconfiguration.getBasecolor()).replaceAll("§date§", dateFormat.format(new java.util.Date())) %><br>
		</div>
	</div>
	<aui:script use="aui-io-request, event, node, aui-popover, valuechange, event-hover, aui-tooltip, event-valuechange, click">
	AUI().use('event', 'node', function(A){
		var nodeObject = A.all('.basecolor');
		nodeObject.on('click', function(event){
			alert("basecolor");
		});
	});
	</aui:script>
	<%
}
%>