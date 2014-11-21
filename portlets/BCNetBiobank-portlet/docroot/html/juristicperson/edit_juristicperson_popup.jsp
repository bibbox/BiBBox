<%@ include file="/html/init.jsp" %>

<portlet:actionURL name='<%= "addJuristicPerson" %>' var="editJuristicPersonURL" windowState="normal" />
<portlet:resourceURL var="resourceURL"></portlet:resourceURL>
<liferay-ui:header
	
	title='<%= "new-juristicPerson" %>'
/>

<aui:form action="<%= resourceURL %>" method="POST" name="fm" onSubmit="event.preventDefault();">
	<aui:fieldset>

		<aui:input name="name" />

		<aui:input name="url" />

		<aui:input name="address" />

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button name="cancel" value="Cancel"/>
		
	</aui:button-row>
</aui:form>

<aui:script use="aui-base,aui-form-validator,aui-io-request">
	AUI().use('aui-base','aui-form-validator','aui-io-request',function(A){
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
	        showAllMessages:true,
	        on: {
                    validateField: function(event) {
                     },
                    validField: function(event) {
                   },
                    errorField: function(event) {
                    },
                    submitError: function(event) {
                        event.preventDefault(); //prevent form submit
                    },
                    submit: function(event) {
                        var A = AUI();
						var url = '<%=resourceURL.toString()%>';
						
						A.io.request(
						    url,
						    {
						        method: 'GET',
						        dataType: 'json',
						        form: {id: '<portlet:namespace/>fm'},
						        on: {
						            success: function() {
						            	var response = this.get('responseData');
						            	var juristicPersonId = response['juristicPersonId'];
						            	var name = response['name'];
						                //Liferay.Util.getOpener().refreshPortlet();
						                Liferay.Util.getOpener().refreshJuristicPersonPortlet(juristicPersonId, name);
						                Liferay.Util.getOpener().closePopup('juristicperson_WAR_BCNetBiobankportlet');						                
						            }
						        }
						    }
						);
                   }
                }
      	});
	});
	
</aui:script>




<aui:script use="aui-base">
    A.one('#<portlet:namespace/>cancel').on('click', function(event) {
        Liferay.Util.getOpener().closePopup('juristicperson_WAR_BCNetBiobankportlet');
    });
</aui:script>

