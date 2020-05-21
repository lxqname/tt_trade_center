package com.deepexi.trade.service.third.domain;

/**
 * @description 业务类型规则编号枚举
 * @Author: lc_xin.
 * @Date: 2019/4/24 10:25
 */
public enum IdRuleEnum {

	//内部使用的普通订单号 00
	COMMON_RANDOM("00", "", "内部使用的普通订单号、随机唯一号"),

	//主订单号
	MAIN_RANDOM("01", "", "主订单"),

	//子订单号
	CHILD_RANDOM("02", "", "子订单"),

	//支付订单号
	PAY_RANDOM("03", "", "支付"),

	//退款订单号
	REUND_RANDOM("04", "", "退款"),

	;


	private IdRuleEnum(String code, String flag, String description) {
		this.code = code;
		this.flag = flag;
		this.description = description;
	}

	/**
	 * seqences id
	 */
	private String code;
	
	/**
	 * 起始标志
	 */
	private String flag;
	
	/**
	 * 描述
	 */
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static IdRuleEnum getEnumByCode(String code){
		for(IdRuleEnum e:values()){
			if(e.getCode().equals(code))
				return e;
		}
		return null;
	}

}
