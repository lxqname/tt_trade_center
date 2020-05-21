package com.deepexi.trade.service.third.domain;/**
 * Created by chenshaowen on 2018/11/27.
 */

/**
 * program: deepexi-auth-center
 * <p>
 * description: 账号传输dto
 *
 * @author: shaowin
 * <p>
 * created on : 2018-11-27 17:57
 **/
/**
* AccountVo
* @Author: yunzi7758
* @Date: 2019/4/25 17:32
*/
public class AccountVo extends Account {

    /**
     * 第三方登录
     */
    private String nickname;

    private String avatar;

/**  //    //jwt生成的token  */
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
