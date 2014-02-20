<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	${theme.include(top_head_include)}
</head>

<body class="${css_class}">
<!-- New Header -->

<div class="bbmri_eric_header-maincontainer">
	<div class="bbmri_eric_header-maincontainer-verlauf"><img  alt="${logo_description}" height="325px" src="/BBMRIERIC-theme/images/BBMRI-Logo-homepage-bg.png" width="449px" ></div>
	<div class="bbmri_eric_header-innercontainer">
		<div class="bbmri_eric_header-logo"><img  alt="${logo_description}" height="100px" src="/BBMRIERIC-theme/images/bbmri_eric_logo.png" width="320px" ></div>
	</div>
</div>

<div class="bbmri_eric_header-menucontainer">
	<div class="bbmri_eric_header-mainmenu">
		<#if has_navigation || is_signed_in>
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>
	</div>
</div>

<hr><br><br><br><hr>

<!-- New Header End -->
<a href="#main-content" id="skip-to-content"><@liferay.language key="skip-to-content" /></a>

${theme.include(body_top_include)}

<#if is_signed_in>
	<@liferay.dockbar />
</#if>

<div class="bbmri-eric-header-container">
	<div class="bbmri-eric-header-container-spacer" >
	</div>
	<div class="bbmri-eric-header-container-top">
		<div class="bbmri-eric-header-container-width">	
			<div class="bbmri-eric-header-container-top-logo">
				<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
					<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
				</a>
			</div>
			<div class="bbmri-eric-header-container-top-menue">
				<#if has_navigation || is_signed_in>
					<#include "${full_templates_path}/navigation.ftl" />
				</#if>
			</div>
		</div>
	</div>
	<div class="bbmri-eric-header-container-bottom">	
		<div class="bbmri-eric-header-container-width">	
			<div class="bbmri-eric-header-container-bottom-submenue">
				<#if has_navigation || is_signed_in>
					<#include "${full_templates_path}/navigation_sub.ftl" />
				</#if>
			</div>
		</div>
	</div>
</div>

<div class="container-fluid" id="wrapper">
	<header id="banner" role="banner">
		<div id="heading">
			<h1 class="site-title">
				<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
					<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
				</a>

				<#if show_site_name>
					<span class="site-name" title="<@liferay.language_format objects="${site_name}" key="go-to-x" />">
						${site_name}
					</span>
				</#if>
			</h1>

			<h2 class="page-title">
				<span>${the_title}</span>
			</h2>
		</div>

		<#if !is_signed_in>
			<a href="${sign_in_url}" data-redirect="${is_login_redirect_required?string}" id="sign-in" rel="nofollow">${sign_in_text}</a>
		</#if>

		<#if has_navigation || is_signed_in>
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>
	</header>

	<div id="content">
		<nav id="breadcrumbs"><@liferay.breadcrumbs /></nav>

		<#if selectable>
			${theme.include(content_include)}
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			${theme.wrapPortlet("portlet.ftl", content_include)}
		</#if>
	</div>

	<footer id="footer" role="contentinfo">
		<p class="powered-by">
			<@liferay.language key="powered-by" /> <a href="http://www.liferay.com" rel="external">Liferay</a>
		</p>
	</footer>
</div>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

</body>

</html>