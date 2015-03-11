package com.sample.giftbit.oauth

import com.giftbit.sample.oauth.SessionInfoStorageBean

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
