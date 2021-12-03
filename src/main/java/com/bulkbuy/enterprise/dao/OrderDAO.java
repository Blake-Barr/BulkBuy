package com.bulkbuy.enterprise.dao;

import com.bulkbuy.enterprise.dto.Bulk_Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Calendar;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * Handles business logic for order Data
 */
@Repository("orderDAO")
public class OrderDAO implements IOrderDAO {

    @Autowired
    OrderRepository orderRepository;

    /***
     * Creates an order to put into the database
     * @param order the order to create
     * @return the created order
     */
    @Override
    public Bulk_Order create(Bulk_Order order) {
        Date orderDate = new Date();
        order.setOrderDate(orderDate);

        Calendar c = Calendar.getInstance();
        c.setTime(orderDate);
        c.add(Calendar.DAY_OF_MONTH, 5);

        Date arrivalDate = c.getTime();
        order.setEstimatedArrival(arrivalDate);

        order.setOrderStatus("Received Order");

        Bulk_Order created = orderRepository.save(order);
        return created;
    }

    /***
     * Gets all orders in the database
     * @return a list containing all orders
     */
    @Override
    public List<Bulk_Order> getAllOrders()   {
        List<Bulk_Order> allOrders = new ArrayList<>();
        Iterable<Bulk_Order> orders = orderRepository.findAll();

        for(Bulk_Order order : orders)   {
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
    public Bulk_Order findByOrderId(int id)    {
        return orderRepository.findById(id).get();
    }

}
