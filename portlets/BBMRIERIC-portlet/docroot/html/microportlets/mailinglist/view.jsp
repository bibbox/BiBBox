<%@ include file="/html/init.jsp" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="com.liferay.portal.model.Group" %>
<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<portlet:defineObjects />

<!-- Begin Search Form -->
<div id="mc_embed_signup">
	<div class="mc-field-group" style="width: 315px;padding-bottom:0;">
	        <label style="text-align: right;color: #184B8A;"><span style="font-weight:bold;">Search</spam> <div class="bbmri-eric-text-square-orange" style="float:right;margin-left:10px;margin-top:5px;"></div></label>
		<div class="mc-field-group-float">
		
		
			<% String searchurl1 = themeDisplay.getURLPortal()+"/web/guest/search"; %>
			<aui:form name="filterform" action="<%= searchurl1 %>" method="get" style="padding: 0;">
		        <input type="text" placeholder="What are you looking for?" value="" name="SEARCH" class="required email" id="mce-SEARCH">
		        <input type="submit" value="GO" name="subscribe" id="mc-embedded-subscribe">
	        </aui:form>
	    </div>
	</div>
</div>
<!-- END Search Form -->

<!-- Begin MailChimp Signup Form -->
<link href="//cdn-images.mailchimp.com/embedcode/classic-081711.css" rel="stylesheet" type="text/css">

<div id="mc_embed_signup">
<form action="http://bbmri-eric.us8.list-manage.com/subscribe/post?u=c7415c09f5c4d908a6ec9388d&amp;id=39dc000a0f" method="post" id="mc-embedded-subscribe-form" name="mc-embedded-subscribe-form" class="validate" target="_blank" novalidate>

<div class="mc-field-group" style="width: 315px;padding-bottom:0;">
        <label style="text-align: right;color: #184B8A;" for="mce-EMAIL">sign up for <span style="font-weight:bold;">Newsletter</spam> <div class="bbmri-eric-text-square-orange" style="float:right;margin-left:10px;margin-top:5px;"></div></label>
	<div class="mc-field-group-float">
        <input type="email" placeholder="Please enter mail address" value="" name="EMAIL" class="required email" id="mce-EMAIL">
        <input type="submit" value="SEND" name="subscribe" id="mc-embedded-subscribe">
    </div>
</div>
<div class="mc-field-group" style="display: none;">
        <label for="mce-FNAME">First Name </label>
        <input type="text" value="" name="FNAME" class="" id="mce-FNAME">
</div>
<div class="mc-field-group" style="display: none;">
        <label for="mce-LNAME">Last Name </label>
        <input type="text" value="" name="LNAME" class="" id="mce-LNAME">
</div>
        <div id="mce-responses" class="clear">
                <div class="response" id="mce-error-response" style="display:none;"></div>
                <div class="response" id="mce-success-response" style="display:none;"></div>
        </div>    <!-- real people should not fill this in and expect good things - do not remove this or risk form bot signups-->
    <div style="position: absolute; left: -5000px;"><input type="text" name="b_c7415c09f5c4d908a6ec9388d_39dc000a0f" value=""></div>
        <div class="clear" style="display: none;"><input type="submit" value="Subscribe" name="subscribe" id="mc-embedded-subscribe" class="button"></div>
</form>
<hr style="background-color:#FFFFFF; border-width:0; color:#FFFFFF; height:0px; lineheight:0; display: inline-block; text-align: left; width:100%;margin-bottom:0;margin-top: 0;">
</div>

<!--End mc_embed_signup-->
<!-- Catalogue -->
<div>
<a href="https://www.bbmriportal.eu/bbmri2.0/jsp/core/login.jsf" target="_blank">
<label style="text-align: right;color: #184B8A;"><span style="font-weight:bold;">Catalogue</spam> <div class="bbmri-eric-text-square-orange" style="float:right;margin-left:10px;margin-top:5px;"></div></label>
</a>
</div>
<!-- Wiki -->
<div>
<a href="/etools">
<label style="text-align: right;color: #184B8A;"><span style="font-weight:bold;">eTools</spam> <div class="bbmri-eric-text-square-orange" style="float:right;margin-left:10px;margin-top:5px;"></div></label>
</a>
</div>


<hr style="background-color:#FFFFFF; border-width:0; color:#FFFFFF; height:1px; lineheight:0; display: inline-block; text-align: left; width:100%;margin-bottom: 5px;margin-top: 10px;">

<script type="text/javascript">
var fnames = new Array();var ftypes = new Array();fnames[0]='EMAIL';ftypes[0]='email';fnames[1]='FNAME';ftypes[1]='text';fnames[2]='LNAME';ftypes[2]='text';
try {
    var jqueryLoaded=jQuery;
    jqueryLoaded=true;
} catch(err) {
    var jqueryLoaded=false;
}
var head= document.getElementsByTagName('head')[0];
if (!jqueryLoaded) {
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = '//ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js';
    head.appendChild(script);
    if (script.readyState && script.onload!==null){
        script.onreadystatechange= function () {
              if (this.readyState == 'complete') mce_preload_check();
        }
    }
}

var err_style = '';
try{
    err_style = mc_custom_error_style;
} catch(e){
    err_style = '#mc_embed_signup input.mce_inline_error{border-color:#6B0505;} #mc_embed_signup div.mce_inline_error{margin: 0 0 1em 0; padding: 5px 10px; background-color:#6B0505; font-weight: bold; z-index: 1; color:#fff;}';
}
var head= document.getElementsByTagName('head')[0];
var style= document.createElement('style');
style.type= 'text/css';
if (style.styleSheet) {
  style.styleSheet.cssText = err_style;
} else {
  style.appendChild(document.createTextNode(err_style));
}
head.appendChild(style);
setTimeout('mce_preload_check();', 250);

var mce_preload_checks = 0;
function mce_preload_check(){
    if (mce_preload_checks>40) return;
    mce_preload_checks++;
    try {
        var jqueryLoaded=jQuery;
    } catch(err) {
        setTimeout('mce_preload_check();', 250);
        return;
    }
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = 'http://downloads.mailchimp.com/js/jquery.form-n-validate.js';
    head.appendChild(script);
    try {
        var validatorLoaded=jQuery("#fake-form").validate({});
    } catch(err) {
        setTimeout('mce_preload_check();', 250);
        return;
    }
    mce_init_form();
}
function mce_init_form(){
    jQuery(document).ready( function($) {
      var options = { errorClass: 'mce_inline_error', errorElement: 'div', onkeyup: function(){}, onfocusout:function(){}, onblur:function(){}  };
      var mce_validator = $("#mc-embedded-subscribe-form").validate(options);
      $("#mc-embedded-subscribe-form").unbind('submit');//remove the validator so we can get into beforeSubmit on the ajaxform, which then calls the validator
      options = { url: 'http://bbmri-eric.us8.list-manage1.com/subscribe/post-json?u=c7415c09f5c4d908a6ec9388d&id=39dc000a0f&c=?', type: 'GET', dataType: 'json', contentType: "application/json; charset=utf-8",
                    beforeSubmit: function(){
                        $('#mce_tmp_error_msg').remove();
                        $('.datefield','#mc_embed_signup').each(
                            function(){
                                var txt = 'filled';
                                var fields = new Array();
                                var i = 0;
                                $(':text', this).each(
                                    function(){
                                        fields[i] = this;
                                        i++;
                                    });
                                $(':hidden', this).each(
                                    function(){
                                        var bday = false;
                                        if (fields.length == 2){
                                            bday = true;
                                            fields[2] = {'value':1970};//trick birthdays into having years
                                        }
                                        if ( fields[0].value=='MM' && fields[1].value=='DD' && (fields[2].value=='YYYY' || (bday && fields[2].value==1970) ) ){
                                                this.value = '';
                                                                            } else if ( fields[0].value=='' && fields[1].value=='' && (fields[2].value=='' || (bday && fields[2].value==1970) ) ){
                                                this.value = '';
                                                                            } else {
                                                                                if (/\[day\]/.test(fields[0].name)){
                                                this.value = fields[1].value+'/'+fields[0].value+'/'+fields[2].value;
                                                                                } else {
                                                this.value = fields[0].value+'/'+fields[1].value+'/'+fields[2].value;
                                                }
                                            }
                                    });
                            });
                        $('.phonefield-us','#mc_embed_signup').each(
                            function(){
                                var fields = new Array();
                                var i = 0;
                                $(':text', this).each(
                                    function(){
                                        fields[i] = this;
                                        i++;
                                    });
                                $(':hidden', this).each(
                                    function(){
                                        if ( fields[0].value.length != 3 || fields[1].value.length!=3 || fields[2].value.length!=4 ){
                                                this.value = '';
                                                                            } else {
                                                                                this.value = 'filled';
                                            }
                                    });
                            });
                        return mce_validator.form();
                    },
                    success: mce_success_cb
                };
      $('#mc-embedded-subscribe-form').ajaxForm(options);


    });
}
function mce_success_cb(resp){
    $('#mce-success-response').hide();
    $('#mce-error-response').hide();
    if (resp.result=="success"){
        $('#mce-'+resp.result+'-response').show();
        $('#mce-'+resp.result+'-response').html(resp.msg);
        $('#mc-embedded-subscribe-form').each(function(){
            this.reset();
        });
    } else {
        var index = -1;
        var msg;
        try {
            var parts = resp.msg.split(' - ',2);
            if (parts[1]==undefined){
                msg = resp.msg;
            } else {
                i = parseInt(parts[0]);
                if (i.toString() == parts[0]){
                    index = parts[0];
                    msg = parts[1];
                } else {
                    index = -1;
                    msg = resp.msg;
                }
            }
        } catch(e){
            index = -1;
            msg = resp.msg;
        }
        try{
            if (index== -1){
                $('#mce-'+resp.result+'-response').show();
                $('#mce-'+resp.result+'-response').html(msg);
            } else {
                err_id = 'mce_tmp_error_msg';
                html = '<div id="'+err_id+'" style="'+err_style+'"> '+msg+'</div>';

                var input_id = '#mc_embed_signup';
                var f = $(input_id);
                if (ftypes[index]=='address'){
                    input_id = '#mce-'+fnames[index]+'-addr1';
                    f = $(input_id).parent().parent().get(0);
                } else if (ftypes[index]=='date'){
                    input_id = '#mce-'+fnames[index]+'-month';
                    f = $(input_id).parent().parent().get(0);
                } else {
                    input_id = '#mce-'+fnames[index];
                    f = $().parent(input_id).get(0);
                }
                if (f){
                    $(f).append(html);
                    $(input_id).focus();
                } else {
                    $('#mce-'+resp.result+'-response').show();
                    $('#mce-'+resp.result+'-response').html(msg);
                }
            }
        } catch(e){
            $('#mce-'+resp.result+'-response').show();
            $('#mce-'+resp.result+'-response').html(msg);
        }
    }
}

</script>