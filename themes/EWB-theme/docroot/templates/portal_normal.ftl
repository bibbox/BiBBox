<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	${theme.include(top_head_include)}
</head>

<body class="${css_class}">

<a href="#main-content" id="skip-to-content"><@liferay.language key="skip-to-content" /></a>

${theme.include(body_top_include)}

	<@liferay.dockbar />


<div class="container-fluid" id="wrapper">
	<header id="banner" role="banner">
		<div id="heading">
			<div class="heading-text">
				<div class="heading-text-title">Europe Biobank Week</div>
				<div class="heading-text-subtitle">Biobanking for Health Innovation</div>
				<div class="heading-text-date">September 13-16, 2016 | Vienna, Austria</div>
			</div>
		</div>


		<#if has_navigation || is_signed_in>
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>
	</header>

	<div id="content">

		<#if selectable>
			${theme.include(content_include)}
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			${theme.wrapPortlet("portlet.ftl", content_include)}
		</#if>
	</div>

	<footer id="footer" role="contentinfo">
		<div class="footer-fluid">
			<div class="footer-center">
				<a href="http://bbmri-eric.eu" rel="external"><img src="${images_folder}/BBMRI-ERIC_Logo.png" alt="BBMRI-ERIC" style="width:254px;height:80px;"></a>
				<a href="http://www.p3g.org/" rel="external"><img src="${images_folder}/p3g.png" alt="P3G" style="width:82px;height:80px;"></a>
				<a href="http://www.esbb.org/" rel="external"><img src="${images_folder}/ESBB_Logo.png" alt="ESBB" style="width:259px;height:80px;"></a>
			</div>
			<div class="footer-text">
			<p class="powered-by">
				<a href="http://bbmri.at" rel="external">Local Organizer BBMRI.at</a>
			</p>
			</div>
		</div>
	</footer>
</div>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

</body>

</html>