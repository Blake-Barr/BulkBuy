package com.bulkbuy.enterprise.dao;

import com.bulkbuy.enterprise.dto.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDAOStub implements IOrderDAO{

    private List<Order> allOrders = new ArrayList<Order>();

    @Override
    public Order create(Order order)  {
        allOrders.add(order);
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        return allOrders;
    }

    @Override
    public Order findByOrderId(int id)  {
        for (Order ord: getAllOrders()) {
            if (ord.getOrderId() == id) {
                return ord;
            }
        }
        //Maybe throw an exception?
        return null;
    }
}
