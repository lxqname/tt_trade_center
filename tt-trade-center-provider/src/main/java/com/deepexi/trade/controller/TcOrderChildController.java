package com.deepexi.trade.controller;

import com.deepexi.trade.service.TcOrderChildService;
import com.deepexi.trade.domain.dto.TcOrderChildDto;
import com.deepexi.util.config.Payload;
import com.deepexi.util.constant.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;

@Service
@Path("/api/v1/tcOrderChilds")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class TcOrderChildController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TcOrderChildService tcOrderChildService;

    @GET
    @Path("/")
    public Payload findPage(@BeanParam TcOrderChildDto eo,
                            @QueryParam("page") @DefaultValue("1") Integer page,
                            @QueryParam("size") @DefaultValue("10") Integer size) {
        return new Payload(tcOrderChildService.findPage(eo, page, size));
    }

    @GET
    @Path("/list")
    public Payload findAll(@BeanParam TcOrderChildDto eo) {
        return new Payload(tcOrderChildService.findAll(eo));
    }

    @GET
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload detail(@PathParam("id") String pk) {
        return new Payload(tcOrderChildService.detail(pk));
    }

    @POST
    @Path("/")
    public Payload create(TcOrderChildDto eo) {
        return new Payload(tcOrderChildService.create(eo));
    }

    @PUT
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload update(@PathParam("id") String pk, TcOrderChildDto eo) {
        return new Payload(tcOrderChildService.update(pk, eo));
    }

    @DELETE
    @Path("/{id:[a-zA-Z0-9,]+}")
    public Payload delete(@PathParam("id") String pk) {
        return new Payload(tcOrderChildService.delete(pk.split(",")));
    }

    @DELETE
    @Path("/")
    public Payload delete(String[] pks) {
        return new Payload(tcOrderChildService.delete(pks));
    }
}
