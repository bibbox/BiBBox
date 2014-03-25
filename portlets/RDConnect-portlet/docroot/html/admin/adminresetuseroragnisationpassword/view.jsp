<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.util.Encryptor" %>

<portlet:defineObjects />

<%
String redirect = PortalUtil.getCurrentURL(renderRequest);	
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
%>

<div id="myTab">
	<ul class="nav nav-tabs">
    	<li class="active"><a href="#tab-1">Reset PW for Organisation</a></li>
    	<li><a href="#tab-2">Tab #2</a></li>
    	<li><a href="#tab-3">Tab #3</a></li>
  	</ul>
  	<div class="tab-content">
	  	<!-- --------------------------------------------------------------------------------- --> 
	  	<div id="tab-1" class="tab-pane">
	  		<%
	  		long organizationId = 0;
    		com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
    		if (currentGroup.isOrganization()) {
    			organizationId = currentGroup.getClassPK();
    			List<User> users = UserLocalServiceUtil.getOrganizationUsers(organizationId);
    			%>
    			Usersize: <%= users.size() %><br>
    			<portlet:actionURL name='<%= "resetUserPassword" %>' var="resetUserPasswordURL" windowState="normal" />
				<aui:form action="<%= resetUserPasswordURL %>" method="POST" name="fm">
					<aui:fieldset>
						<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
						<aui:input type="hidden" name="numberofuseres" value="<%= String.valueOf(users.size()) %>" />
						<aui:input type="hidden" name="organisationid" value="<%= String.valueOf(organizationId) %>" />
						<%
						int i = 0;
						for(User organisationuser : users) {
							String changeuserpw = "changeuserpw" + i;
							String changeuserpwuserid = "changeuserpwuserid" + i;
							String lastlogin = " - ";
							if(organisationuser.getLoginDate() != null) {
								lastlogin = dateFormat.format(organisationuser.getLoginDate());
							}
							String changeuserpw_label = organisationuser.getFullName() + "    (Last Login: " + lastlogin + ")";
							%>
							<aui:input type="checkbox" name="<%= changeuserpw %>" label="<%= changeuserpw_label %>" />
							<aui:input type="hidden" name="<%= changeuserpwuserid %>" value="<%= organisationuser.getUserId() %>" />
						<% 
							i++;
						} %>
					</aui:fieldset>
					<aui:button-row>
						<aui:button name="saveButton" type="submit" />
					</aui:button-row>
				</aui:form>
    			<%
    		}
	  		%>
	  	</div>
	  	<!-- --------------------------------------------------------------------------------- --> 
	  	<div id="tab-2" class="tab-pane">
	  		<p>123</p>
	  	</div>
	  	<!-- --------------------------------------------------------------------------------- --> 
	  	<div id="tab-3" class="tab-pane">
	  		<p>456</p>
	  	</div>
  	</div>
</div>

<aui:script use="aui-tabview">
AUI().use(
  'aui-tabview',
  function(Y) {
    new Y.TabView(
      {
        srcNode: '#myTab'
      }
    ).render();
  }
);
</aui:script>