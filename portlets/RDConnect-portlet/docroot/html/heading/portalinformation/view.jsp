<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

<div>
<div id="rd-heading-shortinformation" >
<%
		long organizationId = 0;
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
                System.out.println("its a normal community");
           }
	if(organizationId != 0) {
		Organization organisation = OrganizationLocalServiceUtil.getOrganization(organizationId);
		
		String country = "";
		if(organisation.getAddress().getCountryId() != 0)
			country = CountryServiceUtil.getCountry(organisation.getAddress().getCountryId()).getNameCurrentValue();
		
		
%>
<h3><%= organisation.getName() %> <%= organizationId %></h3>
<h6><%= organisation.getAddress().getCity() %>, <%= country %></h6>

<%				
	}
%>
</div>
<div id="rd-heading-aktions">
Aktions
</div>
<div id="rd-heading-submenue">
<%@ include file="/html/heading/portalinformation/submenu.jsp" %>
</div>


</div>