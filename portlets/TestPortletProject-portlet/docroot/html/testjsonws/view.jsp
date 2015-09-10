<%@ include file="/html/init.jsp" %> 

<portlet:defineObjects />

xyz

 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
$(document).on('ready',function(){
    var username ="robert.reihs@gmail.com";
    var password ="gizmo123"; 
    //alert("Dingdong");
    function make_base_auth(user, password) {
      var tok = user + ':' + password;
      var hash = btoa(tok);
      return "Basic " + hash;
    }
        $.ajax({
        //url: 'http://localhost:8080/api/jsonws/BiBBoxCommonServices-portlet.diseasematrix/regbb/organization-id/10779',
          //url: 'http://localhost:8080/api/jsonws/BiBBoxCommonServices-portlet.diseasematrix/get-disease-matrix/organization-id/16016',
          url: 'http://localhost:8080/api/jsonws/BiBBoxCommonServices-portlet.diseasematrix/updatediseasematrix',
          dataType: "json",
          data:{organizationId: 101,
        	   matrix: {"diseasematrixId": 101}
 	   		},
          type: "post",
          success: function(data){
                  alert(data.version);
          },
          beforeSend: function(xhr){
                  xhr.setRequestHeader('Authorization',make_base_auth(username, password));
                            },
                            complete: function(){
                            },
          error: function(){
          }
        });
     
});
</script>

<script type="text/javascript">
<!--


Liferay.Service(
  '/BiBBoxCommonServices-portlet.diseasematrix/updatediseasematrix',
  {
    organizationId: 101,
    matrix: [{   "diseasematrixId": 101,   "diseasename": "jhasdjfasf",   "gene": "",   "icd10": "xcv",   "modifieddate": 1435330786284,   "omim": "",   "organizationId": 15801,   "orphanumber": "xcvx",   "patientcount": "324",   "synonym": "" }]
  },
  function(obj) {
    console.log(obj);
  }
);


//-->
</script>

<a id='checkemail'>Check if user exists</a>

<aui:script use="aui-base,aui-io-request,aui-io-request,event,node,aui-popover,valuechange,event-hover,aui-tooltip,event-valuechange,click">
	AUI().use(
	'aui-base',
	'aui-io-request',  
	'node', 
	function(A){
		A.all('#checkemail').each(function() {
	      this.on('click', function(event){
			var url = 'http://localhost:8080/api/jsonws/BiBBoxCommonServices-portlet.diseasematrix/updatediseasematrix';
			A.io.request(url,{
				//this is the data that you are sending to the action method
				method: 'POST',
				data: {
				   organizationId: 101,
        	   		matrix: {"diseasematrixId": 101}
				},
				dataType: 'json',
				on: {
				  failure: function() { alert('There is a problem with the server connection.'); },
				  success: function(data) { 
				  	var response = this.get('responseData');
				  	alert(response);
				  	
				  }
				}
			});
		});
	});
	});
</aui:script>
