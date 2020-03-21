package com.wupeng.cloud.provider.payment8001.pojo;



import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "tab_order_info")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    /** 订单状态：0异常,1正常,2待支付,-1退单*/
    public  static  final String ORDERSTATUS_ERROR="0",ORDERSTATUS_SUCCESS="1",NOT_PAID="2",CHAEGEEBACK="-1";

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "order_name")
    private String orderName;
    @Column(name = "order_sys_num")
    private String orderSysNum;
    @Column(name = "order_num")
    private Integer orderNum;
    @Column(name = "order_price")
    private BigDecimal orderPrice;
    @Column(name = "order_total_money")
    private BigDecimal orderTotalMoney;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "order_time")
    private Date orderCreateTime;
    @Column(name = "order_status",length = 2)
    private String orderStatus;
    @Column(name = "order_remarks",length = 100)
    private String orderRemarks;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderSysNum() {
        return orderSysNum;
    }

    public void setOrderSysNum(String orderSysNum) {
        this.orderSysNum = orderSysNum;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getOrderTotalMoney() {
        return orderTotalMoney;
    }

    public void setOrderTotalMoney(BigDecimal orderTotalMoney) {
        this.orderTotalMoney = orderTotalMoney;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderRemarks() {
        return orderRemarks;
    }

    public void setOrderRemarks(String orderRemarks) {
        this.orderRemarks = orderRemarks;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                ", orderSysNum='" + orderSysNum + '\'' +
                ", orderPrice=" + orderPrice +
                ", orderTotalMoney=" + orderTotalMoney +
                ", userId=" + userId +
                ", orderCreateTime=" + orderCreateTime +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderRemarks='" + orderRemarks + '\'' +
                '}';
    }
}
