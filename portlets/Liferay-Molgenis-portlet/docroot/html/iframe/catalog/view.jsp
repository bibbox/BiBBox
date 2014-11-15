<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

This is the <b>Molgenis I Fram Catalog</b> portlet in View mode.
<br />
<iframe id="iframe_molgenis" src="#" name="iframe_molgenis" style="width:100%;height:400px;"></iframe>

<script  type="text/javascript">
	window.onload = function() {
		var xmlhttp = new XMLHttpRequest(); 
		xmlhttp.open("Post", "http://localhost:8080/api/v1/login", false);
		xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
		xmlhttp.send(JSON.stringify({username:"admin",password:"admin"}));
		var elem = document.getElementById("x-molgenis-token");
		
		var a = JSON.parse(xmlhttp.responseText);
		var token = a.token;
		//alert(token);
		
		var xmlhttp2 = new XMLHttpRequest(); 
		xmlhttp2.open("Post", "http://localhost:8080/api/v1/entities", false);
		xmlhttp2.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
		xmlhttp2.send(JSON.stringify({'x-molgenis-token':token}));
		var a2 = JSON.parse(xmlhttp2.responseText);
		alert(a2);
		
		
		
		

		
	}
</script>