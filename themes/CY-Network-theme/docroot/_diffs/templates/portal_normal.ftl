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

<#assign loginpage = themeDisplay.getURLCurrent()?contains("_58_struts_action=%2Flogin%2Flogin") />
<#if false>
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
</#if>


<!-- New Header -->

<div class="bbmri_eric_header-maincontainer">
	<div class="bbmri_eric_header-maincontainer-verlauf">
		<div class="bbmri_eric_header-maincontainer-verlauf-inner">
			<img  alt="${logo_description}" height="217px" src="/CY-Network-theme/images/header.png" width="1200px" >
		</div>
	</div>
	<a href="/about"><div class="bbmri_eric_header-innercontainer">
		<div class="bbmri_eric_header-logo">
			<div class="bbmri_eric_header-logo-floating">
				<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
			</div>
		</div>
	</div></a>
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
			   <div class="bbmri_eric_header-submainmenu-floating-runing-text">
               		<#if is_signed_in>
						<a href="${sign_out_url}" data-redirect="${is_login_redirect_required?string}" id="sign-out" rel="nofollow">${sign_out_text}</a>
					</#if>
			   </div>
				<div class="bbmri_eric_header-submainmenu-floating">
					<#if has_navigation || is_signed_in>
						<#include "${full_templates_path}/navigation_sub.ftl" />
					</#if>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- New Header End -->
<div class="container-fluid-background">
	<div class="container-fluid" id="wrapper">
	<div>
			<#if is_signed_in>
				<#assign canseedockbar = user_middle_name?contains("$$$") />
			   <#if is_admin>
			   	<#assign canseedockbar = false />
				  <@liferay.dockbar />
				</#if>
				
            <#if canseedockbar>
               <@liferay.dockbar />
            </#if>
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
</div>
<div class="bbmrieric-footer-container">
	<div class="bbmrieric-footer">
		<div class="bbmrieric-footer-twitter"  style="visibility: hidden;">
			<a href="https://twitter.com/BBMRIERIC" target="_blank"><img id="bbmrieric-footer-twitter-slide"  src="/BBMRIERIC-theme/images/twitter.png" /></a>
		</div>
		<div class="bbmrieric-footer-linkedin"  style="visibility: hidden;">
			<a href="http://www.linkedin.com/company/bbmri-eric" target="_blank"><img id="bbmrieric-footer-linkedin-slide"  src="/BBMRIERIC-theme/images/linkedin.png" /></a>
		</div>
		
		<div class="bbmrieric-footer-menue-left">
			<span style="color:#ed660a">${company_name}</span> | ${potaladdress}
		</div>	
		<div class="bbmrieric-footer-menue">
			<#include "${full_templates_path}/navigation_footer.ftl" />
		</div>	
	</div>
</div>


${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

</body>

</html>