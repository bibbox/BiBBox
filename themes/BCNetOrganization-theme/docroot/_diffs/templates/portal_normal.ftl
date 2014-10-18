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

<#if is_signed_in>
	<@liferay.dockbar />
</#if>
<div id="page-position">
	<div class="container-fluid" id="wrapper">
		<div id="wrapper-blue">
			<div id="page"> 
	
				<header id="banner" role="banner">
					<div id="page-header">
						<div id="logo-position">
							<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
								<img title="IARC" height="${site_logo_height}" src="${images_folder}/logoiarc.gif" width="${site_logo_width}" />
							</a>
			
							<#if show_site_name>
								<span class="site-name" title="<@liferay.language_format objects="${site_name}" key="go-to-x" />">
									${site_name}
								</span>
							</#if>
						</div>
						
						<div id="section-logo-position">
							<a href="/home">
			                  <img src="/BCNetHome-theme/images/bcnet-title.gif" hspace="10"  align="top" title="BCNet" border="0">  
							</a>
						</div>
						
						<div id="links-position">
	
							<ul id="networks">
								<li class="firstli">
									<a href="http://www.linkedin.com/groups?mostPopular=&gid=3713610"  target="_blank" title="IARC Alumni"  alt="IARC Alumni">
										<img src="${images_folder}/linkedin.jpg"/>
									</a>
								</li>
								<li class="lastli">
									<a href="http://www.iarc.fr/en/feeds/index.php"  title="IARC RSS  Feeds" alt="IARC RSS  Feeds" target="_blank">
										<img src="${images_folder}/rss.jpg"/>
									</a>
								</li>
							</ul>
							<div class="break"></div>
					
						</div>
						
						<div id="section-link-position">
	    					<a href="/home"><h1>BCNet: Biobank and Cohort Building Network</h1></a>
						</div>
						<div class="break"></div>
						
					</div>
			
					<#if !is_signed_in>
						<a href="${sign_in_url}" data-redirect="${is_login_redirect_required?string}" id="sign-in" rel="nofollow">${sign_in_text}</a>
					</#if>
			
					
				</header>
				
				<div id="topmenu-position">
					<#if has_navigation || is_signed_in>
						<#include "${full_templates_path}/navigation.ftl" />
					</#if>
				</div>
				
				<div class="break"></div>
	
				<div id="main">
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
				</div>
				
				<div class="break"></div>
				
				<div id="bottom-links">
				
					<ul id="networks">
						<li class="firstli">
							<a href="http://www.linkedin.com/groups?mostPopular=&gid=3713610"  target="_blank" title="IARC Alumni"  alt="IARC Alumni">
								<img src="${images_folder}/linkedin.jpg"/>
							</a>
						</li>
						<li class="lastli">
							<a href="http://www.iarc.fr/en/feeds/index.php"  title="IARC RSS  Feeds" alt="IARC RSS  Feeds" target="_blank">
								<img src="${images_folder}/rss.jpg"/>
							</a>
						</li>
					</ul>
				
					<div class="break"></div>
				</div>
			</div>
		</div>
	
	
		<footer id="footer" role="contentinfo">
			<div id="footer">
				<address>
					IARC, 150 Cours Albert Thomas, 69372 Lyon CEDEX 08, France - Tel: +33 (0)4 72 73 84 85 - Fax: +33 (0)4 72 73 85 75<br/>
					&copy; IARC 2014 - <a href="http://www.iarc.fr/en/copyright.php" target="_blank">All Rights Reserved.</a>
				</address>
			</div>
		</footer>
	</div>
</div>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

</body>

</html>