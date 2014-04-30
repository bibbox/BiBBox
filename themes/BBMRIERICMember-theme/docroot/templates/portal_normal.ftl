<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	${theme.include(top_head_include)}
</head>

<body class="${css_class} bbmri-eric-body">

${theme.include(body_top_include)}

<!-- Liferay Dockbar if Admin -->
<#if is_signed_in>
	<!--<#if user_id == 11728>
		<@liferay.dockbar />
	</#if>
	<#if user_id == 10785>
		<@liferay.dockbar />
	</#if>
	<#if user_id == 10434>
		<@liferay.dockbar />
	</#if>-->
	<@liferay.dockbar />
</#if>

<!-- BBMRI MEMBER Area Top Menue -->
<div class="bbmri-eric-member-area-top-menue">
   <div class="bbmri-eric-member-area-top-menue-container">
      <div class="bbmri-eric-member-area-top-menue-container-bbmri-member-logo">
         <a href="/web/guest/about"><img alt="BBMRI-ERIC-Logo" height="40px" width="140px" src="/BBMRIERICMember-theme/images/bbmri_eric_logo.png" /></a>
      </div>
      <div class="bbmri-eric-member-area-top-menue-container-username">
         <#if is_signed_in>
            ${user_name}
         <#else>
            <a href="${sign_in_url}" data-redirect="${is_login_redirect_required?string}" >${sign_in_text}</a>
         </#if>
      </div>
      <div class="bbmri-eric-member-area-top-menue-container-committees">
         <#assign committeesPortletId = "bbmriericcommittees_WAR_BBMRIERICportlet" />
         <#assign PortletPreferencesFactoryUtil = staticUtil["com.liferay.portlet.PortletPreferencesFactoryUtil"] />
         <#assign portletSetup = PortletPreferencesFactoryUtil.getLayoutPortletSetup(layout, committeesPortletId) />
         <#if portletSetup.getValue("portletSetupShowBorders", "") != "false" >
            <#assign temp = portletSetup.setValue("portletSetupShowBorders", "false") />
            <#assign temp = portletSetup.store() />
         </#if>
         ${theme.runtime(committeesPortletId, "", "")}
      </div>
      <div class="bbmri-eric-member-area-top-menue-container-search">
         search
      </div>
   </div>
<div>
<!-- END BBMRI MEMBER Area Top Menue -->
<div id="bbmri-eric-member-area-top-toggler">
   <div class="bbmri-eric-member-area-top-area-expand">
      <div class="bbmri-eric-member-area-top-area-expand-container">
         <div class="bbmri-eric-member-area-top-area-expand-container-user-portlet">
            <#assign userportletPortletId = "bbmriericuser_WAR_BBMRIERICportlet" />
            <#assign PortletPreferencesFactoryUtil = staticUtil["com.liferay.portlet.PortletPreferencesFactoryUtil"] />
            <#assign portletSetup = PortletPreferencesFactoryUtil.getLayoutPortletSetup(layout, userportletPortletId) />
            <#if portletSetup.getValue("portletSetupShowBorders", "") != "false" >
               <#assign temp = portletSetup.setValue("portletSetupShowBorders", "false") />
               <#assign temp = portletSetup.store() />
            </#if>
            ${theme.runtime(userportletPortletId, "", "")}
         </div>
         <div class="bbmri-eric-member-area-top-area-expand-container-committees">
            <#assign committeesareaPortletId = "bbmriericcommitteesarea_WAR_BBMRIERICportlet" />
            <#assign PortletPreferencesFactoryUtil = staticUtil["com.liferay.portlet.PortletPreferencesFactoryUtil"] />
            <#assign portletSetup = PortletPreferencesFactoryUtil.getLayoutPortletSetup(layout, committeesareaPortletId) />
            <#if portletSetup.getValue("portletSetupShowBorders", "") != "false" >
               <#assign temp = portletSetup.setValue("portletSetupShowBorders", "false") />
               <#assign temp = portletSetup.store() />
            </#if>
            ${theme.runtime(committeesareaPortletId, "", "")}
         </div>
      </div>
   </div>
   <div class="bbmri-eric-member-area-top-area-not-expand">
      <div class="bbmri-eric-member-area-top-area-not-expand-container">
         <div class="bbmri-eric-member-area-top-area-not-expand-container-toggle">
         </div>
      </div>
   </div>
</div>
<!-- BBMRI MEMBER Area Top Area -->

<!-- END BBMRI MEMBER Area Top Area -->


<div class="bbmri_eric_header-menucontainer">
	<div class="bbmri_eric_header-menucontainer-inner">
		<div class="bbmri_eric_header-menucontainer-inner-float">
			<div class="bbmri_eric_header-menucontainer-inner-sitemenue-main">
				<#if has_navigation || is_signed_in>
					<#include "${full_templates_path}/navigation.ftl" />
				</#if>
			</div>
		</div>
		<div class="bbmri_eric_header-menucontainer-inner-float">
			<div class="bbmri_eric_header-menucontainer-inner-sitemenue-sub">
				<#if has_navigation || is_signed_in>
					<#include "${full_templates_path}/navigation_sub.ftl" />
				</#if>
			</div>
		</div>
	</div>
</div>
<!-- New Header End -->
<div class="container-fluid-background">
	<div class="container-fluid" id="wrapper">
		<div id="content">
			<#if selectable>
				${theme.include(content_include)}
			<#else>
				<!--${portletDisplay.recycle()}
	
				${portletDisplay.setTitle(the_title)}
	
				${theme.wrapPortlet("portlet.ftl", content_include)}-->
			</#if>
		</div>
	</div>
</div>
<div class="bbmrieric-footer-container">
	<div class="bbmrieric-footer">
		<div class="bbmrieric-footer-menue">
			<#include "${full_templates_path}/navigation_footer.ftl" />
		</div>	
		<footer id="footer" role="contentinfo">
			<a href="mailto:contact@bbmri-eric.eu">contact@bbmri-eric.eu</a> 
		</footer>
	</div>
</div>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

</body>

</html>