<%@include file="/html/init.jsp" %>

<portlet:defineObjects />
<h2>Contact</h2>
<% 
long organizationId;
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
            
           //List<DDLRecord> ddls = DDLRecordLocalServiceUtil.getCompanyRecords(themeDisplay.getCompanyId(), 12017, (int)themeDisplay.getScopeGroupId(), 0, 100000, null);
           List<DDLRecord> ddls = DDLRecordLocalServiceUtil.getCompanyRecords(10154, 12017, 18601, 0, 100000000, null);
			for(DDLRecord rec : ddls) {
%>
<%= rec.getField("TextNr1").getValue() %>
<% } %>

<%= ddls.size() %>




<%= themeDisplay.getCompanyId()
%>
<%= themeDisplay.getLayout().getGroupId()
%>
<%= themeDisplay.getLayout().getCompanyId()
%>

