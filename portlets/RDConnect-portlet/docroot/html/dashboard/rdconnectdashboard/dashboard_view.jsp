<%@ include file="/html/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery.js"></script> 

<style> 
.rcorners6 {
    border-radius: 50px 50px;
    background: #8AC007;
    overflow: hidden;
} 
</style> 

<%
List<Layout> portlet_layouts = themeDisplay.getLayout().getChildren();
%>

<div class="container">  
<div class="row">  
<%
for(Layout portlet_layout : portlet_layouts) {
	String img_path = "/images/dashboard/";
	if(portlet_layout.getNameCurrentValue().equalsIgnoreCase("User")) {
		img_path += "user.png";
	} else if(portlet_layout.getNameCurrentValue().equalsIgnoreCase("Statistics")) {
		img_path += "Statistics.png";
	}
	String orgPath = themeDisplay.getURLPortal()+"/web"+ portlet_layout.getGroup().getFriendlyURL() + portlet_layout.getFriendlyURL();
%>
	<div class="span1 rcorners6" ><aui:a class="span1" href="<%= orgPath %>"><img src='<%= request.getContextPath() + img_path %>' class="center-block img-responsive img-circle" alt="Generic placeholder thumbnail"></aui:a></div> 
<%
}
%>
</div>    
