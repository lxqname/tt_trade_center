package com.deepexi.trade.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.deepexi.trade.service.TcOrderSkuService;
import com.deepexi.trade.domain.eo.TcOrderSku;
import com.deepexi.trade.domain.dto.TcOrderSkuDto;
import com.deepexi.trade.extension.AppRuntimeEnv;
import com.deepexi.trade.mapper.TcOrderSkuMapper;
import com.deepexi.util.pageHelper.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.deepexi.util.BeanPowerHelper;
import java.util.List;


@Component
@Service(version = "${demo.service.version}")
public class TcOrderSkuServiceImpl implements TcOrderSkuService {

    private static final Logger logger = LoggerFactory.getLogger(TcOrderSkuServiceImpl.class);

    @Autowired
    private TcOrderSkuMapper tcOrderSkuMapper;

    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

    @Override
    public PageBean findPage(TcOrderSkuDto eo, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<TcOrderSku> list = tcOrderSkuMapper.findList(eo);
        return new PageBean<>(list);
    }

    @Override
    public List<TcOrderSku> findAll(TcOrderSkuDto eo) {
        List<TcOrderSku> list = tcOrderSkuMapper.findList(eo);
        return list;
    }
    @Override
    public TcOrderSku detail(String pk) {
        return tcOrderSkuMapper.selectById(pk);
    }

    @Override
    public Boolean create(TcOrderSkuDto eo) {
        int result = tcOrderSkuMapper.insert(BeanPowerHelper.mapPartOverrider(eo,TcOrderSku.class));
        return result > 0;
    }

    @Override
    public Boolean update(String pk,TcOrderSkuDto eo) {
        eo.setId(pk);
        int result = tcOrderSkuMapper.updateById(BeanPowerHelper.mapPartOverrider(eo,TcOrderSku.class));
        return result > 0;
    }

    @Override
    public Boolean delete(String...pk) {
        int result = tcOrderSkuMapper.deleteByIds(pk);
        return result > 0;
    }

}