<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Giftbit Oauth sample app"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'giftbit-favicon.png')}?v=2" type="image/x-icon">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
    <g:layoutHead/>
    <g:javascript library="application"/>
    <r:layoutResources/>
</head>

<body>

<div id="kiindLogo" role="banner"><g:link uri="/"><img
        src="${resource(dir: 'images', file: 'giftbit.png')}" width="150px" alt="Giftbit"/></g:link>

</div>

<nav:menu scope="base"/>

<g:layoutBody/>
<hr/>
<div class="footer" role="contentinfo">

    <h3 class="footerheader">Set information:</h3>
    <div class="credentials">
        <kiind:displayCurrentCredentials/>
    </div>
    <br/>
    <h3 class="footerheader">Configuration and endpoints:</h3>
    <div class="configinfo">
        <kiind:displayConfig/>
    </div>


</div>

<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
<r:layoutResources/>
</body>
</html>
