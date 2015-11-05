<#--
This file allows you to override and define new FreeMarker variables.
-->
<#assign my_sites_text = languageUtil.get(locale, "my-sites") />
<#assign myroles = themeDisplay.getUser().getRoles() />
<#assign is_admin = false />
<#list myroles as myrole>
   <#if myrole.getName()?contains("Administrator")>
      <#assign is_admin = true />
   </#if>
</#list>
<#-- Get the address of the Portal -->
<#assign addressLocalServiceUtil = serviceLocator.findService("com.liferay.portal.service.AddressLocalService")  />
<#assign addresses = addressLocalServiceUtil.getAddresses(themeDisplay.getCompanyId(), "com.liferay.portal.model.Account", company.getAccountId()) />
<#assign potaladdress = "" />
<#list addresses as addresse>
	<#if addresse.isPrimary()>
		<#assign potaladdress = addresse.getStreet1() + ", " + addresse.getZip() + " " + addresse.getCity() + " - <span style='text-transform: uppercase;'>" + addresse.getCountry().getName(themeDisplay.getLocale()) + "</span>" />
	</#if>
</#list>