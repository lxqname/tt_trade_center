package com.deepexi.trade.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.deepexi.trade.domain.dto.OrderSkuWriteoffDto;
import com.deepexi.trade.service.OrderSkuWriteoffService;
import com.deepexi.trade.domain.eo.OrderSkuWriteoff;
import com.deepexi.trade.extension.AppRuntimeEnv;
import com.deepexi.trade.mapper.OrderSkuWriteoffMapper;
import com.deepexi.util.pageHelper.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
        import com.deepexi.util.*;


@Component
@Service(version = "$ {demo.service.version}")
public class OrderSkuWriteoffServiceImpl implements OrderSkuWriteoffService {

    private static final Logger logger = LoggerFactory.getLogger(OrderSkuWriteoffServiceImpl.class);

    @Autowired
    private OrderSkuWriteoffMapper OrderSkuWriteoffMapper;

    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

    @Override
    public PageBean findPage(OrderSkuWriteoffDto eo, Integer page, Integer size) {
        eo.setTenantCode(appRuntimeEnv.getTenantId());
        PageHelper.startPage(page, size);
        List<OrderSkuWriteoff> list = OrderSkuWriteoffMapper.findList(eo);
        return new PageBean<>(list);
    }

    @Override
    public List<OrderSkuWriteoff> findAll(OrderSkuWriteoffDto eo) {
        eo.setTenantCode(appRuntimeEnv.getTenantId());
        List<OrderSkuWriteoff> list = OrderSkuWriteoffMapper.findList(eo);
        return list;
    }
    @Override
    public OrderSkuWriteoff detail(String pk) {
        return OrderSkuWriteoffMapper.selectById(pk);
    }

    @Override
    public Boolean create(OrderSkuWriteoffDto eo) {
        //eo.setBaseFeild(eo.getCreatedBy(),appRuntimeEnv.getTenantId());

        OrderSkuWriteoff entity = new OrderSkuWriteoff();
        BeanUtil.copyProperties(eo, entity);
        int result = OrderSkuWriteoffMapper.insert(entity);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean update(String pk,OrderSkuWriteoffDto eo) {
        eo.setId(pk);
        int result = OrderSkuWriteoffMapper.updateById(BeanPowerHelper.mapPartOverrider(eo,OrderSkuWriteoff.class));
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(String...pk) {
        int result = OrderSkuWriteoffMapper.deleteByIds(pk);
        if (result > 0) {
            return true;
        }
        return false;
    }

}