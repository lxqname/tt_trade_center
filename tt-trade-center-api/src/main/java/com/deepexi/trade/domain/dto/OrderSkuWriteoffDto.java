package com.deepexi.trade.domain.dto;


import java.util.*;
import javax.ws.rs.*;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.ws.rs.QueryParam;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;


/**
 * @desc tc_order_sku_writeoff
 * @author yunzi7758
 */
//@ApiModel(description = "hsp_datasource")
//@TableName("tc_order_sku_writeoff")
public class OrderSkuWriteoffDto implements Serializable  {


        //@ApiModelProperty(value = "ID主键")
        @QueryParam("id")
        private String id;

        //@ApiModelProperty(value = "租户")
        @QueryParam("tenantCode")
        private String tenantCode;

        //@ApiModelProperty(value = "创建时间")
        @QueryParam("createdAt")
        private Date createdAt;

        //@ApiModelProperty(value = "创建人")
        @QueryParam("createdBy")
        private String createdBy;

        //@ApiModelProperty(value = "更新时间")
        @QueryParam("updatedAt")
        private Date updatedAt;

        //@ApiModelProperty(value = "更新人")
        @QueryParam("updatedBy")
        private String updatedBy;

        //@ApiModelProperty(value = "版本记录,修改时自增")
        @QueryParam("version")
        private Integer version;

        //@ApiModelProperty(value = "删除标志 1=已删除, 0=未删除")
        @QueryParam("dr")
        private Integer dr;

        //@ApiModelProperty(value = "子订单关联id")
        @QueryParam("orderChildId")
        private String orderChildId;

        //@ApiModelProperty(value = "商品关联id")
        @QueryParam("awardId")
        private String awardId;

        //@ApiModelProperty(value = "奖品项ID")
        @QueryParam("awardItemId")
        private String awardItemId;

        //@ApiModelProperty(value = "订单skuid")
        @QueryParam("orderSkuId")
        private String orderSkuId;

        //@ApiModelProperty(value = "订单ID")
        @QueryParam("orderId")
        private String orderId;

        //@ApiModelProperty(value = "状态 0 待核销 1 已核销,2guoqi")
        @QueryParam("status")
        private Integer status;

        //@ApiModelProperty(value = "核销ID")
        @QueryParam("memberAwardItemId")
        private String memberAwardItemId;

        private Integer awardNum;
        private String remark1;
        private String remark2;
        private String orderAwardId;


        //@ApiModelProperty(value = "")
//        @QueryParam("remark3")
        private String remark3;

        //@ApiModelProperty(value = "")
//        @QueryParam("remark4")
        private String remark4;





        public void setId(String id){
        this.id = id;
        }

        public String getId(){
        return this.id;
        }

        public void setTenantCode(String tenantCode){
        this.tenantCode = tenantCode;
        }

        public String getTenantCode(){
        return this.tenantCode;
        }

        public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;
        }

        public Date getCreatedAt(){
        return this.createdAt;
        }

        public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
        }

        public String getCreatedBy(){
        return this.createdBy;
        }

        public void setUpdatedAt(Date updatedAt){
        this.updatedAt = updatedAt;
        }

        public Date getUpdatedAt(){
        return this.updatedAt;
        }

        public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
        }

        public String getUpdatedBy(){
        return this.updatedBy;
        }

        public void setVersion(Integer version){
        this.version = version;
        }

        public Integer getVersion(){
        return this.version;
        }

        public void setDr(Integer dr){
        this.dr = dr;
        }

        public Integer getDr(){
        return this.dr;
        }

        public void setOrderChildId(String orderChildId){
        this.orderChildId = orderChildId;
        }

        public String getOrderChildId(){
        return this.orderChildId;
        }

        public void setAwardId(String awardId){
        this.awardId = awardId;
        }

        public String getAwardId(){
        return this.awardId;
        }

        public void setAwardItemId(String awardItemId){
        this.awardItemId = awardItemId;
        }

        public String getAwardItemId(){
        return this.awardItemId;
        }

        public void setOrderSkuId(String orderSkuId){
        this.orderSkuId = orderSkuId;
        }

        public String getOrderSkuId(){
        return this.orderSkuId;
        }

        public void setOrderId(String orderId){
        this.orderId = orderId;
        }

        public String getOrderId(){
        return this.orderId;
        }

        public void setStatus(Integer status){
        this.status = status;
        }

        public Integer getStatus(){
        return this.status;
        }

        public void setMemberAwardItemId(String memberAwardItemId){
        this.memberAwardItemId = memberAwardItemId;
        }

        public String getMemberAwardItemId(){
        return this.memberAwardItemId;
        }


        public Integer getAwardNum() {
                return awardNum;
        }

        public void setAwardNum(Integer awardNum) {
                this.awardNum = awardNum;
        }

        public String getRemark1() {
                return remark1;
        }

        public void setRemark1(String remark1) {
                this.remark1 = remark1;
        }

        public String getRemark2() {
                return remark2;
        }

        public void setRemark2(String remark2) {
                this.remark2 = remark2;
        }

        public static List<String> toListSplit(String str){
                return Arrays.asList(str.split(","));
        }

        public String getOrderAwardId() {
                return orderAwardId;
        }

        public void setOrderAwardId(String orderAwardId) {
                this.orderAwardId = orderAwardId;
        }

        public String getRemark3() {
                return remark3;
        }

        public void setRemark3(String remark3) {
                this.remark3 = remark3;
        }

        public String getRemark4() {
                return remark4;
        }

        public void setRemark4(String remark4) {
                this.remark4 = remark4;
        }
}

