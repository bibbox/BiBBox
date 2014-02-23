<%@include file="/html/init.jsp" %>
<div id="rdc-candidate-propose">

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);	

	Candidate candidate = null;
	
	String[] countrylist = CandidateLocalServiceUtil.getCountryNames();
	String[] types = CandidateLocalServiceUtil.getTypesOfCandidatesNewEntry();
	
	boolean success = ParamUtil.getBoolean(request, "success");
	
	String name = "";
	String url = "";
	String contact_person = "";
	String type = "";
	String country = "";
	String diseases_icd10 = "";
	String diseases_free = "";
	String commend = "";
	String address = "";
	String mail = "";
	String head = "";
	String submitter_name = ParamUtil.getString(request, "submittername");
	String submitter_email = ParamUtil.getString(request, "submitteremail");
	String candidatesubtype = "";
%>



<liferay-ui:success key="candidate-saved-successfully" message="candidate-saved-successfully" />
<liferay-ui:error key="fields-required" message="fields-required" />

<aui:model-context bean="<%= candidate %>" model="<%= Candidate.class %>" />
<portlet:actionURL name='<%= "addCandidate" %>' var="addCandidateURL" windowState="normal" />
<aui:form action="<%= addCandidateURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:input type="hidden" name="source" value="ONLINE PROPOSED" />
		<aui:input type="hidden" name="subunit_of" value="" />
		
		<div>
		<div class="proposeheadline">Propose Candidate</div>
		<aui:layout cssClass="proposelayout">  
			<aui:column columnWidth="25" first="true">
				<aui:select name="country" label="Country" value ="<%= country %>">
					<% for (String string : countrylist) { %>
					<aui:option value="<%= string %>">
						<%= string %>
					</aui:option>
					<% } %>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="25" >
				<aui:select name="candidatetype" label="Type" value ="<%= type %>" >
					<% for (String string : types) { %>
					<aui:option value="<%= string %>" >
						<%= string %>
					</aui:option>
					<% } %>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="50" last="true">
				<aui:input name="candidatesubtype" label="Acronym" type="text" value ="<%= candidatesubtype %>" cssClass="propose" />
			</aui:column>
			
	 		<aui:column columnWidth="50" first="true">
				<liferay-ui:error key="candidate-name-required" message="candidate-name-required" />
				<aui:input name="name" type="text" label='Name <div class="proposerequired" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>' value ="<%= name %>" cssClass="propose" />
			</aui:column>
	 		<aui:column columnWidth="50" last="true">
	 			<liferay-ui:error key="candidate-contact_person-required" message="candidate-contact_person-required" />
				<aui:input name="contactperson" type="text" label='Contact Person <div class="proposerequired" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>' value ="<%= contact_person %>" cssClass="propose" />
			</aui:column>
	 		
	 		<aui:column columnWidth="50" first="true">
	 			<aui:input name="address" type="text" value ="<%= address %>" cssClass="propose" />
			</aui:column>
	 		<aui:column columnWidth="50" last="true">
	 			<liferay-ui:error key="candidate-email-required" message="candidate-email-required" />
				<liferay-ui:error key="candidate-email-error" message="candidate-email-error" />	
				<aui:input name="mail" type="text" label='Contact E-Mail <div class="proposerequired" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>' value ="<%= mail %>" cssClass="propose" />
			</aui:column>
			
	 		<aui:column columnWidth="50" first="true">
				<aui:input name="url" type="text" label='URL' value ="<%= url %>" cssClass="propose" />
			</aui:column>
	 		<aui:column columnWidth="50" last="true">
				<aui:input name="head" type="text" label="Head of Registry/Biobank" value ="<%= head %>" cssClass="propose" />
			</aui:column>
			
	 		<aui:column columnWidth="50" first="true">
				<aui:input name="diseasescodes" type="text" label='Disease Codes <span id="rdc-filter-name-help" class="rdc-filter-name-help" title="You can enter multiple disease codes with ; separated (ORPHANET, ICD10, OMIM, UMLS, MESH, MEDDRA, SNOMEDCT)"><img class="proposerequired" src="/RDConnect-portlet/images/icon_fragezeichen.png" /></span>' value ="<%= diseases_icd10 %>" cssClass="propose" />
				<aui:input name="diseasesfreetext" type="text" label='Disease description <span id="rdc-filter-name-help" class="rdc-filter-name-help" title="You can enter multiple diseases with ; separated"><img class="proposerequired" src="/RDConnect-portlet/images/icon_fragezeichen.png" /></span>' value ="<%= diseases_free %>" cssClass="propose" />
			</aui:column>
	 		<aui:column columnWidth="50" last="true">
				<aui:input name="comment" label="Comment" type="textarea" value ="<%= commend %>" cssClass="propose" />
			</aui:column>
			
		</aui:layout>
		</div>
		
		<div>
		<div class="proposeheadline">Submitter</div>
		<aui:layout cssClass="proposelayout"> 
  			<aui:column columnWidth="50" first="true">
  				<liferay-ui:error key="candidate-submitter_name-required" message="candidate-submitter_name-required" />
				<aui:input name="submittername" type="text" label='Name <div class="proposerequired" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>' value ='<%= submitter_name.equalsIgnoreCase("") ? themeDisplay.getRealUser().getFullName() : submitter_name %>' cssClass="propose" />
				<liferay-ui:error key="candidate-submitteremail-required" message="candidate-submitteremail-required" />
				<liferay-ui:error key="candidate-submitteremail-error" message="candidate-submitteremail-error" />
				<aui:input name="submitteremail" type="text" label='E-Mail <div class="proposerequired" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>' value ='<%= themeDisplay.getRealUser().getEmailAddress().startsWith("default@") ? submitter_email : submitter_email.equalsIgnoreCase("") ? themeDisplay.getRealUser().getEmailAddress() : submitter_email %>' cssClass="propose" />
			
			</aui:column>
			<aui:column columnWidth="50" last="true">	
				<liferay-ui:error key="recaptcha-required" message="recaptcha-required" />
				<% if(!themeDisplay.isSignedIn()) { %>
				<portlet:resourceURL var="captchaURL"/>
				<liferay-ui:captcha url="<%= captchaURL %>" />
				<aui:input type="hidden" name="validated" value="false" />
				<% } else { %>
				<aui:input type="hidden" name="validated" value="true" />
				<% } %>
			</aui:column>
		</aui:layout>
		</div>
	</aui:fieldset>

	
	<aui:button-row cssClass="proposebuttonrow">
		<img class="proposerequired" src="<%= request.getContextPath()%>/images/required.png" /> <span class="proposerequired">required field</span>
		<aui:button type="submit" first="true" />

		<aui:button type="cancel"  onClick="<%= redirect %>" last="true" />
	</aui:button-row>
</aui:form>
</div>
