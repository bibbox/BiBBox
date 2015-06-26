<%@ include file="/html/demo2/init.jsp" %> 

<portlet:defineObjects />

<style>
.yui3-skin-sam .yui3-calendarnav-prevmonth span,.yui3-skin-sam .yui3-calendarnav-nextmonth span
	{
	display: inline;
}
</style>
<%
long optionsPageTemplate_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsPageTemplate", "0"));
long optionsParentOrganisation_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsParentOrganisation", "0"));
long optionsRoleForUser_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsRoleForUser", "0"));
//Parameters for permission Checking
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId_create_organization = "CREATE_PATIENT";
if(permissionChecker.hasPermission(groupId, name, primKey, actionId_create_organization)) {
	%>
	<h3>Add Patient:</h3>
	<div style="border: 1px solid #000000;padding:10px;">
		<portlet:actionURL name='<%= "createNewPatientWithAZ" %>' var="createNewPatientWithAZURL" windowState="normal" />
		<aui:form action="<%= createNewPatientWithAZURL %>" method="POST" name="fm">
			<aui:fieldset>
				<aui:input name="kdssmp_pagetemplate" type="hidden" value ="<%= optionsPageTemplate_cfg %>" />
				<aui:input name="kdssmp_parentorganisation" type="hidden" value ="<%= optionsParentOrganisation_cfg %>" />
				<aui:input name="kdssmp_roleforuser" type="hidden" value ="<%= optionsRoleForUser_cfg %>" />
				<aui:layout>
					<aui:column columnWidth="100" first="true">
						<aui:input name="kdssmp_az" label="Patient AZ" type="text" value ="" />	
					</aui:column>
				</aui:layout>
			</aui:fieldset>
			<aui:button-row cssClass="proposebuttonrow">
				<aui:button type="submit" />
			</aui:button-row>
		</aui:form>
	</div>
	<br>
	<div style="border: 1px solid #000000;padding:10px;">
		<portlet:actionURL name='<%= "createNewPatient" %>' var="createNewPatientURL" windowState="normal" />
		<aui:form action="<%= createNewPatientURL %>" method="POST" name="fm">
			<aui:fieldset>
				<aui:input name="kdssmp_pagetemplate" type="hidden" value ="<%= optionsPageTemplate_cfg %>" />
				<aui:input name="kdssmp_parentorganisation" type="hidden" value ="<%= optionsParentOrganisation_cfg %>" />
				<aui:input name="kdssmp_roleforuser" type="hidden" value ="<%= optionsRoleForUser_cfg %>" />
				<aui:layout>
					<aui:column columnWidth="50" first="true">
						<aui:input name="kdssmp_firstname" label="First Name" type="text" value ="" />	
					</aui:column>
					<aui:column columnWidth="50" last="true">
						<aui:input name="kdssmp_lastname" label="Last Name" type="text" value ="" />	
					</aui:column>
					<aui:column columnWidth="50" first="true">
						<aui:select label="Gender" name="kdssmp_gender" >
							<aui:option value="male" >Male</aui:option>
							<aui:option value="female" >Female</aui:option>
						</aui:select>
					</aui:column>
					<aui:column columnWidth="50" last="true">					
						<label for="kdssmp_dob">Date of Birth</label>
						<input cssClass="kdssmp_dob form-control field-date" class="form-control field-date" name="<portlet:namespace />kdssmp_dob" type="text" placeholder="dd/mm/yyyy" value="">
					</aui:column>
				</aui:layout>
			</aui:fieldset>
			<aui:button-row cssClass="proposebuttonrow">
				<aui:button type="submit" />
			</aui:button-row>
		</aui:form>
	</div>
	<aui:script use="aui-io-request, event, node, aui-popover, valuechange, event-hover, aui-tooltip, event-valuechange, click">
	AUI().use(
	  'aui-datepicker',
	  function(Y) {
	    var datepicker = new Y.DatePicker({
			trigger: '.field-date',
			mask: '%d/%m/%Y',
			popover: {
				toolbars: {
					header: [[
						{
						   icon:'icon-trash',
						   label: 'Clear',
						   on: {
						      click: function() {
						          datepicker.clearSelection();
						      }
						   }
						 },
						{
						    icon:'icon-globe',
						    label: 'Today',
						    on: {
						        click: function() {
						             datepicker.clearSelection();
						             datepicker.selectDates(new Date());
						         }
						     }
						 }
					]]
				},
				zIndex: 1
				}
			}
		);
	}
	);
	</aui:script>
	<%
}
%>