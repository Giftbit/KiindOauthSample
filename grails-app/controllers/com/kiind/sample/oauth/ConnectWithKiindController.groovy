package com.kiind.sample.oauth

class ConnectWithKiindController {

    def configService
    def sessionStorageService

    def index() {

        String state = "hashedUserState"

        return [state: state]
    }

    def connect(String state) {

        ConfigBean configBean = configService.createConfigBeanFromConfig()
        SessionInfoStorageBean sessionInfo = sessionStorageService.getSavedInfo(session)

        Map connectionParams = [
                client_id    : sessionInfo.app_clientid,
                response_type: "code",
                scope        : configBean.scope,
                redirect_uri : configBean.redirect_url,
                state        : state,
        ]
        String urlParams = connectionParams.collect { k,v -> return "${k.encodeAsURL()}=${v.encodeAsURL()}" }.join('&')

        String connectRedirectString = configBean.kiind_web_userlogin_endpoint + "?" + urlParams

        redirect(uri: connectRedirectString )

    }

}
