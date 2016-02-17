<%@ include file="/html/init.jsp" %> 
<%@ page import="test.portlet.service.MolgenisAPIRequestLocalServiceUtil"%>

<portlet:defineObjects />

This is the <b>Test Api Update Call</b> portlet in View mode.

<%
MolgenisAPIRequestLocalServiceUtil.testAPIUpdate();

%>

<aui:button name="send" type="send" value="send" label="Send" cssClass="sendUpdateButton" />

<aui:script>
AUI().use('event', 'node', function(A){
		var nodeObject = A.all('.sendUpdateButton');
		nodeObject.on('click', function(event){
			alert("Send");
			var data = JSON.stringify([
			  {
			    "/update-portlet.idcard/diseasematrix": {
			      "url": "https://connect.patientcrossroads.org/?org=algsa",
			      "diseasname": "Alagille Syndrome 1",
			      "patientcount": "1",
			      "gene": "JAG1",
			      "orphanumber": "ORPHA52",
			      "icd10": "Q44.7",
			      "omim": "#610205",
			      "synonym": "ALGS1"
			    }
			  },
			  {
			    "/update-portlet.idcard/diseasematrix": {
			      "url": "https://connect.patientcrossroads.org/?org=algsa",
			      "diseasname": "Alagille Syndrome 2",
			      "patientcount": "",
			      "gene": "NOTCH2",
			      "orphanumber": "ORPHA52",
			      "icd10": "Q44.7",
			      "omim": "#118450",
			      "synonym": "ALGS2"
			    }
			  },
			  {
			    "/update-portlet.idcard/diseasematrix": {
			      "url": "https://connect.patientcrossroads.org/?org=algsa",
			      "diseasname": "Alagille Syndrome",
			      "patientcount": "136",
			      "gene": "",
			      "orphanumber": "ORPHA52",
			      "icd10": "Q44.7",
			      "omim": "#118450; #610205",
			      "synonym": "Alagille-Watson syndrome, Arteriohepatic dysplasia, Syndromic bile duct paucity"
			    }
			  }
			]);
			
			var xhr = new XMLHttpRequest();
			xhr.withCredentials = true;
			
			xhr.addEventListener("readystatechange", function () {
			  if (this.readyState === 4) {
			    console.log(this.responseText);
			  }
			});
			
			xhr.open("POST", "http://catalogue.rd-connect.eu/apiv1/update");
			xhr.setRequestHeader("content-type", "application/json");
			xhr.setRequestHeader("authorization", "Basic " + btoa('jud@patientcrossroads.com:rdc2016'));
			xhr.setRequestHeader("cache-control", "no-cache");
			xhr.setRequestHeader("Access-Control-Allow-Origin", "*");
			
			xhr.send(data);

		});
	});

</aui:script>