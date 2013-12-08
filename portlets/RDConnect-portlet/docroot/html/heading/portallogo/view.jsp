<%@include file="/html/init.jsp" %>

<portlet:defineObjects />
<div id="rd-heading-rdlogo"><img alt="logoRDConnect IDCard" src="<%= request.getContextPath() %>/images/RDLogo.png" width="180px" /></div>

<%
long organizationId = 0;
long comunity_id = 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isUser()) {
 	// the group is a private user community
 	// getting the userId of the group's owner is
  	organizationId = currentGroup.getClassPK();
  	//System.out.println("user group - user id :" +  userId );
}
else if (currentGroup.isOrganization()) {
  	// the group is an Organization
  	organizationId = currentGroup.getClassPK();
  	//System.out.println("Organization group - organizationId  :" +  organizationId );
}
else {
 	// its a normal community
 	//System.out.println("its a normal community");
	comunity_id = currentGroup.getClassPK();
}
if(organizationId != 0) {
	Organization organisations = OrganizationLocalServiceUtil.getOrganization(organizationId);
	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+organisations.getLogoId();
	%>
		<img alt="logo" src="<%= imgPath %>" width="180px" />
	<%
} else {
	%>
		<img alt="logo" src="<%= request.getContextPath() %>/images/RDLogoglobe.png" width="180px" />
	<%
}
%>

<br />

