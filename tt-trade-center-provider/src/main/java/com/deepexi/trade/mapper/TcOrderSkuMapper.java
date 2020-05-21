package com.deepexi.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepexi.trade.domain.dto.TcOrderSkuDto;
import com.deepexi.trade.domain.eo.TcOrderSku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface TcOrderSkuMapper extends BaseMapper<TcOrderSku> {

    List<TcOrderSku> findList(@Param("eo") TcOrderSkuDto eo);

    int deleteByIds(@Param("pks") String... pks);

    int batchInsert(@Param("eo") List<TcOrderSkuDto> eo);

    int batchUpdate(@Param("eo") List<TcOrderSkuDto> eo);
}
