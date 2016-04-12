<%@ include file="/html/init.jsp" %>

<style>
	#ajaxloader
	{
		position: absolute;
		width: 30px;
		height: 30px;
		border: 8px solid #ed660a;
		border-right-color: transparent;
		border-radius: 50%;
		box-shadow: 0 0 25px 2px #eee;
	}
	#ajaxloader
	{
		animation: spin 1s linear infinite;
	}
	@keyframes spin
	{
		from { transform: rotate(0deg);   opacity: 0.2; }
		50%  { transform: rotate(180deg); opacity: 1.0; }
		to   { transform: rotate(360deg); opacity: 0.2; }
	}
	.dockerstoped {
	-moz-box-shadow: 3px 4px 0px 0px #8a2a21;
	-webkit-box-shadow: 3px 4px 0px 0px #8a2a21;
	box-shadow: 3px 4px 0px 0px #8a2a21;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #c62d1f), color-stop(1, #f24437));
	background:-moz-linear-gradient(top, #c62d1f 5%, #f24437 100%);
	background:-webkit-linear-gradient(top, #c62d1f 5%, #f24437 100%);
	background:-o-linear-gradient(top, #c62d1f 5%, #f24437 100%);
	background:-ms-linear-gradient(top, #c62d1f 5%, #f24437 100%);
	background:linear-gradient(to bottom, #c62d1f 5%, #f24437 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#c62d1f', endColorstr='#f24437',GradientType=0);
	background-color:#c62d1f;
	-moz-border-radius:18px;
	-webkit-border-radius:18px;
	border-radius:18px;
	border:1px solid #d02718;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-family:Arial;
	font-size:15px;
	padding:4px 12px;
	text-decoration:none;
	text-shadow:0px 1px 0px #810e05;
}
.dockerstoped:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #f24437), color-stop(1, #c62d1f));
	background:-moz-linear-gradient(top, #f24437 5%, #c62d1f 100%);
	background:-webkit-linear-gradient(top, #f24437 5%, #c62d1f 100%);
	background:-o-linear-gradient(top, #f24437 5%, #c62d1f 100%);
	background:-ms-linear-gradient(top, #f24437 5%, #c62d1f 100%);
	background:linear-gradient(to bottom, #f24437 5%, #c62d1f 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#f24437', endColorstr='#c62d1f',GradientType=0);
	background-color:#f24437;
}
.dockerstoped:active {
	position:relative;
	top:1px;
}

.dockerrunning {
	-moz-box-shadow: 3px 4px 0px 0px #3e7327;
	-webkit-box-shadow: 3px 4px 0px 0px #3e7327;
	box-shadow: 3px 4px 0px 0px #3e7327;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #77b55a), color-stop(1, #72b352));
	background:-moz-linear-gradient(top, #77b55a 5%, #72b352 100%);
	background:-webkit-linear-gradient(top, #77b55a 5%, #72b352 100%);
	background:-o-linear-gradient(top, #77b55a 5%, #72b352 100%);
	background:-ms-linear-gradient(top, #77b55a 5%, #72b352 100%);
	background:linear-gradient(to bottom, #77b55a 5%, #72b352 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#77b55a', endColorstr='#72b352',GradientType=0);
	background-color:#77b55a;
	-moz-border-radius:18px;
	-webkit-border-radius:18px;
	border-radius:18px;
	border:1px solid #4b8f29;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:15px;
	padding:4px 12px;
	text-decoration:none;
	text-shadow:0px 1px 0px #5b8a3c;
}
.dockerrunning:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #72b352), color-stop(1, #77b55a));
	background:-moz-linear-gradient(top, #72b352 5%, #77b55a 100%);
	background:-webkit-linear-gradient(top, #72b352 5%, #77b55a 100%);
	background:-o-linear-gradient(top, #72b352 5%, #77b55a 100%);
	background:-ms-linear-gradient(top, #72b352 5%, #77b55a 100%);
	background:linear-gradient(to bottom, #72b352 5%, #77b55a 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#72b352', endColorstr='#77b55a',GradientType=0);
	background-color:#72b352;
}
.dockerrunning:active {
	position:relative;
	top:1px;
}
</style>

This is the <b>Docker Dashboard</b> portlet in View mode.

<%
DockerCMD dcmd = new DockerCMD();
%>
<br>


<div id="DockerList">
	<div id="ajaxloader"></div>
</div>

<aui:script>
YUI().use(
  'aui-datatable',
  function(Y) {
    var columns = [
    	{
			key: 'CONTAINERID',
			label: 'CONTAINER ID',
			sortable: true
		},  	
		{
			key: 'NAME',
			sortable: true
		}, 	
		{
			key: 'CREATED',
			sortable: true
		},  	
		{
			key: 'PORTS',
			sortable: true
		},  	
		{
			key: 'STATUS',
			sortable: true
		},
		{
			key: 'Status',
			label: 'Status',
			sortable: true,
			allowHTML: true,
			formatter: function (o) {
				var status = o.data.STATUS;
				var display = '<a href="#" class="dockerstoped">stoped</a>';
				if(status.indexOf("Up") > -1) {
					display = '<a href="#" class="dockerrunning">running</a>';
				}
				return display;
			}
		}
	];

    var data = [<%= dcmd.dockerPs(true) %>];

    new Y.DataTable.Base(
      {
        columnset: columns,
        recordset: data
      }
    ).render('#DockerList');
    
    Y.all('#ajaxloader').setStyle('display', 'none');
    
  }
);
</aui:script>

<portlet:resourceURL var="resourceURL">
	<portlet:param name="<%=Constants.CMD%>" value="docker_reload" />
</portlet:resourceURL>

<p id="demo"></p>
<p id="demo2"></p>

<aui:script use="aui-base,node,aui-datatable,aui-datatype,datatable-sort,aui-io-request">
var myVar = setInterval(myTimer, 15000);

function myTimer() {
	var d = new Date();
	document.getElementById("demo").innerHTML = d.toLocaleTimeString();
	AUI().use(
		'aui-datatable',
		'aui-datatype',
		'datatable-sort',
		'aui-io-request',
		'aui-base',
		function(Y) {
			Y.io.request('<%= resourceURL %>',{
				dataType: 'json',
				on: {
					failure: function() { 
		              	
		              },
					success: function() {
						var jsonelementstring = '{"dataelements":[' + Y.JSON.stringify(this.get('responseData')) + ']}';
						var jsonelement = Y.JSON.parse(jsonelementstring);
						Y.all('#demo2').setHTML(jsonelement);
						
						var items = "";
						
						alert("Length: " + jsonelement.dataelements.length + "\n" + jsonelement.dataelements[0].name);
						
						
					}
				}
			});
		}
	);
}
</aui:script>