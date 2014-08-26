

<head>
    <title>Credentials Storage</title>
    <meta name="layout" content="main" />
</head>

<body>

<g:if test="${saved}">
    <div class="saved">Credentials Saved</div>
</g:if>

<div class="form">
    <form action="save">
        <g:textField name="app_clientid"  value="${sessionInfoStorageBean?.app_clientid}"/>

        <g:textField name="app_secret"  value="${sessionInfoStorageBean?.app_secret}"/>

        <g:submitButton name="Save" />
    </form>
</div>


</body>