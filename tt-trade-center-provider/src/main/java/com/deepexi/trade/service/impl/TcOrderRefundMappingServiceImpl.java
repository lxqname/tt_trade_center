package com.deepexi.trade.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.deepexi.trade.service.TcOrderRefundMappingService;
import com.deepexi.trade.domain.eo.TcOrderRefundMapping;
import com.deepexi.trade.domain.dto.TcOrderRefundMappingDto;
import com.deepexi.trade.extension.AppRuntimeEnv;
import com.deepexi.trade.mapper.TcOrderRefundMappingMapper;
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
public class TcOrderRefundMappingServiceImpl implements TcOrderRefundMappingService {

    private static final Logger logger = LoggerFactory.getLogger(TcOrderRefundMappingServiceImpl.class);

    @Autowired
    private TcOrderRefundMappingMapper tcOrderRefundMappingMapper;

    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

    @Override
    public PageBean findPage(TcOrderRefundMappingDto eo, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<TcOrderRefundMapping> list = tcOrderRefundMappingMapper.findList(eo);
        return new PageBean<>(list);
    }

    @Override
    public List<TcOrderRefundMapping> findAll(TcOrderRefundMappingDto eo) {
        List<TcOrderRefundMapping> list = tcOrderRefundMappingMapper.findList(eo);
        return list;
    }
    @Override
    public TcOrderRefundMapping detail(String pk) {
        return tcOrderRefundMappingMapper.selectById(pk);
    }

    @Override
    public Boolean create(TcOrderRefundMappingDto eo) {
        int result = tcOrderRefundMappingMapper.insert(BeanPowerHelper.mapPartOverrider(eo,TcOrderRefundMapping.class));
        return result > 0;
    }

    @Override
    public Boolean update(String pk,TcOrderRefundMappingDto eo) {
        eo.setId(pk);
        int result = tcOrderRefundMappingMapper.updateById(BeanPowerHelper.mapPartOverrider(eo,TcOrderRefundMapping.class));
        return result > 0;
    }

    @Override
    public Boolean delete(String...pk) {
        int result = tcOrderRefundMappingMapper.deleteByIds(pk);
        return result > 0;
    }

}