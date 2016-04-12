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
			<img id="Image-Maps-Com-image-maps-2016-01-25-124307" usemap="#image-maps-2016-01-25-124307" alt="${logo_description}" style="position: absolute;top: 0;" height="215px" src="/BBMRIERICRITrain-theme/images/RITRain_new_header_image7.png" width="1200px" >
		
			<!-- Login area -->
			<div class="bbmri_eric_header-login-top-right">
				<#if is_signed_in>
					<img style="border-style: ridge;border-width: 2px;border-color: #F0F8FF;" class="bbmri_eric_header-login-image-position" src="${user.getPortraitURL(themeDisplay)}" alt="Test Test" width="45">
					<!--<img class="bbmri_eric_header-login-image-position" alt="Login" height="45px" src="/BBMRIERICRITrain-theme/images/Login_button_ring.png" width="45px" >-->
					<div class="bbmri_eric_header-login-top-right-name">
						<div class="bbmri_eric_header-login-top-right-name-title">${user.firstName} ${user.lastName}</div>
						<a style="cursor:pointer;color:#FFFFFF;" id="portalmyuseredit" url="${my_account_url}">${my_account_text}</a><br>
						<a style="cursor:pointer;color:#FFFFFF;" href="${sign_out_url}" id="sign-out" rel="nofollow">${sign_out_text}</a>
						
						
					</div>
				<#else>
					<a href="/login">
						<img  alt="Login" height="45px" src="/BBMRIERICRITrain-theme/images/Login_button.png" width="45px" >
					</a>
				</#if>
			</div>
			<div class="bbmri_eric_header-logo">
				<img style="border-style: ridge;border-width: 0px;border-color: #F0F8FF;" class="bbmri_eric_header-logo-position" src="/BBMRIERICRITrain-theme/images/logo_ritrain.png" alt="RItrain" width="99">
			</div>
			<a href="http://ritrain.eu/partners#bbmri-eric"><div style="position: absolute;top: 0px;left: 140px;width: 192px;height: 57px;z-index: 1001;"></div></a>
			<a href="http://ritrain.eu/partners#cnrs"><div style="position: absolute;top: 58px;left: 140px;width: 60px;height: 63px;z-index: 1001;"></div></a>
			<a href="http://ritrain.eu/partners#cnrs"><div style="position: absolute;top: 58px;left: 203px;width: 150px;height: 63px;z-index: 1001;"></div></a>
			<a href="http://ritrain.eu/partners#infrontier"><div style="position: absolute;top: 124px;left: 203px;width: 198px;height: 63px;z-index: 1001;"></div></a>
			
			<a href="http://ritrain.eu/partners#embl"><div style="position: absolute;top: 0px;left: 380px;width: 159px;height: 58px;z-index: 1001;"></div></a>
			<a href="http://ritrain.eu/partners#embl"><div style="position: absolute;top: 0px;left: 538px;width: 88px;height: 59px;z-index: 1001;"></div></a>
			<a href="http://ritrain.eu/partners#uminho"><div style="position: absolute;top: 61px;left: 380px;width: 201px;height: 61px;z-index: 1001;"></div></a>
			<a href="http://ritrain.eu/partners#imperial"><div style="position: absolute;top: 120px;left: 380px;width: 247px;height: 54px;z-index: 1001;"></div></a>
			
			<a href="http://ritrain.eu/partners#MUW"><div style="position: absolute;top: 0px;left: 673px;width: 153px;height: 65px;z-index: 1001;"></div></a>
			<a href="http://ritrain.eu/partners#ecrin"><div style="position: absolute;top: 0px;left: 825px;width: 98px;height: 58px;z-index: 1001;"></div></a>
			<a href="http://ritrain.eu/partners#eatris"><div style="position: absolute;top: 65px;left: 673px;width: 184px;height: 61px;z-index: 1001;"></div></a>
			<a href="http://ritrain.eu/partners#img"><div style="position: absolute;top: 123px;left: 673px;width: 213px;height: 50px;z-index: 1001;"></div></a>
			
			<a href="http://ritrain.eu/partners#MUW"><div style="position: absolute;top: 0px;left: 929px;width: 81px;height: 52px;z-index: 1001;"></div></a>
			<a href="http://ritrain.eu/partners#share-eric"><div style="position: absolute;top: 57px;left: 907px;width: 87px;height: 63px;z-index: 1001;"></div></a>
			<a href="http://ritrain.eu/partners#UNIMIB"><div style="position: absolute;top: 120px;left: 933px;width: 52px;height: 51px;z-index: 1001;"></div></a>
		</div>
	</div>
	<div class="bbmri_eric_header-innercontainer">
		<div class="bbmri_eric_header-logo">
			<div class="bbmri_eric_header-logo-floating">
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
	<!--<div class="bbmri_eric_header-subsubmenucontainer">
		<#if has_navigation || is_signed_in>
			<#include "${full_templates_path}/navigation_sub_sub.ftl" />
		</#if>				
	</div>-->
	
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
		<div class="bbmrieric-footer-twitter" style="visibility: hidden;" >
			<a href="https://twitter.com/BBMRIERIC" target="_blank"><img id="bbmrieric-footer-twitter-slide"  src="/BBMRIERIC-theme/images/twitter.png" /></a>
		</div>
		<div class="bbmrieric-footer-linkedin" style="visibility: hidden;" >
			<a href="https://www.linkedin.com/company/bbmri-eric" target="_blank"><img id="bbmrieric-footer-linkedin-slide"  src="/BBMRIERIC-theme/images/linkedin.png" /></a>
		</div>
		
		<div class="bbmrieric-footer-menue">
			<#include "${full_templates_path}/navigation_footer.ftl" />
		</div>	
		<footer id="footer" role="contentinfo">
			<a href="/contact">contact</a> <span style="color: #FFFFFF;">|</span> <a href="/imprint">IMPRINT</a>
		</footer>
	</div>
</div>


${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

</body>

</html>