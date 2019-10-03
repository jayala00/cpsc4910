package com.cpsc4910.cpscbackend.Order;

import com.cpsc4910.cpscbackend.Service.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Order;
import javax.validation.Valid;

@RestController
@RequestMapping(path="/order")
public class OrderController {

    private final OrderServiceImp orderService;

    @Autowired
    public OrderController(OrderServiceImp orderService) {this.orderService = orderService; }

    @PostMapping(path = "/addOrder")
    public ResponseEntity<?> addNewOrder (@Valid @RequestBody DriverOrder request) {
        String response = orderService.addOrder(request.getId(), request.getOrderid(), request.getStatus());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/allOrders")
    public ResponseEntity<?> getAllOrders (@Valid @RequestBody DriverOrder request) {
        Iterable<DriverOrder> response = orderService.allOrders();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
