<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>
<div id="welcome" class="maincontent">
    <h2>Welcome to the Giftbit Oauth sample app</h2>

    <h3>So what is it?</h3>
    This sample app shows what you need to build into your own application.  It and its code can be used as a working reference for each step that you will
    need to implement in your application to  securely retrieve Giftbit API and Refresh tokens for your users, and use them to make API calls to Giftbit on their behalf.

    <h3>Where do I start?</h3>

    <p>In order to understand each step in the process,
    read through the <a href="http://resources.giftbit.com/api/GiftbitOauth-latest.pdf">Giftbit OAuth documentation</a>.
    </p>

    <p>
        Once you are familiarized with the concepts and technical underpinnings, ensure you have an account set up on Giftbit's testbed platform, and that you have an application registered
        with your account.

    </p>

    <h3>OK, I'm set up in testbed.  What now?</h3>
    <p>
        Hit the 'next' button below, and use your registered application's client_id and secret that you have set up in testbed to get started.
    </p>


    <h3 class="important">Important:</h3>

    <p>
        This sample app is meant to be a reference only for the request response flow to Giftbit, and NOT as a reference or best practices guide for overall application design.
        It does things that a real application
        would never do, like store non transient data in the http session and show sensitive information in plaintext.  When designing your real application, be sure to treat all sensitive information
        that is part of this process (API Tokens, Refresh Tokens, your client secret) with the highest level of security.  We recommend encrypting these values before persisting them to your datastore.
    </p>

</div>

<ul class="nav">
    <li class="nextnav buttons">
        <g:link controller="giftbitAppCredentials">Next: Giftbit App Credentials</g:link>
    </li>
</ul>
</body>
</html>
