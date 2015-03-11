package com.giftbit.sample.oauth

class ConnectWithGiftbitController {

    static navigationScope = 'base'
    
    def configService
    def sessionStorageService

    def index() {

        String state = "optionalStateThatWillBeEchoedBack"

        return [state: state]
    }

    def connect(String state) {

        ConfigBean configBean = configService.createConfigBeanFromConfig()
        SessionInfoStorageBean sessionInfo = sessionStorageService.getSavedInfo(session)

        Map connectionParams = [
                client_id    : sessionInfo.app_clientid,
                response_type: "code",
                scope        : sessionInfo.scope,
                redirect_uri : configBean.redirect_url,
                state        : state,
        ]
        String urlParams = connectionParams.collect { k,v -> return "${k.encodeAsURL()}=${v.encodeAsURL()}" }.join('&')

        String connectRedirectString = configBean.giftbit_web_userlogin_endpoint + "?" + urlParams
        println(connectRedirectString)
        redirect(uri: connectRedirectString )

    }

}
