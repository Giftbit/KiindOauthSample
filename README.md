OAuth-Example-Grails
====================

A sample application that demonstrates allowing your users to connect their Kiind or Giftbit accounts to your application via Kiind's OAuth 2.0 endpoints


## So what is it?

This sample app and its code can be used as a working reference for each step that you will need to implement in your application to securely retrieve API and Refresh tokens for your users, and use them to make API calls to on their behalf.

The Kiind Api uses 3-legged authentication to allow your users to grant you permission to send or accept gifts on their behalf.
It conforms to the [Oauth 2.0 Authorization Framework](http://tools.ietf.org/html/rfc6749) specification and supports several of the grant type flows.

Documentation specifically for the Kiind OAuth interface can be found at [http://resources.kiind.me/api/KiindOauth-latest.pdf] .

To use your OAuth acquired tokens:
If you building the sending of gifts into your application, you can find documentation for the Kiind gift API at [http://resources.kiind.me/api/KiindPartnersAPI-latest.pdf]
If you are accepting Giftbit gifts in your checkout/point of sale, you can find the Giftbit Payment API documentation [http://resources.kiind.me/api/GiftbitPaymentAPI-latest.pdf]

## Where do I start?

In order to understand each step in the process, read through the above mentioned Kiind OAuth documentation.
Once you are familiarized with the concepts and technical underpinnings, ensure you have an account set up on Kiind's testbed platform (see below), and that you have an application registered with your account.

# Setup

## Acquiring Testbed Access

The sample app interacts with the Kiind Testbed servers. Having an account on testbed is necessary to make the app work.

You can request a testbed account [here](http://info.kiind.me/api).

## Install Grails

The sample app uses grails 2.3.11 or above (note you will also need Java JDK 1.7 or higher installed if you do not have one). You can easily install [Grails](https://grails.org/) through [GVM](http://gvmtool.net/).

Installing GVM is simple:

```
curl -s get.gvmtool.net | bash
```

Then reload your terminal:

```
source .bash_profile
```

Now you can very easily install grails using the gvm tool:

```
gvm install grails 2.3.11
```

## Running the app

After cloning this repository, navigate into the root folder and run ```grails run-app```

The first time you run it it may take a while to download all the dependencies, but subsequent startups should be very fast.  Assuming everything goes well, you'll see a bit of output ending with
```Server running. Browse to http://localhost:8080/KiindSampleOAuth```

Browse to the URL, replace the localhost with the IP address of your local machine (you can find your IP address using ifconfig command in the terminal; for my machine for example, the URL becomes:192.168.0.27:8080/KiindSampleOAuth/), and then follow the application instructions. 


**Note:** if you need to use a port other than 8080 to keep that port open for another local server, you may specify it as part of the run command  
```grails run-app -Dserver.port=<your port>```
