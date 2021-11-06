package com.bulkbuy.enterprise.dto;


import lombok.Data;

public @Data
class Customer {
    private int customerId;
    private String customerName;
    private String customerAddress;
}
