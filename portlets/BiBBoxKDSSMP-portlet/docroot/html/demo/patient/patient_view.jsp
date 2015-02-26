<%@ include file="/html/demo/init.jsp" %> 

<portlet:defineObjects />
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

Patient:

<%
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
	long organizationId = currentGroup.getClassPK();
  	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
  	String male = organization.getExpandoBridge().getAttribute("male").toString();
	%>
	<div class="kdssmp_patientview">
		<%if(male.equalsIgnoreCase("true")) { 
			%>
			<i class="fa fa-mars fa-3x"></i>
			<%
		} else {
			%>
			<i class="fa fa-venus fa-3x"></i>
			<%
		}
		%>
		<%= organization.getName() %> | <%= organization.getExpandoBridge().getAttribute("dateofbirth") %> | <%= organization.getExpandoBridge().getAttributeType("male") %>
		
	</div>
	<%
} else {
%>
<div>The portet is not able to work in this page.</div>
<%
}
%>
