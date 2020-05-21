package com.deepexi.trade.controller;

import com.deepexi.trade.domain.dto.OrderSkuWriteoffDto;
import com.deepexi.trade.service.OrderSkuWriteoffService;
import com.deepexi.trade.domain.eo.OrderSkuWriteoff;
import com.deepexi.util.config.Payload;
import com.deepexi.util.constant.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;

@Service
@Path("/api/v1/OrderSkuWriteoff")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class OrderSkuWriteoffController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderSkuWriteoffService OrderSkuWriteoffService;

    @GET
    @Path("/")
    public Payload findPage(@BeanParam OrderSkuWriteoffDto eo,
                            @QueryParam("page") @DefaultValue("1") Integer page,
                            @QueryParam("size") @DefaultValue("10") Integer size) {
        return new Payload(OrderSkuWriteoffService.findPage(eo, page, size));
    }

    @GET
    @Path("/list")
    public Payload findAll(@BeanParam OrderSkuWriteoffDto eo) {
        return new Payload(OrderSkuWriteoffService.findAll(eo));
    }

    @GET
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload detail(@PathParam("id") String pk) {
        return new Payload(OrderSkuWriteoffService.detail(pk));
    }

    @POST
    @Path("/")
    public Payload create(OrderSkuWriteoffDto eo) {
        return new Payload(OrderSkuWriteoffService.create(eo));
    }

    @PUT
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload update(@PathParam("id") String pk, OrderSkuWriteoffDto eo) {
        return new Payload(OrderSkuWriteoffService.update(pk, eo));
    }

    @DELETE
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload delete(@PathParam("id") String pk) {
        return new Payload(OrderSkuWriteoffService.delete(pk));
    }

    @DELETE
    @Path("/")
    public Payload delete(String[] pks) {
        return new Payload(OrderSkuWriteoffService.delete(pks));
    }
}
