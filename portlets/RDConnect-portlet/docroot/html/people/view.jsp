<%@include file="/html/init.jsp" %>

<portlet:defineObjects />

<h2>People</h2>

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
            
          //DDLs nach usern
            long userId2 = themeDisplay.getUserId();
            List<Organization> organisations = OrganizationLocalServiceUtil.getUserOrganizations(userId2);
            for(Organization o : organisations) {
            organizationId = o.getOrganizationId();
            
            
            %><%= o.getName() %>  <%       
           // DDLRecordLocalServiceUtil.getCompanyRecords(themeDisplay.getCompanyId(), scope, start, end, orderByComparator)
			List<User> users = UserLocalServiceUtil.getOrganizationUsers(organizationId);
          
           for(User u : users) {
        	   String imgPath = themeDisplay.getPathImage()+"/user_portrait?screenName="+u.getScreenName()+"&amp;companyId="+u.getCompanyId();
%>
<div ><img style="float:left;" alt="" class="avatar" src="<%= imgPath %>" width="35" /> 
			<%= u.getFullName() %> <br>
			<%= u.getJobTitle() %> <br></div>

<%
           }
           break;
            }// ENDE Organisationrun
%>

