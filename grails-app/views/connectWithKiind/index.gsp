
<head>
    <title>Connect to Kiind</title>
    <meta name="layout" content="main" />
</head>


<body>
<div class="maincontent">
    <div class="form">
        <form action="connect">
            <span class="label">state:</span>
            <g:textField name="state"  value="${state}"/>

            <g:submitButton name="Connect" />
            <h3>Important</h3>
            <p>'Connect' will redirect you to Kiind's testbed site.  You can use your own application's testbed account credentials to authenticate for testing purposes, or to simulate a more realistic situation, you can create
            a secondary account on testbed to simulate one of your users authorizing your application.</p>

        </form>
    </div>
</div>
</body>