<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	${theme.include(top_head_include)}
</head>

<body class="${css_class}">

${theme.include(body_top_include)}

<!-- New Header -->

<div class="bbmri_eric_header-maincontainer">
	<div class="bbmri_eric_header-maincontainer-verlauf">
		<div class="bbmri_eric_header-maincontainer-verlauf-inner">
			<img  alt="${logo_description}" height="321px" src="/BBMRIERIC-theme/images/01_header_title.png" width="1200px" >
		</div>
	</div>
	<div class="bbmri_eric_header-innercontainer">
		<div class="bbmri_eric_header-logo">
			<div class="bbmri_eric_header-logo-floating">
				<!--<img  alt="${logo_description}" height="100px" src="/BBMRIERIC-theme/images/bbmri_eric_logo.png" width="320px" >-->
			</div>
		</div>
	</div>
	<div class="bbmri_eric_header-menucontainer">
		<div class="bbmri_eric_header-mainmenu">
			<div class="bbmri_eric_header-mainmenu-position">
				<div class="bbmri_eric_header-mainmenu-floating">
					<#if has_navigation || is_signed_in>
						<#include "${full_templates_path}/navigation.ftl" />
					</#if>
				</div>
			</div>
		</div>
	</div>
	<div class="bbmri_eric_header-submenucontainer">
		<div class="bbmri_eric_header-submainmenu">
			<div class="bbmri_eric_header-submainmenu-position">
				<div class="bbmri_eric_header-submainmenu-floating">
					<#if has_navigation || is_signed_in>
						<#include "${full_templates_path}/navigation_sub.ftl" />
					</#if>
				</div>
			</div>
		</div>
	</div>
	<div class="bbmri_eric_header-subsubmenucontainer">
		<div class="bbmri_eric_header-subsubmainmenu">
			<div class="bbmri_eric_header-subsubmainmenu-floating">
				
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
				${portletDisplay.recycle()}
	
				${portletDisplay.setTitle(the_title)}
	
				${theme.wrapPortlet("portlet.ftl", content_include)}
			</#if>
		</div>
	
		<div>
			<#if is_signed_in>
				<@liferay.dockbar />
			</#if>
		</div>
	</div>
</div>
<div class="bbmrieric-footer-container">
	<div class="bbmrieric-footer">
		<div class="bbmrieric-footer-menue">
			<div class="bbmrieric-footer-menue-float">
				<#include "${full_templates_path}/navigation_footer.ftl" />
			</div>
		</div>	
		<footer id="footer" role="contentinfo">
			<a href="/web/guest/contact">Contact</a> <span style="color: #FFFFFF;">|</span> <a href="/web/guest/impressum">IMPRESSUM</a>
		</footer>
	</div>
</div>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

</body>

</html>