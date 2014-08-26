package com.kiind.sample.oauth

class KiindAppCredentialsController {

    def sessionStorageService

    def index() {
        SessionInfoStorageBean sessionInfoStorageBean = sessionStorageService.getSavedInfo(session)

        return [sessionInfoStorageBean: sessionInfoStorageBean, saved: params.saved]
    }

    def save(String app_clientid, String app_secret) {
        SessionInfoStorageBean sessionInfoStorageBean = new SessionInfoStorageBean(
                app_clientid: app_clientid,
                app_secret: app_secret,
        )

        sessionStorageService.saveNewInfo(session, sessionInfoStorageBean)

        redirect( action: "index", params: [saved:true])
    }
}
