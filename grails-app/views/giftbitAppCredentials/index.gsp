<head>
    <title>Credentials Storage</title>
    <meta name="layout" content="main"/>
</head>

<body>

<g:if test="${saved}">
    <div class="saved">Credentials Saved</div>
</g:if>

<div class="maincontent">

    These values are always available in your Giftbit account developer portal

    <div class="form">
        <form action="save">
            <span class="label">client_id:</span>
            <g:textField name="app_clientid" value="${sessionInfoStorageBean?.app_clientid}"/>

            <span class="label">client_secret:</span>
            <g:textField name="app_secret" value="${sessionInfoStorageBean?.app_secret}"/>

            <g:select name="scope" from="${configBean.scopes}" />

            <g:submitButton name="Save"/>
        </form>
    </div>
</div>

<g:if test="${sessionInfoStorageBean?.app_clientid}">
    <ul class="nav">
        <li class="nextnav buttons">
            <g:link controller="connectWithGiftbit">Next: Connect With Giftbit</g:link>
        </li>
    </ul>
</g:if>

</body>