package com.deepexi.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepexi.trade.domain.dto.TcOrderMainDto;
import com.deepexi.trade.domain.eo.TcOrderMain;
import com.deepexi.trade.domain.vo.TcOrderMainVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface TcOrderMainMapper extends BaseMapper<TcOrderMain> {

    List<TcOrderMainVO> findList(@Param("eo") TcOrderMainDto eo);

    int deleteByIds(@Param("pks") String... pks);

    int updateByOrderIds(@Param("eo") TcOrderMainDto eo);

    int batchInsert(@Param("eo") List<TcOrderMainDto> eo);

    int batchUpdate(@Param("eo") List<TcOrderMainDto> eo);
}
