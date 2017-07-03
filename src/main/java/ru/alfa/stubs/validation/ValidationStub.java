package ru.alfa.stubs.validation;


import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by sbt-velichko-aa on 16.03.17.
 */

@Path("/v1/order/validation")
public class ValidationStub {

    /**
     * Handler for get request
     *
     * @param pins
     * @param assetId
     * @param generalAgreementId
     * @param operation
     * @param amount
     * @param quantity
     * @return
     */
    @GET
    public Response handleGet(
            @DefaultValue("B81206") @QueryParam("pins") String pins,
            @DefaultValue("2237") @QueryParam("assetId") String assetId,
            @DefaultValue("null") @QueryParam("generalAgreementId") String generalAgreementId,
            @DefaultValue("-1") @QueryParam("operation") String operation,
            @DefaultValue("-1") @QueryParam("amount") String amount,
            @DefaultValue("-1") @QueryParam("quantity") String quantity) {

        return Response.status(200).entity("{\"status\":2,\"message\":\"Лимиты рассчитаны\"," +
                "\"tradeAccount\":\"30601840700009092110\",\"commissionAccount\":\"30601810400009092110\"," +
                "\"missingForTrade\":0.0000,\"missingForCommission\":0.0000,\"amount\":0.00000000,\"quantity\":0," +
                "\"commission\":0.0000,\"generalAgreementId\":92110}").build();
    }

    /**
     * Handler for post request
     *
     * @param pins
     * @param assetId
     * @param generalAgreementId
     * @param operation
     * @param amount
     * @param quantity
     * @return
     */
    @POST
    public Response handlerPost(
            @DefaultValue("B81206") @QueryParam("pins") String pins,
            @DefaultValue("2237") @QueryParam("assetId") String assetId,
            @DefaultValue("null") @QueryParam("generalAgreementId") String generalAgreementId,
            @DefaultValue("-1") @QueryParam("operation") String operation,
            @DefaultValue("-1") @QueryParam("amount") String amount,
            @DefaultValue("-1") @QueryParam("quantity") String quantity) {

        return Response.status(200).entity("{\"status\":2,\"message\":\"Лимиты рассчитаны\"," +
                "\"tradeAccount\":\"30601840700009092110\",\"commissionAccount\":\"30601810400009092110\"," +
                "\"missingForTrade\":0.0000,\"missingForCommission\":0.0000,\"amount\":0.00000000,\"quantity\":0," +
                "\"commission\":0.0000,\"generalAgreementId\":92110}").build();
    }
}