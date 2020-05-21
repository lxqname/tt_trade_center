package com.deepexi.trade.controller;

import com.deepexi.trade.domain.dto.TcOrderPayDto;
import com.deepexi.trade.domain.dto.TcOrderPlaceRequestDto;
import com.deepexi.trade.domain.eo.TcOrderPay;
import com.deepexi.trade.domain.vo.TcOrderMainVO;
import com.deepexi.trade.service.TcOrderMainService;
import com.deepexi.trade.domain.dto.TcOrderMainDto;
import com.deepexi.trade.service.third.domain.MemberCouponRelationDto;
import com.deepexi.util.config.Payload;
import com.deepexi.util.constant.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.Arrays;
import java.util.List;

@Service
@Path("/api/v1/tcOrderMains")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class TcOrderMainController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TcOrderMainService tcOrderMainService;

    @GET
    @Path("/")
    public Payload findPage(@BeanParam TcOrderMainDto eo,
                            @QueryParam("page") @DefaultValue("1") Integer page,
                            @QueryParam("size") @DefaultValue("10") Integer size) {
        return new Payload(tcOrderMainService.findPage(eo, page, size));
    }

    @GET
    @Path("/list")
    public Payload findAll(@BeanParam TcOrderMainDto eo) {
        return new Payload(tcOrderMainService.findAll(eo));
    }

    @GET
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload detail(@PathParam("id") String pk) {
        return new Payload(tcOrderMainService.detail(pk));
    }

    @POST
    @Path("/")
    public Payload create(TcOrderMainDto eo) {
        return new Payload(tcOrderMainService.create(eo));
    }

    @PUT
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload update(@PathParam("id") String pk, TcOrderMainDto eo) {
        return new Payload(tcOrderMainService.update(pk, eo));
    }

    @DELETE
    @Path("/{id:[a-zA-Z0-9,]+}")
    public Payload delete(@PathParam("id") String pk) {
        return new Payload(tcOrderMainService.delete(pk.split(",")));
    }

    @DELETE
    @Path("/")
    public Payload delete(String[] pks) {
        return new Payload(tcOrderMainService.delete(pks));
    }


    /**
     * 用户下单
     * @param dto
     * @return
     */
    @POST
    @Path("/orderPlace")
    public Payload orderPlace(@Valid @NotNull TcOrderPlaceRequestDto dto) {
        return new Payload(tcOrderMainService.orderPlace(dto));
    }

    /**
     * 用户支付
     * @param dto
     * @return
     */
    @POST
    @Path("/orderPay")
    public Payload orderPay(@Valid @NotNull TcOrderPayDto dto) {
        return new Payload(tcOrderMainService.orderPay(dto));
    }

    @PUT
    @Path("/orderClose/{id:[a-zA-Z0-9]+}")
    public Payload orderClose(@PathParam("id") String id) {
        TcOrderMainVO vo = new TcOrderMainVO();
        vo.setId(id);
        return new Payload(tcOrderMainService.closeOrderOperation(vo));
    }

    @GET
    @Path("/getOrderCount")
    public Payload getOrderCount(@BeanParam TcOrderMainDto eo) {
        return new Payload(tcOrderMainService.getOrderCount(eo));
    }

    @GET
    @Path("/getRefundParam/{id:[a-zA-Z0-9]+}")
    public Payload getRefundParam(@PathParam("id") String pk) {
        return new Payload(tcOrderMainService.getCanRefund(pk));
    }


    @GET
    @Path("/expireAwardItem")
    public Payload expireAwardItem(@BeanParam TcOrderMainDto eo) {
        List<String> strings = Arrays.asList(eo.getStatus().split(","));
        return new Payload(tcOrderMainService.expireAwardItem(strings));
    }


    @GET
    @Path("/getOrderCoupon")
    public Payload getOrderCoupon(@BeanParam MemberCouponRelationDto eo) {
        return new Payload(tcOrderMainService.getOrderCoupon(eo));
    }
}
