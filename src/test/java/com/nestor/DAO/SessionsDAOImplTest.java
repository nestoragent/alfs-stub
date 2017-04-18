package com.nestor.DAO;

import com.nestor.logic.Sessions;
import com.nestor.util.Factory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by sbt-velichko-aa on 18.04.2017.
 */
public class SessionsDAOImplTest {

    private static Sessions session;

    static {
        session = new Sessions();
        session.setPublicAddress("10.116.179.181")
                .setServerId("56f9c7ca-ea87-4e80-a06e-28609b13feff")
                .setNodeName("auto-slave-testplugin-8097")
                .setCreatedTime(1492420929431L)
                .setDeleteTime(1492423349474L);
    }


    @Before
    @Test
    public void addSession() throws Exception {
        Factory.getInstance().getSessionsDAO().addSession(session);
        Assert.assertNotEquals(0, session.getId());
    }

    @After
    public void after() throws Exception {
        Factory.getInstance().getSessionsDAO().deleteSession(session);
    }

    @Test
    public void updateSession() throws Exception {
        session.setPublicAddress("10.116.179.181_test")
                .setServerId("56f9c7ca-ea87-4e80-a06e-28609b13feff_test")
                .setNodeName("auto-slave-testplugin-8097_test")
                .setCreatedTime(1235466L)
                .setDeleteTime(1343483L);
        Factory.getInstance().getSessionsDAO().updateSession(session);
        Assert.assertEquals("10.116.179.181_test", session.getPublicAddress());
        Assert.assertEquals("56f9c7ca-ea87-4e80-a06e-28609b13feff_test", session.getServerId());
        Assert.assertEquals(1235466L, session.getCreatedTime());
        Assert.assertEquals(1343483L, session.getDeleteTime());
    }

    @Test
    public void getSessionsById() throws Exception {
        Sessions newSessions = Factory.getInstance().getSessionsDAO().getSessionsById(session.getId());
        Assert.assertNotNull(newSessions);
    }

    @Test
    public void getAllSessions() throws Exception {
        List<Sessions> sessions = Factory.getInstance().getSessionsDAO().getAllSessions();
        Assert.assertFalse(sessions.isEmpty());
    }

    @Test
    public void getSessionsByName() throws Exception {
        session.setNodeName("testName_getSessionsByName");
        Factory.getInstance().getSessionsDAO().updateSession(session);
        List<Sessions> newSessions = Factory.getInstance().getSessionsDAO().getSessionsByName(session.getNodeName());
        Assert.assertFalse(newSessions.isEmpty());
    }

}