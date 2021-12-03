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

    public OrderService() {

    }

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public Bulk_Order create(Bulk_Order order) throws Exception {
        return orderDAO.create(order);
    }

    @Override
    @Cacheable(value="order", key="#id")
    public Bulk_Order findByOrderId(int id) {
        Bulk_Order foundOrder = orderDAO.findByOrderId(id);
        return foundOrder;
    }

    @Override
    @Cacheable("orders")
    public List<Bulk_Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    public void setOrderDAO(IOrderDAO orderDAO) {

    }

    @Override
    public IOrderDAO getOrderDAO() {
        return null;
    }
}
