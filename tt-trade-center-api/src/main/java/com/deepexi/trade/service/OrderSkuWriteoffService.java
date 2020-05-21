package com.deepexi.trade.service;

import com.deepexi.trade.domain.dto.OrderSkuWriteoffDto;
import com.deepexi.util.pageHelper.PageBean;
import com.deepexi.trade.domain.eo.OrderSkuWriteoff;
import java.util.*;

public interface OrderSkuWriteoffService {

    PageBean<OrderSkuWriteoff> findPage(OrderSkuWriteoffDto eo, Integer page, Integer size);

    List<OrderSkuWriteoff> findAll(OrderSkuWriteoffDto eo);

    OrderSkuWriteoff detail(String pk);

    Boolean update(String pk, OrderSkuWriteoffDto eo);

    Boolean create(OrderSkuWriteoffDto eo);

    Boolean delete(String... pk);
}