package com.deepexi.trade.controller;

import com.deepexi.trade.domain.dto.TcOrderRefundDto;
import com.deepexi.trade.service.TcOrderRefundService;
import com.deepexi.util.config.Payload;
import com.deepexi.util.constant.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;

@Service
@Path("/api/v1/tcOrderRefunds")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class TcOrderRefundController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TcOrderRefundService tcOrderRefundService;

    @GET
    @Path("/")
    public Payload findPage(@BeanParam TcOrderRefundDto eo,
                            @QueryParam("page") @DefaultValue("1") Integer page,
                            @QueryParam("size") @DefaultValue("10") Integer size) {
        return new Payload(tcOrderRefundService.findPage(eo, page, size));
    }

    @GET
    @Path("/list")
    public Payload findAll(@BeanParam TcOrderRefundDto eo) {
        return new Payload(tcOrderRefundService.findAll(eo));
    }

    @GET
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload detail(@PathParam("id") String pk) {
        return new Payload(tcOrderRefundService.detail(pk));
    }

    @POST
    @Path("/")
    public Payload create(TcOrderRefundDto eo) {
        return new Payload(tcOrderRefundService.create(eo));
    }

    @PUT
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload update(@PathParam("id") String pk, TcOrderRefundDto eo) {
        return new Payload(tcOrderRefundService.update(pk, eo));
    }

    @DELETE
    @Path("/{id:[a-zA-Z0-9,]+}")
    public Payload delete(@PathParam("id") String pk) {
        return new Payload(tcOrderRefundService.delete(pk.split(",")));
    }

    @DELETE
    @Path("/")
    public Payload delete(String[] pks) {
        return new Payload(tcOrderRefundService.delete(pks));
    }

    /**
     * 退款商品
     * @param dto
     * @return
     */
    @POST
    @Path("/orderRefund")
    public Payload orderRefund(@Valid @NotNull TcOrderRefundDto dto) {
        return new Payload(tcOrderRefundService.orderRefund(dto));
    }

    /**
     * 获取退款信息
     * @param orderId
     * @return
     */
    @GET
    @Path("/getRefundInfo/{orderId:[a-zA-Z0-9]+}")
    public Payload getRefundInfo(@PathParam("orderId") String orderId) {
        return tcOrderRefundService.getRefundInfo(orderId);
    }

}
