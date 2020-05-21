package com.deepexi.trade.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.deepexi.trade.service.TcOrderRefundWaterService;
import com.deepexi.trade.domain.eo.TcOrderRefundWater;
import com.deepexi.trade.domain.dto.TcOrderRefundWaterDto;
import com.deepexi.trade.extension.AppRuntimeEnv;
import com.deepexi.trade.mapper.TcOrderRefundWaterMapper;
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
public class TcOrderRefundWaterServiceImpl implements TcOrderRefundWaterService {

    private static final Logger logger = LoggerFactory.getLogger(TcOrderRefundWaterServiceImpl.class);

    @Autowired
    private TcOrderRefundWaterMapper tcOrderRefundWaterMapper;

    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

    @Override
    public PageBean findPage(TcOrderRefundWaterDto eo, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<TcOrderRefundWater> list = tcOrderRefundWaterMapper.findList(eo);
        return new PageBean<>(list);
    }

    @Override
    public List<TcOrderRefundWater> findAll(TcOrderRefundWaterDto eo) {
        List<TcOrderRefundWater> list = tcOrderRefundWaterMapper.findList(eo);
        return list;
    }
    @Override
    public TcOrderRefundWater detail(String pk) {
        return tcOrderRefundWaterMapper.selectById(pk);
    }

    @Override
    public Boolean create(TcOrderRefundWaterDto eo) {
        int result = tcOrderRefundWaterMapper.insert(BeanPowerHelper.mapPartOverrider(eo,TcOrderRefundWater.class));
        return result > 0;
    }

    @Override
    public Boolean update(String pk,TcOrderRefundWaterDto eo) {
        eo.setId(pk);
        int result = tcOrderRefundWaterMapper.updateById(BeanPowerHelper.mapPartOverrider(eo,TcOrderRefundWater.class));
        return result > 0;
    }

    @Override
    public Boolean delete(String...pk) {
        int result = tcOrderRefundWaterMapper.deleteByIds(pk);
        return result > 0;
    }

}