<head>
    <title>Callback Success</title>
    <meta name="layout" content="main"/>
</head>

<body>

<div class="maincontent">
    <div class="success">
        Attempting to us authorization code ${code} to get valid API token
    </div>
    <hr class="widebreak"/>

    <span class="label">Request</span>
    <ul class="apiCall">
        <li>
            <span class="label">endpoint</span>
            <span class="value">${endpoint}</span>
        </li>
        <li>
            <span class="label">method</span>
            <span class="value">${method}</span>
        </li>
        <li>
            <span class="label">header</span>
            <span class="value">${header}</span>
        </li>
        <li>
            <span class="label">accept</span>
            <span class="value">${accept}</span>
        </li>
        <li>
            <span class="label">contentType</span>
            <span class="value">${contentType}</span>
        </li>


        <li>
            <span class="label">body</span>
            <span class="value"><pre>${body}</pre></span>
        </li>

    </ul>

    <hr class="widebreak"/>

    <span class="label">Response</span>
    <ul class="apiCall">
        <li>
            <span class="label">status</span>
            <span class="value">${status}</span>
        </li>
        <li>
            <span class="label">body</span>
            <span class="value">
                <pre>${json}</pre>
            </span>
        </li>
    </ul>

</div>


<ul class="nav">
    <li class="nextnav buttons">
        <g:link controller="giftbitApiCalls">
            Next: Giftbit Api Calls
        </g:link>
    </li>
</ul>

</body>