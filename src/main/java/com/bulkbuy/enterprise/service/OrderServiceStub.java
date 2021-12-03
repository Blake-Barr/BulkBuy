package com.bulkbuy.enterprise.service;

import com.bulkbuy.enterprise.dao.IOrderDAO;
import com.bulkbuy.enterprise.dao.OrderDAO;
import com.bulkbuy.enterprise.dto.Bulk_Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Class that handles business logic for Order DTOs
 */
@Service
public class OrderServiceStub implements IOrderService {

    @Autowired
    private IOrderDAO orderDAO;


    public OrderServiceStub() {

    }

    public OrderServiceStub(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    /**
     * Creates an order and inserts it into the orders List
     * @param order The order to be created
     */
    @Override
    public Bulk_Order create(Bulk_Order order)  {
        Bulk_Order newOrder = orderDAO.create(order);
        return newOrder;
    }

    /**
     * Finds an order by its orderId attribute in the orders List
     * @param id the id to look for
     * @return the order with the specified id. If the order does not exist, returns null.
     */
    @Override
    public Bulk_Order findByOrderId(int id) {
        return orderDAO.findByOrderId(id);
    }

    /**
     * Returns all orders in the orders List
     * @return the orders List
     */
    @Override
    public List<Bulk_Order> getAllOrders() {

        return orderDAO.getAllOrders();
    }

    @Override
    public void setOrderDAO(IOrderDAO orderDAO) {
        this.orderDAO=orderDAO;
    }

    @Override
    public IOrderDAO getOrderDAO() {
        return orderDAO;
    }
}
