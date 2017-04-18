package com.nestor.rest;

import com.nestor.logic.Sessions;
import com.nestor.util.Factory;
import org.junit.Assert;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by sbt-velichko-aa on 16.03.17.
 */
@Path("/add")
public class AddService {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(AddService.class);

    /**
     * Handler for get request
     * @param publicAddress
     * @param serverId
     * @param nodeName
     * @param createdTime
     * @param deleteTime
     * @return
     */
    @GET
    public Response addGet(
            @DefaultValue("empty") @QueryParam("publicAddress") String publicAddress,
            @DefaultValue("empty") @QueryParam("serverId") String serverId,
            @DefaultValue("empty") @QueryParam("nodeName") String nodeName,
            @DefaultValue("-1") @QueryParam("createdTime") long createdTime,
            @DefaultValue("-1") @QueryParam("deleteTime") long deleteTime) {

        String output = saveData(publicAddress, serverId, nodeName, createdTime, deleteTime);
        return Response.status(200).entity("Jersey say: " + output).build();
    }

    /**
     * Handler for post request
     * @param publicAddress
     * @param serverId
     * @param nodeName
     * @param createdTime
     * @param deleteTime
     * @return
     */
    @POST
    public Response addPost(
            @DefaultValue("empty") @QueryParam("publicAddress") String publicAddress,
            @DefaultValue("empty") @QueryParam("serverId") String serverId,
            @DefaultValue("empty") @QueryParam("nodeName") String nodeName,
            @DefaultValue("-1") @QueryParam("createdTime") long createdTime,
            @DefaultValue("-1") @QueryParam("deleteTime") long deleteTime) {

        String output = saveData(publicAddress, serverId, nodeName, createdTime, deleteTime);
        return Response.status(200).entity("Jersey say: " + output).build();
    }


    /**
     * Save used time into db
     * @param publicAddress
     * @param serverId
     * @param nodeName
     * @param createdTime
     * @param deleteTime
     * @return
     */
    private String saveData(String publicAddress, String serverId, String nodeName, long createdTime, long deleteTime) {
        String output;
        Sessions sessions = new Sessions();
        sessions.setPublicAddress(publicAddress)
                .setServerId(serverId)
                .setNodeName(nodeName)
                .setCreatedTime(createdTime)
                .setDeleteTime(deleteTime);
        try {
            Factory.getInstance().getSessionsDAO().addSession(sessions);
            output = "Added row: " + sessions.toString();
        } catch (SQLException e) {
            logger.debug("Error when try to add. Message: " + e.getMessage());
            output = "Error when try to add. Message: " + e.getMessage();
        }
        return output;
    }

    /**
     * Handler for DELETE request
     * @param nodeName
     * @return
     */
    @DELETE
    public Response deleteRow(@DefaultValue("empty") @QueryParam("nodeName") String nodeName){
        String output;
        try {
            List<Sessions> sessions = Factory.getInstance().getSessionsDAO().getSessionsByName(nodeName);
            Assert.assertFalse(sessions.isEmpty());
            Factory.getInstance().getSessionsDAO().deleteSession(sessions.get(0));
            output = "Deleted row: " + sessions.toString();
        } catch (SQLException e) {
            logger.debug("Error when try to add. Message: " + e.getMessage());
            output = "Error when try to add. Message: " + e.getMessage();
        } catch (AssertionError error) {
            logger.debug("Error didn't exist row with nodeName: " + nodeName + ". Message: " + error.getMessage());
            return null;
        }
        return Response.status(200).entity("Jersey say: " + output).build();
    }
}