package com.deepexi.trade.service.third.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.deepexi.member.api.MemberService;
import com.deepexi.member.domain.eo.Member;
import com.deepexi.member.domain.vo.MemberDetailVO;
import com.deepexi.trade.service.third.WmMemberService;
import com.deepexi.trade.service.third.domain.WmMember;
import com.deepexi.util.extension.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WmMemberServiceImpl implements WmMemberService {

    @Reference(version = "${demo.service.version}",check = false )
    private MemberService memberService;
    @Override
    public WmMember detailById(String pk) {

        Member member = null;
        try {
            member = memberService.detailById(pk);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }

        if (member == null){
            throw new ApplicationException("获取不到会员信息:"+pk);
        }

        WmMember wmMember = new WmMember();
        wmMember.setAccountId(member.getAccountId());
        wmMember.setAccountName(member.getAccountName());
        wmMember.setId(member.getId());
        wmMember.setName(member.getName());
        wmMember.setNickName(member.getNickName());
        wmMember.setMobile(member.getMobile());
        wmMember.setHeadImg(member.getHeadImg());


        return wmMember;
    }

    @Override
    public WmMember getEoById(String pk) {
        return null;
    }

    @Override
    public Boolean update(String pk, WmMember eo) {
        return null;
    }

    @Override
    public Boolean update(WmMember eo) {
        return null;
    }

    @Override
    public String create(WmMember eo) {
        return null;
    }

    @Override
    public Boolean delete(String pk) {
        return null;
    }

    @Override
    public WmMember getMemberByUnionId(String unionId) {
        return null;
    }

    @Override
    public WmMember getMemberByUnionIdNoTenantId(String unionId) {
        return null;
    }

    @Override
    public WmMember getMemberByAccountId(String accountId) {
        return null;
    }

    @Override
    public WmMember getMemberByMobile(String mobile) {
        return null;
    }

    @Override
    public Boolean deleteByWeChat(String id) {
        return null;
    }

    @Override
    public WmMember getLoginInfo() {
        Member member = null;
        try {
            member = memberService.getLoginInfo();
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }

        if (member == null){
            throw new ApplicationException("获取不到会员信息:");
        }

        WmMember wmMember = new WmMember();
        wmMember.setAccountId(member.getAccountId());
        wmMember.setId(member.getId());
        wmMember.setName(member.getName());
        wmMember.setNickName(member.getNickName());
        wmMember.setMobile(member.getMobile());


        return wmMember;
    }

    @Override
    public WmMember getMemberByAccountName(String accountName) {
        return null;
    }

    @Override
    public Boolean isInviterMember(String pk, String itemId) {
        return null;
    }

    @Override
    public Boolean updateState(String id, boolean flag) {
        return null;
    }

    @Override
    public WmMember getMemberById(String memberId) {
        return null;
    }

    @Override
    public boolean createAccountAndMember(WmMember eo) {
        return false;
    }
}
