package com.deepexi.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepexi.trade.domain.dto.OrderSkuWriteoffDto;
import com.deepexi.trade.domain.eo.OrderSkuWriteoff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderSkuWriteoffMapper extends BaseMapper<OrderSkuWriteoff> {

    List<OrderSkuWriteoff> findList(@Param("eo") OrderSkuWriteoffDto eo);

    int deleteByIds(@Param("pks") String... pks);

    int batchInsert(@Param("eo") List<OrderSkuWriteoffDto> eo);

    int batchUpdate(@Param("eo") List<OrderSkuWriteoffDto> eo);
}
