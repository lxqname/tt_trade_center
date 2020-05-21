package com.deepexi.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepexi.trade.domain.dto.TcOrderRefundMappingDto;
import com.deepexi.trade.domain.eo.TcOrderRefundMapping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface TcOrderRefundMappingMapper extends BaseMapper<TcOrderRefundMapping> {

    List<TcOrderRefundMapping> findList(@Param("eo") TcOrderRefundMappingDto eo);

    int deleteByIds(@Param("pks") String... pks);

    int batchInsert(@Param("eo") List<TcOrderRefundMappingDto> eo);

    int batchUpdate(@Param("eo") List<TcOrderRefundMappingDto> eo);
}
