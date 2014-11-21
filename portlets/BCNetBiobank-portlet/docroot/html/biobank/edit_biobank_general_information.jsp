<%@ include file="/html/init.jsp" %>

<%
	Biobank biobank = null;

	long biobankDbId = ParamUtil.getLong(request, "biobankDbId");

	if (biobankDbId > 0) {
		biobank = BiobankLocalServiceUtil.getBiobank(biobankDbId);
	}

	List<JuristicPerson> juristicPersons = JuristicPersonLocalServiceUtil.getAllJuristicPersons();
	List<Country> countries = CountryLocalServiceUtil.getAllCountries();

	String redirect = ParamUtil.getString(request, "redirect");
	
	
%>

<aui:model-context bean="<%= biobank %>" model="<%= Biobank.class %>" />
<portlet:renderURL var="viewBiobankURL" />
<portlet:actionURL name='<%= biobank == null ? "addBiobank" : "updateBiobank" %>' var="editBiobankURL" windowState="normal" />

<liferay-ui:header
	backURL="<%= viewBiobankURL %>"
	title='<%= (biobank != null) ? biobank.getName() : "new-biobank" %>'
/>

<aui:form action="<%= editBiobankURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

		<aui:input name="biobankDbId" type="hidden" value='<%= biobank == null ? "" : biobank.getBiobankDbId() %>'/>

		<aui:input name="name" inlineLabel="true"/>

		<aui:input name="biobankId" inlineLabel="true"/>
		
		<aui:input name="acronym" inlineLabel="true"/>
		
		<aui:input name="url" inlineLabel="true"/>
		
		<aui:select label="Juristic Person" name="juristicPersonId" showEmptyOption="<%= true %>" inlineField="true">

	 		<%
				for (JuristicPerson juristicPerson : juristicPersons) {
			%>

			<aui:option selected="<%= biobank != null && juristicPerson.getJuristicPersonId() == biobank.getJuristicPersonId() %>"
				 value="<%= juristicPerson.getJuristicPersonId()%>">
			<%=juristicPerson.getName() %>
			</aui:option>

			<%
				}
			%>

		</aui:select>
		
		<%
			String portletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
			String portletNamespace = PortalUtil.getPortletNamespace(portletId);
		%>
		
		<c:set var="portletNameSpaceVal" value="<%=portletNamespace%>" />
		
		<liferay-portlet:renderURL 
			var="addJuristicPersonURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>"
			portletName="juristicperson_WAR_BCNetBiobankportlet">
			<liferay-portlet:param name="jspPage" value="/html/juristicperson/edit_juristicperson_popup.jsp"/>
		</liferay-portlet:renderURL>
		
		<c:set var="portletURL" value="<%=addJuristicPersonURL%>" />
		
		<aui:a href="#" onClick="${portletNameSpaceVal}showPopup('${portletURL}')" inlineLabel="true"><liferay-ui:icon image="add" message="Add Juristic Person"/></aui:a>
		
		
		<aui:select label="Country" name="countryCode" showEmptyOption="<%= true %>" inlineLabel="true">

	 		<%
				for (Country country : countries) {
			%>

			<aui:option selected="<%= biobank != null && country.getCountryCode() == biobank.getCountryCode() %>" value="<%= country.getCountryCode() %>"><%=country.getName() %></aui:option>

			<%
				}
			%>

		</aui:select>
		
		<aui:input type="textarea" name="description" inlineLabel="true"/>
		
		<% 
			String backup = null;
			if (biobank != null){
				if(biobank.getBackup()==true) backup = "yes"; else backup = "no";
			}
		%>
		<aui:select name="backup" showEmptyOption="<%= true %>" label="backup" inlineLabel="true">
			<aui:option value="true" selected="<%=\"yes\".equals(backup) %>">yes</aui:option>
			<aui:option value="false" selected="<%=\"no\".equals(backup) %>">no</aui:option>
		</aui:select>
		
		
		<% 
			String trainingCourses = null;
			if (biobank != null){
				if(biobank.getTrainingCourses()==true) trainingCourses = "yes"; else trainingCourses = "no";
			}
		%>
		<aui:select name="trainingCourses" showEmptyOption="<%= true %>" label="trainingCourses" inlineLabel="true">
			<aui:option value="true" selected="<%=\"yes\".equals(trainingCourses) %>">yes</aui:option>
			<aui:option value="false" selected="<%=\"yes\".equals(trainingCourses) %>">no</aui:option>
		</aui:select>
		

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button onClick="<%= viewBiobankURL %>"  type="cancel" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-base,aui-form-validator">
	AUI().use('aui-base',' aui-form-validator',function(A){
		var rules = {
      		<portlet:namespace/>name: {
        		required: true
      		},
      		
      		<portlet:namespace/>biobankId: {
        		required: true
      		},
      		
      		<portlet:namespace/>url: {
        		url: true
      		},
      		
      		<portlet:namespace/>juristicPersonId: {
        		required: true
      		},
      		
      		<portlet:namespace/>countryCode: {
        		required: true
      		},
      	};

		var fieldStrings = {
			<portlet:namespace/>name: {
		    	required: 'The Name field is required.'
		  	},
		  	
		  	<portlet:namespace/>biobankId: {
		    	required: 'The Biobank Id field is required.'
		  	},
		  	
		  	<portlet:namespace/>juristicPersonId: {
		    	required: 'Please select the Juristic Person.'
		  	},
		  	
		  	<portlet:namespace/>countryCode: {
		    	required: 'Please select the Country.'
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

<aui:script>
	function <portlet:namespace />showPopup(url) {
	
	    var url = url;
	    
			Liferay.Util.openWindow(
				{
					dialog: {
						cache: false,
						width:800,
						modal: true,
						centered: true
					},
					id: 'juristicperson_WAR_BCNetBiobankportlet',				
					uri: url
				}
			);
	}
	
</aui:script>

<aui:script>
    Liferay.provide(window, 'refreshPortlet', function() {
        var curPortlet = '#p_p_id<portlet:namespace/>';
        Liferay.Portlet.refresh(curPortlet);
    },
    ['aui-dialog','aui-dialog-iframe']
    );
</aui:script>

<aui:script>
    Liferay.provide(window, 'closePopup', function(dialogId) {
        var A = AUI();
        var dialog = Liferay.Util.Window.getById(dialogId);
        dialog.destroy();
    },
    ['liferay-util-window']
    );
</aui:script>
