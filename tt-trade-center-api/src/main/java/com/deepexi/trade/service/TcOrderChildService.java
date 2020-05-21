package com.deepexi.trade.service;

import com.deepexi.trade.domain.vo.TcOrderChildVO;
import com.deepexi.util.pageHelper.PageBean;
import com.deepexi.trade.domain.eo.TcOrderChild;
import com.deepexi.trade.domain.dto.TcOrderChildDto;
import java.util.*;

public interface TcOrderChildService {

    PageBean<TcOrderChildVO> findPage(TcOrderChildDto eo, Integer page, Integer size);

    List<TcOrderChildVO> findAll(TcOrderChildDto eo);

    TcOrderChild detail(String pk);

    Boolean update(String pk, TcOrderChildDto eo);

    Boolean create(TcOrderChildDto eo);

    Boolean delete(String... pk);
}