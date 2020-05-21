package com.deepexi.trade.service.third;

import com.deepexi.trade.service.third.domain.IdRuleEnum;

public interface GenerateIdService {


    String getStandardOrderId(String key, Long timeout, IdRuleEnum idRuleEnum);
}
