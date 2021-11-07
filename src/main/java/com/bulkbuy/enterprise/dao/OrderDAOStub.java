package com.bulkbuy.enterprise.dao;

import com.bulkbuy.enterprise.dto.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDAOStub implements IOrderDAO{

    private Map<Integer,Order> allOrders = new HashMap<>();

    @Override
    public Order create(Order order)  {
        allOrders.put(order.getOrderId(),order);
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<Order>(allOrders.values());
    }

    @Override
    public Order findByOrderId(int id)  {
        return allOrders.get(id);
    }

}
