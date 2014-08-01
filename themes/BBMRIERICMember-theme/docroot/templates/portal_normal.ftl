<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />

	${theme.include(top_head_include)}

   <#if is_signed_in>
      <#if !is_admin>
         <style>
            .portlet-borderless-bar {
               visibility:hidden;
            }
         </style>
      </#if>
   </#if>
	
</head>

<body class="${css_class} bbmri-eric-body custom-background">

${theme.include(body_top_include)}

<!-- Liferay Dockbar if Admin -->
<#if is_signed_in>
	<#assign canseedockbar = user_middle_name?contains("$$$") />
	<#if is_admin>
      <@liferay.dockbar />
      <#assign canseedockbar = false />
   </#if>
   <#if canseedockbar>
      <@liferay.dockbar />
   </#if>
</#if>

<!-- BBMRI MEMBER Area Top Menue -->
<div class="bbmri-eric-member-area-top-menue">
   <div class="bbmri-eric-member-area-top-menue-container">
      <div class="bbmri-eric-member-area-top-menue-container-bbmri-member-logo">
         <a href="/about"><img alt="BBMRI-ERIC-Logo" height="40px" width="140px" src="/BBMRIERICMember-theme/images/bbmri_eric_logo.png" /></a>
      </div>
      <div class="bbmri-eric-member-area-top-menue-container-menu">
         <#if is_signed_in>
            <#assign committeesPortletId = "bbmriericcommittees_WAR_BBMRIERICportlet" />
            <#assign PortletPreferencesFactoryUtil = staticUtil["com.liferay.portlet.PortletPreferencesFactoryUtil"] />
            <#assign portletSetup = PortletPreferencesFactoryUtil.getLayoutPortletSetup(layout, committeesPortletId) />
            <#if portletSetup.getValue("portletSetupShowBorders", "") != "false" >
               <#assign temp = portletSetup.setValue("portletSetupShowBorders", "false") />
               <#assign temp = portletSetup.store() />
            </#if>
            ${theme.runtime(committeesPortletId, "", "")}
         </#if>
      </div>
   </div>
<div>
   <!-- END BBMRI MEMBER Area Top Menue -->
<#if is_signed_in>
   
   
   <div class="bbmri_eric_header-menucontainer">
   	<div class="bbmri_eric_header-menucontainer-inner">
   		<div class="bbmri_eric_header-menucontainer-inner-float">
   			<div class="bbmri_eric_header-menucontainer-inner-sitemenue-main">
   				<#if has_navigation || is_signed_in>
   					<#include "${full_templates_path}/navigation.ftl" />
   				</#if>
   			</div>
   		</div>
   	</div>
   </div>
</#if>

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
      
   </div>
</div>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

</body>

</html>