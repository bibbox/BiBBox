<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

<%
		long organizationId = 0;
		long currentgroup = 0;
			com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
            if (currentGroup.isUser()) {
             // the group is a private user community
             // getting the userId of the group's owner is
              long userId = currentGroup.getClassPK();
              System.out.println("user group - user id :" +  userId );
            }
            else if (currentGroup.isOrganization()) {
              // the group is an Organization
              organizationId = currentGroup.getClassPK();
              System.out.println("Organization group - organizationId  :" +  organizationId );
            }
            else {
             // its a normal community
             	currentgroup = currentGroup.getClassPK();
                System.out.println("its a normal community");
           }
	
%>
<div class="rdconnect-information-container">
	<div class="rd-heading-shortinformation">
		<%
		if(organizationId != 0) {
			Organization organisation = OrganizationLocalServiceUtil.getOrganization(organizationId);
			
			String country = "";
			if(organisation.getAddress().getCountryId() != 0)
				country = CountryServiceUtil.getCountry(organisation.getAddress().getCountryId()).getNameCurrentValue();
		%>
		<h3><%= organisation.getName() %></h3>
		<h6><%= organisation.getAddress().getCity() %>, <%= country %></h6>
		
		<%				
			} else if (currentgroup != 0) {
		%>
		<h3>RD Connect ID Card</h3>
		<h6>Number of Registries: 2067</h6>
		<h6>Number of Biobanks:   599</h6>
		<%				
			} 
		%>
	</div>
	<div class="rd-heading-aktions">
		<div id="ProfileComplededProgressBar">
		<img alt="RD Score" src="<%= request.getContextPath() %>/images/rdscore.png" width="140px" height="140px" />
		</div>
	</div>
	<div class="rd-heading-submenue">
		<%@ include file="/html/heading/portalinformation/submenu.jsp" %> 
	</div>
</div>