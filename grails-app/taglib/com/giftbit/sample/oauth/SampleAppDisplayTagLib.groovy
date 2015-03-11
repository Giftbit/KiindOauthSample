package com.giftbit.sample.oauth

class SampleAppDisplayTagLib {
    static namespace = "kiind"

    def configService
    def sessionStorageService

    def displayConfig = { attrs, body ->
        ConfigBean configBean = configService.createConfigBeanFromConfig()

        out << render(template: "/common/config", model: [configBean: configBean] )
    }

    def displayCurrentCredentials = { attrs, body ->
        SessionInfoStorageBean sessionInfo = sessionStorageService.getSavedInfo(session)

        out << render(template: "/common/sessionInfo", model: [sessionInfo: sessionInfo] )
    }

}
