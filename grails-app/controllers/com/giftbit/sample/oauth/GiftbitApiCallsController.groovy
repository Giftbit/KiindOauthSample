package com.giftbit.sample.oauth

import grails.plugins.rest.client.RestBuilder
import groovy.json.JsonOutput

class GiftbitApiCallsController {

    static navigationScope = 'base'

    def configService
    def sessionStorageService

    def index() {
        ConfigBean configBean = configService.createConfigBeanFromConfig();
        SessionInfoStorageBean sessionInfoStorageBean = sessionStorageService.getSavedInfo(session)

        String endpoint = sessionInfoStorageBean.scope == "PAYMENT" ? configBean.giftbit_api_payment_endpoint : configBean.giftbit_api_gift_endpoint
        String accessToken = sessionInfoStorageBean?.user_token
        String requestBody = null
        String method = "GET"
        String acceptString = "application/json"
        String contentTypeString = "application/json"

        RestBuilder rest = new RestBuilder()
        def jsonResponse = rest.get(endpoint) {
            header('AUTHORIZATION', accessToken)
            accept(acceptString)
            contentType(contentTypeString)
        }

        String jsonOut = JsonOutput.prettyPrint(jsonResponse.json.toString())
        render(view: "index", model: [json: jsonOut, endpoint: endpoint, method:method, body: requestBody, header:'AUTHORIZATION: '+accessToken,accept:acceptString, contentType:contentTypeString, status:jsonResponse.status])
    }

    def getGiftcode(String giftcode) {
        ConfigBean configBean = configService.createConfigBeanFromConfig();
        SessionInfoStorageBean sessionInfoStorageBean = sessionStorageService.getSavedInfo(session)

        String endpoint = configBean.giftbit_api_payment_endpoint+"gift/"+(giftcode?:"")
        String accessToken = sessionInfoStorageBean?.user_token
        String requestBody = null
        String method = "GET"
        String acceptString = "application/json"
        String contentTypeString = "application/json"
        String pageform = "gift_display"

        RestBuilder rest = new RestBuilder()
        def jsonResponse = rest.get(endpoint) {
            header('AUTHORIZATION', accessToken)
            accept(acceptString)
            contentType(contentTypeString)
        }

        String jsonOut = JsonOutput.prettyPrint(jsonResponse.json.toString())
        render(view: "index", model: [pageform:pageform, giftcode:giftcode, json: jsonOut, endpoint: endpoint, method:method, body: requestBody, header:'AUTHORIZATION: '+accessToken,accept:acceptString, contentType:contentTypeString, status:jsonResponse.status])
    }

    def redeemGiftcode(String giftcode, Long amount_to_redeem_in_cents, Long transaction_id) {
        ConfigBean configBean = configService.createConfigBeanFromConfig();
        SessionInfoStorageBean sessionInfoStorageBean = sessionStorageService.getSavedInfo(session)
        transaction_id = transaction_id ?: Calendar.getInstance().getTimeInMillis()
        String endpoint = configBean.giftbit_api_payment_endpoint+"gift/"+(giftcode?:"")+"?amount_in_cents=${amount_to_redeem_in_cents}&transaction_id=${transaction_id}"
        String accessToken = sessionInfoStorageBean?.user_token
        String requestBody = null
        String method = "PUT"
        String acceptString = "application/json"
        String contentTypeString = "application/json"
        String pageform = "gift_redeem"



        RestBuilder rest = new RestBuilder()
        def jsonResponse = rest.put(endpoint) {
            header('AUTHORIZATION', accessToken)
            accept(acceptString)
            contentType(contentTypeString)
        }

        String jsonOut = JsonOutput.prettyPrint(jsonResponse.json.toString())
        render(view: "index", model: [pageform:pageform, transaction_id:transaction_id, amount_to_redeem_in_cents:amount_to_redeem_in_cents, giftcode:giftcode, json: jsonOut, endpoint: endpoint, method:method, body: requestBody, header:'AUTHORIZATION: '+accessToken,accept:acceptString, contentType:contentTypeString, status:jsonResponse.status])
    }


    def showCampaigns() {
        ConfigBean configBean = configService.createConfigBeanFromConfig();
        SessionInfoStorageBean sessionInfoStorageBean = sessionStorageService.getSavedInfo(session)

        String endpoint = configBean.giftbit_api_gift_endpoint+"/campaign"
        String accessToken = sessionInfoStorageBean?.user_token
        String requestBody = null
        String method = "GET"
        String acceptString = "application/json"
        String contentTypeString = "application/json"

        RestBuilder rest = new RestBuilder()
        def jsonResponse = rest.get(endpoint) {
            header('AUTHORIZATION', accessToken)
            accept(acceptString)
            contentType(contentTypeString)
        }

        String jsonOut = JsonOutput.prettyPrint(jsonResponse.json.toString())
        render(view: "index", model: [json: jsonOut, endpoint: endpoint, method:method, body: requestBody, header:'AUTHORIZATION: '+accessToken,accept:acceptString, contentType:contentTypeString, status:jsonResponse.status])
    }

    def showMarketplace() {
        ConfigBean configBean = configService.createConfigBeanFromConfig();
        SessionInfoStorageBean sessionInfoStorageBean = sessionStorageService.getSavedInfo(session)

        String endpoint = configBean.giftbit_api_gift_endpoint+"/marketplace"
        String accessToken = sessionInfoStorageBean?.user_token
        String requestBody = null
        String method = "GET"
        String acceptString = "application/json"
        String contentTypeString = "application/json"

        RestBuilder rest = new RestBuilder()
        def jsonResponse = rest.get(endpoint) {
            header('AUTHORIZATION', accessToken)
            accept(acceptString)
            contentType(contentTypeString)
        }

        String jsonOut = JsonOutput.prettyPrint(jsonResponse.json.toString())
        render(view: "index", model: [json: jsonOut, endpoint: endpoint, method:method, body: requestBody, header:'AUTHORIZATION: '+accessToken,accept:acceptString, contentType:contentTypeString, status:jsonResponse.status])
    }


    def refreshToken() {
        ConfigBean configBean = configService.createConfigBeanFromConfig();
        SessionInfoStorageBean sessionInfoStorageBean = sessionStorageService.getSavedInfo(session)

        String refresh_token = sessionInfoStorageBean?.user_refresh
        String endpoint = configBean.giftbit_api_token_endpoint
        String accessToken = sessionInfoStorageBean?.user_token
        String requestBody = "grant_type=${configBean?.grant_refresh}&client_id=${sessionInfoStorageBean?.app_clientid?:""}&client_secret=${sessionInfoStorageBean?.app_secret?:""}&refresh_token=${refresh_token?.encodeAsURL()?:""}"
        String method = "POST"
        String acceptString = "application/json"
        String contentTypeString = "application/x-www-form-urlencoded"

        RestBuilder rest = new RestBuilder()
        def jsonResponse = rest.post(endpoint) {
            accept(acceptString)
            contentType(contentTypeString)
            body(requestBody)
        }

        accessToken = jsonResponse.json.access_token ?: sessionInfoStorageBean?.user_token
        refresh_token = jsonResponse.json.refresh_token ?: sessionInfoStorageBean?.user_refresh

        sessionInfoStorageBean?.user_refresh = refresh_token
        sessionInfoStorageBean?.user_token = accessToken
        sessionStorageService.saveNewInfo(session, sessionInfoStorageBean)

        String jsonOut = JsonOutput.prettyPrint(jsonResponse.json.toString())
        render(view: "index", model: [json: jsonOut, endpoint: endpoint, method:method, body: requestBody, header:null,accept:acceptString, contentType:contentTypeString, status:jsonResponse.status])
    }

    def error(String error, String error_description) {
        return [error: error, error_description: error_description]
    }
}
