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
        int tempOrderId = allOrders.size() + 1;
        order.setOrderId(tempOrderId);
        allOrders.put(order.getOrderId(), order);
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> returnOrders = new ArrayList<Order>(allOrders.values());
        return returnOrders;
    }

    @Override
    public Order findByOrderId(int id)  {
        return allOrders.get(id);
    }

}
