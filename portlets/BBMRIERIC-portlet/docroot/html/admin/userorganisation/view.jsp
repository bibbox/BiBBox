<%@ include file="/html/init.jsp"%>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.Group" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<portlet:defineObjects />

BBMRI-ERIC User Managment Portlet

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);
List<Group> groups = GroupLocalServiceUtil.getGroups(themeDisplay.getCompanyId(), 0, true);
%>


<div id="BBMRIERICTab">

  <ul class="nav nav-tabs">
    <li class="active"><a href="#tab-mail">Mail To User Groups</a></li>
    <li><a href="#tab-pasword">Reset Passwords</a></li>
  </ul>

  <div class="tab-content">
    <!-- --- Send E-mail Pane --- -->
    <div id="tab-mail">
            <portlet:actionURL name='<%= "sendUserEmailForOrganisations" %>' var="sendUserEmailForOrganisationsURL" windowState="normal" />
            <aui:form action="<%= sendUserEmailForOrganisationsURL %>" method="POST" name="fm">
               <aui:fieldset>
                  <aui:input name="subject" lable="Subject" />
                  <aui:input type="textarea" name="mailbody" lable="Body"/>
                  <aui:input type="hidden" name="redirect" value="<%= redirect %>" />
                  <aui:input type="hidden" name="numberoforganisations" value="<%= String.valueOf(groups.size()) %>" />
                  <% 
                  int counter = 0;
                  for(Group group : groups) { 
                    String organisationmail_counter = "organisationmail_" + counter;
                    String mail_counter = "mail_" + counter;
                  %>
                  <aui:input type="hidden" name="<%= organisationmail_counter %>" value="<%= group.getGroupId() %>" />
                  <aui:input type="checkbox" name="<%= mail_counter %>" label="<%= group.getDescriptiveName() %>" />
                  <% 
                  counter++;
                  } %>
               </aui:fieldset>
               <aui:button-row>
                  <aui:button name="saveButton" type="submit" />
               </aui:button-row>
            </aui:form>
    </div>
    <!-- --- Password Change Pane --- -->
    <div id="tab-password" class="tab-pane">
            <portlet:actionURL name='<%= "resetUserPasswordForOrganisations" %>' var="resetUserPasswordfororganisationsURL" windowState="normal" />
            <aui:form action="<%= resetUserPasswordfororganisationsURL %>" method="POST" name="fm">
               <aui:fieldset>
                  <aui:input name="passwordreset" value="" />
                  <aui:input type="checkbox" name="passwordresetneeded" label="User needs to change password afte first login." />
                  <aui:input type="checkbox" name="silentreset" label="User receive an email on change." />
                  <hr>
                  <aui:input type="hidden" name="redirect" value="<%= redirect %>" />
                  <aui:input type="hidden" name="numberoforganisations" value="<%= String.valueOf(groups.size()) %>" />
                  <% 
                  int counter = 0;
                  for(Group group : groups) { 
                	  String organisation_counter = "organisation_" + counter;
                	  String changepwd_counter = "changepwd_" + counter;
                  %>
                  <aui:input type="hidden" name="<%= organisation_counter %>" value="<%= group.getGroupId() %>" />
                  <aui:input type="checkbox" name="<%= changepwd_counter %>" label="<%= group.getDescriptiveName() %>" />
                  <% 
                  counter++;
                  } %>
               </aui:fieldset>
               <aui:button-row>
                  <aui:button name="saveButton" type="submit" />
               </aui:button-row>
            </aui:form>
    </div>
  </div>

</div>

<aui:script use="aui-tabview">
AUI().use(
  'aui-tabview',
  function(Y) {
    new Y.TabView(
      {
        srcNode: '#BBMRIERICTab'
      }
    ).render();
  }
);
</aui:script>
