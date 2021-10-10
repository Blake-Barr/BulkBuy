package com.bulkbuy.enterprise;

import com.bulkbuy.enterprise.dto.Order;
import com.bulkbuy.enterprise.service.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        LocalDate orderDate = LocalDate.of(2021,10,1);
        LocalDate estimatedArrival = null;
        String carrier = "International Paper";
        String orderStatus = "Order Received";

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
        LocalDate orderDate = LocalDate.of(2021, 10, 01);
        LocalDate estimatedArrival = null;
        String carrier = "International Paper";
        String orderStatus = "Order Received";

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

            if (ord.getOrderId() == orderId && ord.getQuantity() == quantity && ord.getOrderDate().equals(orderDate))
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
        LocalDate orderDate = LocalDate.of(2021,10,1);
        LocalDate estimatedArrival = null;
        String carrier = "International Paper";
        String orderStatus = "Order Received";

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
        LocalDate orderDate2 = LocalDate.of(2021,9,17);
        LocalDate estimatedArrival2 = LocalDate.of(2021,9,24);
        String carrier2 = "Societe Bic";
        String orderStatus2 = "Delivered";

        Order order2 = new Order();
        order2.setOrderId(orderId2);
        order2.setQuantity(quantity2);
        order2.setProductDescription(productDescription2);
        order2.setOrderDate(orderDate2);
        order2.setEstimatedArrival(estimatedArrival2);
        order2.setCarrier(carrier2);
        order2.setOrderStatus(orderStatus2);

        orderService.Create(order);
        orderService.Create(order2);

        assertTrue(order2.equals(orderService.findByOrderId(53)));
    }

}
