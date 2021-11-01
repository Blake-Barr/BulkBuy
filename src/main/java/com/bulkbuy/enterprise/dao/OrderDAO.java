package com.bulkbuy.enterprise.dao;

import com.bulkbuy.enterprise.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDAO implements IOrderDAO {

    OrderRepository orderRepository;

    @Override
    public Order create(Order order) {
        Order created = orderRepository.save(order);
        return created;
    }

    @Override
    public List<Order> getAllOrders()   {
        List<Order> allOrders = new ArrayList<>();
        Iterable<Order> orders = orderRepository.findAll();

        for(Order order : orders)   {
            allOrders.add(order);
        }
        return allOrders;
    }

    @Override
    public Order findByOrderId(int id)    {
        return orderRepository.findById(id).get();
    }

}
