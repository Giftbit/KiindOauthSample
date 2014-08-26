package com.sample.kiind.oauth

import com.kiind.sample.oauth.SessionInfoStorageBean
import grails.transaction.Transactional

import javax.servlet.http.HttpSession

class SessionStorageService {
    public static final SESSION_KEY_FOR_LOCAL_STORAGE = "KIINDSAMPLE_STORAGE"

    public SessionInfoStorageBean getSavedInfo(HttpSession session) {
        SessionInfoStorageBean sessionInfoStorageBean = (SessionInfoStorageBean)session.getAttribute(SESSION_KEY_FOR_LOCAL_STORAGE)
    }

    public void saveNewInfo(HttpSession session, SessionInfoStorageBean sessionInfoStorageBean) {
        session.setAttribute(SESSION_KEY_FOR_LOCAL_STORAGE, sessionInfoStorageBean)
    }

}
