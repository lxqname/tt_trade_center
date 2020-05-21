package com.deepexi.trade.service.third.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.deepexi.member.api.WechatMemberInfoService;
import com.deepexi.member.domain.dto.WechatMemberInfoDto;
import com.deepexi.member.domain.eo.WechatMemberInfo;
import com.deepexi.member.domain.vo.WechatMemberInfoVO;
import com.deepexi.trade.service.third.WmWechatMemberInfoService;
import com.deepexi.trade.service.third.domain.WmWechatMemberInfo;
import com.deepexi.trade.service.third.domain.WmWechatMemberInfoVO;
import com.deepexi.util.extension.ApplicationException;
import com.deepexi.wechat.third.service.domain.WmWechatMemberInfoDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author yunzi7758
 */
@Component
/**
* WmWechatMemberInfoServiceImpl
* @Author: yunzi7758
* @Date: 2019/4/25 17:32
*/
public class WmWechatMemberInfoServiceImpl implements WmWechatMemberInfoService {

    @Reference(version = "${service.version}", check = false)
    private WechatMemberInfoService wmWechatMemberInfoService;

//    @Override
    public Boolean create(WmWechatMemberInfoDto eo) {

        WechatMemberInfoDto wechatMemberInfoDto = new WechatMemberInfoDto();

        BeanUtils.copyProperties(eo,wechatMemberInfoDto);

        try {
            return wmWechatMemberInfoService.create(wechatMemberInfoDto);
        } catch (Exception e) {
            throw new ApplicationException("rpc异常："+e.getMessage() );
        }
    }

    @Override
    public WmWechatMemberInfo detail(String pk) {
        return null;
    }

    @Override
    public Boolean delete(String... pk) {
        return wmWechatMemberInfoService.delete(pk);
    }

    @Override
    public WmWechatMemberInfo getByUnionIdAndWechatId(String unionId, String wechatId) {
        WechatMemberInfo byUnionIdAndWechatId = null;
        try {
            byUnionIdAndWechatId = wmWechatMemberInfoService.getByUnionIdAndWechatId(unionId, wechatId);
        } catch (Exception e) {
            throw new ApplicationException("rpc异常："+e.getMessage() );
        }
        if (byUnionIdAndWechatId == null){
            return null;
        }
        WmWechatMemberInfo wmWechatMemberInfo = new WmWechatMemberInfo();

        BeanUtils.copyProperties(byUnionIdAndWechatId,wmWechatMemberInfo);

        return wmWechatMemberInfo;
    }

    @Override
    public String getUnionIdByOpenId(String openId) {
        try {
            return wmWechatMemberInfoService.getUnionIdByOpenId(openId);
        } catch (Exception e) {
            throw new ApplicationException("rpc异常："+e.getMessage() );
        }
    }

    @Override
    public Boolean isPayByWechatNumberIds(List<String> weChatIds) {
        try {
            return wmWechatMemberInfoService.isPayByWechatNumberIds(weChatIds);
        } catch (Exception e) {
            throw new ApplicationException("rpc异常："+e.getMessage() );
        }
    }

    @Override
    public Boolean isPayByWechatNumberIds(List<String> weChatIds, String memberId) {
        try {
            return wmWechatMemberInfoService.isPayByWechatNumberIds(weChatIds,memberId);
        } catch (Exception e) {
            throw new ApplicationException("rpc异常："+e.getMessage() );
        }
    }

    @Override
    public Boolean updateSubscribeUbsubscribe(String openId, String wechatId) {
        try {
            return wmWechatMemberInfoService.updateSubscribeUbsubscribe(openId, wechatId);
        } catch (Exception e) {
            throw new ApplicationException("rpc异常："+e.getMessage() );
        }
    }

    @Override
    public WmWechatMemberInfo getByOpenIdAndWechatId(String openId, String wechatId) {
        WechatMemberInfo byOpenIdAndWechatId = null;
        try {
            byOpenIdAndWechatId = wmWechatMemberInfoService.getByOpenIdAndWechatId(openId, wechatId);
        } catch (Exception e) {
            throw new ApplicationException("rpc异常："+e.getMessage() );
        }
        if (byOpenIdAndWechatId == null){
            return null;
        }
        WmWechatMemberInfo wmWechatMemberInfo = new WmWechatMemberInfo();

        BeanUtils.copyProperties(byOpenIdAndWechatId,wmWechatMemberInfo);

        return wmWechatMemberInfo;
    }

    @Override
    public WmWechatMemberInfo detailByAppId(String appId) {
        WechatMemberInfo wechatMemberInfo = null;
        try {
            wechatMemberInfo = wmWechatMemberInfoService.detailByAppId(appId);
        } catch (Exception e) {
            throw new ApplicationException("rpc异常："+e.getMessage() );
        }
        if (wechatMemberInfo == null){
            return null;
        }
        WmWechatMemberInfo wmWechatMemberInfo = new WmWechatMemberInfo();

        BeanUtils.copyProperties(wechatMemberInfo,wmWechatMemberInfo);

        return wmWechatMemberInfo;
    }

    @Override
    public WmWechatMemberInfo getWechatNumberIdByAccount(String accountId) {
        WechatMemberInfo wechatNumberIdByAccount = null;
        try {
            wechatNumberIdByAccount = wmWechatMemberInfoService.getWechatNumberIdByAccount(accountId);
        } catch (Exception e) {
            throw new ApplicationException("rpc异常："+e.getMessage() );
        }
        if (wechatNumberIdByAccount == null){
            return null;
        }
        WmWechatMemberInfo wmWechatMemberInfo = new WmWechatMemberInfo();

        BeanUtils.copyProperties(wechatNumberIdByAccount,wmWechatMemberInfo);

        return wmWechatMemberInfo;
    }

    @Override
    public WmWechatMemberInfoVO getWechatMemberVoByAccount(String accountId) {
        return null;
    }

    @Override
    public WmWechatMemberInfo getWechatNumberIdBypass(String memberId) {
        WechatMemberInfo wechatNumberIdBypass = null;
        try {
            wechatNumberIdBypass = wmWechatMemberInfoService.getWechatNumberIdBypass(memberId);
        } catch (Exception e) {
            throw new ApplicationException("rpc异常："+e.getMessage() );
        }
        if (wechatNumberIdBypass == null){
            return null;
        }
        WmWechatMemberInfo wmWechatMemberInfo = new WmWechatMemberInfo();

        BeanUtils.copyProperties(wechatNumberIdBypass,wmWechatMemberInfo);

        return wmWechatMemberInfo;
    }

    @Override
    public WmWechatMemberInfo getWechatNumberIdBypass(String memberId, String weChatId) {
        WechatMemberInfo wechatNumberIdBypass = null;
        try {
            wechatNumberIdBypass = wmWechatMemberInfoService.getWechatNumberIdBypass(memberId, weChatId);
        } catch (Exception e) {
            throw new ApplicationException("rpc异常："+e.getMessage() );
        }

        if (wechatNumberIdBypass == null){
            return null;
        }
        WmWechatMemberInfo wmWechatMemberInfo = new WmWechatMemberInfo();

        BeanUtils.copyProperties(wechatNumberIdBypass,wmWechatMemberInfo);

        return wmWechatMemberInfo;
    }

    @Override
    public WmWechatMemberInfoVO getInfoVOWechatNumberIdBypass(String memberId) {

        WechatMemberInfoVO infoVOWechatNumberIdBypass = null;
        try {
            infoVOWechatNumberIdBypass = wmWechatMemberInfoService.getInfoVOWechatNumberIdBypass(memberId);
        } catch (Exception e) {
            throw new ApplicationException("rpc异常："+e.getMessage() );
        }

        if (infoVOWechatNumberIdBypass == null){
            return null;
        }

        WmWechatMemberInfoVO wmWechatMemberInfoVO = new WmWechatMemberInfoVO();
        wmWechatMemberInfoVO.setOpenId(infoVOWechatNumberIdBypass.getOpenId());
        wmWechatMemberInfoVO.setWechatNumberId(infoVOWechatNumberIdBypass.getWechatNumberId());
        return wmWechatMemberInfoVO;
    }

    @Override
    public Boolean isPayByWechatNumberIdsAndAccountId(List<String> weChatIds, String accountId) {
        try {
            return wmWechatMemberInfoService.isPayByWechatNumberIdsAndAccountId(weChatIds, accountId);
        } catch (Exception e) {
            throw new ApplicationException("rpc异常："+e.getMessage() );
        }
    }
}
