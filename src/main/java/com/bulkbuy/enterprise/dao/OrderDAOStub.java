package com.bulkbuy.enterprise.dao;

import com.bulkbuy.enterprise.dto.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDAOStub implements IOrderDAO{

    private Map<Integer,Order> allOrders = new HashMap<>();

    @Override
    public Order create(Order order)  {
        if(order.getOrderId() <= 0){
            List<Order> allOrderList = new ArrayList(allOrders.values());
            int lastOrderId = 0;
            for(int i = 0; i < allOrderList.size(); i++){
                int indexOrderId = allOrderList.get(i).getOrderId();
                if(indexOrderId > lastOrderId){
                    lastOrderId = indexOrderId;
                }
            }
            int tempOrderId = lastOrderId + 1;
            order.setOrderId(tempOrderId);
        }
        allOrders.put(order.getOrderId(), order);
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> returnOrders = new ArrayList<Order>(allOrders.values());
        return returnOrders;
    }

    @Override
    public Order findByOrderId(int id)  {
        return allOrders.get(id);
    }

}
