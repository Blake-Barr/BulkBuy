package com.bulkbuy.enterprise.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * DTO, handles data for orders.
 */
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "productDescription")
    private String productDescription;
    @Column(name = "orderDate")
    private Date orderDate;
    @Column(name = "estimatedArrival")
    private Date estimatedArrival;
    @Column(name = "carrier")
    private String carrier;
    @Column(name = "orderStatus")
    private String orderStatus;
    @Column(name = "itemID")
    private int itemID;
    @Column(name = "customer")
    private String customer;
    @Column(name = "customerAddress")
    private String customerAddress;

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public Date getEstimatedArrival() {
        return estimatedArrival;
    }
    public void setEstimatedArrival(Date estimatedArrival) {
        this.estimatedArrival = estimatedArrival;
    }
    public String getCarrier() {
        return carrier;
    }
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public int getItemID() {
        return itemID;
    }
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

}
