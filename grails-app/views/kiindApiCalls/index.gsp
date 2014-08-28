<head>
    <title>Call to Kiind</title>
    <meta name="layout" content="main"/>
</head>

<body>
<div class="maincontent">

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
    <li>
        <a href="/KiindSampleOAuth/kiindApiCalls/index">Credentials Check</a>
    </li>
    <li>
        <a href="/KiindSampleOAuth/kiindApiCalls/showCampaigns">List Campaigns</a>
    </li>
    <li>
        <a href="/KiindSampleOAuth/kiindApiCalls/showMarketplace">List MarketplaceGift</a>
    </li>
    <li>
        <a href="/KiindSampleOAuth/kiindApiCalls/refreshToken">Refresh Token</a>
    </li>
</ul>
</body>