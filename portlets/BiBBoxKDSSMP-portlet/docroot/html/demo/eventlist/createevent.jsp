<%@ include file="/html/demo/init.jsp" %> 

<portlet:defineObjects />

<%
long organizationId = 0;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
	organizationId = currentGroup.getClassPK();
}
%>

<style>
	.yui3-skin-sam .yui3-calendarnav-prevmonth span, .yui3-skin-sam .yui3-calendarnav-nextmonth span {
	    display: inline;
	}
</style>

<portlet:actionURL name='createEvent' var="createEventURL" windowState="normal" />

<aui:form action="<%= createEventURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:layout>
			<aui:input type="hidden" name="patientId" value="<%= String.valueOf(organizationId) %>" />
			<aui:column columnWidth="50" first="true">
				<input class="form-control" name="kdssmpdate" type="text" placeholder="dd-mm-yyyy" value="">
			</aui:column>
			<aui:column columnWidth="50" last="true">
				<aui:select label="Event" name="eventType" >
					<aui:option value="Primärdiagnose">Primärdiagnose</aui:option>
					<aui:option value="Histologie">Histologie</aui:option>
					<aui:option value="Radiologie">Radiologie</aui:option>
					<optgroup label="Pathology">
						<aui:option value="OP Präperat">OP Präperat</aui:option>
						<aui:option value="Schnellschnitt">Schnellschnitt</aui:option>
						<aui:option value="Biopsie">Biopsie</aui:option>
						<aui:option value="Probe Excession">Probe Excession</aui:option>
						<aui:option value="Nadelbiopsie">Nadelbiopsie</aui:option>
						<aui:option value="Teilextraktion">Teilextraktion</aui:option>
						<aui:option value="Todesbefund">Todesbefund</aui:option>
					</optgroup>
				</aui:select>
			</aui:column>
			
		</aui:layout>
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>

<aui:script use="aui-io-request, event, node, aui-popover, valuechange, event-hover, aui-tooltip, event-valuechange, click">
AUI().use(
  'aui-datepicker',
  function(Y) {
    var datepicker = new Y.DatePicker(
      {
        trigger: 'input',
        mask: '%d-%m-%Y',
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
