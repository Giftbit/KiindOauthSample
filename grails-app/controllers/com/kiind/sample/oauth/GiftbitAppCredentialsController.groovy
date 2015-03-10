package com.kiind.sample.oauth

class GiftbitAppCredentialsController {

    static navigationScope = 'base'

    def configService;
    def sessionStorageService;

    def index() {
        ConfigBean configBean = configService.createConfigBeanFromConfig();
        SessionInfoStorageBean sessionInfoStorageBean = sessionStorageService.getSavedInfo(session)


        return [sessionInfoStorageBean: sessionInfoStorageBean, configBean:configBean, saved: params.saved]
    }

    def save(String app_clientid, String app_secret, String scope) {
        SessionInfoStorageBean sessionInfoStorageBean = new SessionInfoStorageBean(
                app_clientid: app_clientid,
                app_secret: app_secret,
                scope: scope,
        )

        sessionStorageService.saveNewInfo(session, sessionInfoStorageBean)

        redirect( action: "index", params: [saved:true])
    }
}
