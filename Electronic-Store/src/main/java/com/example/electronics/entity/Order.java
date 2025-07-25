package com.example.electronics.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private String orderId;
    private String orderStatus;
    private String paymentStatus;
    private int orderAmount;

    @Column(length = 1000)
    private String billingAddress;

    private String billingPhone;
    private String billingName;
    private Date orderedDate;
    private Date deliveredDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    // Getters and setters

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBillingPhone() {
        return billingPhone;
    }

    public void setBillingPhone(String billingPhone) {
        this.billingPhone = billingPhone;
    }

    public String getBillingName() {
        return billingName;
    }

    public void setBillingName(String billingName) {
        this.billingName = billingName;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    // ✅ Manual Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String orderId;
        private String orderStatus;
        private String paymentStatus;
        private int orderAmount;
        private String billingAddress;
        private String billingPhone;
        private String billingName;
        private Date orderedDate;
        private Date deliveredDate;
        private User user;
        private List<OrderItem> orderItems = new ArrayList<>();

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder orderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Builder paymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Builder orderAmount(int orderAmount) {
            this.orderAmount = orderAmount;
            return this;
        }

        public Builder billingAddress(String billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        public Builder billingPhone(String billingPhone) {
            this.billingPhone = billingPhone;
            return this;
        }

        public Builder billingName(String billingName) {
            this.billingName = billingName;
            return this;
        }

        public Builder orderedDate(Date orderedDate) {
            this.orderedDate = orderedDate;
            return this;
        }

        public Builder deliveredDate(Date deliveredDate) {
            this.deliveredDate = deliveredDate;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder orderItems(List<OrderItem> orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public Order build() {
            Order order = new Order();
            order.setOrderId(this.orderId);
            order.setOrderStatus(this.orderStatus);
            order.setPaymentStatus(this.paymentStatus);
            order.setOrderAmount(this.orderAmount);
            order.setBillingAddress(this.billingAddress);
            order.setBillingPhone(this.billingPhone);
            order.setBillingName(this.billingName);
            order.setOrderedDate(this.orderedDate);
            order.setDeliveredDate(this.deliveredDate);
            order.setUser(this.user);
            order.setOrderItems(this.orderItems);
            return order;
        }
    }
}
