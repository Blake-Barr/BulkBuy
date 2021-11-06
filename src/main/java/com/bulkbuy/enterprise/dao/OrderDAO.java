package com.bulkbuy.enterprise.dao;

import com.bulkbuy.enterprise.dto.Order;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("TBA")
public class OrderDAO implements IOrderDAO {

    OrderRepository orderRepository;

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
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
