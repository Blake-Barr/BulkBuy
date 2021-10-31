package com.bulkbuy.enterprise;

import com.bulkbuy.enterprise.dto.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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

    @GetMapping("/newOrder")
    public String newOrder(Model model){
        model.addAttribute("order", new Order());
        return "newOrder";
    }

    @PostMapping(value="/saveOrder")
    public String saveOrder(@ModelAttribute("order") Order order, Model model) {
        Order newOrder = null;
        return "start";
    }

    @RequestMapping("/orderLookup")
    public String orderLookup(){
        return "orderLookup";
    }


}
