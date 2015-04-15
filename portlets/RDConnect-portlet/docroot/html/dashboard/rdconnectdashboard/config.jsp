<%@ include file="/html/init.jsp" %> 
<%@ page import="com.liferay.portal.kernel.util.Constants" %> 

<portlet:defineObjects />

<%
long optionsRootPage_cfg = GetterUtil.getLong(portletPreferences.getValue("optionsRootPage", "0"));
%>

<%
//Layout layout_root = LayoutLocalServiceUtil.getLayout(themeDisplay.getScopeGroupId(), false, 0);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />
<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:fieldset>
		<aui:layout cssClass="proposelayout">
   			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
   			<!-- Select Root Page -->
			<aui:column columnWidth="100" first="true">
				<aui:select label="Select Root Page" name="preferences--optionsRootPage--" >
					<%
					for(Layout layout_element : themeDisplay.getLayouts()) {
						%>
						<aui:option value="<%= layout_element.getLayoutId() %>" selected="<%= layout_element.getLayoutId() == optionsRootPage_cfg %>" > - <%= layout_element.getName() %></aui:option>
						<%
						if(layout_element.hasChildren()) {
							for(Layout layout_element_2 : layout_element.getAllChildren()) {
								%>
								<aui:option value="<%= layout_element_2.getLayoutId() %>" selected="<%= layout_element_2.getLayoutId() == optionsRootPage_cfg %>" > - - <%= layout_element_2.getName() %></aui:option>
								<%
								if(layout_element_2.hasChildren()) {
									for(Layout layout_element_3 : layout_element_2.getAllChildren()) {
										%>
										<aui:option value="<%= layout_element_3.getLayoutId() %>" selected="<%= layout_element_3.getLayoutId() == optionsRootPage_cfg %>" > - - - <%= layout_element_3.getName() %></aui:option>
										<%
										if(layout_element_3.hasChildren()) {
											for(Layout layout_element_4 : layout_element_3.getAllChildren()) {
												%>
												<aui:option value="<%= layout_element_4.getLayoutId() %>" selected="<%= layout_element_4.getLayoutId() == optionsRootPage_cfg %>" > - - - - <%= layout_element_4.getName() %></aui:option>
												<%
											}
										}
									}
								}
							}
						}
					}
					%>
				</aui:select>
			</aui:column>
   		</aui:layout>
   	</aui:fieldset>
   	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>