<%@ include file="/html/init.jsp" %> 

<portlet:defineObjects />

xyza

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
          //url: 'http://localhost:8080/api/jsonws/BiBBoxCommonServices-portlet.diseasematrix/updatediseasematrix',
          //url: 'http://catalogue.rd-connect.eu/BiBBoxCommonServices-portlet/api/jsonws/logapi/regbbs',
          url: 'http://catalogue.rd-connect.eu/api/jsonws/BiBBoxCommonServices-portlet.logapi/regbbs',
          dataType: "json",
          headers: {"Access-Control-Allow-Origin" : "*"},
          data:{
 	   		},
          type: "post",
          success: function(data){
                  alert(data.name);
          },
          beforeSend: function(xhr){
                  xhr.setRequestHeader('Authorization',make_base_auth(username, password));
                  xhr.setRequestHeader("Access-Control-Allow-Origin","*");
                            },
                            complete: function(){
                            },
          error: function(){
          }
        });
     
});
</script>

