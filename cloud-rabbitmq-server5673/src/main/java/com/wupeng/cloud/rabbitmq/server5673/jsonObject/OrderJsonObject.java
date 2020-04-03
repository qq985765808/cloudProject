package com.wupeng.cloud.rabbitmq.server5673.jsonObject;

import java.util.Date;

public class OrderJsonObject {

    private Long orderId;
    private Long userId;
    private Integer number;
    private Date createTime;
    private Short status;
    private String remarks;

    public OrderJsonObject(){
        super();
    }

    public OrderJsonObject(Long orderId, Long userId, Integer number, Date createTime, Short status, String remarks) {
        this.orderId = orderId;
        this.userId = userId;
        this.number = number;
        this.createTime = createTime;
        this.status = status;
        this.remarks = remarks;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "OrderJsonObject{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", number=" + number +
                ", createTime=" + createTime +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
