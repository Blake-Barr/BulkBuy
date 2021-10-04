package com.bulkbuy.enterprise.controller;

import com.bulkbuy.enterprise.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BulkBuyController {
    @Autowired
    public OrderService orderService;
    /**
     * Endpoint control handler
     * @return directory
     */
    @RequestMapping("/")
    public String index() {
        return "start";
    }

    @RequestMapping("/newOrder")
    public String newOrder(){
        return "newOrder";
    }

    @RequestMapping("/orderLookup")
    public String orderLookup(){
        return "orderLookup";
    }

}
