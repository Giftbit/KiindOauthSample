package com.kiind.sample.oauth

import grails.plugins.rest.client.RestBuilder


class KiindOauthCallbackController {
    def sessionStorageService;
    def configService;

    def index(String code, String state, String error, String error_description) {

        if (code) { //user login was successful
            ConfigBean configBean = configService.createConfigBeanFromConfig();
            SessionInfoStorageBean sessionInfoStorageBean = sessionStorageService.getSavedInfo(session)

            String requestBody = "grant_type=${configBean.grant_type}&code=${code}&client_id=${sessionInfoStorageBean.app_clientid}&client_secret=${sessionInfoStorageBean.app_secret}&redirect_uri=${configBean.redirect_url.encodeAsURL()}&scope=${configBean.scope}"

            // Get access_token from authorization code

            RestBuilder rest = new RestBuilder()
            def jsonResponse = rest.post(configBean.kiind_api_token_endpoint) {
                accept("application/json")
                contentType("application/x-www-form-urlencoded")
                body(requestBody)
            }

            if (jsonResponse.status != 200) {
                redirect(action: error, params: [error: jsonResponse.json.error.name, error_description: jsonResponse.json.error.message])
                return
            }
            String accessToken = jsonResponse.json.access_token
            String refresh_token = jsonResponse.json.refresh_token

            //use access token to do a real API call (credentials check)
            jsonResponse = rest.get(configBean.kiind_api_credentials_endpoint) {
                header('AUTHORIZATION', accessToken)
                accept("application/json")
                contentType("application/json")
            }
            println jsonResponse.properties

            if (jsonResponse.status != 200) {
                redirect(action: error, params: [error: jsonResponse.json.error.name, error_description: jsonResponse.json.error.message])
                return
            }
            String connectedUsername = jsonResponse.json.username

            return [code: code, connectedUsername: connectedUsername]
        } else {
            redirect(action: 'error', params: [error: error, error_description: error_description])

        }


    }

    def error(String error, String error_description) {
        return [error: error, error_description: error_description]
    }
}
