<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<iframe id="molgenis-iframe" src="JavaScript:''" style="width:100%;height:600px;border-width: 0;"></iframe>

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
		        			req.open('Get', 'http://localhost:8080/plugin/dataexplorer', true);
		        			req.setRequestHeader("Content-Type", "text/html,application/xhtml+xml,application/xml,text/plain;q=0.9,image/webp,*/*;q=0.8");
		        			req.setRequestHeader("x-molgenis-token", token);
		        		    // Just like regular ol' XHR
		        		    req.onreadystatechange = function() {
		        		        if (req.readyState === 4) {
		        		            if (req.status >= 200 && req.status < 400) {		        		    
		        		            	var A = AUI();
		        		            	var molgenisiframe = document.getElementById('molgenis-iframe');

		        		            	var iframedoc = molgenisiframe.document;
		        		            	if (molgenisiframe.contentDocument) {
		        		            		iframedoc = molgenisiframe.contentDocument;
		        		            	} else if (molgenisiframe.contentWindow) {
		        		            		iframedoc = molgenisiframe.contentWindow.document;
		        		            	}
		        		            	if (iframedoc) {
			        		            	// Put the content in the iframe
			        		            	iframedoc.open();
			        		            	iframedoc.writeln(req.responseText);
			        		            	iframedoc.close();
		        		            	} else {
			        		            	//just in case of browsers that don't support the above 3 properties.
			        		            	//fortunately we don't come across such case so far.
			        		            	alert('Cannot inject dynamic contents into iframe.');
		        		            	}
		        		            											
		        		            	//if(molgenisiframe.contentDocument != null) {
		        		            		//molgenisiframe.contentDocument.write("<scr" + "ipt>" + req.responseText + "</scr" + "ipt>");
		        		            		//molgenisiframe.contentDocument.write(req.responseText);
		        		            	//}
		        		            } else {
		        		                // Handle error case
		        		            }
		        		        }
		        		    };
		        		    req.send();
		        		}	
		            } else {
		                // Handle error case
		            }
		        }
		    };
		    req.send(JSON.stringify({username:"admin",password:"admin"}));
		}	
	}
</script>