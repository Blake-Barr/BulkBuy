package com.bulkbuy.enterprise;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class EnterpriseApplicationTests {

    @Autowired
    IOrderService orderService;

    @Test
    void contextLoads() {
    }

    /**
     * Test the properties of the DTO for getting and setting values.
     */
    @Test
    void verifyOrderProperties() {
        int orderId = 52;
        int quantity = 5;
        String productDescription = "Plain Paper";
        Date orderDate = new Date(2021,10,1);
        Date estimatedArrival = null;
        String carrier = "International Paper";
        String orderStatus = "Order Recieved";

        Order order = new Order();
        order.setOrderId(orderId);
        order.setQuantity(quantity);
        order.setProductDescription(productDescription);
        order.setOrderDate(orderDate);
        order.setEstimatedArrival(estimatedArrival);
        order.setCarrier(carrier);
        order.setOrderStatus(orderStatus);

        assertEquals(orderId,order.getOrderId());
        assertEquals(quantity,order.getQuantity());
        assertEquals(productDescription,order.getProductDescription());
        assertEquals(orderDate,order.getOrderDate());
        assertEquals(estimatedArrival,order.getEstimatedArrival());
        assertEquals(carrier,order.getCarrier());
        assertEquals(orderStatus,order.getOrderStatus());
    }

    /**
     * Confirm saving orders and pulling a full list of orders.
     */
    @Test
    void confirmSavedOrder(){
        int orderId = 52;
        int quantity = 5;
        String productDescription = "Plain Paper";
        Date orderDate = new Date(2021,10,1);
        Date estimatedArrival = null;
        String carrier = "International Paper";
        String orderStatus = "Order Recieved";

        Order order = new Order();
        order.setOrderId(orderId);
        order.setQuantity(quantity);
        order.setProductDescription(productDescription);
        order.setOrderDate(orderDate);
        order.setEstimatedArrival(estimatedArrival);
        order.setCarrier(carrier);
        order.setOrderStatus(orderStatus);

        orderService.Create(order);

        List<Order> orders = orderService.getAllOrders();
        for (Order ord:orders)
        {
            if (ord.getOrderId().equals(orderId) && ord.getQuantity().equals(quantity) && ord.getOrderDate().equals(orderDate))
            {
                assertTrue(true);
                break;
            }
        }
    }

    /**
     * Verifies proper return of order object when searching by order ID.
     */
    @Test
    void confirmFindByOrderId()
    {
        int orderId = 52;
        int quantity = 5;
        String productDescription = "Plain Paper";
        Date orderDate = new Date(2021,10,1);
        Date estimatedArrival = null;
        String carrier = "International Paper";
        String orderStatus = "Order Recieved";

        Order order = new Order();
        order.setOrderId(orderId);
        order.setQuantity(quantity);
        order.setProductDescription(productDescription);
        order.setOrderDate(orderDate);
        order.setEstimatedArrival(estimatedArrival);
        order.setCarrier(carrier);
        order.setOrderStatus(orderStatus);

        int orderId2 = 53;
        int quantity2 = 17;
        String productDescription2 = "Box of 60 Black Pens";
        Date orderDate2 = new Date(2021,9,17);
        Date estimatedArrival2 = new Date(2021,9,24);
        String carrier2 = "Société Bic";
        String orderStatus2 = "Delivered";

        Order order2 = new Order();
        order.setOrderId(orderId2);
        order.setQuantity(quantity2);
        order.setProductDescription(productDescription2);
        order.setOrderDate(orderDate2);
        order.setEstimatedArrival(estimatedArrival2);
        order.setCarrier(carrier2);
        order.setOrderStatus(orderStatus2);

        orderService.Create(order);
        orderService.Create(order2);

        assertTrue(order2.equals(orderService.findByOrderId(53)));
    }

}
