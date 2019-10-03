package com.cpsc4910.cpscbackend.Service;

import com.cpsc4910.cpscbackend.Order.DriverOrder;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    String addOrder(long id, long orderNumber, String status);

    Iterable<DriverOrder> allOrders();
}
