package com.deepexi.trade.service;

import com.deepexi.util.pageHelper.PageBean;
import com.deepexi.trade.domain.eo.TcOrderRefundMapping;
import com.deepexi.trade.domain.dto.TcOrderRefundMappingDto;
import java.util.*;

public interface TcOrderRefundMappingService {

    PageBean<TcOrderRefundMapping> findPage(TcOrderRefundMappingDto eo, Integer page, Integer size);

    List<TcOrderRefundMapping> findAll(TcOrderRefundMappingDto eo);

    TcOrderRefundMapping detail(String pk);

    Boolean update(String pk, TcOrderRefundMappingDto eo);

    Boolean create(TcOrderRefundMappingDto eo);

    Boolean delete(String... pk);
}