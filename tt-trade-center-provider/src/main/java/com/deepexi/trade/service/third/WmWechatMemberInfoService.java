package com.deepexi.trade.service.third;

import com.deepexi.trade.service.third.domain.*;
import com.deepexi.util.pageHelper.PageBean;

import java.util.List;

public interface WmWechatMemberInfoService {


    WmWechatMemberInfo detail(String pk);


    Boolean delete(String... pk);

    /**
     * 获得微信信息
     * @param unionId 微信unionId
     * @param wechatId wechatId唯一ID
     * @return
     */
    WmWechatMemberInfo getByUnionIdAndWechatId(String unionId, String wechatId);

    /**
     * 获得微信用户的unionId
     * @param openId openId
     * @return
     */
    String getUnionIdByOpenId(String openId);

    /**
     * 判断当前用户是否关注其中一个公众号
     * @param weChatIds 公众号唯一ID列表
     * @return
     */
    Boolean isPayByWechatNumberIds(List<String> weChatIds);

    /**
     * 判断用户是否关注其中一个公众号
     * @param weChatIds 公众号唯一ID列表
     * @param memberId 会员ID
     * @return
     */
    Boolean isPayByWechatNumberIds(List<String> weChatIds, String memberId);

    /**
     * 修改用户关注状态为取关
     * @param openId openid
     * @param wechatId 微信唯一ID
     * @return
     */
    Boolean updateSubscribeUbsubscribe(String openId, String wechatId);

    /**
     * 获得微信个人信息
     * @param openId
     * @param wechatId
     * @return
     */
    WmWechatMemberInfo getByOpenIdAndWechatId(String openId, String wechatId);

    /**
     * 获得微信个人信息
     * @param appId
     * @return
     */
    WmWechatMemberInfo detailByAppId(String appId);

    /**
     * 根据账户ID 获得关注公众号分流最前面的唯一ID
     * @param accountId 账户ID
     * @return 公众号唯一ID
     */
    WmWechatMemberInfo getWechatNumberIdByAccount(String accountId);

    /**
     * 根据账户ID 获得关注公众号分流最前面的唯一ID
     * @param accountId 账户ID
     * @return 公众号唯一ID
     */
    WmWechatMemberInfoVO getWechatMemberVoByAccount(String accountId);

    /**
     * 根据会员ID 获得关注公众号分流最前面的唯一ID
     * @param memberId 会员ID
     * @return 公众号唯一ID
     */
    WmWechatMemberInfo getWechatNumberIdBypass(String memberId);

    /**
     * 根据会员ID 获得关注公众号分流最前面的唯一ID
     * @param memberId 会员ID
     * @param weChatId 公众号唯一ID
     * @return 微信用户实体
     */
    WmWechatMemberInfo getWechatNumberIdBypass(String memberId, String weChatId);


    /**
     * 根据会员ID 获得关注公众号分流最前面的唯一ID
     * @param memberId 会员ID
     * @return 公众号唯一ID
     */
    WmWechatMemberInfoVO getInfoVOWechatNumberIdBypass(String memberId);

    /**
     * 判断用户是否关注其中一个公众号
     * @param weChatIds 公众号唯一ID列表
     * @param accountId 会员AccountID
     * @return
     */
    Boolean isPayByWechatNumberIdsAndAccountId(List<String> weChatIds, String accountId);

}