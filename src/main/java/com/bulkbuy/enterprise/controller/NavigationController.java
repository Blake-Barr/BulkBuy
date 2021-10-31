package com.bulkbuy.enterprise.controller;
import com.bulkbuy.enterprise.dto.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {

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

    @PostMapping(value="/saveOrder")
    public String saveOrder(@ModelAttribute("order") Order order, Model model) {
        Order newOrder = null;
        return "index";
    }

    @RequestMapping("/orderLookup")
    public String orderLookup(){
        return "orderLookup";
    }

}
