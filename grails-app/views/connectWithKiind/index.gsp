<head>
    <title>Connect to Kiind</title>
    <meta name="layout" content="main"/>
</head>


<body>
<div class="maincontent">
    <div class="form">
        <form action="connect">
            <span class="label">state:</span>
            <g:textField name="state" value="${state}" size="50"/>

            <g:submitButton name="Connect"/>
            <h3>Important</h3>

            <p>
                Be sure to set your redirect uri for your application in testbed to the redirect uri for your running sample app, as shown in the configuration below.
            </p>
            <br/>

            <p>
                'Connect' will redirect you to Kiind's testbed site.  You can use your own application's testbed account credentials to authenticate for testing purposes, or to simulate a more realistic situation, you can create
                a secondary account on testbed to simulate one of your users authorizing your application to gift on their behalf.
            </p>

        </form>
    </div>
</div>
</body>