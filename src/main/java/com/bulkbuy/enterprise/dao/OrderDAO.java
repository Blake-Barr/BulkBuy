package com.bulkbuy.enterprise.dao;

import com.bulkbuy.enterprise.dto.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDAO implements IOrderDAO{
    List<Order> allOrders = new ArrayList<>();

    @Override
    public void create(Order order) {
        try {
            allOrders.add(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> listAll() {
        return allOrders;
    }
}
