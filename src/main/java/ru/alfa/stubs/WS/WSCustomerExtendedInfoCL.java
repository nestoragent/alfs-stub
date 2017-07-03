package ru.alfa.stubs.WS;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by sbt-velichko-aa on 16.03.17.
 */
@Slf4j
@Path("/vdaton")
public class WSCustomerExtendedInfoCL {


    /**
     * Handler for get request
     *
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

        return Response.status(200).entity("Jersey say: ").build();
    }

    /**
     * Handler for post request
     *
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

        return Response.status(200).entity("Jersey say: ").build();
    }
}