package com.bulkbuy.enterprise.controller;
import com.bulkbuy.enterprise.dto.Order;
import com.bulkbuy.enterprise.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NavigationController {

    @Autowired
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
        model.addAttribute("saveOrder", new Order());
        return "placeOrder";
    }

    @GetMapping("/orderLookup")
    public String getOrderLookup(Model model){
        model.addAttribute("activePage", "orderLookup");
        return "orderLookup";
    }

    @PostMapping(value="/saveOrder")
    public String saveOrder(@ModelAttribute("saveOrder") Order savedOrder, Model model) {
        Order newOrder = null;
        try {
            newOrder = orderService.create(savedOrder);
        }
        catch (Exception ex)
        {
            //TODO: LOGGING/Exception handling
            throw ex;
        }
        return "index";
    }

    @RequestMapping("/orderLookup")
    public String orderLookup(){
        return "orderLookup";
    }

}
