package com.deepexi.trade.service.third.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.deepexi.trade.domain.eo.SuperEntity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 权益
 *
 * @author 蝈蝈
 */
@TableName("ac_equity")
public class Equity extends SuperEntity implements Serializable {

    /**
     * 创建方式（1-权益包、2-权益包+优惠券）
     */
    private Integer createType;

    /**
     * 申请权益类型（1-优惠券）
     */
    private Integer type;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动金额
     */
    private BigDecimal amount;

    /**
     * 占用金额
     */
    private BigDecimal frozenAmount;

    /**
     * 活动素材/资料名称
     */
    private String fileName;

    /**
     * 活动素材/资料URL
     */
    private String fileUrl;

    /**
     * 备注说明
     */
    private String remark;

    /**
     * 商户ID
     */
    private String merchantId;

    /**
     * 审核状态（0-待审核、1-已通过、2-未通过）
     */
    private Integer auditStatus;

    /**
     * 审核说明
     */
    private String auditRemark;

    public Integer getCreateType() {
        return createType;
    }

    public void setCreateType(Integer createType) {
        this.createType = createType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(BigDecimal frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }
}

