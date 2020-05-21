package com.deepexi.trade.service.third;

import com.deepexi.trade.service.third.domain.*;
import com.deepexi.util.pageHelper.PageBean;

import java.util.List;

public interface WmMemberService {

    /**
     * 获得会员详情
     * @param pk
     * @return
     */
    WmMember detailById(String pk);

    /**
     * 根据主键ID获取数据库EO数据
     *
     * @param pk 主键ID
     * @return WmMember
     */
    WmMember getEoById(String pk);

    /**
     * 会员修改
     * @param pk
     * @param eo
     * @return
     */
    Boolean update(String pk, WmMember eo);

    /**
     * 修改
     * @param eo
     * @return
     */
    Boolean update(WmMember eo);

    /**
     * 创建会员
     * @param eo
     * @return 会员ID
     */
    String create(WmMember eo);

    /**
     * 删除会员
     * @param pk
     * @return
     */
    Boolean delete(String pk);

    /**
     * 获得会员，通过unionId
     * @param unionId
     * @return
     */
    WmMember getMemberByUnionId(String unionId);

    /**
     * 获得会员，通过unionId  无需tenantId
     * @param unionId
     * @return
     */
    WmMember getMemberByUnionIdNoTenantId(String unionId);

    /**
     * 获得会员，通过AccountId
     * @param accountId
     * @return
     */
    WmMember getMemberByAccountId(String accountId);

    /**
     * 获得会员，通过mobile
     * @param mobile
     * @return
     */
    WmMember getMemberByMobile(String mobile);

    /**
     * 微信新用户替换原来用户，删除新用户
     * @param id
     * @return
     */
    Boolean deleteByWeChat(String id);

    /**
     * 获得当前登陆会员信息
     * @return
     */
    WmMember getLoginInfo();

    /**
     * 获得会员列表
     * @param eo
     * @param merchantId 商户ID
     * @param page
     * @param size
     * @return
     */
//    PageBean<WmMember> findListByMerchant(WmMemberDto eo, String merchantId, Integer page, Integer size);

    /**
     * 获得会员
     * @param accountName 会员账户名
     * @return
     */
    WmMember getMemberByAccountName(String accountName);

    /**
     * 获得会员是否邀请过他人
     * @param pk
     * @return
     */
    Boolean isInviterMember(String pk, String itemId);

    /**
     * 修改会员状态
     * @param id 会员ID
     * @param flag 启用/禁用
     * @return
     */
    Boolean updateState(String id, boolean flag);

    /**
     * 获得会员信息
     * @param memberId 会员ID
     * @return
     */
    WmMember getMemberById(String memberId);


    /**
     * 商户导入会员：创建账户与会员
     * @param eo
     * @return
     */
    boolean createAccountAndMember(WmMember eo);

}