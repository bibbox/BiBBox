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



<div class="container-fluid" id="wrapper">
	<div id="rd-heading">
			<div id="signin">
			<#if !is_signed_in>
				<a href="${sign_in_url}" data-redirect="${is_login_redirect_required?string}" id="sign-in" rel="nofollow">${sign_in_text}</a>
			</#if>
			</div>	
			
		</div>

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
		<p class="powered-by">
			Linking up rare disease resarch across the world<br/> <a href="http://www.rd-connect.eu" rel="external">RD-Connect</a>
		</p>
	</footer>
</div>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}


<div id="logo-rdconnect-Public">
	<img alt="${logo_description}" height="61px" src="/RDConnectPublic-theme/images/RDLogoNew.png" width="240px" />
</div>
</body>

</html>