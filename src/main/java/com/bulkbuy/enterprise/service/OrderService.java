package com.bulkbuy.enterprise.service;

import com.bulkbuy.enterprise.dao.IOrderDAO;
import com.bulkbuy.enterprise.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that handles business logic for Order DTOs
 */
@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderDAO orderDAO;

    private ArrayList<Order> orders = new ArrayList<>();

    /**
     * Creates an order and inserts it into the orders List
     * @param order The order to be created
     */
    @Override
    public void Create(Order order) {

        orderDAO.create(order);

    }

    /**
     * Finds an order by its orderId attribute in the orders List
     * @param id the id to look for
     * @return the order with the specified id. If the order does not exist, returns null.
     */
    @Override
    public Order findByOrderId(int id) {

        for (Order ord: orderDAO.listAll()
             ) {
            if(ord.getOrderId() == id)  {
                return ord;
            }
        }
        return null;
    }

    /**
     * Returns all orders in the orders List
     * @return the orders List
     */
    @Override
    public List<Order> getAllOrders() {
        return orderDAO.listAll();
    }
}
