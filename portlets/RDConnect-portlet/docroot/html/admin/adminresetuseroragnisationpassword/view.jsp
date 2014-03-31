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
    	<li><a href="#tab-2">Send Invitations</a></li>
    	<li><a href="#tab-3">Tab #3</a></li>
  	</ul>
  	<div class="tab-content">
  	<%
	  		long organizationId = 0;
    		com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
    		if (currentGroup.isOrganization()) {
    			organizationId = currentGroup.getClassPK();
    			
    			List<MasterCandidate> masters = MasterCandidateLocalServiceUtil.getFilterdCandidates(organizationId);
    			long masterId = 0;
    			for(MasterCandidate master : masters) {
    				masterId = master.getMasterCandidateId();
    			}
    			
    			List<User> users = UserLocalServiceUtil.getOrganizationUsers(organizationId);
    			String password = "rdconnect$" + masterId;
    			%>
	  	<!-- --------------------------------------------------------------------------------- --> 
	  	<div id="tab-1" class="tab-pane">
	  		
    			# of Users: <%= users.size() %> | The default password: <%= password %><br>
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
    			
	  	</div>
	  	<!-- --------------------------------------------------------------------------------- --> 
	  	<div id="tab-2" class="tab-pane">
	  		Send Invitation to:
	  		<portlet:actionURL name='<%= "sendInvitation" %>' var="sendInvitationURL" windowState="normal" />
	  		<aui:form action="<%= sendInvitationURL %>" method="POST" name="fm">
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
						<hr>
						<aui:input name="rdcfrom" label="Sender" type="text" value ="<%= themeDisplay.getUser().getEmailAddress() %>"/>
						<aui:input name="rdcsubject" label="Subject" type="text" value ="Invitation to participate in RD-Connect"/>
<textarea rows="15" cols="20" id="rdctext" class="field" name="rdctext">
Dear §NAME§,
I am contacting you as you have been a very active collaborator of the EPIRARE project, which I and my group have the pleasure to coordinate.
Besides EPIRARE, we are coordinating the work-package on RD registries within the RD-Connect project (www.rd-connect.eu), an integrated research platform that links up databases, registries, biobanks and clinical bioinformatics data used in rare disease research into a central resource for researchers worldwide.  THIS MUST BE CHANGED OF COURSE

One important milestone in Rd-Connect is the creation of an online catalogue of RD registries and biobanks, which will be useful to RD researchers to retrieve the data and samples that they need to reply to their research purposes.
As compared to existing inventories, the RD-Connect catalogue will contain more information on the content of RD registries and biobanks, including the number of registered patients with certain conditions, in order to speed researchers ability to retrieve the information (data and samples) they need. 

The catalogue will also provide details of the procedures and best practices adopted by registries and biobanks to ensure the quality of their data/samples.

Inclusion into the catalogue will have many advantages also for biobanks/registries like yours:
- It multiplies the occasions of sharing data with other researchers and the possibility of being cited as author or contributor in scientific publications;
- It provides safe rules and a code of conduct for researchers in order to ensure a safe data sharing inside the network;
- It provides a simple strategy for the evaluation of the quality of registries and biobanks inside the network;
- It increases your chances for networking and promotes the use of OMICS technologies for federated registries and biobanks.

To increase your visibility into the RD-Connect catalogue we have created a template for your ID card (LINK?) wich shows essential information on your registry. </textarea>
<textarea rows="10" cols="20" id="rdclogininformation" class="field" name="rdclogininformation">
If you wish to be included into the RD-Connect catalogue you will have the possibility to update and integrate your ID-card with additional information.
Your credentials:
http://rd-connect.bibbox.org/
To Login user your e-mail address: §EMAIL§
and the Password: <%= password %>

If you do not wish to be included into the RD-Connect catalogue please click here and your ID Card will be deleted.
</textarea>
<textarea rows="5" cols="20" id="rdcGreetings" class="field" name="rdcGreetings">
We hope to keep collaborating with you in the future and will wait for your feedback.
Thank you for your collaboration and best wishes,
§YOURNAME§ and the RD Connect Team
</textarea>

					</aui:fieldset>
					<aui:button-row>
						<aui:button name="Send" type="submit" />
					</aui:button-row>
				</aui:form>
	  	</div>
	  	<!-- --------------------------------------------------------------------------------- --> 
	  	<div id="tab-3" class="tab-pane">
	  		<p>456</p>
	  	</div>
		<%
    		}
	  	%>
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