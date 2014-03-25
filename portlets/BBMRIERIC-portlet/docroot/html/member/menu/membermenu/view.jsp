<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.service.OrganizationLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.Organization" %>
<%@ page import="com.liferay.portal.model.Layout" %>

<portlet:defineObjects />

<%
long organizationId_paranet = OrganizationLocalServiceUtil.getOrganizationId(themeDisplay.getCompanyId(), "BBMRI-ERIC");
Organization organization_paranet = OrganizationLocalServiceUtil.getOrganization(organizationId_paranet);

long organizationId = 0;
Organization organization = null;
com.liferay.portal.model.Group currentGroup =  themeDisplay.getLayout().getGroup();
if (currentGroup.isOrganization()) {
	organizationId = currentGroup.getClassPK();
  	organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
}

%>

	<div class="bbmri_eric_header-menucontainer">
		<div class="bbmri_eric_header-mainmenu">
			<div class="bbmri_eric_header-mainmenu-floating">
				<ul>
					<% 
					
					List<Layout> pagelayouts = LayoutLocalServiceUtil.getLayouts(organization_paranet.getGroupId(), false);
					//List<Layout> pagelayouts = themeDisplay.getLayouts();
					for(Layout l : pagelayouts) {
						if(!l.isRootLayout())
							continue;
						String pageurl = themeDisplay.getURLPortal() + "/web" + organization_paranet.getGroup().getFriendlyURL() + l.getFriendlyURL();
						if(themeDisplay.getLayout().equals(l) || (organizationId != organizationId_paranet && l.getFriendlyURL().equalsIgnoreCase("/workinggroups"))) {
						%>
							<li>
								<div style="float: left;">
									<div class="bbmri-eric-square-orange"></div>
									<div style="float: left;"><aui:a href="<%= pageurl %>" cssClass="bbmri_eric_header-mainmenu-active"><%= l.getName() %></aui:a></div>
								</div>
							</li>
						<%
						} else {
						%>
							<li>
								<div style="float: left;">
									<div class="bbmri-eric-square-blue"></div>
									<div style="float: left;"><aui:a href="<%= pageurl %>"><%= l.getName() %></aui:a></div>
								</div>
							</li>
						<%
						}
					}
					%>
				</ul>
			</div>
		</div>
	</div>
	<div class="bbmri_eric_header-submenucontainer">
		<div class="bbmri_eric_header-submainmenu">
			<div class="bbmri_eric_header-submainmenu-floating">
				<%
				if(organizationId != organizationId_paranet || themeDisplay.getURLCurrent().equalsIgnoreCase("/web/bbmri-eric/workinggroups")) {
					List<Organization> sub_organization = organization_paranet.getSuborganizations();
					for(Organization o : sub_organization) {
						String pageurl = themeDisplay.getURLPortal()+"/web"+o.getGroup().getFriendlyURL();
						if(o.getOrganizationId() == organizationId) {
						%>
							<aui:a href="<%= pageurl %>" cssClass="bbmri_eric_header-mainmenu-active"><%= o.getName() %></aui:a>
						<%
						} else {
						%>
							<aui:a href="<%= pageurl %>"><%= o.getName() %></aui:a>
						<%
						}
					}
				} else {
					List<Layout> pagelayoutschildren = themeDisplay.getLayout().getAllChildren();
					for(Layout l : pagelayoutschildren) {
						String pageurl = themeDisplay.getURLPortal() + "/web" + themeDisplay.getSiteGroup().getFriendlyURL() + l.getFriendlyURL();
						if(themeDisplay.getLayout().equals(l)) {
						%>
							<aui:a href="<%= pageurl %>" cssClass="bbmri_eric_header-mainmenu-active"><%= l.getName() %></aui:a>
						<%
						} else {
						%>
							<aui:a href="<%= pageurl %>"><%= l.getName() %></aui:a>
						<%
						}
					}
				}
				%>
			</div>
		</div>
	</div>
	<div class="bbmri_eric_header-subsubmenucontainer">
		<div class="bbmri_eric_header-subsubmainmenu">
			<%
			if(organizationId != organizationId_paranet) {
				%>
				<div class="bbmri_eric_header-subsubmainmenu-floating">
				<%
					List<Layout> organisation_pagelayouts = themeDisplay.getLayouts();
					for(Layout l : organisation_pagelayouts) {
						String pageurl = themeDisplay.getURLPortal() + "/web" + themeDisplay.getSiteGroup().getFriendlyURL() + l.getFriendlyURL();
						if(themeDisplay.getLayout().equals(l) || organizationId != organizationId_paranet) {
						%>
							<aui:a href="<%= pageurl %>" cssClass="bbmri_eric_header-mainmenu-active"><%= l.getName() %></aui:a>
						<%
						} else {
						%>
							<aui:a href="<%= pageurl %>"><%= l.getName() %></aui:a>
						<%
						}
					}
				%>
				
				</div>
			<%
			}
			%>
		</div>
	</div>