package com.bulkbuy.enterprise.service;

import com.bulkbuy.enterprise.dao.IOrderDAO;
import com.bulkbuy.enterprise.dao.OrderDAO;
import com.bulkbuy.enterprise.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Class that handles business logic for Order DTOs
 */
@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderDAO order;
    public OrderService(IOrderDAO order) {
        this.order = order;
    }
    public OrderService() {

    }
    /**
     * Creates an order and inserts it into the orders List
     * @param order The order to be created
     */
    @Override
    public void Create(Order order) {
        this.order.save(order);
    }

    /**
     * Finds an order by its orderId attribute in the orders List
     * @param orderId the id to look for
     * @return the order with the specified id. If the order does not exist, returns null.
     */
    @Override
    public Order findByOrderId(int orderId) {

        Optional< Order > optional = order.findById(orderId);
        Order order;
        if (optional.isPresent()) {
            order = optional.get();
        } else {
            throw new RuntimeException(" Order not found for id :: " + orderId);
        }
        return order;
    }

    /**
     * Returns all orders in the orders List
     * @return the orders List
     */
    @Override
    public List<Order> getAllOrders() {
        return (List<Order>) order.findAll();
    }
}
