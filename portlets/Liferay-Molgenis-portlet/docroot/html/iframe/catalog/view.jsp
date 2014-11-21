<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

This is the <b>Molgenis I Fram Catalog</b> portlet in View mode.
<br />

<iframe id="yui-history-iframe" src="#" style="width:100%;height:600px;"></iframe>

<script  type="text/javascript">
	window.onload = function() {


		var req = new XMLHttpRequest();
		var token;

		// Feature detection for CORS
		if ('withCredentials' in req) {
		    req.open('Post', 'http://localhost:8080/api/v1/login', true);
		    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
		    // Just like regular ol' XHR
		    req.onreadystatechange = function() {
		        if (req.readyState === 4) {
		            if (req.status >= 200 && req.status < 400) {
		                // JSON.parse(req.responseText) etc.
		            	var a = JSON.parse(req.responseText);
		        		token = a.token;
		        		
		        		//var reqpage = new XMLHttpRequest();
		        		if ('withCredentials' in req) {
		        			req.open('GET', 'http://localhost:8080/plugin/dataexplorer', true);
		        			req.setRequestHeader("Content-Type", "text/html,application/xhtml+xml,application/xml,text/plain;q=0.9,image/webp,*/*;q=0.8");
		        			req.setRequestHeader("x-molgenis-token", token);
		        		    // Just like regular ol' XHR
		        		    req.onreadystatechange = function() {
		        		        if (req.readyState === 4) {
		        		            if (req.status >= 200 && req.status < 400) {
		        		                // JSON.parse(req.responseText) etc.
		        		                //alert(req.responseText);
		        		            	//var a = JSON.parse(req.responseText);
		        		        		//token = a.token;
		        		        		//alert(token);
		        		            	var A = AUI();
		        		            	//A.one('#iframe_molgenis').setHTML(req.responseText);
		        		            	//A.one('#yui-history-iframe').get('contentWindow.document').one('body').setHTML(req.responseText);
		        		            	//A.one('#yui-history-iframe').get('contentWindow.document').setHTML(req.responseText);
		        		            	//A.one('#yui-history-iframe').src = "data:text/html;charset=utf-8," + escape(req.responseText);
		        		            	var s = document.getElementById('yui-history-iframe');
										s.contentDocument.write(req.responseText);
		        		            	//.attr('src',req.responseText);
		        		            } else {
		        		                // Handle error case
		        		            }
		        		        }
		        		    };
		        		    req.send(JSON.stringify({'x-molgenis-token':token}));
		        		}





		        		
		            } else {
		                // Handle error case
		            }
		        }
		    };
		    req.send(JSON.stringify({username:"admin",password:"admin"}));
		}

		


		/*
		// Load the page (not working)
		var A = AUI();

		var url = 'http://localhost:8080/plugin/dataexplorer';
		//url = 'http://localhost:8080/api/v1/entities';
		A.io.request(url,{
			//this is the data that you are sending to the action method
			method: 'GET',
			data: {
				'x-molgenis-token': token,
				'Access-Control-Allow-Origin': '*',
				'Content-Type': 'application/json',
				"username": "admin"
				
			},
			headers: {'Content-Type':'charset=utf-8','x-molgenis-token': token},		
			on: {
				failure: function() { alert('There is a problem with the server connection.'); },
				success: function() { 
					alert("laoded");
					A.one('#iframe_molgenis').attr('src',this.get('responseData'));
					//.setHTML(this.get('responseData'));
				}
			}
		});*/
		
		

		
	}
</script>