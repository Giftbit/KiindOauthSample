package com.sample.kiind.oauth

import com.kiind.sample.oauth.ConfigBean
import grails.transaction.Transactional

@Transactional
class ConfigService {

    def grailsApplication
    def grailsLinkGenerator;

    public ConfigBean createConfigBeanFromConfig() {
        ConfigBean configBean = new ConfigBean(
                scope: grailsApplication.config.kiind.oauth.scope,
                grant_type: grailsApplication.config.kiind.oauth.granttype.threelegged,
                redirect_url: grailsLinkGenerator.link(absolute: true, controller: grailsApplication.config.sampleapp.redirectcallback),
                kiind_web_userlogin_endpoint: grailsApplication.config.kiind.webEndpointBase+'/'+grailsApplication.config.kiind.oauthWebLoginEndpoint,
                kiind_api_token_endpoint: grailsApplication.config.kiind.apiEndpointBase+'/'+grailsApplication.config.kiind.apiTokenEndpoint,
                kiind_api_credentials_endpoint: grailsApplication.config.kiind.apiEndpointBase,
        )
    }
}
