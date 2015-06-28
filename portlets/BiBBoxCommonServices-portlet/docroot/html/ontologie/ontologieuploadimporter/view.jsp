<%@ include file="/html/ontologie/init.jsp" %> 

<portlet:defineObjects />
<liferay-theme:defineObjects />

<div style="height: 160px;">
	<portlet:actionURL name='<%="uploadFile"%>' var="uploadFileURL" windowState="normal" />
	<aui:form action="<%=uploadFileURL%>" enctype="multipart/form-data" method="post" name="fm" cssClass="rdcbuttonrowuploadexcel">
		<aui:fieldset>
			<aui:layout cssClass="proposelayout">
				<aui:select label="Select Import Type" name="selectedimporttype">
					<aui:option value="orphanetdisorder" >Orphanet Disorder</aui:option>
				</aui:select>
				<input type="file" name="fileupload" id="fileupload" size="60" />
			</aui:layout>
		</aui:fieldset>
		<aui:button-row>
			<aui:button name="saveButton" type="submit" value="save" />
		</aui:button-row>
	</aui:form>
</div>
<br>