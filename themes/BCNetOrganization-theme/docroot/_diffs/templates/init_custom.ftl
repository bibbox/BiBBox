<#--
This file allows you to override and define new FreeMarker variables.
-->
<#assign navLayoutLocalServiceUtil = serviceLocator.findService("com.liferay.portal.service.LayoutLocalService")  />
<#assign nav_main_items = navLayoutLocalServiceUtil.getLayouts(10181, false) />