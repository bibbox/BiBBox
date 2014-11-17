<!-- 
BiBBoxCommonServices
user/invitation

 -->
<%@ include file="/html/user/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
long organizationId = ParamUtil.getLong(request, "organizationId");
String redirect = ParamUtil.getString(request, "redirect");
%>

<% 
String tmpTitle = "new-assessment";

String background1_1 = "Not Specified";
String elsi1_2 = "Not Specified";
String quality1_3 = "Not Specified";
String cataloguemeetpurposes2_1 = "Not Specified";
String adequateitplatform2_2 = "Not Specified";
String addedvaluecatalogue2_3 = "Not Specified";
String associateddata2_4 = "Not Specified";
String reasonstoaccept3_1 = "Not Specified";
String recommendation3_2 = "Not Specified";
String needadditionalinformation3_3 = "Not Specified";
String finalrecommendation_4 = "Not Specified";


%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%=tmpTitle %>'
/>

<portlet:actionURL name='createAssessment' var="createAssessmentURL" windowState="normal" />
<aui:form action="<%= createAssessmentURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:input type="hidden" name="organizationId" value="<%= String.valueOf(organizationId) %>" />
		<aui:input type="hidden" name="organizationId" value="0" />
		<aui:layout>
			<h2>1 GENERAL INFORMATION ON THE BIOBANK</h2>
			<aui:column columnWidth="100" first="true">
				<aui:select name="background1_1" showEmptyOption="<%= true %>" label="<h3>1.1 Biobank background (year of experience, Director's CV, etc)</h3>">
					<aui:option value="Not Specified" selected="<%=\"Not Specified\".equals(background1_1) %>">Not Specified</aui:option>
					<aui:option value="Appropriate" selected="<%=\"Appropriate\".equals(background1_1) %>">Appropriate</aui:option>
					<aui:option value="Inadequate" selected="<%=\"Inadequate\".equals(background1_1) %>">Inadequate</aui:option>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input type="textarea" name="background1_1_comments" label="Comments, if any:" />
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:select name="elsi1_2" showEmptyOption="<%= true %>" label="<h3>1.2 Does the biobank comply with ELSI issues?</h3>">
					<aui:option value="Not Specified" selected="<%=\"Not Specified\".equals(elsi1_2) %>">Not Specified</aui:option>
					<aui:option value="Yes" selected="<%=\"Yes\".equals(elsi1_2) %>">Yes</aui:option>
					<aui:option value="No" selected="<%=\"No\".equals(elsi1_2) %>">No</aui:option>
					<aui:option value="Unclear" selected="<%=\"Unclear\".equals(elsi1_2) %>">Unclear</aui:option>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:select name="quality1_3" showEmptyOption="<%= true %>" label="<h3>1.3 Does the biobank comply with quality standards?</h3>">
					<aui:option value="Not Specified" selected="<%=\"Not Specified\".equals(quality1_3) %>">Not Specified</aui:option>
					<aui:option value="Yes" selected="<%=\"Yes\".equals(quality1_3) %>">Yes</aui:option>
					<aui:option value="No" selected="<%=\"No\".equals(quality1_3) %>">No</aui:option>
					<aui:option value="Unclear" selected="<%=\"Unclear\".equals(quality1_3) %>">Unclear</aui:option>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input type="textarea" name="quality1_3_comments" label="Comments, if any:" />
			</aui:column>
			<h2>2 SAMPLE COLLECTIONS</h2>
			<aui:column columnWidth="100" first="true">
				<aui:select name="cataloguemeetpurposes2_1" showEmptyOption="<%= true %>" label="<h3>1.3 Does the biobank comply with quality standards?</h3>">
					<aui:option value="Not Specified" selected="<%=\"Not Specified\".equals(cataloguemeetpurposes2_1) %>">Not Specified</aui:option>
					<aui:option value="Yes" selected="<%=\"Yes\".equals(cataloguemeetpurposes2_1) %>">Yes</aui:option>
					<aui:option value="No" selected="<%=\"No\".equals(cataloguemeetpurposes2_1) %>">No</aui:option>
					<aui:option value="Unclear" selected="<%=\"Unclear\".equals(cataloguemeetpurposes2_1) %>">Unclear</aui:option>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:select name="adequateitplatform2_2" showEmptyOption="<%= true %>" label="<h3>1.3 Does the biobank comply with quality standards?</h3>">
					<aui:option value="Not Specified" selected="<%=\"Not Specified\".equals(adequateitplatform2_2) %>">Not Specified</aui:option>
					<aui:option value="Yes" selected="<%=\"Yes\".equals(adequateitplatform2_2) %>">Yes</aui:option>
					<aui:option value="No" selected="<%=\"No\".equals(adequateitplatform2_2) %>">No</aui:option>
					<aui:option value="Unclear" selected="<%=\"Unclear\".equals(adequateitplatform2_2) %>">Unclear</aui:option>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:select name="addedvaluecatalogue2_3" showEmptyOption="<%= true %>" label="<h3>1.3 Does the biobank comply with quality standards?</h3>">
					<aui:option value="Not Specified" selected="<%=\"Not Specified\".equals(addedvaluecatalogue2_3) %>">Not Specified</aui:option>
					<aui:option value="Yes" selected="<%=\"Yes\".equals(addedvaluecatalogue2_3) %>">Yes</aui:option>
					<aui:option value="No" selected="<%=\"No\".equals(addedvaluecatalogue2_3) %>">No</aui:option>
					<aui:option value="Unclear" selected="<%=\"Unclear\".equals(addedvaluecatalogue2_3) %>">Unclear</aui:option>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:select name="associateddata2_4" showEmptyOption="<%= true %>" label="<h3>1.3 Does the biobank comply with quality standards?</h3>">
					<aui:option value="Not Specified" selected="<%=\"Not Specified\".equals(associateddata2_4) %>">Not Specified</aui:option>
					<aui:option value="Yes" selected="<%=\"Yes\".equals(associateddata2_4) %>">Yes</aui:option>
					<aui:option value="No" selected="<%=\"No\".equals(associateddata2_4) %>">No</aui:option>
					<aui:option value="Unclear" selected="<%=\"Unclear\".equals(associateddata2_4) %>">Unclear</aui:option>
				</aui:select>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input type="textarea" name="associateddata2_4_comments" label="Comments, if any:" />
			</aui:column>
			<h2>3 OVERALL COMMENTS</h2>
			<p>Please briefly summarize the following points. These sections will be used to compile an assessment report for the biobank</p>
			<aui:column columnWidth="100" first="true">
				<aui:input type="textarea" name="reasonstoaccept3_1" label="<h3>(i) The reasons to accept (or decline) the present application:</h3>"/>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input type="textarea" name="recommendation3_2" label="<h3>(ii) Any recommendation to improve the biobank's quality and compliance to RD-Connect's standards:</h3>"/>
			</aui:column>
			<aui:column columnWidth="100" first="true">
				<aui:input type="textarea" name="needadditionalinformation3_3" label="<h3>(iii) If you need additional information from the biobank:</h3>"/>
			</aui:column>
			<h3>4 FINAL RECOMMENDATION</h3>
			<aui:column columnWidth="100" first="true">
				<aui:select name="finalrecommendation_4" showEmptyOption="<%= true %>" label="<h3>The present biobank application should be (please select one):</h3>">
					<aui:option value="Not Specified" selected="<%=\"Not Specified\".equals(finalrecommendation_4) %>">Not Specified</aui:option>
					<aui:option value="(A) Admitted with full approval - The biobank will significantly contribute to RD-Connect." selected="<%=\"(A) Admitted with full approval - The biobank will significantly contribute to RD-Connect.\".equals(finalrecommendation_4) %>">(A) Admitted with full approval - The biobank will significantly contribute to RD-Connect.</aui:option>
					<aui:option value="(B) Admitted with recommendations - Please consider the suggestions appropriately." selected="<%=\"(B) Admitted with recommendations - Please consider the suggestions appropriately.\".equals(finalrecommendation_4) %>">(B) Admitted with recommendations - Please consider the suggestions appropriately.</aui:option>
					<aui:option value="(C) Postponed - At the moment, the biobank poorly meets RD-Connect requirements." selected="<%=\"(C) Postponed - At the moment, the biobank poorly meets RD-Connect requirements.\".equals(finalrecommendation_4) %>">(C) Postponed - At the moment, the biobank poorly meets RD-Connect requirements.</aui:option>
					<aui:option value="(D) Declined - It is not an acceptable application." selected="<%=\"(D) Declined - It is not an acceptable application.\".equals(finalrecommendation_4) %>">(D) Declined - It is not an acceptable application.</aui:option>
				</aui:select>
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>