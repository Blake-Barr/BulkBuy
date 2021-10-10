package com.bulkbuy.enterprise;

import com.bulkbuy.enterprise.dto.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class BulkBuyController {

    /**
     * Endpoint control handler
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "start";
    }

    /**
     * Endpoint handler for /newOrder
     * @return the page newOrder.html
     */
    @RequestMapping("/newOrder")
    public String newOrder(Model model){
        Order order = new Order();
        model.addAttribute(order);
        return "newOrder";
    }

    /**
     * Endpoint handler for /orderLookup
     * @return the page orderLookup.html
     */
    @RequestMapping("/orderLookup")
    public String orderLookup(Model model){
        Order order = new Order();
        model.addAttribute(order);
        return "orderLookup";
    }

    @RequestMapping("/saveOrder")
    public String saveOrder(Order newOrder){
        Date today = new Date();
        newOrder.setOrderDate(today);
        newOrder.setOrderStatus("Pending");
        newOrder.setCarrier("TBD");
        return "newOrder";
    }

}
