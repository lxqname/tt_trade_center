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
* AccountDto
* @Author: yunzi7758
* @Date: 2019/4/25 17:32
*/
public class AccountDto extends Account {

    private String channel;

    /**
     * 第三方登录
     */
/**  //    //第三方平台用户id  */
    private String platformUserId;

/**  //    //第三方平台访问token  */
    private String accessToken;

/**  //    //平台类型，0:未知,1:wechat,2:qq,3:aliPay,4:weibo,5:facebook,6:google,7:twitter  */
    private String type;

    private String token;

    private String verifyCode;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getPlatformUserId() {
        return platformUserId;
    }

    public void setPlatformUserId(String platformUserId) {
        this.platformUserId = platformUserId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
