package com.deepexi.trade.controller;

import com.deepexi.trade.service.TcOrderRefundWaterService;
import com.deepexi.trade.domain.dto.TcOrderRefundWaterDto;
import com.deepexi.util.config.Payload;
import com.deepexi.util.constant.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;

@Service
@Path("/api/v1/tcOrderRefundWaters")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class TcOrderRefundWaterController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TcOrderRefundWaterService tcOrderRefundWaterService;

    @GET
    @Path("/")
    public Payload findPage(@BeanParam TcOrderRefundWaterDto eo,
                            @QueryParam("page") @DefaultValue("1") Integer page,
                            @QueryParam("size") @DefaultValue("10") Integer size) {
        return new Payload(tcOrderRefundWaterService.findPage(eo, page, size));
    }

    @GET
    @Path("/list")
    public Payload findAll(@BeanParam TcOrderRefundWaterDto eo) {
        return new Payload(tcOrderRefundWaterService.findAll(eo));
    }

    @GET
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload detail(@PathParam("id") String pk) {
        return new Payload(tcOrderRefundWaterService.detail(pk));
    }

    @POST
    @Path("/")
    public Payload create(TcOrderRefundWaterDto eo) {
        return new Payload(tcOrderRefundWaterService.create(eo));
    }

    @PUT
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload update(@PathParam("id") String pk, TcOrderRefundWaterDto eo) {
        return new Payload(tcOrderRefundWaterService.update(pk, eo));
    }

    @DELETE
    @Path("/{id:[a-zA-Z0-9,]+}")
    public Payload delete(@PathParam("id") String pk) {
        return new Payload(tcOrderRefundWaterService.delete(pk.split(",")));
    }

    @DELETE
    @Path("/")
    public Payload delete(String[] pks) {
        return new Payload(tcOrderRefundWaterService.delete(pks));
    }
}
