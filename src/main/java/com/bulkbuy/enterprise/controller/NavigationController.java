package com.bulkbuy.enterprise.controller;
import com.bulkbuy.enterprise.dto.Order;
import com.bulkbuy.enterprise.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {

    Logger log = LoggerFactory.getLogger((this.getClass()));
    @Autowired
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


    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public String saveOrder(@ModelAttribute("order") Order order, BindingResult result, ModelMap model) throws Exception {

        log.debug("Save order endpoint reached");
        try {
            if(result.hasErrors())
            {
                throw new Exception("Form returned with error");
            }
            var newOrder = orderService.create(order);
            log.info("New order created successfully");
        }
        catch (Exception ex)
        {
            log.error("failed to save order", ex);
            throw ex;
        }

        return "index";
    }

    @RequestMapping("/orderLookup")
    public ModelAndView orderLookup() {
        ModelAndView modelAndView = new ModelAndView();

        try {
            Iterable<Order> allOrders = orderService.getAllOrders();
            modelAndView.setViewName("orderLookup");
            modelAndView.addObject("allOrders", allOrders);
        } catch (Exception ex) {
            log.error("Error when trying to retrieve orders", ex);
        }
        return modelAndView;
    }

}
