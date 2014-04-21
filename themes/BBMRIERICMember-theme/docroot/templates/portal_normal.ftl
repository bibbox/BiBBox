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

<!-- BBMRI Member top menu -->
<div class="bbmri_eric_header-top-menu">
	<div class="bbmri_eric_header-top-menu-container">
		<div class="bbmri_eric_header-top-menu-container-logo">
			<a href="http://new.bbmri-eric.eu/"><img alt="BBMRI-ERIC-Logo" height="50px" width="142px" src="/BBMRIERICMember-theme/images/bbmri-logo.png" /></a>
		</div>
		<div class="bbmri_eric_header-top-menu-container-menu">
			Container 1
		</div>
		<div class="bbmri_eric_header-top-menu-container-menu">
			Container 2
		</div>
		<div class="bbmri_eric_header-top-menu-container-menu">
			Container 3
		</div>
	</div>
</div>

<!-- New Header -->
<div class="bbmri_eric_header-maincontainer">
	<div class="bbmri_eric_header-maincontainer-inner">
		<div class="bbmri_eric_header-maincontainer-inner-image">
		<img alt="BBMRI-ERIC-Logo" height="144px" width="142px" src="/BBMRIERICMember-theme/images/testimage.png" />
		</div>
		<div class="bbmri_eric_header-maincontainer-inner-topmenue">
		Container 1
		</div>
		<div class="bbmri_eric_header-maincontainer-inner-topmenue">
			<#assign locPortletId = "mysitelist_WAR_BBMRIERICportlet" />
			<#assign PortletPreferencesFactoryUtil = staticUtil["com.liferay.portlet.PortletPreferencesFactoryUtil"] />
			<#assign portletSetup = PortletPreferencesFactoryUtil.getLayoutPortletSetup(layout, locPortletId) />
			<#if portletSetup.getValue("portletSetupShowBorders", "") != "false" >
				<#assign temp = portletSetup.setValue("portletSetupShowBorders", "false") />
				<#assign temp = portletSetup.store() />
			</#if>
			${theme.runtime(locPortletId, "", "")}
		</div>
		<div class="bbmri_eric_header-maincontainer-inner-topmenue">
			Container 3
		</div>
	</div>
</div>
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
<!-- <div class="bbmri_eric_header-member-menu">
	<#assign locPortletId = "membermenu_WAR_BBMRIERICportlet" />
	<#assign PortletPreferencesFactoryUtil = staticUtil["com.liferay.portlet.PortletPreferencesFactoryUtil"] />
	<#assign portletSetup = PortletPreferencesFactoryUtil.getLayoutPortletSetup(layout, locPortletId) />
	<#if portletSetup.getValue("portletSetupShowBorders", "") != "false" >
		<#assign temp = portletSetup.setValue("portletSetupShowBorders", "false") />
		<#assign temp = portletSetup.store() />
	</#if>
	${theme.runtime(locPortletId, "", "")}
</div>-->
<!-- New Header End -->
<div class="container-fluid-background">
	<div class="container-fluid" id="wrapper">
		<div id="content">
			<#if selectable>
				${theme.include(content_include)}
			<#else>
				${portletDisplay.recycle()}
	
				${portletDisplay.setTitle(the_title)}
	
				${theme.wrapPortlet("portlet.ftl", content_include)}
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