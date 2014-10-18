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

		var A = AUI();

		var url = 'http://localhost:8080/plugin/dataexplorer';
		A.io.request(url,{
			//this is the data that you are sending to the action method
			data: {
				'x-molgenis-token': token,
			},
			dataType: 'json',
			on: {
				failure: function() { alert('There is a problem with the server connection.'); },
				success: function() { 
					alert("laoded");
					A.one('#iframe_molgenis').attr('src',this.get('responseData'));
					//.setHTML(this.get('responseData'));
				}
			}
		});
	}
</script>