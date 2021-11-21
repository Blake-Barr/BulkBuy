package com.bulkbuy.enterprise.controller;
import com.bulkbuy.enterprise.dto.Order;
import com.bulkbuy.enterprise.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NavigationController {

    Logger log = LoggerFactory.getLogger((this.getClass()));
    IOrderService orderService;

    /**
     * Endpoint control handler
     * @return
     */

    @GetMapping("/index")
    public String getIndex(Model model){
        log.debug("Index endpoint reached");
        model.addAttribute("activePage", "index");
        return "index";
    }

    @GetMapping("/about")
    public String getAbout(Model model){
        log.debug("About endpoint reached");
        model.addAttribute("activePage", "about");
        return "about";
    }

    @GetMapping("/placeOrder")
    public String getPlaceOrder(Model model){
        log.debug("Place order endpoint reached");
        Order order = new Order();
        model.addAttribute("activePage", "placeOrder");
        model.addAttribute(order);
        return "placeOrder";
    }

    @GetMapping("/orderLookup")
    public String getOrderLookup(Model model){
        log.debug("Order lookup endpoint reached");
        model.addAttribute("activePage", "orderLookup");
        return "orderLookup";
    }

    @PostMapping(value="/saveOrder", consumes = "application/json", produces = "application/json")
    public Order saveOrder(@RequestBody Order order) throws Exception {
        log.debug("Save order endpoint reached");
        Order newOrder = null;
        try {
            newOrder = orderService.create(order);
            log.info("New order created successfully");
        }
        catch (Exception ex)
        {
            log.error("failed to save order", ex);
            throw ex;
        }

        return newOrder;
    }

    @RequestMapping("/orderLookup")
    public String orderLookup(){
        return "orderLookup";
    }

}
