<%@ include file="/html/demo/init.jsp" %> 

<portlet:defineObjects />
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

<%
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
	long organizationId = currentGroup.getClassPK();
  	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
  	String male = organization.getExpandoBridge().getAttribute("male").toString();
  	String date_ = organization.getExpandoBridge().getAttribute("dateofbirth").toString();
  	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
  	Date dateofbirth = dateFormat.parse(date_);
  	Date now = new Date();
  	long calc = now.getTime() - dateofbirth.getTime();
  	long MILLS_IN_YEAR = 1000L * 60 * 60 * 24 * 365;
  	long age = calc/MILLS_IN_YEAR;
  	String name = organization.getExpandoBridge().getAttribute("firstname").toString() + " " + organization.getExpandoBridge().getAttribute("lastname").toString() + " (" + organization.getExpandoBridge().getAttribute("dateofbirth").toString() + ")";
  	
	%>
	<div class="kdssmp_patientview">
		<div style="float: left; margin-right: 30px; margin-top: 15px;">
			<%if(male.equalsIgnoreCase("true")) { 
				%>
				<i class="fa fa-mars fa-4x"></i>
				<%
			} else {
				%>
				<i class="fa fa-venus fa-4x"></i>
				<%
			}
			%>
		</div>
		<div>
			<h1>Age: <b><%= age %></b></h1> <h2><%= name %></h2>
		</div>
	</div>
	<%
} else {
%>
<div>The portet is not able to work in this page.</div>
<%
}
%>
