package com.deepexi.trade.controller;

import com.deepexi.trade.annotation.TenantId;
import com.deepexi.trade.annotation.Token;
import com.deepexi.trade.domain.dto.MakeSignDto;
import com.deepexi.trade.domain.dto.TcCallBackDto;
import com.deepexi.trade.domain.dto.TcOrderPayDto;
import com.deepexi.trade.domain.vo.pay.TcCallBackResponse;
import com.deepexi.trade.service.TcOrderPayService;
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
@Path("/api/v1/tcOrderPays")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class TcOrderPayController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TcOrderPayService tcOrderPayService;

    @GET
    @Path("/")
    public Payload findPage(@BeanParam TcOrderPayDto eo,
                            @QueryParam("page") @DefaultValue("1") Integer page,
                            @QueryParam("size") @DefaultValue("10") Integer size) {
        return new Payload(tcOrderPayService.findPage(eo, page, size));
    }

    @GET
    @Path("/list")
    public Payload findAll(@BeanParam TcOrderPayDto eo) {
        return new Payload(tcOrderPayService.findAll(eo));
    }

    @GET
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload detail(@PathParam("id") String pk) {
        return new Payload(tcOrderPayService.detail(pk));
    }

    @POST
    @Path("/")
    public Payload create(TcOrderPayDto eo) {
        return new Payload(tcOrderPayService.create(eo));
    }

    @PUT
    @Path("/{id:[a-zA-Z0-9]+}")
    public Payload update(@PathParam("id") String pk, TcOrderPayDto eo) {
        return new Payload(tcOrderPayService.update(pk, eo));
    }

    @DELETE
    @Path("/{id:[a-zA-Z0-9,]+}")
    public Payload delete(@PathParam("id") String pk) {
        return new Payload(tcOrderPayService.delete(pk.split(",")));
    }

    @DELETE
    @Path("/")
    public Payload delete(String[] pks) {
        return new Payload(tcOrderPayService.delete(pks));
    }

    /**
     *  支付成功回调的接口
     * @param callBackDto 请求实体类
     * @return
     */
    @POST
    @Path("/payCallback")
    @Token(require = false)
    @TenantId(require = false)
    public TcCallBackResponse payCallback(@Valid @NotNull TcCallBackDto callBackDto) {
        return tcOrderPayService.payCallback(callBackDto);
    }

    @POST
    @Path("/makeSign")
    public Payload makeSign(@Valid @NotNull MakeSignDto makeSignDto) {
        return new Payload(tcOrderPayService.makeSign(makeSignDto));
    }


}
