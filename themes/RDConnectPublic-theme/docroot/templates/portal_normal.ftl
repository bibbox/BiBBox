<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	${theme.include(top_head_include)}
	
	<#if is_signed_in>
		<#if !isadmin>
 			<meta http-equiv="refresh" content="0; url=http://rd-connect.bibbox.org/home" />
 		</#if>
	</#if>
	
</head>

<body class="${css_class}">

<a href="#main-content" id="skip-to-content"><@liferay.language key="skip-to-content" /></a>

${theme.include(body_top_include)}

<#if isadmin>
	<@liferay.dockbar />
</#if>

<div class="container-fluid" id="wrapper">
	<div id="rd-heading">
		<#if !is_signed_in>
			<div class="signinfloatingtext">already a member?</div>
			<div id="signin">
				<a href="${sign_in_url}" data-redirect="${is_login_redirect_required?string}" id="sign-in" rel="nofollow">${sign_in_text}</a>		
			</div>	
		</#if>
		<#if the_title != "Welcome">
			<div id="logoleft">
				<a class="" href="http://rd-connect.bibbox.org/home"><img alt="RD-Connect-IDCard-Logo" height="81px" width="287px" src="/RDConnectPublic-theme/images/rdconnectlogoidcard.png"  /></a>
			</div>
			<div id="logocenter">
				<a href="http://rd-connect.bibbox.org/home"><img alt="RD-Connect-IDCard-Logo-center" height="123px" width="184px" src="/RDConnectPublic-theme/images/centerlogo.png"  /></a>
			</div>
		</#if>	
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

	
</div>

	<footer id="footer" role="contentinfo">
		<p class="powered-by">
			Linking up rare disease resarch across the world<br/> <a href="http://www.rd-connect.eu" rel="external">RD-Connect</a>
		</p>
	</footer>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

</body>

</html>