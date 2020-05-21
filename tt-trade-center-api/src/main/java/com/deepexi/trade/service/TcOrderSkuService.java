package com.deepexi.trade.service;

import com.deepexi.util.pageHelper.PageBean;
import com.deepexi.trade.domain.eo.TcOrderSku;
import com.deepexi.trade.domain.dto.TcOrderSkuDto;
import java.util.*;

public interface TcOrderSkuService {

    PageBean<TcOrderSku> findPage(TcOrderSkuDto eo, Integer page, Integer size);

    List<TcOrderSku> findAll(TcOrderSkuDto eo);

    TcOrderSku detail(String pk);

    Boolean update(String pk, TcOrderSkuDto eo);

    Boolean create(TcOrderSkuDto eo);

    Boolean delete(String... pk);
}