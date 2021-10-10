package com.bulkbuy.enterprise.dao;

import com.bulkbuy.enterprise.dto.Order;

import java.util.List;

public interface IOrderDAO {
    void create(Order order);

    List<Order> listAll();
}
