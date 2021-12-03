package com.bulkbuy.enterprise.dao;

import com.bulkbuy.enterprise.dto.Bulk_Order;

import java.util.List;


public interface IOrderDAO {
    Bulk_Order create(Bulk_Order order);

    List<Bulk_Order> getAllOrders();

    Bulk_Order findByOrderId(int id);

}
