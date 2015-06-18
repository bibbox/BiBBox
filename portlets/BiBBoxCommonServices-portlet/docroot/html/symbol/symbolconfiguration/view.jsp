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
</style>

<% 
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


String headerlogo = request.getContextPath() + "/images/logo_mib.gif";
String headerimage = request.getContextPath() + "/images/header.gif";
%>

<div style="background-image: url('<%= headerimage %>');background-repeat: repeat-x;"><img alt="logo" src="<%= headerlogo %>" width="252px" /></div>

<%
List<SymbolConfiguration> symbolconfigurations = SymbolConfigurationLocalServiceUtil.getSymbolConfigurations(-1, -1);
for(SymbolConfiguration symbolconfiguration : symbolconfigurations) {
	%>
	<div style="width: 100%;">
		<div style="width: 75%;">
			<%= symbolconfiguration.getEventtype() %><br>
			<input class="basecolor" type="color" label="Basecolor" name="basecolor" value='<%= "#" + symbolconfiguration.getBasecolor() %>'>
		</div>
		<div style="float: right;width: 20%;">
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