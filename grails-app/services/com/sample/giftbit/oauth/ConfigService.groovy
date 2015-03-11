package com.sample.giftbit.oauth

import com.giftbit.sample.oauth.ConfigBean
import grails.transaction.Transactional

@Transactional
class ConfigService {

    def grailsApplication
    def grailsLinkGenerator;

    public ConfigBean createConfigBeanFromConfig() {
        ConfigBean configBean = new ConfigBean(
                scopes: grailsApplication.config.kiind.oauth.scopes,
                grant_type: grailsApplication.config.kiind.oauth.granttype.threelegged,
                grant_refresh: grailsApplication.config.kiind.oauth.granttype.refresh,
                redirect_url: grailsLinkGenerator.link(absolute: true, controller: grailsApplication.config.sampleapp.redirectcallback),
                giftbit_web_userlogin_endpoint: grailsApplication.config.kiind.webEndpointBase+'/'+grailsApplication.config.kiind.oauthWebLoginEndpoint,
                giftbit_api_token_endpoint: grailsApplication.config.kiind.apiEndpointBase+'/'+grailsApplication.config.kiind.apiTokenEndpoint,
                giftbit_api_payment_endpoint: grailsApplication.config.kiind.apiEndpointBase+'/payment/v2/',
                giftbit_api_gift_endpoint: grailsApplication.config.kiind.apiEndpointBase+'/papi/v1/',
                giftbit_api_responsetype: grailsApplication.config.kiind.oauth.responsetype
        )
    }
}
