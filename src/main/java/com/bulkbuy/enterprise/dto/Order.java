package com.bulkbuy.enterprise.dto;

import lombok.Data;
import java.util.Date;

/**
 * DTO, handles data for orders.
 */
public @Data class Order {

    private int orderId;
    private int quantity;
    private String productDescription;
    private Date orderDate;
    private Date estimatedArrival;
    private String carrier;
    private String orderStatus;

    private int itemID;
    private String customerName;
    private String customerAddress;

}
