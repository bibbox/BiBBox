<%@ include file="/html/demo2/init.jsp" %> 

<portlet:defineObjects />

<style>
	.notdisplayInput {
		display: none;
	}
	.aui .highliteMultiselect {
		border: 1px solid red;
	}
	.highliteMultiselectElement {
		border: 1px solid red;
		color: red;
	}
	.aui select[multiple] {
		height: 200px;
	}
</style>

<%
String optionsGroupFilter_cfg = GetterUtil.getString(portletPreferences.getValue("optionsGroupFilter", ""));
String optionsTitle_cfg = GetterUtil.getString(portletPreferences.getValue("optionsTitle", ""));
boolean showsubgroups = true;
long organizationId = 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
long eventlayoutid =  themeDisplay.getLayout().getPlid();
long eventid = 0;
long patientId = 0;

%><h3><%= optionsTitle_cfg %></h3>
<portlet:actionURL name='createEvent' var="createEventURL" windowState="normal" />

<aui:form action="<%= createEventURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:layout>
			<aui:input type="hidden" name="patientId" value="<%= String.valueOf(organizationId) %>" />
<%

if (currentGroup.isOrganization()) {
	organizationId = currentGroup.getClassPK();
	Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
	Event event = EventLocalServiceUtil.getEventForLayout(eventlayoutid);
	eventid = event.getEventId();
	boolean status = false;
	if(event.getStatus().equalsIgnoreCase("signed")) {
		status = true;
	}
	KdssmpPatient patient = KdssmpPatientLocalServiceUtil.getKdssmpPatient(event.getPatientId());
	patientId = patient.getPatientId();
	List<KdssmpConfiguration> parameters = KdssmpConfigurationLocalServiceUtil.getConfigurationOptions("Parameter", event.getEventtype());
	for(KdssmpConfiguration parameter : parameters) {
		KdssmpParameterConfiguration parameterconfig = KdssmpParameterConfigurationLocalServiceUtil.getKdssmpParameterConfiguration(Long.parseLong(parameter.getOptionvalue()));
		String id = parameterconfig.getDatatype() + parameterconfig.getParameterconfigurationId();
		if((parameterconfig.getGrouping().startsWith(optionsGroupFilter_cfg) && showsubgroups) || parameterconfig.getGrouping().equals(optionsGroupFilter_cfg)) {
			if(parameterconfig.getDatatype().equalsIgnoreCase("html")) {
				%><%@ include file="/html/demo/dynamicevent/dynamicelementsview/html.jspf" %><%
			} else if(parameterconfig.getDatatype().equalsIgnoreCase("text")) {
				%><%@ include file="/html/demo/dynamicevent/dynamicelementsview/text.jspf" %><%
			} else if(parameterconfig.getDatatype().equalsIgnoreCase("textbox")) {
				%><%@ include file="/html/demo/dynamicevent/dynamicelementsview/textbox.jspf" %><%
			} else if(parameterconfig.getDatatype().equalsIgnoreCase("Select")) {
				%><%@ include file="/html/demo/dynamicevent/dynamicelementsview/select.jspf" %><%
			} else if(parameterconfig.getDatatype().equalsIgnoreCase("Multiselect")) {
				%><%@ include file="/html/demo/dynamicevent/dynamicelementsview/multiselect.jspf" %><%
			} else if(parameterconfig.getDatatype().equalsIgnoreCase("Calculated")) {
				%><%@ include file="/html/demo/dynamicevent/dynamicelementsview/calculated.jspf" %><%
			}  
		}
	}
}
%>
		</aui:layout>
	</aui:fieldset>
</aui:form>

<portlet:actionURL name='updateData' var="updateDataURL" />

<aui:script>
AUI.add('datastore', function (A) {
   // Write your module code here, and make your module available on the Y
   // object if desired.
   A.DatakDSSMPStore = {
       kDSSMPStore: function (target) {
		   var url = '<%= updateDataURL.toString() %>';
		   var valuetarget = "";
		   if(target.get('id').indexOf("Multiselect")  > -1) {
		   		var inputObject=A.all("#" + target.get('id') + " option:selected");
   		   		inputObject.each(function (taskNode) {
			   		valuetarget += taskNode.get('value') + ';';
		   		});
		   } else {
		   		valuetarget = target.get('value');
		   }
			A.io.request(url,{
				//this is the data that you are sending to the action method
				data: {
				   <portlet:namespace />eventid: <%= eventid %>,
				   <portlet:namespace />organizationId: <%= organizationId %>,
				   <portlet:namespace />patientId: <%= patientId %>,
				   <portlet:namespace />ontology: target.get('id'),
				   <portlet:namespace />value: valuetarget
				},
				dataType: 'json',
				on: {
				  failure: function() { alert('failure'); },
				  success: function(event, id, obj) { "success" }
				}
			});
	   }
   }
});
AUI.add('evaluationrule', function (A) {
   // Write your module code here, and make your module available on the Y
   // object if desired.
   A.EvaluationkDSSMPRule = {
       kDSSMPRule1: function () {
		   var select13 = A.all(".Select13").get('value');
		   var age = A.all(".Calculated15").get('value');
		   var select4 = A.all(".Select4").get('value');
		   var multiselect12 = '';
   		   var inputObject=A.all(".ms_Multiselect12 option:selected");
   		   inputObject.each(function (taskNode) {
			   multiselect12 += taskNode.get('value') + ';';
		   });
		   if(select13 == 'no') {
			   if(age > 10 && select4 == 'no') {
				   A.all(".ms_Multiselect12").addClass('highliteMultiselect');
				   A.all(".ms_Multiselect12_kras-testing").addClass('highliteMultiselectElement');
			   } else if(age > 10 && multiselect12.indexOf("kras-testing") > -1) {
				   A.all(".Select4").addClass('highliteMultiselect');
				   A.all(".Select4_no").addClass('highliteMultiselectElement');
			   } else {
				   //alert("nothing r1");
			   }
		   } else {
			   if(age > 10 && select4 == 'no' && multiselect12.indexOf("kras-testing") > -1) {
				   A.all(".Select13").addClass('highliteMultiselect');
				   A.all(".Select13_no").addClass('highliteMultiselectElement');
			   } else {
				   //alert("nothing r1");
			   }
		   }
       },
       kDSSMPRule2: function () {
		   var select13 = A.all(".Select13").get('value');
		   var age = A.all(".Calculated15").get('value');
		   var select4 = A.all(".Select4").get('value');
		   var select9 = A.all(".Select9").get('value');
		   var multiselect12 = '';
   		   var inputObject12=A.all(".ms_Multiselect12 option:selected");
   		   inputObject12.each(function (taskNode) {
			   multiselect12 += taskNode.get('value') + ';';
		   });
		   var multiselect11_values = '';
		   var multiselect11 = A.all(".ms_Multiselect11");
   		   var inputObject11=A.all(".ms_Multiselect11 option:selected");
   		   inputObject11.each(function (taskNode) {
			   multiselect11_values += taskNode.get('value') + ';';
		   });
		   if(select13 == 'no') {
			   if(age > 10 && select4 == '<20' && select9 == 'yes' && multiselect11_values.indexOf("folfiri-bevacizumab") > -1 && multiselect11_values.indexOf("folfiri-cetuximab") > -1) {
				   A.all(".ms_Multiselect12").addClass('highliteMultiselect');
				   A.all(".ms_Multiselect12_kras-testing").addClass('highliteMultiselectElement');
			   } else if(age > 10 && multiselect12.indexOf("kras-testing") > -1  && select9 == 'yes' && multiselect11_values.indexOf("folfiri-bevacizumab") > -1 && multiselect11_values.indexOf("folfiri-cetuximab") > -1) {
				   A.all(".Select4").addClass('highliteMultiselect');
				   A.all(".Select4_<20").addClass('highliteMultiselectElement');
			   } else if(age > 10 && multiselect12.indexOf("kras-testing") > -1  && select4 == '<20' && multiselect11_values.indexOf("folfiri-bevacizumab") > -1 && multiselect11_values.indexOf("folfiri-cetuximab") > -1) {
				   A.all(".Select9").addClass('highliteMultiselect');
				   A.all(".Select9_yes").addClass('highliteMultiselectElement');
			   } else if(age > 10 && multiselect12.indexOf("kras-testing") > -1  && select4 == '<20' && select9 == 'yes' && multiselect11_values.indexOf("folfiri-bevacizumab") > -1) {
				   A.all(".ms_Multiselect11").addClass('highliteMultiselect');
				   A.all(".ms_Multiselect11_folfiri-cetuximab").addClass('highliteMultiselectElement');
			   } else if(age > 10 && multiselect12.indexOf("kras-testing") > -1  && select4 == '<20' && select9 == 'yes' && multiselect11_values.indexOf("folfiri-cetuximab") > -1) {
				   A.all(".ms_Multiselect11").addClass('highliteMultiselect');
				   A.all(".ms_Multiselect11_folfiri-bevacizumab").addClass('highliteMultiselectElement');
			   } else {
				   //alert("nothing r2");
			   }
		   } else {
			   if(age > 10 && select4 == '<20' && multiselect12.indexOf("kras-testing") > -1  && select9 == yes && multiselect11_values.indexOf("folfiri-bevacizumab") > -1 && multiselect11_values.indexOf("folfiri-cetuximab") > -1) {
				   A.all(".Select13").addClass('highliteMultiselect');
				   A.all(".Select13_no").addClass('highliteMultiselectElement');
			   } else {
				   //alert("nothing r2");
			   }
		   }
       },
       kDSSMPRule3: function () {
		   var select13 = A.all(".Select13").get('value');
		   var age = A.all(".Calculated15").get('value');
		   var select4 = A.all(".Select4").get('value');
		   var multiselect12 = '';
   		   var inputObject=A.all(".ms_Multiselect12 option:selected");
   		   inputObject.each(function (taskNode) {
			   multiselect12 += taskNode.get('value') + ';';
		   });
		   if(select13 == 'yes-no') {
			   if(age < 50 && select4 == '>20') {
				   A.all(".ms_Multiselect12").addClass('highliteMultiselect');
				   A.all(".ms_Multiselect12_fap-sequencing").addClass('highliteMultiselectElement');
			   } else if(age < 50 && multiselect12.indexOf("fap-sequencin") > -1) {
				   A.all(".Select4").addClass('highliteMultiselect');
				   A.all(".Select4_>20").addClass('highliteMultiselectElement');
			   } else {
				   //alert("nothing r3");
			   }
		   } else {
			   if(age < 50 && select4 == '>20' && multiselect12.indexOf("fap-sequencin") > -1) {
				   A.all(".Select13").addClass('highliteMultiselect');
				   A.all(".Select13_yes-no").addClass('highliteMultiselectElement');
			   } else {
				   //alert("nothing r3");
			   }
		   }
       },
       kDSSMPRule4: function () {
		   var select13 = A.all(".Select13").get('value');
		   var age = A.all(".Calculated15").get('value');
		   var select4 = A.all(".Select4").get('value');
		   var multiselect12_value = '';
   		   var inputObject12=A.all(".ms_Multiselect12 option:selected");
   		   inputObject12.each(function (taskNode) {
			   multiselect12_value += taskNode.get('value') + ';';
		   });
		   var multiselect14_value = '';
   		   var inputObject14=A.all(".ms_Multiselect14 option:selected");
   		   inputObject12.each(function (taskNode) {
			   multiselect14_value += taskNode.get('value') + ';';
		   });
		   if(multiselect14_value != 'not specified;') {
		       //alert("false");
		   } else {
			   //alert("true");
		   }
		   if(select13 == 'yes') {
			   if(age < 50 && select4 == 'no' && multiselect12_value.indexOf("pms2") > -1 && multiselect12_value.indexOf("epcam") > -1 && multiselect12_value.indexOf("microsattelite-instability") > -1 && multiselect14_value != 'not specified;') {
				   A.all(".ms_Multiselect12").addClass('highliteMultiselect');
				   A.all(".ms_Multiselect12_msh6").addClass('highliteMultiselectElement');
			   } else if(age < 50 && multiselect12_value.indexOf("msh6") > -1 && multiselect12_value.indexOf("pms2") > -1 && multiselect12_value.indexOf("epcam") > -1 && multiselect12_value.indexOf("microsattelite-instability") > -1 && multiselect14_value != 'not specified;') {
				   A.all(".Select4").addClass('highliteMultiselect');
				   A.all(".Select4_no").addClass('highliteMultiselectElement');
			   } else if(age < 50 && select4 == 'no' && multiselect12_value.indexOf("msh6") > -1 && multiselect12_value.indexOf("epcam") > -1 && multiselect12_value.indexOf("microsattelite-instability") > -1 && multiselect14_value != 'not specified;') {
				   A.all(".ms_Multiselect12").addClass('highliteMultiselect');
				   A.all(".ms_Multiselect12_pms2").addClass('highliteMultiselectElement');
			   } else if(age < 50 && select4 == 'no' && multiselect12_value.indexOf("msh6") > -1 && multiselect12_value.indexOf("pms2") > -1 && multiselect12_value.indexOf("microsattelite-instability") > -1 && multiselect14_value != 'not specified;') {
				   A.all(".ms_Multiselect12").addClass('highliteMultiselect');
				   A.all(".ms_Multiselect12_epcam").addClass('highliteMultiselectElement');
			   } else if(age < 50 && select4 == 'no' && multiselect12_value.indexOf("msh6") > -1 && multiselect12_value.indexOf("pms2") > -1 && multiselect12_value.indexOf("epcam") > -1 && multiselect14_value != 'not specified;') {
				   A.all(".ms_Multiselect12").addClass('highliteMultiselect');
				   A.all(".ms_Multiselect12_microsattelite-instability").addClass('highliteMultiselectElement');
			   } else if(age < 50 && select4 == 'no' && multiselect12_value.indexOf("msh6") > -1 && multiselect12_value.indexOf("pms2") > -1 && multiselect12_value.indexOf("epcam") > -1 && multiselect12_value.indexOf("microsattelite-instability") > -1) {
				   alert("Rule");
				   A.all(".ms_Multiselect14").addClass('highliteMultiselect');
				   var inputObject14_options = A.all(".ms_Multiselect12_microsattelite-instability");
		   		   inputObject14_options.each(function (taskNode) {
					   taskNode.addClass('highliteMultiselectElement');
				   });
			   } else {
				   //alert("nothing r4");
			   }
		   } else {
			   if(age < 50 && select4 == 'no' && multiselect12_value.indexOf("msh6") > -1 && multiselect12_value.indexOf("pms2") > -1 && multiselect12_value.indexOf("epcam") > -1 && multiselect12_value.indexOf("microsattelite-instability") > -1 && multiselect14_value != 'not specified;') {
				   A.all(".Select13").addClass('highliteMultiselect');
				   A.all(".Select13_yes").addClass('highliteMultiselectElement');
			   } else {
				   //alert("nothing r4");
			   }
		   }
       }
   };
});

AUI().use('aui-base', 'evaluationrule', function(A){
	A.all(".ms_Multiselect12").on('change',function(){
		A.EvaluationkDSSMPRule.kDSSMPRule1();
		A.EvaluationkDSSMPRule.kDSSMPRule2();
		A.EvaluationkDSSMPRule.kDSSMPRule3();
		A.EvaluationkDSSMPRule.kDSSMPRule4();
	});
	A.all(".Select13").on('change',function(){
		A.EvaluationkDSSMPRule.kDSSMPRule1();
		A.EvaluationkDSSMPRule.kDSSMPRule2();
		A.EvaluationkDSSMPRule.kDSSMPRule3();
		A.EvaluationkDSSMPRule.kDSSMPRule4();
	});
	A.all(".Select4").on('change',function(){
		A.EvaluationkDSSMPRule.kDSSMPRule1();
		A.EvaluationkDSSMPRule.kDSSMPRule2();
		A.EvaluationkDSSMPRule.kDSSMPRule3();
		A.EvaluationkDSSMPRule.kDSSMPRule4();
	});
	A.all(".Select9").on('change',function(){
		A.EvaluationkDSSMPRule.kDSSMPRule2();
	});
	A.all(".ms_Multiselect11").on('change',function(){
		A.EvaluationkDSSMPRule.kDSSMPRule2();
	});
	A.all(".ms_Multiselect14").on('change',function(){
		A.EvaluationkDSSMPRule.kDSSMPRule4();
	});
});
</aui:script>
