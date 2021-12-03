package com.bulkbuy.enterprise.dto;

import lombok.Data;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * DTO, handles data for orders.
 */
@Entity
public @Data class Bulk_Order {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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