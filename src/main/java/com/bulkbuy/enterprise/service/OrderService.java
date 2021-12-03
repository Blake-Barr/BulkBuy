package com.bulkbuy.enterprise.service;

import com.bulkbuy.enterprise.dao.IOrderDAO;
import com.bulkbuy.enterprise.dao.OrderDAO;
import com.bulkbuy.enterprise.dto.Bulk_Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService{

    @Autowired
    private IOrderDAO orderDAO;

    /**
     * Create an order
     * @param order The order to be created
     * @return Order created
     * @throws Exception
     */
    @Override
    public Bulk_Order create(Bulk_Order order) throws Exception {
        return orderDAO.create(order);
    }

    /**
     * Search for specific order by ID
     * @param id the id to look for
     * @return order with specified ID
     */
    @Override
    public Bulk_Order findByOrderId(int id) {
        Bulk_Order foundOrder = orderDAO.findByOrderId(id);
        return foundOrder;
    }

    /**
     * Retrieve all orders
     * @return List of all orders
     */
    @Override
    @Cacheable("orders")
    public List<Bulk_Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    public void setOrderDAO(IOrderDAO orderDAO) {    }

    /**
     * Retrieve DAO in use
     * @return IOrderDAO in use
     */
    @Override
    public IOrderDAO getOrderDAO() {
        return orderDAO;
    }
}
