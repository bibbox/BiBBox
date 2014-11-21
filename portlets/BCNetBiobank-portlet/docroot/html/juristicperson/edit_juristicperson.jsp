<%@ include file="/html/init.jsp" %>

<%
	JuristicPerson juristicPerson = null;

	long juristicPersonId = ParamUtil.getLong(request, "juristicPersonId");

	if (juristicPersonId > 0) {
		juristicPerson = JuristicPersonLocalServiceUtil.getJuristicPerson(juristicPersonId);
	}

	List<JuristicPerson> juristicPersons = JuristicPersonLocalServiceUtil.getAllJuristicPersons();

	String redirect = ParamUtil.getString(request, "redirect");
	
%>

<aui:model-context bean="<%= juristicPerson %>" model="<%= JuristicPerson.class %>" />
<portlet:renderURL var="viewJuristicPersonURL" />
<portlet:actionURL name='<%= juristicPerson == null ? "addJuristicPerson" : "updateJuristicPerson" %>' var="editJuristicPersonURL" windowState="normal" />

<liferay-ui:header
	backURL="<%= viewJuristicPersonURL %>"
	title='<%= (juristicPerson != null) ? juristicPerson.getName() : "new-juristicPerson" %>'
/>

<aui:form action="<%= editJuristicPersonURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

		<aui:input name="juristicPersonId" type="hidden" value='<%= juristicPerson == null ? "" : juristicPerson.getJuristicPersonId() %>'/>

		<aui:input name="name" />

		<aui:input name="url" />

		<aui:input name="address" />

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button onClick="<%= viewJuristicPersonURL %>"  type="cancel" />
		
	</aui:button-row>
</aui:form>

<aui:script use="aui-base,aui-form-validator">
	AUI().use('aui-base','aui-form-validator',function(A){
		var rules = {
      		<portlet:namespace/>name: {
        		required: true
      		},
      		
      		<portlet:namespace/>url: {
        		url: true
      		},
      		
      		<portlet:namespace/>address: {
        		required: true
      		},
      	};

		var fieldStrings = {
			<portlet:namespace/>name: {
		    	required: 'The Name field is required.'
		  	},
		  	
		  	<portlet:namespace/>address: {
		    	required: 'The Address field is required.'
		  	},
		};
		
		new A.FormValidator({
	        boundingBox: '#<portlet:namespace/>fm',
	        fieldStrings: fieldStrings,
	        rules: rules,
	        showAllMessages:true
      	});
      	
      	
      	
	});
	
</aui:script>
