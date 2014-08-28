package com.kiind.sample.oauth

import grails.plugins.rest.client.RestBuilder
import groovy.json.JsonOutput

class KiindApiCallsController {

    static navigationScope = 'base'

    def configService
    def sessionStorageService

    def index() {
        ConfigBean configBean = configService.createConfigBeanFromConfig();
        SessionInfoStorageBean sessionInfoStorageBean = sessionStorageService.getSavedInfo(session)

        String accessToken = sessionInfoStorageBean.user_token

        RestBuilder rest = new RestBuilder()
        def jsonResponse = rest.get(configBean.kiind_api_credentials_endpoint) {
            header('AUTHORIZATION', accessToken)
            accept("application/json")
            contentType("application/json")
        }
        println jsonResponse.properties

        if (jsonResponse.status != 200) {
            redirect(action: error, params: [error: jsonResponse.json?.error?.name, error_description: jsonResponse.json?.error?.message])
            return
        }

        String jsonOut = JsonOutput.prettyPrint(jsonResponse.json.toString())
        render(view: "index", model: [json: jsonOut])
    }


    def showCampaigns() {
        ConfigBean configBean = configService.createConfigBeanFromConfig();
        SessionInfoStorageBean sessionInfoStorageBean = sessionStorageService.getSavedInfo(session)

        String accessToken = sessionInfoStorageBean.user_token

        RestBuilder rest = new RestBuilder()
        def jsonResponse = rest.get(configBean.kiind_api_credentials_endpoint+"/campaign") {
            header('AUTHORIZATION', accessToken)
            accept("application/json")
            contentType("application/json")
        }
        println jsonResponse.properties

        if (jsonResponse.status != 200) {
            redirect(action: error, params: [error: jsonResponse.json?.error?.name, error_description: jsonResponse.json?.error?.message])
            return
        }

        String jsonOut = JsonOutput.prettyPrint(jsonResponse.json.toString())
        render(view: "index", model: [json: jsonOut])
    }

    def showMarketplace() {
        ConfigBean configBean = configService.createConfigBeanFromConfig();
        SessionInfoStorageBean sessionInfoStorageBean = sessionStorageService.getSavedInfo(session)

        String accessToken = sessionInfoStorageBean.user_token

        RestBuilder rest = new RestBuilder()
        def jsonResponse = rest.get(configBean.kiind_api_credentials_endpoint+"/marketplace") {
            header('AUTHORIZATION', accessToken)
            accept("application/json")
            contentType("application/json")
        }
        println jsonResponse.properties

        if (jsonResponse.status != 200) {
            redirect(action: error, params: [error: jsonResponse.json?.error?.name, error_description: jsonResponse.json?.error?.message])
            return
        }

        String jsonOut = JsonOutput.prettyPrint(jsonResponse.json.toString())
        render(view: "index", model: [json: jsonOut])
    }


    def refreshToken() {
        ConfigBean configBean = configService.createConfigBeanFromConfig();
        SessionInfoStorageBean sessionInfoStorageBean = sessionStorageService.getSavedInfo(session)

        String refresh_token = sessionInfoStorageBean.user_refresh

        String requestBody = "grant_type=${configBean.grant_refresh}&client_id=${sessionInfoStorageBean.app_clientid}&client_secret=${sessionInfoStorageBean.app_secret}&refresh_token=${refresh_token.encodeAsURL()}"

        RestBuilder rest = new RestBuilder()
        def jsonResponse = rest.post(configBean.kiind_api_token_endpoint) {
            accept("application/json")
            contentType("application/x-www-form-urlencoded")
            body(requestBody)
        }

        if (jsonResponse.status != 200) {
            redirect(action: error, params: [error: jsonResponse.json?.error, error_description: jsonResponse.json?.error_description])
            return
        }
        String accessToken = jsonResponse.json.access_token
        refresh_token = jsonResponse.json.refresh_token

        sessionInfoStorageBean.user_refresh = refresh_token
        sessionInfoStorageBean.user_token = accessToken
        sessionStorageService.saveNewInfo(session, sessionInfoStorageBean)

        String jsonOut = JsonOutput.prettyPrint(jsonResponse.json.toString())
        render(view: "index", model: [json: jsonOut])
    }

    def error(String error, String error_description) {
        return [error: error, error_description: error_description]
    }
}
