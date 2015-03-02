<%@ include file="/html/demo/init.jsp" %> 

<portlet:defineObjects />

CreateEvent

<portlet:actionURL name='createEvent' var="createEventURL" windowState="normal" />

<aui:form action="<%= createEventURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:layout>
			<aui:column columnWidth="50" first="true">
				<aui:input name="date" ></aui:input>
			</aui:column>
			<aui:column columnWidth="50" last="true">
				<aui:select label="Event" name="event" >
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


