package com.deepexi.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepexi.trade.domain.dto.TcOrderPayDto;
import com.deepexi.trade.domain.eo.TcOrderPay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface TcOrderPayMapper extends BaseMapper<TcOrderPay> {

    List<TcOrderPay> findList(@Param("eo") TcOrderPayDto eo);

    int deleteByIds(@Param("pks") String... pks);

    int batchInsert(@Param("eo") List<TcOrderPayDto> eo);

    int batchUpdate(@Param("eo") List<TcOrderPayDto> eo);
}
