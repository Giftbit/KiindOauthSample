OAuth-Example-Grails
====================

A sample application that demonstrates allowing your users to connect their Kiind accounts to your application via Kiind's OAuth 2.0 endpoints


## So what is it?

This sample app shows what you need to do to build your application into Kiind.
It and its code can be used as a working reference for each step that you will need to implement in your application to securely retrieve Kiind API and Refresh tokens for your users, and use them to make API calls to Kiind on their behalf.

The Kiind Api uses 3-legged authentication to allow your users to grant you permission to send gifts on their behalf.
The Kiind Api conforms to the Authorization Code Grant grant type found in the [Oauth 2.0 Authorization Framework](http://tools.ietf.org/html/rfc6749#section-4.1) specification.
Documentation specifically for the Kiind OAuth interface can be found [here](http://resources.kiind.me/api/KiindOauth-latest.pdf) .

You can find documentation for the Kiind gift API [here](http://resources.kiind.me/api/KiindPartnersAPI-latest.pdf)

## Where do I start?

In order to understand each step in the process, read through the above mentioned Kiind OAuth documentation.
Once you are familiarized with the concepts and technical underpinnings, ensure you have an account set up on Kiind's testbed platform, and that you have an application registered with your account.

# Setup

## Acquiring Testbed Access

The sample app interacts with the Kiind Testbed servers. Having an account on testbed is necessary to make the app work.

You can request a testbed account through the [Kiind Api page](https://www.kiind.me/api). Alternatively, you can email testbed@kiind.me to request testbed access.

## Install Grails

The sample app uses grails. You can easily install [Grails](https://grails.org/) through [GVM](http://gvmtool.net/).

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