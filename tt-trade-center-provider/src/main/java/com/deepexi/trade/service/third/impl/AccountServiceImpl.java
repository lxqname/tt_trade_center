package com.deepexi.trade.service.third.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.deepexi.trade.service.third.AccountService;
import com.deepexi.trade.service.third.domain.*;
import com.deepexi.util.extension.ApplicationException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author yunzi7758
 */
@Component
/**
* AccountServiceImpl
* @Author: yunzi7758
* @Date: 2019/4/25 17:32
*/
public class AccountServiceImpl implements AccountService {

    @Reference(version = "${demo.service.version}",check = false /*,url = "dubbo://129.204.78.116:28101"*//*,url = "dubbo://203.195.178.170:28101"*/)
    private com.deepexi.user.service.AccountService accountService;

    @Override
    public Account register(AccountDto dto, String tenantId) {
        return null;
    }

    @Override
    public boolean updateUser(Account account) {
        return false;
    }

    @Override
    public AccountDto login(AccountDto dto, String tenantId) {
        return null;
    }

    @Override
    public AccountVo codeLogin(AccountDto dto, String tenantId) {
        return null;
    }

    @Override
    public AccountVo fastLogin(AccountDto dto) {
        return null;
    }

    @Override
    public AccountVo thirdLogin(AccountDto dto) {
        return null;
    }

    @Override
    public Map queryUserByToken(String token) {
        return null;
    }

    @Override
    public Account queryById(String id) {
        return null;
    }

    @Override
    public void deleteUsers(List<String> ids) {

    }

    @Override
    public Account selectByUsernameAndTenantId(String username, String tenantId) {
        return null;
    }

    @Override
    public Account selectByEmailAndTenantId(String email, String tenantId) {
        return null;
    }

    @Override
    public Account selectByPhoneAndTenantId(String phone, String tenantId) {
        return null;
    }

    @Override
    public Map<String, List<Account>> registerBatch(List<AccountDto> accountDto, String tenantId) {
        return null;
    }

    @Override
    public AccountDto getTokenByToken(String token, String channel) {
        return null;
    }

    @Override
    public Account getAccountByToken(String token) {

        com.deepexi.user.domain.eo.Account loginAccountByToken = null;
        try {
            loginAccountByToken = accountService.getLoginAccountByToken(token);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }

        if (loginAccountByToken == null){
            throw new ApplicationException("rpc异常：根据token:" +token+
                    "获取用户信息失败！");
        }

        Account account = new Account();

        BeanUtils.copyProperties(loginAccountByToken,account);
        return account;
    }

    @Override
    public String getLoginAccountIdByToken(String token) {

        String loginAccountIdByToken = null;
        try {
            loginAccountIdByToken = accountService.getLoginAccountIdByToken(token);
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage());
        }
        if (loginAccountIdByToken == null){
            throw new ApplicationException("rpc异常：根据token:" +token+
                    "获取用户信息失败！");
        }
        return loginAccountIdByToken;
    }
}
