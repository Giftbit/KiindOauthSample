<head>
    <title>Call to Giftbit</title>
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

    <g:if test="${pageform == 'gift_display'}" >
        <g:form action="getGiftcode" name="gift_details">
            <hr class="widebreak"/>
            <span class="label">Gift Details</span>
            <ul class="apiCall">
                    <li>
                        <span class="label">giftcode</span>
                        <span class="value"><g:textField name="giftcode" valu="${giftcode}" placeholder="Giftcode"/></span>
                    </li>
            <li>
                <span class="label"> </span>
                <span class="value">
                    <g:submitButton name="Go"/>
                </span>
            </li>
        </g:form>
    </g:if>
    <g:elseif test="${pageform=='gift_redeem'}" >
        <g:form action="redeemGiftcode" name="gift_redeem" >
            <hr class="widebreak"/>
            <span class="label">Gift Redemption</span>
            <ul class="apiCall">
                    <li>
                        <span class="label">Giftcode</span>
                        <span class="value"><g:textField name="giftcode" value="${giftcode}" placeholder="Giftcode"/></span>
                    </li>
                <li>
                    <span class="label">Amount</span>
                    <span class="value"><g:textField type="number" name="amount_to_redeem_in_cents" value="${amount_to_redeem_in_cents}" placeholder="Amount to Redeem in cents"/></span>
                </li>
                 <li>
                     <span class="label">Transaction Id (Leave blank to use current time)</span>
                     <span class="value"><g:textField type="text" name="transaction_id" value="${transaction_id}" placeholder="Unique transaction Id"/></span>
                 </li>
                    <li>
                <span class="label"> </span>
                <span class="value">
                    <g:submitButton name="Go"/>
                </span>
            </li>
        </g:form>
    </g:elseif>

</div>

<ul class="nav">
    <li class="nextnav buttons">
        <g:link controller="giftbitApiCalls" action="index">Credentials Check</g:link>
    </li>
    <li class="nextnav buttons">
<g:link controller="giftbitApiCalls" action="showCampaigns">List Campaigns</g:link>
    </li>
    <li class="nextnav buttons">
    <g:link controller="giftbitApiCalls" action="showMarketplace">List MarketplaceGift</g:link>
    </li>
    <li class="nextnav buttons">
        <g:link controller="giftbitApiCalls" action="refreshToken">Refresh Token</g:link>
    </li>
    <li class="nextnav buttons">
        <g:link controller="giftbitApiCalls" action="getGiftcode">Gift Details</g:link>
    </li>
    <li class="nextnav buttons">
        <g:link controller="giftbitApiCalls" action="redeemGiftcode">Redeem Gift</g:link>
    </li>
</ul>
</body>