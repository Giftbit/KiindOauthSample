package com.giftbit.sample.oauth

/**
 * Created by plocke on 2014-08-26.
 */
class ConfigBean {
    String grant_type, redirect_url, giftbit_web_userlogin_endpoint, giftbit_api_token_endpoint,
            giftbit_api_responsetype, grant_refresh, giftbit_api_payment_endpoint, giftbit_api_gift_endpoint;
    List<String> scopes
}
