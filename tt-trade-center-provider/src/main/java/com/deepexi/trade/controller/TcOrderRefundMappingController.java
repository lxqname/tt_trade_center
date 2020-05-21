package com.deepexi.trade.controller;

import com.deepexi.trade.service.TcOrderRefundMappingService;
import com.deepexi.trade.domain.dto.TcOrderRefundMappingDto;
import com.deepexi.util.config.Payload;
import com.deepexi.util.constant.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;

@Service
@Path("/api/v1/tcOrderRefundMappings")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class TcOrderRefundMappingController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TcOrderRefundMappingService tcOrderRefundMappingService;

    @GET
    @Path("/")
    public Payload findPage(@BeanParam TcOrderRefundMappingDto eo,
                            @QueryParam("page") @DefaultValue("1") Integer page,
                            @QueryParam("size") @DefaultValue("10") Integer size) {
        return new Payload(tcOrderRefundMappingService.findPage(eo, page, size));
    }

    @GET
    @Path("/list")
    public Payload findAll(@BeanParam TcOrderRefundMappingDto eo) {
        return new Payload(tcOrderRefundMappingService.findAll(eo));
    }

    @GET
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload detail(@PathParam("id") String pk) {
        return new Payload(tcOrderRefundMappingService.detail(pk));
    }

    @POST
    @Path("/")
    public Payload create(TcOrderRefundMappingDto eo) {
        return new Payload(tcOrderRefundMappingService.create(eo));
    }

    @PUT
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload update(@PathParam("id") String pk, TcOrderRefundMappingDto eo) {
        return new Payload(tcOrderRefundMappingService.update(pk, eo));
    }

    @DELETE
    @Path("/{id:[a-zA-Z0-9,]+}")
    public Payload delete(@PathParam("id") String pk) {
        return new Payload(tcOrderRefundMappingService.delete(pk.split(",")));
    }

    @DELETE
    @Path("/")
    public Payload delete(String[] pks) {
        return new Payload(tcOrderRefundMappingService.delete(pks));
    }
}
