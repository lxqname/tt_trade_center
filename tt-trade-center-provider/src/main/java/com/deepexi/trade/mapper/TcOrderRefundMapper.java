package com.deepexi.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepexi.trade.domain.dto.TcOrderRefundDto;
import com.deepexi.trade.domain.eo.TcOrderRefund;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface TcOrderRefundMapper extends BaseMapper<TcOrderRefund> {

    List<TcOrderRefund> findList(@Param("eo") TcOrderRefundDto eo);

    int deleteByIds(@Param("pks") String... pks);

    int batchInsert(@Param("eo") List<TcOrderRefundDto> eo);

    int batchUpdate(@Param("eo") List<TcOrderRefundDto> eo);
}
