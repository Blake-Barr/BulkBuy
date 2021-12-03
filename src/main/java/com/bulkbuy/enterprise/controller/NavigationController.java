package com.bulkbuy.enterprise.controller;
import com.bulkbuy.enterprise.dto.Bulk_Order;
import com.bulkbuy.enterprise.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @return Index Page
     */

    @GetMapping("/index")
    public String getIndex(Model model){
        log.debug("Index endpoint reached");
        model.addAttribute("activePage", "index");
        return "index";
    }

    /**
     * About endpoint
     * @return About page
     */
    @GetMapping("/about")
    public String getAbout(Model model){
        log.debug("About endpoint reached");
        model.addAttribute("activePage", "about");
        return "about";
    }

    /**
     * Place Order endpoint for creating orders
     * @return Place Order page
     */
    @GetMapping("/placeOrder")
    public String getPlaceOrder(Model model){
        log.debug("Place order endpoint reached");
        Bulk_Order order = new Bulk_Order();
        model.addAttribute("activePage", "placeOrder");
        model.addAttribute(order);
        return "placeOrder";
    }

    /**
     * Lookup endpoint for entering ID to search
     * @return Lookup page
     */
    @GetMapping("/orderLookup")
    public String getOrderLookup(Model model) {
        log.debug("Order lookup endpoint reached");
        return "orderLookup";
    }

    /**
     * Save new order endpoint
     * @param order Order to be saved
     * @return Index Page
     * @throws Exception
     */
    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public String saveOrder(@ModelAttribute("order") Bulk_Order order, BindingResult result, ModelMap model) throws Exception {

        log.debug("Save order endpoint reached");

        try {
            if(result.hasErrors())
            {
                throw new Exception("Form returned with error");
            }
            orderService.create(order);
            log.info("New order created successfully");
        }
        catch (Exception ex)
        {
            log.error("failed to save order", ex);
            throw ex;
        }

        return "index";
    }

     /**
     * Endpoint for looking specified order up
     * @param id Order ID to look up
     * @return Order details page
     */
    @PostMapping("/orderDetails")
    public ModelAndView orderDetails(@RequestParam(value="lookupId", required = true, defaultValue = "0") int id) {
        log.debug("Specific order lookup endpoint reached. ID= " + id );
        ModelAndView modelAndView = new ModelAndView();
        try {

            modelAndView.setViewName("orderDetails");
            Bulk_Order order= orderService.findByOrderId(id);
            modelAndView.addObject("order",order);
        }
        catch (Exception ex){
            log.error("failed to load order with specified ID", ex);
            throw ex;
        }
        return modelAndView;
    }

}
