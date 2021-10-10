package com.bulkbuy.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BulkBuyController {

    /**
     * @aurthor
     * Endpoint control handler
     *
     * @return start
     */
    @RequestMapping("/")
    public String index() {
        return "start";
    }

    /**
     *
     * @return newOrder
     */
    @RequestMapping("/newOrder")
    public String newOrder(){
        return "newOrder";
    }

    /**
     *
     * @return orderLookup
     */
    @RequestMapping("/orderLookup")
    public String orderLookup(){
        return "orderLookup";
    }

}
