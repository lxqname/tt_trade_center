package com.deepexi.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepexi.trade.domain.dto.TcOrderRefundWaterDto;
import com.deepexi.trade.domain.eo.TcOrderRefundWater;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface TcOrderRefundWaterMapper extends BaseMapper<TcOrderRefundWater> {

    List<TcOrderRefundWater> findList(@Param("eo") TcOrderRefundWaterDto eo);

    int deleteByIds(@Param("pks") String... pks);

    int batchInsert(@Param("eo") List<TcOrderRefundWaterDto> eo);

    int batchUpdate(@Param("eo") List<TcOrderRefundWaterDto> eo);
}
