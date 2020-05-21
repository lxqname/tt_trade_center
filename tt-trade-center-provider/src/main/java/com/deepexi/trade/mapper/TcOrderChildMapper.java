package com.deepexi.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepexi.trade.domain.dto.TcOrderChildDto;
import com.deepexi.trade.domain.eo.TcOrderChild;
import com.deepexi.trade.domain.vo.TcOrderChildVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface TcOrderChildMapper extends BaseMapper<TcOrderChild> {

    List<TcOrderChildVO> findList(@Param("eo") TcOrderChildDto eo);

    int deleteByIds(@Param("pks") String... pks);

    int batchInsert(@Param("eo") List<TcOrderChildDto> eo);

    int batchUpdate(@Param("eo") List<TcOrderChildDto> eo);

    int updateByOrderId(@Param("tc") TcOrderChild tc);

}
