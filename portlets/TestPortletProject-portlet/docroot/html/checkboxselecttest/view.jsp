<%@ include file="/html/init.jsp" %> 

<portlet:defineObjects />

<button id="selectall" type="button">selectall</button>
<button id="deselectall" type="button">deselectall</button>

<portlet:actionURL name='sendTest' var="sendTestURL" windowState="normal" />
<aui:form action="<%= sendTestURL %>" method="POST" name="fm">
	<aui:fieldset>
<aui:input cssClass="testcheckbox" name="testcheckbox1" label="1 check" type="checkbox" value="" checked="false" />
<aui:input cssClass="testcheckbox" name="testcheckbox2" label="2 check" type="checkbox" value="" checked="false" />
<aui:input cssClass="testcheckbox" name="testcheckbox3" label="3 check" type="checkbox" value="" checked="true" />
<aui:input cssClass="testcheckbox" name="testcheckbox4" label="4 check" type="checkbox" value="" checked="false" />
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-base">
            A.all('#selectall').on(
               'click',
               function(event) {
                  A.all('input[name*=testcheckbox]').set("value", true);
                  A.all('input[name*=testcheckbox]').set("checked", true);
               }
            );
</aui:script>

<aui:script use="aui-base">
            A.all('#deselectall').on(
               'click',
               function(event) {
                  A.all('input[name*=testcheckbox]').set("value", false);
                  A.all('input[name*=testcheckbox]').set("checked", false);
               }
            );
</aui:script>