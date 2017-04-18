package com.nestor.util;

import com.nestor.DAO.SessionsDAO;
import com.nestor.DAO.SessionsDAOImpl;

/**
 * Created by sbt-velichko-aa on 20.03.17.
 */
public class Factory {

    private static Factory instance = null;
    private static SessionsDAO sessionsDAO = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public SessionsDAO getSessionsDAO() {
        if (sessionsDAO == null) {
            sessionsDAO = new SessionsDAOImpl();
        }
        return sessionsDAO;
    }


}
