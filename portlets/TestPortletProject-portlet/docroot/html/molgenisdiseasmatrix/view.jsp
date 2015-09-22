<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="test.portlet.service.MolgenisAPIRequestLocalServiceUtil"%>


<portlet:defineObjects />

<div id="diseasematrix"></div>

<script  type="text/javascript">
<%= MolgenisAPIRequestLocalServiceUtil.getAgregatedJsonFromMolgenis("http%3A%2F%2Fcatalogue.rd-connect.eu%2Fweb%2F71542") %>
</script>

<script  type="text/javascript">
	window.onload = function() {

		var req = new XMLHttpRequest();
		var token;

		if(false) {
		// Feature detection for CORS
		if ('withCredentials' in req) {
		    req.open('Post', 'https://molgenis21.target.rug.nl/api/v1/login', true);
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
			        		alert("logedin");
		        			req.open('Get', 'https://molgenis21.target.rug.nl/api/v2/test?aggs=x==Diseases;distinct==ParticipantID', true);
		        			req.setRequestHeader("Content-Type", "text/html,application/xhtml+xml,application/xml,text/plain;q=0.9,image/webp,*/*;q=0.8");
		        			req.setRequestHeader("x-molgenis-token", token);
		        		    // Just like regular ol' XHR
		        		    req.onreadystatechange = function() {
		        		        if (req.readyState === 4) {
		        		            if (req.status >= 200 && req.status < 400) {		        		    
		        		            	var data_agr = JSON.parse(req.responseText);
		        		            	alert(data_agr);
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
		    req.send(JSON.stringify({username:"user",password:"hackathon789"}));
		}	
		}
	}
</script>
