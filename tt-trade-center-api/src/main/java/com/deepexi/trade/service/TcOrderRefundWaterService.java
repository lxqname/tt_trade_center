package com.deepexi.trade.service;

import com.deepexi.util.pageHelper.PageBean;
import com.deepexi.trade.domain.eo.TcOrderRefundWater;
import com.deepexi.trade.domain.dto.TcOrderRefundWaterDto;
import java.util.*;

public interface TcOrderRefundWaterService {

    PageBean<TcOrderRefundWater> findPage(TcOrderRefundWaterDto eo, Integer page, Integer size);

    List<TcOrderRefundWater> findAll(TcOrderRefundWaterDto eo);

    TcOrderRefundWater detail(String pk);

    Boolean update(String pk, TcOrderRefundWaterDto eo);

    Boolean create(TcOrderRefundWaterDto eo);

    Boolean delete(String... pk);
}