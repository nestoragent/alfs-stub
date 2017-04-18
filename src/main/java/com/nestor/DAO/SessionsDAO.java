package com.nestor.DAO;

import com.nestor.logic.Sessions;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by sbt-velichko-aa on 17.03.17.
 */
public interface SessionsDAO {

    public void addSession(Sessions sessions) throws SQLException;
    public void updateSession(Sessions sessions) throws SQLException;
    public Sessions getSessionsById(int sessions_id) throws SQLException;
    public List getSessionsByName(String name) throws SQLException;
    public List<Sessions> getAllSessions() throws SQLException;
    public void deleteSession(Sessions sessions) throws SQLException;
}