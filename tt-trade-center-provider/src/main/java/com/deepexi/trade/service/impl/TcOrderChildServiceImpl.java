package com.deepexi.trade.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.deepexi.trade.domain.dto.TcOrderChildDto;
import com.deepexi.trade.domain.dto.TcOrderSkuDto;
import com.deepexi.trade.domain.eo.TcOrderChild;
import com.deepexi.trade.domain.vo.TcOrderChildVO;
import com.deepexi.trade.extension.AppRuntimeEnv;
import com.deepexi.trade.mapper.TcOrderChildMapper;
import com.deepexi.trade.service.TcOrderChildService;
import com.deepexi.trade.service.TcOrderSkuService;
import com.deepexi.util.BeanPowerHelper;
import com.deepexi.util.pageHelper.PageBean;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Service(version = "${demo.service.version}")
public class TcOrderChildServiceImpl implements TcOrderChildService {

    private static final Logger logger = LoggerFactory.getLogger(TcOrderChildServiceImpl.class);

    @Autowired
    private TcOrderChildMapper tcOrderChildMapper;

    @Autowired
    private TcOrderSkuService tcOrderSkuService;

    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

    @Override
    public PageBean findPage(TcOrderChildDto eo, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<TcOrderChildVO> list = findAll(eo);
        return new PageBean<>(list);
    }

    @Override
    public List<TcOrderChildVO> findAll(TcOrderChildDto eo) {
        List<TcOrderChildVO> list = tcOrderChildMapper.findList(eo);
        if ( null != list){
            list.forEach(order ->{
                TcOrderSkuDto tcOrderChildDto = new TcOrderSkuDto();
                tcOrderChildDto.setOrderChildId(order.getId());
                order.setTcOrderSkus(tcOrderSkuService.findAll(tcOrderChildDto));
            });
        }
        return list;
    }
    @Override
    public TcOrderChild detail(String pk) {
        return tcOrderChildMapper.selectById(pk);
    }

    @Override
    public Boolean create(TcOrderChildDto eo) {
        int result = tcOrderChildMapper.insert(BeanPowerHelper.mapPartOverrider(eo,TcOrderChild.class));
        return result > 0;
    }

    @Override
    public Boolean update(String pk,TcOrderChildDto eo) {
        eo.setId(pk);
        int result = tcOrderChildMapper.updateById(BeanPowerHelper.mapPartOverrider(eo,TcOrderChild.class));
        return result > 0;
    }

    @Override
    public Boolean delete(String...pk) {
        int result = tcOrderChildMapper.deleteByIds(pk);
        return result > 0;
    }

}