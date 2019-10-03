package com.cpsc4910.cpscbackend.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping(path="/addorder")
    public @ResponseBody String newOrder(@RequestParam long id, @RequestParam String status){

        DriverOrder o = new DriverOrder();
        o.setOrderid(id);
        o.setStatus(status);
        orderRepository.save(o);

        return "SAVED";
    }

    @GetMapping(path="/allorders")
    public @ResponseBody Iterable<DriverOrder> getAllOrders() {
        return orderRepository.findAll();
    }
}
