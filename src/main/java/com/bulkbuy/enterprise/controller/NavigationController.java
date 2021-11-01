package com.bulkbuy.enterprise.controller;
import com.bulkbuy.enterprise.dto.Order;
import com.bulkbuy.enterprise.service.IOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NavigationController {

    IOrderService orderService;

    /**
     * Endpoint control handler
     * @return
     */

    @GetMapping("/index")
    public String getIndex(Model model){
        model.addAttribute("activePage", "index");
        return "index";
    }

    @GetMapping("/about")
    public String getAbout(Model model){
        model.addAttribute("activePage", "about");
        return "about";
    }

    @GetMapping("/placeOrder")
    public String getPlaceOrder(Model model){
        model.addAttribute("activePage", "placeOrder");
        return "placeOrder";
    }

    @GetMapping("/orderLookup")
    public String getOrderLookup(Model model){
        model.addAttribute("activePage", "orderLookup");
        return "orderLookup";
    }

    @PostMapping(value="/saveOrder", consumes = "application/json", produces = "application/json")
    public Order saveOrder(@RequestBody Order order) throws Exception {
        Order newOrder = null;
        try {
            newOrder = orderService.create(order);
        }
        catch (Exception ex)
        {
            //TODO: LOGGING/Exception handling
            throw ex;
        }

        return newOrder;
    }

    @RequestMapping("/orderLookup")
    public String orderLookup(){
        return "orderLookup";
    }

}
