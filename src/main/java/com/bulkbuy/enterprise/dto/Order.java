package com.bulkbuy.enterprise.dto;

import lombok.Data;
import java.util.Date;

/**
 * DTO, handles data for orders.
 */
public @Data class Order {

    private int orderId;
    private int productQuantity;
    private String productDescription;
    private Date orderDate;
    private Date estimatedArrival;
    private String carrier;
    private String orderStatus;

    private int itemID;
    private int customerId;
    private String customerFirstname;
    private String customerLastname;;
    private String customerStreet;
    private String customerCity;
    private String customerState;
    private String customerZip;


}
