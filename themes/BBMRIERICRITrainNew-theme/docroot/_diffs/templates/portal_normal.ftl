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

	<div class="bbmri_eric_header-innercontainer">

        <img class="bbmri_eric_header-image" src="/BBMRIERICRITrainNew-theme/images/header.png" alt="RItrain Header Image">

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
					<img  alt="Login" height="45px" src="/BBMRIERICRITrainNew-theme/images/Login_button.png" width="45px" >
				</a>
			</#if>
        </div>

		<!-- Logo -->
        <div class="bbmri_eric_header-logo">
            <img style="border-style: ridge;border-width: 0px;border-color: #F0F8FF;" class="bbmri_eric_header-logo-position" src="/BBMRIERICRITrainNew-theme/images/logo_ritrain.png" alt="RItrain" width="75">
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
<div class="bbmrieric-footer-container bbmrieric-footer">
	<div class="bbmri-footer-inner">
        <div class="bbmri-footer-item">
            <img src="/BBMRIERICRITrainNew-theme/images/footer_logos/bbmri-eric.png">
        </div>
		<div class="bbmri-footer-item">
			<img src="/BBMRIERICRITrainNew-theme/images/footer_logos/Ebi_official_logo.png">
		</div>
		<div class="bbmri-footer-item">
			<img src="/BBMRIERICRITrainNew-theme/images/footer_logos/ELIXIR_logo.png">
		</div>
		<div class="bbmri-footer-item">
			<img src="/BBMRIERICRITrainNew-theme/images/footer_logos/MedUni-Wien.png">
		</div>
		<div class="bbmri-footer-item">
			<img src="/BBMRIERICRITrainNew-theme/images/footer_logos/ecrin.png">
		</div>
		<div class="bbmri-footer-item">
			<img src="/BBMRIERICRITrainNew-theme/images/footer_logos/emtrain.png">
		</div>
		<div class="bbmri-footer-item">
			<img src="/BBMRIERICRITrainNew-theme/images/footer_logos/cnrs-new.png">
		</div>
		<div class="bbmri-footer-item">
			<img src="/BBMRIERICRITrainNew-theme/images/footer_logos/minho.png">
		</div>
		<div class="bbmri-footer-item">
			<img src="/BBMRIERICRITrainNew-theme/images/footer_logos/EATRIS-logo.png">
		</div>
		<div class="bbmri-footer-item">
			<img src="/BBMRIERICRITrainNew-theme/images/footer_logos/logo_share.gif">
		</div>
		<div class="bbmri-footer-item">
			<img src="/BBMRIERICRITrainNew-theme/images/footer_logos/logo-infrafrontier.png">
		</div>
		<div class="bbmri-footer-item">
			<img src="/BBMRIERICRITrainNew-theme/images/footer_logos/ISBE.png">
		</div>
		<div class="bbmri-footer-item">
			<img src="/BBMRIERICRITrainNew-theme/images/footer_logos/IMG.png">
		</div>
		<div class="bbmri-footer-item">
			<img src="/BBMRIERICRITrainNew-theme/images/footer_logos/unimib.png">
		</div>
		<div class="bbmri-footer-item">
			<img src="/BBMRIERICRITrainNew-theme/images/footer_logos/oncourse.png">
		</div>
	</div>
</div>


${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

</body>

</html>