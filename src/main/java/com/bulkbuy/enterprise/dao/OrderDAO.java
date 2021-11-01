package com.bulkbuy.enterprise.dao;

import com.bulkbuy.enterprise.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public List<Order> getAllOrders()   {return null;}

    @Override
    public Order findByOrderId(int id)    {return null;}

}
