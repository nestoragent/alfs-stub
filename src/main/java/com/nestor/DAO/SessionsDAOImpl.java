package com.nestor.DAO;

import com.nestor.logic.Sessions;
import com.nestor.rest.AddService;
import com.nestor.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by sbt-velichko-aa on 17.03.17.
 */
public class SessionsDAOImpl implements SessionsDAO {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(AddService.class);

    @Override
    public void addSession(Sessions sessions) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(sessions);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.debug("Hibernate. Error into method addSession. Message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateSession(Sessions sessions) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(sessions);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.debug("Hibernate. Error into method updateSession. Message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Sessions getSessionsById(int sessions_id) throws SQLException {
        Session session = null;
        Sessions sessions = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            sessions = (Sessions) session.load(Sessions.class, sessions_id);
        } catch (Exception e) {
            logger.debug("Hibernate. Error into method getSessionsById. Message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return sessions;
    }

    @Override
    public List getAllSessions() throws SQLException {
        Session session = null;
        List sessions = new ArrayList<Sessions>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            sessions = session.createCriteria(Sessions.class).list();
        } catch (Exception e) {
            logger.debug("Hibernate. Error into method getAllSessions. Message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return sessions;
    }

    @Override
    public void deleteSession(Sessions sessions) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(sessions);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.debug("Hibernate. Error into method deleteSession. Message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<Sessions> getSessionsByName(String name) throws SQLException {
        List<Sessions> deals = new ArrayList<>();
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "from Sessions where nodeName = :nodeName";
            Query query = session.createQuery(hql);
            query.setString("nodeName", name);
            deals = query.list();
        } catch (Exception e) {
            logger.debug("Hibernate. Error into method getSessionsByName. Message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return deals;
    }
}
