package com.kiind.sample.oauth

import grails.plugins.rest.client.RestBuilder
import groovy.json.JsonOutput


class GiftbitOauthCallbackController {
    def sessionStorageService;
    def configService;

    static navigationScope = 'none'

    def index(String code, String state, String error, String error_description) {

        if (code) { //user login was successful
            ConfigBean configBean = configService.createConfigBeanFromConfig();
            SessionInfoStorageBean sessionInfoStorageBean = sessionStorageService.getSavedInfo(session)

            String refresh_token = sessionInfoStorageBean?.user_refresh
            String endpoint = configBean.kiind_api_token_endpoint
            String accessToken = sessionInfoStorageBean?.user_token
            String requestBody = "grant_type=${configBean?.grant_type}&code=${code}&client_id=${sessionInfoStorageBean?.app_clientid}&client_secret=${sessionInfoStorageBean?.app_secret}&redirect_uri=${configBean.redirect_url?.encodeAsURL()}&scope=${sessionInfoStorageBean.scope}"
            String method = "POST"
            String acceptString = "application/json"
            String contentTypeString = "application/x-www-form-urlencoded"

            RestBuilder rest = new RestBuilder()
            def jsonResponse = rest.post(endpoint) {
                accept(acceptString)
                contentType(contentTypeString)
                body(requestBody)
            }

            accessToken = jsonResponse?.json?.access_token ?: sessionInfoStorageBean?.user_token
            refresh_token = jsonResponse?.json?.refresh_token ?: sessionInfoStorageBean?.user_refresh

            sessionInfoStorageBean?.user_refresh = refresh_token
            sessionInfoStorageBean?.user_token = accessToken
            sessionStorageService.saveNewInfo(session, sessionInfoStorageBean)

            String jsonOut = JsonOutput.prettyPrint(jsonResponse.json.toString())
            return [code:code, json: jsonOut, endpoint: endpoint, method:method, body: requestBody, header:null,accept:acceptString, contentType:contentTypeString, status:jsonResponse.status]

        } else {
            redirect(action: 'error', params: [error: error, error_description: error_description])
        }
    }

    def error(String error, String error_description) {
        return [error: error, error_description: error_description]
    }
}
