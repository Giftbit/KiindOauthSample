<head>
    <title>Credentials Storage</title>
    <meta name="layout" content="main"/>
</head>

<body>

<g:if test="${saved}">
    <div class="saved">Credentials Saved</div>
</g:if>

<div class="maincontent">

    <div class="form">
        <form action="save">
            <span class="label">client_id:</span>
            <g:textField name="app_clientid" value="${sessionInfoStorageBean?.app_clientid}"/>

            <span class="label">client_secret:</span>
            <g:textField name="app_secret" value="${sessionInfoStorageBean?.app_secret}"/>

            <g:submitButton name="Save"/>
        </form>
    </div>
</div>

<g:if test="${sessionInfoStorageBean?.app_clientid}">
    <ul class="nav">
        <li>
            <g:link controller="connectWithKiind">Next: Connect With Kiind</g:link>
        </li>
    </ul>
</g:if>

</body>