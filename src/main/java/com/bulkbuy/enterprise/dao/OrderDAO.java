package com.bulkbuy.enterprise.dao;

import com.bulkbuy.enterprise.dto.Order;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/***
 * Handles business logic for order Data
 */
@Repository
@Profile("TBA")
public class OrderDAO implements IOrderDAO {

    OrderRepository orderRepository;

    /***
     * Creates an order to put into the database
     * @param order the order to create
     * @return the created order
     */
    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    /***
     * Gets all orders in the database
     * @return a list containing all orders
     */
    @Override
    public List<Order> getAllOrders()   {
        List<Order> allOrders = new ArrayList<>();
        Iterable<Order> orders = orderRepository.findAll();

        for(Order order : orders)   {
            allOrders.add(order);
        }
        return allOrders;
    }

    /***
     * Finds an order in the database by the given id
     * @param id the id to lookup
     * @return the order with the specified id
     */
    @Override
    public Order findByOrderId(int id)    {
        return orderRepository.findById(id).get();
    }

}
