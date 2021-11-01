package com.bulkbuy.enterprise.dao;

import com.bulkbuy.enterprise.dto.Order;

import java.util.List;


public interface IOrderDAO {
    Order create(Order order);

    List<Order> getAllOrders();


    Order findByOrderId(int id);
}
