package com.deepexi.trade.service.third;/**
 * Created by chenshaowen on 2018/11/27.
 */



import com.deepexi.trade.service.third.domain.Account;
import com.deepexi.trade.service.third.domain.AccountDto;
import com.deepexi.trade.service.third.domain.AccountVo;

import java.util.List;
import java.util.Map;

/**
 * program: deepexi-auth-center
 * <p>
 * description: 账户服务
 *
 * @author: shaowin
 * <p>
 * created on : 2018-11-27 17:30
 **/

/**
* AccountService
* @Author: yunzi7758
* @Date: 2019/4/25 17:32
*/
public interface AccountService {

    /**
     * 用户名/手机号/邮箱+密码注册
     *
     * @param dto
     * @param tenantId
     * @return
     */
/**
* 查询
* @param dto
* @param tenantId
* @return
*/
    Account register(AccountDto dto, String tenantId);

    /**
     * 修改密码，邮箱，手机号（管理员操作）,状态
     *
     * @param account
     * @return
     */
/**
* 更新
* @param account
* @return
*/
    boolean updateUser(Account account);

    /**
     * 登录
     *
     * @param dto
     * @return
     */
/**
* 查询
* @param dto
* @param tenantId
* @return
*/
    AccountDto login(AccountDto dto, String tenantId);

    /**
     * 验证码登录
     *
     * @param dto
     * @return
     */
/**
* 查询
* @param dto
* @param tenantId
* @return
*/
    AccountVo codeLogin(AccountDto dto, String tenantId);

    /**
     * 快速登录
     *
     * @param dto
     * @return
     */
/**
* 查询
* @param dto
* @return
*/
    AccountVo fastLogin(AccountDto dto);

    /**
     * 第三方登录
     *
     * @param dto
     * @return
     */
/**
* 查询
* @param dto
* @return
*/
    AccountVo thirdLogin(AccountDto dto);

    /**
     * 根据token获取用户信息
     *
     * @param token
     * @return
     */
/**
* 查询
* @param token
* @return
*/
    Map queryUserByToken(String token);

    /**
     * 根据账户id获取账户信息
     */
/**
* 查询
* @param id
* @return
*/
    Account queryById(String id);

    /**
     * 根据用户id逻辑删除用户
     *
     * @param ids
     * @return
     */
/**
* 删除
* @param ids
* @return
*/
    void deleteUsers(List<String> ids);

    /**
     * 根据用户名和租户id获取租户信息
     *
     * @param username
     * @param tenantId
     * @return
     */
/**
* 查询
* @param username
* @param tenantId
* @return
*/
    Account selectByUsernameAndTenantId(String username, String tenantId);

    /**
     * 根据用户名和租户id获取租户信息
     *
     * @param email
     * @param tenantId
     * @return
     */
/**
* 查询
* @param email
* @param tenantId
* @return
*/
    Account selectByEmailAndTenantId(String email, String tenantId);

    /**
     * 根据用户名和租户id获取租户信息
     *
     * @param phone
     * @param tenantId
     * @return
     */
/**
* 查询
* @param phone
* @param tenantId
* @return
*/
    Account selectByPhoneAndTenantId(String phone, String tenantId);

    /**
     * 批量插入用户
     *
     * @param accountDto
     * @param tenantId
     * @return
     */
/**
* 查询
* @param accountDto
* @param tenantId
* @return
*/
    Map<String, List<Account>> registerBatch(List<AccountDto> accountDto, String tenantId);

    /**
     * 根据token获取token
     *
     * @param token
     * @param channel
     * @return
     */
/**
* 查询
* @param token
* @param channel
* @return
*/
    AccountDto getTokenByToken(String token, String channel);


    /**
     * 获得账户信息
     * @param token
     * @return
     */
/**
* 查询
* @param token
* @return
*/
    Account getAccountByToken(String token);

    /**
     * 获得账户信息
     * @param token
     * @return
     */
/**
* 查询
* @param token
* @return
*/
    String getLoginAccountIdByToken(String token);
}
